.class public Lcom/android/mail/browse/ConversationItemViewModel;
.super Ljava/lang/Object;
.source "ConversationItemViewModel.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;
    }
.end annotation


# static fields
.field private static sCachedModelsFolder:Lcom/android/mail/providers/Folder;

.field static sConversationHeaderMap:Landroid/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LruCache",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/android/mail/browse/ConversationItemViewModel;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public checkboxVisible:Z

.field public conversation:Lcom/android/mail/providers/Conversation;

.field dateBackground:Landroid/graphics/Bitmap;

.field dateText:Ljava/lang/String;

.field faded:Z

.field public folderDisplayer:Lcom/android/mail/browse/ConversationItemView$ConversationItemFolderDisplayer;

.field public hasBeenForwarded:Z

.field public hasBeenRepliedTo:Z

.field public isInvite:Z

.field private mContentDescription:Ljava/lang/String;

.field private mDataHashCode:I

.field private mLayoutHashCode:I

.field public messageInfoString:Landroid/text/SpannableStringBuilder;

.field paperclip:Landroid/graphics/Bitmap;

.field personalLevelBitmap:Landroid/graphics/Bitmap;

.field final senderFragments:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;",
            ">;"
        }
    .end annotation
.end field

.field sendersDisplayLayout:Landroid/text/StaticLayout;

.field sendersDisplayText:Landroid/text/SpannableStringBuilder;

.field sendersText:Ljava/lang/String;

.field public sendersTextView:Landroid/widget/TextView;

.field public standardScaledDimen:I

.field public styledMessageInfoStringOffset:I

