.class public final Lcom/android/mail/browse/ConversationCursor;
.super Ljava/lang/Object;
.source "ConversationCursor.java"

# interfaces
.implements Landroid/database/Cursor;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationCursor$ConversationListener;,
        Lcom/android/mail/browse/ConversationCursor$ConversationOperation;,
        Lcom/android/mail/browse/ConversationCursor$ConversationProvider;,
        Lcom/android/mail/browse/ConversationCursor$CursorObserver;,
        Lcom/android/mail/browse/ConversationCursor$RefreshTask;
    }
.end annotation


# static fields
.field private static final EMPTY_DELETION_LIST:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field static sProvider:Lcom/android/mail/browse/ConversationCursor$ConversationProvider;

.field private static sResolver:Landroid/content/ContentResolver;

.field private static sSequence:I

.field private static sUriColumnIndex:I


# instance fields
.field private mCacheMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/content/ContentValues;",
            ">;"
        }
    .end annotation
.end field

.field private mCacheMapLock:Ljava/lang/Object;

.field private mColumnNames:[Ljava/lang/String;

.field private final mCursorObserver:Lcom/android/mail/browse/ConversationCursor$CursorObserver;

.field private mCursorObserverRegistered:Z

.field private mDeferSync:Z

.field private mDeletedCount:I

.field private mInitialConversationLimit:Z

.field private mListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/browse/ConversationCursor$ConversationListener;",
            ">;"
        }
    .end annotation
.end field

.field private final mName:Ljava/lang/String;

.field private mPaused:Z

.field private mPosition:I

.field private mRefreshReady:Z

.field private mRefreshRequired:Z

.field private mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

.field private volatile mRequeryCursor:Landroid/database/Cursor;

.field mUnderlyingCursor:Landroid/database/Cursor;

