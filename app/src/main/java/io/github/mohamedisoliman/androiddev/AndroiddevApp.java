package io.github.mohamedisoliman.androiddev;

import android.app.Application;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.MobileAds;
import io.fabric.sdk.android.Fabric;
import io.github.mohamedisoliman.androiddev.data.GettingTopPostsWorker;
import java.util.concurrent.TimeUnit;

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
    PeriodicWorkRequest.Builder photoCheckBuilder = new PeriodicWorkRequest
            .Builder(GettingTopPostsWorker.class, 3, TimeUnit.MINUTES);
    PeriodicWorkRequest workRequest = photoCheckBuilder.build();
    WorkManager.getInstance().enqueue(workRequest);
  }
}
