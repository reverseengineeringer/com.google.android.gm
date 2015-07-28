.class Lcom/android/mail/ui/AbstractConversationViewFragment$5;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;->onError()V
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
    .line 529
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$5;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 3

    .prologue
    .line 533
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$5;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractConversationViewFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v0

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/android/mail/ui/ConversationListCallbacks;->onConversationSelected(Lcom/android/mail/providers/Conversation;Z)V

    .line 535
    return-void
.end method