.field private qProjection:[Ljava/lang/String;

.field private qUri:Landroid/net/Uri;

.field private sMostlyDead:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationCursor;->EMPTY_DELETION_LIST:Ljava/util/Collection;

    .line 82
    const/4 v0, 0x0

    sput v0, Lcom/android/mail/browse/ConversationCursor;->sSequence:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/net/Uri;ZLjava/lang/String;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "initialConversationLimit"    # Z
    .param p4, "name"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 146
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 94
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    .line 96
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    .line 98
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    .line 103
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z

    .line 105
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshRequired:Z

    .line 107
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    .line 109
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->sMostlyDead:Ljava/util/List;

    .line 117
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z

    .line 119
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    .line 121
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    .line 124
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 127
    iput v1, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    .line 147
    iput-boolean p3, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    .line 148
    invoke-virtual {p1}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;

    .line 149
    const/4 v0, 0x1

    sput v0, Lcom/android/mail/browse/ConversationCursor;->sUriColumnIndex:I

    .line 150
    iput-object p2, p0, Lcom/android/mail/browse/ConversationCursor;->qUri:Landroid/net/Uri;

    .line 151
    iput-object p4, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    .line 152
    sget-object v0, Lcom/android/mail/providers/UIProvider;->CONVERSATION_PROJECTION:[Ljava/lang/String;

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->qProjection:[Ljava/lang/String;

    .line 153
    new-instance v0, Lcom/android/mail/browse/ConversationCursor$CursorObserver;

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-direct {v0, p0, v1}, Lcom/android/mail/browse/ConversationCursor$CursorObserver;-><init>(Lcom/android/mail/browse/ConversationCursor;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserver:Lcom/android/mail/browse/ConversationCursor$CursorObserver;

    .line 154
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/browse/ConversationCursor;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/android/mail/browse/ConversationCursor;Z)Landroid/database/Cursor;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;
    .param p1, "x1"    # Z

    .prologue
    .line 62
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->doQuery(Z)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1000(Landroid/net/Uri;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Landroid/net/Uri;

    .prologue
    .line 62
    invoke-static {p0}, Lcom/android/mail/browse/ConversationCursor;->uriFromCachingUri(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1100()Landroid/content/ContentResolver;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;

    return-object v0
.end method

.method static synthetic access$1200()I
    .locals 1

    .prologue
    .line 62
    sget v0, Lcom/android/mail/browse/ConversationCursor;->sSequence:I

    return v0
.end method

.method static synthetic access$1208()I
    .locals 2

    .prologue
    .line 62
    sget v0, Lcom/android/mail/browse/ConversationCursor;->sSequence:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Lcom/android/mail/browse/ConversationCursor;->sSequence:I

    return v0
.end method

.method static synthetic access$1300(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Landroid/net/Uri;

    .prologue
    .line 62
    invoke-static {p0}, Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1400(Lcom/android/mail/browse/ConversationCursor;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Ljava/lang/Object;

    .prologue
    .line 62
    invoke-direct {p0, p1, p2, p3}, Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    return-void
.end method

.method static synthetic access$1500(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->recalibratePosition()V

    return-void
.end method

.method static synthetic access$1600(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyDataChanged()V

    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/browse/ConversationCursor;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$302(Lcom/android/mail/browse/ConversationCursor;Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;
    .param p1, "x1"    # Landroid/database/Cursor;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/android/mail/browse/ConversationCursor;->mRequeryCursor:Landroid/database/Cursor;

    return-object p1
.end method

.method static synthetic access$402(Lcom/android/mail/browse/ConversationCursor;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;
    .param p1, "x1"    # Z

    .prologue
    .line 62
    iput-boolean p1, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z

    return p1
.end method

.method static synthetic access$500(Lcom/android/mail/browse/ConversationCursor;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    return v0
.end method

.method static synthetic access$600(Lcom/android/mail/browse/ConversationCursor;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    return v0
.end method

.method static synthetic access$700(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyRefreshReady()V

    return-void
.end method

.method static synthetic access$900(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    .line 62
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->underlyingChanged()V

    return-void
.end method

.method private apply(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationCursor$ConversationOperation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1620
    .local p2, "operations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationCursor$ConversationOperation;>;"
    sget-object v0, Lcom/android/mail/browse/ConversationCursor;->sProvider:Lcom/android/mail/browse/ConversationCursor$ConversationProvider;

    invoke-virtual {v0, p2, p0}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->apply(Ljava/util/Collection;Lcom/android/mail/browse/ConversationCursor;)I

    move-result v0

    return v0
.end method

.method private applyAction(Landroid/content/Context;Ljava/util/Collection;I)I
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "opAction"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;I)I"
        }
    .end annotation

    .prologue
    .line 1741
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    .line 1742
    .local v3, "ops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/browse/ConversationCursor$ConversationOperation;>;"
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1743
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    new-instance v2, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;

    invoke-direct {v2, p0, p3, v0}, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;-><init>(Lcom/android/mail/browse/ConversationCursor;ILcom/android/mail/providers/Conversation;)V

    .line 1745
    .local v2, "op":Lcom/android/mail/browse/ConversationCursor$ConversationOperation;
    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1747
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    .end local v2    # "op":Lcom/android/mail/browse/ConversationCursor$ConversationOperation;
    :cond_0
    invoke-direct {p0, p1, v3}, Lcom/android/mail/browse/ConversationCursor;->apply(Landroid/content/Context;Ljava/util/Collection;)I

    move-result v4

    return v4
.end method

.method private cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 13
    .param p1, "uriString"    # Ljava/lang/String;
    .param p2, "columnName"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 442
    invoke-static {}, Lcom/android/mail/browse/ConversationCursor;->offUiThread()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 443
    const-string v5, "ConversationCursor"

    new-instance v8, Ljava/lang/Error;

    invoke-direct {v8}, Ljava/lang/Error;-><init>()V

    const-string v9, "cacheValue incorrectly being called from non-UI thread"

    new-array v10, v7, [Ljava/lang/Object;

    invoke-static {v5, v8, v9, v10}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 446
    :cond_0
    iget-object v8, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v8

    .line 448
    :try_start_0
    iget-object v5, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v5, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/content/ContentValues;

    .line 450
    .local v3, "map":Landroid/content/ContentValues;
    if-nez v3, :cond_1

    .line 451
    new-instance v3, Landroid/content/ContentValues;

    .end local v3    # "map":Landroid/content/ContentValues;
    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 452
    .restart local v3    # "map":Landroid/content/ContentValues;
    iget-object v5, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v5, p1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 455
    :cond_1
    const-string v5, "__deleted__"

    if-ne p2, v5, :cond_2

    .line 456
    move-object/from16 v0, p3

    check-cast v0, Ljava/lang/Boolean;

    move-object v5, v0

    invoke-virtual {v5}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    .line 457
    .local v4, "state":Z
    invoke-virtual {v3, p2}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_4

    move v2, v6

    .line 458
    .local v2, "hasValue":Z
    :goto_0
    if-eqz v4, :cond_5

    if-nez v2, :cond_5

    .line 459
    iget v5, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    add-int/lit8 v5, v5, 0x1

    iput v5, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    .line 461
    const-string v5, "ConversationCursor"

    const-string v9, "Deleted %s, incremented deleted count=%d"

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    aput-object p1, v10, v11

    const/4 v11, 0x1

    iget v12, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v5, v9, v10}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 484
    .end local v2    # "hasValue":Z
    .end local v4    # "state":Z
    :cond_2
    move-object/from16 v0, p3

    instance-of v5, v0, Ljava/lang/Boolean;

    if-eqz v5, :cond_8

    .line 485
    check-cast p3, Ljava/lang/Boolean;

    .end local p3    # "value":Ljava/lang/Object;
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v5

    if-eqz v5, :cond_7

    move v5, v6

    :goto_1
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v3, p2, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 495
    :goto_2
    const-string v5, "__updatetime__"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-virtual {v3, v5, v6}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 496
    const-string v5, "__deleted__"

    if-eq p2, v5, :cond_3

    .line 497
    const-string v5, "ConversationCursor"

    const-string v6, "Caching value for %s: %s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p1, v7, v9

    const/4 v9, 0x1

    aput-object p2, v7, v9

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 499
    :cond_3
    monitor-exit v8

    .line 500
    :goto_3
    return-void

    .restart local v4    # "state":Z
    .restart local p3    # "value":Ljava/lang/Object;
    :cond_4
    move v2, v7

    .line 457
    goto :goto_0

    .line 464
    .restart local v2    # "hasValue":Z
    :cond_5
    if-nez v4, :cond_6

    if-eqz v2, :cond_6

    .line 465
    iget v5, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    add-int/lit8 v5, v5, -0x1

    iput v5, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    .line 466
    invoke-virtual {v3, p2}, Landroid/content/ContentValues;->remove(Ljava/lang/String;)V

    .line 468
    const-string v5, "ConversationCursor"

    const-string v6, "Undeleted %s, decremented deleted count=%d"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p1, v7, v9

    const/4 v9, 0x1

    iget v10, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v7, v9

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 471
    monitor-exit v8

    goto :goto_3

    .line 499
    .end local v2    # "hasValue":Z
    .end local v3    # "map":Landroid/content/ContentValues;
    .end local v4    # "state":Z
    .end local p3    # "value":Ljava/lang/Object;
    :catchall_0
    move-exception v5

    monitor-exit v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5

    .line 472
    .restart local v2    # "hasValue":Z
    .restart local v3    # "map":Landroid/content/ContentValues;
    .restart local v4    # "state":Z
    .restart local p3    # "value":Ljava/lang/Object;
    :cond_6
    if-nez v4, :cond_2

    .line 475
    :try_start_1
    const-string v5, "ConversationCursor"

    const-string v6, "Undeleted %s, IGNORING, deleted count=%d"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v9, 0x0

    aput-object p1, v7, v9

    const/4 v9, 0x1

    iget v10, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    aput-object v10, v7, v9

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 478
    monitor-exit v8

    goto :goto_3

    .end local v2    # "hasValue":Z
    .end local v4    # "state":Z
    .end local p3    # "value":Ljava/lang/Object;
    :cond_7
    move v5, v7

    .line 485
    goto :goto_1

    .line 486
    .restart local p3    # "value":Ljava/lang/Object;
    :cond_8
    move-object/from16 v0, p3

    instance-of v5, v0, Ljava/lang/Integer;

    if-eqz v5, :cond_9

    .line 487
    check-cast p3, Ljava/lang/Integer;

    .end local p3    # "value":Ljava/lang/Object;
    move-object/from16 v0, p3

    invoke-virtual {v3, p2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    goto :goto_2

    .line 488
    .restart local p3    # "value":Ljava/lang/Object;
    :cond_9
    move-object/from16 v0, p3

    instance-of v5, v0, Ljava/lang/String;

    if-eqz v5, :cond_a

    .line 489
    check-cast p3, Ljava/lang/String;

    .end local p3    # "value":Ljava/lang/Object;
    move-object/from16 v0, p3

    invoke-virtual {v3, p2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 491
    .restart local p3    # "value":Ljava/lang/Object;
    :cond_a
    invoke-virtual/range {p3 .. p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    .line 492
    .local v1, "cname":Ljava/lang/String;
    new-instance v5, Ljava/lang/IllegalArgumentException;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Value class not compatible with cache: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0
.end method

.method private checkNotifyUI()V
    .locals 5

    .prologue
    .line 205
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    if-nez v0, :cond_2

    .line 206
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshRequired:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    if-nez v0, :cond_1

    .line 207
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyRefreshRequired()V

    .line 215
    :cond_0
    :goto_0
    return-void

    .line 208
    :cond_1
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z

    if-eqz v0, :cond_0

    .line 209
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyRefreshReady()V

    goto :goto_0

    .line 212
    :cond_2
    const-string v1, "ConversationCursor"

    const-string v2, "[checkNotifyUI: %s%s"

    const/4 v0, 0x2

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    if-eqz v0, :cond_3

    const-string v0, "Paused "

    :goto_1
    aput-object v0, v3, v4

    const/4 v4, 0x1

    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    if-eqz v0, :cond_4

    const-string v0, "Defer"

    :goto_2
    aput-object v0, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    :cond_3
    const-string v0, ""

    goto :goto_1

    :cond_4
    const-string v0, ""

    goto :goto_2
.end method

.method private doQuery(Z)Landroid/database/Cursor;
    .locals 9
    .param p1, "withLimit"    # Z

    .prologue
    const/4 v3, 0x0

    .line 269
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->qUri:Landroid/net/Uri;

    .line 270
    .local v1, "uri":Landroid/net/Uri;
    if-eqz p1, :cond_0

    .line 271
    invoke-virtual {v1}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    const-string v2, "limit"

    const-string v4, "50"

    invoke-virtual {v0, v2, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v1

    .line 274
    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    .line 276
    .local v7, "time":J
    sget-object v0, Lcom/android/mail/browse/ConversationCursor;->sResolver:Landroid/content/ContentResolver;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->qProjection:[Ljava/lang/String;

    move-object v4, v3

    move-object v5, v3

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 277
    .local v6, "result":Landroid/database/Cursor;
    if-nez v6, :cond_1

    .line 278
    const-string v0, "ConversationCursor"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "doQuery returning null cursor, uri: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 284
    :goto_0
    return-object v6

    .line 280
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    sub-long v7, v2, v7

    .line 281
    const-string v0, "ConversationCursor"

    const-string v2, "ConversationCursor query: %s, %dms, %d results"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v1, v3, v4

    const/4 v4, 0x1

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-interface {v6}, Landroid/database/Cursor;->getCount()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method private getCachedValue(I)Ljava/lang/Object;
    .locals 3
    .param p1, "columnIndex"    # I

    .prologue
    .line 508
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    sget v2, Lcom/android/mail/browse/ConversationCursor;->sUriColumnIndex:I

    invoke-interface {v1, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 509
    .local v0, "uri":Ljava/lang/String;
    invoke-direct {p0, v0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(Ljava/lang/String;I)Ljava/lang/Object;

    move-result-object v1

    return-object v1
.end method

.method private getCachedValue(Ljava/lang/String;I)Ljava/lang/Object;
    .locals 3
    .param p1, "uri"    # Ljava/lang/String;
    .param p2, "columnIndex"    # I

    .prologue
    .line 513
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v2, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/ContentValues;

    .line 514
    .local v1, "uriMap":Landroid/content/ContentValues;
    if-eqz v1, :cond_1

    .line 516
    const/4 v2, -0x1

    if-ne p2, v2, :cond_0

    .line 517
    const-string v0, "__deleted__"

    .line 521
    .local v0, "columnName":Ljava/lang/String;
    :goto_0
    invoke-virtual {v1, v0}, Landroid/content/ContentValues;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    .line 523
    .end local v0    # "columnName":Ljava/lang/String;
    :goto_1
    return-object v2

    .line 519
    :cond_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mColumnNames:[Ljava/lang/String;

    aget-object v0, v2, p2

    .restart local v0    # "columnName":Ljava/lang/String;
    goto :goto_0

    .line 523
    .end local v0    # "columnName":Ljava/lang/String;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private getOperationsForConversations(Ljava/util/Collection;ILandroid/content/ContentValues;)Ljava/util/ArrayList;
    .locals 4
    .param p2, "type"    # I
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;I",
            "Landroid/content/ContentValues;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/browse/ConversationCursor$ConversationOperation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 1573
    .local p1, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v2

    .line 1574
    .local v2, "ops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/browse/ConversationCursor$ConversationOperation;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1575
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    invoke-virtual {p0, v0, p2, p3}, Lcom/android/mail/browse/ConversationCursor;->getOperationForConversation(Lcom/android/mail/providers/Conversation;ILandroid/content/ContentValues;)Lcom/android/mail/browse/ConversationCursor$ConversationOperation;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1577
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_0
    return-object v2
.end method

.method private notifyDataChanged()V
    .locals 7

    .prologue
    .line 582
    const-string v2, "ConversationCursor"

    const-string v3, "[Notify %s: onDataSetChanged()]"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 584
    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    monitor-enter v3

    .line 585
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationCursor$ConversationListener;

    .line 586
    .local v1, "listener":Lcom/android/mail/browse/ConversationCursor$ConversationListener;
    invoke-interface {v1}, Lcom/android/mail/browse/ConversationCursor$ConversationListener;->onDataSetChanged()V

    goto :goto_0

    .line 588
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/android/mail/browse/ConversationCursor$ConversationListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 589
    return-void
.end method

.method private notifyRefreshReady()V
    .locals 7

    .prologue
    .line 567
    const-string v2, "ConversationCursor"

    const-string v3, "[Notify %s: onRefreshReady(), %d listeners]"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 570
    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    monitor-enter v3

    .line 571
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationCursor$ConversationListener;

    .line 572
    .local v1, "listener":Lcom/android/mail/browse/ConversationCursor$ConversationListener;
    invoke-interface {v1}, Lcom/android/mail/browse/ConversationCursor$ConversationListener;->onRefreshReady()V

    goto :goto_0

    .line 574
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/android/mail/browse/ConversationCursor$ConversationListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 575
    return-void
.end method

.method private notifyRefreshRequired()V
    .locals 7

    .prologue
    .line 551
    const-string v2, "ConversationCursor"

    const-string v3, "[Notify %s: onRefreshRequired()]"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 553
    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    if-nez v2, :cond_1

    .line 554
    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    monitor-enter v3

    .line 555
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationCursor$ConversationListener;

    .line 556
    .local v1, "listener":Lcom/android/mail/browse/ConversationCursor$ConversationListener;
    invoke-interface {v1}, Lcom/android/mail/browse/ConversationCursor$ConversationListener;->onRefreshRequired()V

    goto :goto_0

    .line 558
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/android/mail/browse/ConversationCursor$ConversationListener;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 560
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method static offUiThread()Z
    .locals 2

    .prologue
    .line 288
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private recalibratePosition()V
    .locals 1

    .prologue
    .line 816
    iget v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 817
    .local v0, "pos":I
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->moveToFirst()Z

    .line 818
    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    .line 819
    return-void
.end method

.method private resetCursor(Landroid/database/Cursor;)V
    .locals 14
    .param p1, "newCursor"    # Landroid/database/Cursor;

    .prologue
    .line 299
    iget-object v9, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v9

    .line 301
    :try_start_0
    iget-object v8, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v8}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 302
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;>;"
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 303
    .local v3, "now":J
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 304
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 305
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/ContentValues;

    .line 306
    .local v7, "values":Landroid/content/ContentValues;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 307
    .local v2, "key":Ljava/lang/String;
    const-string v8, "__updatetime__"

    invoke-virtual {v7, v8}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    .line 308
    .local v5, "updateTime":J
    sub-long v10, v3, v5

    const-wide/16 v12, 0x2710

    cmp-long v8, v10, v12

    if-gez v8, :cond_0

    .line 309
    const-string v8, "ConversationCursor"

    const-string v10, "IN resetCursor, keep recent changes to %s"

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v2, v11, v12

    invoke-static {v8, v10, v11}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 335
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;>;"
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "now":J
    .end local v5    # "updateTime":J
    .end local v7    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v8

    monitor-exit v9
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v8

    .line 312
    .restart local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    .restart local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;>;"
    .restart local v2    # "key":Ljava/lang/String;
    .restart local v3    # "now":J
    .restart local v5    # "updateTime":J
    .restart local v7    # "values":Landroid/content/ContentValues;
    :cond_0
    :try_start_1
    const-string v8, "__deleted__"

    invoke-virtual {v7, v8}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 314
    iget v8, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    add-int/lit8 v8, v8, -0x1

    iput v8, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    .line 315
    const-string v8, "ConversationCursor"

    const-string v10, "IN resetCursor, sDeletedCount decremented to: %d by %s"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    iget v13, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    aput-object v13, v11, v12

    const/4 v12, 0x1

    aput-object v2, v11, v12

    invoke-static {v8, v10, v11}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 319
    :cond_1
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 323
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    .end local v2    # "key":Ljava/lang/String;
    .end local v5    # "updateTime":J
    .end local v7    # "values":Landroid/content/ContentValues;
    :cond_2
    iget-object v8, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-eqz v8, :cond_3

    .line 324
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->close()V

    .line 326
    :cond_3
    iput-object p1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    .line 328
    const/4 v8, -0x1

    iput v8, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 329
    iget-object v8, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    iget v10, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    invoke-interface {v8, v10}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 330
    iget-boolean v8, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z

    if-nez v8, :cond_4

    .line 331
    iget-object v8, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    iget-object v10, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserver:Lcom/android/mail/browse/ConversationCursor$CursorObserver;

    invoke-interface {v8, v10}, Landroid/database/Cursor;->registerContentObserver(Landroid/database/ContentObserver;)V

    .line 332
    const/4 v8, 0x1

    iput-boolean v8, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z

    .line 334
    :cond_4
    const/4 v8, 0x0

    iput-boolean v8, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshRequired:Z

    .line 335
    monitor-exit v9
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 336
    return-void
.end method

.method private setCursor(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v1, 0x0

    .line 135
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 136
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->close()V

    .line 138
    :cond_0
    invoke-interface {p1}, Landroid/database/Cursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mColumnNames:[Ljava/lang/String;

    .line 139
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshRequired:Z

    .line 140
    iput-boolean v1, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z

    .line 141
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    .line 142
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->resetCursor(Landroid/database/Cursor;)V

    .line 143
    return-void
.end method

.method private underlyingChanged()V
    .locals 3

    .prologue
    .line 530
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v1

    .line 531
    :try_start_0
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    .line 533
    :try_start_1
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserver:Lcom/android/mail/browse/ConversationCursor$CursorObserver;

    invoke-interface {v0, v2}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V
    :try_end_1
    .catch Ljava/lang/IllegalStateException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 537
    :goto_0
    const/4 v0, 0x0

    :try_start_2
    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z

    .line 539
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshRequired:Z

    .line 540
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    if-nez v0, :cond_1

    .line 541
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyRefreshRequired()V

    .line 543
    :cond_1
    monitor-exit v1

    .line 544
    return-void

    .line 543
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 534
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method private undoLocal()V
    .locals 1

    .prologue
    .line 1624
    sget-object v0, Lcom/android/mail/browse/ConversationCursor;->sProvider:Lcom/android/mail/browse/ConversationCursor$ConversationProvider;

    invoke-virtual {v0, p0}, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->undo(Lcom/android/mail/browse/ConversationCursor;)V

    .line 1625
    return-void
.end method

.method private static uriFromCachingUri(Landroid/net/Uri;)Landroid/net/Uri;
    .locals 6
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 406
    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    .line 408
    .local v0, "authority":Ljava/lang/String;
    sget-object v4, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 416
    .end local p0    # "uri":Landroid/net/Uri;
    :goto_0
    return-object p0

    .line 411
    .restart local p0    # "uri":Landroid/net/Uri;
    :cond_0
    invoke-virtual {p0}, Landroid/net/Uri;->getPathSegments()Ljava/util/List;

    move-result-object v3

    .line 412
    .local v3, "path":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v4, Landroid/net/Uri$Builder;

    invoke-direct {v4}, Landroid/net/Uri$Builder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/net/Uri$Builder;->scheme(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v5

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v4}, Landroid/net/Uri$Builder;->authority(Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v1

    .line 413
    .local v1, "builder":Landroid/net/Uri$Builder;
    const/4 v2, 0x1

    .local v2, "i":I
    :goto_1
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 414
    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v1, v4}, Landroid/net/Uri$Builder;->appendPath(Ljava/lang/String;)Landroid/net/Uri$Builder;

    .line 413
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 416
    :cond_1
    invoke-virtual {v1}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object p0

    goto :goto_0
.end method

.method private static uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;
    .locals 2
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 420
    invoke-static {p0}, Lcom/android/mail/browse/ConversationCursor;->uriFromCachingUri(Landroid/net/Uri;)Landroid/net/Uri;

    move-result-object v0

    .line 422
    .local v0, "underlyingUri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static uriToCachingUriString(Landroid/net/Uri;)Ljava/lang/String;
    .locals 3
    .param p0, "uri"    # Landroid/net/Uri;

    .prologue
    .line 394
    invoke-virtual {p0}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    .line 395
    .local v0, "provider":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "://"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/android/mail/browse/ConversationCursor$ConversationProvider;->AUTHORITY:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method


# virtual methods
.method public addListener(Lcom/android/mail/browse/ConversationCursor$ConversationListener;)V
    .locals 4
    .param p1, "listener"    # Lcom/android/mail/browse/ConversationCursor$ConversationListener;

    .prologue
    .line 367
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    monitor-enter v1

    .line 368
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 369
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 373
    :goto_0
    monitor-exit v1

    .line 374
    return-void

    .line 371
    :cond_0
    const-string v0, "ConversationCursor"

    const-string v2, "Ignoring duplicate add of listener"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 373
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public archive(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1653
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x3

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method clearMostlyDead(Ljava/lang/String;)Z
    .locals 4
    .param p1, "uriString"    # Ljava/lang/String;

    .prologue
    .line 1168
    const/16 v2, 0xf

    invoke-direct {p0, p1, v2}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(Ljava/lang/String;I)Ljava/lang/Object;

    move-result-object v1

    .line 1170
    .local v1, "val":Ljava/lang/Object;
    if-eqz v1, :cond_0

    .line 1171
    check-cast v1, Ljava/lang/Integer;

    .end local v1    # "val":Ljava/lang/Object;
    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 1172
    .local v0, "flags":I
    and-int/lit8 v2, v0, 0x1

    if-eqz v2, :cond_0

    .line 1173
    const-string v2, "conversationFlags"

    and-int/lit8 v0, v0, -0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-direct {p0, p1, v2, v3}, Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 1175
    const/4 v2, 0x1

    .line 1178
    .end local v0    # "flags":I
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public close()V
    .locals 2

    .prologue
    .line 686
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_1

    .line 688
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z

    if-eqz v0, :cond_0

    .line 690
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserver:Lcom/android/mail/browse/ConversationCursor$CursorObserver;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->unregisterContentObserver(Landroid/database/ContentObserver;)V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 694
    :goto_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCursorObserverRegistered:Z

    .line 696
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 698
    :cond_1
    return-void

    .line 691
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method commitMostlyDead(Lcom/android/mail/providers/Conversation;)V
    .locals 5
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v4, 0x0

    .line 1158
    iget v0, p1, Lcom/android/mail/providers/Conversation;->convFlags:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p1, Lcom/android/mail/providers/Conversation;->convFlags:I

    .line 1159
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->sMostlyDead:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 1160
    const-string v0, "ConversationCursor"

    const-string v1, "[All dead: %s]"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p1, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1161
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->sMostlyDead:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1162
    iput-boolean v4, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    .line 1163
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->checkNotifyUI()V

    .line 1165
    :cond_0
    return-void
.end method

.method public copyStringToBuffer(ILandroid/database/CharArrayBuffer;)V
    .locals 1
    .param p1, "columnIndex"    # I
    .param p2, "buffer"    # Landroid/database/CharArrayBuffer;

    .prologue
    .line 1408
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public deactivate()V
    .locals 1

    .prologue
    .line 1423
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public delete(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1646
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public disable()V
    .locals 1

    .prologue
    .line 678
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->close()V

    .line 679
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    .line 680
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 681
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    .line 682
    return-void
.end method

.method public discardDrafts(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1688
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/16 v0, 0x8

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public getBlob(I)[B
    .locals 2
    .param p1, "columnIndex"    # I

    .prologue
    .line 885
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 886
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    check-cast v0, [B

    .end local v0    # "obj":Ljava/lang/Object;
    check-cast v0, [B

    .line 887
    :goto_0
    return-object v0

    .restart local v0    # "obj":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v0

    goto :goto_0
.end method

.method public getColumnCount()I
    .locals 1

    .prologue
    .line 1403
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getColumnCount()I

    move-result v0

    return v0
.end method

.method public getColumnIndex(Ljava/lang/String;)I
    .locals 1
    .param p1, "columnName"    # Ljava/lang/String;

    .prologue
    .line 1383
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getColumnIndexOrThrow(Ljava/lang/String;)I
    .locals 1
    .param p1, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 1388
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getColumnName(I)Ljava/lang/String;
    .locals 1
    .param p1, "columnIndex"    # I

    .prologue
    .line 1393
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->getColumnName(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getColumnNames()[Ljava/lang/String;
    .locals 1

    .prologue
    .line 1398
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getColumnNames()[Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getCount()I
    .locals 3

    .prologue
    .line 748
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-nez v0, :cond_0

    .line 749
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "getCount() on disabled cursor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->qUri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 752
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    iget v1, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    sub-int/2addr v0, v1

    return v0
.end method

.method public getDeletedItems()Ljava/util/Set;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 344
    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v6

    .line 346
    :try_start_0
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v1

    .line 347
    .local v1, "deletedItems":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v5, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMap:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 349
    .local v3, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;>;"
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 350
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/util/Map$Entry;

    .line 351
    .local v2, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    invoke-interface {v2}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/content/ContentValues;

    .line 352
    .local v4, "values":Landroid/content/ContentValues;
    const-string v5, "__deleted__"

    invoke-virtual {v4, v5}, Landroid/content/ContentValues;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 355
    invoke-interface {v2}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 356
    .local v0, "conversationUri":Landroid/net/Uri;
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->uriToCachingUriString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v1, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 360
    .end local v0    # "conversationUri":Landroid/net/Uri;
    .end local v1    # "deletedItems":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v2    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;"
    .end local v3    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;>;"
    .end local v4    # "values":Landroid/content/ContentValues;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5

    .line 359
    .restart local v1    # "deletedItems":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/util/Map$Entry<Ljava/lang/String;Landroid/content/ContentValues;>;>;"
    :cond_1
    :try_start_1
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-object v1
.end method

.method public getDouble(I)D
    .locals 3
    .param p1, "columnIndex"    # I

    .prologue
    .line 837
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 838
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    check-cast v0, Ljava/lang/Double;

    .end local v0    # "obj":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v1

    .line 839
    :goto_0
    return-wide v1

    .restart local v0    # "obj":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->getDouble(I)D

    move-result-wide v1

    goto :goto_0
.end method

.method public getExtras()Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 1464
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    goto :goto_0
.end method

.method public getFloat(I)F
    .locals 2
    .param p1, "columnIndex"    # I

    .prologue
    .line 844
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 845
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    check-cast v0, Ljava/lang/Float;

    .end local v0    # "obj":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Float;->floatValue()F

    move-result v1

    .line 846
    :goto_0
    return v1

    .restart local v0    # "obj":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->getFloat(I)F

    move-result v1

    goto :goto_0
.end method

.method public getInt(I)I
    .locals 2
    .param p1, "columnIndex"    # I

    .prologue
    .line 851
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 852
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    check-cast v0, Ljava/lang/Integer;

    .end local v0    # "obj":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 853
    :goto_0
    return v1

    .restart local v0    # "obj":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    goto :goto_0
.end method

.method public getLong(I)J
    .locals 3
    .param p1, "columnIndex"    # I

    .prologue
    .line 858
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 859
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    check-cast v0, Ljava/lang/Long;

    .end local v0    # "obj":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v1

    .line 860
    :goto_0
    return-wide v1

    .restart local v0    # "obj":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    goto :goto_0
.end method

.method public getOperationForConversation(Lcom/android/mail/providers/Conversation;ILandroid/content/ContentValues;)Lcom/android/mail/browse/ConversationCursor$ConversationOperation;
    .locals 1
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p2, "type"    # I
    .param p3, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 1582
    new-instance v0, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;

    invoke-direct {v0, p0, p2, p1, p3}, Lcom/android/mail/browse/ConversationCursor$ConversationOperation;-><init>(Lcom/android/mail/browse/ConversationCursor;ILcom/android/mail/providers/Conversation;Landroid/content/ContentValues;)V

    return-object v0
.end method

.method public getPosition()I
    .locals 1

    .prologue
    .line 740
    iget v0, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    return v0
.end method

.method public getShort(I)S
    .locals 2
    .param p1, "columnIndex"    # I

    .prologue
    .line 865
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 866
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_0

    check-cast v0, Ljava/lang/Short;

    .end local v0    # "obj":Ljava/lang/Object;
    invoke-virtual {v0}, Ljava/lang/Short;->shortValue()S

    move-result v1

    .line 867
    :goto_0
    return v1

    .restart local v0    # "obj":Ljava/lang/Object;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1, p1}, Landroid/database/Cursor;->getShort(I)S

    move-result v1

    goto :goto_0
.end method

.method public getString(I)Ljava/lang/String;
    .locals 3
    .param p1, "columnIndex"    # I

    .prologue
    .line 874
    sget v2, Lcom/android/mail/browse/ConversationCursor;->sUriColumnIndex:I

    if-ne p1, v2, :cond_0

    .line 875
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v2, p1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 876
    .local v1, "uri":Landroid/net/Uri;
    invoke-static {v1}, Lcom/android/mail/browse/ConversationCursor;->uriToCachingUriString(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 880
    .end local v1    # "uri":Landroid/net/Uri;
    :goto_0
    return-object v0

    .line 878
    :cond_0
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v0

    .line 879
    .local v0, "obj":Ljava/lang/Object;
    if-eqz v0, :cond_1

    check-cast v0, Ljava/lang/String;

    goto :goto_0

    .line 880
    :cond_1
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v2, p1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getType(I)I
    .locals 1
    .param p1, "columnIndex"    # I

    .prologue
    .line 1413
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->getType(I)I

    move-result v0

    return v0
.end method

.method public getWantsAllOnMoveCalls()Z
    .locals 1

    .prologue
    .line 1459
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 1763
    invoke-super {p0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    return v0
.end method

.method public isAfterLast()Z
    .locals 1

    .prologue
    .line 1378
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isBeforeFirst()Z
    .locals 1

    .prologue
    .line 1373
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isClosed()Z
    .locals 1

    .prologue
    .line 1428
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFirst()Z
    .locals 1

    .prologue
    .line 1363
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isLast()Z
    .locals 1

    .prologue
    .line 1368
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isNull(I)Z
    .locals 1
    .param p1, "columnIndex"    # I

    .prologue
    .line 1418
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public isRefreshReady()Z
    .locals 1

    .prologue
    .line 620
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z

    return v0
.end method

.method public isRefreshRequired()Z
    .locals 1

    .prologue
    .line 616
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshRequired:Z

    return v0
.end method

.method public load()V
    .locals 4

    .prologue
    .line 168
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v1

    .line 171
    :try_start_0
    const-string v0, "ConversationCursor"

    const-string v2, "Create: initial creation"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 172
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationCursor;->doQuery(Z)Landroid/database/Cursor;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationCursor;->setCursor(Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 175
    :try_start_1
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    if-eqz v0, :cond_0

    .line 176
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    .line 177
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->refresh()Z

    .line 180
    :cond_0
    monitor-exit v1

    .line 181
    return-void

    .line 175
    :catchall_0
    move-exception v0

    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    if-eqz v2, :cond_1

    .line 176
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/android/mail/browse/ConversationCursor;->mInitialConversationLimit:Z

    .line 177
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->refresh()Z

    :cond_1
    throw v0

    .line 180
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    throw v0
.end method

.method public mostlyArchive(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1695
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/16 v0, 0x83

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public mostlyDelete(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1702
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/16 v0, 0x80

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public mostlyDestructiveUpdate(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Ljava/lang/String;)I
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "column"    # Ljava/lang/String;
    .param p4, "value"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")I"
        }
    .end annotation

    .prologue
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1710
    new-array v0, v1, [Ljava/lang/String;

    aput-object p3, v0, v2

    new-array v1, v1, [Ljava/lang/String;

    aput-object p4, v1, v2

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/android/mail/browse/ConversationCursor;->mostlyDestructiveUpdate(Landroid/content/Context;Ljava/util/Collection;[Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public mostlyDestructiveUpdate(Landroid/content/Context;Ljava/util/Collection;[Ljava/lang/String;[Ljava/lang/String;)I
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "columnNames"    # [Ljava/lang/String;
    .param p4, "values"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;[",
            "Ljava/lang/String;",
            "[",
            "Ljava/lang/String;",
            ")I"
        }
    .end annotation

    .prologue
    .line 1722
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1723
    .local v0, "cv":Landroid/content/ContentValues;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, p3

    if-ge v1, v2, :cond_0

    .line 1724
    aget-object v2, p3, v1

    aget-object v3, p4, v1

    invoke-virtual {v0, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1723
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 1726
    :cond_0
    const/16 v2, 0x82

    invoke-direct {p0, p2, v2, v0}, Lcom/android/mail/browse/ConversationCursor;->getOperationsForConversations(Ljava/util/Collection;ILandroid/content/ContentValues;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-direct {p0, p1, v2}, Lcom/android/mail/browse/ConversationCursor;->apply(Landroid/content/Context;Ljava/util/Collection;)I

    move-result v2

    return v2
.end method

.method public move(I)Z
    .locals 2
    .param p1, "offset"    # I

    .prologue
    .line 828
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "move unsupported!"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public moveToFirst()Z
    .locals 3

    .prologue
    const/4 v1, -0x1

    .line 757
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-nez v0, :cond_0

    .line 758
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "moveToFirst() on disabled cursor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->qUri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 761
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    .line 762
    iput v1, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 763
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->moveToNext()Z

    move-result v0

    return v0
.end method

.method public moveToLast()Z
    .locals 2

    .prologue
    .line 823
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "moveToLast unsupported!"

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public moveToNext()Z
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 706
    :cond_0
    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v3}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    .line 707
    .local v0, "ret":Z
    if-nez v0, :cond_1

    .line 708
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->getCount()I

    move-result v3

    iput v3, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 710
    const-string v3, "ConversationCursor"

    const-string v4, "*** moveToNext returns false; pos = %d, und = %d, del = %d"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    iget v6, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v6}, Landroid/database/Cursor;->getPosition()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v2

    const/4 v2, 0x2

    iget v6, p0, Lcom/android/mail/browse/ConversationCursor;->mDeletedCount:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 716
    :goto_0
    return v1

    .line 714
    :cond_1
    const/4 v3, -0x1

    invoke-direct {p0, v3}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v3

    instance-of v3, v3, Ljava/lang/Integer;

    if-nez v3, :cond_0

    .line 715
    iget v1, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    move v1, v2

    .line 716
    goto :goto_0
.end method

.method public moveToPosition(I)Z
    .locals 8
    .param p1, "pos"    # I

    .prologue
    const/4 v7, 0x2

    const/4 v6, -0x1

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 768
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-nez v2, :cond_0

    .line 769
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "moveToPosition() on disabled cursor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->qUri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 776
    :cond_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->getPosition()I

    move-result v2

    if-ne v2, v6, :cond_1

    .line 777
    const-string v2, "ConversationCursor"

    const-string v3, "*** Underlying cursor position is -1 asking to move from %d to %d"

    new-array v4, v7, [Ljava/lang/Object;

    iget v5, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v0

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 780
    :cond_1
    if-nez p1, :cond_2

    .line 781
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->moveToFirst()Z

    move-result v1

    .line 808
    :goto_0
    return v1

    .line 782
    :cond_2
    if-gez p1, :cond_3

    .line 783
    iput v6, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 784
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    iget v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    invoke-interface {v0, v2}, Landroid/database/Cursor;->moveToPosition(I)Z

    goto :goto_0

    .line 786
    :cond_3
    iget v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    if-ne p1, v2, :cond_5

    .line 788
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->getCount()I

    move-result v2

    if-ge p1, v2, :cond_4

    :goto_1
    move v1, v0

    goto :goto_0

    :cond_4
    move v0, v1

    goto :goto_1

    .line 789
    :cond_5
    iget v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    if-le p1, v2, :cond_8

    .line 790
    :cond_6
    iget v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    if-le p1, v2, :cond_7

    .line 791
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->moveToNext()Z

    move-result v2

    if-nez v2, :cond_6

    goto :goto_0

    :cond_7
    move v1, v0

    .line 795
    goto :goto_0

    .line 796
    :cond_8
    if-ltz p1, :cond_9

    iget v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    sub-int/2addr v2, p1

    if-le v2, p1, :cond_9

    .line 799
    const-string v2, "ConversationCursor"

    const-string v3, "*** Move from %d to %d, starting from first"

    new-array v4, v7, [Ljava/lang/Object;

    iget v5, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v4, v0

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 800
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->moveToFirst()Z

    .line 801
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    move-result v1

    goto :goto_0

    .line 803
    :cond_9
    iget v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    if-ge p1, v2, :cond_a

    .line 804
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor;->moveToPrevious()Z

    move-result v2

    if-nez v2, :cond_9

    goto :goto_0

    :cond_a
    move v1, v0

    .line 808
    goto :goto_0
.end method

.method public moveToPrevious()Z
    .locals 3

    .prologue
    const/4 v2, -0x1

    .line 726
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->moveToPrevious()Z

    move-result v0

    .line 727
    .local v0, "ret":Z
    if-nez v0, :cond_1

    .line 729
    iput v2, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 730
    const/4 v1, 0x0

    .line 734
    :goto_0
    return v1

    .line 732
    :cond_1
    invoke-direct {p0, v2}, Lcom/android/mail/browse/ConversationCursor;->getCachedValue(I)Ljava/lang/Object;

    move-result-object v1

    instance-of v1, v1, Ljava/lang/Integer;

    if-nez v1, :cond_0

    .line 733
    iget v1, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    add-int/lit8 v1, v1, -0x1

    iput v1, p0, Lcom/android/mail/browse/ConversationCursor;->mPosition:I

    .line 734
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public mute(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1660
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x4

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public pause()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    .line 188
    const-string v0, "ConversationCursor"

    const-string v1, "[Paused: %s]"

    new-array v2, v5, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 190
    iput-boolean v5, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    .line 191
    return-void
.end method

.method public refresh()Z
    .locals 7

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 661
    const-string v2, "ConversationCursor"

    const-string v3, "[refresh() %s]"

    new-array v4, v1, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v5, v4, v0

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 663
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v2

    .line 664
    :try_start_0
    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    if-eqz v3, :cond_0

    .line 666
    const-string v1, "ConversationCursor"

    const-string v3, "[refresh() %s returning; already running %d]"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    invoke-virtual {v6}, Ljava/lang/Object;->hashCode()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v1, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 669
    monitor-exit v2

    .line 674
    :goto_0
    return v0

    .line 671
    :cond_0
    new-instance v0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    const/4 v3, 0x0

    invoke-direct {v0, p0, v3}, Lcom/android/mail/browse/ConversationCursor$RefreshTask;-><init>(Lcom/android/mail/browse/ConversationCursor;Lcom/android/mail/browse/ConversationCursor$1;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    .line 672
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    sget-object v3, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v3, v4}, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 673
    monitor-exit v2

    move v0, v1

    .line 674
    goto :goto_0

    .line 673
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public registerContentObserver(Landroid/database/ContentObserver;)V
    .locals 0
    .param p1, "observer"    # Landroid/database/ContentObserver;

    .prologue
    .line 1435
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 0
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1445
    return-void
.end method

.method public removeListener(Lcom/android/mail/browse/ConversationCursor$ConversationListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/android/mail/browse/ConversationCursor$ConversationListener;

    .prologue
    .line 380
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    monitor-enter v1

    .line 381
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 382
    monitor-exit v1

    .line 383
    return-void

    .line 382
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public reportNotSpam(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1674
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x6

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public reportPhishing(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1681
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x7

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public reportSpam(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1667
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x5

    invoke-direct {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->applyAction(Landroid/content/Context;Ljava/util/Collection;I)I

    move-result v0

    return v0
.end method

.method public requery()Z
    .locals 1

    .prologue
    .line 1477
    const/4 v0, 0x1

    return v0
.end method

.method public respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 1
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 1469
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 1470
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mUnderlyingCursor:Landroid/database/Cursor;

    invoke-interface {v0, p1}, Landroid/database/Cursor;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    .line 1472
    :goto_0
    return-object v0

    :cond_0
    sget-object v0, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    goto :goto_0
.end method

.method public resume()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 198
    const-string v0, "ConversationCursor"

    const-string v1, "[Resumed: %s]"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 200
    iput-boolean v4, p0, Lcom/android/mail/browse/ConversationCursor;->mPaused:Z

    .line 201
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->checkNotifyUI()V

    .line 202
    return-void
.end method

.method public setConversationColumn(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Object;)V
    .locals 3
    .param p1, "conversationUri"    # Landroid/net/Uri;
    .param p2, "columnName"    # Ljava/lang/String;
    .param p3, "value"    # Ljava/lang/Object;

    .prologue
    .line 426
    invoke-static {p1}, Lcom/android/mail/browse/ConversationCursor;->uriStringFromCachingUri(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 427
    .local v0, "uriStr":Ljava/lang/String;
    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v2

    .line 428
    :try_start_0
    invoke-direct {p0, v0, p2, p3}, Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 429
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 430
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyDataChanged()V

    .line 431
    return-void

    .line 429
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method setMostlyDead(Ljava/lang/String;Lcom/android/mail/providers/Conversation;)V
    .locals 5
    .param p1, "uriString"    # Ljava/lang/String;
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const/4 v4, 0x1

    .line 1149
    const-string v0, "ConversationCursor"

    const-string v1, "[Mostly dead, deferring: %s] "

    new-array v2, v4, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1150
    const-string v0, "conversationFlags"

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {p0, p1, v0, v1}, Lcom/android/mail/browse/ConversationCursor;->cacheValue(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 1152
    iget v0, p2, Lcom/android/mail/providers/Conversation;->convFlags:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p2, Lcom/android/mail/providers/Conversation;->convFlags:I

    .line 1153
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->sMostlyDead:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1154
    iput-boolean v4, p0, Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z

    .line 1155
    return-void
.end method

.method public setNotificationUri(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    .locals 1
    .param p1, "cr"    # Landroid/content/ContentResolver;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 1454
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method public sync()V
    .locals 6

    .prologue
    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 595
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRequeryCursor:Landroid/database/Cursor;

    if-nez v0, :cond_0

    .line 599
    const-string v0, "ConversationCursor"

    const-string v1, "[sync() %s; no requery cursor]"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 613
    :goto_0
    return-void

    .line 603
    :cond_0
    iget-object v1, p0, Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;

    monitor-enter v1

    .line 605
    :try_start_0
    const-string v0, "ConversationCursor"

    const-string v2, "[sync() %s]"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 607
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRequeryCursor:Landroid/database/Cursor;

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationCursor;->resetCursor(Landroid/database/Cursor;)V

    .line 608
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRequeryCursor:Landroid/database/Cursor;

    .line 609
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshTask:Lcom/android/mail/browse/ConversationCursor$RefreshTask;

    .line 610
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z

    .line 611
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 612
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->notifyDataChanged()V

    goto :goto_0

    .line 611
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public undo(Landroid/content/Context;Landroid/net/Uri;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "undoUri"    # Landroid/net/Uri;

    .prologue
    .line 1628
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/android/mail/browse/ConversationCursor$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/android/mail/browse/ConversationCursor$1;-><init>(Lcom/android/mail/browse/ConversationCursor;Landroid/content/Context;Landroid/net/Uri;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1638
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationCursor;->undoLocal()V

    .line 1639
    return-void
.end method

.method public unregisterContentObserver(Landroid/database/ContentObserver;)V
    .locals 0
    .param p1, "observer"    # Landroid/database/ContentObserver;

    .prologue
    .line 1440
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 0
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1450
    return-void
.end method

.method public updateBoolean(Landroid/content/Context;Lcom/android/mail/providers/Conversation;Ljava/lang/String;Z)I
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p3, "columnName"    # Ljava/lang/String;
    .param p4, "value"    # Z

    .prologue
    .line 1484
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/android/mail/providers/Conversation;

    const/4 v1, 0x0

    aput-object p2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, p1, v0, p3, p4}, Lcom/android/mail/browse/ConversationCursor;->updateBoolean(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Z)I

    move-result v0

    return v0
.end method

.method public updateBoolean(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Z)I
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "columnName"    # Ljava/lang/String;
    .param p4, "value"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "Z)I"
        }
    .end annotation

    .prologue
    .line 1502
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1503
    .local v0, "cv":Landroid/content/ContentValues;
    invoke-static {p4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v0, p3, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1504
    invoke-virtual {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->updateValues(Landroid/content/Context;Ljava/util/Collection;Landroid/content/ContentValues;)I

    move-result v1

    return v1
.end method

.method public updateBulkValues(Landroid/content/Context;Ljava/util/Collection;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationCursor$ConversationOperation;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1568
    .local p2, "op":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationCursor$ConversationOperation;>;"
    invoke-direct {p0, p1, p2}, Lcom/android/mail/browse/ConversationCursor;->apply(Landroid/content/Context;Ljava/util/Collection;)I

    move-result v0

    return v0
.end method

.method public updateInt(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;I)I
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "columnName"    # Ljava/lang/String;
    .param p4, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "I)I"
        }
    .end annotation

    .prologue
    .line 1492
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1493
    .local v0, "cv":Landroid/content/ContentValues;
    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, p3, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1494
    invoke-virtual {p0, p1, p2, v0}, Lcom/android/mail/browse/ConversationCursor;->updateValues(Landroid/content/Context;Ljava/util/Collection;Landroid/content/ContentValues;)I

    move-result v1

    return v1
.end method

.method public updateStrings(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Ljava/util/ArrayList;)I
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "columnName"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 1524
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    .local p4, "values":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 1525
    .local v4, "operations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/browse/ConversationCursor$ConversationOperation;>;"
    const/4 v2, 0x0

    .line 1526
    .local v2, "i":I
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 1527
    .local v1, "cv":Landroid/content/ContentValues;
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1528
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    invoke-virtual {p4, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v1, p3, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1529
    const/4 v5, 0x2

    invoke-virtual {p0, v0, v5, v1}, Lcom/android/mail/browse/ConversationCursor;->getOperationForConversation(Lcom/android/mail/providers/Conversation;ILandroid/content/ContentValues;)Lcom/android/mail/browse/ConversationCursor$ConversationOperation;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 1531
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    :cond_0
    invoke-direct {p0, p1, v4}, Lcom/android/mail/browse/ConversationCursor;->apply(Landroid/content/Context;Ljava/util/Collection;)I

    move-result v5

    return v5
.end method

.method public updateValues(Landroid/content/Context;Ljava/util/Collection;Landroid/content/ContentValues;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p3, "values"    # Landroid/content/ContentValues;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Landroid/content/ContentValues;",
            ")I"
        }
    .end annotation

    .prologue
    .line 1556
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x2

    invoke-direct {p0, p2, v0, p3}, Lcom/android/mail/browse/ConversationCursor;->getOperationsForConversations(Ljava/util/Collection;ILandroid/content/ContentValues;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/ConversationCursor;->apply(Landroid/content/Context;Ljava/util/Collection;)I

    move-result v0

    return v0
.end method
