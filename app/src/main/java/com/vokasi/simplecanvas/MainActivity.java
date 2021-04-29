package com.vokasi.simplecanvas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.content.res.ResourcesCompat;

public class MainActivity extends AppCompatActivity {
    private Canvas mCanvas;
    private Paint mPaint = new Paint();
    private Paint mPaintText = new Paint(Paint.UNDERLINE_TEXT_FLAG);
    private Bitmap mBitmap;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImageView = findViewById(R.id.my_imageview);
        mPaint.setColor(Color.YELLOW);
        mPaintText.setColor(ResourcesCompat.getColor(getResources(),
                R.color.black, null));
        mPaintText.setTextSize(60);
    }

    public void drawSomething(View view) {
        int vWidth = view.getWidth();
        int vHeight = view.getHeight();
        mBitmap = Bitmap.createBitmap(vWidth, vHeight, Bitmap.Config.ARGB_8888);
        mImageView.setImageBitmap(mBitmap);
        mCanvas = new Canvas(mBitmap);
        mCanvas.drawColor(Color.CYAN);

        mPaint.setColor(ContextCompat.getColor(this, R.color.green));
        Rect mRect = new Rect();
        mRect.set(250, 620, 770, 950);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.light_yellow));
        mRect.set(430, 750, 580, 950);
        mCanvas.drawRect(mRect, mPaint);

        mPaint.setColor(ContextCompat.getColor(this, R.color.pink));
        Path path = new Path();
        path.moveTo(500, 410); // Atas
        path.lineTo(245, 625); // Bawah kiri
        path.lineTo(775, 625); // Bawah kanan
        path.lineTo(450, 375); // Balik ke atas
        path.close();
        mCanvas.drawPath(path, mPaint);

        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(675, 800, 50, mPaint);

        mPaint.setColor(Color.LTGRAY);
        mCanvas.drawCircle(330, 800, 50, mPaint);

        mCanvas.drawText("Bernardinus Nicholas Martin",135,1200,mPaintText);

        view.invalidate();
    }

}
























