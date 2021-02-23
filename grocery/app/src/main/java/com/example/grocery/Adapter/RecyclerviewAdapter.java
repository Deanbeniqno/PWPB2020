package com.example.grocery.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grocery.Model.Product;
import com.example.grocery.R;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.Holder> {
    Context context;
    List<Product> listProducts;
    OnUserClickListener listener;

   public RecyclerviewAdapter(Context context, List<Product> listProducts, OnUserClickListener onUserClickListener){
        this.context = context;
        this.listProducts = listProducts;
        this.listener = onUserClickListener;
    }

    public interface OnUserClickListener{
        void onUserClick(Product product, String action);
    }

    @NonNull
    @Override
    public RecyclerviewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        final Product currentProduct = listProducts.get(position);
        holder.inpName.setText(currentProduct.getNama());
        holder.inpQuantity.setText(currentProduct.getQuantity());
        holder.btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentProduct, "Edit");
            }
        });
        holder.btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onUserClick(currentProduct,"Delete");
            }
        });
    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView inpName, inpQuantity, inpDate;
        ImageView btnEdit, btnDelete;
        public Holder(@NonNull View itemView) {
            super(itemView);
            inpName = itemView.findViewById(R.id.inp_nama);
            inpQuantity = itemView.findViewById(R.id.inp_jumlah);
            inpDate = (TextView) itemView.findViewById(R.id.inp_date);
            btnEdit = (ImageView) itemView.findViewById(R.id.btn_edit);
            btnDelete = (ImageView) itemView.findViewById(R.id.btn_delete);
        }
    }
}
