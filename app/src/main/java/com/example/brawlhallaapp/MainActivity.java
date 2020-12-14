package com.example.brawlhallaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.brawlhallaapp.legends.LegendsActivity;

public class MainActivity extends AppCompatActivity {






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button legendsButton = (Button) findViewById(R.id.legendsButton);
        legendsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent legendsIntent = new Intent(MainActivity.this, LegendsActivity.class);
                startActivity(legendsIntent);
            }
        });

    }
}