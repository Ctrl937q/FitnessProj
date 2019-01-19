package com.example.tituh.fitnessproj.model.exprecyclermodel;

import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import static android.view.animation.Animation.RELATIVE_TO_SELF;

public class CompanyViewHolder extends GroupViewHolder {

    TextView mTextView;
    ImageView imageView;
    int count = 0;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textView_company);
        imageView = itemView.findViewById(R.id.image_view_exp_rv_arrow);
    }

    public void bind(Company company) {
        mTextView.setText(company.getTitle());
    }

    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }

    private void animateExpand() {
        imageView.setImageResource(R.drawable.close_exp_rv_iconn);
        RotateAnimation rotate =
                new RotateAnimation(360, 180, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        imageView.setAnimation(rotate);
    }

    private void animateCollapse() {
        imageView.setImageResource(R.drawable.open_exp_rv_icon);
        RotateAnimation rotate =
                new RotateAnimation(180, 360, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        imageView.setAnimation(rotate);
    }
}

