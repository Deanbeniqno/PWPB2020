package com.example.grocery;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.grocery.Adapter.RecyclerviewAdapter;
import com.example.grocery.Model.DatabaseHelper;
import com.example.grocery.Model.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity implements RecyclerviewAdapter.OnUserClickListener {
    FloatingActionButton fb;
    List<Product> listProducts;
    RecyclerView recyclerView;
    DatabaseHelper db;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fb = findViewById(R.id.btn_add);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AddUpdateItemActivity.class);
                startActivity(intent);
            }
        });
        actionBar = getSupportActionBar();
        actionBar.setTitle("GROCERY");
        db = new DatabaseHelper(this);
        recyclerView = findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        setupRecycleView();
    }

    private void setupRecycleView() {
        listProducts = db.fetch();
        RecyclerviewAdapter adapter = new RecyclerviewAdapter(MainActivity.this, listProducts, this);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onUserClick(final Product product, String action) {
        switch (action){
            case "Edit":
                Intent intentEdit = new Intent(MainActivity.this, AddUpdateItemActivity.class);
                intentEdit.putExtra("id", product.getId());
                intentEdit.putExtra("nama", product.getNama());
                intentEdit.putExtra("quantity", product.getQuantity());
                startActivity(intentEdit);
                break;
            case "Delete":
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("Yakin Menghapus Data?");
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        db.delete(product.getId());
                        dialogInterface.dismiss();
                        setupRecycleView();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                break;
        }
    }
}