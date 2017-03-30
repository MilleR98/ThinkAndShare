package com.dev.thinkandshare.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.dev.thinkandshare.R;

import java.util.ArrayList;
import java.util.List;

public class IdeasFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_my_ideas,container,false);

        final TabLayout tabLayout = (TabLayout) v.findViewById(R.id.home_tabs);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        final ViewPager viewPager = (ViewPager) v.findViewById(R.id.home_viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getFragmentManager());
        adapter.addFragment(new AllIdeasFragment(), "All ideas");
        adapter.addFragment(new MyIdeasFragment(), "My ideas");
        adapter.addFragment(new InvitedIdeasFragment(), "Invited");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);
        setupViewPager(viewPager);

        return v;

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter  adapter = new ViewPagerAdapter (getChildFragmentManager());
        adapter.addFragment(new AllIdeasFragment(), "All ideas");
        adapter.addFragment(new MyIdeasFragment(), "My ideas");
        adapter.addFragment(new InvitedIdeasFragment(), "Invited");
        viewPager.setAdapter(adapter);
    }


    private class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
