package io.github.mohamedisoliman.androiddev.data.model

import com.squareup.moshi.Json

data class Data(
    @Json(name = "modhash") val modhash: String,
    @Json(name = "dist") val dist: Int,
    @Json(name = "children") val children: List<Children>,
    @Json(name = "after") val after: String,
    @Json(name = "before") val before: Any
)