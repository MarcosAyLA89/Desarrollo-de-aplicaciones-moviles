package com.example.ejercicio01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2, edt3;
    private TextView tvres, tvres2;
    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("0.00", simbolos);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.txta);
        edt2 = (EditText)findViewById(R.id.txtb);
        edt3 = (EditText)findViewById(R.id.txtc);
        tvres = (TextView)findViewById(R.id.tvResultado);
        tvres2 = (TextView)findViewById(R.id.tvresultado2);
    }

    public void Calcular(View view){
        String valora = edt1.getText().toString();
        String valorb = edt2.getText().toString();
        String valorc = edt3.getText().toString();

        if (valora.length() == 0 || valorb.length() == 0 || valorc.length() == 0)
            Toast.makeText(this,"No pueden haber campos en blanco.", Toast.LENGTH_SHORT).show();
        else{
            int a = Integer.parseInt(valora);
            int b = Integer.parseInt(valorb);
            int c = Integer.parseInt(valorc);

            double radical = Math.pow(b, 2) - 4*a*c;
            int denominador = 2*a;
            if (radical < 0.0)
                Toast.makeText(this,"La solución podría tener raíces complejas, verifique sus valores.", Toast.LENGTH_SHORT).show();
            else if (denominador == 0)
                Toast.makeText(this,"El valor de 'a' no puede ser cero", Toast.LENGTH_SHORT).show();
            else{
                double x1 = (-b + radical) / denominador;
                double x2 = (-b - radical) / denominador;
                tvres.setText("La raíz X1 es: " + String.valueOf(df.format(x1)));
                tvres2.setText("La raíz X2 es: " + String.valueOf(df.format(x2)));
            }
        }
    }
}