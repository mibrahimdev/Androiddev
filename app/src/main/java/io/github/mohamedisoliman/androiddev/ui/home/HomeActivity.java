package io.github.mohamedisoliman.androiddev.ui.home;

import android.annotation.SuppressLint;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import com.google.android.gms.ads.AdRequest;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter;
import io.github.mohamedisoliman.androiddev.databinding.ActivityHomeBinding;
import timber.log.Timber;

import static es.dmoral.toasty.Toasty.error;

public class HomeActivity extends AppCompatActivity {

  private PostsAdapter postsAdapter = new PostsAdapter();
  private ActivityHomeBinding binding;
  private HomeViewModel homeViewModel;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
    homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
    bindViews();
    binding.appbar.title1.setVisibility(View.VISIBLE);
    binding.appbar.title2.setVisibility(View.VISIBLE);
    setSupportActionBar(binding.appbar.toolbar);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    loadAd();
    homeViewModel.loadPosts();
  }

  private void loadAd() {
    AdRequest adRequest = new AdRequest.Builder().build();

    binding.adView.loadAd(adRequest);
  }

  @SuppressLint("CheckResult")
  private void bindViews() {
    setupPostsRecyclerView();
    homeViewModel.getPosts().subscribe(postsAdapter::setData);
    homeViewModel.getErrorIndicator().subscribe(errorMessage -> error(this, errorMessage).show());
    homeViewModel.getLoadingIndicator().subscribe(binding.swipeRefreshLayout::setRefreshing);
  }

  private void setupPostsRecyclerView() {
    RecyclerView recyclerView = binding.postsRecyclerView;
    LinearLayoutManager layoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setHasFixedSize(true);
    recyclerView.setAdapter(postsAdapter);
    binding.swipeRefreshLayout.setEnabled(false);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_home_activity, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    int id = item.getItemId();
    switch (id) {
      case R.id.hot:
        homeViewModel.loadWithFilter(RedditFilter.HOT);
        break;
      case R.id.new_posts:
        homeViewModel.loadWithFilter(RedditFilter.NEW);
        break;
      case R.id.controversial:
        homeViewModel.loadWithFilter(RedditFilter.CONTROVERSIAL);
        break;
      case R.id.top:
        homeViewModel.loadWithFilter(RedditFilter.TOP);
        break;
      case R.id.rising:
        homeViewModel.loadWithFilter(RedditFilter.RISING);
        break;
      default:
        Timber.i("Menu Item id with no click handling: %s", String.valueOf(id));
    }
    return super.onOptionsItemSelected(item);
  }
}
