package io.github.mohamedisoliman.androiddev.data.local;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.SharedPreferences;
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.reactivex.Completable;
import io.reactivex.Observable;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 8/5/18.
 */
public class RedditLocalStore {

  private static final String KEY_FILTER = "FILTER";
  private static final String FILE_NAME = "Androiddev_pref";
  private final SharedPreferences sharedPreferences;
  private final PostsDatabase database;

  public RedditLocalStore(Context app) {
    sharedPreferences = app.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
    database = Room.databaseBuilder(app, PostsDatabase.class, "androiddev.db")
        .fallbackToDestructiveMigration()
        .build();
  }

  public void saveFilter(String filter) {
    sharedPreferences.edit().putString(KEY_FILTER, filter).apply();
  }

  public String getFilter() {
    return sharedPreferences.getString(KEY_FILTER, RedditFilter.NEW.getFilterValue());
  }

  public Completable insertPosts(List<RedditPost> posts) {
    return database.insertPosts(posts);
  }

  public Observable<List<RedditPost>> getPosts() {
    return database.getTopPosts();
  }

  public Completable deletePosts() {
    return database.deletePosts();
  }
}
