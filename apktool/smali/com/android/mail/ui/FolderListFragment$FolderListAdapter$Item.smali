.class Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
.super Ljava/lang/Object;
.source "FolderListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "Item"
.end annotation


# instance fields
.field public final mFolder:Lcom/android/mail/providers/Folder;

.field public final mFolderType:I

.field public mPosition:I

.field public final mResource:I

.field public final mType:I

.field final synthetic this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;I)V
    .locals 1
    .param p2, "resource"    # I

    .prologue
    .line 414
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 415
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    .line 416
    iput p2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mResource:I

    .line 417
    const/4 v0, 0x1

    iput v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mType:I

    .line 418
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolderType:I

    .line 419
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;ILcom/android/mail/ui/FolderListFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/android/mail/ui/FolderListFragment$1;

    .prologue
    .line 376
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;I)V

    return-void
.end method

.method private constructor <init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;II)V
    .locals 1
    .param p2, "folder"    # Lcom/android/mail/providers/Folder;
    .param p3, "folderType"    # I
    .param p4, "cursorPosition"    # I

    .prologue
    .line 403
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 404
    iput-object p2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    .line 405
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mResource:I

    .line 406
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mType:I

    .line 407
    iput p3, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolderType:I

    .line 408
    iput p4, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mPosition:I

    .line 409
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;IILcom/android/mail/ui/FolderListFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;
    .param p2, "x1"    # Lcom/android/mail/providers/Folder;
    .param p3, "x2"    # I
    .param p4, "x3"    # I
    .param p5, "x4"    # Lcom/android/mail/ui/FolderListFragment$1;

    .prologue
    .line 376
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;-><init>(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;Lcom/android/mail/providers/Folder;II)V

    return-void
.end method

.method static synthetic access$800(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;
    .param p1, "x1"    # I
    .param p2, "x2"    # Landroid/view/View;
    .param p3, "x3"    # Landroid/view/ViewGroup;

    .prologue
    .line 376
    invoke-direct {p0, p1, p2, p3}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private final getFolderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v1, 0x0

    .line 457
    if-eqz p2, :cond_2

    move-object v0, p2

    .line 458
    check-cast v0, Lcom/android/mail/ui/FolderItemView;

    .line 463
    .local v0, "folderItemView":Lcom/android/mail/ui/FolderItemView;
    :goto_0
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    iget-object v3, v3, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {v3}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/android/mail/ui/FolderItemView;->bind(Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/FolderItemView$DropHandler;)V

    .line 464
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    iget-object v2, v2, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;
    invoke-static {v2}, Lcom/android/mail/ui/FolderListFragment;->access$500(Lcom/android/mail/ui/FolderListFragment;)Landroid/widget/ListView;

    move-result-object v2

    if-eqz v2, :cond_1

    .line 465
    iget v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolderType:I

    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    iget-object v3, v3, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderType:I
    invoke-static {v3}, Lcom/android/mail/ui/FolderListFragment;->access$600(Lcom/android/mail/ui/FolderListFragment;)I

    move-result v3

    if-ne v2, v3, :cond_0

    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    iget-object v2, v2, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    iget-object v3, v3, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mSelectedFolderUri:Landroid/net/Uri;
    invoke-static {v3}, Lcom/android/mail/ui/FolderListFragment;->access$700(Lcom/android/mail/ui/FolderListFragment;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/net/Uri;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    .line 467
    .local v1, "isSelected":Z
    :cond_0
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    iget-object v2, v2, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mListView:Landroid/widget/ListView;
    invoke-static {v2}, Lcom/android/mail/ui/FolderListFragment;->access$500(Lcom/android/mail/ui/FolderListFragment;)Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {v2, p1, v1}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 469
    .end local v1    # "isSelected":Z
    :cond_1
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    const v3, 0x7f1000bc

    invoke-virtual {v0, v3}, Lcom/android/mail/ui/FolderItemView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/android/mail/providers/Folder;->setFolderBlockColor(Lcom/android/mail/providers/Folder;Landroid/view/View;)V

    .line 470
    iget-object v3, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mFolder:Lcom/android/mail/providers/Folder;

    const v2, 0x7f10003b

    invoke-virtual {v0, v2}, Lcom/android/mail/ui/FolderItemView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    invoke-static {v3, v2}, Lcom/android/mail/providers/Folder;->setIcon(Lcom/android/mail/providers/Folder;Landroid/widget/ImageView;)V

    .line 471
    return-object v0

    .line 460
    .end local v0    # "folderItemView":Lcom/android/mail/ui/FolderItemView;
    :cond_2
    iget-object v2, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    # getter for: Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mInflater:Landroid/view/LayoutInflater;
    invoke-static {v2}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->access$400(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)Landroid/view/LayoutInflater;

    move-result-object v2

    const v3, 0x7f04003e

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/FolderItemView;

    .restart local v0    # "folderItemView":Lcom/android/mail/ui/FolderItemView;
    goto :goto_0
.end method

.method private final getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 437
    if-eqz p2, :cond_0

    move-object v0, p2

    .line 438
    check-cast v0, Landroid/widget/TextView;

    .line 443
    .local v0, "headerView":Landroid/widget/TextView;
    :goto_0
    iget v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mResource:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 444
    return-object v0

    .line 440
    .end local v0    # "headerView":Landroid/widget/TextView;
    :cond_0
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->this$1:Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;

    # getter for: Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->mInflater:Landroid/view/LayoutInflater;
    invoke-static {v1}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;->access$400(Lcom/android/mail/ui/FolderListFragment$FolderListAdapter;)Landroid/view/LayoutInflater;

    move-result-object v1

    const v2, 0x7f040040

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .restart local v0    # "headerView":Landroid/widget/TextView;
    goto :goto_0
.end method

.method private final getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 422
    iget v0, p0, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->mType:I

    if-nez v0, :cond_0

    .line 423
    invoke-direct {p0, p1, p2, p3}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->getFolderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 425
    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/android/mail/ui/FolderListFragment$FolderListAdapter$Item;->getHeaderView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method
