package com.example.admin.myresume;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

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

public class ActivityTest extends AppCompatActivity implements OnMapReadyCallback {

    private static final int NUM_PAGES = 3;
    private static final String[] mySkills = {"My Skills", "JAVA/J2EE", "ANDROID", "MySQL"};
    ImageButton m_expndbtn;
    ImageButton m_collapsebtn;
    LinearLayout m_layoutExpand;
    CardView crdView6;
    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;
    private LinearLayout linearLayoutSkills;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_activity);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        m_expndbtn = (ImageButton) findViewById(R.id.imgbtn_expand);
        m_collapsebtn = (ImageButton) findViewById(R.id.imgbtn_collapse);
        m_layoutExpand = (LinearLayout) findViewById(R.id.linear_education2);
        crdView6 = (CardView) findViewById(R.id.card_view6);

        m_expndbtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (!m_layoutExpand.isShown()) {
                    m_layoutExpand.setVisibility(View.VISIBLE);
                    m_expndbtn.setVisibility(View.INVISIBLE);
                    m_collapsebtn.setVisibility(View.VISIBLE);
                }
            }
        });

        m_collapsebtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (m_layoutExpand.isShown()) {
                    m_layoutExpand.setVisibility(View.INVISIBLE);
                    m_expndbtn.setVisibility(View.VISIBLE);
                    m_collapsebtn.setVisibility(View.INVISIBLE);
                    //crdView6.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,500));
                    //crdView6.setLayout;
                    // LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                    //        LinearLayout.LayoutParams.MATCH_PARENT, 500);
                    //layoutParams.setMargins(8,8,8,8);
                    //crdView6.setLayoutParams(layoutParams);
                }
            }
        });

        mPager = (ViewPager) findViewById(R.id.viewpager);
        mPagerAdapter = new LoginPageAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        populateMySkills();
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
}
