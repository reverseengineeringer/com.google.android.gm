.class public Lcom/android/mail/ui/ConversationSelectionSet;
.super Ljava/lang/Object;
.source "ConversationSelectionSet.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/ui/ConversationSelectionSet;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mConversationUriToIdMap:Lcom/google/common/collect/BiMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/common/collect/BiMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final mInternalMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field private final mInternalViewMap:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/Long;",
            "Lcom/android/mail/browse/ConversationItemView;",
            ">;"
        }
    .end annotation
.end field

.field final mObservers:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/ConversationSetObserver;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 49
    new-instance v0, Lcom/android/mail/ui/ConversationSelectionSet$1;

    invoke-direct {v0}, Lcom/android/mail/ui/ConversationSelectionSet$1;-><init>()V

    sput-object v0, Lcom/android/mail/ui/ConversationSelectionSet;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 48
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 70
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    .line 77
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalViewMap:Ljava/util/HashMap;

    .line 79
    invoke-static {}, Lcom/google/common/collect/HashBiMap;->create()Lcom/google/common/collect/HashBiMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mConversationUriToIdMap:Lcom/google/common/collect/BiMap;

    .line 81
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/ui/ConversationSelectionSet;Ljava/lang/Long;Lcom/android/mail/providers/Conversation;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationSelectionSet;
    .param p1, "x1"    # Ljava/lang/Long;
    .param p2, "x2"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/ConversationSelectionSet;->put(Ljava/lang/Long;Lcom/android/mail/providers/Conversation;)V

    return-void
.end method

