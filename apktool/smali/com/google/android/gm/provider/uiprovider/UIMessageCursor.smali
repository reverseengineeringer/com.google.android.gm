.class public Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;
.super Lcom/google/android/gm/provider/uiprovider/UICursorWapper;
.source "UIMessageCursor.java"


# static fields
.field private static final GMAIL_STATUS_UI_STATUS_MAP:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mAttachments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/Gmail$Attachment;",
            ">;"
        }
    .end annotation
.end field

.field private final mBccIndex:I

.field private final mBodyEmbedsExternalResourcesIndex:I

.field private final mBodyIndex:I

.field private final mCcIndex:I

.field private final mContext:Landroid/content/Context;

.field private mConversationId:J

.field private final mConversationIdIndex:I

.field private final mCustomFromIndex:I

.field private final mDateReceivedMsIndex:I

.field private final mExtras:Landroid/os/Bundle;

.field private final mForwardIndex:I

.field private mFromAddress:Ljava/lang/String;

.field private final mFromIndex:I

.field private final mGmailQuote:Ljava/lang/String;

.field private final mIdIndex:I

.field private final mIsDraftIndex:I

.field private final mIsInOutboxIndex:I

.field private final mIsStarredIndex:I

.field private final mIsUnreadIndex:I

.field private final mJoinedAttachmentInfosIndex:I

.field private mLocalMessageId:J

.field private mMessageBody:Ljava/lang/String;

.field private final mPersistence:Lcom/google/android/gm/persistence/Persistence;

.field private final mQuoteStartPosIndex:I

.field private final mRefMessageIdIndex:I

.field private final mReplyToIndex:I

.field private mRowDataIsCached:Z

.field private mServerMessageId:J

.field private final mServerMessageIdIndex:I

.field private final mSnippetIndex:I

.field private mSpamReason:I

.field private final mSubjectIndex:I

