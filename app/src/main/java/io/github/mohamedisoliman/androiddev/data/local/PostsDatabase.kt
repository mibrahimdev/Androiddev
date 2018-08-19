package io.github.mohamedisoliman.androiddev.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.reactivex.Completable
import io.reactivex.Observable
import timber.log.Timber

/**
 * Created by Mohamed Ibrahim on 8/7/18.
 */
@Database(entities = [RedditPost::class], version = 1, exportSchema = false)
abstract class PostsDatabase : RoomDatabase() {

  fun getTopPosts(): Observable<List<RedditPost>> =
      topPostsDao().recipes.doOnError { Timber.e(it) }.toObservable()

  abstract fun topPostsDao(): TopPostsDao

  fun insertPosts(posts: List<RedditPost>): Completable {
    return Completable.fromAction { topPostsDao().insertPosts(posts) }
  }

  fun deletePosts(): Completable {
    return Completable.fromAction { topPostsDao().deletePosts() }
  }
}
