package io.github.mohamedisoliman.androiddev.data.remote;

import io.github.mohamedisoliman.androiddev.data.model.RedditResponse;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mohamed Ibrahim on 7/30/18.
 */
public interface RedditApi {

  @GET("/r/{subreddit}.json")
  Observable<RedditResponse> getSubreddit(@Path("subreddit") String subreddit,
      @Query("after") String after, @Query("limit") int limit);
}
