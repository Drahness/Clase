package com.example.clase;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.text.Layout;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.time.Duration;

public class MyButtons extends MainMenu {
    int taps_on_OnOff_button = 0;
    private ImageButton ib;
    private Switch s ;
    private ToggleButton tb;
    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_buttons);
        if(getActionBar() == null) {
            Toolbar toolbar = findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
        }
        s = (Switch) findViewById(R.id.switch1);
        ib = (ImageButton) findViewById(R.id.imageButton);
        tb = (ToggleButton) findViewById(R.id.toggleButton);
        rg = findViewById(R.id.radioGroup);

        System.out.println(findViewById(R.id.switch1));
        System.out.println(findViewById(R.id.imageButton));

        this.setSwitch();
        this.setOnOffButton();
        this.setRadios();
        this.setOnToggleButton();
    }
    private void setRadios() {
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence cs = ((RadioButton)v).getText();

                AlertDialog.Builder builder = new AlertDialog.Builder(MyButtons.this);

                String s = getString(R.string.alert_dialog_radios);

                builder.setTitle("Radio Button Action").setMessage(String.format(s, cs)).create().show();


            }
        };
        findViewById(R.id.radio_man).setOnClickListener(listener);
        findViewById(R.id.radio_woman).setOnClickListener(listener);

    }
    private void setSwitch() {
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println(s.isChecked());
                if(s.isChecked()) {
                    ib.setVisibility(View.VISIBLE);
                    tb.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                }
                else {
                    ib.setVisibility(View.INVISIBLE);
                    tb.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setOnToggleButton() {
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(MyButtons.this,String.format(getString(R.string.alert_toast),tb.getText()),Toast.LENGTH_LONG );
                t.setGravity(Gravity.TOP,0,0);
                t.show();
            }
        });
    }


    private void setOnOffButton() {
        ImageButton ib = (ImageButton) findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {
                ImageButton img = (ImageButton) findViewById(v.getId());
                if(taps_on_OnOff_button%2 == 1) {
                    img.setImageDrawable(getDrawable(R.drawable.offbutton));
                }
                else {
                    img.setImageDrawable(getDrawable(R.drawable.onbutton));
                }
                taps_on_OnOff_button++;
            }
        });
    }
}