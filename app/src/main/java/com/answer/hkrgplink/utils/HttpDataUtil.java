package com.answer.hkrgplink.utils;
import java.util.Date;
import android.os.Build;

/**
 * @Author AnswerDev
 * @Date 2023/05/08 22:49
 */
public class HttpDataUtil {
    
    public static String getDs() {
        String salt = "ulInCDohgEs557j0VsPDYnQaaz6KJcv5";
        long time = Math.round(new Date().getTime() / 1000);
        String str = getStr();
        String key = "salt=" + salt + "&t=" + time + "&r=" + str;
        String md5 = Md5Util.getMD5(key);

        return time+"," + str + "," + md5;
    }
    
    
    
    public static String getStr() {
        String chars = "ABCDEFGHJKMNPQRSTWXYZabcdefhijkmnprstwxyz2345678";
        int maxPos = chars.length();
        String code = "";
        for (int i = 0; i < 6; i++) {
            code += chars.charAt((int)Math.floor(Math.random() * maxPos));
        }
        return code;
    }

    
    public static String getOs_system(){
        return "Android OS " + Build.VERSION.RELEASE +" / API-"+Build.VERSION.SDK_INT+" ("+Build.ID+"/"+Build.VERSION.INCREMENTAL+")";
    }
    
    public static String getDevice_model(){
        String[] info = Build.FINGERPRINT.split("/");
        return info[0]+" "+info[1];
    }
}
