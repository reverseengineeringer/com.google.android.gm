.class Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;
.super Landroid/widget/ArrayAdapter;
.source "FolderListFragment.java"

# interfaces
.implements Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HierarchicalFolderListAdapter"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lcom/android/mail/providers/Folder;",
        ">;",
        "Lcom/android/mail/ui/FolderListFragment$FolderListFragmentCursorAdapter;"
    }
.end annotation


# instance fields
.field private mCursor:Landroid/database/Cursor;

.field private final mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

.field private final mParent:Lcom/android/mail/providers/Folder;

.field private final mParentUri:Landroid/net/Uri;

.field final synthetic this$0:Lcom/android/mail/ui/FolderListFragment;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/FolderListFragment;Landroid/database/Cursor;Lcom/android/mail/providers/Folder;)V
    .locals 2
    .param p2, "c"    # Landroid/database/Cursor;
    .param p3, "parentFolder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 647
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    .line 648
    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {p1}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v0

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f04003e

    invoke-direct {p0, v0, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 649
    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {p1}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    .line 650
    iput-object p3, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParent:Lcom/android/mail/providers/Folder;

    .line 651
    iget-object v0, p3, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParentUri:Landroid/net/Uri;

    .line 652
    invoke-virtual {p0, p2}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->setCursor(Landroid/database/Cursor;)V

    .line 653
    return-void
.end method


# virtual methods
.method public destroy()V
    .locals 0

    .prologue
    .line 707
    return-void
.end method

.method public getFullFolder(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;)Lcom/android/mail/providers/Folder;
    .locals 4
    .param p1, "folderItem"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;

    .prologue
    const/4 v1, 0x0

    .line 711
    iget v0, p1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mPosition:I

    .line 712
    .local v0, "pos":I
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 714
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;
    invoke-static {v2}, Lcom/android/mail/ui/FolderListFragment;->access$1100(Lcom/android/mail/ui/FolderListFragment;)Landroid/database/Cursor;

    move-result-object v2

    iput-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    .line 715
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # setter for: Lcom/android/mail/ui/FolderListFragment;->mFutureData:Landroid/database/Cursor;
    invoke-static {v2, v1}, Lcom/android/mail/ui/FolderListFragment;->access$1102(Lcom/android/mail/ui/FolderListFragment;Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 717
    :cond_1
    const/4 v2, -0x1

    if-le v0, v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-interface {v2}, Landroid/database/Cursor;->isClosed()Z

    move-result v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    iget v3, p1, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mPosition:I

    invoke-interface {v2, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 719
    new-instance v1, Lcom/android/mail/providers/Folder;

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    invoke-direct {v1, v2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .line 721
    :cond_2
    return-object v1
.end method

.method public getItemViewType(I)I
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 663
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 664
    .local v0, "f":Lcom/android/mail/providers/Folder;
    iget-object v1, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParentUri:Landroid/net/Uri;

    invoke-virtual {v1, v2}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 670
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    .line 671
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    iget-object v4, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v5, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParentUri:Landroid/net/Uri;

    invoke-virtual {v4, v5}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 672
    .local v2, "isParent":Z
    if-eqz p2, :cond_1

    move-object v1, p2

    .line 673
    check-cast v1, Lcom/android/mail/ui/FolderItemView;

    .line 679
    .local v1, "folderItemView":Lcom/android/mail/ui/FolderItemView;
    :goto_0
    iget-object v4, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mDropHandler:Lcom/android/mail/ui/FolderItemView$DropHandler;

    invoke-virtual {v1, v0, v4}, Lcom/android/mail/ui/FolderItemView;->bind(Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/FolderItemView$DropHandler;)V

    .line 680
    iget-object v4, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v5, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;
    invoke-static {v5}, Lcom/android/mail/ui/FolderListFragment;->access$700(Lcom/android/mail/ui/FolderListFragment;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 681
    iget-object v4, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    invoke-virtual {v4}, Lcom/android/mail/ui/FolderListFragment;->getListView()Landroid/widget/ListView;

    move-result-object v4

    const/4 v5, 0x1

    invoke-virtual {v4, p1, v5}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 683
    :cond_0
    const v4, 0x7f10003b

    invoke-virtual {v1, v4}, Lcom/android/mail/ui/FolderItemView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/android/mail/providers/Folder;->setFolderBlockColor(Lcom/android/mail/providers/Folder;Landroid/view/View;)V

    .line 684
    return-object v1

    .line 675
    .end local v1    # "folderItemView":Lcom/android/mail/ui/FolderItemView;
    :cond_1
    if-eqz v2, :cond_2

    const v3, 0x7f04003e

    .line 676
    .local v3, "resId":I
    :goto_1
    iget-object v4, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {v4}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v4

    invoke-interface {v4}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v4, v3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/android/mail/ui/FolderItemView;

    .restart local v1    # "folderItemView":Lcom/android/mail/ui/FolderItemView;
    goto :goto_0

    .line 675
    .end local v1    # "folderItemView":Lcom/android/mail/ui/FolderItemView;
    .end local v3    # "resId":I
    :cond_2
    const v3, 0x7f040013

    goto :goto_1
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 658
    const/4 v0, 0x2

    return v0
.end method

.method public setCursor(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 689
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mCursor:Landroid/database/Cursor;

    .line 690
    invoke-virtual {p0}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->clear()V

    .line 691
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParent:Lcom/android/mail/providers/Folder;

    if-eqz v1, :cond_0

    .line 692
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParent:Lcom/android/mail/providers/Folder;

    invoke-virtual {p0, v1}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->add(Ljava/lang/Object;)V

    .line 694
    :cond_0
    if-eqz p1, :cond_2

    invoke-interface {p1}, Landroid/database/Cursor;->getCount()I

    move-result v1

    if-lez v1, :cond_2

    .line 695
    invoke-interface {p1}, Landroid/database/Cursor;->moveToFirst()Z

    .line 697
    :cond_1
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0, p1}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .line 698
    .local v0, "f":Lcom/android/mail/providers/Folder;
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->mParent:Lcom/android/mail/providers/Folder;

    iput-object v1, v0, Lcom/android/mail/providers/Folder;->parent:Lcom/android/mail/providers/Folder;

    .line 699
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/FolderListFragment$HierarchicalFolderListAdapter;->add(Ljava/lang/Object;)V

    .line 700
    invoke-interface {p1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-nez v1, :cond_1

    .line 702
    .end local v0    # "f":Lcom/android/mail/providers/Folder;
    :cond_2
    return-void
.end method
