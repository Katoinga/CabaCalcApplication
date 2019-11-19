package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AconActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acon);
    }

    public void CalcularAcon(View v){
        EditText editText5 = (EditText) findViewById(R.id.datec4);
        String date4 = editText5.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.datec1);
        String date1 = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.datec2);
        String date2 = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.datec3);
        String date3 = editText4.getText().toString();
        if (date4.length()==0){
            Toast.makeText(this, this.getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
        }
        if (date1.length()==0){
            Toast.makeText(this, this.getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
        }
        if (date2.length()==0){
            Toast.makeText(this, this.getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
        }
        if (date3.length()==0){
            Toast.makeText(this, this.getResources().getString(R.string.error), Toast.LENGTH_LONG).show();
        }
        if (date4.length()!=0 && date1.length()!=0 && date2.length()!=0 && date3.length()!=0){
            int hora=Integer.parseInt(date4);
            int toni= Tonico();
            int res= sumcif((hora+toni));
            String data= String.valueOf(res);
            TextView txt = findViewById(R.id.acres);
            txt.setText(data);
            String arcano= significado(data);
            TextView txt2 = findViewById(R.id.txtcab8);
            txt2.setText(arcano);
        }

    }

    public int Tonico(){
        Bundle extras= getIntent().getExtras();
        String p= extras.getString("dat7");
        int p1= Integer.parseInt(p);
        int p2=calcular();
        int p3=sumcif((p1+p2));
        return p3;

    }

    public int calcular(){
        EditText editText2 = (EditText) findViewById(R.id.datec1);
        String date1 = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.datec2);
        String date2 = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.datec3);
        String date3 = editText4.getText().toString();


        int dia= Integer.parseInt(date1);
        int mes= Integer.parseInt(date2);
        int ao= Integer.parseInt(date3);

        int res= sumcif((sumcif(dia)+sumcif(mes)+sumcif(ao)));
        return res;
    }
    public static int sumcif(int numero){
        int sumdig=0,aux=numero;
        while(numero != 0){
            sumdig = sumdig +(numero%10);
            numero= numero/10;
        }
        if (sumdig>=10){
            return sumcif(sumdig);
        }
        return sumdig;

    }
    public String significado(String num){
        int n= Integer.parseInt(num);
        if (n==1){
            return this.getResources().getString(R.string.arcano1);
        }if (n==2){
            return this.getResources().getString(R.string.arcano2);
        }if (n==3){
            return this.getResources().getString(R.string.arcano3);
        }if (n==4){
            return this.getResources().getString(R.string.arcano4);
        }if (n==5){
            return this.getResources().getString(R.string.arcano5);
        }if (n==6){
            return this.getResources().getString(R.string.arcano6);
        }if (n==7){
            return this.getResources().getString(R.string.arcano7);
        }if (n==8){
            return this.getResources().getString(R.string.arcano8);
        }if (n==9){
            return this.getResources().getString(R.string.arcano9);
        }
        return "No hay pronostico";
    }
}
