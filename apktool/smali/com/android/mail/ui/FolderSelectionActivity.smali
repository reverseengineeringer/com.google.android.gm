.class public Lcom/android/mail/ui/FolderSelectionActivity;
.super Landroid/app/Activity;
.source "FolderSelectionActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;
.implements Landroid/view/View$OnClickListener;
.implements Lcom/android/mail/ui/ControllableActivity;
.implements Lcom/android/mail/ui/FolderChangeListener;
.implements Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private mAppWidgetId:I

.field private mConfigureShortcut:Z

.field private mConfigureWidget:Z

.field private mMode:I

.field private mSelectedFolder:Lcom/android/mail/providers/Folder;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/FolderSelectionActivity;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 62
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAppWidgetId:I

    .line 63
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mMode:I

    return-void
.end method

.method private createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V
    .locals 3
    .param p1, "parent"    # Lcom/android/mail/providers/Folder;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 109
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 110
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    const/4 v2, 0x0

    invoke-static {p1, p2, v2}, Lcom/android/mail/ui/FolderListFragment;->newInstance(Lcom/android/mail/providers/Folder;Landroid/net/Uri;Z)Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    .line 111
    .local v0, "fragment":Landroid/app/Fragment;
    const v2, 0x7f1000be

    invoke-virtual {v1, v2, v0}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 112
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 113
    return-void
.end method

.method private doCancel()V
    .locals 1

    .prologue
    .line 137
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/FolderSelectionActivity;->setResult(I)V

    .line 138
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->finish()V

    .line 139
    return-void
.end method


