package com.accedeed.app.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.accedeed.app.R;
import com.accedeed.app.model.Mensaje;
import com.accedeed.app.utils.PreferenceManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MensajeAdapter extends RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder> {
    private List<Mensaje> mensajes;
    private static final int VIEW_TYPE_SENT = 1;
    private static final int VIEW_TYPE_RECEIVED = 2;

    public MensajeAdapter(List<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public int getItemViewType(int position) {
        // Determinar si el mensaje es enviado o recibido
        return VIEW_TYPE_SENT; // Por ahora todos son enviados
    }

    @NonNull
    @Override
    public MensajeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        int layoutId = (viewType == VIEW_TYPE_SENT) ? R.layout.item_mensaje_sent : R.layout.item_mensaje_received;
        View view = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new MensajeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MensajeViewHolder holder, int position) {
        Mensaje mensaje = mensajes.get(position);
        holder.tvMensaje.setText(mensaje.getTexto());
        
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        String hora = sdf.format(new Date(mensaje.getTimestamp()));
        holder.tvHora.setText(hora);
    }

    @Override
    public int getItemCount() {
        return mensajes.size();
    }

    static class MensajeViewHolder extends RecyclerView.ViewHolder {
        TextView tvMensaje, tvHora;

        MensajeViewHolder(@NonNull View itemView) {
            super(itemView);
            tvMensaje = itemView.findViewById(R.id.tv_mensaje);
            tvHora = itemView.findViewById(R.id.tv_hora);
        }
    }
}
