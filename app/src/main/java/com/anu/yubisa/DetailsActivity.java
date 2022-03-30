package com.anu.yubisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageButton kurang, tambah;
    TextView tv;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        kurang = findViewById(R.id.btn_10);
        tambah = findViewById(R.id.btn_11);
        tv = findViewById(R.id.textView13);

        tambah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                count++;
                tv.setText(count + "");

            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                count--;
                tv.setText(count + "");

            }
        });
    }
}