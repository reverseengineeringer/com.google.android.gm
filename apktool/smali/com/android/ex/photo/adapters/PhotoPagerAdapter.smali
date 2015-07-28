.class public Lcom/android/ex/photo/adapters/PhotoPagerAdapter;
.super Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;
.source "PhotoPagerAdapter.java"


# instance fields
.field private mContentUriIndex:I

.field private mThumbnailUriIndex:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/app/FragmentManager;Landroid/database/Cursor;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "fm"    # Landroid/app/FragmentManager;
    .param p3, "c"    # Landroid/database/Cursor;

    .prologue
    .line 38
    invoke-direct {p0, p1, p2, p3}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;-><init>(Landroid/content/Context;Landroid/app/FragmentManager;Landroid/database/Cursor;)V

    .line 39
    return-void
.end method


# virtual methods
.method public getItem(Landroid/content/Context;Landroid/database/Cursor;I)Landroid/app/Fragment;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "position"    # I

    .prologue
    .line 43
    iget v3, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mContentUriIndex:I

    invoke-interface {p2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 44
    .local v1, "photoUri":Ljava/lang/String;
    iget v3, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mThumbnailUriIndex:I

    invoke-interface {p2, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 47
    .local v2, "thumbnailUri":Ljava/lang/String;
    iget-object v3, p0, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->mContext:Landroid/content/Context;

    invoke-static {v3}, Lcom/android/ex/photo/Intents;->newPhotoViewFragmentIntentBuilder(Landroid/content/Context;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    move-result-object v0

    .line 49
    .local v0, "builder":Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;
    invoke-virtual {v0, v1}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->setResolvedPhotoUri(Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->setThumbnailUri(Ljava/lang/String;)Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;

    .line 53
    new-instance v3, Lcom/android/ex/photo/fragments/PhotoViewFragment;

    invoke-virtual {v0}, Lcom/android/ex/photo/Intents$PhotoViewIntentBuilder;->build()Landroid/content/Intent;

    move-result-object v4

    invoke-direct {v3, v4, p3, p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;-><init>(Landroid/content/Intent;ILcom/android/ex/photo/adapters/PhotoPagerAdapter;)V

    return-object v3
.end method

.method public getPhotoUri(Landroid/database/Cursor;)Ljava/lang/String;
    .locals 1
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 72
    iget v0, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mContentUriIndex:I

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;
    .locals 1
    .param p1, "newCursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v0, -0x1

    .line 58
    if-eqz p1, :cond_0

    .line 59
    const-string v0, "contentUri"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mContentUriIndex:I

    .line 61
    const-string v0, "thumbnailUri"

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mThumbnailUriIndex:I

    .line 68
    :goto_0
    invoke-super {p0, p1}, Lcom/android/ex/photo/adapters/BaseCursorPagerAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    move-result-object v0

    return-object v0

    .line 64
    :cond_0
    iput v0, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mContentUriIndex:I

    .line 65
    iput v0, p0, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->mThumbnailUriIndex:I

    goto :goto_0
.end method
