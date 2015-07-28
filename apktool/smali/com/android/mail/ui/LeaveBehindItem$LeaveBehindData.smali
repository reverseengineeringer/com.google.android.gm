.class public Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;
.super Ljava/lang/Object;
.source "LeaveBehindItem.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/LeaveBehindItem;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "LeaveBehindData"
.end annotation


# instance fields
.field public final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;",
            ">;"
        }
    .end annotation
.end field

.field data:Lcom/android/mail/providers/Conversation;

.field op:Lcom/android/mail/ui/ToastBarOperation;

.field final synthetic this$0:Lcom/android/mail/ui/LeaveBehindItem;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/LeaveBehindItem;Landroid/os/Parcel;)V
    .locals 2
    .param p2, "arg"    # Landroid/os/Parcel;

    .prologue
    const/4 v1, 0x0

    .line 169
    invoke-virtual {p2, v1}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    invoke-virtual {p2, v1}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/ToastBarOperation;

    invoke-direct {p0, p1, v0, v1}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;-><init>(Lcom/android/mail/ui/LeaveBehindItem;Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ToastBarOperation;)V

    .line 171
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/LeaveBehindItem;Landroid/os/Parcel;Lcom/android/mail/ui/LeaveBehindItem$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/LeaveBehindItem;
    .param p2, "x1"    # Landroid/os/Parcel;
    .param p3, "x2"    # Lcom/android/mail/ui/LeaveBehindItem$1;

    .prologue
    .line 148
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;-><init>(Lcom/android/mail/ui/LeaveBehindItem;Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/LeaveBehindItem;Lcom/android/mail/providers/Conversation;Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 1
    .param p2, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p3, "undoOp"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    .line 152
    iput-object p1, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->this$0:Lcom/android/mail/ui/LeaveBehindItem;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 173
    new-instance v0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData$1;-><init>(Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;)V

    iput-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->CREATOR:Landroid/os/Parcelable$Creator;

    .line 153
    iput-object p3, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->op:Lcom/android/mail/ui/ToastBarOperation;

    .line 154
    iput-object p2, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->data:Lcom/android/mail/providers/Conversation;

    .line 155
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 159
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "arg"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x0

    .line 164
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->op:Lcom/android/mail/ui/ToastBarOperation;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 165
    iget-object v0, p0, Lcom/android/mail/ui/LeaveBehindItem$LeaveBehindData;->data:Lcom/android/mail/providers/Conversation;

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 166
    return-void
.end method
