.class final Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;
.super Landroid/os/AsyncTask;
.source "SingleFolderSelectionDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/SingleFolderSelectionDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "QueryRunner"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field final synthetic this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/SingleFolderSelectionDialog;Landroid/content/Context;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 100
    iput-object p1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 101
    iput-object p2, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    .line 102
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/SingleFolderSelectionDialog;Landroid/content/Context;Lcom/android/mail/ui/SingleFolderSelectionDialog$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/SingleFolderSelectionDialog;
    .param p2, "x1"    # Landroid/content/Context;
    .param p3, "x2"    # Lcom/android/mail/ui/SingleFolderSelectionDialog$1;

    .prologue
    .line 97
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;-><init>(Lcom/android/mail/ui/SingleFolderSelectionDialog;Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 97
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 12
    .param p1, "v"    # [Ljava/lang/Void;

    .prologue
    const/4 v11, 0x0

    .line 106
    const/4 v9, 0x0

    .line 108
    .local v9, "foldersCursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$100(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->isEmpty(Landroid/net/Uri;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$100(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    :goto_0
    sget-object v2, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v2

    .line 114
    .end local v9    # "foldersCursor":Landroid/database/Cursor;
    .local v2, "foldersCursor":Landroid/database/Cursor;
    :try_start_1
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e0008

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v10

    .line 118
    .local v10, "headers":[Ljava/lang/String;
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v0}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$300(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v6

    new-instance v0, Lcom/android/mail/ui/SystemFolderSelectorAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    const v3, 0x7f040068

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mExcludeFolder:Lcom/android/mail/providers/Folder;
    invoke-static {v5}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$200(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Folder;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/SystemFolderSelectorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;ILjava/lang/String;Lcom/android/mail/providers/Folder;)V

    invoke-virtual {v6, v0}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->addSection(Lcom/android/mail/ui/FolderSelectorAdapter;)V

    .line 123
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v0}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$300(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v0

    new-instance v3, Lcom/android/mail/ui/HierarchicalFolderSelectorAdapter;

    iget-object v4, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/android/mail/ui/AddableFolderSelectorAdapter;->filterFolders(Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v5

    const v6, 0x7f040068

    const/4 v1, 0x2

    aget-object v7, v10, v1

    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mExcludeFolder:Lcom/android/mail/providers/Folder;
    invoke-static {v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$200(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Folder;

    move-result-object v8

    invoke-direct/range {v3 .. v8}, Lcom/android/mail/ui/HierarchicalFolderSelectorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;ILjava/lang/String;Lcom/android/mail/providers/Folder;)V

    invoke-virtual {v0, v3}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->addSection(Lcom/android/mail/ui/FolderSelectorAdapter;)V

    .line 126
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBuilder:Landroid/app/AlertDialog$Builder;
    invoke-static {v0}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$400(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$300(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v1

    iget-object v3, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    invoke-virtual {v0, v1, v3}, Landroid/app/AlertDialog$Builder;->setAdapter(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 128
    if-eqz v2, :cond_0

    .line 129
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 132
    :cond_0
    return-object v11

    .line 108
    .end local v2    # "foldersCursor":Landroid/database/Cursor;
    .end local v10    # "headers":[Ljava/lang/String;
    .restart local v9    # "foldersCursor":Landroid/database/Cursor;
    :cond_1
    :try_start_2
    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mAccount:Lcom/android/mail/providers/Account;
    invoke-static {v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$100(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Lcom/android/mail/providers/Account;

    move-result-object v1

    iget-object v1, v1, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 128
    :catchall_0
    move-exception v0

    move-object v2, v9

    .end local v9    # "foldersCursor":Landroid/database/Cursor;
    .restart local v2    # "foldersCursor":Landroid/database/Cursor;
    :goto_1
    if-eqz v2, :cond_2

    .line 129
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    :cond_2
    throw v0

    .line 128
    :catchall_1
    move-exception v0

    goto :goto_1
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 97
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "v"    # Ljava/lang/Void;

    .prologue
    .line 137
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    iget-object v1, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # getter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mBuilder:Landroid/app/AlertDialog$Builder;
    invoke-static {v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$400(Lcom/android/mail/ui/SingleFolderSelectionDialog;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    # setter for: Lcom/android/mail/ui/SingleFolderSelectionDialog;->mDialog:Landroid/app/AlertDialog;
    invoke-static {v0, v1}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$502(Lcom/android/mail/ui/SingleFolderSelectionDialog;Landroid/app/AlertDialog;)Landroid/app/AlertDialog;

    .line 138
    iget-object v0, p0, Lcom/android/mail/ui/SingleFolderSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/SingleFolderSelectionDialog;

    # invokes: Lcom/android/mail/ui/SingleFolderSelectionDialog;->showInternal()V
    invoke-static {v0}, Lcom/android/mail/ui/SingleFolderSelectionDialog;->access$600(Lcom/android/mail/ui/SingleFolderSelectionDialog;)V

    .line 139
    return-void
.end method
