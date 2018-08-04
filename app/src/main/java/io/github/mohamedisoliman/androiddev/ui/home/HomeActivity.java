package io.github.mohamedisoliman.androiddev.ui.home;

import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {

  private PostsAdapter postsAdapter = new PostsAdapter();
  private ActivityMainBinding binding;
  private HomeViewModel homeViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    setupPostsRecyclerView();

    homeViewModel.loadPosts();
  }

  private void setupPostsRecyclerView() {
    RecyclerView recyclerView = binding.postsRecyclerView;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);
    recyclerView.setAdapter(postsAdapter);
    homeViewModel.getPosts().subscribe(postsAdapter::setData);
  }
}
