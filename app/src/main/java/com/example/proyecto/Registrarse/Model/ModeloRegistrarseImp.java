package com.example.proyecto.Registrarse.Model;

import android.util.Log;

import com.example.proyecto.Registrarse.Presenter.PresenterModelRegistrarse;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import androidx.annotation.NonNull;

public class ModeloRegistrarseImp implements ModelRegistrarse {

    private final PresenterModelRegistrarse listenerRegistrarse;
    private final FirebaseAuth mAuth;
    private final DatabaseReference myRef;

    public ModeloRegistrarseImp(PresenterModelRegistrarse listenerRegistrarse) {
        this.listenerRegistrarse = listenerRegistrarse;
        mAuth = FirebaseAuth.getInstance();
        myRef = FirebaseDatabase.getInstance().getReference();
    }

    @Override
    public void registrarUsuario(final String nombre, final String apellido, final String email, final String password) {
            Log.i("Login", nombre+" "+ apellido+" "+email+" "+password);
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Map<String, String> data = parseMapUsuario(nombre, apellido, email, password);
                            String userId = Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
                            myRef.child("usuarios").child(userId).setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        listenerRegistrarse.onSuccess();



                                    } else {
                                        listenerRegistrarse.onError("ERROR REGISTRADO");
                                    }
                                }
                            });
                        }
                        else {
                            listenerRegistrarse.onError("Email ya registrado");
                        }
                    }

                });
    }

    private Map<String, String> parseMapUsuario(String nombre, String apellido, String email, String password) {
        Map<String, String> data = new HashMap<>();
        data.put("nombre", nombre);
        data.put("apellido", apellido);
        data.put("email", email);
        data.put("password", password);
        return data;
    }
}
