package io.github.mohamedisoliman.androiddev.data.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.reactivex.Single;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 8/7/18.
 */
@Dao
public interface TopPostsDao {

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  void insertPosts(RedditPost... ingredients);

  @Query("SELECT * FROM top_posts")
  Single<List<RedditPost>> getRecipes();
}
