package io.github.mohamedisoliman.androiddev.data.local;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import io.github.mohamedisoliman.androiddev.data.model.RedditFilter;

/**
 * Created by Mohamed Ibrahim on 8/5/18.
 */
public class RedditLocalStore {

  private static final String KEY_FILTER = "FILTER";
  private static final String FILE_NAME = "Androiddev_pref";
  private final SharedPreferences sharedPreferences;

  public RedditLocalStore(Application app) {
    sharedPreferences = app.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE);
  }

  public void saveFilter(String filter) {
    sharedPreferences.edit().putString(KEY_FILTER, filter).apply();
  }

  public String getFilter() {
    return sharedPreferences.getString(KEY_FILTER, RedditFilter.NEW);
  }
}
