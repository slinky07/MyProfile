package com.slinky.myprofile;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ThemeUtils.onCreateSetTheme(this, getSavedTheme());

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       ImageButton btn = findViewById(R.id.settingsWheel);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchSettings();
            }
        });

    }
    protected void launchSettings() {
        Intent intent = new Intent(this, SpinnerActivity.class);
        startActivity(intent);
    }
//    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(),
//            new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result.getResultCode() == 0) {
//                        Intent intent = result.getData();
//                        ///something about ketting item from key for seasons maybe
//                    }
//                }
//            }
//    );

    public int getSavedTheme() {
        return 6;
    }

}