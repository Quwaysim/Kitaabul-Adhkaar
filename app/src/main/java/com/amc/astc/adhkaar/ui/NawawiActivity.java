package com.amc.astc.adhkaar.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;
import androidx.core.app.ShareCompat;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.amc.astc.adhkaar.R;
import com.amc.astc.adhkaar.adapters.HadithPagerAdapter;
import com.amc.astc.adhkaar.ui.fragments.AboutUsFragment;
import com.amc.astc.adhkaar.utils.Constants;

public class NawawiActivity extends AppCompatActivity {

    private ViewPager2 viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nawawi);

        // Instantiate a ViewPager2 and a PagerAdapter.
        viewPager = findViewById(R.id.pager);
        FragmentStateAdapter pagerAdapter = new HadithPagerAdapter(this, this);
        viewPager.setAdapter(pagerAdapter);

        if (getIntent().hasExtra(Constants.KEY_FORTY_HADITH_INTENT)) {
            int position = getIntent().getIntExtra(Constants.KEY_FORTY_HADITH_INTENT, 0);
            viewPager.setCurrentItem(position);
            Toast.makeText(this, "You can swipe left or right to the previous or next hadith", Toast.LENGTH_SHORT).show();
        }

    }
    //TODO attention, removed the viewpager.setCurrentItem() method: not in version 1.0.2
    @Override
    public void onBackPressed() {
        super.onBackPressed();
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
                startActivity(new Intent(NawawiActivity.this, AdhkarAudioActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            case R.id.action_settings:
                startActivity(new Intent(NawawiActivity.this, SettingsActivity.class));
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
}