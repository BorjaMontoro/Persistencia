package com.example.persistencia;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    //Aplicacion Acabada
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b=findViewById(R.id.boton);

        try{
            File dir= getFilesDir();
            File archivo=new File(dir,"dades.txt");
            FileWriter escribir=new FileWriter(archivo);
            String mensaje="Lorem Ipsum is simply dummy text of the printing and typesetting industry.\n";
            escribir.write(mensaje);
            escribir.flush();
            escribir.close();
            actualizarEditText();
            b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    actualizaArchivo();
                    actualizarEditText();

                }
            });

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void actualizarEditText(){
        File dir = getFilesDir();
        File archivo = new File(dir,"dades.txt");
        EditText edit=findViewById(R.id.editar);
        edit.setText("");
        try {
            Scanner obj = new Scanner(archivo);

            while (obj.hasNextLine())
                edit.append(obj.nextLine()+"\n");
        }
        catch (IOException e) {
        }
    }
    private void actualizaArchivo(){
        try {
            EditText edit=findViewById(R.id.editar);
            File dir= getFilesDir();
            File archivo=new File(dir,"dades.txt");
            FileWriter escribir=new FileWriter(archivo);
            escribir.write(edit.getText().toString());
            escribir.flush();
            escribir.close();
        }catch(Exception e){

        }
    }
}