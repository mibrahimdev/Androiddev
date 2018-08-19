package io.github.mohamedisoliman.androiddev.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Mohamed Ibrahim on 8/1/18.
 */
@Entity(tableName = "top_posts")
@Parcelize
class RedditPost @JvmOverloads constructor(@PrimaryKey(autoGenerate = true) var id: Int = 0,
    var stringId: String? = "", var title: String? = "", var author: String? = "",
    var url: String? = "", var thumbnail: String? = "", var ups: Long = 0,
    var created: Double? = null) : Parcelable {

  val createdDate: String
    get() {
      val date = Date(created!!.toLong())
      val format = "dd/MM, hh:mm a"
      val dateFormat = SimpleDateFormat(format, Locale.ENGLISH)
      return dateFormat.format(date)
    }

}
