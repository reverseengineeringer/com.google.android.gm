.class public Lcom/google/android/gm/provider/uiprovider/ConversationState;
.super Ljava/lang/Object;
.source "ConversationState.java"

# interfaces
.implements Landroid/content/Loader$OnLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/content/Loader$OnLoadCompleteListener",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;",
        ">;>;"
    }
.end annotation


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

.field private final mContext:Landroid/content/Context;

.field private final mConversationId:J

.field private final mDownloadManager:Landroid/app/DownloadManager;

.field private final mEngine:Lcom/google/android/gm/provider/MailEngine;

.field private final mLoaderHandler:Landroid/os/Handler;

.field private final mLoaderLock:Ljava/lang/Object;

.field private final mMessageAttachmentCursors:Ljava/util/WeakHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/WeakHashMap",
            "<",
            "Landroid/database/Cursor;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private final mMessageStateMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/uiprovider/MessageState;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;JLandroid/os/Handler;Lcom/google/android/gm/provider/MailEngine;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "conversationId"    # J
    .param p5, "loaderHandler"    # Landroid/os/Handler;
    .param p6, "engine"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 47
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 26
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    .line 33
    new-instance v0, Ljava/util/WeakHashMap;

    invoke-direct {v0}, Ljava/util/WeakHashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageAttachmentCursors:Ljava/util/WeakHashMap;

    .line 37
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mLoaderLock:Ljava/lang/Object;

    .line 48
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mContext:Landroid/content/Context;

    .line 49
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mContext:Landroid/content/Context;

    const-string v1, "download"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/DownloadManager;

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mDownloadManager:Landroid/app/DownloadManager;

    .line 50
    iput-object p2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAccount:Ljava/lang/String;

    .line 51
    iput-wide p3, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mConversationId:J

    .line 52
    iput-object p5, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mLoaderHandler:Landroid/os/Handler;

    .line 53
    iput-object p6, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mLoaderLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$100(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Lcom/google/android/gm/provider/AttachmentStatusLoader;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    return-object v0
.end method

.method static synthetic access$102(Lcom/google/android/gm/provider/uiprovider/ConversationState;Lcom/google/android/gm/provider/AttachmentStatusLoader;)Lcom/google/android/gm/provider/AttachmentStatusLoader;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;
    .param p1, "x1"    # Lcom/google/android/gm/provider/AttachmentStatusLoader;

    .prologue
    .line 22
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    return-object p1
.end method

.method static synthetic access$200(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$300(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAccount:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/google/android/gm/provider/uiprovider/ConversationState;)J
    .locals 2
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .prologue
    .line 22
    iget-wide v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mConversationId:J

    return-wide v0
.end method

.method static synthetic access$500(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Landroid/app/DownloadManager;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mDownloadManager:Landroid/app/DownloadManager;

    return-object v0
.end method

.method private createMessageStateFromMessage(Lcom/google/android/gm/provider/MailSync$Message;)Lcom/google/android/gm/provider/uiprovider/MessageState;
    .locals 10
    .param p1, "message"    # Lcom/google/android/gm/provider/MailSync$Message;

    .prologue
    .line 100
    iget-wide v5, p1, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    .line 101
    .local v5, "serverMessageId":J
    iget-object v9, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    monitor-enter v9

    .line 102
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 103
    new-instance v0, Lcom/google/android/gm/provider/uiprovider/MessageState;

    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAccount:Ljava/lang/String;

    iget-wide v3, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mConversationId:J

    iget-wide v7, p1, Lcom/google/android/gm/provider/MailSync$Message;->localMessageId:J

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gm/provider/uiprovider/MessageState;-><init>(Landroid/content/Context;Ljava/lang/String;JJJ)V

    .line 105
    .local v0, "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 109
    :goto_0
    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 113
    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->initializeAttachmentsFromMessage(Lcom/google/android/gm/provider/MailSync$Message;)V

    .line 115
    return-object v0

    .line 107
    .end local v0    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    :cond_0
    :try_start_1
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/MessageState;

    .restart local v0    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    goto :goto_0

    .line 109
    .end local v0    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    :catchall_0
    move-exception v1

    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method


# virtual methods
.method public addAttachmentCursor(Landroid/database/Cursor;)V
    .locals 3
    .param p1, "attachmentCursor"    # Landroid/database/Cursor;

    .prologue
    .line 140
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageAttachmentCursors:Ljava/util/WeakHashMap;

    monitor-enter v1

    .line 141
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageAttachmentCursors:Ljava/util/WeakHashMap;

    const/4 v2, 0x0

    invoke-virtual {v0, p1, v2}, Ljava/util/WeakHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 142
    monitor-exit v1

    .line 143
    return-void

    .line 142
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public ensureAttachmentStatusLoaderStarted()V
    .locals 2

    .prologue
    .line 147
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mLoaderHandler:Landroid/os/Handler;

    new-instance v1, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;

    invoke-direct {v1, p0}, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;-><init>(Lcom/google/android/gm/provider/uiprovider/ConversationState;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 166
    return-void
.end method

.method public getMessageState(J)Lcom/google/android/gm/provider/uiprovider/MessageState;
    .locals 4
    .param p1, "messageId"    # J

    .prologue
    .line 64
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    monitor-enter v2

    .line 65
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/MessageState;

    .line 66
    .local v0, "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    monitor-exit v2

    .line 68
    return-object v0

    .line 66
    .end local v0    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public getOrCreateMessageState(J)Lcom/google/android/gm/provider/uiprovider/MessageState;
    .locals 5
    .param p1, "serverMessageId"    # J

    .prologue
    const/4 v4, 0x0

    .line 121
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->getMessageState(J)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v1

    .line 123
    .local v1, "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->gmailAttachmentDataLoaded()Z

    move-result v2

    if-nez v2, :cond_2

    .line 124
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v2, p1, p2, v4}, Lcom/google/android/gm/provider/MailEngine;->getMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v0

    .line 125
    .local v0, "message":Lcom/google/android/gm/provider/MailSync$Message;
    if-nez v0, :cond_1

    .line 126
    const-string v2, "Gmail"

    const-string v3, "Message not found"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 127
    const/4 v2, 0x0

    .line 136
    .end local v0    # "message":Lcom/google/android/gm/provider/MailSync$Message;
    :goto_0
    return-object v2

    .line 132
    .restart local v0    # "message":Lcom/google/android/gm/provider/MailSync$Message;
    :cond_1
    if-nez v1, :cond_2

    .line 133
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->createMessageStateFromMessage(Lcom/google/android/gm/provider/MailSync$Message;)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v1

    .end local v0    # "message":Lcom/google/android/gm/provider/MailSync$Message;
    :cond_2
    move-object v2, v1

    .line 136
    goto :goto_0
.end method

.method public getOrCreateMessageState(Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;)Lcom/google/android/gm/provider/uiprovider/MessageState;
    .locals 6
    .param p1, "parsed"    # Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;

    .prologue
    const/4 v5, 0x0

    .line 73
    iget-wide v2, p1, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mMessageId:J

    invoke-virtual {p0, v2, v3}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->getMessageState(J)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v1

    .line 75
    .local v1, "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    iget-wide v3, p1, Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;->mLocalMessageId:J

    invoke-virtual {v2, v3, v4, v5}, Lcom/google/android/gm/provider/MailEngine;->getLocalMessage(JZ)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v0

    .line 76
    .local v0, "message":Lcom/google/android/gm/provider/MailSync$Message;
    if-nez v0, :cond_0

    .line 77
    const-string v2, "Gmail"

    const-string v3, "Message not found"

    new-array v4, v5, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 78
    const/4 v2, 0x0

    .line 92
    :goto_0
    return-object v2

    .line 83
    :cond_0
    if-nez v1, :cond_2

    .line 84
    invoke-direct {p0, v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->createMessageStateFromMessage(Lcom/google/android/gm/provider/MailSync$Message;)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v1

    .line 86
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->ensureAttachmentStatusLoaderStarted()V

    :cond_1
    :goto_1
    move-object v2, v1

    .line 92
    goto :goto_0

    .line 87
    :cond_2
    invoke-virtual {v1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->gmailAttachmentDataLoaded()Z

    move-result v2

    if-nez v2, :cond_1

    .line 89
    invoke-virtual {v1, v0}, Lcom/google/android/gm/provider/uiprovider/MessageState;->populateGmailAttachmentData(Lcom/google/android/gm/provider/MailSync$Message;)V

    goto :goto_1
.end method

.method public handleCursorClose(Landroid/database/Cursor;)V
    .locals 5
    .param p1, "attachmentCursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v0, 0x0

    .line 170
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageAttachmentCursors:Ljava/util/WeakHashMap;

    monitor-enter v2

    .line 171
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageAttachmentCursors:Ljava/util/WeakHashMap;

    invoke-virtual {v1, p1}, Ljava/util/WeakHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 173
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageAttachmentCursors:Ljava/util/WeakHashMap;

    invoke-virtual {v1}, Ljava/util/WeakHashMap;->size()I

    move-result v1

    if-nez v1, :cond_0

    const/4 v0, 0x1

    .line 174
    .local v0, "allCursorsClosed":Z
    :cond_0
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 177
    if-eqz v0, :cond_2

    .line 178
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mLoaderLock:Ljava/lang/Object;

    monitor-enter v2

    .line 179
    :try_start_1
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    if-eqz v1, :cond_1

    .line 180
    const-string v1, "Gmail"

    const-string v3, "attachment cursor closed, and stopping loader"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v1, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 181
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->abandon()V

    .line 182
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->stopLoading()V

    .line 183
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->reset()V

    .line 185
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    .line 187
    :cond_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 189
    :cond_2
    return-void

    .line 174
    .end local v0    # "allCursorsClosed":Z
    :catchall_0
    move-exception v1

    :try_start_2
    monitor-exit v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v1

    .line 187
    .restart local v0    # "allCursorsClosed":Z
    :catchall_1
    move-exception v1

    :try_start_3
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v1
.end method

.method notifyAttachmentChanges()V
    .locals 5

    .prologue
    .line 192
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    monitor-enter v4

    .line 194
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    .line 195
    .local v2, "messageStates":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/uiprovider/MessageState;>;"
    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/uiprovider/MessageState;

    .line 196
    .local v1, "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    invoke-virtual {v1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->notifyAttachmentChange()V

    goto :goto_0

    .line 198
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    .end local v2    # "messageStates":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/uiprovider/MessageState;>;"
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "messageStates":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/google/android/gm/provider/uiprovider/MessageState;>;"
    :cond_0
    :try_start_1
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 199
    return-void
.end method

.method public bridge synthetic onLoadComplete(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 22
    check-cast p2, Ljava/util/List;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->onLoadComplete(Landroid/content/Loader;Ljava/util/List;)V

    return-void
.end method

.method public onLoadComplete(Landroid/content/Loader;Ljava/util/List;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;",
            ">;>;",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 203
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Ljava/util/List<Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;>;>;"
    .local p2, "results":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;>;"
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mMessageStateMap:Ljava/util/Map;

    monitor-enter v4

    .line 204
    :try_start_0
    const-string v3, "Gmail"

    const-string v5, "onLoadComplete called on loader for conversation %d"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-wide v8, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState;->mConversationId:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v3, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 207
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;

    .line 208
    .local v0, "attachment":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    iget-wide v5, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    invoke-virtual {p0, v5, v6}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->getOrCreateMessageState(J)Lcom/google/android/gm/provider/uiprovider/MessageState;

    move-result-object v2

    .line 209
    .local v2, "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    if-eqz v2, :cond_0

    .line 210
    invoke-virtual {v2, v0}, Lcom/google/android/gm/provider/uiprovider/MessageState;->updateAttachment(Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;)V

    goto :goto_0

    .line 219
    .end local v0    # "attachment":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 212
    .restart local v0    # "attachment":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    .restart local v1    # "i$":Ljava/util/Iterator;
    .restart local v2    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    :cond_0
    :try_start_1
    const-string v3, "Gmail"

    const-string v5, "failed to find Message state for message id: %d"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-wide v8, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v3, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 218
    .end local v0    # "attachment":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    .end local v2    # "messageState":Lcom/google/android/gm/provider/uiprovider/MessageState;
    :cond_1
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->notifyAttachmentChanges()V

    .line 219
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 220
    return-void
.end method
