.class public final Lcom/android/mail/ui/ConversationListFragment;
.super Landroid/app/ListFragment;
.source "ConversationListFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemLongClickListener;
.implements Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;
.implements Lcom/android/mail/ui/ViewMode$ModeChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;,
        Lcom/android/mail/ui/ConversationListFragment$FolderObserver;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static TIMESTAMP_UPDATE_INTERVAL:I

.field private static mTabletDevice:Z


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private final mAccountObserver:Lcom/android/mail/providers/AccountObserver;

.field private mActivity:Lcom/android/mail/ui/ControllableActivity;

.field private mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

.field private mConversationCursorHash:I

.field private mConversationListStatusObserver:Landroid/database/DataSetObserver;

.field private mEmptyView:Landroid/view/View;

.field private mErrorListener:Lcom/android/mail/ui/ErrorListener;

.field private mFolder:Lcom/android/mail/providers/Folder;

.field private mFolderObserver:Landroid/database/DataSetObserver;

.field private mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

.field private final mHandler:Landroid/os/Handler;

.field private mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

.field private mListView:Lcom/android/mail/ui/SwipeableListView;

.field private mSearchResultCountTextView:Landroid/widget/TextView;

.field private mSearchStatusTextView:Landroid/widget/TextView;

.field private mSearchStatusView:Landroid/view/View;

.field private mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

.field private mUpdateTimestampsRunnable:Ljava/lang/Runnable;

.field private mUpdater:Lcom/android/mail/ui/ConversationUpdater;

.field private mViewContext:Lcom/android/mail/ConversationListContext;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 73
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/ConversationListFragment;->LOG_TAG:Ljava/lang/String;

    .line 82
    const/4 v0, 0x0

    sput v0, Lcom/android/mail/ui/ConversationListFragment;->TIMESTAMP_UPDATE_INTERVAL:I

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 140
    invoke-direct {p0}, Landroid/app/ListFragment;-><init>()V

    .line 89
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mHandler:Landroid/os/Handler;

    .line 111
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdateTimestampsRunnable:Ljava/lang/Runnable;

    .line 124
    new-instance v0, Lcom/android/mail/ui/ConversationListFragment$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/ConversationListFragment$1;-><init>(Lcom/android/mail/ui/ConversationListFragment;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    .line 141
    return-void
.end method

.method static synthetic access$002(Lcom/android/mail/ui/ConversationListFragment;Lcom/android/mail/providers/Account;)Lcom/android/mail/providers/Account;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationListFragment;
    .param p1, "x1"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    return-object p1
.end method

.method static synthetic access$100(Lcom/android/mail/ui/ConversationListFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationListFragment;

    .prologue
    .line 66
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->setSwipeAction()V

    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/ui/ConversationListFragment;)Lcom/android/mail/ui/ControllableActivity;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationListFragment;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/mail/ui/ConversationListFragment;)Lcom/android/mail/ui/SwipeableListView;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationListFragment;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/mail/ui/ConversationListFragment;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationListFragment;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdateTimestampsRunnable:Ljava/lang/Runnable;

    return-object v0
.end method

.method static synthetic access$700()I
    .locals 1

    .prologue
    .line 66
    sget v0, Lcom/android/mail/ui/ConversationListFragment;->TIMESTAMP_UPDATE_INTERVAL:I

    return v0
.end method

.method static synthetic access$800(Lcom/android/mail/ui/ConversationListFragment;)Landroid/os/Handler;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/ConversationListFragment;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mHandler:Landroid/os/Handler;

    return-object v0
.end method

.method private getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;
    .locals 1

    .prologue
    .line 552
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    invoke-interface {v0}, Lcom/android/mail/ui/ConversationListCallbacks;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private initializeUiForFirstDisplay()V
    .locals 2

    .prologue
    .line 238
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v1, 0x7f1000e5

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ControllableActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchStatusView:Landroid/view/View;

    .line 239
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v1, 0x7f1000e6

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ControllableActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchStatusTextView:Landroid/widget/TextView;

    .line 240
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    const v1, 0x7f1000e7

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ControllableActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchResultCountTextView:Landroid/widget/TextView;

    .line 242
    return-void
.end method

