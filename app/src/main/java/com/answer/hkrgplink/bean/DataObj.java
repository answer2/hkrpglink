package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:21
 */
public class DataObj {
    
    private final String name;
    private final String token;
    
    
    public DataObj(String str, String str2) {
        this.name = str;
        this.token = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getToken() {
        return this.token;
    }
    
    
}
