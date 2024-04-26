package com.example.projectakhir_loginwithsqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class TambahMahasiswa extends AppCompatActivity {

    private Spinner spinnerGender;
    private EditText editTextNama, editTextNim, editTextTanggalLahir, editTextAlamat;
    private Button btn_simpan;

    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_mahasiswa);

        // Inisialisasi views
        spinnerGender = findViewById(R.id.spinner_jenis_kelamin);
        editTextNama = findViewById(R.id.edit_nama);
        editTextNim = findViewById(R.id.edit_nim);
        editTextTanggalLahir = findViewById(R.id.edit_tanggal_lahir);
        editTextAlamat = findViewById(R.id.edit_alamat);
        btn_simpan = findViewById(R.id.btn_simpan);

        // Inisialisasi DatabaseHelper
        databaseHelper = new DatabaseHelper(this);

        // Setup Spinner
        setupGenderSpinner();

        // Setup onClickListener untuk btn_simpan
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ambil data dari EditText dan Spinner
                String nama = editTextNama.getText().toString().trim();
                int nim = Integer.parseInt(editTextNim.getText().toString().trim());
                int tanggal_lahir = Integer.parseInt(editTextTanggalLahir.getText().toString().trim());
                String jenis_kelamin = spinnerGender.getSelectedItem().toString();
                String alamat = editTextAlamat.getText().toString().trim();

                // Panggil fungsi insertDataCrud dari DatabaseHelper
                boolean isSuccess = databaseHelper.insertDataCrud(nim, nama, tanggal_lahir, jenis_kelamin, alamat);

                // Berikan respons berdasarkan hasil operasi penyisipan data
                if (isSuccess) {
                    Toast.makeText(TambahMahasiswa.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                    // Reset EditText setelah penyimpanan berhasil
                    editTextNama.setText("");
                    editTextNim.setText("");
                    editTextTanggalLahir.setText("");
                    editTextAlamat.setText("");
                    Intent intent = new Intent(TambahMahasiswa.this, LihatMahasiswa.class);

                    startActivity(intent);
                } else {
                    Toast.makeText(TambahMahasiswa.this, "Gagal menyimpan data", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void setupGenderSpinner() {
        // Implementasi Anda untuk setup spinner
    }
}