.class public abstract Lcom/android/mail/ui/AbstractActivityController;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Lcom/android/mail/ui/ActivityController;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;,
        Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;,
        Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;,
        Lcom/android/mail/ui/AbstractActivityController$ConversationAction;
    }
.end annotation


# static fields
.field protected static final LOG_TAG:Ljava/lang/String;


# instance fields
.field protected isLoaderInitialized:Z

.field protected mAccount:Lcom/android/mail/providers/Account;

.field private final mAccountObservers:Landroid/database/DataSetObservable;

.field protected mActionBarView:Lcom/android/mail/ui/MailActionBarView;

.field protected final mActivity:Lcom/android/mail/ui/ControllableActivity;

.field private mAsyncRefreshTask:Lcom/android/mail/ui/AsyncRefreshTask;

.field mCabActionMenu:Lcom/android/mail/browse/SelectedConversationsActionMenu;

.field protected final mContext:Landroid/content/Context;

.field protected mConvListContext:Lcom/android/mail/ConversationListContext;

.field protected mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

.field private final mConversationListObservable:Landroid/database/DataSetObservable;

.field private mConversationListRefreshTask:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;

.field private final mCurrentAccountUris:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field

.field protected mCurrentConversation:Lcom/android/mail/providers/Conversation;

.field private mDestroyed:Z

.field private mEnableShareIntents:Landroid/os/AsyncTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/AsyncTask",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Void;",
            "Ljava/lang/Void;",
            ">;"
        }
    .end annotation
.end field

.field protected mFolder:Lcom/android/mail/providers/Folder;

.field private mFolderChanged:Z

.field private final mFolderItemUpdateDelayMs:I

.field private mFolderListFolder:Lcom/android/mail/providers/Folder;

.field private final mFolderObservable:Landroid/database/DataSetObservable;

.field protected mFolderSyncTask:Lcom/android/mail/ui/AsyncRefreshTask;

.field private final mFragmentManager:Landroid/app/FragmentManager;

.field protected mHandler:Landroid/os/Handler;

.field private mIsDragHappening:Z

.field private final mListCursorCallbacks:Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;

.field private mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

.field protected mPagerController:Lcom/android/mail/browse/ConversationPagerController;

.field private mPendingDestruction:Lcom/android/mail/ui/DestructiveAction;

.field protected final mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

.field private final mRecentFolderObservers:Landroid/database/DataSetObservable;

.field private mRecentsDataUpdated:Z

.field protected mResolver:Landroid/content/ContentResolver;

.field private mSafeToModifyFragments:Z

.field private final mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

.field private mShowUndoBarDelay:I

.field protected mToastBar:Lcom/android/mail/ui/ActionableToastBar;

.field protected final mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

.field protected final mViewMode:Lcom/android/mail/ui/ViewMode;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 260
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/android/mail/ui/MailActivity;Lcom/android/mail/ui/ViewMode;)V
    .locals 3
    .param p1, "activity"    # Lcom/android/mail/ui/MailActivity;
    .param p2, "viewMode"    # Lcom/android/mail/ui/ViewMode;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 296
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 143
    iput-boolean v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderChanged:Z

    .line 153
    iput-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    .line 155
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mHandler:Landroid/os/Handler;

    .line 164
    iput-boolean v1, p0, Lcom/android/mail/ui/AbstractActivityController;->isLoaderInitialized:Z

    .line 177
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSafeToModifyFragments:Z

    .line 179
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentAccountUris:Ljava/util/Set;

    .line 181
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$1;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;

    .line 201
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$2;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$2;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccountObservers:Landroid/database/DataSetObservable;

    .line 219
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$3;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$3;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderObservers:Landroid/database/DataSetObservable;

    .line 239
    new-instance v0, Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-direct {v0}, Lcom/android/mail/ui/ConversationSelectionSet;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    .line 255
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;

    invoke-direct {v0, p0, v2}, Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;-><init>(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/ui/AbstractActivityController$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mListCursorCallbacks:Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;

    .line 258
    new-instance v0, Landroid/database/DataSetObservable;

    invoke-direct {v0}, Landroid/database/DataSetObservable;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderObservable:Landroid/database/DataSetObservable;

    .line 297
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 298
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFragmentManager:Landroid/app/FragmentManager;

    .line 299
    iput-object p2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    .line 300
    invoke-virtual {p1}, Lcom/android/mail/ui/MailActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    .line 301
    new-instance v0, Lcom/android/mail/ui/RecentFolderList;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/android/mail/ui/RecentFolderList;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    .line 302
    new-instance v0, Lcom/android/mail/ui/ConversationPositionTracker;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/ConversationPositionTracker;-><init>(Lcom/android/mail/ui/ConversationPositionTracker$Callbacks;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

    .line 305
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0, p0}, Lcom/android/mail/ui/ConversationSelectionSet;->addObserver(Lcom/android/mail/ui/ConversationSetObserver;)V

    .line 307
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0a0021

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderItemUpdateDelayMs:I

    .line 309
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0a0022

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    iput v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mShowUndoBarDelay:I

    .line 311
    return-void
.end method

.method static synthetic access$1000(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/providers/Account;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;
    .param p1, "x1"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 116
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->promptUserForAuthentication(Lcom/android/mail/providers/Account;)V

    return-void
.end method

.method static synthetic access$1100(Lcom/android/mail/ui/AbstractActivityController;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;

    .prologue
    .line 116
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->showStorageErrorDialog()V

    return-void
.end method

.method static synthetic access$400(Lcom/android/mail/ui/AbstractActivityController;)I
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;

    .prologue
    .line 116
    iget v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mShowUndoBarDelay:I

    return v0
.end method

.method static synthetic access$500(Lcom/android/mail/ui/AbstractActivityController;)Lcom/android/mail/ui/ConversationSelectionSet;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;
    .param p1, "x1"    # Lcom/android/mail/ui/DestructiveAction;

    .prologue
    .line 116
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->destroyPending(Lcom/android/mail/ui/DestructiveAction;)V

    return-void
.end method

.method static synthetic access$700(Lcom/android/mail/ui/AbstractActivityController;)Landroid/database/DataSetObservable;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;

    return-object v0
.end method

.method static synthetic access$900(Lcom/android/mail/ui/AbstractActivityController;Landroid/net/Uri;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController;
    .param p1, "x1"    # Landroid/net/Uri;

    .prologue
    .line 116
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->startAsyncRefreshTask(Landroid/net/Uri;)V

    return-void
.end method

.method private accountsUpdated(Landroid/database/Cursor;)Z
    .locals 5
    .param p1, "accountCursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v2, 0x1

    .line 1705
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v3, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v3

    if-nez v3, :cond_1

    .line 1731
    :cond_0
    :goto_0
    return v2

    .line 1711
    :cond_1
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentAccountUris:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->size()I

    move-result v3

    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v4

    if-ne v3, v4, :cond_0

    .line 1717
    const/4 v1, 0x0

    .line 1719
    .local v1, "foundCurrentAccount":Z
    :cond_2
    const/4 v3, 0x3

    invoke-interface {p1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 1721
    .local v0, "accountUri":Landroid/net/Uri;
    if-nez v1, :cond_3

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v3, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 1722
    const/4 v1, 0x1

    .line 1725
    :cond_3
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentAccountUris:Ljava/util/Set;

    invoke-interface {v3, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1728
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v3

    if-nez v3, :cond_2

    .line 1731
    if-eqz v1, :cond_0

    const/4 v2, 0x0

    goto :goto_0
.end method

.method private attachActionBar()V
    .locals 6

    .prologue
    const/4 v5, -0x1

    .line 415
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 416
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    if-eqz v3, :cond_0

    .line 417
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    new-instance v4, Landroid/app/ActionBar$LayoutParams;

    invoke-direct {v4, v5, v5}, Landroid/app/ActionBar$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v3, v4}, Landroid/app/ActionBar;->setCustomView(Landroid/view/View;Landroid/app/ActionBar$LayoutParams;)V

    .line 420
    const/16 v2, 0x1a

    .line 422
    .local v2, "mask":I
    const/16 v1, 0x12

    .line 423
    .local v1, "enabled":I
    const/16 v3, 0x12

    const/16 v4, 0x1a

    invoke-virtual {v0, v3, v4}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 424
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v3}, Lcom/android/mail/ui/MailActionBarView;->attach()V

    .line 426
    .end local v1    # "enabled":I
    .end local v2    # "mask":I
    :cond_0
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v3, v4}, Lcom/android/mail/ui/ViewMode;->addListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V

    .line 427
    return-void
.end method

.method private cancelRefreshTask()V
    .locals 1

    .prologue
    .line 2282
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListRefreshTask:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;

    if-eqz v0, :cond_0

    .line 2283
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListRefreshTask:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;

    invoke-virtual {v0}, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;->cancel()Z

    .line 2284
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListRefreshTask:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;

    .line 2286
    :cond_0
    return-void
.end method

.method private changeFolder(Lcom/android/mail/providers/Folder;Ljava/lang/String;)V
    .locals 2
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "query"    # Ljava/lang/String;

    .prologue
    .line 547
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0, p1}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 548
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->commitDestructiveActions(Z)V

    .line 550
    :cond_0
    if-eqz p1, :cond_1

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v0}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    const/4 v1, 0x2

    if-eq v0, v1, :cond_3

    .line 552
    :cond_2
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;->setListContext(Lcom/android/mail/providers/Folder;Ljava/lang/String;)V

    .line 553
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->showConversationList(Lcom/android/mail/ConversationListContext;)V

    .line 555
    :cond_3
    return-void
.end method

.method private final destroyPending(Lcom/android/mail/ui/DestructiveAction;)V
    .locals 1
    .param p1, "nextAction"    # Lcom/android/mail/ui/DestructiveAction;

    .prologue
    .line 2526
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPendingDestruction:Lcom/android/mail/ui/DestructiveAction;

    if-eqz v0, :cond_0

    .line 2527
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPendingDestruction:Lcom/android/mail/ui/DestructiveAction;

    invoke-interface {v0}, Lcom/android/mail/ui/DestructiveAction;->performAction()V

    .line 2529
    :cond_0
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mPendingDestruction:Lcom/android/mail/ui/DestructiveAction;

    .line 2530
    return-void
.end method

.method private disableNotifications()V
    .locals 2

    .prologue
    .line 1803
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p0}, Lcom/android/mail/ui/SuppressNotificationReceiver;->activate(Landroid/content/Context;Lcom/android/mail/ui/AbstractActivityController;)Z

    .line 1804
    return-void
.end method

