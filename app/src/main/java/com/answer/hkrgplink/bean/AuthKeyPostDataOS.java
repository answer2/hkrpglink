package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:19
 */
public class AuthKeyPostDataOS {
    
    private final String auth_appid;
    private final int authkey_ver;
    private final String device_type;
    private final String game_biz;
    private final String game_uid;
    private final String game_version;
    private final boolean is_chosen;
    private final boolean is_official;
    private final int level;
    private final String nickname;
    private final String plat_type;
    private final String region;
    private final String region_name;
    private final int sign_type;
    private final String win_mode;
    
    public AuthKeyPostDataOS(String str, String str2, String str3, String str4, int i, boolean z, String str5, boolean z2, String str6, String str7, int i2, int i3, String str8, String str9, String str10) {
        this.game_biz = str;
        this.game_uid = str2;
        this.region = str3;
        this.nickname = str4;
        this.level = i;
        this.is_official = z;
        this.region_name = str5;
        this.is_chosen = z2;
        this.auth_appid = str6;
        this.win_mode = str7;
        this.authkey_ver = i2;
        this.sign_type = i3;
        this.device_type = str8;
        this.plat_type = str9;
        this.game_version = str10;
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

    public final String getNickname() {
        return this.nickname;
    }

    public final int getLevel() {
        return this.level;
    }

    public final boolean is_official() {
        return this.is_official;
    }

    public final String getRegion_name() {
        return this.region_name;
    }

    public final boolean is_chosen() {
        return this.is_chosen;
    }

    public final String getAuth_appid() {
        return this.auth_appid;
    }

    public final String getWin_mode() {
        return this.win_mode;
    }

    public final int getAuthkey_ver() {
        return this.authkey_ver;
    }

    public final int getSign_type() {
        return this.sign_type;
    }

    public final String getDevice_type() {
        return this.device_type;
    }

    public final String getPlat_type() {
        return this.plat_type;
    }

    public final String getGame_version() {
        return this.game_version;
    }
    
}
