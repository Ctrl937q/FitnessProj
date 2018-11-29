package com.example.tituh.fitnessproj.ui.fragments.fitness.week_workout;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.ui.activities.MainActivity;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

public class AwardFragment extends BaseFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.award_fragment, container, false);
        ((MainActivity) getActivity()).goneIconAbouttActionBar();
        ((MainActivity) getActivity()).visibilityIconShareActionBar();
        ((MainActivity) getActivity()).goneIconInfoActionBar();
        ((MainActivity) getActivity()).goneIconHomeActionBar();
        ((MainActivity) getActivity()).visibleIconBacktActionBar();

        Button buttonMainMenu = rootView.findViewById(R.id.button_main_manu_award);

        buttonMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentInteractionListener.pushFragment(new DayWorkoutFragment(), false, getClass().getName());
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt(
                        fragmentManager.getBackStackEntryCount() - 2).getId(), FragmentManager.POP_BACK_STACK_INCLUSIVE);

                //FragmentManager fragmentManager = getFragmentManager();
                /*Fragment fragment = getFragmentManager().findFragmentByTag("awarddddfragq");
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);

                if(fragment != null) {
                    Log.d("doooooooo", "" + fragment);

                    getFragmentManager().beginTransaction().remove(fragment).commit();

                    Log.d("pooosleeeeeee", "" + fragment);

                }*/
                /*getFragmentManager().popBackStack();
                getFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new DayWorkoutFragment())
                        .addToBackStack(null)
                        .commit();*/

            }
        });
        return rootView;
    }

    @Override
    public void onResume() {
        FragmentManager fragmentManager = getFragmentManager();
        Log.d("dasdaf32rdfge", "" + fragmentManager.getBackStackEntryCount());
        super.onResume();
    }

}
