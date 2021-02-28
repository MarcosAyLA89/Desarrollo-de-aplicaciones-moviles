package com.example.ejercicio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edt1, edt2, edt3;
    private Spinner spn1;
    private Button btn1, btn2;
    private String[] nombres = new String[3];
    private  String[] apellidos = new String[3];
    private  String[] cargog = new String[3];
    private int[] hora = new int[3];
    int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt1 = (EditText)findViewById(R.id.txtnombres);
        edt2 = (EditText)findViewById(R.id.txtapellidos);
        edt3 = (EditText)findViewById(R.id.txthoras);
        spn1 = (Spinner)findViewById(R.id.spinner);
        btn1 = (Button)findViewById(R.id.btnCalcular);
        btn2 = (Button)findViewById(R.id.btnIngresar);
        btn1.setEnabled(false);

        String[] opciones = {"Gerente", "Asistente", "Secretaria", "Ordenanza", "Vigilante", "Vendedor"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_modify, opciones);
        spn1.setAdapter(adapter);
    }

    public void Ingresar(View view){
        String valor1 = edt1.getText().toString();
        String valor2 = edt2.getText().toString();
        String valor3 = edt3.getText().toString();
        String cargo = spn1.getSelectedItem().toString();

        if (valor1.length() == 0 || valor2.length() == 0 || valor3.length() == 0)
            Toast.makeText(this,"No pueden haber campos en blanco.",Toast.LENGTH_SHORT).show();
        else{
            int hour = Integer.parseInt(valor3);
            if (hour <= 0)
                Toast.makeText(this,"No pueden haber horas negativas o iguales a cero.",Toast.LENGTH_SHORT).show();
            else{
                if (contador < 3){
                    nombres[contador] = valor1;
                    apellidos[contador] = valor2;
                    hora[contador] = Integer.parseInt(valor3);
                    cargog[contador] = cargo;
                    contador++;
                    edt1.setText("");
                    edt2.setText("");
                    edt3.setText("");
                    if (contador == 3){
                        btn1.setEnabled(true);
                        btn2.setEnabled(false);
                        edt1.setText("");
                        edt2.setText("");
                        edt3.setText("");
                        Toast.makeText(this,"Prosiga dando click en Calcular, porfavor.",Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(this,"Ingrese al siguiente empleado.",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    public void Calcular(View view){
        double[] sueldoBase = new double[3];
        int[] horasMayor = new int[3];
        double[] sueldoLiquido = new double[3];
        double[] descuentosE1 = new double[3];
        double[] descuentosE2 = new double[3];
        double[] descuentosE3 = new double[3];
        double[] bonos = new double[3];

        if (hora[0] > 160) {
            horasMayor[0] = hora[0] - 160;
            sueldoBase[0] = 160*9.75 + horasMayor[0]*11.50;
        }else if (hora[0] <= 160){
            sueldoBase[0] = hora[0]*9.75;
        }
        if (hora[1] > 160) {
            horasMayor[1] = hora[1] - 160;
            sueldoBase[1] = 160*9.75 + horasMayor[1]*11.50;
        }else if (hora[1] <= 160){
            sueldoBase[1] = hora[1]*9.75;
        }
        if (hora[2] > 160) {
            horasMayor[2] = hora[2] - 160;
            sueldoBase[2] = 160*9.75 + horasMayor[2]*11.50;
        }else if (hora[2] <= 160){
            sueldoBase[2] = hora[2]*9.75;
        }
        descuentosE1[0] = sueldoBase[0]*0.0525;
        descuentosE1[1] = sueldoBase[0]*0.0688;
        descuentosE1[2] = sueldoBase[0]*0.1;
        descuentosE2[0] = sueldoBase[1]*0.0525;
        descuentosE2[1] = sueldoBase[1]*0.0688;
        descuentosE2[2] = sueldoBase[1]*0.1;
        descuentosE3[0] = sueldoBase[2]*0.0525;
        descuentosE3[1] = sueldoBase[2]*0.0688;
        descuentosE3[2] = sueldoBase[2]*0.1;
        sueldoLiquido[0] = sueldoBase[0] - (sueldoBase[0]*0.0525 + sueldoBase[0]*0.0688 + sueldoBase[0]*0.1);
        sueldoLiquido[1] = sueldoBase[1] - (sueldoBase[1]*0.0525 + sueldoBase[1]*0.0688 + sueldoBase[1]*0.1);
        sueldoLiquido[2] = sueldoBase[2] - (sueldoBase[2]*0.0525 + sueldoBase[2]*0.0688 + sueldoBase[2]*0.1);

        if (cargog[0].equals("Gerente") && cargog[1].equals("Asistente") && cargog[2].equals("Secretaria")){
            bonos[0] = 0.0;
            bonos[1] = 0.0;
            bonos[2] = 0.0;
        }else{
            if(cargog[0].equals("Gerente")){
                bonos[0] = sueldoLiquido[0]*0.1 + sueldoLiquido[0];
            }else if(cargog[0].equals("Asistente")){
                bonos[0] = sueldoLiquido[0]*0.05 + sueldoLiquido[0];
            }else if(cargog[0].equals("Secretaria")){
                bonos[0] = sueldoLiquido[0]*0.03 + sueldoLiquido[0];
            }else{
                bonos[0] = sueldoLiquido[0]*0.02 + sueldoLiquido[0];
            }

            if(cargog[1].equals("Gerente")){
                bonos[1] = sueldoLiquido[1]*0.1 + sueldoLiquido[1];
            }else if(cargog[1].equals("Asistente")){
                bonos[1] = sueldoLiquido[1]*0.05 + sueldoLiquido[1];
            }else if(cargog[1].equals("Secretaria")){
                bonos[1] = sueldoLiquido[1]*0.03 + sueldoLiquido[1];
            }else{
                bonos[1] = sueldoLiquido[1]*0.02 + sueldoLiquido[1];
            }

            if(cargog[2].equals("Gerente")){
                bonos[2] = sueldoLiquido[2]*0.1 + sueldoLiquido[2];
            }else if(cargog[2].equals("Asistente")){
                bonos[2] = sueldoLiquido[2]*0.05 + sueldoLiquido[2];
            }else if(cargog[2].equals("Secretaria")){
                bonos[2] = sueldoLiquido[2]*0.03 + sueldoLiquido[2];
            }else{
                bonos[2] = sueldoLiquido[2]*0.02 + sueldoLiquido[2];
            }
        }

        Bundle data = new Bundle();

        data.putDouble("sl1", sueldoLiquido[0]);
        data.putDouble("sl2", sueldoLiquido[1]);
        data.putDouble("sl3", sueldoLiquido[2]);

        data.putDouble("d1e1", descuentosE1[0]);
        data.putDouble("d2e1", descuentosE1[1]);
        data.putDouble("d3e1", descuentosE1[2]);

        data.putDouble("d1e2", descuentosE2[0]);
        data.putDouble("d2e2", descuentosE2[1]);
        data.putDouble("d3e2", descuentosE2[2]);

        data.putDouble("d1e3", descuentosE3[0]);
        data.putDouble("d2e3", descuentosE3[1]);
        data.putDouble("d3e3", descuentosE3[2]);

        data.putDouble("be1", bonos[0]);
        data.putDouble("be2", bonos[1]);
        data.putDouble("be3", bonos[2]);

        data.putString("ne1",nombres[0]);
        data.putString("ne2",nombres[1]);
        data.putString("ne3",nombres[2]);

        data.putString("ae1",apellidos[0]);
        data.putString("ae2",apellidos[1]);
        data.putString("ae3",apellidos[2]);

        data.putString("ce1",cargog[0]);
        data.putString("ce2",cargog[1]);
        data.putString("ce3",cargog[2]);

        Intent i = new Intent(this,ShowData.class);
        i.putExtras(data);
        startActivity(i);
    }
}