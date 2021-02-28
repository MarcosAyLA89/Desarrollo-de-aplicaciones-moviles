package com.example.ejercicio_2_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edid_txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edid_txt1=(EditText)findViewById(R.id.txt1);

    }

    public void EnviarDatos(View view)
    {

        String datos=edid_txt1.getText().toString();
        String votos[]=datos.split(",",0);



        double sum1=0;
        double sum2=0;
        double sum3=0;
        double sum4=0;


        double porcentaje1=0;
        double porcentaje2=0;
        double porcentaje3=0;
        double porcentaje4=0;

        double totalvotos=0;
   //    Toast notifiacion= Toast.makeText(this,"El tamaño es:"+String.valueOf(votos.length),Toast.LENGTH_SHORT);
     //  notifiacion.show();

       for(int i=0;i<votos.length;i++)

       {
           double numero=Double.parseDouble(votos[i]);
           if(numero==1)
           {
               sum1++;
           }
           else if(numero==2)
           {
               sum2++;
           }
           else if(numero==3)
           {
               sum3++;
           }
           else if(numero==4)
           {
               sum4++;
           }
           else
           {

           }
       }

       totalvotos=sum1+sum2+sum3+sum4;
       porcentaje1=Math.round(((sum1/totalvotos)*100));
        porcentaje2=Math.round(((sum2/totalvotos)*100));
        porcentaje3=Math.round(((sum3/totalvotos)*100));
        porcentaje4=Math.round(((sum4/totalvotos)*100));



        Intent i=new Intent(this,Resultados.class);

        i.putExtra("candidato1",String.valueOf(String.valueOf(porcentaje1)));
        i.putExtra("candidato2",String.valueOf(String.valueOf(porcentaje2)));
        i.putExtra("candidato3",String.valueOf(String.valueOf(porcentaje3)));
        i.putExtra("candidato4",String.valueOf(String.valueOf(porcentaje4)));

        startActivity(i);
    }
}