package com.timegoesby.bbscommon.constant;

public enum CodeEnums {

    SUCCESS(200,"success"),
    FAIL(500,"failed");

    private final int code;
    private final String message;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    CodeEnums(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
