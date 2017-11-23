package com.example.yagizozbek.orcacarbon;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Vector;

public class FirstUseActivity extends FragmentActivity {
     PagerAdapter pagerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_use);
        initializePagging();
    }
    public void initializePagging()
    {
        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(this, Fragment1.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment2.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment3.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment4.class.getName()));
        fragments.add(Fragment.instantiate(this, Fragment5.class.getName()));
        pagerAdapter = new com.example.yagizozbek.orcacarbon.PagerAdapter(this.getSupportFragmentManager(),fragments);
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            private int lastPos = 0;

            @Override
            public void onPageScrollStateChanged(int state) {
            }

            @Override
            public void onPageSelected(int position) {
                ImageView myTextView;
                switch (position) {
                    case 0:
                        myTextView = (ImageView) findViewById(R.id.imgFirstico);
                        break;
                    case 1:
                        myTextView = (ImageView) findViewById(R.id.imgSecondico);
                        break;
                    case 2:
                        myTextView = (ImageView) findViewById(R.id.imgThirdico);
                        break;
                    case 3:
                        myTextView = (ImageView) findViewById(R.id.imgFourthico);
                        break;
                    case 4:
                        myTextView = (ImageView) findViewById(R.id.imgFifthico);
                        break;
                    default:
                        myTextView = null;
                        break;
                }
                myTextView.setImageResource(R.mipmap.leftfootprint_on);
                switch (lastPos) {
                    case 0:
                        myTextView = (ImageView) findViewById(R.id.imgFirstico);
                        break;
                    case 1:
                        myTextView = (ImageView) findViewById(R.id.imgSecondico);
                        break;
                    case 2:
                        myTextView = (ImageView) findViewById(R.id.imgThirdico);
                        break;
                    case 3:
                        myTextView = (ImageView) findViewById(R.id.imgFourthico);
                        break;
                    case 4:
                        myTextView = (ImageView) findViewById(R.id.imgFifthico);
                        break;
                    default:
                        myTextView = null;
                        break;
                }
                myTextView.setImageResource(R.mipmap.leftfootprint_off);
                lastPos = position;
            }

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
        });
    }
    public void onClick(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }
}
