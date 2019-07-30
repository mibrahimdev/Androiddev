package io.github.mohamedisoliman.androiddev.ui.post

import android.content.Context
import android.content.Intent
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.KeyEvent
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import io.github.mohamedisoliman.androiddev.R
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.github.mohamedisoliman.androiddev.databinding.ActivityPostBinding
import io.github.mohamedisoliman.androiddev.ui.openExternal
import io.github.mohamedisoliman.androiddev.ui.sharePost

/**
 * Created by Mohamed Ibrahim on 8/5/18.
 */
class PostActivity : AppCompatActivity() {
  private lateinit var binding: ActivityPostBinding
  private lateinit var post: RedditPost

  private val webChromeClient: WebChromeClient
    get() = object : WebChromeClient() {

      override fun onProgressChanged(view: WebView, newProgress: Int) {
        setValue(newProgress)
        super.onProgressChanged(view, newProgress)
      }
    }

  private val webViewClient: WebViewClient
    get() = object : WebViewClient() {
      override fun shouldOverrideKeyEvent(view: WebView, event: KeyEvent): Boolean {
        return true
      }
    }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    post = intent.getParcelableExtra(KEY_POST)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_post)
    setSupportActionBar(binding.appbar?.toolbar)
    supportActionBar?.setDisplayHomeAsUpEnabled(true)
    supportActionBar?.setDisplayShowTitleEnabled(false)

    binding.webview.webViewClient = webViewClient
    binding.webview.webChromeClient = webChromeClient
    binding.webview.loadUrl(post.url)
  }

  fun setValue(newProgress: Int) {
    binding.appbar?.progress?.progress = newProgress
    binding.appbar?.progress?.visibility = View.VISIBLE
    when (newProgress) {
      100 -> binding.appbar?.progress?.visibility = View.GONE
      else -> binding.appbar?.progress?.visibility = View.VISIBLE

    }
  }

  override fun onCreateOptionsMenu(menu: Menu): Boolean {
    menuInflater.inflate(R.menu.menu_post_activity, menu)
    return super.onCreateOptionsMenu(menu)
  }

  override fun onOptionsItemSelected(item: MenuItem): Boolean {
    when (item.itemId) {
      android.R.id.home -> finish()
      R.id.share -> sharePost(post)
      R.id.external -> openExternal(post.url!!)
    }
    return super.onOptionsItemSelected(item)
  }

  companion object {

    private const val KEY_POST = "POST"

    fun start(context: Context, post: RedditPost) {
      val starter = Intent(context, PostActivity::class.java)
      starter.putExtra(KEY_POST, post)
      context.startActivity(starter)
    }
  }
}
