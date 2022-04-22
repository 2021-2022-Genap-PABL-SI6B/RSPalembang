package com.si6b.rspalembang.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.si6b.rspalembang.R;

public class UbahActivity extends AppCompatActivity {
    private String yId, yNama, yAlamat, yTelepon;
    private EditText etNama, etAlamat, etTelepon;
    private Button btnUbah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        Intent intent = getIntent();
        yId = intent.getStringExtra("xId");
        yNama = intent.getStringExtra("xNama");
        yAlamat = intent.getStringExtra("xAlamat");
        yTelepon = intent.getStringExtra("xTelepon");

        etNama = findViewById(R.id.et_nama);
        etAlamat = findViewById(R.id.et_alamat);
        etTelepon = findViewById(R.id.et_telepon);
        btnUbah = findViewById(R.id.btn_ubah);

        etNama.setText(yNama);
        etAlamat.setText(yAlamat);
        etTelepon.setText(yTelepon);
    }
}