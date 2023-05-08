package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/08 22:46
 */
public class AuthKeyData {
    
    private final String authkey;
    private final int authkey_ver;
    private final int sign_type;
    
    public AuthKeyData(String str, int i, int i2) {
        this.authkey = str;
        this.authkey_ver = i;
        this.sign_type = i2;
    }

    public final String getAuthkey() {
        return this.authkey;
    }

    public final int getAuthkey_ver() {
        return this.authkey_ver;
    }

    public final int getSign_type() {
        return this.sign_type;
    }
    
}
