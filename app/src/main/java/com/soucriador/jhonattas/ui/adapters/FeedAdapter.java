package com.soucriador.jhonattas.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.model.jekyll.Feed;
import com.soucriador.jhonattas.model.jekyll.Post;
import com.soucriador.jhonattas.ui.activities.PostDetailsActivity;
import com.soucriador.jhonattas.ui.interfaces.OnFragmentInteractionListener;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FeedAdapter extends RecyclerView.Adapter<FeedAdapter.FeedViewHolder> {

    private Feed feed;
    private List<Post> posts;
    private int rowLayout;
    private Context context;
    private OnFragmentInteractionListener listener;

    public static class FeedViewHolder extends RecyclerView.ViewHolder {


        LinearLayoutCompat postsLayout;
        ImageView postImg;
        TextView postTitle;
        TextView subtitle;
        TextView description;
        TextView rating;
        View mView;

        public FeedViewHolder(View v) {
            super(v);
            postsLayout     = v.findViewById(R.id.posts_layout);
            postImg         = v.findViewById(R.id.post_img);
            postTitle       = v.findViewById(R.id.title);
            subtitle        = v.findViewById(R.id.subtitle);
            description     = v.findViewById(R.id.description);
            mView = v;
            // rating          = v.findViewById(R.id.rating);
        }
    }

    public FeedAdapter(List<Post> posts, int rowLayout, Context context, OnFragmentInteractionListener listener) {
        this.posts = posts;
        this.rowLayout = rowLayout;
        this.context = context;
        this.listener = listener;
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
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) holder.pizza);
                }
                Toast.makeText(v.getContext(), "O item " + posts.get(position).getTitle() + " foi clicado", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(v.getContext(), PostDetailsActivity.class);

                i.putExtra("post_id", posts.get(position).getId());
                i.putExtra("image_url", posts.get(position).getImg());
                i.putExtra("title", posts.get(position).getTitle());

                v.getContext().startActivity(i);
            }
        });
    }

    public int getItemCount () {
        return posts.size();
    }

}
