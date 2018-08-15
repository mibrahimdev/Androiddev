package io.github.mohamedisoliman.androiddev.ui.widget;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 8/15/18.
 */
public class ListViewWidgetService extends RemoteViewsService {

  public static final String KEY_TOP_POSTS_LIST = "top_posts";

  @Override
  public RemoteViewsFactory onGetViewFactory(Intent intent) {
    Bundle bundle = intent.getBundleExtra(KEY_TOP_POSTS_LIST);
    return new AppWidgetListView(this.getApplicationContext(),
        bundle.getParcelableArrayList(KEY_TOP_POSTS_LIST));
  }

  public class AppWidgetListView implements RemoteViewsService.RemoteViewsFactory {

    private List<RedditPost> dataList;
    private Context context;

    public AppWidgetListView(Context applicationContext, List<RedditPost> dataList) {
      this.context = applicationContext;
      this.dataList = dataList;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public int getCount() {
      return dataList.size();
    }

    @Override
    public RemoteViews getViewAt(int position) {
      RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.item_top_post);
      RedditPost item = dataList.get(position);
      views.setTextViewText(R.id.widget_ingredient_name, item.getTitle());
      return views;
    }

    @Override
    public RemoteViews getLoadingView() {
      return new RemoteViews(context.getPackageName(), R.layout.loading_view);
    }

    @Override
    public int getViewTypeCount() {
      return 1;
    }

    @Override
    public long getItemId(int position) {
      return position;
    }

    @Override
    public boolean hasStableIds() {
      return false;
    }
  }
}