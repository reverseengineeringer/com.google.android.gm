.class Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Lcom/android/mail/ui/DestructiveAction;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractActivityController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FolderDestruction"
.end annotation


# instance fields
.field private mAction:I

.field private mCompleted:Z

.field private final mFolderOps:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;"
        }
    .end annotation
.end field

.field private final mIsDestructive:Z

.field private mIsSelectedSet:Z

.field private mShowUndo:Z

.field private final mTarget:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Ljava/util/Collection;ZZZI)V
    .locals 1
    .param p4, "isDestructive"    # Z
    .param p5, "isBatch"    # Z
    .param p6, "showUndo"    # Z
    .param p7, "action"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;ZZZI)V"
        }
    .end annotation

    .prologue
    .line 2595
    .local p2, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    .local p3, "folders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/ui/FolderOperation;>;"
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2581
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mFolderOps:Ljava/util/ArrayList;

    .line 2596
    invoke-static {p2}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mTarget:Ljava/util/Collection;

    .line 2597
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mFolderOps:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 2598
    iput-boolean p4, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mIsDestructive:Z

    .line 2599
    iput-boolean p5, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mIsSelectedSet:Z

    .line 2600
    iput-boolean p6, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mShowUndo:Z

    .line 2601
    iput p7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mAction:I

    .line 2602
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Ljava/util/Collection;ZZZILcom/android/mail/ui/AbstractActivityController$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/AbstractActivityController;
    .param p2, "x1"    # Ljava/util/Collection;
    .param p3, "x2"    # Ljava/util/Collection;
    .param p4, "x3"    # Z
    .param p5, "x4"    # Z
    .param p6, "x5"    # Z
    .param p7, "x6"    # I
    .param p8, "x7"    # Lcom/android/mail/ui/AbstractActivityController$1;

    .prologue
    .line 2579
    invoke-direct/range {p0 .. p7}, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;-><init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Ljava/util/Collection;ZZZI)V

    return-void
.end method

.method private declared-synchronized isPerformed()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 2647
    monitor-enter p0

    :try_start_0
    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mCompleted:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 2651
    :goto_0
    monitor-exit p0

    return v0

    .line 2650
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mCompleted:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2651
    const/4 v0, 0x0

    goto :goto_0

    .line 2647
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public performAction()V
    .locals 11

    .prologue
    .line 2606
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->isPerformed()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 2640
    :cond_0
    :goto_0
    return-void

    .line 2609
    :cond_1
    iget-boolean v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mIsDestructive:Z

    if-eqz v7, :cond_2

    iget-boolean v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mShowUndo:Z

    if-eqz v7, :cond_2

    .line 2610
    new-instance v5, Lcom/android/mail/ui/ToastBarOperation;

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mTarget:Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->size()I

    move-result v7

    iget v8, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mAction:I

    const/4 v9, 0x0

    iget-boolean v10, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mIsSelectedSet:Z

    invoke-direct {v5, v7, v8, v9, v10}, Lcom/android/mail/ui/ToastBarOperation;-><init>(IIIZ)V

    .line 2612
    .local v5, "undoOp":Lcom/android/mail/ui/ToastBarOperation;
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v7, v5}, Lcom/android/mail/ui/AbstractActivityController;->onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V

    .line 2616
    .end local v5    # "undoOp":Lcom/android/mail/ui/ToastBarOperation;
    :cond_2
    new-instance v6, Ljava/util/ArrayList;

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mTarget:Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->size()I

    move-result v7

    invoke-direct {v6, v7}, Ljava/util/ArrayList;-><init>(I)V

    .line 2617
    .local v6, "updatedTargetFolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mTarget:Ljava/util/Collection;

    invoke-interface {v7}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_6

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/mail/providers/Conversation;

    .line 2618
    .local v3, "target":Lcom/android/mail/providers/Conversation;
    invoke-virtual {v3}, Lcom/android/mail/providers/Conversation;->getRawFolders()Ljava/util/ArrayList;

    move-result-object v7

    invoke-static {v7}, Lcom/android/mail/providers/Folder;->hashMapForFolders(Ljava/util/ArrayList;)Ljava/util/HashMap;

    move-result-object v4

    .line 2620
    .local v4, "targetFolders":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroid/net/Uri;Lcom/android/mail/providers/Folder;>;"
    iget-boolean v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mIsDestructive:Z

    if-eqz v7, :cond_3

    .line 2621
    const/4 v7, 0x1

    iput-boolean v7, v3, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    .line 2623
    :cond_3
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mFolderOps:Ljava/util/ArrayList;

    invoke-virtual {v7}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/ui/FolderOperation;

    .line 2624
    .local v2, "op":Lcom/android/mail/ui/FolderOperation;
    iget-boolean v7, v2, Lcom/android/mail/ui/FolderOperation;->mAdd:Z

    if-eqz v7, :cond_4

    .line 2625
    iget-object v7, v2, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v7, v7, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v8, v2, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v4, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 2627
    :cond_4
    iget-object v7, v2, Lcom/android/mail/ui/FolderOperation;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v7, v7, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v4, v7}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    .line 2630
    .end local v2    # "op":Lcom/android/mail/ui/FolderOperation;
    :cond_5
    invoke-virtual {v4}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v7

    invoke-static {v7}, Lcom/android/mail/providers/Folder;->getSerializedFolderString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 2632
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "target":Lcom/android/mail/providers/Conversation;
    .end local v4    # "targetFolders":Ljava/util/HashMap;, "Ljava/util/HashMap<Landroid/net/Uri;Lcom/android/mail/providers/Folder;>;"
    :cond_6
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v7, v7, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-eqz v7, :cond_7

    .line 2633
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v7, v7, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v8, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v8, v8, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v9, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mTarget:Ljava/util/Collection;

    const-string v10, "rawFolders"

    invoke-virtual {v7, v8, v9, v10, v6}, Lcom/android/mail/browse/ConversationCursor;->updateStrings(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Ljava/util/ArrayList;)I

    .line 2636
    :cond_7
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v7}, Lcom/android/mail/ui/AbstractActivityController;->refreshConversationList()V

    .line 2637
    iget-boolean v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->mIsSelectedSet:Z

    if-eqz v7, :cond_0

    .line 2638
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # getter for: Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;
    invoke-static {v7}, Lcom/android/mail/ui/AbstractActivityController;->access$500(Lcom/android/mail/ui/AbstractActivityController;)Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v7

    invoke-virtual {v7}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V

    goto/16 :goto_0
.end method
