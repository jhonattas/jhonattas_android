package com.soucriador.jhonattas.ui.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.model.jekyll.Feed
import com.soucriador.jhonattas.model.jekyll.Post
import com.soucriador.jhonattas.ui.activities.PostDetailsActivity
import com.soucriador.jhonattas.ui.adapters.FeedAdapter.FeedViewHolder
import com.soucriador.jhonattas.ui.interfaces.OnFragmentInteractionListener

class FeedAdapter(private val posts: List<Post>, private val rowLayout: Int, private val context: Context, private val listener: OnFragmentInteractionListener?) : RecyclerView.Adapter<FeedViewHolder>() {
    private val feed: Feed? = null

    class FeedViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var postsLayout: LinearLayoutCompat
        var postImg: ImageView
        var postTitle: TextView
        var subtitle: TextView
        var description: TextView
        var rating: TextView? = null
        var mView: View

        init {
            postsLayout = v.findViewById(R.id.posts_layout)
            postImg = v.findViewById(R.id.post_img)
            postTitle = v.findViewById(R.id.title)
            subtitle = v.findViewById(R.id.subtitle)
            description = v.findViewById(R.id.description)
            mView = v
            // rating          = v.findViewById(R.id.rating);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(rowLayout, parent, false)
        return FeedViewHolder(view)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        // Picasso.with(context).load(posts.get(position).getImg()).into(holder.postImg);
        holder.postTitle.text = posts[position].title
        holder.subtitle.text = posts[position].url
        holder.mView.setOnClickListener { v ->
            if (null != listener) {
                // Notify the active callbacks interface (the activity, if the
                // fragment is attached to one) holder.pizza);
            }
            Toast.makeText(v.context, "O item " + posts[position].title + " foi clicado", Toast.LENGTH_SHORT).show()
            val i = Intent(v.context, PostDetailsActivity::class.java)
            i.putExtra("post_id", posts[position].id)
            i.putExtra("image_url", posts[position].img)
            i.putExtra("title", posts[position].title)
            v.context.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return posts.size
    }

}