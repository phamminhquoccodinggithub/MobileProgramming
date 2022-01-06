package com.example.game2048;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Picture;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.jar.Attributes;

public class CustomView extends View {
    private Paint paint;
    private Resources resources;
    private Bitmap bitmap;
    //su dung khi add view luc runtime
    public CustomView(Context context){
        super(context);
        init(context, null, 0);
    }
    // su dung khi khai bao trong file xml
    public CustomView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init(context, attrs, 0);
    }
    // dung trong xml them style mac dinh
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }
    //them tham so de truyen style thong qua resources
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes){
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs, defStyleAttr);
    }
    private void init(Context context, AttributeSet attrs, int defStyleAttr){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        resources = context.getResources();
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.resize);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap,0,0,paint);
    }
}
