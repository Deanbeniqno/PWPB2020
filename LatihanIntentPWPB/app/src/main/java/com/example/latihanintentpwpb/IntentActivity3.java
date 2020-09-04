package com.example.latihanintentpwpb;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity3 extends AppCompatActivity {
    Button btnBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_intent_3);
        btnBack = findViewById(R.id.back_to_two);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backToTwo = new Intent(IntentActivity3.this, IntentActivity2.class);
                startActivity(backToTwo);
            }
        });
    }
}