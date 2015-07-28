.class Lcom/android/mail/AccountSpinnerAdapter$2;
.super Lcom/android/mail/providers/AccountObserver;
.source "AccountSpinnerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/AccountSpinnerAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/AccountSpinnerAdapter;


# direct methods
.method constructor <init>(Lcom/android/mail/AccountSpinnerAdapter;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-direct {p0}, Lcom/android/mail/providers/AccountObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged(Lcom/android/mail/providers/Account;)V
    .locals 6
    .param p1, "newAccount"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 112
    if-nez p1, :cond_1

    .line 128
    :cond_0
    :goto_0
    return-void

    .line 115
    :cond_1
    iget-object v1, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    # invokes: Lcom/android/mail/AccountSpinnerAdapter;->getCurrentAccountUri()Landroid/net/Uri;
    invoke-static {v2}, Lcom/android/mail/AccountSpinnerAdapter;->access$100(Lcom/android/mail/AccountSpinnerAdapter;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 119
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    # setter for: Lcom/android/mail/AccountSpinnerAdapter;->mCurrentAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1, p1}, Lcom/android/mail/AccountSpinnerAdapter;->access$202(Lcom/android/mail/AccountSpinnerAdapter;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;

    .line 120
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    # getter for: Lcom/android/mail/AccountSpinnerAdapter;->mRecentFoldersVisible:Z
    invoke-static {v1}, Lcom/android/mail/AccountSpinnerAdapter;->access$300(Lcom/android/mail/AccountSpinnerAdapter;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 121
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    # getter for: Lcom/android/mail/AccountSpinnerAdapter;->mAllAccounts:[Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/AccountSpinnerAdapter;->access$400(Lcom/android/mail/AccountSpinnerAdapter;)[Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v2, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-static {v1, v2}, Lcom/android/mail/providers/Account;->findPosition([Lcom/android/mail/providers/Account;Landroid/net/Uri;)I

    move-result v0

    .line 122
    .local v0, "pos":I
    # getter for: Lcom/android/mail/AccountSpinnerAdapter;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/AccountSpinnerAdapter;->access$500()Ljava/lang/String;

    move-result-object v1

    const-string v2, "setCurrentAccount: mCurrentAccountPos = %d"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 123
    if-ltz v0, :cond_2

    .line 124
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    # invokes: Lcom/android/mail/AccountSpinnerAdapter;->requestRecentFolders()V
    invoke-static {v1}, Lcom/android/mail/AccountSpinnerAdapter;->access$000(Lcom/android/mail/AccountSpinnerAdapter;)V

    .line 127
    .end local v0    # "pos":I
    :cond_2
    iget-object v1, p0, Lcom/android/mail/AccountSpinnerAdapter$2;->this$0:Lcom/android/mail/AccountSpinnerAdapter;

    invoke-virtual {v1}, Lcom/android/mail/AccountSpinnerAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method
