.class Lcom/google/android/gm/provider/UiProvider$1;
.super Ljava/lang/Object;
.source "UiProvider.java"

# interfaces
.implements Lcom/google/android/gm/AccountHelper$AccountResultsCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/UiProvider;->initializeMailEngines()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/UiProvider;

.field final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/UiProvider;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 3032
    iput-object p1, p0, Lcom/google/android/gm/provider/UiProvider$1;->this$0:Lcom/google/android/gm/provider/UiProvider;

    iput-object p2, p0, Lcom/google/android/gm/provider/UiProvider$1;->val$context:Landroid/content/Context;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public exec([Landroid/accounts/Account;)V
    .locals 9
    .param p1, "accounts"    # [Landroid/accounts/Account;

    .prologue
    .line 3036
    array-length v4, p1

    if-lez v4, :cond_0

    .line 3037
    move-object v1, p1

    .local v1, "arr$":[Landroid/accounts/Account;
    array-length v3, v1

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_1

    aget-object v0, v1, v2

    .line 3038
    .local v0, "account":Landroid/accounts/Account;
    const-string v4, "Gmail"

    const-string v5, "Getting MailEngine for account: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3039
    iget-object v4, p0, Lcom/google/android/gm/provider/UiProvider$1;->this$0:Lcom/google/android/gm/provider/UiProvider;

    # getter for: Lcom/google/android/gm/provider/UiProvider;->mAccountsPendingInitialization:Ljava/util/Set;
    invoke-static {v4}, Lcom/google/android/gm/provider/UiProvider;->access$200(Lcom/google/android/gm/provider/UiProvider;)Ljava/util/Set;

    move-result-object v4

    iget-object v5, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-interface {v4, v5}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 3040
    iget-object v4, p0, Lcom/google/android/gm/provider/UiProvider$1;->val$context:Landroid/content/Context;

    iget-object v5, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    iget-object v6, p0, Lcom/google/android/gm/provider/UiProvider$1;->this$0:Lcom/google/android/gm/provider/UiProvider;

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngineAsync(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;)V

    .line 3037
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 3045
    .end local v0    # "account":Landroid/accounts/Account;
    .end local v1    # "arr$":[Landroid/accounts/Account;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    :cond_0
    iget-object v4, p0, Lcom/google/android/gm/provider/UiProvider$1;->this$0:Lcom/google/android/gm/provider/UiProvider;

    # invokes: Lcom/google/android/gm/provider/UiProvider;->updateAccountsIntializedStatus()V
    invoke-static {v4}, Lcom/google/android/gm/provider/UiProvider;->access$300(Lcom/google/android/gm/provider/UiProvider;)V

    .line 3047
    :cond_1
    return-void
.end method
