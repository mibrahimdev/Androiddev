package io.github.mohamedisoliman.androiddev.data.model

import com.google.gson.annotations.Expose

class Source {

  @Expose
  var height: Long? = null
  @Expose
  var url: String? = null
  @Expose
  var width: Long? = null
}
