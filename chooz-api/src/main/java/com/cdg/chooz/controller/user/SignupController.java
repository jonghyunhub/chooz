package com.cdg.chooz.controller.user;

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
        // 1. 회원가입 요청을 받는다.
        // 2. 이미 가입된 회원인지 확인한다.
        // 3. 가입된 회원이 아니라면 회원가입을 진행한다.

        // 1. 회원가입 요청을 받는다.
        // 2. 카카오 로그인을 통해 토큰을 받아오고 회원가입을 진행한다.
        // 3. 이미 가입된 회원인지 확인한다.
        // 4. 가입된 회원이 아니라면 회원가입을 진행한다.



        // User, UserService
        signupService.signup(request.toDomain());



//        try {
//            userService.registerUser(signUpRequestDto);
//        } catch (Exception e) {
//            CommonResponse response = new CommonResponse("조건을 만족하는 유저가 이미 존재합니다. 다시한번 확인하세요");
//            return new ResponseEntity(response, HttpStatus.CONFLICT);
//        }
//
//        CommonResponse response = new CommonResponse("회원가입에 성공했습니다.");
        return new ResponseEntity(response, HttpStatus.OK);
    }

    /**
     * 카카오 서버에서 유저정보 조희
     *
     * @param getkakaoToken
     * @return 엑세스 토큰
     * @throws IOException
     * @throws ParseException
     */
    @PostMapping("/signup/kakao")
    public ResponseEntity<GetLoginTokenResponse> getKaKaoToken(@Valid @RequestBody GetkakaoTokenRequest getkakaoToken) throws IOException, ParseException {
        String code = getkakaoToken.getCode();
        String redirectUrl = getkakaoToken.getRedirectUrl();
        GetLoginTokenResponse getLoginToken = kakaoService.KakaoLogin(code, redirectUrl);
        return new ResponseEntity(getLoginToken, HttpStatus.OK);
    }

}
