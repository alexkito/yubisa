package com.anu.yubisa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    ImageButton kurang, tambah;
    TextView jumlah, harga;
    int count, total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        kurang = findViewById(R.id.btn_10);
        tambah = findViewById(R.id.btn_11);
        jumlah = findViewById(R.id.textView13);
        harga = findViewById(R.id.textView14);
        String price = harga.getText().toString();
        int price2 = Integer.parseInt(price);

        tambah.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                count++;
                total = price2 * count;
                jumlah.setText(Integer.toString(count));
                harga.setText(Integer.toString(total));
            }
        });

        kurang.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view){
                count--;
                total = price2 * count;
                jumlah.setText(count + "");
                harga.setText(total + "");
            }
        });
    }
}