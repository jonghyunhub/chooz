package com.cdg.chooz.controller.user.response;

import com.cdg.chooz.domain.token.LoginToken;
import lombok.*;

@Data
public class GetLoginTokenResponse {
    private String accessToken;
    private String refreshToken;
    private boolean isNewUser;

    public GetLoginTokenResponse(LoginToken loginToken) {
        this.accessToken = loginToken.getAccessToken();
        this.refreshToken = loginToken.getRefreshToken();
        this.isNewUser = loginToken.isNewUser();
    }
}
