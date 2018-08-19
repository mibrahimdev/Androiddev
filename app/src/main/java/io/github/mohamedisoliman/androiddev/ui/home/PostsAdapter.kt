package io.github.mohamedisoliman.androiddev.ui.home

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.squareup.picasso.Picasso
import io.github.mohamedisoliman.androiddev.R
import io.github.mohamedisoliman.androiddev.data.model.RedditPost
import io.github.mohamedisoliman.androiddev.databinding.ItemRedditPostBinding
import io.github.mohamedisoliman.androiddev.ui.base.AppBaseAdapter
import io.github.mohamedisoliman.androiddev.ui.post.PostActivity
import io.github.mohamedisoliman.androiddev.ui.sharePost

/**
 * Created by Mohamed Ibrahim on 8/4/18.
 */
internal class PostsAdapter : AppBaseAdapter<PostsAdapter.PostViewHolder, RedditPost>() {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
    val inflater = LayoutInflater.from(parent.context)
    val itemRedditPostBinding = DataBindingUtil.inflate<ItemRedditPostBinding>(inflater,
        R.layout.item_reddit_post, parent, false)
    return PostViewHolder(itemRedditPostBinding)
  }

  override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
    holder.bindData(getDataItem(position))
  }

  internal inner class PostViewHolder(private val itemRedditPostBinding: ItemRedditPostBinding) :
      RecyclerView.ViewHolder(itemRedditPostBinding.root) {
    private val context: Context = itemRedditPostBinding.root.context

    fun bindData(post: RedditPost) {
      itemRedditPostBinding.postItem.setOnClickListener { PostActivity.start(context, post) }
      itemRedditPostBinding.title.text = post.title
      itemRedditPostBinding.actionShare.setOnClickListener { context.sharePost(post) }
      itemRedditPostBinding.author.text = post.author
      itemRedditPostBinding.created.text = post.createdDate
      itemRedditPostBinding.upvotes.text = post.ups.toString()
      Picasso.get()
          .load(post.thumbnail)
          .error(R.drawable.ic_reddit_logo)
          .into(itemRedditPostBinding.thumbnail)
    }
  }
}