.method private disableNotificationsOnAccountChange(Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 1813
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    invoke-virtual {v0}, Lcom/android/mail/ui/SuppressNotificationReceiver;->activated()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/SuppressNotificationReceiver;->notificationsDisabledForAccount(Lcom/android/mail/providers/Account;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1816
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    invoke-virtual {v0}, Lcom/android/mail/ui/SuppressNotificationReceiver;->deactivate()V

    .line 1817
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p0}, Lcom/android/mail/ui/SuppressNotificationReceiver;->activate(Landroid/content/Context;Lcom/android/mail/ui/AbstractActivityController;)Z

    .line 1819
    :cond_0
    return-void
.end method

.method private enableNotifications()V
    .locals 1

    .prologue
    .line 1807
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    invoke-virtual {v0}, Lcom/android/mail/ui/SuppressNotificationReceiver;->deactivate()V

    .line 1808
    return-void
.end method

.method private fetchSearchFolder(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 515
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 516
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "query"

    const-string v2, "query"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 518
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x6

    invoke-virtual {v1, v2, v0, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 519
    return-void
.end method

.method private getInternalErrorClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    .locals 1

    .prologue
    .line 2818
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$12;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$12;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    return-object v0
.end method

.method private getRetryClickedListener(Lcom/android/mail/providers/Folder;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 2778
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$9;

    invoke-direct {v0, p0, p1}, Lcom/android/mail/ui/AbstractActivityController$9;-><init>(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/providers/Folder;)V

    return-object v0
.end method

.method private getSignInClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    .locals 1

    .prologue
    .line 2791
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$10;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$10;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    return-object v0
.end method

.method private getStorageErrorClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    .locals 1

    .prologue
    .line 2800
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$11;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$11;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    return-object v0
.end method

.method private handleIntent(Landroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1408
    .line 1409
    const-string v3, "android.intent.action.VIEW"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 1410
    const-string v3, "account"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 1411
    const-string v3, "account"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/android/mail/providers/Account;->newinstance(Ljava/lang/String;)Lcom/android/mail/providers/Account;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/android/mail/ui/AbstractActivityController;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 1413
    :cond_0
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v3, :cond_2

    .line 1472
    :cond_1
    :goto_0
    return-void

    .line 1416
    :cond_2
    const-string v3, "conversationUri"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v3

    .line 1417
    if-eqz v3, :cond_7

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v4}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v4

    if-nez v4, :cond_7

    .line 1418
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v4}, Lcom/android/mail/ui/ViewMode;->enterConversationMode()Z

    .line 1422
    :goto_1
    const-string v4, "folder"

    invoke-virtual {p1, v4}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    const-string v0, "folder"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v0

    .line 1424
    :cond_3
    if-eqz v0, :cond_b

    .line 1425
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    move v0, v1

    .line 1429
    :goto_2
    if-eqz v3, :cond_5

    .line 1431
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v3, "SHOW THE CONVERSATION at %s"

    new-array v4, v1, [Ljava/lang/Object;

    const-string v5, "conversationUri"

    invoke-virtual {p1, v5}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1433
    const-string v0, "conversationUri"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1435
    if-eqz v0, :cond_4

    iget v3, v0, Lcom/android/mail/providers/Conversation;->position:I

    if-gez v3, :cond_4

    .line 1438
    iput v2, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 1440
    :cond_4
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;)V

    move v0, v1

    .line 1444
    :cond_5
    if-nez v0, :cond_6

    .line 1446
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->loadAccountInbox()V

    .line 1469
    :cond_6
    :goto_3
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_1

    .line 1470
    const/4 v0, 0x7

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    goto :goto_0

    .line 1420
    :cond_7
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v4}, Lcom/android/mail/ui/ViewMode;->enterConversationListMode()Z

    goto :goto_1

    .line 1448
    :cond_8
    const-string v3, "android.intent.action.SEARCH"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    .line 1449
    const-string v3, "account"

    invoke-virtual {p1, v3}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_a

    .line 1451
    const-string v2, "query"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 1452
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    const v4, 0x7f0c0012

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 1453
    new-instance v4, Landroid/provider/SearchRecentSuggestions;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-direct {v4, v5, v3, v1}, Landroid/provider/SearchRecentSuggestions;-><init>(Landroid/content/Context;Ljava/lang/String;I)V

    .line 1455
    invoke-virtual {v4, v2, v0}, Landroid/provider/SearchRecentSuggestions;->saveRecentQuery(Ljava/lang/String;Ljava/lang/String;)V

    .line 1456
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->showTwoPaneSearchResults(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1457
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsConversationMode()Z

    .line 1461
    :goto_4
    const-string v0, "account"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getParcelableExtra(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Account;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 1462
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    .line 1463
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->fetchSearchFolder(Landroid/content/Intent;)V

    goto :goto_3

    .line 1459
    :cond_9
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterSearchResultsListMode()Z

    goto :goto_4

    .line 1465
    :cond_a
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Missing account extra from search intent.  Finishing"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1466
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_3

    :cond_b
    move v0, v2

    goto/16 :goto_2
.end method

.method private initializeActionBar()V
    .locals 8

    .prologue
    .line 397
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v4

    .line 398
    .local v4, "actionBar":Landroid/app/ActionBar;
    if-nez v4, :cond_0

    .line 409
    :goto_0
    return-void

    .line 403
    :cond_0
    invoke-virtual {v4}, Landroid/app/ActionBar;->getThemedContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v6

    .line 404
    .local v6, "inflater":Landroid/view/LayoutInflater;
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    if-eqz v0, :cond_1

    const-string v0, "android.intent.action.SEARCH"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v7, 0x1

    .line 406
    .local v7, "isSearch":Z
    :goto_1
    if-eqz v7, :cond_2

    const v0, 0x7f040064

    :goto_2
    const/4 v1, 0x0

    invoke-virtual {v6, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/MailActionBarView;

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    .line 408
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    move-object v2, p0

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/MailActionBarView;->initialize(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ActivityController;Lcom/android/mail/ui/ViewMode;Landroid/app/ActionBar;Lcom/android/mail/ui/RecentFolderList;)V

    goto :goto_0

    .line 404
    .end local v7    # "isSearch":Z
    :cond_1
    const/4 v7, 0x0

    goto :goto_1

    .line 406
    .restart local v7    # "isSearch":Z
    :cond_2
    const v0, 0x7f04000c

    goto :goto_2
.end method

.method private isDragging()Z
    .locals 1

    .prologue
    .line 2205
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mIsDragHappening:Z

    return v0
.end method

.method private static final isValidFragment(Landroid/app/Fragment;)Z
    .locals 1
    .param p0, "in"    # Landroid/app/Fragment;

    .prologue
    .line 348
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Landroid/app/Fragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Landroid/app/Fragment;->getView()Landroid/view/View;

    move-result-object v0

    if-nez v0, :cond_1

    .line 349
    :cond_0
    const/4 v0, 0x0

    .line 351
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private loadRecentFolders(Landroid/database/Cursor;)V
    .locals 1
    .param p1, "data"    # Landroid/database/Cursor;

    .prologue
    .line 2289
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/RecentFolderList;->loadFromUiProvider(Landroid/database/Cursor;)V

    .line 2290
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->isAnimating()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2291
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentsDataUpdated:Z

    .line 2295
    :goto_0
    return-void

    .line 2293
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    goto :goto_0
.end method

.method private markConversationsRead(Ljava/util/Collection;ZZZ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;ZZZ)V"
        }
    .end annotation

    .prologue
    .line 1030
    if-eqz p4, :cond_0

    if-nez p2, :cond_0

    .line 1031
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->showNextConversation(Ljava/util/Collection;)V

    .line 1033
    :cond_0
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v0

    .line 1034
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 1035
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1036
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 1037
    sget-object v4, Lcom/android/mail/providers/UIProvider$ConversationColumns;->READ:Ljava/lang/String;

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1038
    if-eqz p3, :cond_2

    .line 1039
    const-string v4, "viewed"

    const/4 v5, 0x1

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1041
    :cond_2
    iget-object v4, v0, Lcom/android/mail/providers/Conversation;->conversationInfo:Lcom/android/mail/providers/ConversationInfo;

    .line 1042
    if-eqz v4, :cond_3

    .line 1043
    invoke-virtual {v4, p2}, Lcom/android/mail/providers/ConversationInfo;->markRead(Z)Z

    move-result v5

    .line 1044
    if-eqz v5, :cond_3

    .line 1045
    const-string v5, "conversationInfo"

    invoke-static {v4}, Lcom/android/mail/providers/ConversationInfo;->toString(Lcom/android/mail/providers/ConversationInfo;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v5, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 1049
    :cond_3
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    const/4 v5, 0x2

    invoke-virtual {v4, v0, v5, v3}, Lcom/android/mail/browse/ConversationCursor;->getOperationForConversation(Lcom/android/mail/providers/Conversation;ILandroid/content/ContentValues;)Lcom/android/mail/browse/ConversationCursor$ConversationOperation;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1052
    iput-boolean p2, v0, Lcom/android/mail/providers/Conversation;->read:Z

    .line 1053
    if-eqz p3, :cond_1

    .line 1054
    invoke-virtual {v0}, Lcom/android/mail/providers/Conversation;->markViewed()V

    goto :goto_0

    .line 1057
    :cond_4
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v2, v1}, Lcom/android/mail/browse/ConversationCursor;->updateBulkValues(Landroid/content/Context;Ljava/util/Collection;)I

    .line 1058
    return-void
.end method

.method private promptUserForAuthentication(Lcom/android/mail/providers/Account;)V
    .locals 3

    .prologue
    .line 2873
    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->isEmpty(Landroid/net/Uri;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2874
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p1, Lcom/android/mail/providers/Account;->reauthenticationIntentUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 2876
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const/4 v2, 0x2

    invoke-interface {v1, v0, v2}, Lcom/android/mail/ui/ControllableActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 2878
    :cond_0
    return-void
.end method

.method private final registerDestructiveAction(Lcom/android/mail/ui/DestructiveAction;)V
    .locals 0
    .param p1, "action"    # Lcom/android/mail/ui/DestructiveAction;

    .prologue
    .line 2542
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->destroyPending(Lcom/android/mail/ui/DestructiveAction;)V

    .line 2543
    return-void
.end method

.method private requestFolderRefresh()V
    .locals 3

    .prologue
    .line 1111
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_1

    .line 1112
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAsyncRefreshTask:Lcom/android/mail/ui/AsyncRefreshTask;

    if-eqz v0, :cond_0

    .line 1113
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAsyncRefreshTask:Lcom/android/mail/ui/AsyncRefreshTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AsyncRefreshTask;->cancel(Z)Z

    .line 1115
    :cond_0
    new-instance v0, Lcom/android/mail/ui/AsyncRefreshTask;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, v2, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    invoke-direct {v0, v1, v2}, Lcom/android/mail/ui/AsyncRefreshTask;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAsyncRefreshTask:Lcom/android/mail/ui/AsyncRefreshTask;

    .line 1116
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAsyncRefreshTask:Lcom/android/mail/ui/AsyncRefreshTask;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AsyncRefreshTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1118
    :cond_1
    return-void
.end method

.method private requestUpdate(Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 0
    .param p2, "action"    # Lcom/android/mail/ui/DestructiveAction;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1186
    .local p1, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-interface {p2}, Lcom/android/mail/ui/DestructiveAction;->performAction()V

    .line 1187
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->refreshConversationList()V

    .line 1188
    return-void
.end method

.method private restartOptionalLoader(I)V
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 1662
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 1663
    .local v0, "lm":Landroid/app/LoaderManager;
    invoke-virtual {v0, p1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 1664
    sget-object v1, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    invoke-virtual {v0, p1, v1, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 1665
    return-void
.end method

.method private final restoreSelectedConversations(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 1480
    if-nez p1, :cond_0

    .line 1481
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V

    .line 1492
    :goto_0
    return-void

    .line 1484
    :cond_0
    const-string v0, "saved-selected-set"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ConversationSelectionSet;

    .line 1485
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 1486
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V

    goto :goto_0

    .line 1491
    :cond_2
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v1, v0}, Lcom/android/mail/ui/ConversationSelectionSet;->putAll(Lcom/android/mail/ui/ConversationSelectionSet;)V

    goto :goto_0
.end method

.method private setAccount(Lcom/android/mail/providers/Account;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 1329
    if-nez p1, :cond_0

    .line 1330
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/Error;

    invoke-direct {v1}, Ljava/lang/Error;-><init>()V

    const-string v2, "AAC ignoring null (presumably invalid) account restoration"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1349
    :goto_0
    return-void

    .line 1334
    :cond_0
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "AbstractActivityController.setAccount(): account = %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1335
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    .line 1338
    const/4 v0, 0x3

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    .line 1339
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 1340
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->disableNotificationsOnAccountChange(Lcom/android/mail/providers/Account;)V

    .line 1341
    const/4 v0, 0x7

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    .line 1342
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/MailAppProvider;->setLastViewedAccount(Ljava/lang/String;)V

    .line 1344
    iget-object v0, p1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    if-nez v0, :cond_1

    .line 1345
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/Error;

    invoke-direct {v1}, Ljava/lang/Error;-><init>()V

    const-string v2, "AAC ignoring account with null settings."

    new-array v3, v4, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 1348
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccountObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    goto :goto_0
.end method

.method private final setHasFolderChanged(Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p1, "newFolder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 611
    if-nez p1, :cond_1

    .line 619
    :cond_0
    :goto_0
    return-void

    .line 616
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_2

    iget-object v0, p1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v1, v1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 617
    :cond_2
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderChanged:Z

    goto :goto_0
.end method

.method private setListContext(Lcom/android/mail/providers/Folder;Ljava/lang/String;)V
    .locals 2
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "query"    # Ljava/lang/String;

    .prologue
    .line 532
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->updateFolder(Lcom/android/mail/providers/Folder;)V

    .line 533
    if-eqz p2, :cond_0

    .line 534
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0, v1, p2}, Lcom/android/mail/ConversationListContext;->forSearchQuery(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)Lcom/android/mail/ConversationListContext;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    .line 538
    :goto_0
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->cancelRefreshTask()V

    .line 539
    return-void

    .line 536
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0, v1}, Lcom/android/mail/ConversationListContext;->forFolder(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)Lcom/android/mail/ConversationListContext;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    goto :goto_0
.end method

.method private final showConversation(Lcom/android/mail/providers/Conversation;)V
    .locals 1
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 1500
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;Z)V

    .line 1501
    return-void
.end method

.method private showStorageErrorDialog()V
    .locals 3

    .prologue
    .line 2809
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v2, "SyncErrorDialogFragment"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Landroid/app/DialogFragment;

    .line 2811
    .local v0, "fragment":Landroid/app/DialogFragment;
    if-nez v0, :cond_0

    .line 2812
    invoke-static {}, Lcom/android/mail/browse/SyncErrorDialogFragment;->newInstance()Lcom/android/mail/browse/SyncErrorDialogFragment;

    move-result-object v0

    .line 2814
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v2, "SyncErrorDialogFragment"

    invoke-virtual {v0, v1, v2}, Landroid/app/DialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 2815
    return-void
.end method

.method private startAsyncRefreshTask(Landroid/net/Uri;)V
    .locals 2
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 2865
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderSyncTask:Lcom/android/mail/ui/AsyncRefreshTask;

    if-eqz v0, :cond_0

    .line 2866
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderSyncTask:Lcom/android/mail/ui/AsyncRefreshTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AsyncRefreshTask;->cancel(Z)Z

    .line 2868
    :cond_0
    new-instance v0, Lcom/android/mail/ui/AsyncRefreshTask;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/android/mail/ui/AsyncRefreshTask;-><init>(Landroid/content/Context;Landroid/net/Uri;)V

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderSyncTask:Lcom/android/mail/ui/AsyncRefreshTask;

    .line 2869
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderSyncTask:Lcom/android/mail/ui/AsyncRefreshTask;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AsyncRefreshTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 2870
    return-void
.end method

.method private switchAccount(Lcom/android/mail/providers/Account;Z)V
    .locals 6
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "shouldReloadInbox"    # Z

    .prologue
    .line 445
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    .line 446
    sget-object v1, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "AbstractActivityController.switchAccount(): mAccount = %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v5, v5, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 448
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->cancelRefreshTask()V

    .line 449
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccountObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v1}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 450
    if-eqz p2, :cond_0

    .line 451
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->loadAccountInbox()V

    .line 453
    :cond_0
    const/4 v1, 0x3

    invoke-direct {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    .line 454
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 455
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-direct {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->disableNotificationsOnAccountChange(Lcom/android/mail/providers/Account;)V

    .line 456
    const/4 v1, 0x7

    invoke-direct {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    .line 457
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/providers/MailAppProvider;->setLastViewedAccount(Ljava/lang/String;)V

    .line 458
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v1, :cond_1

    sget-object v1, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v2, v2, Lcom/android/mail/providers/Settings;->setupIntentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 460
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.EDIT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 461
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v1, v1, Lcom/android/mail/providers/Settings;->setupIntentUri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 462
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1, v0}, Lcom/android/mail/ui/ControllableActivity;->startActivity(Landroid/content/Intent;)V

    .line 464
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    return-void
.end method

.method private updateAccounts(Landroid/database/Cursor;)Z
    .locals 10

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 1742
    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    move v0, v3

    .line 1799
    :goto_0
    return v0

    .line 1746
    :cond_1
    invoke-static {p1}, Lcom/android/mail/providers/Account;->getAllAccounts(Landroid/database/Cursor;)[Lcom/android/mail/providers/Account;

    move-result-object v5

    .line 1748
    const/4 v1, 0x0

    .line 1751
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentAccountUris:Ljava/util/Set;

    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 1752
    array-length v6, v5

    move v4, v3

    :goto_1
    if-ge v4, v6, :cond_2

    aget-object v0, v5, v4

    .line 1753
    sget-object v7, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v8, "updateAccounts(%s)"

    new-array v9, v2, [Ljava/lang/Object;

    aput-object v0, v9, v3

    invoke-static {v7, v8, v9}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1754
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentAccountUris:Ljava/util/Set;

    iget-object v8, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-interface {v7, v8}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 1755
    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v7, :cond_9

    iget-object v7, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v8, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v8, v8, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v7, v8}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 1752
    :goto_2
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    move-object v1, v0

    goto :goto_1

    .line 1769
    :cond_2
    aget-object v0, v5, v3

    .line 1770
    if-eqz v1, :cond_4

    .line 1772
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v1, v4}, Lcom/android/mail/providers/Account;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_8

    move v0, v2

    .line 1793
    :goto_3
    if-eqz v0, :cond_3

    .line 1794
    invoke-virtual {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->onAccountChanged(Lcom/android/mail/providers/Account;)V

    .line 1798
    :cond_3
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0, v5}, Lcom/android/mail/ui/MailActionBarView;->setAccounts([Lcom/android/mail/providers/Account;)V

    .line 1799
    array-length v0, v5

    if-lez v0, :cond_6

    move v0, v2

    goto :goto_0

    .line 1780
    :cond_4
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v1, :cond_7

    .line 1782
    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getInstance()Lcom/android/mail/providers/MailAppProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/android/mail/providers/MailAppProvider;->getLastViewedAccount()Ljava/lang/String;

    move-result-object v6

    .line 1783
    if-eqz v6, :cond_7

    .line 1784
    array-length v7, v5

    move v4, v3

    :goto_4
    if-ge v4, v7, :cond_7

    aget-object v1, v5, v4

    .line 1785
    iget-object v8, v1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v8}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    move v0, v2

    .line 1787
    goto :goto_3

    .line 1784
    :cond_5
    add-int/lit8 v1, v4, 0x1

    move v4, v1

    goto :goto_4

    :cond_6
    move v0, v3

    .line 1799
    goto :goto_0

    :cond_7
    move-object v1, v0

    move v0, v2

    goto :goto_3

    :cond_8
    move-object v1, v0

    move v0, v3

    goto :goto_3

    :cond_9
    move-object v0, v1

    goto :goto_2
.end method

.method private final updateConversationListFragment()V
    .locals 2

    .prologue
    .line 2246
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 2247
    .local v0, "convList":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz v0, :cond_0

    .line 2248
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->refreshConversationList()V

    .line 2249
    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 2250
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->informCursorVisiblity(Z)V

    .line 2253
    :cond_0
    return-void
.end method

.method private updateFolder(Lcom/android/mail/providers/Folder;)V
    .locals 10
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x0

    const/4 v7, 0x4

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 629
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/android/mail/providers/Folder;->isInitialized()Z

    move-result v4

    if-nez v4, :cond_1

    .line 630
    :cond_0
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/Error;

    invoke-direct {v5}, Ljava/lang/Error;-><init>()V

    const-string v6, "AAC.setFolder(%s): Bad input"

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    invoke-static {v4, v5, v6, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 673
    :goto_0
    return-void

    .line 633
    :cond_1
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v4}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 634
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "AAC.setFolder(%s): Input matches mFolder"

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    invoke-static {v4, v5, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 637
    :cond_2
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-nez v4, :cond_4

    move v1, v2

    .line 638
    .local v1, "wasNull":Z
    :goto_1
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "AbstractActivityController.setFolder(%s)"

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v6, p1, Lcom/android/mail/providers/Folder;->name:Ljava/lang/String;

    aput-object v6, v2, v3

    invoke-static {v4, v5, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 639
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    .line 643
    .local v0, "lm":Landroid/app/LoaderManager;
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->setHasFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 644
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    .line 649
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v2, v3}, Lcom/android/mail/ui/MailActionBarView;->setFolder(Lcom/android/mail/providers/Folder;)V

    .line 656
    invoke-virtual {v0, v9}, Landroid/app/LoaderManager;->getLoader(I)Landroid/content/Loader;

    move-result-object v2

    if-nez v2, :cond_5

    .line 657
    invoke-virtual {v0, v9, v8, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 664
    :goto_2
    if-nez v1, :cond_3

    invoke-virtual {v0, v7}, Landroid/app/LoaderManager;->getLoader(I)Landroid/content/Loader;

    move-result-object v2

    if-nez v2, :cond_6

    .line 665
    :cond_3
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mListCursorCallbacks:Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;

    invoke-virtual {v0, v7, v8, v2}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0

    .end local v0    # "lm":Landroid/app/LoaderManager;
    .end local v1    # "wasNull":Z
    :cond_4
    move v1, v3

    .line 637
    goto :goto_1

    .line 659
    .restart local v0    # "lm":Landroid/app/LoaderManager;
    .restart local v1    # "wasNull":Z
    :cond_5
    invoke-virtual {v0, v9, v8, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_2

    .line 670
    :cond_6
    invoke-virtual {v0, v7}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 671
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mListCursorCallbacks:Lcom/android/mail/ui/AbstractActivityController$ConversationListLoaderCallbacks;

    invoke-virtual {v0, v7, v8, v2}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0
.end method

.method private updateRecentFolderList()V
    .locals 3

    .prologue
    .line 566
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_0

    .line 567
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/ui/RecentFolderList;->touchFolder(Lcom/android/mail/providers/Folder;Lcom/android/mail/providers/Account;)V

    .line 569
    :cond_0
    return-void
.end method


# virtual methods
.method public final assignFolder(Ljava/util/Collection;Ljava/util/Collection;ZZ)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;ZZ)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v6, 0x0

    .line 2150
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {p1, v0}, Lcom/android/mail/ui/FolderOperation;->isDestructive(Ljava/util/Collection;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v3, v1

    .line 2153
    :goto_0
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "onFolderChangesCommit: isDestructive = %b"

    new-array v4, v1, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v0, v2, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2154
    if-eqz v3, :cond_1

    .line 2155
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 2156
    iput-boolean v1, v0, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    goto :goto_1

    :cond_0
    move v3, v6

    .line 2150
    goto :goto_0

    .line 2162
    :cond_1
    if-eqz v3, :cond_2

    move-object v0, p0

    move-object v1, p2

    move-object v2, p1

    move v4, p3

    move v5, p4

    .line 2163
    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredFolderChange(Ljava/util/Collection;Ljava/util/Collection;ZZZ)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v0

    .line 2165
    invoke-virtual {p0, v6, p2, v0}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 2171
    :goto_2
    return-void

    :cond_2
    move-object v0, p0

    move-object v1, p2

    move-object v2, p1

    move v4, p3

    move v5, p4

    .line 2167
    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/AbstractActivityController;->getFolderChange(Ljava/util/Collection;Ljava/util/Collection;ZZZ)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v0

    .line 2169
    invoke-direct {p0, p2, v0}, Lcom/android/mail/ui/AbstractActivityController;->requestUpdate(Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_2
.end method

.method public commitDestructiveActions(Z)V
    .locals 1
    .param p1, "animate"    # Z

    .prologue
    .line 1307
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 1308
    .local v0, "fragment":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz v0, :cond_0

    .line 1309
    invoke-virtual {v0, p1}, Lcom/android/mail/ui/ConversationListFragment;->commitDestructiveActions(Z)V

    .line 1311
    :cond_0
    return-void
.end method

.method protected confirmAndDelete(Ljava/util/Collection;ZILcom/android/mail/ui/DestructiveAction;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;ZI",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1130
    if-eqz p2, :cond_0

    .line 1131
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$7;

    invoke-direct {v0, p0, p1, p4}, Lcom/android/mail/ui/AbstractActivityController$7;-><init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 1139
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v2

    invoke-static {v1, p3, v2}, Lcom/android/mail/utils/Utils;->formatPlural(Landroid/content/Context;II)Ljava/lang/String;

    move-result-object v1

    .line 1141
    new-instance v2, Landroid/app/AlertDialog$Builder;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v2, v3}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {v2, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    const v2, 0x7f0c00d2

    invoke-virtual {v1, v2, v0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d3

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 1148
    :goto_0
    return-void

    .line 1146
    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p4}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_0
.end method

.method public delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 1
    .param p1, "actionId"    # I
    .param p3, "action"    # Lcom/android/mail/ui/DestructiveAction;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1176
    .local p2, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, p1, p2, v0, p3}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 1177
    return-void
.end method

.method public delete(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/browse/ConversationItemView;",
            ">;",
            "Lcom/android/mail/ui/DestructiveAction;",
            ")V"
        }
    .end annotation

    .prologue
    .line 1160
    invoke-virtual {p0, p2}, Lcom/android/mail/ui/AbstractActivityController;->showNextConversation(Ljava/util/Collection;)V

    .line 1162
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 1163
    if-eqz v0, :cond_0

    .line 1164
    sget-object v1, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "AAC.requestDelete: ListFragment is handling delete."

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1165
    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/android/mail/ui/ConversationListFragment;->requestDelete(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 1171
    :goto_0
    return-void

    .line 1170
    :cond_0
    invoke-interface {p4}, Lcom/android/mail/ui/DestructiveAction;->performAction()V

    goto :goto_0
.end method

.method protected disableCabMode()V
    .locals 1

    .prologue
    .line 2352
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->commitDestructiveActions(Z)V

    .line 2353
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCabActionMenu:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    if-eqz v0, :cond_0

    .line 2354
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCabActionMenu:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    invoke-virtual {v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->deactivate()V

    .line 2356
    :cond_0
    return-void
.end method

.method public disablePagerUpdates()V
    .locals 1

    .prologue
    .line 1298
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationPagerController;->stopListening()V

    .line 1299
    return-void
.end method

.method protected enableCabMode()V
    .locals 1

    .prologue
    .line 2362
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCabActionMenu:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    if-eqz v0, :cond_0

    .line 2363
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCabActionMenu:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    invoke-virtual {v0}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->activate()V

    .line 2365
    :cond_0
    return-void
.end method

.method protected final exitCabMode()V
    .locals 1

    .prologue
    .line 2371
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V

    .line 2372
    return-void
.end method

.method public exitSearchMode()V
    .locals 2

    .prologue
    .line 2392
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 2393
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    .line 2395
    :cond_0
    return-void
.end method

.method public getAccount()Lcom/android/mail/providers/Account;
    .locals 1

    .prologue
    .line 511
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method public final getBatchAction(I)Lcom/android/mail/ui/DestructiveAction;
    .locals 3
    .param p1, "action"    # I

    .prologue
    .line 2548
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, p0, p1, v1, v2}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;-><init>(Lcom/android/mail/ui/AbstractActivityController;ILjava/util/Collection;Z)V

    .line 2549
    .local v0, "da":Lcom/android/mail/ui/DestructiveAction;
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->registerDestructiveAction(Lcom/android/mail/ui/DestructiveAction;)V

    .line 2550
    return-object v0
.end method

.method public final getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    return-object v0
.end method

.method protected getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;
    .locals 3

    .prologue
    .line 366
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v2, "tag-conversation-list"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 367
    .local v0, "fragment":Landroid/app/Fragment;
    invoke-static {v0}, Lcom/android/mail/ui/AbstractActivityController;->isValidFragment(Landroid/app/Fragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 368
    check-cast v0, Lcom/android/mail/ui/ConversationListFragment;

    .line 370
    .end local v0    # "fragment":Landroid/app/Fragment;
    :goto_0
    return-object v0

    .restart local v0    # "fragment":Landroid/app/Fragment;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentAccount()Lcom/android/mail/providers/Account;
    .locals 1

    .prologue
    .line 315
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method public getCurrentConversation()Lcom/android/mail/providers/Conversation;
    .locals 1

    .prologue
    .line 1579
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    return-object v0
.end method

.method public getCurrentListContext()Lcom/android/mail/ConversationListContext;
    .locals 1

    .prologue
    .line 320
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    return-object v0
.end method

.method public getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;
    .locals 1
    .param p1, "action"    # I
    .param p3, "batch"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;Z)",
            "Lcom/android/mail/ui/DestructiveAction;"
        }
    .end annotation

    .prologue
    .line 2570
    .local p2, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    invoke-direct {v0, p0, p1, p2, p3}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;-><init>(Lcom/android/mail/ui/AbstractActivityController;ILjava/util/Collection;Z)V

    .line 2571
    .local v0, "da":Lcom/android/mail/ui/DestructiveAction;
    return-object v0
.end method

.method public final getDeferredBatchAction(I)Lcom/android/mail/ui/DestructiveAction;
    .locals 2
    .param p1, "action"    # I

    .prologue
    .line 2555
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {p0, p1, v0, v1}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v0

    return-object v0
.end method

.method public final getDeferredFolderChange(Ljava/util/Collection;Ljava/util/Collection;ZZZ)Lcom/android/mail/ui/DestructiveAction;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;ZZZ)",
            "Lcom/android/mail/ui/DestructiveAction;"
        }
    .end annotation

    .prologue
    .line 2667
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;

    const v7, 0x7f100127

    const/4 v8, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v8}, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;-><init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Ljava/util/Collection;ZZZILcom/android/mail/ui/AbstractActivityController$1;)V

    .line 2669
    return-object v0
.end method

.method public final getDeferredRemoveFolder(Ljava/util/Collection;Lcom/android/mail/providers/Folder;ZZZ)Lcom/android/mail/ui/DestructiveAction;
    .locals 9
    .param p2, "toRemove"    # Lcom/android/mail/providers/Folder;
    .param p3, "isDestructive"    # Z
    .param p4, "isBatch"    # Z
    .param p5, "showUndo"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Lcom/android/mail/providers/Folder;",
            "ZZZ)",
            "Lcom/android/mail/ui/DestructiveAction;"
        }
    .end annotation

    .prologue
    .line 2676
    .local p1, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 2677
    .local v3, "folderOps":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/ui/FolderOperation;>;"
    new-instance v0, Lcom/android/mail/ui/FolderOperation;

    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-direct {v0, p2, v1}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-interface {v3, v0}, Ljava/util/Collection;->add(Ljava/lang/Object;)Z

    .line 2678
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;

    const v7, 0x7f100124

    const/4 v8, 0x0

    move-object v1, p0

    move-object v2, p1

    move v4, p3

    move v5, p4

    move v6, p5

    invoke-direct/range {v0 .. v8}, Lcom/android/mail/ui/AbstractActivityController$FolderDestruction;-><init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Ljava/util/Collection;ZZZILcom/android/mail/ui/AbstractActivityController$1;)V

    return-object v0
.end method

.method public getFolder()Lcom/android/mail/providers/Folder;
    .locals 1

    .prologue
    .line 677
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    return-object v0
.end method

.method public final getFolderChange(Ljava/util/Collection;Ljava/util/Collection;ZZZ)Lcom/android/mail/ui/DestructiveAction;
    .locals 1
    .param p3, "isDestructive"    # Z
    .param p4, "isBatch"    # Z
    .param p5, "showUndo"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;ZZZ)",
            "Lcom/android/mail/ui/DestructiveAction;"
        }
    .end annotation

    .prologue
    .line 2658
    .local p1, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    .local p2, "folders":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/ui/FolderOperation;>;"
    invoke-virtual/range {p0 .. p5}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredFolderChange(Ljava/util/Collection;Ljava/util/Collection;ZZZ)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v0

    .line 2660
    .local v0, "da":Lcom/android/mail/ui/DestructiveAction;
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->registerDestructiveAction(Lcom/android/mail/ui/DestructiveAction;)V

    .line 2661
    return-object v0
.end method

.method protected getFolderListFragment()Lcom/android/mail/ui/FolderListFragment;
    .locals 3

    .prologue
    .line 385
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v2, "tag-folder-list"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 386
    .local v0, "fragment":Landroid/app/Fragment;
    invoke-static {v0}, Lcom/android/mail/ui/AbstractActivityController;->isValidFragment(Landroid/app/Fragment;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 387
    check-cast v0, Lcom/android/mail/ui/FolderListFragment;

    .line 389
    .end local v0    # "fragment":Landroid/app/Fragment;
    :goto_0
    return-object v0

    .restart local v0    # "fragment":Landroid/app/Fragment;
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getHelpContext()Ljava/lang/String;
    .locals 3

    .prologue
    .line 325
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v2}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v1

    .line 327
    .local v1, "mode":I
    packed-switch v1, :pswitch_data_0

    .line 332
    const v0, 0x7f0c000d

    .line 334
    .local v0, "helpContextResId":I
    :goto_0
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    return-object v2

    .line 329
    .end local v0    # "helpContextResId":I
    :pswitch_0
    const v0, 0x7f0c000c

    .line 330
    .restart local v0    # "helpContextResId":I
    goto :goto_0

    .line 327
    nop

    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_0
    .end packed-switch
.end method

.method public getHierarchyFolder()Lcom/android/mail/providers/Folder;
    .locals 1

    .prologue
    .line 682
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderListFolder:Lcom/android/mail/providers/Folder;

    return-object v0
.end method

.method public getRecentFolders()Lcom/android/mail/ui/RecentFolderList;
    .locals 1

    .prologue
    .line 592
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    return-object v0
.end method

.method public getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;
    .locals 1

    .prologue
    .line 2344
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    return-object v0
.end method

.method public getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;
    .locals 1

    .prologue
    .line 1496
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    return-object v0
.end method

.method protected final getUndoClickedListener(Lcom/android/mail/ui/AnimatedAdapter;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
    .locals 1
    .param p1, "listAdapter"    # Lcom/android/mail/ui/AnimatedAdapter;

    .prologue
    .line 2701
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$8;

    invoke-direct {v0, p0, p1}, Lcom/android/mail/ui/AbstractActivityController$8;-><init>(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/ui/AnimatedAdapter;)V

    return-object v0
.end method

.method public handleDrop(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)V
    .locals 9
    .param p1, "event"    # Landroid/view/DragEvent;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    const/4 v7, 0x0

    const/4 v4, 0x1

    .line 2417
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;->supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2441
    :goto_0
    return-void

    .line 2420
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->values()Ljava/util/Collection;

    move-result-object v1

    .line 2421
    .local v1, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 2423
    .local v2, "dragDropOperations":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/FolderOperation;>;"
    new-instance v0, Lcom/android/mail/ui/FolderOperation;

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-direct {v0, p2, v5}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 2426
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0}, Lcom/android/mail/providers/Folder;->isViewAll()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v5, 0x8

    invoke-virtual {v0, v5}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_2

    move v3, v4

    .line 2429
    .local v3, "isDestructive":Z
    :goto_1
    if-eqz v3, :cond_1

    .line 2430
    new-instance v0, Lcom/android/mail/ui/FolderOperation;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-direct {v0, v5, v8}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    :cond_1
    move-object v0, p0

    move v5, v4

    .line 2434
    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/AbstractActivityController;->getFolderChange(Ljava/util/Collection;Ljava/util/Collection;ZZZ)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v6

    .line 2436
    .local v6, "action":Lcom/android/mail/ui/DestructiveAction;
    if-eqz v3, :cond_3

    .line 2437
    invoke-virtual {p0, v7, v1, v6}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_0

    .end local v3    # "isDestructive":Z
    .end local v6    # "action":Lcom/android/mail/ui/DestructiveAction;
    :cond_2
    move v3, v7

    .line 2426
    goto :goto_1

    .line 2439
    .restart local v3    # "isDestructive":Z
    .restart local v6    # "action":Lcom/android/mail/ui/DestructiveAction;
    :cond_3
    invoke-interface {v6}, Lcom/android/mail/ui/DestructiveAction;->performAction()V

    goto :goto_0
.end method

.method public hideWaitForInitialization()V
    .locals 0

    .prologue
    .line 1532
    return-void
.end method

.method public inWaitMode()Z
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 1550
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 1551
    const-string v2, "wait-fragment"

    invoke-virtual {v0, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/WaitFragment;

    .line 1553
    if-eqz v0, :cond_1

    .line 1554
    invoke-virtual {v0}, Lcom/android/mail/ui/WaitFragment;->getAccount()Lcom/android/mail/providers/Account;

    move-result-object v0

    .line 1555
    iget-object v0, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v0, v2}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    const/4 v2, 0x6

    if-ne v0, v2, :cond_0

    const/4 v0, 0x1

    .line 1558
    :goto_0
    return v0

    :cond_0
    move v0, v1

    .line 1555
    goto :goto_0

    :cond_1
    move v0, v1

    .line 1558
    goto :goto_0
.end method

.method protected declared-synchronized informCursorVisiblity(Z)V
    .locals 2
    .param p1, "visible"    # Z

    .prologue
    .line 721
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-eqz v0, :cond_0

    .line 722
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderChanged:Z

    invoke-static {v0, p1, v1}, Lcom/android/mail/utils/Utils;->setConversationCursorVisibility(Landroid/database/Cursor;ZZ)V

    .line 725
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderChanged:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 727
    :cond_0
    monitor-exit p0

    return-void

    .line 721
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public isAnimating()Z
    .locals 3

    .prologue
    .line 2210
    const/4 v2, 0x0

    .line 2211
    .local v2, "isAnimating":Z
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v1

    .line 2212
    .local v1, "convListFragment":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz v1, :cond_0

    .line 2213
    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    .line 2214
    .local v0, "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    if-eqz v0, :cond_0

    .line 2215
    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->isAnimating()Z

    move-result v2

    .line 2218
    .end local v0    # "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    :cond_0
    return v2
.end method

.method protected abstract isConversationListVisible()Z
.end method

.method public isDestroyed()Z
    .locals 1

    .prologue
    .line 1302
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mDestroyed:Z

    return v0
.end method

.method public isInitialConversationLoading()Z
    .locals 1

    .prologue
    .line 2459
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationPagerController;->isInitialConversationLoading()Z

    move-result v0

    return v0
.end method

.method public loadAccountInbox()V
    .locals 1

    .prologue
    .line 599
    const/4 v0, 0x5

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    .line 600
    return-void
.end method

.method public markConversationMessagesUnread(Lcom/android/mail/providers/Conversation;Ljava/util/Set;Ljava/lang/String;)V
    .locals 12
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;
    .param p3, "originalConversationInfo"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/providers/Conversation;",
            "Ljava/util/Set",
            "<",
            "Landroid/net/Uri;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p2, "unreadMessageUris":Ljava/util/Set;, "Ljava/util/Set<Landroid/net/Uri;>;"
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 969
    const/4 v8, 0x0

    invoke-direct {p0, v8}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;)V

    .line 973
    iput-boolean v7, p1, Lcom/android/mail/providers/Conversation;->read:Z

    .line 975
    iget-object v8, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-nez v8, :cond_0

    .line 976
    sget-object v8, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v9, "null ConversationCursor in markConversationMessagesUnread"

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v8, v9, v7}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1018
    :goto_0
    return-void

    .line 981
    :cond_0
    if-nez p2, :cond_1

    move v6, v7

    .line 982
    .local v6, "unreadCount":I
    :goto_1
    invoke-virtual {p1}, Lcom/android/mail/providers/Conversation;->getNumMessages()I

    move-result v3

    .line 983
    .local v3, "numMessages":I
    if-le v3, v5, :cond_2

    if-lez v6, :cond_2

    if-ge v6, v3, :cond_2

    .line 986
    .local v5, "subsetIsUnread":Z
    :goto_2
    if-nez v5, :cond_3

    .line 989
    invoke-static {p1}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v8

    invoke-direct {p0, v8, v7, v7, v7}, Lcom/android/mail/ui/AbstractActivityController;->markConversationsRead(Ljava/util/Collection;ZZZ)V

    goto :goto_0

    .line 981
    .end local v3    # "numMessages":I
    .end local v5    # "subsetIsUnread":Z
    .end local v6    # "unreadCount":I
    :cond_1
    invoke-interface {p2}, Ljava/util/Set;->size()I

    move-result v6

    goto :goto_1

    .restart local v3    # "numMessages":I
    .restart local v6    # "unreadCount":I
    :cond_2
    move v5, v7

    .line 983
    goto :goto_2

    .line 991
    .restart local v5    # "subsetIsUnread":Z
    :cond_3
    iget-object v8, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v9, p1, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    sget-object v10, Lcom/android/mail/providers/UIProvider$ConversationColumns;->READ:Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v8, v9, v10, v11}, Lcom/android/mail/browse/ConversationCursor;->setConversationColumn(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Object;)V

    .line 994
    if-eqz p3, :cond_4

    .line 995
    iget-object v8, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v9, p1, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    const-string v10, "conversationInfo"

    invoke-virtual {v8, v9, v10, p3}, Lcom/android/mail/browse/ConversationCursor;->setConversationColumn(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Object;)V

    .line 1000
    :cond_4
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v4

    .line 1001
    .local v4, "ops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/content/ContentProviderOperation;>;"
    const/4 v0, 0x0

    .line 1002
    .local v0, "authority":Ljava/lang/String;
    invoke-interface {p2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    .line 1003
    .local v2, "messageUri":Landroid/net/Uri;
    if-nez v0, :cond_5

    .line 1004
    invoke-virtual {v2}, Landroid/net/Uri;->getAuthority()Ljava/lang/String;

    move-result-object v0

    .line 1006
    :cond_5
    invoke-static {v2}, Landroid/content/ContentProviderOperation;->newUpdate(Landroid/net/Uri;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v8

    sget-object v9, Lcom/android/mail/providers/UIProvider$MessageColumns;->READ:Ljava/lang/String;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Landroid/content/ContentProviderOperation$Builder;->withValue(Ljava/lang/String;Ljava/lang/Object;)Landroid/content/ContentProviderOperation$Builder;

    move-result-object v8

    invoke-virtual {v8}, Landroid/content/ContentProviderOperation$Builder;->build()Landroid/content/ContentProviderOperation;

    move-result-object v8

    invoke-virtual {v4, v8}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 1011
    .end local v2    # "messageUri":Landroid/net/Uri;
    :cond_6
    new-instance v7, Lcom/android/mail/ui/AbstractActivityController$5;

    invoke-direct {v7, p0}, Lcom/android/mail/ui/AbstractActivityController$5;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    iget-object v8, p0, Lcom/android/mail/ui/AbstractActivityController;->mResolver:Landroid/content/ContentResolver;

    invoke-virtual {v7, v8, v0, v4}, Lcom/android/mail/ui/AbstractActivityController$5;->run(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public markConversationsRead(Ljava/util/Collection;ZZ)V
    .locals 1
    .param p2, "read"    # Z
    .param p3, "viewed"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;ZZ)V"
        }
    .end annotation

    .prologue
    .line 1024
    .local p1, "targets":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/android/mail/ui/AbstractActivityController;->markConversationsRead(Ljava/util/Collection;ZZZ)V

    .line 1025
    return-void
.end method

.method public onAccessibilityStateChanged()V
    .locals 2

    .prologue
    .line 2883
    invoke-static {}, Lcom/android/mail/browse/ConversationItemViewModel;->onAccessibilityUpdated()V

    .line 2885
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v1

    .line 2886
    .local v1, "frag":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz v1, :cond_0

    .line 2887
    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    .line 2888
    .local v0, "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    if-eqz v0, :cond_0

    .line 2889
    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetInvalidated()V

    .line 2892
    .end local v0    # "adapter":Lcom/android/mail/ui/AnimatedAdapter;
    :cond_0
    return-void
.end method

.method public onAccountChanged(Lcom/android/mail/providers/Account;)V
    .locals 10
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 469
    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v6, :cond_6

    move v2, v4

    .line 470
    .local v2, "firstLoad":Z
    :goto_0
    sget-object v6, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v7, "onAccountChanged (%s) called. firstLoad=%s"

    const/4 v8, 0x2

    new-array v8, v8, [Ljava/lang/Object;

    aput-object p1, v8, v5

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    aput-object v9, v8, v4

    invoke-static {v6, v7, v8}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 471
    if-nez v2, :cond_0

    iget-object v6, p1, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v7, v7, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v6, v7}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_7

    :cond_0
    move v0, v4

    .line 472
    .local v0, "accountChanged":Z
    :goto_1
    if-nez v2, :cond_1

    iget-object v6, p1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v7, v7, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-virtual {v6, v7}, Lcom/android/mail/providers/Settings;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_8

    :cond_1
    move v3, v4

    .line 473
    .local v3, "settingsChanged":Z
    :goto_2
    if-nez v0, :cond_2

    if-eqz v3, :cond_5

    .line 474
    :cond_2
    if-eqz p1, :cond_3

    .line 475
    iget-object v1, p1, Landroid/accounts/Account;->name:Ljava/lang/String;

    .line 476
    .local v1, "accountName":Ljava/lang/String;
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mHandler:Landroid/os/Handler;

    new-instance v6, Lcom/android/mail/ui/AbstractActivityController$4;

    invoke-direct {v6, p0, v1}, Lcom/android/mail/ui/AbstractActivityController$4;-><init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/lang/String;)V

    invoke-virtual {v4, v6}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 483
    .end local v1    # "accountName":Ljava/lang/String;
    :cond_3
    if-eqz v0, :cond_4

    .line 484
    invoke-virtual {p0, v5}, Lcom/android/mail/ui/AbstractActivityController;->commitDestructiveActions(Z)V

    .line 486
    :cond_4
    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/AbstractActivityController;->switchAccount(Lcom/android/mail/providers/Account;Z)V

    .line 488
    :cond_5
    return-void

    .end local v0    # "accountChanged":Z
    .end local v2    # "firstLoad":Z
    .end local v3    # "settingsChanged":Z
    :cond_6
    move v2, v5

    .line 469
    goto :goto_0

    .restart local v2    # "firstLoad":Z
    :cond_7
    move v0, v5

    .line 471
    goto :goto_1

    .restart local v0    # "accountChanged":Z
    :cond_8
    move v3, v5

    .line 472
    goto :goto_2
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v0, 0x0

    const/4 v1, -0x1

    .line 692
    packed-switch p1, :pswitch_data_0

    .line 714
    :cond_0
    :goto_0
    return-void

    .line 695
    :pswitch_0
    if-ne p2, v1, :cond_1

    .line 697
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2, v0, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0

    .line 701
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->finish()V

    goto :goto_0

    .line 705
    :pswitch_1
    if-ne p2, v1, :cond_0

    .line 707
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v0, v1, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 708
    .local v0, "refreshUri":Landroid/net/Uri;
    :cond_2
    if-eqz v0, :cond_0

    .line 709
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->startAsyncRefreshTask(Landroid/net/Uri;)V

    goto :goto_0

    .line 692
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onAnimationEnd(Lcom/android/mail/ui/AnimatedAdapter;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2299
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-nez v0, :cond_1

    .line 2300
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "null ConversationCursor in onAnimationEnd"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2320
    :cond_0
    :goto_0
    return-void

    .line 2303
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->isRefreshReady()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2304
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Stopped animating: try sync"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2305
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->onRefreshReady()V

    .line 2308
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->isRefreshRequired()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 2309
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Stopped animating: refresh"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2310
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->refresh()Z

    .line 2312
    :cond_3
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentsDataUpdated:Z

    if-eqz v0, :cond_4

    .line 2313
    iput-boolean v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentsDataUpdated:Z

    .line 2314
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 2316
    :cond_4
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getFolderListFragment()Lcom/android/mail/ui/FolderListFragment;

    move-result-object v0

    .line 2317
    if-eqz v0, :cond_0

    .line 2318
    invoke-virtual {v0}, Lcom/android/mail/ui/FolderListFragment;->onAnimationEnd()V

    goto :goto_0
.end method

.method public onConversationListVisibilityChanged(Z)V
    .locals 0
    .param p1, "visible"    # Z

    .prologue
    .line 731
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->informCursorVisiblity(Z)V

    .line 732
    return-void
.end method

.method public onConversationSeen(Lcom/android/mail/providers/Conversation;)V
    .locals 1
    .param p1, "conv"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 2454
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationPagerController;->onConversationSeen(Lcom/android/mail/providers/Conversation;)V

    .line 2455
    return-void
.end method

.method public final onConversationSelected(Lcom/android/mail/providers/Conversation;Z)V
    .locals 1
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p2, "inLoaderCallbacks"    # Z

    .prologue
    .line 1573
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->commitDestructiveActions(Z)V

    .line 1574
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;Z)V

    .line 1575
    return-void
.end method

.method public onConversationVisibilityChanged(Z)V
    .locals 0
    .param p1, "visible"    # Z

    .prologue
    .line 740
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)Z
    .locals 6
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 744
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->initializeActionBar()V

    .line 746
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const/4 v4, 0x2

    invoke-interface {v3, v4}, Lcom/android/mail/ui/ControllableActivity;->setDefaultKeyMode(I)V

    .line 747
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mResolver:Landroid/content/ContentResolver;

    .line 748
    new-instance v3, Lcom/android/mail/ui/SuppressNotificationReceiver;

    invoke-direct {v3}, Lcom/android/mail/ui/SuppressNotificationReceiver;-><init>()V

    iput-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mNewEmailReceiver:Lcom/android/mail/ui/SuppressNotificationReceiver;

    .line 749
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-virtual {v3, v4}, Lcom/android/mail/ui/RecentFolderList;->initialize(Lcom/android/mail/ui/ControllableActivity;)V

    .line 754
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3, p0}, Lcom/android/mail/ui/ViewMode;->addListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V

    .line 755
    new-instance v3, Lcom/android/mail/browse/ConversationPagerController;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-direct {v3, v4, p0}, Lcom/android/mail/browse/ConversationPagerController;-><init>(Lcom/android/mail/ui/RestrictedActivity;Lcom/android/mail/ui/ActivityController;)V

    iput-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    .line 756
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v4, 0x7f1000d1

    invoke-interface {v3, v4}, Lcom/android/mail/ui/ControllableActivity;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/mail/ui/ActionableToastBar;

    iput-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    .line 757
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->attachActionBar()V

    .line 758
    invoke-static {}, Lcom/android/mail/ui/FolderSelectionDialog;->setDialogDismissed()V

    .line 760
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 765
    .local v1, "intent":Landroid/content/Intent;
    if-eqz p1, :cond_3

    .line 766
    const-string v3, "saved-account"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 767
    const-string v3, "saved-account"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Lcom/android/mail/providers/Account;

    invoke-direct {p0, v3}, Lcom/android/mail/ui/AbstractActivityController;->setAccount(Lcom/android/mail/providers/Account;)V

    .line 769
    :cond_0
    const-string v3, "saved-folder"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 770
    const-string v3, "saved-folder"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 771
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    const-string v3, "saved-query"

    invoke-virtual {p1, v3, v5}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 772
    .local v2, "query":Ljava/lang/String;
    invoke-direct {p0, v0, v2}, Lcom/android/mail/ui/AbstractActivityController;->setListContext(Lcom/android/mail/providers/Folder;Ljava/lang/String;)V

    .line 774
    .end local v0    # "folder":Lcom/android/mail/providers/Folder;
    .end local v2    # "query":Ljava/lang/String;
    :cond_1
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v3, p1}, Lcom/android/mail/ui/ViewMode;->handleRestore(Landroid/os/Bundle;)V

    .line 779
    :cond_2
    :goto_0
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4, v5, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 780
    const/4 v3, 0x1

    return v3

    .line 775
    :cond_3
    if-eqz v1, :cond_2

    .line 776
    invoke-direct {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->handleIntent(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method public onCreateDialog(ILandroid/os/Bundle;)Landroid/app/Dialog;
    .locals 1
    .param p1, "id"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 806
    const/4 v0, 0x0

    return-object v0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 1606
    packed-switch p1, :pswitch_data_0

    .line 1639
    :pswitch_0
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Loader returned unexpected id: %d"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    :cond_0
    move-object v0, v4

    .line 1641
    :goto_0
    return-object v0

    .line 1608
    :pswitch_1
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-static {}, Lcom/android/mail/providers/MailAppProvider;->getAccountsUri()Landroid/net/Uri;

    move-result-object v2

    sget-object v3, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1611
    :pswitch_2
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    .line 1613
    iget v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderItemUpdateDelayMs:I

    int-to-long v1, v1

    invoke-virtual {v0, v1, v2}, Landroid/content/CursorLoader;->setUpdateThrottle(J)V

    goto :goto_0

    .line 1616
    :pswitch_3
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    if-eqz v0, :cond_0

    .line 1617
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->recentFolderListUri:Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1622
    :pswitch_4
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-static {v0}, Lcom/android/mail/providers/Settings;->getDefaultInboxUri(Lcom/android/mail/providers/Settings;)Landroid/net/Uri;

    move-result-object v2

    .line 1623
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    invoke-virtual {v2, v0}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v0, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    .line 1625
    :cond_1
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Loading the default inbox: %s"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object v2, v3, v5

    invoke-static {v0, v1, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1626
    if-eqz v2, :cond_0

    .line 1627
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 1632
    :pswitch_5
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const-string v1, "query"

    invoke-virtual {p2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/android/mail/providers/Folder;->forSearchResults(Lcom/android/mail/providers/Account;Ljava/lang/String;Landroid/content/Context;)Landroid/content/CursorLoader;

    move-result-object v0

    goto :goto_0

    .line 1636
    :pswitch_6
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->ACCOUNTS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1606
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_0
        :pswitch_4
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method public final onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 811
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getMenuInflater()Landroid/view/MenuInflater;

    move-result-object v0

    .line 812
    .local v0, "inflater":Landroid/view/MenuInflater;
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1}, Lcom/android/mail/ui/MailActionBarView;->getOptionsMenuId()I

    move-result v1

    invoke-virtual {v0, v1, p1}, Landroid/view/MenuInflater;->inflate(ILandroid/view/Menu;)V

    .line 813
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1, p1}, Lcom/android/mail/ui/MailActionBarView;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    .line 814
    const/4 v1, 0x1

    return v1
.end method

.method public final onDataSetChanged()V
    .locals 2

    .prologue
    .line 2237
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->updateConversationListFragment()V

    .line 2238
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 2239
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ConversationSelectionSet;->validateAgainstCursor(Lcom/android/mail/browse/ConversationCursor;)V

    .line 2240
    return-void
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 1277
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationPagerController;->onDestroy()V

    .line 1278
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0}, Lcom/android/mail/ui/MailActionBarView;->onDestroy()V

    .line 1279
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderList:Lcom/android/mail/ui/RecentFolderList;

    invoke-virtual {v0}, Lcom/android/mail/ui/RecentFolderList;->destroy()V

    .line 1280
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mDestroyed:Z

    .line 1281
    return-void
.end method

.method public onFolderChanged(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 523
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/AbstractActivityController;->changeFolder(Lcom/android/mail/providers/Folder;Ljava/lang/String;)V

    .line 524
    return-void
.end method

.method public onFolderSelected(Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 559
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 560
    return-void
.end method

.method public onFooterViewErrorActionClick(Lcom/android/mail/providers/Folder;I)V
    .locals 4
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;
    .param p2, "errorStatus"    # I

    .prologue
    .line 2829
    const/4 v0, 0x0

    .line 2830
    .local v0, "uri":Landroid/net/Uri;
    packed-switch p2, :pswitch_data_0

    .line 2855
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 2832
    :pswitch_1
    if-eqz p1, :cond_1

    iget-object v1, p1, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    if-eqz v1, :cond_1

    .line 2833
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 2852
    :cond_1
    if-eqz v0, :cond_0

    .line 2853
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->startAsyncRefreshTask(Landroid/net/Uri;)V

    goto :goto_0

    .line 2837
    :pswitch_2
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-direct {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->promptUserForAuthentication(Lcom/android/mail/providers/Account;)V

    goto :goto_0

    .line 2842
    :pswitch_3
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->showStorageErrorDialog()V

    goto :goto_0

    .line 2845
    :pswitch_4
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/Utils;->sendFeedback(Landroid/content/Context;Lcom/android/mail/providers/Account;Z)V

    goto :goto_0

    .line 2830
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public onFooterViewLoadMoreClick(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 2859
    if-eqz p1, :cond_0

    iget-object v0, p1, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    if-eqz v0, :cond_0

    .line 2860
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->loadMoreUri:Landroid/net/Uri;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->startAsyncRefreshTask(Landroid/net/Uri;)V

    .line 2862
    :cond_0
    return-void
.end method

.method public final onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 820
    const/4 v0, 0x0

    return v0
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1828
    if-nez p2, :cond_0

    .line 1829
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Received null cursor from loader id: %d"

    new-array v4, v1, [Ljava/lang/Object;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v2

    invoke-static {v0, v3, v4}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1831
    :cond_0
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 1977
    :cond_1
    :goto_0
    :pswitch_0
    return-void

    .line 1833
    :pswitch_1
    if-eqz p2, :cond_1

    .line 1837
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_3

    .line 1844
    invoke-interface {p2}, Landroid/database/Cursor;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 1845
    const-string v3, "accounts_loaded"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    .line 1848
    :goto_1
    if-eqz v0, :cond_1

    .line 1849
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/android/mail/providers/MailAppProvider;->getNoAccountIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 1850
    if-eqz v0, :cond_1

    .line 1851
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2, v0, v1}, Lcom/android/mail/ui/ControllableActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    :cond_2
    move v0, v2

    .line 1845
    goto :goto_1

    .line 1856
    :cond_3
    invoke-direct {p0, p2}, Lcom/android/mail/ui/AbstractActivityController;->accountsUpdated(Landroid/database/Cursor;)Z

    move-result v0

    .line 1857
    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractActivityController;->isLoaderInitialized:Z

    if-eqz v1, :cond_4

    if-eqz v0, :cond_1

    .line 1858
    :cond_4
    invoke-direct {p0, p2}, Lcom/android/mail/ui/AbstractActivityController;->updateAccounts(Landroid/database/Cursor;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->isLoaderInitialized:Z

    goto :goto_0

    .line 1866
    :pswitch_2
    if-eqz p2, :cond_1

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1867
    new-instance v0, Lcom/android/mail/providers/Account;

    invoke-direct {v0, p2}, Lcom/android/mail/providers/Account;-><init>(Landroid/database/Cursor;)V

    .line 1869
    iget-object v3, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v4, v4, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_8

    .line 1871
    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    .line 1874
    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    .line 1875
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "AbstractActivityController.onLoadFinished(): mAccount = %s"

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v6, v6, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    aput-object v6, v1, v2

    invoke-static {v4, v5, v1}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1879
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-static {v1, v3}, Lcom/google/common/base/Objects;->equal(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 1880
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccountObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v1}, Landroid/database/DataSetObservable;->notifyChanged()V

    .line 1885
    :cond_5
    invoke-virtual {v0}, Lcom/android/mail/providers/Account;->isAccountInitializationRequired()Z

    move-result v1

    if-nez v1, :cond_1

    .line 1887
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->inWaitMode()Z

    move-result v1

    .line 1888
    invoke-virtual {v0}, Lcom/android/mail/providers/Account;->isAccountSyncRequired()Z

    move-result v2

    if-eqz v2, :cond_6

    if-nez v1, :cond_6

    .line 1890
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->showWaitForInitialization()V

    goto/16 :goto_0

    .line 1891
    :cond_6
    invoke-virtual {v0}, Lcom/android/mail/providers/Account;->isAccountSyncRequired()Z

    move-result v2

    if-nez v2, :cond_7

    .line 1892
    if-eqz v1, :cond_1

    .line 1894
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->hideWaitForInitialization()V

    goto/16 :goto_0

    .line 1896
    :cond_7
    invoke-virtual {v0}, Lcom/android/mail/providers/Account;->isAccountSyncRequired()Z

    move-result v0

    if-eqz v0, :cond_1

    if-eqz v1, :cond_1

    .line 1898
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->updateWaitMode()V

    goto/16 :goto_0

    .line 1902
    :cond_8
    sget-object v3, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Got update for account: %s with current account: %s"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    aput-object v0, v5, v2

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->uri:Landroid/net/Uri;

    aput-object v0, v5, v1

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1906
    const/4 v0, 0x7

    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->restartOptionalLoader(I)V

    goto/16 :goto_0

    .line 1912
    :pswitch_3
    if-eqz p2, :cond_9

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 1913
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0, p2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .line 1914
    sget-object v3, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v4, "FOLDER STATUS = %d"

    new-array v1, v1, [Ljava/lang/Object;

    iget v5, v0, Lcom/android/mail/providers/Folder;->syncStatus:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v1, v2

    invoke-static {v3, v4, v1}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1915
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->setHasFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 1916
    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    .line 1917
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0}, Landroid/database/DataSetObservable;->notifyChanged()V

    goto/16 :goto_0

    .line 1919
    :cond_9
    sget-object v3, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Unable to get the folder %s"

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    :goto_2
    aput-object v0, v1, v2

    invoke-static {v3, v4, v1}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_0

    :cond_a
    const-string v0, ""

    goto :goto_2

    .line 1931
    :pswitch_4
    if-eqz p2, :cond_b

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-gt v0, v1, :cond_b

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 1941
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->defaultRecentFolderListUri:Landroid/net/Uri;

    .line 1942
    sget-object v3, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Default recents at %s"

    new-array v5, v1, [Ljava/lang/Object;

    aput-object v0, v5, v2

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1943
    new-instance v3, Lcom/android/mail/ui/AbstractActivityController$1PopulateDefault;

    invoke-direct {v3, p0}, Lcom/android/mail/ui/AbstractActivityController$1PopulateDefault;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    new-array v1, v1, [Landroid/net/Uri;

    aput-object v0, v1, v2

    invoke-virtual {v3, v1}, Lcom/android/mail/ui/AbstractActivityController$1PopulateDefault;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 1946
    :cond_b
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Reading recent folders from the cursor."

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1947
    invoke-direct {p0, p2}, Lcom/android/mail/ui/AbstractActivityController;->loadRecentFolders(Landroid/database/Cursor;)V

    goto/16 :goto_0

    .line 1950
    :pswitch_5
    if-eqz p2, :cond_c

    invoke-interface {p2}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_c

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 1951
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0, p2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .line 1952
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->onFolderChanged(Lcom/android/mail/providers/Folder;)V

    .line 1955
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    goto/16 :goto_0

    .line 1957
    :cond_c
    sget-object v3, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Unable to get the account inbox for account %s"

    new-array v1, v1, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_d

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    :goto_3
    aput-object v0, v1, v2

    invoke-static {v3, v4, v1}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_0

    :cond_d
    const-string v0, ""

    goto :goto_3

    .line 1962
    :pswitch_6
    if-eqz p2, :cond_e

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_e

    .line 1963
    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    .line 1964
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0, p2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .line 1965
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->updateFolder(Lcom/android/mail/providers/Folder;)V

    .line 1966
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/ControllableActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string v3, "query"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/android/mail/ConversationListContext;->forSearchQuery(Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;Ljava/lang/String;)Lcom/android/mail/ConversationListContext;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    .line 1969
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->showConversationList(Lcom/android/mail/ConversationListContext;)V

    .line 1970
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 1971
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    goto/16 :goto_0

    .line 1973
    :cond_e
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Null or empty cursor returned by LOADER_SEARCH loader"

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_0

    .line 1831
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_4
        :pswitch_0
        :pswitch_5
        :pswitch_6
        :pswitch_2
    .end packed-switch
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 116
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/AbstractActivityController;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 1647
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public final onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 13
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 825
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v10

    .line 826
    .local v10, "id":I
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v2, "AbstractController.onOptionsItemSelected(%d) called."

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 827
    const/4 v9, 0x1

    .line 828
    .local v9, "handled":Z
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-static {v0}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v1

    .line 829
    .local v1, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v0, :cond_1

    const/4 v11, 0x0

    .line 832
    .local v11, "settings":Lcom/android/mail/providers/Settings;
    :goto_0
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->commitDestructiveActions(Z)V

    .line 833
    sparse-switch v10, :sswitch_data_0

    .line 931
    const/4 v9, 0x0

    .line 934
    :cond_0
    :goto_1
    return v9

    .line 829
    .end local v11    # "settings":Lcom/android/mail/providers/Settings;
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v11, v0, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    goto :goto_0

    .line 835
    .restart local v11    # "settings":Lcom/android/mail/providers/Settings;
    :sswitch_0
    if-eqz v11, :cond_2

    iget-boolean v0, v11, Lcom/android/mail/providers/Settings;->confirmArchive:Z

    if-eqz v0, :cond_2

    const/4 v12, 0x1

    .line 836
    .local v12, "showDialog":Z
    :goto_2
    const v0, 0x7f110004

    const v2, 0x7f100123

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v1, v12, v0, v2}, Lcom/android/mail/ui/AbstractActivityController;->confirmAndDelete(Ljava/util/Collection;ZILcom/android/mail/ui/DestructiveAction;)V

    goto :goto_1

    .line 835
    .end local v12    # "showDialog":Z
    :cond_2
    const/4 v12, 0x0

    goto :goto_2

    .line 841
    :sswitch_1
    const v6, 0x7f100124

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    const/4 v3, 0x1

    const/4 v4, 0x0

    const/4 v5, 0x1

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredRemoveFolder(Ljava/util/Collection;Lcom/android/mail/providers/Folder;ZZZ)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v0

    invoke-virtual {p0, v6, v1, v0}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto :goto_1

    .line 845
    :sswitch_2
    if-eqz v11, :cond_3

    iget-boolean v0, v11, Lcom/android/mail/providers/Settings;->confirmDelete:Z

    if-eqz v0, :cond_3

    const/4 v12, 0x1

    .line 846
    .restart local v12    # "showDialog":Z
    :goto_3
    const v0, 0x7f110003

    const v2, 0x7f100125

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v1, v12, v0, v2}, Lcom/android/mail/ui/AbstractActivityController;->confirmAndDelete(Ljava/util/Collection;ZILcom/android/mail/ui/DestructiveAction;)V

    goto :goto_1

    .line 845
    .end local v12    # "showDialog":Z
    :cond_3
    const/4 v12, 0x0

    goto :goto_3

    .line 851
    :sswitch_3
    if-eqz v11, :cond_4

    iget-boolean v0, v11, Lcom/android/mail/providers/Settings;->confirmDelete:Z

    if-eqz v0, :cond_4

    const/4 v12, 0x1

    .line 852
    .restart local v12    # "showDialog":Z
    :goto_4
    const v0, 0x7f110005

    const v2, 0x7f100126

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v1, v12, v0, v2}, Lcom/android/mail/ui/AbstractActivityController;->confirmAndDelete(Ljava/util/Collection;ZILcom/android/mail/ui/DestructiveAction;)V

    goto :goto_1

    .line 851
    .end local v12    # "showDialog":Z
    :cond_4
    const/4 v12, 0x0

    goto :goto_4

    .line 857
    :sswitch_4
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-static {v0}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v0

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {p0, v0, v2, v3}, Lcom/android/mail/ui/AbstractActivityController;->updateConversation(Ljava/util/Collection;Ljava/lang/String;I)V

    goto :goto_1

    .line 861
    :sswitch_5
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0}, Lcom/android/mail/providers/Folder;->isImportantOnly()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 862
    const v0, 0x7f10012a

    const v2, 0x7f10012a

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_1

    .line 865
    :cond_5
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-static {v0}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v0

    sget-object v2, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {p0, v0, v2, v3}, Lcom/android/mail/ui/AbstractActivityController;->updateConversation(Ljava/util/Collection;Ljava/lang/String;I)V

    goto/16 :goto_1

    .line 870
    :sswitch_6
    const v0, 0x7f10012b

    const v2, 0x7f10012b

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_1

    .line 873
    :sswitch_7
    const v0, 0x7f10012c

    const v2, 0x7f10012c

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_1

    .line 880
    :sswitch_8
    const v0, 0x7f10012d

    const v2, 0x7f10012d

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_1

    .line 884
    :sswitch_9
    const v0, 0x7f10012e

    const v2, 0x7f10012e

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v1, v3}, Lcom/android/mail/ui/AbstractActivityController;->getDeferredAction(ILjava/util/Collection;Z)Lcom/android/mail/ui/DestructiveAction;

    move-result-object v2

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    goto/16 :goto_1

    .line 888
    :sswitch_a
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->onUpPressed()Z

    goto/16 :goto_1

    .line 891
    :sswitch_b
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v0, v2}, Lcom/android/mail/compose/ComposeActivity;->compose(Landroid/content/Context;Lcom/android/mail/providers/Account;)V

    goto/16 :goto_1

    .line 894
    :sswitch_c
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->showFolderList()V

    goto/16 :goto_1

    .line 897
    :sswitch_d
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->requestFolderRefresh()V

    goto/16 :goto_1

    .line 900
    :sswitch_e
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v0, v2}, Lcom/android/mail/utils/Utils;->showSettings(Landroid/content/Context;Lcom/android/mail/providers/Account;)V

    goto/16 :goto_1

    .line 903
    :sswitch_f
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/Utils;->showFolderSettings(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/providers/Folder;)V

    goto/16 :goto_1

    .line 906
    :sswitch_10
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getHelpContext()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/Utils;->showHelp(Landroid/content/Context;Lcom/android/mail/providers/Account;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 909
    :sswitch_11
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/4 v3, 0x0

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/Utils;->sendFeedback(Landroid/content/Context;Lcom/android/mail/providers/Account;Z)V

    goto/16 :goto_1

    .line 912
    :sswitch_12
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-static {v0, v2}, Lcom/android/mail/utils/Utils;->showManageFolder(Landroid/content/Context;Lcom/android/mail/providers/Account;)V

    goto/16 :goto_1

    .line 916
    :sswitch_13
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v2, 0x2000

    invoke-virtual {v0, v2}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 918
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-static {v0}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v5

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    move-object v4, p0

    invoke-static/range {v2 .. v7}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->getInstance(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    move-result-object v8

    .line 926
    .local v8, "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    :goto_5
    if-eqz v8, :cond_0

    .line 927
    invoke-virtual {v8}, Lcom/android/mail/ui/FolderSelectionDialog;->show()V

    goto/16 :goto_1

    .line 922
    .end local v8    # "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    :cond_6
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v2

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-static {v0}, Lcom/android/mail/providers/Conversation;->listOf(Lcom/android/mail/providers/Conversation;)Ljava/util/Collection;

    move-result-object v5

    const/4 v6, 0x0

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    move-object v4, p0

    invoke-static/range {v2 .. v7}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->getInstance(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)Lcom/android/mail/ui/SingleFolderSelectionDialog;

    move-result-object v8

    .restart local v8    # "dialog":Lcom/android/mail/ui/FolderSelectionDialog;
    goto :goto_5

    .line 833
    nop

    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_a
        0x7f100003 -> :sswitch_12
        0x7f10003f -> :sswitch_b
        0x7f100120 -> :sswitch_e
        0x7f100121 -> :sswitch_11
        0x7f100122 -> :sswitch_10
        0x7f100123 -> :sswitch_0
        0x7f100124 -> :sswitch_1
        0x7f100125 -> :sswitch_2
        0x7f100126 -> :sswitch_3
        0x7f100127 -> :sswitch_13
        0x7f100129 -> :sswitch_4
        0x7f10012a -> :sswitch_5
        0x7f10012b -> :sswitch_6
        0x7f10012c -> :sswitch_7
        0x7f10012d -> :sswitch_8
        0x7f10012e -> :sswitch_9
        0x7f100130 -> :sswitch_d
        0x7f100131 -> :sswitch_f
        0x7f100132 -> :sswitch_c
    .end sparse-switch
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 1202
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->isLoaderInitialized:Z

    .line 1203
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->enableNotifications()V

    .line 1204
    return-void
.end method

.method public onPrepareDialog(ILandroid/app/Dialog;Landroid/os/Bundle;)V
    .locals 0
    .param p1, "id"    # I
    .param p2, "dialog"    # Landroid/app/Dialog;
    .param p3, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 1193
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 1197
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/MailActionBarView;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public final onRefreshReady()V
    .locals 1

    .prologue
    .line 2228
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->isAnimating()Z

    move-result v0

    if-nez v0, :cond_0

    .line 2230
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->sync()V

    .line 2232
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationPositionTracker;->onCursorUpdated()V

    .line 2233
    return-void
.end method

.method public final onRefreshRequired()V
    .locals 3

    .prologue
    .line 2175
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->isAnimating()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->isDragging()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 2176
    :cond_0
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "onRefreshRequired: delay until animating done"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2183
    :cond_1
    :goto_0
    return-void

    .line 2180
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->isRefreshRequired()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2181
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->refresh()Z

    goto :goto_0
.end method

.method public onRestart()V
    .locals 3

    .prologue
    .line 790
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFragmentManager:Landroid/app/FragmentManager;

    const-string v2, "SyncErrorDialogFragment"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Landroid/app/DialogFragment;

    .line 792
    .local v0, "fragment":Landroid/app/DialogFragment;
    if-eqz v0, :cond_0

    .line 793
    invoke-virtual {v0}, Landroid/app/DialogFragment;->dismiss()V

    .line 799
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    if-eqz v1, :cond_1

    .line 800
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/ActionableToastBar;->hide(Z)V

    .line 802
    :cond_1
    return-void
.end method

.method public onRestoreInstanceState(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 1360
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "IN AAC.onRestoreInstanceState"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1361
    const-string v0, "saved-conversation"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1363
    const-string v0, "saved-conversation"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 1365
    if-eqz v0, :cond_0

    iget v1, v0, Lcom/android/mail/providers/Conversation;->position:I

    if-gez v1, :cond_0

    .line 1368
    iput v3, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 1370
    :cond_0
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;)V

    .line 1373
    :cond_1
    const-string v0, "saved-toast-bar-op"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1374
    const-string v0, "saved-toast-bar-op"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ToastBarOperation;

    .line 1376
    if-eqz v0, :cond_2

    .line 1377
    invoke-virtual {v0}, Lcom/android/mail/ui/ToastBarOperation;->getType()I

    move-result v1

    if-nez v1, :cond_5

    .line 1378
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V

    .line 1384
    :cond_2
    :goto_0
    const-string v0, "saved-hierarchical-folder"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 1385
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 1386
    invoke-static {v0}, Lcom/android/mail/providers/Folder;->fromString(Ljava/lang/String;)Lcom/android/mail/providers/Folder;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderListFolder:Lcom/android/mail/providers/Folder;

    .line 1388
    :cond_3
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 1389
    if-eqz v0, :cond_4

    .line 1390
    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->onRestoreInstanceState(Landroid/os/Bundle;)V

    .line 1398
    :cond_4
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->restoreSelectedConversations(Landroid/os/Bundle;)V

    .line 1399
    return-void

    .line 1379
    :cond_5
    invoke-virtual {v0}, Lcom/android/mail/ui/ToastBarOperation;->getType()I

    move-result v0

    if-ne v0, v4, :cond_2

    .line 1380
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v0, v4}, Lcom/android/mail/ui/AbstractActivityController;->onError(Lcom/android/mail/providers/Folder;Z)V

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 1212
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->disableNotifications()V

    .line 1214
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSafeToModifyFragments:Z

    .line 1215
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1219
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/ViewMode;->handleSaveInstanceState(Landroid/os/Bundle;)V

    .line 1220
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v0, :cond_0

    .line 1221
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Saving the account now"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1222
    const-string v0, "saved-account"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1224
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_1

    .line 1225
    const-string v0, "saved-folder"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1228
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v0}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1229
    const-string v0, "saved-query"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mConvListContext:Lcom/android/mail/ConversationListContext;

    iget-object v1, v1, Lcom/android/mail/ConversationListContext;->searchQuery:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1231
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->isConversationMode()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1232
    const-string v0, "saved-conversation"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1234
    :cond_3
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1235
    const-string v0, "saved-selected-set"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1237
    :cond_4
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0}, Lcom/android/mail/ui/ActionableToastBar;->getVisibility()I

    move-result v0

    if-nez v0, :cond_5

    .line 1238
    const-string v0, "saved-toast-bar-op"

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v1}, Lcom/android/mail/ui/ActionableToastBar;->getOperation()Lcom/android/mail/ui/ToastBarOperation;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1240
    :cond_5
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 1241
    if-eqz v0, :cond_6

    .line 1242
    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/AnimatedAdapter;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 1244
    :cond_6
    iput-boolean v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mSafeToModifyFragments:Z

    .line 1245
    const-string v1, "saved-hierarchical-folder"

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderListFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderListFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->toString(Lcom/android/mail/providers/Folder;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1247
    return-void

    .line 1245
    :cond_7
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onSearchRequested(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1258
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 1259
    const-string v1, "android.intent.action.SEARCH"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1260
    const-string v1, "query"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1261
    const-string v1, "account"

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 1262
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getComponentName()Landroid/content/ComponentName;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 1263
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v1}, Lcom/android/mail/ui/MailActionBarView;->collapseSearch()V

    .line 1264
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1, v0}, Lcom/android/mail/ui/ControllableActivity;->startActivity(Landroid/content/Intent;)V

    .line 1265
    return-void
