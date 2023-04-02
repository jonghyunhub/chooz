package com.cdg.chooz.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;

    public void signup(GeneralSignupInfo signupInfo) {
        // TODO providerId를 통하지 않고 회원가입을 시도하는 경우는?
//        if (userRepository.existsByProviderId(signupInfo.getProviderId())) {
//            throw new Exception("중복된 유저가 존재합니다.");
//        }

        User user = new User(signupInfo);
        userRepository.register(user);
    }

}
