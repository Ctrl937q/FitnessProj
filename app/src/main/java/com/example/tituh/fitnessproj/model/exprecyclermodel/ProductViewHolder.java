package com.example.tituh.fitnessproj.model.exprecyclermodel;

import android.view.View;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

public class ProductViewHolder extends ChildViewHolder {

    TextView mTextView;

    public ProductViewHolder(View itemView) {
        super(itemView);
        mTextView = itemView.findViewById(R.id.textView_product);

    }

    public void bind(Product product) {
        mTextView.setText(product.name);

    }
}
