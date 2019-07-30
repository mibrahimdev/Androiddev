package io.github.mohamedisoliman.androiddev.data

import android.app.Application
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder
import androidx.work.Worker
import io.github.mohamedisoliman.androiddev.R
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter
import io.github.mohamedisoliman.androiddev.di.AppDependencies
import io.github.mohamedisoliman.androiddev.ui.home.HomeActivity
import io.github.mohamedisoliman.androiddev.ui.widget.TopPostsWidget
import timber.log.Timber

/**
 * Created by Mohamed Ibrahim on 8/8/18.
 */
class GettingTopPostsWorker : Worker() {

  override fun doWork(): Worker.Result {
    val appDependencies = AppDependencies(applicationContext as Application)
    val repository = appDependencies.repository

    try {

      val result = repository.deleteLocalPosts()
          .andThen(repository.getSubreddit(RedditFilter.TOP.filterValue, 5))
          .flatMapSingle { redditPosts ->
            repository.insertTopFive(redditPosts)
                .toSingleDefault(true)
                .onErrorReturnItem(false)
          }
          .doOnError { Timber.e(it) }
          .blockingSingle()

      if (result) {
        showNotification()
        updateWidget(applicationContext)
      }

      return if (result) Worker.Result.SUCCESS else Worker.Result.FAILURE
    } catch (e: Exception) {
      return Worker.Result.RETRY
    }

  }

  private fun showNotification() {
    val mBuilder = NotificationCompat.Builder(applicationContext, CHANNEL_ID).setSmallIcon(
        R.drawable.ic_reddit_logo)
        .setContentTitle(applicationContext.getString(R.string.app_name))
        .setContentText(applicationContext.getString(R.string.top_posts_notification_message))
        .setAutoCancel(true)
        .setPriority(NotificationCompat.PRIORITY_DEFAULT)

    val resultIntent = Intent(applicationContext, HomeActivity::class.java)
    resultIntent.action = HomeActivity.SHOW_TOP_POSTS

    val stackBuilder = TaskStackBuilder.create(applicationContext)
    stackBuilder.addNextIntentWithParentStack(resultIntent)

    val resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)

    mBuilder.setContentIntent(resultPendingIntent)

    val notificationManager = NotificationManagerCompat.from(applicationContext)

    notificationManager.notify(TOP_POSTS_NOTIFICATION_ID, mBuilder.build())
  }

  private fun updateWidget(context: Context) {
    val appWidgetManager = AppWidgetManager.getInstance(context)
    TopPostsWidget.updateAppWidget(context, appWidgetManager, TopPostsWidget.TOP_POSTS_WIDGET_ID)
  }

  companion object {

    private const val CHANNEL_ID = "androiddev_notifications"
    private const val TOP_POSTS_NOTIFICATION_ID = 0x10
  }
}
