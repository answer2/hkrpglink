package com.answer.hkrgplink.bean;
import java.util.List;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:25
 */
public class UserGameRolesByCookieData {
    
    private final List<UserService> list;
    
    public UserGameRolesByCookieData(List<UserService> list) {
        
        this.list = list;
    }

    public final List<UserService> getList() {
        return this.list;
    }
    
}
