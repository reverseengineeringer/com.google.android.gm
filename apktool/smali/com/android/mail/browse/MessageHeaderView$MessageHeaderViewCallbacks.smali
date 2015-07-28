.class public interface abstract Lcom/android/mail/browse/MessageHeaderView$MessageHeaderViewCallbacks;
.super Ljava/lang/Object;
.source "MessageHeaderView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/MessageHeaderView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "MessageHeaderViewCallbacks"
.end annotation


# virtual methods
.method public abstract setMessageDetailsExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;ZI)V
.end method

.method public abstract setMessageExpanded(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V
.end method

.method public abstract setMessageSpacerHeight(Lcom/android/mail/browse/ConversationViewAdapter$MessageHeaderItem;I)V
.end method

.method public abstract showExternalResources(Lcom/android/mail/providers/Message;)V
.end method
