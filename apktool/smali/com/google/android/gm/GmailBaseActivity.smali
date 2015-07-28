.class public abstract Lcom/google/android/gm/GmailBaseActivity;
.super Landroid/app/Activity;
.source "GmailBaseActivity.java"

# interfaces
.implements Lcom/google/android/gm/ApplicationMenuHandler$HelpCallback;
.implements Lcom/google/android/gm/RestrictedActivity;


# static fields
.field private static sForegroundInstance:Lcom/google/android/gm/GmailBaseActivity;


# instance fields
.field private mForegroundNdef:Landroid/nfc/NdefMessage;

.field private mNfcAdapter:Landroid/nfc/NfcAdapter;

.field mOnMailEnginePrepared:Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;

.field private final mUiHandler:Lcom/google/android/gm/UiHandler;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 29
    new-instance v0, Lcom/google/android/gm/UiHandler;

    invoke-direct {v0}, Lcom/google/android/gm/UiHandler;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mUiHandler:Lcom/google/android/gm/UiHandler;

    .line 90
    new-instance v0, Lcom/google/android/gm/GmailBaseActivity$1;

    invoke-direct {v0, p0}, Lcom/google/android/gm/GmailBaseActivity$1;-><init>(Lcom/google/android/gm/GmailBaseActivity;)V

    iput-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mOnMailEnginePrepared:Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;

    return-void
.end method


# virtual methods
.method public getContext()Landroid/content/Context;
    .locals 0

    .prologue
    .line 49
    return-object p0
.end method

.method public getHelpContext()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    const-string v0, "gm"

    return-object v0
.end method

.method public getUiHandler()Lcom/google/android/gm/UiHandler;
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mUiHandler:Lcom/google/android/gm/UiHandler;

    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 33
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 35
    invoke-static {p0}, Landroid/nfc/NfcAdapter;->getDefaultAdapter(Landroid/content/Context;)Landroid/nfc/NfcAdapter;

    move-result-object v1

    iput-object v1, p0, Lcom/google/android/gm/GmailBaseActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    .line 36
    iget-object v1, p0, Lcom/google/android/gm/GmailBaseActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v1, :cond_0

    .line 38
    invoke-static {}, Lcom/google/android/gm/persistence/Persistence;->getInstance()Lcom/google/android/gm/persistence/Persistence;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/google/android/gm/persistence/Persistence;->getActiveAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 39
    .local v0, "realAccount":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 40
    iget-object v1, p0, Lcom/google/android/gm/GmailBaseActivity;->mOnMailEnginePrepared:Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;

    invoke-static {p0, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->getOrMakeMailEngineAsync(Landroid/content/Context;Ljava/lang/String;Lcom/google/android/gm/provider/MailEngine$MailEngineResultCallback;)V

    .line 44
    .end local v0    # "realAccount":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/google/android/gm/GmailBaseActivity;->mUiHandler:Lcom/google/android/gm/UiHandler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/google/android/gm/UiHandler;->setEnabled(Z)V

    .line 45
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 68
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 69
    monitor-enter p0

    .line 70
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    if-eqz v0, :cond_0

    .line 71
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    invoke-virtual {v0, p0}, Landroid/nfc/NfcAdapter;->disableForegroundNdefPush(Landroid/app/Activity;)V

    .line 73
    :cond_0
    const/4 v0, 0x0

    sput-object v0, Lcom/google/android/gm/GmailBaseActivity;->sForegroundInstance:Lcom/google/android/gm/GmailBaseActivity;

    .line 74
    monitor-exit p0

    .line 75
    return-void

    .line 74
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 79
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 80
    monitor-enter p0

    .line 81
    :try_start_0
    sput-object p0, Lcom/google/android/gm/GmailBaseActivity;->sForegroundInstance:Lcom/google/android/gm/GmailBaseActivity;

    .line 82
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    if-eqz v0, :cond_0

    .line 83
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    iget-object v1, p0, Lcom/google/android/gm/GmailBaseActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    invoke-virtual {v0, p0, v1}, Landroid/nfc/NfcAdapter;->enableForegroundNdefPush(Landroid/app/Activity;Landroid/nfc/NdefMessage;)V

    .line 85
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 87
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mUiHandler:Lcom/google/android/gm/UiHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/UiHandler;->setEnabled(Z)V

    .line 88
    return-void

    .line 85
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 61
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 63
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mUiHandler:Lcom/google/android/gm/UiHandler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/google/android/gm/UiHandler;->setEnabled(Z)V

    .line 64
    return-void
.end method

.method protected onStart()V
    .locals 2

    .prologue
    .line 54
    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    .line 56
    iget-object v0, p0, Lcom/google/android/gm/GmailBaseActivity;->mUiHandler:Lcom/google/android/gm/UiHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/UiHandler;->setEnabled(Z)V

    .line 57
    return-void
.end method
