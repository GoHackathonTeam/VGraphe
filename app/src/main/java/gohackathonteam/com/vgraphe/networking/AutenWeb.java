package gohackathonteam.com.vgraphe.networking;


import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import gohackathonteam.com.vgraphe.InitActivity;

import static android.content.ContentValues.TAG;

class AutenWeb extends WebViewClient {

    Context context;
    String TOKEN;
    String ID;

    AutenWeb(Context context){
        this.context = context;
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, String url)
    {
        return shouldOverrideUrlLoading(url);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest request)
    {
        Uri uri = request.getUrl();
        return shouldOverrideUrlLoading(uri.toString());
    }

    private boolean shouldOverrideUrlLoading(final String url)
    {
        Log.i(TAG, "shouldOverrideUrlLoading() URL : " + url);

        System.out.println(url);

        if (url.matches(".*access_token=.*")) {
            TOKEN = url.substring(45, 130);
            ID = url.substring(156, 165);
            Intent intent = new Intent(context, Object.class);
            intent.putExtra("token", TOKEN).putExtra("id", ID);
            context.startActivity(intent);
        }

        return false;
    }
}
