.class public Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;
.super Landroid/webkit/WebViewClient;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "AbstractConversationWebViewClient"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method protected constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;)V
    .locals 0

    .prologue
    .line 682
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct {p0}, Landroid/webkit/WebViewClient;-><init>()V

    return-void
.end method

.method private generateProxyIntent(Landroid/net/Uri;)Landroid/content/Intent;
    .locals 12
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 713
    new-instance v4, Landroid/content/Intent;

    const-string v9, "android.intent.action.VIEW"

    iget-object v10, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v10, v10, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v10, v10, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    invoke-direct {v4, v9, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 714
    .local v4, "intent":Landroid/content/Intent;
    const-string v9, "original_uri"

    invoke-virtual {v4, v9, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 715
    const-string v9, "account"

    iget-object v10, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v10, v10, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v4, v9, v10}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 717
    iget-object v9, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-virtual {v9}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 718
    .local v1, "context":Landroid/content/Context;
    const/4 v5, 0x0

    .line 722
    .local v5, "manager":Landroid/content/pm/PackageManager;
    :try_start_0
    invoke-virtual {v1}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;
    :try_end_0
    .catch Ljava/lang/UnsupportedOperationException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 727
    :goto_0
    if-eqz v5, :cond_1

    .line 729
    const/high16 v9, 0x10000

    invoke-virtual {v5, v4, v9}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v8

    .line 732
    .local v8, "resolvedActivities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-virtual {v1}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    .line 738
    .local v6, "packageName":Ljava/lang/String;
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/content/pm/ResolveInfo;

    .line 739
    .local v7, "resolveInfo":Landroid/content/pm/ResolveInfo;
    iget-object v0, v7, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    .line 740
    .local v0, "activityInfo":Landroid/content/pm/ActivityInfo;
    iget-object v9, v0, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v6, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    .line 741
    iget-object v9, v0, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    iget-object v10, v0, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {v4, v9, v10}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 747
    .end local v0    # "activityInfo":Landroid/content/pm/ActivityInfo;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v6    # "packageName":Ljava/lang/String;
    .end local v7    # "resolveInfo":Landroid/content/pm/ResolveInfo;
    .end local v8    # "resolvedActivities":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    :cond_1
    return-object v4

    .line 723
    :catch_0
    move-exception v2

    .line 724
    .local v2, "e":Ljava/lang/UnsupportedOperationException;
    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$600()Ljava/lang/String;

    move-result-object v9

    const-string v10, "Error getting package manager"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v9, v2, v10, v11}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method


# virtual methods
.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 685
    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-virtual {v4}, Lcom/android/mail/ui/AbstractConversationViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 686
    .local v0, "activity":Landroid/app/Activity;
    if-nez v0, :cond_0

    .line 687
    const/4 v2, 0x0

    .line 709
    :goto_0
    return v2

    .line 690
    :cond_0
    const/4 v2, 0x0

    .line 692
    .local v2, "result":Z
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 693
    .local v3, "uri":Landroid/net/Uri;
    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractConversationViewFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, v4, Lcom/android/mail/providers/Account;->viewIntentProxyUri:Landroid/net/Uri;

    invoke-static {v4}, Lcom/android/mail/utils/Utils;->isEmpty(Landroid/net/Uri;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 694
    invoke-direct {p0, v3}, Lcom/android/mail/ui/AbstractConversationViewFragment$AbstractConversationWebViewClient;->generateProxyIntent(Landroid/net/Uri;)Landroid/content/Intent;

    move-result-object v1

    .line 701
    .local v1, "intent":Landroid/content/Intent;
    :goto_1
    const/high16 v4, 0x80000

    :try_start_0
    invoke-virtual {v1, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 702
    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 703
    const/4 v2, 0x1

    goto :goto_0

    .line 696
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    new-instance v1, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    invoke-direct {v1, v4, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 697
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v4, "com.android.browser.application_id"

    invoke-virtual {v0}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 704
    :catch_0
    move-exception v4

    goto :goto_0
.end method
