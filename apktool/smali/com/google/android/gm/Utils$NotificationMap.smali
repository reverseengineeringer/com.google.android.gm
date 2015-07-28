.class Lcom/google/android/gm/Utils$NotificationMap;
.super Ljava/util/concurrent/ConcurrentHashMap;
.source "Utils.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/Utils;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "NotificationMap"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/util/concurrent/ConcurrentHashMap",
        "<",
        "Lcom/google/android/gm/Utils$NotificationKey;",
        "Landroid/util/Pair",
        "<",
        "Ljava/lang/Integer;",
        "Ljava/lang/Integer;",
        ">;>;"
    }
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 374
    invoke-direct {p0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/Utils$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/Utils$1;

    .prologue
    .line 374
    invoke-direct {p0}, Lcom/google/android/gm/Utils$NotificationMap;-><init>()V

    return-void
.end method


# virtual methods
.method public getUnread(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;
    .locals 2
    .param p1, "key"    # Lcom/google/android/gm/Utils$NotificationKey;

    .prologue
    .line 384
    invoke-virtual {p0, p1}, Lcom/google/android/gm/Utils$NotificationMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 385
    .local v0, "value":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    if-eqz v0, :cond_0

    iget-object v1, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getUnseen(Lcom/google/android/gm/Utils$NotificationKey;)Ljava/lang/Integer;
    .locals 2
    .param p1, "key"    # Lcom/google/android/gm/Utils$NotificationKey;

    .prologue
    .line 392
    invoke-virtual {p0, p1}, Lcom/google/android/gm/Utils$NotificationMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 393
    .local v0, "value":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    if-eqz v0, :cond_0

    iget-object v1, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public declared-synchronized loadNotificationMap(Landroid/content/Context;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 409
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v5

    .line 410
    .local v5, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-virtual {v5, p1}, Lcom/google/android/gm/persistence/Persistence;->getActiveNotificationSet(Landroid/content/Context;)Ljava/util/Set;

    move-result-object v4

    .line 411
    .local v4, "notificationSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    if-eqz v4, :cond_1

    .line 412
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 414
    .local v2, "notificationEntry":Ljava/lang/String;
    const-string v9, " "

    invoke-static {v2, v9}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 416
    .local v3, "notificationParts":[Ljava/lang/String;
    array-length v9, v3

    const/4 v10, 0x4

    if-ne v9, v10, :cond_0

    .line 417
    new-instance v1, Lcom/google/android/gm/Utils$NotificationKey;

    const/4 v9, 0x0

    aget-object v9, v3, v9

    const/4 v10, 0x1

    aget-object v10, v3, v10

    invoke-direct {v1, v9, v10}, Lcom/google/android/gm/Utils$NotificationKey;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 419
    .local v1, "key":Lcom/google/android/gm/Utils$NotificationKey;
    const/4 v9, 0x2

    aget-object v9, v3, v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v7

    .line 420
    .local v7, "unreadValue":Ljava/lang/Integer;
    const/4 v9, 0x3

    aget-object v9, v3, v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v8

    .line 421
    .local v8, "unseenValue":Ljava/lang/Integer;
    new-instance v6, Landroid/util/Pair;

    invoke-direct {v6, v7, v8}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 423
    .local v6, "unreadUnseenValue":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    invoke-virtual {p0, v1, v6}, Lcom/google/android/gm/Utils$NotificationMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 409
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Lcom/google/android/gm/Utils$NotificationKey;
    .end local v2    # "notificationEntry":Ljava/lang/String;
    .end local v3    # "notificationParts":[Ljava/lang/String;
    .end local v4    # "notificationSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v5    # "persistence":Lcom/google/android/gm/persistence/Persistence;
    .end local v6    # "unreadUnseenValue":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    .end local v7    # "unreadValue":Ljava/lang/Integer;
    .end local v8    # "unseenValue":Ljava/lang/Integer;
    :catchall_0
    move-exception v9

    monitor-exit p0

    throw v9

    .line 427
    .restart local v4    # "notificationSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v5    # "persistence":Lcom/google/android/gm/persistence/Persistence;
    :cond_1
    monitor-exit p0

    return-void
.end method

.method public put(Lcom/google/android/gm/Utils$NotificationKey;II)V
    .locals 3
    .param p1, "key"    # Lcom/google/android/gm/Utils$NotificationKey;
    .param p2, "unread"    # I
    .param p3, "unseen"    # I

    .prologue
    .line 400
    new-instance v0, Landroid/util/Pair;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/util/Pair;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 402
    .local v0, "value":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    invoke-virtual {p0, p1, v0}, Lcom/google/android/gm/Utils$NotificationMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 403
    return-void
.end method

.method public declared-synchronized saveNotificationMap(Landroid/content/Context;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 433
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v3

    .line 434
    .local v3, "notificationSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/google/android/gm/Utils$NotificationMap;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 435
    .local v2, "keys":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/Utils$NotificationKey;>;"
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/Utils$NotificationKey;

    .line 436
    .local v1, "key":Lcom/google/android/gm/Utils$NotificationKey;
    invoke-virtual {p0, v1}, Lcom/google/android/gm/Utils$NotificationMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/util/Pair;

    .line 437
    .local v8, "value":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    iget-object v6, v8, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v6, Ljava/lang/Integer;

    .line 438
    .local v6, "unreadCount":Ljava/lang/Integer;
    iget-object v7, v8, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v7, Ljava/lang/Integer;

    .line 439
    .local v7, "unseenCount":Ljava/lang/Integer;
    if-eqz v8, :cond_0

    if-eqz v6, :cond_0

    if-eqz v7, :cond_0

    .line 440
    const/4 v9, 0x4

    new-array v4, v9, [Ljava/lang/String;

    const/4 v9, 0x0

    iget-object v10, v1, Lcom/google/android/gm/Utils$NotificationKey;->account:Ljava/lang/String;

    aput-object v10, v4, v9

    const/4 v9, 0x1

    iget-object v10, v1, Lcom/google/android/gm/Utils$NotificationKey;->label:Ljava/lang/String;

    aput-object v10, v4, v9

    const/4 v9, 0x2

    invoke-virtual {v6}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v4, v9

    const/4 v9, 0x3

    invoke-virtual {v7}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v4, v9

    .line 442
    .local v4, "partValues":[Ljava/lang/String;
    const-string v9, " "

    invoke-static {v9, v4}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-interface {v3, v9}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 433
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "key":Lcom/google/android/gm/Utils$NotificationKey;
    .end local v2    # "keys":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/Utils$NotificationKey;>;"
    .end local v3    # "notificationSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v4    # "partValues":[Ljava/lang/String;
    .end local v6    # "unreadCount":Ljava/lang/Integer;
    .end local v7    # "unseenCount":Ljava/lang/Integer;
    .end local v8    # "value":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/Integer;Ljava/lang/Integer;>;"
    :catchall_0
    move-exception v9

    monitor-exit p0

    throw v9

    .line 445
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "keys":Ljava/util/Set;, "Ljava/util/Set<Lcom/google/android/gm/Utils$NotificationKey;>;"
    .restart local v3    # "notificationSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1
    :try_start_1
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v5

    .line 446
    .local v5, "persistence":Lcom/google/android/gm/persistence/Persistence;
    invoke-virtual {v5, p1, v3}, Lcom/google/android/gm/persistence/Persistence;->cacheActiveNotificationSet(Landroid/content/Context;Ljava/util/Set;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 447
    monitor-exit p0

    return-void
.end method
