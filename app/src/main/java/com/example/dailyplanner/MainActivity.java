package com.example.dailyplanner;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private BottomNavigationView bottomNavBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        bottomNavBar = findViewById(R.id.bottomNavBar);

        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        bottomNavBar.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.nav_home) {
                    viewPager.setCurrentItem(0);
                    return true;
                } else if (id == R.id.nav_settings) {
                    viewPager.setCurrentItem(1);
                    return true;
                } else if (id == R.id.nav_status) {
                    viewPager.setCurrentItem(2);
                    return true;
                }
                return false;
            }
        });

        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                if (position == 0) {
                    bottomNavBar.getMenu().findItem(R.id.nav_home).setChecked(true);
                } else if (position == 1) {
                    bottomNavBar.getMenu().findItem(R.id.nav_settings).setChecked(true);
                } else if (position == 2) {
                    bottomNavBar.getMenu().findItem(R.id.nav_status).setChecked(true);
                }
            }
        });
    }
}
