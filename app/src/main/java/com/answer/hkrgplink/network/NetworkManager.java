package com.answer.hkrgplink.network;
import android.os.Handler;
import com.answer.hkrgplink.bean.DataObj;
import com.answer.hkrgplink.bean.LoginCookieDataDto;
import com.answer.hkrgplink.bean.LoginTokenDto;
import com.google.gson.Gson;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import java.util.ArrayList;
import com.answer.hkrgplink.bean.UserService;
import com.answer.hkrgplink.bean.UserGameRolesByCookieDataDto;
import com.answer.hkrgplink.bean.ListUrl;
import com.answer.hkrgplink.bean.AuthKeyPostData;
import okhttp3.RequestBody;
import okhttp3.MediaType;
import com.answer.hkrgplink.utils.HttpDataUtil;
import java.net.URLEncoder;
import com.answer.hkrgplink.bean.AuthKeyDataDto;
import android.os.Message;
import com.answer.hkrgplink.bean.ChouKaObj;
import android.os.Build;

/**
 * @Author AnswerDev
 * @Date 2023/05/09 00:27
 */
public class NetworkManager {

    public static final NetworkManager INSTANCE = new NetworkManager();

    private static OkHttpClient client = new OkHttpClient()
    .newBuilder().connectTimeout(10, TimeUnit.SECONDS)
    .readTimeout(10, TimeUnit.SECONDS)
    .writeTimeout(10, TimeUnit.SECONDS)
    .build();

    private static Thread NetworkThread;

    private static Handler NetworkHandler;

    private NetworkManager() {
    }

