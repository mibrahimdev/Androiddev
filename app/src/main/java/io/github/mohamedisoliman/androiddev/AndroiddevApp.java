package io.github.mohamedisoliman.androiddev;

import android.app.Application;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
public class AndroiddevApp extends Application {

  @Override
  public void onCreate() {
    super.onCreate();

    Fabric.with(this, new Crashlytics());
  }
}
