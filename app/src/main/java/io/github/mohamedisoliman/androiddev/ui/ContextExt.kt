package io.github.mohamedisoliman.androiddev.ui

import android.content.Context
import android.content.Intent
import android.net.Uri
import io.github.mohamedisoliman.androiddev.data.model.RedditPost

/**
 *
 * Created by Mohamed Ibrahim on 8/19/18.
 */

fun Context.sharePost(post: RedditPost) {
  val share = Intent(Intent.ACTION_SEND)
  share.type = "text/plain"
  share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET)
  share.putExtra(Intent.EXTRA_SUBJECT, post.title)
  share.putExtra(Intent.EXTRA_TEXT, post.url)
  startActivity(Intent.createChooser(share, "Share link!"))
}

fun Context.openExternal(url: String) {
  val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
  startActivity(browserIntent)
}