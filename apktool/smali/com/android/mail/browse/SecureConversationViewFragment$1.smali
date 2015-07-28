.class Lcom/android/mail/browse/SecureConversationViewFragment$1;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;
.source "SecureConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/SecureConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/SecureConversationViewFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/SecureConversationViewFragment;)V
    .locals 0

    .prologue
    .line 63
    iput-object p1, p0, Lcom/android/mail/browse/SecureConversationViewFragment$1;->this$0:Lcom/android/mail/browse/SecureConversationViewFragment;

    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment$1;->this$0:Lcom/android/mail/browse/SecureConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/browse/SecureConversationViewFragment;->isUserVisible()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment$1;->this$0:Lcom/android/mail/browse/SecureConversationViewFragment;

    # invokes: Lcom/android/mail/browse/SecureConversationViewFragment;->onConversationSeen()V
    invoke-static {v0}, Lcom/android/mail/browse/SecureConversationViewFragment;->access$000(Lcom/android/mail/browse/SecureConversationViewFragment;)V

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/SecureConversationViewFragment$1;->this$0:Lcom/android/mail/browse/SecureConversationViewFragment;

    # invokes: Lcom/android/mail/browse/SecureConversationViewFragment;->dismissLoadingStatus()V
    invoke-static {v0}, Lcom/android/mail/browse/SecureConversationViewFragment;->access$100(Lcom/android/mail/browse/SecureConversationViewFragment;)V

    .line 71
    return-void
.end method
