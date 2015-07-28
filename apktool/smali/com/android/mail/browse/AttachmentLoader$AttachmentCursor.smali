.class public Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;
.super Landroid/database/CursorWrapper;
.source "AttachmentLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/AttachmentLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AttachmentCursor"
.end annotation


# instance fields
.field private mCache:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "inner"    # Landroid/database/Cursor;

    .prologue
    .line 49
    invoke-direct {p0, p1}, Landroid/database/CursorWrapper;-><init>(Landroid/database/Cursor;)V

    .line 46
    invoke-static {}, Lcom/google/common/collect/Maps;->newHashMap()Ljava/util/HashMap;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->mCache:Ljava/util/Map;

    .line 50
    return-void
.end method

.method synthetic constructor <init>(Landroid/database/Cursor;Lcom/android/mail/browse/AttachmentLoader$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/database/Cursor;
    .param p2, "x1"    # Lcom/android/mail/browse/AttachmentLoader$1;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;-><init>(Landroid/database/Cursor;)V

    return-void
.end method


# virtual methods
.method public get()Lcom/android/mail/providers/Attachment;
    .locals 4

    .prologue
    .line 53
    invoke-virtual {p0}, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->getWrappedCursor()Landroid/database/Cursor;

    move-result-object v2

    const/4 v3, 0x2

    invoke-interface {v2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 54
    .local v1, "uri":Ljava/lang/String;
    iget-object v2, p0, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->mCache:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Attachment;

    .line 55
    .local v0, "m":Lcom/android/mail/providers/Attachment;
    if-nez v0, :cond_0

    .line 56
    new-instance v0, Lcom/android/mail/providers/Attachment;

    .end local v0    # "m":Lcom/android/mail/providers/Attachment;
    invoke-direct {v0, p0}, Lcom/android/mail/providers/Attachment;-><init>(Landroid/database/Cursor;)V

    .line 57
    .restart local v0    # "m":Lcom/android/mail/providers/Attachment;
    iget-object v2, p0, Lcom/android/mail/browse/AttachmentLoader$AttachmentCursor;->mCache:Ljava/util/Map;

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    :cond_0
    return-object v0
.end method
