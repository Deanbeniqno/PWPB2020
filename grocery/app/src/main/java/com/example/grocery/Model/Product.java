package com.example.grocery.Model;

public class Product {

    private int id;
    private String nama;
    private int quantity;
    private String tanggal;

    public Product(){

    }
    public Product(int id, String nama, int quantity, String tanggal) {
        this.id = id;
        this.nama = nama;
        this.quantity = quantity;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
}
