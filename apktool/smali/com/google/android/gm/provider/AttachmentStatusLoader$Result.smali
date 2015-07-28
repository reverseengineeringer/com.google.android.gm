.class public Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
.super Ljava/lang/Object;
.source "AttachmentStatusLoader.java"

# interfaces
.implements Lcom/google/android/gm/provider/uiprovider/UIAttachment;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/AttachmentStatusLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Result"
.end annotation


# instance fields
.field public contentType:Ljava/lang/String;

.field public final conversationId:J

.field public downloadStatus:I

.field public downloadedSize:I

.field public final fileName:Ljava/lang/String;

.field public mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

.field public final messageId:J

.field public final partId:Ljava/lang/String;

.field public final rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

.field public final saveToSd:Z

.field public size:I

.field public final state:I

.field public final status:I

.field private transientDestination:Ljava/lang/Integer;

.field private transientSavedFileUri:Ljava/lang/String;

.field private transientStatus:Ljava/lang/Integer;


# direct methods
.method public constructor <init>(JJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 1
    .param p1, "conversationId"    # J
    .param p3, "messageId"    # J
    .param p5, "partId"    # Ljava/lang/String;
    .param p6, "saveToSd"    # Z
    .param p7, "fileName"    # Ljava/lang/String;
    .param p8, "mimeType"    # Ljava/lang/String;
    .param p9, "status"    # I
    .param p10, "rendition"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 80
    iput-wide p1, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->conversationId:J

    .line 81
    iput-wide p3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    .line 82
    iput-object p5, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->partId:Ljava/lang/String;

    .line 83
    iput-boolean p6, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->saveToSd:Z

    .line 84
    iput-object p7, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->fileName:Ljava/lang/String;

    .line 85
    iput-object p8, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->contentType:Ljava/lang/String;

    .line 86
    iput p9, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    .line 87
    invoke-static {p10}, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->valueOf(Ljava/lang/String;)Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->rendition:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    .line 89
    invoke-static {p9}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {p7}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadStillPresent(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 91
    if-eqz p6, :cond_0

    const/4 v0, 0x3

    :goto_0
    iput v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    .line 97
    :goto_1
    return-void

    .line 91
    :cond_0
    const/4 v0, 0x2

    goto :goto_0

    .line 92
    :cond_1
    invoke-static {p9}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusRunning(I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 93
    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    goto :goto_1

    .line 95
    :cond_2
    const/4 v0, 0x0

    iput v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    goto :goto_1
.end method

.method private updatedToCompleteState()Z
    .locals 2

    .prologue
    .line 298
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientSavedFileUri:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public downloadCompletedSuccessfully()Z
    .locals 2

    .prologue
    .line 294
    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->getStatus()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "object"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 101
    if-ne p1, p0, :cond_1

    .line 110
    :cond_0
    :goto_0
    return v1

    .line 105
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    .line 106
    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 109
    check-cast v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;

    .line 110
    .local v0, "other":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    iget-wide v3, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    iget-wide v5, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    cmp-long v3, v3, v5

    if-nez v3, :cond_4

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->partId:Ljava/lang/String;

    iget-object v4, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->partId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->contentType:Ljava/lang/String;

    return-object v0
.end method

.method public getDestination()I
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientDestination:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    .line 269
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientDestination:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 271
    :goto_0
    return v0

    :cond_0
    iget-boolean v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->saveToSd:Z

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
    .line 204
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->downloadedSize:I

    return v0
.end method

.method public getExternalFilePath()Landroid/net/Uri;
    .locals 2

    .prologue
    .line 222
    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isDownloadedToSd()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->fileName:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 231
    :goto_0
    return-object v0

    .line 224
    :cond_0
    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->getStatus()I

    move-result v0

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->getDestination()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientSavedFileUri:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 229
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientSavedFileUri:Ljava/lang/String;

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    goto :goto_0

    .line 231
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getJoinedAttachmentInfo()Ljava/lang/String;
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$Attachment;->toJoinedString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 210
    iget-object v2, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    if-eqz v2, :cond_0

    .line 211
    iget-object v2, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$Attachment;->getName()Ljava/lang/String;

    move-result-object v1

    .line 212
    .local v1, "gmailAttachmentName":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 217
    .end local v1    # "gmailAttachmentName":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 216
    :cond_0
    iget-object v2, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->fileName:Ljava/lang/String;

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 217
    .local v0, "fileUri":Landroid/net/Uri;
    invoke-virtual {v0}, Landroid/net/Uri;->getLastPathSegment()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getOrigin()Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
    .locals 1

    .prologue
    .line 184
    const/4 v0, 0x0

    return-object v0
.end method

.method public getOriginExtras()Ljava/lang/String;
    .locals 1

    .prologue
    .line 189
    const/4 v0, 0x0

    return-object v0
.end method

.method public getOriginal()Lcom/google/android/gm/provider/Gmail$Attachment;
    .locals 1

    .prologue
    .line 277
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    return-object v0
.end method

.method public getPartId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->partId:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()I
    .locals 3

    .prologue
    .line 194
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$Attachment;->getSize()I

    move-result v0

    if-eqz v0, :cond_0

    .line 195
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->mOriginalAttachment:Lcom/google/android/gm/provider/Gmail$Attachment;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/Gmail$Attachment;->getSize()I

    move-result v0

    .line 199
    :goto_0
    return v0

    .line 198
    :cond_0
    const-string v0, "Gmail"

    const-string v1, "Returning inaccurate attachment size"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 199
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->downloadedSize:I

    goto :goto_0
.end method

.method public getStatus()I
    .locals 3

    .prologue
    const/4 v1, 0x2

    const/4 v0, 0x1

    .line 236
    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isStatusError()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 257
    :goto_0
    return v0

    .line 238
    :cond_0
    iget v2, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    if-ne v2, v0, :cond_1

    move v0, v1

    .line 239
    goto :goto_0

    .line 240
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    if-eqz v0, :cond_4

    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->fileName:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isDownloadStillPresent(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_2
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusPending(I)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-ne v0, v1, :cond_4

    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusError(I)Z

    move-result v0

    if-nez v0, :cond_3

    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 253
    :cond_3
    iget-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    goto :goto_0

    .line 254
    :cond_4
    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isDownloadedToSd()Z

    move-result v0

    if-nez v0, :cond_5

    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->isDownloadedToCache()Z

    move-result v0

    if-nez v0, :cond_5

    invoke-direct {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->updatedToCompleteState()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 255
    :cond_5
    const/4 v0, 0x3

    goto :goto_0

    .line 257
    :cond_6
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 4

    .prologue
    .line 115
    iget-wide v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    iget-object v2, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->partId:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    int-to-long v2, v2

    xor-long/2addr v0, v2

    long-to-int v0, v0

    return v0
.end method

.method public isDownloadedToCache()Z
    .locals 2

    .prologue
    .line 139
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDownloadedToSd()Z
    .locals 2

    .prologue
    .line 135
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isDownloading()Z
    .locals 2

    .prologue
    .line 131
    invoke-virtual {p0}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->getStatus()I

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

.method public isStatusError()Z
    .locals 2

    .prologue
    .line 168
    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 169
    .local v0, "statusValue":I
    :goto_0
    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusError(I)Z

    move-result v1

    return v1

    .line 168
    .end local v0    # "statusValue":I
    :cond_0
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    goto :goto_0
.end method

.method public isStatusPaused()Z
    .locals 2

    .prologue
    .line 158
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusPaused(I)Z

    move-result v0

    if-nez v0, :cond_0

    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->downloadStatus:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isStatusPending()Z
    .locals 1

    .prologue
    .line 147
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusPending(I)Z

    move-result v0

    return v0
.end method

.method public isStatusSuccess()Z
    .locals 2

    .prologue
    .line 163
    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 164
    .local v0, "statusValue":I
    :goto_0
    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusSuccess(I)Z

    move-result v1

    return v1

    .line 163
    .end local v0    # "statusValue":I
    :cond_0
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    goto :goto_0
.end method

.method public isStatusValid()Z
    .locals 1

    .prologue
    .line 143
    iget v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v0}, Lcom/google/android/gm/provider/AttachmentManager;->isStatusValid(I)Z

    move-result v0

    return v0
.end method

.method public supportsOrigin()Z
    .locals 1

    .prologue
    .line 179
    const/4 v0, 0x0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 120
    const-string v0, "Result: conv=%d msg=%d part=%s fname=%s status=%d state=%d size=%d dled=%d transientStatus=%s, transientDestination=%s, transientFile=%s"

    const/16 v1, 0xb

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-wide v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->conversationId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    iget-wide v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->messageId:J

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->partId:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x3

    iget-object v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->fileName:Ljava/lang/String;

    aput-object v3, v1, v2

    const/4 v2, 0x4

    iget v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->status:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x5

    iget v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->state:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x6

    iget v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->size:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x7

    iget v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->downloadedSize:I

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    const/16 v2, 0x8

    iget-object v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    aput-object v3, v1, v2

    const/16 v2, 0x9

    iget-object v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientDestination:Ljava/lang/Integer;

    aput-object v3, v1, v2

    const/16 v2, 0xa

    iget-object v3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientSavedFileUri:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public updateState(IILjava/lang/String;)V
    .locals 1
    .param p1, "attachmentState"    # I
    .param p2, "destination"    # I
    .param p3, "savedFileUri"    # Ljava/lang/String;

    .prologue
    .line 287
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientStatus:Ljava/lang/Integer;

    .line 288
    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientDestination:Ljava/lang/Integer;

    .line 289
    iput-object p3, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->transientSavedFileUri:Ljava/lang/String;

    .line 290
    return-void
.end method
