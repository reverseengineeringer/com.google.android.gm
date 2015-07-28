.class public final Lcom/android/mail/ui/FolderListFragment;
.super Landroid/app/ListFragment;
.source "FolderListFragment.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/FolderListFragment$1;,
        Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;,
        Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;,
        Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;,
        Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;,
        Lcom/android/mail/ui/FolderListFragment$FolderObserver;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/ListFragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mActivity:Lcom/android/mail/ui/ControllableActivity;

.field private mConversationListCallback:Lcom/android/mail/ui/ConversationListCallbacks;

.field private mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

.field private mEmptyView:Landroid/view/View;

.field private mFolderListUri:Landroid/net/Uri;

.field private mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

.field private mFutureData:Landroid/database/Cursor;

.field private mIsSectioned:Z

.field private mListView:Landroid/widget/ListView;

.field private mListener:Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;

.field private mParentFolder:Lcom/android/mail/providers/Folder;

.field private mSelectedFolderType:I

.field private mSelectedFolderUri:Landroid/net/Uri;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/ui/FolderListFragment;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 121
    invoke-direct {p0}, Landroid/app/ListFragment;-><init>()V

    .line 68
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    .line 90
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    .line 96
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    .line 122
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/android/mail/ui/FolderListFragment;Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;
    .param p1, "x1"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 53
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderListFragment;->setSelectedFolder(Lcom/android/mail/providers/Folder;)V

    return-void
.end method

.method static synthetic access$1100(Lcom/android/mail/ui/FolderListFragment;)Landroid/database/Cursor;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/android/mail/ui/FolderListFragment;Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;
    .param p1, "x1"    # Landroid/database/Cursor;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;

    return-object p1
.end method

