package com.example.dam.vistacomposta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {

    private EditNumber editNumber1, editNumber2;
    private TextView resultText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editNumber1 = (EditNumber) findViewById(R.id.editNumber1);
        editNumber2 = (EditNumber) findViewById(R.id.editNumber2);
        resultText = (TextView) findViewById(R.id.resultText);
        editNumber1.setMin(-15);
        editNumber1.setMax(15);
        editNumber1.setValue(0);
        editNumber2.setValue(27);
        resultText.setText("Valor");
        editNumber1.setOnSeekBarChangeListener(this);
        editNumber2.setOnSeekBarChangeListener(this);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int resultat = editNumber1.getValue() + editNumber2.getValue();
        resultText.setText("" + resultat);
    }
    @Override public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override public void onStopTrackingTouch(SeekBar seekBar) {}
}