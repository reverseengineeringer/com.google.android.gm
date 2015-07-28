.class public Lcom/android/mail/ui/WaitFragment;
.super Landroid/app/Fragment;
.source "WaitFragment.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/view/View$OnClickListener;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field private mAccount:Lcom/android/mail/providers/Account;

.field private mContainer:Landroid/view/ViewGroup;

.field private mDefault:Z

.field private mInflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 36
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    return-void
.end method

.method private getContent()Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 89
    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 90
    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget v1, v1, Lcom/android/mail/providers/Account;->syncStatus:I

    and-int/lit8 v1, v1, 0x10

    const/16 v2, 0x10

    if-ne v1, v2, :cond_0

    .line 94
    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mInflater:Landroid/view/LayoutInflater;

    const v2, 0x7f040073

    iget-object v3, p0, Lcom/android/mail/ui/WaitFragment;->mContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 96
    .local v0, "root":Landroid/view/View;
    const v1, 0x7f100102

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 97
    const v1, 0x7f100103

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    :goto_0
    return-object v0

    .line 99
    .end local v0    # "root":Landroid/view/View;
    :cond_0
    iget-boolean v1, p0, Lcom/android/mail/ui/WaitFragment;->mDefault:Z

    if-eqz v1, :cond_1

    .line 100
    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mInflater:Landroid/view/LayoutInflater;

    const v2, 0x7f040072

    iget-object v3, p0, Lcom/android/mail/ui/WaitFragment;->mContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "root":Landroid/view/View;
    goto :goto_0

    .line 102
    .end local v0    # "root":Landroid/view/View;
    :cond_1
    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mInflater:Landroid/view/LayoutInflater;

    const v2, 0x7f040076

    iget-object v3, p0, Lcom/android/mail/ui/WaitFragment;->mContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .restart local v0    # "root":Landroid/view/View;
    goto :goto_0
.end method

.method public static newInstance(Lcom/android/mail/providers/Account;)Lcom/android/mail/ui/WaitFragment;
    .locals 1
    .param p0, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 55
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/android/mail/ui/WaitFragment;->newInstance(Lcom/android/mail/providers/Account;Z)Lcom/android/mail/ui/WaitFragment;

    move-result-object v0

    return-object v0
.end method

.method public static newInstance(Lcom/android/mail/providers/Account;Z)Lcom/android/mail/ui/WaitFragment;
    .locals 3
    .param p0, "account"    # Lcom/android/mail/providers/Account;
    .param p1, "def"    # Z

    .prologue
    .line 59
    new-instance v1, Lcom/android/mail/ui/WaitFragment;

    invoke-direct {v1}, Lcom/android/mail/ui/WaitFragment;-><init>()V

    .line 61
    .local v1, "fragment":Lcom/android/mail/ui/WaitFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 62
    .local v0, "args":Landroid/os/Bundle;
    const-string v2, "account"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 63
    const-string v2, "isDefault"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 64
    invoke-virtual {v1, v0}, Lcom/android/mail/ui/WaitFragment;->setArguments(Landroid/os/Bundle;)V

    .line 65
    return-object v1
.end method


# virtual methods
.method getAccount()Lcom/android/mail/providers/Account;
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 119
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 131
    :cond_0
    :goto_0
    return-void

    .line 121
    :pswitch_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.SYNC_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 122
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 123
    invoke-virtual {p0, v0}, Lcom/android/mail/ui/WaitFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 126
    .end local v0    # "intent":Landroid/content/Intent;
    :pswitch_1
    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v1, v1, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    if-eqz v1, :cond_0

    .line 127
    invoke-virtual {p0}, Lcom/android/mail/ui/WaitFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0

    .line 119
    :pswitch_data_0
    .packed-switch 0x7f100102
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 70
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 72
    invoke-virtual {p0}, Lcom/android/mail/ui/WaitFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 73
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "account"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Account;

    iput-object v1, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 74
    const-string v1, "isDefault"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lcom/android/mail/ui/WaitFragment;->mDefault:Z

    .line 75
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 7
    .param p1, "id"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 137
    new-instance v0, Landroid/content/CursorLoader;

    invoke-virtual {p0}, Lcom/android/mail/ui/WaitFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->manualSyncUri:Landroid/net/Uri;

    move-object v4, v3

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 80
    iput-object p1, p0, Lcom/android/mail/ui/WaitFragment;->mInflater:Landroid/view/LayoutInflater;

    .line 81
    iput-object p2, p0, Lcom/android/mail/ui/WaitFragment;->mContainer:Landroid/view/ViewGroup;

    .line 82
    invoke-direct {p0}, Lcom/android/mail/ui/WaitFragment;->getContent()Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 0
    .param p2, "arg1"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 143
    .local p1, "arg0":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 36
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/ui/WaitFragment;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 148
    .local p1, "arg0":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public updateAccount(Lcom/android/mail/providers/Account;)V
    .locals 2
    .param p1, "account"    # Lcom/android/mail/providers/Account;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/android/mail/ui/WaitFragment;->mAccount:Lcom/android/mail/providers/Account;

    .line 110
    iget-object v0, p0, Lcom/android/mail/ui/WaitFragment;->mContainer:Landroid/view/ViewGroup;

    invoke-direct {p0}, Lcom/android/mail/ui/WaitFragment;->getContent()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 111
    return-void
.end method
