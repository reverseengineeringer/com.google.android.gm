.class public Lcom/android/mail/providers/GmailAccountCacheProvider;
.super Lcom/android/mail/providers/MailAppProvider;
.source "GmailAccountCacheProvider.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/android/mail/providers/MailAppProvider;-><init>()V

    return-void
.end method


# virtual methods
.method protected getAuthority()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    const-string v0, "com.google.android.gm2.accountcache"

    return-object v0
.end method

.method protected getNoAccountsIntent(Landroid/content/Context;)Landroid/content/Intent;
    .locals 2

    .prologue
    .line 30
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lcom/google/android/gm/AddAccountActivity;

    invoke-direct {v0, p1, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    return-object v0
.end method
