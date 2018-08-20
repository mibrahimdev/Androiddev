package io.github.mohamedisoliman.androiddev.data.remote

import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.reactivex.Observable
import timber.log.Timber

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
class RedditRemoteStore(private val redditApi: RedditApi) {

  companion object {
    private const val ANDROIDDEV_SUBREDDIT = "androiddev"
  }

  fun getSubreddit(filter: String, limit: Int): Observable<List<RedditPost>> {
    return redditApi.getSubreddit(ANDROIDDEV_SUBREDDIT, filter, limit = limit)
        .doOnError { Timber.e(it) }
        .map { redditResponse -> redditResponse.data }
        .map { it.children }
        .flatMap { source -> Observable.fromIterable(source) }
        .map { child -> child.data }
        .map { RedditPost(0, it.id, it.title, it.author, it.url, it.thumbnail, it.ups, it.created) }
        .toList()
        .toObservable()
  }

}
