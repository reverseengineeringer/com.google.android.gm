.class public Lcom/android/ex/photo/loaders/PhotoBitmapLoader;
.super Landroid/content/AsyncTaskLoader;
.source "PhotoBitmapLoader.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/content/AsyncTaskLoader",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field private mPhotoUri:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "photoUri"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Landroid/content/AsyncTaskLoader;-><init>(Landroid/content/Context;)V

    .line 40
    iput-object p2, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mPhotoUri:Ljava/lang/String;

    .line 41
    return-void
.end method


# virtual methods
.method public deliverResult(Landroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->isReset()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 74
    if-eqz p1, :cond_0

    .line 75
    invoke-virtual {p0, p1}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->onReleaseResources(Landroid/graphics/Bitmap;)V

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    .line 79
    .local v0, "oldBitmap":Landroid/graphics/Bitmap;
    iput-object p1, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    .line 81
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->isStarted()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 84
    invoke-super {p0, p1}, Landroid/content/AsyncTaskLoader;->deliverResult(Ljava/lang/Object;)V

    .line 90
    :cond_1
    if-eqz v0, :cond_2

    if-eq v0, p1, :cond_2

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v1

    if-nez v1, :cond_2

    .line 91
    invoke-virtual {p0, v0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->onReleaseResources(Landroid/graphics/Bitmap;)V

    .line 93
    :cond_2
    return-void
.end method

.method public bridge synthetic deliverResult(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 33
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->deliverResult(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public loadInBackground()Landroid/graphics/Bitmap;
    .locals 5

    .prologue
    .line 49
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 51
    .local v1, "context":Landroid/content/Context;
    if-eqz v1, :cond_1

    iget-object v3, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mPhotoUri:Ljava/lang/String;

    if-eqz v3, :cond_1

    .line 52
    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    .line 53
    .local v2, "resolver":Landroid/content/ContentResolver;
    iget-object v3, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mPhotoUri:Ljava/lang/String;

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    sget-object v4, Lcom/android/ex/photo/fragments/PhotoViewFragment;->sPhotoSize:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-static {v2, v3, v4}, Lcom/android/ex/photo/util/ImageUtils;->createLocalBitmap(Landroid/content/ContentResolver;Landroid/net/Uri;I)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 55
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    if-eqz v0, :cond_0

    .line 56
    const/16 v3, 0xa0

    invoke-virtual {v0, v3}, Landroid/graphics/Bitmap;->setDensity(I)V

    .line 61
    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "resolver":Landroid/content/ContentResolver;
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public bridge synthetic loadInBackground()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 33
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->loadInBackground()Landroid/graphics/Bitmap;

    move-result-object v0

    return-object v0
.end method

.method public onCanceled(Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 126
    invoke-super {p0, p1}, Landroid/content/AsyncTaskLoader;->onCanceled(Ljava/lang/Object;)V

    .line 130
    invoke-virtual {p0, p1}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->onReleaseResources(Landroid/graphics/Bitmap;)V

    .line 131
    return-void
.end method

.method public bridge synthetic onCanceled(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 33
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->onCanceled(Landroid/graphics/Bitmap;)V

    return-void
.end method

.method protected onReleaseResources(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 156
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->isRecycled()Z

    move-result v0

    if-nez v0, :cond_0

    .line 157
    invoke-virtual {p1}, Landroid/graphics/Bitmap;->recycle()V

    .line 159
    :cond_0
    return-void
.end method

.method protected onReset()V
    .locals 1

    .prologue
    .line 138
    invoke-super {p0}, Landroid/content/AsyncTaskLoader;->onReset()V

    .line 141
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->onStopLoading()V

    .line 145
    iget-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p0, v0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->onReleaseResources(Landroid/graphics/Bitmap;)V

    .line 147
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    .line 149
    :cond_0
    return-void
.end method

.method protected onStartLoading()V
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p0, v0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->deliverResult(Landroid/graphics/Bitmap;)V

    .line 106
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->takeContentChanged()Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_2

    .line 109
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->forceLoad()V

    .line 111
    :cond_2
    return-void
.end method

.method protected onStopLoading()V
    .locals 0

    .prologue
    .line 118
    invoke-virtual {p0}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->cancelLoad()Z

    .line 119
    return-void
.end method

.method public setPhotoUri(Ljava/lang/String;)V
    .locals 0
    .param p1, "photoUri"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->mPhotoUri:Ljava/lang/String;

    .line 45
    return-void
.end method
