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
  @Expose
  private Boolean edited;
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

  public String getAfter() {
    return after;
  }

  public void setAfter(String after) {
    this.after = after;
  }

  public Object getApprovedAtUtc() {
    return approvedAtUtc;
  }

  public void setApprovedAtUtc(Object approvedAtUtc) {
    this.approvedAtUtc = approvedAtUtc;
  }

  public Object getApprovedBy() {
    return approvedBy;
  }

  public void setApprovedBy(Object approvedBy) {
    this.approvedBy = approvedBy;
  }

  public Boolean getArchived() {
    return archived;
  }

  public void setArchived(Boolean archived) {
    this.archived = archived;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Object getAuthorFlairBackgroundColor() {
    return authorFlairBackgroundColor;
  }

  public void setAuthorFlairBackgroundColor(Object authorFlairBackgroundColor) {
    this.authorFlairBackgroundColor = authorFlairBackgroundColor;
  }

  public Object getAuthorFlairCssClass() {
    return authorFlairCssClass;
  }

  public void setAuthorFlairCssClass(Object authorFlairCssClass) {
    this.authorFlairCssClass = authorFlairCssClass;
  }

  public List<Object> getAuthorFlairRichtext() {
    return authorFlairRichtext;
  }

  public void setAuthorFlairRichtext(List<Object> authorFlairRichtext) {
    this.authorFlairRichtext = authorFlairRichtext;
  }

  public Object getAuthorFlairTemplateId() {
    return authorFlairTemplateId;
  }

  public void setAuthorFlairTemplateId(Object authorFlairTemplateId) {
    this.authorFlairTemplateId = authorFlairTemplateId;
  }

  public Object getAuthorFlairText() {
    return authorFlairText;
  }

  public void setAuthorFlairText(Object authorFlairText) {
    this.authorFlairText = authorFlairText;
  }

  public Object getAuthorFlairTextColor() {
    return authorFlairTextColor;
  }

  public void setAuthorFlairTextColor(Object authorFlairTextColor) {
    this.authorFlairTextColor = authorFlairTextColor;
  }

  public String getAuthorFlairType() {
    return authorFlairType;
  }

  public void setAuthorFlairType(String authorFlairType) {
    this.authorFlairType = authorFlairType;
  }

  public Object getBannedAtUtc() {
    return bannedAtUtc;
  }

  public void setBannedAtUtc(Object bannedAtUtc) {
    this.bannedAtUtc = bannedAtUtc;
  }

  public Object getBannedBy() {
    return bannedBy;
  }

  public void setBannedBy(Object bannedBy) {
    this.bannedBy = bannedBy;
  }

  public Object getBefore() {
    return before;
  }

  public void setBefore(Object before) {
    this.before = before;
  }

  public Boolean getCanGild() {
    return canGild;
  }

  public void setCanGild(Boolean canGild) {
    this.canGild = canGild;
  }

  public Boolean getCanModPost() {
    return canModPost;
  }

  public void setCanModPost(Boolean canModPost) {
    this.canModPost = canModPost;
  }

  public Object getCategory() {
    return category;
  }

  public void setCategory(Object category) {
    this.category = category;
  }

  public List<Child> getChildren() {
    return children;
  }

  public void setChildren(List<Child> children) {
    this.children = children;
  }

  public Boolean getClicked() {
    return clicked;
  }

  public void setClicked(Boolean clicked) {
    this.clicked = clicked;
  }

  public Object getContentCategories() {
    return contentCategories;
  }

  public void setContentCategories(Object contentCategories) {
    this.contentCategories = contentCategories;
  }

  public Boolean getContestMode() {
    return contestMode;
  }

  public void setContestMode(Boolean contestMode) {
    this.contestMode = contestMode;
  }

  public Double getCreated() {
    return created;
  }

  public void setCreated(Double created) {
    this.created = created;
  }

  public Double getCreatedUtc() {
    return createdUtc;
  }

  public void setCreatedUtc(Double createdUtc) {
    this.createdUtc = createdUtc;
  }

  public Long getDist() {
    return dist;
  }

  public void setDist(Long dist) {
    this.dist = dist;
  }

  public Object getDistinguished() {
    return distinguished;
  }

  public void setDistinguished(Object distinguished) {
    this.distinguished = distinguished;
  }

  public String getDomain() {
    return domain;
  }

  public void setDomain(String domain) {
    this.domain = domain;
  }

  public Long getDowns() {
    return downs;
  }

  public void setDowns(Long downs) {
    this.downs = downs;
  }

  public Boolean getEdited() {
    return edited;
  }

  public void setEdited(Boolean edited) {
    this.edited = edited;
  }

  public Long getGilded() {
    return gilded;
  }

  public void setGilded(Long gilded) {
    this.gilded = gilded;
  }

  public Boolean getHidden() {
    return hidden;
  }

  public void setHidden(Boolean hidden) {
    this.hidden = hidden;
  }

  public Boolean getHideScore() {
    return hideScore;
  }

  public void setHideScore(Boolean hideScore) {
    this.hideScore = hideScore;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Boolean getIsCrosspostable() {
    return isCrosspostable;
  }

  public void setIsCrosspostable(Boolean isCrosspostable) {
    this.isCrosspostable = isCrosspostable;
  }

  public Boolean getIsMeta() {
    return isMeta;
  }

  public void setIsMeta(Boolean isMeta) {
    this.isMeta = isMeta;
  }

  public Boolean getIsOriginalContent() {
    return isOriginalContent;
  }

  public void setIsOriginalContent(Boolean isOriginalContent) {
    this.isOriginalContent = isOriginalContent;
  }

  public Boolean getIsRedditMediaDomain() {
    return isRedditMediaDomain;
  }

  public void setIsRedditMediaDomain(Boolean isRedditMediaDomain) {
    this.isRedditMediaDomain = isRedditMediaDomain;
  }

  public Boolean getIsSelf() {
    return isSelf;
  }

  public void setIsSelf(Boolean isSelf) {
    this.isSelf = isSelf;
  }

  public Boolean getIsVideo() {
    return isVideo;
  }

  public void setIsVideo(Boolean isVideo) {
    this.isVideo = isVideo;
  }

  public Object getLikes() {
    return likes;
  }

  public void setLikes(Object likes) {
    this.likes = likes;
  }

  public String getLinkFlairBackgroundColor() {
    return linkFlairBackgroundColor;
  }

  public void setLinkFlairBackgroundColor(String linkFlairBackgroundColor) {
    this.linkFlairBackgroundColor = linkFlairBackgroundColor;
  }

  public Object getLinkFlairCssClass() {
    return linkFlairCssClass;
  }

  public void setLinkFlairCssClass(Object linkFlairCssClass) {
    this.linkFlairCssClass = linkFlairCssClass;
  }

  public List<Object> getLinkFlairRichtext() {
    return linkFlairRichtext;
  }

  public void setLinkFlairRichtext(List<Object> linkFlairRichtext) {
    this.linkFlairRichtext = linkFlairRichtext;
  }

  public Object getLinkFlairTemplateId() {
    return linkFlairTemplateId;
  }

  public void setLinkFlairTemplateId(Object linkFlairTemplateId) {
    this.linkFlairTemplateId = linkFlairTemplateId;
  }

  public Object getLinkFlairText() {
    return linkFlairText;
  }

  public void setLinkFlairText(Object linkFlairText) {
    this.linkFlairText = linkFlairText;
  }

  public String getLinkFlairTextColor() {
    return linkFlairTextColor;
  }

  public void setLinkFlairTextColor(String linkFlairTextColor) {
    this.linkFlairTextColor = linkFlairTextColor;
  }

  public String getLinkFlairType() {
    return linkFlairType;
  }

  public void setLinkFlairType(String linkFlairType) {
    this.linkFlairType = linkFlairType;
  }

  public Boolean getLocked() {
    return locked;
  }

  public void setLocked(Boolean locked) {
    this.locked = locked;
  }

  public Object getMedia() {
    return media;
  }

  public void setMedia(Object media) {
    this.media = media;
  }

  public MediaEmbed getMediaEmbed() {
    return mediaEmbed;
  }

  public void setMediaEmbed(MediaEmbed mediaEmbed) {
    this.mediaEmbed = mediaEmbed;
  }

  public Boolean getMediaOnly() {
    return mediaOnly;
  }

  public void setMediaOnly(Boolean mediaOnly) {
    this.mediaOnly = mediaOnly;
  }

  public Object getModNote() {
    return modNote;
  }

  public void setModNote(Object modNote) {
    this.modNote = modNote;
  }

  public Object getModReasonBy() {
    return modReasonBy;
  }

  public void setModReasonBy(Object modReasonBy) {
    this.modReasonBy = modReasonBy;
  }

  public Object getModReasonTitle() {
    return modReasonTitle;
  }

  public void setModReasonTitle(Object modReasonTitle) {
    this.modReasonTitle = modReasonTitle;
  }

  public List<Object> getModReports() {
    return modReports;
  }

  public void setModReports(List<Object> modReports) {
    this.modReports = modReports;
  }

  public String getModhash() {
    return modhash;
  }

  public void setModhash(String modhash) {
    this.modhash = modhash;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getNoFollow() {
    return noFollow;
  }

  public void setNoFollow(Boolean noFollow) {
    this.noFollow = noFollow;
  }

  public Long getNumComments() {
    return numComments;
  }

  public void setNumComments(Long numComments) {
    this.numComments = numComments;
  }

  public Long getNumCrossposts() {
    return numCrossposts;
  }

  public void setNumCrossposts(Long numCrossposts) {
    this.numCrossposts = numCrossposts;
  }

  public Object getNumReports() {
    return numReports;
  }

  public void setNumReports(Object numReports) {
    this.numReports = numReports;
  }

  public Boolean getOver18() {
    return over18;
  }

  public void setOver18(Boolean over18) {
    this.over18 = over18;
  }

  public String getParentWhitelistStatus() {
    return parentWhitelistStatus;
  }

  public void setParentWhitelistStatus(String parentWhitelistStatus) {
    this.parentWhitelistStatus = parentWhitelistStatus;
  }

  public String getPermalink() {
    return permalink;
  }

  public void setPermalink(String permalink) {
    this.permalink = permalink;
  }

  public Boolean getPinned() {
    return pinned;
  }

  public void setPinned(Boolean pinned) {
    this.pinned = pinned;
  }

  public Object getPostCategories() {
    return postCategories;
  }

  public void setPostCategories(Object postCategories) {
    this.postCategories = postCategories;
  }

  public String getPostHint() {
    return postHint;
  }

  public void setPostHint(String postHint) {
    this.postHint = postHint;
  }

  public Preview getPreview() {
    return preview;
  }

  public void setPreview(Preview preview) {
    this.preview = preview;
  }

  public Long getPwls() {
    return pwls;
  }

  public void setPwls(Long pwls) {
    this.pwls = pwls;
  }

  public Boolean getQuarantine() {
    return quarantine;
  }

  public void setQuarantine(Boolean quarantine) {
    this.quarantine = quarantine;
  }

  public Object getRemovalReason() {
    return removalReason;
  }

  public void setRemovalReason(Object removalReason) {
    this.removalReason = removalReason;
  }

  public Object getReportReasons() {
    return reportReasons;
  }

  public void setReportReasons(Object reportReasons) {
    this.reportReasons = reportReasons;
  }

  public String getRteMode() {
    return rteMode;
  }

  public void setRteMode(String rteMode) {
    this.rteMode = rteMode;
  }

  public Boolean getSaved() {
    return saved;
  }

  public void setSaved(Boolean saved) {
    this.saved = saved;
  }

  public Long getScore() {
    return score;
  }

  public void setScore(Long score) {
    this.score = score;
  }

  public Object getSecureMedia() {
    return secureMedia;
  }

  public void setSecureMedia(Object secureMedia) {
    this.secureMedia = secureMedia;
  }

  public SecureMediaEmbed getSecureMediaEmbed() {
    return secureMediaEmbed;
  }

  public void setSecureMediaEmbed(SecureMediaEmbed secureMediaEmbed) {
    this.secureMediaEmbed = secureMediaEmbed;
  }

  public String getSelftext() {
    return selftext;
  }

  public void setSelftext(String selftext) {
    this.selftext = selftext;
  }

  public Object getSelftextHtml() {
    return selftextHtml;
  }

  public void setSelftextHtml(Object selftextHtml) {
    this.selftextHtml = selftextHtml;
  }

  public Boolean getSendReplies() {
    return sendReplies;
  }

  public void setSendReplies(Boolean sendReplies) {
    this.sendReplies = sendReplies;
  }

  public Boolean getSpoiler() {
    return spoiler;
  }

  public void setSpoiler(Boolean spoiler) {
    this.spoiler = spoiler;
  }

  public Boolean getStickied() {
    return stickied;
  }

  public void setStickied(Boolean stickied) {
    this.stickied = stickied;
  }

  public String getSubreddit() {
    return subreddit;
  }

  public void setSubreddit(String subreddit) {
    this.subreddit = subreddit;
  }

  public String getSubredditId() {
    return subredditId;
  }

  public void setSubredditId(String subredditId) {
    this.subredditId = subredditId;
  }

  public String getSubredditNamePrefixed() {
    return subredditNamePrefixed;
  }

  public void setSubredditNamePrefixed(String subredditNamePrefixed) {
    this.subredditNamePrefixed = subredditNamePrefixed;
  }

  public Long getSubredditSubscribers() {
    return subredditSubscribers;
  }

  public void setSubredditSubscribers(Long subredditSubscribers) {
    this.subredditSubscribers = subredditSubscribers;
  }

  public String getSubredditType() {
    return subredditType;
  }

  public void setSubredditType(String subredditType) {
    this.subredditType = subredditType;
  }

  public Object getSuggestedSort() {
    return suggestedSort;
  }

  public void setSuggestedSort(Object suggestedSort) {
    this.suggestedSort = suggestedSort;
  }

  public String getThumbnail() {
    return thumbnail;
  }

  public void setThumbnail(String thumbnail) {
    this.thumbnail = thumbnail;
  }

  public Long getThumbnailHeight() {
    return thumbnailHeight;
  }

  public void setThumbnailHeight(Long thumbnailHeight) {
    this.thumbnailHeight = thumbnailHeight;
  }

  public Long getThumbnailWidth() {
    return thumbnailWidth;
  }

  public void setThumbnailWidth(Long thumbnailWidth) {
    this.thumbnailWidth = thumbnailWidth;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Long getUps() {
    return ups;
  }

  public void setUps(Long ups) {
    this.ups = ups;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public List<Object> getUserReports() {
    return userReports;
  }

  public void setUserReports(List<Object> userReports) {
    this.userReports = userReports;
  }

  public Object getViewCount() {
    return viewCount;
  }

  public void setViewCount(Object viewCount) {
    this.viewCount = viewCount;
  }

  public Boolean getVisited() {
    return visited;
  }

  public void setVisited(Boolean visited) {
    this.visited = visited;
  }

  public String getWhitelistStatus() {
    return whitelistStatus;
  }

  public void setWhitelistStatus(String whitelistStatus) {
    this.whitelistStatus = whitelistStatus;
  }

  public Long getWls() {
    return wls;
  }

  public void setWls(Long wls) {
    this.wls = wls;
  }
}
