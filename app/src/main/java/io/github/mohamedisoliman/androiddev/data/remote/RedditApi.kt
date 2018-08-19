package io.github.mohamedisoliman.androiddev.data.remote

import io.github.mohamedisoliman.androiddev.data.model.RedditResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Mohamed Ibrahim on 7/30/18.
 */
interface RedditApi {

  @GET("/r/{subreddit}/{filter}.json")
  fun getSubreddit(@Path("subreddit") subreddit: String,
      @Path("filter") filter: String, @Query("after") after: String,
      @Query("limit") limit: Int): Observable<RedditResponse>
}
