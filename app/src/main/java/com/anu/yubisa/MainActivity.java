package com.anu.yubisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText input_uang;
    Button rp_usd, rp_euro, rp_yen;
    TextView hasil_konversi;
    ImageButton logout;

    double angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        input_uang = (EditText) findViewById(R.id.uang_input);
        rp_usd = (Button) findViewById(R.id.rpusd);
        rp_euro = (Button) findViewById(R.id.rpeuro);
        rp_yen = (Button) findViewById(R.id.rpyen);
        hasil_konversi = (TextView) findViewById(R.id.hasil_konversi);
        logout = (ImageButton)findViewById(R.id.btn_logout);

        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false) {
            Intent loginIntent = new Intent(MainActivity.this, Login.class);
            startActivity(loginIntent);
            finish();
        }

        // logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                if (updtSession == true) {
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });
    }



    public boolean cek(){
        if (input_uang.getText().toString().isEmpty()){
            Toast.makeText(this, "Silahkan masukan jumlah uang", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    public void toYEN(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception ex){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 132;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil));
        Toast.makeText(this, "1 Yen = Rp 132", Toast.LENGTH_SHORT).show();
    }

    public void toEuro(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 17228;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil));
        Toast.makeText(this, "1 Euro = Rp 17.228", Toast.LENGTH_SHORT).show();
    }



    public void toUSD(View v){
        if (!cek()){
            return;
        }

        try{
            angka = Double.parseDouble(input_uang.getText().toString());
        }catch(Exception e){
            Toast.makeText(this, "Masukkan angka", Toast.LENGTH_SHORT).show();
        }

        double hasil = angka / 14808;
        hasil_konversi.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil));
        Toast.makeText(this, "1 U$D = Rp 14808", Toast.LENGTH_SHORT).show();
    }
}

    /*DatabaseHelper db;
    Button logout, home, tes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);
        home = (Button)findViewById(R.id.btn_menu);
        logout = (Button)findViewById(R.id.btn_logout);
        tes = (Button)findViewById(R.id.btn_tes);


        Boolean checkSession = db.checkSession("ada");
        if (checkSession == false) {
            Intent loginIntent = new Intent(MainActivity.this, Login.class);
            startActivity(loginIntent);
            finish();
        }

        // logout
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean updtSession = db.upgradeSession("kosong", 1);
                if (updtSession == true) {
                    Toast.makeText(getApplicationContext(), "Berhasil Keluar", Toast.LENGTH_SHORT).show();
                    Intent loginIntent = new Intent(MainActivity.this, Login.class);
                    startActivity(loginIntent);
                    finish();
                }
            }
        });

        Menu
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainActivity.this,MainMain.class);
                startActivity(home);
            }
        });



    }
}*/
