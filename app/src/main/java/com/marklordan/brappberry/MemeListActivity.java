package com.marklordan.brappberry;

import android.content.res.TypedArray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * Created by Mark on 13/11/2016.
 */

public class MemeListActivity extends AppCompatActivity{

    public static final String TAG = "MemeListActivity";
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        TypedArray spicyMemes = getResources().obtainTypedArray(R.array.meme_list);
        int[] resIds = new int[spicyMemes.length()];
        for (int i = 0; i < spicyMemes.length(); i++) {
            resIds[i] = spicyMemes.getResourceId(i, -1);
        }
    }
}
