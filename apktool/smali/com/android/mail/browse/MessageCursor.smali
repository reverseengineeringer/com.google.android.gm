.class public Lcom/android/mail/browse/MessageCursor;
.super Landroid/database/CursorWrapper;
.source "MessageCursor.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/MessageCursor$ConversationMessage;,
        Lcom/android/mail/browse/MessageCursor$ConversationController;
    }
.end annotation


# instance fields
.field private final mCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/android/mail/browse/MessageCursor$ConversationMessage;",
            ">;"
        }
    .end annotation
.end field

.field private final mController:Lcom/android/mail/browse/MessageCursor$ConversationController;

.field private final mConversation:Lcom/android/mail/providers/Conversation;

.field private mStatus:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Landroid/database/Cursor;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/MessageCursor$ConversationController;)V
    .locals 1
    .param p1, "inner"    # Landroid/database/Cursor;
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p3, "controller"    # Lcom/android/mail/browse/MessageCursor$ConversationController;

    .prologue
    .line 116
    invoke-direct {p0, p1}, Landroid/database/CursorWrapper;-><init>(Landroid/database/Cursor;)V

    .line 46
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/MessageCursor;->mCache:Ljava/util/Map;

    .line 117
    iput-object p2, p0, Lcom/android/mail/browse/MessageCursor;->mConversation:Lcom/android/mail/providers/Conversation;

    .line 118
    iput-object p3, p0, Lcom/android/mail/browse/MessageCursor;->mController:Lcom/android/mail/browse/MessageCursor$ConversationController;

    .line 119
    return-void
.end method


