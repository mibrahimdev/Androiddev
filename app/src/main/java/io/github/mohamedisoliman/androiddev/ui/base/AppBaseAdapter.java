package io.github.mohamedisoliman.androiddev.ui.base;

import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohamed Ibrahim on 4/27/18.
 */
public abstract class AppBaseAdapter<VH extends RecyclerView.ViewHolder, T>
    extends RecyclerView.Adapter<VH> {

  private List<T> data = new ArrayList<>();

  public void setData(List<T> data) {
    this.data.clear();
    this.data.addAll(data);
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return data.size();
  }

  protected T getDataItem(int position) {
    return data.get(position);
  }

  public List<T> getData() {
    return data;
  }
}
