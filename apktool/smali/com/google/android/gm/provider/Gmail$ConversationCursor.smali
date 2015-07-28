.class public Lcom/google/android/gm/provider/Gmail$ConversationCursor;
.super Lcom/google/android/gm/provider/Gmail$MailCursor;
.source "Gmail.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/Gmail;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ConversationCursor"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private final mConversationIdIndex:I

.field private final mDateIndex:I

.field private final mForceAllUnreadIndex:I

.field private final mFromIndex:I

.field private final mHasAttachmentsIndex:I

.field private final mHasMessagesWithErrorsIndex:I

.field private final mLabelIdsIndex:I

.field private final mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

.field private final mLabelsIndex:I

.field private final mMaxMessageIdIndex:I

.field private final mNumMessagesIndex:I

.field private final mParsedLabels:Landroid/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LruCache",
            "<",
            "Ljava/lang/Long;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mPersonalLevelIndex:I

.field private final mSnippetIndex:I

.field private final mSubjectIndex:I

.field private final mSyncedIndex:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 3719
    const-class v0, Lcom/google/android/gm/provider/Gmail;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Landroid/os/Handler;Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 2
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "gmail"    # Lcom/google/android/gm/provider/Gmail;
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 3747
    invoke-direct {p0, p1, p3, p4}, Lcom/google/android/gm/provider/Gmail$MailCursor;-><init>(Landroid/os/Handler;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 3734
    new-instance v0, Landroid/util/LruCache;

    const/16 v1, 0x32

    invoke-direct {v0, v1}, Landroid/util/LruCache;-><init>(I)V

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mParsedLabels:Landroid/util/LruCache;

    .line 3738
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->newConversationLabelIdsSplitter()Landroid/text/TextUtils$StringSplitter;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

    .line 3749
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mConversationIdIndex:I

    .line 3751
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "subject"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSubjectIndex:I

    .line 3752
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "snippet"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSnippetIndex:I

    .line 3753
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "fromAddress"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mFromIndex:I

    .line 3754
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "date"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mDateIndex:I

    .line 3755
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "personalLevel"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mPersonalLevelIndex:I

    .line 3757
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "numMessages"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mNumMessagesIndex:I

    .line 3758
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "maxMessageId"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mMaxMessageIdIndex:I

    .line 3759
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "hasAttachments"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mHasAttachmentsIndex:I

    .line 3761
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "hasMessagesWithErrors"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mHasMessagesWithErrorsIndex:I

    .line 3763
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "forceAllUnread"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mForceAllUnreadIndex:I

    .line 3765
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "synced"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSyncedIndex:I

    .line 3766
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "conversationLabels"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelsIndex:I

    .line 3768
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "labelIds"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelIdsIndex:I

    .line 3769
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Handler;Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;Lcom/google/android/gm/provider/Gmail$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Handler;
    .param p2, "x1"    # Lcom/google/android/gm/provider/Gmail;
    .param p3, "x2"    # Ljava/lang/String;
    .param p4, "x3"    # Landroid/database/Cursor;
    .param p5, "x4"    # Lcom/google/android/gm/provider/Gmail$1;

    .prologue
    .line 3719
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;-><init>(Landroid/os/Handler;Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V

    return-void
.end method

.method private constructor <init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 1
    .param p1, "gmail"    # Lcom/google/android/gm/provider/Gmail;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 3742
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;-><init>(Landroid/os/Handler;Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 3743
    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;Lcom/google/android/gm/provider/Gmail$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/provider/Gmail;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Landroid/database/Cursor;
    .param p4, "x3"    # Lcom/google/android/gm/provider/Gmail$1;

    .prologue
    .line 3719
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;-><init>(Lcom/google/android/gm/provider/Gmail;Ljava/lang/String;Landroid/database/Cursor;)V

    return-void
.end method


# virtual methods
.method public getConversationId()J
    .locals 2

    .prologue
    .line 3839
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mConversationIdIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getDateMs()J
    .locals 2

    .prologue
    .line 3910
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mDateIndex:I

    const/4 v1, -0x1

    if-le v0, v1, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mDateIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    :goto_0
    return-wide v0

    :cond_0
    const-wide/16 v0, 0x0

    goto :goto_0
.end method

.method public getForceAllUnread()Z
    .locals 2

    .prologue
    .line 3923
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mForceAllUnreadIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->isNull(I)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mForceAllUnreadIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFromSnippetInstructions()Ljava/lang/String;
    .locals 1

    .prologue
    .line 3848
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mFromIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getHasDraftMessage()Z
    .locals 2

    .prologue
    .line 3956
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getRawLabels()Ljava/lang/String;

    move-result-object v0

    .line 3957
    .local v0, "rawLabels":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v1, "^*^^r^*^"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getHasUnreadMessage()Z
    .locals 2

    .prologue
    .line 3972
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getRawLabels()Ljava/lang/String;

    move-result-object v0

    .line 3973
    .local v0, "rawLabels":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v1, "^*^^u^*^"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getLabelIds()Ljava/util/Set;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 3885
    iget v2, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelIdsIndex:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_1

    .line 3886
    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v3, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelIdsIndex:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 3887
    .local v1, "labelIds":Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

    if-nez v1, :cond_0

    const-string v1, ""

    .end local v1    # "labelIds":Ljava/lang/String;
    :cond_0
    invoke-interface {v2, v1}, Landroid/text/TextUtils$StringSplitter;->setString(Ljava/lang/String;)V

    .line 3888
    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

    invoke-static {v2}, Lcom/google/android/gm/provider/Gmail;->getLabelIdsFromLabelIdsString(Landroid/text/TextUtils$StringSplitter;)Ljava/util/Set;

    move-result-object v0

    .line 3892
    .local v0, "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :goto_0
    return-object v0

    .line 3890
    .end local v0    # "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getLabels()Ljava/util/Map;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gm/provider/Gmail;->getLabelIdsFromLabelMap(Ljava/util/Map;)Ljava/util/Set;

    move-result-object v0

    .restart local v0    # "ids":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    goto :goto_0
.end method

.method public getLabels()Ljava/util/Map;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation

    .prologue
    .line 3935
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getConversationId()J

    move-result-wide v0

    .line 3937
    .local v0, "id":J
    iget-object v4, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mParsedLabels:Landroid/util/LruCache;

    monitor-enter v4

    .line 3938
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mParsedLabels:Landroid/util/LruCache;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getConversationId()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v5}, Landroid/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map;

    .line 3939
    .local v2, "parsedLabels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    if-nez v2, :cond_0

    .line 3940
    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mAccount:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getRawLabels()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Lcom/google/android/gm/provider/LabelManager;->parseLabelQueryResult(Ljava/lang/String;Ljava/lang/String;)Ljava/util/Map;

    move-result-object v2

    .line 3941
    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mParsedLabels:Landroid/util/LruCache;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v5, v2}, Landroid/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 3943
    :cond_0
    monitor-exit v4

    .line 3944
    return-object v2

    .line 3943
    .end local v2    # "parsedLabels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method getLogic()Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    .locals 1

    .prologue
    .line 3986
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    return-object v0
.end method

.method public getMaxServerMessageId()J
    .locals 2

    .prologue
    .line 3906
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mMaxMessageIdIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getNumMessages()I
    .locals 2

    .prologue
    .line 3899
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mNumMessagesIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    return v0
.end method

.method public getPersonalLevel()Lcom/google/android/gm/provider/Gmail$PersonalLevel;
    .locals 3

    .prologue
    .line 3875
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v2, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mPersonalLevelIndex:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 3876
    .local v0, "personalLevelInt":I
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->fromInt(I)Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    move-result-object v1

    return-object v1
.end method

.method public getRawLabels()Ljava/lang/String;
    .locals 2

    .prologue
    .line 3981
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelsIndex:I

    const/4 v1, -0x1

    if-le v0, v1, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mLabelsIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getSnippet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 3866
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSnippetIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSubject()Ljava/lang/String;
    .locals 1

    .prologue
    .line 3857
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSubjectIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hasAttachments()Z
    .locals 2

    .prologue
    .line 3914
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mHasAttachmentsIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSynced()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 3931
    iget v1, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSyncedIndex:I

    const/4 v2, -0x1

    if-le v1, v2, :cond_0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v2, p0, Lcom/google/android/gm/provider/Gmail$ConversationCursor;->mSyncedIndex:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    return v0
.end method

.method protected onCursorPositionChanged()V
    .locals 0

    .prologue
    .line 3773
    invoke-super {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->onCursorPositionChanged()V

    .line 3774
    return-void
.end method
