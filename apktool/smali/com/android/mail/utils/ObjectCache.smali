.class public Lcom/android/mail/utils/ObjectCache;
.super Ljava/lang/Object;
.source "ObjectCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/utils/ObjectCache$Callback;
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
.field private final mCallback:Lcom/android/mail/utils/ObjectCache$Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/android/mail/utils/ObjectCache$Callback",
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
.method public constructor <init>(Lcom/android/mail/utils/ObjectCache$Callback;I)V
    .locals 1
    .param p2, "maxSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/utils/ObjectCache$Callback",
            "<TT;>;I)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p0, "this":Lcom/android/mail/utils/ObjectCache;, "Lcom/android/mail/utils/ObjectCache<TT;>;"
    .local p1, "callbacks":Lcom/android/mail/utils/ObjectCache$Callback;, "Lcom/android/mail/utils/ObjectCache$Callback<TT;>;"
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 35
    invoke-static {}, Lcom/google/common/collect/Lists;->newLinkedList()Ljava/util/LinkedList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/utils/ObjectCache;->mDataStore:Ljava/util/Deque;

    .line 46
    iput-object p1, p0, Lcom/android/mail/utils/ObjectCache;->mCallback:Lcom/android/mail/utils/ObjectCache$Callback;

    .line 47
    iput p2, p0, Lcom/android/mail/utils/ObjectCache;->mMaxSize:I

    .line 48
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
    .line 55
    .local p0, "this":Lcom/android/mail/utils/ObjectCache;, "Lcom/android/mail/utils/ObjectCache<TT;>;"
    iget-object v2, p0, Lcom/android/mail/utils/ObjectCache;->mDataStore:Ljava/util/Deque;

    monitor-enter v2

    .line 56
    :try_start_0
    iget-object v1, p0, Lcom/android/mail/utils/ObjectCache;->mDataStore:Ljava/util/Deque;

    invoke-interface {v1}, Ljava/util/Deque;->poll()Ljava/lang/Object;

    move-result-object v0

    .line 57
    .local v0, "result":Ljava/lang/Object;, "TT;"
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 58
    if-nez v0, :cond_0

    .line 59
    iget-object v1, p0, Lcom/android/mail/utils/ObjectCache;->mCallback:Lcom/android/mail/utils/ObjectCache$Callback;

    invoke-interface {v1}, Lcom/android/mail/utils/ObjectCache$Callback;->newInstance()Ljava/lang/Object;

    move-result-object v0

    .line 61
    :cond_0
    return-object v0

    .line 57
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
    .line 69
    .local p0, "this":Lcom/android/mail/utils/ObjectCache;, "Lcom/android/mail/utils/ObjectCache<TT;>;"
    .local p1, "objectToCache":Ljava/lang/Object;, "TT;"
    iget-object v1, p0, Lcom/android/mail/utils/ObjectCache;->mDataStore:Ljava/util/Deque;

    monitor-enter v1

    .line 70
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/utils/ObjectCache;->mDataStore:Ljava/util/Deque;

    invoke-interface {v0}, Ljava/util/Deque;->size()I

    move-result v0

    iget v2, p0, Lcom/android/mail/utils/ObjectCache;->mMaxSize:I

    if-ge v0, v2, :cond_0

    .line 71
    iget-object v0, p0, Lcom/android/mail/utils/ObjectCache;->mCallback:Lcom/android/mail/utils/ObjectCache$Callback;

    invoke-interface {v0, p1}, Lcom/android/mail/utils/ObjectCache$Callback;->onObjectReleased(Ljava/lang/Object;)V

    .line 72
    iget-object v0, p0, Lcom/android/mail/utils/ObjectCache;->mDataStore:Ljava/util/Deque;

    invoke-interface {v0, p1}, Ljava/util/Deque;->add(Ljava/lang/Object;)Z

    .line 74
    :cond_0
    monitor-exit v1

    .line 75
    return-void

    .line 74
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
