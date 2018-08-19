package io.github.mohamedisoliman.androiddev.data

import io.github.mohamedisoliman.androiddev.data.local.RedditLocalStore
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.github.mohamedisoliman.androiddev.data.remote.RedditRemoteStore
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
class Repository(private val remoteStore: RedditRemoteStore,
    private val localStore: RedditLocalStore) {

  val androidDev: Observable<List<RedditPost>>
    get() {
      return getSubreddit(localStore.filter, LIMIT)
    }

  val localTopPosts: Observable<List<RedditPost>>
    get() = localStore.posts.subscribeOn(Schedulers.io())

  fun getSubreddit(filter: String, limit: Int): Observable<List<RedditPost>> {
    return remoteStore.getSubreddit(filter, limit)
  }

  fun saveFilter(filter: String): Completable {
    return Completable.fromAction { localStore.filter = filter }
  }

  fun insertTopFive(posts: List<RedditPost>): Completable {
    return localStore.insertPosts(posts)
  }

  fun deleteLocalPosts(): Completable {
    return localStore.deletePosts()
  }

  companion object {
    private const val LIMIT = 25
  }
}
