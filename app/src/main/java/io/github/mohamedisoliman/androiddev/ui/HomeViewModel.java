package io.github.mohamedisoliman.androiddev.ui;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import io.github.mohamedisoliman.androiddev.data.Repository;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.di.AppDependencies;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.BehaviorSubject;
import java.util.List;

import static io.reactivex.subjects.BehaviorSubject.createDefault;
import static java.util.Collections.emptyList;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class HomeViewModel extends AndroidViewModel {

  private Repository repository;
  private BehaviorSubject<List<RedditPost>> posts = createDefault(emptyList());
  private CompositeDisposable compositeDisposable = new CompositeDisposable();

  public HomeViewModel(@NonNull Application application) {
    super(application);
    AppDependencies appDependencies = new AppDependencies(application);
    repository = appDependencies.getRepository();
  }

  public void loadPosts() {
    compositeDisposable.add(repository.getAndroidDev()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(posts::onNext));
  }
}
