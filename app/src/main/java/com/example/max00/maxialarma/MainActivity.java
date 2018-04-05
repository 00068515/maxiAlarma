package com.example.max00.maxialarma;

import android.content.Intent;
import android.provider.AlarmClock;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    //variables
    private Spinner horitas;
    private Spinner minutitos;
    private EditText horas;
    private EditText minutos;
    private EditText mensaje;
    private Button boton;
    private int Phora;
    private int Pmin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //spinner de las horas
        horitas = findViewById(R.id.SP_hours);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.horas,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        horitas.setAdapter(adapter);
        horitas.setOnItemSelectedListener(this);

        //spinner de los minutos
        minutitos = findViewById(R.id.SP_minutes);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this,R.array.minutos,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        minutitos.setAdapter(adapter2);
        minutitos.setOnItemSelectedListener(this);




        /*instanciacion
        horas = findViewById(R.id.ET_hours);
        minutos = findViewById(R.id.ET_minutes);*/
        mensaje = findViewById(R.id.ET_mensaje);
        boton = findViewById(R.id.B_allahu);


        //listener boton
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //parse de mierda
                //Integer hora = Integer.parseInt(horas.getText().toString());
                //implementacion del metodo alarmita
                alarmita(mensaje.getText().toString(),Phora,Pmin);
            }
        });


    }
    private void alarmita(String message, int hour,int minutes) {

        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);//instanciando intent
        intent.putExtra(AlarmClock.EXTRA_MESSAGE, message);//poniento mensaje
        intent.putExtra(AlarmClock.EXTRA_HOUR, hour);//poniendo hora
        intent.putExtra(AlarmClock.EXTRA_MINUTES, minutes);//poninedo minutos

        //validacion
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = horitas.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT).show();//mostrar mensaje
        String text2 = minutitos.getItemAtPosition(position).toString();
        //Toast.makeText(parent.getContext(),text2,Toast.LENGTH_SHORT).show();//mostrar mensaje

        Phora = Integer.parseInt(text);
        Pmin = Integer.parseInt(text2);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