.method public static newInstance(Lcom/android/mail/ConversationListContext;)Lcom/android/mail/ui/ConversationListFragment;
    .locals 4
    .param p0, "viewContext"    # Lcom/android/mail/ConversationListContext;

    .prologue
    .line 177
    new-instance v1, Lcom/android/mail/ui/ConversationListFragment;

    invoke-direct {v1}, Lcom/android/mail/ui/ConversationListFragment;-><init>()V

    .line 178
    .local v1, "fragment":Lcom/android/mail/ui/ConversationListFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 179
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "conversation-list"

    invoke-virtual {p0}, Lcom/android/mail/ConversationListContext;->toBundle()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 180
    invoke-virtual {v1, v0}, Lcom/android/mail/ui/ConversationListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 181
    return-object v1
.end method

.method private onCursorUpdated()V
    .locals 5

    .prologue
    .line 690
    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    if-nez v3, :cond_1

    .line 715
    :cond_0
    :goto_0
    return-void

    .line 695
    :cond_1
    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    invoke-interface {v3}, Lcom/android/mail/ui/ConversationListCallbacks;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v1

    .line 696
    .local v1, "newCursor":Lcom/android/mail/browse/ConversationCursor;
    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v3, v1}, Lcom/android/mail/ui/AnimatedAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 701
    if-nez v1, :cond_3

    const/4 v2, 0x0

    .line 702
    .local v2, "newCursorHash":I
    :goto_1
    iget v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationCursorHash:I

    if-ne v3, v2, :cond_2

    iget v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationCursorHash:I

    if-eqz v3, :cond_2

    .line 703
    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v3}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 705
    :cond_2
    iput v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationCursorHash:I

    .line 708
    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    invoke-interface {v3}, Lcom/android/mail/ui/ConversationListCallbacks;->getCurrentConversation()Lcom/android/mail/providers/Conversation;

    move-result-object v0

    .line 709
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    if-eqz v0, :cond_0

    .line 712
    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v3}, Lcom/android/mail/ui/SwipeableListView;->getCheckedItemPosition()I

    move-result v3

    const/4 v4, -0x1

    if-ne v3, v4, :cond_0

    .line 713
    iget v3, v0, Lcom/android/mail/providers/Conversation;->position:I

    invoke-virtual {p0, v3}, Lcom/android/mail/ui/ConversationListFragment;->setSelected(I)V

    goto :goto_0

    .line 701
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    .end local v2    # "newCursorHash":I
    :cond_3
    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationCursor;->hashCode()I

    move-result v2

    goto :goto_1
.end method

