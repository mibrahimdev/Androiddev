package io.github.mohamedisoliman.androiddev.ui;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.github.mohamedisoliman.androiddev.R;

public class HomeActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    HomeViewModel homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    homeViewModel.loadPosts();
  }
}
