.class Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;
.super Lcom/android/mail/utils/DelayedTaskHandler;
.source "MailEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DatasetChangedNotifier"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mIntent:Landroid/content/Intent;

.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/MailEngine;Landroid/content/Context;I)V
    .locals 3
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "refreshDelay"    # I

    .prologue
    .line 6738
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->this$0:Lcom/google/android/gm/provider/MailEngine;

    .line 6739
    # invokes: Lcom/google/android/gm/provider/MailEngine;->getNotifyDatasetChangedLooper()Landroid/os/Looper;
    invoke-static {}, Lcom/google/android/gm/provider/MailEngine;->access$4900()Landroid/os/Looper;

    move-result-object v0

    invoke-direct {p0, v0, p3}, Lcom/android/mail/utils/DelayedTaskHandler;-><init>(Landroid/os/Looper;I)V

    .line 6741
    iput-object p2, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->mContext:Landroid/content/Context;

    .line 6742
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.android.mail.ACTION_NOTIFY_DATASET_CHANGED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->mIntent:Landroid/content/Intent;

    .line 6743
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->mIntent:Landroid/content/Intent;

    const-string v1, "accountUri"

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {p1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v2

    iget-object v2, v2, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-static {v2}, Lcom/google/android/gm/provider/UiProvider;->getAccountUri(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 6745
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->mIntent:Landroid/content/Intent;

    const-string v1, "application/gmail-ls"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 6746
    return-void
.end method


# virtual methods
.method protected performTask()V
    .locals 2

    .prologue
    .line 6750
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$DatasetChangedNotifier;->mIntent:Landroid/content/Intent;

    invoke-virtual {v0, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 6751
    return-void
.end method
