package cat.dam.andy.majormenorigual;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView resultat;
    ImageButton igual,mesGran,mesPetit;
    Button click2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mesGran = (ImageButton) findViewById(R.id.mesGran);
        mesPetit = (ImageButton) findViewById(R.id.mesPetit);
        resultat =(TextView) findViewById(R.id.resultat);
        igual = (ImageButton) findViewById(R.id.Igual);
        click2 = findViewById(R.id.click);
        Random rand = new Random();
        int num1 = rand.nextInt(10) + 1;
        int num2 = rand.nextInt(10) + 1;
        crearImatgesEsquerra(num1);
        crearImatgesDreta(num2);
        mesGran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprovarGran(num1,num2);
            }
        });
        mesPetit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprovarPetit(num1,num2);
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                comprovarIgual(num1,num2);
            }
        });
        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
                overridePendingTransition(0, 0);
                String time = System.currentTimeMillis() + "";
                Toast.makeText(MainActivity.this, "Nova partida" + time, Toast.LENGTH_SHORT).show();
        }
    });
    }
    public void crearImatgesEsquerra(int num1) {
        LinearLayout ll_esquerra = (LinearLayout) findViewById(R.id.ll_esquerra);
        for (int i = 0; i <= num1; i++) {
            ImageView n = new ImageView(MainActivity.this);
            n.setImageResource(R.drawable.elefants);
            n.setAdjustViewBounds(true);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100,100);
            n.setLayoutParams(params);
            ll_esquerra.addView(n);
        }
    }
    public void crearImatgesDreta(int num1) {
        LinearLayout ll_dreta = (LinearLayout) findViewById(R.id.ll_dret);
        for (int i = 0; i <= num1; i++) {
            ImageView n = new ImageView(MainActivity.this);
            n.setImageResource(R.drawable.leon);
            n.setAdjustViewBounds(true);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100,100);
            n.setLayoutParams(params);
            ll_dreta.addView(n);
        }
    }
    public void comprovarIgual(int num1, int num2){
        if(num1 == num2){
            resultat.setText("Correcte!");
        }else {resultat.setText("Incorrecte");}
    }
    public void comprovarGran(int num1, int num2){
        if(num1 > num2){
            resultat.setText("Correcte!");
        }else {resultat.setText("Incorrecte");}
    }
    public void comprovarPetit(int num1, int num2){
        if(num1 < num2){
            resultat.setText("Correcte!");
        } else {resultat.setText("Incorrecte");}
    }
}