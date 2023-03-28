package com.cdg.chooz.domain.token;

import com.cdg.chooz.domain.common.EnumModel;

public enum TokenType implements EnumModel {
    REFRESH("refresh"),
    ACCESS("access");

    private String value;

    TokenType(String value) {
        this.value = value;
    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getValue() {
        return null;
    }
}
