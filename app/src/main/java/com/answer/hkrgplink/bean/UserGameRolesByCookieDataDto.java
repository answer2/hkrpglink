package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:25
 */
public class UserGameRolesByCookieDataDto {
    
    private final UserGameRolesByCookieData data;
    private final String message;
    private final int retcode;
    
    public UserGameRolesByCookieDataDto(UserGameRolesByCookieData userGameRolesByCookieData, String str, int i) {
        this.data = userGameRolesByCookieData;
        this.message = str;
        this.retcode = i;
    }

    public final UserGameRolesByCookieData getData() {
        return this.data;
    }

    public final String getMessage() {
        return this.message;
    }

    public final int getRetcode() {
        return this.retcode;
    }
    
    
}