.method private onFolderStatusUpdated()V
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 629
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    .line 630
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 631
    .local v2, "extras":Landroid/os/Bundle;
    :goto_0
    const-string v6, "cursor_error"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    const-string v6, "cursor_error"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 634
    .local v1, "error":I
    :goto_1
    const-string v6, "cursor_status"

    invoke-virtual {v2, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v4

    .line 637
    .local v4, "status":I
    iget-object v6, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v6, :cond_5

    iget-object v5, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    iget v3, v5, Lcom/android/mail/providers/Folder;->totalCount:I

    .line 638
    .local v3, "folderCount":I
    :goto_2
    if-nez v1, :cond_0

    const/4 v5, 0x2

    if-eq v4, v5, :cond_1

    const/16 v5, 0x8

    if-eq v4, v5, :cond_1

    :cond_0
    if-lez v3, :cond_2

    .line 641
    :cond_1
    invoke-direct {p0, v3}, Lcom/android/mail/ui/ConversationListFragment;->updateSearchResultHeader(I)V

    .line 642
    if-nez v3, :cond_2

    .line 643
    iget-object v5, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    iget-object v6, p0, Lcom/android/mail/ui/ConversationListFragment;->mEmptyView:Landroid/view/View;

    invoke-virtual {v5, v6}, Lcom/android/mail/ui/SwipeableListView;->setEmptyView(Landroid/view/View;)V

    .line 646
    :cond_2
    return-void

    .line 630
    .end local v1    # "error":I
    .end local v2    # "extras":Landroid/os/Bundle;
    .end local v3    # "folderCount":I
    .end local v4    # "status":I
    :cond_3
    sget-object v2, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    goto :goto_0

    .restart local v2    # "extras":Landroid/os/Bundle;
    :cond_4
    move v1, v5

    .line 631
    goto :goto_1

    .restart local v1    # "error":I
    .restart local v4    # "status":I
    :cond_5
    move v3, v5

    .line 637
    goto :goto_2
.end method

.method private setSwipeAction()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    .line 649
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    invoke-static {v2}, Lcom/android/mail/providers/Settings;->getSwipeSetting(Lcom/android/mail/providers/Settings;)I

    move-result v1

    .line 650
    .local v1, "swipeSetting":I
    const/4 v2, 0x2

    if-eq v1, v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v3, 0x4000

    invoke-virtual {v2, v3}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v2}, Lcom/android/mail/providers/Folder;->isTrash()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 653
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/android/mail/ui/SwipeableListView;->enableSwipe(Z)V

    .line 683
    :goto_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    iget-object v3, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v2, v3}, Lcom/android/mail/ui/SwipeableListView;->setCurrentFolder(Lcom/android/mail/providers/Folder;)V

    .line 684
    return-void

    .line 656
    :cond_1
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mViewContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v2}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    iget v2, v2, Lcom/android/mail/providers/Folder;->type:I

    const/4 v3, 0x6

    if-ne v2, v3, :cond_3

    .line 658
    :cond_2
    const v0, 0x7f100125

    .line 681
    .local v0, "action":I
    :goto_1
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v2, v0}, Lcom/android/mail/ui/SwipeableListView;->setSwipeAction(I)V

    goto :goto_0

    .line 659
    .end local v0    # "action":I
    :cond_3
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    if-nez v2, :cond_4

    .line 660
    const v0, 0x7f100124

    .restart local v0    # "action":I
    goto :goto_1

    .line 663
    .end local v0    # "action":I
    :cond_4
    packed-switch v1, :pswitch_data_0

    .line 677
    :cond_5
    const v0, 0x7f100125

    .restart local v0    # "action":I
    goto :goto_1

    .line 665
    .end local v0    # "action":I
    :pswitch_0
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    invoke-virtual {v2, v4}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 666
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v3, 0x10

    invoke-virtual {v2, v3}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 667
    const v0, 0x7f100123

    .line 668
    .restart local v0    # "action":I
    goto :goto_1

    .line 669
    .end local v0    # "action":I
    :cond_6
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v2, v4}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 671
    const v0, 0x7f100124

    .line 672
    .restart local v0    # "action":I
    goto :goto_1

    .line 663
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method private showList()V
    .locals 2

    .prologue
    .line 514
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SwipeableListView;->setEmptyView(Landroid/view/View;)V

    .line 515
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v0

    invoke-interface {v0}, Lcom/android/mail/ui/FolderController;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ConversationListFragment;->onFolderUpdated(Lcom/android/mail/providers/Folder;)V

    .line 516
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->onConversationListStatusUpdated()V

    .line 517
    return-void
.end method

.method private updateSearchResultHeader(I)V
    .locals 7
    .param p1, "count"    # I

    .prologue
    .line 217
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-nez v2, :cond_1

    .line 228
    :cond_0
    :goto_0
    return-void

    .line 221
    :cond_1
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 222
    .local v0, "res":Landroid/content/res/Resources;
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mViewContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v2}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v1

    .line 223
    .local v1, "showHeader":Z
    if-eqz v1, :cond_0

    .line 224
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchStatusTextView:Landroid/widget/TextView;

    const v3, 0x7f0c00a3

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 225
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchResultCountTextView:Landroid/widget/TextView;

    const v3, 0x7f0c00e3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v0, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public commitDestructiveActions(Z)V
    .locals 1
    .param p1, "animate"    # Z

    .prologue
    .line 718
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    if-eqz v0, :cond_0

    .line 719
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/SwipeableListView;->commitDestructiveActions(Z)V

    .line 722
    :cond_0
    return-void
.end method

