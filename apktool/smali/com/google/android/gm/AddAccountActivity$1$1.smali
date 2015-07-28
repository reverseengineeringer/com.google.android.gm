.class Lcom/google/android/gm/AddAccountActivity$1$1;
.super Ljava/lang/Object;
.source "AddAccountActivity.java"

# interfaces
.implements Lcom/google/android/gm/AccountHelper$AddAccountCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/AddAccountActivity$1;->exec([Landroid/accounts/Account;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/google/android/gm/AddAccountActivity$1;


# direct methods
.method constructor <init>(Lcom/google/android/gm/AddAccountActivity$1;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/google/android/gm/AddAccountActivity$1$1;->this$1:Lcom/google/android/gm/AddAccountActivity$1;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onResult(Landroid/accounts/Account;)V
    .locals 3
    .param p1, "result"    # Landroid/accounts/Account;

    .prologue
    .line 47
    if-eqz p1, :cond_0

    .line 48
    iget-object v0, p0, Lcom/google/android/gm/AddAccountActivity$1$1;->this$1:Lcom/google/android/gm/AddAccountActivity$1;

    iget-object v0, v0, Lcom/google/android/gm/AddAccountActivity$1;->this$0:Lcom/google/android/gm/AddAccountActivity;

    const/4 v1, 0x1

    new-array v1, v1, [Landroid/accounts/Account;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    # invokes: Lcom/google/android/gm/AddAccountActivity;->onAccountCreated([Landroid/accounts/Account;)V
    invoke-static {v0, v1}, Lcom/google/android/gm/AddAccountActivity;->access$000(Lcom/google/android/gm/AddAccountActivity;[Landroid/accounts/Account;)V

    .line 53
    :goto_0
    return-void

    .line 51
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/AddAccountActivity$1$1;->this$1:Lcom/google/android/gm/AddAccountActivity$1;

    iget-object v0, v0, Lcom/google/android/gm/AddAccountActivity$1;->this$0:Lcom/google/android/gm/AddAccountActivity;

    # invokes: Lcom/google/android/gm/AddAccountActivity;->onFailureToAddAccount()V
    invoke-static {v0}, Lcom/google/android/gm/AddAccountActivity;->access$100(Lcom/google/android/gm/AddAccountActivity;)V

    goto :goto_0
.end method
