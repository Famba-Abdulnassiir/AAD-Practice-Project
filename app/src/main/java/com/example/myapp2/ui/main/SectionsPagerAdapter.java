package com.example.myapp2.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.myapp2.LeaderBoardFragment;
import com.example.myapp2.R;
import com.example.myapp2.SkillsIqFragment;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).

            switch(position){
                case 0:
                    return new LeaderBoardFragment();

                case 1:
                    return  new SkillsIqFragment();

                default:
                    return null;

            }

    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:

                return mContext.getString(R.string.tab_text_1);

            case 1:
                return mContext.getString(R.string.tab_text_2);
            default:return null;
        }

    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 2;
    }
}