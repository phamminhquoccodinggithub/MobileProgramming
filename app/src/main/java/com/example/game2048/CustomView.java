package com.example.game2048;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import java.util.jar.Attributes;

public class CustomView extends View {
    private Paint paint;
    private Resources resources;
    private Bitmap bitmap;
    public CustomView(Context context){
        super(context);
        init(context, null);
    }
    private void init(Context context, Attributes attributes){
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        resources = context.getResources();
        bitmap = BitmapFactory.decodeResource(resources, R.drawable.box0);
    }
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}
