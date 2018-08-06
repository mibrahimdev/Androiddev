package io.github.mohamedisoliman.androiddev.ui;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;

/**
 * Created by Mohamed Ibrahim on 8/6/18.
 */
public class Util {

  public static void sharePost(RedditPost post, Context context) {
    Intent share = new Intent(android.content.Intent.ACTION_SEND);
    share.setType("text/plain");
    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
    share.putExtra(Intent.EXTRA_SUBJECT, post.getTitle());
    share.putExtra(Intent.EXTRA_TEXT, post.getUrl());
    context.startActivity(Intent.createChooser(share, "Share link!"));
  }

  public static void openExternal(String url, Context context) {
    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
    context.startActivity(browserIntent);
  }
}
