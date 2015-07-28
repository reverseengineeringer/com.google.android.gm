.class Lcom/android/mail/compose/ComposeActivity$3;
.super Ljava/lang/Object;
.source "ComposeActivity.java"

# interfaces
.implements Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/compose/ComposeActivity;->sendOrSave(Landroid/text/Spanned;ZZZ)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/compose/ComposeActivity;


# direct methods
.method constructor <init>(Lcom/android/mail/compose/ComposeActivity;)V
    .locals 0

    .prologue
    .line 2300
    iput-object p1, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getMessage()Lcom/android/mail/providers/Message;
    .locals 2

    .prologue
    .line 2340
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # getter for: Lcom/android/mail/compose/ComposeActivity;->mDraftLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/android/mail/compose/ComposeActivity;->access$500(Lcom/android/mail/compose/ComposeActivity;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 2341
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # getter for: Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;
    invoke-static {v0}, Lcom/android/mail/compose/ComposeActivity;->access$700(Lcom/android/mail/compose/ComposeActivity;)Lcom/android/mail/providers/Message;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 2342
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public initializeSendOrSave(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;)V
    .locals 5

    .prologue
    .line 2306
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-object v1, v0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    monitor-enter v1

    .line 2307
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-object v0, v0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 2308
    if-nez v0, :cond_0

    .line 2311
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    new-instance v2, Landroid/content/Intent;

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    const-class v4, Lcom/android/mail/compose/EmptyService;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v2}, Lcom/android/mail/compose/ComposeActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 2314
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-object v0, v0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2315
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2316
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 2317
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->initializeSendOrSave(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;)V

    .line 2319
    :cond_1
    return-void

    .line 2315
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public notifyMessageIdAllocated(Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;Lcom/android/mail/providers/Message;)V
    .locals 5
    .param p1, "sendOrSaveMessage"    # Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;
    .param p2, "message"    # Lcom/android/mail/providers/Message;

    .prologue
    .line 2324
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # getter for: Lcom/android/mail/compose/ComposeActivity;->mDraftLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/android/mail/compose/ComposeActivity;->access$500(Lcom/android/mail/compose/ComposeActivity;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 2325
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-wide v2, p2, Lcom/android/mail/providers/Message;->id:J

    # setter for: Lcom/android/mail/compose/ComposeActivity;->mDraftId:J
    invoke-static {v0, v2, v3}, Lcom/android/mail/compose/ComposeActivity;->access$602(Lcom/android/mail/compose/ComposeActivity;J)J

    .line 2326
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # setter for: Lcom/android/mail/compose/ComposeActivity;->mDraft:Lcom/android/mail/providers/Message;
    invoke-static {v0, p2}, Lcom/android/mail/compose/ComposeActivity;->access$702(Lcom/android/mail/compose/ComposeActivity;Lcom/android/mail/providers/Message;)Lcom/android/mail/providers/Message;

    .line 2327
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sRequestMessageIdMap:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$800()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2328
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sRequestMessageIdMap:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$800()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v0

    invoke-virtual {p1}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;->requestId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # getter for: Lcom/android/mail/compose/ComposeActivity;->mDraftId:J
    invoke-static {v3}, Lcom/android/mail/compose/ComposeActivity;->access$600(Lcom/android/mail/compose/ComposeActivity;)J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2331
    :cond_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # invokes: Lcom/android/mail/compose/ComposeActivity;->saveRequestMap()V
    invoke-static {v0}, Lcom/android/mail/compose/ComposeActivity;->access$900(Lcom/android/mail/compose/ComposeActivity;)V

    .line 2332
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2333
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 2334
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->notifyMessageIdAllocated(Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;Lcom/android/mail/providers/Message;)V

    .line 2336
    :cond_1
    return-void

    .line 2332
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public sendOrSaveFinished(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;Z)V
    .locals 4

    .prologue
    .line 2348
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # getter for: Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v0}, Lcom/android/mail/compose/ComposeActivity;->access$1000(Lcom/android/mail/compose/ComposeActivity;)Lcom/android/mail/providers/Account;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 2349
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # getter for: Lcom/android/mail/compose/ComposeActivity;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/compose/ComposeActivity;->access$1000(Lcom/android/mail/compose/ComposeActivity;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/MailAppProvider;->setLastSentFromAccount(Ljava/lang/String;)V

    .line 2351
    :cond_0
    if-eqz p2, :cond_3

    .line 2353
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    # invokes: Lcom/android/mail/compose/ComposeActivity;->discardChanges()V
    invoke-static {v0}, Lcom/android/mail/compose/ComposeActivity;->access$1100(Lcom/android/mail/compose/ComposeActivity;)V

    .line 2363
    :goto_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-object v1, v0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    monitor-enter v1

    .line 2365
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-object v0, v0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 2366
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    iget-object v0, v0, Lcom/android/mail/compose/ComposeActivity;->mActiveTasks:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 2367
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2369
    if-nez v0, :cond_1

    .line 2371
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    const-class v3, Lcom/android/mail/compose/EmptyService;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Lcom/android/mail/compose/ComposeActivity;->stopService(Landroid/content/Intent;)Z

    .line 2373
    :cond_1
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 2374
    # getter for: Lcom/android/mail/compose/ComposeActivity;->sTestSendOrSaveCallback:Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
    invoke-static {}, Lcom/android/mail/compose/ComposeActivity;->access$400()Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;->sendOrSaveFinished(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;Z)V

    .line 2376
    :cond_2
    return-void

    .line 2358
    :cond_3
    iget-object v0, p0, Lcom/android/mail/compose/ComposeActivity$3;->this$0:Lcom/android/mail/compose/ComposeActivity;

    const v1, 0x7f0c009a

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 2367
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method
