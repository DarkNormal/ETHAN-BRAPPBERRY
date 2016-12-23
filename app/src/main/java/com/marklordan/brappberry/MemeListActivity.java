package com.marklordan.brappberry;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Mark on 13/11/2016.
 */

public class MemeListActivity extends SingleFragmentActivity implements BradberryMemeFragment.OnMemePlayedListener{

    public static final String TAG = "MemeListActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
    }

    @Override
    protected Fragment createFragment() {
        return new BradberryMemeFragment();
    }

    @Override
    public void onMemePlayed(String memeName) {
        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, memeName);
    }
}
