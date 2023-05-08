package com.answer.hkrgplink.bean;
import java.util.List;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:20
 */
public class ChouKaObj {
    
    private final int code;
    private final String msg;
    private final List<ListUrl> urlListObj;
    
    
    public ChouKaObj(int i, String str, List<ListUrl> list) {
        this.code = i;
        this.msg = str;
        this.urlListObj = list;
    }

    public final int getCode() {
        return this.code;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final List<ListUrl> getUrlListObj() {
        return this.urlListObj;
    }
    
    
}
