package com.example.alc4phase1;

import android.content.Context;
import android.content.DialogInterface;
import android.net.http.SslError;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class AboutALC extends AppCompatActivity {

    private WebView mWebView;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        swipe = findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadPage();
            }
        });

       loadPage();

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //check if the key event was the Back Button and if there's history
        if ((keyCode == KeyEvent.KEYCODE_BACK)&& mWebView.canGoBack()){
            mWebView.goBack();
            return true;
        }
        //if it wasn't the back key of there's no web page history, bubble up to the default
        //system behaviour(probably exit the activity)
        return super.onKeyDown(keyCode,event);
    }
    public void loadPage(){
        mWebView = findViewById(R.id.webView_alc);
        swipe.setRefreshing(true);
        mWebView.setWebViewClient(new WebViewClient(){
            public void onPageFinished(WebView view, String url){
                swipe.setRefreshing(false);
            }
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl){
                Context context = getApplicationContext();
                CharSequence text = "Make sure that your device is connected to the internet and pull down to refresh";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                super.onReceivedError(view, errorCode, description, failingUrl);
            }

        });
        mWebView.loadUrl("https://andela.com/alc/");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAppCacheEnabled(true);
    }
    /*@Override
    public void onReceiveSslError(WebView view, final SslErrorHandler handler, SslError error){
        Context context;
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(R.string.notification_error_ssl_cert_invalid);
        builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                handler.proceed();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                handler.cancel();
            }
        });
        final AlertDialog dialog = builder.create();
        dialog.show();
    }*/

    //public void loadAlcpage()
}
