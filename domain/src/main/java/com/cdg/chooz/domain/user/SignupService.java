package com.cdg.chooz.domain.user;

import com.cdg.chooz.domain.token.LoginToken;
import com.cdg.chooz.domain.token.TokenGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRegister userRegister;
    private final ThirdPartyAuthorizerProvider thirdPartyAuthorizerProvider;
    private final TokenGenerator tokenGenerator;

    public void signup(GeneralSignupInfo signupInfo) {
        userRegister.register(signupInfo);
    }

    public LoginToken signupByThirdParty(ThirdPartySignupInfo signupInfo) {
        ThirdPartyAuthorizer authorizer = thirdPartyAuthorizerProvider.get(signupInfo.getProviderType());
        String accessToken = authorizer.getAccessToken(signupInfo);
        Map<String, String> userInfo = authorizer.getUserInfo(accessToken);
        String providerId = userInfo.get("id");

        userRegister.registerIfNeed(providerId, signupInfo.getProviderType());

        LoginToken loginToken = tokenGenerator.generate(providerId);
        return loginToken;
    }
}
