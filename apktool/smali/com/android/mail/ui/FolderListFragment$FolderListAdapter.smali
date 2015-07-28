.class Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;
.super Landroid/widget/BaseAdapter;
.source "FolderListFragment.java"

# interfaces
.implements Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FolderListAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
    }
.end annotation


# instance fields
.field private mCursor:Landroid/database/Cursor;

.field private final mInflater:Landroid/view/LayoutInflater;

.field private final mIsSectioned:Z

.field private final mItemList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;",
            ">;"
        }
    .end annotation
.end field

.field private final mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

.field private final mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

.field final synthetic this$0:Lcom/android/mail/ui/FolderListFragment;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/FolderListFragment;IZ)V
    .locals 3
    .param p2, "layout"    # I
    .param p3, "isSectioned"    # Z

    .prologue
    const/4 v2, 0x0

    .line 481
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    .line 482
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 359
    new-instance v1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$1;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$1;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)V

    iput-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    .line 371
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    .line 373
    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    .line 483
    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {p1}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v1

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mInflater:Landroid/view/LayoutInflater;

    .line 484
    iput-boolean p3, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mIsSectioned:Z

    .line 485
    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {p1}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v1

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getRecentFolderController()Lcom/android/mail/ui/RecentFolderController;

    move-result-object v0

    .line 486
    .local v0, "controller":Lcom/android/mail/ui/RecentFolderController;
    if-eqz v0, :cond_0

    iget-boolean v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mIsSectioned:Z

    if-eqz v1, :cond_0

    .line 487
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    invoke-virtual {v1, v0}, Lcom/android/mail/providers/RecentFolderObserver;->initialize(Lcom/android/mail/ui/RecentFolderController;)Lcom/android/mail/ui/RecentFolderList;

    move-result-object v1

    iput-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

    .line 491
    :goto_0
    return-void

    .line 489
    :cond_0
    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

    goto :goto_0
.end method

.method static synthetic access$300(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    .prologue
    .line 357
    invoke-direct {p0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->recalculateList()V

    return-void
.end method

.method static synthetic access$400(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)Landroid/view/LayoutInflater;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    .prologue
    .line 357
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mInflater:Landroid/view/LayoutInflater;

    return-object v0
.end method

.method private final getRecentFolders(Lcom/android/mail/ui/RecentFolderList;)Ljava/util/List;
    .locals 4
    .param p1, "recentList"    # Lcom/android/mail/ui/RecentFolderList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/android/mail/ui/RecentFolderList;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation

    .prologue
    .line 532
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 533
    .local v1, "folderList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Folder;>;"
    if-nez p1, :cond_1

    .line 542
    :cond_0
    return-object v1

    .line 537
    :cond_1
    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Lcom/android/mail/ui/RecentFolderList;->getRecentFolderList(Landroid/net/Uri;)Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 538
    .local v0, "f":Lcom/android/mail/providers/Folder;
    invoke-virtual {v0}, Lcom/android/mail/providers/Folder;->isProviderFolder()Z

    move-result v3

    if-nez v3, :cond_2

    .line 539
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private recalculateList()V
    .locals 11

    .prologue
    .line 550
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->isClosed()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-nez v0, :cond_1

    .line 594
    :cond_0
    :goto_0
    return-void

    .line 554
    :cond_1
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 555
    iget-boolean v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mIsSectioned:Z

    if-nez v0, :cond_3

    .line 558
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->getDeficientDisplayOnlyFolder(Landroid/database/Cursor;)Lcom/android/mail/providers/Folder;

    move-result-object v2

    .line 559
    .local v2, "f":Lcom/android/mail/providers/Folder;
    iget-object v10, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    new-instance v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    const/4 v3, 0x3

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getPosition()I

    move-result v4

    const/4 v5, 0x0

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;IILcom/android/mail/ui/FolderListFragment$1;)V

    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 560
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_2

    .line 562
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->notifyDataSetChanged()V

    goto :goto_0

    .line 568
    .end local v2    # "f":Lcom/android/mail/providers/Folder;
    :cond_3
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 570
    .local v9, "userFolderList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;>;"
    :cond_4
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-static {v0}, Lcom/android/mail/providers/Folder;->getDeficientDisplayOnlyFolder(Landroid/database/Cursor;)Lcom/android/mail/providers/Folder;

    move-result-object v2

    .line 571
    .restart local v2    # "f":Lcom/android/mail/providers/Folder;
    invoke-virtual {v2}, Lcom/android/mail/providers/Folder;->isProviderFolder()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 572
    iget-object v10, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    new-instance v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    const/4 v3, 0x1

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getPosition()I

    move-result v4

    const/4 v5, 0x0

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;IILcom/android/mail/ui/FolderListFragment$1;)V

    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 576
    :goto_1
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-nez v0, :cond_4

    .line 578
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mRecentFolders:Lcom/android/mail/ui/RecentFolderList;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->getRecentFolders(Lcom/android/mail/ui/RecentFolderList;)Ljava/util/List;

    move-result-object v8

    .line 579
    .local v8, "recentFolderList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Folder;>;"
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_6

    .line 580
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    new-instance v1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    const v3, 0x7f0c0108

    const/4 v4, 0x0

    invoke-direct {v1, p0, v3, v4}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;ILcom/android/mail/ui/FolderListFragment$1;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 581
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "f":Lcom/android/mail/providers/Folder;
    check-cast v2, Lcom/android/mail/providers/Folder;

    .line 582
    .restart local v2    # "f":Lcom/android/mail/providers/Folder;
    iget-object v10, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    new-instance v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    const/4 v3, 0x2

    const/4 v4, -0x1

    const/4 v5, 0x0

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;IILcom/android/mail/ui/FolderListFragment$1;)V

    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 574
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v8    # "recentFolderList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Folder;>;"
    :cond_5
    new-instance v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    const/4 v3, 0x3

    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v1}, Landroid/database/Cursor;->getPosition()I

    move-result v4

    const/4 v5, 0x0

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;IILcom/android/mail/ui/FolderListFragment$1;)V

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 586
    .restart local v8    # "recentFolderList":Ljava/util/List;, "Ljava/util/List<Lcom/android/mail/providers/Folder;>;"
    :cond_6
    invoke-interface {v9}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_7

    .line 587
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    new-instance v1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    const v3, 0x7f0c0107

    const/4 v4, 0x0

    invoke-direct {v1, p0, v3, v4}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;ILcom/android/mail/ui/FolderListFragment$1;)V

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 588
    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .restart local v7    # "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    .line 589
    .local v6, "i":Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 593
    .end local v6    # "i":Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
    .end local v7    # "i$":Ljava/util/Iterator;
    :cond_7
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->notifyDataSetChanged()V

    goto/16 :goto_0
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 523
    const/4 v0, 0x0

    return v0
