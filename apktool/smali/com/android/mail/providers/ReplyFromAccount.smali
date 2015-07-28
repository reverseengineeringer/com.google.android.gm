.class public Lcom/android/mail/providers/ReplyFromAccount;
.super Ljava/lang/Object;
.source "ReplyFromAccount.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final serialVersionUID:J = 0x1L


# instance fields
.field public account:Lcom/android/mail/providers/Account;

.field public address:Ljava/lang/String;

.field baseAccountUri:Landroid/net/Uri;

.field public isCustomFrom:Z

.field public isDefault:Z

.field public name:Ljava/lang/String;

.field public replyTo:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/providers/ReplyFromAccount;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 0
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "baseAccountUri"    # Landroid/net/Uri;
    .param p3, "address"    # Ljava/lang/String;
    .param p4, "name"    # Ljava/lang/String;
    .param p5, "replyTo"    # Ljava/lang/String;
    .param p6, "isDefault"    # Z
    .param p7, "isCustom"    # Z

    .prologue
    .line 52
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 53
    iput-object p1, p0, Lcom/android/mail/providers/ReplyFromAccount;->account:Lcom/android/mail/providers/Account;

    .line 54
    iput-object p2, p0, Lcom/android/mail/providers/ReplyFromAccount;->baseAccountUri:Landroid/net/Uri;

    .line 55
    iput-object p3, p0, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    .line 56
    iput-object p4, p0, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    .line 57
    iput-object p5, p0, Lcom/android/mail/providers/ReplyFromAccount;->replyTo:Ljava/lang/String;

    .line 58
    iput-boolean p6, p0, Lcom/android/mail/providers/ReplyFromAccount;->isDefault:Z

    .line 59
    iput-boolean p7, p0, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    .line 60
    return-void
.end method

.method public static deserialize(Lcom/android/mail/providers/Account;Ljava/lang/String;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 5
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "stringExtra"    # Ljava/lang/String;

    .prologue
    .line 95
    const/4 v1, 0x0

    .line 97
    .local v1, "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {p0, v2}, Lcom/android/mail/providers/ReplyFromAccount;->deserialize(Lcom/android/mail/providers/Account;Lorg/json/JSONObject;)Lcom/android/mail/providers/ReplyFromAccount;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 101
    :goto_0
    return-object v1

    .line 98
    :catch_0
    move-exception v0

    .line 99
    .local v0, "e":Lorg/json/JSONException;
    sget-object v2, Lcom/android/mail/providers/ReplyFromAccount;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Could not deserialize replyfromaccount"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public static deserialize(Lcom/android/mail/providers/Account;Lorg/json/JSONObject;)Lcom/android/mail/providers/ReplyFromAccount;
    .locals 12
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "json"    # Lorg/json/JSONObject;

    .prologue
    .line 78
    const/4 v9, 0x0

    .line 80
    .local v9, "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :try_start_0
    const-string v1, "baseAccountUri"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->getValidUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 81
    .local v2, "uri":Landroid/net/Uri;
    const-string v1, "address"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 82
    .local v3, "addressString":Ljava/lang/String;
    const-string v1, "name"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 83
    .local v4, "nameString":Ljava/lang/String;
    const-string v1, "replyTo"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 84
    .local v5, "replyTo":Ljava/lang/String;
    const-string v1, "isDefault"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v6

    .line 85
    .local v6, "isDefault":Z
    const-string v1, "isCustom"

    invoke-virtual {p1, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    .line 86
    .local v7, "isCustomFrom":Z
    new-instance v0, Lcom/android/mail/providers/ReplyFromAccount;

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/android/mail/providers/ReplyFromAccount;-><init>(Lcom/android/mail/providers/Account;Landroid/net/Uri;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 91
    .end local v2    # "uri":Landroid/net/Uri;
    .end local v3    # "addressString":Ljava/lang/String;
    .end local v4    # "nameString":Ljava/lang/String;
    .end local v5    # "replyTo":Ljava/lang/String;
    .end local v6    # "isDefault":Z
    .end local v7    # "isCustomFrom":Z
    .end local v9    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    .local v0, "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :goto_0
    return-object v0

    .line 88
    .end local v0    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    .restart local v9    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    :catch_0
    move-exception v8

    .line 89
    .local v8, "e":Lorg/json/JSONException;
    sget-object v1, Lcom/android/mail/providers/ReplyFromAccount;->LOG_TAG:Ljava/lang/String;

    const-string v10, "Could not deserialize replyfromaccount"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v1, v8, v10, v11}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    move-object v0, v9

    .end local v9    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    .restart local v0    # "replyFromAccount":Lcom/android/mail/providers/ReplyFromAccount;
    goto :goto_0
.end method

.method public static isCustomFrom(Ljava/lang/String;Ljava/util/List;)Z
    .locals 3
    .param p0, "senderAddress"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/ReplyFromAccount;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 109
    .local p1, "replyFromAccounts":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/ReplyFromAccount;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/ReplyFromAccount;

    .line 110
    .local v0, "account":Lcom/android/mail/providers/ReplyFromAccount;
    iget-object v2, v0, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    invoke-static {v2, p0}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-boolean v2, v0, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    if-eqz v2, :cond_0

    .line 111
    const/4 v2, 0x1

    .line 114
    .end local v0    # "account":Lcom/android/mail/providers/ReplyFromAccount;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public serialize()Lorg/json/JSONObject;
    .locals 5

    .prologue
    .line 63
    new-instance v1, Lorg/json/JSONObject;

    invoke-direct {v1}, Lorg/json/JSONObject;-><init>()V

    .line 65
    .local v1, "json":Lorg/json/JSONObject;
    :try_start_0
    const-string v2, "baseAccountUri"

    iget-object v3, p0, Lcom/android/mail/providers/ReplyFromAccount;->baseAccountUri:Landroid/net/Uri;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 66
    const-string v2, "address"

    iget-object v3, p0, Lcom/android/mail/providers/ReplyFromAccount;->address:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 67
    const-string v2, "name"

    iget-object v3, p0, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 68
    const-string v2, "replyTo"

    iget-object v3, p0, Lcom/android/mail/providers/ReplyFromAccount;->replyTo:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 69
    const-string v2, "isDefault"

    iget-boolean v3, p0, Lcom/android/mail/providers/ReplyFromAccount;->isDefault:Z

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 70
    const-string v2, "isCustom"

    iget-boolean v3, p0, Lcom/android/mail/providers/ReplyFromAccount;->isCustomFrom:Z

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 74
    :goto_0
    return-object v1

    .line 71
    :catch_0
    move-exception v0

    .line 72
    .local v0, "e":Lorg/json/JSONException;
    sget-object v2, Lcom/android/mail/providers/ReplyFromAccount;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Could not serialize account with name "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/providers/ReplyFromAccount;->name:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
