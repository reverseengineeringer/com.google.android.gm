.class Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;
.super Ljava/lang/Object;
.source "LeaveBehindItem.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;)V
    .locals 0

    .prologue
    .line 173
    iput-object p1, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;->this$1:Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
    .locals 3
    .param p1, "source"    # Landroid/os/Parcel;

    .prologue
    .line 177
    new-instance v0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    iget-object v1, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;->this$1:Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    iget-object v1, v1, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->this$0:Lcom/android/mail/ui/LeaveBehindItem;

    const/4 v2, 0x0

    invoke-direct {v0, v1, p1, v2}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;-><init>(Lcom/android/mail/ui/LeaveBehindItem;Landroid/os/Parcel;Lcom/android/mail/ui/LeaveBehindItem$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 173
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;->createFromParcel(Landroid/os/Parcel;)Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 182
    new-array v0, p1, [Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 173
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;->newArray(I)[Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;

    move-result-object v0

    return-object v0
.end method
