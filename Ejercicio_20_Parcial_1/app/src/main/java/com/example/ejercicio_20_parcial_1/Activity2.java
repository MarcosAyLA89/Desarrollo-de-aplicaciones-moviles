package com.example.ejercicio_20_parcial_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.TextView;
import android.os.Bundle;

public class Activity2 extends AppCompatActivity {

    private TextView lbl1;
    private TextView lbl2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle datos=getIntent().getExtras();

        lbl1=(TextView)findViewById(R.id.lbl_salario);
        lbl2=(TextView)findViewById(R.id.lbl_new_salario);


        lbl1.setText("Salario anterior: "+datos.getString("Salario"));
        lbl2.setText("Salario nuevo: "+datos.getString("NewSalario"));
    }
}