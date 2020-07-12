package com.soucriador.jhonattas.ui.activities

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.soucriador.jhonattas.R
import com.soucriador.jhonattas.model.jekyll.Post
import com.soucriador.jhonattas.ui.fragments.IntroFragment.Companion.newInstance
import com.soucriador.jhonattas.ui.fragments.PostFragment.Companion.newInstance
import com.soucriador.jhonattas.ui.interfaces.OnFragmentInteractionListener
import com.soucriador.jhonattas.ui.interfaces.OnListFragmentInteractionListener

class MainActivity : AppCompatActivity(), OnListFragmentInteractionListener, OnFragmentInteractionListener {

    private var mTextMessage: TextView? = null
    lateinit var ft: FragmentTransaction
    private val API_KEY = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (API_KEY.isEmpty()) {
            Toast.makeText(this, R.string.please_obtain_key, Toast.LENGTH_SHORT).show()
            // return;
        }
        val introFragment = newInstance("", "")
        ft = supportFragmentManager.beginTransaction()
        ft.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        ft.replace(R.id.fragmentContainer, introFragment)
        ft.commit()

        // atualiza o titulo da actionBar
        supportActionBar!!.title = resources.getString(R.string.title_home)
        mTextMessage = findViewById(R.id.message)
        val navigation = findViewById<BottomNavigationView>(R.id.navigation)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        ft = supportFragmentManager.beginTransaction()
        ft!!.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
        when (item.itemId) {
            R.id.navigation_home -> {
                //mTextMessage.setText(R.string.title_home);
                supportActionBar!!.title = resources.getString(R.string.title_home)
                val introFragment = newInstance("", "")
                ft.replace(R.id.fragmentContainer, introFragment)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                //mTextMessage.setText(R.string.title_posts);
                supportActionBar!!.title = resources.getString(R.string.title_posts)
                val pf = newInstance(1)
                ft.replace(R.id.fragmentContainer, pf)
                ft.commit()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                //mTextMessage.setText(R.string.title_notifications);
                supportActionBar!!.title = resources.getString(R.string.title_aboutme)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onListFragmentInteraction(post: Post?) {
        Log.d(TAG, post.toString())
    }

    override fun onFragmentInteraction(obj: Any?) {}

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}