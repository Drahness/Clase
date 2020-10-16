package com.example.clase;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainMenu extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            return true;
        }
        else if(id == R.id.buttons_item) {
            Intent intent = new Intent(MainMenu.this, MyButtons.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.amazon_item) {
            Intent intent = new Intent(MainMenu.this, MyWebsActivity.class);
            Bundle b = new Bundle();
            b.putString("URL",getString(R.string.amazon_URL));
            intent.putExtras(b);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.twitch_item) {
            Intent intent = new Intent(MainMenu.this, MyWebsActivity.class);
            Bundle b = new Bundle();
            b.putString("URL",getString(R.string.twitch_URL));
            intent.putExtras(b);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.home_item) {
            Intent intent = new Intent(MainMenu.this, MainActivity.class);
            startActivity(intent);
            return true;
        }
        else if(id == R.id.lists_item) {
            Intent intent = new Intent(MainMenu.this, MyListActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
