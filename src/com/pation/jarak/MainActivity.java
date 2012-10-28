package com.pation.jarak;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void onClick(View view) {
        switch (view.getId()) {
        case R.id.btnCalc:
        	EditText editNominal = (EditText) findViewById(R.id.editTextNominal);
        	try {
	        	double nominal = Double.parseDouble(editNominal.getText().toString());
	        	if(nominal > 0)
	        	{
	        		Spinner spinSatu = (Spinner) findViewById(R.id.spinSatuanSatu);
	            	Spinner spinDua = (Spinner) findViewById(R.id.spinSatuanDua);
	        		TextView txtHasil = (TextView) findViewById(R.id.txtViewResult);
	        		txtHasil.setText(nominal+spinSatu.getSelectedItem().toString()+" = "+kalkulasi(nominal,spinSatu,spinDua)+spinDua.getSelectedItem().toString());
	        	}
	        	else
	        	{
	        		Toast.makeText(getApplicationContext(), "Inputkan nominal ukuran yang akan dikonversi", Toast.LENGTH_SHORT).show();
	        	}
        	} catch (NumberFormatException e) {
        		Toast.makeText(getApplicationContext(), "Inputkan nominal ukuran yang akan dikonversi", Toast.LENGTH_SHORT).show();
			}
        	break;
        }
    }
    
    private String kalkulasi(double nominal, Spinner spinSatu, Spinner spinDua) {
    	int tangga = (spinDua.getSelectedItemPosition()) - (spinSatu.getSelectedItemPosition());
    	Double hasil = nominal * Math.pow(10, tangga);
    	return hasil.toString();
    }
    
}
