package io.github.mohamedisoliman.androiddev.ui.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import io.github.mohamedisoliman.androiddev.data.Repository;
import io.github.mohamedisoliman.androiddev.data.TasksFactory;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.di.AppDependencies;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import java.util.List;
import timber.log.Timber;

import static io.reactivex.subjects.BehaviorSubject.createDefault;
import static java.util.Collections.emptyList;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class HomeViewModel extends AndroidViewModel {

  private Repository repository;
  private BehaviorSubject<List<RedditPost>> posts = createDefault(emptyList());
  private PublishSubject<Boolean> loadingIndicator = PublishSubject.create();
  private PublishSubject<String> errorIndicator = PublishSubject.create();
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public HomeViewModel(@NonNull Application application) {
    super(application);

    AppDependencies appDependencies = new AppDependencies(application);
    repository = appDependencies.getRepository();
    TasksFactory.INSTANCE.periodicTopPostsUpdate();
  }

  public void loadPosts() {
    if (posts.getValue().isEmpty()) {
      refreshLoading();
    } else {
      posts.onNext(posts.getValue());
    }
  }

  private void refreshLoading() {
    compositeDisposable.add(Observable.just("start")
        .doOnNext(ignored -> loadingIndicator.onNext(true))
        .flatMap(ignored -> repository.getAndroidDev())
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .doOnNext(redditPosts -> loadingIndicator.onNext(false))
        .doOnError(throwable -> loadingIndicator.onNext(false))
        .doOnError(throwable -> errorIndicator.onNext(throwable.getMessage()))
        .doOnNext(redditPosts -> {
          if (redditPosts.isEmpty()) errorIndicator.onNext("No available data");
        })
        .subscribe(posts::onNext, Timber::e));
  }

  public void loadWithFilter(String filter) {
    compositeDisposable.add(repository.saveFilter(filter)
        .subscribe(this::refreshLoading,
            throwable -> errorIndicator.onNext(throwable.getMessage())));
  }

  public Observable<List<RedditPost>> getPosts() {
    return posts;
  }

  public Observable<Boolean> getLoadingIndicator() {
    return loadingIndicator.observeOn(AndroidSchedulers.mainThread());
  }

  public Observable<String> getErrorIndicator() {
    return errorIndicator.observeOn(AndroidSchedulers.mainThread());
  }

  @Override
  protected void onCleared() {
    errorIndicator.onComplete();
    loadingIndicator.onComplete();
    compositeDisposable.clear();
    super.onCleared();
  }
}
