package com.marklordan.brappberry;

import android.support.v4.app.Fragment;

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
