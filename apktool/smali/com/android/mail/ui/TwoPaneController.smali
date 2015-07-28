.class public final Lcom/android/mail/ui/TwoPaneController;
.super Lcom/android/mail/ui/AbstractActivityController;
.source "TwoPaneController.java"


# instance fields
.field private mConversationToShow:Lcom/android/mail/providers/Conversation;

.field private mLayout:Lcom/android/mail/ui/TwoPaneLayout;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/MailActivity;Lcom/android/mail/ui/ViewMode;)V
    .locals 0
    .param p1, "activity"    # Lcom/android/mail/ui/MailActivity;
    .param p2, "viewMode"    # Lcom/android/mail/ui/ViewMode;

    .prologue
    .line 54
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;-><init>(Lcom/android/mail/ui/MailActivity;Lcom/android/mail/ui/ViewMode;)V

    .line 55
    return-void
.end method

.method private createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V
    .locals 4
    .param p1, "parent"    # Lcom/android/mail/providers/Folder;
    .param p2, "uri"    # Landroid/net/Uri;

    .prologue
    .line 103
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/TwoPaneController;->setHierarchyFolder(Lcom/android/mail/providers/Folder;)V

    .line 105
    const/4 v2, 0x1

    invoke-static {p1, p2, v2}, Lcom/android/mail/ui/FolderListFragment;->newInstance(Lcom/android/mail/providers/Folder;Landroid/net/Uri;Z)Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    .line 106
    .local v0, "folderListFragment":Lcom/android/mail/ui/FolderListFragment;
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 107
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/utils/Utils;->useFolderListFragmentTransition(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 108
    const/16 v2, 0x1001

    invoke-virtual {v1, v2}, Landroid/app/FragmentTransaction;->setTransition(I)Landroid/app/FragmentTransaction;

    .line 110
    :cond_0
    const v2, 0x7f1000be

    const-string v3, "tag-folder-list"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 111
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 114
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->resetActionBarIcon()V

    .line 115
    return-void
.end method

.method private final enableOrDisableCab()V
    .locals 1

    .prologue
    .line 258
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v0}, Lcom/android/mail/ui/TwoPaneLayout;->isConversationListCollapsed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 259
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->disableCabMode()V

    .line 263
    :goto_0
    return-void

    .line 261
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->enableCabMode()V

    goto :goto_0
.end method

.method private getUndoBarWidth(ILcom/android/mail/ui/ToastBarOperation;)I
    .locals 3
    .param p1, "mode"    # I
    .param p2, "op"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    const/4 v1, -0x1

    .line 435
    const/4 v0, -0x1

    .line 436
    .local v0, "resId":I
    packed-switch p1, :pswitch_data_0

    .line 451
    :goto_0
    :pswitch_0
    if-eq v0, v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v1

    float-to-int v1, v1

    :cond_0
    return v1

    .line 438
    :pswitch_1
    const v0, 0x7f0b000e

    .line 439
    goto :goto_0

    .line 441
    :pswitch_2
    const v0, 0x7f0b000b

    .line 442
    goto :goto_0

    .line 445
    :pswitch_3
    invoke-virtual {p2}, Lcom/android/mail/ui/ToastBarOperation;->isBatchUndo()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 446
    const v0, 0x7f0b000d

    goto :goto_0

    .line 448
    :cond_1
    const v0, 0x7f0b000c

    goto :goto_0

    .line 436
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_2
        :pswitch_0
        :pswitch_1
        :pswitch_3
    .end packed-switch
.end method

