package com.example.dam.vistacomposta;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;


public class ColorView extends View implements View.OnClickListener{
    private int color;

    public interface OnColorChangedListener{
        public void colorChanged(View view, int color);
    }
    private OnColorChangedListener listener;
    private Paint paint;
    public ColorView(Context context) {this(context, null, 0);}
    public ColorView(Context context, AttributeSet attrs) {this(context, attrs, 0);}
    public ColorView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        color = Color.GREEN;
        this.setOnClickListener(this);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override public void draw(Canvas canvas){
        canvas.drawColor(color);
        canvas.drawRect(0,0, getWidth(), getHeight(), paint);
    }

    public int getColor() {return color;}
    public void setColor(int color) {
        this.color = color;
        this.invalidate();
    }

    public void setOnColorChangedListener(OnColorChangedListener listener){
        this.listener = listener;
    }

    @Override public void onClick(View view){
        int r = (int) (Math.random() * 256);
        int g = (int) (Math.random() * 256);
        int b = (int) (Math.random() * 256);
        int color = Color.rgb(r, g, b);
        setColor(color);
        if (this.listener != null){
            this.listener.colorChanged(this, color);
        }
    }
}
