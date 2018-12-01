package com.example.tituh.fitnessproj.helpers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public class ProgressBarDrawable extends Drawable {

    private int mParts;
    private Paint mPaint;
    private int mFillColor = Color.parseColor("#FFA9C5");
    private int mEmptyColor = Color.parseColor("#FFEFF3");
    private int mSeparatorColor = Color.parseColor("#FFFFFF");
    private RectF mRectFill = null;
    private RectF mRectEmpty = null;
    private List<RectF> mSeparators = null;

    public ProgressBarDrawable(int parts) {
        this.mParts = parts;
        this.mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        this.mSeparators = new ArrayList<>();
    }

    @Override
    protected boolean onLevelChange(int level) {
        invalidateSelf();
        return true;
    }

    @Override
    public void draw(Canvas canvas) {
        Rect b = getBounds();
        float width = b.width();
        float height = b.height();

        int spaceFilled = (int) (getLevel() * width / 10000);
        this.mRectFill = new RectF(0, 0, spaceFilled, height);
        this.mRectEmpty = new RectF(spaceFilled, 0, width, height);

        int spaceBetween = (int) (width / 50);
        int widthPart = (int) (width / this.mParts - (int) (0.9 * spaceBetween));
        int startX = widthPart;
        for (int i = 0; i < this.mParts - 1; i++) {
            this.mSeparators.add(new RectF(startX, 0, startX + spaceBetween, height));
            Log.d("asdsadasdas", "" + startX + spaceBetween);
            startX += spaceBetween + widthPart;
        }


        this.mPaint.setColor(this.mFillColor);
        canvas.drawRect(this.mRectFill, this.mPaint);

        this.mPaint.setColor(this.mEmptyColor);
        canvas.drawRect(this.mRectEmpty, this.mPaint);

        this.mPaint.setColor(this.mSeparatorColor);
        for (RectF separator : this.mSeparators) {
            canvas.drawRect(separator, this.mPaint);
        }
    }

    @Override
    public void setAlpha(int alpha) {
    }

    @Override
    public void setColorFilter(ColorFilter cf) {
    }

    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
}