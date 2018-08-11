package io.github.mohamedisoliman.androiddev.data;

import androidx.work.Constraints;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import java.util.concurrent.TimeUnit;

/**
 * Created by Mohamed Ibrahim on 8/11/18.
 */
public class TasksFactory {

  private TasksFactory() {
  }

  public static void createGetTopPostsTask(boolean periodic) {
    Constraints constraints =
        new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
            .setRequiresBatteryNotLow(true)
            .build();

    WorkManager.getInstance().cancelAllWork();

    if (periodic) {
      PeriodicWorkRequest.Builder retrieveTopPost =
          new PeriodicWorkRequest.Builder(GettingTopPostsWorker.class, 3,
              TimeUnit.DAYS).setConstraints(constraints);

      PeriodicWorkRequest workRequest = retrieveTopPost.build();
      WorkManager.getInstance().enqueue(workRequest);
    } else {

      OneTimeWorkRequest retrieveTopPost =
          new OneTimeWorkRequest.Builder(GettingTopPostsWorker.class).build();
      WorkManager.getInstance().enqueue(retrieveTopPost);
    }
  }
}