# virtual methods
.method public getDebugDump()Ljava/lang/String;
    .locals 14

    .prologue
    const/4 v13, 0x2

    const/4 v12, 0x1

    const/4 v11, 0x0

    .line 201
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 202
    .local v5, "sb":Ljava/lang/StringBuilder;
    const-string v6, "conv subj=\'%s\' status=%d messages:\n"

    new-array v7, v13, [Ljava/lang/Object;

    iget-object v8, p0, Lcom/android/mail/browse/MessageCursor;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v8, v8, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    aput-object v8, v7, v11

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getStatus()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v12

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 204
    const/4 v4, -0x1

    .line 205
    .local v4, "pos":I
    :goto_0
    add-int/lit8 v4, v4, 0x1

    invoke-virtual {p0, v4}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 206
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v3

    .line 207
    .local v3, "m":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v1

    .line 208
    .local v1, "attUris":Ljava/util/List;, "Ljava/util/List<Landroid/net/Uri;>;"
    invoke-virtual {v3}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getAttachments()Ljava/util/List;

    move-result-object v6

    invoke-interface {v6}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 209
    .local v0, "a":Lcom/android/mail/providers/Attachment;
    iget-object v6, v0, Lcom/android/mail/providers/Attachment;->uri:Landroid/net/Uri;

    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 211
    .end local v0    # "a":Lcom/android/mail/providers/Attachment;
    :cond_0
    const-string v6, "[Message #%d hash=%s uri=%s id=%s serverId=%s from=\'%s\' draftType=%d isSending=%s read=%s starred=%s attUris=%s]\n"

    const/16 v7, 0xb

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-virtual {v3}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getStateHashCode()I

    move-result v8

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v7, v12

    iget-object v8, v3, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    aput-object v8, v7, v13

    const/4 v8, 0x3

    iget-wide v9, v3, Lcom/android/mail/providers/Message;->id:J

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x4

    iget-object v9, v3, Lcom/android/mail/providers/Message;->serverId:Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x5

    iget-object v9, v3, Lcom/android/mail/providers/Message;->from:Ljava/lang/String;

    aput-object v9, v7, v8

    const/4 v8, 0x6

    iget v9, v3, Lcom/android/mail/providers/Message;->draftType:I

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    const/4 v8, 0x7

    iget-boolean v9, v3, Lcom/android/mail/providers/Message;->isSending:Z

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    aput-object v9, v7, v8

    const/16 v8, 0x8

    iget-boolean v9, v3, Lcom/android/mail/providers/Message;->read:Z

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    aput-object v9, v7, v8

    const/16 v8, 0x9

    iget-boolean v9, v3, Lcom/android/mail/providers/Message;->starred:Z

    invoke-static {v9}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    aput-object v9, v7, v8

    const/16 v8, 0xa

    aput-object v1, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_0

    .line 217
    .end local v1    # "attUris":Ljava/util/List;, "Ljava/util/List<Landroid/net/Uri;>;"
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "m":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    :cond_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    return-object v6
.end method

.method public getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .locals 5

    .prologue
    .line 122
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getWrappedCursor()Landroid/database/Cursor;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    .line 123
    .local v0, "id":J
    iget-object v3, p0, Lcom/android/mail/browse/MessageCursor;->mCache:Ljava/util/Map;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .line 124
    .local v2, "m":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    if-nez v2, :cond_0

    .line 125
    new-instance v2, Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    .end local v2    # "m":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    iget-object v3, p0, Lcom/android/mail/browse/MessageCursor;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v4, p0, Lcom/android/mail/browse/MessageCursor;->mController:Lcom/android/mail/browse/MessageCursor$ConversationController;

    invoke-direct {v2, p0, v3, v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;-><init>(Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/MessageCursor$ConversationController;)V

    .line 126
    .restart local v2    # "m":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    iget-object v3, p0, Lcom/android/mail/browse/MessageCursor;->mCache:Ljava/util/Map;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v3, v4, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    :cond_0
    return-object v2
.end method

.method public getStateHashCode()I
    .locals 1

    .prologue
    .line 160
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageCursor;->getStateHashCode(I)I

    move-result v0

    return v0
.end method

.method public getStateHashCode(I)I
    .locals 5
    .param p1, "exceptLast"    # I

    .prologue
    .line 174
    const/16 v0, 0x11

    .line 175
    .local v0, "hashCode":I
    const/4 v1, -0x1

    .line 176
    .local v1, "pos":I
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getCount()I

    move-result v3

    sub-int v2, v3, p1

    .line 177
    .local v2, "stopAt":I
    :goto_0
    add-int/lit8 v1, v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_0

    if-ge v1, v2, :cond_0

    .line 178
    mul-int/lit8 v3, v0, 0x1f

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getStateHashCode()I

    move-result v4

    add-int v0, v3, v4

    goto :goto_0

    .line 180
    :cond_0
    return v0
.end method

.method public getStatus()I
    .locals 2

    .prologue
    .line 184
    iget-object v1, p0, Lcom/android/mail/browse/MessageCursor;->mStatus:Ljava/lang/Integer;

    if-eqz v1, :cond_0

    .line 185
    iget-object v1, p0, Lcom/android/mail/browse/MessageCursor;->mStatus:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 193
    :goto_0
    return v1

    .line 188
    :cond_0
    const/4 v1, 0x2

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/MessageCursor;->mStatus:Ljava/lang/Integer;

    .line 189
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 190
    .local v0, "extras":Landroid/os/Bundle;
    if-eqz v0, :cond_1

    const-string v1, "cursor_status"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 191
    const-string v1, "cursor_status"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/browse/MessageCursor;->mStatus:Ljava/lang/Integer;

    .line 193
    :cond_1
    iget-object v1, p0, Lcom/android/mail/browse/MessageCursor;->mStatus:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    goto :goto_0
.end method

.method public isConversationRead()Z
    .locals 2

    .prologue
    .line 144
    const/4 v0, -0x1

    .line 145
    .local v0, "pos":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 146
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v1

    iget-boolean v1, v1, Lcom/android/mail/providers/Message;->read:Z

    if-nez v1, :cond_0

    .line 147
    const/4 v1, 0x0

    .line 150
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isConversationStarred()Z
    .locals 2

    .prologue
    .line 133
    const/4 v0, -0x1

    .line 134
    .local v0, "pos":I
    :cond_0
    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 135
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v1

    iget-boolean v1, v1, Lcom/android/mail/providers/Message;->starred:Z

    if-eqz v1, :cond_0

    .line 136
    const/4 v1, 0x1

    .line 139
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isLoaded()Z
    .locals 2

    .prologue
    .line 197
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getStatus()I

    move-result v0

    const/4 v1, 0x2

    if-ge v0, v1, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getCount()I

    move-result v0

    if-lez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public markMessagesRead()V
    .locals 3

    .prologue
    .line 153
    const/4 v0, -0x1

    .line 154
    .local v0, "pos":I
    :goto_0
    add-int/lit8 v0, v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 155
    invoke-virtual {p0}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v1

    const/4 v2, 0x1

    iput-boolean v2, v1, Lcom/android/mail/providers/Message;->read:Z

    goto :goto_0

    .line 157
    :cond_0
    return-void
.end method