.method private declared-synchronized dispatchOnBecomeUnempty(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/ConversationSetObserver;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 135
    .local p1, "observers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationSetObserver;

    .line 136
    .local v1, "observer":Lcom/android/mail/ui/ConversationSetObserver;
    invoke-interface {v1, p0}, Lcom/android/mail/ui/ConversationSetObserver;->onSetPopulated(Lcom/android/mail/ui/ConversationSelectionSet;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 135
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "observer":Lcom/android/mail/ui/ConversationSetObserver;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 138
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized dispatchOnChange(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/ConversationSetObserver;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "observers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationSetObserver;

    .line 144
    .local v1, "observer":Lcom/android/mail/ui/ConversationSetObserver;
    invoke-interface {v1, p0}, Lcom/android/mail/ui/ConversationSetObserver;->onSetChanged(Lcom/android/mail/ui/ConversationSelectionSet;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 143
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "observer":Lcom/android/mail/ui/ConversationSetObserver;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 146
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized dispatchOnEmpty(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/ConversationSetObserver;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 149
    .local p1, "observers":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ConversationSetObserver;

    .line 150
    .local v1, "observer":Lcom/android/mail/ui/ConversationSetObserver;
    invoke-interface {v1}, Lcom/android/mail/ui/ConversationSetObserver;->onSetEmpty()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 149
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "observer":Lcom/android/mail/ui/ConversationSetObserver;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 152
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private declared-synchronized put(Ljava/lang/Long;Lcom/android/mail/browse/ConversationItemView;)V
    .locals 4
    .param p1, "id"    # Ljava/lang/Long;
    .param p2, "info"    # Lcom/android/mail/browse/ConversationItemView;

    .prologue
    .line 179
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    .line 180
    .local v0, "initiallyEmpty":Z
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalViewMap:Ljava/util/HashMap;

    invoke-virtual {v2, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    iget-object v3, p2, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v2, p1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 182
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mConversationUriToIdMap:Lcom/google/common/collect/BiMap;

    iget-object v3, p2, Lcom/android/mail/browse/ConversationItemView;->mHeader:Lcom/android/mail/browse/ConversationItemViewModel;

    iget-object v3, v3, Lcom/android/mail/browse/ConversationItemViewModel;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v3, v3, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p1}, Lcom/google/common/collect/BiMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 184
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v1

    .line 185
    .local v1, "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnChange(Ljava/util/ArrayList;)V

    .line 186
    if-eqz v0, :cond_0

    .line 187
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnBecomeUnempty(Ljava/util/ArrayList;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 189
    :cond_0
    monitor-exit p0

    return-void

    .line 179
    .end local v0    # "initiallyEmpty":Z
    .end local v1    # "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method private declared-synchronized put(Ljava/lang/Long;Lcom/android/mail/providers/Conversation;)V
    .locals 4
    .param p1, "id"    # Ljava/lang/Long;
    .param p2, "info"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 163
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    .line 164
    .local v0, "initiallyEmpty":Z
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 167
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalViewMap:Ljava/util/HashMap;

    const/4 v3, 0x0

    invoke-virtual {v2, p1, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 168
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mConversationUriToIdMap:Lcom/google/common/collect/BiMap;

    iget-object v3, p2, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    invoke-virtual {v3}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, p1}, Lcom/google/common/collect/BiMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 170
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v1

    .line 171
    .local v1, "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnChange(Ljava/util/ArrayList;)V

    .line 172
    if-eqz v0, :cond_0

    .line 173
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnBecomeUnempty(Ljava/util/ArrayList;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 175
    :cond_0
    monitor-exit p0

    return-void

    .line 163
    .end local v0    # "initiallyEmpty":Z
    .end local v1    # "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method private declared-synchronized remove(Ljava/lang/Long;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/Long;

    .prologue
    .line 193
    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Ljava/util/Collections;->singleton(Ljava/lang/Object;)Ljava/util/Set;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/ConversationSelectionSet;->removeAll(Ljava/util/Collection;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 194
    monitor-exit p0

    return-void

    .line 193
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized removeAll(Ljava/util/Collection;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 197
    .local p1, "ids":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/Long;>;"
    monitor-enter p0

    :try_start_0
    iget-object v5, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    const/4 v2, 0x1

    .line 199
    .local v2, "initiallyNotEmpty":Z
    :goto_0
    iget-object v5, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mConversationUriToIdMap:Lcom/google/common/collect/BiMap;

    invoke-interface {v5}, Lcom/google/common/collect/BiMap;->inverse()Lcom/google/common/collect/BiMap;

    move-result-object v3

    .line 201
    .local v3, "inverseMap":Lcom/google/common/collect/BiMap;, "Lcom/google/common/collect/BiMap<Ljava/lang/Long;Ljava/lang/String;>;"
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 202
    .local v1, "id":Ljava/lang/Long;
    iget-object v5, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalViewMap:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 203
    iget-object v5, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v5, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 204
    invoke-interface {v3, v1}, Lcom/google/common/collect/BiMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 197
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "id":Ljava/lang/Long;
    .end local v2    # "initiallyNotEmpty":Z
    .end local v3    # "inverseMap":Lcom/google/common/collect/BiMap;, "Lcom/google/common/collect/BiMap<Ljava/lang/Long;Ljava/lang/String;>;"
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 207
    .restart local v0    # "i$":Ljava/util/Iterator;
    .restart local v2    # "initiallyNotEmpty":Z
    .restart local v3    # "inverseMap":Lcom/google/common/collect/BiMap;, "Lcom/google/common/collect/BiMap<Ljava/lang/Long;Ljava/lang/String;>;"
    :cond_1
    :try_start_1
    iget-object v5, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-static {v5}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v4

    .line 208
    .local v4, "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    invoke-direct {p0, v4}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnChange(Ljava/util/ArrayList;)V

    .line 209
    iget-object v5, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v5}, Ljava/util/HashMap;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_2

    if-eqz v2, :cond_2

    .line 210
    invoke-direct {p0, v4}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnEmpty(Ljava/util/ArrayList;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 212
    :cond_2
    monitor-exit p0

    return-void
.end method


# virtual methods
.method public declared-synchronized addObserver(Lcom/android/mail/ui/ConversationSetObserver;)V
    .locals 1
    .param p1, "observer"    # Lcom/android/mail/ui/ConversationSetObserver;

    .prologue
    .line 90
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 91
    monitor-exit p0

    return-void

    .line 90
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized clear()V
    .locals 3

    .prologue
    .line 97
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    const/4 v0, 0x1

    .line 98
    .local v0, "initiallyNotEmpty":Z
    :goto_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalViewMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 99
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->clear()V

    .line 100
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mConversationUriToIdMap:Lcom/google/common/collect/BiMap;

    invoke-interface {v2}, Lcom/google/common/collect/BiMap;->clear()V

    .line 102
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    if-eqz v0, :cond_0

    .line 103
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v1

    .line 104
    .local v1, "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnChange(Ljava/util/ArrayList;)V

    .line 105
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnEmpty(Ljava/util/ArrayList;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 107
    .end local v1    # "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    :cond_0
    monitor-exit p0

    return-void

    .line 97
    .end local v0    # "initiallyNotEmpty":Z
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized contains(Lcom/android/mail/providers/Conversation;)Z
    .locals 2
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 125
    monitor-enter p0

    :try_start_0
    iget-wide v0, p1, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ConversationSelectionSet;->containsKey(Ljava/lang/Long;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized containsKey(Ljava/lang/Long;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/Long;

    .prologue
    .line 116
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 130
    const/4 v0, 0x0

    return v0
.end method

.method public declared-synchronized isEmpty()Z
    .locals 1

    .prologue
    .line 159
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized keySet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 256
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public putAll(Lcom/android/mail/ui/ConversationSelectionSet;)V
    .locals 4
    .param p1, "other"    # Lcom/android/mail/ui/ConversationSelectionSet;

    .prologue
    .line 266
    if-nez p1, :cond_1

    .line 278
    :cond_0
    :goto_0
    return-void

    .line 270
    :cond_1
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    .line 271
    .local v0, "initiallyEmpty":Z
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    iget-object v3, p1, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v2, v3}, Ljava/util/HashMap;->putAll(Ljava/util/Map;)V

    .line 273
    iget-object v2, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v1

    .line 274
    .local v1, "observersCopy":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/ConversationSetObserver;>;"
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnChange(Ljava/util/ArrayList;)V

    .line 275
    if-eqz v0, :cond_0

    .line 276
    invoke-direct {p0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->dispatchOnBecomeUnempty(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public declared-synchronized removeObserver(Lcom/android/mail/ui/ConversationSetObserver;)V
    .locals 1
    .param p1, "observer"    # Lcom/android/mail/ui/ConversationSetObserver;

    .prologue
    .line 220
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mObservers:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 221
    monitor-exit p0

    return-void

    .line 220
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized size()I
    .locals 1

    .prologue
    .line 228
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->size()I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public toggle(Lcom/android/mail/browse/ConversationItemView;Lcom/android/mail/providers/Conversation;)V
    .locals 3
    .param p1, "view"    # Lcom/android/mail/browse/ConversationItemView;
    .param p2, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 240
    iget-wide v0, p2, Lcom/android/mail/providers/Conversation;->id:J

    .line 241
    .local v0, "conversationId":J
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ConversationSelectionSet;->containsKey(Ljava/lang/Long;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 243
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/android/mail/ui/ConversationSelectionSet;->remove(Ljava/lang/Long;)V

    .line 247
    :goto_0
    return-void

    .line 245
    :cond_0
    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-direct {p0, v2, p1}, Lcom/android/mail/ui/ConversationSelectionSet;->put(Ljava/lang/Long;Lcom/android/mail/browse/ConversationItemView;)V

    goto :goto_0
.end method

.method public declared-synchronized validateAgainstCursor(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 10
    .param p1, "cursor"    # Lcom/android/mail/browse/ConversationCursor;

    .prologue
    const/4 v9, -0x1

    .line 305
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v8

    if-eqz v8, :cond_1

    .line 362
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 309
    :cond_1
    if-nez p1, :cond_2

    .line 310
    :try_start_1
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 305
    :catchall_0
    move-exception v8

    monitor-exit p0

    throw v8

    .line 315
    :cond_2
    :try_start_2
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->disableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z

    move-result v7

    .line 318
    .local v7, "networkWasEnabled":Z
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationCursor;->getPosition()I

    move-result v3

    .line 319
    .local v3, "currentPosition":I
    if-eq v3, v9, :cond_3

    .line 323
    const/4 v8, -0x1

    invoke-virtual {p1, v8}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    .line 327
    :cond_3
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationCursor;->getDeletedItems()Ljava/util/Set;

    move-result-object v4

    .line 330
    .local v4, "deletedConversations":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v6

    .line 331
    .local v6, "itemsToRemoveFromBatch":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_4
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 332
    .local v2, "conversationUri":Ljava/lang/String;
    iget-object v8, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mConversationUriToIdMap:Lcom/google/common/collect/BiMap;

    invoke-interface {v8, v2}, Lcom/google/common/collect/BiMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    .line 333
    .local v1, "conversationId":Ljava/lang/Long;
    if-eqz v1, :cond_4

    .line 334
    invoke-interface {v6, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 339
    .end local v1    # "conversationId":Ljava/lang/Long;
    .end local v2    # "conversationUri":Ljava/lang/String;
    :cond_5
    new-instance v0, Ljava/util/HashSet;

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationSelectionSet;->keySet()Ljava/util/Set;

    move-result-object v8

    invoke-direct {v0, v8}, Ljava/util/HashSet;-><init>(Ljava/util/Collection;)V

    .line 343
    .local v0, "batchConversationToCheck":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {v0, v6}, Ljava/util/Set;->removeAll(Ljava/util/Collection;)Z

    .line 347
    :goto_2
    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_6

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationCursor;->moveToNext()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 348
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->getConversationId(Lcom/android/mail/browse/ConversationCursor;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-interface {v0, v8}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    goto :goto_2

    .line 353
    :cond_6
    invoke-interface {v6, v0}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    .line 355
    invoke-direct {p0, v6}, Lcom/android/mail/ui/ConversationSelectionSet;->removeAll(Ljava/util/Collection;)V

    .line 357
    invoke-virtual {p1, v3}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    .line 359
    if-eqz v7, :cond_0

    .line 360
    invoke-static {p1}, Lcom/android/mail/utils/Utils;->enableConversationCursorNetworkAccess(Landroid/database/Cursor;)Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized values()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation

    .prologue
    .line 251
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public views()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationItemView;",
            ">;"
        }
    .end annotation

    .prologue
    .line 287
    iget-object v0, p0, Lcom/android/mail/ui/ConversationSelectionSet;->mInternalViewMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 3
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 282
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v1

    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationSelectionSet;->size()I

    move-result v2

    new-array v2, v2, [Lcom/android/mail/providers/Conversation;

    invoke-interface {v1, v2}, Ljava/util/Collection;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/android/mail/providers/Conversation;

    .line 283
    .local v0, "values":[Lcom/android/mail/providers/Conversation;
    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelableArray([Landroid/os/Parcelable;I)V

    .line 284
    return-void
.end method
