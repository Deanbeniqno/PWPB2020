package com.example.grocery.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "grocery";
    private static final String TABLE_NAME = "product";

    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "nama";
    private static final String KEY_QUAN = "quantity";
    private static final String KEY_DATE = "tanggal";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + TABLE_NAME + "(" +
                KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_NAME + " TEXT, " +
                KEY_QUAN + " TEXT, " +
                KEY_DATE + " TEXT )";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String sql = "DROP TABLE IF EXISTS" + TABLE_NAME;
        sqLiteDatabase.execSQL(sql);
        onCreate(sqLiteDatabase);
    }
    public void insert(Product product){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, product.getId());
        values.put(KEY_NAME, product.getNama());
        values.put(KEY_QUAN, product.getQuantity());
        values.put(KEY_DATE, product.getTanggal());

        db.insert(TABLE_NAME,null,values);
    }

    public void update(Product product){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NAME, product.getNama());
        values.put(KEY_QUAN, product.getQuantity());
        values.put(KEY_DATE, product.getTanggal());

        String whereClause = KEY_ID + " = '" + product.getId() + "'";
        db.update(TABLE_NAME, values, whereClause, null);
    }

    public ArrayList<Product> fetch(){
        ArrayList<Product> arrayList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String[] columns = {KEY_ID, KEY_NAME, KEY_QUAN, KEY_DATE};
        Cursor c = db.query(TABLE_NAME, columns, null, null, null, null,  null);


        while(c.moveToNext()){
            int id = c.getInt(0);
            String nama = c.getString(1);
            int quantity = c.getInt(2);
            String tanggal = c.getString(3);

            Product product = new Product();
            product.setId(id);
            product.setNama(nama);
            product.setQuantity(quantity);
            product.setTanggal(tanggal);

            arrayList.add(product);
        }
        return arrayList;
    }

    public void delete(int id){
        SQLiteDatabase db = getWritableDatabase();
        String whereClause = KEY_ID + " = " +id;
        db.delete(TABLE_NAME, whereClause,null);
    }
}
