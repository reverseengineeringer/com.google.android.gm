.class Lcom/android/mail/ui/ConversationViewFragment$2;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationViewFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Ljava/lang/String;

    .prologue
    .line 185
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$2;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 1

    .prologue
    .line 188
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$2;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 189
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$2;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationViewFragment;->onConversationSeen()V

    .line 191
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$2;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;
    invoke-static {v0}, Lcom/android/mail/ui/ConversationViewFragment;->access$400(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationWebView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationWebView;->onRenderComplete()V

    .line 192
    return-void
.end method
