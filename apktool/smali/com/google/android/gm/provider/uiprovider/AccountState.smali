.class public Lcom/google/android/gm/provider/uiprovider/AccountState;
.super Ljava/lang/Object;
.source "AccountState.java"


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mConversationCursorMap:Landroid/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/LruCache",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mConversationStateMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/uiprovider/ConversationState;",
            ">;"
        }
    .end annotation
.end field

.field private final mEngine:Lcom/google/android/gm/provider/MailEngine;

.field private final mLoaderHandler:Landroid/os/Handler;

.field private final mSearchInfo:Ljava/util/Map;
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


# direct methods
.method public constructor <init>(Ljava/lang/String;Landroid/os/Handler;Lcom/google/android/gm/provider/MailEngine;)V
    .locals 2
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "loaderHandler"    # Landroid/os/Handler;
    .param p3, "engine"    # Lcom/google/android/gm/provider/MailEngine;

    .prologue
    .line 40
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 23
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    .line 28
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mSearchInfo:Ljava/util/Map;

    .line 33
    new-instance v0, Landroid/util/LruCache;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Landroid/util/LruCache;-><init>(I)V

    iput-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationCursorMap:Landroid/util/LruCache;

    .line 41
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mAccount:Ljava/lang/String;

    .line 42
    iput-object p2, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mLoaderHandler:Landroid/os/Handler;

    .line 43
    iput-object p3, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 44
    return-void
.end method

.method private static generateConversationCursorKey(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p0, "conversationListUri"    # Landroid/net/Uri;

    .prologue
    .line 90
    invoke-virtual {p0}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->clearQuery()Landroid/net/Uri$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private updateSearchInfoMapForQuery(Ljava/lang/String;)V
    .locals 2
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 108
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mSearchInfo:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 109
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mSearchInfo:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 110
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mSearchInfo:Ljava/util/Map;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 112
    :cond_0
    return-void
.end method


# virtual methods
.method public cacheConversationCursor(Landroid/net/Uri;Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;)V
    .locals 3
    .param p1, "conversationListUri"    # Landroid/net/Uri;
    .param p2, "cursor"    # Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;

    .prologue
    .line 94
    invoke-static {p1}, Lcom/google/android/gm/provider/uiprovider/AccountState;->generateConversationCursorKey(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    .line 95
    .local v0, "key":Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationCursorMap:Landroid/util/LruCache;

    new-instance v2, Ljava/lang/ref/WeakReference;

    invoke-direct {v2, p2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v1, v0, v2}, Landroid/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    return-void
.end method

.method public getConversationCursor(Landroid/net/Uri;)Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;
    .locals 3
    .param p1, "conversationListUri"    # Landroid/net/Uri;

    .prologue
    .line 99
    invoke-static {p1}, Lcom/google/android/gm/provider/uiprovider/AccountState;->generateConversationCursorKey(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v1

    .line 100
    .local v1, "key":Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationCursorMap:Landroid/util/LruCache;

    invoke-virtual {v2, v1}, Landroid/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/ref/WeakReference;

    .line 102
    .local v0, "cursor":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;>;"
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/provider/uiprovider/UIConversationCursor;

    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getConversationState(J)Lcom/google/android/gm/provider/uiprovider/ConversationState;
    .locals 3
    .param p1, "conversationId"    # J

    .prologue
    .line 47
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    monitor-enter v1

    .line 48
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/ConversationState;

    monitor-exit v1

    return-object v0

    .line 49
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getNumSearchResults(Ljava/lang/String;)I
    .locals 1
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 78
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/uiprovider/AccountState;->updateSearchInfoMapForQuery(Ljava/lang/String;)V

    .line 80
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mSearchInfo:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public getOrCreateConversationState(Landroid/content/Context;J)Lcom/google/android/gm/provider/uiprovider/ConversationState;
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "conversationId"    # J

    .prologue
    .line 65
    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    monitor-enter v7

    .line 66
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 67
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .line 73
    .local v0, "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    :goto_0
    monitor-exit v7

    return-object v0

    .line 69
    .end local v0    # "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    :cond_0
    new-instance v0, Lcom/google/android/gm/provider/uiprovider/ConversationState;

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mAccount:Ljava/lang/String;

    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mLoaderHandler:Landroid/os/Handler;

    iget-object v6, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    move-object v1, p1

    move-wide v3, p2

    invoke-direct/range {v0 .. v6}, Lcom/google/android/gm/provider/uiprovider/ConversationState;-><init>(Landroid/content/Context;Ljava/lang/String;JLandroid/os/Handler;Lcom/google/android/gm/provider/MailEngine;)V

    .line 71
    .restart local v0    # "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    invoke-static {p2, p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 74
    .end local v0    # "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    :catchall_0
    move-exception v1

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public notifyAttachmentChange(J)V
    .locals 4
    .param p1, "conversationId"    # J

    .prologue
    .line 54
    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    monitor-enter v2

    .line 55
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mConversationStateMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/uiprovider/ConversationState;

    .line 56
    .local v0, "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 57
    if-eqz v0, :cond_0

    .line 58
    invoke-virtual {v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->notifyAttachmentChanges()V

    .line 60
    :cond_0
    return-void

    .line 56
    .end local v0    # "conversationState":Lcom/google/android/gm/provider/uiprovider/ConversationState;
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public setNumSearchResults(Ljava/lang/String;I)V
    .locals 2
    .param p1, "query"    # Ljava/lang/String;
    .param p2, "numResults"    # I

    .prologue
    .line 84
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/uiprovider/AccountState;->updateSearchInfoMapForQuery(Ljava/lang/String;)V

    .line 86
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/AccountState;->mSearchInfo:Ljava/util/Map;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 87
    return-void
.end method
