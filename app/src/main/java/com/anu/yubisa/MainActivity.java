package com.anu.yubisa;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
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

        //Menu
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(MainActivity.this,Home.class);
                startActivity(home);
            }
        });

    }
}
