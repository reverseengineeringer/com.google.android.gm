.class final Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;
.super Ljava/lang/Object;
.source "GmsClient.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/common/internal/GmsClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "GmsServiceConnection"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gms/common/internal/GmsClient;


# direct methods
.method constructor <init>(Lcom/google/android/gms/common/internal/GmsClient;)V
    .locals 0

    .prologue
    .line 45
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.GmsServiceConnection;"
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3
    .param p1, "component"    # Landroid/content/ComponentName;
    .param p2, "binder"    # Landroid/os/IBinder;

    .prologue
    .line 49
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.GmsServiceConnection;"
    const-string v0, "GmsClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "service broker connected, binder: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 50
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-virtual {v0, p2}, Lcom/google/android/gms/common/internal/GmsClient;->onServiceBrokerBound(Landroid/os/IBinder;)V

    .line 51
    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 3
    .param p1, "component"    # Landroid/content/ComponentName;

    .prologue
    .line 55
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.GmsServiceConnection;"
    const-string v0, "GmsClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "service disconnected: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 57
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    const/4 v1, 0x0

    # setter for: Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;
    invoke-static {v0, v1}, Lcom/google/android/gms/common/internal/GmsClient;->access$002(Lcom/google/android/gms/common/internal/GmsClient;Landroid/os/IInterface;)Landroid/os/IInterface;

    .line 58
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-virtual {v0}, Lcom/google/android/gms/common/internal/GmsClient;->onDisconnection()V

    .line 59
    return-void
.end method