.method private goUpFolderHierarchy(Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p1, "current"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 195
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    .line 196
    .local v0, "parent":Lcom/android/mail/providers/Folder;
    iget-object v1, v0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    if-eqz v1, :cond_0

    .line 197
    iget-object v1, v0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    iget-object v2, v0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    iget-object v2, v2, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    invoke-direct {p0, v1, v2}, Lcom/android/mail/ui/TwoPaneController;->createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V

    .line 199
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1}, Lcom/android/mail/ui/MailActionBarView;->setBackButton()V

    .line 203
    :goto_0
    return-void

    .line 201
    :cond_0
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneController;->onFolderSelected(Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method private initializeConversationListFragment(Z)V
    .locals 2
    .param p1, "show"    # Z

    .prologue
    .line 62
    if-eqz p1, :cond_0

    .line 63
    const-string v0, "android.intent.action.SEARCH"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 64
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->showTwoPaneSearchResults(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsConversationMode()Z

    .line 73
    :cond_0
    :goto_0
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneController;->renderConversationList()V

    .line 74
    return-void

    .line 67
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsListMode()Z

    goto :goto_0

    .line 70
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterConversationListMode()Z

    goto :goto_0
.end method

.method private renderConversationList()V
    .locals 4

    .prologue
    .line 80
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-nez v2, :cond_0

    .line 90
    :goto_0
    return-void

    .line 83
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 85
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    const/16 v2, 0x1003

    invoke-virtual {v1, v2}, Landroid/app/FragmentTransaction;->setTransition(I)Landroid/app/FragmentTransaction;

    .line 86
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v2}, Lcom/android/mail/ui/ConversationListFragment;->newInstance(Lcom/android/mail/ConversationListContext;)Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 87
    .local v0, "conversationListFragment":Landroid/app/Fragment;
    const v2, 0x7f1000fc

    const-string v3, "tag-conversation-list"

    invoke-virtual {v1, v2, v0, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 89
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    goto :goto_0
.end method

.method private renderFolderList()V
    .locals 2

    .prologue
    .line 96
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-nez v0, :cond_0

    .line 100
    :goto_0
    return-void

    .line 99
    :cond_0
    const/4 v0, 0x0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/TwoPaneController;->createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V

    goto :goto_0
.end method


# virtual methods
.method public exitSearchMode()V
    .locals 2

    .prologue
    .line 420
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 421
    .local v0, "mode":I
    const/4 v1, 0x4

    if-eq v0, v1, :cond_0

    const/4 v1, 0x5

    if-ne v0, v1, :cond_1

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->showTwoPaneSearchResults(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 424
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    .line 426
    :cond_1
    return-void
.end method

.method public hideWaitForInitialization()V
    .locals 4

    .prologue
    .line 327
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 328
    .local v1, "manager":Landroid/app/FragmentManager;
    const-string v3, "wait-fragment"

    invoke-virtual {v1, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/android/mail/ui/WaitFragment;

    .line 329
    .local v2, "waitFragment":Lcom/android/mail/ui/WaitFragment;
    if-eqz v2, :cond_0

    .line 330
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 332
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    invoke-virtual {v0, v2}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 333
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 335
    .end local v0    # "fragmentTransaction":Landroid/app/FragmentTransaction;
    :cond_0
    return-void
.end method

.method protected isConversationListVisible()Z
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v0}, Lcom/android/mail/ui/TwoPaneLayout;->isConversationListCollapsed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAccountChanged(Lcom/android/mail/providers/Account;)V
    .locals 0
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 163
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onAccountChanged(Lcom/android/mail/providers/Account;)V

    .line 164
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneController;->renderFolderList()V

    .line 165
    return-void
.end method

.method public onBackPressed()Z
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 371
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ActionableToastBar;->hide(Z)V

    .line 372
    invoke-virtual {p0, v1}, Lcom/android/mail/ui/TwoPaneController;->popView(Z)V

    .line 373
    const/4 v0, 0x1

    return v0
.end method

.method public onConversationListVisibilityChanged(Z)V
    .locals 0
    .param p1, "visible"    # Z

    .prologue
    .line 237
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onConversationListVisibilityChanged(Z)V

    .line 238
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneController;->enableOrDisableCab()V

    .line 239
    return-void
.end method

.method public onConversationVisibilityChanged(Z)V
    .locals 5
    .param p1, "visible"    # Z

    .prologue
    const/4 v4, 0x0

    .line 225
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onConversationVisibilityChanged(Z)V

    .line 226
    if-nez p1, :cond_1

    .line 227
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0, v4}, Lcom/android/mail/browse/ConversationPagerController;->hide(Z)V

    .line 233
    :cond_0
    :goto_0
    return-void

    .line 228
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneController;->mConversationToShow:Lcom/android/mail/providers/Conversation;

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v3, p0, Lcom/android/mail/ui/TwoPaneController;->mConversationToShow:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/android/mail/browse/ConversationPagerController;->show(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Conversation;Z)V

    .line 231
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/TwoPaneController;->mConversationToShow:Lcom/android/mail/providers/Conversation;

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)Z
    .locals 4
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    .line 137
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v2, 0x7f04006f

    invoke-interface {v1, v2}, Lcom/android/mail/ui/ControllableActivity;->setContentView(I)V

    .line 138
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v2, 0x7f1000fb

    invoke-interface {v1, v2}, Lcom/android/mail/ui/ControllableActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/TwoPaneLayout;

    iput-object v1, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    .line 139
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    if-nez v1, :cond_0

    .line 141
    sget-object v1, Lcom/android/mail/ui/TwoPaneController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "mLayout is null!"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 143
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    const-string v2, "android.intent.action.SEARCH"

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    invoke-virtual {v1, p0, v2}, Lcom/android/mail/ui/TwoPaneLayout;->setController(Lcom/android/mail/ui/AbstractActivityController;Z)V

    .line 148
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/ViewMode;->addListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V

    .line 149
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onCreate(Landroid/os/Bundle;)Z

    move-result v0

    .line 150
    .local v0, "isParentInitialized":Z
    return v0
.end method

.method public onError(Lcom/android/mail/providers/Folder;Z)V
    .locals 4
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "replaceVisibleToast"    # Z

    .prologue
    .line 508
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 509
    .local v0, "mode":I
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v2}, Lcom/android/mail/ui/ActionableToastBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout$LayoutParams;

    .line 511
    .local v1, "params":Landroid/widget/FrameLayout$LayoutParams;
    packed-switch v0, :pswitch_data_0

    .line 529
    :goto_0
    :pswitch_0
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/TwoPaneController;->showErrorToast(Lcom/android/mail/providers/Folder;Z)V

    .line 530
    return-void

    .line 514
    :pswitch_1
    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v2}, Lcom/android/mail/ui/TwoPaneLayout;->computeConversationListWidth()I

    move-result v2

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    sub-int/2addr v2, v3

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    sub-int/2addr v2, v3

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 516
    const/16 v2, 0x55

    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 517
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v2, v1}, Lcom/android/mail/ui/ActionableToastBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 522
    :pswitch_2
    const/16 v2, 0x53

    iput v2, v1, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 523
    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v2}, Lcom/android/mail/ui/TwoPaneLayout;->computeConversationListWidth()I

    move-result v2

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    sub-int/2addr v2, v3

    iget v3, v1, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    sub-int/2addr v2, v3

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 525
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v2, v1}, Lcom/android/mail/ui/ActionableToastBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 511
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onFolderChanged(Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 169
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 170
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->exitCabMode()V

    .line 171
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->getFolderListFragment()Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    .line 172
    .local v0, "folderList":Lcom/android/mail/ui/FolderListFragment;
    if-nez v0, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v1

    const/4 v2, 0x2

    if-ne v1, v2, :cond_0

    .line 174
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneController;->renderFolderList()V

    .line 176
    :cond_0
    return-void
.end method

.method public onFolderSelected(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 180
    iget-boolean v0, p1, Lcom/android/mail/providers/Folder;->hasChildren:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->getHierarchyFolder()Lcom/android/mail/providers/Folder;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 184
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->childFoldersListUri:Landroid/net/Uri;

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/TwoPaneController;->createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V

    .line 186
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0}, Lcom/android/mail/ui/MailActionBarView;->setBackButton()V

    .line 187
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onFolderSelected(Lcom/android/mail/providers/Folder;)V

    .line 192
    :goto_0
    return-void

    .line 189
    :cond_0
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/TwoPaneController;->setHierarchyFolder(Lcom/android/mail/providers/Folder;)V

    .line 190
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onFolderSelected(Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method public onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V
    .locals 12
    .param p1, "op"    # Lcom/android/mail/ui/ToastBarOperation;

    .prologue
    const v5, 0x7f0c009f

    const/16 v3, 0x55

    const/4 v2, 0x0

    const/4 v4, 0x1

    .line 456
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v9

    .line 457
    .local v9, "mode":I
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0}, Lcom/android/mail/ui/ActionableToastBar;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    check-cast v10, Landroid/widget/FrameLayout$LayoutParams;

    .line 459
    .local v10, "params":Landroid/widget/FrameLayout$LayoutParams;
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v8

    .line 460
    .local v8, "convList":Lcom/android/mail/ui/ConversationListFragment;
    invoke-direct {p0, v9, p1}, Lcom/android/mail/ui/TwoPaneController;->getUndoBarWidth(ILcom/android/mail/ui/ToastBarOperation;)I

    move-result v11

    .line 461
    .local v11, "undoBarWidth":I
    packed-switch v9, :pswitch_data_0

    .line 504
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 464
    :pswitch_1
    iget v0, v10, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    sub-int v0, v11, v0

    iget v1, v10, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    sub-int/2addr v0, v1

    iput v0, v10, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 465
    iput v3, v10, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 466
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v10}, Lcom/android/mail/ui/ActionableToastBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 467
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v2}, Lcom/android/mail/ui/ActionableToastBar;->setConversationMode(Z)V

    .line 468
    if-eqz v8, :cond_0

    .line 469
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v8}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/TwoPaneController;->getUndoClickedListener(Lcom/android/mail/ui/AnimatedAdapter;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

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

    .line 482
    :pswitch_2
    invoke-virtual {p1}, Lcom/android/mail/ui/ToastBarOperation;->isBatchUndo()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 484
    const/16 v0, 0x53

    iput v0, v10, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 485
    iget v0, v10, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    sub-int v0, v11, v0

    iget v1, v10, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    sub-int/2addr v0, v1

    iput v0, v10, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 486
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v10}, Lcom/android/mail/ui/ActionableToastBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 487
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v2}, Lcom/android/mail/ui/ActionableToastBar;->setConversationMode(Z)V

    .line 495
    :goto_1
    if-eqz v8, :cond_0

    .line 496
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v8}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/TwoPaneController;->getUndoClickedListener(Lcom/android/mail/ui/AnimatedAdapter;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

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

    .line 490
    :cond_1
    iput v3, v10, Landroid/widget/FrameLayout$LayoutParams;->gravity:I

    .line 491
    iget v0, v10, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    sub-int v0, v11, v0

    iget v1, v10, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    sub-int/2addr v0, v1

    iput v0, v10, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 492
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v10}, Lcom/android/mail/ui/ActionableToastBar;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 493
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v4}, Lcom/android/mail/ui/ActionableToastBar;->setConversationMode(Z)V

    goto :goto_1

    .line 461
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public onUpPressed()Z
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 349
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v1}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    .line 350
    .local v0, "mode":I
    if-ne v0, v2, :cond_1

    .line 351
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->onBackPressed()V

    .line 365
    :cond_0
    :goto_0
    return v2

    .line 352
    :cond_1
    const/4 v1, 0x5

    if-ne v0, v1, :cond_4

    .line 353
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v1}, Lcom/android/mail/ui/TwoPaneLayout;->isConversationListCollapsed()Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v1}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->showTwoPaneSearchResults(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 356
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->onBackPressed()Z

    goto :goto_0

    .line 358
    :cond_3
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_0

    .line 360
    :cond_4
    const/4 v1, 0x4

    if-ne v0, v1, :cond_5

    .line 361
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_0

    .line 362
    :cond_5
    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 363
    invoke-virtual {p0, v2}, Lcom/android/mail/ui/TwoPaneController;->popView(Z)V

    goto :goto_0
.end method

.method public onViewModeChanged(I)V
    .locals 1
    .param p1, "newMode"    # I

    .prologue
    .line 207
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onViewModeChanged(I)V

    .line 208
    const/4 v0, 0x6

    if-eq p1, v0, :cond_0

    .line 210
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->hideWaitForInitialization()V

    .line 217
    :cond_0
    const/4 v0, 0x1

    if-eq p1, v0, :cond_1

    const/4 v0, 0x2

    if-ne p1, v0, :cond_2

    .line 218
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneController;->enableOrDisableCab()V

    .line 220
    :cond_2
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->resetActionBarIcon()V

    .line 221
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasFocus"    # Z

    .prologue
    .line 155
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneController;->mLayout:Lcom/android/mail/ui/TwoPaneLayout;

    invoke-virtual {v0}, Lcom/android/mail/ui/TwoPaneLayout;->isConversationListCollapsed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneController;->informCursorVisiblity(Z)V

    .line 159
    :cond_0
    return-void
.end method

.method protected popView(Z)V
    .locals 5
    .param p1, "preventClose"    # Z

    .prologue
    .line 385
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v2

    .line 386
    .local v2, "mode":I
    const/4 v3, 0x4

    if-ne v2, v3, :cond_1

    .line 387
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    .line 416
    :cond_0
    :goto_0
    return-void

    .line 388
    :cond_1
    const/4 v3, 0x1

    if-ne v2, v3, :cond_2

    .line 390
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->enterConversationListMode()Z

    goto :goto_0

    .line 391
    :cond_2
    const/4 v3, 0x5

    if-ne v2, v3, :cond_3

    .line 392
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsListMode()Z

    goto :goto_0

    .line 396
    :cond_3
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->getFolderListFragment()Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    .line 397
    .local v0, "folderList":Lcom/android/mail/ui/FolderListFragment;
    const/4 v3, 0x2

    if-ne v2, v3, :cond_5

    if-eqz v0, :cond_5

    invoke-virtual {v0}, Lcom/android/mail/ui/FolderListFragment;->showingHierarchy()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 401
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->getHierarchyFolder()Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 402
    .local v1, "hierarchyFolder":Lcom/android/mail/providers/Folder;
    iget-object v3, v1, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    if-eqz v3, :cond_4

    .line 403
    invoke-direct {p0, v1}, Lcom/android/mail/ui/TwoPaneController;->goUpFolderHierarchy(Lcom/android/mail/providers/Folder;)V

    goto :goto_0

    .line 408
    :cond_4
    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, v4, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    invoke-direct {p0, v3, v4}, Lcom/android/mail/ui/TwoPaneController;->createFolderListFragment(Lcom/android/mail/providers/Folder;Landroid/net/Uri;)V

    .line 409
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->loadAccountInbox()V

    goto :goto_0

    .line 411
    .end local v1    # "hierarchyFolder":Lcom/android/mail/providers/Folder;
    :cond_5
    if-nez p1, :cond_0

    .line 413
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_0
.end method

.method public resetActionBarIcon()V
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    if-nez v0, :cond_0

    .line 252
    :goto_0
    return-void

    .line 247
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->isListMode()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 248
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0}, Lcom/android/mail/ui/MailActionBarView;->removeBackButton()V

    goto :goto_0

    .line 250
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0}, Lcom/android/mail/ui/MailActionBarView;->setBackButton()V

    goto :goto_0
