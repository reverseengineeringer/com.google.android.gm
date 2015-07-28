.class public final Lcom/android/mail/ui/OnePaneController;
.super Lcom/android/mail/ui/AbstractActivityController;
.source "OnePaneController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;
    }
.end annotation


# instance fields
.field private mConversationListNeverShown:Z

.field private mConversationListVisible:Z

.field private mInbox:Lcom/android/mail/providers/Folder;

.field private mLastConversationListTransactionId:I

.field private mLastConversationTransactionId:I

.field private mLastFolderListTransactionId:I

.field private mLastInboxConversationListTransactionId:I


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/MailActivity;Lcom/android/mail/ui/ViewMode;)V
    .locals 2
    .param p1, "activity"    # Lcom/android/mail/ui/MailActivity;
    .param p2, "viewMode"    # Lcom/android/mail/ui/ViewMode;

    .prologue
    const/4 v1, -0x1

    .line 75
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;-><init>(Lcom/android/mail/ui/MailActivity;Lcom/android/mail/ui/ViewMode;)V

    .line 61
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    .line 62
    iput v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastInboxConversationListTransactionId:I

    .line 63
    iput v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    .line 64
    iput v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationTransactionId:I

    .line 65
    iput v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 68
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListNeverShown:Z

    .line 76
    return-void
.end method

.method private goUpFolderHierarchy(Lcom/android/mail/providers/Folder;)V
    .locals 4
    .param p1, "current"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 362
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    .line 363
    .local v0, "top":Lcom/android/mail/providers/Folder;
    if-eqz v0, :cond_0

    .line 364
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/OnePaneController;->setHierarchyFolder(Lcom/android/mail/providers/Folder;)V

    .line 368
    iget-object v1, v0, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Lcom/android/mail/ui/FolderListFragment;->newInstance(Lcom/android/mail/providers/Folder;Landroid/net/Uri;Z)Lcom/android/mail/ui/FolderListFragment;

    move-result-object v1

    const/16 v2, 0x1001

    const-string v3, "tag-folder-list"

    invoke-direct {p0, v1, v2, v3}, Lcom/android/mail/ui/OnePaneController;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    move-result v1

    iput v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 372
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1}, Lcom/android/mail/ui/MailActionBarView;->setBackButton()V

    .line 378
    :goto_0
    return-void

    .line 376
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->showFolderList()V

    goto :goto_0
.end method

