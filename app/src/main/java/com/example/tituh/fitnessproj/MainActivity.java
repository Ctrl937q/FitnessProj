package com.example.tituh.fitnessproj;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tituh.fitnessproj.Adapters.FitnessFragmentStartRecyclerViewAdapter;
import com.example.tituh.fitnessproj.Adapters.ViewPagerAdapter;
import com.example.tituh.fitnessproj.Fragments.AboutFragment;
import com.example.tituh.fitnessproj.Fragments.FitnessFragment;
import com.example.tituh.fitnessproj.Fragments.NutritionFramgment;
import com.example.tituh.fitnessproj.Fragments.WellnessFragment;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    ViewPager viewPager;
    MenuItem prevMenuItem;
    AboutFragment aboutFragment;
    FitnessFragment fitnessFragment;
    NutritionFramgment nutritionFramgment;
    WellnessFragment wellnessFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new AboutFragment()).commit();

        bottomNavigationView = findViewById(R.id.bottom_navigation_bar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        bottomNavigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener);
        TextView textViewActionBar = (TextView)findViewById(R.id.action_bar_text_view);
        textViewActionBar.setText("SKINNY GUIDE");

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                bottomNavigationView.getMenu().getItem(i).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        setupViewPager(viewPager);



    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        aboutFragment = new AboutFragment();
        fitnessFragment = new FitnessFragment();
        nutritionFramgment = new NutritionFramgment();
        wellnessFragment = new WellnessFragment();
        viewPagerAdapter.addFragment(aboutFragment);
        viewPagerAdapter.addFragment(fitnessFragment);
        viewPagerAdapter.addFragment(nutritionFramgment);
        viewPagerAdapter.addFragment(wellnessFragment);
        viewPager.setAdapter(viewPagerAdapter);
    }

    BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            Fragment selectFragment = null;

            switch (item.getItemId()) {
                case R.id.item_about:
                    selectFragment = new AboutFragment();
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.item_fitness:
                    selectFragment = new FitnessFragment();
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.item_nutrition:
                    selectFragment = new NutritionFramgment();
                    viewPager.setCurrentItem(2);
                    break;
                case R.id.item_wellness:
                    selectFragment = new WellnessFragment();
                    viewPager.setCurrentItem(3);
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    selectFragment).commit();

            return true;
        }
    };
}
