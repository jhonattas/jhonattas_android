package com.soucriador.jhonattas.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.ui.fragments.IntroFragment;
import com.soucriador.jhonattas.ui.fragments.PostFragment;
import com.soucriador.jhonattas.ui.adapters.dummy.DummyContent;
import com.soucriador.jhonattas.ui.interfaces.OnFragmentInteractionListener;
import com.soucriador.jhonattas.ui.interfaces.OnListFragmentInteractionListener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity
        implements OnListFragmentInteractionListener, OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView mTextMessage;
    FragmentTransaction ft;
    private final String API_KEY = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(API_KEY.isEmpty()) {
            Toast.makeText(this, "Please obtain your API KEY", Toast.LENGTH_SHORT).show();
            // return;
        }

        IntroFragment introFragment = IntroFragment.newInstance("", "");

        ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations( android.R.anim.fade_in, android.R.anim.fade_out );
        ft.replace(R.id.fragmentContainer, introFragment);
        ft.commit();

        // atualiza o titulo da actionBar
        getSupportActionBar().setTitle(getResources().getString(R.string.title_home));

        mTextMessage                    = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            ft = getSupportFragmentManager().beginTransaction();
            ft.setCustomAnimations( android.R.anim.fade_in, android.R.anim.fade_out );

            switch (item.getItemId()) {
                case R.id.navigation_home:
                    //mTextMessage.setText(R.string.title_home);
                    getSupportActionBar().setTitle(getResources().getString(R.string.title_home));
                    IntroFragment introFragment = IntroFragment.newInstance("", "");
                    ft.replace(R.id.fragmentContainer, introFragment);
                    ft.commit();
                    return true;

                case R.id.navigation_dashboard:
                    //mTextMessage.setText(R.string.title_posts);
                    getSupportActionBar().setTitle(getResources().getString(R.string.title_posts));

                    PostFragment pf = PostFragment.newInstance(1);
                    ft.replace(R.id.fragmentContainer, pf);
                    ft.commit();
                    return true;

                case R.id.navigation_notifications:
                    //mTextMessage.setText(R.string.title_notifications);
                    getSupportActionBar().setTitle(getResources().getString(R.string.title_aboutme));
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    @Override
    public void onFragmentInteraction(Object obj) {

    }
}
