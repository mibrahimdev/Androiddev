package io.github.mohamedisoliman.androiddev.ui.base

import android.support.v7.widget.RecyclerView
import java.util.ArrayList

/**
 * Created by Mohamed Ibrahim on 4/27/18.
 */
abstract class AppBaseAdapter<VH : RecyclerView.ViewHolder, T> : RecyclerView.Adapter<VH>() {

  val data = ArrayList<T>()

  fun setData(data: List<T>) {
    this.data.clear()
    this.data.addAll(data)
    notifyDataSetChanged()
  }

  override fun getItemCount(): Int {
    return data.size
  }

  protected fun getDataItem(position: Int): T {
    return data[position]
  }
}
