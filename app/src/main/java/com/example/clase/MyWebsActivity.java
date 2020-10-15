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
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        System.out.println(findViewById(R.id.buttons_item));

        web = (WebView) findViewById(R.id.web_view);
        web.setWebViewClient(new WebViewClient());
        web.getSettings().setJavaScriptEnabled(true);
        tx = findViewById(R.id.web_text);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //System.out.println(item.getTitle());
//                  Es la unica forma que se me ha ocurrido.
        if (item.getTitle().toString().equals(getString(R.string.amazon))) {
            web.loadUrl("https://www.amazon.es");
            tx.setText(getString(R.string.amazon));
            return true; // No veo diferencia de true a false.
        }
        if (item.getTitle().toString().equals(getString(R.string.twitch))) {
            web.loadUrl("https://www.twitch.tv");
            tx.setText(getString(R.string.twitch));
            return false;
        }
        return super.onOptionsItemSelected(item);
    }
}