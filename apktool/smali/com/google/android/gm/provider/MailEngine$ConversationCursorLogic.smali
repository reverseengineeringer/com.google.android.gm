.class Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
.super Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;
.source "MailEngine.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailSync$ConversationSink;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ConversationCursorLogic"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;
    }
.end annotation


# instance fields
.field private final mBackwardsCompatMode:Z

.field private mFetchThreshold:I

.field private final mGmailQuery:Lcom/google/android/gm/provider/GmailQuery;

.field mIsActiveNetworkCursor:Z

.field private final mLabel:Lcom/google/android/gm/provider/MailCore$Label;

.field private mLimit:I

.field private final mMaxResults:I

.field mMaxUnsyncedMessageId:J

.field private mNeedToPurgeConversations:Z

.field private volatile mNextHighestMessageId:J

.field private final mQuery:Ljava/lang/String;

.field private mReceivedServerResults:Z

.field private final mSearchQuery:Z

.field private final mSqlFmt:Ljava/lang/String;

.field private final mThresholdMax:I

.field private final mThresholdStep:I

.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;ZLjava/lang/Integer;Z)V
    .locals 9
    .param p2, "query"    # Ljava/lang/String;
    .param p3, "becomeActiveNetworkCursor"    # Z
    .param p4, "limit"    # Ljava/lang/Integer;
    .param p5, "backwardsCompat"    # Z

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 5738
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    .line 5714
    iput-boolean v7, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mReceivedServerResults:Z

    .line 5717
    iput-boolean v7, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNeedToPurgeConversations:Z

    .line 5718
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string v5, "gmail_live_max_results"

    const/16 v6, 0x16

    invoke-static {v4, v5, v6}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxResults:I

    .line 5720
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string v5, "gmail_live_threshold_step"

    const/16 v6, 0xa

    invoke-static {v4, v5, v6}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mThresholdStep:I

    .line 5722
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    const-string v5, "gmail_live_threshold_max"

    const/16 v6, 0x64

    invoke-static {v4, v5, v6}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mThresholdMax:I

    .line 5724
    iput v7, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetchThreshold:I

    .line 5739
    iput-boolean p5, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mBackwardsCompatMode:Z

    .line 5740
    iput-boolean p3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mIsActiveNetworkCursor:Z

    .line 5741
    if-eqz p3, :cond_0

    .line 5744
    iput-boolean v8, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNeedToPurgeConversations:Z

    .line 5750
    iget-object v4, p1, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const-string v5, "^i"

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 5751
    # setter for: Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;
    invoke-static {p1, p2}, Lcom/google/android/gm/provider/MailEngine;->access$3702(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)Ljava/lang/String;

    .line 5752
    # setter for: Lcom/google/android/gm/provider/MailEngine;->mLastConversationCursorLogic:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    invoke-static {p1, p0}, Lcom/google/android/gm/provider/MailEngine;->access$4002(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 5755
    :cond_0
    iput-object p2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mQuery:Ljava/lang/String;

    .line 5756
    iget-object v4, p1, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mQuery:Ljava/lang/String;

    invoke-direct {p0, v5}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->labelNameFromQuery(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v4

    iput-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    .line 5758
    iget-object v4, p1, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    invoke-virtual {v4, v5}, Lcom/google/android/gm/provider/MailSync;->getMaxUnsyncedMessageIdForLabel(Lcom/google/android/gm/provider/MailCore$Label;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    .line 5759
    iget-wide v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    iput-wide v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNextHighestMessageId:J

    .line 5796
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    if-eqz v4, :cond_1

    .line 5797
    const-string v3, "conversation_labels.conversation_id IN\n(SELECT DISTINCT conversation_labels.conversation_id\n   FROM conversation_labels\n WHERE conversation_labels.labels_id = ?\n ORDER BY conversation_labels.sortMessageId DESC\n LIMIT ?)\n   AND conversation_labels.labels_id = ? \n   AND (((conversations.maxMessageId >= ?           OR conversations.maxMessageId = 0)\n        AND conversation_labels.queryId = 0)\n     OR (conversations.maxMessageId < ?\n        AND conversation_labels.queryId = ?))"

    .line 5809
    .local v3, "wherePart":Ljava/lang/String;
    const-string v1, "GROUP BY conversations._id\nORDER BY conversation_labels.sortMessageId DESC\n"

    .line 5812
    .local v1, "groupOrderBy":Ljava/lang/String;
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mGmailQuery:Lcom/google/android/gm/provider/GmailQuery;

    .line 5813
    iput-boolean v7, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mSearchQuery:Z

    .line 5837
    :goto_0
    invoke-direct {p0, p4}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setLimit(Ljava/lang/Integer;)V

    .line 5838
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setSelectionArgs()V

    .line 5840
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "SELECT conversation_labels.*, conversations.*, conversations.queryId = 0 AS synced, (SELECT group_concat((labels._id || \'^*^\' || labels.canonicalName || \'^*^\' || \n(CASE labels.canonicalName    WHEN \'^f\' THEN ?    WHEN \'^^out\' THEN ?    WHEN \'^i\' THEN ?    WHEN \'^r\' THEN ?    WHEN \'^b\' THEN ?    WHEN \'^all\' THEN ?    WHEN \'^u\' THEN ?    WHEN \'^k\' THEN ?    WHEN \'^s\' THEN ?    WHEN \'^t\' THEN ?    WHEN \'^g\' THEN ?    WHEN \'^io_im\' THEN ?    WHEN \'^iim\' THEN ?    ELSE labels.name END)  || \'^*^\' || labels.color || \'^*^\' || labels.hidden),    \'^**^\') FROM labels JOIN conversation_labels  ON conversation_labels.labels_id = labels._id  AND conversation_labels.conversation_id = conversations._id AND conversation_labels.isZombie = 0) AS conversationLabels   FROM conversation_labels\n  LEFT OUTER JOIN conversations\n  ON conversation_labels.conversation_id = conversations._id\n  AND conversation_labels.queryId = conversations.queryId\nWHERE\n  ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ")\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "  AND isZombie = 0\n"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "LIMIT ?"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mSqlFmt:Ljava/lang/String;

    .line 5853
    return-void

    .line 5820
    .end local v1    # "groupOrderBy":Ljava/lang/String;
    .end local v3    # "wherePart":Ljava/lang/String;
    :cond_1
    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine;->isFullTextSearchEnabled()Z

    move-result v0

    .line 5821
    .local v0, "ftsEnabled":Z
    iput-boolean v8, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mSearchQuery:Z

    .line 5823
    new-instance v4, Lcom/google/android/gm/provider/GmailQuery;

    iget-object v5, p1, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {p1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v6

    iget-object v6, v6, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v7, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mQuery:Ljava/lang/String;

    invoke-direct {v4, v5, v6, v7, v0}, Lcom/google/android/gm/provider/GmailQuery;-><init>(Lcom/google/android/gm/provider/MailCoreLabelAccess;Ljava/lang/String;Ljava/lang/String;Z)V

    iput-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mGmailQuery:Lcom/google/android/gm/provider/GmailQuery;

    .line 5824
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mGmailQuery:Lcom/google/android/gm/provider/GmailQuery;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/GmailQuery;->getQueryLikeClause()Ljava/lang/String;

    move-result-object v2

    .line 5828
    .local v2, "queryLikeClause":Ljava/lang/String;
    iget-boolean v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mBackwardsCompatMode:Z

    if-nez v4, :cond_2

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 5829
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "conversation_labels.queryId = ? OR  (conversation_labels.queryId = 0 AND ("

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "))"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 5834
    .restart local v3    # "wherePart":Ljava/lang/String;
    :goto_1
    const-string v1, "GROUP BY conversations._id\nORDER BY conversation_labels.sortMessageId DESC\n"

    .restart local v1    # "groupOrderBy":Ljava/lang/String;
    goto :goto_0

    .line 5832
    .end local v1    # "groupOrderBy":Ljava/lang/String;
    .end local v3    # "wherePart":Ljava/lang/String;
    :cond_2
    const-string v3, "conversation_labels.queryId = ?"

    .restart local v3    # "wherePart":Ljava/lang/String;
    goto :goto_1
.end method

.method static synthetic access$1500(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;Ljava/lang/Integer;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    .param p1, "x1"    # Ljava/lang/Integer;

    .prologue
    .line 5685
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setLimit(Ljava/lang/Integer;)V

    return-void
.end method

.method static synthetic access$1600(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .prologue
    .line 5685
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setSelectionArgs()V

    return-void
.end method

.method static synthetic access$3800(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)Z
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .prologue
    .line 5685
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mBackwardsCompatMode:Z

    return v0
.end method

.method static synthetic access$3900(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .prologue
    .line 5685
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->clearMatchingNotifications()V

    return-void
.end method

.method private clearMatchingNotifications()V
    .locals 2

    .prologue
    .line 6266
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    if-eqz v0, :cond_0

    .line 6267
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->clearNewUnreadMailForNotificationLabelIfNeeded(Lcom/google/android/gm/provider/MailCore$Label;)V

    .line 6269
    :cond_0
    return-void
.end method

.method private getConversationQueryArgs(Landroid/content/Context;Lcom/google/android/gm/provider/MailCore$Label;JJI)[Ljava/lang/String;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p3, "maxUnsyncedMessageId"    # J
    .param p5, "queryId"    # J
    .param p7, "limit"    # I

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 5903
    if-eqz p2, :cond_0

    .line 5904
    const/4 v1, 0x7

    new-array v1, v1, [Ljava/lang/String;

    iget-wide v2, p2, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v5

    const/4 v2, 0x2

    iget-wide v3, p2, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v3, v4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x3

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x4

    invoke-static {p3, p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x5

    invoke-static {p5, p6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    invoke-static {p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {p1, v1}, Lcom/google/android/gm/provider/QueryUtils;->argListWithLabelNames(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 5919
    :goto_0
    return-object v1

    .line 5913
    :cond_0
    new-array v1, v5, [Ljava/lang/String;

    invoke-static {p5, p6}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {v1}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    .line 5914
    .local v0, "argsList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mBackwardsCompatMode:Z

    if-nez v1, :cond_1

    .line 5916
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mGmailQuery:Lcom/google/android/gm/provider/GmailQuery;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/GmailQuery;->getQueryBindArgs()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 5918
    :cond_1
    invoke-static {p7}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 5919
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    new-array v1, v1, [Ljava/lang/String;

    invoke-interface {v0, v1}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v1

    check-cast v1, [Ljava/lang/String;

    invoke-static {p1, v1}, Lcom/google/android/gm/provider/QueryUtils;->argListWithLabelNames(Landroid/content/Context;[Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method private getLimit()I
    .locals 1

    .prologue
    .line 5865
    iget v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLimit:I

    return v0
.end method

.method private labelNameFromQuery(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 5930
    const-string v0, "label:"

    .line 5931
    .local v0, "prefix":Ljava/lang/String;
    const-string v1, "label:"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 5932
    const-string v1, "label:"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    .line 5934
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private maybeFetchMoreResults(ILcom/google/android/gm/provider/MailEngine$NetworkCursor;)V
    .locals 6
    .param p1, "position"    # I
    .param p2, "cursor"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursor;

    .prologue
    .line 5993
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->isActiveNetworkCursor()Z

    move-result v1

    if-nez v1, :cond_1

    .line 6026
    :cond_0
    :goto_0
    return-void

    .line 6007
    :cond_1
    invoke-virtual {p2}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->getCount()I

    move-result v0

    .line 6008
    .local v0, "count":I
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getIsInErrorState()Z

    move-result v1

    if-nez v1, :cond_0

    add-int/lit8 v1, p1, 0x1

    iget v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetchThreshold:I

    sub-int v2, v0, v2

    if-ge v1, v2, :cond_2

    iget-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mSearchQuery:Z

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mReceivedServerResults:Z

    if-nez v1, :cond_0

    :cond_2
    const/16 v1, 0x9c4

    if-ge v0, v1, :cond_0

    iget-wide v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNextHighestMessageId:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 6014
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetcherThread:Ljava/lang/Thread;

    if-nez v1, :cond_0

    .line 6016
    iget v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mThresholdMax:I

    if-lez v1, :cond_3

    .line 6018
    const-string v1, "Gmail"

    const-string v2, "Prefetching live mail: maxResults: %d pos: %d count: %d threshold: %d"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget v5, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxResults:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    iget v5, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetchThreshold:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6021
    :cond_3
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->startThread()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 6022
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->notifyDataSetChanges()V

    goto :goto_0
.end method

.method private maybeSheduleSync()V
    .locals 5

    .prologue
    .line 6033
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->isActiveNetworkCursor()Z

    move-result v1

    if-nez v1, :cond_1

    .line 6052
    :cond_0
    :goto_0
    return-void

    .line 6040
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v1

    const-string v2, "gmail-ls"

    invoke-static {v1, v2}, Landroid/content/ContentResolver;->isSyncPending(Landroid/accounts/Account;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 6043
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "gmail-sync-thread-interval"

    const v3, 0x1b7740

    invoke-static {v1, v2, v3}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 6046
    .local v0, "syncThreadIntervalTime":I
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLastSyncThreadTime:J
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$4100(Lcom/google/android/gm/provider/MailEngine;)J

    move-result-wide v3

    sub-long/2addr v1, v3

    int-to-long v3, v0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 6048
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mLastSyncThreadTime:J
    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/MailEngine;->access$4102(Lcom/google/android/gm/provider/MailEngine;J)J

    .line 6049
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->startSyncThread()V

    goto :goto_0
.end method

.method private notifyDataSetChanges()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 6212
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->notifyDatasetChanged(Z)V
    invoke-static {v2, v1}, Lcom/google/android/gm/provider/MailEngine;->access$3500(Lcom/google/android/gm/provider/MailEngine;Z)V

    .line 6215
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v3

    iget-object v3, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 6220
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    iget-object v0, v2, Lcom/google/android/gm/provider/MailCore$Label;->canonicalName:Ljava/lang/String;

    .line 6221
    .local v0, "canonicalName":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    if-nez v2, :cond_0

    const/4 v1, 0x1

    .line 6223
    .local v1, "isSearch":Z
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v3

    iget-object v3, v3, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v2, v3, v1, v0}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountFolderChangeNotification(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;)V

    .line 6226
    return-void

    .line 6220
    .end local v0    # "canonicalName":Ljava/lang/String;
    .end local v1    # "isSearch":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private setLimit(Ljava/lang/Integer;)V
    .locals 1
    .param p1, "limit"    # Ljava/lang/Integer;

    .prologue
    .line 5861
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    :goto_0
    iput v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLimit:I

    .line 5862
    return-void

    .line 5861
    :cond_0
    const/16 v0, 0x9c4

    goto :goto_0
.end method

.method private setSelectionArgs()V
    .locals 8

    .prologue
    .line 5856
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    iget-wide v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    iget-wide v5, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->mQueryId:J

    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getLimit()I

    move-result v7

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getConversationQueryArgs(Landroid/content/Context;Lcom/google/android/gm/provider/MailCore$Label;JJI)[Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setSelectionArguments([Ljava/lang/String;)V

    .line 5858
    return-void
.end method


# virtual methods
.method public configure(Lcom/google/android/gm/provider/MailEngine$NetworkCursor;)V
    .locals 1
    .param p1, "cursor"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursor;

    .prologue
    .line 5869
    invoke-virtual {p1}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->getPosition()I

    move-result v0

    invoke-direct {p0, v0, p1}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->maybeFetchMoreResults(ILcom/google/android/gm/provider/MailEngine$NetworkCursor;)V

    .line 5870
    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->maybeSheduleSync()V

    .line 5871
    return-void
.end method

.method public finalizeSink()V
    .locals 1

    .prologue
    .line 6097
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V

    .line 6098
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 6099
    return-void
.end method

.method public getExtras()Landroid/os/Bundle;
    .locals 5

    .prologue
    .line 5961
    invoke-super {p0}, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 5967
    .local v0, "extras":Landroid/os/Bundle;
    iget-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mSearchQuery:Z

    if-eqz v3, :cond_2

    iget-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mReceivedServerResults:Z

    if-nez v3, :cond_2

    .line 5968
    const-string v3, "status"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 5969
    .local v2, "stringStatus":Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$CursorStatus;

    move-result-object v1

    .line 5974
    .local v1, "status":Lcom/google/android/gm/provider/Gmail$CursorStatus;
    iget-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mBackwardsCompatMode:Z

    if-nez v3, :cond_0

    sget-object v3, Lcom/google/android/gm/provider/Gmail$CursorStatus;->LOADING:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    if-eq v1, v3, :cond_1

    :cond_0
    sget-object v3, Lcom/google/android/gm/provider/Gmail$CursorStatus;->LOADED:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    if-ne v1, v3, :cond_2

    .line 5977
    :cond_1
    const-string v3, "status"

    sget-object v4, Lcom/google/android/gm/provider/Gmail$CursorStatus;->SEARCHING:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 5982
    .end local v1    # "status":Lcom/google/android/gm/provider/Gmail$CursorStatus;
    .end local v2    # "stringStatus":Ljava/lang/String;
    :cond_2
    const-string v3, "active_network_query"

    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->isActiveNetworkCursor()Z

    move-result v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 5985
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    if-eqz v3, :cond_3

    .line 5986
    const-string v3, "label_canonical_name"

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailCore$Label;->canonicalName:Ljava/lang/String;

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 5989
    :cond_3
    return-object v0
.end method

.method public getQuery()Ljava/lang/String;
    .locals 1

    .prologue
    .line 5939
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mQuery:Ljava/lang/String;

    return-object v0
.end method

.method public getSql()Ljava/lang/String;
    .locals 1

    .prologue
    .line 5943
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mSqlFmt:Ljava/lang/String;

    return-object v0
.end method

.method public getWantsAllOnMoveCalls()Z
    .locals 1

    .prologue
    .line 6277
    const/4 v0, 0x1

    return v0
.end method

.method public handleConversation(Lcom/google/android/gm/provider/MailSync$Conversation;)V
    .locals 6
    .param p1, "conversation"    # Lcom/google/android/gm/provider/MailSync$Conversation;

    .prologue
    .line 6070
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-wide v3, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->mQueryId:J

    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    invoke-virtual {v2, p1, v3, v4, v5}, Lcom/google/android/gm/provider/MailEngine;->handleConversation(Lcom/google/android/gm/provider/MailSync$Conversation;JLcom/google/android/gm/provider/MailCore$Label;)J

    move-result-wide v0

    .line 6076
    .local v0, "sortMessageId":J
    const-wide/16 v2, 0x1

    sub-long v2, v0, v2

    iput-wide v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNextHighestMessageId:J

    .line 6077
    return-void
.end method

.method public isActiveNetworkCursor()Z
    .locals 2

    .prologue
    .line 5950
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getQuery()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$3700(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mIsActiveNetworkCursor:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isCursorComplete()Z
    .locals 4

    .prologue
    .line 5956
    iget-wide v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNextHighestMessageId:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onMove(IILcom/google/android/gm/provider/MailEngine$NetworkCursor;)V
    .locals 0
    .param p1, "oldPosition"    # I
    .param p2, "newPosition"    # I
    .param p3, "cursor"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursor;

    .prologue
    .line 6272
    invoke-direct {p0, p2, p3}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->maybeFetchMoreResults(ILcom/google/android/gm/provider/MailEngine$NetworkCursor;)V

    .line 6273
    return-void
.end method

.method public prepareSink()V
    .locals 2

    .prologue
    .line 6084
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 6089
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->suppressUiNotifications()V

    .line 6090
    return-void
.end method

.method purgeConversationsIfNeeded()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 5877
    iget-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNeedToPurgeConversations:Z

    if-eqz v0, :cond_1

    .line 5878
    iput-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNeedToPurgeConversations:Z

    .line 5880
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    if-eqz v0, :cond_0

    .line 5881
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    invoke-virtual {v0, v3}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;->cancel(Z)Z

    .line 5883
    :cond_0
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    iget-wide v1, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->mQueryId:J

    invoke-direct {v0, p0, v1, v2}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;-><init>(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;J)V

    sput-object v0, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    .line 5893
    sget-object v0, Lcom/google/android/gm/provider/MailEngine;->sConversationPurgeTask:Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;

    sget-object v1, Landroid/os/AsyncTask;->SERIAL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic$PurgeStaleConversationsTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 5895
    :cond_1
    return-void
.end method

.method public requery(Lcom/google/android/gm/provider/MailEngine$NetworkCursor;Z)V
    .locals 11
    .param p1, "cursor"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursor;
    .param p2, "contentsVisible"    # Z

    .prologue
    .line 6229
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailSync;->getMaxUnsyncedMessageIdForLabel(Lcom/google/android/gm/provider/MailCore$Label;)J

    move-result-wide v8

    .line 6230
    .local v8, "maxUnsyncedMessageId":J
    iget-wide v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    cmp-long v0, v0, v8

    if-eqz v0, :cond_1

    .line 6252
    iget-wide v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    cmp-long v0, v0, v8

    if-gez v0, :cond_0

    .line 6253
    iget-wide v8, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    .line 6255
    :cond_0
    iput-wide v8, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    .line 6256
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mLabel:Lcom/google/android/gm/provider/MailCore$Label;

    iget-wide v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxUnsyncedMessageId:J

    iget-wide v5, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->mQueryId:J

    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getLimit()I

    move-result v7

    move-object v0, p0

    invoke-direct/range {v0 .. v7}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getConversationQueryArgs(Landroid/content/Context;Lcom/google/android/gm/provider/MailCore$Label;JJI)[Ljava/lang/String;

    move-result-object v10

    .line 6258
    .local v10, "queryArgs":[Ljava/lang/String;
    invoke-virtual {p0, v10}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->setSelectionArguments([Ljava/lang/String;)V

    .line 6260
    .end local v10    # "queryArgs":[Ljava/lang/String;
    :cond_1
    if-eqz p2, :cond_2

    invoke-direct {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->clearMatchingNotifications()V

    .line 6261
    :cond_2
    return-void
.end method

.method public run()V
    .locals 17

    .prologue
    .line 6145
    :try_start_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->cancelSyncForLiveRequest()V
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$4300(Lcom/google/android/gm/provider/MailEngine;)V

    .line 6146
    const-wide/16 v12, 0x0

    .line 6147
    .local v12, "startTime":J
    const/4 v10, 0x0

    .line 6148
    .local v10, "foregroundSync":Z
    const/4 v11, 0x0

    .line 6149
    .local v11, "liveRequestInProgress":Z
    const-string v1, "Gmail"

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 6150
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v12

    .line 6151
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$3100(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;

    move-result-object v1

    if-eqz v1, :cond_3

    const/4 v10, 0x1

    .line 6152
    :goto_0
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetcherThread:Ljava/lang/Thread;

    if-eqz v1, :cond_4

    const/4 v11, 0x1

    .line 6154
    :cond_0
    :goto_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mSyncLock:Ljava/lang/Object;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$3200(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;

    move-result-object v16

    monitor-enter v16
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_0 .. :try_end_0} :catch_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_3
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 6155
    :try_start_1
    const-string v1, "Gmail"

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 6156
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    sub-long v14, v1, v12

    .line 6157
    .local v14, "syncLockWaitTime":J
    const-wide/16 v1, 0x1f4

    cmp-long v1, v14, v1

    if-lez v1, :cond_1

    .line 6158
    const-string v1, "Gmail"

    const-string v2, "Blocked while waiting for mSyncLock in ConversationCursorLogic.run() %d ms\n  foreground Sync: %b live request: %b"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-static {v11}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6164
    .end local v14    # "syncLockWaitTime":J
    :cond_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x0

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mIsSyncCancelled:Z
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$4402(Lcom/google/android/gm/provider/MailEngine;Z)Z

    .line 6165
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x0

    const/4 v3, 0x1

    new-instance v4, Lcom/google/android/gm/provider/MailEngine$SyncInfo;

    invoke-direct {v4}, Lcom/google/android/gm/provider/MailEngine$SyncInfo;-><init>()V

    const/4 v5, 0x0

    const/4 v6, 0x0

    # invokes: Lcom/google/android/gm/provider/MailEngine;->runSyncLoop(Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z
    invoke-static/range {v1 .. v6}, Lcom/google/android/gm/provider/MailEngine;->access$3300(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$MailEngineSyncObserver;ZLcom/google/android/gm/provider/MailEngine$SyncInfo;Landroid/content/SyncResult;Landroid/os/Bundle;)Z

    .line 6166
    monitor-exit v16
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 6167
    :try_start_2
    const-string v1, "Gmail"

    const/4 v2, 0x3

    invoke-static {v1, v2}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 6168
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v1

    sub-long v7, v1, v12

    .line 6169
    .local v7, "beforeRunInternalTime":J
    const-wide/16 v1, 0x1f4

    cmp-long v1, v7, v1

    if-lez v1, :cond_2

    .line 6170
    const-string v1, "Gmail"

    const-string v2, "Blocked  for %d ms before calling runInternal() in ConversationCursorLogic.run()  (Blocked by previous call to runSyncLoop()"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6176
    .end local v7    # "beforeRunInternalTime":J
    :cond_2
    invoke-virtual/range {p0 .. p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->runInternal()V

    .line 6177
    const/4 v1, 0x0

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mErrorOccurred:Z

    .line 6178
    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->NO_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mError:Lcom/google/android/gm/provider/Gmail$CursorError;

    .line 6179
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x0

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$300(Lcom/google/android/gm/provider/MailEngine;I)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 6203
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    .line 6205
    .end local v10    # "foregroundSync":Z
    .end local v11    # "liveRequestInProgress":Z
    .end local v12    # "startTime":J
    :goto_2
    invoke-direct/range {p0 .. p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->notifyDataSetChanges()V

    .line 6206
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->mFetcherThreadLock:Ljava/lang/Object;

    monitor-enter v2

    .line 6207
    const/4 v1, 0x0

    :try_start_3
    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetcherThread:Ljava/lang/Thread;

    .line 6208
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 6209
    return-void

    .line 6151
    .restart local v10    # "foregroundSync":Z
    .restart local v11    # "liveRequestInProgress":Z
    .restart local v12    # "startTime":J
    :cond_3
    const/4 v10, 0x0

    goto/16 :goto_0

    .line 6152
    :cond_4
    const/4 v11, 0x0

    goto/16 :goto_1

    .line 6166
    :catchall_0
    move-exception v1

    :try_start_4
    monitor-exit v16
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v1
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_0
    .catch Lcom/google/android/gm/provider/MailEngine$AuthenticationException; {:try_start_5 .. :try_end_5} :catch_1
    .catch Lcom/google/android/gm/provider/MailSync$ResponseParseException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_5 .. :try_end_5} :catch_3
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 6180
    .end local v10    # "foregroundSync":Z
    .end local v11    # "liveRequestInProgress":Z
    .end local v12    # "startTime":J
    :catch_0
    move-exception v9

    .line 6181
    .local v9, "e":Ljava/io/IOException;
    :try_start_6
    const-string v1, "Gmail"

    const-string v2, "MailCursor encountered an IOException: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v9}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6182
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mErrorOccurred:Z

    .line 6183
    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->IO_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mError:Lcom/google/android/gm/provider/Gmail$CursorError;

    .line 6184
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x1

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$300(Lcom/google/android/gm/provider/MailEngine;I)V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 6203
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    goto :goto_2

    .line 6185
    .end local v9    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v9

    .line 6186
    .local v9, "e":Lcom/google/android/gm/provider/MailEngine$AuthenticationException;
    :try_start_7
    const-string v1, "Gmail"

    const-string v2, "MailCursor encountered an AuthenticationException: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v9}, Lcom/google/android/gm/provider/MailEngine$AuthenticationException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6188
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mErrorOccurred:Z

    .line 6189
    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->AUTH_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mError:Lcom/google/android/gm/provider/Gmail$CursorError;

    .line 6190
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x2

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$300(Lcom/google/android/gm/provider/MailEngine;I)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 6203
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    goto :goto_2

    .line 6191
    .end local v9    # "e":Lcom/google/android/gm/provider/MailEngine$AuthenticationException;
    :catch_2
    move-exception v9

    .line 6192
    .local v9, "e":Lcom/google/android/gm/provider/MailSync$ResponseParseException;
    :try_start_8
    const-string v1, "Gmail"

    const-string v2, "MailCursor encountered a ResponseParseException: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v9}, Lcom/google/android/gm/provider/MailSync$ResponseParseException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6194
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mErrorOccurred:Z

    .line 6195
    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->PARSE_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mError:Lcom/google/android/gm/provider/Gmail$CursorError;

    .line 6196
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x5

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$300(Lcom/google/android/gm/provider/MailEngine;I)V
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1

    .line 6203
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    goto/16 :goto_2

    .line 6197
    .end local v9    # "e":Lcom/google/android/gm/provider/MailSync$ResponseParseException;
    :catch_3
    move-exception v9

    .line 6198
    .local v9, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_9
    const-string v1, "Gmail"

    const-string v2, "MailCursor encountered a SQLiteException: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v9}, Landroid/database/sqlite/SQLiteException;->getMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 6199
    const/4 v1, 0x1

    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mErrorOccurred:Z

    .line 6200
    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->DB_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mError:Lcom/google/android/gm/provider/Gmail$CursorError;

    .line 6201
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x5

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$300(Lcom/google/android/gm/provider/MailEngine;I)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_1

    .line 6203
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v2, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    goto/16 :goto_2

    .end local v9    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_1
    move-exception v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v3, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v2, v3}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    throw v1

    .line 6208
    :catchall_2
    move-exception v1

    :try_start_a
    monitor-exit v2
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_2

    throw v1
.end method

.method protected runInternal()V
    .locals 15
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Lcom/google/android/gm/provider/MailEngine$AuthenticationException;,
            Lcom/google/android/gm/provider/MailSync$ResponseParseException;
        }
    .end annotation

    .prologue
    const/high16 v14, 0x200000

    const/4 v13, 0x0

    const/4 v12, 0x2

    const/4 v11, 0x1

    .line 6106
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 6107
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v0

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/common/GoogleTrafficStats;->getDomainType(Ljava/lang/String;)I

    move-result v6

    .line 6108
    .local v6, "accountType":I
    const/high16 v9, 0x200000

    .line 6111
    .local v9, "requestType":I
    or-int v0, v6, v9

    invoke-static {v0}, Landroid/net/TrafficStats;->setThreadStatsTag(I)V

    .line 6116
    .end local v6    # "accountType":I
    .end local v9    # "requestType":I
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v1, 0x2

    const/4 v2, 0x1

    # invokes: Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V
    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$400(Lcom/google/android/gm/provider/MailEngine;IZ)V

    .line 6118
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mQuery:Ljava/lang/String;

    iget-wide v2, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNextHighestMessageId:J

    iget v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mMaxResults:I

    const/4 v5, 0x5

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailSync;->newQueryRequest(Ljava/lang/String;JII)Lorg/apache/http/client/methods/HttpUriRequest;

    move-result-object v8

    .line 6120
    .local v8, "request":Lorg/apache/http/client/methods/HttpUriRequest;
    iget v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetchThreshold:I

    iget v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mThresholdStep:I

    add-int/2addr v0, v1

    iget v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mThresholdMax:I

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetchThreshold:I

    .line 6121
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->runHttpRequest(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    invoke-static {v0, v8}, Lcom/google/android/gm/provider/MailEngine;->access$4200(Lcom/google/android/gm/provider/MailEngine;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_2

    move-result-object v10

    .line 6123
    .local v10, "response":Lorg/apache/http/HttpResponse;
    :try_start_1
    monitor-enter p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 6124
    :try_start_2
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0, v10, p0}, Lcom/google/android/gm/provider/MailSync;->handleQueryResponse(Lorg/apache/http/HttpResponse;Lcom/google/android/gm/provider/MailSync$ConversationSink;)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mNextHighestMessageId:J

    .line 6125
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mReceivedServerResults:Z

    .line 6126
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 6128
    :try_start_3
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v7

    .line 6129
    .local v7, "entity":Lorg/apache/http/HttpEntity;
    if-eqz v7, :cond_1

    invoke-interface {v7}, Lorg/apache/http/HttpEntity;->consumeContent()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_2

    .line 6132
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V
    invoke-static {v0, v12, v13}, Lcom/google/android/gm/provider/MailEngine;->access$400(Lcom/google/android/gm/provider/MailEngine;IZ)V

    .line 6133
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 6134
    invoke-static {v14, v11}, Landroid/net/TrafficStats;->incrementOperationCount(II)V

    .line 6135
    invoke-static {}, Landroid/net/TrafficStats;->clearThreadStatsTag()V

    .line 6138
    :cond_2
    return-void

    .line 6126
    .end local v7    # "entity":Lorg/apache/http/HttpEntity;
    :catchall_0
    move-exception v0

    :try_start_4
    monitor-exit p0
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 6128
    :catchall_1
    move-exception v0

    :try_start_6
    invoke-interface {v10}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v7

    .line 6129
    .restart local v7    # "entity":Lorg/apache/http/HttpEntity;
    if-eqz v7, :cond_3

    invoke-interface {v7}, Lorg/apache/http/HttpEntity;->consumeContent()V

    .line 6130
    :cond_3
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 6132
    .end local v7    # "entity":Lorg/apache/http/HttpEntity;
    .end local v8    # "request":Lorg/apache/http/client/methods/HttpUriRequest;
    .end local v10    # "response":Lorg/apache/http/HttpResponse;
    :catchall_2
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V
    invoke-static {v1, v12, v13}, Lcom/google/android/gm/provider/MailEngine;->access$400(Lcom/google/android/gm/provider/MailEngine;IZ)V

    .line 6133
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 6134
    invoke-static {v14, v11}, Landroid/net/TrafficStats;->incrementOperationCount(II)V

    .line 6135
    invoke-static {}, Landroid/net/TrafficStats;->clearThreadStatsTag()V

    :cond_4
    throw v0
.end method

.method protected final startSyncThread()V
    .locals 5

    .prologue
    .line 6058
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$3100(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;

    move-result-object v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mFetcherThread:Ljava/lang/Thread;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mMailEngineClosing:Z
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$3600(Lcom/google/android/gm/provider/MailEngine;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 6059
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mSyncThreadLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$3400(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 6060
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$3100(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;

    move-result-object v0

    if-nez v0, :cond_0

    .line 6061
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/google/android/gm/provider/MailEngine$SyncThread;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct {v3, v4}, Lcom/google/android/gm/provider/MailEngine$SyncThread;-><init>(Lcom/google/android/gm/provider/MailEngine;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;
    invoke-static {v0, v2}, Lcom/google/android/gm/provider/MailEngine;->access$3102(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/Thread;)Ljava/lang/Thread;

    .line 6062
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mSyncThread:Ljava/lang/Thread;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$3100(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 6064
    :cond_0
    monitor-exit v1

    .line 6066
    :cond_1
    return-void

    .line 6064
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
