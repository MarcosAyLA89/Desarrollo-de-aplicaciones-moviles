package com.example.ejercicioconradiobutton;

import androidx.annotation.IntegerRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private RadioButton suma_rdbt;
    private RadioButton resta_rdbt;
    private RadioButton multiplicacion_rdbt;
    private RadioButton division_rdbt;
    private EditText n1;
    private EditText n2;
    private TextView resultadoTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//se castea el tipo de dato del view
        suma_rdbt=(RadioButton)findViewById(R.id.suma_rdbt);
        resta_rdbt=(RadioButton)findViewById(R.id.restar_rdbt);
        multiplicacion_rdbt=(RadioButton)findViewById(R.id.multiplicar_rdbt);
        division_rdbt=(RadioButton)findViewById(R.id.dividir_rdbt);
        n1=(EditText)findViewById(R.id.text1);
        n2=(EditText)findViewById(R.id.text2);

        resultadoTxt=(TextView)findViewById(R.id.result_txt);
    }

    public void calcular(View view)
    {
        String text1=String.valueOf(n1.getText());
        String text2=String.valueOf(n2.getText());

        float text1_int= Float.parseFloat(text1);
        float text2_int= Float.parseFloat(text2);
        float resultado=0;
        if(suma_rdbt.isChecked()==true)
        {
            resultado=text1_int+text2_int;
        }
        else if(resta_rdbt.isChecked()==true)
        {
            resultado=text1_int-text2_int;
        }
        else if(multiplicacion_rdbt.isChecked()==true)
        {
            resultado=text1_int*text2_int;

        }
        else
        {
            if(text2_int==0)
            {
                Toast.makeText(this,"No se puede dividir entre 0",Toast.LENGTH_SHORT).show();
            }
            else
            {
                resultado=text1_int/text2_int;
            }

        }
       resultadoTxt.setText("El resultado es: "+String.valueOf(resultado));


    }
}