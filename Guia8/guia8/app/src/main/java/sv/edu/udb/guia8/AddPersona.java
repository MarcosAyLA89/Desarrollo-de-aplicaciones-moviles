package sv.edu.udb.guia8;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.Toast;

import Datos.Persona;

public class AddPersona extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinnerGender;
    EditText edtDUI, edtNombre,Txt_peso,Txt_altura;
    String key="",nombre="",dui="",accion="";
    CalendarView fecha_nacimiento;
    String BirthDateString="";
    String GenderString="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_persona);
        inicializar();

        ArrayAdapter<CharSequence> adapter =ArrayAdapter.createFromResource(this,R.array.genders, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      
        spinnerGender.setAdapter(adapter);
        spinnerGender.setOnItemSelectedListener(this);

        fecha_nacimiento.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                BirthDateString=(dayOfMonth)+"/"+(month)+"/"+(year);
                Toast.makeText(AddPersona.this,BirthDateString,Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void inicializar() {
        edtNombre = findViewById(R.id.edtNombre);
        edtDUI = findViewById(R.id.edtDUI);
        fecha_nacimiento=findViewById(R.id.calendarViewFec_Nac);
        spinnerGender=findViewById(R.id.spinner_genero);
        Txt_altura=findViewById(R.id.txt_altura);
        Txt_peso=findViewById(R.id.txt_peso);

        // Obtención de datos que envia actividad anterior
        Bundle datos = getIntent().getExtras();
        key = datos.getString("key");
        dui = datos.getString("dui");
        nombre=datos.getString("nombre");
        accion=datos.getString("accion");
        edtDUI.setText(dui);
        edtNombre.setText(nombre);
    }


    public void guardar(View v){
        String nombre = edtNombre.getText().toString();
        String dui = edtDUI.getText().toString();
        String fecha=BirthDateString;
        String genero=GenderString;
        Double peso=Double.parseDouble(Txt_peso.getText().toString());
        Double algura=Double.parseDouble(Txt_altura.getText().toString());


        // Se forma objeto persona
        Persona persona = new Persona(dui,nombre,fecha,genero,peso
        ,algura);

        if (accion.equals("a")) { //Agregar usando push()
            Personas.refPersonas.push().setValue(persona);
        }
        else // Editar usando setValue
        {
            Personas.refPersonas.child(key).setValue(persona);
        }
        finish();
    }
    public void cancelar(View v){
        finish();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        GenderString= parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}