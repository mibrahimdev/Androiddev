package io.github.mohamedisoliman.androiddev.data;

import android.app.Application;
import android.support.annotation.NonNull;
import androidx.work.Worker;
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.di.AppDependencies;
import timber.log.Timber;

/**
 * Created by Mohamed Ibrahim on 8/8/18.
 */
public class GettingTopPostsWorker extends Worker {

  @NonNull
  @Override
  public Result doWork() {
    AppDependencies appDependencies = new AppDependencies((Application) getApplicationContext());
    Repository repository = appDependencies.getRepository();

    repository.getSubreddit(RedditFilter.TOP)
        .take(5)
        .flatMap(redditPosts -> repository.insertTopFive(
            redditPosts.toArray(new RedditPost[redditPosts.size()])).toObservable())
        .doOnError(Timber::e)
        .blockingSubscribe();

    return Result.SUCCESS;
  }
}
