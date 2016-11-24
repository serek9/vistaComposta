package com.example.dam.vistacomposta;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class EditNumber extends LinearLayout implements SeekBar.OnSeekBarChangeListener{

    private int value, min, max;
    private TextView textView;
    private SeekBar seekBar;

    public EditNumber(Context context) {this(context, null, 0);}
    public EditNumber(Context context, AttributeSet attrs) {this(context, attrs, 0);}
    public EditNumber(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.edit_number_layout, this);
        textView = (TextView) view.findViewById(R.id.textView);
        seekBar = (SeekBar) view.findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        setMin(0);
        setMax(10);
        setValue(0);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (!fromUser) return;
        this.setValue(progress + this.min);
        if (listener != null) listener.onProgressChanged(seekBar, this.value, true);
    }

    @Override public void onStartTrackingTouch(SeekBar seekBar) {}
    @Override public void onStopTrackingTouch(SeekBar seekBar) {}

    private SeekBar.OnSeekBarChangeListener listener;
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener listener){
        this.listener = listener;
    }

    public int getValue() {return value;}
    public void setValue(int value) {
        if (value < this.min) value = this.min;
        if (value > this.max) value = this.max;
        this.value = value;
        textView.setText("" +value);
        seekBar.setProgress(value - this.min);
    }

    public int getMin() {return min;}
    public void setMin(int min) {
        this.min = min;
        int rang = this.max - this.min;
        seekBar.setMax(rang);
        if (this.value < this.min) this.setValue(min);
    }

    public int getMax() {return max;}
    public void setMax(int max) {
        this.max = max;
        int rang = this.max - this.min;
        seekBar.setMax(rang);
        if (this.value > this.max) this.setValue(max);
    }

}
