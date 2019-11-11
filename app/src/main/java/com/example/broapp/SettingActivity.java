package com.example.broapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.text.style.BackgroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

import java.util.List;

public class SettingActivity extends AppCompatActivity {

    Switch darkmode;
    View bg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        darkmode=findViewById(R.id.switch1);
        bg=findViewById(R.id.bg);

        darkmode.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    darkmode.setTextColor(Color.parseColor("#ffffff"));
                    bg.setBackgroundColor(Color.parseColor("#000000"));
                }else{
                    darkmode.setTextColor(Color.parseColor("#000000"));
                    bg.setBackgroundColor(Color.parseColor("#ffffff"));

                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.mainmenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.randOpt:
            Intent listAct=new Intent(SettingActivity.this,MainActivity.class);
            startActivity(listAct);
            return true;
            case R.id.settOpt:
                Intent setAct=new Intent(SettingActivity.this,SettingActivity.class);
                startActivity(setAct);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
