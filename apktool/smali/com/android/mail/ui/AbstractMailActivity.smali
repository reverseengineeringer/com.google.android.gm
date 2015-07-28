.class public abstract Lcom/android/mail/ui/AbstractMailActivity;
.super Landroid/app/Activity;
.source "AbstractMailActivity.java"

# interfaces
.implements Lcom/android/mail/ui/RestrictedActivity;


# static fields
.field private static sForegroundInstance:Lcom/android/mail/ui/AbstractMailActivity;


# instance fields
.field private mForegroundNdef:Landroid/nfc/NdefMessage;

.field private mNfcAdapter:Landroid/nfc/NfcAdapter;

.field private final mUiHandler:Lcom/android/mail/ui/UiHandler;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 43
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 49
    new-instance v0, Lcom/android/mail/ui/UiHandler;

    invoke-direct {v0}, Lcom/android/mail/ui/UiHandler;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mUiHandler:Lcom/android/mail/ui/UiHandler;

    return-void
.end method


# virtual methods
.method public getActivityContext()Landroid/content/Context;
    .locals 0

    .prologue
    .line 173
    return-object p0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 69
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 71
    invoke-static {p0}, Landroid/nfc/NfcAdapter;->getDefaultAdapter(Landroid/content/Context;)Landroid/nfc/NfcAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    .line 72
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v0, :cond_0

    .line 75
    const-string v0, "test@android.com"

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mUiHandler:Lcom/android/mail/ui/UiHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/UiHandler;->setEnabled(Z)V

    .line 78
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 96
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 97
    monitor-enter p0

    .line 98
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    invoke-virtual {v0, p0}, Landroid/nfc/NfcAdapter;->disableForegroundNdefPush(Landroid/app/Activity;)V

    .line 101
    :cond_0
    const/4 v0, 0x0

    sput-object v0, Lcom/android/mail/ui/AbstractMailActivity;->sForegroundInstance:Lcom/android/mail/ui/AbstractMailActivity;

    .line 102
    monitor-exit p0

    .line 103
    return-void

    .line 102
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
    .line 107
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 108
    monitor-enter p0

    .line 109
    :try_start_0
    sput-object p0, Lcom/android/mail/ui/AbstractMailActivity;->sForegroundInstance:Lcom/android/mail/ui/AbstractMailActivity;

    .line 110
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractMailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    invoke-virtual {v0, p0, v1}, Landroid/nfc/NfcAdapter;->enableForegroundNdefPush(Landroid/app/Activity;Landroid/nfc/NdefMessage;)V

    .line 113
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 115
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mUiHandler:Lcom/android/mail/ui/UiHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/UiHandler;->setEnabled(Z)V

    .line 116
    return-void

    .line 113
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
    .line 89
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 91
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mUiHandler:Lcom/android/mail/ui/UiHandler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/UiHandler;->setEnabled(Z)V

    .line 92
    return-void
.end method

.method protected onStart()V
    .locals 2

    .prologue
    .line 82
    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    .line 84
    iget-object v0, p0, Lcom/android/mail/ui/AbstractMailActivity;->mUiHandler:Lcom/android/mail/ui/UiHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/UiHandler;->setEnabled(Z)V

    .line 85
    return-void
.end method
