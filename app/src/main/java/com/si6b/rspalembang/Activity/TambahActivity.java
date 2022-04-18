package com.si6b.rspalembang.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.si6b.rspalembang.API.APIRequestData;
import com.si6b.rspalembang.API.RetroServer;
import com.si6b.rspalembang.Adapter.AdapterRumahSakit;
import com.si6b.rspalembang.Model.ModelResponse;
import com.si6b.rspalembang.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    private EditText etNama, etAlamat, etTelepon;
    private Button btnSimpan;
    private String nama, alamat, telepon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        etNama = findViewById(R.id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etTelepon = findViewById(R.id.et_telepon);
        btnSimpan = findViewById(R.id.btn_simpan);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nama = etNama.getText().toString();
                alamat = etAlamat.getText().toString();
                telepon = etTelepon.getText().toString();

                if(nama.trim().equals("")){
                    etNama.setError("Nama Harus Diisi");
                }
                else if(alamat.trim().equals("")){
                    etAlamat.setError("Alamat Harus Diisi");
                }
                else if(telepon.trim().equals("")){
                    etTelepon.setError("Telepon Harus Diisi");
                }
                else{
                    tambahRumahSakit();
                }
            }
        });
    }

    private void tambahRumahSakit(){
        APIRequestData API = RetroServer.konekRetrofit().create(APIRequestData.class);
        Call<ModelResponse> proses = API.ardCreate(nama, alamat, telepon);

        proses.enqueue(new Callback<ModelResponse>() {
            @Override
            public void onResponse(Call<ModelResponse> call, Response<ModelResponse> response) {
                int kode = response.body().getKode();
                String pesan = response.body().getPesan();

                Toast.makeText(TambahActivity.this, "Kode: "+kode+ "| Pesan: "+pesan, Toast.LENGTH_SHORT).show();
                finish();
            }

            @Override
            public void onFailure(Call<ModelResponse> call, Throwable t) {
                Toast.makeText(TambahActivity.this, "Gagal menghubungi server : " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}