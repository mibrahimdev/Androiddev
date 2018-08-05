package io.github.mohamedisoliman.androiddev.ui.home;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.squareup.picasso.Picasso;
import io.github.mohamedisoliman.androiddev.R;
import io.github.mohamedisoliman.androiddev.data.model.RedditPost;
import io.github.mohamedisoliman.androiddev.databinding.ItemRedditPostBinding;
import io.github.mohamedisoliman.androiddev.databinding.PlaceHolderEmptyListBinding;
import io.github.mohamedisoliman.androiddev.ui.base.AppBaseAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    private final Context context;

    public PostViewHolder(ItemRedditPostBinding itemRedditPostBinding) {
      super(itemRedditPostBinding.getRoot());
      this.itemRedditPostBinding = itemRedditPostBinding;
      context = itemRedditPostBinding.getRoot().getContext();
    }

    void bindData(RedditPost post) {
      itemRedditPostBinding.title.setText(post.getTitle());
      itemRedditPostBinding.actionShare.setOnClickListener(v -> share(post));
      itemRedditPostBinding.author.setText(post.getAuthor());
      itemRedditPostBinding.created.setText(post.getCreatedDate());
      itemRedditPostBinding.upvotes.setText(String.valueOf(post.getUps()));
      Picasso.get()
          .load(post.getThumbnail())
          .error(R.drawable.ic_reddit_logo)
          .into(itemRedditPostBinding.thumbnail);
    }

    private void share(RedditPost post) {
      Intent share = new Intent(android.content.Intent.ACTION_SEND);
      share.setType("text/plain");
      share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
      share.putExtra(Intent.EXTRA_SUBJECT, post.getTitle());
      share.putExtra(Intent.EXTRA_TEXT, post.getUrl());
      context.startActivity(Intent.createChooser(share, "Share link!"));
    }
  }
}
