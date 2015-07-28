.class Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->onContentReady()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;Ljava/lang/String;)V
    .locals 1
    .param p2, "x0"    # Ljava/lang/String;

    .prologue
    .line 1039
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v0, p1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0, v0, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 1043
    :try_start_0
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v1, v1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadStartMs:J
    invoke-static {v1}, Lcom/android/mail/ui/ConversationViewFragment;->access$800(Lcom/android/mail/ui/ConversationViewFragment;)J

    move-result-wide v1

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_0

    .line 1044
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v1

    const-string v2, "IN CVF.onContentReady, f=%s vis=%s t=%sms"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v5, v5, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    aput-object v5, v3, v4

    const/4 v4, 0x1

    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v5, v5, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationViewFragment;->isUserVisible()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v5

    iget-object v7, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v7, v7, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadStartMs:J
    invoke-static {v7}, Lcom/android/mail/ui/ConversationViewFragment;->access$800(Lcom/android/mail/ui/ConversationViewFragment;)J

    move-result-wide v7

    sub-long/2addr v5, v7

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1049
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v1, v1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->revealConversation()V
    invoke-static {v1}, Lcom/android/mail/ui/ConversationViewFragment;->access$1100(Lcom/android/mail/ui/ConversationViewFragment;)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 1055
    :goto_0
    return-void

    .line 1050
    :catch_0
    move-exception v0

    .line 1051
    .local v0, "t":Ljava/lang/Throwable;
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Error in MailJsBridge.onContentReady"

    new-array v3, v9, [Ljava/lang/Object;

    invoke-static {v1, v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1053
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v1, v1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->revealConversation()V
    invoke-static {v1}, Lcom/android/mail/ui/ConversationViewFragment;->access$1100(Lcom/android/mail/ui/ConversationViewFragment;)V

    goto :goto_0
.end method
