package com.example.proyecto.Activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.bumptech.glide.Glide;
import com.example.proyecto.R;

import java.util.Objects;

public class VerMas_Activity extends AppCompatActivity {
    private  static final  int REQUEST_CALL=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_mas_);
        TextView nombre = findViewById(R.id.textView_vermas_nombre);
        TextView apellido = findViewById(R.id.textView_vermas_apellido);
        TextView descripcion = findViewById(R.id.textView_vermas_descripcion);
        ImageView imageView = findViewById(R.id.imageView_vermas);

        Bundle datos = this.getIntent().getExtras();

        int posicion = Objects.requireNonNull(datos).getInt("posicion");
        String imagen = datos.getString("imagen");
        String nom = datos.getString("nombre");
        String ape = datos.getString("apellido");
        String desc = datos.getString("descripcion");

        System.out.println("Activity_Ver_Mas");
        System.out.println(posicion);

        Glide.with(VerMas_Activity.this)
                .load(imagen)
                .into(imageView);
        nombre.setText(nom);
        apellido.setText(ape);
        descripcion.setText(desc);
        Button btn_llamar = findViewById(R.id.button_llamar);
        btn_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });



    }
    private void makePhoneCall(){
        Bundle datos = this.getIntent().getExtras();
        String tel = Objects.requireNonNull(datos).getString("telefono");
        if(Objects.requireNonNull(tel).trim().length() > 0){
            if(ContextCompat.checkSelfPermission(VerMas_Activity.this,Manifest.permission.CALL_PHONE)!= PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(VerMas_Activity.this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_CALL);
            }else{
                String dial = "tel:" + tel;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == REQUEST_CALL){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                makePhoneCall();
            }else{
                Toast.makeText(this,"PERMISSION DENIED",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
