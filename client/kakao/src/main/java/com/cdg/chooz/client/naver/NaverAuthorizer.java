package com.cdg.chooz.client.naver;

import com.cdg.chooz.domain.user.ProviderType;
import com.cdg.chooz.domain.user.ThirdPartyAuthorizer;
import com.cdg.chooz.domain.user.ThirdPartySignupInfo;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class NaverAuthorizer implements ThirdPartyAuthorizer {

    @Value("${spring.security.oauth2.client.registration.naver.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.naver.client-secret}")
    private String client_secret;

    @Override
    public String getAccessToken(ThirdPartySignupInfo signupInfo) {
        // 인가코드로 토큰받기
        String host = "https://nid.naver.com/oauth2.0/token";

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // restTemplate 에러 메세지 확인 설정

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> propertiesValues = signupInfo.getPropertiesValues();

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type", "authorization_code");
        param.add("client_id", clientId);
        param.add("client_secret", client_secret);
        param.add("code", propertiesValues.get("code"));
        param.add("state", propertiesValues.get("state"));

        HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<>(param, headers);
        ResponseEntity<String> res = rt.exchange(host,
                HttpMethod.POST,
                req,
                String.class);

        JSONParser jsonParser = new JSONParser();
        JSONObject parse = null;
        try {
            parse = (JSONObject) jsonParser.parse(res.getBody());
        } catch (ParseException e) {
            throw new RuntimeException("파싱 하다 터짐");
        }

        return (String) parse.get("access_token");

    }

    @Override
    public Map<String, String> getUserInfo(String accessToken) {
        String host = "https://openapi.naver.com/v1/nid/me";
        Map<String, String> result = new HashMap<>(); //key, value json 형식으로 데이터 내보내기 위해 hashMap 사용
        try {
            URL url = new URL(host);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            //request header 부분
            urlConnection.setRequestProperty("Authorization", "Bearer " + accessToken);
            urlConnection.setRequestMethod("GET");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
                String line;
                StringBuilder res = new StringBuilder();
                while((line=br.readLine())!=null)
                {
                    res.append(line);
                }
                // int responseCode = urlConnection.getResponseCode();
                // System.out.println(responseCode);

                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(res.toString());

                System.out.println(obj);   // response 부분이 따로 { } 로 되어 있음
                JSONObject response = (JSONObject) obj.get("response");


                String id = response.get("id").toString();
                String nickname = response.get("nickname").toString();
                String profile_image = response.get("profile_image").toString();

                result.put("id",id);
                result.put("nickname", nickname);
                result.put("profile_image", profile_image);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public ProviderType getProviderType() {
        return ProviderType.NAVER;
    }
}
