.class public Lcom/google/android/gm/AddAccountActivity;
.super Lcom/google/android/gm/GmailBaseActivity;
.source "AddAccountActivity.java"


# instance fields
.field private mAccountCreated:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/google/android/gm/GmailBaseActivity;-><init>()V

    .line 14
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/AddAccountActivity;->mAccountCreated:Z

    return-void
.end method

.method static synthetic access$000(Lcom/google/android/gm/AddAccountActivity;[Landroid/accounts/Account;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/AddAccountActivity;
    .param p1, "x1"    # [Landroid/accounts/Account;

    .prologue
    .line 11
    invoke-direct {p0, p1}, Lcom/google/android/gm/AddAccountActivity;->onAccountCreated([Landroid/accounts/Account;)V

    return-void
.end method

.method static synthetic access$100(Lcom/google/android/gm/AddAccountActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/google/android/gm/AddAccountActivity;

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/google/android/gm/AddAccountActivity;->onFailureToAddAccount()V

    return-void
.end method

.method private onAccountCreated([Landroid/accounts/Account;)V
    .locals 1
    .param p1, "accounts"    # [Landroid/accounts/Account;

    .prologue
    .line 66
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/google/android/gm/AddAccountActivity;->mAccountCreated:Z

    .line 67
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/google/android/gm/AddAccountActivity;->setResult(I)V

    .line 68
    invoke-virtual {p0}, Lcom/google/android/gm/AddAccountActivity;->finish()V

    .line 69
    return-void
.end method

.method private onFailureToAddAccount()V
    .locals 1

    .prologue
    .line 72
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/google/android/gm/AddAccountActivity;->setResult(I)V

    .line 73
    invoke-virtual {p0}, Lcom/google/android/gm/AddAccountActivity;->finish()V

    .line 74
    return-void
.end method

.method private waitForGmailAccount()V
    .locals 3

    .prologue
    .line 37
    move-object v1, p0

    .line 38
    .local v1, "activity":Landroid/app/Activity;
    new-instance v0, Lcom/google/android/gm/AccountHelper;

    invoke-virtual {p0}, Lcom/google/android/gm/AddAccountActivity;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v0, v2}, Lcom/google/android/gm/AccountHelper;-><init>(Landroid/content/Context;)V

    .line 39
    .local v0, "accountHelper":Lcom/google/android/gm/AccountHelper;
    new-instance v2, Lcom/google/android/gm/AddAccountActivity$1;

    invoke-direct {v2, p0, v1}, Lcom/google/android/gm/AddAccountActivity$1;-><init>(Lcom/google/android/gm/AddAccountActivity;Landroid/app/Activity;)V

    invoke-virtual {v0, v2}, Lcom/google/android/gm/AccountHelper;->asyncGetAccountsInfo(Lcom/google/android/gm/AccountHelper$AccountResultsCallback;)V

    .line 62
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 18
    invoke-super {p0, p1}, Lcom/google/android/gm/GmailBaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 19
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 23
    invoke-super {p0}, Lcom/google/android/gm/GmailBaseActivity;->onResume()V

    .line 24
    iget-boolean v0, p0, Lcom/google/android/gm/AddAccountActivity;->mAccountCreated:Z

    if-nez v0, :cond_0

    .line 25
    invoke-direct {p0}, Lcom/google/android/gm/AddAccountActivity;->waitForGmailAccount()V

    .line 27
    :cond_0
    return-void
.end method
