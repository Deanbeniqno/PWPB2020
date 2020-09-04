package com.example.latihanintentpwpb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnPage2;
    Button btnPage3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPage2 = findViewById(R.id.btn_page2);
        btnPage3 = findViewById(R.id.btn_page3);
        btnPage2.setOnClickListener(this);
        btnPage3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_page2:
                Intent gotoPage2 = new Intent(MainActivity.this, IntentActivity2.class);//gerak snto
                startActivity(gotoPage2); //to start intent activity
                break;

            case R.id.btn_page3:
                Intent gotoPage3 = new Intent(MainActivity.this, IntentActivity3.class);//Intent(context,classtujuan)
                startActivity(gotoPage3);
                break;
        }
    }
}