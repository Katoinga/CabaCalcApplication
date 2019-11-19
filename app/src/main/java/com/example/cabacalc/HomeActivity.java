package com.example.cabacalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class HomeActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "Error!!!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.intxt_1);
        String name = editText.getText().toString();
        EditText editText2 = (EditText) findViewById(R.id.intxt_2);
        String date1 = editText2.getText().toString();
        EditText editText3 = (EditText) findViewById(R.id.intxt_3);
        String date2 = editText3.getText().toString();
        EditText editText4 = (EditText) findViewById(R.id.intxt_4);
        String date3 = editText4.getText().toString();

        if (name.length()==0){
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

        if (name.length()!=0 && date1.length()!=0 && date2.length()!=0 && date3.length()!=0){
            int dia= Integer.parseInt(date1);
            int mes= Integer.parseInt(date2);
            int ao= Integer.parseInt(date3);
            int urg= sumcif(dia)+sumcif(mes)+sumcif(ao);
            int urgencia = sumcif(urg);
            String urgstr= String.valueOf(urgencia);
            //tonica
            String[] arre=name.split("\\s+");
            int[] lengths= new int[arre.length];
            for(int a=0;a<arre.length;a++){
                lengths[a]= arre[a].length();
            }
            int tonico= tonico(lengths, urgencia);
            String tonstr= String.valueOf(tonico);
            //tonica 2
            int tonico2= tonico;
            String ton2str= String.valueOf(tonico2);
            // cabala
            int ao1= aos(ao);
            int ao2= aos(ao1);
            int ao3= aos(ao2);
            String pao= String.valueOf(ao1);
            String sao= String.valueOf(ao2);
            String tao= String.valueOf(ao3);
            int resao1= sumcif(ao1);
            int resao2= sumcif(ao2);
            int resao3= sumcif(ao3);
            String sum1= String.valueOf(resao1);
            String sum2= String.valueOf(resao2);
            String sum3= String.valueOf(resao3);

            //mandar
            intent.putExtra("dat1", name);
            intent.putExtra("dat2", date1);
            intent.putExtra("dat3", date2);
            intent.putExtra("dat4", date3);
            intent.putExtra("dat5", urgstr);
            intent.putExtra("dat6", tonstr);
            intent.putExtra("dat7", ton2str);
            //cabala
            intent.putExtra("dat8", pao);
            intent.putExtra("dat9", sao);
            intent.putExtra("dat10", tao);
            intent.putExtra("dat11", sum1);
            intent.putExtra("dat12", sum2);
            intent.putExtra("dat13", sum3);
            startActivity(intent);
        }
    }
    public static int tonico(int[] top, int urgencia){
        int sum=0;
        for (int i=0;i<top.length;i++){
            if (top[i]!= 0){
                sum+= top[i];
            }
        }
        int p2= sumcif(sum)+urgencia;
        int res= sumcif(p2);
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
    public static int aos(int numero){
        int atotal=numero;
        int cuarto,tercero,segundo,primero;
        cuarto = numero%10;
        numero = numero/10;
        tercero = numero%10;
        numero = numero/10;
        segundo = numero%10;
        numero = numero/10;
        primero = numero%10;
        atotal= atotal+primero+segundo+tercero+cuarto;
        return atotal;
    }
}
