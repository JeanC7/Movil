package com.facci.restaurantjd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivityJD extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_jd);
    }
    public void click1(View v){
        Toast.makeText(MainActivityJD.this,"Parrillada",Toast.LENGTH_SHORT).show();
    }
    public void click2(View v){
        Toast.makeText(MainActivityJD.this,"Hamburgueza",Toast.LENGTH_SHORT).show();
    }
    public void click3(View v){
        Toast.makeText(MainActivityJD.this,"Pizza",Toast.LENGTH_SHORT).show();
    }
    public void click4(View v){
        Toast.makeText(MainActivityJD.this,"Ensalada Light",Toast.LENGTH_SHORT).show();
    }
    public void click5(View v){
        Toast.makeText(MainActivityJD.this,"Pescado",Toast.LENGTH_SHORT).show();
    }
    public void click6(View v){
        Toast.makeText(MainActivityJD.this,"Dona",Toast.LENGTH_SHORT).show();
    }
    public void click7(View v){
        Toast.makeText(MainActivityJD.this,"Sanduche",Toast.LENGTH_SHORT).show();
    }
}
