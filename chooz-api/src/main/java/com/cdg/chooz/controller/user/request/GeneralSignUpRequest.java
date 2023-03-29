package com.cdg.chooz.controller.user.request;

import com.cdg.chooz.domain.user.SignupInfo;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class GeneralSignUpRequest {
    private String name;
    private String email;
    private String password;

    public SignupInfo toDomain() {
        Map<String, String> propertiesValues = new HashMap<>();
        propertiesValues.put("name", name);
        propertiesValues.put("email", email);
        propertiesValues.put("password", password);
        return new SignupInfo(propertiesValues);
    }
}
