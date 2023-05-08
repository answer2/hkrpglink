package com.answer.hkrgplink;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.answer.hkrgplink.bean.ChouKaObj;
import com.answer.hkrgplink.bean.ListUrl;
import kotlin.jvm.internal.Intrinsics;
import android.view.View.OnClickListener;
import android.content.DialogInterface;
import android.webkit.CookieManager;
import com.answer.hkrgplink.network.NetworkManager;

public class MainActivity extends Activity {

    private static EditText input;

    private static Context context;

    public static Handler handler = new Handler(){
        @Override
        public void handleMessage(Message message) {
            final ChouKaObj chouKaObj = (ChouKaObj) message.obj;
            int i = 0;
            if (chouKaObj.getCode() == 200) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                if (chouKaObj.getUrlListObj().size() > 1) {
                    int size = chouKaObj.getUrlListObj().size();
                    final String[] strArr = new String[size];
                    for (int i2 = 0; i2 < size; i2++) {
                        strArr[i2] = "";
                    }
                    for (ListUrl listUrl : chouKaObj.getUrlListObj()) {
                        strArr[i] = listUrl.getUid();
                        i++;
                    }
                    builder.setIcon(R.drawable.ic_launcher).setTitle("选择你想要查询的账号");
                    builder.setItems(strArr, new DialogInterface.OnClickListener(){
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                for (ListUrl listUrl : chouKaObj.getUrlListObj()) {
                                    if (Intrinsics.areEqual(listUrl.getUid(), strArr[which])) {
                                        input.setText(listUrl.getUrl());
                                        ClipboardManager systemService = (ClipboardManager) context.getSystemService("clipboard");

                                        systemService.setPrimaryClip(ClipData.newPlainText("", listUrl.getUrl()));
                                        Toast.makeText(context, "已复制到剪贴板", 0).show();
                                    }
                                }

                                Toast.makeText(context, "你选择了Uid:" + strArr[which], 0).show();

                            }
                        });
                    AlertDialog create = builder.create();
                    Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
                    create.show();
                    return;
                }

                input.setText(chouKaObj.getUrlListObj().get(0).getUrl());
                //copy
                ClipboardManager systemService =(ClipboardManager) context.getSystemService("clipboard");
                systemService.setPrimaryClip(ClipData.newPlainText("", chouKaObj.getUrlListObj().get(0).getUrl()));

                Toast.makeText(context, "已复制到剪贴板", 0).show();
                return;
            }
            Toast.makeText(context, "请先登录米游社", 0).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        WebView webView = findViewById(R.id.webview);
        Button cookieButton = findViewById(R.id.cookieBtn);
        input = findViewById(R.id.input);

        //initial context
        this.context = this;

        //configure WebView
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.loadUrl("https://user.mihoyo.com");

    }

    public void cookie(View view) {
        String cookie = CookieManager.getInstance().getCookie("https://user.mihoyo.com");
        NetworkManager manager = NetworkManager.INSTANCE;
        manager.getAuthKey(cookie, this.handler);

    }

}
