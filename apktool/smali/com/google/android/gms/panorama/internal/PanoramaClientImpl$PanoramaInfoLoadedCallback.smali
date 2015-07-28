.class final Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;
.super Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;
.source "PanoramaClientImpl.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x10
    name = "PanoramaInfoLoadedCallback"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/common/internal/GmsClient",
        "<",
        "Lcom/google/android/gms/panorama/internal/IPanoramaService;",
        ">.CallbackProxy<",
        "Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;",
        ">;"
    }
.end annotation


# instance fields
.field public final status:Lcom/google/android/gms/common/ConnectionResult;

.field final synthetic this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

.field public final type:I

.field public final viewerIntent:Landroid/content/Intent;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;Lcom/google/android/gms/common/ConnectionResult;ILandroid/content/Intent;)V
    .locals 0
    .param p2, "listener"    # Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;
    .param p3, "status"    # Lcom/google/android/gms/common/ConnectionResult;
    .param p4, "type"    # I
    .param p5, "viewerIntent"    # Landroid/content/Intent;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->this$0:Lcom/google/android/gms/panorama/internal/PanoramaClientImpl;

    .line 43
    invoke-direct {p0, p1, p2}, Lcom/google/android/gms/common/internal/GmsClient$CallbackProxy;-><init>(Lcom/google/android/gms/common/internal/GmsClient;Ljava/lang/Object;)V

    .line 44
    iput-object p3, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->status:Lcom/google/android/gms/common/ConnectionResult;

    .line 45
    iput p4, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->type:I

    .line 46
    iput-object p5, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->viewerIntent:Landroid/content/Intent;

    .line 47
    return-void
.end method


# virtual methods
.method protected deliverCallback(Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;)V
    .locals 3
    .param p1, "listener"    # Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;

    .prologue
    .line 51
    if-eqz p1, :cond_0

    .line 52
    iget-object v0, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->status:Lcom/google/android/gms/common/ConnectionResult;

    iget v1, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->type:I

    iget-object v2, p0, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->viewerIntent:Landroid/content/Intent;

    invoke-interface {p1, v0, v1, v2}, Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;->onPanoramaInfoLoaded(Lcom/google/android/gms/common/ConnectionResult;ILandroid/content/Intent;)V

    .line 54
    :cond_0
    return-void
.end method

.method protected bridge synthetic deliverCallback(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 36
    check-cast p1, Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/google/android/gms/panorama/internal/PanoramaClientImpl$PanoramaInfoLoadedCallback;->deliverCallback(Lcom/google/android/gms/panorama/PanoramaClient$OnPanoramaInfoLoadedListener;)V

    return-void
.end method
