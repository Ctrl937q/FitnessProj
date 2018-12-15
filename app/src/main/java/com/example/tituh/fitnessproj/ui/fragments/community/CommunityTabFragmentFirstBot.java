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

public class CommunityTabFragmentFirstBot extends BaseFragment {

    TextView textViewLinkLaurin;
    ImageView imageViewInstaLaurin;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null){
            view = inflater.inflate(R.layout.community_tab_bot_first, container, false);
            textViewLinkLaurin = view.findViewById(R.id.textView_href_community_laurin);
            imageViewInstaLaurin = view.findViewById(R.id.imageView_insta_laurin);
            textViewLinkLaurin.setText("@theskinnyconfidential");
            textViewLinkLaurin.setMovementMethod(LinkMovementMethod.getInstance());

            imageViewInstaLaurin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/theskinnyconfidential/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);

                    if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(openlinkIntent);
                    } else {
                        Log.d("Intent", "Не получается обработать намерение!");
                    }
                }
            });

            textViewLinkLaurin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Uri address = Uri.parse("https://www.instagram.com/theskinnyconfidential/");
                    Intent openlinkIntent = new Intent(Intent.ACTION_VIEW, address);

                    if (openlinkIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(openlinkIntent);
                    } else {
                        Log.d("Intent", "Не получается обработать намерение!");
                    }
                }
            });

        }
            return view;
    }
}
