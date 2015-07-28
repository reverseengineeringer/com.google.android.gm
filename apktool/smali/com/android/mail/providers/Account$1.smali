.class final Lcom/android/mail/providers/Account$1;
.super Ljava/lang/Object;
.source "Account.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/providers/Account;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/android/mail/providers/Account;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 634
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/mail/providers/Account;
    .locals 1
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 637
    new-instance v0, Lcom/android/mail/providers/Account;

    invoke-direct {v0, p1}, Lcom/android/mail/providers/Account;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 634
    invoke-virtual {p0, p1}, Lcom/android/mail/providers/Account$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/mail/providers/Account;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/mail/providers/Account;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 642
    new-array v0, p1, [Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 634
    invoke-virtual {p0, p1}, Lcom/android/mail/providers/Account$1;->newArray(I)[Lcom/android/mail/providers/Account;

    move-result-object v0

    return-object v0
.end method
