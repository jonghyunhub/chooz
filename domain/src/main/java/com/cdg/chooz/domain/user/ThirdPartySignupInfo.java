package com.cdg.chooz.domain.user;

import lombok.Getter;

import java.util.Map;

@Getter
public class ThirdPartySignupInfo {
    private ProviderType providerType;
    private Map<String, String> propertiesValues;

    public ThirdPartySignupInfo(ProviderType providerType, Map<String, String> propertiesValues) {
        this.providerType = providerType;
        this.propertiesValues = propertiesValues;
    }
}