package org.dev4u.hv.guia3_ejemplo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MensajeActivity extends AppCompatActivity {

    private AdaptadorMensaje adaptadorMensaje;
    private ArrayList<String> mensajeArrayList;
    private EditText mensaje;
    private Button btnEnviar;
    private String fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        mensajeArrayList = new ArrayList<String>();
        //Inicializando el adaptador
        adaptadorMensaje = new AdaptadorMensaje(this,  mensajeArrayList);
        //Inicializando el listView
        ListView listView = (ListView) findViewById(R.id.lstMensaje);
        //seteando el adaptador al listview
        listView.setAdapter((ListAdapter) adaptadorMensaje);
        mensaje = (EditText) findViewById(R.id.txtEntrada);
        btnEnviar = (Button) findViewById(R.id.btnEnviar);

        }

    public Date devolverFecha(Date fechaEntrada) throws ParseException {

        SimpleDateFormat formato = new SimpleDateFormat("dd/M/yyyy");
        String fechaString = fechaEntrada.toString(); // Convierte Date a String
        Date miFecha = formato.parse(fechaString); // convierte String a Date
        return miFecha;

    }
    public void agregar(View v) {
        mensajeArrayList.add((String)mensaje.getText().toString());
        adaptadorMensaje.notifyDataSetChanged();
        mensaje.setText("");
    }

}