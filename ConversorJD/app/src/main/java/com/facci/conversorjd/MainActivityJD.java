package com.facci.conversorjd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityJD extends AppCompatActivity {
    final String[] datos = new String[]{"DOLAR","EURO","PESO MEXICANO","PESO COLOMBIANO"};
    private Spinner monedaActualSP;
    private Spinner monedaCambioSP;
    private EditText valorCambioET;
    private TextView resultadoTV;
    final private double factorDolarEuro = 0.87;
    final private double factorPesoDolar = 0.54;
    final private double factorEuroPeso = 21.13;
    final private double factorEuroPesoco = 3.449;
    final private double factorDolarPesoco = 2800;
    final private double factorPesocoPeso = 0.01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity_jd);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,datos);

        monedaActualSP = (Spinner) findViewById(R.id.monedaActualSP);

        monedaActualSP.setAdapter(adaptador);
    }
    public void clickConvertir(View v){
        monedaActualSP = (Spinner) findViewById(R.id.monedaActualSP);
        monedaCambioSP = (Spinner) findViewById(R.id.monedaCambioSP);
        valorCambioET = (EditText) findViewById(R.id.valorCambioET);
        resultadoTV = (TextView) findViewById(R.id.resultadoTv);

        String monedaActual = monedaActualSP.getSelectedItem().toString();
        String monedaCambio = monedaCambioSP.getSelectedItem().toString();

        double valorCambio = Double.parseDouble(valorCambioET.getText().toString());

        double resultado = procesarConversion(monedaActual,monedaCambio,valorCambio);

        if (resultado > 0) {
            resultadoTV.setText(String.format("Por %5.2f %s, Usted Recibira %5.2f %s",valorCambio,monedaActual,resultado,monedaCambio));
            valorCambioET.setText("");
        }else
        {
            resultadoTV.setText(String.format("Usted Recibirá"));
            Toast.makeText(MainActivityJD.this, "Las Opciones Elejidas No Tienen Un Factor De Conversion", Toast.LENGTH_SHORT).show();

        }

    }
    private double procesarConversion(String monedaActual,String monedaCambio,double valorCambio){
        double resultadoConversion = 0;

        switch (monedaActual){
            case "DOLAR":
                if (monedaCambio.equals("EURO")){
                    resultadoConversion = valorCambio * factorDolarEuro;
                }
                if (monedaCambio.equals("PESO MEXICANO")){
                    resultadoConversion = valorCambio / factorPesoDolar;
                }
                if (monedaCambio.equals("PESO COLOMBIANO")){
                        resultadoConversion = valorCambio * factorDolarPesoco;
                }
                break;
            case "EURO":
                if (monedaCambio.equals("DOLAR")){
                    resultadoConversion = valorCambio / factorDolarEuro;
                }
                if (monedaCambio.equals("PESO MEXICANO")){
                    resultadoConversion = valorCambio * factorEuroPeso;
                }
                if (monedaCambio.equals("PESO COLOMBIANO")){
                    resultadoConversion = valorCambio * factorEuroPesoco;
                }
                break;
            case "PESO MEXICANO":
                if (monedaCambio.equals("EURO")){
                    resultadoConversion = valorCambio / factorDolarEuro;
                }
                if (monedaCambio.equals("DOLAR")){
                    resultadoConversion = valorCambio * factorPesoDolar;
                }
                if (monedaCambio.equals("PESO COLOMBIANO")){
                    resultadoConversion = valorCambio / factorPesocoPeso;
                }
                break;
            case "PESO COLOMBIANO":
                if (monedaCambio.equals("EURO")){
                    resultadoConversion = valorCambio / factorDolarEuro;
                }
                if (monedaCambio.equals("PESO MEXICANO")){
                    resultadoConversion = valorCambio * factorPesocoPeso;
                }
                if (monedaCambio.equals("DOLAR")){
                    resultadoConversion = valorCambio /factorDolarPesoco;
                }
                break;
        }
        return 0;
    }
}
