.class public interface abstract Lcom/android/mail/compose/ComposeActivity$SendOrSaveCallback;
.super Ljava/lang/Object;
.source "ComposeActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/compose/ComposeActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "SendOrSaveCallback"
.end annotation


# virtual methods
.method public abstract getMessage()Lcom/android/mail/providers/Message;
.end method

.method public abstract initializeSendOrSave(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;)V
.end method

.method public abstract notifyMessageIdAllocated(Lcom/android/mail/compose/ComposeActivity$SendOrSaveMessage;Lcom/android/mail/providers/Message;)V
.end method

.method public abstract sendOrSaveFinished(Lcom/android/mail/compose/ComposeActivity$SendOrSaveTask;Z)V
.end method
