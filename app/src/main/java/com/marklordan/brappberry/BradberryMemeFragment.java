package com.marklordan.brappberry;

import android.os.Bundle;

/**
 * Created by Mark on 13/11/2016.
 */

public class BradberryMemeFragment extends MemeFragment{

    private int[] mSpicyMemes, mSpicyMemesImages;
    private String[] mSpicyMemesText;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null) {
            mSpicyMemes = convertToIntArray(getResources().obtainTypedArray(R.array.bradberry_meme_audio_source_list));
            mSpicyMemesImages = convertToIntArray(getResources().obtainTypedArray(R.array.bradberry_meme_image_source_list));
            mSpicyMemesText = getResources().getStringArray(R.array.bradberry_meme_text_source_list);
        }
        else{
            mSpicyMemes = savedInstanceState.getIntArray(SAVE_MEME_SOUND);
            mSpicyMemesImages = savedInstanceState.getIntArray(SAVE_MEME_IMAGE);
            mSpicyMemesText = savedInstanceState.getStringArray(SAVE_MEME_TEXT);
        }
        for (int i = 0; i < mSpicyMemes.length; i++) {
            int memeSoundResourceId = mSpicyMemes[i];
            String meme_array = mSpicyMemesText[i];
            int memeImageResourceId = mSpicyMemesImages[i];
            Meme meme = new Meme(memeSoundResourceId, memeImageResourceId, meme_array.toString());
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
