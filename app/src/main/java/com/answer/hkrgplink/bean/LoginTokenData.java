package com.answer.hkrgplink.bean;
import java.util.List;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:23
 */
public class LoginTokenData {
    
    private final List<DataObj> list;
    
    public LoginTokenData(List<DataObj> list) {
        this.list = list;
    }

    public final List<DataObj> getList() {
        return this.list;
    }
    
}
