package com.example.admin.myresume;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.myresume.ui.MyStrengthsFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by admin on 11/03/17.
 */

public class DrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, OnMapReadyCallback {

    private static final int NUM_PAGES = 3;
    private static final String[] mySkills = {"My Skills", "JAVA/J2EE", "ANDROID", "MySQL"};
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private LinearLayout linearLayoutSkills;
    private static String TOOLBAR_TITLE = "Niraj Kumar Manjhi , 23";
    private static String TOOLBAR_SUBTITLE = "Java | Android Developer";

    private boolean backPressedToExitOnce = false;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(TOOLBAR_TITLE);
        toolbar.setSubtitle(TOOLBAR_SUBTITLE);
        setSupportActionBar(toolbar);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new LoginPageAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        populateMySkills();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (backPressedToExitOnce) {
                super.onBackPressed();
            } else {
                this.backPressedToExitOnce = true;
                Toast.makeText(this, "Please back press again", Toast.LENGTH_SHORT).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        backPressedToExitOnce = false;
                    }
                }, 2000);
            }
        }
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng bangalore = new LatLng(12.940377, 77.704978);
        googleMap.addMarker(new MarkerOptions().position(bangalore)
                .title("Isha casablanca, Panathur"));
        googleMap.setMinZoomPreference(12.0f);
        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(bangalore, -20.0f));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(bangalore));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_highlits) {

        } else if (id == R.id.nav_Work_experience) {

        } else if (id == R.id.nav_education) {
            displayEducation();

        } else if (id == R.id.nav_contact) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private class LoginPageAdapter extends FragmentStatePagerAdapter {
        public LoginPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            String contentText = null;
            switch (position) {
                case 0:
                    contentText = "I am passionate towards app developement";
                    break;

                case 1:
                    contentText = "I am a team player";
                    break;

                case 2:
                    contentText = "Having fun in workplace is how i work.";
                    break;
            }

            return MyStrengthsFragment.newInstance(contentText);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }



    public void populateMySkills(){
        linearLayoutSkills = (LinearLayout) findViewById(R.id.hz_scroll_linear_layout_skills);
        LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        llp.setMargins(8,8,8,8);
        TextView mySkillText = new TextView(this);
        mySkillText.setText(mySkills[0]);
        mySkillText.setWidth(450);
        mySkillText.setHeight(350);
        mySkillText.setTextSize(30);
        mySkillText.setTextColor(Color.parseColor("#ffffff"));
        mySkillText.setGravity(Gravity.CENTER);
        mySkillText.setTypeface(null, Typeface.BOLD);
        mySkillText.setLayoutParams(llp);
        mySkillText.setBackgroundResource(R.drawable.tags_rounded_corners);
        GradientDrawable drawable = (GradientDrawable) mySkillText.getBackground();
        drawable.setColor(Color.parseColor("#C51162"));
        linearLayoutSkills.addView(mySkillText);

        for (int i =1; i < mySkills.length; i++){
            TextView mySkillText1 = new TextView(this);
            mySkillText1.setText(mySkills[i]);
            mySkillText1.setWidth(400);
            mySkillText1.setHeight(300);
            mySkillText1.setTextSize(20);
            mySkillText1.setTextColor(Color.BLACK);
            mySkillText1.setGravity(Gravity.CENTER);
            mySkillText1.setTypeface(null, Typeface.BOLD);
            mySkillText1.setLayoutParams(llp);
            mySkillText1.setBackgroundResource(R.drawable.tags_rounded_corners);
            GradientDrawable drawable1 = (GradientDrawable) mySkillText1.getBackground();
            drawable1.setColor(Color.parseColor("#B0BEC5"));
            linearLayoutSkills.addView(mySkillText1);
        }
    }

    public void displayEducation() {
        Intent intent = new Intent(this, EducationActivity.class);
        startActivity(intent);
    }
}