.end method

.method public onSetChanged(Lcom/android/mail/ui/ConversationSelectionSet;)V
    .locals 0
    .param p1, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;

    .prologue
    .line 2340
    return-void
.end method

.method public onSetEmpty()V
    .locals 0

    .prologue
    .line 2324
    return-void
.end method

.method public onSetPopulated(Lcom/android/mail/ui/ConversationSelectionSet;)V
    .locals 5
    .param p1, "set"    # Lcom/android/mail/ui/ConversationSelectionSet;

    .prologue
    .line 2328
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 2329
    .local v0, "convList":Lcom/android/mail/ui/ConversationListFragment;
    if-nez v0, :cond_0

    .line 2335
    :goto_0
    return-void

    .line 2332
    :cond_0
    new-instance v2, Lcom/android/mail/browse/SelectedConversationsActionMenu;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->getListView()Landroid/widget/ListView;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/SwipeableListView;

    invoke-direct {v2, v3, p1, v4, v1}, Lcom/android/mail/browse/SelectedConversationsActionMenu;-><init>(Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/SwipeableListView;)V

    iput-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mCabActionMenu:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    .line 2334
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->enableCabMode()V

    goto :goto_0
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 785
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSafeToModifyFragments:Z

    .line 786
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 1269
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mEnableShareIntents:Landroid/os/AsyncTask;

    if-eqz v0, :cond_0

    .line 1270
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mEnableShareIntents:Landroid/os/AsyncTask;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/AsyncTask;->cancel(Z)Z

    .line 1272
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)V
    .locals 2
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 2445
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_0

    .line 2446
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/ActionableToastBar;->isEventInToastBar(Landroid/view/MotionEvent;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2447
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ActionableToastBar;->hide(Z)V

    .line 2450
    :cond_0
    return-void
.end method

.method public onViewModeChanged(I)V
    .locals 1
    .param p1, "newMode"    # I

    .prologue
    .line 1292
    invoke-static {p1}, Lcom/android/mail/ui/ViewMode;->isConversationMode(I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1293
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    .line 1295
    :cond_0
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 2
    .param p1, "hasFocus"    # Z

    .prologue
    .line 1315
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 1316
    .local v0, "convList":Lcom/android/mail/ui/ConversationListFragment;
    if-eqz p1, :cond_0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1318
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/AbstractActivityController;->informCursorVisiblity(Z)V

    .line 1320
    :cond_0
    return-void
.end method

.method public final refreshConversationList()V
    .locals 1

    .prologue
    .line 2692
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getConversationListFragment()Lcom/android/mail/ui/ConversationListFragment;

    move-result-object v0

    .line 2693
    .local v0, "convList":Lcom/android/mail/ui/ConversationListFragment;
    if-nez v0, :cond_0

    .line 2697
    :goto_0
    return-void

    .line 2696
    :cond_0
    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListFragment;->requestListRefresh()V

    goto :goto_0
.end method

.method public registerAccountObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "obs"    # Landroid/database/DataSetObserver;

    .prologue
    .line 497
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccountObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 498
    return-void
.end method

.method public registerConversationListObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1669
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 1670
    return-void
.end method

.method public registerConversationLoadedObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1689
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationPagerController;->registerConversationLoadedObserver(Landroid/database/DataSetObserver;)V

    .line 1690
    return-void
.end method

.method public registerFolderObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1679
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 1680
    return-void
.end method

.method public registerRecentFolderObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "obs"    # Landroid/database/DataSetObserver;

    .prologue
    .line 578
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->registerObserver(Ljava/lang/Object;)V

    .line 579
    return-void
.end method

.method protected safeToModifyFragments()Z
    .locals 1

    .prologue
    .line 1253
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mSafeToModifyFragments:Z

    return v0
.end method

.method public setCurrentConversation(Lcom/android/mail/providers/Conversation;)V
    .locals 2
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;

    .prologue
    .line 1591
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ConversationPositionTracker;->initialize(Lcom/android/mail/providers/Conversation;)V

    .line 1592
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    .line 1594
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    if-eqz v0, :cond_0

    .line 1595
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MailActionBarView;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    .line 1596
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->getSubjectDisplayChanger()Lcom/android/mail/ui/SubjectDisplayChanger;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    iget-object v1, v1, Lcom/android/mail/providers/Conversation;->subject:Ljava/lang/String;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/SubjectDisplayChanger;->setSubject(Ljava/lang/String;)V

    .line 1597
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->invalidateOptionsMenu()V

    .line 1599
    :cond_0
    return-void
.end method

.method public setHierarchyFolder(Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 687
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderListFolder:Lcom/android/mail/providers/Folder;

    .line 688
    return-void
.end method

.method protected showConversation(Lcom/android/mail/providers/Conversation;Z)V
    .locals 0
    .param p1, "conversation"    # Lcom/android/mail/providers/Conversation;
    .param p2, "inLoaderCallbacks"    # Z

    .prologue
    .line 1513
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->setCurrentConversation(Lcom/android/mail/providers/Conversation;)V

    .line 1518
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->updateRecentFolderList()V

    .line 1519
    return-void
.end method

.method public showConversationList(Lcom/android/mail/ConversationListContext;)V
    .locals 0
    .param p1, "listContext"    # Lcom/android/mail/ConversationListContext;

    .prologue
    .line 1567
    return-void
.end method

.method protected final showErrorToast(Lcom/android/mail/providers/Folder;Z)V
    .locals 8

    .prologue
    const/4 v6, 0x1

    const/4 v4, 0x0

    .line 2727
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    invoke-virtual {v0, v4}, Lcom/android/mail/ui/ActionableToastBar;->setConversationMode(Z)V

    .line 2731
    iget v3, p1, Lcom/android/mail/providers/Folder;->lastSyncResult:I

    .line 2732
    and-int/lit8 v0, v3, 0xf

    packed-switch v0, :pswitch_data_0

    .line 2775
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 2735
    :pswitch_1
    shr-int/lit8 v1, v3, 0x4

    .line 2740
    and-int/lit8 v0, v1, 0x1

    if-eqz v0, :cond_2

    move v0, v6

    .line 2743
    :goto_1
    if-nez v0, :cond_3

    iget v0, p1, Lcom/android/mail/providers/Folder;->syncWindow:I

    if-gtz v0, :cond_1

    and-int/lit8 v0, v1, 0x4

    if-eqz v0, :cond_3

    :cond_1
    move v0, v6

    .line 2745
    :goto_2
    if-nez v0, :cond_0

    .line 2748
    invoke-direct {p0, p1}, Lcom/android/mail/ui/AbstractActivityController;->getRetryClickedListener(Lcom/android/mail/providers/Folder;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    move-result-object v1

    .line 2749
    const v5, 0x7f0c0001

    .line 2768
    :goto_3
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mToastBar:Lcom/android/mail/ui/ActionableToastBar;

    const v2, 0x7f02002e

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v7}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v3}, Lcom/android/mail/utils/Utils;->getSyncStatusText(Landroid/content/Context;I)Ljava/lang/CharSequence;

    move-result-object v3

    new-instance v7, Lcom/android/mail/ui/ToastBarOperation;

    invoke-direct {v7, v6, v4, v6, v4}, Lcom/android/mail/ui/ToastBarOperation;-><init>(IIIZ)V

    move v6, p2

    invoke-virtual/range {v0 .. v7}, Lcom/android/mail/ui/ActionableToastBar;->show(Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;ILjava/lang/CharSequence;ZIZLcom/android/mail/ui/ToastBarOperation;)V

    goto :goto_0

    :cond_2
    move v0, v4

    .line 2740
    goto :goto_1

    :cond_3
    move v0, v4

    .line 2743
    goto :goto_2

    .line 2752
    :pswitch_2
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->getSignInClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    move-result-object v1

    .line 2753
    const v5, 0x7f0c00f5

    .line 2754
    goto :goto_3

    .line 2758
    :pswitch_3
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->getStorageErrorClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    move-result-object v1

    .line 2759
    const v5, 0x7f0c00f6

    .line 2760
    goto :goto_3

    .line 2762
    :pswitch_4
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController;->getInternalErrorClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;

    move-result-object v1

    .line 2763
    const v5, 0x7f0c00f7

    .line 2764
    goto :goto_3

    .line 2732
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public showNextConversation(Ljava/util/Collection;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 1070
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    invoke-static {p1, v0}, Lcom/android/mail/providers/Conversation;->contains(Ljava/util/Collection;Lcom/android/mail/providers/Conversation;)Z

    move-result v0

    if-eqz v0, :cond_1

    move v0, v1

    .line 1072
    :goto_0
    if-eqz v0, :cond_0

    .line 1073
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mTracker:Lcom/android/mail/ui/ConversationPositionTracker;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v3, v3, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-static {v3}, Lcom/android/mail/providers/Settings;->getAutoAdvanceSetting(Lcom/android/mail/providers/Settings;)I

    move-result v3

    invoke-virtual {v0, v3, p1}, Lcom/android/mail/ui/ConversationPositionTracker;->getNextConversation(ILjava/util/Collection;)Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 1075
    sget-object v3, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v4, "showNextConversation: showing %s next."

    new-array v1, v1, [Ljava/lang/Object;

    aput-object v0, v1, v2

    invoke-static {v3, v4, v1}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 1076
    invoke-direct {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->showConversation(Lcom/android/mail/providers/Conversation;)V

    .line 1078
    :cond_0
    return-void

    :cond_1
    move v0, v2

    .line 1070
    goto :goto_0
.end method

.method public showWaitForInitialization()V
    .locals 1

    .prologue
    .line 1527
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mViewMode:Lcom/android/mail/ui/ViewMode;

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->enterWaitingForInitializationMode()Z

    .line 1528
    return-void
.end method

.method public starMessage(Lcom/android/mail/browse/MessageCursor$ConversationMessage;Z)V
    .locals 9
    .param p1, "msg"    # Lcom/android/mail/browse/MessageCursor$ConversationMessage;
    .param p2, "starred"    # Z

    .prologue
    const/4 v4, 0x0

    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 1082
    iget-boolean v2, p1, Lcom/android/mail/providers/Message;->starred:Z

    if-ne v2, p2, :cond_0

    .line 1108
    :goto_0
    return-void

    .line 1086
    :cond_0
    iput-boolean p2, p1, Lcom/android/mail/providers/Message;->starred:Z

    .line 1092
    if-nez p2, :cond_1

    invoke-virtual {p1}, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->isConversationStarred()Z

    move-result v2

    if-eqz v2, :cond_3

    :cond_1
    move v6, v1

    .line 1093
    .local v6, "conversationStarred":Z
    :goto_1
    iget-object v2, p1, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->conversation:Lcom/android/mail/providers/Conversation;

    iget-boolean v2, v2, Lcom/android/mail/providers/Conversation;->starred:Z

    if-eq v6, v2, :cond_2

    .line 1094
    iget-object v2, p1, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->conversation:Lcom/android/mail/providers/Conversation;

    iput-boolean v6, v2, Lcom/android/mail/providers/Conversation;->starred:Z

    .line 1095
    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p1, Lcom/android/mail/browse/MessageCursor$ConversationMessage;->conversation:Lcom/android/mail/providers/Conversation;

    iget-object v5, v5, Lcom/android/mail/providers/Conversation;->uri:Landroid/net/Uri;

    sget-object v7, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-virtual {v2, v5, v7, v8}, Lcom/android/mail/browse/ConversationCursor;->setConversationColumn(Landroid/net/Uri;Ljava/lang/String;Ljava/lang/Object;)V

    .line 1099
    :cond_2
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3, v1}, Landroid/content/ContentValues;-><init>(I)V

    .line 1100
    .local v3, "values":Landroid/content/ContentValues;
    sget-object v2, Lcom/android/mail/providers/UIProvider$MessageColumns;->STARRED:Ljava/lang/String;

    if-eqz p2, :cond_4

    :goto_2
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v3, v2, v0}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1102
    new-instance v0, Lcom/android/mail/ui/AbstractActivityController$6;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/AbstractActivityController$6;-><init>(Lcom/android/mail/ui/AbstractActivityController;)V

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mResolver:Landroid/content/ContentResolver;

    iget-object v2, p1, Lcom/android/mail/providers/Message;->uri:Landroid/net/Uri;

    move-object v5, v4

    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/ui/AbstractActivityController$6;->run(Landroid/content/ContentResolver;Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0

    .end local v3    # "values":Landroid/content/ContentValues;
    .end local v6    # "conversationStarred":Z
    :cond_3
    move v6, v0

    .line 1092
    goto :goto_1

    .restart local v3    # "values":Landroid/content/ContentValues;
    .restart local v6    # "conversationStarred":Z
    :cond_4
    move v1, v0

    .line 1100
    goto :goto_2
.end method

.method public startDragMode()V
    .locals 1

    .prologue
    .line 2187
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mIsDragHappening:Z

    .line 2188
    return-void
.end method

.method public startSearch()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2376
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    if-nez v0, :cond_0

    .line 2378
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "AbstractActivityController.startSearch(): null account"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2388
    :goto_0
    return-void

    .line 2381
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v1, 0x800

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v2, 0x20

    invoke-virtual {v1, v2}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v1

    or-int/2addr v0, v1

    if-eqz v0, :cond_1

    .line 2383
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActionBarView:Lcom/android/mail/ui/MailActionBarView;

    invoke-virtual {v0}, Lcom/android/mail/ui/MailActionBarView;->getQuery()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/AbstractActivityController;->onSearchRequested(Ljava/lang/String;)V

    goto :goto_0

    .line 2385
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0c00a4

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method

.method public stopDragMode()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 2192
    iput-boolean v3, p0, Lcom/android/mail/ui/AbstractActivityController;->mIsDragHappening:Z

    .line 2193
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->isRefreshReady()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 2194
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Stopped animating: try sync"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2195
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->onRefreshReady()V

    .line 2198
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->isRefreshRequired()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2199
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Stopped animating: refresh"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2200
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->refresh()Z

    .line 2202
    :cond_1
    return-void
.end method

.method public supportsDrag(Landroid/view/DragEvent;Lcom/android/mail/providers/Folder;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/DragEvent;
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 2402
    if-eqz p2, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/view/DragEvent;->getClipDescription()Landroid/content/ClipDescription;

    move-result-object v0

    if-eqz v0, :cond_0

    const/16 v0, 0x8

    invoke-virtual {p2, v0}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x4

    invoke-virtual {p2, v0}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v0, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v1, p2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v0, v1}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public unregisterAccountObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "obs"    # Landroid/database/DataSetObserver;

    .prologue
    .line 506
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccountObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 507
    return-void
.end method

.method public unregisterConversationListObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1674
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 1675
    return-void
.end method

.method public unregisterConversationLoadedObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1694
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mPagerController:Lcom/android/mail/browse/ConversationPagerController;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationPagerController;->unregisterConversationLoadedObserver(Landroid/database/DataSetObserver;)V

    .line 1695
    return-void
.end method

.method public unregisterFolderObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 1684
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mFolderObservable:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 1685
    return-void
.end method

.method public unregisterRecentFolderObserver(Landroid/database/DataSetObserver;)V
    .locals 1
    .param p1, "obs"    # Landroid/database/DataSetObserver;

    .prologue
    .line 587
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mRecentFolderObservers:Landroid/database/DataSetObservable;

    invoke-virtual {v0, p1}, Landroid/database/DataSetObservable;->unregisterObserver(Ljava/lang/Object;)V

    .line 588
    return-void
.end method

.method public updateConversation(Ljava/util/Collection;Ljava/lang/String;I)V
    .locals 2
    .param p2, "columnName"    # Ljava/lang/String;
    .param p3, "value"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    .line 953
    .local p1, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p1, p2, p3}, Lcom/android/mail/browse/ConversationCursor;->updateInt(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;I)I

    .line 954
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->refreshConversationList()V

    .line 955
    return-void
.end method

.method public updateConversation(Ljava/util/Collection;Ljava/lang/String;Z)V
    .locals 2
    .param p2, "columnName"    # Ljava/lang/String;
    .param p3, "value"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 946
    .local p1, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    invoke-virtual {v0, v1, p1, p2, p3}, Lcom/android/mail/browse/ConversationCursor;->updateBoolean(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Z)I

    .line 947
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractActivityController;->refreshConversationList()V

    .line 948
    return-void
.end method

.method public updateWaitMode()V
    .locals 2

    .prologue
    .line 1536
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 1537
    const-string v1, "wait-fragment"

    invoke-virtual {v0, v1}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/WaitFragment;

    .line 1539
    if-eqz v0, :cond_0

    .line 1540
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/WaitFragment;->updateAccount(Lcom/android/mail/providers/Account;)V

    .line 1542
    :cond_0
    return-void
.end method
