package com.soucriador.jhonattas.ui.adapters;

import android.content.Context;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.model.jekyll.Feed;
import com.soucriador.jhonattas.model.jekyll.Post;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private Feed feed;
    private List<Post> posts;
    private int rowLayout;
    private Context context;

    public static class FeedViewHolder extends RecyclerView.ViewHolder {

        LinearLayoutCompat postsLayout;
        ImageView postImg;
        TextView postTitle;
        TextView subtitle;
        TextView description;
        TextView rating;

        public FeedViewHolder(View v) {
            super(v);
            postsLayout     = v.findViewById(R.id.posts_layout);
            postImg         = v.findViewById(R.id.post_img);
            postTitle       = v.findViewById(R.id.title);
            subtitle        = v.findViewById(R.id.subtitle);
            description     = v.findViewById(R.id.description);
            // rating          = v.findViewById(R.id.rating);
        }
    }

    public FeedAdapter(List<Post> posts, int rowLayout, Context context) {
        this.posts = posts;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public FeedAdapter.FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout,parent, false);
        return new FeedViewHolder(view);
    }

    public void onBindViewHolder (FeedViewHolder holder, final int position) {
        Picasso.with(context).load(posts.get(position).getImg()).into(holder.postImg);
        holder.postTitle.setText(posts.get(position).getTitle());
        holder.subtitle.setText(posts.get(position).getUrl());
    }

    public int getItemCount () {
        return posts.size();
    }

}
