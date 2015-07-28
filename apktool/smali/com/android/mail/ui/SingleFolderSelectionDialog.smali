.class public Lcom/android/mail/ui/SingleFolderSelectionDialog;
.super Lcom/android/mail/ui/FolderSelectionDialog;
.source "SingleFolderSelectionDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;
    }
.end annotation


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

.field private mBatch:Z

.field private mBuilder:Landroid/app/AlertDialog$Builder;

.field private mDialog:Landroid/app/AlertDialog;

.field private mExcludeFolder:Lcom/android/mail/providers/Folder;

.field final mRunner:Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;

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

.field private mUpdater:Lcom/android/mail/ui/ConversationUpdater;


# direct methods
.method private constructor <init>(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)V
    .locals 2
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
    .line 80
    .local p4, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-direct {p0}, Lcom/android/mail/ui/FolderSelectionDialog;-><init>()V

    .line 81
    iput-object p3, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    .line 82
    iput-object p4, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mTarget:Ljava/util/Collection;

    .line 83
    iput-boolean p5, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBatch:Z

    .line 84
    iput-object p6, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mExcludeFolder:Lcom/android/mail/providers/Folder;

    .line 85
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBuilder:Landroid/app/AlertDialog$Builder;

    .line 86
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBuilder:Landroid/app/AlertDialog$Builder;

    const v1, 0x7f0c00e0

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    .line 87
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBuilder:Landroid/app/AlertDialog$Builder;

    const v1, 0x7f0c00d3

    invoke-virtual {v0, v1, p0}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 88
    iput-object p2, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAccount:Lcom/android/mail/providers/Account;

    .line 89
    new-instance v0, Lcom/android/mail/ui/SeparatedFolderListAdapter;

    invoke-direct {v0, p1}, Lcom/android/mail/ui/SeparatedFolderListAdapter;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    .line 90
    new-instance v0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;-><init>(Lcom/android/mail/ui/SingleFolderSelectionDialog;Landroid/content/Context;Lcom/android/mail/ui/SingleFolderSelectionDialog$1;)V

    iput-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mRunner:Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;

    .line 91
    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Account;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Folder;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mExcludeFolder:Lcom/android/mail/providers/Folder;

    return-object v0
.end method

.method static synthetic access$300(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;

    return-object v0
.end method

.method static synthetic access$400(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Landroid/app/AlertDialog$Builder;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBuilder:Landroid/app/AlertDialog$Builder;

    return-object v0
.end method

.method static synthetic access$500(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Landroid/app/AlertDialog;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    return-object v0
.end method

.method static synthetic access$502(Lcom/android/mail/ui/SingleFolderSelectionDialog;Landroid/app/AlertDialog;)Landroid/app/AlertDialog;
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;
    .param p1, "x1"    # Landroid/app/AlertDialog;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    return-object p1
.end method

.method static synthetic access$600(Lcom/android/mail/ui/SingleFolderSelectionDialog;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->showInternal()V

    return-void
.end method

.method static synthetic access$700(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Ljava/util/Collection;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mTarget:Ljava/util/Collection;

    return-object v0
.end method

.method static synthetic access$800(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBatch:Z

    return v0
.end method

.method static synthetic access$900(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/ConversationUpdater;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mUpdater:Lcom/android/mail/ui/ConversationUpdater;

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)Lcom/android/mail/ui/SingleFolderSelectionDialog;
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
            "Lcom/android/mail/ui/SingleFolderSelectionDialog;"
        }
    .end annotation

    .prologue
    .line 59
    .local p3, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    invoke-static {}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->isShown()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 60
    const/4 v0, 0x0

    .line 62
    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/android/mail/ui/SingleFolderSelectionDialog;

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move v5, p4

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/android/mail/ui/SingleFolderSelectionDialog;-><init>(Landroid/content/Context;Lcom/android/mail/providers/Account;Lcom/android/mail/ui/ConversationUpdater;Ljava/util/Collection;ZLcom/android/mail/providers/Folder;)V

    goto :goto_0
.end method

.method private final showInternal()V
    .locals 2

    .prologue
    .line 155
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 156
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0}, Landroid/app/AlertDialog;->getListView()Landroid/widget/ListView;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/SingleFolderSelectionDialog$1;-><init>(Lcom/android/mail/ui/SingleFolderSelectionDialog;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 171
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;

    invoke-virtual {v0, p0}, Landroid/app/AlertDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 172
    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 177
    return-void
.end method

.method public show()V
    .locals 2

    .prologue
    .line 147
    invoke-super {p0}, Lcom/android/mail/ui/FolderSelectionDialog;->show()V

    .line 148
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog;->mRunner:Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 149
    return-void
.end method
