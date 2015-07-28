.class final Lcom/google/android/gm/AccountHelper$3;
.super Ljava/lang/Object;
.source "AccountHelper.java"

# interfaces
.implements Landroid/accounts/AccountManagerCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/AccountHelper;->promptForCredentials(Landroid/app/Activity;Ljava/lang/String;Lcom/google/android/gm/AccountHelper$CredentialsCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/accounts/AccountManagerCallback",
        "<",
        "Landroid/os/Bundle;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic val$callback:Lcom/google/android/gm/AccountHelper$CredentialsCallback;


# direct methods
.method constructor <init>(Lcom/google/android/gm/AccountHelper$CredentialsCallback;)V
    .locals 0

    .prologue
    .line 249
    iput-object p1, p0, Lcom/google/android/gm/AccountHelper$3;->val$callback:Lcom/google/android/gm/AccountHelper$CredentialsCallback;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run(Landroid/accounts/AccountManagerFuture;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/accounts/AccountManagerFuture",
            "<",
            "Landroid/os/Bundle;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "future":Landroid/accounts/AccountManagerFuture;, "Landroid/accounts/AccountManagerFuture<Landroid/os/Bundle;>;"
    const/4 v5, 0x0

    .line 251
    const/4 v2, 0x0

    .line 253
    .local v2, "success":Z
    :try_start_0
    invoke-interface {p1}, Landroid/accounts/AccountManagerFuture;->getResult()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;
    :try_end_0
    .catch Landroid/accounts/OperationCanceledException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Landroid/accounts/AuthenticatorException; {:try_start_0 .. :try_end_0} :catch_2

    .line 255
    .local v1, "result":Landroid/os/Bundle;
    const/4 v2, 0x1

    .line 267
    .end local v1    # "result":Landroid/os/Bundle;
    :goto_0
    iget-object v3, p0, Lcom/google/android/gm/AccountHelper$3;->val$callback:Lcom/google/android/gm/AccountHelper$CredentialsCallback;

    invoke-interface {v3, v2}, Lcom/google/android/gm/AccountHelper$CredentialsCallback;->onCredentialsResult(Z)V

    .line 268
    return-void

    .line 256
    :catch_0
    move-exception v0

    .line 257
    .local v0, "e":Landroid/accounts/OperationCanceledException;
    const-string v3, "Gmail"

    const-string v4, "promptForCredentials(): User Canceled"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 259
    .end local v0    # "e":Landroid/accounts/OperationCanceledException;
    :catch_1
    move-exception v0

    .line 260
    .local v0, "e":Ljava/io/IOException;
    const-string v3, "Gmail"

    const-string v4, "promptForCredentials(): IO Error"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 263
    .end local v0    # "e":Ljava/io/IOException;
    :catch_2
    move-exception v0

    .line 264
    .local v0, "e":Landroid/accounts/AuthenticatorException;
    const-string v3, "Gmail"

    const-string v4, "promptForCredentials(): Not Authenticated"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
