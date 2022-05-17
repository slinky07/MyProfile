package com.slinky.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {
//    private  String selected = "spring";
    private Spinner spin;
    private Button btn;
    private int defaultVal = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initID();
        btnListenner();
        initSpinner();
        spinListenner();

        getSharedPref(); //see if necessary, already has default set

    }

    private void initID() {
        spin = findViewById(R.id.spinnerID);
        btn = findViewById(R.id.confirmBtn);
    }

    private void initSpinner() {
        ArrayAdapter<CharSequence> stackAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.seasonsList,
                android.R.layout.simple_spinner_item
        );
        stackAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(stackAdapter);
    }

    private void btnListenner() {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set AND cache theme then launch

                launchMain();
            }
        });
    }
    private void spinListenner() {
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                selected = spin.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // booooooo
            }
        });
    }
    private void launchMain() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void getSharedPref() {
        SharedPreferences sharedPreferences = getSharedPreferences(ThemeUtils.getPREF(), MODE_PRIVATE);
        defaultVal = sharedPreferences.getInt("Theme", defaultVal);
    }

    private void getSharedPreference(int i) {
        SharedPreferences sharedPreferences = getSharedPreferences(ThemeUtils.getPREF(), MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("Theme", ThemeUtils.getRightThemeVal(i));
        editor.apply();

    }
}