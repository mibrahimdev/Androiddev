package io.github.mohamedisoliman.androiddev.ui.widget

import android.annotation.SuppressLint
import android.app.Application
import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.widget.RemoteViews
import es.dmoral.toasty.Toasty
import io.github.mohamedisoliman.androiddev.R
import io.github.mohamedisoliman.androiddev.data.TasksFactory
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.github.mohamedisoliman.androiddev.di.AppDependencies
import io.reactivex.android.schedulers.AndroidSchedulers
import java.util.ArrayList

/**
 * Created by Mohamed Ibrahim on 8/15/18.
 */
class TopPostsWidget : AppWidgetProvider() {

  override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager,
      appWidgetIds: IntArray) {
    // There may be multiple widgets active, so update all of them
    for (appWidgetId in appWidgetIds) {
      updateAppWidget(context, appWidgetManager, appWidgetId)
    }
  }

  override fun onReceive(context: Context, intent: Intent) {
    super.onReceive(context, intent)
    if (UPDATE_WIDGET == intent.action) {
      TasksFactory.instantTopPostsUpdateTask()
    }
  }

  override fun onDeleted(context: Context, appWidgetIds: IntArray) {

  }

  override fun onEnabled(context: Context) {
    // Enter relevant functionality for when the first widget is created
  }

  override fun onDisabled(context: Context) {
    // Enter relevant functionality for when the last widget is disabled
  }

  companion object {

    const val TOP_POSTS_WIDGET_ID = 304
    private const val UPDATE_WIDGET = "myOnClickTag"

    @SuppressLint("CheckResult")
    fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager,
        appWidgetId: Int) {
      val repository = AppDependencies(context.applicationContext as Application).repository

      repository.localTopPosts
          .observeOn(AndroidSchedulers.mainThread())
          .subscribe({ posts -> updateRemoteViews(context, appWidgetManager, appWidgetId, posts) },
              { throwable -> Toasty.error(context, throwable.message!!).show() })
    }

    private fun updateRemoteViews(context: Context, appWidgetManager: AppWidgetManager,
        appWidgetId: Int, posts: List<RedditPost>) {
      val views = RemoteViews(context.packageName, R.layout.top_posts_widget)

      val intent = Intent(context, ListViewWidgetService::class.java)
      val bundle = Bundle()
      bundle.putParcelableArrayList(ListViewWidgetService.KEY_TOP_POSTS_LIST,
          posts as ArrayList<out Parcelable>)
      intent.putExtra(ListViewWidgetService.KEY_TOP_POSTS_LIST, bundle)
      views.setRemoteAdapter(R.id.top_posts, intent)

      views.setOnClickPendingIntent(R.id.refresh_widget, getPendingSelfIntent(context, UPDATE_WIDGET))

      appWidgetManager.updateAppWidget(appWidgetId, views)
      appWidgetManager.notifyAppWidgetViewDataChanged(TOP_POSTS_WIDGET_ID, R.id.top_posts)
    }

    private fun getPendingSelfIntent(context: Context, action: String): PendingIntent {
      val intent = Intent(context, TopPostsWidget::class.java)
      intent.action = action
      return PendingIntent.getBroadcast(context, 0, intent, 0)
    }
  }
}
