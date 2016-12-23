package com.marklordan.brappberry;

import android.content.res.TypedArray;
import android.media.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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
 * Created by Mark on 23/12/2016.
 */

public class MemeFragment extends Fragment {

    protected MemeAdapter mMemeAdapter;
    protected RecyclerView mMemeRecyclerView;
    protected List<Meme> mMemeObjList = new ArrayList<>();
    @Override
    public View onCreateView (LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.fragment_meme_list, container, false);
        mMemeRecyclerView = (RecyclerView) v.findViewById(R.id.meme_recycler_view);
        mMemeRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
        mMemeRecyclerView.setHasFixedSize(true);

        if(mMemeAdapter == null){
            mMemeAdapter = new MemeAdapter(mMemeObjList);
            mMemeRecyclerView.setAdapter(mMemeAdapter);
        }
        return v;
    }

    public class MemeHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private ImageView memeImageView;
        private TextView memeTextView;
        private Meme meme;
        public MemeHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            memeImageView = (ImageView) itemView.findViewById(R.id.meme_image_view);
            memeTextView = (TextView) itemView.findViewById(R.id.meme_text_view);
        }
        @Override
        public void onClick(View view) {
            android.media.MediaPlayer mp = android.media.MediaPlayer.create(getActivity(), meme.getSoundResourceId());
            mp.setOnCompletionListener(new android.media.MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(android.media.MediaPlayer mp) {
                    mp.release();
                }
            });

            mp.start();
        }
        public void bindMeme(Meme meme){
            this.meme = meme;
            memeImageView.setImageDrawable(getResources().getDrawable(meme.getImageResourceId()));
            memeTextView.setText(meme.getMemeText());
        }
    }
    public class MemeAdapter extends RecyclerView.Adapter<MemeHolder>{
        private List<Meme> mMemeList;
        public MemeAdapter(List<Meme> memes){
            mMemeList = memes;
        }
        @Override
        public MemeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
            View v = layoutInflater.inflate(R.layout.list_item_meme, parent, false);
            return new MemeHolder(v);
        }
        @Override
        public void onBindViewHolder(MemeHolder holder, int position) {
            Meme meme = mMemeList.get(position);
            holder.bindMeme(meme);
        }
        @Override
        public int getItemCount() {
            return mMemeList.size();
        }
        public void setMemes(List<Meme> memes){
            mMemeList = memes;
        }
    }
}
