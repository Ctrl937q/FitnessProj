package com.example.tituh.fitnessproj.ui.fragments.community;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class CommunityTabFragmentSecondBot extends BaseFragment {

    private TextView textViewLinKim;
    private ImageView imageView_insta_kim;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.community_tab_bot_second, container, false);
            textViewLinKim = view.findViewById(R.id.textView_href_community_kim);
            imageView_insta_kim = view.findViewById(R.id.imageView_insta_kim);

            imageView_insta_kim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/kimkellyfit/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);

                    if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(openlinkIntent);
                    }
                }
            });

            textViewLinKim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/kimkellyfit/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(openlinkIntent);
                    }
                }
            });


            textViewLinKim.setText("@KIMKELLYFIT");
            textViewLinKim.setMovementMethod(LinkMovementMethod.getInstance());

        }
        return view;
    }
}
