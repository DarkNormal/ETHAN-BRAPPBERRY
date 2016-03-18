package com.marklordan.brappberry;

/**
 * Created by Mark on 18/03/2016.
 */
public class Sound {

    private static Sound instance = null;
    protected Sound(){}
    public static Sound getInstance(){
        if(instance == null){
            instance = new Sound();
        }
        return instance;
    }
    private int mSoundResourceId = -1;

    public void setSoundResourceId(int id) { mSoundResourceId = id; }
    public int getSoundResourceId() { return mSoundResourceId; }
}
