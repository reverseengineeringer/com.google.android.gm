.class public Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
.super Lcom/google/android/gm/provider/uiprovider/UICursorWapper;
.source "UIConversationCursor.java"


# static fields
.field private static final CONVERSATION_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gm/provider/ObjectCache",
            "<",
            "Lcom/android/mail/providers/ConversationInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static final GMAIL_ERROR_UI_ERROR_MAP:Ljava/util/Map;
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

.field private static final MESSAGE_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gm/provider/ObjectCache",
            "<",
            "Lcom/android/mail/providers/MessageInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static final SENDER_INSTRUCTIONS_CACHE:Lcom/google/android/gm/provider/ObjectCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gm/provider/ObjectCache",
            "<",
            "Lcom/google/android/gm/provider/SenderInstructions;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mCachedLabels:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation
.end field

.field private final mConversationIdIndex:I

.field private mCurrentConversationUri:Ljava/lang/String;

.field private final mCurrentLabels:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;"
        }
    .end annotation
.end field

.field private final mDateIndex:I

.field private final mFromIndex:I

.field private final mHasAttachmentsIndex:I

.field private final mLabelColorMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final mLabelsIndex:I

.field private final mNumMessagesIndex:I

.field private final mPersonalLevelIndex:I

.field private mRowDataCached:Z

.field private final mSerializedFolderMap:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mSnippet:Ljava/lang/String;

.field private final mSnippetIndex:I

.field private final mSubjectIndex:I

