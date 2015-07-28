.class public Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;
.super Landroid/database/DataSetObservable;
.source "RecentLabelsCache.java"

# interfaces
.implements Ljava/lang/Iterable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/RecentLabelsCache;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "RecentLabelList"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/database/DataSetObservable;",
        "Ljava/lang/Iterable",
        "<",
        "Ljava/lang/String;",
        ">;"
    }
.end annotation


# instance fields
.field private final mRecentLabelsLRU:Lcom/google/android/gm/LRUCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gm/LRUCache",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/google/android/gm/RecentLabelsCache;


# direct methods
.method private constructor <init>(Lcom/google/android/gm/RecentLabelsCache;Ljava/util/List;I)V
    .locals 4
    .param p3, "capacity"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;I)V"
        }
    .end annotation

    .prologue
    .line 243
    .local p2, "orderedCanonicalNames":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->this$0:Lcom/google/android/gm/RecentLabelsCache;

    invoke-direct {p0}, Landroid/database/DataSetObservable;-><init>()V

    .line 244
    new-instance v2, Lcom/google/android/gm/LRUCache;

    invoke-direct {v2, p3}, Lcom/google/android/gm/LRUCache;-><init>(I)V

    iput-object v2, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->mRecentLabelsLRU:Lcom/google/android/gm/LRUCache;

    .line 246
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 247
    .local v0, "canonicalName":Ljava/lang/String;
    iget-object v2, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->mRecentLabelsLRU:Lcom/google/android/gm/LRUCache;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Lcom/google/android/gm/LRUCache;->addElement(Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 249
    .end local v0    # "canonicalName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/RecentLabelsCache;Ljava/util/List;ILcom/google/android/gm/RecentLabelsCache$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/RecentLabelsCache;
    .param p2, "x1"    # Ljava/util/List;
    .param p3, "x2"    # I
    .param p4, "x3"    # Lcom/google/android/gm/RecentLabelsCache$1;

    .prologue
    .line 236
    invoke-direct {p0, p1, p2, p3}, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;-><init>(Lcom/google/android/gm/RecentLabelsCache;Ljava/util/List;I)V

    return-void
.end method

.method static synthetic access$100(Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 236
    invoke-direct {p0, p1}, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->addLabel(Ljava/lang/String;)V

    return-void
.end method

.method private addLabel(Ljava/lang/String;)V
    .locals 2
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 261
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->mRecentLabelsLRU:Lcom/google/android/gm/LRUCache;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/google/android/gm/LRUCache;->addElement(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 262
    return-void
.end method


# virtual methods
.method public iterator()Ljava/util/Iterator;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Iterator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 253
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->mRecentLabelsLRU:Lcom/google/android/gm/LRUCache;

    invoke-virtual {v0}, Lcom/google/android/gm/LRUCache;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    return-object v0
.end method

.method public registerObserver(Landroid/database/DataSetObserver;)V
    .locals 5
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 273
    invoke-super {p0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 274
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->this$0:Lcom/google/android/gm/RecentLabelsCache;

    # getter for: Lcom/google/android/gm/RecentLabelsCache;->mUpdateLists:Ljava/util/Set;
    invoke-static {v0}, Lcom/google/android/gm/RecentLabelsCache;->access$200(Lcom/google/android/gm/RecentLabelsCache;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 275
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->this$0:Lcom/google/android/gm/RecentLabelsCache;

    # getter for: Lcom/google/android/gm/RecentLabelsCache;->mUpdateLists:Ljava/util/Set;
    invoke-static {v0}, Lcom/google/android/gm/RecentLabelsCache;->access$200(Lcom/google/android/gm/RecentLabelsCache;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->size()I

    move-result v0

    const/4 v1, 0x3

    if-le v0, v1, :cond_0

    .line 277
    const-string v0, "Gmail"

    const-string v1, "global RLC update set size=%d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->this$0:Lcom/google/android/gm/RecentLabelsCache;

    # getter for: Lcom/google/android/gm/RecentLabelsCache;->mUpdateLists:Ljava/util/Set;
    invoke-static {v4}, Lcom/google/android/gm/RecentLabelsCache;->access$200(Lcom/google/android/gm/RecentLabelsCache;)Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 279
    :cond_0
    return-void
.end method

.method public bridge synthetic registerObserver(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 236
    check-cast p1, Landroid/database/DataSetObserver;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->registerObserver(Landroid/database/DataSetObserver;)V

    return-void
.end method

.method public size()I
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->mRecentLabelsLRU:Lcom/google/android/gm/LRUCache;

    invoke-virtual {v0}, Lcom/google/android/gm/LRUCache;->size()I

    move-result v0

    return v0
.end method

.method public unregisterAll()V
    .locals 1

    .prologue
    .line 291
    invoke-super {p0}, Landroid/database/DataSetObservable;->unregisterAll()V

    .line 292
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->this$0:Lcom/google/android/gm/RecentLabelsCache;

    # getter for: Lcom/google/android/gm/RecentLabelsCache;->mUpdateLists:Ljava/util/Set;
    invoke-static {v0}, Lcom/google/android/gm/RecentLabelsCache;->access$200(Lcom/google/android/gm/RecentLabelsCache;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p0}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 293
    return-void
.end method

.method public unregisterObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 283
    invoke-super {p0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 284
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 285
    iget-object v0, p0, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->this$0:Lcom/google/android/gm/RecentLabelsCache;

    # getter for: Lcom/google/android/gm/RecentLabelsCache;->mUpdateLists:Ljava/util/Set;
    invoke-static {v0}, Lcom/google/android/gm/RecentLabelsCache;->access$200(Lcom/google/android/gm/RecentLabelsCache;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p0}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 287
    :cond_0
    return-void
.end method

.method public bridge synthetic unregisterObserver(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 236
    check-cast p1, Landroid/database/DataSetObserver;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gm/RecentLabelsCache$RecentLabelList;->unregisterObserver(Landroid/database/DataSetObserver;)V

    return-void
.end method