.method private static inInbox(Lcom/android/mail/providers/Account;Lcom/android/mail/ConversationListContext;)Z
    .locals 3
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "context"    # Lcom/android/mail/ConversationListContext;

    .prologue
    const/4 v1, 0x0

    .line 135
    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    iget-object v2, p1, Lcom/android/mail/ConversationListContext;->folder:Lcom/android/mail/providers/Folder;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    if-nez v2, :cond_1

    .line 140
    :cond_0
    :goto_0
    return v1

    .line 139
    :cond_1
    iget-object v2, p0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-static {v2}, Lcom/android/mail/providers/Settings;->getDefaultInboxUri(Lcom/android/mail/providers/Settings;)Landroid/net/Uri;

    move-result-object v0

    .line 140
    .local v0, "inboxUri":Landroid/net/Uri;
    invoke-static {p1}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p1, Lcom/android/mail/ConversationListContext;->folder:Lcom/android/mail/providers/Folder;

    iget-object v2, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v2, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method private isTransactionIdValid(I)Z
    .locals 1
    .param p1, "id"    # I

    .prologue
    .line 415
    if-ltz p1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I
    .locals 3
    .param p1, "fragment"    # Landroid/app/Fragment;
    .param p2, "transition"    # I
    .param p3, "tag"    # Ljava/lang/String;

    .prologue
    .line 302
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 303
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 304
    invoke-virtual {v0, p2}, Landroid/app/FragmentTransaction;->setTransition(I)Landroid/app/FragmentTransaction;

    .line 305
    const v2, 0x7f1000be

    invoke-virtual {v0, v2, p1, p3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 306
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    move-result v1

    .line 307
    .local v1, "transactionId":I
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->resetActionBarIcon()V

    .line 308
    return v1
.end method

.method private safelyPopBackStack(IZ)V
    .locals 4
    .param p1, "transactionId"    # I
    .param p2, "inLoaderCallbacks"    # Z

    .prologue
    .line 485
    new-instance v0, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;

    invoke-direct {v0, p0, p1}, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;-><init>(Lcom/android/mail/ui/OnePaneController;I)V

    .line 486
    .local v0, "r":Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;
    if-eqz p2, :cond_0

    .line 488
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mHandler:Landroid/os/Handler;

    invoke-virtual {v1, v0}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 497
    :goto_0
    return-void

    .line 489
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->safeToModifyFragments()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 491
    invoke-virtual {v0}, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->popBackStack()V

    goto :goto_0

    .line 494
    :cond_1
    sget-object v1, Lcom/android/mail/ui/OnePaneController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Activity has been saved; ignoring unsafe immediate request to pop back stack"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method private transitionBackToConversationListMode(Z)V
    .locals 5
    .param p1, "inLoaderCallbacks"    # Z

    .prologue
    const/4 v4, 0x1

    .line 442
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v1

    .line 443
    .local v1, "mode":I
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->enableCabMode()V

    .line 444
    const/4 v2, 0x5

    if-ne v1, v2, :cond_0

    .line 445
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsListMode()Z

    .line 449
    :goto_0
    iget v2, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    invoke-direct {p0, v2}, Lcom/android/mail/ui/OnePaneController;->isTransactionIdValid(I)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 450
    iget v2, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    invoke-direct {p0, v2, p1}, Lcom/android/mail/ui/OnePaneController;->safelyPopBackStack(IZ)V

    .line 462
    :goto_1
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->resetActionBarIcon()V

    .line 464
    iput-boolean v4, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    .line 465
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/OnePaneController;->onConversationVisibilityChanged(Z)V

    .line 466
    invoke-virtual {p0, v4}, Lcom/android/mail/ui/OnePaneController;->onConversationListVisibilityChanged(Z)V

    .line 467
    return-void

    .line 447
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->enterConversationListMode()Z

    goto :goto_0

    .line 451
    :cond_1
    iget v2, p0, Lcom/android/mail/ui/OnePaneController;->mLastInboxConversationListTransactionId:I

    invoke-direct {p0, v2}, Lcom/android/mail/ui/OnePaneController;->isTransactionIdValid(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 452
    iget v2, p0, Lcom/android/mail/ui/OnePaneController;->mLastInboxConversationListTransactionId:I

    invoke-direct {p0, v2, p1}, Lcom/android/mail/ui/OnePaneController;->safelyPopBackStack(IZ)V

    .line 453
    iget-object v2, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/OnePaneController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    goto :goto_1

    .line 456
    :cond_2
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    invoke-static {v2, v3}, Lcom/android/mail/ConversationListContext;->forFolder(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Lcom/android/mail/ConversationListContext;

    move-result-object v0

    .line 459
    .local v0, "listContext":Lcom/android/mail/ConversationListContext;
    iget-object v2, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/OnePaneController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 460
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/OnePaneController;->showConversationList(Lcom/android/mail/ConversationListContext;)V

    goto :goto_1
.end method

.method private transitionToInbox()V
    .locals 3

    .prologue
    .line 384
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->enterConversationListMode()Z

    .line 385
    iget-object v1, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    if-nez v1, :cond_0

    .line 386
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->loadAccountInbox()V

    .line 394
    :goto_0
    return-void

    .line 388
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    invoke-static {v1, v2}, Lcom/android/mail/ConversationListContext;->forFolder(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Lcom/android/mail/ConversationListContext;

    move-result-object v0

    .line 391
    .local v0, "listContext":Lcom/android/mail/ConversationListContext;
    iget-object v1, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/OnePaneController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 392
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/OnePaneController;->showConversationList(Lcom/android/mail/ConversationListContext;)V

    goto :goto_0
.end method


# virtual methods
.method public getHelpContext()Ljava/lang/String;
    .locals 3

    .prologue
    .line 560
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 561
    .local v0, "mode":I
    packed-switch v0, :pswitch_data_0

    .line 565
    invoke-super {p0}, Lcom/android/mail/ui/AbstractActivityController;->getHelpContext()Ljava/lang/String;

    move-result-object v1

    :goto_0
    return-object v1

    .line 563
    :pswitch_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    const v2, 0x7f0c000b

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 561
    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method public hideWaitForInitialization()V
    .locals 0

    .prologue
    .line 270
    invoke-direct {p0}, Lcom/android/mail/ui/OnePaneController;->transitionToInbox()V

    .line 271
    return-void
.end method

.method protected isConversationListVisible()Z
    .locals 1

    .prologue
    .line 159
    iget-boolean v0, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    return v0
.end method

.method public onAccountChanged(Lcom/android/mail/providers/Account;)V
    .locals 1
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 146
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onAccountChanged(Lcom/android/mail/providers/Account;)V

    .line 147
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListNeverShown:Z

    .line 148
    return-void
.end method

.method public onBackPressed()Z
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, -0x1

    const/4 v5, 0x0

    .line 326
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v2

    .line 327
    .local v2, "mode":I
    const/4 v3, 0x3

    if-ne v2, v3, :cond_1

    .line 328
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->getHierarchyFolder()Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 329
    .local v1, "hierarchyFolder":Lcom/android/mail/providers/Folder;
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->getFolderListFragment()Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    .line 330
    .local v0, "folderListFragment":Lcom/android/mail/ui/FolderListFragment;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/ui/FolderListFragment;->showingHierarchy()Z

    move-result v3

    if-eqz v3, :cond_0

    if-eqz v1, :cond_0

    .line 335
    invoke-direct {p0, v1}, Lcom/android/mail/ui/OnePaneController;->goUpFolderHierarchy(Lcom/android/mail/providers/Folder;)V

    .line 357
    .end local v0    # "folderListFragment":Lcom/android/mail/ui/FolderListFragment;
    .end local v1    # "hierarchyFolder":Lcom/android/mail/providers/Folder;
    :goto_0
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v3, v5}, Lcom/android/mail/ui/ActionableToastBar;->hide(Z)V

    .line 358
    return v7

    .line 338
    .restart local v0    # "folderListFragment":Lcom/android/mail/ui/FolderListFragment;
    .restart local v1    # "hierarchyFolder":Lcom/android/mail/providers/Folder;
    :cond_0
    iput v6, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 339
    invoke-direct {p0}, Lcom/android/mail/ui/OnePaneController;->transitionToInbox()V

    goto :goto_0

    .line 341
    .end local v0    # "folderListFragment":Lcom/android/mail/ui/FolderListFragment;
    .end local v1    # "hierarchyFolder":Lcom/android/mail/providers/Folder;
    :cond_1
    const/4 v3, 0x4

    if-ne v2, v3, :cond_2

    .line 342
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_0

    .line 343
    :cond_2
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->isListMode()Z

    move-result v3

    if-eqz v3, :cond_4

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v3, v4}, Lcom/android/mail/ui/OnePaneController;->inInbox(Lcom/android/mail/providers/Account;Lcom/android/mail/ConversationListContext;)Z

    move-result v3

    if-nez v3, :cond_4

    .line 344
    iget v3, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    if-eq v3, v6, :cond_3

    .line 347
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->enterFolderListMode()Z

    .line 348
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    iget v4, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    invoke-virtual {v3, v4, v5}, Landroid/app/FragmentManager;->popBackStack(II)V

    goto :goto_0

    .line 350
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/ui/OnePaneController;->transitionToInbox()V

    goto :goto_0

    .line 352
    :cond_4
    if-eq v2, v7, :cond_5

    const/4 v3, 0x5

    if-ne v2, v3, :cond_6

    .line 353
    :cond_5
    invoke-direct {p0, v5}, Lcom/android/mail/ui/OnePaneController;->transitionBackToConversationListMode(Z)V

    goto :goto_0

    .line 355
    :cond_6
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)Z
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 152
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v1, 0x7f04005c

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ControllableActivity;->setContentView(I)V

    .line 154
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onCreate(Landroid/os/Bundle;)Z

    move-result v0

    return v0
.end method

.method public onError(Lcom/android/mail/providers/Folder;Z)V
    .locals 2
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "replaceVisibleToast"    # Z

    .prologue
    .line 547
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 548
    .local v0, "mode":I
    packed-switch v0, :pswitch_data_0

    .line 556
    :goto_0
    :pswitch_0
    return-void

    .line 551
    :pswitch_1
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/OnePaneController;->showErrorToast(Lcom/android/mail/providers/Folder;Z)V

    goto :goto_0

    .line 548
    :pswitch_data_0
    .packed-switch 0x2
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onFolderSelected(Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 398
    iget-boolean v0, p1, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->getHierarchyFolder()Lcom/android/mail/providers/Folder;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 399
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterFolderListMode()Z

    .line 400
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/OnePaneController;->setHierarchyFolder(Lcom/android/mail/providers/Folder;)V

    .line 404
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Lcom/android/mail/ui/FolderListFragment;->newInstance(Lcom/android/mail/providers/Folder;Landroid/net/Uri;Z)Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    const/16 v1, 0x1001

    const-string v2, "tag-folder-list"

    invoke-direct {p0, v0, v1, v2}, Lcom/android/mail/ui/OnePaneController;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 408
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0}, Lcom/android/mail/ui/MailActionBarView;->setBackButton()V

    .line 412
    :goto_0
    return-void

    .line 410
    :cond_0
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onFolderSelected(Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method public onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "inState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, -0x1

    .line 80
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 82
    if-nez p1, :cond_0

    .line 94
    :goto_0
    return-void

    .line 85
    :cond_0
    const-string v0, "folder-list-transaction"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 86
    const-string v0, "inbox_conversation-list-transaction"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/OnePaneController;->mLastInboxConversationListTransactionId:I

    .line 88
    const-string v0, "conversation-list-transaction"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    .line 90
    const-string v0, "conversation-transaction"

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationTransactionId:I

    .line 91
    const-string v0, "conversation-list-visible"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    .line 92
    const-string v0, "conversation-list-never-shown"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListNeverShown:Z

    .line 93
    const-string v0, "m-inbox"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    iput-object v0, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    goto :goto_0
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 98
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 100
    const-string v0, "folder-list-transaction"

    iget v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 101
    const-string v0, "inbox_conversation-list-transaction"

    iget v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastInboxConversationListTransactionId:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 103
    const-string v0, "conversation-list-transaction"

    iget v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 104
    const-string v0, "conversation-transaction"

    iget v1, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationTransactionId:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 105
    const-string v0, "conversation-list-visible"

    iget-boolean v1, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 106
    const-string v0, "conversation-list-never-shown"

    iget-boolean v1, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListNeverShown:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 107
    const-string v0, "m-inbox"

    iget-object v1, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 108
    return-void
.end method

.method public onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 10
    .param p1, "op"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    const v5, 0x7f0c009f

    const/4 v2, 0x0

    const/4 v4, 0x1

    .line 506
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v1, 0x4000

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 507
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v9

    .line 508
    .local v9, "mode":I
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v8

    .line 509
    .local v8, "convList":Lcom/android/mail/ui/ConversationListFragment;
    packed-switch v9, :pswitch_data_0

    .line 543
    .end local v8    # "convList":Lcom/android/mail/ui/ConversationListFragment;
    .end local v9    # "mode":I
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 512
    .restart local v8    # "convList":Lcom/android/mail/ui/ConversationListFragment;
    .restart local v9    # "mode":I
    :pswitch_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v4}, Lcom/android/mail/ui/ActionableToastBar;->setConversationMode(Z)V

    .line 513
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    if-eqz v8, :cond_1

    invoke-virtual {v8}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v1

    :goto_1
    invoke-virtual {p0, v1}, Lcom/android/mail/ui/OnePaneController;->getUndoClickedListener(Lcom/android/mail/ui/AnimatedAdapter;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    move-result-object v1

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v3

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v3, v6}, Lcom/android/mail/ui/ToastBarOperation;->getDescription(Landroid/content/Context;Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    move v6, v4

    move-object v7, p1

    invoke-virtual/range {v0 .. v7}, Lcom/android/mail/ui/ActionableToastBar;->show(Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;ILjava/lang/CharSequence;ZIZLcom/android/mail/ui/ToastBarOperation;)V

    goto :goto_0

    :cond_1
    const/4 v1, 0x0

    goto :goto_1

    .line 526
    :pswitch_2
    if-eqz v8, :cond_2

    .line 527
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v2}, Lcom/android/mail/ui/ActionableToastBar;->setConversationMode(Z)V

    .line 528
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v8}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/OnePaneController;->getUndoClickedListener(Lcom/android/mail/ui/AnimatedAdapter;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    move-result-object v1

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v3

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v3, v6}, Lcom/android/mail/ui/ToastBarOperation;->getDescription(Landroid/content/Context;Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    move v6, v4

    move-object v7, p1

    invoke-virtual/range {v0 .. v7}, Lcom/android/mail/ui/ActionableToastBar;->show(Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;ILjava/lang/CharSequence;ZIZLcom/android/mail/ui/ToastBarOperation;)V

    goto :goto_0

    .line 538
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ControllableActivity;->setPendingToastOperation(Lcom/android/mail/ui/ToastBarOperation;)V

    goto :goto_0

    .line 509
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method public onUpPressed()Z
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 428
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 429
    .local v0, "mode":I
    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    .line 430
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    .line 438
    :cond_0
    :goto_0
    return v3

    .line 431
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v1, v2}, Lcom/android/mail/ui/OnePaneController;->inInbox(Lcom/android/mail/providers/Account;Lcom/android/mail/ConversationListContext;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->isListMode()Z

    move-result v1

    if-nez v1, :cond_3

    :cond_2
    if-eq v0, v3, :cond_3

    const/4 v1, 0x3

    if-eq v0, v1, :cond_3

    const/4 v1, 0x5

    if-ne v0, v1, :cond_0

    .line 436
    :cond_3
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public onViewModeChanged(I)V
    .locals 2
    .param p1, "newMode"    # I

    .prologue
    .line 164
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onViewModeChanged(I)V

    .line 169
    invoke-static {p1}, Lcom/android/mail/ui/ViewMode;->isListMode(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 170
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationPagerController;->hide(Z)V

    .line 174
    :cond_0
    invoke-static {p1}, Lcom/android/mail/ui/ViewMode;->isConversationMode(I)Z

    move-result v0

    if-nez v0, :cond_1

    .line 175
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/OnePaneController;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    .line 177
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->resetActionBarIcon()V

    .line 178
    return-void
.end method

.method public resetActionBarIcon()V
    .locals 3

    .prologue
    .line 112
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 114
    .local v0, "mode":I
    if-nez v0, :cond_0

    .line 126
    :goto_0
    return-void

    .line 117
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v1, v2}, Lcom/android/mail/ui/OnePaneController;->inInbox(Lcom/android/mail/providers/Account;Lcom/android/mail/ConversationListContext;)Z

    move-result v1

    if-eqz v1, :cond_1

    const/4 v1, 0x4

    if-eq v0, v1, :cond_1

    const/4 v1, 0x5

    if-eq v0, v1, :cond_1

    const/4 v1, 0x1

    if-eq v0, v1, :cond_1

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 122
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1}, Lcom/android/mail/ui/MailActionBarView;->setBackButton()V

    goto :goto_0

    .line 124
    :cond_2
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1}, Lcom/android/mail/ui/MailActionBarView;->removeBackButton()V

    goto :goto_0
