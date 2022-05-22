package com.slinky.myprofile;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.widget.ImageButton;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.onCreateSetTheme(this, ThemeUtils.getSavedTheme(this));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ImageButton btn = findViewById(R.id.settingsWheel);

        btn.setOnClickListener(view -> launchSettings());

    }

    /**
     * send to SpinnerActivity
     */
    protected void launchSettings() {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }
}