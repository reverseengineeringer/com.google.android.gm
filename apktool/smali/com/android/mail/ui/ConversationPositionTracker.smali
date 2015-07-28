.class public Lcom/android/mail/ui/ConversationPositionTracker;
.super Ljava/lang/Object;
.source "ConversationPositionTracker.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;
    }
.end annotation


# static fields
.field protected static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mCallbacks:Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

.field private mConversation:Lcom/android/mail/providers/Conversation;

.field private mCursorDirty:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/ConversationPositionTracker;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;)V
    .locals 1
    .param p1, "callbacks"    # Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

    .prologue
    .line 56
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 47
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCursorDirty:Z

    .line 57
    iput-object p1, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCallbacks:Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

    .line 58
    return-void
.end method

.method private calculatePosition()I
    .locals 11

    .prologue
    const/4 v0, 0x1

    const/4 v5, -0x1

    const/4 v6, 0x0

    .line 171
    const/4 v2, -0x1

    .line 172
    .local v2, "invalidPosition":I
    iget-object v7, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCallbacks:Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

    invoke-interface {v7}, Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v1

    .line 174
    .local v1, "cursor":Lcom/android/mail/browse/ConversationCursor;
    iget-boolean v7, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCursorDirty:Z

    if-nez v7, :cond_1

    .line 175
    iget-object v6, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    iget v5, v6, Lcom/android/mail/providers/Conversation;->position:I

    .line 229
    :cond_0
    :goto_0
    return v5

    .line 178
    :cond_1
    if-eqz v1, :cond_0

    iget-object v7, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    if-eqz v7, :cond_0

    .line 181
    iput-boolean v6, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCursorDirty:Z

    .line 182
    if-nez v1, :cond_2

    move v3, v6

    .line 183
    .local v3, "listSize":I
    :goto_1
    invoke-static {v1}, Lcom/android/mail/ui/ConversationPositionTracker;->isDataLoaded(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v7

    if-eqz v7, :cond_0

    if-eqz v3, :cond_0

    .line 188
    invoke-static {v1}, Lcom/android/mail/utils/Utils;->disableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    move-result v4

    .line 189
    .local v4, "networkWasEnabled":Z
    const/4 v5, 0x0

    .line 193
    .local v5, "newPosition":I
    :goto_2
    :try_start_0
    invoke-virtual {v1, v5}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 194
    invoke-static {v1}, Lcom/android/mail/utils/Utils;->getConversationId(Lcom/android/mail/browse/ConversationCursor;)J

    move-result-wide v7

    iget-object v9, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v9, v9, Lcom/android/mail/providers/Conversation;->id:J

    cmp-long v7, v7, v9

    if-nez v7, :cond_4

    .line 195
    iget-object v7, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    iput v5, v7, Lcom/android/mail/providers/Conversation;->position:I

    .line 196
    iget-object v7, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    iget v7, v7, Lcom/android/mail/providers/Conversation;->position:I

    if-eq v7, v5, :cond_3

    .line 201
    .local v0, "changed":Z
    :goto_3
    add-int/lit8 v6, v5, 0x1

    invoke-virtual {v1, v6}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 224
    if-eqz v4, :cond_0

    .line 225
    invoke-static {v1}, Lcom/android/mail/utils/Utils;->enableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    goto :goto_0

    .line 182
    .end local v0    # "changed":Z
    .end local v3    # "listSize":I
    .end local v4    # "networkWasEnabled":Z
    .end local v5    # "newPosition":I
    :cond_2
    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationCursor;->getCount()I

    move-result v3

    goto :goto_1

    .restart local v3    # "listSize":I
    .restart local v4    # "networkWasEnabled":Z
    .restart local v5    # "newPosition":I
    :cond_3
    move v0, v6

    .line 196
    goto :goto_3

    .line 204
    :cond_4
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 209
    :cond_5
    :try_start_1
    iget-object v6, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    iget v6, v6, Lcom/android/mail/providers/Conversation;->position:I

    if-ge v6, v3, :cond_6

    if-lt v5, v3, :cond_7

    .line 211
    :cond_6
    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationCursor;->getCount()I

    move-result v6

    add-int/lit8 v5, v6, -0x1

    .line 215
    :cond_7
    invoke-static {v1}, Lcom/android/mail/ui/ConversationPositionTracker;->isDataLoaded(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 216
    sget-object v6, Lcom/android/mail/ui/ConversationPositionTracker;->LOG_TAG:Ljava/lang/String;

    const-string v7, "ConversationPositionTracker: Could not find conversation %s in the cursor. Moving to position %d "

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-object v10, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v10}, Lcom/android/mail/providers/Conversation;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    const/4 v9, 0x1

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v6, v7, v8}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 219
    invoke-virtual {v1, v5}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    .line 220
    new-instance v6, Lcom/android/mail/providers/Conversation;

    invoke-direct {v6, v1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    iput-object v6, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 224
    :cond_8
    if-eqz v4, :cond_0

    .line 225
    invoke-static {v1}, Lcom/android/mail/utils/Utils;->enableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    goto/16 :goto_0

    .line 224
    :catchall_0
    move-exception v6

    if-eqz v4, :cond_9

    .line 225
    invoke-static {v1}, Lcom/android/mail/utils/Utils;->enableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    :cond_9
    throw v6
.end method

.method private conversationAtPosition(I)Lcom/android/mail/providers/Conversation;
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 62
    iget-object v2, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCallbacks:Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

    invoke-interface {v2}, Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v1

    .line 63
    .local v1, "cursor":Lcom/android/mail/browse/ConversationCursor;
    invoke-virtual {v1, p1}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    .line 64
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, v1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 65
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iput p1, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 66
    return-object v0
.end method

.method private getCount()I
    .locals 2

    .prologue
    .line 73
    iget-object v1, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCallbacks:Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

    invoke-interface {v1}, Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    .line 74
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    invoke-static {v0}, Lcom/android/mail/ui/ConversationPositionTracker;->isDataLoaded(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 75
    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->getCount()I

    move-result v1

    .line 77
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getNewer(Ljava/util/Collection;)Lcom/android/mail/providers/Conversation;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)",
            "Lcom/android/mail/providers/Conversation;"
        }
    .end annotation

    .prologue
    .local p1, "victims":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v2, 0x0

    .line 86
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationPositionTracker;->calculatePosition()I

    move-result v1

    .line 87
    .local v1, "pos":I
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationPositionTracker;->isDataLoaded()Z

    move-result v3

    if-eqz v3, :cond_0

    if-gez v1, :cond_2

    :cond_0
    move-object v0, v2

    .line 100
    :cond_1
    :goto_0
    return-object v0

    .line 92
    :cond_2
    add-int/lit8 v1, v1, -0x1

    .line 93
    :goto_1
    if-ltz v1, :cond_3

    .line 94
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationPositionTracker;->conversationAtPosition(I)Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 95
    .local v0, "candidate":Lcom/android/mail/providers/Conversation;
    invoke-static {p1, v0}, Lcom/android/mail/providers/Conversation;->contains(Ljava/util/Collection;Lcom/android/mail/providers/Conversation;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 98
    add-int/lit8 v1, v1, -0x1

    .line 99
    goto :goto_1

    .end local v0    # "candidate":Lcom/android/mail/providers/Conversation;
    :cond_3
    move-object v0, v2

    .line 100
    goto :goto_0
.end method

.method private getOlder(Ljava/util/Collection;)Lcom/android/mail/providers/Conversation;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)",
            "Lcom/android/mail/providers/Conversation;"
        }
    .end annotation

    .prologue
    .local p1, "victims":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v2, 0x0

    .line 108
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationPositionTracker;->calculatePosition()I

    move-result v1

    .line 109
    .local v1, "pos":I
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationPositionTracker;->isDataLoaded()Z

    move-result v3

    if-eqz v3, :cond_0

    if-gez v1, :cond_2

    :cond_0
    move-object v0, v2

    .line 122
    :cond_1
    :goto_0
    return-object v0

    .line 114
    :cond_2
    add-int/lit8 v1, v1, 0x1

    .line 115
    :goto_1
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationPositionTracker;->getCount()I

    move-result v3

    if-ge v1, v3, :cond_3

    .line 116
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationPositionTracker;->conversationAtPosition(I)Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 117
    .local v0, "candidate":Lcom/android/mail/providers/Conversation;
    invoke-static {p1, v0}, Lcom/android/mail/providers/Conversation;->contains(Ljava/util/Collection;Lcom/android/mail/providers/Conversation;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 120
    add-int/lit8 v1, v1, 0x1

    .line 121
    goto :goto_1

    .end local v0    # "candidate":Lcom/android/mail/providers/Conversation;
    :cond_3
    move-object v0, v2

    .line 122
    goto :goto_0
.end method

.method private isDataLoaded()Z
    .locals 2

    .prologue
    .line 144
    iget-object v1, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCallbacks:Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;

    invoke-interface {v1}, Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    .line 145
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    invoke-static {v0}, Lcom/android/mail/ui/ConversationPositionTracker;->isDataLoaded(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v1

    return v1
.end method

.method private static isDataLoaded(Lcom/android/mail/browse/ConversationCursor;)Z
    .locals 1
    .param p0, "cursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 140
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getNextConversation(ILjava/util/Collection;)Lcom/android/mail/providers/Conversation;
    .locals 10
    .param p1, "autoAdvance"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)",
            "Lcom/android/mail/providers/Conversation;"
        }
    .end annotation

    .prologue
    .local p2, "mTarget":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v9, 0x2

    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 243
    if-ne p1, v9, :cond_0

    move v0, v3

    .line 244
    .local v0, "getNewer":Z
    :goto_0
    if-ne p1, v3, :cond_1

    move v1, v3

    .line 245
    .local v1, "getOlder":Z
    :goto_1
    if-eqz v0, :cond_2

    invoke-direct {p0, p2}, Lcom/android/mail/ui/ConversationPositionTracker;->getNewer(Ljava/util/Collection;)Lcom/android/mail/providers/Conversation;

    move-result-object v2

    .line 247
    .local v2, "next":Lcom/android/mail/providers/Conversation;
    :goto_2
    sget-object v5, Lcom/android/mail/ui/ConversationPositionTracker;->LOG_TAG:Ljava/lang/String;

    const-string v6, "ConversationPositionTracker.getNextConversation: getNewer = %b, getOlder = %b, Next conversation is %s"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    aput-object v8, v7, v4

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v7, v3

    aput-object v2, v7, v9

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 250
    return-object v2

    .end local v0    # "getNewer":Z
    .end local v1    # "getOlder":Z
    .end local v2    # "next":Lcom/android/mail/providers/Conversation;
    :cond_0
    move v0, v4

    .line 243
    goto :goto_0

    .restart local v0    # "getNewer":Z
    :cond_1
    move v1, v4

    .line 244
    goto :goto_1

    .line 245
    .restart local v1    # "getOlder":Z
    :cond_2
    if-eqz v1, :cond_3

    invoke-direct {p0, p2}, Lcom/android/mail/ui/ConversationPositionTracker;->getOlder(Ljava/util/Collection;)Lcom/android/mail/providers/Conversation;

    move-result-object v2

    goto :goto_2

    :cond_3
    const/4 v2, 0x0

    goto :goto_2
.end method

.method public initialize(Lcom/android/mail/providers/Conversation;)V
    .locals 1
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 133
    iput-object p1, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mConversation:Lcom/android/mail/providers/Conversation;

    .line 134
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCursorDirty:Z

    .line 135
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationPositionTracker;->calculatePosition()I

    .line 136
    return-void
.end method

.method public onCursorUpdated()V
    .locals 1

    .prologue
    .line 152
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/ConversationPositionTracker;->mCursorDirty:Z

    .line 153
    return-void
.end method
