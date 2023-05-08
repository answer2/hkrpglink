package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:22
 */
public class ListUrl {
    
    private final String uid;
    private final String url;
    
    public ListUrl(String str, String str2) {
        this.uid = str;
        this.url = str2;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getUrl() {
        return this.url;
    }
    
    
}
