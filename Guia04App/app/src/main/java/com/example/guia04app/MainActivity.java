package com.example.guia04app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText txt1;
    private EditText txt2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt1=(EditText)findViewById(R.id.txt1);
        txt2=(EditText)findViewById(R.id.txt2);



    }
    public void segundaActividad (View v) {
        Intent i=new Intent(this, Actividad2.class);
        i.putExtra("txtNombre", txt1.getText().toString());
        i.putExtra("txtEdad", txt2.getText().toString());
        startActivity(i);
    }
}