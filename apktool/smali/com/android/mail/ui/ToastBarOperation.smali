.class public Lcom/android/mail/ui/ToastBarOperation;
.super Ljava/lang/Object;
.source "ToastBarOperation.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/ui/ToastBarOperation;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final mAction:I

.field private final mBatch:Z

.field private final mCount:I

.field private final mType:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 76
    new-instance v0, Lcom/android/mail/ui/ToastBarOperation$1;

    invoke-direct {v0}, Lcom/android/mail/ui/ToastBarOperation$1;-><init>()V

    sput-object v0, Lcom/android/mail/ui/ToastBarOperation;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(IIIZ)V
    .locals 0
    .param p1, "count"    # I
    .param p2, "menuId"    # I
    .param p3, "type"    # I
    .param p4, "batch"    # Z

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 46
    iput p1, p0, Lcom/android/mail/ui/ToastBarOperation;->mCount:I

    .line 47
    iput p2, p0, Lcom/android/mail/ui/ToastBarOperation;->mAction:I

    .line 48
    iput-boolean p4, p0, Lcom/android/mail/ui/ToastBarOperation;->mBatch:Z

    .line 49
    iput p3, p0, Lcom/android/mail/ui/ToastBarOperation;->mType:I

    .line 50
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 60
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 61
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mCount:I

    .line 62
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mAction:I

    .line 63
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mBatch:Z

    .line 64
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mType:I

    .line 65
    return-void

    .line 63
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 151
    const/4 v0, 0x0

    return v0
.end method

.method public getDescription(Landroid/content/Context;Lcom/android/mail/providers/Folder;)Ljava/lang/String;
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 93
    const/4 v1, -0x1

    .line 94
    .local v1, "resId":I
    iget v2, p0, Lcom/android/mail/ui/ToastBarOperation;->mAction:I

    packed-switch v2, :pswitch_data_0

    .line 125
    :pswitch_0
    const/4 v1, -0x1

    .line 128
    :goto_0
    const/4 v2, -0x1

    if-ne v1, v2, :cond_0

    const-string v0, ""

    .line 130
    :goto_1
    return-object v0

    .line 96
    :pswitch_1
    const v1, 0x7f110012

    .line 97
    goto :goto_0

    .line 99
    :pswitch_2
    const v2, 0x7f0c00a2

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v4, p2, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-virtual {p1, v2, v3}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 101
    :pswitch_3
    const v1, 0x7f110017

    .line 102
    goto :goto_0

    .line 104
    :pswitch_4
    const v1, 0x7f110010

    .line 105
    goto :goto_0

    .line 107
    :pswitch_5
    const v1, 0x7f11000c

    .line 108
    goto :goto_0

    .line 110
    :pswitch_6
    const v1, 0x7f11000d

    .line 111
    goto :goto_0

    .line 113
    :pswitch_7
    const v1, 0x7f11000e

    .line 114
    goto :goto_0

    .line 116
    :pswitch_8
    const v1, 0x7f11000b

    .line 117
    goto :goto_0

    .line 119
    :pswitch_9
    const v1, 0x7f110009

    .line 120
    goto :goto_0

    .line 122
    :pswitch_a
    const v1, 0x7f11000f

    .line 123
    goto :goto_0

    .line 128
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    iget v3, p0, Lcom/android/mail/ui/ToastBarOperation;->mCount:I

    invoke-virtual {v2, v1, v3}, Landroid/content/res/Resources;->getQuantityString(II)Ljava/lang/String;

    move-result-object v2

    new-array v3, v4, [Ljava/lang/Object;

    iget v4, p0, Lcom/android/mail/ui/ToastBarOperation;->mCount:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 94
    :pswitch_data_0
    .packed-switch 0x7f100123
        :pswitch_4
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_5
        :pswitch_6
        :pswitch_a
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_9
    .end packed-switch
.end method

.method public getSingularDescription(Landroid/content/Context;Lcom/android/mail/providers/Folder;)Ljava/lang/String;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 134
    iget v1, p0, Lcom/android/mail/ui/ToastBarOperation;->mAction:I

    const v2, 0x7f100124

    if-ne v1, v2, :cond_0

    .line 135
    const v1, 0x7f0c00a2

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p2, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-virtual {p1, v1, v2}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 146
    :goto_0
    return-object v1

    .line 137
    :cond_0
    const/4 v0, -0x1

    .line 138
    .local v0, "resId":I
    iget v1, p0, Lcom/android/mail/ui/ToastBarOperation;->mAction:I

    packed-switch v1, :pswitch_data_0

    .line 146
    :goto_1
    :pswitch_0
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    const-string v1, ""

    goto :goto_0

    .line 140
    :pswitch_1
    const v0, 0x7f0c00a0

    .line 141
    goto :goto_1

    .line 143
    :pswitch_2
    const v0, 0x7f0c00a1

    goto :goto_1

    .line 146
    :cond_1
    invoke-virtual {p1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 138
    :pswitch_data_0
    .packed-switch 0x7f100123
        :pswitch_2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 53
    iget v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mType:I

    return v0
.end method

.method public isBatchUndo()Z
    .locals 1

    .prologue
    .line 57
    iget-boolean v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mBatch:Z

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 69
    iget v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 70
    iget v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mAction:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 71
    iget-boolean v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mBatch:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 72
    iget v0, p0, Lcom/android/mail/ui/ToastBarOperation;->mType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 73
    return-void

    .line 71
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
