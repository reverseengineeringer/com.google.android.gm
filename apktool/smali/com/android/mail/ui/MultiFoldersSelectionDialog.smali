.class public Lcom/android/mail/ui/MultiFoldersSelectionDialog;
.super Lcom/android/mail/ui/FolderSelectionDialog;
.source "MultiFoldersSelectionDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;
    }
.end annotation


# instance fields
.field private final mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

.field private final mBatch:Z

.field private mDialog:Landroid/app/AlertDialog;

.field private final mOperations:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/net/Uri;",
            "Lcom/android/mail/ui/FolderOperation;",
            ">;"
        }
    .end annotation
.end field

.field private final mRunner:Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;

.field private final mSingle:Z

.field private final mTarget:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field private final mUpdater:Lcom/android/mail/ui/ConversationUpdater;


# direct methods
.method private constructor <init>(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)V
    .locals 7
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "account"    # Lcom/android/mail/providers/Account;
    .param p3, "updater"    # Lcom/android/mail/ui/ConversationUpdater;
    .param p5, "isBatch"    # Z
    .param p6, "currentFolder"    # Lcom/android/mail/providers/Folder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/android/mail/providers/Account;",
            "Lcom/android/mail/ui/ConversationUpdater;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;Z",
            "Lcom/android/mail/providers/Folder;",
            ")V"
        }
    .end annotation

    .prologue
    .line 82
    .local p4, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-direct {p0}, Lcom/android/mail/ui/FolderSelectionDialog;-><init>()V

    .line 83
    iput-object p3, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    .line 84
    iput-object p4, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mTarget:Ljava/util/Collection;

    .line 85
    iput-boolean p5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mBatch:Z

    .line 87
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mOperations:Ljava/util/HashMap;

    .line 88
    new-instance v4, Landroid/app/AlertDialog$Builder;

    invoke-direct {v4, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 89
    .local v4, "builder":Landroid/app/AlertDialog$Builder;
    const v0, 0x7f0c00e0

    invoke-virtual {v4, v0}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 90
    const v0, 0x7f0c00d2

    invoke-virtual {v4, v0, p0}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 91
    const v0, 0x7f0c00d3

    invoke-virtual {v4, v0, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 92
    const/16 v0, 0x2000

    invoke-virtual {p2, v0}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mSingle:Z

    .line 94
    new-instance v0, Lcom/android/mail/ui/SeparatedFolderListAdapter;

    invoke-direct {v0, p1}, Lcom/android/mail/ui/SeparatedFolderListAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    .line 95
    new-instance v0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;

    const/4 v6, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v5, p6

    invoke-direct/range {v0 .. v6}, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;-><init>(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Landroid/content/Context;Lcom/android/mail/providers/Account;Landroid/app/AlertDialog$Builder;Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mRunner:Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;

    .line 96
    return-void

    .line 92
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)Ljava/util/Collection;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mTarget:Ljava/util/Collection;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    return-object v0
.end method

.method static synthetic access$302(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Landroid/app/AlertDialog;)Landroid/app/AlertDialog;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog;
    .param p1, "x1"    # Landroid/app/AlertDialog;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    return-object p1
.end method

.method static synthetic access$400(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->showInternal()V

    return-void
.end method

.method static synthetic access$500(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog;
    .param p1, "x1"    # Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    .prologue
    .line 48
    invoke-direct {p0, p1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->update(Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;)V

    return-void
.end method

.method public static getInstance(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)Lcom/android/mail/ui/MultiFoldersSelectionDialog;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Lcom/android/mail/providers/Account;
    .param p2, "updater"    # Lcom/android/mail/ui/ConversationUpdater;
    .param p4, "isBatch"    # Z
    .param p5, "currentFolder"    # Lcom/android/mail/providers/Folder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/android/mail/providers/Account;",
            "Lcom/android/mail/ui/ConversationUpdater;",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;Z",
            "Lcom/android/mail/providers/Folder;",
            ")",
            "Lcom/android/mail/ui/MultiFoldersSelectionDialog;"
        }
    .end annotation

    .prologue
    .line 61
    .local p3, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-static {}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 62
    const/4 v0, 0x0

    .line 64
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;-><init>(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method private final showInternal()V
    .locals 2

    .prologue
    .line 179
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 180
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->getListView()Landroid/widget/ListView;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;-><init>(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 189
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0, p0}, Landroid/app/AlertDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 190
    return-void
.end method

.method private final update(Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;)V
    .locals 10
    .param p1, "row"    # Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    .prologue
    const/4 v6, 0x0

    .line 199
    invoke-virtual {p1}, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;->isPresent()Z

    move-result v5

    if-nez v5, :cond_0

    const/4 v0, 0x1

    .line 200
    .local v0, "add":Z
    :goto_0
    iget-boolean v5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mSingle:Z

    if-eqz v5, :cond_3

    .line 201
    if-nez v0, :cond_1

    .line 220
    :goto_1
    return-void

    .end local v0    # "add":Z
    :cond_0
    move v0, v6

    .line 199
    goto :goto_0

    .line 207
    .restart local v0    # "add":Z
    :cond_1
    const/4 v2, 0x0

    .local v2, "i":I
    iget-object v5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    invoke-virtual {v5}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->getCount()I

    move-result v4

    .local v4, "size":I
    :goto_2
    if-ge v2, v4, :cond_3

    .line 208
    iget-object v5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    invoke-virtual {v5, v2}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v3

    .line 209
    .local v3, "item":Ljava/lang/Object;
    instance-of v5, v3, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    if-eqz v5, :cond_2

    move-object v5, v3

    .line 210
    check-cast v5, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    invoke-virtual {v5, v6}, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;->setIsPresent(Z)V

    .line 211
    check-cast v3, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;

    .end local v3    # "item":Ljava/lang/Object;
    invoke-virtual {v3}, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 212
    .local v1, "folder":Lcom/android/mail/providers/Folder;
    iget-object v5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mOperations:Ljava/util/HashMap;

    iget-object v7, v1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    new-instance v8, Lcom/android/mail/ui/FolderOperation;

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v9

    invoke-direct {v8, v1, v9}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-virtual {v5, v7, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 207
    .end local v1    # "folder":Lcom/android/mail/providers/Folder;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .line 216
    .end local v2    # "i":I
    .end local v4    # "size":I
    :cond_3
    invoke-virtual {p1, v0}, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;->setIsPresent(Z)V

    .line 217
    iget-object v5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    invoke-virtual {v5}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->notifyDataSetChanged()V

    .line 218
    invoke-virtual {p1}, Lcom/android/mail/ui/FolderSelectorAdapter$FolderRow;->getFolder()Lcom/android/mail/providers/Folder;

    move-result-object v1

    .line 219
    .restart local v1    # "folder":Lcom/android/mail/providers/Folder;
    iget-object v5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mOperations:Ljava/util/HashMap;

    iget-object v6, v1, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    new-instance v7, Lcom/android/mail/ui/FolderOperation;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-direct {v7, v1, v8}, Lcom/android/mail/ui/FolderOperation;-><init>(Lcom/android/mail/providers/Folder;Ljava/lang/Boolean;)V

    invoke-virtual {v5, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 224
    packed-switch p2, :pswitch_data_0

    .line 235
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 226
    :pswitch_1
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    if-eqz v0, :cond_0

    .line 227
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mOperations:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mTarget:Ljava/util/Collection;

    iget-boolean v3, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mBatch:Z

    const/4 v4, 0x1

    invoke-interface {v0, v1, v2, v3, v4}, Lcom/android/mail/ui/ConversationUpdater;->assignFolder(Ljava/util/Collection;Ljava/util/Collection;ZZ)V

    goto :goto_0

    .line 224
    nop

    :pswitch_data_0
    .packed-switch -0x2
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public show()V
    .locals 2

    .prologue
    .line 171
    invoke-super {p0}, Lcom/android/mail/ui/FolderSelectionDialog;->show()V

    .line 172
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mRunner:Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 173
    return-void
.end method
