package com.news.idetechmedia.bitcoinapp;

import static com.pesonal.adsdk.AppManage.ADMOB_N;
import static com.pesonal.adsdk.AppManage.FACEBOOK_N;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.ActivityNavigator;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.news.idetechmedia.bitcoinapp.bottomNavigationFragment.HomeMenuFragment;
import com.news.idetechmedia.bitcoinapp.bottomNavigationFragment.TrendingMenuFragment;
import com.news.idetechmedia.bitcoinapp.bottomNavigationFragment.VideosMenuFragment;
import com.news.idetechmedia.bitcoinapp.databinding.ActivityDashboardBinding;
import com.pesonal.adsdk.AppManage;

public class DashboardActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    ActivityDashboardBinding binding;
    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout drawer;
    NavigationView navigationView;
    private NavController navController;
//    TabLayout tablayout;
//    ViewPager viewpager;
//    RelativeLayout menu_btn;
//    DrawerLayout draw_lay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE |
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        // making notification bar transparent
        changeStatusBarColor();
        getWindow().setStatusBarColor(DashboardActivity.this.getResources().getColor(android.R.color.transparent));
        Toolbar toolbar = findViewById(R.id.toolbar);


        navigationView = findViewById(R.id.nav_view);
        navigationView.setItemIconTintList(null);
        setSupportActionBar(toolbar);
        drawer = binding.drawerLayout;

        BottomNavigationView bottomNavView = findViewById(R.id.bottom_nav_view);
        bottomNavView.setItemIconTintList(null);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_videos, R.id.nav_trending)
                .setOpenableLayout(binding.drawerLayout)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(bottomNavView, navController);
        binding.navView.setNavigationItemSelectedListener(this);
//        tablayout=findViewById(R.id.tablayout);
//        viewpager=findViewById(R.id.viewpager);
//        PagerAdapter adapter=new PageAdapter(getSupportFragmentManager());
//        viewpager.setAdapter(adapter);
//        tablayout.setupWithViewPager(viewpager);
//        draw_lay = findViewById(R.id.draw_lay);
//        menu_btn = findViewById(R.id.menu_btn);
//        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
//        bottomNav.setOnNavigationItemSelectedListener(navListener);
//
//        // as soon as the application opens the first
//        // fragment should be shown to the user
//        // in this case it is algorithm fragment
//        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeMenuFragment()).commit();
//        menu_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                draw_lay.openDrawer(Gravity.LEFT);
//            }
//        });
//
//
//
//
//    }
//    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            // By using switch we can easily get
//            // the selected fragment
//            // by using there id.
//            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.home:
//                    selectedFragment = new HomeMenuFragment();
//                    break;
//                case R.id.videos:
//                    selectedFragment = new VideosMenuFragment();
//                    break;
//                case R.id.trending:
//                    selectedFragment = new TrendingMenuFragment();
//                    break;
//            }
//            // It will help to replace the
//            // one fragment to other.
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, selectedFragment)
//                    .commit();
//            return true;
//        }
    }
    @Override
    public void onBackPressed() {
        exitApp();
    }
    public void exitApp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = LayoutInflater.from(this).inflate(R.layout.exit_app_dailog, null);
        TextView no_btn = view.findViewById(R.id.no_btn);
        TextView yes_btn = view.findViewById(R.id.yes_btn);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
                System.exit(0);

            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_home) {
//            navController.navigate(R.id.nav_home);
            AppManage.getInstance(DashboardActivity.this).showInterstitialAd(DashboardActivity.this, new AppManage.MyCallback() {
                public void callbackCall() {
//                    Intent intent = new Intent(DashboardActivity.this, DashboardActivity.class);
//                    startActivity(intent);
                    navController.navigate(R.id.nav_home);
                }
            },"",AppManage.app_mainClickCntSwAd);
        } else if(id == R.id.menu_rate_us){
            drawer.closeDrawers();
            launchMarket();
        }else if(id == R.id.menu_share){
            drawer.closeDrawers();
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }else if(id==R.id.menu_about_us){
            navController.navigate(R.id.nav_home);
        }else if(id==R.id.menu_privacy){
            gotoUrl("https://techiemediaadvertising.blogspot.com/2022/06/techiemedia-inc.html");
        }
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }
    private void launchMarket() {
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent myAppLinkToMarket = new Intent(Intent.ACTION_VIEW, uri);
        try {
            startActivity(myAppLinkToMarket);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(this, " unable to find market app", Toast.LENGTH_LONG).show();
        }
    }
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(R.drawable.button);
        }
    }
    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW, uri));
    }


}