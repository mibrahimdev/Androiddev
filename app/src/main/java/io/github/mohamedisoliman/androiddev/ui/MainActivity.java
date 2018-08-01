package io.github.mohamedisoliman.androiddev.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.remote.RedditApi;
import io.github.mohamedisoliman.androiddev.data.remote.RemotesDataFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        homeViewModel.loadPosts();
    }
}
