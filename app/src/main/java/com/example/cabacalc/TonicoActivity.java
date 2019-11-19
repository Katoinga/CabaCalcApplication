package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class TonicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tonico);
        mostrarData();
    }

    public void mostrarData(){
        Bundle extras= getIntent().getExtras();
        String data= extras.getString("dat6");
        TextView txt = findViewById(R.id.txt_tonres);
        txt.setText(data);
        String arcano= significado(data);
        TextView txt2 = findViewById(R.id.txtarcano);
        txt2.setText(arcano);

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
