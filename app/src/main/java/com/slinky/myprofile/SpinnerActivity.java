package com.slinky.myprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class SpinnerActivity extends AppCompatActivity {
    private  String selected = "spring";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        Button btn = findViewById(R.id.confirmBtn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // set AND cache theme then launch

                launchMain();
            }
        });

        Spinner spin = findViewById(R.id.spinnerID);

        // init spinner
        ArrayAdapter<CharSequence> stackAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.seasonsList,
                android.R.layout.simple_spinner_item
        );
        stackAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(stackAdapter);

        // set select listenner
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selected = spin.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                // booooooo
            }
        });
    }

    protected void launchMain() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}