.class public Lcom/google/android/gms/panorama/PanoramaClient;
.super Ljava/lang/Object;
.source "PanoramaClient.java"

# interfaces
.implements Lcom/google/android/gms/common/GooglePlayServicesClient;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;
    }
.end annotation


# instance fields
.field private final mClientImpl:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "connectionCallbacks"    # Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;
    .param p3, "connectionFailedListener"    # Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;

    .prologue
    .line 62
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 63
    new-instance v0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    invoke-direct {v0, p1, p2, p3}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/GooglePlayServicesClient$ConnectionCallbacks;Lcom/google/android/gms/common/GooglePlayServicesClient$OnConnectionFailedListener;)V

    iput-object v0, p0, Lcom/google/android/gms/panorama/PanoramaClient;->mClientImpl:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    .line 65
    return-void
.end method


# virtual methods
.method public connect()V
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lcom/google/android/gms/panorama/PanoramaClient;->mClientImpl:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    invoke-virtual {v0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->connect()V

    .line 99
    return-void
.end method

.method public disconnect()V
    .locals 1

    .prologue
    .line 138
    iget-object v0, p0, Lcom/google/android/gms/panorama/PanoramaClient;->mClientImpl:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    invoke-virtual {v0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->disconnect()V

    .line 139
    return-void
.end method

.method public isConnected()Z
    .locals 1

    .prologue
    .line 103
    iget-object v0, p0, Lcom/google/android/gms/panorama/PanoramaClient;->mClientImpl:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    invoke-virtual {v0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->isConnected()Z

    move-result v0

    return v0
.end method

.method public loadPanoramaInfoAndGrantAccess(Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Landroid/net/Uri;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "listener"    # Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;
    .param p2, "uri"    # Landroid/net/Uri;
    .param p3, "viewerIntentExtras"    # Landroid/os/Bundle;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/google/android/gms/panorama/PanoramaClient;->mClientImpl:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, p2, p3, v1}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->loadPanoramaInfo(Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Landroid/net/Uri;Landroid/os/Bundle;Z)V

    .line 94
    return-void
.end method
