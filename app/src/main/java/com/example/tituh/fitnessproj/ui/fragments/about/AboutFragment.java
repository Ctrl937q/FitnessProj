package com.example.tituh.fitnessproj.ui.fragments.about;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class AboutFragment extends BaseFragment {

    private TextView mTextViewBigTextInstaSkinny;
    private TextView mTextViewBigTextInstaKim;
    private ImageView mImageViewInstaSkinny;
    private ImageView imageViewInstaKim;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.about_fragment, container, false);
            mImageViewInstaSkinny = view.findViewById(R.id.image_about_skinny);
            imageViewInstaKim = view.findViewById(R.id.image_about_kim);
            mTextViewBigTextInstaSkinny = view.findViewById(R.id.text_view_insta_sninny);
            mTextViewBigTextInstaKim = view.findViewById(R.id.text_view_insta_kim);
            mTextViewBigTextInstaKim.setText("@KIMKELLYFIT");
            mTextViewBigTextInstaSkinny.setText("@THESKINNYCONFIDENTIAL");


            imageViewInstaKim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/kimkellyfit/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    if (getActivity() != null) {
                        if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(openlinkIntent);
                        }
                    }
                }
            });

            mImageViewInstaSkinny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/theskinnyconfidential/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    if (getActivity() != null) {
                        if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(openlinkIntent);
                        }
                    }
                }
            });

            mTextViewBigTextInstaSkinny.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/theskinnyconfidential/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    if (getActivity() != null) {
                        if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(openlinkIntent);
                        }
                    }
                }
            });

            mTextViewBigTextInstaKim.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/kimkellyfit/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);
                    if (getActivity() != null) {
                        if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                            startActivity(openlinkIntent);
                        }
                    }
                }
            });
        }

        fragmentInteractionListener.visibleIconAboutActionBar();
        fragmentInteractionListener.goneIconBacktActionBar();

        return view;
    }
}
