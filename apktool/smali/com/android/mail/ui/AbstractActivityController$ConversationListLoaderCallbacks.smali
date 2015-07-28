.class Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractActivityController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConversationListLoaderCallbacks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Lcom/android/mail/browse/ConversationCursor;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/AbstractActivityController;)V
    .locals 0

    .prologue
    .line 2462
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/ui/AbstractActivityController$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/AbstractActivityController;
    .param p2, "x1"    # Lcom/android/mail/ui/AbstractActivityController$1;

    .prologue
    .line 2462
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    return-void
.end method


# virtual methods
.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 5
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Lcom/android/mail/browse/ConversationCursor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 2467
    new-instance v0, Lcom/android/mail/ui/ConversationCursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v1, v1, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    check-cast v1, Landroid/app/Activity;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v3, v3, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v3, v3, Lcom/android/mail/providers/Folder;->conversationListUri:Landroid/net/Uri;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v4, v4, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/android/mail/ui/ConversationCursorLoader;-><init>(Landroid/app/Activity;Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;)V

    .line 2469
    .local v0, "result":Landroid/content/Loader;, "Landroid/content/Loader<Lcom/android/mail/browse/ConversationCursor;>;"
    return-object v0
.end method

.method public onLoadFinished(Landroid/content/Loader;Lcom/android/mail/browse/ConversationCursor;)V
    .locals 7
    .param p2, "data"    # Lcom/android/mail/browse/ConversationCursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Lcom/android/mail/browse/ConversationCursor;",
            ">;",
            "Lcom/android/mail/browse/ConversationCursor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Lcom/android/mail/browse/ConversationCursor;>;"
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 2474
    sget-object v2, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v3, "IN AAC.ConversationCursor.onLoadFinished, data=%s loader=%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p2, v4, v5

    aput-object p1, v4, v6

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2477
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    const/4 v3, 0x0

    # invokes: Lcom/android/mail/ui/AbstractActivityController;->destroyPending(Lcom/android/mail/ui/DestructiveAction;)V
    invoke-static {v2, v3}, Lcom/android/mail/ui/AbstractActivityController;->access$600(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/ui/DestructiveAction;)V

    .line 2478
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iput-object p2, v2, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    .line 2479
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v2, v3}, Lcom/android/mail/browse/ConversationCursor;->addListener(Lcom/android/mail/browse/ConversationCursor$ConversationListener;)V

    .line 2481
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

    invoke-virtual {v2}, Lcom/android/mail/ui/ConversationPositionTracker;->onCursorUpdated()V

    .line 2482
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # getter for: Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;
    invoke-static {v2}, Lcom/android/mail/ui/AbstractActivityController;->access$700(Lcom/android/mail/ui/AbstractActivityController;)Landroid/database/DataSetObservable;

    move-result-object v2

    invoke-virtual {v2}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 2484
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v2}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v1

    .line 2485
    .local v1, "convList":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationListFragment;->isVisible()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 2489
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v2, v6}, Lcom/android/mail/ui/AbstractActivityController;->informCursorVisiblity(Z)V

    .line 2492
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v2}, Lcom/android/mail/ui/AbstractActivityController;->shouldShowFirstConversation()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 2493
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationCursor;->getCount()I

    move-result v2

    if-lez v2, :cond_1

    .line 2494
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v2, v5}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    .line 2495
    new-instance v0, Lcom/android/mail/providers/Conversation;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-direct {v0, v2}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 2496
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iput v5, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 2497
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v2, v0, v6}, Lcom/android/mail/ui/AbstractActivityController;->onConversationSelected(Lcom/android/mail/providers/Conversation;Z)V

    .line 2500
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_1
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 2462
    check-cast p2, Lcom/android/mail/browse/ConversationCursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->onLoadFinished(Landroid/content/Loader;Lcom/android/mail/browse/ConversationCursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Lcom/android/mail/browse/ConversationCursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 2504
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Lcom/android/mail/browse/ConversationCursor;>;"
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN AAC.ConversationCursor.onLoaderReset, data=%s loader=%s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2507
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-eqz v0, :cond_0

    .line 2509
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationCursor;->removeListener(Lcom/android/mail/browse/ConversationCursor$ConversationListener;)V

    .line 2510
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    .line 2513
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationPositionTracker;->onCursorUpdated()V

    .line 2514
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # getter for: Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;
    invoke-static {v0}, Lcom/android/mail/ui/AbstractActivityController;->access$700(Lcom/android/mail/ui/AbstractActivityController;)Landroid/database/DataSetObservable;

    move-result-object v0

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 2516
    :cond_0
    return-void
.end method
