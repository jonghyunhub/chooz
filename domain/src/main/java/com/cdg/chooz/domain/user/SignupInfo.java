package com.cdg.chooz.domain.user;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class SignupInfo {
    private Map<String, String> propertiesValues;

    public SignupInfo(Map<String, String> propertiesValues) {
        this.propertiesValues = new HashMap<>();
    }
}