package io.github.mohamedisoliman.androiddev.data;

import android.app.Application;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v4.app.TaskStackBuilder;
import androidx.work.Worker;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter;
import io.github.mohamedisoliman.androiddev.di.AppDependencies;
import io.github.mohamedisoliman.androiddev.ui.home.HomeActivity;
import io.github.mohamedisoliman.androiddev.ui.widget.TopPostsWidget;
import timber.log.Timber;

/**
 * Created by Mohamed Ibrahim on 8/8/18.
 */
public class GettingTopPostsWorker extends Worker {

  private static final String CHANNEL_ID = "androiddev_notifications";
  private static final int TOP_POSTS_NOTIFICATION_ID = 0x10;

  @NonNull
  @Override
  public Result doWork() {
    AppDependencies appDependencies = new AppDependencies((Application) getApplicationContext());
    Repository repository = appDependencies.getRepository();

    try {

      Boolean result = repository.deleteLocalPosts()
          .andThen(repository.getSubreddit(RedditFilter.TOP, 5))
          .flatMapSingle(redditPosts -> repository.insertTopFive(redditPosts)
              .toSingleDefault(true)
              .onErrorReturnItem(false))
          .doOnError(Timber::e)
          .blockingSingle();

      if (result) {
        showNotification();
        updateWidget(getApplicationContext());
      }

      return result ? Result.SUCCESS : Result.FAILURE;
    } catch (Exception e) {
      return Result.RETRY;
    }
  }

  private void showNotification() {
    NotificationCompat.Builder mBuilder =
        new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID).setSmallIcon(
            R.drawable.ic_reddit_logo)
            .setContentTitle(getApplicationContext().getString(R.string.app_name))
            .setContentText("Top Posts from Androiddev are here :D")
            .setAutoCancel(true)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

    Intent resultIntent = new Intent(getApplicationContext(), HomeActivity.class);
    resultIntent.setAction(HomeActivity.SHOW_TOP_POSTS);

    TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
    stackBuilder.addNextIntentWithParentStack(resultIntent);

    PendingIntent resultPendingIntent =
        stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

    mBuilder.setContentIntent(resultPendingIntent);

    NotificationManagerCompat notificationManager =
        NotificationManagerCompat.from(getApplicationContext());

    notificationManager.notify(TOP_POSTS_NOTIFICATION_ID, mBuilder.build());
  }

  private void updateWidget(Context context) {
    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);
    TopPostsWidget.updateAppWidget(context, appWidgetManager, TopPostsWidget.TOP_POSTS_WIDGET_ID);
  }
}
