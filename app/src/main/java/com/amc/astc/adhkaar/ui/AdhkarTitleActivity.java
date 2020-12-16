package com.amc.astc.adhkaar.ui;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.amc.astc.adhkaar.R;
import com.amc.astc.adhkaar.adapters.AdhkarAdapter;
import com.amc.astc.adhkaar.utils.Constants;

import java.util.Objects;

public class AdhkarTitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhkar_title);

        ActionBar actionBar = Objects.requireNonNull(getSupportActionBar());
        actionBar.setDisplayHomeAsUpEnabled(true);
        RecyclerView adhkarTitles = findViewById(R.id.adhkar_title_rv);
        AdhkarAdapter adhkarAdapter;

        if (getIntent().hasExtra(Constants.KEY_ADHKAR_INTENT)) {
            String[] adhkarSection = getIntent().getStringArrayExtra(Constants.KEY_ADHKAR_INTENT);
            String contentType = Constants.KEY_ADHKAR_INTENT;
            actionBar.setTitle(Constants.KEY_ADHKAR_INTENT);
            adhkarAdapter = new AdhkarAdapter(this, adhkarSection, R.layout.adhkar_title_item, contentType);
            adhkarTitles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            adhkarTitles.setAdapter(adhkarAdapter);
        } else if (getIntent().hasExtra(Constants.KEY_SUWAR_INTENT)) {
            String[] suwarList = getIntent().getStringArrayExtra(Constants.KEY_SUWAR_INTENT);
            String contentType = Constants.KEY_SUWAR_INTENT;
            actionBar.setTitle(Constants.KEY_SUWAR_INTENT);
            adhkarAdapter = new AdhkarAdapter(this, suwarList, R.layout.adhkar_title_item, contentType);
            adhkarTitles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            adhkarTitles.setAdapter(adhkarAdapter);
        } else if (getIntent().hasExtra(Constants.KEY_FORTY_HADITH_INTENT)) {
            String[] hadithList = getIntent().getStringArrayExtra(Constants.KEY_FORTY_HADITH_INTENT);
            String contentType = Constants.KEY_FORTY_HADITH_INTENT;
            actionBar.setTitle(Constants.KEY_FORTY_HADITH_INTENT);
            adhkarAdapter = new AdhkarAdapter(this, hadithList, R.layout.adhkar_title_item, contentType);
            adhkarTitles.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
            adhkarTitles.setAdapter(adhkarAdapter);
        }
    }
}
