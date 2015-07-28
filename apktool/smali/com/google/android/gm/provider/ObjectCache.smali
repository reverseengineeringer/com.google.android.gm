.class public Lcom/google/android/gm/provider/ObjectCache;
.super Ljava/lang/Object;
.source "ObjectCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/ObjectCache$Callback;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final mCallback:Lcom/google/android/gm/provider/ObjectCache$Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gm/provider/ObjectCache$Callback",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final mDataStore:Ljava/util/Deque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Deque",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final mMaxSize:I


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/ObjectCache$Callback;I)V
    .locals 1
    .param p2, "maxSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gm/provider/ObjectCache$Callback",
            "<TT;>;I)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p0, "this":Lcom/google/android/gm/provider/ObjectCache;, "Lcom/google/android/gm/provider/ObjectCache<TT;>;"
    .local p1, "callbacks":Lcom/google/android/gm/provider/ObjectCache$Callback;, "Lcom/google/android/gm/provider/ObjectCache$Callback<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 21
    invoke-static {}, Lcom/google/common/collect/Lists;->newLinkedList()Ljava/util/LinkedList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/ObjectCache;->mDataStore:Ljava/util/Deque;

    .line 32
    iput-object p1, p0, Lcom/google/android/gm/provider/ObjectCache;->mCallback:Lcom/google/android/gm/provider/ObjectCache$Callback;

    .line 33
    iput p2, p0, Lcom/google/android/gm/provider/ObjectCache;->mMaxSize:I

    .line 34
    return-void
.end method


# virtual methods
.method public get()Ljava/lang/Object;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 41
    .local p0, "this":Lcom/google/android/gm/provider/ObjectCache;, "Lcom/google/android/gm/provider/ObjectCache<TT;>;"
    iget-object v2, p0, Lcom/google/android/gm/provider/ObjectCache;->mDataStore:Ljava/util/Deque;

    monitor-enter v2

    .line 42
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/ObjectCache;->mDataStore:Ljava/util/Deque;

    invoke-interface {v1}, Ljava/util/Deque;->poll()Ljava/lang/Object;

    move-result-object v0

    .line 43
    .local v0, "result":Ljava/lang/Object;, "TT;"
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 44
    if-nez v0, :cond_0

    .line 45
    iget-object v1, p0, Lcom/google/android/gm/provider/ObjectCache;->mCallback:Lcom/google/android/gm/provider/ObjectCache$Callback;

    invoke-interface {v1}, Lcom/google/android/gm/provider/ObjectCache$Callback;->newInstance()Ljava/lang/Object;

    move-result-object v0

    .line 47
    :cond_0
    return-object v0

    .line 43
    .end local v0    # "result":Ljava/lang/Object;, "TT;"
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public release(Ljava/lang/Object;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 55
    .local p0, "this":Lcom/google/android/gm/provider/ObjectCache;, "Lcom/google/android/gm/provider/ObjectCache<TT;>;"
    .local p1, "objectToCache":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/google/android/gm/provider/ObjectCache;->mDataStore:Ljava/util/Deque;

    monitor-enter v1

    .line 56
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/ObjectCache;->mDataStore:Ljava/util/Deque;

    invoke-interface {v0}, Ljava/util/Deque;->size()I

    move-result v0

    iget v2, p0, Lcom/google/android/gm/provider/ObjectCache;->mMaxSize:I

    if-ge v0, v2, :cond_0

    .line 57
    iget-object v0, p0, Lcom/google/android/gm/provider/ObjectCache;->mCallback:Lcom/google/android/gm/provider/ObjectCache$Callback;

    invoke-interface {v0, p1}, Lcom/google/android/gm/provider/ObjectCache$Callback;->onObjectReleased(Ljava/lang/Object;)V

    .line 58
    iget-object v0, p0, Lcom/google/android/gm/provider/ObjectCache;->mDataStore:Ljava/util/Deque;

    invoke-interface {v0, p1}, Ljava/util/Deque;->add(Ljava/lang/Object;)Z

    .line 60
    :cond_0
    monitor-exit v1

    .line 61
    return-void

    .line 60
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
