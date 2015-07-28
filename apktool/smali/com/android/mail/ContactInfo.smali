.class public Lcom/android/mail/ContactInfo;
.super Ljava/lang/Object;
.source "ContactInfo.java"


# instance fields
.field public final contactUri:Landroid/net/Uri;

.field public final photo:Landroid/graphics/Bitmap;

.field public final status:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(Landroid/net/Uri;Ljava/lang/Integer;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "contactUri"    # Landroid/net/Uri;
    .param p2, "status"    # Ljava/lang/Integer;
    .param p3, "photo"    # Landroid/graphics/Bitmap;

    .prologue
    .line 28
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/android/mail/ContactInfo;->contactUri:Landroid/net/Uri;

    .line 30
    iput-object p2, p0, Lcom/android/mail/ContactInfo;->status:Ljava/lang/Integer;

    .line 31
    iput-object p3, p0, Lcom/android/mail/ContactInfo;->photo:Landroid/graphics/Bitmap;

    .line 32
    return-void
.end method


# virtual methods
.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 36
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "{status="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ContactInfo;->status:Ljava/lang/Integer;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " photo="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ContactInfo;->photo:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
