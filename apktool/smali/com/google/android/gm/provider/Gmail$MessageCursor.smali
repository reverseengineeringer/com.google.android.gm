.class public Lcom/google/android/gm/provider/Gmail$MessageCursor;
.super Lcom/google/android/gm/provider/Gmail$MailCursor;
.source "Gmail.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/Gmail;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageCursor"
.end annotation


# static fields
.field static final synthetic $assertionsDisabled:Z


# instance fields
.field private mBccIndex:I

.field private mBodyEmbedsExternalResourcesIndex:I

.field private mBodyIndex:I

.field private mCcIndex:I

.field private final mContentResolver:Landroid/content/ContentResolver;

.field private mConversationIdIndex:I

.field private mCursorCloned:Z

.field private mCustomFromIndex:I

.field private mDateReceivedMsIndex:I

.field private mDateSentMsIndex:I

.field private mErrorIndex:I

.field private mForwardIndex:I

.field private mFromIndex:I

.field private mIdIndex:I

.field mInReplyToLocalMessageId:J

.field private mIncludeQuotedTextIndex:I

.field private mIsDraftIndex:I

.field private mIsInOutboxIndex:I

.field private mIsStarredIndex:I

.field private mIsUnreadIndex:I

.field private mJoinedAttachmentInfosIndex:I

.field private mLabelCountIndex:I

.field private mLabelIdsIndex:I

.field private final mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

.field private mLabelsIndex:I

.field private mListInfoIndex:I

.field private mPersonalLevelIndex:I

.field mPreserveAttachments:Z

.field private mQuoteStartPosIndex:I

.field private mRefMessageIdIndex:I

.field private mReplyToIndex:I

.field private mServerMessageIdIndex:I

.field private mSnippetIndex:I

.field private mSubjectIndex:I