.field private final mToIndex:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 30
    new-instance v0, Lcom/google/common/collect/ImmutableMap$Builder;

    invoke-direct {v0}, Lcom/google/common/collect/ImmutableMap$Builder;-><init>()V

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->LOADED:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->LOADING:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->SEARCHING:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->ERROR:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v2, 0x4

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->COMPLETE:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0x8

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap$Builder;->build()Lcom/google/common/collect/ImmutableMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->GMAIL_STATUS_UI_STATUS_MAP:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/database/Cursor;Ljava/lang/String;Lcom/google/android/gm/persistence/Persistence;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "account"    # Ljava/lang/String;
    .param p4, "persistence"    # Lcom/google/android/gm/persistence/Persistence;
    .param p5, "gmailQuoteStr"    # Ljava/lang/String;
    .param p6, "resultProjection"    # [Ljava/lang/String;

    .prologue
    .line 81
    invoke-direct {p0, p2, p6}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;-><init>(Landroid/database/Cursor;[Ljava/lang/String;)V

    .line 69
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    .line 76
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mRowDataIsCached:Z

    .line 83
    iput-object p3, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    .line 84
    iput-object p4, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    .line 85
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mContext:Landroid/content/Context;

    .line 86
    iput-object p5, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mGmailQuote:Ljava/lang/String;

    .line 88
    const-string v0, "_id"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIdIndex:I

    .line 89
    const-string v0, "messageId"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mServerMessageIdIndex:I

    .line 90
    const-string v0, "conversation"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mConversationIdIndex:I

    .line 91
    const-string v0, "subject"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSubjectIndex:I

    .line 92
    const-string v0, "snippet"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSnippetIndex:I

    .line 93
    const-string v0, "fromAddress"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mFromIndex:I

    .line 94
    const-string v0, "customFromAddress"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mCustomFromIndex:I

    .line 95
    const-string v0, "toAddresses"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mToIndex:I

    .line 96
    const-string v0, "ccAddresses"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mCcIndex:I

    .line 97
    const-string v0, "bccAddresses"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mBccIndex:I

    .line 98
    const-string v0, "replyToAddresses"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mReplyToIndex:I

    .line 99
    const-string v0, "dateReceivedMs"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mDateReceivedMsIndex:I

    .line 100
    const-string v0, "body"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mBodyIndex:I

    .line 101
    const-string v0, "bodyEmbedsExternalResources"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mBodyEmbedsExternalResourcesIndex:I

    .line 103
    const-string v0, "refMessageId"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mRefMessageIdIndex:I

    .line 104
    const-string v0, "isDraft"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsDraftIndex:I

    .line 105
    const-string v0, "forward"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mForwardIndex:I

    .line 106
    const-string v0, "joinedAttachmentInfos"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mJoinedAttachmentInfosIndex:I

    .line 108
    const-string v0, "isUnread"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsUnreadIndex:I

    .line 110
    const-string v0, "isStarred"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsStarredIndex:I

    .line 112
    const-string v0, "isInOutbox"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsInOutboxIndex:I

    .line 114
    const-string v0, "quoteStartPos"

    invoke-interface {p2, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mQuoteStartPosIndex:I

    .line 119
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getExtrasInternal()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mExtras:Landroid/os/Bundle;

    .line 120
    return-void
.end method

.method private cacheRowValues()V
    .locals 2

    .prologue
    .line 131
    iget-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mRowDataIsCached:Z

    if-nez v0, :cond_0

    .line 132
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->loadAttachmentInfos()V

    .line 133
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mServerMessageIdIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mServerMessageId:J

    .line 134
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIdIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mLocalMessageId:J

    .line 135
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mConversationIdIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mConversationId:J

    .line 136
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getFromAddress()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mFromAddress:Ljava/lang/String;

    .line 137
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getSpamReason()I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSpamReason:I

    .line 139
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mRowDataIsCached:Z

    .line 141
    :cond_0
    return-void
.end method

.method private getAddresses(Ljava/lang/String;I)[Ljava/lang/String;
    .locals 2
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "index"    # I

    .prologue
    .line 475
    invoke-virtual {p0, p2}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    .line 477
    .local v0, "addresses":Ljava/lang/String;
    sget-object v1, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getDraftType()I
    .locals 5

    .prologue
    .line 335
    const/4 v0, 0x0

    .line 337
    .local v0, "draftType":I
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getIsDraft()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 338
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getForward()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 339
    const/4 v0, 0x4

    .line 351
    :cond_0
    :goto_0
    return v0

    .line 340
    :cond_1
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getRefMessageId()J

    move-result-wide v1

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_3

    .line 341
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getToAddresses()[Ljava/lang/String;

    move-result-object v1

    array-length v1, v1

    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getCcAddresses()[Ljava/lang/String;

    move-result-object v2

    array-length v2, v2

    add-int/2addr v1, v2

    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getBccAddresses()[Ljava/lang/String;

    move-result-object v2

    array-length v2, v2

    add-int/2addr v1, v2

    const/4 v2, 0x1

    if-le v1, v2, :cond_2

    .line 343
    const/4 v0, 0x3

    goto :goto_0

    .line 345
    :cond_2
    const/4 v0, 0x2

    goto :goto_0

    .line 348
    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;
    .locals 1
    .param p0, "rawAddress"    # Ljava/lang/String;

    .prologue
    .line 433
    invoke-static {p0}, Lcom/google/android/gm/EmailAddress;->getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;

    move-result-object v0

    return-object v0
.end method

.method private getExtrasInternal()Landroid/os/Bundle;
    .locals 7

    .prologue
    .line 154
    invoke-super {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 156
    .local v0, "extras":Landroid/os/Bundle;
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 158
    .local v3, "uiMessageCursorExtras":Landroid/os/Bundle;
    const/4 v2, 0x2

    .line 159
    .local v2, "uiCursorStatus":I
    const-string v4, "status"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 160
    const-string v4, "status"

    invoke-virtual {v0, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 161
    .local v1, "stringStatus":Ljava/lang/String;
    sget-object v4, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->GMAIL_STATUS_UI_STATUS_MAP:Ljava/util/Map;

    invoke-interface {v4, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 162
    sget-object v4, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->GMAIL_STATUS_UI_STATUS_MAP:Ljava/util/Map;

    invoke-interface {v4, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 166
    .end local v1    # "stringStatus":Ljava/lang/String;
    :cond_0
    const/4 v4, 0x2

    if-ne v2, v4, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getCount()I

    move-result v4

    if-nez v4, :cond_1

    .line 170
    const-string v4, "Gmail"

    const-string v5, "Unexpected loaded state for empty cursor"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 173
    const/4 v2, 0x1

    .line 177
    :cond_1
    const-string v4, "cursor_status"

    invoke-virtual {v3, v4, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 179
    return-object v3
.end method

.method private getForward()Z
    .locals 4

    .prologue
    .line 363
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mForwardIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

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

.method private static getGmailAttachmentsAsJson(Ljava/util/Collection;Ljava/lang/String;JJJ)Ljava/lang/String;
    .locals 15
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "conversationId"    # J
    .param p4, "serverMessageId"    # J
    .param p6, "localMessageId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/google/android/gm/provider/Gmail$Attachment;",
            ">;",
            "Ljava/lang/String;",
            "JJJ)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 503
    .local p0, "gmailAttachments":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/Gmail$Attachment;>;"
    const/4 v13, 0x0

    .line 504
    .local v13, "jsonStr":Ljava/lang/String;
    if-eqz p0, :cond_1

    invoke-interface {p0}, Ljava/util/Collection;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 506
    :try_start_0
    new-instance v14, Lorg/json/JSONArray;

    invoke-direct {v14}, Lorg/json/JSONArray;-><init>()V

    .line 507
    .local v14, "out":Lorg/json/JSONArray;
    invoke-interface {p0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 508
    .local v10, "a":Lcom/google/android/gm/provider/Gmail$Attachment;
    iget-object v7, v10, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    iget-object v8, v10, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    invoke-virtual {v10}, Lcom/google/android/gm/provider/Gmail$Attachment;->toJoinedString()Ljava/lang/String;

    move-result-object v9

    move-object/from16 v0, p1

    move-wide/from16 v1, p2

    move-wide/from16 v3, p4

    move-wide/from16 v5, p6

    invoke-static/range {v0 .. v9}, Lcom/google/android/gm/provider/UiProvider;->getMessageAttachmentUri(Ljava/lang/String;JJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 511
    .local v2, "uri":Landroid/net/Uri;
    iget-object v0, v10, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    iget v1, v10, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    const/4 v3, 0x0

    iget-object v4, v10, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lcom/android/mail/providers/Attachment;->toJSON(Ljava/lang/String;ILandroid/net/Uri;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Integer;)Lorg/json/JSONObject;

    move-result-object v0

    invoke-virtual {v14, v0}, Lorg/json/JSONArray;->put(Ljava/lang/Object;)Lorg/json/JSONArray;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 514
    .end local v2    # "uri":Landroid/net/Uri;
    .end local v10    # "a":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v14    # "out":Lorg/json/JSONArray;
    :catch_0
    move-exception v11

    .line 515
    .local v11, "e":Lorg/json/JSONException;
    new-instance v0, Ljava/lang/IllegalArgumentException;

    invoke-direct {v0, v11}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/Throwable;)V

    throw v0

    .line 513
    .end local v11    # "e":Lorg/json/JSONException;
    .restart local v12    # "i$":Ljava/util/Iterator;
    .restart local v14    # "out":Lorg/json/JSONArray;
    :cond_0
    :try_start_1
    invoke-virtual {v14}, Lorg/json/JSONArray;->toString()Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v13

    .line 519
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v14    # "out":Lorg/json/JSONArray;
    :cond_1
    return-object v13
.end method

.method private getIsDraft()Z
    .locals 4

    .prologue
    .line 355
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsDraftIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

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

.method private getIsStarred()Z
    .locals 4

    .prologue
    .line 370
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsStarredIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

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

.method private getIsUnread()Z
    .locals 4

    .prologue
    .line 359
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsUnreadIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

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

.method private getMessageBody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mMessageBody:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 148
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mBodyIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mMessageBody:Ljava/lang/String;

    .line 150
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mMessageBody:Ljava/lang/String;

    return-object v0
.end method

.method private getQuotedTextOffset()I
    .locals 4

    .prologue
    .line 485
    const/4 v2, -0x1

    .line 486
    .local v2, "quotedTextOffset":I
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getQuoteStartPos()I

    move-result v1

    .line 487
    .local v1, "pos":I
    if-gtz v1, :cond_1

    .line 488
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getMessageBody()Ljava/lang/String;

    move-result-object v0

    .line 489
    .local v0, "body":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 490
    const/4 v2, -0x1

    .line 497
    .end local v0    # "body":Ljava/lang/String;
    :goto_0
    return v2

    .line 492
    .restart local v0    # "body":Ljava/lang/String;
    :cond_0
    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mGmailQuote:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    goto :goto_0

    .line 495
    .end local v0    # "body":Ljava/lang/String;
    :cond_1
    move v2, v1

    goto :goto_0
.end method

.method private getRefMessageId()J
    .locals 2

    .prologue
    .line 382
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mRefMessageIdIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method private getSpamReason()I
    .locals 1

    .prologue
    .line 390
    const/4 v0, -0x1

    return v0
.end method

.method private getViaDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 396
    const/4 v0, 0x0

    return-object v0
.end method

.method private loadAttachmentInfos()V
    .locals 3

    .prologue
    .line 329
    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mJoinedAttachmentInfosIndex:I

    invoke-super {p0, v1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 330
    .local v0, "joinedAttachmentInfos":Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$MessageModification;->parseJoinedAttachmentString(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 332
    return-void
.end method


# virtual methods
.method public getBccAddresses()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 457
    const-string v0, "bccAddresses"

    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mBccIndex:I

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getAddresses(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCcAddresses()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 449
    const-string v0, "ccAddresses"

    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mCcIndex:I

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getAddresses(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getExtras()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mExtras:Landroid/os/Bundle;

    return-object v0
.end method

.method public getFromAddress()Ljava/lang/String;
    .locals 3

    .prologue
    .line 409
    iget v2, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mFromIndex:I

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v1

    .line 416
    .local v1, "from":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 422
    .end local v1    # "from":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 421
    .restart local v1    # "from":Ljava/lang/String;
    :cond_0
    iget v2, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mCustomFromIndex:I

    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    .line 422
    .local v0, "customFrom":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .end local v0    # "customFrom":Ljava/lang/String;
    :goto_1
    move-object v1, v0

    goto :goto_0

    .restart local v0    # "customFrom":Ljava/lang/String;
    :cond_1
    move-object v0, v1

    goto :goto_1
.end method

.method public getInt(I)I
    .locals 9
    .param p1, "columnIndex"    # I

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 205
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->cacheRowValues()V

    .line 206
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    if-lez v6, :cond_1

    move v0, v4

    .line 208
    .local v0, "hasAttachments":Z
    :goto_0
    packed-switch p1, :pswitch_data_0

    .line 253
    :pswitch_0
    const-string v6, "Gmail"

    const-string v7, "UIMessageCursor.getInt(%d): Unexpected column"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v4, v5

    invoke-static {v6, v7, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 254
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v4

    :cond_0
    :goto_1
    return v4

    .end local v0    # "hasAttachments":Z
    :cond_1
    move v0, v5

    .line 206
    goto :goto_0

    .line 210
    .restart local v0    # "hasAttachments":Z
    :pswitch_1
    iget v4, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mBodyEmbedsExternalResourcesIndex:I

    invoke-super {p0, v4}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v4

    goto :goto_1

    .line 212
    :pswitch_2
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getDraftType()I

    move-result v4

    goto :goto_1

    .line 214
    :pswitch_3
    if-nez v0, :cond_0

    move v4, v5

    goto :goto_1

    .line 217
    :pswitch_4
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getIsUnread()Z

    move-result v6

    if-eqz v6, :cond_2

    :goto_2
    move v4, v5

    goto :goto_1

    :cond_2
    move v5, v4

    goto :goto_2

    .line 219
    :pswitch_5
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getIsStarred()Z

    move-result v6

    if-nez v6, :cond_0

    move v4, v5

    goto :goto_1

    .line 221
    :pswitch_6
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getIsInOutbox()Z

    move-result v6

    if-nez v6, :cond_0

    move v4, v5

    goto :goto_1

    .line 225
    :pswitch_7
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mFromAddress:Ljava/lang/String;

    invoke-static {v6}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getEmailAddress(Ljava/lang/String;)Lcom/google/android/gm/EmailAddress;

    move-result-object v6

    invoke-virtual {v6}, Lcom/google/android/gm/EmailAddress;->getAddress()Ljava/lang/String;

    move-result-object v1

    .line 226
    .local v1, "sender":Ljava/lang/String;
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mPersistence:Lcom/google/android/gm/persistence/Persistence;

    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mContext:Landroid/content/Context;

    invoke-virtual {v6, v7, v1}, Lcom/google/android/gm/persistence/Persistence;->getDisplayImagesFromSender(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v2

    .line 228
    .local v2, "showImages":Z
    if-nez v2, :cond_0

    move v4, v5

    goto :goto_1

    .line 230
    .end local v1    # "sender":Ljava/lang/String;
    .end local v2    # "showImages":Z
    :pswitch_8
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getQuotedTextOffset()I

    move-result v6

    if-gez v6, :cond_0

    move v4, v5

    goto :goto_1

    .line 232
    :pswitch_9
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getQuotedTextOffset()I

    move-result v4

    goto :goto_1

    .line 235
    :pswitch_a
    iget v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSpamReason:I

    const/4 v7, -0x1

    if-ne v6, v7, :cond_3

    move v4, v5

    .line 236
    goto :goto_1

    .line 237
    :cond_3
    sget-object v5, Lcom/google/android/gm/provider/SpamReasonType;->HIGH_WARNING_LEVEL_SPAM_TYPES:Ljava/util/Set;

    iget v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSpamReason:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v5, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 239
    const/4 v4, 0x2

    goto :goto_1

    .line 246
    :pswitch_b
    sget-object v4, Lcom/google/android/gm/provider/SpamReasonType;->WARNING_LINK_TYPE_MAP:Ljava/util/Map;

    iget v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSpamReason:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Integer;

    .line 247
    .local v3, "warningType":Ljava/lang/Integer;
    if-nez v3, :cond_4

    move v4, v5

    .line 248
    goto :goto_1

    .line 250
    :cond_4
    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v4

    goto :goto_1

    .line 208
    :pswitch_data_0
    .packed-switch 0xe
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_8
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_4
        :pswitch_5
        :pswitch_9
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_a
        :pswitch_b
        :pswitch_0
        :pswitch_6
    .end packed-switch
.end method

.method public getIsInOutbox()Z
    .locals 4

    .prologue
    .line 377
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIsInOutboxIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

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

.method public getLong(I)J
    .locals 5
    .param p1, "columnIndex"    # I

    .prologue
    .line 189
    sparse-switch p1, :sswitch_data_0

    .line 197
    const-string v0, "Gmail"

    const-string v1, "UIMessageCursor.getLong(%d): Unexpected column"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 199
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    :goto_0
    return-wide v0

    .line 191
    :sswitch_0
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mIdIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    goto :goto_0

    .line 193
    :sswitch_1
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mDateReceivedMsIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    goto :goto_0

    .line 195
    :sswitch_2
    const-wide/16 v0, 0x0

    goto :goto_0

    .line 189
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xb -> :sswitch_1
        0x14 -> :sswitch_2
    .end sparse-switch
.end method

.method public getQuoteStartPos()I
    .locals 1

    .prologue
    .line 481
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mQuoteStartPosIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v0

    return v0
.end method

.method public getReplyToAddress()Ljava/lang/String;
    .locals 3

    .prologue
    .line 466
    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mReplyToIndex:I

    invoke-virtual {p0, v1}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->EMAIL_SEPARATOR_PATTERN:Ljava/util/regex/Pattern;

    invoke-static {v1, v2}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/util/regex/Pattern;)[Ljava/lang/String;

    move-result-object v0

    .line 468
    .local v0, "addrs":[Ljava/lang/String;
    if-eqz v0, :cond_0

    array-length v1, v0

    if-nez v1, :cond_1

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return-object v1

    :cond_1
    const/4 v1, 0x0

    aget-object v1, v0, v1

    goto :goto_0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 10
    .param p1, "columnIndex"    # I

    .prologue
    const/4 v8, 0x1

    const/4 v1, 0x0

    const/4 v0, 0x0

    .line 260
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->cacheRowValues()V

    .line 262
    packed-switch p1, :pswitch_data_0

    .line 322
    :pswitch_0
    const-string v0, "Gmail"

    const-string v2, "UIMessageCursor.getString(%d): Unexpected column"

    new-array v3, v8, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v1

    invoke-static {v0, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 324
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    :cond_0
    :goto_0
    :pswitch_1
    return-object v0

    .line 264
    :pswitch_2
    iget-wide v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mServerMessageId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 266
    :pswitch_3
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    iget-wide v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mLocalMessageId:J

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getMessageByIdUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 268
    :pswitch_4
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    iget-wide v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mConversationId:J

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getConversationUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 270
    :pswitch_5
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSubjectIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 272
    :pswitch_6
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSnippetIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 274
    :pswitch_7
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mFromAddress:Ljava/lang/String;

    goto :goto_0

    .line 276
    :pswitch_8
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mCustomFromIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 278
    :pswitch_9
    const-string v0, ", "

    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getToAddresses()[Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 280
    :pswitch_a
    const-string v0, ", "

    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getCcAddresses()[Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 282
    :pswitch_b
    const-string v0, ", "

    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getBccAddresses()[Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 284
    :pswitch_c
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getReplyToAddress()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 286
    :pswitch_d
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getMessageBody()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 291
    :pswitch_e
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getRefMessageId()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 293
    :pswitch_f
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 294
    .local v8, "hasAttachments":Z
    :goto_1
    if-eqz v8, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    iget-wide v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mConversationId:J

    iget-wide v3, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mServerMessageId:J

    iget-wide v5, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mLocalMessageId:J

    invoke-static/range {v0 .. v6}, Lcom/google/android/gm/provider/UiProvider;->getMessageAttachmentsUri(Ljava/lang/String;JJJ)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .end local v8    # "hasAttachments":Z
    :cond_1
    move v8, v1

    .line 293
    goto :goto_1

    .line 299
    :pswitch_10
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    invoke-static {v0}, Lcom/google/android/gm/provider/Gmail$MessageModification;->joinedAttachmentsString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 301
    :pswitch_11
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/UiProvider;->getSaveMessageUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 303
    :pswitch_12
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/UiProvider;->getSendMessageUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 305
    :pswitch_13
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAccount:Ljava/lang/String;

    iget-wide v2, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mConversationId:J

    iget-wide v4, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mServerMessageId:J

    iget-wide v6, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mLocalMessageId:J

    invoke-static/range {v0 .. v7}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getGmailAttachmentsAsJson(Ljava/util/Collection;Ljava/lang/String;JJJ)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 312
    :pswitch_14
    sget-object v1, Lcom/google/android/gm/provider/SpamReasonType;->SPAM_REASON_TO_STRING_MAP:Ljava/util/Map;

    iget v2, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mSpamReason:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Ljava/lang/Integer;

    .line 314
    .local v9, "resourceId":Ljava/lang/Integer;
    if-eqz v9, :cond_0

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-eqz v1, :cond_0

    .line 317
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 320
    .end local v9    # "resourceId":Ljava/lang/Integer;
    :pswitch_15
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getViaDomain()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 262
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_0
        :pswitch_d
        :pswitch_1
        :pswitch_0
        :pswitch_e
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_f
        :pswitch_0
        :pswitch_10
        :pswitch_11
        :pswitch_12
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_13
        :pswitch_8
        :pswitch_1
        :pswitch_1
        :pswitch_14
        :pswitch_0
        :pswitch_0
        :pswitch_15
    .end packed-switch
.end method

.method public getToAddresses()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 441
    const-string v0, "toAddresses"

    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mToIndex:I

    invoke-direct {p0, v0, v1}, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->getAddresses(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected resetCursorRowState()V
    .locals 1

    .prologue
    .line 124
    invoke-super {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 125
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mAttachments:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 126
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mMessageBody:Ljava/lang/String;

    .line 127
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIMessageCursor;->mRowDataIsCached:Z

    .line 128
    return-void
.end method
