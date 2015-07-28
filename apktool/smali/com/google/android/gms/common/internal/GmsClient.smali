.class public abstract Lcom/google/android/gms/common/internal/GmsClient;
.super Ljava/lang/Object;
.source "GmsClient.java"

# interfaces
.implements Lcom/google/android/gms/common/GooglePlayServicesClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;,
        Lcom/google/android/gms/common/internal/GmsClient$PostInitCallback;,
        Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;,
        Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;,
        Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/os/IInterface;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/google/android/gms/common/GooglePlayServicesClient;"
    }
.end annotation


# static fields
.field public static final GOOGLE_PLUS_REQUIRED_FEATURES:[Ljava/lang/String;


# instance fields
.field private final mCallbackProxyList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/common/internal/GmsClient",
            "<TT;>.CallbackProxy<*>;>;"
        }
    .end annotation
.end field

.field private mConnection:Landroid/content/ServiceConnection;

.field private mConnectionFailedListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;",
            ">;"
        }
    .end annotation
.end field

.field private mConnectionListeners:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;",
            ">;"
        }
    .end annotation
.end field

.field final mConnectionListenersRemoved:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;",
            ">;"
        }
    .end annotation
.end field

.field private final mContext:Landroid/content/Context;

.field final mHandler:Landroid/os/Handler;

.field private mIsProcessingConnectionCallback:Z

.field private mIsProcessingOnConnectionFailed:Z

.field mPerformConnectionCallbacks:Z

