package com.spk.dispepsia.Activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.spk.dispepsia.R;

public class MainActivity extends AppCompatActivity {
    private int countFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void keluar(View view) {
        new AlertDialog.Builder(this)
                .setIcon(R.mipmap.ic_launcher)
                .setTitle(R.string.app_name)
                .setMessage("Keluar Aplikasi?")
                .setPositiveButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                })
                .setNegativeButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                })
                .show();
    }

    public int getCountFragment() {
        return countFragment;
    }

    @Override
    public void onBackPressed() {
        int count = getCountFragment();

        if(count == 0) {
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            countFragment = (count-1);
        }
    }

    public void masuk(View view) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }

    public void tentang(View view) {
        startActivity(new Intent(getApplicationContext(), Tentang.class));
        finish();
    }
}