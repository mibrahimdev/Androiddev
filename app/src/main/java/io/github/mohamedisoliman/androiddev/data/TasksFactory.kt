package io.github.mohamedisoliman.androiddev.data

import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

/**
 * Created by Mohamed Ibrahim on 8/11/18.
 */
object TasksFactory {

  fun periodicTopPostsUpdate() {
    val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresBatteryNotLow(true)
        .build()

    val request = PeriodicWorkRequest.Builder(GettingTopPostsWorker::class.java, 3,
        TimeUnit.DAYS)
        .setConstraints(constraints)
        .build()

    WorkManager.getInstance().enqueue(request)
  }

  fun instantTopPostsUpdateTask() {
    val constraints = Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED)
        .setRequiresBatteryNotLow(true)
        .build()

    val request = OneTimeWorkRequest.Builder(GettingTopPostsWorker::class.java).setConstraints(
        constraints)
        .build()
    WorkManager.getInstance().enqueue(request)
  }
}
