package io.github.mohamedisoliman.androiddev.di

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.github.mohamedisoliman.androiddev.data.Repository
import io.github.mohamedisoliman.androiddev.data.local.RedditLocalStore
import io.github.mohamedisoliman.androiddev.data.remote.RedditApi
import io.github.mohamedisoliman.androiddev.data.remote.RedditRemoteStore
import io.github.mohamedisoliman.androiddev.data.remote.RemotesDataFactory

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
class AppDependencies(application: Application) : AndroidViewModel(application) {

  val repository: Repository

  init {
    val localStore = RedditLocalStore(application)
    val redditApi = RemotesDataFactory.newRedditApi()
    val redditRemoteStore = RedditRemoteStore(redditApi)

    repository = Repository(redditRemoteStore, localStore)
  }
}
