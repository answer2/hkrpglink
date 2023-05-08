package com.answer.hkrgplink.bean;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:21
 */
public class Data {
    
    private final AccountInfo account_info;
    private final Object game_ctrl_info;
    private final String msg;
    private final NoticeInfo notice_info;
    private final int status;
    
    public Data(AccountInfo accountInfo, Object obj, String str, NoticeInfo noticeInfo, int i) {
        this.account_info = accountInfo;
        this.game_ctrl_info = obj;
        this.msg = str;
        this.notice_info = noticeInfo;
        this.status = i;
    }

    public final AccountInfo getAccount_info() {
        return this.account_info;
    }

    public final Object getGame_ctrl_info() {
        return this.game_ctrl_info;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final NoticeInfo getNotice_info() {
        return this.notice_info;
    }

    public final int getStatus() {
        return this.status;
    }
    
}
