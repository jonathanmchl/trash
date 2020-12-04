package com.example.gamemate;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.gamemate.tabgoogleplay.TabGooglePlayActivity;


public class MainActivity extends AppCompatActivity {


    Button btnActTabGooglePlay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        btnActTabGooglePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TabGooglePlayActivity.class));
            }
        });


    }
}