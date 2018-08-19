package io.github.mohamedisoliman.androiddev.data.model

import com.google.gson.annotations.Expose

class Image {

  @Expose
  var id: String? = null
  @Expose
  var resolutions: List<Resolution>? = null
  @Expose
  var source: Source? = null
  @Expose
  var variants: Variants? = null
}
