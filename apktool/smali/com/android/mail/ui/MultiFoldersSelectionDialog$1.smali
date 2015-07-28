.class Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;
.super Ljava/lang/Object;
.source "MultiFoldersSelectionDialog.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/MultiFoldersSelectionDialog;->showInternal()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)V
    .locals 0

    .prologue
    .line 180
    iput-object p1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
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
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 183
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    # getter for: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$200(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v1

    invoke-virtual {v1, p3}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    .line 184
    .local v0, "item":Ljava/lang/Object;
    instance-of v1, v0, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    if-eqz v1, :cond_0

    .line 185
    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    check-cast v0, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    .end local v0    # "item":Ljava/lang/Object;
    # invokes: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->update(Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;)V
    invoke-static {v1, v0}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$500(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;)V

    .line 187
    :cond_0
    return-void
.end method
