package com.soucriador.jhonattas.ui.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.model.jekyll.Feed
import com.soucriador.jhonattas.model.jekyll.Post
import com.soucriador.jhonattas.rest.ServerClient
import com.soucriador.jhonattas.rest.ServerInterface
import com.soucriador.jhonattas.ui.adapters.FeedAdapter
import com.soucriador.jhonattas.ui.interfaces.OnFragmentInteractionListener
import com.soucriador.jhonattas.ui.interfaces.OnListFragmentInteractionListener
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PostFragment : Fragment() {
    private var mColumnCount = 1
    private var mListener: OnFragmentInteractionListener? = null
    private var recyclerView: RecyclerView? = null
    private var feed: Feed? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            mColumnCount = arguments!!.getInt(ARG_COLUMN_COUNT)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_post_list, container, false)
        val serverService = ServerClient.getClient().create(ServerInterface::class.java)
        val feedCall = serverService.feed

        // Set the adapter
        if (view is RecyclerView) {
            val context = view.getContext()
            recyclerView = view
            if (mColumnCount <= 1) {
                recyclerView!!.layoutManager = LinearLayoutManager(context)
            } else {
                recyclerView!!.layoutManager = GridLayoutManager(context, mColumnCount)
            }
            feedCall.enqueue(object : Callback<Feed?> {
                override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {
                    feed = response.body()
                    Log.d(TAG, "dados recuperados: " + feed.toString())
                    if (feed != null) {
                        recyclerView!!.adapter = FeedAdapter(feed!!.items as List<Post>, R.layout.list_item_post, context, mListener)
                    }
                }

                override fun onFailure(call: Call<Feed?>, t: Throwable) {
                    Log.e(TAG, t.toString())
                }
            })
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnListFragmentInteractionListener) {
            context as OnFragmentInteractionListener
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    companion object {
        private val TAG = PostFragment::class.java.simpleName
        private const val ARG_COLUMN_COUNT = "column-count"
        fun newInstance(): PostFragment {
            return PostFragment()
        }

        @JvmStatic
        fun newInstance(columnCount: Int): PostFragment {
            val fragment = PostFragment()
            val args = Bundle()
            args.putInt(ARG_COLUMN_COUNT, columnCount)
            fragment.arguments = args
            return fragment
        }

    }
}