package io.github.mohamedisoliman.androiddev.ui.home;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.databinding.ItemRedditPostBinding;
import io.github.mohamedisoliman.androiddev.ui.base.AppBaseAdapter;

/**
 * Created by Mohamed Ibrahim on 8/4/18.
 */
public class PostsAdapter extends AppBaseAdapter<PostsAdapter.PostViewHolder, RedditPost> {

  @NonNull
  @Override
  public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    LayoutInflater inflater = LayoutInflater.from(parent.getContext());
    ItemRedditPostBinding itemRedditPostBinding =
        DataBindingUtil.inflate(inflater, R.layout.item_reddit_post, parent, false);
    return new PostViewHolder(itemRedditPostBinding);
  }

  @Override
  public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
    holder.bindData(getDataItem(position));
  }

  class PostViewHolder extends RecyclerView.ViewHolder {

    private final ItemRedditPostBinding itemRedditPostBinding;

    public PostViewHolder(ItemRedditPostBinding itemRedditPostBinding) {
      super(itemRedditPostBinding.getRoot());
      this.itemRedditPostBinding = itemRedditPostBinding;
    }

    void bindData(RedditPost post) {
      itemRedditPostBinding.title.setText(post.getTitle());
      itemRedditPostBinding.actionShare.setOnClickListener(v -> { });
      itemRedditPostBinding.author.setText(post.getAuthor());
      itemRedditPostBinding.created.setText(String.valueOf(post.getCreated()));
      itemRedditPostBinding.upvotes.setText(String.valueOf(post.getUps()));
      Picasso.get().load(post.getThumbnail()).into(itemRedditPostBinding.thumbnail);
    }
  }
}
