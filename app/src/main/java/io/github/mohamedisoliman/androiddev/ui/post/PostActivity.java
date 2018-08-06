package io.github.mohamedisoliman.androiddev.ui.post;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.databinding.ActivityPostBinding;
import io.github.mohamedisoliman.androiddev.ui.Util;

/**
 * Created by Mohamed Ibrahim on 8/5/18.
 */
public class PostActivity extends AppCompatActivity {

  private static final String KEY_POST = "POST";
  ActivityPostBinding binding;
  private RedditPost post;

  public static void start(Context context, RedditPost post) {
    Intent starter = new Intent(context, PostActivity.class);
    starter.putExtra(KEY_POST, post);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    post = getIntent().getParcelableExtra(KEY_POST);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_post);
    setSupportActionBar(binding.appbar.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    binding.webview.setWebViewClient(getWebViewClient());
    binding.webview.setWebChromeClient(getWebChromeClient());
    binding.webview.loadUrl(post.getUrl());
  }

  @NonNull
  private WebChromeClient getWebChromeClient() {
    return new WebChromeClient() {

      @Override
      public void onProgressChanged(WebView view, int newProgress) {
        setValue(newProgress);
        super.onProgressChanged(view, newProgress);
      }
    };
  }

  @NonNull
  private WebViewClient getWebViewClient() {
    return new WebViewClient() {
      @Override
      public boolean shouldOverrideKeyEvent(WebView view, KeyEvent event) {
        return true;
      }
    };
  }

  public void setValue(int newProgress) {
    binding.appbar.progress.setProgress(newProgress);
    if (newProgress == 100) {
      binding.appbar.progress.setVisibility(View.GONE);
    } else if (binding.appbar.progress.getVisibility() == View.GONE) {
      binding.appbar.progress.setVisibility(View.VISIBLE);
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.menu_post_activity, menu);
    return super.onCreateOptionsMenu(menu);
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        break;
      case R.id.share:
        if (post != null) {
          Util.sharePost(post, this);
        }
        break;
      case R.id.external:
        if (post != null) {
          Util.openExternal(post.getUrl(), this);
        }
        break;
    }
    return super.onOptionsItemSelected(item);
  }
}
