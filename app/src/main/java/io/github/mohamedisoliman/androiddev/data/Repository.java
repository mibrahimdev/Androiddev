package io.github.mohamedisoliman.androiddev.data;

import io.github.mohamedisoliman.androiddev.data.local.RedditLocalStore;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.data.remote.RedditRemoteStore;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class Repository {

  private RedditRemoteStore remoteStore;
  private RedditLocalStore localStore;

  public Repository(RedditRemoteStore remoteStore, RedditLocalStore localStore) {
    this.remoteStore = remoteStore;
    this.localStore = localStore;
  }

  public Observable<List<RedditPost>> getAndroidDev() {
    String filter = localStore.getFilter();
    return remoteStore.getSubreddit(filter);
  }

  public Completable saveFilter(String filter) {
    return Completable.fromAction(() -> localStore.saveFilter(filter));
  }

  public Completable insertTopFive(RedditPost... posts) {
    return localStore.insertPosts(posts);
  }


}
