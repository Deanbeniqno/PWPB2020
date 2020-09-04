package com.example.latihanintentpwpb;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentActivity2 extends AppCompatActivity implements View.OnClickListener {
    Button btnToMain;
    Button btnToThree;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.halaman_intent_2);
        btnToMain = findViewById(R.id.back_to_main);
        btnToThree = findViewById(R.id.go_to_three);
        btnToMain.setOnClickListener(this);
        btnToThree.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_to_main:
                Intent back = new Intent(this, MainActivity.class);
                startActivity(back); //to start intent activity
                break;

            case R.id.go_to_three:
                Intent gotoPage3 = new Intent(this, IntentActivity3.class);//Intent(context,classtujuan)
                startActivity(gotoPage3);
                break;
        }
    }
}
