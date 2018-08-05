package io.github.mohamedisoliman.androiddev.data.model;

import android.support.annotation.StringDef;

/**
 * Created by Mohamed Ibrahim on 8/5/18.
 */
@StringDef({
    RedditFilter.NEW, RedditFilter.HOT, RedditFilter.CONTROVERSIAL, RedditFilter.TOP,
    RedditFilter.RISING
})
public @interface RedditFilter {
  String NEW = "new";
  String HOT = "hot";
  String CONTROVERSIAL = "controversial";
  String TOP = "top";
  String RISING = "rising";
}