.field public styledSenders:[Landroid/text/SpannableString;

.field public styledSendersString:Landroid/text/SpannableStringBuilder;

.field subjectText:Landroid/text/SpannableStringBuilder;

.field unread:Z

.field public viewWidth:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 57
    new-instance v0, Landroid/util/LruCache;

    const/16 v1, 0x64

    invoke-direct {v0, v1}, Landroid/util/LruCache;-><init>(I)V

    sput-object v0, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 193
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->faded:Z

    .line 194
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->senderFragments:Ljava/util/ArrayList;

    .line 195
    return-void
.end method

.method static forConversation(Ljava/lang/String;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/ConversationItemViewModel;
    .locals 6
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 150
    iget-wide v4, p1, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {p0, v4, v5}, Lcom/android/mail/browse/ConversationItemViewModel;->forConversationId(Ljava/lang/String;J)Lcom/android/mail/browse/ConversationItemViewModel;

    move-result-object v0

    .line 152
    .local v0, "header":Lcom/android/mail/browse/ConversationItemViewModel;
    if-eqz p1, :cond_0

    .line 153
    iput-boolean v3, v0, Lcom/android/mail/browse/ConversationItemViewModel;->faded:Z

    .line 154
    iput-boolean v2, v0, Lcom/android/mail/browse/ConversationItemViewModel;->checkboxVisible:Z

    .line 155
    iput-object p1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    .line 156
    iget-boolean v1, p1, Lcom/android/mail/providers/Conversation;->read:Z

    if-nez v1, :cond_1

    move v1, v2

    :goto_0
    iput-boolean v1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->unread:Z

    .line 157
    iget v1, p1, Lcom/android/mail/providers/Conversation;->convFlags:I

    and-int/lit8 v1, v1, 0x8

    const/16 v4, 0x8

    if-ne v1, v4, :cond_2

    move v1, v2

    :goto_1
    iput-boolean v1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->hasBeenForwarded:Z

    .line 160
    iget v1, p1, Lcom/android/mail/providers/Conversation;->convFlags:I

    and-int/lit8 v1, v1, 0x4

    const/4 v4, 0x4

    if-ne v1, v4, :cond_3

    move v1, v2

    :goto_2
    iput-boolean v1, v0, Lcom/android/mail/browse/ConversationItemViewModel;->hasBeenRepliedTo:Z

    .line 163
    iget v1, p1, Lcom/android/mail/providers/Conversation;->convFlags:I

    and-int/lit8 v1, v1, 0x10

    const/16 v4, 0x10

    if-ne v1, v4, :cond_4

    :goto_3
    iput-boolean v2, v0, Lcom/android/mail/browse/ConversationItemViewModel;->isInvite:Z

    .line 167
    :cond_0
    return-object v0

    :cond_1
    move v1, v3

    .line 156
    goto :goto_0

    :cond_2
    move v1, v3

    .line 157
    goto :goto_1

    :cond_3
    move v1, v3

    .line 160
    goto :goto_2

    :cond_4
    move v2, v3

    .line 163
    goto :goto_3
.end method

.method static forConversationId(Ljava/lang/String;J)Lcom/android/mail/browse/ConversationItemViewModel;
    .locals 4
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 181
    sget-object v3, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    monitor-enter v3

    .line 182
    :try_start_0
    invoke-static {p0, p1, p2}, Lcom/android/mail/browse/ConversationItemViewModel;->forConversationIdOrNull(Ljava/lang/String;J)Lcom/android/mail/browse/ConversationItemViewModel;

    move-result-object v0

    .line 184
    .local v0, "header":Lcom/android/mail/browse/ConversationItemViewModel;
    if-nez v0, :cond_0

    .line 185
    new-instance v1, Landroid/util/Pair;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {v1, p0, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 186
    .local v1, "key":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Long;>;"
    new-instance v0, Lcom/android/mail/browse/ConversationItemViewModel;

    .end local v0    # "header":Lcom/android/mail/browse/ConversationItemViewModel;
    invoke-direct {v0}, Lcom/android/mail/browse/ConversationItemViewModel;-><init>()V

    .line 187
    .restart local v0    # "header":Lcom/android/mail/browse/ConversationItemViewModel;
    sget-object v2, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    invoke-virtual {v2, v1, v0}, Landroid/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    .end local v1    # "key":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Long;>;"
    :cond_0
    monitor-exit v3

    return-object v0

    .line 190
    .end local v0    # "header":Lcom/android/mail/browse/ConversationItemViewModel;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method static forConversationIdOrNull(Ljava/lang/String;J)Lcom/android/mail/browse/ConversationItemViewModel;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "conversationId"    # J

    .prologue
    .line 139
    new-instance v0, Landroid/util/Pair;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 140
    .local v0, "key":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/Long;>;"
    sget-object v2, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    monitor-enter v2

    .line 141
    :try_start_0
    sget-object v1, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    invoke-virtual {v1, v0}, Landroid/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationItemViewModel;

    monitor-exit v2

    return-object v1

    .line 142
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method static forCursor(Ljava/lang/String;Landroid/database/Cursor;)Lcom/android/mail/browse/ConversationItemViewModel;
    .locals 1
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 146
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, p1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    invoke-static {p0, v0}, Lcom/android/mail/browse/ConversationItemViewModel;->forConversation(Ljava/lang/String;Lcom/android/mail/providers/Conversation;)Lcom/android/mail/browse/ConversationItemViewModel;

    move-result-object v0

    return-object v0
.end method

.method private getConvInfo()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 240
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v0, v0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v0, v0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0}, Lcom/android/mail/providers/Conversation;->getSnippet()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static getHashCode(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZZII)I
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "dateText"    # Ljava/lang/String;
    .param p2, "convInfo"    # Ljava/lang/Object;
    .param p3, "rawFolders"    # Ljava/lang/String;
    .param p4, "starred"    # Z
    .param p5, "read"    # Z
    .param p6, "priority"    # I
    .param p7, "sendingState"    # I

    .prologue
    .line 222
    if-nez p1, :cond_0

    .line 223
    const/4 v0, -0x1

    .line 228
    :goto_0
    return v0

    .line 225
    :cond_0
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 226
    const-string p3, ""

    .line 228
    :cond_1
    const/4 v0, 0x7

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    aput-object p2, v0, v1

    const/4 v1, 0x1

    aput-object p1, v0, v1

    const/4 v1, 0x2

    aput-object p3, v0, v1

    const/4 v1, 0x3

    invoke-static {p4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x4

    invoke-static {p5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x5

    invoke-static {p6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x6

    invoke-static {p7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    goto :goto_0
.end method

.method private getLayoutHashCode()I
    .locals 3

    .prologue
    .line 236
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget v2, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mDataHashCode:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget v2, p0, Lcom/android/mail/browse/ConversationItemViewModel;->viewWidth:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget v2, p0, Lcom/android/mail/browse/ConversationItemViewModel;->standardScaledDimen:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationItemViewModel;->checkboxVisible:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public static onAccessibilityUpdated()V
    .locals 1

    .prologue
    .line 364
    sget-object v0, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    invoke-virtual {v0}, Landroid/util/LruCache;->evictAll()V

    .line 365
    return-void
.end method

.method public static onFolderUpdated(Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p0, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 371
    sget-object v2, Lcom/android/mail/browse/ConversationItemViewModel;->sCachedModelsFolder:Lcom/android/mail/providers/Folder;

    if-eqz v2, :cond_1

    sget-object v2, Lcom/android/mail/browse/ConversationItemViewModel;->sCachedModelsFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 372
    .local v1, "old":Landroid/net/Uri;
    :goto_0
    if-eqz p0, :cond_2

    iget-object v0, p0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    .line 373
    .local v0, "newUri":Landroid/net/Uri;
    :goto_1
    invoke-virtual {v1, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 374
    sput-object p0, Lcom/android/mail/browse/ConversationItemViewModel;->sCachedModelsFolder:Lcom/android/mail/providers/Folder;

    .line 375
    sget-object v2, Lcom/android/mail/browse/ConversationItemViewModel;->sConversationHeaderMap:Landroid/util/LruCache;

    invoke-virtual {v2}, Landroid/util/LruCache;->evictAll()V

    .line 377
    :cond_0
    return-void

    .line 371
    .end local v0    # "newUri":Landroid/net/Uri;
    .end local v1    # "old":Landroid/net/Uri;
    :cond_1
    sget-object v1, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    goto :goto_0

    .line 372
    .restart local v1    # "old":Landroid/net/Uri;
    :cond_2
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    goto :goto_1
.end method


# virtual methods
.method addSenderFragment(IILandroid/text/style/CharacterStyle;Z)V
    .locals 6
    .param p1, "start"    # I
    .param p2, "end"    # I
    .param p3, "style"    # Landroid/text/style/CharacterStyle;
    .param p4, "isFixed"    # Z

    .prologue
    .line 206
    new-instance v0, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationItemViewModel;->sendersText:Ljava/lang/String;

    move v1, p1

    move v2, p2

    move-object v4, p3

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;-><init>(IILjava/lang/CharSequence;Landroid/text/style/CharacterStyle;Z)V

    .line 207
    .local v0, "senderFragment":Lcom/android/mail/browse/ConversationItemViewModel$SenderFragment;
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemViewModel;->senderFragments:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 208
    return-void
.end method

.method public getContentDescription(Landroid/content/Context;)Ljava/lang/CharSequence;
    .locals 12
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v9, -0x1

    .line 316
    iget-object v10, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mContentDescription:Ljava/lang/String;

    if-nez v10, :cond_3

    .line 320
    const-string v8, ""

    .line 321
    .local v8, "sender":Ljava/lang/String;
    iget-object v10, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v10, v10, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    if-eqz v10, :cond_2

    .line 322
    const-string v5, ""

    .line 323
    .local v5, "lastSender":Ljava/lang/String;
    iget-object v10, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v10, v10, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v10, v10, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    if-eqz v10, :cond_4

    iget-object v10, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v10, v10, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v10, v10, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v10}, Ljava/util/ArrayList;->size()I

    move-result v10

    add-int/lit8 v4, v10, -0x1

    .line 325
    .local v4, "last":I
    :goto_0
    if-eq v4, v9, :cond_0

    .line 326
    iget-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v9, v9, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v9, v9, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v9, v4}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/android/mail/providers/MessageInfo;

    iget-object v5, v9, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    .line 328
    :cond_0
    iget-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v9, v9, Lcom/android/mail/providers/Conversation;->read:Z

    if-eqz v9, :cond_6

    .line 329
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_5

    invoke-static {p1}, Lcom/android/mail/browse/SendersView;->getMe(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    .line 344
    :cond_1
    :goto_1
    invoke-static {v8}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 346
    move-object v8, v5

    .line 349
    .end local v4    # "last":I
    .end local v5    # "lastSender":Ljava/lang/String;
    :cond_2
    iget-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-wide v9, v9, Lcom/android/mail/providers/Conversation;->dateMs:J

    invoke-static {v9, v10}, Landroid/text/format/DateUtils;->isToday(J)Z

    move-result v3

    .line 350
    .local v3, "isToday":Z
    iget-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-wide v9, v9, Lcom/android/mail/providers/Conversation;->dateMs:J

    invoke-static {p1, v9, v10}, Landroid/text/format/DateUtils;->getRelativeTimeSpanString(Landroid/content/Context;J)Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 352
    .local v0, "date":Ljava/lang/String;
    if-eqz v3, :cond_a

    const v7, 0x7f0c0096

    .line 353
    .local v7, "res":I
    :goto_2
    const/4 v9, 0x4

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v8, v9, v10

    const/4 v10, 0x1

    iget-object v11, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v11, v11, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    aput-object v11, v9, v10

    const/4 v10, 0x2

    iget-object v11, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v11}, Lcom/android/mail/providers/Conversation;->getSnippet()Ljava/lang/String;

    move-result-object v11

    aput-object v11, v9, v10

    const/4 v10, 0x3

    aput-object v0, v9, v10

    invoke-virtual {p1, v7, v9}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    iput-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mContentDescription:Ljava/lang/String;

    .line 356
    .end local v0    # "date":Ljava/lang/String;
    .end local v3    # "isToday":Z
    .end local v7    # "res":I
    .end local v8    # "sender":Ljava/lang/String;
    :cond_3
    iget-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mContentDescription:Ljava/lang/String;

    return-object v9

    .restart local v5    # "lastSender":Ljava/lang/String;
    .restart local v8    # "sender":Ljava/lang/String;
    :cond_4
    move v4, v9

    .line 323
    goto :goto_0

    .restart local v4    # "last":I
    :cond_5
    move-object v8, v5

    .line 329
    goto :goto_1

    .line 332
    :cond_6
    const/4 v1, 0x0

    .line 333
    .local v1, "firstUnread":Lcom/android/mail/providers/MessageInfo;
    iget-object v9, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v9, v9, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    iget-object v9, v9, Lcom/android/mail/providers/ConversationInfo;->messageInfos:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_7
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/mail/providers/MessageInfo;

    .line 334
    .local v6, "m":Lcom/android/mail/providers/MessageInfo;
    iget-boolean v9, v6, Lcom/android/mail/providers/MessageInfo;->read:Z

    if-nez v9, :cond_7

    .line 335
    move-object v1, v6

    .line 339
    .end local v6    # "m":Lcom/android/mail/providers/MessageInfo;
    :cond_8
    if-eqz v1, :cond_1

    .line 340
    iget-object v9, v1, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    invoke-static {v9}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-eqz v9, :cond_9

    invoke-static {p1}, Lcom/android/mail/browse/SendersView;->getMe(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    :goto_3
    goto :goto_1

    :cond_9
    iget-object v8, v1, Lcom/android/mail/providers/MessageInfo;->sender:Ljava/lang/String;

    goto :goto_3

    .line 352
    .end local v1    # "firstUnread":Lcom/android/mail/providers/MessageInfo;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "last":I
    .end local v5    # "lastSender":Ljava/lang/String;
    .restart local v0    # "date":Ljava/lang/String;
    .restart local v3    # "isToday":Z
    :cond_a
    const v7, 0x7f0c0095

    goto :goto_2
.end method

.method isDataValid(Landroid/content/Context;)Z
    .locals 9
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 258
    iget v8, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mDataHashCode:I

    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemViewModel;->dateText:Ljava/lang/String;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemViewModel;->getConvInfo()Ljava/lang/Object;

    move-result-object v2

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0}, Lcom/android/mail/providers/Conversation;->getRawFoldersString()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v4, v0, Lcom/android/mail/providers/Conversation;->starred:Z

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v5, v0, Lcom/android/mail/providers/Conversation;->read:Z

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v6, v0, Lcom/android/mail/providers/Conversation;->priority:I

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v7, v0, Lcom/android/mail/providers/Conversation;->sendingState:I

    move-object v0, p1

    invoke-static/range {v0 .. v7}, Lcom/android/mail/browse/ConversationItemViewModel;->getHashCode(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZZII)I

    move-result v0

    if-ne v8, v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method isLayoutValid(Landroid/content/Context;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 267
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationItemViewModel;->isDataValid(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mLayoutHashCode:I

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemViewModel;->getLayoutHashCode()I

    move-result v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public resetContentDescription()V
    .locals 1

    .prologue
    .line 309
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mContentDescription:Ljava/lang/String;

    .line 310
    return-void
.end method

.method validate(Landroid/content/Context;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 248
    iget-object v1, p0, Lcom/android/mail/browse/ConversationItemViewModel;->dateText:Ljava/lang/String;

    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemViewModel;->getConvInfo()Ljava/lang/Object;

    move-result-object v2

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0}, Lcom/android/mail/providers/Conversation;->getRawFoldersString()Ljava/lang/String;

    move-result-object v3

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v4, v0, Lcom/android/mail/providers/Conversation;->starred:Z

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v5, v0, Lcom/android/mail/providers/Conversation;->read:Z

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v6, v0, Lcom/android/mail/providers/Conversation;->priority:I

    iget-object v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget v7, v0, Lcom/android/mail/providers/Conversation;->sendingState:I

    move-object v0, p1

    invoke-static/range {v0 .. v7}, Lcom/android/mail/browse/ConversationItemViewModel;->getHashCode(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/String;ZZII)I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mDataHashCode:I

    .line 251
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationItemViewModel;->getLayoutHashCode()I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/ConversationItemViewModel;->mLayoutHashCode:I

    .line 252
    return-void
.end method
