package com.example.aplicacionagenda;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;
import java.util.function.Function;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
         ArrayList<UsuarioAgenda> usuariosAgendados = (ArrayList<UsuarioAgenda>) getIntent().getSerializableExtra("usuarios");
        TableLayout tableLayout = findViewById(R.id.tablaAgenda);
        if (usuariosAgendados != null) {
            for (UsuarioAgenda usuario : usuariosAgendados) {
                TableRow row = new TableRow(this);


                TextView nombreTextView = new TextView(this);
                nombreTextView.setText(usuario.getNombre());


                TextView apellidoTextView = new TextView(this);
                apellidoTextView.setText(usuario.getApellido());


                TextView emailTextView = new TextView(this);
                emailTextView.setText(usuario.getEmail());


                TextView telefonoTextView = new TextView(this);
                telefonoTextView.setText(Integer.toString(usuario.getTelefono()));


                row.addView(nombreTextView);
                row.addView(apellidoTextView);
                row.addView(emailTextView);
                row.addView(telefonoTextView);

                tableLayout.addView(row);
            }
        }

    }


}