package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:22
 */
public class LoginCookieDataDto {
    
    private final int code;
    private final Data data;
    
    public LoginCookieDataDto(int i, Data data) {
        this.code = i;
        this.data = data;
    }

    public final int getCode() {
        return this.code;
    }

    public final Data getData() {
        return this.data;
    }
    
}
