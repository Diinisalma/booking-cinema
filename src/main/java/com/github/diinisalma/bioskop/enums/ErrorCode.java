package com.github.diinisalma.bioskop.enums;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ErrorCode {
    INVALID_DATA(1), INTERNAL_ERROR(2), NOT_FOUND(3), BAD_REQUEST(4), UNAUTHORIZED(5), FORBIDDEN(6), CONFLICT(7);

    private int code;
    ErrorCode(int code) {
        this.code = code;
    }

    @JsonValue
    public int code() {
        return code;
    }
}
