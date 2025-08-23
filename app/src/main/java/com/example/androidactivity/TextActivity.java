package com.example.androidactivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TextActivity extends AppCompatActivity {

    TextView tvSaludo;
    TextView tvPresentacion;
    EditText myEditText;
    EditText editTextEmail;
    Button btnVolver;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvSaludo = findViewById(R.id.tvSaludo);
        tvPresentacion = findViewById(R.id.tvPresentacion);
        myEditText = findViewById(R.id.myEditText);
        editTextEmail = findViewById(R.id.editTextEmail);
        btnVolver = findViewById(R.id.btnVolver);




        tvSaludo.setText("Hola esta es mi Tarea de Programacion ");
        tvPresentacion.setText("Bienvenidos a mi Tarea de Programacion 2");
        myEditText.setText("");
        editTextEmail.setText("");

        btnVolver.setOnClickListener(v->{
            finish();
                });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });
    }
}