# virtual methods
.method protected createWidget(ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p1, "id"    # I
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "selectedFolder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 145
    invoke-static {p0, p1, p2, p3}, Lcom/android/mail/widget/WidgetProvider;->updateWidget(Landroid/content/Context;ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 146
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 147
    .local v0, "result":Landroid/content/Intent;
    const-string v1, "appWidgetId"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 148
    const/4 v1, -0x1

    invoke-virtual {p0, v1, v0}, Lcom/android/mail/ui/FolderSelectionActivity;->setResult(ILandroid/content/Intent;)V

    .line 149
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->finish()V

    .line 150
    return-void
.end method

.method public getAccountController()Lcom/android/mail/ui/AccountController;
    .locals 1

    .prologue
    .line 325
    const/4 v0, 0x0

    return-object v0
.end method

.method public getActivityContext()Landroid/content/Context;
    .locals 0

    .prologue
    .line 215
    return-object p0
.end method

.method public getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;
    .locals 1

    .prologue
    .line 290
    const/4 v0, 0x0

    return-object v0
.end method

.method public getErrorListener()Lcom/android/mail/ui/ErrorListener;
    .locals 1

    .prologue
    .line 300
    const/4 v0, 0x0

    return-object v0
.end method

.method public getFolderController()Lcom/android/mail/ui/FolderController;
    .locals 1

    .prologue
    .line 315
    const/4 v0, 0x0

    return-object v0
.end method

.method public getFolderListSelectionListener()Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;
    .locals 0

    .prologue
    .line 265
    return-object p0
.end method

.method public getHierarchyFolder()Lcom/android/mail/providers/Folder;
    .locals 1

    .prologue
    .line 285
    const/4 v0, 0x0

    return-object v0
.end method

.method public getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;
    .locals 1

    .prologue
    .line 233
    const/4 v0, 0x0

    return-object v0
.end method

.method public getPendingToastOperation()Lcom/android/mail/ui/ToastBarOperation;
    .locals 1

    .prologue
    .line 310
    const/4 v0, 0x0

    return-object v0
.end method

.method public getRecentFolderController()Lcom/android/mail/ui/RecentFolderController;
    .locals 1

    .prologue
    .line 351
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;
    .locals 1

    .prologue
    .line 248
    const/4 v0, 0x0

    return-object v0
.end method

.method public getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;
    .locals 1

    .prologue
    .line 295
    const/4 v0, 0x0

    return-object v0
.end method

.method public getViewMode()Lcom/android/mail/ui/ViewMode;
    .locals 1

    .prologue
    .line 220
    const/4 v0, 0x0

    return-object v0
.end method

.method public handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "event"    # Landroid/view/DragEvent;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 276
    return-void
.end method

.method public isAccessibilityEnabled()Z
    .locals 1

    .prologue
    .line 357
    const/4 v0, 0x1

    return v0
.end method

.method public onAnimationEnd(Lcom/android/mail/ui/AnimatedAdapter;)V
    .locals 0
    .param p1, "animatedAdapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 320
    return-void
.end method

.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 3
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 154
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 156
    iget v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAppWidgetId:I

    iget-object v1, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mSelectedFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/FolderSelectionActivity;->createWidget(ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    .line 160
    :goto_0
    return-void

    .line 158
    :cond_0
    invoke-direct {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->doCancel()V

    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 125
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 134
    :cond_0
    :goto_0
    return-void

    .line 127
    :pswitch_0
    iget v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mMode:I

    if-nez v0, :cond_0

    .line 128
    invoke-direct {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->doCancel()V

    goto :goto_0

    .line 125
    :pswitch_data_0
    .packed-switch 0x7f1000cf
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "icicle"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 67
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 69
    const v4, 0x7f040042

    invoke-virtual {p0, v4}, Lcom/android/mail/ui/FolderSelectionActivity;->setContentView(I)V

    .line 71
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 72
    .local v3, "intent":Landroid/content/Intent;
    invoke-virtual {v3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 73
    .local v0, "action":Ljava/lang/String;
    const-string v4, "android.intent.action.CREATE_SHORTCUT"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    iput-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureShortcut:Z

    .line 74
    const-string v4, "android.appwidget.action.APPWIDGET_CONFIGURE"

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    iput-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureWidget:Z

    .line 75
    iget-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureShortcut:Z

    if-nez v4, :cond_0

    iget-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureWidget:Z

    if-nez v4, :cond_0

    .line 76
    sget-object v4, Lcom/android/mail/ui/FolderSelectionActivity;->LOG_TAG:Ljava/lang/String;

    const-string v5, "unexpected intent: %s"

    new-array v6, v8, [Ljava/lang/Object;

    aput-object v3, v6, v7

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 78
    :cond_0
    iget-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureShortcut:Z

    if-nez v4, :cond_1

    iget-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureWidget:Z

    if-eqz v4, :cond_5

    .line 79
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    .line 80
    .local v1, "actionBar":Landroid/app/ActionBar;
    if-eqz v1, :cond_2

    .line 81
    const v4, 0x7f030001

    invoke-virtual {v1, v4}, Landroid/app/ActionBar;->setIcon(I)V

    .line 83
    :cond_2
    iput v7, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mMode:I

    .line 88
    .end local v1    # "actionBar":Landroid/app/ActionBar;
    :goto_0
    iget-boolean v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureWidget:Z

    if-eqz v4, :cond_3

    .line 89
    const-string v4, "appWidgetId"

    invoke-virtual {v3, v4, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAppWidgetId:I

    .line 91
    iget v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAppWidgetId:I

    if-nez v4, :cond_3

    .line 92
    sget-object v4, Lcom/android/mail/ui/FolderSelectionActivity;->LOG_TAG:Ljava/lang/String;

    const-string v5, "invalid widgetId"

    new-array v6, v7, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 96
    :cond_3
    const-string v4, "account-shortcut"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v4

    check-cast v4, Lcom/android/mail/providers/Account;

    iput-object v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAccount:Lcom/android/mail/providers/Account;

    .line 97
    const v4, 0x7f1000cf

    invoke-virtual {p0, v4}, Lcom/android/mail/ui/FolderSelectionActivity;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    .line 98
    .local v2, "firstButton":Landroid/widget/Button;
    invoke-virtual {v2, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 100
    iget v4, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mMode:I

    if-ne v4, v8, :cond_4

    .line 101
    invoke-virtual {v2, v7}, Landroid/widget/Button;->setEnabled(Z)V

    .line 103
    :cond_4
    invoke-virtual {v2, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, v5, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-direct {p0, v4, v5}, Lcom/android/mail/ui/FolderSelectionActivity;->createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V

    .line 106
    return-void

    .line 85
    .end local v2    # "firstButton":Landroid/widget/Button;
    :cond_5
    iput v8, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mMode:I

    goto :goto_0
.end method

.method public onFolderChanged(Lcom/android/mail/providers/Folder;)V
    .locals 4

    .prologue
    .line 164
    iget-object v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mSelectedFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v0}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 165
    iput-object p1, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mSelectedFolder:Lcom/android/mail/providers/Folder;

    .line 166
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 168
    iget-boolean v1, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureShortcut:Z

    if-eqz v1, :cond_1

    .line 175
    iget-object v1, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mSelectedFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v1, v2}, Lcom/android/mail/utils/Utils;->createViewFolderIntent(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)Landroid/content/Intent;

    move-result-object v1

    .line 177
    const-string v2, "android.intent.extra.shortcut.INTENT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 178
    const-string v1, "android.intent.extra.shortcut.ICON_RESOURCE"

    const v2, 0x7f030001

    invoke-static {p0, v2}, Landroid/content/Intent$ShortcutIconResource;->fromContext(Landroid/content/Context;I)Landroid/content/Intent$ShortcutIconResource;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 182
    iget-object v1, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mSelectedFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, v1, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    .line 184
    const-string v2, "android.intent.extra.shortcut.NAME"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 191
    new-instance v2, Landroid/content/Intent;

    const-class v3, Lcom/android/mail/ui/ShortcutNameActivity;

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 192
    const/high16 v3, 0x42000000    # 32.0f

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 194
    const-string v3, "extra_folder_click_intent"

    invoke-virtual {v2, v3, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 196
    const-string v0, "extra_shortcut_name"

    invoke-virtual {v2, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/CharSequence;)Landroid/content/Intent;

    .line 199
    invoke-virtual {p0, v2}, Lcom/android/mail/ui/FolderSelectionActivity;->startActivity(Landroid/content/Intent;)V

    .line 200
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderSelectionActivity;->finish()V

    .line 205
    :cond_0
    :goto_0
    return-void

    .line 201
    :cond_1
    iget-boolean v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mConfigureWidget:Z

    if-eqz v0, :cond_0

    .line 202
    iget v0, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAppWidgetId:I

    iget-object v1, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/ui/FolderSelectionActivity;->mSelectedFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/FolderSelectionActivity;->createWidget(ILcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method public onFolderSelected(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 253
    iget-boolean v0, p1, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v0, :cond_0

    .line 257
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/FolderSelectionActivity;->createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V

    .line 261
    :goto_0
    return-void

    .line 260
    :cond_0
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderSelectionActivity;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method public onFooterViewErrorActionClick(Lcom/android/mail/providers/Folder;I)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "errorStatus"    # I

    .prologue
    .line 331
    return-void
.end method

.method public onFooterViewLoadMoreClick(Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 336
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 117
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 121
    return-void
.end method

.method public onSearchRequested(Ljava/lang/String;)Z
    .locals 1
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 243
    const/4 v0, 0x0

    return v0
.end method

.method public onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 0
    .param p1, "undoOp"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    .line 281
    return-void
.end method

.method public setPendingToastOperation(Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 0
    .param p1, "op"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    .line 306
    return-void
.end method

.method public startDragMode()V
    .locals 0

    .prologue
    .line 341
    return-void
.end method

.method public stopDragMode()V
    .locals 0

    .prologue
    .line 346
    return-void
.end method

.method public supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/DragEvent;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 270
    const/4 v0, 0x0

    return v0
.end method

.method public unsetViewModeListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/android/mail/ui/ViewMode$ModeChangeListener;

    .prologue
    .line 229
    return-void
.end method
