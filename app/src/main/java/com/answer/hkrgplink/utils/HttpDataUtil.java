package com.answer.hkrgplink.utils;
import java.util.Date;

/**
 * @Author AnswerDev
 * @Date 2023/05/08 22:49
 */
public class HttpDataUtil {
    
    public final String getDs() {
        long time = new Date().getTime() / 1000;
        String str = getStr();
        String md5 = Md5Util.getMD5("salt=ulInCDohgEs557j0VsPDYnQaaz6KJcv5&t=" + time + "&r=" + str);
        return time + ',' + str + ',' + md5;
    }

    private final String getStr() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            str = str + "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678".charAt((int) Math.floor(Math.random() * 48));
        }
        return str;
    }
    
}
