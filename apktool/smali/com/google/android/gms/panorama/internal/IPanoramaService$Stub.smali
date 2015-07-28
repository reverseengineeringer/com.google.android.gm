.class public abstract Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub;
.super Landroid/os/Binder;
.source "IPanoramaService.java"

# interfaces
.implements Lcom/google/android/gms/panorama/internal/IPanoramaService;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gms/panorama/internal/IPanoramaService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x409
    name = "Stub"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub$Proxy;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 17
    invoke-direct {p0}, Landroid/os/Binder;-><init>()V

    .line 18
    const-string v0, "com.google.android.gms.panorama.internal.IPanoramaService"

    invoke-virtual {p0, p0, v0}, Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub;->attachInterface(Landroid/os/IInterface;Ljava/lang/String;)V

    .line 19
    return-void
.end method

.method public static asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/panorama/internal/IPanoramaService;
    .locals 2
    .param p0, "obj"    # Landroid/os/IBinder;

    .prologue
    .line 26
    if-nez p0, :cond_0

    .line 27
    const/4 v0, 0x0

    .line 33
    :goto_0
    return-object v0

    .line 29
    :cond_0
    const-string v1, "com.google.android.gms.panorama.internal.IPanoramaService"

    invoke-interface {p0, v1}, Landroid/os/IBinder;->queryLocalInterface(Ljava/lang/String;)Landroid/os/IInterface;

    move-result-object v0

    .line 30
    .local v0, "iin":Landroid/os/IInterface;
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/google/android/gms/panorama/internal/IPanoramaService;

    if-eqz v1, :cond_1

    .line 31
    check-cast v0, Lcom/google/android/gms/panorama/internal/IPanoramaService;

    goto :goto_0

    .line 33
    :cond_1
    new-instance v0, Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub$Proxy;

    .end local v0    # "iin":Landroid/os/IInterface;
    invoke-direct {v0, p0}, Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub$Proxy;-><init>(Landroid/os/IBinder;)V

    goto :goto_0
.end method


# virtual methods
.method public onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z
    .locals 6
    .param p1, "code"    # I
    .param p2, "data"    # Landroid/os/Parcel;
    .param p3, "reply"    # Landroid/os/Parcel;
    .param p4, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v4, 0x1

    .line 41
    sparse-switch p1, :sswitch_data_0

    .line 73
    invoke-super {p0, p1, p2, p3, p4}, Landroid/os/Binder;->onTransact(ILandroid/os/Parcel;Landroid/os/Parcel;I)Z

    move-result v4

    :goto_0
    return v4

    .line 45
    :sswitch_0
    const-string v5, "com.google.android.gms.panorama.internal.IPanoramaService"

    invoke-virtual {p3, v5}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    goto :goto_0

    .line 50
    :sswitch_1
    const-string v5, "com.google.android.gms.panorama.internal.IPanoramaService"

    invoke-virtual {p2, v5}, Landroid/os/Parcel;->enforceInterface(Ljava/lang/String;)V

    .line 52
    invoke-virtual {p2}, Landroid/os/Parcel;->readStrongBinder()Landroid/os/IBinder;

    move-result-object v5

    invoke-static {v5}, Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks$Stub;->asInterface(Landroid/os/IBinder;)Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks;

    move-result-object v0

    .line 54
    .local v0, "_arg0":Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks;
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_0

    .line 55
    sget-object v5, Landroid/net/Uri;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 61
    .local v1, "_arg1":Landroid/net/Uri;
    :goto_1
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_1

    .line 62
    sget-object v5, Landroid/os/Bundle;->CREATOR:Landroid/os/Parcelable$Creator;

    invoke-interface {v5, p2}, Landroid/os/Parcelable$Creator;->createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/os/Bundle;

    .line 68
    .local v2, "_arg2":Landroid/os/Bundle;
    :goto_2
    invoke-virtual {p2}, Landroid/os/Parcel;->readInt()I

    move-result v5

    if-eqz v5, :cond_2

    move v3, v4

    .line 69
    .local v3, "_arg3":Z
    :goto_3
    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/google/android/gms/panorama/internal/IPanoramaService$Stub;->loadPanoramaInfo(Lcom/google/android/gms/panorama/internal/IPanoramaCallbacks;Landroid/net/Uri;Landroid/os/Bundle;Z)V

    goto :goto_0

    .line 58
    .end local v1    # "_arg1":Landroid/net/Uri;
    .end local v2    # "_arg2":Landroid/os/Bundle;
    .end local v3    # "_arg3":Z
    :cond_0
    const/4 v1, 0x0

    .restart local v1    # "_arg1":Landroid/net/Uri;
    goto :goto_1

    .line 65
    :cond_1
    const/4 v2, 0x0

    .restart local v2    # "_arg2":Landroid/os/Bundle;
    goto :goto_2

    .line 68
    :cond_2
    const/4 v3, 0x0

    goto :goto_3

    .line 41
    nop

    :sswitch_data_0
    .sparse-switch
        0x1 -> :sswitch_1
        0x5f4e5446 -> :sswitch_0
    .end sparse-switch
.end method
