package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:17
 */
public class AuthKeyDataDto {
    
    private final AuthKeyData data;
    private final String message;
    private final int retcode;
    
    public AuthKeyDataDto(AuthKeyData authKeyData, String str, int i) {
        this.data = authKeyData;
        this.message = str;
        this.retcode = i;
    }

    public final AuthKeyData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getRetcode() {
        return this.retcode;
    }
    
}
