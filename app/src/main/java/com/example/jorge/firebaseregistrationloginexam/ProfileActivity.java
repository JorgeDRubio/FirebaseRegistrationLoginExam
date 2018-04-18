package com.example.jorge.firebaseregistrationloginexam;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ProfileActivity extends AppCompatActivity {

    Button guardar;
    String nombre, control;
    EditText texto1,texto2;
            private TextView tvEmail;

    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference();
    DatabaseReference mensajeref=databaseReference.child("nombre");
    DatabaseReference controlref=databaseReference.child("numero");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        tvEmail = findViewById(R.id.txtEmailProfile);
        texto1=findViewById(R.id.texto1);
        texto2=findViewById(R.id.texto2);

        tvEmail.setText(getIntent().getExtras().getString("email"));
        guardar=findViewById(R.id.boton);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=texto1.getText().toString();
                mensajeref.setValue(nombre);
                control=texto2.getText().toString();
                controlref.setValue(control);
            }
        });
    }
}
