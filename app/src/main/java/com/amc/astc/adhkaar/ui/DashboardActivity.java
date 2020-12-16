package com.amc.astc.adhkaar.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.preference.PreferenceManager;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;

import com.amc.astc.adhkaar.R;
import com.amc.astc.adhkaar.ui.fragments.AboutUsFragment;
import com.amc.astc.adhkaar.utils.Constants;
import com.amc.astc.adhkaar.workers.DuaWorker;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;

public class DashboardActivity extends AppCompatActivity {

    ImageView header;
    private String[] fortyHadithTitles = new String[43];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        ImageView adhkaar = findViewById(R.id.ic_adhkaar);
        ImageView suwar = findViewById(R.id.ic_suwar);
        ImageView rabbana = findViewById(R.id.ic_forty_rabbana);
        ImageView hadith = findViewById(R.id.ic_forty_hadith);
        WorkManager workManager = WorkManager.getInstance(this);
        for (int i = 0; i < 43; i++) {
            if (i == 0)
                fortyHadithTitles[i] = "Forty Hadith Overview";
            else
                fortyHadithTitles[i] = "Hadith " + i;
        }
        header = findViewById(R.id.header);
        header.setClipToOutline(true);

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        boolean notificationSet = sharedPreferences.getBoolean(
                getString(R.string.key_notification_reminder),
                false
        );

        if (notificationSet) {
            Calendar time = Calendar.getInstance();
            int now = time.get(Calendar.HOUR_OF_DAY);
            int notificationTime = 18;
            PeriodicWorkRequest.Builder builder = new PeriodicWorkRequest.Builder(DuaWorker.class,
                    12,
                    TimeUnit.HOURS)
                    .setInitialDelay(notificationTime - now, TimeUnit.HOURS);
            workManager.enqueue(builder.build());
        }

        adhkaar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, AdhkarTitleActivity.class)
                        .putExtra(Constants.KEY_ADHKAR_INTENT, getResources().getStringArray(R.array.adhkaar_subsections)));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });
        suwar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, AdhkarTitleActivity.class)
                        .putExtra(Constants.KEY_SUWAR_INTENT, getResources().getStringArray(R.array.suwar_title_list)));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }));

        rabbana.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, AdhkarActivity.class)
                        .putExtra(Constants.KEY_FORTY_RABBANA_INTENT, getResources().getStringArray(R.array.forty_rabbanas)));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }));

        hadith.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DashboardActivity.this, AdhkarTitleActivity.class)
                        .putExtra(Constants.KEY_FORTY_HADITH_INTENT, fortyHadithTitles));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        }));
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
            case R.id.action_audio_adhkar:
                startActivity(new Intent(DashboardActivity.this, AdhkarAudioActivity.class));
                overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                return true;
            case R.id.action_settings:
                startActivity(new Intent(DashboardActivity.this, SettingsActivity.class));
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