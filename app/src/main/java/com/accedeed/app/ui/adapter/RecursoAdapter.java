package com.accedeed.app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.model.Recurso;
import com.bumptech.glide.Glide;

import java.util.List;

public class RecursoAdapter extends RecyclerView.Adapter<RecursoAdapter.RecursoViewHolder> {
    private List<Recurso> recursos;

    public RecursoAdapter(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    @NonNull
    @Override
    public RecursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recurso, parent, false);
        return new RecursoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecursoViewHolder holder, int position) {
        Recurso recurso = recursos.get(position);
        holder.tvTitulo.setText(recurso.getTitulo());
        holder.tvDescripcion.setText(recurso.getDescripcion());
        holder.tvCategoria.setText(recurso.getCategoria());
        
        if (recurso.getImageUrl() != null && !recurso.getImageUrl().isEmpty()) {
            Glide.with(holder.itemView.getContext())
                    .load(recurso.getImageUrl())
                    .into(holder.ivRecurso);
        }
    }

    @Override
    public int getItemCount() {
        return recursos.size();
    }

    static class RecursoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvDescripcion, tvCategoria;
        ImageView ivRecurso;

        RecursoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tv_titulo);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion);
            tvCategoria = itemView.findViewById(R.id.tv_categoria);
            ivRecurso = itemView.findViewById(R.id.iv_recurso);
        }
    }
}
