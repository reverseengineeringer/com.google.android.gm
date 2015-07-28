.class Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->onWebContentGeometryChange([Ljava/lang/String;[Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

.field final synthetic val$overlayBottomStrs:[Ljava/lang/String;

.field final synthetic val$overlayTopStrs:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V
    .locals 1
    .param p2, "x0"    # Ljava/lang/String;

    .prologue
    .line 967
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iput-object p3, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->val$overlayTopStrs:[Ljava/lang/String;

    iput-object p4, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->val$overlayBottomStrs:[Ljava/lang/String;

    iget-object v0, p1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0, v0, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 972
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v2, v2, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$700(Lcom/android/mail/ui/ConversationViewFragment;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 973
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v2

    const-string v3, "ignoring webContentGeometryChange because views are gone, %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v6, v6, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 990
    :cond_0
    :goto_0
    return-void

    .line 977
    :cond_1
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v2, v2, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mConversationContainer:Lcom/android/mail/browse/ConversationContainer;
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$1300(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationContainer;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->val$overlayTopStrs:[Ljava/lang/String;

    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->val$overlayBottomStrs:[Ljava/lang/String;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->parsePositions([Ljava/lang/String;[Ljava/lang/String;)[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    invoke-static {v3, v4}, Lcom/android/mail/ui/ConversationViewFragment;->access$1200([Ljava/lang/String;[Ljava/lang/String;)[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/android/mail/browse/ConversationContainer;->onGeometryChange([Lcom/android/mail/browse/ConversationContainer$OverlayPosition;)V

    .line 979
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v2, v2, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$1400(Lcom/android/mail/ui/ConversationViewFragment;)I

    move-result v2

    if-eqz v2, :cond_0

    .line 981
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v2, v2, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$400(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationWebView;

    move-result-object v2

    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationWebView;->getScale()F

    move-result v2

    iget-object v3, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v3, v3, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;
    invoke-static {v3}, Lcom/android/mail/ui/ConversationViewFragment;->access$400(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationWebView;

    move-result-object v3

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationWebView;->getInitialScale()F

    move-result v3

    div-float/2addr v2, v3

    float-to-int v0, v2

    .line 982
    .local v0, "scale":I
    if-le v0, v5, :cond_2

    .line 983
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v2, v2, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebView:Lcom/android/mail/browse/ConversationWebView;
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$400(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/browse/ConversationWebView;

    move-result-object v2

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v4, v4, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I
    invoke-static {v4}, Lcom/android/mail/ui/ConversationViewFragment;->access$1400(Lcom/android/mail/ui/ConversationViewFragment;)I

    move-result v4

    add-int/lit8 v5, v0, -0x1

    mul-int/2addr v4, v5

    invoke-virtual {v2, v3, v4}, Lcom/android/mail/browse/ConversationWebView;->scrollBy(II)V

    .line 985
    :cond_2
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;

    iget-object v2, v2, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    const/4 v3, 0x0

    # setter for: Lcom/android/mail/ui/ConversationViewFragment;->mDiff:I
    invoke-static {v2, v3}, Lcom/android/mail/ui/ConversationViewFragment;->access$1402(Lcom/android/mail/ui/ConversationViewFragment;I)I
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 987
    .end local v0    # "scale":I
    :catch_0
    move-exception v1

    .line 988
    .local v1, "t":Ljava/lang/Throwable;
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Error in MailJsBridge.onWebContentGeometryChange"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v2, v1, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
