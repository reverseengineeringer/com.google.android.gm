.class Lcom/google/android/gm/AddAccountActivity$1;
.super Ljava/lang/Object;
.source "AddAccountActivity.java"

# interfaces
.implements Lcom/google/android/gm/AccountHelper$AccountResultsCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/AddAccountActivity;->waitForGmailAccount()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/AddAccountActivity;

.field final synthetic val$activity:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/google/android/gm/AddAccountActivity;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/google/android/gm/AddAccountActivity$1;->this$0:Lcom/google/android/gm/AddAccountActivity;

    iput-object p2, p0, Lcom/google/android/gm/AddAccountActivity$1;->val$activity:Landroid/app/Activity;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public exec([Landroid/accounts/Account;)V
    .locals 2
    .param p1, "accounts"    # [Landroid/accounts/Account;

    .prologue
    .line 42
    if-eqz p1, :cond_0

    array-length v0, p1

    if-nez v0, :cond_1

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/AddAccountActivity$1;->val$activity:Landroid/app/Activity;

    new-instance v1, Lcom/google/android/gm/AddAccountActivity$1$1;

    invoke-direct {v1, p0}, Lcom/google/android/gm/AddAccountActivity$1$1;-><init>(Lcom/google/android/gm/AddAccountActivity$1;)V

    invoke-static {v0, v1}, Lcom/google/android/gm/AccountHelper;->showAddAccount(Landroid/app/Activity;Lcom/google/android/gm/AccountHelper$AddAccountCallback;)V

    .line 60
    :goto_0
    return-void

    .line 58
    :cond_1
    iget-object v0, p0, Lcom/google/android/gm/AddAccountActivity$1;->this$0:Lcom/google/android/gm/AddAccountActivity;

    # invokes: Lcom/google/android/gm/AddAccountActivity;->onAccountCreated([Landroid/accounts/Account;)V
    invoke-static {v0, p1}, Lcom/google/android/gm/AddAccountActivity;->access$000(Lcom/google/android/gm/AddAccountActivity;[Landroid/accounts/Account;)V

    goto :goto_0
.end method
