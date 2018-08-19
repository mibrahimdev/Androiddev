package io.github.mohamedisoliman.androiddev.data.model

import com.google.gson.annotations.Expose

class Preview {

  @Expose
  var enabled: Boolean? = null
  @Expose
  var images: List<Image>? = null
}
