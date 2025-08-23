package com.example.androidactivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtMenu;
    Button btnAct1, btnAct2, btnAct3, btnAct4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        btnAct1 = findViewById(R.id.btnAct1);
        btnAct2 = findViewById(R.id.btnAct2);
        btnAct3 = findViewById(R.id.btnAct3);
        btnAct4 = findViewById(R.id.btnAct4);
        txtMenu = findViewById(R.id.txtMenu);

        btnAct1.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, TextActivity.class);
            startActivity(intent);
        });

        btnAct2.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this, MainActivity2.class );
            startActivity(intent);
        });

        btnAct3.setOnClickListener(v ->{
            Intent intent = new Intent(MainActivity.this,WidgetsActivity.class );
            startActivity(intent);
        });

        btnAct4.setOnClickListener(v->{
            Intent intent = new Intent(MainActivity.this, ImageActivity.class);
            startActivity(intent);
                });

        txtMenu.setText("Bienvenidos a mi Tarea de Programacion 2");



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}