.method configureSearchResultHeader()V
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 189
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    if-nez v4, :cond_0

    .line 210
    :goto_0
    return-void

    .line 193
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 194
    .local v2, "res":Landroid/content/res/Resources;
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mViewContext:Lcom/android/mail/ConversationListContext;

    invoke-static {v4}, Lcom/android/mail/ConversationListContext;->isSearchResult(Lcom/android/mail/ConversationListContext;)Z

    move-result v3

    .line 200
    .local v3, "showHeader":Z
    if-eqz v3, :cond_1

    .line 201
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchStatusTextView:Landroid/widget/TextView;

    const v6, 0x7f0c00ac

    invoke-virtual {v2, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 203
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchResultCountTextView:Landroid/widget/TextView;

    const-string v6, ""

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 205
    :cond_1
    iget-object v6, p0, Lcom/android/mail/ui/ConversationListFragment;->mSearchStatusView:Landroid/view/View;

    if-eqz v3, :cond_2

    move v4, v5

    :goto_1
    invoke-virtual {v6, v4}, Landroid/view/View;->setVisibility(I)V

    .line 206
    if-eqz v3, :cond_3

    const v4, 0x7f0b0040

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v4

    float-to-int v1, v4

    .line 207
    .local v1, "marginTop":I
    :goto_2
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v4}, Lcom/android/mail/ui/SwipeableListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 208
    .local v0, "layoutParams":Landroid/view/ViewGroup$MarginLayoutParams;
    iput v1, v0, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 209
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v4, v0}, Lcom/android/mail/ui/SwipeableListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0

    .line 205
    .end local v0    # "layoutParams":Landroid/view/ViewGroup$MarginLayoutParams;
    .end local v1    # "marginTop":I
    :cond_2
    const/16 v4, 0x8

    goto :goto_1

    :cond_3
    move v1, v5

    .line 206
    goto :goto_2
.end method

