package com.accedeed.app.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.model.Recurso;

import java.util.List;

public class RecursoAdapter extends RecyclerView.Adapter<RecursoAdapter.RecursoViewHolder> {
    private List<Recurso> recursos;

    public RecursoAdapter(List<Recurso> recursos) {
        this.recursos = recursos;
    }

    @NonNull
    @Override
    public RecursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recurso, parent, false);
        return new RecursoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecursoViewHolder holder, int position) {
        Recurso recurso = recursos.get(position);
        holder.tvTitle.setText(recurso.getTitle());
        holder.tvDescription.setText(recurso.getDescription());
        holder.tvCategory.setText(recurso.getCategory());
    }

    @Override
    public int getItemCount() {
        return recursos.size();
    }

    public static class RecursoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDescription, tvCategory;

        public RecursoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            tvCategory = itemView.findViewById(R.id.tv_category);
        }
    }
}