.field private mToIndex:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 2920
    const-class v0, Lcom/google/android/gm/provider/Gmail;

    invoke-virtual {v0}, Ljava/lang/Class;->desiredAssertionStatus()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->$assertionsDisabled:Z

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 1
    .param p1, "resolver"    # Landroid/content/ContentResolver;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 2972
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    invoke-direct {p0, v0, p1, p2, p3}, Lcom/google/android/gm/provider/Gmail$MessageCursor;-><init>(Landroid/os/Handler;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 2973
    return-void
.end method

.method synthetic constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;Lcom/google/android/gm/provider/Gmail$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/ContentResolver;
    .param p2, "x1"    # Ljava/lang/String;
    .param p3, "x2"    # Landroid/database/Cursor;
    .param p4, "x3"    # Lcom/google/android/gm/provider/Gmail$1;

    .prologue
    .line 2920
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/provider/Gmail$MessageCursor;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V

    return-void
.end method

.method public constructor <init>(Landroid/os/Handler;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V
    .locals 3
    .param p1, "handler"    # Landroid/os/Handler;
    .param p2, "resolver"    # Landroid/content/ContentResolver;
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v2, 0x0

    .line 2977
    invoke-direct {p0, p1, p3, p4}, Lcom/google/android/gm/provider/Gmail$MailCursor;-><init>(Landroid/os/Handler;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 2931
    iput-boolean v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCursorCloned:Z

    .line 2968
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->newMessageLabelIdsSplitter()Landroid/text/TextUtils$StringSplitter;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

    .line 2979
    if-nez p4, :cond_0

    .line 2980
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "null cursor passed to MessageCursor()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 2984
    :cond_0
    iput-object p2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mContentResolver:Landroid/content/ContentResolver;

    .line 2986
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "_id"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIdIndex:I

    .line 2987
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "messageId"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mServerMessageIdIndex:I

    .line 2988
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "conversation"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mConversationIdIndex:I

    .line 2990
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "subject"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSubjectIndex:I

    .line 2991
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "snippet"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSnippetIndex:I

    .line 2992
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "fromAddress"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mFromIndex:I

    .line 2993
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "customFromAddress"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCustomFromIndex:I

    .line 2994
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "toAddresses"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mToIndex:I

    .line 2995
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "ccAddresses"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCcIndex:I

    .line 2996
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "bccAddresses"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBccIndex:I

    .line 2997
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "replyToAddresses"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mReplyToIndex:I

    .line 2998
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "dateSentMs"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateSentMsIndex:I

    .line 3000
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "dateReceivedMs"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateReceivedMsIndex:I

    .line 3002
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "listInfo"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mListInfoIndex:I

    .line 3003
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "personalLevel"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mPersonalLevelIndex:I

    .line 3005
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "body"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyIndex:I

    .line 3006
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "bodyEmbedsExternalResources"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyEmbedsExternalResourcesIndex:I

    .line 3008
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "labelIds"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsIndex:I

    .line 3009
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "joinedAttachmentInfos"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mJoinedAttachmentInfosIndex:I

    .line 3011
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "error"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mErrorIndex:I

    .line 3012
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "refMessageId"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mRefMessageIdIndex:I

    .line 3013
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "forward"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mForwardIndex:I

    .line 3014
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "includeQuotedText"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIncludeQuotedTextIndex:I

    .line 3016
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "quoteStartPos"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mQuoteStartPosIndex:I

    .line 3020
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "labelCount"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelCountIndex:I

    .line 3022
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "messageLabels"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelsIndex:I

    .line 3024
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "isStarred"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsStarredIndex:I

    .line 3026
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "isDraft"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsDraftIndex:I

    .line 3028
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "isInOutbox"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsInOutboxIndex:I

    .line 3030
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const-string v1, "isUnread"

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsUnreadIndex:I

    .line 3033
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mInReplyToLocalMessageId:J

    .line 3034
    iput-boolean v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mPreserveAttachments:Z

    .line 3035
    return-void
.end method

.method private getAddresses(Ljava/lang/String;I)[Ljava/lang/String;
    .locals 3
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "index"    # I

    .prologue
    .line 3212
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getUpdateValues()Landroid/content/ContentValues;

    move-result-object v1

    .line 3214
    .local v1, "updated":Landroid/content/ContentValues;
    invoke-virtual {v1, p1}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3215
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getUpdateValues()Landroid/content/ContentValues;

    move-result-object v2

    invoke-virtual {v2, p1}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 3220
    .local v0, "addresses":Ljava/lang/String;
    :goto_0
    sget-object v2, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v2}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 3217
    .end local v0    # "addresses":Ljava/lang/String;
    :cond_0
    invoke-virtual {p0, p2}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "addresses":Ljava/lang/String;
    goto :goto_0
.end method


# virtual methods
.method public addOrRemoveLabel(Ljava/lang/String;Z)V
    .locals 8
    .param p1, "label"    # Ljava/lang/String;
    .param p2, "add"    # Z

    .prologue
    .line 3389
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mContentResolver:Landroid/content/ContentResolver;

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mAccount:Ljava/lang/String;

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getConversationId()J

    move-result-wide v2

    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getLocalId()J

    move-result-wide v4

    move-object v6, p1

    move v7, p2

    invoke-static/range {v0 .. v7}, Lcom/google/android/gm/provider/Gmail;->addOrRemoveLabelOnMessage(Landroid/content/ContentResolver;Ljava/lang/String;JJLjava/lang/String;Z)V

    .line 3391
    return-void
.end method

.method public clone()Ljava/lang/Object;
    .locals 8

    .prologue
    .line 3045
    iget-object v4, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    if-nez v4, :cond_0

    .line 3046
    new-instance v1, Lcom/google/android/gm/provider/Gmail$MessageCursor;

    new-instance v4, Landroid/os/Handler;

    invoke-direct {v4}, Landroid/os/Handler;-><init>()V

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mContentResolver:Landroid/content/ContentResolver;

    iget-object v6, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mAccount:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct {v1, v4, v5, v6, v7}, Lcom/google/android/gm/provider/Gmail$MessageCursor;-><init>(Landroid/os/Handler;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 3095
    :goto_0
    return-object v1

    .line 3050
    :cond_0
    new-instance v0, Landroid/database/MatrixCursor;

    iget-object v4, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v5}, Landroid/database/Cursor;->getCount()I

    move-result v5

    invoke-direct {v0, v4, v5}, Landroid/database/MatrixCursor;-><init>([Ljava/lang/String;I)V

    .line 3051
    .local v0, "cloned":Landroid/database/MatrixCursor;
    iget-object v4, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    const/4 v5, -0x1

    invoke-interface {v4, v5}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 3052
    iget-object v4, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->getColumnCount()I

    move-result v2

    .line 3053
    .local v2, "numColumns":I
    :goto_1
    iget-object v4, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 3054
    new-array v3, v2, [Ljava/lang/Object;

    .line 3055
    .local v3, "row":[Ljava/lang/Object;
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIdIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIdIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3056
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mServerMessageIdIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mServerMessageIdIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3057
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mConversationIdIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mConversationIdIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3058
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSubjectIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSubjectIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3059
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSnippetIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSnippetIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3060
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mFromIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mFromIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3061
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCustomFromIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCustomFromIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3062
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mToIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mToIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3063
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCcIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCcIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3064
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBccIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBccIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3065
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mReplyToIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mReplyToIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3066
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateSentMsIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateSentMsIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3067
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateReceivedMsIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateSentMsIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3068
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mListInfoIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mListInfoIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3069
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mPersonalLevelIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mPersonalLevelIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3070
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3071
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyEmbedsExternalResourcesIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyEmbedsExternalResourcesIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3073
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3074
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mJoinedAttachmentInfosIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mJoinedAttachmentInfosIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3076
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mErrorIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mErrorIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3077
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mRefMessageIdIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mRefMessageIdIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3078
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mForwardIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mForwardIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3079
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelCountIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelCountIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3080
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelsIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelsIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3081
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsStarredIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsStarredIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3082
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsDraftIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsDraftIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3083
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsInOutboxIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsInOutboxIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3084
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsUnreadIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsUnreadIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3085
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIncludeQuotedTextIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIncludeQuotedTextIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3086
    iget v4, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mQuoteStartPosIndex:I

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v6, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mQuoteStartPosIndex:I

    invoke-interface {v5, v6}, Landroid/database/Cursor;->getInt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    .line 3090
    invoke-virtual {v0, v3}, Landroid/database/MatrixCursor;->addRow([Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 3092
    .end local v3    # "row":[Ljava/lang/Object;
    :cond_1
    new-instance v1, Lcom/google/android/gm/provider/Gmail$MessageCursor;

    new-instance v4, Landroid/os/Handler;

    invoke-direct {v4}, Landroid/os/Handler;-><init>()V

    iget-object v5, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mContentResolver:Landroid/content/ContentResolver;

    iget-object v6, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mAccount:Ljava/lang/String;

    invoke-direct {v1, v4, v5, v6, v0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;-><init>(Landroid/os/Handler;Landroid/content/ContentResolver;Ljava/lang/String;Landroid/database/Cursor;)V

    .line 3094
    .local v1, "messageCursor":Lcom/google/android/gm/provider/Gmail$MessageCursor;
    const/4 v4, 0x1

    iput-boolean v4, v1, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCursorCloned:Z

    goto/16 :goto_0
.end method

.method public getAttachmentInfos()Ljava/util/ArrayList;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gm/provider/Gmail$Attachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 3394
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 3396
    .local v0, "attachments":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gm/provider/Gmail$Attachment;>;"
    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v3, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mJoinedAttachmentInfosIndex:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 3397
    .local v1, "joinedAttachmentInfos":Ljava/lang/String;
    invoke-static {v1}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 3399
    return-object v0
.end method

.method public getBccAddresses()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 3244
    const-string v0, "bccAddresses"

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBccIndex:I

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getAddresses(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getBody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 3292
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mBodyIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCcAddresses()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 3236
    const-string v0, "ccAddresses"

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCcIndex:I

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getAddresses(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getConversationId()J
    .locals 2

    .prologue
    .line 3162
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->checkCursor()V

    .line 3163
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mConversationIdIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getDateSentMs()J
    .locals 2

    .prologue
    .line 3258
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->checkCursor()V

    .line 3259
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mDateSentMsIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getErrorText()Ljava/lang/String;
    .locals 2

    .prologue
    .line 3420
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mErrorIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getFromAddress()Ljava/lang/String;
    .locals 3

    .prologue
    .line 3196
    iget v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mCustomFromIndex:I

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    .line 3197
    .local v0, "customFrom":Ljava/lang/String;
    iget v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mFromIndex:I

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v1

    .line 3202
    .local v1, "from":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3205
    .end local v0    # "customFrom":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "customFrom":Ljava/lang/String;
    :cond_0
    iget v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mFromIndex:I

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getIsUnread()Z
    .locals 4

    .prologue
    .line 3363
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIsUnreadIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getLabelIds()Ljava/util/Set;
    .locals 3
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
    .line 3309
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsIndex:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 3310
    .local v0, "labelNames":Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

    if-nez v0, :cond_0

    const-string v0, ""

    .end local v0    # "labelNames":Ljava/lang/String;
    :cond_0
    invoke-interface {v1, v0}, Landroid/text/TextUtils$StringSplitter;->setString(Ljava/lang/String;)V

    .line 3311
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mLabelIdsSplitter:Landroid/text/TextUtils$StringSplitter;

    invoke-static {v1}, Lcom/google/android/gm/provider/Gmail;->getLabelIdsFromLabelIdsString(Landroid/text/TextUtils$StringSplitter;)Ljava/util/Set;

    move-result-object v1

    return-object v1
.end method

.method public getListInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 3269
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mListInfoIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLocalId()J
    .locals 2

    .prologue
    .line 3142
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->checkCursor()V

    .line 3143
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mIdIndex:I

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method public getPersonalLevel()Lcom/google/android/gm/provider/Gmail$PersonalLevel;
    .locals 3

    .prologue
    .line 3273
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->checkCursor()V

    .line 3274
    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$MailCursor;->mCursor:Landroid/database/Cursor;

    iget v2, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mPersonalLevelIndex:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    .line 3275
    .local v0, "personalLevelInt":I
    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->fromInt(I)Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    move-result-object v1

    return-object v1
.end method

.method public getReplyToAddress()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 3253
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mReplyToIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getSubject()Ljava/lang/String;
    .locals 1

    .prologue
    .line 3172
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mSubjectIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getToAddresses()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 3228
    const-string v0, "toAddresses"

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$MessageCursor;->mToIndex:I

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/Gmail$MessageCursor;->getAddresses(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected onCursorPositionChanged()V
    .locals 0

    .prologue
    .line 3108
    invoke-super {p0}, Lcom/google/android/gm/provider/Gmail$MailCursor;->onCursorPositionChanged()V

    .line 3109
    return-void
.end method
