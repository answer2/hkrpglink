package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:24
 */
public class LoginTokenDto {
    
    private final LoginTokenData data;
    private final String message;
    private final int retcode;
    
    public LoginTokenDto(LoginTokenData loginTokenData, String str, int i) {
        this.data = loginTokenData;
        this.message = str;
        this.retcode = i;
    }

    public final LoginTokenData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getRetcode() {
        return this.retcode;
    }
    
}
