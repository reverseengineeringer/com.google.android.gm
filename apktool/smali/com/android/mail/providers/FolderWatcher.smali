.class public Lcom/android/mail/providers/FolderWatcher;
.super Ljava/lang/Object;
.source "FolderWatcher.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field private final mActivity:Lcom/android/mail/ui/RestrictedActivity;

.field private mConsumer:Landroid/widget/BaseAdapter;

.field private final mFolder:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Landroid/net/Uri;",
            "Lcom/android/mail/providers/Folder;",
            ">;"
        }
    .end annotation
.end field

.field private final mUri:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/net/Uri;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/RestrictedActivity;Landroid/widget/BaseAdapter;)V
    .locals 1
    .param p1, "activity"    # Lcom/android/mail/ui/RestrictedActivity;
    .param p2, "consumer"    # Landroid/widget/BaseAdapter;

    .prologue
    .line 59
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/android/mail/providers/FolderWatcher;->mUri:Ljava/util/List;

    .line 45
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/providers/FolderWatcher;->mFolder:Ljava/util/Map;

    .line 60
    iput-object p1, p0, Lcom/android/mail/providers/FolderWatcher;->mActivity:Lcom/android/mail/ui/RestrictedActivity;

    .line 61
    iput-object p2, p0, Lcom/android/mail/providers/FolderWatcher;->mConsumer:Landroid/widget/BaseAdapter;

    .line 62
    return-void
.end method

.method private static final getLoaderFromPosition(I)I
    .locals 1
    .param p0, "position"    # I

    .prologue
    .line 89
    add-int/lit8 v0, p0, 0x64

    return v0
.end method

.method private static final getPositionFromLoader(I)I
    .locals 1
    .param p0, "loaderId"    # I

    .prologue
    .line 98
    add-int/lit8 v0, p0, -0x64

    return v0
.end method


# virtual methods
.method public get(Landroid/net/Uri;)Lcom/android/mail/providers/Folder;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 126
    iget-object v0, p0, Lcom/android/mail/providers/FolderWatcher;->mFolder:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Folder;

    return-object v0
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 8
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
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
    const/4 v4, 0x0

    .line 131
    invoke-static {p1}, Lcom/android/mail/providers/FolderWatcher;->getPositionFromLoader(I)I

    move-result v7

    .line 132
    .local v7, "position":I
    if-ltz v7, :cond_0

    iget-object v0, p0, Lcom/android/mail/providers/FolderWatcher;->mUri:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-le v7, v0, :cond_1

    :cond_0
    move-object v0, v4

    .line 135
    :goto_0
    return-object v0

    :cond_1
    new-instance v0, Landroid/content/CursorLoader;

    iget-object v1, p0, Lcom/android/mail/providers/FolderWatcher;->mActivity:Lcom/android/mail/ui/RestrictedActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/RestrictedActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mUri:Ljava/util/List;

    invoke-interface {v2, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/net/Uri;

    sget-object v3, Lcom/android/mail/providers/UIProvider;->FOLDERS_PROJECTION:[Ljava/lang/String;

    move-object v5, v4

    move-object v6, v4

    invoke-direct/range {v0 .. v6}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 4
    .param p2, "data"    # Landroid/database/Cursor;
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
    .line 141
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    if-eqz p2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v2

    if-nez v2, :cond_1

    .line 149
    :cond_0
    :goto_0
    return-void

    .line 144
    :cond_1
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mUri:Ljava/util/List;

    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v3

    invoke-static {v3}, Lcom/android/mail/providers/FolderWatcher;->getPositionFromLoader(I)I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/Uri;

    .line 145
    .local v1, "uri":Landroid/net/Uri;
    new-instance v0, Lcom/android/mail/providers/Folder;

    invoke-direct {v0, p2}, Lcom/android/mail/providers/Folder;-><init>(Landroid/database/Cursor;)V

    .line 146
    .local v0, "folder":Lcom/android/mail/providers/Folder;
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mFolder:Ljava/util/Map;

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 148
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mConsumer:Landroid/widget/BaseAdapter;

    invoke-virtual {v2}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 41
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/mail/providers/FolderWatcher;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

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
    .line 154
    .local p1, "arg0":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public startWatching(Landroid/net/Uri;)V
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    const/4 v7, 0x0

    .line 71
    if-eqz p1, :cond_0

    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mFolder:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 81
    :cond_0
    :goto_0
    return-void

    .line 75
    :cond_1
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mUri:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    .line 76
    .local v0, "id":I
    const-string v2, "UnifiedEmail"

    const-string v3, "Watching %s, at position %d."

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    const/4 v5, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v2, v3, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 77
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mFolder:Ljava/util/Map;

    invoke-interface {v2, p1, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mUri:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 79
    iget-object v2, p0, Lcom/android/mail/providers/FolderWatcher;->mActivity:Lcom/android/mail/ui/RestrictedActivity;

    invoke-interface {v2}, Lcom/android/mail/ui/RestrictedActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    .line 80
    .local v1, "lm":Landroid/app/LoaderManager;
    invoke-static {v0}, Lcom/android/mail/providers/FolderWatcher;->getLoaderFromPosition(I)I

    move-result v2

    invoke-virtual {v1, v2, v7, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_0
.end method
