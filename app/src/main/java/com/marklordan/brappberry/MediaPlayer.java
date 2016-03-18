package com.marklordan.brappberry;

/**
 * Created by Mark on 18/03/2016.
 */
public class MediaPlayer {

    private static android.media.MediaPlayer instance = null;
    protected MediaPlayer(){}
    public static android.media.MediaPlayer getInstance(){
        if(instance == null){
            instance = new android.media.MediaPlayer();
        }
        return instance;
    }
}
