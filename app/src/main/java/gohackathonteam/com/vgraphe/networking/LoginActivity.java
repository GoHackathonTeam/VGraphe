package gohackathonteam.com.vgraphe.networking;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

import gohackathonteam.com.vgraphe.R;

public class LoginActivity extends Activity {

    String url = "https://oauth.vk.com/authorize?client_id=6460719&display=page&" +
            "redirect_uri=https://oauth.vk.com/blank.html&scope=friends&response_type=token&v=5.74&state=123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_in_vk);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new AutenWeb(getApplicationContext()));

        System.out.println(url);
        webView.loadUrl(url);
    }
}
