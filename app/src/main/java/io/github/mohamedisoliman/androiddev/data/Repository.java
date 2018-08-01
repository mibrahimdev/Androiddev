package io.github.mohamedisoliman.androiddev.data;

import java.util.List;

import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.data.remote.RedditRemoteStore;
import io.reactivex.Observable;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class Repository {

    private RedditRemoteStore remoteStore;

    public Repository(RedditRemoteStore remoteStore) {
        this.remoteStore = remoteStore;
    }

    public Observable<List<RedditPost>> getAndroidDev() {
        return remoteStore.getSubreddit();
    }
}
