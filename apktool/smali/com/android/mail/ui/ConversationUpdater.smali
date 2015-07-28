.class public interface abstract Lcom/android/mail/ui/ConversationUpdater;
.super Ljava/lang/Object;
.source "ConversationUpdater.java"

# interfaces
.implements Lcom/android/mail/ui/ConversationListCallbacks;


# virtual methods
.method public abstract assignFolder(Ljava/util/Collection;Ljava/util/Collection;ZZ)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;ZZ)V"
        }
    .end annotation
.end method

.method public abstract delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation
.end method

.method public abstract delete(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationItemView;",
            ">;",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation
.end method

.method public abstract getBatchAction(I)Lcom/android/mail/ui/DestructiveAction;
.end method

.method public abstract getDeferredBatchAction(I)Lcom/android/mail/ui/DestructiveAction;
.end method

.method public abstract getDeferredRemoveFolder(Ljava/util/Collection;Lcom/android/mail/providers/Folder;ZZZ)Lcom/android/mail/ui/DestructiveAction;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/providers/Folder;",
            "ZZZ)",
            "Lcom/android/mail/ui/DestructiveAction;"
        }
    .end annotation
.end method

.method public abstract markConversationMessagesUnread(Lcom/android/mail/providers/Conversation;Ljava/util/Set;Ljava/lang/String;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/providers/Conversation;",
            "Ljava/util/Set",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation
.end method

.method public abstract markConversationsRead(Ljava/util/Collection;ZZ)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;ZZ)V"
        }
    .end annotation
.end method

.method public abstract refreshConversationList()V
.end method

.method public abstract showNextConversation(Ljava/util/Collection;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)V"
        }
    .end annotation
.end method

.method public abstract starMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)V
.end method

.method public abstract updateConversation(Ljava/util/Collection;Ljava/lang/String;I)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation
.end method

.method public abstract updateConversation(Ljava/util/Collection;Ljava/lang/String;Z)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation
.end method
