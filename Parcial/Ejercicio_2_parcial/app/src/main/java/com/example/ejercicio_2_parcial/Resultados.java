package com.example.ejercicio_2_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Resultados extends AppCompatActivity {


    private TextView lbl1;
    private TextView lbl2;
    private TextView lbl3;
    private TextView lbl4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados2);

lbl1=(TextView)findViewById(R.id.lbl1);
        lbl2=(TextView)findViewById(R.id.lbl2);
        lbl3=(TextView)findViewById(R.id.lbl3);
        lbl4=(TextView)findViewById(R.id.lbl4);

        Bundle datos=getIntent().getExtras();

        lbl1.setText("El porcentaje de votos del candidato 1 es de : "+datos.getString("candidato1")+"%");
        lbl2.setText("El porcentaje de votos del candidato 2 es de : "+datos.getString("candidato2")+"%");
        lbl3.setText("El porcentaje de votos del candidato 3 es de : "+datos.getString("candidato3")+"%");
        lbl4.setText("El porcentaje de votos del candidato 4 es de : "+datos.getString("candidato4")+"%");




    }
}