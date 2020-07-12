package com.soucriador.jhonattas.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.model.jekyll.Album
import com.soucriador.jhonattas.ui.adapters.AlbumsAdapter.MyViewHolder

class AlbumsAdapter(private val mContext: Context, private val albumList: List<Album>) : RecyclerView.Adapter<MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var title: TextView
        var count: TextView
        var thumbnail: ImageView
        var overflow: ImageView

        init {
            title = view.findViewById<View>(R.id.title) as TextView
            count = view.findViewById<View>(R.id.count) as TextView
            thumbnail = view.findViewById<View>(R.id.thumbnail) as ImageView
            overflow = view.findViewById<View>(R.id.overflow) as ImageView
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.album_card, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val album = albumList[position]
        holder.title.text = album.name
        holder.count.text = album.numOfSongs.toString() + " songs"

        // loading album cover using Glide library
        // TODO Glide.with(mContext).load(album.getThumbnail()).into(holder.thumbnail);
        holder.overflow.setOnClickListener { showPopupMenu(holder.overflow) }
    }

    private fun showPopupMenu(view: View) {
        // inflate menu
        val popup = PopupMenu(mContext, view)
        val inflater = popup.menuInflater
        inflater.inflate(R.menu.menu_album, popup.menu)
        popup.setOnMenuItemClickListener(MyMenuItemClickListener())
        popup.show()
    }

    internal inner class MyMenuItemClickListener : PopupMenu.OnMenuItemClickListener {
        override fun onMenuItemClick(menuItem: MenuItem): Boolean {
            when (menuItem.itemId) {
                R.id.action_add_favourite -> {
                    Toast.makeText(mContext, "Add to favourite", Toast.LENGTH_SHORT).show()
                    return true
                }
                R.id.action_play_next -> {
                    Toast.makeText(mContext, "Play next", Toast.LENGTH_SHORT).show()
                    return true
                }
                else -> {
                }
            }
            return false
        }
    }

    override fun getItemCount(): Int {
        return albumList.size
    }

}