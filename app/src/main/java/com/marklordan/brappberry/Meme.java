package com.marklordan.brappberry;

/**
 * Created by Mark on 13/11/2016.
 */

public class Meme {

    private int mSoundResourceId;



    private int mImageResourceId;

    public Meme(){
        mSoundResourceId = -1;
    }
    public void setSoundResourceId(int id) { mSoundResourceId = id; }
    public int getSoundResourceId() { return mSoundResourceId; }
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }
}
