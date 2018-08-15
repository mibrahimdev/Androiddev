package io.github.mohamedisoliman.androiddev.data;

import io.github.mohamedisoliman.androiddev.data.local.RedditLocalStore;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.data.remote.RedditRemoteStore;
import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class Repository {

  private RedditRemoteStore remoteStore;
  private RedditLocalStore localStore;
  private static final int LIMIT = 25;

  public Repository(RedditRemoteStore remoteStore, RedditLocalStore localStore) {
    this.remoteStore = remoteStore;
    this.localStore = localStore;
  }

  public Observable<List<RedditPost>> getAndroidDev() {
    String filter = localStore.getFilter();
    return getSubreddit(filter, LIMIT);
  }

  public Observable<List<RedditPost>> getSubreddit(String filter, int limit) {
    return remoteStore.getSubreddit(filter, limit);
  }

  public Observable<List<RedditPost>> getLocalTopPosts() {
    return localStore.getPosts().subscribeOn(Schedulers.io());
  }

  public Completable saveFilter(String filter) {
    return Completable.fromAction(() -> localStore.saveFilter(filter));
  }

  public Completable insertTopFive(List<RedditPost> posts) {
    return localStore.insertPosts(posts);
  }

  public Completable deleteLocalPosts() {
    return localStore.deletePosts();
  }
}
