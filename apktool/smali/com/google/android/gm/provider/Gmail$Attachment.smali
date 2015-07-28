.class public final Lcom/google/android/gm/provider/Gmail$Attachment;
.super Ljava/lang/Object;
.source "Gmail.java"

# interfaces
.implements Lcom/google/android/gm/provider/uiprovider/UIAttachment;
.implements Ljava/io/Serializable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/Gmail;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Attachment"
.end annotation


# static fields
.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public cachedContent:Ljava/lang/String;

.field public contentType:Ljava/lang/String;

.field public name:Ljava/lang/String;

.field public origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

.field public originExtras:Ljava/lang/String;

.field public partId:Ljava/lang/String;

.field public simpleContentType:Ljava/lang/String;

.field public size:I

.field private transientDestination:Ljava/lang/Integer;

.field private transientSavedFileUri:Ljava/lang/String;

.field private transientStatus:Ljava/lang/Integer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2611
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static parseJoinedString(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$Attachment;
    .locals 10
    .param p0, "joinedString"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    const/4 v9, 0x7

    .line 2701
    const-string v7, "\\|"

    invoke-static {p0, v7}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 2702
    .local v2, "fragments":[Ljava/lang/String;
    array-length v7, v2

    if-ge v7, v9, :cond_0

    move-object v0, v6

    .line 2733
    :goto_0
    return-object v0

    .line 2705
    :cond_0
    const/4 v3, 0x0

    .line 2706
    .local v3, "i":I
    new-instance v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    invoke-direct {v0}, Lcom/google/android/gm/provider/Gmail$Attachment;-><init>()V

    .line 2707
    .local v0, "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "i":I
    .local v4, "i":I
    aget-object v7, v2, v3

    iput-object v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    .line 2708
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    aget-object v7, v2, v4

    iput-object v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    .line 2709
    iget-object v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    add-int/lit8 v4, v3, 0x1

    .end local v3    # "i":I
    .restart local v4    # "i":I
    aget-object v8, v2, v3

    invoke-static {v7, v8}, Lcom/google/android/gm/provider/MimeType;->inferMimeType(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    iput-object v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    .line 2711
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    :try_start_0
    aget-object v7, v2, v4

    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v7

    iput v7, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 2715
    iget-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    add-int/lit8 v4, v3, 0x1

    .end local v3    # "i":I
    .restart local v4    # "i":I
    aget-object v7, v2, v3

    invoke-static {v6, v7}, Lcom/google/android/gm/provider/MimeType;->inferMimeType(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    iput-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->simpleContentType:Ljava/lang/String;

    .line 2719
    :try_start_1
    aget-object v6, v2, v4

    invoke-static {v6}, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    move-result-object v6

    iput-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1

    .line 2728
    :goto_1
    add-int/lit8 v3, v4, 0x1

    .line 2729
    .end local v4    # "i":I
    .restart local v3    # "i":I
    add-int/lit8 v4, v3, 0x1

    .end local v3    # "i":I
    .restart local v4    # "i":I
    aget-object v6, v2, v3

    iput-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    .line 2730
    array-length v6, v2

    if-le v6, v9, :cond_2

    .line 2731
    add-int/lit8 v3, v4, 0x1

    .end local v4    # "i":I
    .restart local v3    # "i":I
    aget-object v6, v2, v4

    iput-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    goto :goto_0

    .line 2712
    :catch_0
    move-exception v1

    .local v1, "e":Ljava/lang/NumberFormatException;
    move-object v0, v6

    .line 2713
    goto :goto_0

    .line 2720
    .end local v1    # "e":Ljava/lang/NumberFormatException;
    .end local v3    # "i":I
    .restart local v4    # "i":I
    :catch_1
    move-exception v1

    .line 2721
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    aget-object v6, v2, v4

    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    .line 2722
    .local v5, "origin":I
    if-nez v5, :cond_1

    .line 2723
    sget-object v6, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->SERVER_ATTACHMENT:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    iput-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    goto :goto_1

    .line 2725
    :cond_1
    sget-object v6, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->LOCAL_FILE:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    iput-object v6, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    goto :goto_1

    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    .end local v5    # "origin":I
    :cond_2
    move v3, v4

    .end local v4    # "i":I
    .restart local v3    # "i":I
    goto :goto_0
.end method


# virtual methods
.method public downloadCompletedSuccessfully()Z
    .locals 2

    .prologue
    const/4 v1, 0x3

    .line 2825
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$Attachment;->getStatus()I

    move-result v0

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientSavedFileUri:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientStatus:Ljava/lang/Integer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 5
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 2674
    if-ne p1, p0, :cond_1

    .line 2685
    :cond_0
    :goto_0
    return v1

    .line 2678
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 2679
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 2682
    check-cast v0, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 2685
    .local v0, "other":Lcom/google/android/gm/provider/Gmail$Attachment;
    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    if-eqz v3, :cond_4

    iget-object v3, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    iget-object v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    iget-object v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    iget-object v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    iget v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    iget v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    if-ne v3, v4, :cond_4

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    iget-object v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    if-ne v3, v4, :cond_4

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    iget-object v4, v0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 2

    .prologue
    .line 2790
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/MimeType;->inferMimeType(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDestination()I
    .locals 1

    .prologue
    .line 2795
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientDestination:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    .line 2796
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientDestination:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2801
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getDownloadedSize()I
    .locals 1

    .prologue
    .line 2763
    const/4 v0, 0x0

    return v0
.end method

.method public getExternalFilePath()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 2773
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientSavedFileUri:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientSavedFileUri:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getJoinedAttachmentInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2813
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$Attachment;->toJoinedString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2768
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getOrigin()Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    .locals 1

    .prologue
    .line 2748
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    return-object v0
.end method

.method public getOriginExtras()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2753
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    return-object v0
.end method

.method public getOriginal()Lcom/google/android/gm/provider/Gmail$Attachment;
    .locals 0

    .prologue
    .line 2808
    return-object p0
.end method

.method public getPartId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 2738
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()I
    .locals 1

    .prologue
    .line 2758
    iget v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    return v0
.end method

.method public getStatus()I
    .locals 1

    .prologue
    .line 2778
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientStatus:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    .line 2779
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 2783
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x3

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 3

    .prologue
    .line 2693
    const/4 v0, 0x6

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget v2, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x4

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    aput-object v2, v0, v1

    const/4 v1, 0x5

    iget-object v2, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v2, v0, v1

    invoke-static {v0}, Lcom/google/common/base/Objects;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public isDownloading()Z
    .locals 2

    .prologue
    .line 2832
    invoke-virtual {p0}, Lcom/google/android/gm/provider/Gmail$Attachment;->getStatus()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public supportsOrigin()Z
    .locals 1

    .prologue
    .line 2743
    const/4 v0, 0x1

    return v0
.end method

.method public toJoinedString()Ljava/lang/String;
    .locals 6

    .prologue
    .line 2645
    const-string v1, "|"

    const/16 v0, 0x8

    new-array v2, v0, [Ljava/io/Serializable;

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    if-nez v0, :cond_0

    const-string v0, ""

    :goto_0
    aput-object v0, v2, v3

    const/4 v3, 0x1

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    if-nez v0, :cond_1

    const-string v0, ""

    :goto_1
    aput-object v0, v2, v3

    const/4 v0, 0x2

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    aput-object v3, v2, v0

    const/4 v0, 0x3

    iget v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v0, 0x4

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->simpleContentType:Ljava/lang/String;

    aput-object v3, v2, v0

    const/4 v0, 0x5

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v0

    const/4 v0, 0x6

    iget-object v3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v3, v2, v0

    const/4 v3, 0x7

    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    if-nez v0, :cond_2

    const-string v0, ""

    :goto_2
    aput-object v0, v2, v3

    invoke-static {v2}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    const-string v4, "[|\n]"

    const-string v5, ""

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    :cond_2
    iget-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    goto :goto_2
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    const/16 v2, 0x27

    .line 2660
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Attachment{contentType=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", partId=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", name=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", size="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->size:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", simpleContentType=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->simpleContentType:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", origin="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", originExtras=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", cachedContent=\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateState(IILjava/lang/String;)V
    .locals 1
    .param p1, "attachmentState"    # I
    .param p2, "destination"    # I
    .param p3, "savedFileUri"    # Ljava/lang/String;

    .prologue
    .line 2818
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientStatus:Ljava/lang/Integer;

    .line 2819
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientDestination:Ljava/lang/Integer;

    .line 2820
    iput-object p3, p0, Lcom/google/android/gm/provider/Gmail$Attachment;->transientSavedFileUri:Ljava/lang/String;

    .line 2821
    return-void
.end method
