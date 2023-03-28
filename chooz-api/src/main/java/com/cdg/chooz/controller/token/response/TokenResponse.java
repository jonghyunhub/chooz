package com.cdg.chooz.controller.token.response;

import com.cdg.chooz.domain.token.TokenType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TokenResponse {

    private String token;
    private TokenType tokenType;
}
