.class public interface abstract Lcom/android/mail/ui/ConversationListCallbacks;
.super Ljava/lang/Object;
.source "ConversationListCallbacks.java"


# virtual methods
.method public abstract commitDestructiveActions(Z)V
.end method

.method public abstract getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;
.end method

.method public abstract getCurrentConversation()Lcom/android/mail/providers/Conversation;
.end method

.method public abstract isAnimating()Z
.end method

.method public abstract isInitialConversationLoading()Z
.end method

.method public abstract onConversationSeen(Lcom/android/mail/providers/Conversation;)V
.end method

.method public abstract onConversationSelected(Lcom/android/mail/providers/Conversation;Z)V
.end method

.method public abstract registerConversationListObserver(Landroid/database/DataSetObserver;)V
.end method

.method public abstract registerConversationLoadedObserver(Landroid/database/DataSetObserver;)V
.end method

.method public abstract setCurrentConversation(Lcom/android/mail/providers/Conversation;)V
.end method

.method public abstract unregisterConversationListObserver(Landroid/database/DataSetObserver;)V
.end method

.method public abstract unregisterConversationLoadedObserver(Landroid/database/DataSetObserver;)V
.end method
