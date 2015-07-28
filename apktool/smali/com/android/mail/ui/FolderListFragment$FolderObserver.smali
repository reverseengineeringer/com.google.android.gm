.class final Lcom/android/mail/ui/FolderListFragment$FolderObserver;
.super Landroid/database/DataSetObserver;
.source "FolderListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/FolderListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "FolderObserver"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/FolderListFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/FolderListFragment;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/android/mail/ui/FolderListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/FolderListFragment;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/FolderListFragment;Lcom/android/mail/ui/FolderListFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/FolderListFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/FolderListFragment$1;

    .prologue
    .line 103
    invoke-direct {p0, p1}, Lcom/android/mail/ui/FolderListFragment$FolderObserver;-><init>(Lcom/android/mail/ui/FolderListFragment;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 3

    .prologue
    .line 106
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {v1}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v1

    if-nez v1, :cond_1

    .line 114
    :cond_0
    :goto_0
    return-void

    .line 109
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/FolderListFragment;

    # getter for: Lcom/android/mail/ui/FolderListFragment;->mActivity:Lcom/android/mail/ui/ControllableActivity;
    invoke-static {v1}, Lcom/android/mail/ui/FolderListFragment;->access$000(Lcom/android/mail/ui/FolderListFragment;)Lcom/android/mail/ui/ControllableActivity;

    move-result-object v1

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getFolderController()Lcom/android/mail/ui/FolderController;

    move-result-object v0

    .line 110
    .local v0, "controller":Lcom/android/mail/ui/FolderController;
    if-eqz v0, :cond_0

    .line 113
    iget-object v1, p0, Lcom/android/mail/ui/FolderListFragment$FolderObserver;->this$0:Lcom/android/mail/ui/FolderListFragment;

    invoke-interface {v0}, Lcom/android/mail/ui/FolderController;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v2

    # invokes: Lcom/android/mail/ui/FolderListFragment;->setSelectedFolder(Lcom/android/mail/providers/Folder;)V
    invoke-static {v1, v2}, Lcom/android/mail/ui/FolderListFragment;->access$100(Lcom/android/mail/ui/FolderListFragment;Lcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method
