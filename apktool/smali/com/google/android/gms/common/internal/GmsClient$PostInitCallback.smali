.class public final Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;
.super Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;
.source "GmsClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/common/internal/GmsClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x14
    name = "PostInitCallback"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/common/internal/GmsClient",
        "<TT;>.CallbackProxy<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field public final resolution:Landroid/os/Bundle;

.field public final service:Landroid/os/IBinder;

.field public final statusCode:I

.field final synthetic this$0:Lcom/google/android/gms/common/internal/GmsClient;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/internal/GmsClient;ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 1
    .param p2, "statusCode"    # I
    .param p3, "service"    # Landroid/os/IBinder;
    .param p4, "resolution"    # Landroid/os/Bundle;

    .prologue
    .line 340
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.PostInitCallback;"
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    .line 341
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;-><init>(Lcom/google/android/gms/common/internal/GmsClient;Ljava/lang/Object;)V

    .line 342
    iput p2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->statusCode:I

    .line 343
    iput-object p3, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->service:Landroid/os/IBinder;

    .line 344
    iput-object p4, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->resolution:Landroid/os/Bundle;

    .line 345
    return-void
.end method


# virtual methods
.method protected deliverCallback(Ljava/lang/Boolean;)V
    .locals 6
    .param p1, "nullIfRemoved"    # Ljava/lang/Boolean;

    .prologue
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.PostInitCallback;"
    const/4 v5, 0x0

    .line 349
    if-nez p1, :cond_0

    .line 384
    :goto_0
    return-void

    .line 354
    :cond_0
    iget v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->statusCode:I

    packed-switch v2, :pswitch_data_0

    .line 380
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->resolution:Landroid/os/Bundle;

    const-string v3, "pendingIntent"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/app/PendingIntent;

    .line 381
    .local v1, "pendingIntent":Landroid/app/PendingIntent;
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    new-instance v3, Lcom/google/android/gms/common/ConnectionResult;

    iget v4, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->statusCode:I

    invoke-direct {v3, v4, v1}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v2, v3}, Lcom/google/android/gms/common/internal/GmsClient;->onConnectionFailure(Lcom/google/android/gms/common/ConnectionResult;)V

    goto :goto_0

    .line 356
    .end local v1    # "pendingIntent":Landroid/app/PendingIntent;
    :pswitch_0
    const/4 v0, 0x0

    .line 358
    .local v0, "descriptor":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->service:Landroid/os/IBinder;

    invoke-interface {v2}, Landroid/os/IBinder;->getInterfaceDescriptor()Ljava/lang/String;

    move-result-object v0

    .line 359
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-virtual {v2}, Lcom/google/android/gms/common/internal/GmsClient;->getServiceDescriptor()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 361
    const-string v2, "GmsClient"

    const-string v3, "bound to service broker"

    invoke-static {v2, v3}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 362
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->service:Landroid/os/IBinder;

    invoke-virtual {v3, v4}, Lcom/google/android/gms/common/internal/GmsClient;->createServiceInterface(Landroid/os/IBinder;)Landroid/os/IInterface;

    move-result-object v3

    # setter for: Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;
    invoke-static {v2, v3}, Lcom/google/android/gms/common/internal/GmsClient;->access$002(Lcom/google/android/gms/common/internal/GmsClient;Landroid/os/IInterface;)Landroid/os/IInterface;

    .line 363
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;
    invoke-static {v2}, Lcom/google/android/gms/common/internal/GmsClient;->access$000(Lcom/google/android/gms/common/internal/GmsClient;)Landroid/os/IInterface;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 364
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-virtual {v2}, Lcom/google/android/gms/common/internal/GmsClient;->onConnectionSuccess()V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 368
    :catch_0
    move-exception v2

    .line 373
    :cond_1
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/google/android/gms/common/internal/GmsClient;->access$400(Lcom/google/android/gms/common/internal/GmsClient;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;
    invoke-static {v3}, Lcom/google/android/gms/common/internal/GmsClient;->access$300(Lcom/google/android/gms/common/internal/GmsClient;)Landroid/content/ServiceConnection;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 374
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # setter for: Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;
    invoke-static {v2, v5}, Lcom/google/android/gms/common/internal/GmsClient;->access$302(Lcom/google/android/gms/common/internal/GmsClient;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;

    .line 375
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    # setter for: Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;
    invoke-static {v2, v5}, Lcom/google/android/gms/common/internal/GmsClient;->access$002(Lcom/google/android/gms/common/internal/GmsClient;Landroid/os/IInterface;)Landroid/os/IInterface;

    .line 376
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    new-instance v3, Lcom/google/android/gms/common/ConnectionResult;

    const/16 v4, 0x8

    invoke-direct {v3, v4, v5}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v2, v3}, Lcom/google/android/gms/common/internal/GmsClient;->onConnectionFailure(Lcom/google/android/gms/common/ConnectionResult;)V

    goto :goto_0

    .line 354
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method protected bridge synthetic deliverCallback(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 334
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.PostInitCallback;"
    check-cast p1, Ljava/lang/Boolean;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;->deliverCallback(Ljava/lang/Boolean;)V

    return-void
.end method