.field private final mSyncedIndex:I


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x1

    const/4 v3, 0x2

    .line 61
    new-instance v0, Lcom/google/common/collect/ImmutableMap$Builder;

    invoke-direct {v0}, Lcom/google/common/collect/ImmutableMap$Builder;-><init>()V

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->LOADED:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->LOADING:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorStatus;->SEARCHING:Lcom/google/android/gm/provider/Gmail$CursorStatus;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorStatus;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

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

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->GMAIL_STATUS_UI_STATUS_MAP:Ljava/util/Map;

    .line 71
    new-instance v0, Lcom/google/common/collect/ImmutableMap$Builder;

    invoke-direct {v0}, Lcom/google/common/collect/ImmutableMap$Builder;-><init>()V

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->AUTH_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->DB_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->IO_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->PARSE_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    sget-object v1, Lcom/google/android/gm/provider/Gmail$CursorError;->UNKNOWN_ERROR:Lcom/google/android/gm/provider/Gmail$CursorError;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$CursorError;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/google/common/collect/ImmutableMap$Builder;->put(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableMap$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/common/collect/ImmutableMap$Builder;->build()Lcom/google/common/collect/ImmutableMap;

    move-result-object v0

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->GMAIL_ERROR_UI_ERROR_MAP:Ljava/util/Map;

    .line 83
    new-instance v0, Lcom/google/android/gm/provider/ObjectCache;

    new-instance v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$1;

    invoke-direct {v1}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$1;-><init>()V

    invoke-direct {v0, v1, v3}, Lcom/google/android/gm/provider/ObjectCache;-><init>(Lcom/google/android/gm/provider/ObjectCache$Callback;I)V

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->SENDER_INSTRUCTIONS_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    .line 96
    new-instance v0, Lcom/google/android/gm/provider/ObjectCache;

    new-instance v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$2;

    invoke-direct {v1}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$2;-><init>()V

    invoke-direct {v0, v1, v3}, Lcom/google/android/gm/provider/ObjectCache;-><init>(Lcom/google/android/gm/provider/ObjectCache$Callback;I)V

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->CONVERSATION_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    .line 108
    new-instance v0, Lcom/google/android/gm/provider/ObjectCache;

    new-instance v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$3;

    invoke-direct {v1}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor$3;-><init>()V

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/google/android/gm/provider/ObjectCache;-><init>(Lcom/google/android/gm/provider/ObjectCache$Callback;I)V

    sput-object v0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->MESSAGE_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "resultProjection"    # [Ljava/lang/String;

    .prologue
    .line 121
    invoke-direct {p0, p1, p3}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;-><init>(Landroid/database/Cursor;[Ljava/lang/String;)V

    .line 47
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCachedLabels:Ljava/util/Map;

    .line 49
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mRowDataCached:Z

    .line 51
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    .line 57
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSerializedFolderMap:Landroid/util/SparseArray;

    .line 59
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mLabelColorMap:Ljava/util/HashMap;

    .line 122
    iput-object p2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mAccount:Ljava/lang/String;

    .line 124
    const-string v0, "_id"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mConversationIdIndex:I

    .line 126
    const-string v0, "subject"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSubjectIndex:I

    .line 127
    const-string v0, "snippet"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSnippetIndex:I

    .line 128
    const-string v0, "fromAddress"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mFromIndex:I

    .line 129
    const-string v0, "date"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mDateIndex:I

    .line 130
    const-string v0, "personalLevel"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mPersonalLevelIndex:I

    .line 132
    const-string v0, "numMessages"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mNumMessagesIndex:I

    .line 133
    const-string v0, "hasAttachments"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mHasAttachmentsIndex:I

    .line 135
    const-string v0, "conversationLabels"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mLabelsIndex:I

    .line 137
    const-string v0, "synced"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSyncedIndex:I

    .line 138
    return-void
.end method

.method private cachePositionValues(Z)V
    .locals 3
    .param p1, "uriOnly"    # Z

    .prologue
    .line 207
    iget-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mRowDataCached:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentConversationUri:Ljava/lang/String;

    if-nez v0, :cond_2

    .line 208
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentConversationUri:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 209
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mAccount:Ljava/lang/String;

    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getConversationId()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getConversationUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentConversationUri:Ljava/lang/String;

    .line 213
    :cond_1
    if-nez p1, :cond_2

    .line 214
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->loadLabels(Ljava/util/Map;)V

    .line 215
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getSnippet()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSnippet:Ljava/lang/String;

    .line 216
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mRowDataCached:Z

    .line 219
    :cond_2
    return-void
.end method

.method private generateConversationInfo()Ljava/lang/String;
    .locals 8

    .prologue
    .line 273
    iget v5, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mFromIndex:I

    invoke-virtual {p0, v5}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v4

    .line 274
    .local v4, "senderInstructions":Ljava/lang/String;
    iget v5, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mNumMessagesIndex:I

    invoke-super {p0, v5}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v3

    .line 275
    .local v3, "numMessages":I
    sget-object v5, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->CONVERSATION_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v5}, Lcom/google/android/gm/provider/ObjectCache;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/ConversationInfo;

    .line 277
    .local v1, "info":Lcom/android/mail/providers/ConversationInfo;
    :try_start_0
    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSnippet:Ljava/lang/String;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v7, "^u"

    invoke-interface {v6, v7}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v6

    invoke-static {v4, v3, v5, v1, v6}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->generateConversationInfo(Ljava/lang/String;ILjava/lang/String;Lcom/android/mail/providers/ConversationInfo;Z)V

    .line 279
    invoke-static {v1}, Lcom/android/mail/providers/ConversationInfo;->toString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v5

    .line 283
    iget-object v6, v1, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/MessageInfo;

    .line 284
    .local v2, "messageInfo":Lcom/android/mail/providers/MessageInfo;
    sget-object v6, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->MESSAGE_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v6, v2}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    goto :goto_0

    .line 286
    .end local v2    # "messageInfo":Lcom/android/mail/providers/MessageInfo;
    :cond_0
    iget-object v6, v1, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->clear()V

    .line 288
    sget-object v6, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->CONVERSATION_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v6, v1}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    return-object v5

    .line 283
    .end local v0    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v5

    iget-object v6, v1, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .restart local v0    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/MessageInfo;

    .line 284
    .restart local v2    # "messageInfo":Lcom/android/mail/providers/MessageInfo;
    sget-object v6, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->MESSAGE_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v6, v2}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    goto :goto_1

    .line 286
    .end local v2    # "messageInfo":Lcom/android/mail/providers/MessageInfo;
    :cond_1
    iget-object v6, v1, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->clear()V

    .line 288
    sget-object v6, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->CONVERSATION_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v6, v1}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    throw v5
.end method

