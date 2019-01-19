package com.example.tituh.fitnessproj.ui.fragments.nutrition;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tituh.fitnessproj.R;
import com.example.tituh.fitnessproj.adapters.ProductAdapter;
import com.example.tituh.fitnessproj.adapters.ViewPagerAdapterForTips;
import com.example.tituh.fitnessproj.model.exprecyclermodel.Company;
import com.example.tituh.fitnessproj.model.exprecyclermodel.Product;
import com.example.tituh.fitnessproj.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class SkinnyHacksFragment extends BaseFragment {

    private ViewPager mViewPager;
    private ViewPager mViewPagerBot;
    private SkinnyHacksTopFirstScreen mFirstFragmentSkinnyHacksTop;
    private SkinnyHacksTopSecondScreen mSecondFragmentSkinnyHacksTop;

    private SkinnyHacksBotFirstScreen mSkinnyHacksBotFirstScreen;
    private SkinnyHacksBotSecondScreen mSkinnyHacksBotSecondScreen;
    private SkinnyHacksBotThirdScreen mSkinnyHacksBotThirdScreen;

    private TabLayout mTabDotLayout;
    private TabLayout mTabDotLayoutBot;
    private Button button;

    private RecyclerView recyclerViewExp;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.skinny_hacks_fragment, container, false);
            mViewPager = view.findViewById(R.id.view_pager_tips);
            mViewPagerBot = view.findViewById(R.id.view_pager_bot_hacks);
            mTabDotLayout = view.findViewById(R.id.tabDots);
            mTabDotLayoutBot = view.findViewById(R.id.tabDots_hack);
            recyclerViewExp = view.findViewById(R.id.exp_recyclerView_hacks);
            mTabDotLayout.setupWithViewPager(mViewPager, true);
            mTabDotLayoutBot.setupWithViewPager(mViewPagerBot, true);
            button = view.findViewById(R.id.btn_go_to_recipes);

            recyclerViewExp.setLayoutManager(new LinearLayoutManager(getActivity()));

            ArrayList<Company>companies = new ArrayList<>();
            ArrayList<Product> macapowder = new ArrayList<>();
            ArrayList<Product> probiotics = new ArrayList<>();
            ArrayList<Product> magnesium = new ArrayList<>();
            ArrayList<Product> collagen = new ArrayList<>();
            ArrayList<Product> turmeric = new ArrayList<>();
            ArrayList<Product> omega = new ArrayList<>();
            ArrayList<Product> biotin = new ArrayList<>();
            ArrayList<Product> calcium = new ArrayList<>();
            ArrayList<Product> zinc = new ArrayList<>();
            ArrayList<Product> melatonin = new ArrayList<>();

            ArrayList<Product> magnesiumCitrate = new ArrayList<>();
            ArrayList<Product> iron = new ArrayList<>();
            ArrayList<Product> bcaa = new ArrayList<>();
            ArrayList<Product> vitaminC = new ArrayList<>();
            ArrayList<Product> oliveOil = new ArrayList<>();
            ArrayList<Product> fermentedFood = new ArrayList<>();
            ArrayList<Product> leafyGreens = new ArrayList<>();
            ArrayList<Product> chiaSeeds = new ArrayList<>();
            ArrayList<Product> apple = new ArrayList<>();
            ArrayList<Product> flaxSeeds = new ArrayList<>();

            ArrayList<Product> unsaltedrawNuts = new ArrayList<>();
            ArrayList<Product> rawCoconutOil = new ArrayList<>();
            ArrayList<Product> bonebroth = new ArrayList<>();
            ArrayList<Product> celery = new ArrayList<>();
            ArrayList<Product> cucumber = new ArrayList<>();
            ArrayList<Product> beets = new ArrayList<>();
            ArrayList<Product> mushrooms = new ArrayList<>();


            macapowder.add(new Product("• enhance energy, stamina, athletic performance and memory"));
            macapowder.add(new Product("• high in calcium, potassium, iron, magnesium, phosphorus and zinc"));
            macapowder.add(new Product("• recommended for adrenal fatigue"));

            probiotics.add(new Product("• help with digestive & urinary health"));
            probiotics.add(new Product("• aids with allergies & immunity"));
            probiotics.add(new Product("• helps support healthy intestinal function and the ability to absorb nutrients from food and other supplements"));

            magnesium.add(new Product("• relaxes muscles & promotes peaceful sleep"));

            collagen.add(new Product("• prevents aging & urinary health"));
            collagen.add(new Product("• aids with allergies & immunity"));

            turmeric.add(new Product("• contains cucumin, which reduces inflammation in the body"));
            turmeric.add(new Product("• blocks enzymes that cause swelling and pain in the body"));
            turmeric.add(new Product("• increases capacity for antioxidants"));

            omega.add(new Product("• essential fatty acids that help promote heart health, immune & nervous system"));
            omega.add(new Product("• helps support healthy skin and nails"));
            omega.add(new Product("• helps lower triglyceride levels which lower the risk of heart disease"));
            omega.add(new Product("• aids in weight management by supporting healthy metabolism, and providing and storing energy for the body"));
            omega.add(new Product("• have potent anti-inflammatory properties"));

            biotin.add(new Product("• helps body metabolize carbohydrates, fats and amino acids-the building blocks of protein."));
            biotin.add(new Product("• supports healthy hair, skin and nails"));

            calcium.add(new Product("• helps keep bones and teeth strong and reduces the risk of osteoporosis"));
            calcium.add(new Product("• vitamin d helps body absorb calcium better"));

            zinc.add(new Product("• keeps immune system healthy"));
            zinc.add(new Product("• promotes good skeletal development"));
            zinc.add(new Product("• keeps energy & metabolism levels high"));

            melatonin.add(new Product("• naturally made by brain to help regulate your sleep cycle"));
            melatonin.add(new Product("• if you’re having trouble sleeping through the night, taking melatonin may help"));

            magnesiumCitrate.add(new Product("• magnesium is needed in order for your muscles to function properly"));
            magnesiumCitrate.add(new Product("• may also help increase energy levels, glucose metabolism and help regulate the amount of calcium in your body"));

            iron.add(new Product("• always have your iron levels checked, especially if you’re feeling sluggish or unusually tired"));
            iron.add(new Product("• responsible for carrying oxygen throughout the body and for the formation of red blood cells"));

            bcaa.add(new Product("• BCAA’s are the building blocks of muscle and are important for sports performance as they contribute to reducing muscle damage and soreness"));

            vitaminC.add(new Product("• needed for growth & repair of tissues in all parts of your body"));
            vitaminC.add(new Product("• helps the body make collagen, an important protein used to make skin, cartilage, tendons, ligaments &blood vessels"));
            vitaminC.add(new Product("• aids in healing wounds & repairing and maintaining bones & teeth"));
            vitaminC.add(new Product("• protects against immune system deficiencies, cardiovascular disease, prenatal health problems, eye disease and even skin wrinkling"));

            oliveOil.add(new Product("• prevents pro-inflammatory enzymes"));
            oliveOil.add(new Product("• healthy fats"));
            oliveOil.add(new Product("• contains polyphenols, which prevents the release of inflammatory compounds"));

            fermentedFood.add(new Product("• kombucha, sauerkraut, gut shot"));
            fermentedFood.add(new Product("• probiotics balance the bacteria in your gut for better health"));
            fermentedFood.add(new Product("• improves digestive health, immunity, nutrient absorption, reduced inflammation"));

            leafyGreens.add(new Product("• healthy complexion, increases energy, weight loss"));
            leafyGreens.add(new Product("• high in calcium, iron and magnesium"));

            chiaSeeds.add(new Product("• omega 3 fatty acids, high fiber and protein"));

            apple.add(new Product("• reduces bloating, belching and heartburn lowers"));
            apple.add(new Product("• bad cholesterol"));

            flaxSeeds.add(new Product("• contains ALA omega 3s & high fiber"));
            flaxSeeds.add(new Product("• has most cancer fighting chemicals of any food on the planet"));

            unsaltedrawNuts.add(new Product("• vitamin e, reduces inflammation and protects the body from free radicals"));

            rawCoconutOil.add(new Product("• repairs brain function & full of healthy fats"));

            bonebroth.add(new Product("• improves joint health & reduces cellulite minerals in an easily absorbed form"));

            celery.add(new Product("• reduces bloating & contains electrolytes"));
            celery.add(new Product("• prevents dehydration & ulcers"));

            cucumber.add(new Product("• contains potassium & b vitamins"));

            beets.add(new Product("• lowers blood pressure & increase stamina"));

            mushrooms.add(new Product("• boost immune system"));
            mushrooms.add(new Product("• provides essential nutrients like vitamin b, d & potassium"));



            Company macapowderComp = new Company("MACA POWDER", macapowder);
            Company probioticsComp = new Company("PROBIOTICS", probiotics);
            Company magnesiumComp = new Company("MAGNESIUM", magnesium);
            Company collagenCom = new Company("COLLAGEN", collagen);
            Company turmericCom = new Company("TURMERIC", turmeric);
            Company omegaCom = new Company("OMEGA-3 (ALA)", omega);
            Company biotinCom = new Company("BIOTIN", biotin);
            Company calciumCom = new Company("CALCIUM +VITAMIN D", calcium);
            Company zincComp = new Company("ZINC", zinc);
            Company melatoninComp = new Company("MELATONIN", melatonin);
            Company magnesiumCitrateComp = new Company("MAGNESIUM CITRATE", magnesiumCitrate);
            Company ironComp = new Company("IRON", iron);
            Company bcaaComp = new Company("BCAA (branched-chain amino acids)", bcaa);
            Company vitaminCComp = new Company("VITAMIN C", vitaminC);
            Company oliveOilComp = new Company("OLIVE OIL", oliveOil);
            Company fermentedFoodComp = new Company("FERMENTED FOOD (FARMHOUSE CULTURE)", fermentedFood);
            Company leafyGreensComp = new Company("LEAFY GREENS", leafyGreens);
            Company chiaSeedsComp = new Company("CHIA SEEDS", chiaSeeds);
            Company appleComp = new Company("APPLE CIDERVINEGAR", apple);
            Company flaxSeedsComp = new Company("FLAX SEEDS", flaxSeeds);
            Company unsaltedrawNutsComp = new Company("UNSALTEDRAW NUTS", unsaltedrawNuts);
            Company rawCoconutOilComps = new Company("RAWCOCONUT OIL", rawCoconutOil);
            Company bonebrothComp = new Company("BONE BROTH", bonebroth);
            Company celeryComp = new Company("CELERY", celery);
            Company cucumberComp = new Company("CUCUMBER", cucumber);
            Company beetsComp = new Company("BEETS", beets);
            Company mushroomsComp = new Company("MUSHROOMS", mushrooms);

            companies.add(macapowderComp);
            companies.add(probioticsComp);
            companies.add(magnesiumComp);
            companies.add(collagenCom);
            companies.add(turmericCom);
            companies.add(omegaCom);
            companies.add(biotinCom);
            companies.add(calciumCom);
            companies.add(zincComp);
            companies.add(melatoninComp);
            companies.add(magnesiumCitrateComp);
            companies.add(ironComp);
            companies.add(bcaaComp);
            companies.add(vitaminCComp);
            companies.add(oliveOilComp);
            companies.add(fermentedFoodComp);
            companies.add(leafyGreensComp);
            companies.add(chiaSeedsComp);
            companies.add(appleComp);
            companies.add(flaxSeedsComp);
            companies.add(unsaltedrawNutsComp);
            companies.add(rawCoconutOilComps);
            companies.add(bonebrothComp);
            companies.add(celeryComp);
            companies.add(cucumberComp);
            companies.add(beetsComp);
            companies.add(mushroomsComp);



            ProductAdapter adapter = new ProductAdapter(companies);
            recyclerViewExp.setAdapter(adapter);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    fragmentInteractionListener.pushFragment(new RecipesFragment(), true);
                }
            });

            mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {

                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });

            mViewPagerBot.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int i, float v, int i1) {

                }

                @Override
                public void onPageSelected(int i) {

                }

                @Override
                public void onPageScrollStateChanged(int i) {

                }
            });
            setupViewPager(mViewPager);
            setupViewPagerBot(mViewPagerBot);
        }
        fragmentInteractionListener.goneIconAbouttActionBar();
        fragmentInteractionListener.updateActionBarTitle("SKINNY HACKS");
        fragmentInteractionListener.visibleIconBacktActionBar();
        return view;
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapterForTips viewPagerAdapter = new ViewPagerAdapterForTips(getChildFragmentManager());
        mFirstFragmentSkinnyHacksTop = new SkinnyHacksTopFirstScreen();
        mSecondFragmentSkinnyHacksTop = new SkinnyHacksTopSecondScreen();
        viewPagerAdapter.addFragment(mFirstFragmentSkinnyHacksTop);
        viewPagerAdapter.addFragment(mSecondFragmentSkinnyHacksTop);
        viewPager.setAdapter(viewPagerAdapter);
    }

    private void setupViewPagerBot(ViewPager viewPager){
        ViewPagerAdapterForTips viewPagerAdapter = new ViewPagerAdapterForTips(getChildFragmentManager());
        mSkinnyHacksBotFirstScreen = new SkinnyHacksBotFirstScreen();
        mSkinnyHacksBotSecondScreen = new SkinnyHacksBotSecondScreen();
        mSkinnyHacksBotThirdScreen = new SkinnyHacksBotThirdScreen();
        viewPagerAdapter.addFragment(mSkinnyHacksBotFirstScreen);
        viewPagerAdapter.addFragment(mSkinnyHacksBotSecondScreen);
        viewPagerAdapter.addFragment(mSkinnyHacksBotThirdScreen);
        viewPager.setAdapter(viewPagerAdapter);
    }
}
