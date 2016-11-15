package kr.thesongbookandroid;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("검색"));
        tabLayout.addTab(tabLayout.newTab().setText("신곡"));
        tabLayout.addTab(tabLayout.newTab().setText("인기곡"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        OnTabSelectedListen OnTabSelectedListener = new OnTabSelectedListen(viewPager);
        tabLayout.setOnTabSelectedListener(OnTabSelectedListener);


//        setContentView(R.layout.inner_tab1_main);
//
//        TabLayout innerTabLayout = (TabLayout) findViewById(R.id.inner_tab_layout);
//        innerTabLayout .addTab(innerTabLayout.newTab().setText("내부검색"));
//        innerTabLayout .addTab(innerTabLayout.newTab().setText("내부신곡"));
//        innerTabLayout .addTab(innerTabLayout.newTab().setText("내부인기곡"));
//        innerTabLayout .setTabGravity(TabLayout.GRAVITY_FILL);
//
//        final ViewPager innerViewPager = (ViewPager) findViewById(R.id.inner_pager);
//        final InnerPagerAdapter innerAdapter = new InnerPagerAdapter(getSupportFragmentManager(), innerTabLayout.getTabCount());
//        innerViewPager .setAdapter(innerAdapter);
//        innerViewPager .addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(innerTabLayout));
//
//        OnTabSelectedListen InnerOnTabSelectedListener = new OnTabSelectedListen(innerViewPager);
//        innerTabLayout.setOnTabSelectedListener(InnerOnTabSelectedListener);

    }

    public class OnTabSelectedListen implements TabLayout.OnTabSelectedListener //  둘이 쓰는 리스너
    {
        ViewPager viewPager;
        public OnTabSelectedListen(ViewPager v)
        {
            viewPager = v;
        }

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
    }
}

//    final ViewPager viewPager = (ViewPager) findViewById(R.id.inner_pager);
//    final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
//viewPager.setAdapter(adapter);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//@Override
//public void onTabSelected(TabLayout.Tab tab) {
//        viewPager.setCurrentItem(tab.getPosition());
//        }
//
//@Override
//public void onTabUnselected(TabLayout.Tab tab) {
//
//        }
//
//@Override
//public void onTabReselected(TabLayout.Tab tab) {
//
//        }
//        });