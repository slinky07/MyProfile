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

    private Spinner spin;
    private Button btn;
    private int selectedPosition;
    private boolean isSpinnerTouched = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        initID();
        btnListener();
        initSpinner();
        spinListener();

//        selectedPosition = ThemeUtils.getSavedTheme(this);
    }

    /**
     * init some boring IDs
     */
    private void initID() {
        spin = findViewById(R.id.spinnerID);
        btn = findViewById(R.id.confirmBtn);
    }

    /**
     * initialize spinner
     */
    private void initSpinner() {
        ArrayAdapter<CharSequence> stackAdapter = ArrayAdapter.createFromResource(
                this,
                R.array.seasonsList,
                android.R.layout.simple_spinner_item
        );
        stackAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(stackAdapter);
    }

    /**
     * Btn Click Listener, only save preference if something has been saved this round
     */
    private void btnListener() {
        btn.setOnClickListener(view -> {
            if (isSpinnerTouched) {
                ThemeUtils.putSharedPreference(SpinnerActivity.this, selectedPosition);
            }
            isSpinnerTouched = false;
            launchMain();
        });
    }

    /**
     * Spinner onSelect listener
     */
    private void spinListener() {
        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
                if (pos != 0) {
                    selectedPosition = pos;
                    isSpinnerTouched = true;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                isSpinnerTouched = false;
            }
        });
    }

    /**
     * send to MainActivity
     */
    private void launchMain() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}