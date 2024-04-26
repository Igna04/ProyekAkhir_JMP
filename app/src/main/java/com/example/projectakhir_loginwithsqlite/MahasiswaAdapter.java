package com.example.projectakhir_loginwithsqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MahasiswaAdapter extends RecyclerView.Adapter<MahasiswaAdapter.ViewHolder> {
    private List<MahasiswaModel> mahasiswaList;
    private Context context;

    public MahasiswaAdapter(Context context, List<MahasiswaModel> mahasiswaList) {
        this.context = context;
        this.mahasiswaList = mahasiswaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mahasiswa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MahasiswaModel mahasiswa = mahasiswaList.get(position);
        holder.tvNama.setText(mahasiswa.getNama());
        holder.tvNim.setText(mahasiswa.getNim());
        holder.tvTanggal_lahir.setText(mahasiswa.getTanggal_lahir());
        holder.tvJenis_kelamin.setText(mahasiswa.getJenis_kelamin());
        holder.tvALamat.setText(mahasiswa.getAlamat());

    }

    @Override
    public int getItemCount() {
        return mahasiswaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNama, tvNim, tvTanggal_lahir, tvJenis_kelamin, tvALamat;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvTanggal_lahir = itemView.findViewById(R.id.tvTanggal_lahir);
            tvJenis_kelamin = itemView.findViewById(R.id.tvJenis_kelamin);
            tvALamat = itemView.findViewById(R.id.tvALamat);
        }
    }
}

