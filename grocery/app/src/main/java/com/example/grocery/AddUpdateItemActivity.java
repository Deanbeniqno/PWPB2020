package com.example.grocery;

        import android.content.Intent;
        import android.os.Build;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;

        import androidx.annotation.Nullable;
        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import com.example.grocery.Model.DatabaseHelper;
        import com.example.grocery.Model.Product;

        import java.sql.Date;
        import java.time.LocalDate;
        import java.util.Random;

public class AddUpdateItemActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText inpNama, inpQuantity;
    DatabaseHelper db;
    Random rand;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        rand = new Random();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_activity);
        btnSubmit = findViewById(R.id.btnSubmit);
        inpNama = findViewById(R.id.inp_nama);
        inpQuantity = findViewById(R.id.inp_jumlah);
        db = new DatabaseHelper(this);

        if(getIntent().getIntExtra("id", 0) != 0){
            inpNama.setText(getIntent().getStringExtra("nama"));
            inpQuantity.setText(String.valueOf(getIntent().getIntExtra("quantity",0)));
            getSupportActionBar().setTitle("Form Edit");
        }else{
            getSupportActionBar().setTitle("Form Add");
        }

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if(getIntent().getIntExtra("id",0) !=0){
                    Product product = new Product();
                    product.setId(getIntent().getIntExtra("id",0));
                    product.setNama(inpNama.getText().toString());
                    product.setQuantity(Integer.parseInt(inpQuantity.getText().toString()));
                    product.setTanggal(getIntent().getStringExtra("date"));
                    db.update(product);
                    startActivity(new Intent(AddUpdateItemActivity.this, MainActivity.class));
                 }
                else {
                    Product product = new Product();
                    int id = rand.nextInt(9999)+ 1;
                    product.setId(id);
                    product.setNama(inpNama.getText().toString());
                    product.setQuantity(Integer.parseInt(inpQuantity.getText().toString()));
                    long millis = System.currentTimeMillis();
                    product.setTanggal(String.valueOf(new Date(millis)));
                    db.insert(product);
                    startActivity(new Intent(AddUpdateItemActivity.this, MainActivity.class));

                }
            }
        });
    }
}
