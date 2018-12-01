package com.example.tituh.fitnessproj.helpers;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MarginItemDecoration extends RecyclerView.ItemDecoration {
    private int mColumns;
    private int mMarginTop;
    private int mMarginBot;
    private int mMarginLeft;
    private int mMarginRight;

    public MarginItemDecoration(int columns, int marginTop, int marginBot, int marginLeft, int marginRight) {
        this.mColumns = columns;
        this.mMarginTop = marginTop;
        this.mMarginBot = marginBot;
        this.mMarginLeft = marginLeft;
        this.mMarginRight = marginRight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = mMarginBot;
        outRect.top = mMarginTop;
        outRect.left = mMarginLeft;
        outRect.right = mMarginRight;
    }
}