.method public getAnimatedAdapter()Lcom/android/mail/ui/AnimatedAdapter;
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 11
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x0

    const/4 v10, 0x0

    .line 246
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 256
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v7

    .line 257
    .local v7, "activity":Landroid/app/Activity;
    instance-of v0, v7, Lcom/android/mail/ui/ControllableActivity;

    if-nez v0, :cond_0

    .line 258
    sget-object v0, Lcom/android/mail/ui/ConversationListFragment;->LOG_TAG:Ljava/lang/String;

    const-string v1, "ConversationListFragment expects only a ControllableActivity tocreate it. Cannot proceed."

    new-array v2, v9, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 261
    :cond_0
    check-cast v7, Lcom/android/mail/ui/ControllableActivity;

    .end local v7    # "activity":Landroid/app/Activity;
    iput-object v7, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 265
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getAccountController()Lcom/android/mail/ui/AccountController;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/providers/AccountObserver;->initialize(Lcom/android/mail/ui/AccountController;)Lcom/android/mail/providers/Account;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 266
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    .line 267
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getErrorListener()Lcom/android/mail/ui/ErrorListener;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mErrorListener:Lcom/android/mail/ui/ErrorListener;

    .line 269
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    const v1, 0x7f040022

    invoke-virtual {v0, v1, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/browse/ConversationListFooterView;

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    .line 272
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationListFooterView;->setClickListener(Lcom/android/mail/browse/ConversationListFooterView$FooterViewClickListener;)V

    .line 273
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v3

    .line 274
    .local v3, "conversationCursor":Lcom/android/mail/browse/ConversationCursor;
    new-instance v0, Lcom/android/mail/ui/AnimatedAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, -0x1

    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v4}, Lcom/android/mail/ui/ControllableActivity;->getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    iget-object v6, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-direct/range {v0 .. v6}, Lcom/android/mail/ui/AnimatedAdapter;-><init>(Landroid/content/Context;ILcom/android/mail/browse/ConversationCursor;Lcom/android/mail/ui/ConversationSelectionSet;Lcom/android/mail/ui/ControllableActivity;Lcom/android/mail/ui/SwipeableListView;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    .line 276
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AnimatedAdapter;->addFooter(Landroid/view/View;)V

    .line 277
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SwipeableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 278
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getSelectedSet()Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    .line 279
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SwipeableListView;->setSelectionSet(Lcom/android/mail/ui/ConversationSelectionSet;)V

    .line 280
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->hideFooter()V

    .line 281
    new-instance v0, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;

    invoke-direct {v0, p0, v10}, Lcom/android/mail/ui/ConversationListFragment$FolderObserver;-><init>(Lcom/android/mail/ui/ConversationListFragment;Lcom/android/mail/ui/ConversationListFragment$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolderObserver:Landroid/database/DataSetObserver;

    .line 282
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolderObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/FolderController;->registerFolderObserver(Landroid/database/DataSetObserver;)V

    .line 283
    new-instance v0, Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;

    invoke-direct {v0, p0, v10}, Lcom/android/mail/ui/ConversationListFragment$ConversationListStatusObserver;-><init>(Lcom/android/mail/ui/ConversationListFragment;Lcom/android/mail/ui/ConversationListFragment$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationListStatusObserver:Landroid/database/DataSetObserver;

    .line 284
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getConversationUpdater()Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    .line 285
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationListStatusObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ConversationUpdater;->registerConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 286
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v0

    sput-boolean v0, Lcom/android/mail/ui/ConversationListFragment;->mTabletDevice:Z

    .line 287
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->initializeUiForFirstDisplay()V

    .line 288
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->configureSearchResultHeader()V

    .line 292
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/ui/ViewMode;->getMode()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/ConversationListFragment;->onViewModeChanged(I)V

    .line 293
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getViewMode()Lcom/android/mail/ui/ViewMode;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/android/mail/ui/ViewMode;->addListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V

    .line 295
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 314
    :cond_1
    :goto_0
    return-void

    .line 299
    :cond_2
    if-nez v3, :cond_4

    move v0, v9

    :goto_1
    iput v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationCursorHash:I

    .line 302
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationCursor;->isRefreshReady()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 303
    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationCursor;->sync()V

    .line 307
    :cond_3
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->showList()V

    .line 308
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getPendingToastOperation()Lcom/android/mail/ui/ToastBarOperation;

    move-result-object v8

    .line 309
    .local v8, "pendingOp":Lcom/android/mail/ui/ToastBarOperation;
    if-eqz v8, :cond_1

    .line 311
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0, v10}, Lcom/android/mail/ui/ControllableActivity;->setPendingToastOperation(Lcom/android/mail/ui/ToastBarOperation;)V

    .line 312
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0, v8}, Lcom/android/mail/ui/ControllableActivity;->onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V

    goto :goto_0

    .line 299
    .end local v8    # "pendingOp":Lcom/android/mail/ui/ToastBarOperation;
    :cond_4
    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationCursor;->hashCode()I

    move-result v0

    goto :goto_1
.end method

.method public onConversationListStatusUpdated()V
    .locals 3

    .prologue
    .line 618
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    .line 619
    .local v0, "cursor":Lcom/android/mail/browse/ConversationCursor;
    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    invoke-virtual {v2, v0}, Lcom/android/mail/browse/ConversationListFooterView;->updateStatus(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 621
    .local v1, "showFooter":Z
    :goto_0
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->onFolderStatusUpdated()V

    .line 622
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v2, v1}, Lcom/android/mail/ui/AnimatedAdapter;->setFooterVisibility(Z)V

    .line 625
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->onCursorUpdated()V

    .line 626
    return-void

    .line 619
    .end local v1    # "showFooter":Z
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    .line 322
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 325
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 326
    .local v1, "res":Landroid/content/res/Resources;
    const v2, 0x7f0a0017

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    sput v2, Lcom/android/mail/ui/ConversationListFragment;->TIMESTAMP_UPDATE_INTERVAL:I

    .line 327
    new-instance v2, Lcom/android/mail/ui/ConversationListFragment$2;

    invoke-direct {v2, p0}, Lcom/android/mail/ui/ConversationListFragment$2;-><init>(Lcom/android/mail/ui/ConversationListFragment;)V

    iput-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdateTimestampsRunnable:Ljava/lang/Runnable;

    .line 336
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 337
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "conversation-list"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    invoke-static {v2}, Lcom/android/mail/ConversationListContext;->forBundle(Landroid/os/Bundle;)Lcom/android/mail/ConversationListContext;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mViewContext:Lcom/android/mail/ConversationListContext;

    .line 338
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mViewContext:Lcom/android/mail/ConversationListContext;

    iget-object v2, v2, Lcom/android/mail/ConversationListContext;->account:Lcom/android/mail/providers/Account;

    iput-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 340
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/android/mail/ui/ConversationListFragment;->setRetainInstance(Z)V

    .line 341
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedState"    # Landroid/os/Bundle;

    .prologue
    .line 345
    const v1, 0x7f040021

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 346
    .local v0, "rootView":Landroid/view/View;
    const v1, 0x7f100062

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mEmptyView:Landroid/view/View;

    .line 347
    const v1, 0x102000a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/SwipeableListView;

    iput-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    .line 348
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/SwipeableListView;->setHeaderDividersEnabled(Z)V

    .line 351
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/SwipeableListView;->setChoiceMode(I)V

    .line 352
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v1, p0}, Lcom/android/mail/ui/SwipeableListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 353
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v3, 0x4000

    invoke-virtual {v2, v3}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/SwipeableListView;->enableSwipe(Z)V

    .line 354
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v1, p0}, Lcom/android/mail/ui/SwipeableListView;->setSwipedListener(Lcom/android/mail/ui/SwipeableListView$ListItemSwipedListener;)V

    .line 357
    if-eqz p3, :cond_0

    const-string v1, "list-state"

    invoke-virtual {p3, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 358
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const-string v2, "list-state"

    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/android/mail/ui/SwipeableListView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 360
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v1}, Lcom/android/mail/ui/SwipeableListView;->clearChoices()V

    .line 362
    :cond_0
    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 367
    invoke-super {p0}, Landroid/app/ListFragment;->onDestroy()V

    .line 368
    return-void
