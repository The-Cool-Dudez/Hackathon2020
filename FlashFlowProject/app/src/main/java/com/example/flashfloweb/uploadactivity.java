package com.example.flashfloweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class uploadactivity extends AppCompatActivity implements View.OnClickListener{


    Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploadactivity);

        buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)  {
        switch (v.getId())
        {
            case R.id.buttonBack:
                startActivity(new Intent(uploadactivity.this, MainActivity.class));
                break;

        }
    }
}
