package io.github.mohamedisoliman.androiddev.ui.widget;

import android.annotation.SuppressLint;
import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.RemoteViews;
import es.dmoral.toasty.Toasty;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.Repository;
import io.github.mohamedisoliman.androiddev.data.TasksFactory;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.di.AppDependencies;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 8/15/18.
 */
public class TopPostsWidget extends AppWidgetProvider {

  public static final int TOP_POSTS_WIDGET_ID = 304;
  private static final String UPDATE_WIDGET = "myOnClickTag";

  @Override
  public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
    // There may be multiple widgets active, so update all of them
    for (int appWidgetId : appWidgetIds) {
      updateAppWidget(context, appWidgetManager, appWidgetId);
    }
  }

  @SuppressLint("CheckResult")
  public static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
      int appWidgetId) {
    Repository repository =
        new AppDependencies((Application) context.getApplicationContext()).getRepository();

    repository.getLocalTopPosts()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(posts -> updateRemoteViews(context, appWidgetManager, appWidgetId, posts),
            throwable -> Toasty.error(context, throwable.getMessage()).show());
  }

  private static void updateRemoteViews(Context context, AppWidgetManager appWidgetManager,
      int appWidgetId, List<RedditPost> posts) {
    RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.top_posts_widget);

    Intent intent = new Intent(context, ListViewWidgetService.class);
    Bundle bundle = new Bundle();
    bundle.putParcelableArrayList(ListViewWidgetService.KEY_TOP_POSTS_LIST,
        (ArrayList<? extends Parcelable>) posts);
    intent.putExtra(ListViewWidgetService.KEY_TOP_POSTS_LIST, bundle);
    views.setRemoteAdapter(R.id.top_posts, intent);

    views.setOnClickPendingIntent(R.id.refresh_widget, getPendingSelfIntent(context, UPDATE_WIDGET));

    appWidgetManager.updateAppWidget(appWidgetId, views);
    appWidgetManager.notifyAppWidgetViewDataChanged(TOP_POSTS_WIDGET_ID, R.id.top_posts);
  }

  protected static PendingIntent getPendingSelfIntent(Context context, String action) {
    Intent intent = new Intent(context, TopPostsWidget.class);
    intent.setAction(action);
    return PendingIntent.getBroadcast(context, 0, intent, 0);
  }

  @Override
  public void onReceive(Context context, Intent intent) {
    super.onReceive(context, intent);
    if (UPDATE_WIDGET.equals(intent.getAction())) {
      TasksFactory.INSTANCE.instantTopPostsUpdateTask();
    }
  }

  @Override
  public void onDeleted(Context context, int[] appWidgetIds) {

  }

  @Override
  public void onEnabled(Context context) {
    // Enter relevant functionality for when the first widget is created
  }

  @Override
  public void onDisabled(Context context) {
    // Enter relevant functionality for when the last widget is disabled
  }
}
