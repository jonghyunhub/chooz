package com.cdg.chooz.client.kakao;

import com.cdg.chooz.domain.user.ProviderType;
import com.cdg.chooz.domain.user.ThirdPartyAuthorizer;
import com.cdg.chooz.domain.user.ThirdPartySignupInfo;
import com.cdg.chooz.domain.user.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
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

@Component
public class KakaoAuthorizer implements ThirdPartyAuthorizer {

    @Value("${spring.security.oauth2.client.registration.kakao.client-id:대충 기본 클라이언트아이디}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.kakao.client-secret:대충 시크릿키}")
    private String client_secret;

    @Override
    public String getAccessToken(ThirdPartySignupInfo signupInfo) {
        // 인가코드로 토큰받기
        String host = "https://kauth.kakao.com/oauth/token";

        // https://withseungryu.tistory.com/116 : RestTemplate 참고할 블로그
        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory()); // restTemplate 에러 메세지 확인 설정

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/x-www-form-urlencoded");

        Map<String, String> propertiesValues = signupInfo.getPropertiesValues();

        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("grant_type", "authorization_code");
        param.add("client_id", clientId);
        param.add("redirect_uri", propertiesValues.get("redirectUrl")); //로컬, 개발, 운영 서버 테스트에서 계속 변경할 수 있게 Redirect Url 파라미터로 받아서 적용
        param.add("code", propertiesValues.get("code"));
        param.add("client_secret", client_secret);

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
        String host = "https://kapi.kakao.com/v2/user/me";
        Map<String, String> result = new HashMap<>();

        try {
            URL url = new URL(host);

            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestProperty("Authorization", "Bearer " + accessToken);
            urlConnection.setRequestMethod("GET");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()))){
                String line;
                StringBuilder res = new StringBuilder();
                while((line=br.readLine())!=null)
                {
                    res.append(line);
                }

                JSONParser parser = new JSONParser();
                JSONObject obj = (JSONObject) parser.parse(res.toString());


                JSONObject properties = (JSONObject) obj.get("properties");


                String id = obj.get("id").toString();
                String nickname = properties.get("nickname").toString();
                String profile_image = properties.get("profile_image").toString();

                result.put("id", id);
                result.put("nickname", nickname);
                result.put("profile_image", profile_image);
            }

        } catch (IOException | ParseException e) {
            e.printStackTrace(); // 스탑더월드
        }

        return result;
    }

    @Override
    public ProviderType getProviderType() {
        return ProviderType.KAKAO;
    }

}
