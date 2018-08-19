package io.github.mohamedisoliman.androiddev.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Data {

  @Expose
  private val after: String? = null
  @SerializedName("approved_at_utc")
  private val approvedAtUtc: Any? = null
  @SerializedName("approved_by")
  private val approvedBy: Any? = null
  @Expose
  private val archived: Boolean? = null
  @Expose
  var author: String? = null
  @SerializedName("author_flair_background_color")
  private val authorFlairBackgroundColor: Any? = null
  @SerializedName("author_flair_css_class")
  private val authorFlairCssClass: Any? = null
  @SerializedName("author_flair_richtext")
  private val authorFlairRichtext: List<Any>? = null
  @SerializedName("author_flair_template_id")
  private val authorFlairTemplateId: Any? = null
  @SerializedName("author_flair_text")
  private val authorFlairText: Any? = null
  @SerializedName("author_flair_text_color")
  private val authorFlairTextColor: Any? = null
  @SerializedName("author_flair_type")
  private val authorFlairType: String? = null
  @SerializedName("banned_at_utc")
  private val bannedAtUtc: Any? = null
  @SerializedName("banned_by")
  private val bannedBy: Any? = null
  @Expose
  private val before: Any? = null
  @SerializedName("can_gild")
  private val canGild: Boolean? = null
  @SerializedName("can_mod_post")
  private val canModPost: Boolean? = null
  @Expose
  private val category: Any? = null
  @Expose
  val children: List<Child>? = null
  @Expose
  private val clicked: Boolean? = null
  @SerializedName("content_categories")
  private val contentCategories: Any? = null
  @SerializedName("contest_mode")
  private val contestMode: Boolean? = null
  @Expose
  var created: Double? = null
  @SerializedName("created_utc")
  private val createdUtc: Double? = null
  @Expose
  private val dist: Long? = null
  @Expose
  private val distinguished: Any? = null
  @Expose
  private val domain: String? = null
  @Expose
  private val downs: Long? = null
  //@Expose
  //private Boolean edited;
  @Expose
  private val gilded: Long? = null
  @Expose
  private val hidden: Boolean? = null
  @SerializedName("hide_score")
  private val hideScore: Boolean? = null
  @Expose
  val id: String? = null
  @SerializedName("is_crosspostable")
  private val isCrosspostable: Boolean? = null
  @SerializedName("is_meta")
  private val isMeta: Boolean? = null
  @SerializedName("is_original_content")
  private val isOriginalContent: Boolean? = null
  @SerializedName("is_reddit_media_domain")
  private val isRedditMediaDomain: Boolean? = null
  @SerializedName("is_self")
  private val isSelf: Boolean? = null
  @SerializedName("is_video")
  private val isVideo: Boolean? = null
  @Expose
  private val likes: Any? = null
  @SerializedName("link_flair_background_color")
  private val linkFlairBackgroundColor: String? = null
  @SerializedName("link_flair_css_class")
  private val linkFlairCssClass: Any? = null
  @SerializedName("link_flair_richtext")
  private val linkFlairRichtext: List<Any>? = null
  @SerializedName("link_flair_template_id")
  private val linkFlairTemplateId: Any? = null
  @SerializedName("link_flair_text")
  private val linkFlairText: Any? = null
  @SerializedName("link_flair_text_color")
  private val linkFlairTextColor: String? = null
  @SerializedName("link_flair_type")
  private val linkFlairType: String? = null
  @Expose
  private val locked: Boolean? = null
  @Expose
  private val media: Any? = null
  @SerializedName("media_embed")
  private val mediaEmbed: MediaEmbed? = null
  @SerializedName("media_only")
  private val mediaOnly: Boolean? = null
  @SerializedName("mod_note")
  private val modNote: Any? = null
  @SerializedName("mod_reason_by")
  private val modReasonBy: Any? = null
  @SerializedName("mod_reason_title")
  private val modReasonTitle: Any? = null
  @SerializedName("mod_reports")
  private val modReports: List<Any>? = null
  @Expose
  private val modhash: String? = null
  @Expose
  var name: String? = null
  @SerializedName("no_follow")
  private val noFollow: Boolean? = null
  @SerializedName("num_comments")
  private val numComments: Long? = null
  @SerializedName("num_crossposts")
  private val numCrossposts: Long? = null
  @SerializedName("num_reports")
  private val numReports: Any? = null
  @SerializedName("over_18")
  private val over18: Boolean? = null
  @SerializedName("parent_whitelist_status")
  private val parentWhitelistStatus: String? = null
  @Expose
  private val permalink: String? = null
  @Expose
  private val pinned: Boolean? = null
  @SerializedName("post_categories")
  private val postCategories: Any? = null
  @SerializedName("post_hint")
  private val postHint: String? = null
  @Expose
  private val preview: Preview? = null
  @Expose
  private val pwls: Long? = null
  @Expose
  private val quarantine: Boolean? = null
  @SerializedName("removal_reason")
  private val removalReason: Any? = null
  @SerializedName("report_reasons")
  private val reportReasons: Any? = null
  @SerializedName("rte_mode")
  private val rteMode: String? = null
  @Expose
  private val saved: Boolean? = null
  @Expose
  private val score: Long? = null
  @SerializedName("secure_media")
  private val secureMedia: Any? = null
  @SerializedName("secure_media_embed")
  private val secureMediaEmbed: SecureMediaEmbed? = null
  @Expose
  private val selftext: String? = null
  @SerializedName("selftext_html")
  private val selftextHtml: Any? = null
  @SerializedName("send_replies")
  private val sendReplies: Boolean? = null
  @Expose
  private val spoiler: Boolean? = null
  @Expose
  private val stickied: Boolean? = null
  @Expose
  private val subreddit: String? = null
  @SerializedName("subreddit_id")
  private val subredditId: String? = null
  @SerializedName("subreddit_name_prefixed")
  private val subredditNamePrefixed: String? = null
  @SerializedName("subreddit_subscribers")
  private val subredditSubscribers: Long? = null
  @SerializedName("subreddit_type")
  private val subredditType: String? = null
  @SerializedName("suggested_sort")
  private val suggestedSort: Any? = null
  @Expose
  var thumbnail: String? = null
  @SerializedName("thumbnail_height")
  private val thumbnailHeight: Long? = null
  @SerializedName("thumbnail_width")
  private val thumbnailWidth: Long? = null
  @Expose
  val title: String? = null
  @Expose
  val ups: Long? = null
  @Expose
  val url: String? = null
  @SerializedName("user_reports")
  private val userReports: List<Any>? = null
  @SerializedName("view_count")
  private val viewCount: Any? = null
  @Expose
  private val visited: Boolean? = null
  @SerializedName("whitelist_status")
  private val whitelistStatus: String? = null
  @Expose
  private val wls: Long? = null
}
