package com.cdg.chooz.domain.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 회원을 등록해주는 놈
 */
@Component
@AllArgsConstructor
public class UserRegister {
    private final UserRepository userRepository;

    /**
     * 일반 회원 가입
     * @param signupInfo
     */
    public void register(GeneralSignupInfo signupInfo) {
        if (userRepository.existsByProviderId(signupInfo.getEmail())) {
            throw new IllegalArgumentException("이미 가입된 이메일입니다.");
        }

        User user = new User(signupInfo);
        userRepository.register(user);
    }

    /**
     * 소셜 회원 가입
     *
     * @param providerId
     * @param providerType
     */
    public void registerIfNeed(String providerId, ProviderType providerType) {
        if (userRepository.existsByProviderId(providerId)) {
            return;
        }
        User user = new User(providerId, providerType);
        userRepository.register(user);
    }
}
