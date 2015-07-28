.class public Lcom/google/android/gm/provider/uiprovider/MessageState;
.super Ljava/lang/Object;
.source "MessageState.java"


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field private final mConversationId:J

.field private final mLocalMessageId:J

.field private final mMessageAttachments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/uiprovider/UIAttachment;",
            ">;"
        }
    .end annotation
.end field

.field mMessageAttachmentsInitialized:Z

.field private final mMessageId:J


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;JJJ)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Ljava/lang/String;
    .param p3, "conversationId"    # J
    .param p5, "messageId"    # J
    .param p7, "localMessageId"    # J

    .prologue
    .line 39
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    .line 30
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachmentsInitialized:Z

    .line 40
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mContext:Landroid/content/Context;

    .line 41
    iput-object p2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mAccount:Ljava/lang/String;

    .line 42
    iput-wide p3, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mConversationId:J

    .line 43
    iput-wide p5, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageId:J

    .line 44
    iput-wide p7, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mLocalMessageId:J

    .line 45
    return-void
.end method

.method private getMessageAttachmentIndex(Ljava/lang/String;)I
    .locals 4
    .param p1, "partId"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v3

    .line 67
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v1, v2, :cond_1

    .line 68
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 69
    .local v0, "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v0}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 70
    monitor-exit v3

    .line 74
    .end local v0    # "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    .end local v1    # "i":I
    :goto_1
    return v1

    .line 67
    .restart local v0    # "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    .restart local v1    # "i":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 73
    .end local v0    # "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :cond_1
    monitor-exit v3

    .line 74
    const/4 v1, -0x1

    goto :goto_1

    .line 73
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method


# virtual methods
.method public getMessageAttachment(Ljava/lang/String;)Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    .locals 4
    .param p1, "partId"    # Ljava/lang/String;

    .prologue
    .line 55
    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v3

    .line 56
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 57
    .local v0, "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v0}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 58
    monitor-exit v3

    .line 62
    .end local v0    # "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :goto_0
    return-object v0

    .line 61
    :cond_1
    monitor-exit v3

    .line 62
    const/4 v0, 0x0

    goto :goto_0

    .line 61
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public getMessageAttachments()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/google/android/gm/provider/uiprovider/UIAttachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 49
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v1

    .line 50
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-static {v0}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 51
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method gmailAttachmentDataLoaded()Z
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 123
    iget-boolean v3, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachmentsInitialized:Z

    if-nez v3, :cond_0

    .line 134
    :goto_0
    return v2

    .line 127
    :cond_0
    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v3

    .line 128
    :try_start_0
    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 129
    .local v0, "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v0}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getOriginal()Lcom/google/android/gm/provider/Gmail$Attachment;

    move-result-object v4

    if-nez v4, :cond_1

    .line 130
    monitor-exit v3

    goto :goto_0

    .line 133
    .end local v0    # "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_2
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 134
    const/4 v2, 0x1

    goto :goto_0
.end method

.method initializeAttachmentsFromMessage(Lcom/google/android/gm/provider/MailSync$Message;)V
    .locals 5
    .param p1, "message"    # Lcom/google/android/gm/provider/MailSync$Message;

    .prologue
    .line 78
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 79
    const-string v2, "Gmail"

    const-string v3, "Attempting to initialize attachment when attachmentshave already been configured"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 90
    :goto_0
    return-void

    .line 84
    :cond_0
    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v3

    .line 85
    :try_start_0
    iget-object v2, p1, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 86
    .local v0, "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 88
    .end local v0    # "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 89
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachmentsInitialized:Z

    goto :goto_0
.end method

.method public notifyAttachmentChange()V
    .locals 11

    .prologue
    .line 197
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v8

    .line 198
    .local v8, "partIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/google/android/gm/provider/uiprovider/MessageState;->getMessageAttachments()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .local v10, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 199
    .local v9, "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v9}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v8, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 201
    .end local v9    # "attachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :cond_0
    const-string v0, "Gmail"

    const-string v1, "Notifying about attachment change conversation message %d/%d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-wide v4, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mConversationId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-wide v4, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 203
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mAccount:Ljava/lang/String;

    iget-wide v2, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mConversationId:J

    iget-wide v4, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageId:J

    iget-wide v6, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mLocalMessageId:J

    invoke-static/range {v0 .. v8}, Lcom/google/android/gm/provider/UiProvider;->notifyMessageAttachmentsChanged(Landroid/content/Context;Ljava/lang/String;JJJLjava/util/Set;)V

    .line 205
    return-void
.end method

