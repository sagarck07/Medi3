package com.example.medi3.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.medi3.Fragment.DonateFragment;
import com.example.medi3.Fragment.EditRegisterUserFragment;
import com.example.medi3.Fragment.RequestFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {
    
    static final int NUM_ITEMS = 2;
    private Fragment mFragmentAtPos0;
    private final FragmentManager mFragmentManager;

    
    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mFragmentManager = fm;
    }

    public FragmentsAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        mFragmentManager = fm;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0: return  new DonateFragment();
            case 1: return  new RequestFragment();
            default: return new DonateFragment();
        }

    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if(position==0){
            title = "Donate Blood";
        }
        if(position==1){
            title = "Request Blood";
        }
        return title;
    }
}
