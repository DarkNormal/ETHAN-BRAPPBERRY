package com.marklordan.brappberry;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import com.mopub.mobileads.MoPubView;

import java.util.logging.Logger;

import io.fabric.sdk.android.Fabric;

public class Soundboard extends AppCompatActivity {
    MediaPlayer mp;
    Sound sound;
    private MoPubView moPubView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_soundboard);
        sound = new Sound();

//        moPubView = (MoPubView) findViewById(R.id.mopub_sample_ad);
//        // TODO: Replace this test id with your personal ad unit id
//        if (moPubView != null) {
//            moPubView.setAdUnitId("8fbfa6f2d9a9466cbfe2a8e9b3318363");
//        }
//        if (moPubView != null) {
//            moPubView.loadAd();
//        }
//        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest adRequest = new AdRequest.Builder().build();
//        if (mAdView != null) {
//            mAdView.loadAd(adRequest);
//        }


    }

    public void BRADBERRY(View v){
        
        switch (v.getId()){
            case R.id.clickwoohoo:
                sound.setSoundResourceId(R.raw.clickwoohoo);
                break;
            case R.id.imaperson:
                //sound.setSoundResourceId(R.raw.imaperson);
                break;
            case R.id.brrrradberry:
                sound.setSoundResourceId(R.raw.brrrradberry);
                break;
            case R.id.ethanbradberry:
                sound.setSoundResourceId(R.raw.bradberry);
                break;
            //etc. etc.....
            case R.id.ethankbradberry:
                sound.setSoundResourceId(R.raw.ethanbradberry);
                break;
            case R.id.hilabradberry:
                sound.setSoundResourceId(R.raw.hilabradberry);
                break;
            case R.id.copberry:
                sound.setSoundResourceId(R.raw.copberry);
                break;
            case R.id.abuseBerry:
                sound.setSoundResourceId(R.raw.et);
                break;
            case R.id.jewishberry:
                sound.setSoundResourceId(R.raw.bradberry_muslim_jewish);
                break;
            case R.id.slammin:
                sound.setSoundResourceId(R.raw.slammin);
                break;
            case R.id.bornmobile:
                //sound.setSoundResourceId(R.raw.bornmobile);
                break;

            default:
                sound.setSoundResourceId(R.raw.bradberry);
                break;
        }
            MediaPlayer mp = MediaPlayer.create(this, sound.getSoundResourceId());
            mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    mp.release();

                }
            });
            mp.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_soundboard, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.credits:
                startActivity(new Intent(this, CreditActivity.class));
                break;
            case R.id.rate:
                launchRating();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onDestroy() {
        moPubView.destroy();
        if (mp != null) mp.release();
        super.onDestroy();

    }
    private void launchRating(){
        Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        // To count with Play market backstack, After pressing back button,
        // to taken back to our application, we need to add following flags to intent.
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
        }
    }
}
