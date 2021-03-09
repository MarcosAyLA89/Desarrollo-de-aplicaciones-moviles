package com.example.guia4ejercicio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    private TextView lbl1;
    private TextView lbl2;
    private TextView lbl3;
    private TextView lbl4;
    private TextView lbl5;

    private TextView lbl6;
    private TextView lbl7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        lbl1=(TextView)findViewById(R.id.lbl_nominal);
        lbl2=(TextView)findViewById(R.id.lbl_isss);
        lbl3=(TextView)findViewById(R.id.lbl_afp);
        lbl4=(TextView)findViewById(R.id.lbl_renta);
        lbl5=(TextView)findViewById(R.id.lbl_neto);

        lbl6=(TextView)findViewById(R.id.lbl_nombre2);
        lbl7=(TextView)findViewById(R.id.lbl_horas2);


        Bundle bundle = getIntent().getExtras();


        lbl6.setText("Nombre: "+bundle.getString("nombre"));

        lbl7.setText("Horas: "+bundle.getString("horas"));


        lbl1.setText("Salario inicial: "+bundle.getString("salario_inicial"));

        lbl2.setText("ISSS: "+bundle.getString("isss"));

        lbl3.setText("AFP:"+bundle.getString("afp"));

        lbl4.setText("RENTA: "+bundle.getString("renta"));

        lbl5.setText("Salario Neto: "+bundle.getString("salario_neto"));

    }
}