.method public static generateConversationInfo(Ljava/lang/String;ILjava/lang/String;Lcom/android/mail/providers/ConversationInfo;Z)V
    .locals 14
    .param p0, "senderInstructions"    # Ljava/lang/String;
    .param p1, "numMessages"    # I
    .param p2, "snippet"    # Ljava/lang/String;
    .param p3, "result"    # Lcom/android/mail/providers/ConversationInfo;
    .param p4, "conversationUnread"    # Z

    .prologue
    .line 295
    sget-object v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->SENDER_INSTRUCTIONS_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/ObjectCache;->get()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/android/gm/provider/SenderInstructions;

    .line 297
    .local v8, "instructions":Lcom/google/android/gm/provider/SenderInstructions;
    :try_start_0
    invoke-virtual {v8}, Lcom/google/android/gm/provider/SenderInstructions;->reset()V

    .line 298
    invoke-static {p0, v8}, Lcom/google/android/gm/provider/CompactSenderInstructions;->parseCompactSenderInstructions(Ljava/lang/String;Lcom/google/android/gm/provider/SenderInstructions;)V

    .line 301
    invoke-virtual {v8}, Lcom/google/android/gm/provider/SenderInstructions;->getNumDrafts()I

    move-result v3

    .line 302
    .local v3, "draftCount":I
    move-object/from16 v4, p2

    .line 303
    .local v4, "first":Ljava/lang/String;
    move-object v5, v4

    .line 304
    .local v5, "firstUnread":Ljava/lang/String;
    move-object v6, v4

    .line 305
    .local v6, "last":Ljava/lang/String;
    invoke-virtual {v8}, Lcom/google/android/gm/provider/SenderInstructions;->getSenders()Ljava/util/Collection;

    move-result-object v11

    .local v11, "senders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    move-object/from16 v1, p3

    move v2, p1

    .line 306
    invoke-virtual/range {v1 .. v6}, Lcom/android/mail/providers/ConversationInfo;->set(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    invoke-interface {v11}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v10

    check-cast v10, Lcom/google/android/gm/provider/SenderInstructions$Sender;

    .line 315
    .local v10, "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    sget-object v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->MESSAGE_INFO_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/ObjectCache;->get()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/mail/providers/MessageInfo;

    .line 316
    .local v9, "messageInfo":Lcom/android/mail/providers/MessageInfo;
    if-nez p4, :cond_0

    .line 317
    const/4 v1, 0x0

    iput-boolean v1, v10, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    .line 319
    :cond_0
    iget-boolean v1, v10, Lcom/google/android/gm/provider/SenderInstructions$Sender;->unread:Z

    if-nez v1, :cond_1

    const/4 v1, 0x1

    :goto_1
    const/4 v2, 0x0

    iget-object v12, v10, Lcom/google/android/gm/provider/SenderInstructions$Sender;->name:Ljava/lang/String;

    iget v13, v10, Lcom/google/android/gm/provider/SenderInstructions$Sender;->priority:I

    invoke-virtual {v9, v1, v2, v12, v13}, Lcom/android/mail/providers/MessageInfo;->set(ZZLjava/lang/String;I)V

    .line 320
    move-object/from16 v0, p3

    invoke-virtual {v0, v9}, Lcom/android/mail/providers/ConversationInfo;->addMessage(Lcom/android/mail/providers/MessageInfo;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 323
    .end local v3    # "draftCount":I
    .end local v4    # "first":Ljava/lang/String;
    .end local v5    # "firstUnread":Ljava/lang/String;
    .end local v6    # "last":Ljava/lang/String;
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v9    # "messageInfo":Lcom/android/mail/providers/MessageInfo;
    .end local v10    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    .end local v11    # "senders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    :catchall_0
    move-exception v1

    sget-object v2, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->SENDER_INSTRUCTIONS_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v2, v8}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    throw v1

    .line 319
    .restart local v3    # "draftCount":I
    .restart local v4    # "first":Ljava/lang/String;
    .restart local v5    # "firstUnread":Ljava/lang/String;
    .restart local v6    # "last":Ljava/lang/String;
    .restart local v7    # "i$":Ljava/util/Iterator;
    .restart local v9    # "messageInfo":Lcom/android/mail/providers/MessageInfo;
    .restart local v10    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    .restart local v11    # "senders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/SenderInstructions$Sender;>;"
    :cond_1
    const/4 v1, 0x0

    goto :goto_1

    .line 323
    .end local v9    # "messageInfo":Lcom/android/mail/providers/MessageInfo;
    .end local v10    # "sender":Lcom/google/android/gm/provider/SenderInstructions$Sender;
    :cond_2
    sget-object v1, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->SENDER_INSTRUCTIONS_CACHE:Lcom/google/android/gm/provider/ObjectCache;

    invoke-virtual {v1, v8}, Lcom/google/android/gm/provider/ObjectCache;->release(Ljava/lang/Object;)V

    .line 325
    return-void
.end method

.method private getConversationId()J
    .locals 2

    .prologue
    .line 386
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mConversationIdIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v0

    return-wide v0
.end method

.method private getConversationPersonalLevel()I
    .locals 4

    .prologue
    .line 390
    iget v3, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mPersonalLevelIndex:I

    invoke-super {p0, v3}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v1

    .line 392
    .local v1, "personalLevelInt":I
    invoke-static {v1}, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->fromInt(I)Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    move-result-object v0

    .line 394
    .local v0, "personalLevel":Lcom/google/android/gm/provider/Gmail$PersonalLevel;
    const/4 v2, 0x0

    .line 396
    .local v2, "translatedLevel":I
    sget-object v3, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->NOT_TO_ME:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    if-ne v0, v3, :cond_1

    .line 397
    const/4 v2, 0x0

    .line 403
    :cond_0
    :goto_0
    return v2

    .line 398
    :cond_1
    sget-object v3, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->ONLY_TO_ME:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    if-ne v0, v3, :cond_2

    .line 399
    const/4 v2, 0x2

    goto :goto_0

    .line 400
    :cond_2
    sget-object v3, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->TO_ME_AND_OTHERS:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    if-ne v0, v3, :cond_0

    .line 401
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private getRawLabels()Ljava/lang/String;
    .locals 1

    .prologue
    .line 419
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mLabelsIndex:I

    invoke-super {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSnippet()Ljava/lang/String;
    .locals 1

    .prologue
    .line 411
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSnippetIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private getSubject()Ljava/lang/String;
    .locals 1

    .prologue
    .line 407
    iget v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSubjectIndex:I

    invoke-virtual {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getStringInColumn(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private loadLabels(Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/Label;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 415
    .local p1, "labels":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Label;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mAccount:Ljava/lang/String;

    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getRawLabels()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCachedLabels:Ljava/util/Map;

    invoke-static {v0, v1, p1, v2}, Lcom/google/android/gm/provider/LabelManager;->parseLabelQueryResult(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;)V

    .line 416
    return-void
.end method


# virtual methods
.method public getExtras()Landroid/os/Bundle;
    .locals 8

    .prologue
    .line 254
    invoke-super {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getExtras()Landroid/os/Bundle;

    move-result-object v4

    .line 257
    .local v4, "underlyingExtras":Landroid/os/Bundle;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0, v4}, Landroid/os/Bundle;-><init>(Landroid/os/Bundle;)V

    .line 259
    .local v0, "result":Landroid/os/Bundle;
    const-string v6, "status"

    invoke-virtual {v4, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 260
    .local v5, "underlyingStatus":Ljava/lang/String;
    const-string v6, "error"

    invoke-virtual {v4, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 262
    .local v3, "underlyingError":Ljava/lang/String;
    sget-object v6, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->GMAIL_STATUS_UI_STATUS_MAP:Ljava/util/Map;

    invoke-interface {v6, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/Integer;

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 263
    .local v2, "uiCursorStatus":I
    sget-object v6, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->GMAIL_ERROR_UI_ERROR_MAP:Ljava/util/Map;

    invoke-interface {v6, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    .line 265
    .local v1, "uiCursorError":Ljava/lang/Integer;
    const-string v6, "cursor_status"

    invoke-virtual {v0, v6, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 266
    if-eqz v1, :cond_0

    .line 267
    const-string v6, "cursor_error"

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v7

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 269
    :cond_0
    return-object v0
.end method

.method public getInt(I)I
    .locals 7
    .param p1, "columnIndex"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 142
    invoke-direct {p0, v3}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->cachePositionValues(Z)V

    .line 143
    packed-switch p1, :pswitch_data_0

    .line 186
    :pswitch_0
    const-string v4, "Gmail"

    const-string v5, "UIConversationCursor.getInt(%d): Unexpected column"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v2, v3

    invoke-static {v4, v5, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 188
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v2

    :cond_0
    :goto_0
    return v2

    .line 145
    :pswitch_1
    iget v2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mHasAttachmentsIndex:I

    invoke-super {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v2

    goto :goto_0

    .line 147
    :pswitch_2
    iget v2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mNumMessagesIndex:I

    invoke-super {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v2

    goto :goto_0

    .line 150
    :pswitch_3
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^r"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 152
    :pswitch_4
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v4, "^^out"

    invoke-interface {v2, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    .line 153
    .local v0, "isSending":Z
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v4, "^f"

    invoke-interface {v2, v4}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    .line 154
    .local v1, "isSent":Z
    if-eqz v0, :cond_1

    .line 155
    const/4 v2, 0x2

    goto :goto_0

    .line 156
    :cond_1
    if-eqz v1, :cond_2

    .line 157
    const/4 v2, 0x3

    goto :goto_0

    :cond_2
    move v2, v3

    .line 159
    goto :goto_0

    .line 162
    .end local v0    # "isSending":Z
    .end local v1    # "isSent":Z
    :pswitch_5
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^io_im"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 166
    :pswitch_6
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^u"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    :goto_1
    move v2, v3

    goto :goto_0

    :cond_3
    move v3, v2

    goto :goto_1

    .line 168
    :pswitch_7
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^t"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 170
    :pswitch_8
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^s"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 172
    :pswitch_9
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^p"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    .line 174
    :pswitch_a
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    const-string v5, "^g"

    invoke-interface {v4, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    move v2, v3

    goto :goto_0

    :pswitch_b
    move v2, v3

    .line 177
    goto :goto_0

    .line 179
    :pswitch_c
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getConversationPersonalLevel()I

    move-result v2

    goto/16 :goto_0

    :pswitch_d
    move v2, v3

    .line 182
    goto/16 :goto_0

    .line 184
    :pswitch_e
    iget v4, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSyncedIndex:I

    invoke-super {p0, v4}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getInt(I)I

    move-result v4

    if-eqz v4, :cond_0

    move v2, v3

    goto/16 :goto_0

    .line 143
    :pswitch_data_0
    .packed-switch 0x7
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_0
        :pswitch_b
        :pswitch_c
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_d
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_e
    .end packed-switch
.end method

.method public getLong(I)J
    .locals 5
    .param p1, "columnIndex"    # I

    .prologue
    .line 194
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->mResultProjection:[Ljava/lang/String;

    aget-object v0, v1, p1

    .line 196
    .local v0, "column":Ljava/lang/String;
    const-string v1, "_id"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 197
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getConversationId()J

    move-result-wide v1

    .line 202
    :goto_0
    return-wide v1

    .line 198
    :cond_0
    const-string v1, "dateReceivedMs"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 199
    iget v1, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mDateIndex:I

    invoke-super {p0, v1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v1

    goto :goto_0

    .line 201
    :cond_1
    const-string v1, "Gmail"

    const-string v2, "UIConversationCursor.getLong(%d): Unexpected column"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 202
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getLong(I)J

    move-result-wide v1

    goto :goto_0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 5
    .param p1, "columnIndex"    # I

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 223
    if-ne p1, v1, :cond_0

    move v0, v1

    :goto_0
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->cachePositionValues(Z)V

    .line 224
    sparse-switch p1, :sswitch_data_0

    .line 246
    const-string v0, "Gmail"

    const-string v3, "UIConversationCursor.getString(%d): Unexpected column"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v1, v2

    invoke-static {v0, v3, v1}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 248
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_1
    return-object v0

    :cond_0
    move v0, v2

    .line 223
    goto :goto_0

    .line 226
    :sswitch_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentConversationUri:Ljava/lang/String;

    goto :goto_1

    .line 228
    :sswitch_1
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getSubject()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 230
    :sswitch_2
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSnippet:Ljava/lang/String;

    goto :goto_1

    .line 232
    :sswitch_3
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mAccount:Ljava/lang/String;

    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->getConversationId()J

    move-result-wide v1

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/UiProvider;->getConversationMessageListUri(Ljava/lang/String;J)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    :sswitch_4
    move-object v0, v3

    .line 235
    goto :goto_1

    .line 237
    :sswitch_5
    invoke-direct {p0}, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->generateConversationInfo()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 239
    :sswitch_6
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mAccount:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mSerializedFolderMap:Landroid/util/SparseArray;

    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mLabelColorMap:Ljava/util/HashMap;

    invoke-static {v0, v1, v2, v3}, Lcom/google/android/gm/provider/UiProvider;->getSerializedFolderString(Ljava/lang/String;Ljava/util/Map;Landroid/util/SparseArray;Ljava/util/Map;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    :sswitch_7
    move-object v0, v3

    .line 242
    goto :goto_1

    .line 244
    :sswitch_8
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/UiProvider;->getConversationBaseUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 224
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_0
        0x2 -> :sswitch_3
        0x3 -> :sswitch_1
        0x4 -> :sswitch_2
        0x5 -> :sswitch_5
        0xe -> :sswitch_6
        0x15 -> :sswitch_7
        0x16 -> :sswitch_4
        0x17 -> :sswitch_8
    .end sparse-switch
.end method

.method protected resetCursorRowState()V
    .locals 1

    .prologue
    .line 329
    invoke-super {p0}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->resetCursorRowState()V

    .line 330
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentLabels:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 331
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mCurrentConversationUri:Ljava/lang/String;

    .line 332
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;->mRowDataCached:Z

    .line 333
    return-void
.end method

.method public respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 10
    .param p1, "params"    # Landroid/os/Bundle;

    .prologue
    .line 344
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 345
    .local v4, "response":Landroid/os/Bundle;
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 347
    .local v2, "innerParams":Landroid/os/Bundle;
    const-string v1, "allowNetwork"

    .line 350
    .local v1, "allowNetworkAccessKey":Ljava/lang/String;
    const-string v8, "allowNetwork"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 351
    const-string v8, "allowNetwork"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 352
    .local v0, "allowNetworkAccess":Z
    const-string v9, "command"

    if-eqz v0, :cond_2

    const-string v8, "activate"

    :goto_0
    invoke-virtual {v2, v9, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 355
    invoke-super {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 357
    .local v3, "innerResponse":Landroid/os/Bundle;
    const-string v8, "ok"

    const-string v9, "commandResponse"

    invoke-virtual {v3, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    .line 359
    .local v6, "success":Z
    const-string v9, "allowNetwork"

    if-eqz v6, :cond_3

    const-string v8, "ok"

    :goto_1
    invoke-virtual {v4, v9, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 364
    .end local v0    # "allowNetworkAccess":Z
    .end local v3    # "innerResponse":Landroid/os/Bundle;
    .end local v6    # "success":Z
    :cond_0
    const-string v5, "setVisibility"

    .line 366
    .local v5, "setVisibilityKey":Ljava/lang/String;
    const-string v8, "setVisibility"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 367
    const-string v8, "setVisibility"

    invoke-virtual {p1, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 368
    .local v7, "visible":Z
    if-eqz v7, :cond_1

    .line 369
    invoke-virtual {v2}, Landroid/os/Bundle;->clear()V

    .line 370
    const-string v8, "command"

    const-string v9, "setVisible"

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 371
    const-string v8, "visible"

    invoke-virtual {v2, v8, v7}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 373
    invoke-super {p0, v2}, Lcom/google/android/gm/provider/uiprovider/UICursorWapper;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v3

    .line 374
    .restart local v3    # "innerResponse":Landroid/os/Bundle;
    const-string v8, "ok"

    const-string v9, "commandResponse"

    invoke-virtual {v3, v9}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    .line 376
    .restart local v6    # "success":Z
    const-string v9, "setVisibility"

    if-eqz v6, :cond_4

    const-string v8, "ok"

    :goto_2
    invoke-virtual {v4, v9, v8}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 382
    .end local v3    # "innerResponse":Landroid/os/Bundle;
    .end local v6    # "success":Z
    .end local v7    # "visible":Z
    :cond_1
    return-object v4

    .line 352
    .end local v5    # "setVisibilityKey":Ljava/lang/String;
    .restart local v0    # "allowNetworkAccess":Z
    :cond_2
    const-string v8, "deactivate"

    goto :goto_0

    .line 359
    .restart local v3    # "innerResponse":Landroid/os/Bundle;
    .restart local v6    # "success":Z
    :cond_3
    const-string v8, "failed"

    goto :goto_1

    .line 376
    .end local v0    # "allowNetworkAccess":Z
    .restart local v5    # "setVisibilityKey":Ljava/lang/String;
    .restart local v7    # "visible":Z
    :cond_4
    const-string v8, "failed"

    goto :goto_2
.end method
