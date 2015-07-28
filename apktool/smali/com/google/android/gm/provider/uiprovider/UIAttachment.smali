.class public interface abstract Lcom/google/android/gm/provider/uiprovider/UIAttachment;
.super Ljava/lang/Object;
.source "UIAttachment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/uiprovider/UIAttachment$UriParser;
    }
.end annotation


# virtual methods
.method public abstract downloadCompletedSuccessfully()Z
.end method

.method public abstract getContentType()Ljava/lang/String;
.end method

.method public abstract getDestination()I
.end method

.method public abstract getDownloadedSize()I
.end method

.method public abstract getExternalFilePath()Landroid/net/Uri;
.end method

.method public abstract getJoinedAttachmentInfo()Ljava/lang/String;
.end method

.method public abstract getName()Ljava/lang/String;
.end method

.method public abstract getOrigin()Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;
.end method

.method public abstract getOriginExtras()Ljava/lang/String;
.end method

.method public abstract getOriginal()Lcom/google/android/gm/provider/Gmail$Attachment;
.end method

.method public abstract getPartId()Ljava/lang/String;
.end method

.method public abstract getSize()I
.end method

.method public abstract getStatus()I
.end method

.method public abstract isDownloading()Z
.end method

.method public abstract supportsOrigin()Z
.end method

.method public abstract updateState(IILjava/lang/String;)V
.end method
