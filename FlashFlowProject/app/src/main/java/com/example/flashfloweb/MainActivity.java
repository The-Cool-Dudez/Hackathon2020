package com.example.flashfloweb;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.io.IOException;
import java.util.List;

import flashair.FATFile;
import flashair.FlashAir;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{


    Button buttonConnect;
    Button buttonUpload;
    boolean connected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonConnect = findViewById(R.id.btnConnect);
        buttonUpload = findViewById(R.id.btnUpload);

        buttonConnect.setEnabled(true);
        buttonUpload.setEnabled(false);

        buttonConnect.setOnClickListener(this);
        buttonUpload.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v)  {
        switch (v.getId())
        {
            case R.id.btnConnect:
                startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
                buttonConnect.setText("Connecting");
                try
                {
                    Thread.sleep(500);
                }
                catch(InterruptedException e)
                {}
                buttonConnect.setText("Connected");
                buttonConnect.setEnabled(false);
                buttonUpload.setEnabled(true);
                connected = true;
                break;
            case R.id.btnUpload:
                if (!connected) {
                    return;
                }
                startActivity(new Intent(MainActivity.this, uploadactivity.class));
                /*
                FlashAir flashair = new FlashAir();
                try {
                    List<FATFile> files = flashair.getFileList("/");
                    if  (files.isEmpty()) {
                        Log.v("FILE", "none found");
                        return;
                    }
                    for (FATFile file: files) {
                        Log.v("FILE:", file.getFileName());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
                 */
                connected = false;
                break;
        }
    }
}
