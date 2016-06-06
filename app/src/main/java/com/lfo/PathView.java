package com.lfo;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by home on 2016/5/16.
 */
public class PathView extends View {
    Paint paint2 = new Paint();
    Paint paint1 = new Paint();
    Paint paint = new Paint();
    Path p = new Path();
    Matrix matrix = new Matrix();

    public PathView(Context context) {
        super(context);
        intit();
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
        intit();
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        intit();
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        intit();
    }

    private void intit() {

        paint.setAntiAlias(true);                       //设置画笔为无锯齿
        paint.setColor(Color.BLACK);                    //设置画笔颜色
        paint.setStrokeWidth((float) 3.0);              //线宽
        paint.setStyle(Paint.Style.STROKE);

        paint1.setAntiAlias(true);                       //设置画笔为无锯齿
        paint1.setColor(Color.GREEN);                    //设置画笔颜色
        paint1.setStrokeWidth((float) 3.0);              //线宽
        paint1.setStyle(Paint.Style.STROKE);

        paint2.setAntiAlias(true);                       //设置画笔为无锯齿
        paint2.setColor(Color.RED);                    //设置画笔颜色
        paint2.setStrokeWidth((float) 3.0);              //线宽
        paint2.setStyle(Paint.Style.STROKE);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rectF = new RectF(454, 1113, 1035, 1213);
        canvas.drawRect(rectF, paint);
        matrix.postTranslate(20, 30);
        matrix.mapRect(rectF);
        canvas.drawRect(rectF, paint1);
        matrix.postTranslate(40, 10);
        matrix.mapRect(rectF);
        canvas.drawRect(rectF, paint2);

    }

    private void drawRect(Canvas canvas, float aX, float aY, float bX, float bY, float cX, float cY, float dX, float dY, Paint paint) {
        p.moveTo(aX, aY);
        p.lineTo(bX, bY);
        p.lineTo(cX, cY);
        p.lineTo(dX, dY);
        p.lineTo(aX, aY);
        canvas.drawPath(p, paint);
    }
}
