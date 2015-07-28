.class public interface abstract Lcom/google/android/gms/panorama/internal/IPanoramaService;
.super Ljava/lang/Object;
.source "IPanoramaService.java"

# interfaces
.implements Landroid/os/IInterface;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub;
    }
.end annotation


# virtual methods
.method public abstract loadPanoramaInfo(Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks;Landroid/net/Uri;Landroid/os/Bundle;Z)V
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation
.end method
