.class public Lcom/android/ex/photo/loaders/PhotoPagerLoader;
.super Landroid/content/CursorLoader;
.source "PhotoPagerLoader.java"


# instance fields
.field private final mPhotosUri:Landroid/net/Uri;

.field private final mProjection:[Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "photosUri"    # Landroid/net/Uri;
    .param p3, "projection"    # [Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Landroid/content/CursorLoader;-><init>(Landroid/content/Context;)V

    .line 37
    iput-object p2, p0, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->mPhotosUri:Landroid/net/Uri;

    .line 38
    if-eqz p3, :cond_0

    .end local p3    # "projection":[Ljava/lang/String;
    :goto_0
    iput-object p3, p0, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->mProjection:[Ljava/lang/String;

    .line 39
    return-void

    .line 38
    .restart local p3    # "projection":[Ljava/lang/String;
    :cond_0
    sget-object p3, Lcom/android/ex/photo/provider/PhotoContract$PhotoQuery;->PROJECTION:[Ljava/lang/String;

    goto :goto_0
.end method


# virtual methods
.method public loadInBackground()Landroid/database/Cursor;
    .locals 5

    .prologue
    .line 43
    const/4 v1, 0x0

    .line 45
    .local v1, "returnCursor":Landroid/database/Cursor;
    iget-object v2, p0, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->mPhotosUri:Landroid/net/Uri;

    invoke-virtual {v2}, Landroid/net/Uri;->buildUpon()Landroid/net/Uri$Builder;

    move-result-object v2

    const-string v3, "contentType"

    const-string v4, "image/"

    invoke-virtual {v2, v3, v4}, Landroid/net/Uri$Builder;->appendQueryParameter(Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri$Builder;

    move-result-object v2

    invoke-virtual {v2}, Landroid/net/Uri$Builder;->build()Landroid/net/Uri;

    move-result-object v0

    .line 47
    .local v0, "loaderUri":Landroid/net/Uri;
    invoke-virtual {p0, v0}, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->setUri(Landroid/net/Uri;)V

    .line 48
    iget-object v2, p0, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->mProjection:[Ljava/lang/String;

    invoke-virtual {p0, v2}, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->setProjection([Ljava/lang/String;)V

    .line 49
    invoke-super {p0}, Landroid/content/CursorLoader;->loadInBackground()Landroid/database/Cursor;

    move-result-object v1

    .line 51
    return-object v1
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 30
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoPagerLoader;->loadInBackground()Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method
