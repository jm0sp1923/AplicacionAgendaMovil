package com.example.aplicacionagenda;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    ArrayList<UsuarioAgenda> usuariosAgendados = new ArrayList<>();

    public void agendar(View view) {
        TextView nombre = findViewById(R.id.nombre);
        TextView apellido = findViewById(R.id.apellido);
        TextView email = findViewById(R.id.email);
        TextView telefono = findViewById(R.id.telefono);

        String nombreStr = nombre.getText().toString().trim();
        String apellidoStr = apellido.getText().toString().trim();
        String emailStr = email.getText().toString().trim();
        String telefonoStr = telefono.getText().toString().trim();


        if (nombreStr.isEmpty() || apellidoStr.isEmpty() || emailStr.isEmpty() || telefonoStr.isEmpty()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Campos Vacíos");
            builder.setMessage("Por favor, complete todos los campos.");
            builder.setPositiveButton("Aceptar", (dialog, which) -> dialog.dismiss());
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {

            UsuarioAgenda usu = new UsuarioAgenda();
            usu.setNombre(nombreStr);
            usu.setApellido(apellidoStr);
            usu.setEmail(emailStr);

            try {
                int telefonoInt = Integer.parseInt(telefonoStr);
                usu.setTelefono(telefonoInt);
            } catch (NumberFormatException e) {
                usu.setTelefono(0);
            }

            usuariosAgendados.add(usu);


            Intent intent = new Intent(this, MainActivity2.class);
            intent.putExtra("usuarios", usuariosAgendados);
            startActivity(intent);


            nombre.setText("");
            apellido.setText("");
            email.setText("");
            telefono.setText("");
        }
    }

}