.method static synthetic access$500(Lcom/android/mail/ui/FolderListFragment;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$600(Lcom/android/mail/ui/FolderListFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;

    .prologue
    .line 53
    iget v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    return v0
.end method

.method static synthetic access$700(Lcom/android/mail/ui/FolderListFragment;)Landroid/net/Uri;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    return-object v0
.end method

.method public static newInstance(Lcom/android/mail/providers/Folder;Landroid/net/Uri;Z)Lcom/android/mail/ui/FolderListFragment;
    .locals 4
    .param p0, "parentFolder"    # Lcom/android/mail/providers/Folder;
    .param p1, "folderUri"    # Landroid/net/Uri;
    .param p2, "isSectioned"    # Z

    .prologue
    .line 138
    new-instance v1, Lcom/android/mail/ui/FolderListFragment;

    invoke-direct {v1}, Lcom/android/mail/ui/FolderListFragment;-><init>()V

    .line 139
    .local v1, "fragment":Lcom/android/mail/ui/FolderListFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 140
    .local v0, "args":Landroid/os/Bundle;
    if-eqz p0, :cond_0

    .line 141
    const-string v2, "arg-parent-folder"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 143
    :cond_0
    const-string v2, "arg-folder-list-uri"

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    const-string v2, "arg-is-sectioned"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 145
    invoke-virtual {v1, v0}, Lcom/android/mail/ui/FolderListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 146
    return-object v1
.end method

.method private setSelectedFolder(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 731
    if-nez p1, :cond_1

    .line 732
    sget-object v0, Landroid/net/Uri;->EMPTY:Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    .line 740
    :cond_0
    :goto_0
    return-void

    .line 735
    :cond_1
    iget-object v0, p1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    .line 736
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderListFragment;->setSelectedFolderType(Lcom/android/mail/providers/Folder;)V

    .line 737
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    if-eqz v0, :cond_0

    .line 738
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    invoke-interface {v0}, Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method private setSelectedFolderType(Lcom/android/mail/providers/Folder;)V
    .locals 1
    .param p1, "folder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 748
    iget v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    if-eqz v0, :cond_0

    .line 753
    :goto_0
    return-void

    .line 751
    :cond_0
    invoke-virtual {p1}, Lcom/android/mail/providers/Folder;->isProviderFolder()Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    iput v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    goto :goto_0

    :cond_1
    const/4 v0, 0x3

    goto :goto_1
.end method

.method private updateCursorAdapter(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "data"    # Landroid/database/Cursor;

    .prologue
    .line 318
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;->setCursor(Landroid/database/Cursor;)V

    .line 319
    if-eqz p1, :cond_0

    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    .line 320
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mEmptyView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 321
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mEmptyView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 323
    :cond_1
    return-void
.end method

.method private viewFolder(I)V
    .locals 8
    .param p1, "position"    # I

    .prologue
    .line 277
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment;->getListAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    invoke-interface {v3, p1}, Landroid/widget/ListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    .line 279
    .local v2, "item":Ljava/lang/Object;
    instance-of v3, v2, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    if-eqz v3, :cond_0

    move-object v1, v2

    .line 280
    check-cast v1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    .line 281
    .local v1, "folderItem":Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    invoke-interface {v3, v1}, Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;->getFullFolder(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;)Lcom/android/mail/providers/Folder;

    move-result-object v0

    .line 282
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    iget v3, v1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolderType:I

    iput v3, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    .line 288
    .end local v1    # "folderItem":Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
    .end local v2    # "item":Ljava/lang/Object;
    :goto_0
    if-eqz v0, :cond_3

    .line 293
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v0, v3}, Lcom/android/mail/providers/Folder;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    const/4 v3, 0x0

    :goto_1
    iput-object v3, v0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    .line 295
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mListener:Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;

    invoke-interface {v3, v0}, Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;->onFolderSelected(Lcom/android/mail/providers/Folder;)V

    .line 300
    :goto_2
    return-void

    .line 283
    .end local v0    # "folder":Lcom/android/mail/providers/Folder;
    .restart local v2    # "item":Ljava/lang/Object;
    :cond_0
    instance-of v3, v2, Lcom/android/mail/providers/Folder;

    if-eqz v3, :cond_1

    move-object v0, v2

    .line 284
    check-cast v0, Lcom/android/mail/providers/Folder;

    .restart local v0    # "folder":Lcom/android/mail/providers/Folder;
    goto :goto_0

    .line 286
    .end local v0    # "folder":Lcom/android/mail/providers/Folder;
    :cond_1
    new-instance v0, Lcom/android/mail/providers/Folder;

    check-cast v2, Landroid/database/Cursor;

    .end local v2    # "item":Ljava/lang/Object;
    invoke-direct {v0, v2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .restart local v0    # "folder":Lcom/android/mail/providers/Folder;
    goto :goto_0

    .line 293
    :cond_2
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    goto :goto_1

    .line 297
    :cond_3
    sget-object v3, Lcom/android/mail/ui/FolderListFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "FolderListFragment unable to get a full fledged folder to hand to the listener for position %d"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_2
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7
    .param p1, "savedState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x0

    const/4 v2, 0x0

    .line 151
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 157
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 158
    .local v0, "activity":Landroid/app/Activity;
    instance-of v3, v0, Lcom/android/mail/ui/ControllableActivity;

    if-nez v3, :cond_0

    .line 159
    sget-object v3, Lcom/android/mail/ui/FolderListFragment;->LOG_TAG:Ljava/lang/String;

    const-string v4, "FolderListFragment expects only a ControllableActivity tocreate it. Cannot proceed."

    new-array v5, v6, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/android/mail/utils/LogUtils;->wtf(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 162
    :cond_0
    check-cast v0, Lcom/android/mail/ui/ControllableActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    .line 163
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getListHandler()Lcom/android/mail/ui/ConversationListCallbacks;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mConversationListCallback:Lcom/android/mail/ui/ConversationListCallbacks;

    .line 164
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v1

    .line 166
    .local v1, "controller":Lcom/android/mail/ui/FolderController;
    new-instance v3, Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    invoke-direct {v3, p0, v2}, Lcom/android/mail/ui/FolderListFragment$FolderObserver;-><init>(Lcom/android/mail/ui/FolderListFragment;Lcom/android/mail/ui/FolderListFragment$1;)V

    iput-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    .line 167
    if-eqz v1, :cond_1

    .line 169
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    invoke-interface {v1, v3}, Lcom/android/mail/ui/FolderController;->registerFolderObserver(Landroid/database/DataSetObserver;)V

    .line 172
    :cond_1
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getFolderListSelectionListener()Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mListener:Lcom/android/mail/ui/FolderListFragment$FolderListSelectionListener;

    .line 173
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->isFinishing()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 193
    :goto_0
    return-void

    .line 179
    :cond_2
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    if-eqz v3, :cond_4

    .line 180
    new-instance v3, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;

    iget-object v4, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    invoke-direct {v3, p0, v2, v4}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;-><init>(Lcom/android/mail/ui/FolderListFragment;Landroid/database/Cursor;Lcom/android/mail/providers/Folder;)V

    iput-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    .line 181
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v3}, Lcom/android/mail/ui/ControllableActivity;->getHierarchyFolder()Lcom/android/mail/providers/Folder;

    move-result-object v2

    .line 187
    .local v2, "selectedFolder":Lcom/android/mail/providers/Folder;
    :goto_1
    if-eqz v2, :cond_3

    iget-object v3, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v4, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    invoke-virtual {v3, v4}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 188
    invoke-direct {p0, v2}, Lcom/android/mail/ui/FolderListFragment;->setSelectedFolder(Lcom/android/mail/providers/Folder;)V

    .line 190
    :cond_3
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    invoke-virtual {p0, v3}, Lcom/android/mail/ui/FolderListFragment;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 192
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v3

    sget-object v4, Landroid/os/Bundle;->EMPTY:Landroid/os/Bundle;

    invoke-virtual {v3, v6, v4, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0

    .line 183
    .end local v2    # "selectedFolder":Lcom/android/mail/providers/Folder;
    :cond_4
    new-instance v3, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    const v4, 0x7f04003e

    iget-boolean v5, p0, Lcom/android/mail/ui/FolderListFragment;->mIsSectioned:Z

    invoke-direct {v3, p0, v4, v5}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;-><init>(Lcom/android/mail/ui/FolderListFragment;IZ)V

    iput-object v3, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    .line 184
    if-nez v1, :cond_5

    .restart local v2    # "selectedFolder":Lcom/android/mail/providers/Folder;
    :goto_2
    goto :goto_1

    .end local v2    # "selectedFolder":Lcom/android/mail/providers/Folder;
    :cond_5
    invoke-interface {v1}, Lcom/android/mail/ui/FolderController;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v2

    goto :goto_2
.end method

.method public onAnimationEnd()V
    .locals 1

    .prologue
    .line 311
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 312
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/FolderListFragment;->updateCursorAdapter(Landroid/database/Cursor;)V

    .line 313
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;

    .line 315
    :cond_0
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
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
    const/4 v4, 0x0

    .line 304
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v0, v4}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 305
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mEmptyView:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 306
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderListUri:Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 198
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 199
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "arg-folder-list-uri"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderListUri:Landroid/net/Uri;

    .line 200
    const-string v2, "arg-parent-folder"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v2

    check-cast v2, Lcom/android/mail/providers/Folder;

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    .line 201
    const-string v2, "arg-is-sectioned"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/android/mail/ui/FolderListFragment;->mIsSectioned:Z

    .line 202
    const v2, 0x7f04003f

    invoke-virtual {p1, v2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 203
    .local v1, "rootView":Landroid/view/View;
    const v2, 0x102000a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    .line 204
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setHeaderDividersEnabled(Z)V

    .line 205
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 206
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v2, v4}, Landroid/widget/ListView;->setEmptyView(Landroid/view/View;)V

    .line 207
    if-eqz p3, :cond_0

    const-string v2, "flf-list-state"

    invoke-virtual {p3, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 208
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    const-string v3, "flf-list-state"

    invoke-virtual {p3, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 210
    :cond_0
    const v2, 0x7f100062

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mEmptyView:Landroid/view/View;

    .line 211
    if-eqz p3, :cond_2

    const-string v2, "flf-selected-folder"

    invoke-virtual {p3, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 212
    const-string v2, "flf-selected-folder"

    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    .line 213
    const-string v2, "flf-selected-type"

    invoke-virtual {p3, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    .line 219
    :cond_1
    :goto_0
    return-object v1

    .line 214
    :cond_2
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    if-eqz v2, :cond_1

    .line 215
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 252
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    if-eqz v1, :cond_0

    .line 253
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    invoke-interface {v1}, Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;->destroy()V

    .line 256
    :cond_0
    invoke-virtual {p0, v2}, Lcom/android/mail/ui/FolderListFragment;->setListAdapter(Landroid/widget/ListAdapter;)V

    .line 257
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    if-eqz v1, :cond_1

    .line 258
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v0

    .line 259
    .local v0, "controller":Lcom/android/mail/ui/FolderController;
    if-eqz v0, :cond_1

    .line 260
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    invoke-interface {v0, v1}, Lcom/android/mail/ui/FolderController;->unregisterFolderObserver(Landroid/database/DataSetObserver;)V

    .line 261
    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment;->mFolderObserver:Lcom/android/mail/ui/FolderListFragment$FolderObserver;

    .line 264
    .end local v0    # "controller":Lcom/android/mail/ui/FolderController;
    :cond_1
    invoke-super {p0}, Landroid/app/ListFragment;->onDestroyView()V

    .line 265
    return-void
.end method

.method public onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 0
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 269
    invoke-direct {p0, p3}, Lcom/android/mail/ui/FolderListFragment;->viewFolder(I)V

    .line 270
    return-void
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 2
    .param p2, "data"    # Landroid/database/Cursor;
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
    .line 327
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mConversationListCallback:Lcom/android/mail/ui/ConversationListCallbacks;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mConversationListCallback:Lcom/android/mail/ui/ConversationListCallbacks;

    invoke-interface {v0}, Lcom/android/mail/ui/ConversationListCallbacks;->isAnimating()Z

    move-result v0

    if-nez v0, :cond_1

    .line 328
    :cond_0
    invoke-direct {p0, p2}, Lcom/android/mail/ui/FolderListFragment;->updateCursorAdapter(Landroid/database/Cursor;)V

    .line 333
    :goto_0
    return-void

    .line 330
    :cond_1
    iput-object p2, p0, Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;

    .line 331
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;->setCursor(Landroid/database/Cursor;)V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 53
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/FolderListFragment;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 2
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
    .line 337
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mCursorAdapter:Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;->setCursor(Landroid/database/Cursor;)V

    .line 338
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 234
    invoke-super {p0}, Landroid/app/ListFragment;->onPause()V

    .line 235
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 127
    invoke-super {p0}, Landroid/app/ListFragment;->onResume()V

    .line 129
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment;->getView()Landroid/view/View;

    move-result-object v0

    const-string v1, "FolderListFragment"

    invoke-static {v0, v1}, Lcom/android/mail/utils/Utils;->fixSubTreeLayoutIfOrphaned(Landroid/view/View;Ljava/lang/String;)V

    .line 130
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 239
    invoke-super {p0, p1}, Landroid/app/ListFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 240
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    if-eqz v0, :cond_0

    .line 241
    const-string v0, "flf-list-state"

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 243
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    if-eqz v0, :cond_1

    .line 244
    const-string v0, "flf-selected-folder"

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;

    invoke-virtual {v1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    :cond_1
    const-string v0, "flf-selected-type"

    iget v1, p0, Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 247
    const-string v0, "arg-is-sectioned"

    iget-boolean v1, p0, Lcom/android/mail/ui/FolderListFragment;->mIsSectioned:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 248
    return-void
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 224
    invoke-super {p0}, Landroid/app/ListFragment;->onStart()V

    .line 225
    return-void
.end method

.method public onStop()V
    .locals 0

    .prologue
    .line 229
    invoke-super {p0}, Landroid/app/ListFragment;->onStop()V

    .line 230
    return-void
.end method

.method public showingHierarchy()Z
    .locals 1

    .prologue
    .line 764
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment;->mParentFolder:Lcom/android/mail/providers/Folder;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
