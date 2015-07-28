.class Lcom/android/mail/ui/AbstractConversationViewFragment$1;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Ljava/lang/String;

    .prologue
    .line 126
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$1;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 3

    .prologue
    .line 129
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$1;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    # setter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mLoadingShownTime:J
    invoke-static {v0, v1, v2}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$102(Lcom/android/mail/ui/AbstractConversationViewFragment;J)J

    .line 130
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$1;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mProgressView:Landroid/view/View;
    invoke-static {v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$200(Lcom/android/mail/ui/AbstractConversationViewFragment;)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 131
    return-void
.end method
