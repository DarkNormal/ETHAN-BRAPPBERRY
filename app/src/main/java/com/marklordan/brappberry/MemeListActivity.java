package com.marklordan.brappberry;

import android.content.res.TypedArray;

import android.media.*;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by Mark on 13/11/2016.
 */

public class MemeListActivity extends SingleFragmentActivity{

    public static final String TAG = "MemeListActivity";

    @Override
    protected Fragment createFragment() {
        return new MemeListFragment();
    }
}