    public final String getAuthKey(final String cookie, final Handler handler) {
        this.NetworkHandler = handler;

        NetworkThread = new Thread(new Runnable(){
                @Override
                public void run()  {
                    try {
                        //get time
                        long time = new Date().getTime();
                        //get cookie
                        ResponseBody body = client.newCall(new Request.Builder()
                                                           .url("https://webapi.account.mihoyo.com/Api/login_by_cookie?t=" + time)
                                                           .header("Cookie", cookie).build())
                            .execute()
                            .body();

                        //LoginCookieBody
                        String LoginCookieBody = body != null ? body.string() : null;

                        System.out.println((Object) ("body====>" + LoginCookieBody));

                        //initial gson
                        Gson gson = new Gson();

                        //LoginCookieJson to Object
                        LoginCookieDataDto loginCookieDataDto =  gson.fromJson(LoginCookieBody, LoginCookieDataDto.class);

                        //get Account id
                        int account_id = loginCookieDataDto.getData().getAccount_info().getAccount_id();

                        //get token
                        String weblogin_token = loginCookieDataDto.getData().getAccount_info().getWeblogin_token();


                        //LoginTokenBody
                        ResponseBody LoginTokenBody = client.newCall(new Request.Builder()
                                                                     .url("https://api-takumi.mihoyo.com/auth/api/getMultiTokenByLoginTicket?login_ticket="
                                                                          + weblogin_token
                                                                          + "&token_types=3&uid=" 
                                                                          + account_id)
                                                                     .header("Cookie", cookie)
                                                                     .build())
                            .execute()
                            .body();

                        //LoginTokenString
                        String LoginTokenString = LoginTokenBody != null ? LoginTokenBody.string() : null;

                        System.out.println(LoginTokenString);

                        String stuid = "stuid=" + account_id + ';';

                        for (DataObj dataObj : gson.fromJson(LoginTokenString, LoginTokenDto.class).getData().getList()) {
                            stuid = stuid + dataObj.getName() + '=' + dataObj.getToken() + ';';
                        }
                        String stuid_cookie = stuid + cookie;

                        System.out.println(stuid_cookie);

                        ResponseBody uidDataDtoBody = client.newCall(new Request.Builder()
                                                                     .url("https://api-takumi.mihoyo.com/binding/api/getUserGameRolesByCookie?game_biz=hkrpg_cn")
                                                                     .header("Cookie", stuid_cookie)
                                                                     .build())
                            .execute()
                            .body();

                        String uidDataDtoString = uidDataDtoBody != null ? uidDataDtoBody.string() : null;
                        System.out.println((Object) ("uidDataDtoBody:=>>>" + uidDataDtoString));
                        ArrayList arrayList = new ArrayList();

                        UserGameRolesByCookieDataDto uidDataDtoBean =gson.fromJson(uidDataDtoString, UserGameRolesByCookieDataDto.class);

                        for (UserService userService :  uidDataDtoBean.getData().getList()) {
                            //get data
                            String game_uid = userService.getGame_uid();
                            String game_biz = userService.getGame_biz();
                            String region = userService.getRegion();


                            AuthKeyPostData authKeyPostData = new AuthKeyPostData("webview_gacha", game_biz, game_uid, region);
                            String toJson = gson.toJson(authKeyPostData);

                            System.out.println(toJson);

                            RequestBody createRequestBody = RequestBody.create(toJson, MediaType.Companion.get("application/json;charset=utf-8"));


                            //{"data":null,"message":"invalid request","retcode":-10001}
                            System.out.println(stuid_cookie);
                            System.out.println(HttpDataUtil.getDs());

                            ResponseBody genAuthKeyBody = client.newCall(new Request.Builder()
                                                                         .url("https://api-takumi.mihoyo.com/binding/api/genAuthKey")
                                                                         .header("Content-Type", "application/json;charset=utf-8")
                                                                         .header("Host", "api-takumi.mihoyo.com")
                                                                         .header("Accept", "application/json, text/plain, */*")
                                                                         .header("User-Agent", "okhttp/4.8.0")
                                                                         .header("x-rpc-channel", "mihoyo")
                                                                         .header("x-rpc-app_version", "2.40.1")
                                                                         .header("x-rpc-client_type", "5")

                                                                         .header("x-rpc-device_id", "CBEC8312-AA77-489E-AE8A-8D498DE24E90")
                                                                         .header("DS", HttpDataUtil.getDs())
                                                                         .header("Cookie", stuid_cookie)
                                                                         .header("Referer", "https://app.mihoyo.com")
                                                                         .header("Origin", "https://webstatic.mihoyo.com")
                                                                         .post(createRequestBody)
                                                                         .build())
                                .execute()
                                .body();

                            String genAuthKeyString = genAuthKeyBody != null ? genAuthKeyBody.string() : null;

                            System.out.println(genAuthKeyString);

                            AuthKeyDataDto genAuthKeyBean = gson.fromJson(genAuthKeyString, AuthKeyDataDto.class);

                            System.out.println(URLEncoder.encode(genAuthKeyBean.getData().getAuthkey(), "utf-8"));

                            //authkey 好像有问题
                            // 崩坏星穹铁道的authkey 是固定的 这个不是固定的
                            StringBuilder sb = new StringBuilder();
                            sb.append("https://api-takumi.mihoyo.com/common/gacha_record/api/getGachaLog?authkey_ver=1&sign_type=2&auth_appid=webview_gacha&win_mode=fullscreen&gacha_id=b4ac24d133739b7b1d55173f30ccf980e0b73fc1");
                            sb.append("&timestamp=" + System.currentTimeMillis());
                            sb.append("&region=" + region);
                            sb.append("&default_gacha_type=11&lang=zh-cn&authkey=" + URLEncoder.encode(genAuthKeyBean.getData().getAuthkey(), "utf-8"));
                            sb.append("&game_biz=" + game_biz);
                            sb.append("&os_system=" + HttpDataUtil.getOs_system());
                            sb.append("&device_model=" + HttpDataUtil.getDevice_model());
                            sb.append("&plat_type=android&page=1&size=5&gacha_type=11&end_id=0");




                            System.out.println(sb.toString());
                            arrayList.add(new ListUrl(game_uid, sb.toString()));
                            Message obtain = Message.obtain();
                            obtain.obj = new ChouKaObj(200, "请求成功", arrayList);
                            handler.sendMessage(obtain);

                        }

                    } catch (Throwable e) {
                        e.printStackTrace();
                        Message obtain2 = Message.obtain();
                        obtain2.obj = new ChouKaObj(404, "获取失败", new ArrayList());
                        handler.sendMessage(obtain2);
                    }

                }
            });
        NetworkThread.start();



        return "";
    }


}
