package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=findViewById(R.id.boton);

        try{
            File dir= getFilesDir();
            Log.i("Info",dir.toString());
            File archivo= new File(dir,"dades.txt");
            if(!archivo.exists()) {
                archivo.createNewFile();
            }
            FileWriter archivoescribir=new FileWriter(dir+"/dades.txt");
            Log.i("Info",dir+"/dades.txt");
            String mensaje="Cataluña es la mejor comunidad autonoma de España";
            archivoescribir.write(mensaje);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}