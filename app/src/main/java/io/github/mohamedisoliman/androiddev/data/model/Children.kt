package io.github.mohamedisoliman.androiddev.data.model

import com.squareup.moshi.Json

data class Children(
    @Json(name = "kind") val kind: String,
    @Json(name = "data") val data: DataX
)