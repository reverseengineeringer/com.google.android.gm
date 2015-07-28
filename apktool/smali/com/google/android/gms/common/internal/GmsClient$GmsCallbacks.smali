.class public final Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;
.super Lcom/google/android/gms/common/internal/IGmsCallbacks$Stub;
.source "GmsClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/common/internal/GmsClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x14
    name = "GmsCallbacks"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gms/common/internal/GmsClient;


# direct methods
.method protected constructor <init>(Lcom/google/android/gms/common/internal/GmsClient;)V
    .locals 0

    .prologue
    .line 394
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.GmsCallbacks;"
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-direct {p0}, Lcom/google/android/gms/common/internal/IGmsCallbacks$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public onPostInitComplete(ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "statusCode"    # I
    .param p2, "service"    # Landroid/os/IBinder;
    .param p3, "resolution"    # Landroid/os/Bundle;

    .prologue
    .line 398
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.GmsCallbacks;"
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    iget-object v0, v0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    iget-object v1, v1, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x1

    new-instance v3, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;

    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-direct {v3, v4, p1, p2, p3}, Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;-><init>(Lcom/google/android/gms/common/internal/GmsClient;ILandroid/os/IBinder;Landroid/os/Bundle;)V

    invoke-virtual {v1, v2, v3}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 400
    return-void
.end method