.end method

.method public onDestroyView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 374
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->destroy()V

    .line 375
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v0, v2}, Lcom/android/mail/ui/SwipeableListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 377
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0, p0}, Lcom/android/mail/ui/ControllableActivity;->unsetViewModeListener(Lcom/android/mail/ui/ViewMode$ModeChangeListener;)V

    .line 378
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->isChangingConfigurations()Z

    move-result v0

    if-nez v0, :cond_0

    .line 379
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mViewContext:Lcom/android/mail/ConversationListContext;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/LoaderManager;->destroyLoader(I)V

    .line 381
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolderObserver:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_1

    .line 382
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolderObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/FolderController;->unregisterFolderObserver(Landroid/database/DataSetObserver;)V

    .line 383
    iput-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolderObserver:Landroid/database/DataSetObserver;

    .line 385
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationListStatusObserver:Landroid/database/DataSetObserver;

    if-eqz v0, :cond_2

    .line 386
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationListStatusObserver:Landroid/database/DataSetObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/ConversationUpdater;->unregisterConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 387
    iput-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mConversationListStatusObserver:Landroid/database/DataSetObserver;

    .line 389
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccountObserver:Lcom/android/mail/providers/AccountObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/AccountObserver;->unregisterAndDestroy()V

    .line 390
    invoke-super {p0}, Landroid/app/ListFragment;->onDestroyView()V

    .line 391
    return-void
.end method

