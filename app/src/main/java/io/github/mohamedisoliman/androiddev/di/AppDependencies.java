package io.github.mohamedisoliman.androiddev.di;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import io.github.mohamedisoliman.androiddev.data.Repository;
import io.github.mohamedisoliman.androiddev.data.local.RedditLocalStore;
import io.github.mohamedisoliman.androiddev.data.remote.RedditApi;
import io.github.mohamedisoliman.androiddev.data.remote.RedditRemoteStore;
import io.github.mohamedisoliman.androiddev.data.remote.RemotesDataFactory;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class AppDependencies extends AndroidViewModel {

  private Repository repository;

  public AppDependencies(@NonNull Application application) {
    super(application);
    RedditLocalStore localStore = new RedditLocalStore(application);
    RedditApi redditApi = RemotesDataFactory.newRedditApi();
    RedditRemoteStore redditRemoteStore = new RedditRemoteStore(redditApi);

    repository = new Repository(redditRemoteStore, localStore);
  }

  public Repository getRepository() {
    return repository;
  }
}
