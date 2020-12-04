package com.example.gamemate.tabgoogleplay;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.view.View;
import android.view.ViewStructure;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.gamemate.R;
import com.google.android.material.tabs.TabLayout;


public class TabGooglePlayActivity extends AppCompatActivity {



    TabGooglePlayAdapter tabGooglePlayAdapter;
    Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_google_play);

        ButterKnife.bind(this);
        unbinder = ButterKnife.bind(this);

        setupTabLayout();
        searchView.setHint("Search Home");
    }

    /*
    Fungsi untuk mengganti warna pada status bar
     */
    public void setStatusBarColor(String color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            int statusBarColor = Color.parseColor(color);
            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(statusBarColor);
        }
    }

    /*
    FUngsi untuk membuat dan mengkonfigurasi tab.
     */
    private void setupTabLayout() {
        ActionBar tabLayout;
        tabLayout.addTab(tabLayout.newTab().setText("HOME"));
        tabLayout.addTab(tabLayout.newTab().setText("GAMES"));
        tabLayout.addTab(tabLayout.newTab().setText("MOVIES"));
        tabLayout.addTab(tabLayout.newTab().setText("BOOKS"));
        tabLayout.newTab(TabLayout.GRAVITY_FILL);
        tabGooglePlayAdapter = new TabGooglePlayAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        ViewPager viewPager;
        viewPager.setAdapter(tabGooglePlayAdapter);
        viewPager.setCurrentItem(0);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addTab(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                /*
                Switch case disini berfungsi untuk mengatur warna dan hint ketika disuatu posisi.
                Contoh :
                jika tab berada di posisi 0 yang berarti posisi 0 ini adalah tab pada kategori Home,
                warnanya akan berubah dan juga hint pada searchview akan berubah.

                posisi 0 = HOME
                posisi 1 = GAMES
                posisi 2 = MOVIES
                posisi 3 = BOOKS
                 */
                switch (tab.getPosition()) {
                    case 0:
                        setStatusBarColor("#3F51B5");
                        tabLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                        View rlSearch;
                        rlSearch.setBackgroundColor(Color.parseColor("#3F51B5"));
                        TextView searchView;
                        searchView.setHint("Search Home");
                        break;
                    case 1:
                        setStatusBarColor("#007a0e");
                        tabLayout.setBackgroundColor(Color.parseColor("#007a0e"));
                        rlSearch.setBackgroundColor(Color.parseColor("#007a0e"));
                        searchView.setHint("Search Games");
                        break;
                    case 2:
                        setStatusBarColor("#960000");
                        tabLayout.setBackgroundColor(Color.parseColor("#960000"));
                        rlSearch.setBackgroundColor(Color.parseColor("#960000"));
                        searchView.setHint("Search Movies");
                        break;
                    case 3:
                        setStatusBarColor("#008282");
                        tabLayout.setBackgroundColor(Color.parseColor("#008282"));
                        rlSearch.setBackgroundColor(Color.parseColor("#008282"));
                        searchView.setHint("Search Books");
                        break;
                }
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
