package com.accedeed.app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.model.Evento;

import java.util.List;

public class EventoAdapter extends RecyclerView.Adapter<EventoAdapter.EventoViewHolder> {
    private List<Evento> eventos;

    public EventoAdapter(List<Evento> eventos) {
        this.eventos = eventos;
    }

    @NonNull
    @Override
    public EventoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_evento, parent, false);
        return new EventoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventoViewHolder holder, int position) {
        Evento evento = eventos.get(position);
        holder.tvTitulo.setText(evento.getTitulo());
        holder.tvDescripcion.setText(evento.getDescripcion());
        holder.tvFecha.setText(evento.getFecha());
        holder.tvLugar.setText(evento.getLugar());
    }

    @Override
    public int getItemCount() {
        return eventos.size();
    }

    static class EventoViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitulo, tvDescripcion, tvFecha, tvLugar;

        EventoViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tv_titulo);
            tvDescripcion = itemView.findViewById(R.id.tv_descripcion);
            tvFecha = itemView.findViewById(R.id.tv_fecha);
            tvLugar = itemView.findViewById(R.id.tv_lugar);
        }
    }
}
