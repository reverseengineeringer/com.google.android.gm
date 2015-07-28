.class final Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;
.super Landroid/os/AsyncTask;
.source "MultiFoldersSelectionDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/MultiFoldersSelectionDialog;
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
.field private final mAccount:Lcom/android/mail/providers/Account;

.field private final mBuilder:Landroid/app/AlertDialog$Builder;

.field private final mContext:Landroid/content/Context;

.field private final mCurrentFolder:Lcom/android/mail/providers/Folder;

.field final synthetic this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Landroid/content/Context;Lcom/android/mail/providers/Account;Landroid/app/AlertDialog$Builder;Lcom/android/mail/providers/Folder;)V
    .locals 0
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "account"    # Lcom/android/mail/providers/Account;
    .param p4, "builder"    # Landroid/app/AlertDialog$Builder;
    .param p5, "currentFolder"    # Lcom/android/mail/providers/Folder;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 110
    iput-object p2, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    .line 111
    iput-object p3, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mAccount:Lcom/android/mail/providers/Account;

    .line 112
    iput-object p4, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mBuilder:Landroid/app/AlertDialog$Builder;

    .line 113
    iput-object p5, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    .line 114
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Landroid/content/Context;Lcom/android/mail/providers/Account;Landroid/app/AlertDialog$Builder;Lcom/android/mail/providers/Folder;Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog;
    .param p2, "x1"    # Landroid/content/Context;
    .param p3, "x2"    # Lcom/android/mail/providers/Account;
    .param p4, "x3"    # Landroid/app/AlertDialog$Builder;
    .param p5, "x4"    # Lcom/android/mail/providers/Folder;
    .param p6, "x5"    # Lcom/android/mail/ui/MultiFoldersSelectionDialog$1;

    .prologue
    .line 102
    invoke-direct/range {p0 .. p5}, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;-><init>(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Landroid/content/Context;Lcom/android/mail/providers/Account;Landroid/app/AlertDialog$Builder;Lcom/android/mail/providers/Folder;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 102
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 12
    .param p1, "v"    # [Ljava/lang/Void;

    .prologue
    const/4 v11, 0x0

    .line 118
    const/4 v7, 0x0

    .line 120
    .local v7, "foldersCursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    invoke-static {v1}, Lcom/android/mail/utils/Utils;->isEmpty(Landroid/net/Uri;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->fullFolderListUri:Landroid/net/Uri;

    :goto_0
    sget-object v2, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 125
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 126
    .local v3, "checked":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    # getter for: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mTarget:Ljava/util/Collection;
    invoke-static {v0}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$100(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    .local v8, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/android/mail/providers/Conversation;

    .line 127
    .local v6, "conversation":Lcom/android/mail/providers/Conversation;
    invoke-virtual {v6}, Lcom/android/mail/providers/Conversation;->getRawFolders()Ljava/util/ArrayList;

    move-result-object v9

    .line 128
    .local v9, "rawFolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    if-eqz v6, :cond_2

    if-eqz v9, :cond_2

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 130
    invoke-static {v9}, Lcom/android/mail/providers/Folder;->getUriArray(Ljava/util/ArrayList;)[Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/HashSet;->addAll(Ljava/util/Collection;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 153
    .end local v3    # "checked":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    .end local v6    # "conversation":Lcom/android/mail/providers/Conversation;
    .end local v8    # "i$":Ljava/util/Iterator;
    .end local v9    # "rawFolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    :catchall_0
    move-exception v0

    if-eqz v7, :cond_0

    .line 154
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    :cond_0
    throw v0

    .line 120
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->folderListUri:Landroid/net/Uri;

    goto :goto_0

    .line 134
    .restart local v3    # "checked":Ljava/util/HashSet;, "Ljava/util/HashSet<Ljava/lang/String;>;"
    .restart local v6    # "conversation":Lcom/android/mail/providers/Conversation;
    .restart local v8    # "i$":Ljava/util/Iterator;
    .restart local v9    # "rawFolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    :cond_2
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mCurrentFolder:Lcom/android/mail/providers/Folder;

    iget-object v0, v0, Lcom/android/mail/providers/Folder;->uri:Landroid/net/Uri;

    invoke-virtual {v0}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/util/HashSet;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 148
    .end local v6    # "conversation":Lcom/android/mail/providers/Conversation;
    .end local v9    # "rawFolders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/android/mail/providers/Folder;>;"
    :cond_3
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    # getter for: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v0}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$200(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v10

    new-instance v0, Lcom/android/mail/ui/AddableFolderSelectorAdapter;

    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mContext:Landroid/content/Context;

    invoke-static {v7}, Lcom/android/mail/ui/AddableFolderSelectorAdapter;->filterFolders(Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v2

    const v4, 0x7f040058

    const/4 v5, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/android/mail/ui/AddableFolderSelectorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;Ljava/util/Set;ILjava/lang/String;)V

    invoke-virtual {v10, v0}, Lcom/android/mail/ui/SeparatedFolderListAdapter;->addSection(Lcom/android/mail/ui/FolderSelectorAdapter;)V

    .line 151
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mBuilder:Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    # getter for: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mAdapter:Lcom/android/mail/ui/SeparatedFolderListAdapter;
    invoke-static {v1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$200(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)Lcom/android/mail/ui/SeparatedFolderListAdapter;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setAdapter(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 153
    if-eqz v7, :cond_4

    .line 154
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 157
    :cond_4
    return-object v11
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 102
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "v"    # Ljava/lang/Void;

    .prologue
    .line 161
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    iget-object v1, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->mBuilder:Landroid/app/AlertDialog$Builder;

    invoke-virtual {v1}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    # setter for: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->mDialog:Landroid/app/AlertDialog;
    invoke-static {v0, v1}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$302(Lcom/android/mail/ui/MultiFoldersSelectionDialog;Landroid/app/AlertDialog;)Landroid/app/AlertDialog;

    .line 162
    iget-object v0, p0, Lcom/android/mail/ui/MultiFoldersSelectionDialog$QueryRunner;->this$0:Lcom/android/mail/ui/MultiFoldersSelectionDialog;

    # invokes: Lcom/android/mail/ui/MultiFoldersSelectionDialog;->showInternal()V
    invoke-static {v0}, Lcom/android/mail/ui/MultiFoldersSelectionDialog;->access$400(Lcom/android/mail/ui/MultiFoldersSelectionDialog;)V

    .line 163
    return-void
.end method
