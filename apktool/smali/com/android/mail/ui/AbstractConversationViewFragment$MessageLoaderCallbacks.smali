.class Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;
.super Ljava/lang/Object;
.source "AbstractConversationViewFragment.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MessageLoaderCallbacks"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V
    .locals 0

    .prologue
    .line 453
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/AbstractConversationViewFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/AbstractConversationViewFragment$1;

    .prologue
    .line 453
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V

    return-void
.end method


# virtual methods
.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 4
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 457
    new-instance v0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v1, v1, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct {v0, v1, v2, v3}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoader;-><init>(Landroid/content/Context;Lcom/android/mail/providers/Conversation;Lcom/android/mail/browse/MessageCursor$ConversationController;)V

    return-object v0
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 9
    .param p2, "data"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    const/4 v8, 0x0

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 465
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$500(Lcom/android/mail/ui/AbstractConversationViewFragment;)Lcom/android/mail/browse/MessageCursor;

    move-result-object v2

    if-ne v2, p2, :cond_0

    .line 508
    :goto_0
    return-void

    :cond_0
    move-object v0, p2

    .line 468
    check-cast v0, Lcom/android/mail/browse/MessageCursor;

    .line 470
    .local v0, "messageCursor":Lcom/android/mail/browse/MessageCursor;
    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$600()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x3

    invoke-static {v2, v3}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 471
    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$600()Ljava/lang/String;

    move-result-object v2

    const-string v3, "LOADED CONVERSATION= %s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->getDebugDump()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 476
    :cond_1
    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->getCount()I

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$500(Lcom/android/mail/ui/AbstractConversationViewFragment;)Lcom/android/mail/browse/MessageCursor;

    move-result-object v2

    if-eqz v2, :cond_3

    .line 477
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mUserVisible:Z
    invoke-static {v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$700(Lcom/android/mail/ui/AbstractConversationViewFragment;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 478
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # invokes: Lcom/android/mail/ui/AbstractConversationViewFragment;->onError()V
    invoke-static {v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$800(Lcom/android/mail/ui/AbstractConversationViewFragment;)V

    .line 491
    :goto_1
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # setter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v2, v8}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$502(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/browse/MessageCursor;

    goto :goto_0

    .line 485
    :cond_2
    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$600()Ljava/lang/String;

    move-result-object v2

    const-string v3, "CVF: offscreen conv has no messages, ignoring update in anticipation of conv cursor update. c=%s"

    new-array v4, v7, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-object v5, v5, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 496
    :cond_3
    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->isLoaded()Z

    move-result v2

    if-nez v2, :cond_4

    .line 501
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # setter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v2, v8}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$502(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/browse/MessageCursor;

    goto :goto_0

    .line 504
    :cond_4
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$500(Lcom/android/mail/ui/AbstractConversationViewFragment;)Lcom/android/mail/browse/MessageCursor;

    move-result-object v1

    .line 505
    .local v1, "oldCursor":Lcom/android/mail/browse/MessageCursor;
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # setter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v2, v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$502(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/browse/MessageCursor;

    .line 506
    iget-object v2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v3}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$500(Lcom/android/mail/ui/AbstractConversationViewFragment;)Lcom/android/mail/browse/MessageCursor;

    move-result-object v3

    invoke-virtual {v2, p1, v3, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->onMessageCursorLoadFinished(Landroid/content/Loader;Lcom/android/mail/browse/MessageCursor;Lcom/android/mail/browse/MessageCursor;)V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 453
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 512
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MessageLoaderCallbacks;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    const/4 v1, 0x0

    # setter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mCursor:Lcom/android/mail/browse/MessageCursor;
    invoke-static {v0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$502(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/browse/MessageCursor;)Lcom/android/mail/browse/MessageCursor;

    .line 513
    return-void
.end method
