package com.cdg.chooz.controller.user.request;

import com.cdg.chooz.domain.user.GeneralSignupInfo;
import lombok.Data;

@Data
public class GeneralSignUpRequest {
    private String name;
    private String email;
    private String password;

    public GeneralSignupInfo toDomain() {
        return new GeneralSignupInfo(name, email, password);
    }
}
