package com.example.ejerciciopractica10_02_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;

public class Acivity2 extends AppCompatActivity {
private TextView resultado_lbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acivity2);

        Bundle datos=getIntent().getExtras();


        resultado_lbl=(TextView)findViewById(R.id.result_label);
        int numero= Integer.parseInt(datos.getString("Numero"));

        String resultado_String="";
        for (int i=1;i<11;i++)
        {
            int producto;
            producto=numero*i;
            resultado_String+=String.valueOf(numero)+" * "+ String.valueOf(i)+" = "+String.valueOf(producto)+" \n";
        }

        resultado_lbl.setText(resultado_String);
        resultado_lbl.setGravity(Gravity.CENTER);
    }
}