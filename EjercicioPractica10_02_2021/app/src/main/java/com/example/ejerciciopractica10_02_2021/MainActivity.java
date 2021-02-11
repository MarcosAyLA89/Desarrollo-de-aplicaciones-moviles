package com.example.ejerciciopractica10_02_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private EditText text1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text1=(EditText)findViewById(R.id.txt2);

    }

    public void Enviar(View view)
    {

         String txt1=text1.getText().toString();



        Intent i=new Intent(this,Acivity2.class);

        i.putExtra("Numero",txt1);

        startActivity(i);

    }
}