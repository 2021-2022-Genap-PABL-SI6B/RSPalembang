package com.si6b.rspalembang.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.si6b.rspalembang.Model.ModelRumahSakit;
import com.si6b.rspalembang.R;

import java.util.List;

public class AdapterRumahSakit extends RecyclerView.Adapter<AdapterRumahSakit.HolderData> {
    private Context ctx;
    private List<ModelRumahSakit> listRumahSakit;

    public AdapterRumahSakit(Context ctx, List<ModelRumahSakit> listRumahSakit) {
        this.ctx = ctx;
        this.listRumahSakit = listRumahSakit;
    }

    @NonNull
    @Override
    public HolderData onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_rumah_sakit, parent, false);
        HolderData holder = new HolderData(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderData holder, int position) {
        ModelRumahSakit MRS = listRumahSakit.get(position);

        holder.tvNama.setText(MRS.getNama());
        holder.tvAlamat.setText(MRS.getAlamat());
        holder.tvTelepon.setText(MRS.getTelepon());
        Glide.with(ctx)
                .load(MRS.getFoto())
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.ivRumahSakit);
    }

    @Override
    public int getItemCount() {
        return listRumahSakit.size();
    }

    public class HolderData extends RecyclerView.ViewHolder {
        TextView tvNama, tvAlamat, tvTelepon;
        ImageView ivRumahSakit;

        public HolderData(@NonNull View itemView) {
            super(itemView);

            tvNama = itemView.findViewById(R.id.tv_nama);
            tvAlamat = itemView.findViewById(R.id.tv_alamat);
            tvTelepon = itemView.findViewById(R.id.tv_telepon);
            ivRumahSakit = itemView.findViewById(R.id.iv_rumah_sakit);
        }
    }

}
