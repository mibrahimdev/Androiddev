package io.github.mohamedisoliman.androiddev.data.remote

import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.reactivex.Observable

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
class RedditRemoteStore(private val redditApi: RedditApi) {

  companion object {
    private const val ANDROIDDEV_SUBREDDIT = "androiddev"
  }

  fun getSubreddit(filter: String, limit: Int): Observable<List<RedditPost>> {
    return redditApi.getSubreddit(ANDROIDDEV_SUBREDDIT, filter, "", limit)
        .map { redditResponse -> redditResponse.data }
        .map { data1 -> data1.children }
        .flatMap { source -> Observable.fromIterable(source) }
        .map { child -> child.data }
        .map { data ->
          RedditPost(0, data.id, data.title, data.author,
              data.url, data.thumbnail, data.ups!!, data.created)
        }
        .toList()
        .toObservable()
  }

}
