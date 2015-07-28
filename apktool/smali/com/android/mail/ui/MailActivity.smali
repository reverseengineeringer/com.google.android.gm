.class public Lcom/android/mail/ui/MailActivity;
.super Lcom/android/mail/ui/AbstractMailActivity;
.source "MailActivity.java"

# interfaces
.implements Lcom/android/mail/ui/ControllableActivity;


# static fields
.field private static sForegroundInstance:Lcom/android/mail/ui/MailActivity;


# instance fields
.field private mAccessibilityEnabled:Z

.field private mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

.field private mController:Lcom/android/mail/ui/ActivityController;

.field private mForegroundNdef:Landroid/nfc/NdefMessage;

.field private mLaunchedCleanly:Z

.field private mNfcAdapter:Landroid/nfc/NfcAdapter;

.field private mPendingToastOp:Lcom/android/mail/ui/ToastBarOperation;

.field private mViewMode:Lcom/android/mail/ui/ViewMode;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 75
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractMailActivity;-><init>()V

    .line 65
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/MailActivity;->mLaunchedCleanly:Z

    .line 76
    return-void
.end method

.method public static getMailtoNdef(Ljava/lang/String;)Landroid/nfc/NdefMessage;
    .locals 9
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 178
    :try_start_0
    const-string v5, "UTF-8"

    invoke-static {p0, v5}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "UTF-8"

    invoke-virtual {v5, v6}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 182
    .local v0, "accountBytes":[B
    :goto_0
    const/4 v3, 0x6

    .line 183
    .local v3, "prefix":B
    array-length v5, v0

    add-int/lit8 v5, v5, 0x1

    new-array v4, v5, [B

    .line 184
    .local v4, "recordBytes":[B
    aput-byte v3, v4, v7

    .line 185
    array-length v5, v0

    invoke-static {v0, v7, v4, v8, v5}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    .line 186
    new-instance v2, Landroid/nfc/NdefRecord;

    sget-object v5, Landroid/nfc/NdefRecord;->RTD_URI:[B

    new-array v6, v7, [B

    invoke-direct {v2, v8, v5, v6, v4}, Landroid/nfc/NdefRecord;-><init>(S[B[B[B)V

    .line 188
    .local v2, "mailto":Landroid/nfc/NdefRecord;
    new-instance v5, Landroid/nfc/NdefMessage;

    new-array v6, v8, [Landroid/nfc/NdefRecord;

    aput-object v2, v6, v7

    invoke-direct {v5, v6}, Landroid/nfc/NdefMessage;-><init>([Landroid/nfc/NdefRecord;)V

    return-object v5

    .line 179
    .end local v0    # "accountBytes":[B
    .end local v2    # "mailto":Landroid/nfc/NdefRecord;
    .end local v3    # "prefix":B
    .end local v4    # "recordBytes":[B
    :catch_0
    move-exception v1

    .line 180
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .restart local v0    # "accountBytes":[B
    goto :goto_0
.end method

.method public static setForegroundNdef(Landroid/nfc/NdefMessage;)V
    .locals 3
    .param p0, "ndef"    # Landroid/nfc/NdefMessage;

    .prologue
    .line 154
    sget-object v0, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    .line 155
    .local v0, "foreground":Lcom/android/mail/ui/MailActivity;
    if-eqz v0, :cond_1

    iget-object v1, v0, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v1, :cond_1

    .line 156
    monitor-enter v0

    .line 157
    :try_start_0
    iput-object p0, v0, Lcom/android/mail/ui/MailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    .line 158
    sget-object v1, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    if-eqz v1, :cond_0

    .line 159
    if-eqz p0, :cond_2

    .line 160
    sget-object v1, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    iget-object v1, v1, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    sget-object v2, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    invoke-virtual {v1, v2, p0}, Landroid/nfc/NfcAdapter;->enableForegroundNdefPush(Landroid/app/Activity;Landroid/nfc/NdefMessage;)V

    .line 167
    :cond_0
    :goto_0
    monitor-exit v0

    .line 169
    :cond_1
    return-void

    .line 163
    :cond_2
    sget-object v1, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    iget-object v1, v1, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    sget-object v2, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    invoke-virtual {v1, v2}, Landroid/nfc/NfcAdapter;->disableForegroundNdefPush(Landroid/app/Activity;)V

    goto :goto_0

    .line 167
    :catchall_0
    move-exception v1

    monitor-exit v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method private setupNfc()V
    .locals 1

    .prologue
    .line 146
    invoke-static {p0}, Landroid/nfc/NfcAdapter;->getDefaultAdapter(Landroid/content/Context;)Landroid/nfc/NfcAdapter;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    .line 147
    return-void
.end method


# virtual methods
.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onTouchEvent(Landroid/view/MotionEvent;)V

    .line 81
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public doNothingClickHandler(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 393
    return-void
.end method

.method public getAccountController()Lcom/android/mail/ui/AccountController;
    .locals 1

    .prologue
    .line 402
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;
    .locals 1

    .prologue
    .line 361
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getErrorListener()Lcom/android/mail/ui/ErrorListener;
    .locals 1

    .prologue
    .line 371
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getFolderController()Lcom/android/mail/ui/FolderController;
    .locals 1

    .prologue
    .line 331
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getFolderListSelectionListener()Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getHierarchyFolder()Lcom/android/mail/providers/Folder;
    .locals 1

    .prologue
    .line 356
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->getHierarchyFolder()Lcom/android/mail/providers/Folder;

    move-result-object v0

    return-object v0
.end method

.method public getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;
    .locals 1

    .prologue
    .line 316
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getPendingToastOperation()Lcom/android/mail/ui/ToastBarOperation;
    .locals 1

    .prologue
    .line 381
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mPendingToastOp:Lcom/android/mail/ui/ToastBarOperation;

    return-object v0
.end method

.method public getRecentFolderController()Lcom/android/mail/ui/RecentFolderController;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    return-object v0
.end method

.method public getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;
    .locals 1

    .prologue
    .line 336
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v0

    return-object v0
.end method

.method public getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;
    .locals 1

    .prologue
    .line 366
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    return-object v0
.end method

.method public getViewMode()Lcom/android/mail/ui/ViewMode;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mViewMode:Lcom/android/mail/ui/ViewMode;

    return-object v0
.end method

.method public handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "event"    # Landroid/view/DragEvent;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 346
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1, p2}, Lcom/android/mail/ui/ActivityController;->handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V

    .line 347
    return-void
.end method

.method public isAccessibilityEnabled()Z
    .locals 1

    .prologue
    .line 432
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityEnabled:Z

    return v0
.end method

.method public onAccessibilityStateChanged(Z)V
    .locals 1
    .param p1, "enabled"    # Z

    .prologue
    .line 436
    iput-boolean p1, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityEnabled:Z

    .line 437
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onAccessibilityStateChanged()V

    .line 438
    return-void
.end method

.method public onActionModeFinished(Landroid/view/ActionMode;)V
    .locals 0
    .param p1, "mode"    # Landroid/view/ActionMode;

    .prologue
    .line 94
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onActionModeFinished(Landroid/view/ActionMode;)V

    .line 95
    return-void
.end method

.method public onActionModeStarted(Landroid/view/ActionMode;)V
    .locals 0
    .param p1, "mode"    # Landroid/view/ActionMode;

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onActionModeStarted(Landroid/view/ActionMode;)V

    .line 100
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 104
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1, p2, p3}, Lcom/android/mail/ui/ActivityController;->onActivityResult(IILandroid/content/Intent;)V

    .line 105
    return-void
.end method

.method public onAnimationEnd(Lcom/android/mail/ui/AnimatedAdapter;)V
    .locals 1
    .param p1, "animatedAdapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 397
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onAnimationEnd(Lcom/android/mail/ui/AnimatedAdapter;)V

    .line 398
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onBackPressed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 110
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onBackPressed()V

    .line 112
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onCreate(Landroid/os/Bundle;)V

    .line 118
    new-instance v2, Lcom/android/mail/ui/ViewMode;

    invoke-direct {v2, p0}, Lcom/android/mail/ui/ViewMode;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/android/mail/ui/MailActivity;->mViewMode:Lcom/android/mail/ui/ViewMode;

    .line 119
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v1

    .line 120
    .local v1, "tabletUi":Z
    iget-object v2, p0, Lcom/android/mail/ui/MailActivity;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-static {p0, v2, v1}, Lcom/android/mail/ui/ControllerFactory;->forActivity(Lcom/android/mail/ui/MailActivity;Lcom/android/mail/ui/ViewMode;Z)Lcom/android/mail/ui/ActivityController;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    .line 121
    iget-object v2, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v2, p1}, Lcom/android/mail/ui/ActivityController;->onCreate(Landroid/os/Bundle;)Z

    .line 123
    invoke-virtual {p0}, Lcom/android/mail/ui/MailActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 130
    .local v0, "intent":Landroid/content/Intent;
    if-nez p1, :cond_0

    invoke-virtual {v0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 131
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/android/mail/ui/MailActivity;->mLaunchedCleanly:Z

    .line 133
    :cond_0
    const-string v2, "accessibility"

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/MailActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/accessibility/AccessibilityManager;

    iput-object v2, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    .line 135
    iget-object v2, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v2}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v2

    iput-boolean v2, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityEnabled:Z

    .line 136
    invoke-direct {p0}, Lcom/android/mail/ui/MailActivity;->setupNfc()V

    .line 137
    return-void
.end method

.method public onCreateDialog(ILandroid/os/Bundle;)Landroid/app/Dialog;
    .locals 2
    .param p1, "id"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 199
    iget-object v1, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v1, p1, p2}, Lcom/android/mail/ui/ActivityController;->onCreateDialog(ILandroid/os/Bundle;)Landroid/app/Dialog;

    move-result-object v0

    .line 201
    .local v0, "dialog":Landroid/app/Dialog;
    if-nez v0, :cond_0

    invoke-super {p0, p1, p2}, Lcom/android/mail/ui/AbstractMailActivity;->onCreateDialog(ILandroid/os/Bundle;)Landroid/app/Dialog;

    move-result-object v0

    .end local v0    # "dialog":Landroid/app/Dialog;
    :cond_0
    return-object v0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 206
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 294
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onDestroy()V

    .line 295
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onDestroy()V

    .line 296
    return-void
.end method

.method public onFooterViewErrorActionClick(Lcom/android/mail/providers/Folder;I)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "errorStatus"    # I

    .prologue
    .line 412
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1, p2}, Lcom/android/mail/ui/ActivityController;->onFooterViewErrorActionClick(Lcom/android/mail/providers/Folder;I)V

    .line 413
    return-void
.end method

.method public onFooterViewLoadMoreClick(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 417
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onFooterViewLoadMoreClick(Lcom/android/mail/providers/Folder;)V

    .line 418
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 211
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1, p2}, Lcom/android/mail/ui/ActivityController;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1, p2}, Lcom/android/mail/ui/AbstractMailActivity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 216
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 221
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onPause()V

    .line 222
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onPause()V

    .line 223
    monitor-enter p0

    .line 224
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    if-eqz v0, :cond_0

    .line 225
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    invoke-virtual {v0, p0}, Landroid/nfc/NfcAdapter;->disableForegroundNdefPush(Landroid/app/Activity;)V

    .line 227
    :cond_0
    const/4 v0, 0x0

    sput-object v0, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    .line 228
    monitor-exit p0

    .line 229
    return-void

    .line 228
    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public onPrepareDialog(ILandroid/app/Dialog;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "id"    # I
    .param p2, "dialog"    # Landroid/app/Dialog;
    .param p3, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 233
    invoke-super {p0, p1, p2, p3}, Lcom/android/mail/ui/AbstractMailActivity;->onPrepareDialog(ILandroid/app/Dialog;Landroid/os/Bundle;)V

    .line 234
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1, p2, p3}, Lcom/android/mail/ui/ActivityController;->onPrepareDialog(ILandroid/app/Dialog;Landroid/os/Bundle;)V

    .line 235
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 239
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    .line 240
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method protected onRestart()V
    .locals 1

    .prologue
    .line 141
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onRestart()V

    .line 142
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onRestart()V

    .line 143
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 193
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 194
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 195
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 245
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onResume()V

    .line 246
    iget-object v1, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v1}, Lcom/android/mail/ui/ActivityController;->onResume()V

    .line 247
    monitor-enter p0

    .line 248
    :try_start_0
    sput-object p0, Lcom/android/mail/ui/MailActivity;->sForegroundInstance:Lcom/android/mail/ui/MailActivity;

    .line 249
    iget-object v1, p0, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/MailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    if-eqz v1, :cond_0

    .line 250
    iget-object v1, p0, Lcom/android/mail/ui/MailActivity;->mNfcAdapter:Landroid/nfc/NfcAdapter;

    iget-object v2, p0, Lcom/android/mail/ui/MailActivity;->mForegroundNdef:Landroid/nfc/NdefMessage;

    invoke-virtual {v1, p0, v2}, Landroid/nfc/NfcAdapter;->enableForegroundNdefPush(Landroid/app/Activity;Landroid/nfc/NdefMessage;)V

    .line 252
    :cond_0
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 253
    iget-object v1, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityManager:Landroid/view/accessibility/AccessibilityManager;

    invoke-virtual {v1}, Landroid/view/accessibility/AccessibilityManager;->isEnabled()Z

    move-result v0

    .line 254
    .local v0, "enabled":Z
    iget-boolean v1, p0, Lcom/android/mail/ui/MailActivity;->mAccessibilityEnabled:Z

    if-eq v0, v1, :cond_1

    .line 255
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/MailActivity;->onAccessibilityStateChanged(Z)V

    .line 257
    :cond_1
    return-void

    .line 252
    .end local v0    # "enabled":Z
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 261
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 262
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 263
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->startSearch()V

    .line 283
    const/4 v0, 0x1

    return v0
.end method

.method public onSearchRequested(Ljava/lang/String;)Z
    .locals 1
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 267
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onSearchRequested(Ljava/lang/String;)V

    .line 268
    const/4 v0, 0x1

    return v0
.end method

.method protected onStart()V
    .locals 1

    .prologue
    .line 273
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onStart()V

    .line 274
    iget-boolean v0, p0, Lcom/android/mail/ui/MailActivity;->mLaunchedCleanly:Z

    if-eqz v0, :cond_0

    .line 277
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onStart()V

    .line 278
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 288
    invoke-super {p0}, Lcom/android/mail/ui/AbstractMailActivity;->onStop()V

    .line 289
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->onStop()V

    .line 290
    return-void
.end method

.method public onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 1
    .param p1, "undoOp"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    .line 351
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V

    .line 352
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasFocus"    # Z

    .prologue
    .line 300
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractMailActivity;->onWindowFocusChanged(Z)V

    .line 301
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ActivityController;->onWindowFocusChanged(Z)V

    .line 302
    return-void
.end method

.method public setPendingToastOperation(Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 0
    .param p1, "op"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    .line 376
    iput-object p1, p0, Lcom/android/mail/ui/MailActivity;->mPendingToastOp:Lcom/android/mail/ui/ToastBarOperation;

    .line 377
    return-void
.end method

.method public startDragMode()V
    .locals 1

    .prologue
    .line 422
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->startDragMode()V

    .line 423
    return-void
.end method

.method public stopDragMode()V
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0}, Lcom/android/mail/ui/ActivityController;->stopDragMode()V

    .line 428
    return-void
.end method

.method public supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/DragEvent;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 341
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mController:Lcom/android/mail/ui/ActivityController;

    invoke-interface {v0, p1, p2}, Lcom/android/mail/ui/ActivityController;->supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    return v0
.end method

.method public unsetViewModeListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/mail/ui/ViewMode$ModeChangeListener;

    .prologue
    .line 311
    iget-object v0, p0, Lcom/android/mail/ui/MailActivity;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/ViewMode;->removeListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V

    .line 312
    return-void
.end method
