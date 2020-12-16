package com.amc.astc.adhkaar.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.app.ShareCompat;
import androidx.preference.PreferenceManager;

import com.amc.astc.adhkaar.R;
import com.amc.astc.adhkaar.adapters.MyListAdapter;
import com.amc.astc.adhkaar.ui.fragments.AboutUsFragment;
import com.amc.astc.adhkaar.utils.Constants;

import java.util.Objects;

public class AdhkarActivity extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    ListView adhkarListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adhkar);
        ActionBar actionBar = Objects.requireNonNull(getSupportActionBar());
        actionBar.setDisplayHomeAsUpEnabled(true);
        adhkarListView = findViewById(R.id.listview_adhkar);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int textSize = sharedPreferences.getInt("text_size", 20);
        sharedPreferences.registerOnSharedPreferenceChangeListener(this);
        MyListAdapter myListAdapter;

        if (getIntent().hasExtra(Constants.KEY_ADHKAR_INTENT)) {
            String[] adhkar = getIntent().getStringArrayExtra(Constants.KEY_ADHKAR_INTENT);
            assert adhkar != null;
            actionBar.setTitle(adhkar[0]);
            myListAdapter = new MyListAdapter(this, R.layout.adhkar_list_item, adhkar, textSize);
            adhkarListView.setAdapter(myListAdapter);
        } else if (getIntent().hasExtra(Constants.KEY_FORTY_RABBANA_INTENT)) {
            String[] fortyRabbanas = getIntent().getStringArrayExtra(Constants.KEY_FORTY_RABBANA_INTENT);
            assert fortyRabbanas != null;
            actionBar.setTitle(fortyRabbanas[0]);
            myListAdapter = new MyListAdapter(this, R.layout.adhkar_list_item, fortyRabbanas, textSize);
            adhkarListView.setAdapter(myListAdapter);
        } else if (getIntent().hasExtra(Constants.KEY_SUWAR_INTENT)) {
            String[] sura = getIntent().getStringArrayExtra(Constants.KEY_SUWAR_INTENT);
            assert sura != null;
            actionBar.setTitle(sura[0]);
            myListAdapter = new MyListAdapter(this, R.layout.adhkar_list_item, sura, textSize);
            adhkarListView.setAdapter(myListAdapter);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            case R.id.action_audio_adhkar:
                startActivity(new Intent(AdhkarActivity.this, AdhkarAudioActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            case R.id.action_settings:
                startActivity(new Intent(AdhkarActivity.this, SettingsActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            case R.id.action_share:
                shareAppLink();
                return true;
            case R.id.action_about_us:
                new AboutUsFragment().show(getSupportFragmentManager(), "AboutUsFragment");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void shareAppLink() {
        String msg = getString(R.string.share_text) + getString(R.string.share_link);
        ShareCompat.IntentBuilder.from(this)
                .setText(msg)
                .setType("text/plain")
                .setChooserTitle("Share App Link")
                .startChooser();
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String s) {
        if (s.equals(getString(R.string.key_size))) {
            recreate();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager
                .getDefaultSharedPreferences(this)
                .unregisterOnSharedPreferenceChangeListener(this);
    }

}