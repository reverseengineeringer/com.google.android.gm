.class final Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;
.super Landroid/os/Handler;
.source "GmsClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/common/internal/GmsClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "CallbackHandler"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gms/common/internal/GmsClient;


# direct methods
.method constructor <init>(Lcom/google/android/gms/common/internal/GmsClient;)V
    .locals 0

    .prologue
    .line 70
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackHandler;"
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 5
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackHandler;"
    const/4 v3, 0x2

    .line 83
    iget v1, p1, Landroid/os/Message;->what:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_1

    .line 84
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    new-instance v3, Lcom/google/android/gms/common/ConnectionResult;

    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    const/4 v4, 0x0

    invoke-direct {v3, v1, v4}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v2, v3}, Lcom/google/android/gms/common/internal/GmsClient;->onConnectionFailure(Lcom/google/android/gms/common/ConnectionResult;)V

    .line 108
    :cond_0
    :goto_0
    return-void

    .line 88
    :cond_1
    iget v1, p1, Landroid/os/Message;->what:I

    const/4 v2, 0x4

    if-ne v1, v2, :cond_3

    .line 89
    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/google/android/gms/common/internal/GmsClient;->access$100(Lcom/google/android/gms/common/internal/GmsClient;)Ljava/util/ArrayList;

    move-result-object v2

    monitor-enter v2

    .line 90
    :try_start_0
    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    iget-boolean v1, v1, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-virtual {v1}, Lcom/google/android/gms/common/internal/GmsClient;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/google/android/gms/common/internal/GmsClient;->access$100(Lcom/google/android/gms/common/internal/GmsClient;)Ljava/util/ArrayList;

    move-result-object v1

    iget-object v3, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 92
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;

    invoke-interface {v1}, Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;->onConnected()V

    .line 94
    :cond_2
    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 99
    :cond_3
    iget v1, p1, Landroid/os/Message;->what:I

    if-ne v1, v3, :cond_4

    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-virtual {v1}, Lcom/google/android/gms/common/internal/GmsClient;->isConnected()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 103
    :cond_4
    iget v1, p1, Landroid/os/Message;->what:I

    if-eq v1, v3, :cond_5

    iget v1, p1, Landroid/os/Message;->what:I

    const/4 v2, 0x1

    if-ne v1, v2, :cond_0

    .line 104
    :cond_5
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;

    .line 105
    .local v0, "callback":Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackProxy<*>;"
    invoke-virtual {v0}, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->deliverCallback()V

    goto :goto_0
.end method
