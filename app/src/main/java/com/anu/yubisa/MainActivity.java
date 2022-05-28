package com.anu.yubisa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;

    EditText edtNomor;
    ImageView btnKonversi, logout;
    TextView txtyen, txturo, txtusd, txtwon;
    double angka;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        edtNomor = findViewById(R.id.edtNomor);
        btnKonversi = findViewById(R.id.btnKonversi);
        txtyen = findViewById(R.id.txtyen);
        txturo = findViewById(R.id.txturo);
        txtusd = findViewById(R.id.txtusd);
        txtwon = findViewById(R.id.txtwon);
        logout = (ImageView) findViewById(R.id.btn_logout);

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


        btnKonversi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    int dec = Integer.parseInt(edtNomor.getText().toString());

                    //yen
                    try{
                        angka = Double.parseDouble(edtNomor.getText().toString());
                    }catch(Exception ex){
                    }
                    double hasil1 = angka/114;
                    txtyen.setText(NumberFormat.getCurrencyInstance(Locale.JAPAN).format(hasil1));

                    //euro
                    try{
                        angka = Double.parseDouble(edtNomor.getText().toString());
                    }catch(Exception ex){
                    }
                    double hasil2 = angka/15603;
                    txturo.setText(NumberFormat.getCurrencyInstance(Locale.GERMANY).format(hasil2));

                    //usd
                    try{
                        angka = Double.parseDouble(edtNomor.getText().toString());
                    }catch(Exception ex){
                    }
                    double hasil3 = angka/14510;
                    txtusd.setText(NumberFormat.getCurrencyInstance(Locale.US).format(hasil3));

                    //WON
                    try{
                        angka = Double.parseDouble(edtNomor.getText().toString());
                    }catch(Exception ex){
                    }
                    double hasil4 = angka/12;
                    txtwon.setText(NumberFormat.getCurrencyInstance(Locale.KOREA).format(hasil4));


                }catch (Exception e){
                    Toast.makeText(getApplicationContext(),"Berhasil !!!",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
