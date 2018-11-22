package com.example.tituh.fitnessproj.helpers;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MarginItemDecoration extends RecyclerView.ItemDecoration {
    private final int columns;
    private int marginTop;
    int marginBot;
    int marginLeft;
    int marginRight;

    public MarginItemDecoration(int columns, int marginTop, int marginBot, int marginLeft, int marginRight) {
        this.columns = columns;
        this.marginTop = marginTop;
        this.marginBot = marginBot;
        this.marginLeft = marginLeft;
        this.marginRight = marginRight;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.bottom = marginBot;
        outRect.top = marginTop;
        outRect.left = marginLeft;
        outRect.right = marginRight;
    }
}