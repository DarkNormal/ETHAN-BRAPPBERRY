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


    private int[] mSpicyMemes, mSpicyMemesImages;
    private String[] mSpicyMemesText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            mSpicyMemes = convertToIntArray(getResources().obtainTypedArray(R.array.meme_audio_source_list));
            mSpicyMemesImages =  convertToIntArray(getResources().obtainTypedArray(R.array.meme_image_source_list));
            mSpicyMemesText = getResources().getStringArray(R.array.dank_meme_text_source_list);
        }
        else{
            mSpicyMemes = savedInstanceState.getIntArray(SAVE_MEME_SOUND);
            mSpicyMemesImages = savedInstanceState.getIntArray(SAVE_MEME_IMAGE);
            mSpicyMemesText = savedInstanceState.getStringArray(SAVE_MEME_TEXT);
        }
        for (int i = 0; i < mSpicyMemes.length; i++) {
            int memeSoundResourceId = mSpicyMemes[i];
            int memeImageResourceId = mSpicyMemesImages[i];
            Meme meme = new Meme(memeSoundResourceId, memeImageResourceId, mSpicyMemesText[i]);
            mMemeObjList.add(meme);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putStringArray(SAVE_MEME_TEXT, mSpicyMemesText);
        outState.putIntArray(SAVE_MEME_IMAGE,mSpicyMemesImages);
        outState.putIntArray(SAVE_MEME_SOUND, mSpicyMemes);
        super.onSaveInstanceState(outState);

    }
}