.end method

.method public final destroy()V
    .locals 1

    .prologue
    .line 614
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mRecentFolderObserver:Lcom/android/mail/providers/RecentFolderObserver;

    invoke-virtual {v0}, Lcom/android/mail/providers/RecentFolderObserver;->unregisterAndDestroy()V

    .line 615
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 511
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getFullFolder(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;)Lcom/android/mail/providers/Folder;
    .locals 4
    .param p1, "folderItem"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    .prologue
    const/4 v1, 0x0

    .line 619
    iget v2, p1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolderType:I

    const/4 v3, 0x2

    if-ne v2, v3, :cond_1

    .line 620
    iget-object v1, p1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    .line 631
    :cond_0
    :goto_0
    return-object v1

    .line 622
    :cond_1
    iget v0, p1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mPosition:I

    .line 623
    .local v0, "pos":I
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;
    invoke-static {v2}, Lcom/android/mail/ui/FolderListFragment;->access$1100(Lcom/android/mail/ui/FolderListFragment;)Landroid/database/Cursor;

    move-result-object v2

    if-eqz v2, :cond_2

    .line 624
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;
    invoke-static {v2}, Lcom/android/mail/ui/FolderListFragment;->access$1100(Lcom/android/mail/ui/FolderListFragment;)Landroid/database/Cursor;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    .line 625
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # setter for: Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;
    invoke-static {v2, v1}, Lcom/android/mail/ui/FolderListFragment;->access$1102(Lcom/android/mail/ui/FolderListFragment;Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 627
    :cond_2
    const/4 v2, -0x1

    if-le v0, v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    iget v3, p1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mPosition:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 629
    new-instance v1, Lcom/android/mail/providers/Folder;

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-direct {v1, v2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 604
    iget-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mItemList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 609
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->hashCode()I

    move-result v0

    int-to-long v0, v0

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 506
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    iget v0, v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mType:I

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 495
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    # invokes: Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    invoke-static {v0, p1, p2, p3}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->access$800(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 501
    const/4 v0, 0x2

    return v0
.end method

.method public isEnabled(I)Z
    .locals 2
    .param p1, "position"    # I

    .prologue
    const/4 v1, 0x1

    .line 517
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    iget v0, v0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mType:I

    if-eq v0, v1, :cond_0

    move v0, v1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCursor(Landroid/database/Cursor;)V
    .locals 0
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 598
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mCursor:Landroid/database/Cursor;

    .line 599
    invoke-direct {p0}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->recalculateList()V

    .line 600
    return-void
.end method
