package com.example.JunSen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class homeactivity extends AppCompatActivity {
    Button btnLogout,btnsel,btnbuy,delete;
    FirebaseAuth mFirebaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeactivity);

        btnLogout = findViewById(R.id.logout);
        btnsel = findViewById(R.id.seller);
        btnbuy = findViewById(R.id.buyer);
        delete = findViewById(R.id.del);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intToMain = new Intent(homeactivity.this,MainActivity.class);
                startActivity(intToMain);

            }
        });
       btnsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToSeller = new Intent(homeactivity.this,selleractivity.class);
                startActivity(intToSeller);

            }
        });
        btnbuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intToBuyer = new Intent(homeactivity.this,buyeractivity.class);
                startActivity(intToBuyer);
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intTodel = new Intent(homeactivity.this,delete.class);
                startActivity(intTodel);
            }
        });

    }
}
