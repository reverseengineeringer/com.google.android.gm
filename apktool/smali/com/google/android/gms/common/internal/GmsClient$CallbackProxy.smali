.class public abstract Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;
.super Ljava/lang/Object;
.source "GmsClient.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/common/internal/GmsClient;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x404
    name = "CallbackProxy"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T",
        "Listener:Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private mListener:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT",
            "Listener;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/google/android/gms/common/internal/GmsClient;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/common/internal/GmsClient;Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT",
            "Listener;",
            ")V"
        }
    .end annotation

    .prologue
    .line 130
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackProxy<TTListener;>;"
    .local p2, "listener":Ljava/lang/Object;, "TTListener;"
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->this$0:Lcom/google/android/gms/common/internal/GmsClient;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 131
    iput-object p2, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->mListener:Ljava/lang/Object;

    .line 132
    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/google/android/gms/common/internal/GmsClient;->access$200(Lcom/google/android/gms/common/internal/GmsClient;)Ljava/util/ArrayList;

    move-result-object v1

    monitor-enter v1

    .line 133
    :try_start_0
    # getter for: Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;
    invoke-static {p1}, Lcom/google/android/gms/common/internal/GmsClient;->access$200(Lcom/google/android/gms/common/internal/GmsClient;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 134
    monitor-exit v1

    .line 135
    return-void

    .line 134
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public deliverCallback()V
    .locals 2

    .prologue
    .line 149
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackProxy<TTListener;>;"
    monitor-enter p0

    .line 150
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->mListener:Ljava/lang/Object;

    .line 151
    .local v0, "listener":Ljava/lang/Object;, "TTListener;"
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 152
    invoke-virtual {p0, v0}, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->deliverCallback(Ljava/lang/Object;)V

    .line 153
    return-void

    .line 151
    .end local v0    # "listener":Ljava/lang/Object;, "TTListener;"
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method protected abstract deliverCallback(Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT",
            "Listener;",
            ")V"
        }
    .end annotation
.end method

.method public removeListener()V
    .locals 1

    .prologue
    .line 159
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackProxy<TTListener;>;"
    monitor-enter p0

    .line 160
    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->mListener:Ljava/lang/Object;

    .line 161
    monitor-exit p0

    .line 162
    return-void

    .line 161
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