.field private final mScopes:[Ljava/lang/String;

.field private mService:Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 242
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "service_esmobile"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "service_googleme"

    aput-object v2, v0, v1

    sput-object v0, Lcom/google/android/gms/common/internal/GmsClient;->GOOGLE_PLUS_REQUIRED_FEATURES:[Ljava/lang/String;

    return-void
.end method

.method protected varargs constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;[Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "connectedListener"    # Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;
    .param p3, "connectionFailedListener"    # Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;
    .param p4, "scopes"    # [Ljava/lang/String;

    .prologue
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    const/4 v1, 0x0

    .line 271
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 190
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListenersRemoved:Ljava/util/ArrayList;

    .line 199
    iput-boolean v1, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingConnectionCallback:Z

    .line 211
    iput-boolean v1, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingOnConnectionFailed:Z

    .line 218
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;

    .line 236
    iput-boolean v1, p0, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    .line 273
    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v0

    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    if-eq v0, v1, :cond_0

    .line 274
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Clients must be created on the UI thread."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 277
    :cond_0
    invoke-static {p1}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    .line 278
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    .line 279
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    invoke-static {p2}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 280
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionFailedListeners:Ljava/util/ArrayList;

    .line 281
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionFailedListeners:Ljava/util/ArrayList;

    invoke-static {p3}, Lcom/google/android/gms/common/internal/Preconditions;->checkNotNull(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 285
    new-instance v0, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;

    invoke-direct {v0, p0}, Lcom/google/android/gms/common/internal/GmsClient$CallbackHandler;-><init>(Lcom/google/android/gms/common/internal/GmsClient;)V

    iput-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    .line 286
    iput-object p4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mScopes:[Ljava/lang/String;

    .line 287
    return-void
.end method

.method static synthetic access$000(Lcom/google/android/gms/common/internal/GmsClient;)Landroid/os/IInterface;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;

    return-object v0
.end method

.method static synthetic access$002(Lcom/google/android/gms/common/internal/GmsClient;Landroid/os/IInterface;)Landroid/os/IInterface;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;
    .param p1, "x1"    # Landroid/os/IInterface;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;

    return-object p1
.end method

.method static synthetic access$100(Lcom/google/android/gms/common/internal/GmsClient;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$200(Lcom/google/android/gms/common/internal/GmsClient;)Ljava/util/ArrayList;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$300(Lcom/google/android/gms/common/internal/GmsClient;)Landroid/content/ServiceConnection;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    return-object v0
.end method

.method static synthetic access$302(Lcom/google/android/gms/common/internal/GmsClient;Landroid/content/ServiceConnection;)Landroid/content/ServiceConnection;
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;
    .param p1, "x1"    # Landroid/content/ServiceConnection;

    .prologue
    .line 35
    iput-object p1, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    return-object p1
.end method

.method static synthetic access$400(Lcom/google/android/gms/common/internal/GmsClient;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/google/android/gms/common/internal/GmsClient;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method protected final checkConnected()V
    .locals 2

    .prologue
    .line 738
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    invoke-virtual {p0}, Lcom/google/android/gms/common/internal/GmsClient;->isConnected()Z

    move-result v0

    if-nez v0, :cond_0

    .line 739
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Not connected. Call connect() and wait for onConnected() to be called."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 742
    :cond_0
    return-void
.end method

.method public connect()V
    .locals 7

    .prologue
    .line 405
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    .line 408
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/google/android/gms/common/GooglePlayServicesUtil;->isGooglePlayServicesAvailable(Landroid/content/Context;)I

    move-result v0

    .line 409
    .local v0, "errorCode":I
    if-eqz v0, :cond_0

    .line 410
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    const/4 v5, 0x3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 425
    :goto_0
    return-void

    .line 415
    :cond_0
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/google/android/gms/common/internal/GmsClient;->getStartServiceAction()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 416
    .local v1, "intent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    if-eqz v3, :cond_1

    .line 417
    const-string v3, "GmsClient"

    const-string v4, "Calling connect() while still connected, missing disconnect()."

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 418
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;

    .line 419
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v3, v4}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 421
    :cond_1
    new-instance v3, Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;

    invoke-direct {v3, p0}, Lcom/google/android/gms/common/internal/GmsClient$GmsServiceConnection;-><init>(Lcom/google/android/gms/common/internal/GmsClient;)V

    iput-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    .line 422
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    const/16 v5, 0x81

    invoke-virtual {v3, v1, v4, v5}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v2

    .line 424
    .local v2, "result":Z
    const-string v3, "GmsClient"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "connect: bindService returned "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " for "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected abstract createServiceInterface(Landroid/os/IBinder;)Landroid/os/IInterface;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/IBinder;",
            ")TT;"
        }
    .end annotation
.end method

.method public disconnect()V
    .locals 5

    .prologue
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    const/4 v4, 0x0

    .line 434
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    .line 436
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;

    monitor-enter v3

    .line 438
    :try_start_0
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 439
    .local v1, "numCallbacks":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 440
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;

    invoke-virtual {v2}, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;->removeListener()V

    .line 439
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 442
    :cond_0
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient;->mCallbackProxyList:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 443
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 446
    iput-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;

    .line 447
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    if-eqz v2, :cond_1

    .line 448
    iget-object v2, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v2, v3}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 449
    iput-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnection:Landroid/content/ServiceConnection;

    .line 451
    :cond_1
    return-void

    .line 443
    .end local v0    # "i":I
    .end local v1    # "numCallbacks":I
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2
.end method

.method public final doCallback(Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/internal/GmsClient",
            "<TT;>.CallbackProxy<*>;)V"
        }
    .end annotation

    .prologue
    .line 763
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    .local p1, "callback":Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>.CallbackProxy<*>;"
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    const/4 v2, 0x2

    invoke-virtual {v1, v2, p1}, Landroid/os/Handler;->obtainMessage(ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 764
    return-void
.end method

.method public final getContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 457
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mContext:Landroid/content/Context;

    return-object v0
.end method

.method protected final getService()Landroid/os/IInterface;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TT;"
        }
    .end annotation

    .prologue
    .line 752
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    invoke-virtual {p0}, Lcom/google/android/gms/common/internal/GmsClient;->checkConnected()V

    .line 753
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;

    return-object v0
.end method

.method protected abstract getServiceDescriptor()Ljava/lang/String;
.end method

.method protected abstract getServiceFromBroker(Lcom/google/android/gms/common/internal/IGmsServiceBroker;Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/internal/IGmsServiceBroker;",
            "Lcom/google/android/gms/common/internal/GmsClient",
            "<TT;>.GmsCallbacks;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method

.method protected abstract getStartServiceAction()Ljava/lang/String;
.end method

.method public isConnected()Z
    .locals 1

    .prologue
    .line 429
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mService:Landroid/os/IInterface;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected final onConnectionFailure(Lcom/google/android/gms/common/ConnectionResult;)V
    .locals 6
    .param p1, "status"    # Lcom/google/android/gms/common/ConnectionResult;

    .prologue
    .line 592
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 594
    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionFailedListeners:Ljava/util/ArrayList;

    monitor-enter v4

    .line 596
    const/4 v3, 0x1

    :try_start_0
    iput-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingOnConnectionFailed:Z

    .line 598
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionFailedListeners:Ljava/util/ArrayList;

    .line 600
    .local v0, "connectionFailedListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, "size":I
    :goto_0
    if-ge v1, v2, :cond_2

    .line 604
    iget-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    if-nez v3, :cond_0

    .line 605
    monitor-exit v4

    .line 615
    :goto_1
    return-void

    .line 608
    :cond_0
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionFailedListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 609
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;

    invoke-interface {v3, p1}, Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;->onConnectionFailed(Lcom/google/android/gms/common/ConnectionResult;)V

    .line 600
    :cond_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 613
    :cond_2
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingOnConnectionFailed:Z

    .line 614
    monitor-exit v4

    goto :goto_1

    .end local v0    # "connectionFailedListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;>;"
    .end local v1    # "i":I
    .end local v2    # "size":I
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method protected final onConnectionSuccess()V
    .locals 9

    .prologue
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 505
    iget-object v7, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    monitor-enter v7

    .line 506
    :try_start_0
    iget-boolean v6, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingConnectionCallback:Z

    if-nez v6, :cond_1

    move v6, v4

    :goto_0
    invoke-static {v6}, Lcom/google/android/gms/common/internal/Preconditions;->checkState(Z)V

    .line 509
    iget-object v6, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    const/4 v8, 0x4

    invoke-virtual {v6, v8}, Landroid/os/Handler;->removeMessages(I)V

    .line 512
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingConnectionCallback:Z

    .line 527
    iget-object v6, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListenersRemoved:Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    if-nez v6, :cond_2

    :goto_1
    invoke-static {v4}, Lcom/google/android/gms/common/internal/Preconditions;->checkState(Z)V

    .line 529
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    .line 530
    .local v0, "connectionListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v3

    .local v3, "size":I
    :goto_2
    if-ge v1, v3, :cond_0

    .line 534
    iget-boolean v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    if-eqz v4, :cond_0

    invoke-virtual {p0}, Lcom/google/android/gms/common/internal/GmsClient;->isConnected()Z

    move-result v4

    if-nez v4, :cond_3

    .line 545
    :cond_0
    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListenersRemoved:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    .line 547
    const/4 v4, 0x0

    iput-boolean v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingConnectionCallback:Z

    .line 548
    monitor-exit v7

    .line 549
    return-void

    .end local v0    # "connectionListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;>;"
    .end local v1    # "i":I
    .end local v3    # "size":I
    :cond_1
    move v6, v5

    .line 506
    goto :goto_0

    :cond_2
    move v4, v5

    .line 527
    goto :goto_1

    .line 538
    .restart local v0    # "connectionListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;>;"
    .restart local v1    # "i":I
    .restart local v3    # "size":I
    :cond_3
    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListenersRemoved:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 539
    .local v2, "instanceSize":I
    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListenersRemoved:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 540
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;

    invoke-interface {v4}, Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;->onConnected()V

    .line 530
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 548
    .end local v0    # "connectionListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;>;"
    .end local v1    # "i":I
    .end local v2    # "instanceSize":I
    .end local v3    # "size":I
    :catchall_0
    move-exception v4

    monitor-exit v7
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4
.end method

.method protected final onDisconnection()V
    .locals 6

    .prologue
    .line 559
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mHandler:Landroid/os/Handler;

    const/4 v4, 0x4

    invoke-virtual {v3, v4}, Landroid/os/Handler;->removeMessages(I)V

    .line 561
    iget-object v4, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    monitor-enter v4

    .line 563
    const/4 v3, 0x1

    :try_start_0
    iput-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingConnectionCallback:Z

    .line 565
    iget-object v0, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    .line 566
    .local v0, "connectionListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v2

    .local v2, "size":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 570
    iget-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mPerformConnectionCallbacks:Z

    if-nez v3, :cond_1

    .line 579
    :cond_0
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mIsProcessingConnectionCallback:Z

    .line 580
    monitor-exit v4

    .line 581
    return-void

    .line 574
    :cond_1
    iget-object v3, p0, Lcom/google/android/gms/common/internal/GmsClient;->mConnectionListeners:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 575
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;

    invoke-interface {v3}, Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;->onDisconnected()V

    .line 566
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 580
    .end local v0    # "connectionListeners":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;>;"
    .end local v1    # "i":I
    .end local v2    # "size":I
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method protected final onServiceBrokerBound(Landroid/os/IBinder;)V
    .locals 4
    .param p1, "binder"    # Landroid/os/IBinder;

    .prologue
    .line 477
    .local p0, "this":Lcom/google/android/gms/common/internal/GmsClient;, "Lcom/google/android/gms/common/internal/GmsClient<TT;>;"
    :try_start_0
    invoke-static {p1}, Lcom/google/android/gms/common/internal/IGmsServiceBroker$Stub;->asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/common/internal/IGmsServiceBroker;

    move-result-object v1

    .line 478
    .local v1, "serviceBroker":Lcom/google/android/gms/common/internal/IGmsServiceBroker;
    new-instance v2, Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;

    invoke-direct {v2, p0}, Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;-><init>(Lcom/google/android/gms/common/internal/GmsClient;)V

    invoke-virtual {p0, v1, v2}, Lcom/google/android/gms/common/internal/GmsClient;->getServiceFromBroker(Lcom/google/android/gms/common/internal/IGmsServiceBroker;Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 482
    .end local v1    # "serviceBroker":Lcom/google/android/gms/common/internal/IGmsServiceBroker;
    :goto_0
    return-void

    .line 479
    :catch_0
    move-exception v0

    .line 480
    .local v0, "e":Landroid/os/RemoteException;
    const-string v2, "GmsClient"

    const-string v3, "service died"

    invoke-static {v2, v3}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
