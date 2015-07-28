.class public Lcom/google/android/gm/ui/FolderSelectionActivityGmail;
.super Lcom/android/mail/ui/FolderSelectionActivity;
.source "FolderSelectionActivityGmail.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/android/mail/ui/FolderSelectionActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected createWidget(ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "selectedFolder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 19
    invoke-static {p0, p1, p2, p3}, Lcom/android/mail/widget/BaseGmailWidgetProvider;->updateWidget(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 20
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 21
    .local v0, "result":Landroid/content/Intent;
    const-string v1, "appWidgetId"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 22
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/google/android/gm/ui/FolderSelectionActivityGmail;->setResult(ILandroid/content/Intent;)V

    .line 23
    invoke-virtual {p0}, Lcom/google/android/gm/ui/FolderSelectionActivityGmail;->finish()V

    .line 24
    return-void
.end method
