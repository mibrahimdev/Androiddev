package io.github.mohamedisoliman.androiddev.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Data {

  @Expose
  private String after;
  @SerializedName("approved_at_utc")
  private Object approvedAtUtc;
  @SerializedName("approved_by")
  private Object approvedBy;
  @Expose
  private Boolean archived;
  @Expose
  private String author;
  @SerializedName("author_flair_background_color")
  private Object authorFlairBackgroundColor;
  @SerializedName("author_flair_css_class")
  private Object authorFlairCssClass;
  @SerializedName("author_flair_richtext")
  private List<Object> authorFlairRichtext;
  @SerializedName("author_flair_template_id")
  private Object authorFlairTemplateId;
  @SerializedName("author_flair_text")
  private Object authorFlairText;
  @SerializedName("author_flair_text_color")
  private Object authorFlairTextColor;
  @SerializedName("author_flair_type")
  private String authorFlairType;
  @SerializedName("banned_at_utc")
  private Object bannedAtUtc;
  @SerializedName("banned_by")
  private Object bannedBy;
  @Expose
  private Object before;
  @SerializedName("can_gild")
  private Boolean canGild;
  @SerializedName("can_mod_post")
  private Boolean canModPost;
  @Expose
  private Object category;
  @Expose
  private List<Child> children;
  @Expose
  private Boolean clicked;
  @SerializedName("content_categories")
  private Object contentCategories;
  @SerializedName("contest_mode")
  private Boolean contestMode;
  @Expose
  private Double created;
  @SerializedName("created_utc")
  private Double createdUtc;
  @Expose
  private Long dist;
  @Expose
  private Object distinguished;
  @Expose
  private String domain;
  @Expose
  private Long downs;
  //@Expose
  //private Boolean edited;
  @Expose
  private Long gilded;
  @Expose
  private Boolean hidden;
  @SerializedName("hide_score")
  private Boolean hideScore;
  @Expose
  private String id;
  @SerializedName("is_crosspostable")
  private Boolean isCrosspostable;
  @SerializedName("is_meta")
  private Boolean isMeta;
  @SerializedName("is_original_content")
  private Boolean isOriginalContent;
  @SerializedName("is_reddit_media_domain")
  private Boolean isRedditMediaDomain;
  @SerializedName("is_self")
  private Boolean isSelf;
  @SerializedName("is_video")
  private Boolean isVideo;
  @Expose
  private Object likes;
  @SerializedName("link_flair_background_color")
  private String linkFlairBackgroundColor;
  @SerializedName("link_flair_css_class")
  private Object linkFlairCssClass;
  @SerializedName("link_flair_richtext")
  private List<Object> linkFlairRichtext;
  @SerializedName("link_flair_template_id")
  private Object linkFlairTemplateId;
  @SerializedName("link_flair_text")
  private Object linkFlairText;
  @SerializedName("link_flair_text_color")
  private String linkFlairTextColor;
  @SerializedName("link_flair_type")
  private String linkFlairType;
  @Expose
  private Boolean locked;
  @Expose
  private Object media;
  @SerializedName("media_embed")
  private MediaEmbed mediaEmbed;
  @SerializedName("media_only")
  private Boolean mediaOnly;
  @SerializedName("mod_note")
  private Object modNote;
  @SerializedName("mod_reason_by")
  private Object modReasonBy;
  @SerializedName("mod_reason_title")
  private Object modReasonTitle;
  @SerializedName("mod_reports")
  private List<Object> modReports;
  @Expose
  private String modhash;
  @Expose
  private String name;
  @SerializedName("no_follow")
  private Boolean noFollow;
  @SerializedName("num_comments")
  private Long numComments;
  @SerializedName("num_crossposts")
  private Long numCrossposts;
  @SerializedName("num_reports")
  private Object numReports;
  @SerializedName("over_18")
  private Boolean over18;
  @SerializedName("parent_whitelist_status")
  private String parentWhitelistStatus;
  @Expose
  private String permalink;
  @Expose
  private Boolean pinned;
  @SerializedName("post_categories")
  private Object postCategories;
  @SerializedName("post_hint")
  private String postHint;
  @Expose
  private Preview preview;
  @Expose
  private Long pwls;
  @Expose
  private Boolean quarantine;
  @SerializedName("removal_reason")
  private Object removalReason;
  @SerializedName("report_reasons")
  private Object reportReasons;
  @SerializedName("rte_mode")
  private String rteMode;
  @Expose
  private Boolean saved;
  @Expose
  private Long score;
  @SerializedName("secure_media")
  private Object secureMedia;
  @SerializedName("secure_media_embed")
  private SecureMediaEmbed secureMediaEmbed;
  @Expose
  private String selftext;
  @SerializedName("selftext_html")
  private Object selftextHtml;
  @SerializedName("send_replies")
  private Boolean sendReplies;
  @Expose
  private Boolean spoiler;
  @Expose
  private Boolean stickied;
  @Expose
  private String subreddit;
  @SerializedName("subreddit_id")
  private String subredditId;
  @SerializedName("subreddit_name_prefixed")
  private String subredditNamePrefixed;
  @SerializedName("subreddit_subscribers")
  private Long subredditSubscribers;
  @SerializedName("subreddit_type")
  private String subredditType;
  @SerializedName("suggested_sort")
  private Object suggestedSort;
  @Expose
  private String thumbnail;
  @SerializedName("thumbnail_height")
  private Long thumbnailHeight;
  @SerializedName("thumbnail_width")
  private Long thumbnailWidth;
  @Expose
  private String title;
  @Expose
  private Long ups;
  @Expose
  private String url;
  @SerializedName("user_reports")
  private List<Object> userReports;
  @SerializedName("view_count")
  private Object viewCount;
  @Expose
  private Boolean visited;
  @SerializedName("whitelist_status")
  private String whitelistStatus;
  @Expose
  private Long wls;

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public List<Child> getChildren() {
    return children;
  }

  public Double getCreated() {
    return created;
  }

  public void setCreated(Double created) {
    this.created = created;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public String getTitle() {
    return title;
  }

  public Long getUps() {
    return ups;
  }

  public String getUrl() {
    return url;
  }

  public String getId() {
    return id;
  }
}
