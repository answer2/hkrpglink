package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:18
 */
public class AuthKeyPostData {
    
    private final String auth_appid;
    private final String game_biz;
    private final String game_uid;
    private final String region;
    
    public AuthKeyPostData(String str, String str2, String str3, String str4) {
        this.auth_appid = str;
        this.game_biz = str2;
        this.game_uid = str3;
        this.region = str4;
    }

    public final String getAuth_appid() {
        return this.auth_appid;
    }

    public final String getGame_biz() {
        return this.game_biz;
    }

    public final String getGame_uid() {
        return this.game_uid;
    }

    public final String getRegion() {
        return this.region;
    }
}
