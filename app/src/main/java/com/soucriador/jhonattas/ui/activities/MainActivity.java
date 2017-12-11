package com.soucriador.jhonattas.ui.activities;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.soucriador.jhonattas.R;
import com.soucriador.jhonattas.model.jekyll.Feed;
import com.soucriador.jhonattas.rest.ServerClient;
import com.soucriador.jhonattas.rest.ServerInterface;
import com.soucriador.jhonattas.ui.fragments.PostFragment;
import com.soucriador.jhonattas.ui.adapters.dummy.DummyContent;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements PostFragment.OnListFragmentInteractionListener {

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

        PostFragment pf = PostFragment.newInstance(1);
        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainer, pf);
        ft.commit();

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        // navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }
}
