package com.cdg.chooz.controller.user;

import com.cdg.chooz.controller.common.CommonResponse;
import com.cdg.chooz.controller.user.request.GeneralSignUpRequest;
import com.cdg.chooz.domain.user.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.io.IOException;

/**
 * 회원가입을 담당하는 컨트롤러
 */
@RequestMapping("/api/user")
@RestController
@RequiredArgsConstructor
public class SignupController {

    private final SignupService signupService;


    @PostMapping("/signup")
    public ResponseEntity<CommonResponse> registerUser(@Valid @RequestBody GeneralSignUpRequest request) {
        signupService.signup(request.toDomain());
//        try {
//            userService.registerUser(signUpRequestDto);
//        } catch (Exception e) {
//            CommonResponse response = new CommonResponse("조건을 만족하는 유저가 이미 존재합니다. 다시한번 확인하세요"); // TODO 동일 유저 외에 다른 에러가 발생한 거라면??
//            return new ResponseEntity(response, HttpStatus.CONFLICT);
//        }
        return new ResponseEntity(new CommonResponse("회원가입에 성공했습니다."), HttpStatus.OK);
    }

//    /**
//     * 카카오 서버에서 유저정보 조희
//     *
//     * @param getkakaoToken
//     * @return 엑세스 토큰
//     * @throws IOException
//     * @throws ParseException
//     */
//    @PostMapping("/signup/kakao")
//    public ResponseEntity<GetLoginTokenResponse> getKaKaoToken(@Valid @RequestBody GetkakaoTokenRequest getkakaoToken) throws IOException, ParseException {
//        String code = getkakaoToken.getCode();
//        String redirectUrl = getkakaoToken.getRedirectUrl();
//        GetLoginTokenResponse getLoginToken = kakaoService.KakaoLogin(code, redirectUrl);
//        return new ResponseEntity(getLoginToken, HttpStatus.OK);
//    }

}
