package io.github.mohamedisoliman.androiddev

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.google.android.gms.ads.MobileAds
import io.fabric.sdk.android.Fabric

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
class AndroiddevApp : Application() {

  override fun onCreate() {
    super.onCreate()

    Fabric.with(this, Crashlytics())
    MobileAds.initialize(this, "ca-app-pub-7597895180580413~3393280259")
  }
}
