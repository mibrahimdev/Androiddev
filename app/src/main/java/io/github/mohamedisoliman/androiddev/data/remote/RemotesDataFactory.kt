package io.github.mohamedisoliman.androiddev.data.remote

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * Created by Mohamed Ibrahim on 7/31/18.
 */
object RemotesDataFactory {

  private const val BASE_URL = "https://www.reddit.com"

  fun newRedditApi(): RedditApi {

    val retrofit = Retrofit.Builder().baseUrl(BASE_URL)
        .client(okHttpClient)
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(MoshiConverterFactory.create())
        .build()
    return retrofit.create(RedditApi::class.java)
  }

  private val okHttpClient: OkHttpClient
    get() {
      val loggingInterceptor = HttpLoggingInterceptor()
      loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
      val clientBuilder = OkHttpClient.Builder().addInterceptor(loggingInterceptor)
      return clientBuilder.build()
    }

}
