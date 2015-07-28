.class public Lcom/google/android/gm/ReauthenticateActivity;
.super Lcom/google/android/gm/GmailBaseActivity;
.source "ReauthenticateActivity.java"

# interfaces
.implements Lcom/google/android/gm/AccountHelper$CredentialsCallback;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/google/android/gm/GmailBaseActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 16
    invoke-super {p0, p1}, Lcom/google/android/gm/GmailBaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 18
    invoke-virtual {p0}, Lcom/google/android/gm/ReauthenticateActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 19
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v2

    .line 21
    .local v2, "uri":Landroid/net/Uri;
    const-string v3, "account"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 24
    .local v0, "accountName":Ljava/lang/String;
    invoke-static {p0, v0, p0}, Lcom/google/android/gm/AccountHelper;->promptForCredentials(Landroid/app/Activity;Ljava/lang/String;Lcom/google/android/gm/AccountHelper$CredentialsCallback;)V

    .line 25
    return-void
.end method

.method public onCredentialsResult(Z)V
    .locals 1
    .param p1, "success"    # Z

    .prologue
    .line 30
    if-eqz p1, :cond_0

    const/4 v0, -0x1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/google/android/gm/ReauthenticateActivity;->setResult(I)V

    .line 31
    invoke-virtual {p0}, Lcom/google/android/gm/ReauthenticateActivity;->finish()V

    .line 32
    return-void

    .line 30
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
