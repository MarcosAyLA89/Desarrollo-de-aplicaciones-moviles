package com.example.ejercicio03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class General extends AppCompatActivity {
    private TextView tv1, tv2, tv3, tv4, tv5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);
        tv1 = (TextView)findViewById(R.id.tvMayor);
        tv2 = (TextView)findViewById(R.id.tvMenor);
        tv3 = (TextView)findViewById(R.id.tv300E1);
        tv4 = (TextView)findViewById(R.id.tv300E2);
        tv5 = (TextView)findViewById(R.id.tv300E3);

        Bundle data2 = this.getIntent().getExtras();
        String Maior = data2.getString("Mayor");
        String Menior = data2.getString("Menor");
        tv1.setText("Empleado con mayor salario: " + Maior);
        tv2.setText("Empleado con menor salario: " + Menior);

        for (int i = 0; i < 3; i++){
            if (i==0)
                tv3.setText(data2.getString("n" + String.valueOf(i)));
            if (i==1)
                tv4.setText(data2.getString("n" + String.valueOf(i)));
            if (i==2)
                tv5.setText(data2.getString("n" + String.valueOf(i)));
        }
    }

    public void Regresar(View view){
        finish();
    }
}