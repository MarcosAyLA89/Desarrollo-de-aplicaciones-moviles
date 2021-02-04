package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //se declaran las variables del tipo de elemento xml
    private EditText cantArt;
    private EditText priceTxt;
    private TextView tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cantArt=(EditText)findViewById(R.id.cantArt);
        priceTxt=(EditText)findViewById(R.id.price);
        tvTotal=(TextView)findViewById(R.id.tvTotal);
    }

    public void calcular(View view) {

        //primero se saca el string de las cajas de texto de las view
        String valor1= cantArt.getText().toString();
        String valor2= priceTxt.getText().toString();

        //luego se convierte a entero el string que se habia obtenido
        int art=Integer.parseInt(valor1);
        double price= Double.parseDouble(valor2);

        //luego que se tiene los datos en entero se realiza la operacion;
        double total = art*price;

        String resu=String.valueOf(total);

        tvTotal.setText("el total a pagar es: "+resu+" $");
        //toast sirve para mostrar mensajes emergentes
        Toast.makeText(this,"resultado: "+resu,Toast.LENGTH_SHORT).show();

        cantArt.setText("");
        priceTxt.setText("");


    }



}

