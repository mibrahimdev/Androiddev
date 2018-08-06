package io.github.mohamedisoliman.androiddev.ui.post;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.databinding.ActivityPostBinding;

/**
 * Created by Mohamed Ibrahim on 8/5/18.
 */
public class PostActivity extends AppCompatActivity {

  private static final String KEY_POST = "POST";
  ActivityPostBinding binding;

  public static void start(Context context, RedditPost post) {
    Intent starter = new Intent(context, PostActivity.class);
    starter.putExtra(KEY_POST, post);
    context.startActivity(starter);
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    RedditPost post = getIntent().getParcelableExtra(KEY_POST);
    binding = DataBindingUtil.setContentView(this, R.layout.activity_post);
    setSupportActionBar(binding.appbar.toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setTitle(post.getTitle());
  }
}
