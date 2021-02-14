package com.example.guia3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private TextView resultado_lbl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLifecycle().addObserver(new MyLifeCycleObserver());
        setContentView(R.layout.activity_main);

        resultado_lbl=(TextView)findViewById(R.id.label_result);
        resultado_lbl.setText("0");
    }

    public void Sumar(View view)
    {
        String numero_string=resultado_lbl.getText().toString();
        int numero=Integer.parseInt(numero_string);

        if(numero==9)
        {
            numero=0;
        }
        else
        {
            numero=numero+1;
        }
        resultado_lbl.setText(String.valueOf(numero));
    }
}