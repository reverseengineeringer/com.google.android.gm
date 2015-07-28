.class final Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;
.super Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks$Stub;
.source "PanoramaClientImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "PanoramaInfoLoadedBinderCallbacks"
.end annotation


# instance fields
.field private final mListener:Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;

.field private final mRevokeUri:Landroid/net/Uri;

.field final synthetic this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Landroid/net/Uri;)V
    .locals 0
    .param p2, "listener"    # Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;
    .param p3, "revokeUri"    # Landroid/net/Uri;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    invoke-direct {p0}, Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks$Stub;-><init>()V

    .line 72
    iput-object p2, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->mListener:Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;

    .line 73
    iput-object p3, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->mRevokeUri:Landroid/net/Uri;

    .line 74
    return-void
.end method


# virtual methods
.method public onPanoramaInfoLoaded(ILandroid/os/Bundle;ILandroid/content/Intent;)V
    .locals 8
    .param p1, "statusCode"    # I
    .param p2, "resolution"    # Landroid/os/Bundle;
    .param p3, "type"    # I
    .param p4, "viewerIntent"    # Landroid/content/Intent;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->mRevokeUri:Landroid/net/Uri;

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    invoke-virtual {v0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->getContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->mRevokeUri:Landroid/net/Uri;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->revokeUriPermission(Landroid/net/Uri;I)V

    .line 84
    :cond_0
    const/4 v6, 0x0

    .line 85
    .local v6, "resolutionIntent":Landroid/app/PendingIntent;
    if-eqz p2, :cond_1

    .line 86
    const-string v0, "pendingIntent"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v6

    .end local v6    # "resolutionIntent":Landroid/app/PendingIntent;
    check-cast v6, Landroid/app/PendingIntent;

    .line 88
    .restart local v6    # "resolutionIntent":Landroid/app/PendingIntent;
    :cond_1
    new-instance v3, Lcom/google/android/gms/common/ConnectionResult;

    invoke-direct {v3, p1, v6}, Lcom/google/android/gms/common/ConnectionResult;-><init>(ILandroid/app/PendingIntent;)V

    .line 89
    .local v3, "status":Lcom/google/android/gms/common/ConnectionResult;
    iget-object v7, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    new-instance v0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;

    iget-object v1, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    iget-object v2, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedBinderCallbacks;->mListener:Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;

    move v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;-><init>(Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Lcom/google/android/gms/common/ConnectionResult;ILandroid/content/Intent;)V

    invoke-virtual {v7, v0}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;->doCallback(Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;)V

    .line 90
    return-void
.end method
