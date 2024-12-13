package com.example.fishapp.ui.sale;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.fishapp.R;
import com.example.fishapp.ui.payment.payment;

public class sale_menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sale_menu);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        final ImageView destination = findViewById(R.id.destination_img);
        final TextView txt = findViewById(R.id.item);
        final TextView Bprice = findViewById(R.id.price);
        final Button buy = findViewById(R.id.buyNowBtn);

        String indian = getIntent().getStringExtra("price");
        String price = getIntent().getStringExtra("price");
        String kyenam = getIntent().getStringExtra("price");


        Bprice.setText(price);
        Bprice.setText(indian);
        Bprice.setText(kyenam);


        //indianprice.setText(indianprice);
        Toast.makeText(this, indian, Toast.LENGTH_SHORT).show();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int resId = bundle.getInt("resId");
            destination.setImageResource(resId);
        }

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), payment.class);
                startActivity(i);
            }
        });


    }
}