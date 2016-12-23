package com.marklordan.brappberry;

import android.content.res.TypedArray;
import android.os.Bundle;

/**
 * Created by Mark on 13/11/2016.
 */

public class BradberryMemeFragment extends MemeFragment{

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        TypedArray spicyMemes = getResources().obtainTypedArray(R.array.bradberry_meme_audio_source_list);
        TypedArray spicyMemesImages = getResources().obtainTypedArray(R.array.bradberry_meme_image_source_list);
        String[] spicyMemesText = getResources().getStringArray(R.array.bradberry_meme_text_source_list);
        for (int i = 0; i < spicyMemes.length(); i++) {
            int memeSoundResourceId = spicyMemes.getResourceId(i, -1);
            String meme_array = spicyMemesText[i];
            int memeImageResourceId = spicyMemesImages.getResourceId(i, -1);
            Meme meme = new Meme(memeSoundResourceId, memeImageResourceId, meme_array.toString());
            mMemeObjList.add(meme);
        }
    }

    public interface OnMemePlayedListener{
        public void onMemePlayed(String memeName);
    }





}
