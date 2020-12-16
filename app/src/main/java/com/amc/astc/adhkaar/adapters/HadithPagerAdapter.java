package com.amc.astc.adhkaar.adapters;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.amc.astc.adhkaar.ui.fragments.HadithFragment;
import com.amc.astc.adhkaar.utils.MyResources;

public class HadithPagerAdapter extends FragmentStateAdapter {

    private static final int NUM_PAGES = 43;
    private Context c;

    public HadithPagerAdapter(FragmentActivity fa, Context c) {
        super(fa);
        this.c = c;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        MyResources myResources = new MyResources();
        String[] hadith = myResources.getHadithStringArray(position, c);
        return new HadithFragment(hadith[0], hadith[1], hadith[2], hadith[3], c);
    }

    @Override
    public int getItemCount() {
        return NUM_PAGES;
    }
}