.method public onFolderUpdated(Lcom/android/mail/providers/Folder;)V
    .locals 3
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 596
    iput-object p1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    .line 597
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->setSwipeAction()V

    .line 598
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    if-nez v0, :cond_0

    .line 612
    :goto_0
    return-void

    .line 601
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AnimatedAdapter;->setFolder(Lcom/android/mail/providers/Folder;)V

    .line 602
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationListFooterView;->setFolder(Lcom/android/mail/providers/Folder;)V

    .line 603
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0}, Lcom/android/mail/providers/Folder;->wasSyncSuccessful()Z

    move-result v0

    if-nez v0, :cond_1

    .line 604
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mErrorListener:Lcom/android/mail/ui/ErrorListener;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/android/mail/ui/ErrorListener;->onError(Lcom/android/mail/providers/Folder;Z)V

    .line 608
    :cond_1
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->onFolderStatusUpdated()V

    .line 611
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-static {v0}, Lcom/android/mail/browse/ConversationItemViewModel;->onFolderUpdated(Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 2
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v1, 0x1

    .line 418
    instance-of v0, p2, Lcom/android/mail/browse/ConversationItemView;

    if-nez v0, :cond_0

    .line 422
    .end local p2    # "view":Landroid/view/View;
    :goto_0
    return v1

    .line 421
    .restart local p2    # "view":Landroid/view/View;
    :cond_0
    check-cast p2, Lcom/android/mail/browse/ConversationItemView;

    .end local p2    # "view":Landroid/view/View;
    invoke-virtual {p2}, Lcom/android/mail/browse/ConversationItemView;->toggleCheckMarkOrBeginDrag()V

    goto :goto_0
.end method

.method public onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 2
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 447
    instance-of v1, p2, Lcom/android/mail/browse/ToggleableItem;

    if-nez v1, :cond_0

    .line 460
    :goto_0
    return-void

    .line 450
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->settings:Lcom/android/mail/providers/Settings;

    iget-boolean v1, v1, Lcom/android/mail/providers/Settings;->hideCheckboxes:Z

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;

    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationSelectionSet;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    move-object v0, p2

    .line 451
    check-cast v0, Lcom/android/mail/browse/ToggleableItem;

    .line 452
    .local v0, "v":Lcom/android/mail/browse/ToggleableItem;
    invoke-interface {v0}, Lcom/android/mail/browse/ToggleableItem;->toggleCheckMarkOrBeginDrag()V

    .line 459
    .end local v0    # "v":Lcom/android/mail/browse/ToggleableItem;
    :goto_1
    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->useTabletUI(Landroid/content/Context;)Z

    move-result v1

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/ConversationListFragment;->commitDestructiveActions(Z)V

    goto :goto_0

    .line 454
    :cond_1
    invoke-virtual {p0, p3}, Lcom/android/mail/ui/ConversationListFragment;->viewConversation(I)V

    goto :goto_1
.end method

.method public onListItemSwiped(Ljava/util/Collection;)V
    .locals 1
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
    .line 726
    .local p1, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/ConversationUpdater;->showNextConversation(Ljava/util/Collection;)V

    .line 727
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 464
    invoke-super {p0}, Landroid/app/ListFragment;->onPause()V

    .line 465
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 167
    invoke-super {p0}, Landroid/app/ListFragment;->onResume()V

    .line 169
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getView()Landroid/view/View;

    move-result-object v0

    const-string v1, "ConversationListFragment"

    invoke-static {v0, v1}, Lcom/android/mail/utils/Utils;->fixSubTreeLayoutIfOrphaned(Landroid/view/View;Ljava/lang/String;)V

    .line 170
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 469
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 470
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    if-eqz v0, :cond_0

    .line 471
    const-string v0, "list-state"

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v1}, Lcom/android/mail/ui/SwipeableListView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 473
    :cond_0
    return-void
.end method

.method public onStart()V
    .locals 4

    .prologue
    .line 477
    invoke-super {p0}, Landroid/app/ListFragment;->onStart()V

    .line 478
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdateTimestampsRunnable:Ljava/lang/Runnable;

    sget v2, Lcom/android/mail/ui/ConversationListFragment;->TIMESTAMP_UPDATE_INTERVAL:I

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 479
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 483
    invoke-super {p0}, Landroid/app/ListFragment;->onStop()V

    .line 484
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment;->mUpdateTimestampsRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 485
    return-void
.end method

