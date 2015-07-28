.class public Lcom/google/android/gm/ViewProxyActivity;
.super Landroid/app/Activity;
.source "ViewProxyActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    return-void
.end method


# virtual methods
.method public addUriAccountIntentExtras(Landroid/net/Uri;Lcom/android/mail/providers/Account;Landroid/content/Intent;)V
    .locals 10
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "intent"    # Landroid/content/Intent;

    .prologue
    .line 57
    invoke-virtual {p1}, Landroid/net/Uri;->getHost()Ljava/lang/String;

    move-result-object v2

    .line 58
    .local v2, "host":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/google/android/gm/ViewProxyActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v7

    const-string v8, "gmail_account_extras_uri_host_pattern"

    const-string v9, ".*\\.google(\\.co(m?))?(\\.\\w{2})?"

    invoke-static {v7, v8, v9}, Lcom/google/android/gsf/Gservices;->getString(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 61
    .local v4, "hostPatternStr":Ljava/lang/String;
    invoke-static {v4}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v3

    .line 63
    .local v3, "hostPattern":Ljava/util/regex/Pattern;
    if-eqz v2, :cond_0

    invoke-virtual {v3, v2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v7

    invoke-virtual {v7}, Ljava/util/regex/Matcher;->matches()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 67
    :try_start_0
    const-string v7, "MD5"

    invoke-static {v7}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v0

    .line 68
    .local v0, "digester":Ljava/security/MessageDigest;
    new-instance v7, Ljava/util/Random;

    invoke-direct {v7}, Ljava/util/Random;-><init>()V

    invoke-virtual {v7}, Ljava/util/Random;->nextLong()J

    move-result-wide v7

    invoke-static {v7, v8}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    .line 69
    .local v5, "salt":Ljava/lang/String;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "com.google"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 71
    .local v6, "saltedAccountName":Ljava/lang/String;
    invoke-virtual {v6}, Ljava/lang/String;->getBytes()[B

    move-result-object v7

    invoke-virtual {v0, v7}, Ljava/security/MessageDigest;->update([B)V

    .line 72
    const-string v7, "salt"

    invoke-virtual {p3, v7, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 73
    const-string v7, "digest"

    invoke-virtual {v0}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v8

    invoke-virtual {p3, v7, v8}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    .line 78
    .end local v0    # "digester":Ljava/security/MessageDigest;
    .end local v5    # "salt":Ljava/lang/String;
    .end local v6    # "saltedAccountName":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 74
    :catch_0
    move-exception v1

    .line 75
    .local v1, "e":Ljava/security/NoSuchAlgorithmException;
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v7

    const-string v8, "Unable to load MD5 digest instance"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-static {v7, v1, v8, v9}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 38
    invoke-virtual {p0}, Lcom/google/android/gm/ViewProxyActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "original_uri"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 39
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {p0}, Lcom/google/android/gm/ViewProxyActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string v4, "account"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Account;

    .line 41
    .local v0, "account":Lcom/android/mail/providers/Account;
    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.VIEW"

    invoke-direct {v2, v3, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 42
    .local v2, "viewIntent":Landroid/content/Intent;
    const/high16 v3, 0x80000

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 44
    const-string v3, "com.android.browser.application_id"

    invoke-virtual {p0}, Lcom/google/android/gm/ViewProxyActivity;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 46
    invoke-virtual {p0, v1, v0, v2}, Lcom/google/android/gm/ViewProxyActivity;->addUriAccountIntentExtras(Landroid/net/Uri;Lcom/android/mail/providers/Account;Landroid/content/Intent;)V

    .line 49
    :try_start_0
    invoke-virtual {p0, v2}, Lcom/google/android/gm/ViewProxyActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 53
    :goto_0
    invoke-virtual {p0}, Lcom/google/android/gm/ViewProxyActivity;->finish()V

    .line 54
    return-void

    .line 50
    :catch_0
    move-exception v3

    goto :goto_0
.end method
