.class Lcom/android/mail/ui/MailboxSelectionActivity$1;
.super Landroid/os/AsyncTask;
.source "MailboxSelectionActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/MailboxSelectionActivity;->setupWithAccounts()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/MailboxSelectionActivity;

.field final synthetic val$resolver:Landroid/content/ContentResolver;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/MailboxSelectionActivity;Landroid/content/ContentResolver;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/android/mail/ui/MailboxSelectionActivity$1;->this$0:Lcom/android/mail/ui/MailboxSelectionActivity;

    iput-object p2, p0, Lcom/android/mail/ui/MailboxSelectionActivity$1;->val$resolver:Landroid/content/ContentResolver;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 180
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MailboxSelectionActivity$1;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 8
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v7, 0x0

    .line 183
    const/4 v6, 0x0

    .line 185
    .local v6, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/MailboxSelectionActivity$1;->val$resolver:Landroid/content/ContentResolver;

    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getAccountsUri()Landroid/net/Uri;

    move-result-object v1

    sget-object v2, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 187
    iget-object v0, p0, Lcom/android/mail/ui/MailboxSelectionActivity$1;->this$0:Lcom/android/mail/ui/MailboxSelectionActivity;

    # invokes: Lcom/android/mail/ui/MailboxSelectionActivity;->completeSetupWithAccounts(Landroid/database/Cursor;)V
    invoke-static {v0, v6}, Lcom/android/mail/ui/MailboxSelectionActivity;->access$000(Lcom/android/mail/ui/MailboxSelectionActivity;Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 189
    if-eqz v6, :cond_0

    .line 190
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 193
    :cond_0
    return-object v7

    .line 189
    :catchall_0
    move-exception v0

    if-eqz v6, :cond_1

    .line 190
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    :cond_1
    throw v0
.end method
