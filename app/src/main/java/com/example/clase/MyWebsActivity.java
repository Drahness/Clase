package com.example.clase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

public class MyWebsActivity extends MainMenu {
    private WebView web;
    TextView tx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_webs);
        System.out.println(findViewById(R.id.buttons_item));
        if(getActionBar() == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
        web = (WebView) findViewById(R.id.web_view);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        tx = findViewById(R.id.web_text);
        if(this.getIntent().getExtras().getString("URL") != null) {
            web.loadUrl(this.getIntent().getExtras().getString("URL"));
        }

        //web.loadUrl("https://www.twitch.tv");
    }
}