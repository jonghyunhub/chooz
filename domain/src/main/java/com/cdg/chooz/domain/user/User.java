package com.cdg.chooz.domain.user;

import com.cdg.chooz.domain.vote.GenderType;
import com.cdg.chooz.domain.vote.MbtiType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String name;
    private String email;
    private String password;
    private String providerId;
    private ProviderType provider;
    private RoleType role;
    private Integer age;
    private GenderType gender;
    private MbtiType mbti;

    public User(String name, String email, String password, String providerId) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.providerId = providerId;
    }

    public User(GeneralSignupInfo signupInfo) {
        this.name = signupInfo.getName();
        this.email = signupInfo.getEmail();
        this.password = signupInfo.getPassword();
    }

    public User(String providerId, ProviderType providerType) {
        this.providerId = providerId;
        this.provider = providerType;
    }
}