.end method

.method public shouldShowFirstConversation()Z
    .locals 1

    .prologue
    .line 501
    const/4 v0, 0x0

    return v0
.end method

.method protected showConversation(Lcom/android/mail/providers/Conversation;Z)V
    .locals 8
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p2, "inLoaderCallbacks"    # Z

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 222
    invoke-super {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;Z)V

    .line 223
    if-nez p1, :cond_0

    .line 224
    invoke-direct {p0, p2}, Lcom/android/mail/ui/OnePaneController;->transitionBackToConversationListMode(Z)V

    .line 258
    :goto_0
    return-void

    .line 227
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->disableCabMode()V

    .line 228
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v3}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 229
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsConversationMode()Z

    .line 233
    :goto_1
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 234
    .local v1, "fm":Landroid/app/FragmentManager;
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 235
    .local v2, "ft":Landroid/app/FragmentTransaction;
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 241
    const v3, 0x7f1000be

    invoke-virtual {v1, v3}, Landroid/app/FragmentManager;->findFragmentById(I)Landroid/app/Fragment;

    move-result-object v0

    .line 246
    .local v0, "f":Landroid/app/Fragment;
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Landroid/app/Fragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 248
    const/16 v3, 0x1001

    invoke-virtual {v2, v3}, Landroid/app/FragmentTransaction;->setTransition(I)Landroid/app/FragmentTransaction;

    .line 249
    invoke-virtual {v2, v0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 250
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 252
    :cond_1
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v3, v4, v5, p1, v7}, Lcom/android/mail/browse/ConversationPagerController;->show(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Conversation;Z)V

    .line 253
    invoke-virtual {p0, v7}, Lcom/android/mail/ui/OnePaneController;->onConversationVisibilityChanged(Z)V

    .line 254
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->resetActionBarIcon()V

    .line 256
    iput-boolean v6, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    .line 257
    invoke-virtual {p0, v6}, Lcom/android/mail/ui/OnePaneController;->onConversationListVisibilityChanged(Z)V

    goto :goto_0

    .line 231
    .end local v0    # "f":Landroid/app/Fragment;
    .end local v1    # "fm":Landroid/app/FragmentManager;
    .end local v2    # "ft":Landroid/app/FragmentTransaction;
    :cond_2
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->enterConversationMode()Z

    goto :goto_1
