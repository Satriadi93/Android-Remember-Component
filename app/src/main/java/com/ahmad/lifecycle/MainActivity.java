package com.ahmad.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText komentar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
        komentar = findViewById(R.id.komentar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        SharedPreferences komentarPrefences = this.getSharedPreferences("lifecycle", Context.MODE_PRIVATE);
        String saveComment = komentarPrefences.getString("Komentar", "");
        komentar.setText(saveComment);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        SharedPreferences.Editor dataSave = this.getSharedPreferences("lifecycle", Context.MODE_PRIVATE).edit();
        dataSave.putString("Komentar", komentar.getText().toString());
        dataSave.apply();
    }
}