package com.news.idetechmedia.bitcoinapp.Fragment;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.google.android.material.tabs.TabLayout;
import com.news.idetechmedia.bitcoinapp.DashboardActivity;
import com.news.idetechmedia.bitcoinapp.R;


public class HomeFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_home, container, false);

        requireActivity().getWindow().setStatusBarColor(getActivity().getApplicationContext().getResources().getColor(android.R.color.transparent));
        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        ViewStateAdapter viewStateAdapter = new ViewStateAdapter(this);
        viewPager = view.findViewById(R.id.viewPager2);
        viewPager.setOffscreenPageLimit(1);
        viewPager.setAdapter(viewStateAdapter);
        viewPager.setUserInputEnabled(false);

        tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }


    @SuppressWarnings("InnerClassMayBeStatic")
    private class ViewStateAdapter extends FragmentStateAdapter {

        public ViewStateAdapter(Fragment fragment) {
            super(fragment);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            Fragment fragment;
            if (position == 0) {
                fragment = new BitcoinFragment();
            } else if (position == 1){
                fragment = new EtherumFragment();
            }else if (position == 2){
                fragment = new StellarFragment();
            }else if (position == 3){
                fragment = new CardanoFragment();
            }else if (position == 4){
                fragment = new DogecoinFragment();
            }else if (position == 5){
                fragment = new TetherFragment();
            }else if (position == 6){
                fragment = new USD_CoinFragment();
            }else if (position == 7){
                fragment = new XRPFragment();
            }else if (position == 8){
                fragment = new SolanaFragment();
            }else if (position == 9){
                fragment = new AvalancheFragment();
            }else if (position == 10){
                fragment = new CosmosFragment();
            }else if (position == 11){
                fragment = new RippleFragment();
            }else if (position == 12){
                fragment = new Shiba_InuFragment();
            }else if (position == 13){
                fragment = new PolkadotFragment();
            }else if (position == 14){
                fragment = new TRONFragment();
            }else if (position == 15){
                fragment = new PolygonFragment();
            }else if (position == 16){
                fragment = new LitecoinFragment();
            }else if (position == 17){
                fragment = new TerraFragment();
            }else if (position == 18){
                fragment = new CosmosFragment();
            }else if (position == 19){
                fragment = new FTX_TokenFragment();
            }else if (position == 20){
                fragment = new FantomFragment();
            }else if (position == 21){
                fragment = new ChromiaFragment();
            }else if (position == 22){
                fragment = new MoneroFragment();
            }else if (position == 23){
                fragment = new BNBFragment();
            }else if (position == 24){
                fragment = new EOSFragment();
            }else if (position == 25){
                fragment = new DaiFragment();
            }else {
                fragment = new Matic_NetworkFragment();
            }
            return fragment;
        }

        @Override
        public int getItemCount() {
            // Hardcoded, use lists
            return 27;
        }
    }
}