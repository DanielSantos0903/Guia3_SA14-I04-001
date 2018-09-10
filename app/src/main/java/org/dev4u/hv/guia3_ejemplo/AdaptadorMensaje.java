package org.dev4u.hv.guia3_ejemplo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;


public class AdaptadorMensaje extends ArrayAdapter<String>{
    //TODO constructor con 2 parametros : el contexto y la lista de objetos (Contacto)
    public AdaptadorMensaje(Context context, ArrayList<String> objects) {
        super(context, 0, objects);
    }
    @NonNull

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Obteniendo el dato
        String mensaje = getItem(position);
        //TODO inicializando el layout correspondiente al item (Contacto)
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_mensaje, parent, false);
        }
        TextView lblMensaje = (TextView) convertView.findViewById(R.id.lblMensaje);
        TextView lblFecha = (TextView) convertView.findViewById(R.id.lblFecha);
        // mostrar los datos
        lblMensaje.setText(mensaje.trim());
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss" , Locale.getDefault());
        Date date = new Date();
        String fecha = dateFormat.format(date.getTime());
        lblFecha.setText(fecha);
        // Return la convertView ya con los datos
        return convertView;
    }
}

//DateFormat.getDateInstance().format(date)