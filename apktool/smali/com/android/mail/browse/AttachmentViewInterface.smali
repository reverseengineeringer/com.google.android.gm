.class public interface abstract Lcom/android/mail/browse/AttachmentViewInterface;
.super Ljava/lang/Object;
.source "AttachmentViewInterface.java"


# virtual methods
.method public abstract getAttachments()Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Attachment;",
            ">;"
        }
    .end annotation
.end method

.method public abstract onUpdateStatus()V
.end method

.method public abstract updateProgress(Z)V
.end method

.method public abstract viewAttachment()V
.end method
