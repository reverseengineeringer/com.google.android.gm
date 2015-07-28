.class Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;
.super Ljava/lang/Object;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MailJsBridge"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationViewFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0

    .prologue
    .line 961
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;Lcom/android/mail/ui/ConversationViewFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationViewFragment$1;

    .prologue
    .line 961
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    return-void
.end method


# virtual methods
.method public getMessageBody(Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p1, "domId"    # Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 1015
    :try_start_0
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v4}, Lcom/android/mail/ui/ConversationViewFragment;->getMessageCursor()Lcom/android/mail/browse/MessageCursor;

    move-result-object v0

    .line 1016
    .local v0, "cursor":Lcom/android/mail/browse/MessageCursor;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z
    invoke-static {v4}, Lcom/android/mail/ui/ConversationViewFragment;->access$700(Lcom/android/mail/ui/ConversationViewFragment;)Z

    move-result v4

    if-eqz v4, :cond_0

    if-nez v0, :cond_1

    .line 1017
    :cond_0
    const-string v4, ""

    .line 1032
    .end local v0    # "cursor":Lcom/android/mail/browse/MessageCursor;
    :goto_0
    return-object v4

    .line 1020
    .restart local v0    # "cursor":Lcom/android/mail/browse/MessageCursor;
    :cond_1
    const/4 v2, -0x1

    .line 1021
    .local v2, "pos":I
    :cond_2
    add-int/lit8 v2, v2, 0x1

    invoke-virtual {v0, v2}, Lcom/android/mail/browse/MessageCursor;->moveToPosition(I)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 1022
    invoke-virtual {v0}, Lcom/android/mail/browse/MessageCursor;->getMessage()Lcom/android/mail/browse/MessageCursor$ConversationMessage;

    move-result-object v1

    .line 1023
    .local v1, "msg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mTemplates:Lcom/android/mail/ui/HtmlConversationTemplates;
    invoke-static {v4}, Lcom/android/mail/ui/ConversationViewFragment;->access$1600(Lcom/android/mail/ui/ConversationViewFragment;)Lcom/android/mail/ui/HtmlConversationTemplates;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/android/mail/ui/HtmlConversationTemplates;->getMessageDomId(Lcom/android/mail/providers/Message;)Ljava/lang/String;

    move-result-object v4

    invoke-static {p1, v4}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 1024
    invoke-virtual {v1}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->getBodyAsHtml()Ljava/lang/String;

    move-result-object v4

    goto :goto_0

    .line 1028
    .end local v1    # "msg":Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    :cond_3
    const-string v4, ""
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1030
    .end local v0    # "cursor":Lcom/android/mail/browse/MessageCursor;
    .end local v2    # "pos":I
    :catch_0
    move-exception v3

    .line 1031
    .local v3, "t":Ljava/lang/Throwable;
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Error in MailJsBridge.getMessageBody"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v4, v3, v5, v6}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1032
    const-string v4, ""

    goto :goto_0
.end method

.method public getScrollYPercent()F
    .locals 4
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 1063
    :try_start_0
    iget-object v1, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebViewYPercent:F
    invoke-static {v1}, Lcom/android/mail/ui/ConversationViewFragment;->access$1700(Lcom/android/mail/ui/ConversationViewFragment;)F
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 1066
    :goto_0
    return v1

    .line 1064
    :catch_0
    move-exception v0

    .line 1065
    .local v0, "t":Ljava/lang/Throwable;
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Error in MailJsBridge.getScrollYPercent"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1066
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getTempMessageBodies()Ljava/lang/String;
    .locals 5
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 998
    :try_start_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$700(Lcom/android/mail/ui/ConversationViewFragment;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 999
    const-string v0, ""

    .line 1007
    :goto_0
    return-object v0

    .line 1002
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mTempBodiesHtml:Ljava/lang/String;
    invoke-static {v2}, Lcom/android/mail/ui/ConversationViewFragment;->access$1500(Lcom/android/mail/ui/ConversationViewFragment;)Ljava/lang/String;

    move-result-object v0

    .line 1003
    .local v0, "s":Ljava/lang/String;
    iget-object v2, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    const/4 v3, 0x0

    # setter for: Lcom/android/mail/ui/ConversationViewFragment;->mTempBodiesHtml:Ljava/lang/String;
    invoke-static {v2, v3}, Lcom/android/mail/ui/ConversationViewFragment;->access$1502(Lcom/android/mail/ui/ConversationViewFragment;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1005
    .end local v0    # "s":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 1006
    .local v1, "t":Ljava/lang/Throwable;
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Error in MailJsBridge.getTempMessageBodies"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v1, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1007
    const-string v0, ""

    goto :goto_0
.end method

.method public onContentReady()V
    .locals 3
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 1039
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationViewFragment;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;

    const-string v2, "onContentReady"

    invoke-direct {v1, p0, v2}, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$2;-><init>(Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1057
    return-void
.end method

.method public onWebContentGeometryChange([Ljava/lang/String;[Ljava/lang/String;)V
    .locals 3
    .param p1, "overlayTopStrs"    # [Ljava/lang/String;
    .param p2, "overlayBottomStrs"    # [Ljava/lang/String;
    .annotation runtime Landroid/webkit/JavascriptInterface;
    .end annotation

    .prologue
    .line 967
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationViewFragment;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;

    const-string v2, "onWebContentGeometryChange"

    invoke-direct {v1, p0, v2, p1, p2}, Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge$1;-><init>(Lcom/android/mail/ui/ConversationViewFragment$MailJsBridge;Ljava/lang/String;[Ljava/lang/String;[Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 992
    return-void
.end method
