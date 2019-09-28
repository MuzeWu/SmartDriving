package com.laioffer.matrix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.res.Configuration;
import android.util.Log;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements EventFragment.OnItemSelectListener,
        CommentFragment.OnItemSelectListener{

    private EventFragment listFragment;
    private CommentFragment gridFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show different fragments based on screen size.
        if (getSupportFragmentManager().findFragmentById(R.id.event_container) == null) {
            listFragment = new EventFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.event_container, listFragment).commit();
        } else {
            listFragment = (EventFragment) getSupportFragmentManager().findFragmentById(R.id.event_container);
        }

        //add Gridview
        if (getSupportFragmentManager().findFragmentById(R.id.comment_container) == null && isTablet()) {
            gridFragment = new CommentFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.comment_container, gridFragment).commit();
        } else {
            gridFragment = (CommentFragment) getSupportFragmentManager().findFragmentById(R.id.comment_container);
        }


    }

    private boolean isTablet() {
        return (getApplicationContext().getResources().getConfiguration().screenLayout &
                Configuration.SCREENLAYOUT_SIZE_MASK) >=
                Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Life cycle test", "We are at onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Life cycle test", "We are at onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Life cycle test", "We are at onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Life cycle test", "We are at onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("Life cycle test", "We are at onDestroy()");
    }

    @Override
    public void onItemSelected(int position) {
        gridFragment.onItemSelected(position);
    }

    @Override
    public void onCommentSelected(int position) {
        listFragment.onItemSelected(position);
    }
}

