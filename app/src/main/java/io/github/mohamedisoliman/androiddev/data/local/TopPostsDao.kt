package io.github.mohamedisoliman.androiddev.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.reactivex.Single

/**
 * Created by Mohamed Ibrahim on 8/7/18.
 */
@Dao
interface TopPostsDao {

  @get:Query("SELECT * FROM top_posts")
  val recipes: Single<List<RedditPost>>

  @Insert(onConflict = OnConflictStrategy.REPLACE)
  fun insertPosts(posts: List<RedditPost>)

  @Query("DELETE FROM top_posts ")
  fun deletePosts()
}
