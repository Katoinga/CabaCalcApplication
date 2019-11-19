package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {
    public String urgencia="",tonico="",dia="",ao1="",ao2="",ao3="", cab1="",cab2="",cab3="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        recibirData();
        // Get the Intent that started this activity and extract the string

    }
    public void recibirData(){
        Bundle extras= getIntent().getExtras();

        String d1= extras.getString("dat1");
        String d2= extras.getString("dat2");
        String d3= extras.getString("dat3");
        String d4= extras.getString("dat4");
        urgencia= extras.getString("dat5");
        tonico= extras.getString("dat6");
        dia= extras.getString("dat7");
        ao1=extras.getString("dat8");
        ao2=extras.getString("dat9");
        ao3=extras.getString("dat10");
        cab1=extras.getString("dat11");
        cab2=extras.getString("dat12");
        cab3=extras.getString("dat13");

        String date= d2+"/"+d3+"/"+d4;
        TextView textView = findViewById(R.id.txt_1);
        textView.setText(d1);
        TextView textView2 = findViewById(R.id.txt_6);
        textView2.setText(date);


    }
    public void AcAbout(View view){
        Intent siguiente= new Intent(this, AboutActivity.class);
        startActivity(siguiente);
    }
    public void AcUrgencia(View view){
        Intent siguiente= new Intent(this, UrgenciaActivity.class);
        siguiente.putExtra("dat5", urgencia);
        startActivity(siguiente);
    }
    public void AcTonico(View view){
        Intent siguiente= new Intent(this, TonicoActivity.class);
        siguiente.putExtra("dat6", tonico);
        startActivity(siguiente);
    }
    public void AcDia(View view){
        Intent siguiente= new Intent(this, TonicaDiaActivity.class);
        siguiente.putExtra("dat7", dia);
        startActivity(siguiente);
    }
    public void AcAcon(View view){
        Intent siguiente= new Intent(this, AconActivity.class);
        siguiente.putExtra("dat7", dia);
        startActivity(siguiente);
    }
    public void AcNum(View view){
        Intent siguiente= new Intent(this, NumActivity.class);
        siguiente.putExtra("dat7", dia);
        startActivity(siguiente);
    }
    public void AcCab(View view){
        Intent siguiente= new Intent(this, CabaActivity.class);
        siguiente.putExtra("dat8", ao1);
        siguiente.putExtra("dat9", ao2);
        siguiente.putExtra("dat10", ao3);
        siguiente.putExtra("dat11", cab1);
        siguiente.putExtra("dat12", cab2);
        siguiente.putExtra("dat13", cab3);

        startActivity(siguiente);
    }

}
