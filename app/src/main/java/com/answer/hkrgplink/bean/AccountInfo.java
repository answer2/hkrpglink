package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/08 22:43
 */
public class AccountInfo {
    
    private final int account_id;
    private final int create_time;
    private final String email;
    private final String identity_code;
    private final int is_adult;
    private final int is_email_verify;
    private final String real_name;
    private final String safe_area_code;
    private final int safe_level;
    private final String safe_mobile;
    private final String weblogin_token;

    public AccountInfo(int account_id, int create_time, String email, String identity_code, int i3, int i4, String str3, String str4, int i5, String str5, String str6) {
        this.account_id = account_id;
        this.create_time = create_time;
        this.email = email;
        this.identity_code = identity_code;
        this.is_adult = i3;
        this.is_email_verify = i4;
        this.real_name = str3;
        this.safe_area_code = str4;
        this.safe_level = i5;
        this.safe_mobile = str5;
        this.weblogin_token = str6;
    }

    public final int getAccount_id() {
        return this.account_id;
    }

    public final int getCreate_time() {
        return this.create_time;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getIdentity_code() {
        return this.identity_code;
    }

    public final int is_adult() {
        return this.is_adult;
    }

    public final int is_email_verify() {
        return this.is_email_verify;
    }

    public final String getReal_name() {
        return this.real_name;
    }

    public final String getSafe_area_code() {
        return this.safe_area_code;
    }

    public final int getSafe_level() {
        return this.safe_level;
    }

    public final String getSafe_mobile() {
        return this.safe_mobile;
    }

    public final String getWeblogin_token() {
        return this.weblogin_token;
    }
    
    
}
