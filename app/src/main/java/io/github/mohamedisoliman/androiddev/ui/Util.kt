package io.github.mohamedisoliman.androiddev.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import io.github.mohamedisoliman.androiddev.data.model.RedditPost

/**
 * Created by Mohamed Ibrahim on 8/6/18.
 */
object Util {

  fun sharePost(post: RedditPost, context: Context) {
    val share = Intent(android.content.Intent.ACTION_SEND)
    share.type = "text/plain"
    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
    share.putExtra(Intent.EXTRA_SUBJECT, post.title)
    share.putExtra(Intent.EXTRA_TEXT, post.url)
    context.startActivity(Intent.createChooser(share, "Share link!"))
  }

  fun openExternal(url: String, context: Context) {
    val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    context.startActivity(browserIntent)
  }
}
