package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:26
 */
public class UserService {
    
    private final String game_biz;
    private final String game_uid;
    private final boolean is_chosen;
    private final boolean is_official;
    private final int level;
    private final String nickname;
    private final String region;
    private final String region_name;
    
    public UserService(String str, String str2, boolean z, boolean z2, int i, String str3, String str4, String str5) {
        this.game_biz = str;
        this.game_uid = str2;
        this.is_chosen = z;
        this.is_official = z2;
        this.level = i;
        this.nickname = str3;
        this.region = str4;
        this.region_name = str5;
    }

    public final String getGame_biz() {
        return this.game_biz;
    }

    public final String getGame_uid() {
        return this.game_uid;
    }

    public final boolean is_chosen() {
        return this.is_chosen;
    }

    public final boolean is_official() {
        return this.is_official;
    }

    public final int getLevel() {
        return this.level;
    }

    public final String getNickname() {
        return this.nickname;
    }

    public final String getRegion() {
        return this.region;
    }

    public final String getRegion_name() {
        return this.region_name;
    }
    
}
