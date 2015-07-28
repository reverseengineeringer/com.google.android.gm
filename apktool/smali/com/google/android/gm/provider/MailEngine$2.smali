.class Lcom/google/android/gm/provider/MailEngine$2;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0

    .prologue
    .line 484
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public declared-synchronized run()V
    .locals 3

    .prologue
    .line 487
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$200(Lcom/google/android/gm/provider/MailEngine;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->isLiveQueryInProgress()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->isBackgroundSyncInProgress()Z

    move-result v0

    if-nez v0, :cond_0

    .line 489
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v1, 0x1

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setLastSyncResult(I)V
    invoke-static {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->access$300(Lcom/google/android/gm/provider/MailEngine;I)V

    .line 493
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v1, 0x1

    # setter for: Lcom/google/android/gm/provider/MailEngine;->mUserRefreshCompleted:Z
    invoke-static {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->access$202(Lcom/google/android/gm/provider/MailEngine;Z)Z

    .line 494
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$2;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v1, 0x4

    const/4 v2, 0x0

    # invokes: Lcom/google/android/gm/provider/MailEngine;->changeTaskState(IZ)V
    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->access$400(Lcom/google/android/gm/provider/MailEngine;IZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 495
    monitor-exit p0

    return-void

    .line 487
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
