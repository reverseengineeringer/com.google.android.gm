.class public Lcom/android/ex/photo/fragments/PhotoViewFragment;
.super Landroid/app/Fragment;
.source "PhotoViewFragment.java"

# interfaces
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Landroid/view/View$OnClickListener;
.implements Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;
.implements Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/photo/fragments/PhotoViewFragment$1;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Fragment;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;",
        "Landroid/view/View$OnClickListener;",
        "Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;",
        "Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;"
    }
.end annotation


# static fields
.field public static sPhotoSize:Ljava/lang/Integer;


# instance fields
.field private mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

.field private mCallback:Lcom/android/ex/photo/PhotoViewActivity;

.field private mEmptyText:Landroid/widget/TextView;

.field private mFullScreen:Z

.field private mIntent:Landroid/content/Intent;

.field private mPhotoPreviewAndProgress:Landroid/view/View;

.field private mPhotoPreviewImage:Landroid/widget/ImageView;

.field private mPhotoProgressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;

.field private mPhotoView:Lcom/android/ex/photo/views/PhotoView;

.field private final mPosition:I

.field private mProgressBarNeeded:Z

.field private mResolvedPhotoUri:Ljava/lang/String;

.field private mRetryButton:Landroid/widget/ImageView;

.field private mThumbnailUri:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 114
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 110
    iput-boolean v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    .line 115
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPosition:I

    .line 116
    iput-boolean v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    .line 117
    return-void
.end method

.method public constructor <init>(Landroid/content/Intent;ILcom/android/ex/photo/adapters/PhotoPagerAdapter;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "position"    # I
    .param p3, "adapter"    # Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    .prologue
    const/4 v0, 0x1

    .line 119
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 110
    iput-boolean v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    .line 120
    iput-object p1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    .line 121
    iput p2, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPosition:I

    .line 122
    iput-object p3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    .line 123
    iput-boolean v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    .line 124
    return-void
.end method

.method private bindPhoto(Landroid/graphics/Bitmap;)V
    .locals 1
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 316
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v0, :cond_0

    .line 317
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v0, p1}, Lcom/android/ex/photo/views/PhotoView;->bindPhoto(Landroid/graphics/Bitmap;)V

    .line 319
    :cond_0
    return-void
.end method

.method private resetPhotoView()V
    .locals 2

    .prologue
    .line 325
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v0, :cond_0

    .line 326
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/android/ex/photo/views/PhotoView;->bindPhoto(Landroid/graphics/Bitmap;)V

    .line 328
    :cond_0
    return-void
.end method

.method private setViewVisibility()V
    .locals 3

    .prologue
    .line 399
    iget-object v2, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v2, p0}, Lcom/android/ex/photo/PhotoViewActivity;->isFragmentFullScreen(Landroid/app/Fragment;)Z

    move-result v0

    .line 400
    .local v0, "fullScreen":Z
    move v1, v0

    .line 402
    .local v1, "hide":Z
    invoke-virtual {p0, v1}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->setFullScreen(Z)V

    .line 403
    return-void
.end method


# virtual methods
.method public getEmptyText()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 434
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mEmptyText:Landroid/widget/TextView;

    return-object v0
.end method

.method public getPhotoProgressBar()Lcom/android/ex/photo/views/ProgressBarWrapper;
    .locals 1

    .prologue
    .line 430
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoProgressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;

    return-object v0
.end method

