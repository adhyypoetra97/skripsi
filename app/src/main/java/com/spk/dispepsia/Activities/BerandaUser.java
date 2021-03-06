package com.spk.dispepsia.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.spk.dispepsia.R;

public class BerandaUser extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView nama_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda_user);

        sharedPreferences = getSharedPreferences("user_details", MODE_PRIVATE);
        String nik = sharedPreferences.getString("nik",null);
        String nama = getIntent().getStringExtra("user");
        nama_user = findViewById(R.id.txt_nama_user);
        nama_user.setText(nama);

    }

    public void keluar(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.app_name)
                .setMessage("Anda yakin ingin logout?")
                .setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.clear();
                        editor.apply();
                        startActivity(new Intent(BerandaUser.this, MainActivity.class));
                        finish();
                    }
                })
                .show();
    }

    public void ProfilUSer(View view){
        Intent intent = new Intent(BerandaUser.this, ProfileUser.class);
        intent.putExtra("nik", getIntent().getStringExtra("nik"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }

    public void diagnosa(View view){
        Intent intent = new Intent(BerandaUser.this, Diagnosa.class);
        intent.putExtra("nik", getIntent().getStringExtra("nik"));
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
}