package io.github.mohamedisoliman.androiddev.data.remote;

import java.util.List;

import io.github.mohamedisoliman.androiddev.data.model.Child;
import io.github.mohamedisoliman.androiddev.data.model.Data;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.data.model.RedditResponse;
import io.reactivex.Observable;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class RedditRemoteStore {

    private static final String ANDROIDDEV_SUBREDDIT = "androiddev";
    private static final int LIMIT = 10;

    private RedditApi redditApi;

    public RedditRemoteStore(RedditApi redditApi) {
        this.redditApi = redditApi;
    }

    public Observable<List<RedditPost>> getSubreddit() {
        return redditApi.getSubreddit(ANDROIDDEV_SUBREDDIT, "", LIMIT)
                .map(RedditResponse::getData)
                .map(Data::getChildren)
                .flatMap(Observable::fromIterable)
                .map(Child::getData)
                .map(data ->
                        new RedditPost(data.getId(),
                                data.getTitle(), data.getAuthor(),
                                data.getUrl(), data.getThumbnail(), data.getUps()))
                .toList().toObservable();
    }
}
