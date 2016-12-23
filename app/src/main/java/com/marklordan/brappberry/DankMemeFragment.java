package com.marklordan.brappberry;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mark on 13/11/2016.
 */

public class DankMemeFragment extends MemeFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TypedArray spicyMemes = getResources().obtainTypedArray(R.array.meme_audio_source_list);
        TypedArray spicyMemesImages = getResources().obtainTypedArray(R.array.meme_image_source_list);
        String[] spicyMemesText = getResources().getStringArray(R.array.dank_meme_text_source_list);
        for (int i = 0; i < spicyMemes.length(); i++) {
            int memeSoundResourceId = spicyMemes.getResourceId(i, -1);
            int memeImageResourceId = spicyMemesImages.getResourceId(i, -1);
            Meme meme = new Meme(memeSoundResourceId, memeImageResourceId, spicyMemesText[i]);
            mMemeObjList.add(meme);
        }
    }
}
