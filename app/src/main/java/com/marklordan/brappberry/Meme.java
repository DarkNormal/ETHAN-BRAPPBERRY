package com.marklordan.brappberry;

/**
 * Created by Mark on 13/11/2016.
 */

public class Meme {

    private int mSoundResourceId;
    private int mImageResourceId;



    private String mMemeText;

    public Meme(){
        mSoundResourceId = -1;
    }
    public Meme(int soundResourceId, int imageResourceId){
        mSoundResourceId = soundResourceId;
        mImageResourceId = imageResourceId;
    }
    public Meme(int soundResourceId, int imageResourceId, String memeText){
        mSoundResourceId = soundResourceId;
        mImageResourceId = imageResourceId;
        mMemeText = memeText;
    }
    public void setSoundResourceId(int id) { mSoundResourceId = id; }
    public int getSoundResourceId() { return mSoundResourceId; }
    public int getImageResourceId() {
        return mImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        mImageResourceId = imageResourceId;
    }

    public String getMemeText() {
        return mMemeText;
    }

    public void setMemeText(String memeText) {
        mMemeText = memeText;
    }
}
