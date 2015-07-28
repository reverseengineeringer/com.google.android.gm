.class Lcom/google/android/gm/provider/MailEngine$ConversationCursor;
.super Lcom/google/android/gm/provider/MailEngine$NetworkCursor;
.source "MailEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConversationCursor"
.end annotation


# instance fields
.field mContentsVisibleToUser:Z

.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;)V
    .locals 1
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "driver"    # Landroid/database/sqlite/SQLiteCursorDriver;
    .param p4, "editTable"    # Ljava/lang/String;
    .param p5, "query"    # Landroid/database/sqlite/SQLiteQuery;
    .param p6, "logic"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    .prologue
    .line 5577
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->this$0:Lcom/google/android/gm/provider/MailEngine;

    .line 5578
    invoke-direct/range {p0 .. p6}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;)V

    .line 5574
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->mContentsVisibleToUser:Z

    .line 5579
    return-void
.end method


# virtual methods
.method getActiveConversationLogicOrNull()Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    .locals 3

    .prologue
    .line 5671
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v2

    .line 5672
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 5673
    .local v0, "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->isActiveNetworkCursor()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 5674
    monitor-exit v2

    .line 5677
    .end local v0    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :goto_0
    return-object v0

    .line 5676
    .restart local v0    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :cond_0
    monitor-exit v2

    .line 5677
    const/4 v0, 0x0

    goto :goto_0

    .line 5676
    .end local v0    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public onMove(II)Z
    .locals 3
    .param p1, "oldPosition"    # I
    .param p2, "newPosition"    # I

    .prologue
    .line 5601
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v2

    .line 5602
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    check-cast v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 5603
    .local v0, "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 5604
    invoke-virtual {v0, p1, p2, p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->onMove(IILcom/google/android/gm/provider/MailEngine$NetworkCursor;)V

    .line 5605
    invoke-super {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->onMove(II)Z

    move-result v1

    return v1

    .line 5603
    .end local v0    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public requery()Z
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 5583
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->getActiveConversationLogicOrNull()Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    move-result-object v0

    .line 5584
    .local v0, "logic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    if-eqz v0, :cond_0

    .line 5585
    iget-boolean v3, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->mContentsVisibleToUser:Z

    invoke-virtual {v0, p0, v3}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->requery(Lcom/google/android/gm/provider/MailEngine$NetworkCursor;Z)V

    .line 5586
    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getSelectionArgs()[Ljava/lang/String;

    move-result-object v2

    .line 5587
    .local v2, "selectionArguments":[Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 5588
    invoke-virtual {p0, v2}, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->setSelectionArguments([Ljava/lang/String;)V

    .line 5591
    .end local v2    # "selectionArguments":[Ljava/lang/String;
    :cond_0
    invoke-super {p0}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->requery()Z

    move-result v1

    .line 5592
    .local v1, "returnValue":Z
    if-eqz v0, :cond_1

    .line 5593
    invoke-virtual {v0, v4, v4, p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->onMove(IILcom/google/android/gm/provider/MailEngine$NetworkCursor;)V

    .line 5595
    :cond_1
    return v1
.end method

.method public respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 11
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 5610
    const-string v1, "command"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 5611
    .local v6, "command":Ljava/lang/String;
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 5615
    .local v9, "response":Landroid/os/Bundle;
    const-string v1, "setVisible"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "visible"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 5617
    const-string v1, "commandResponse"

    const-string v3, "ok"

    invoke-virtual {v9, v1, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 5666
    .end local v9    # "response":Landroid/os/Bundle;
    :goto_0
    return-object v9

    .line 5622
    .restart local v9    # "response":Landroid/os/Bundle;
    :cond_0
    const-string v1, "activate"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 5623
    iget-object v10, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v10

    .line 5624
    :try_start_0
    iget-object v7, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    check-cast v7, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 5626
    .local v7, "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    invoke-virtual {v7}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->getQuery()Ljava/lang/String;

    move-result-object v2

    .line 5627
    .local v2, "query":Ljava/lang/String;
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLastQuery:Ljava/lang/String;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$3700(Lcom/google/android/gm/provider/MailEngine;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v2}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 5628
    new-instance v0, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v3, 0x1

    const/4 v4, 0x0

    # getter for: Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mBackwardsCompatMode:Z
    invoke-static {v7}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->access$3800(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)Z

    move-result v5

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;-><init>(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;ZLjava/lang/Integer;Z)V

    .line 5632
    .local v0, "newLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    invoke-virtual {v0, p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->configure(Lcom/google/android/gm/provider/MailEngine$NetworkCursor;)V

    .line 5633
    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    .line 5637
    .end local v0    # "newLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :goto_1
    monitor-exit v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 5638
    const-string v1, "commandResponse"

    const-string v3, "ok"

    invoke-virtual {v9, v1, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 5635
    :cond_1
    const/4 v1, 0x1

    :try_start_1
    iput-boolean v1, v7, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mIsActiveNetworkCursor:Z

    goto :goto_1

    .line 5637
    .end local v2    # "query":Ljava/lang/String;
    .end local v7    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :catchall_0
    move-exception v1

    monitor-exit v10
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 5641
    :cond_2
    const-string v1, "deactivate"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 5642
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v3

    .line 5643
    :try_start_2
    iget-object v7, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    check-cast v7, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    .line 5645
    .restart local v7    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    invoke-virtual {v7}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->isActiveNetworkCursor()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 5646
    const/4 v1, 0x0

    iput-boolean v1, v7, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->mIsActiveNetworkCursor:Z

    .line 5647
    const-string v1, "commandResponse"

    const-string v4, "ok"

    invoke-virtual {v9, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 5653
    :goto_2
    monitor-exit v3

    goto :goto_0

    .end local v7    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :catchall_1
    move-exception v1

    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v1

    .line 5650
    .restart local v7    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :cond_3
    :try_start_3
    const-string v1, "commandResponse"

    const-string v4, "failed"

    invoke-virtual {v9, v1, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    goto :goto_2

    .line 5655
    .end local v7    # "conversationLogic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :cond_4
    const-string v1, "setVisible"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 5656
    invoke-virtual {p0}, Lcom/google/android/gm/provider/MailEngine$ConversationCursor;->getActiveConversationLogicOrNull()Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;

    move-result-object v8

    .line 5659
    .local v8, "logic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    if-eqz v8, :cond_5

    .line 5660
    # invokes: Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->clearMatchingNotifications()V
    invoke-static {v8}, Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;->access$3900(Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;)V

    .line 5662
    :cond_5
    const-string v1, "commandResponse"

    const-string v3, "ok"

    invoke-virtual {v9, v1, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 5666
    .end local v8    # "logic":Lcom/google/android/gm/provider/MailEngine$ConversationCursorLogic;
    :cond_6
    invoke-super {p0, p1}, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v9

    goto/16 :goto_0
.end method
