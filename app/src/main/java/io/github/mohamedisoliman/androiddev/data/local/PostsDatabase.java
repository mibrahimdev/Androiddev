package io.github.mohamedisoliman.androiddev.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;
import timber.log.Timber;

/**
 * Created by Mohamed Ibrahim on 8/7/18.
 */
@Database(entities = RedditPost.class, version = 1, exportSchema = false)
public abstract class PostsDatabase extends RoomDatabase {

  public abstract TopPostsDao topPostsDao();

  Observable<List<RedditPost>> getTopPosts() {
    return topPostsDao().getRecipes().doOnError(Timber::e).toObservable();
  }

  Completable insertPosts(List<RedditPost> posts) {
    return Completable.fromAction(() -> topPostsDao().insertPosts(posts));
  }

  public Completable deletePosts() {
    return Completable.fromAction(() -> topPostsDao().deletePosts());
  }
}
