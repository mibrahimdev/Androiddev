package io.github.mohamedisoliman.androiddev.ui.widget

import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import io.github.mohamedisoliman.androiddev.R
import io.github.mohamedisoliman.androiddev.data.model.RedditPost

/**
 * Created by Mohamed Ibrahim on 8/15/18.
 */
class ListViewWidgetService : RemoteViewsService() {

  override fun onGetViewFactory(intent: Intent): RemoteViewsService.RemoteViewsFactory {
    val bundle = intent.getBundleExtra(KEY_TOP_POSTS_LIST)
    return AppWidgetListView(this.applicationContext,
        bundle.getParcelableArrayList(KEY_TOP_POSTS_LIST))
  }

  inner class AppWidgetListView(private val context: Context,
      private val dataList: List<RedditPost>) : RemoteViewsService.RemoteViewsFactory {

    override fun onCreate() {

    }

    override fun onDataSetChanged() {

    }

    override fun onDestroy() {

    }

    override fun getCount(): Int {
      return dataList.size
    }

    override fun getViewAt(position: Int): RemoteViews {
      val views = RemoteViews(context.packageName, R.layout.item_top_post)
      val item = dataList[position]
      views.setTextViewText(R.id.widget_post_title, item.title)
      return views
    }

    override fun getLoadingView(): RemoteViews {
      return RemoteViews(context.packageName, R.layout.loading_view)
    }

    override fun getViewTypeCount(): Int {
      return 1
    }

    override fun getItemId(position: Int): Long {
      return position.toLong()
    }

    override fun hasStableIds(): Boolean {
      return false
    }
  }

  companion object {
    const val KEY_TOP_POSTS_LIST = "top_posts"
  }
}