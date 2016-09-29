package com.example.administrator.customfragmenttabhost;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private FragmentTabHost fragmentTabHost;
    private ViewPager mViewPager;
    private LayoutInflater layoutInflater;
    private List<TabBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        intData();

        initView();

        initEvent();
    }

    private void intData() {
        list = new ArrayList<TabBean>();
        TabBean tabHome = new TabBean(R.string.tab_home, new HomeFragment(), R.drawable.tab_home);
        TabBean tabResport = new TabBean(R.string.tab_resport, new ReportFragment(), R.drawable.tab_resport);
        TabBean tabMessage = new TabBean(R.string.tab_message, new MessageFragment(), R.drawable.tab_message);
        TabBean tabMine = new TabBean(R.string.tab_mine, new MineFragment(), R.drawable.tab_mine);
        list.add(tabHome);
        list.add(tabResport);
        list.add(tabMessage);
        list.add(tabMine);
    }

    private void initEvent() {
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                mViewPager.setCurrentItem(fragmentTabHost.getCurrentTab());
            }
        });

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                fragmentTabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void initView() {
        fragmentTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mViewPager = (ViewPager) findViewById(R.id.view_pager);

        fragmentTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);
        fragmentTabHost.getTabWidget().setDividerDrawable(null);


        for (TabBean tab : list) {
            TabHost.TabSpec tabSpec = fragmentTabHost.newTabSpec(getString(tab.getTitle())).setIndicator(getIndicatorView(tab));
            fragmentTabHost.addTab(tabSpec, tab.getFragment().getClass(), null);
        }


        mViewPager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position).getFragment();
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
    }

    private View getIndicatorView(TabBean tab) {
        layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.tab_item, null);

        ImageView imageView = (ImageView) view.findViewById(R.id.image);
        TextView textView = (TextView) view.findViewById(R.id.title);

        imageView.setBackgroundResource(tab.getIcon());
        textView.setText(tab.getTitle());

        return view;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
