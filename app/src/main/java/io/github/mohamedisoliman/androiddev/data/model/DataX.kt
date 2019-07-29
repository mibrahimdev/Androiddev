package io.github.mohamedisoliman.androiddev.data.model

import com.squareup.moshi.Json

data class DataX(
    @Json(name = "approved_at_utc") val approvedAtUtc: Any?,
    @Json(name = "subreddit") val subreddit: String,
    @Json(name = "selftext") val selftext: String,
    @Json(name = "user_reports") val userReports: List<Any>,
    @Json(name = "saved") val saved: Boolean,
    @Json(name = "mod_reason_title") val modReasonTitle: Any,
    @Json(name = "gilded") val gilded: Int,
    @Json(name = "clicked") val clicked: Boolean,
    @Json(name = "title") val title: String,
    @Json(name = "link_flair_richtext") val linkFlairRichtext: List<Any>,
    @Json(name = "subreddit_name_prefixed") val subredditNamePrefixed: String,
    @Json(name = "hidden") val hidden: Boolean,
    @Json(name = "pwls") val pwls: Int,
    @Json(name = "link_flair_css_class") val linkFlairCssClass: Any,
    @Json(name = "downs") val downs: Int,
    @Json(name = "thumbnail_height") val thumbnailHeight: Any,
    @Json(name = "parent_whitelist_status") val parentWhitelistStatus: String,
    @Json(name = "hide_score") val hideScore: Boolean,
    @Json(name = "name") val name: String,
    @Json(name = "quarantine") val quarantine: Boolean,
    @Json(name = "link_flair_text_color") val linkFlairTextColor: String,
    @Json(name = "author_flair_background_color") val authorFlairBackgroundColor: Any,
    @Json(name = "subreddit_type") val subredditType: String,
    @Json(name = "ups") val ups: Long,
    @Json(name = "domain") val domain: String,
    @Json(name = "media_embed") val mediaEmbed: MediaEmbed,
    @Json(name = "thumbnail_width") val thumbnailWidth: Any,
    @Json(name = "author_flair_template_id") val authorFlairTemplateId: Any,
    @Json(name = "is_original_content") val isOriginalContent: Boolean,
    @Json(name = "secure_media") val secureMedia: Any,
    @Json(name = "is_reddit_media_domain") val isRedditMediaDomain: Boolean,
    @Json(name = "is_meta") val isMeta: Boolean,
    @Json(name = "category") val category: Any,
    @Json(name = "secure_media_embed") val secureMediaEmbed: SecureMediaEmbed,
    @Json(name = "link_flair_text") val linkFlairText: Any,
    @Json(name = "can_mod_post") val canModPost: Boolean,
    @Json(name = "score") val score: Int,
    @Json(name = "approved_by") val approvedBy: Any,
    @Json(name = "thumbnail") val thumbnail: String,
    @Json(name = "author_flair_css_class") val authorFlairCssClass: Any,
    @Json(name = "author_flair_richtext") val authorFlairRichtext: List<Any>,
    @Json(name = "content_categories") val contentCategories: Any,
    @Json(name = "is_self") val isSelf: Boolean,
    @Json(name = "mod_note") val modNote: Any,
    @Json(name = "created") val created: Double,
    @Json(name = "link_flair_type") val linkFlairType: String,
    @Json(name = "wls") val wls: Int,
    @Json(name = "banned_by") val bannedBy: Any,
    @Json(name = "author_flair_type") val authorFlairType: String,
    @Json(name = "contest_mode") val contestMode: Boolean,
    @Json(name = "selftext_html") val selftextHtml: Any,
    @Json(name = "likes") val likes: Any,
    @Json(name = "suggested_sort") val suggestedSort: Any,
    @Json(name = "banned_at_utc") val bannedAtUtc: Any,
    @Json(name = "view_count") val viewCount: Any,
    @Json(name = "archived") val archived: Boolean,
    @Json(name = "no_follow") val noFollow: Boolean,
    @Json(name = "is_crosspostable") val isCrosspostable: Boolean,
    @Json(name = "pinned") val pinned: Boolean,
    @Json(name = "over_18") val over18: Boolean,
    @Json(name = "media_only") val mediaOnly: Boolean,
    @Json(name = "link_flair_template_id") val linkFlairTemplateId: Any,
    @Json(name = "can_gild") val canGild: Boolean,
    @Json(name = "spoiler") val spoiler: Boolean,
    @Json(name = "locked") val locked: Boolean,
    @Json(name = "author_flair_text") val authorFlairText: Any,
    @Json(name = "visited") val visited: Boolean,
    @Json(name = "num_reports") val numReports: Any,
    @Json(name = "distinguished") val distinguished: Any,
    @Json(name = "subreddit_id") val subredditId: String,
    @Json(name = "mod_reason_by") val modReasonBy: Any,
    @Json(name = "removal_reason") val removalReason: Any,
    @Json(name = "link_flair_background_color") val linkFlairBackgroundColor: String,
    @Json(name = "id") val id: String,
    @Json(name = "report_reasons") val reportReasons: Any,
    @Json(name = "author") val author: String,
    @Json(name = "num_crossposts") val numCrossposts: Int,
    @Json(name = "num_comments") val numComments: Int,
    @Json(name = "send_replies") val sendReplies: Boolean,
    @Json(name = "mod_reports") val modReports: List<Any>,
    @Json(name = "author_flair_text_color") val authorFlairTextColor: Any,
    @Json(name = "permalink") val permalink: String,
    @Json(name = "whitelist_status") val whitelistStatus: String,
    @Json(name = "stickied") val stickied: Boolean,
    @Json(name = "url") val url: String,
    @Json(name = "subreddit_subscribers") val subredditSubscribers: Int,
    @Json(name = "created_utc") val createdUtc: Double,
    @Json(name = "media") val media: Any,
    @Json(name = "is_video") val isVideo: Boolean
)