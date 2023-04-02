package com.cdg.chooz.domain.user;

import java.util.Map;
import java.util.Optional;

// 서드파티 제공자의 인증을 처리하는 인터페이스
public interface ThirdPartyAuthorizer {
    String getAccessToken(ThirdPartySignupInfo signupInfo);

    Map<String, String> getUserInfo(String accessToken);

    ProviderType getProviderType();

}
