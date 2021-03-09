package com.example.guia4ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private EditText horas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        nombre=(EditText)findViewById(R.id.lbl_nombre);
        horas=(EditText)findViewById(R.id.lbl_horas);



    }

    public void Enviar (View view)
    {
        int hora=Integer.parseInt(horas.getText().toString());


        if(hora<=0)
        {
            Toast.makeText(this,"Ingresar un numero valido",Toast.LENGTH_SHORT).show();
        }
        else

        {
        double totalxhora=hora*8.5;

        double isss=totalxhora*0.02;

        double afp=totalxhora*0.03;

        double renta=totalxhora*0.04;


        double salarioneto=totalxhora-(isss+afp+renta);


        Intent i=new Intent(this, resultados.class);
        i.putExtra("nombre",String.valueOf(nombre.getText()));
        i.putExtra("horas",String.valueOf(horas.getText()));
        i.putExtra("salario_inicial",String.valueOf(totalxhora));
        i.putExtra("isss",String.valueOf(isss));
        i.putExtra("afp",String.valueOf(afp));
        i.putExtra("renta",String.valueOf(renta));
        i.putExtra("salario_neto",String.valueOf(salarioneto));

        startActivity(i);
       }
    }
}