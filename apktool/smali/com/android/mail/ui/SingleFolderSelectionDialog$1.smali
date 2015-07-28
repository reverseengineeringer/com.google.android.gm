.class Lcom/android/mail/ui/SingleFolderSelectionDialog$1;
.super Ljava/lang/Object;
.source "SingleFolderSelectionDialog.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/SingleFolderSelectionDialog;->showInternal()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/SingleFolderSelectionDialog;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 7
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v6, 0x1

    .line 159
    iget-object v3, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v3}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$300(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v3

    invoke-virtual {v3, p3}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    .line 160
    .local v1, "item":Ljava/lang/Object;
    instance-of v3, v1, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    if-eqz v3, :cond_0

    .line 161
    check-cast v1, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    .end local v1    # "item":Ljava/lang/Object;
    invoke-virtual {v1}, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v0

    .line 162
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 164
    .local v2, "ops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/FolderOperation;>;"
    new-instance v3, Lcom/android/mail/ui/FolderOperation;

    iget-object v4, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mExcludeFolder:Lcom/android/mail/providers/Folder;
    invoke-static {v4}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$200(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Folder;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 165
    new-instance v3, Lcom/android/mail/ui/FolderOperation;

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-direct {v3, v0, v4}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 166
    iget-object v3, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;
    invoke-static {v3}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$900(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/ConversationUpdater;

    move-result-object v3

    iget-object v4, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mTarget:Ljava/util/Collection;
    invoke-static {v4}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$700(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Ljava/util/Collection;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBatch:Z
    invoke-static {v5}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$800(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Z

    move-result v5

    invoke-interface {v3, v2, v4, v5, v6}, Lcom/android/mail/ui/ConversationUpdater;->assignFolder(Ljava/util/Collection;Ljava/util/Collection;ZZ)V

    .line 167
    iget-object v3, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;
    invoke-static {v3}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$500(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Landroid/app/AlertDialog;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/AlertDialog;->dismiss()V

    .line 169
    .end local v0    # "folder":Lcom/android/mail/providers/Folder;
    .end local v2    # "ops":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/ui/FolderOperation;>;"
    :cond_0
    return-void
.end method
