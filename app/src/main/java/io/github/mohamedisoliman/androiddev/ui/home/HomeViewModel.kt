package io.github.mohamedisoliman.androiddev.ui.home

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import io.github.mohamedisoliman.androiddev.data.Repository
import io.github.mohamedisoliman.androiddev.data.TasksFactory
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.github.mohamedisoliman.androiddev.di.AppDependencies
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject.createDefault
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import java.util.Collections.emptyList

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
class HomeViewModel(application: Application) : AndroidViewModel(application) {

  private val repository: Repository
  private val posts = createDefault(emptyList<RedditPost>())
  private val loadingIndicator = PublishSubject.create<Boolean>()
  private val errorIndicator = PublishSubject.create<String>()
  private val compositeDisposable = CompositeDisposable()

  init {

    val appDependencies = AppDependencies(application)
    repository = appDependencies.repository
    TasksFactory.periodicTopPostsUpdate()
  }

  fun loadPosts() {

    if (posts.value!!.isEmpty()) {
      refreshLoading()
    } else {
      posts.onNext(posts.value!!)
    }
  }

  private fun refreshLoading() {
    compositeDisposable.add(Observable.just("start")
        .doOnNext { loadingIndicator.onNext(true) }
        .flatMap { repository.androidDev }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext { loadingIndicator.onNext(false) }
        .doOnError { loadingIndicator.onNext(false) }
        .doOnError { throwable -> errorIndicator.onNext(throwable.message!!) }
        .doOnNext { redditPosts ->
          if (redditPosts.isEmpty()) errorIndicator.onNext("No available data")
        }
        .subscribe({ posts.onNext(it) }, { Timber.e(it) }))
  }

  fun loadWithFilter(filter: String) {
    compositeDisposable.add(repository.saveFilter(filter)
        .subscribe({ this.refreshLoading() }
        ) { throwable -> errorIndicator.onNext(throwable.message!!) })
  }

  fun getPosts(): Observable<List<RedditPost>> {
    return posts
  }

  fun getLoadingIndicator(): Observable<Boolean> {
    return loadingIndicator.observeOn(AndroidSchedulers.mainThread())
  }

  fun getErrorIndicator(): Observable<String> {
    return errorIndicator.observeOn(AndroidSchedulers.mainThread())
  }

  override fun onCleared() {
    errorIndicator.onComplete()
    loadingIndicator.onComplete()
    compositeDisposable.clear()
    super.onCleared()
  }
}
