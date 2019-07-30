package io.github.mohamedisoliman.androiddev.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
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
