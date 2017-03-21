package com.edwinacubillos.itaguitur;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListaActivity extends AppCompatActivity {

    ListView listView;
   // String[] data = new String[]{"El Artista", "Las Chimeneas", "Parque principal"};

    private Lista_Entrada[] datos = new Lista_Entrada[]{
            new Lista_Entrada(R.drawable.artista, "El Artista", "Parque con canchas multiples", "Cra 52d Cll 60"),
            new Lista_Entrada(R.drawable.chimeneas, "Chimeneas", "Parque para disfrutar en familia", "Cll 15Sur Cra 52d"),
            new Lista_Entrada(R.drawable.bolivarita, "Principal", "Parque principal de Itagui", "Cll 50 Cra 51")
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);
        listView = (ListView) findViewById(R.id.lista);
        Adapter adapter = new Adapter(this, datos);
  //      ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String opcion =  ((Lista_Entrada)parent.getItemAtPosition(position)).getNombre();

                //Toast.makeText(getApplicationContext(), String.valueOf(position),Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(), opcion ,Toast.LENGTH_SHORT).show();

             /*   switch (position){
                    case 1: Intent intent = new Intent (ListaActivity.this, ParquesActivity.class );
                        startActivity(intent);
                        break;
                }*/
            }
        });
    }

    class Adapter extends ArrayAdapter<Lista_Entrada>{
        public Adapter(@NonNull Context context, Lista_Entrada[] datos) {
            super(context, R.layout.list_item, datos);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.list_item,null);

            TextView nombre = (TextView) item.findViewById(R.id.tNombre);
            nombre.setText(datos[position].getNombre());

            TextView descrip = (TextView) item.findViewById(R.id.tDescrip);
            descrip.setText(datos[position].getDescrip());

            TextView direcc = (TextView) item.findViewById(R.id.tDirec);
            direcc.setText(datos[position].getDirecc());

            ImageView imagen = (ImageView) item.findViewById(R.id.iFoto);
            imagen.setImageResource(datos[position].getIdImagen());

            return item;
        }
    }
}