.method populateGmailAttachmentData(Lcom/google/android/gm/provider/MailSync$Message;)V
    .locals 9
    .param p1, "message"    # Lcom/google/android/gm/provider/MailSync$Message;

    .prologue
    .line 94
    iget-boolean v7, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachmentsInitialized:Z

    if-nez v7, :cond_0

    .line 95
    invoke-virtual {p0, p1}, Lcom/google/android/gm/provider/uiprovider/MessageState;->initializeAttachmentsFromMessage(Lcom/google/android/gm/provider/MailSync$Message;)V

    .line 98
    :cond_0
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v2

    .line 100
    .local v2, "attachmentPartIdMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/Gmail$Attachment;>;"
    iget-object v7, p1, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 101
    .local v1, "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$Attachment;->getPartId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v7, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 104
    .end local v1    # "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    :cond_1
    iget-object v8, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v8

    .line 105
    :try_start_0
    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 106
    .local v6, "uiAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v6}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getOriginal()Lcom/google/android/gm/provider/Gmail$Attachment;

    move-result-object v7

    if-nez v7, :cond_2

    .line 107
    invoke-interface {v6}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v2, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 109
    .local v3, "gmailAttachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    if-eqz v3, :cond_2

    .line 110
    move-object v0, v6

    check-cast v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;

    move-object v5, v0

    .line 112
    .local v5, "loaderAttachment":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    iput-object v3, v5, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    goto :goto_1

    .line 116
    .end local v3    # "gmailAttachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v5    # "loaderAttachment":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    .end local v6    # "uiAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :catchall_0
    move-exception v7

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v7

    :cond_3
    :try_start_1
    monitor-exit v8
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 117
    return-void
.end method

.method public updateAttachment(Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;)V
    .locals 13
    .param p1, "attachment"    # Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;

    .prologue
    .line 138
    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    monitor-enter v7

    .line 140
    :try_start_0
    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->getPartId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/google/android/gm/provider/uiprovider/MessageState;->getMessageAttachmentIndex(Ljava/lang/String;)I

    move-result v0

    .line 141
    .local v0, "attachmentIndex":I
    const/4 v6, -0x1

    if-eq v0, v6, :cond_4

    .line 143
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v6, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 144
    .local v3, "oldAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getOriginal()Lcom/google/android/gm/provider/Gmail$Attachment;

    move-result-object v1

    .line 147
    .local v1, "gmailAttachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    iget-object v6, p1, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    sget-object v8, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    if-ne v6, v8, :cond_3

    .line 150
    iput-object v1, p1, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 164
    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isDownloading()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusPending()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusPaused()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusSuccess()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusError()Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusValid()Z

    move-result v6

    if-nez v6, :cond_1

    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusPending()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->isDownloading()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 168
    :cond_1
    const/4 v6, 0x2

    invoke-interface {v3}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getDestination()I

    move-result v8

    const/4 v9, 0x0

    invoke-virtual {p1, v6, v8, v9}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->updateState(IILjava/lang/String;)V

    .line 173
    :cond_2
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v6, v0}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 174
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v6, v0, p1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 192
    .end local v1    # "gmailAttachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v3    # "oldAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :goto_0
    monitor-exit v7

    .line 193
    return-void

    .line 176
    .restart local v1    # "gmailAttachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .restart local v3    # "oldAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :cond_3
    const-string v6, "Gmail"

    const-string v8, "Dropping attachment update, as this is an thumbnail attachment: %s"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object p1, v9, v10

    invoke-static {v6, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 192
    .end local v0    # "attachmentIndex":I
    .end local v1    # "gmailAttachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v3    # "oldAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :catchall_0
    move-exception v6

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v6

    .line 181
    .restart local v0    # "attachmentIndex":I
    :cond_4
    :try_start_1
    const-string v6, "Gmail"

    const/4 v8, 0x3

    invoke-static {v6, v8}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 182
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v4

    .line 183
    .local v4, "partIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/google/android/gm/provider/uiprovider/UIAttachment;

    .line 184
    .local v5, "uiAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    invoke-interface {v5}, Lcom/google/android/gm/provider/uiprovider/UIAttachment;->getPartId()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 186
    .end local v5    # "uiAttachment":Lcom/google/android/gm/provider/uiprovider/UIAttachment;
    :cond_5
    const-string v6, "Gmail"

    const-string v8, "Got unexpected attachment. messageId: %d partId: %s set: %s"

    const/4 v9, 0x3

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v11, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageId:J

    invoke-static {v11, v12}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x1

    invoke-virtual {p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->getPartId()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x2

    aput-object v4, v9, v10

    invoke-static {v6, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 190
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "partIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_6
    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/MessageState;->mMessageAttachments:Ljava/util/List;

    invoke-interface {v6, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method
