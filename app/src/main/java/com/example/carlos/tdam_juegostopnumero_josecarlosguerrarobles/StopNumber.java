package com.example.carlos.tdam_juegostopnumero_josecarlosguerrarobles;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class StopNumber extends AppCompatActivity {
    TextView txtNumero;
    Button btnStopNumero;
    Boolean subir;
    String num_format1, num_format2;
    float num= (float) 0.0;
    double Number =  (1 * Math.random()) + 1;
    CountDownTimer timer;
    DecimalFormat format;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_number);
        subir=true;
        txtNumero=findViewById(R.id.txtNumero);
        btnStopNumero=findViewById(R.id.btnStopNumero);
        format = new DecimalFormat();
        format.setMaximumFractionDigits(1);
        num_format1 = format.format(Number);
        btnStopNumero.setText(""+num_format1);
        //Toast.makeText(StopNumber.this, ""+subir, Toast.LENGTH_SHORT).show();
        timer= new CountDownTimer(1000, 200) {
            public void onTick(long millisUntilFinished) {
                if(subir){
                    num+=0.1;
                    DecimalFormat format = new DecimalFormat();
                    format.setMaximumFractionDigits(1);
                    num_format2 = format.format(num);
                    if(num>Number){
                        subir=false;
                    }
                }else {

                    num-=0.1;
                    DecimalFormat format = new DecimalFormat();
                    format.setMaximumFractionDigits(1);
                    num_format2 = format.format(num);
                    if(num<Number && num<0){
                        subir=true;
                    }
                }
                txtNumero.setText(num_format2);
            }
            public void onFinish() {

                timer.start();
            }
        }.start();
        btnStopNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subir=true;
                Number =  (1 * Math.random()) + 1;
                num_format1 = format.format(Number);
                btnStopNumero.setText(""+num_format1);
                if(txtNumero.getText().toString().equals(btnStopNumero.getText().toString())){
                    Toast.makeText(StopNumber.this, "Haz ganado!!!", Toast.LENGTH_LONG).show();

                }
                else{
                    Toast.makeText(StopNumber.this, "LOSSSSER XD!!!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}