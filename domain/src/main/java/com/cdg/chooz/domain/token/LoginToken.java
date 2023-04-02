package com.cdg.chooz.domain.token;

import lombok.Getter;

@Getter
public class LoginToken {
    private String accessToken;
    private String refreshToken;
    private boolean isNewUser;
}
