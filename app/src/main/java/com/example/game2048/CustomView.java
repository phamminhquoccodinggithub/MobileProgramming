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
    //Add view runtime
    public CustomView(Context context){
        super(context);
        init(context, null, 0);
    }
    //Use in xml file
    public CustomView(Context context, @Nullable AttributeSet attrs){
        super(context, attrs);
        init(context, attrs, 0);
    }
    //Use in xml file, add default style
    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }
    //Use in xml file, add default style, add style by resources
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
