package com.cdg.chooz.controller.token;

import com.cdg.chooz.controller.token.response.TokenResponse;
import com.cdg.chooz.domain.token.TokenType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/token")
public class TokenController {

    //private final TokenService tokenService;

    @GetMapping("")
    public ResponseEntity<TokenResponse> reissueToken(TokenType tokenType, String refreshToken) {
        /*if(tokenType == TokenType.ACCESS){
            String acessToken = tokenService.refreshAcessToken(refreshToken);
            TokenResponse tokenResponse = new TokenResponse(acessToken, tokenType);
            return new ResponseEntity(tokenResponse,HttpStatus.OK);
        }
        String newRefreshToken = tokenService.updateRefreshToken(refreshToken);
        TokenResponse tokenResponse = new TokenResponse(newRefreshToken, tokenType);
        return new ResponseEntity(tokenResponse ,HttpStatus.OK);*/
        return ResponseEntity.ok().body(null);
    }

}
