package com.example.androidactivity;

import android.os.Bundle;
import android.content.Intent;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AppCompatDelegate;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    ToggleButton tgOn_Off;
    FloatingActionButton btFloat;
    ImageButton imgBotton;
    Button btnSaludo, btnRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        tgOn_Off = findViewById(R.id.tgOn_Off);
        btFloat = findViewById(R.id.btFloat);
        imgBotton = findViewById(R.id.imgBotton);
        btnSaludo = findViewById(R.id.btnSaludo);
        btnRegresar = findViewById(R.id.btnRegresar);

        btnRegresar.setOnClickListener(v->{
            finish();
                });

        btnSaludo.setOnClickListener(v ->{
            Toast.makeText(this, "Hola app de Edwins", Toast.LENGTH_SHORT).show();
        });

        imgBotton.setOnClickListener(v ->{
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if (intent.resolveActivity(getPackageManager()) != null){
                startActivity(intent);
            }else{
                Toast.makeText(this,"No hay aplicacion de camara disponible", Toast.LENGTH_SHORT).show();
            }
        });

        btFloat.setOnClickListener(v ->{
            Toast.makeText(this,"FAB presionado", Toast.LENGTH_SHORT).show();
        });


        tgOn_Off.setOnCheckedChangeListener((buttonView, isChecked) ->  {
            AppCompatDelegate.setDefaultNightMode(
                    isChecked ? AppCompatDelegate.MODE_NIGHT_YES
                            : AppCompatDelegate.MODE_NIGHT_NO
            );

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}