.method public getRetryButton()Landroid/widget/ImageView;
    .locals 1

    .prologue
    .line 438
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mRetryButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method public isPhotoBound()Z
    .locals 1

    .prologue
    .line 392
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView;->isPhotoBound()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isProgressBarNeeded()Z
    .locals 1

    .prologue
    .line 442
    iget-boolean v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    return v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 5
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 128
    invoke-super {p0, p1}, Landroid/app/Fragment;->onAttach(Landroid/app/Activity;)V

    .line 129
    check-cast p1, Lcom/android/ex/photo/PhotoViewActivity;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    .line 130
    iget-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    if-nez v3, :cond_0

    .line 131
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Activity must be a derived class of PhotoViewActivity"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 135
    :cond_0
    sget-object v3, Lcom/android/ex/photo/fragments/PhotoViewFragment;->sPhotoSize:Ljava/lang/Integer;

    if-nez v3, :cond_1

    .line 136
    new-instance v1, Landroid/util/DisplayMetrics;

    invoke-direct {v1}, Landroid/util/DisplayMetrics;-><init>()V

    .line 137
    .local v1, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-string v4, "window"

    invoke-virtual {v3, v4}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/view/WindowManager;

    .line 139
    .local v2, "wm":Landroid/view/WindowManager;
    sget-object v0, Lcom/android/ex/photo/util/ImageUtils;->sUseImageSize:Lcom/android/ex/photo/util/ImageUtils$ImageSize;

    .line 140
    .local v0, "imageSize":Lcom/android/ex/photo/util/ImageUtils$ImageSize;
    invoke-interface {v2}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    invoke-virtual {v3, v1}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 141
    sget-object v3, Lcom/android/ex/photo/fragments/PhotoViewFragment$1;->$SwitchMap$com$android$ex$photo$util$ImageUtils$ImageSize:[I

    invoke-virtual {v0}, Lcom/android/ex/photo/util/ImageUtils$ImageSize;->ordinal()I

    move-result v4

    aget v3, v3, v4

    packed-switch v3, :pswitch_data_0

    .line 151
    iget v3, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    iget v4, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    sput-object v3, Lcom/android/ex/photo/fragments/PhotoViewFragment;->sPhotoSize:Ljava/lang/Integer;

    .line 156
    .end local v0    # "imageSize":Lcom/android/ex/photo/util/ImageUtils$ImageSize;
    .end local v1    # "metrics":Landroid/util/DisplayMetrics;
    .end local v2    # "wm":Landroid/view/WindowManager;
    :cond_1
    :goto_0
    return-void

    .line 144
    .restart local v0    # "imageSize":Lcom/android/ex/photo/util/ImageUtils$ImageSize;
    .restart local v1    # "metrics":Landroid/util/DisplayMetrics;
    .restart local v2    # "wm":Landroid/view/WindowManager;
    :pswitch_0
    iget v3, v1, Landroid/util/DisplayMetrics;->heightPixels:I

    iget v4, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    invoke-static {v3, v4}, Ljava/lang/Math;->min(II)I

    move-result v3

    mul-int/lit16 v3, v3, 0x320

    div-int/lit16 v3, v3, 0x3e8

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    sput-object v3, Lcom/android/ex/photo/fragments/PhotoViewFragment;->sPhotoSize:Ljava/lang/Integer;

    goto :goto_0

    .line 141
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 337
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0}, Lcom/android/ex/photo/PhotoViewActivity;->toggleFullScreen()V

    .line 338
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 166
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 168
    if-eqz p1, :cond_0

    .line 169
    const-string v1, "com.android.mail.photo.fragments.PhotoViewFragment.INTENT"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 170
    .local v0, "state":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 171
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v1

    iput-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    .line 175
    .end local v0    # "state":Landroid/os/Bundle;
    :cond_0
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    if-eqz v1, :cond_1

    .line 176
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    const-string v2, "resolved_photo_uri"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mResolvedPhotoUri:Ljava/lang/String;

    .line 177
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    const-string v2, "thumbnail_uri"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mThumbnailUri:Ljava/lang/String;

    .line 179
    :cond_1
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/content/Loader;
    .locals 3
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/content/Loader",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation

    .prologue
    .line 248
    packed-switch p1, :pswitch_data_0

    .line 254
    const/4 v0, 0x0

    :goto_0
    return-object v0

    .line 250
    :pswitch_0
    new-instance v0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;

    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mResolvedPhotoUri:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 252
    :pswitch_1
    new-instance v0, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;

    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mThumbnailUri:Ljava/lang/String;

    invoke-direct {v0, v1, v2}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0

    .line 248
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 184
    sget v3, Lcom/android/ex/photo/R$layout;->photo_fragment_view:I

    invoke-virtual {p1, v3, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 186
    .local v2, "view":Landroid/view/View;
    sget v3, Lcom/android/ex/photo/R$id;->photo_view:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/android/ex/photo/views/PhotoView;

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    .line 187
    iget-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v3, p0}, Lcom/android/ex/photo/views/PhotoView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 188
    iget-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    iget-boolean v4, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mFullScreen:Z

    invoke-virtual {v3, v4, v5}, Lcom/android/ex/photo/views/PhotoView;->setFullScreen(ZZ)V

    .line 189
    iget-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v3, v6}, Lcom/android/ex/photo/views/PhotoView;->enableImageTransforms(Z)V

    .line 191
    sget v3, Lcom/android/ex/photo/R$id;->photo_preview:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewAndProgress:Landroid/view/View;

    .line 192
    sget v3, Lcom/android/ex/photo/R$id;->photo_preview_image:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewImage:Landroid/widget/ImageView;

    .line 193
    sget v3, Lcom/android/ex/photo/R$id;->indeterminate_progress:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    .line 195
    .local v1, "indeterminate":Landroid/widget/ProgressBar;
    sget v3, Lcom/android/ex/photo/R$id;->determinate_progress:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    .line 197
    .local v0, "determinate":Landroid/widget/ProgressBar;
    new-instance v3, Lcom/android/ex/photo/views/ProgressBarWrapper;

    invoke-direct {v3, v0, v1, v6}, Lcom/android/ex/photo/views/ProgressBarWrapper;-><init>(Landroid/widget/ProgressBar;Landroid/widget/ProgressBar;Z)V

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoProgressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;

    .line 198
    sget v3, Lcom/android/ex/photo/R$id;->empty_text:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mEmptyText:Landroid/widget/TextView;

    .line 199
    sget v3, Lcom/android/ex/photo/R$id;->retry_button:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mRetryButton:Landroid/widget/ImageView;

    .line 202
    invoke-direct {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->setViewVisibility()V

    .line 204
    return-object v2
.end method

.method public onCursorChanged(Landroid/database/Cursor;)V
    .locals 4
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 414
    iget v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPosition:I

    invoke-interface {p1, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->isPhotoBound()Z

    move-result v3

    if-nez v3, :cond_0

    .line 415
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v2

    .line 416
    .local v2, "manager":Landroid/app/LoaderManager;
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/app/LoaderManager;->getLoader(I)Landroid/content/Loader;

    move-result-object v0

    .line 417
    .local v0, "fakeLoader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/graphics/Bitmap;>;"
    if-nez v0, :cond_1

    .line 427
    .end local v0    # "fakeLoader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/graphics/Bitmap;>;"
    .end local v2    # "manager":Landroid/app/LoaderManager;
    :cond_0
    :goto_0
    return-void

    .restart local v0    # "fakeLoader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/graphics/Bitmap;>;"
    .restart local v2    # "manager":Landroid/app/LoaderManager;
    :cond_1
    move-object v1, v0

    .line 421
    check-cast v1, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;

    .line 423
    .local v1, "loader":Lcom/android/ex/photo/loaders/PhotoBitmapLoader;
    iget-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v3, p1}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->getPhotoUri(Landroid/database/Cursor;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mResolvedPhotoUri:Ljava/lang/String;

    .line 424
    iget-object v3, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mResolvedPhotoUri:Ljava/lang/String;

    invoke-virtual {v1, v3}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->setPhotoUri(Ljava/lang/String;)V

    .line 425
    invoke-virtual {v1}, Lcom/android/ex/photo/loaders/PhotoBitmapLoader;->forceLoad()V

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 229
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v0, :cond_0

    .line 230
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView;->clear()V

    .line 231
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    .line 234
    :cond_0
    invoke-super {p0}, Landroid/app/Fragment;->onDestroyView()V

    .line 235
    return-void
.end method

.method public onDetach()V
    .locals 1

    .prologue
    .line 160
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    .line 161
    invoke-super {p0}, Landroid/app/Fragment;->onDetach()V

    .line 162
    return-void
.end method

.method public onFullScreenChanged(Z)V
    .locals 0
    .param p1, "fullScreen"    # Z

    .prologue
    .line 342
    invoke-direct {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->setViewVisibility()V

    .line 343
    return-void
.end method

.method public onInterceptMoveLeft(FF)Z
    .locals 2
    .param p1, "origX"    # F
    .param p2, "origY"    # F

    .prologue
    const/4 v0, 0x0

    .line 370
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v1, p0}, Lcom/android/ex/photo/PhotoViewActivity;->isFragmentActive(Landroid/app/Fragment;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 375
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v1, p1, p2}, Lcom/android/ex/photo/views/PhotoView;->interceptMoveLeft(FF)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onInterceptMoveRight(FF)Z
    .locals 2
    .param p1, "origX"    # F
    .param p2, "origY"    # F

    .prologue
    const/4 v0, 0x0

    .line 380
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v1, p0}, Lcom/android/ex/photo/PhotoViewActivity;->isFragmentActive(Landroid/app/Fragment;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 385
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v1, p1, p2}, Lcom/android/ex/photo/views/PhotoView;->interceptMoveRight(FF)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/graphics/Bitmap;)V
    .locals 5
    .param p2, "data"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;",
            "Landroid/graphics/Bitmap;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/graphics/Bitmap;>;"
    const/16 v4, 0x8

    const/4 v2, 0x0

    .line 261
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getView()Landroid/view/View;

    move-result-object v1

    if-nez v1, :cond_0

    .line 310
    :goto_0
    return-void

    .line 265
    :cond_0
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    .line 266
    .local v0, "id":I
    packed-switch v0, :pswitch_data_0

    .line 301
    :cond_1
    :goto_1
    iget-boolean v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    if-nez v1, :cond_2

    .line 303
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoProgressBar:Lcom/android/ex/photo/views/ProgressBarWrapper;

    invoke-virtual {v1, v4}, Lcom/android/ex/photo/views/ProgressBarWrapper;->setVisibility(I)V

    .line 305
    :cond_2
    if-eqz p2, :cond_3

    .line 306
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v1}, Lcom/android/ex/photo/PhotoViewActivity;->onNewPhotoLoaded()V

    .line 309
    :cond_3
    invoke-direct {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->setViewVisibility()V

    goto :goto_0

    .line 268
    :pswitch_0
    if-eqz p2, :cond_1

    .line 269
    invoke-direct {p0, p2}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->bindPhoto(Landroid/graphics/Bitmap;)V

    .line 270
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewAndProgress:Landroid/view/View;

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 271
    iput-boolean v2, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    goto :goto_1

    .line 275
    :pswitch_1
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->isPhotoBound()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 278
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewAndProgress:Landroid/view/View;

    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    .line 279
    iput-boolean v2, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mProgressBarNeeded:Z

    goto :goto_0

    .line 283
    :cond_4
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewImage:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 285
    if-nez p2, :cond_5

    .line 287
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewImage:Landroid/widget/ImageView;

    sget v2, Lcom/android/ex/photo/R$drawable;->default_image:I

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 288
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewImage:Landroid/widget/ImageView;

    sget-object v2, Landroid/widget/ImageView$ScaleType;->CENTER:Landroid/widget/ImageView$ScaleType;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 294
    :goto_2
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x1

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    goto :goto_1

    .line 291
    :cond_5
    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoPreviewImage:Landroid/widget/ImageView;

    invoke-virtual {v1, p2}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_2

    .line 266
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 54
    check-cast p2, Landroid/graphics/Bitmap;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->onLoadFinished(Landroid/content/Loader;Landroid/graphics/Bitmap;)V

    return-void
.end method

.method public onLoaderReset(Landroid/content/Loader;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 333
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/graphics/Bitmap;>;"
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 219
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 221
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity;->removeCursorListener(Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;)V

    .line 222
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity;->removeScreenListener(Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;)V

    .line 223
    invoke-direct {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->resetPhotoView()V

    .line 224
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 209
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity;->addScreenListener(Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;)V

    .line 210
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity;->addCursorListener(Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;)V

    .line 212
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 214
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 215
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 239
    invoke-super {p0, p1}, Landroid/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 241
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    if-eqz v0, :cond_0

    .line 242
    const-string v0, "com.android.mail.photo.fragments.PhotoViewFragment.INTENT"

    iget-object v1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mIntent:Landroid/content/Intent;

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 244
    :cond_0
    return-void
.end method

.method public onViewActivated()V
    .locals 3

    .prologue
    .line 347
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity;->isFragmentActive(Landroid/app/Fragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 349
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->resetViews()V

    .line 357
    :goto_0
    return-void

    .line 351
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->isPhotoBound()Z

    move-result v0

    if-nez v0, :cond_1

    .line 353
    invoke-virtual {p0}, Lcom/android/ex/photo/fragments/PhotoViewFragment;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x2

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 355
    :cond_1
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mCallback:Lcom/android/ex/photo/PhotoViewActivity;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity;->onFragmentVisible(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V

    goto :goto_0
.end method

.method public resetViews()V
    .locals 1

    .prologue
    .line 363
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    if-eqz v0, :cond_0

    .line 364
    iget-object v0, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mPhotoView:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView;->resetTransformations()V

    .line 366
    :cond_0
    return-void
.end method

.method public setFullScreen(Z)V
    .locals 0
    .param p1, "fullScreen"    # Z

    .prologue
    .line 409
    iput-boolean p1, p0, Lcom/android/ex/photo/fragments/PhotoViewFragment;->mFullScreen:Z

    .line 410
    return-void
.end method