.method public onViewModeChanged(I)V
    .locals 2
    .param p1, "newMode"    # I

    .prologue
    const/4 v1, 0x0

    .line 490
    sget-boolean v0, Lcom/android/mail/ui/ConversationListFragment;->mTabletDevice:Z

    if-eqz v0, :cond_4

    .line 491
    const/4 v0, 0x1

    if-ne p1, v0, :cond_2

    .line 492
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const v1, 0x7f02008b

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SwipeableListView;->setBackgroundResource(I)V

    .line 503
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    if-eqz v0, :cond_1

    .line 504
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mFooterView:Lcom/android/mail/browse/ConversationListFooterView;

    invoke-virtual {v0, p1}, Lcom/android/mail/browse/ConversationListFooterView;->onViewModeChanged(I)V

    .line 506
    :cond_1
    return-void

    .line 493
    :cond_2
    const/4 v0, 0x2

    if-eq p1, v0, :cond_3

    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 497
    :cond_3
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v0}, Lcom/android/mail/ui/SwipeableListView;->clearChoices()V

    .line 498
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SwipeableListView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 501
    :cond_4
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SwipeableListView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public requestDelete(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 5
    .param p1, "actionId"    # I
    .param p4, "action"    # Lcom/android/mail/ui/DestructiveAction;
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
    .line 572
    .local p2, "conversations":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    .local p3, "views":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/browse/ConversationItemView;>;"
    invoke-interface {p2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 573
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    const/4 v4, 0x1

    iput-boolean v4, v0, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    goto :goto_0

    .line 575
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_0
    new-instance v3, Lcom/android/mail/ui/ConversationListFragment$3;

    invoke-direct {v3, p0, p4}, Lcom/android/mail/ui/ConversationListFragment$3;-><init>(Lcom/android/mail/ui/ConversationListFragment;Lcom/android/mail/ui/DestructiveAction;)V

    .line 581
    .local v3, "listener":Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;
    invoke-virtual {p0}, Lcom/android/mail/ui/ConversationListFragment;->getListView()Landroid/widget/ListView;

    move-result-object v2

    check-cast v2, Lcom/android/mail/ui/SwipeableListView;

    .line 582
    .local v2, "listView":Lcom/android/mail/ui/SwipeableListView;
    invoke-virtual {v2}, Lcom/android/mail/ui/SwipeableListView;->getSwipeAction()I

    move-result v4

    if-ne v4, p1, :cond_2

    .line 583
    if-nez p3, :cond_1

    .line 584
    invoke-virtual {v2, p2, v3}, Lcom/android/mail/ui/SwipeableListView;->destroyItems(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    .line 593
    :goto_1
    return-void

    .line 586
    :cond_1
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4, p3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    invoke-virtual {v2, v4, v3}, Lcom/android/mail/ui/SwipeableListView;->destroyItems(Ljava/util/ArrayList;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    goto :goto_1

    .line 592
    :cond_2
    iget-object v4, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v4, p2, v3}, Lcom/android/mail/ui/AnimatedAdapter;->delete(Ljava/util/Collection;Lcom/android/mail/ui/SwipeableListView$ListItemsRemovedListener;)V

    goto :goto_1
.end method

.method public requestListRefresh()V
    .locals 1

    .prologue
    .line 560
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-virtual {v0}, Lcom/android/mail/ui/AnimatedAdapter;->notifyDataSetChanged()V

    .line 561
    return-void
.end method

.method protected final setSelected(I)V
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 548
    const/4 v0, 0x1

    invoke-virtual {p0, p1, v0}, Lcom/android/mail/ui/ConversationListFragment;->setSelected(IZ)V

    .line 549
    return-void
.end method

.method public setSelected(IZ)V
    .locals 2
    .param p1, "position"    # I
    .param p2, "different"    # Z

    .prologue
    .line 536
    if-eqz p2, :cond_0

    .line 537
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    invoke-virtual {v0, p1}, Lcom/android/mail/ui/SwipeableListView;->smoothScrollToPosition(I)V

    .line 539
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;

    const/4 v1, 0x1

    invoke-virtual {v0, p1, v1}, Lcom/android/mail/ui/SwipeableListView;->setItemChecked(IZ)V

    .line 540
    return-void
.end method

.method protected viewConversation(I)V
    .locals 7
    .param p1, "position"    # I

    .prologue
    const/4 v6, 0x0

    .line 524
    sget-object v2, Lcom/android/mail/ui/ConversationListFragment;->LOG_TAG:Ljava/lang/String;

    const-string v3, "ConversationListFragment.viewConversation(%d)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 525
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/ConversationListFragment;->setSelected(I)V

    .line 526
    invoke-direct {p0}, Lcom/android/mail/ui/ConversationListFragment;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v1

    .line 527
    .local v1, "cursor":Lcom/android/mail/browse/ConversationCursor;
    if-eqz v1, :cond_0

    invoke-virtual {v1, p1}, Lcom/android/mail/browse/ConversationCursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 528
    new-instance v0, Lcom/android/mail/providers/Conversation;

    invoke-direct {v0, v1}, Lcom/android/mail/providers/Conversation;-><init>(Landroid/database/Cursor;)V

    .line 529
    .local v0, "conv":Lcom/android/mail/providers/Conversation;
    iput p1, v0, Lcom/android/mail/providers/Conversation;->position:I

    .line 530
    iget-object v2, p0, Lcom/android/mail/ui/ConversationListFragment;->mCallbacks:Lcom/android/mail/ui/ConversationListCallbacks;

    invoke-interface {v2, v0, v6}, Lcom/android/mail/ui/ConversationListCallbacks;->onConversationSelected(Lcom/android/mail/providers/Conversation;Z)V

    .line 532
    .end local v0    # "conv":Lcom/android/mail/providers/Conversation;
    :cond_0
    return-void
.end method