.end method

.method public setCurrentConversation(Lcom/android/mail/providers/Conversation;)V
    .locals 7
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    const-wide/16 v2, -0x1

    .line 304
    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    if-eqz v6, :cond_2

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v4, v6, Lcom/android/mail/providers/Conversation;->id:J

    .line 305
    .local v4, "oldId":J
    :goto_0
    if-eqz p1, :cond_0

    iget-wide v2, p1, Lcom/android/mail/providers/Conversation;->id:J

    .line 306
    .local v2, "newId":J
    :cond_0
    cmp-long v6, v4, v2

    if-eqz v6, :cond_3

    const/4 v1, 0x1

    .line 307
    .local v1, "different":Z
    :goto_1
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    .line 308
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 309
    .local v0, "convList":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz v0, :cond_1

    if-eqz p1, :cond_1

    .line 310
    iget v6, p1, Lcom/android/mail/providers/Conversation;->position:I

    invoke-virtual {v0, v6, v1}, Lcom/android/mail/ui/ConversationListFragment;->setSelected(IZ)V

    .line 312
    :cond_1
    return-void

    .end local v0    # "convList":Lcom/android/mail/ui/ConversationListFragment;
    .end local v1    # "different":Z
    .end local v2    # "newId":J
    .end local v4    # "oldId":J
    :cond_2
    move-wide v4, v2

    .line 304
    goto :goto_0

    .line 306
    .restart local v2    # "newId":J
    .restart local v4    # "oldId":J
    :cond_3
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public shouldShowFirstConversation()Z
    .locals 2

    .prologue
    .line 430
    const-string v0, "android.intent.action.SEARCH"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->showTwoPaneSearchResults(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected showConversation(Lcom/android/mail/providers/Conversation;Z)V
    .locals 3
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p2, "inLoaderCallbacks"    # Z

    .prologue
    .line 267
    invoke-super {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;Z)V

    .line 272
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-nez v2, :cond_1

    .line 300
    :cond_0
    :goto_0
    return-void

    .line 275
    :cond_1
    if-nez p1, :cond_2

    .line 276
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->onBackPressed()Z

    goto :goto_0

    .line 283
    :cond_2
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneController;->enableOrDisableCab()V

    .line 287
    iput-object p1, p0, Lcom/android/mail/ui/TwoPaneController;->mConversationToShow:Lcom/android/mail/providers/Conversation;

    .line 289
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v1

    .line 290
    .local v1, "mode":I
    const/4 v0, 0x0

    .line 291
    .local v0, "changedMode":Z
    const/4 v2, 0x4

    if-eq v1, v2, :cond_3

    const/4 v2, 0x5

    if-ne v1, v2, :cond_4

    .line 292
    :cond_3
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsConversationMode()Z

    move-result v0

    .line 297
    :goto_1
    if-nez v0, :cond_0

    .line 298
    const/4 v2, 0x1

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/TwoPaneController;->onConversationVisibilityChanged(Z)V

    goto :goto_0

    .line 294
    :cond_4
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->enterConversationMode()Z

    move-result v0

    goto :goto_1
.end method

.method public showConversationList(Lcom/android/mail/ConversationListContext;)V
    .locals 1
    .param p1, "listContext"    # Lcom/android/mail/ConversationListContext;

    .prologue
    .line 124
    invoke-super {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->showConversationList(Lcom/android/mail/ConversationListContext;)V

    .line 125
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneController;->initializeConversationListFragment(Z)V

    .line 126
    return-void
.end method

.method public showFolderList()V
    .locals 0

    .prologue
    .line 132
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneController;->onUpPressed()Z

    .line 133
    return-void
.end method

.method public showWaitForInitialization()V
    .locals 4

    .prologue
    .line 316
    invoke-super {p0}, Lcom/android/mail/ui/AbstractActivityController;->showWaitForInitialization()V

    .line 318
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v2}, Lcom/android/mail/ui/WaitFragment;->newInstance(Lcom/android/mail/providers/Account;)Lcom/android/mail/ui/WaitFragment;

    move-result-object v1

    .line 319
    .local v1, "waitFragment":Landroid/app/Fragment;
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 320
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    const/16 v2, 0x1001

    invoke-virtual {v0, v2}, Landroid/app/FragmentTransaction;->setTransition(I)Landroid/app/FragmentTransaction;

    .line 321
    const v2, 0x7f100044

    const-string v3, "wait-fragment"

    invoke-virtual {v0, v2, v1, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 322
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 323
    return-void
.end method
