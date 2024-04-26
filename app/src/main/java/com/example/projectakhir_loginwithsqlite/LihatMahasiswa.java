package com.example.projectakhir_loginwithsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class LihatMahasiswa extends AppCompatActivity {

    public class Mahasiswa {
        private ListView listViewMahasiswa;
        private MahasiswaAdapter mahasiswaAdapter;
        private DatabaseHelper databaseHelper;


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_mahasiswa);

        ImageButton btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang akan dijalankan ketika ImageButton btnBack di klik
                finish(); // Menutup activity saat tombol back diklik
            }
        });

        // Mendapatkan referensi ke ImageButton btnTambah
        ImageButton btnTambah = findViewById(R.id.btnTambah);
        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang akan dijalankan ketika ImageButton btnTambah di klik
                Intent intent = new Intent(LihatMahasiswa.this, TambahMahasiswa.class);
                startActivity(intent); // Memulai activity TambahMahasiswa
            }
        });
    }

    // Metode ini akan dipanggil ketika ImageButton btnBack di klik
    public void onBackButtonClick(View view) {
        finish(); // Menutup activity saat tombol back di klik
    }
}

