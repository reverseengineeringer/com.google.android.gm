.class public Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;
.super Lcom/google/android/gms/common/internal/GmsClient;
.source "PanoramaClientImpl.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;,
        Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/common/internal/GmsClient",
        "<",
        "Lcom/google/android/gms/panorama/internal/IPanoramaService;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "connectedListener"    # Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;
    .param p3, "connectionFailedListener"    # Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;

    .prologue
    .line 95
    const/4 v0, 0x0

    check-cast v0, [Ljava/lang/String;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/gms/common/internal/GmsClient;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;[Ljava/lang/String;)V

    .line 96
    return-void
.end method


# virtual methods
.method public bridge synthetic createServiceInterface(Landroid/os/IBinder;)Landroid/os/IInterface;
    .locals 1
    .param p1, "x0"    # Landroid/os/IBinder;

    .prologue
    .line 24
    invoke-virtual {p0, p1}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->createServiceInterface(Landroid/os/IBinder;)Lcom/google/android/gms/panorama/internal/IPanoramaService;

    move-result-object v0

    return-object v0
.end method

.method public createServiceInterface(Landroid/os/IBinder;)Lcom/google/android/gms/panorama/internal/IPanoramaService;
    .locals 1
    .param p1, "binder"    # Landroid/os/IBinder;

    .prologue
    .line 123
    invoke-static {p1}, Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub;->asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/panorama/internal/IPanoramaService;

    move-result-object v0

    return-object v0
.end method

.method protected getServiceDescriptor()Ljava/lang/String;
    .locals 1

    .prologue
    .line 128
    const-string v0, "com.google.android.gms.panorama.internal.IPanoramaService"

    return-object v0
.end method

.method protected getServiceFromBroker(Lcom/google/android/gms/common/internal/IGmsServiceBroker;Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;)V
    .locals 3
    .param p1, "serviceBroker"    # Lcom/google/android/gms/common/internal/IGmsServiceBroker;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/internal/IGmsServiceBroker;",
            "Lcom/google/android/gms/common/internal/GmsClient",
            "<",
            "Lcom/google/android/gms/panorama/internal/IPanoramaService;",
            ">.GmsCallbacks;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 139
    .local p2, "gmsCallbacks":Lcom/google/android/gms/common/internal/GmsClient$GmsCallbacks;, "Lcom/google/android/gms/common/internal/GmsClient<Lcom/google/android/gms/panorama/internal/IPanoramaService;>.GmsCallbacks;"
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 140
    .local v0, "args":Landroid/os/Bundle;
    const/4 v1, 0x1

    invoke-virtual {p0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, p2, v1, v2, v0}, Lcom/google/android/gms/common/internal/IGmsServiceBroker;->getPanoramaService(Lcom/google/android/gms/common/internal/IGmsCallbacks;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 142
    return-void
.end method

.method protected getStartServiceAction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    const-string v0, "com.google.android.gms.panorama.service.START"

    return-object v0
.end method

.method public loadPanoramaInfo(Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Landroid/net/Uri;Landroid/os/Bundle;Z)V
    .locals 6
    .param p1, "listener"    # Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "viewerIntentExtras"    # Landroid/os/Bundle;
    .param p4, "grantAccess"    # Z

    .prologue
    const/4 v3, 0x0

    .line 100
    invoke-virtual {p0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->checkConnected()V

    .line 103
    if-eqz p4, :cond_0

    .line 104
    invoke-virtual {p0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->getContext()Landroid/content/Context;

    move-result-object v2

    const-string v4, "com.google.android.gms"

    const/4 v5, 0x1

    invoke-virtual {v2, v4, p2, v5}, Landroid/content/Context;->grantUriPermission(Ljava/lang/String;Landroid/net/Uri;I)V

    .line 109
    :cond_0
    new-instance v0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;

    if-eqz p4, :cond_1

    move-object v2, p2

    :goto_0
    invoke-direct {v0, p0, p1, v2}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;-><init>(Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Landroid/net/Uri;)V

    .line 112
    .local v0, "callbackProxy":Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;
    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->getService()Landroid/os/IInterface;

    move-result-object v2

    check-cast v2, Lcom/google/android/gms/panorama/internal/IPanoramaService;

    invoke-interface {v2, v0, p2, p3, p4}, Lcom/google/android/gms/panorama/internal/IPanoramaService;->loadPanoramaInfo(Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks;Landroid/net/Uri;Landroid/os/Bundle;Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 119
    :goto_1
    return-void

    .end local v0    # "callbackProxy":Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;
    :cond_1
    move-object v2, v3

    .line 109
    goto :goto_0

    .line 113
    .restart local v0    # "callbackProxy":Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;
    :catch_0
    move-exception v1

    .line 116
    .local v1, "e":Landroid/os/RemoteException;
    const/16 v2, 0x8

    const/4 v4, 0x0

    invoke-virtual {v0, v2, v3, v4, v3}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->onPanoramaInfoLoaded(ILandroid/os/Bundle;ILandroid/content/Intent;)V

    goto :goto_1
.end method
