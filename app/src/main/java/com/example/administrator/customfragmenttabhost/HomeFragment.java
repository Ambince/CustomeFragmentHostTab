package com.example.administrator.customfragmenttabhost;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
public class HomeFragment extends Fragment {
    private View mRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(R.layout.home_fragment, null);
        }
        ViewGroup viewGroup = (ViewGroup) mRootView.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(mRootView);
        }
        return mRootView;
    }
}
