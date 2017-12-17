package asiste.incode;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nixburemi on 04-Feb-17.
 */

class convertidor_busqueda extends ArrayAdapter {

    List list = new ArrayList<>();




    public convertidor_busqueda(Context context, int resource) {
        super(context, resource);
    }


    public void add(consulta_herramientas object) {
        super.add(object);
        list.add(object);

    }

    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return list.get(position);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View row;
        row= convertView;
        //accede a las preferencias

        final PensamientosHolder pensamientosHolder;


        if(row == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


                row = layoutInflater.inflate(R.layout.elemento_herramienta, parent, false);

            pensamientosHolder = new PensamientosHolder();
            // INSERTA STRING NUEVO
            pensamientosHolder.nom = (TextView)row.findViewById(R.id.nombre);
            pensamientosHolder.cant=(TextView)row.findViewById(R.id.cantidad);
            pensamientosHolder.marc = (TextView)row.findViewById(R.id.marca);


            //final se utiliza para indicar donde exactamente

            row.setTag(pensamientosHolder);


            //al dar click sobre el título del pensamiento





        }
        else
        {
            pensamientosHolder = (PensamientosHolder)row.getTag();

        }

        consulta_herramientas filtradousuario= (consulta_herramientas) this.getItem(position);
        // INSERTA STRING NUEVO
        pensamientosHolder.nom.setText(filtradousuario.getNombre());
        pensamientosHolder.marc.setText(filtradousuario.getMarca());
        pensamientosHolder.cant.setText(filtradousuario.getCantidad());



        return row;
    }
    static class PensamientosHolder
    {
        // INSERTA STRING NUEVO
        TextView nom, marc, cant;


    }

}
