package com.example.administrator.customfragmenttabhost;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class TabBean {
    private int title;
    private int icon;

    private Fragment fragment;

    public TabBean(int title, Fragment fragment, int icon) {
        this.title = title;
        this.fragment = fragment;
        this.icon = icon;
    }

    public int getTitle() {
        return title;
    }

    public void setTitle(int title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public Fragment getFragment() {
        return fragment;
    }

    public void setFragment(Fragment fragment) {
        this.fragment = fragment;
    }
}
