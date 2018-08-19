package io.github.mohamedisoliman.androiddev.data.model

import com.google.gson.annotations.Expose

class RedditResponse {

  @Expose
  var data: Data? = null
  @Expose
  var kind: String? = null
}
