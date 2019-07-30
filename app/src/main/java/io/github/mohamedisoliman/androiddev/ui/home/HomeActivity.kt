package io.github.mohamedisoliman.androiddev.ui.home

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.view.View
import es.dmoral.toasty.Toasty.error
import io.github.mohamedisoliman.androiddev.R
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter
import io.github.mohamedisoliman.androiddev.databinding.ActivityHomeBinding
import timber.log.Timber

class HomeActivity : AppCompatActivity() {
  private val postsAdapter = PostsAdapter()
  private lateinit var binding: ActivityHomeBinding
  private lateinit var homeViewModel: HomeViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
    homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

    bindViews()

    binding.appbar?.title1?.visibility = View.VISIBLE
    binding.appbar?.title2?.visibility = View.VISIBLE
    setSupportActionBar(binding.appbar?.toolbar)
    supportActionBar!!.setDisplayShowTitleEnabled(false)

    if (intent != null && SHOW_TOP_POSTS.equals(intent.action!!, ignoreCase = true)) {
      homeViewModel.loadWithFilter(RedditFilter.TOP.filterValue)
    } else {
      homeViewModel.loadPosts()
    }
  }

  @SuppressLint("CheckResult")
  private fun bindViews() {
    setupPostsRecyclerView()
    homeViewModel.getPosts().subscribe { postsAdapter.setData(it) }
    homeViewModel.getErrorIndicator().subscribe { errorMessage -> error(this, errorMessage).show() }
    homeViewModel.getLoadingIndicator().subscribe { binding.swipeRefreshLayout.isRefreshing = it }
  }

  private fun setupPostsRecyclerView() {
    val recyclerView = binding.postsRecyclerView
    val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
    recyclerView.layoutManager = layoutManager
    recyclerView.setHasFixedSize(true)
    recyclerView.adapter = postsAdapter
    binding.swipeRefreshLayout.isEnabled = false
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_home_activity, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    val id = item.itemId
    when (id) {
      R.id.hot -> homeViewModel.loadWithFilter(RedditFilter.HOT.filterValue)
      R.id.new_posts -> homeViewModel.loadWithFilter(RedditFilter.NEW.filterValue)
      R.id.controversial -> homeViewModel.loadWithFilter(RedditFilter.CONTROVERSIAL.filterValue)
      R.id.top -> homeViewModel.loadWithFilter(RedditFilter.TOP.filterValue)
      R.id.rising -> homeViewModel.loadWithFilter(RedditFilter.RISING.filterValue)
      else -> Timber.i("Menu Item id with no click handling: %s", id.toString())
    }
    return super.onOptionsItemSelected(item)
  }

  companion object {
    const val SHOW_TOP_POSTS = "show_top_posts"
  }
}
