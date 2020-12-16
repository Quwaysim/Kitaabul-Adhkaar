package com.amc.astc.adhkaar.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.amc.astc.adhkaar.R;

public class HadithFragment extends Fragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String title, hadith_en, hadith_ar, references;
    private Context c;
    private int size;

    public HadithFragment(String title,
                          String hadith_en,
                          String hadith_ar,
                          String references,
                          Context c) {
        this.title = title;
        this.hadith_en = hadith_en;
        this.hadith_ar = hadith_ar;
        this.references = references;
        this.c = c;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(c);
        size = sharedPreferences.getInt(getString(R.string.key_size), 24);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);

        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_hadith,
                container,
                false);
        TextView title = v.findViewById(R.id.hadith_title);
        TextView hadithEn = v.findViewById(R.id.hadith_en);
        TextView hadithAr = v.findViewById(R.id.hadith_ar);
        TextView references = v.findViewById(R.id.references);

        title.setText(this.title);
        hadithEn.setText(this.hadith_en);
        hadithAr.setText(this.hadith_ar);
        references.setText(this.references);

        title.setTextSize(size);
        hadithEn.setTextSize(size);
        hadithAr.setTextSize(size);
        references.setTextSize(size-8);

        return v;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals(getString(R.string.key_size))) {
            size = sharedPreferences.getInt(getString(R.string.key_size), 24);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        PreferenceManager
                .getDefaultSharedPreferences(c)
                .unregisterOnSharedPreferenceChangeListener(this);
    }
}
