package com.example.androidactivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WidgetsActivity extends AppCompatActivity {

    TextView tvTerminos;
    CheckBox chAcepto;
    RadioButton rdButton1, rdButton2;
    Switch sw1;
    SeekBar seeBrillo;
    Button btnAtras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widgets);

        tvTerminos = findViewById(R.id.tvTerminos);
        chAcepto = findViewById(R.id.chAcepto);
        rdButton1 = findViewById(R.id.rdButton1);
        rdButton2 = findViewById(R.id.rdButton2);
        sw1 = findViewById(R.id.sw1);
        seeBrillo = findViewById(R.id.seeBrillo);
        btnAtras = findViewById(R.id.btnAtras);

        btnAtras.setOnClickListener(v->{
            finish();
                });

        seeBrillo.setProgress(125);

        seeBrillo.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                WindowManager.LayoutParams layout = getWindow().getAttributes();
                layout.screenBrightness = progress / 255f;
                getWindow().setAttributes(layout);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        sw1.setOnCheckedChangeListener((buttonView, isChecked)->{
            if (isChecked){
                Toast.makeText(this,"Notificaciones activadadas", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this,"Notificaciones desactivadas", Toast.LENGTH_SHORT).show();
            }
                });

        rdButton1.setOnClickListener(v ->{
                    Toast.makeText(this, "Seleccionastes Masculino", Toast.LENGTH_SHORT).show();
                });

        rdButton2.setOnClickListener(v ->{
                    Toast.makeText(this, "Seleccionates Femenino", Toast.LENGTH_SHORT).show();
                });

        chAcepto.setOnClickListener(v ->{
                    Toast.makeText(this, "¡Gracias por aceptar los terminos!", Toast.LENGTH_SHORT).show();
                });



        tvTerminos.setText("Aceptar terminos y condiciones");


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}