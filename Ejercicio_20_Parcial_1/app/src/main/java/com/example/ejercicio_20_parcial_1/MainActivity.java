package com.example.ejercicio_20_parcial_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText)findViewById(R.id.txt_years);
        txt2=(EditText)findViewById(R.id.txt_salary);

    }

    public void Calcular(View view)
    {
        String string_txt1=txt1.getText().toString();
        String string_txt2=txt2.getText().toString();


        int years=Integer.parseInt(string_txt1);
        double salario=Double.parseDouble(string_txt2);

        if(years<=0 || salario<=0)
        {
            Toast.makeText(this,"Ingresar una cantidad positiva",Toast.LENGTH_LONG).show();
        }
       else
        {
             if(salario<100)
        {
            Toast.makeText(this,"Ingresar un salario mayor a 100",Toast.LENGTH_LONG).show();
        }
             else
             {
              EnviarDatos(years,salario);
             }
        }
    }

    private void EnviarDatos(int years,double salario)
    {
        double salarionuevo=0;
        if(salario<500 && years>=10)
        {
            salarionuevo=(salario*0.2)+salario;
        }
        else if(salario<500 && years<10)
        {
            salarionuevo=(salario*0.05)+salario;
        }
        else if(salario>=500)

        {
            salarionuevo=salario;
        }

        Intent i=new Intent(this,Activity2.class);

        i.putExtra("Salario",String.valueOf(salario));
        i.putExtra("NewSalario",String.valueOf(salarionuevo));

        startActivity(i);


    }
}