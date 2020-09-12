package com.example.inputuser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText bilangan1;
    private EditText bilangan2;
    private EditText hasil;
    private Button jumlah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        initEvent();

    }

    private void initEvent() {

        jumlah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungJumlah();
            }
        });
    }

    private void hitungJumlah() {
        int angka1 = Integer.parseInt(bilangan1.getText().toString());
        int angka2 = Integer.parseInt(bilangan2.getText().toString());
        int result  = angka1 + angka2;
        hasil.setText(String.valueOf(result));
    }

    private void initUI() {

        bilangan1 = (EditText) findViewById(R.id.Angka1);
        bilangan2 = (EditText) findViewById(R.id.Angka2);
        hasil = (EditText) findViewById(R.id.hasil);
        jumlah = (Button) findViewById(R.id.btnHasil);


    }
}
