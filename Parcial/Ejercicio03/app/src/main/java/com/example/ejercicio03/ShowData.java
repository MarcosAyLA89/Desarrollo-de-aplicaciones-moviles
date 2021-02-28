package com.example.ejercicio03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ShowData extends AppCompatActivity {
    private Spinner spn2;
    private TextView tv1, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9;
    DecimalFormatSymbols simbolos = DecimalFormatSymbols.getInstance(Locale.ENGLISH);
    DecimalFormat df = new DecimalFormat("0.00", simbolos);
    double[] datos = new double[12];
    double[] bone = new double[3];
    String[] nombres = new String[3];
    String[] apellidos = new String[3];
    String[] cargos = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        spn2 = (Spinner)findViewById(R.id.spinner2);
        tv1 = (TextView)findViewById(R.id.tvnombres);
        tv2 = (TextView)findViewById(R.id.tvisss);
        tv3 = (TextView)findViewById(R.id.tvAFP);
        tv4 = (TextView)findViewById(R.id.tvRenta);
        tv5 = (TextView)findViewById(R.id.tvLiquido);
        tv6 = (TextView)findViewById(R.id.tvbono1);
        tv7 = (TextView)findViewById(R.id.tvbono2);
        tv8 = (TextView)findViewById(R.id.tvbono3);
        tv9 = (TextView)findViewById(R.id.tvLiquiTotal);

        String[] opciones = {"Empleado 1", "Empleado 2", "Empleado 3"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.spinner_item_modify2, opciones);
        spn2.setAdapter(adapter);

        Bundle data = this.getIntent().getExtras();
        datos[0] = data.getDouble("sl1");
        datos[1] = data.getDouble("d1e1");
        datos[2] = data.getDouble("d2e1");
        datos[3] = data.getDouble("d3e1");
        datos[4] = data.getDouble("sl2");
        datos[5] = data.getDouble("d1e2");
        datos[6] = data.getDouble("d2e2");
        datos[7] = data.getDouble("d3e2");
        datos[8] = data.getDouble("sl3");
        datos[9] = data.getDouble("d1e3");
        datos[10] = data.getDouble("d2e3");
        datos[11] = data.getDouble("d3e3");
        bone[0] = data.getDouble("be1");
        bone[1] = data.getDouble("be2");
        bone[2] = data.getDouble("be3");
        nombres[0] = data.getString("ne1");
        apellidos[0] = data.getString("ae1");
        nombres[1] = data.getString("ne2");
        apellidos[1] = data.getString("ae2");
        nombres[2] = data.getString("ne3");
        apellidos[2] = data.getString("ae3");
        cargos[0] = data.getString("ce1");
        cargos[1] = data.getString("ce2");
        cargos[2] = data.getString("ce3");
        tv1.setText("Nombres: " + nombres[0] + " " + apellidos[0]);
        tv2.setText("Descuento ISSS: $" + String.valueOf(df.format(datos[1])));
        tv3.setText("Descuento AFP: $" + String.valueOf(df.format(datos[2])));
        tv4.setText("Descuento Renta: $" + String.valueOf(df.format(datos[3])));
        tv5.setText("Sueldo líquido (Sin bonos): $" + String.valueOf(df.format(datos[0])));

        if (bone[0] == 0.0){
            tv6.setText("NO HAY BONO");
            tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(datos[0])));
            tv7.setText("");
            tv8.setText("");
        }else{
            if (cargos[0].equals("Gerente")) {
                tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 10%");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                tv7.setText("");
                tv8.setText("");
            }else if(cargos[0].equals("Asistente")) {
                tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 5%");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                tv7.setText("");
                tv8.setText("");
            }else if(cargos[0].equals("Secretaria")) {
                tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 3%");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                tv7.setText("");
                tv8.setText("");
            }else {
                tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 2%");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                tv7.setText("");
                tv8.setText("");
            }
        }
    }

    public void Change(View view){
        String opc = spn2.getSelectedItem().toString();

        if (opc.equals("Empleado 1")){
            tv1.setText("Nombres: " + nombres[0] + " " + apellidos[0]);
            tv2.setText("Descuento ISSS: $" + String.valueOf(df.format(datos[1])));
            tv3.setText("Descuento AFP: $" + String.valueOf(df.format(datos[2])));
            tv4.setText("Descuento Renta: $" + String.valueOf(df.format(datos[3])));
            tv5.setText("Sueldo líquido (Sin bonos): $" + String.valueOf(df.format(datos[0])));

            if (bone[0] == 0.0){
                tv6.setText("NO HAY BONO");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(datos[0])));
                tv7.setText("");
                tv8.setText("");
            }else{
                if (cargos[0].equals("Gerente")) {
                    tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 10%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                    tv7.setText("");
                    tv8.setText("");
                }else if(cargos[0].equals("Asistente")) {
                    tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 5%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                    tv7.setText("");
                    tv8.setText("");
                }else if(cargos[0].equals("Secretaria")) {
                    tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 3%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                    tv7.setText("");
                    tv8.setText("");
                }else {
                    tv6.setText("Bono a " + cargos[0] + " " + nombres[0] + " ha sido de: 2%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[0])));
                    tv7.setText("");
                    tv8.setText("");
                }
            }
        }else if (opc.equals("Empleado 2")){
            tv1.setText("Nombres: " + nombres[1] + " " + apellidos[1]);
            tv2.setText("Descuento ISSS: $" + String.valueOf(df.format(datos[5])));
            tv3.setText("Descuento AFP: $" + String.valueOf(df.format(datos[6])));
            tv4.setText("Descuento Renta: $" + String.valueOf(df.format(datos[7])));
            tv5.setText("Sueldo líquido (Sin bonos): $" + String.valueOf(df.format(datos[4])));

            if (bone[1] == 0.0){
                tv7.setText("NO HAY BONO");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(datos[4])));
                tv6.setText("");
                tv8.setText("");
            }else{
                if (cargos[1].equals("Gerente")) {
                    tv7.setText("Bono a " + cargos[1] + " " + nombres[1] + " ha sido de: 10%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[1])));
                    tv6.setText("");
                    tv8.setText("");
                }else if(cargos[1].equals("Asistente")) {
                    tv7.setText("Bono a " + cargos[1] + " " + nombres[1] + " ha sido de: 5%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[1])));
                    tv6.setText("");
                    tv8.setText("");
                }else if(cargos[1].equals("Secretaria")) {
                    tv7.setText("Bono a " + cargos[1] + " " + nombres[1] + " ha sido de: 3%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[1])));
                    tv6.setText("");
                    tv8.setText("");
                }else {
                    tv7.setText("Bono a " + cargos[1] + " " + nombres[1] + " ha sido de: 2%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[1])));
                    tv6.setText("");
                    tv8.setText("");
                }
            }
        }else if (opc.equals("Empleado 3")){
            tv1.setText("Nombres: " + nombres[2] + " " + apellidos[2]);
            tv2.setText("Descuento ISSS: $" + String.valueOf(df.format(datos[9])));
            tv3.setText("Descuento AFP: $" + String.valueOf(df.format(datos[10])));
            tv4.setText("Descuento Renta: $" + String.valueOf(df.format(datos[11])));
            tv5.setText("Sueldo líquido (Sin bonos): $" + String.valueOf(df.format(datos[8])));

            if (bone[2] == 0.0){
                tv8.setText("NO HAY BONO");
                tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(datos[8])));
                tv6.setText("");
                tv7.setText("");
            }else{
                if (cargos[2].equals("Gerente")) {
                    tv8.setText("Bono a " + cargos[2] + " " + nombres[2] + " ha sido de: 10%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[2])));
                    tv7.setText("");
                    tv6.setText("");
                }else if(cargos[2].equals("Asistente")) {
                    tv8.setText("Bono a " + cargos[2] + " " + nombres[2] + " ha sido de: 5%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[2])));
                    tv7.setText("");
                    tv6.setText("");
                }else if(cargos[2].equals("Secretaria")) {
                    tv8.setText("Bono a " + cargos[2] + " " + nombres[2] + " ha sido de: 3%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[2])));
                    tv7.setText("");
                    tv6.setText("");
                }else {
                    tv8.setText("Bono a " + cargos[2] + " " + nombres[2] + " ha sido de: 2%");
                    tv9.setText("Salario Líquido Total: $" + String.valueOf(df.format(bone[2])));
                    tv7.setText("");
                    tv6.setText("");
                }
            }
        }
    }

    public void General(View view2){
        double salarios[] = {datos[0], datos[4], datos[8]};
        double salarios2[] = {bone[0], bone[1], bone[2]};
        double mayor, menor;
        int indice1 = 0, indice2 = 0;
        Bundle data2 = new Bundle();

        if (bone[0] == 0.0){
            mayor = salarios[0];
            for (int x = 1; x < salarios.length; x++) {
                double numeroActual = salarios[x];
                if (numeroActual > mayor) {
                    mayor = numeroActual;
                }
            }
        }else {
            mayor = salarios2[0];
            for (int x = 1; x < salarios2.length; x++) {
                double numeroActual = salarios2[x];
                if (numeroActual > mayor) {
                    mayor = numeroActual;
                }
            }
        }

        if (bone[0] == 0.0){
            menor = salarios[0];
            for (int x = 1; x < salarios.length; x++) {
                double numeroActual = salarios[x];
                if (numeroActual < menor) {
                    menor = numeroActual;
                }
            }
        }else {
            menor = salarios2[0];
            for (int x = 1; x < salarios2.length; x++) {
                double numeroActual = salarios2[x];
                if (numeroActual < menor) {
                    menor = numeroActual;
                }
            }
        }

        if (bone[0] == 0.0){
            for (int i = 1; i < salarios.length; i++){
                if (salarios[i] == mayor)
                    indice1 = i;
                if (salarios[i] == menor)
                    indice2 = i;
            }
        }else {
            for (int i = 1; i < salarios2.length; i++){
                if (salarios2[i] == mayor)
                    indice1 = i;
                if (salarios2[i] == menor)
                    indice2 = i;
            }
        }

        data2.putString("Mayor", nombres[indice1]);
        data2.putString("Menor", nombres[indice2]);

        if (bone[0] == 0.0){
            for (int i = 0; i < 3; i++){
               if (salarios[i] > 300){
                   data2.putString("n" + String.valueOf(i), nombres[i]);
               }
            }
        }else {
            for (int i = 0; i < 3; i++){
                if (salarios2[i] > 300){
                    data2.putString("n" + String.valueOf(i), nombres[i]);
                }
            }
        }

        Intent i = new Intent(this,General.class);
        i.putExtras(data2);
        startActivity(i);
    }
}