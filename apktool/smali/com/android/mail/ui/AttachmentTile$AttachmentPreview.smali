.class public final Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;
.super Ljava/lang/Object;
.source "AttachmentTile.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AttachmentTile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "AttachmentPreview"
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public attachmentIdentifier:Ljava/lang/String;

.field public preview:Landroid/graphics/Bitmap;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 242
    new-instance v0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview$1;

    invoke-direct {v0}, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview$1;-><init>()V

    sput-object v0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method private constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 255
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 256
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->attachmentIdentifier:Ljava/lang/String;

    .line 257
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->preview:Landroid/graphics/Bitmap;

    .line 258
    return-void
.end method

.method synthetic constructor <init>(Landroid/os/Parcel;Lcom/android/mail/ui/AttachmentTile$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/os/Parcel;
    .param p2, "x1"    # Lcom/android/mail/ui/AttachmentTile$1;

    .prologue
    .line 227
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;-><init>(Landroid/os/Parcel;)V

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/providers/Attachment;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "attachment"    # Lcom/android/mail/providers/Attachment;
    .param p2, "preview"    # Landroid/graphics/Bitmap;

    .prologue
    .line 260
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 261
    invoke-static {p1}, Lcom/android/mail/utils/AttachmentUtils;->getIdentifier(Lcom/android/mail/providers/Attachment;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->attachmentIdentifier:Ljava/lang/String;

    .line 262
    iput-object p2, p0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->preview:Landroid/graphics/Bitmap;

    .line 263
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 233
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 238
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->attachmentIdentifier:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 239
    iget-object v0, p0, Lcom/android/mail/ui/AttachmentTile$AttachmentPreview;->preview:Landroid/graphics/Bitmap;

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 240
    return-void
.end method
