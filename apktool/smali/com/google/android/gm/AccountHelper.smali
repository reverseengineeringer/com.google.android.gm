.class public Lcom/google/android/gm/AccountHelper;
.super Ljava/lang/Object;
.source "AccountHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/AccountHelper$CredentialsCallback;,
        Lcom/google/android/gm/AccountHelper$AddAccountCallback;,
        Lcom/google/android/gm/AccountHelper$AccountResultsCallback;
    }
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 70
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 71
    iput-object p1, p0, Lcom/google/android/gm/AccountHelper;->mContext:Landroid/content/Context;

    .line 72
    return-void
.end method

.method public constructor <init>(Lcom/google/android/gm/RestrictedActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/google/android/gm/RestrictedActivity;

    .prologue
    .line 66
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 67
    invoke-interface {p1}, Lcom/google/android/gm/RestrictedActivity;->getContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/AccountHelper;->mContext:Landroid/content/Context;

    .line 68
    return-void
.end method

.method public static getSyncingAccounts(Landroid/content/Context;Landroid/accounts/AccountManagerCallback;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/accounts/AccountManagerCallback",
            "<[",
            "Landroid/accounts/Account;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 119
    .local p1, "callback":Landroid/accounts/AccountManagerCallback;, "Landroid/accounts/AccountManagerCallback<[Landroid/accounts/Account;>;"
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v1, "com.google"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "mail"

    invoke-static {v4}, Lcom/google/android/gsf/GoogleLoginServiceConstants;->featureForService(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v2, p1, v3}, Landroid/accounts/AccountManager;->getAccountsByTypeAndFeatures(Ljava/lang/String;[Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 123
    return-void
.end method

.method public static mergeAccountLists(Ljava/util/List;[Landroid/accounts/Account;Z)Ljava/util/List;
    .locals 5
    .param p1, "accounts"    # [Landroid/accounts/Account;
    .param p2, "prioritizeAccountList"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;[",
            "Landroid/accounts/Account;",
            "Z)",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 136
    .local p0, "existingList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 140
    .local v3, "newAccountList":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    array-length v4, p1

    if-ge v2, v4, :cond_5

    .line 141
    aget-object v4, p1, v2

    iget-object v0, v4, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 142
    .local v0, "accountName":Ljava/lang/String;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->getMailEngine(Ljava/lang/String;)Lcom/google/android/gm/provider/MailEngine;

    move-result-object v1

    .line 143
    .local v1, "engine":Lcom/google/android/gm/provider/MailEngine;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine;->labelsSynced()Z

    move-result v4

    if-nez v4, :cond_1

    :cond_0
    if-eqz p2, :cond_3

    .line 144
    :cond_1
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 140
    :cond_2
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 152
    :cond_3
    if-nez p2, :cond_4

    if-eqz p0, :cond_2

    invoke-interface {p0, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 154
    :cond_4
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 158
    .end local v0    # "accountName":Ljava/lang/String;
    .end local v1    # "engine":Lcom/google/android/gm/provider/MailEngine;
    :cond_5
    return-object v3
.end method

.method public static promptForCredentials(Landroid/app/Activity;Ljava/lang/String;Lcom/google/android/gm/AccountHelper$CredentialsCallback;)V
    .locals 7
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "accountStr"    # Ljava/lang/String;
    .param p2, "callback"    # Lcom/google/android/gm/AccountHelper$CredentialsCallback;

    .prologue
    .line 243
    new-instance v1, Landroid/accounts/Account;

    const-string v0, "com.google"

    invoke-direct {v1, p1, v0}, Landroid/accounts/Account;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    .local v1, "account":Landroid/accounts/Account;
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    .line 247
    .local v3, "bundle":Landroid/os/Bundle;
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v2, "mail"

    new-instance v5, Lcom/google/android/gm/AccountHelper$3;

    invoke-direct {v5, p2}, Lcom/google/android/gm/AccountHelper$3;-><init>(Lcom/google/android/gm/AccountHelper$CredentialsCallback;)V

    const/4 v6, 0x0

    move-object v4, p0

    invoke-virtual/range {v0 .. v6}, Landroid/accounts/AccountManager;->getAuthToken(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 270
    return-void
.end method

.method public static showAddAccount(Landroid/app/Activity;Lcom/google/android/gm/AccountHelper$AddAccountCallback;)V
    .locals 9
    .param p0, "activity"    # Landroid/app/Activity;
    .param p1, "callback"    # Lcom/google/android/gm/AccountHelper$AddAccountCallback;

    .prologue
    const/4 v3, 0x0

    const/4 v5, 0x0

    .line 170
    const/4 v4, 0x0

    .line 171
    .local v4, "options":Landroid/os/Bundle;
    const/4 v0, -0x1

    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-static {p0, v0, v1, v5}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v8

    .line 174
    .local v8, "pendingIntent":Landroid/app/PendingIntent;
    invoke-static {}, Lcom/google/android/gm/provider/Gmail;->isRunningICSOrLater()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 175
    new-instance v4, Landroid/os/Bundle;

    .end local v4    # "options":Landroid/os/Bundle;
    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 176
    .restart local v4    # "options":Landroid/os/Bundle;
    const-string v0, "allowSkip"

    invoke-virtual {v4, v0, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 177
    const-string v0, "introMessage"

    invoke-virtual {p0}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0c0133

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 180
    const-string v0, "pendingIntent"

    invoke-virtual {v4, v0, v8}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 183
    :cond_0
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v1, "com.google"

    const-string v2, "mail"

    new-instance v6, Lcom/google/android/gm/AccountHelper$2;

    invoke-direct {v6, p1, v8}, Lcom/google/android/gm/AccountHelper$2;-><init>(Lcom/google/android/gm/AccountHelper$AddAccountCallback;Landroid/app/PendingIntent;)V

    move-object v5, p0

    move-object v7, v3

    invoke-virtual/range {v0 .. v7}, Landroid/accounts/AccountManager;->addAccount(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Landroid/os/Bundle;Landroid/app/Activity;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 231
    return-void
.end method


# virtual methods
.method public asyncGetAccountsInfo(Lcom/google/android/gm/AccountHelper$AccountResultsCallback;)V
    .locals 5
    .param p1, "callback"    # Lcom/google/android/gm/AccountHelper$AccountResultsCallback;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/google/android/gm/AccountHelper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v0

    const-string v1, "com.google"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const-string v4, "mail"

    invoke-static {v4}, Lcom/google/android/gsf/GoogleLoginServiceConstants;->featureForService(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    new-instance v3, Lcom/google/android/gm/AccountHelper$1;

    invoke-direct {v3, p0, p1}, Lcom/google/android/gm/AccountHelper$1;-><init>(Lcom/google/android/gm/AccountHelper;Lcom/google/android/gm/AccountHelper$AccountResultsCallback;)V

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Landroid/accounts/AccountManager;->getAccountsByTypeAndFeatures(Ljava/lang/String;[Ljava/lang/String;Landroid/accounts/AccountManagerCallback;Landroid/os/Handler;)Landroid/accounts/AccountManagerFuture;

    .line 100
    return-void
.end method

.method public validateAccountName(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "accountName"    # Ljava/lang/String;

    .prologue
    .line 108
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/AccountHelper;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/google/android/gm/Utils;->isValidGoogleAccount(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .end local p1    # "accountName":Ljava/lang/String;
    :goto_0
    return-object p1

    .restart local p1    # "accountName":Ljava/lang/String;
    :cond_0
    const/4 p1, 0x0

    goto :goto_0
.end method
