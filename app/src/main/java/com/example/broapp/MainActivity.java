package com.example.broapp;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextToSpeech textToSpeech;
    ImageView img;
    EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img=findViewById(R.id.imageView2);
        edit=findViewById(R.id.editText);
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.getDefault());
                }
            }
        });

        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = edit.getText().toString();
                if(text.length()!=0) {
                    if (text.charAt(text.length() - 1) == 'a' || text.charAt(text.length() - 1) == 'i') {
                        textToSpeech.speak(text + " je prehnitá jak pavlíkov kód", TextToSpeech.QUEUE_FLUSH, null);
                    } else if (text.charAt(text.length() - 1) == 'é' || text.charAt(text.length() - 1) == 'á') {
                        textToSpeech.speak(text + " sú prehnité jak pavlíkov kód", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(text.charAt(text.length()-1)=='o' || text.charAt(text.length()-1)=='e'){
                        textToSpeech.speak(text+" je prehnité jak pavlíkov kód",TextToSpeech.QUEUE_FLUSH, null);
                    }else {
                        textToSpeech.speak(text + " je prehnitý jak pavlíkov kód", TextToSpeech.QUEUE_FLUSH, null);
                    }
                }else{
                    textToSpeech.speak("čo si kokot šak zadaj vstup",TextToSpeech.QUEUE_FLUSH, null);
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
                Intent listAct=new Intent(MainActivity.this,MainActivity.class);
                startActivity(listAct);
                return true;
            case R.id.settOpt:
                Intent setAct=new Intent(MainActivity.this,SettingActivity.class);
                startActivity(setAct);
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}