.end method

.method public showConversationList(Lcom/android/mail/ConversationListContext;)V
    .locals 7
    .param p1, "listContext"    # Lcom/android/mail/ConversationListContext;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    const/4 v4, -0x1

    .line 182
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->showConversationList(Lcom/android/mail/ConversationListContext;)V

    .line 183
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->enableCabMode()V

    .line 186
    invoke-static {p1}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 187
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsListMode()Z

    .line 193
    :goto_0
    iget-boolean v2, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListNeverShown:Z

    if-eqz v2, :cond_1

    const/16 v1, 0x1003

    .line 196
    .local v1, "transition":I
    :goto_1
    invoke-static {p1}, Lcom/android/mail/ui/ConversationListFragment;->newInstance(Lcom/android/mail/ConversationListContext;)Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 198
    .local v0, "conversationListFragment":Landroid/app/Fragment;
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v2, v3}, Lcom/android/mail/ui/OnePaneController;->inInbox(Lcom/android/mail/providers/Account;Lcom/android/mail/ConversationListContext;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 201
    const-string v2, "tag-conversation-list"

    invoke-direct {p0, v0, v1, v2}, Lcom/android/mail/ui/OnePaneController;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    .line 214
    :goto_2
    iput-boolean v6, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    .line 215
    invoke-virtual {p0, v5}, Lcom/android/mail/ui/OnePaneController;->onConversationVisibilityChanged(Z)V

    .line 216
    invoke-virtual {p0, v6}, Lcom/android/mail/ui/OnePaneController;->onConversationListVisibilityChanged(Z)V

    .line 217
    iput-boolean v5, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListNeverShown:Z

    .line 218
    return-void

    .line 189
    .end local v0    # "conversationListFragment":Landroid/app/Fragment;
    .end local v1    # "transition":I
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->enterConversationListMode()Z

    goto :goto_0

    .line 193
    :cond_1
    const/16 v1, 0x1001

    goto :goto_1

    .line 205
    .restart local v0    # "conversationListFragment":Landroid/app/Fragment;
    .restart local v1    # "transition":I
    :cond_2
    iget-object v2, p1, Lcom/android/mail/ConversationListContext;->folder:Lcom/android/mail/providers/Folder;

    iput-object v2, p0, Lcom/android/mail/ui/OnePaneController;->mInbox:Lcom/android/mail/providers/Folder;

    .line 206
    const-string v2, "tag-conversation-list"

    invoke-direct {p0, v0, v1, v2}, Lcom/android/mail/ui/OnePaneController;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/android/mail/ui/OnePaneController;->mLastInboxConversationListTransactionId:I

    .line 208
    iput v4, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 212
    iput v4, p0, Lcom/android/mail/ui/OnePaneController;->mLastConversationListTransactionId:I

    goto :goto_2
.end method

.method public showFolderList()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 275
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v0, :cond_0

    .line 276
    sget-object v0, Lcom/android/mail/ui/OnePaneController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Null account in showFolderList"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 290
    :goto_0
    return-void

    .line 281
    :cond_0
    invoke-virtual {p0, v1}, Lcom/android/mail/ui/OnePaneController;->setHierarchyFolder(Lcom/android/mail/providers/Folder;)V

    .line 282
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterFolderListMode()Z

    .line 283
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController;->enableCabMode()V

    .line 284
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-static {v1, v0, v3}, Lcom/android/mail/ui/FolderListFragment;->newInstance(Lcom/android/mail/providers/Folder;Landroid/net/Uri;Z)Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    const/16 v1, 0x1001

    const-string v2, "tag-folder-list"

    invoke-direct {p0, v0, v1, v2}, Lcom/android/mail/ui/OnePaneController;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/OnePaneController;->mLastFolderListTransactionId:I

    .line 287
    iput-boolean v3, p0, Lcom/android/mail/ui/OnePaneController;->mConversationListVisible:Z

    .line 288
    invoke-virtual {p0, v3}, Lcom/android/mail/ui/OnePaneController;->onConversationVisibilityChanged(Z)V

    .line 289
    invoke-virtual {p0, v3}, Lcom/android/mail/ui/OnePaneController;->onConversationListVisibilityChanged(Z)V

    goto :goto_0
.end method

.method public showWaitForInitialization()V
    .locals 3

    .prologue
    .line 262
    invoke-super {p0}, Lcom/android/mail/ui/AbstractActivityController;->showWaitForInitialization()V

    .line 264
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v0}, Lcom/android/mail/ui/WaitFragment;->newInstance(Lcom/android/mail/providers/Account;)Lcom/android/mail/ui/WaitFragment;

    move-result-object v0

    const/16 v1, 0x1001

    const-string v2, "wait-fragment"

    invoke-direct {p0, v0, v1, v2}, Lcom/android/mail/ui/OnePaneController;->replaceFragment(Landroid/app/Fragment;ILjava/lang/String;)I

    .line 266
    return-void
.end method
