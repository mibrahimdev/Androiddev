package io.github.mohamedisoliman.androiddev;

import android.app.Application;
import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.MobileAds;
import io.fabric.sdk.android.Fabric;
import io.github.mohamedisoliman.androiddev.data.GettingTopPostsWorker;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class AndroiddevApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Fabric.with(this, new Crashlytics());
    MobileAds.initialize(this, "ca-app-pub-7597895180580413~3393280259");

    setupPeriodicTask();
  }

  private void setupPeriodicTask() {
    Constraints constraints =
        new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build();

    //PeriodicWorkRequest.Builder photoCheckBuilder =
    //    new PeriodicWorkRequest.Builder(GettingTopPostsWorker.class, 16,
    //        TimeUnit.MINUTES).setConstraints(constraints);
    //
    //PeriodicWorkRequest workRequest = photoCheckBuilder.build();

    OneTimeWorkRequest compressionWork =
        new OneTimeWorkRequest.Builder(GettingTopPostsWorker.class).build();
    WorkManager.getInstance().enqueue(compressionWork);

    WorkManager.getInstance().enqueue(compressionWork);
  }
}
