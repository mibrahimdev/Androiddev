package io.github.mohamedisoliman.androiddev.data;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mohamed Ibrahim on 8/11/18.
 */
public class TasksFactory {

  private TasksFactory() {
  }

  public static void periodicTopPostsUpdate() {
    Constraints constraints =
        new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build();

    WorkRequest request = new PeriodicWorkRequest.Builder(GettingTopPostsWorker.class, 3,
        TimeUnit.DAYS)
        .setConstraints(constraints)
        .build();

    WorkManager.getInstance().enqueue(request);
  }

  public static void instantTopPostsUpdateTask() {
    Constraints constraints =
        new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build();

    WorkRequest request =
        new OneTimeWorkRequest.Builder(GettingTopPostsWorker.class).setConstraints(constraints)
            .build();
    WorkManager.getInstance().enqueue(request);
  }
}
