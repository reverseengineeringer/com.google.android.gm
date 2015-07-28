.class Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ConversationWebViewClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationViewFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0

    .prologue
    .line 918
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;Lcom/android/mail/ui/ConversationViewFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/ConversationViewFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationViewFragment$1;

    .prologue
    .line 918
    invoke-direct {p0, p1}, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;-><init>(Lcom/android/mail/ui/ConversationViewFragment;)V

    return-void
.end method


# virtual methods
.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 13
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 924
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ControllableActivity;

    .line 925
    .local v0, "activity":Lcom/android/mail/ui/ControllableActivity;
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationViewFragment;->isAdded()Z

    move-result v5

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z
    invoke-static {v5}, Lcom/android/mail/ui/ConversationViewFragment;->access$700(Lcom/android/mail/ui/ConversationViewFragment;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 926
    :cond_0
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v5

    const-string v6, "ignoring CVF.onPageFinished, url=%s fragment=%s"

    const/4 v7, 0x2

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p2, v7, v8

    const/4 v8, 0x1

    iget-object v9, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    aput-object v9, v7, v8

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 948
    :goto_0
    return-void

    .line 931
    :cond_1
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v5

    const-string v6, "IN CVF.onPageFinished, url=%s fragment=%s wv=%s t=%sms"

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object p2, v7, v8

    const/4 v8, 0x1

    iget-object v9, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    aput-object v9, v7, v8

    const/4 v8, 0x2

    aput-object p1, v7, v8

    const/4 v8, 0x3

    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v9

    iget-object v11, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mWebViewLoadStartMs:J
    invoke-static {v11}, Lcom/android/mail/ui/ConversationViewFragment;->access$800(Lcom/android/mail/ui/ConversationViewFragment;)J

    move-result-wide v11

    sub-long/2addr v9, v11

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v5, v6, v7}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 935
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->ensureContentSizeChangeListener()V
    invoke-static {v5}, Lcom/android/mail/ui/ConversationViewFragment;->access$900(Lcom/android/mail/ui/ConversationViewFragment;)V

    .line 937
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mEnableContentReadySignal:Z
    invoke-static {v5}, Lcom/android/mail/ui/ConversationViewFragment;->access$1000(Lcom/android/mail/ui/ConversationViewFragment;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 938
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->revealConversation()V
    invoke-static {v5}, Lcom/android/mail/ui/ConversationViewFragment;->access$1100(Lcom/android/mail/ui/ConversationViewFragment;)V

    .line 941
    :cond_2
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v3

    .line 942
    .local v3, "emailAddresses":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAddressCache:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Address;

    .line 943
    .local v1, "addr":Lcom/android/mail/providers/Address;
    invoke-virtual {v1}, Lcom/android/mail/providers/Address;->getAddress()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 945
    .end local v1    # "addr":Lcom/android/mail/providers/Address;
    :cond_3
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationViewFragment;->getContactInfoSource()Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    move-result-object v2

    .line 946
    .local v2, "callbacks":Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationViewFragment;->getContactInfoSource()Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;

    move-result-object v5

    invoke-virtual {v5, v3}, Lcom/android/mail/ui/AbstractConversationViewFragment$ContactLoaderCallbacks;->setSenders(Ljava/util/Set;)V

    .line 947
    iget-object v5, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v5}, Lcom/android/mail/ui/ConversationViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v5

    const/4 v6, 0x1

    sget-object v7, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    invoke-virtual {v5, v6, v7, v2}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 1
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 952
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$ConversationWebViewClient;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->mViewsCreated:Z
    invoke-static {v0}, Lcom/android/mail/ui/ConversationViewFragment;->access$700(Lcom/android/mail/ui/ConversationViewFragment;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-super {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
