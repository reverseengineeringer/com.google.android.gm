.class public Lcom/google/android/gm/AutoSendActivity;
.super Lcom/android/mail/compose/AutoSendActivity;
.source "AutoSendActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/android/mail/compose/AutoSendActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 20
    invoke-virtual {p0}, Lcom/google/android/gm/AutoSendActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 21
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "com.google.android.gm.extra.ACCOUNT"

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 23
    const-string v2, "com.google.android.gm.extra.ACCOUNT"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 24
    .local v0, "account":Ljava/lang/String;
    const-string v2, "fromAccountString"

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 26
    .end local v0    # "account":Ljava/lang/String;
    :cond_0
    invoke-super {p0, p1}, Lcom/android/mail/compose/AutoSendActivity;->onCreate(Landroid/os/Bundle;)V

    .line 27
    return-void
.end method
