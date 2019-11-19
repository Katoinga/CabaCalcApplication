package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CabaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caba);
        mostrarData();
    }

    public void mostrarData(){
        Bundle extras= getIntent().getExtras();
        String ao1= extras.getString("dat8");
        String ao2= extras.getString("dat9");
        String ao3= extras.getString("dat10");
        TextView txt1 = findViewById(R.id.txtcab5);
        TextView txt2 = findViewById(R.id.txtcab6);
        TextView txt3 = findViewById(R.id.txtcab7);
        String r1= extras.getString("dat11");
        String r2= extras.getString("dat12");
        String r3= extras.getString("dat13");
        TextView txt4 = findViewById(R.id.cres1);
        TextView txt5 = findViewById(R.id.cres2);
        TextView txt6 = findViewById(R.id.cres3);

        txt1.setText(ao1);
        txt2.setText(ao2);
        txt3.setText(ao3);
        txt4.setText(r1);
        txt5.setText(r2);
        txt6.setText(r3);
        String arcano= significado(r3);
        TextView txt2a = findViewById(R.id.txtcab);
        txt2a.setText(arcano);

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
