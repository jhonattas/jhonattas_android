package com.soucriador.jhonattas.ui.activities

import android.graphics.Rect
import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.model.jekyll.Album
import com.soucriador.jhonattas.ui.adapters.AlbumsAdapter
import kotlinx.android.synthetic.main.activity_post_details.*
import kotlinx.android.synthetic.main.content_main.*
import java.util.*

class PostDetailsActivity : AppCompatActivity() {

    private var adapter: AlbumsAdapter? = null
    private var albumList: MutableList<Album>? = ArrayList()
    private var postId: String? = null
    private var postImg: String? = null
    private var title: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_post_details)

        setSupportActionBar(toolbar)
        initCollapsingToolbar()

        val mLayoutManager: RecyclerView.LayoutManager = GridLayoutManager(this, 2)

        mainRecyclerView.layoutManager = mLayoutManager
        mainRecyclerView.addItemDecoration(GridSpacingItemDecoration(2, dpToPx(10), true))
        mainRecyclerView.itemAnimator = DefaultItemAnimator()
        mainRecyclerView.adapter = AlbumsAdapter(this, albumList as ArrayList<Album>)

        val i = intent
        postId = i.getStringExtra("post_id")
        postImg = i.getStringExtra("image_url")
        title = i.getStringExtra("title")
        setTitle(title)
        Log.d("POSTDETAILS", postImg!!)

        //prepareAlbums();
        try {
            // TODO Picasso.with(this).load(postImg).into(backdrop);
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun initCollapsingToolbar() {
        val collapsingToolbar = findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar)
        collapsingToolbar.title = " "
        appBarLayout.setExpanded(true)

        // hiding & showing the title when toolbar expanded & collapsed
        appBarLayout.addOnOffsetChangedListener(object : OnOffsetChangedListener {
            var isShow = false
            var scrollRange = -1
            override fun onOffsetChanged(appBarLayout: AppBarLayout, verticalOffset: Int) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.totalScrollRange
                }
                if (scrollRange + verticalOffset == 0) {
                    collapsingToolbar.title = getString(R.string.app_name)
                    isShow = true
                } else if (isShow) {
                    collapsingToolbar.title = " "
                    isShow = false
                }
            }
        })
    }

    /**
     * Adding few albums for testing
     */
    private fun prepareAlbums() {
        val covers = intArrayOf(
                R.drawable.album1,
                R.drawable.album2,
                R.drawable.album3,
                R.drawable.album4,
                R.drawable.album5,
                R.drawable.album6,
                R.drawable.album7,
                R.drawable.album8,
                R.drawable.album9,
                R.drawable.album10,
                R.drawable.album11)
        var a = Album("True Romance", 13, covers[0])
        albumList!!.add(a)
        a = Album("Xscpae", 8, covers[1])
        albumList!!.add(a)
        a = Album("Maroon 5", 11, covers[2])
        albumList!!.add(a)
        a = Album("Born to Die", 12, covers[3])
        albumList!!.add(a)
        a = Album("Honeymoon", 14, covers[4])
        albumList!!.add(a)
        a = Album("I Need a Doctor", 1, covers[5])
        albumList!!.add(a)
        a = Album("Loud", 11, covers[6])
        albumList!!.add(a)
        a = Album("Legend", 14, covers[7])
        albumList!!.add(a)
        a = Album("Hello", 11, covers[8])
        albumList!!.add(a)
        a = Album("Greatest Hits", 17, covers[9])
        albumList!!.add(a)
        adapter!!.notifyDataSetChanged()
    }

    /**
     * RecyclerView item decoration - give equal margin around grid item
     */
    inner class GridSpacingItemDecoration(private val spanCount: Int, private val spacing: Int, private val includeEdge: Boolean) : ItemDecoration() {
        override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
            val position = parent.getChildAdapterPosition(view) // item position
            val column = position % spanCount // item column
            if (includeEdge) {
                outRect.left = spacing - column * spacing / spanCount // spacing - column * ((1f / spanCount) * spacing)
                outRect.right = (column + 1) * spacing / spanCount // (column + 1) * ((1f / spanCount) * spacing)
                if (position < spanCount) { // top edge
                    outRect.top = spacing
                }
                outRect.bottom = spacing // item bottom
            } else {
                outRect.left = column * spacing / spanCount // column * ((1f / spanCount) * spacing)
                outRect.right = spacing - (column + 1) * spacing / spanCount // spacing - (column + 1) * ((1f /    spanCount) * spacing)
                if (position >= spanCount) {
                    outRect.top = spacing // item top
                }
            }
        }

    }

    /**
     * Converting dp to pixel
     */
    private fun dpToPx(dp: Int): Int {
        val r = resources
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), r.displayMetrics))
    }
}