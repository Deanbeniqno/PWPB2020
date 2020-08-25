package com.example.intentparcelable;

import android.app.ActionBar;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MoveWithObjectActivity extends AppCompatActivity {

    public static String EXTRA_PERSON = "extra_person";
    private TextView tvObject;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move_with_object);

        getSupportActionBar().setTitle("Move With Object Activity");

        tvObject = (TextView) findViewById(R.id.tv_object_received);
        Person mPerson = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : " + mPerson.getName() + ", Email : "
                + mPerson.getEmail() + ", Age : " + mPerson.getAge()
                + ", Location : " + mPerson.getCity();
        tvObject.setText(text);
    }
}
