.class public Lcom/android/ex/photo/PhotoViewActivity;
.super Landroid/app/Activity;
.source "PhotoViewActivity.java"

# interfaces
.implements Landroid/app/ActionBar$OnMenuVisibilityListener;
.implements Landroid/app/LoaderManager$LoaderCallbacks;
.implements Landroid/support/v4/view/ViewPager$OnPageChangeListener;
.implements Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;,
        Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/app/Activity;",
        "Landroid/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;",
        "Landroid/support/v4/view/ViewPager$OnPageChangeListener;",
        "Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;",
        "Landroid/app/ActionBar$OnMenuVisibilityListener;"
    }
.end annotation


# static fields
.field public static sMemoryClass:I


# instance fields
.field private mActionBarHideDelayTime:J

.field private mActionBarHideRunnable:Ljava/lang/Runnable;

.field private mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

.field private mAlbumCount:I

.field private mCursorListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;",
            ">;"
        }
    .end annotation
.end field

.field private mFullScreen:Z

.field private final mHandler:Landroid/os/Handler;

.field private mIsEmpty:Z

.field private mIsPaused:Z

.field private mPhotoIndex:I

.field private mPhotosUri:Ljava/lang/String;

.field private mProjection:[Ljava/lang/String;

.field private mRestartLoader:Z

.field private mScreenListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;",
            ">;"
        }
    .end annotation
.end field

.field private mViewPager:Lcom/android/ex/photo/PhotoViewPager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 119
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAlbumCount:I

    .line 129
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mScreenListeners:Ljava/util/Set;

    .line 131
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mCursorListeners:Ljava/util/Set;

    .line 135
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsPaused:Z

    .line 136
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mHandler:Landroid/os/Handler;

    .line 457
    new-instance v0, Lcom/android/ex/photo/PhotoViewActivity$1;

    invoke-direct {v0, p0}, Lcom/android/ex/photo/PhotoViewActivity$1;-><init>(Lcom/android/ex/photo/PhotoViewActivity;)V

    iput-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mActionBarHideRunnable:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic access$000(Lcom/android/ex/photo/PhotoViewActivity;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/photo/PhotoViewActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 49
    invoke-direct {p0, p1}, Lcom/android/ex/photo/PhotoViewActivity;->setLightsOutMode(Z)V

    return-void
.end method

.method private cancelActionBarHideRunnable()V
    .locals 2

    .prologue
    .line 428
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mActionBarHideRunnable:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 429
    return-void
.end method

.method private declared-synchronized notifyCursorListeners(Landroid/database/Cursor;)V
    .locals 3
    .param p1, "data"    # Landroid/database/Cursor;

    .prologue
    .line 335
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mCursorListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;

    .line 336
    .local v1, "listener":Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;
    invoke-interface {v1, p1}, Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;->onCursorChanged(Landroid/database/Cursor;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 335
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 338
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    monitor-exit p0

    return-void
.end method

.method private postActionBarHideRunnableWithDelay()V
    .locals 4

    .prologue
    .line 423
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mActionBarHideRunnable:Ljava/lang/Runnable;

    iget-wide v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mActionBarHideDelayTime:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 425
    return-void
.end method

.method private setFullScreen(ZZ)V
    .locals 6
    .param p1, "fullScreen"    # Z
    .param p2, "setDelayedRunnable"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 402
    iget-boolean v5, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    if-eq p1, v5, :cond_1

    move v0, v3

    .line 403
    .local v0, "fullScreenChanged":Z
    :goto_0
    iput-boolean p1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    .line 405
    iget-boolean v5, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    if-eqz v5, :cond_2

    .line 406
    invoke-direct {p0, v3}, Lcom/android/ex/photo/PhotoViewActivity;->setLightsOutMode(Z)V

    .line 407
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewActivity;->cancelActionBarHideRunnable()V

    .line 415
    :cond_0
    :goto_1
    if-eqz v0, :cond_3

    .line 416
    iget-object v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mScreenListeners:Ljava/util/Set;

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;

    .line 417
    .local v2, "listener":Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    iget-boolean v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    invoke-interface {v2, v3}, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;->onFullScreenChanged(Z)V

    goto :goto_2

    .end local v0    # "fullScreenChanged":Z
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "listener":Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    :cond_1
    move v0, v4

    .line 402
    goto :goto_0

    .line 409
    .restart local v0    # "fullScreenChanged":Z
    :cond_2
    invoke-direct {p0, v4}, Lcom/android/ex/photo/PhotoViewActivity;->setLightsOutMode(Z)V

    .line 410
    if-eqz p2, :cond_0

    .line 411
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewActivity;->postActionBarHideRunnableWithDelay()V

    goto :goto_1

    .line 420
    :cond_3
    return-void
.end method

.method private setLightsOutMode(Z)V
    .locals 4
    .param p1, "enabled"    # Z

    .prologue
    .line 432
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-lt v2, v3, :cond_1

    .line 433
    if-eqz p1, :cond_0

    const/16 v1, 0x505

    .line 442
    .local v1, "flags":I
    :goto_0
    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v2, v1}, Lcom/android/ex/photo/PhotoViewPager;->setSystemUiVisibility(I)V

    .line 455
    :goto_1
    return-void

    .line 433
    .end local v1    # "flags":I
    :cond_0
    const/16 v1, 0x500

    goto :goto_0

    .line 444
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 445
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz p1, :cond_2

    .line 446
    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 450
    :goto_2
    if-eqz p1, :cond_3

    const/4 v1, 0x1

    .line 453
    .restart local v1    # "flags":I
    :goto_3
    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v2, v1}, Lcom/android/ex/photo/PhotoViewPager;->setSystemUiVisibility(I)V

    goto :goto_1

    .line 448
    .end local v1    # "flags":I
    :cond_2
    invoke-virtual {v0}, Landroid/app/ActionBar;->show()V

    goto :goto_2

    .line 450
    :cond_3
    const/4 v1, 0x0

    goto :goto_3
.end method


# virtual methods
.method public declared-synchronized addCursorListener(Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;

    .prologue
    .line 248
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mCursorListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 249
    monitor-exit p0

    return-void

    .line 248
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public addScreenListener(Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;

    .prologue
    .line 240
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mScreenListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 241
    return-void
.end method

.method public getCursor()Landroid/database/Cursor;
    .locals 1

    .prologue
    .line 524
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v0}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0
.end method

.method public getCursorAtProperPosition()Landroid/database/Cursor;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 507
    iget-object v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    if-nez v3, :cond_0

    move-object v0, v2

    .line 520
    :goto_0
    return-object v0

    .line 511
    :cond_0
    iget-object v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v3}, Lcom/android/ex/photo/PhotoViewPager;->getCurrentItem()I

    move-result v1

    .line 512
    .local v1, "position":I
    iget-object v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v3}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 514
    .local v0, "cursor":Landroid/database/Cursor;
    if-nez v0, :cond_1

    move-object v0, v2

    .line 515
    goto :goto_0

    .line 518
    :cond_1
    invoke-interface {v0, v1}, Landroid/database/Cursor;->moveToPosition(I)Z

    goto :goto_0
.end method

.method public isFragmentActive(Landroid/app/Fragment;)Z
    .locals 3
    .param p1, "fragment"    # Landroid/app/Fragment;

    .prologue
    const/4 v0, 0x0

    .line 362
    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    if-nez v1, :cond_1

    .line 365
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v1}, Lcom/android/ex/photo/PhotoViewPager;->getCurrentItem()I

    move-result v1

    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v2, p1}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->getItemPosition(Ljava/lang/Object;)I

    move-result v2

    if-ne v1, v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isFragmentFullScreen(Landroid/app/Fragment;)Z
    .locals 2
    .param p1, "fragment"    # Landroid/app/Fragment;

    .prologue
    .line 256
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v0}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    .line 257
    :cond_0
    iget-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    .line 259
    :goto_0
    return v0

    :cond_1
    iget-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v0}, Lcom/android/ex/photo/PhotoViewPager;->getCurrentItem()I

    move-result v0

    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v1, p1}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->getItemPosition(Ljava/lang/Object;)I

    move-result v1

    if-eq v0, v1, :cond_3

    :cond_2
    const/4 v0, 0x1

    goto :goto_0

    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 224
    iget-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    if-eqz v0, :cond_0

    .line 225
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->toggleFullScreen()V

    .line 229
    :goto_0
    return-void

    .line 227
    :cond_0
    invoke-super {p0}, Landroid/app/Activity;->onBackPressed()V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v7, -0x1

    const/4 v6, 0x0

    .line 147
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 149
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "activity"

    invoke-virtual {v4, v5}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/app/ActivityManager;

    .line 151
    .local v3, "mgr":Landroid/app/ActivityManager;
    invoke-virtual {v3}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v4

    sput v4, Lcom/android/ex/photo/PhotoViewActivity;->sMemoryClass:I

    .line 153
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 155
    .local v2, "mIntent":Landroid/content/Intent;
    const/4 v1, -0x1

    .line 156
    .local v1, "currentItem":I
    if-eqz p1, :cond_0

    .line 157
    const-string v4, "com.google.android.apps.plus.PhotoViewFragment.ITEM"

    invoke-virtual {p1, v4, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 158
    const-string v4, "com.google.android.apps.plus.PhotoViewFragment.FULLSCREEN"

    invoke-virtual {p1, v4, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v4

    iput-boolean v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    .line 162
    :cond_0
    const-string v4, "photos_uri"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 163
    const-string v4, "photos_uri"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mPhotosUri:Ljava/lang/String;

    .line 169
    :cond_1
    const-string v4, "projection"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 170
    const-string v4, "projection"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->getStringArrayExtra(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mProjection:[Ljava/lang/String;

    .line 176
    :goto_0
    const-string v4, "photo_index"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    if-gez v1, :cond_2

    .line 177
    const-string v4, "photo_index"

    invoke-virtual {v2, v4, v7}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v1

    .line 179
    :cond_2
    iput v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mPhotoIndex:I

    .line 181
    sget v4, Lcom/android/ex/photo/R$layout;->photo_activity_view:I

    invoke-virtual {p0, v4}, Lcom/android/ex/photo/PhotoViewActivity;->setContentView(I)V

    .line 184
    new-instance v4, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v5

    invoke-direct {v4, p0, v5, v6}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;-><init>(Landroid/content/Context;Landroid/app/FragmentManager;Landroid/database/Cursor;)V

    iput-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    .line 186
    sget v4, Lcom/android/ex/photo/R$id;->photo_view_pager:I

    invoke-virtual {p0, v4}, Lcom/android/ex/photo/PhotoViewActivity;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/android/ex/photo/PhotoViewPager;

    iput-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    .line 187
    iget-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    iget-object v5, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v4, v5}, Lcom/android/ex/photo/PhotoViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 188
    iget-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v4, p0}, Lcom/android/ex/photo/PhotoViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 189
    iget-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v4, p0}, Lcom/android/ex/photo/PhotoViewPager;->setOnInterceptTouchListener(Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;)V

    .line 192
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v4

    invoke-virtual {v4, v9, v6, p0}, Landroid/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 194
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 195
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0, v9}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 196
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/android/ex/photo/R$integer;->action_bar_delay_time_in_millis:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v4

    int-to-long v4, v4

    iput-wide v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mActionBarHideDelayTime:J

    .line 198
    invoke-virtual {v0, p0}, Landroid/app/ActionBar;->addOnMenuVisibilityListener(Landroid/app/ActionBar$OnMenuVisibilityListener;)V

    .line 199
    const/16 v4, 0x8

    invoke-virtual {v0, v8, v4}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 200
    return-void

    .line 172
    .end local v0    # "actionBar":Landroid/app/ActionBar;
    :cond_3
    iput-object v6, p0, Lcom/android/ex/photo/PhotoViewActivity;->mProjection:[Ljava/lang/String;

    goto :goto_0
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
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    .line 284
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 285
    new-instance v0, Lcom/android/ex/photo/loaders/PhotoPagerLoader;

    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mPhotosUri:Ljava/lang/String;

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mProjection:[Ljava/lang/String;

    invoke-direct {v0, p0, v1, v2}, Lcom/android/ex/photo/loaders/PhotoPagerLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;)V

    .line 287
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onFragmentVisible(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V
    .locals 0
    .param p1, "fragment"    # Lcom/android/ex/photo/fragments/PhotoViewFragment;

    .prologue
    .line 369
    invoke-virtual {p0, p1}, Lcom/android/ex/photo/PhotoViewActivity;->updateActionBar(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V

    .line 370
    return-void
.end method

.method public onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 5
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
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 292
    invoke-virtual {p1}, Landroid/content/Loader;->getId()I

    move-result v0

    .line 293
    .local v0, "id":I
    if-ne v0, v3, :cond_1

    .line 294
    if-eqz p2, :cond_0

    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    if-nez v2, :cond_2

    .line 295
    :cond_0
    iput-boolean v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsEmpty:Z

    .line 324
    :goto_0
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->updateActionItems()V

    .line 326
    :cond_1
    :goto_1
    return-void

    .line 297
    :cond_2
    invoke-interface {p2}, Landroid/database/Cursor;->getCount()I

    move-result v2

    iput v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAlbumCount:I

    .line 303
    iget-boolean v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsPaused:Z

    if-eqz v2, :cond_3

    .line 304
    iput-boolean v3, p0, Lcom/android/ex/photo/PhotoViewActivity;->mRestartLoader:Z

    goto :goto_1

    .line 307
    :cond_3
    iput-boolean v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsEmpty:Z

    .line 310
    iget v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mPhotoIndex:I

    .line 313
    .local v1, "itemIndex":I
    if-gez v1, :cond_4

    .line 314
    const/4 v1, 0x0

    .line 317
    :cond_4
    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAdapter:Lcom/android/ex/photo/adapters/PhotoPagerAdapter;

    invoke-virtual {v2, p2}, Lcom/android/ex/photo/adapters/PhotoPagerAdapter;->swapCursor(Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 318
    invoke-direct {p0, p2}, Lcom/android/ex/photo/PhotoViewActivity;->notifyCursorListeners(Landroid/database/Cursor;)V

    .line 320
    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v2, v1, v4}, Lcom/android/ex/photo/PhotoViewPager;->setCurrentItem(IZ)V

    .line 321
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->setViewActivated()V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 49
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/android/ex/photo/PhotoViewActivity;->onLoadFinished(Landroid/content/Loader;Landroid/database/Cursor;)V

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
    .line 345
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    return-void
.end method

.method public onMenuVisibilityChanged(Z)V
    .locals 0
    .param p1, "isVisible"    # Z

    .prologue
    .line 529
    if-eqz p1, :cond_0

    .line 530
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewActivity;->cancelActionBarHideRunnable()V

    .line 534
    :goto_0
    return-void

    .line 532
    :cond_0
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewActivity;->postActionBarHideRunnableWithDelay()V

    goto :goto_0
.end method

.method public onNewPhotoLoaded()V
    .locals 0

    .prologue
    .line 537
    return-void
.end method

.method public onPageScrollStateChanged(I)V
    .locals 0
    .param p1, "state"    # I

    .prologue
    .line 359
    return-void
.end method

.method public onPageScrolled(IFI)V
    .locals 0
    .param p1, "position"    # I
    .param p2, "positionOffset"    # F
    .param p3, "positionOffsetPixels"    # I

    .prologue
    .line 349
    return-void
.end method

.method public onPageSelected(I)V
    .locals 0
    .param p1, "position"    # I

    .prologue
    .line 353
    iput p1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mPhotoIndex:I

    .line 354
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->setViewActivated()V

    .line 355
    return-void
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 216
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsPaused:Z

    .line 218
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 219
    return-void
.end method

.method protected onResume()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 204
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 205
    iget-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    invoke-direct {p0, v0, v1}, Lcom/android/ex/photo/PhotoViewActivity;->setFullScreen(ZZ)V

    .line 207
    iput-boolean v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsPaused:Z

    .line 208
    iget-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mRestartLoader:Z

    if-eqz v0, :cond_0

    .line 209
    iput-boolean v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mRestartLoader:Z

    .line 210
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getLoaderManager()Landroid/app/LoaderManager;

    move-result-object v0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, p0}, Landroid/app/LoaderManager;->restartLoader(ILandroid/os/Bundle;Landroid/app/LoaderManager$LoaderCallbacks;)Landroid/content/Loader;

    .line 212
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 233
    invoke-super {p0, p1}, Landroid/app/Activity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 235
    const-string v0, "com.google.android.apps.plus.PhotoViewFragment.ITEM"

    iget-object v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v1}, Lcom/android/ex/photo/PhotoViewPager;->getCurrentItem()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 236
    const-string v0, "com.google.android.apps.plus.PhotoViewFragment.FULLSCREEN"

    iget-boolean v1, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 237
    return-void
.end method

.method public onTouchIntercept(FF)Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    .locals 5
    .param p1, "origX"    # F
    .param p2, "origY"    # F

    .prologue
    .line 374
    const/4 v1, 0x0

    .line 375
    .local v1, "interceptLeft":Z
    const/4 v2, 0x0

    .line 377
    .local v2, "interceptRight":Z
    iget-object v4, p0, Lcom/android/ex/photo/PhotoViewActivity;->mScreenListeners:Ljava/util/Set;

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;

    .line 378
    .local v3, "listener":Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    if-nez v1, :cond_0

    .line 379
    invoke-interface {v3, p1, p2}, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;->onInterceptMoveLeft(FF)Z

    move-result v1

    .line 381
    :cond_0
    if-nez v2, :cond_1

    .line 382
    invoke-interface {v3, p1, p2}, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;->onInterceptMoveRight(FF)Z

    move-result v2

    .line 384
    :cond_1
    invoke-interface {v3}, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;->onViewActivated()V

    goto :goto_0

    .line 387
    .end local v3    # "listener":Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    :cond_2
    if-eqz v1, :cond_4

    .line 388
    if-eqz v2, :cond_3

    .line 389
    sget-object v4, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->BOTH:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    .line 395
    :goto_1
    return-object v4

    .line 391
    :cond_3
    sget-object v4, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->LEFT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    goto :goto_1

    .line 392
    :cond_4
    if-eqz v2, :cond_5

    .line 393
    sget-object v4, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->RIGHT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    goto :goto_1

    .line 395
    :cond_5
    sget-object v4, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->NONE:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    goto :goto_1
.end method

.method public declared-synchronized removeCursorListener(Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/ex/photo/PhotoViewActivity$CursorChangedListener;

    .prologue
    .line 252
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mCursorListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 253
    monitor-exit p0

    return-void

    .line 252
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public removeScreenListener(Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mScreenListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 245
    return-void
.end method

.method public setViewActivated()V
    .locals 3

    .prologue
    .line 465
    iget-object v2, p0, Lcom/android/ex/photo/PhotoViewActivity;->mScreenListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;

    .line 466
    .local v1, "listener":Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    invoke-interface {v1}, Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;->onViewActivated()V

    goto :goto_0

    .line 468
    .end local v1    # "listener":Lcom/android/ex/photo/PhotoViewActivity$OnScreenListener;
    :cond_0
    return-void
.end method

.method public toggleFullScreen()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 263
    iget-boolean v0, p0, Lcom/android/ex/photo/PhotoViewActivity;->mFullScreen:Z

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    invoke-direct {p0, v0, v1}, Lcom/android/ex/photo/PhotoViewActivity;->setFullScreen(ZZ)V

    .line 264
    return-void

    .line 263
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected updateActionBar(Lcom/android/ex/photo/fragments/PhotoViewFragment;)V
    .locals 14
    .param p1, "fragment"    # Lcom/android/ex/photo/fragments/PhotoViewFragment;

    .prologue
    const/16 v13, 0x8

    const/4 v7, 0x1

    const/4 v8, 0x0

    .line 474
    iget-object v9, p0, Lcom/android/ex/photo/PhotoViewActivity;->mViewPager:Lcom/android/ex/photo/PhotoViewPager;

    invoke-virtual {v9}, Lcom/android/ex/photo/PhotoViewPager;->getCurrentItem()I

    move-result v9

    add-int/lit8 v4, v9, 0x1

    .line 477
    .local v4, "position":I
    iget v9, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAlbumCount:I

    if-ltz v9, :cond_1

    move v2, v7

    .line 479
    .local v2, "hasAlbumCount":Z
    :goto_0
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getCursorAtProperPosition()Landroid/database/Cursor;

    move-result-object v1

    .line 481
    .local v1, "cursor":Landroid/database/Cursor;
    if-eqz v1, :cond_2

    .line 482
    const-string v9, "_display_name"

    invoke-interface {v1, v9}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    .line 483
    .local v3, "photoNameIndex":I
    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 488
    .end local v3    # "photoNameIndex":I
    .local v6, "title":Ljava/lang/String;
    :goto_1
    iget-boolean v9, p0, Lcom/android/ex/photo/PhotoViewActivity;->mIsEmpty:Z

    if-nez v9, :cond_0

    if-eqz v2, :cond_0

    if-gtz v4, :cond_3

    .line 489
    :cond_0
    const/4 v5, 0x0

    .line 494
    .local v5, "subtitle":Ljava/lang/String;
    :goto_2
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 495
    .local v0, "actionBar":Landroid/app/ActionBar;
    invoke-virtual {v0, v13, v13}, Landroid/app/ActionBar;->setDisplayOptions(II)V

    .line 496
    invoke-virtual {v0, v6}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 497
    invoke-virtual {v0, v5}, Landroid/app/ActionBar;->setSubtitle(Ljava/lang/CharSequence;)V

    .line 498
    return-void

    .end local v0    # "actionBar":Landroid/app/ActionBar;
    .end local v1    # "cursor":Landroid/database/Cursor;
    .end local v2    # "hasAlbumCount":Z
    .end local v5    # "subtitle":Ljava/lang/String;
    .end local v6    # "title":Ljava/lang/String;
    :cond_1
    move v2, v8

    .line 477
    goto :goto_0

    .line 485
    .restart local v1    # "cursor":Landroid/database/Cursor;
    .restart local v2    # "hasAlbumCount":Z
    :cond_2
    const/4 v6, 0x0

    .restart local v6    # "title":Ljava/lang/String;
    goto :goto_1

    .line 491
    :cond_3
    invoke-virtual {p0}, Lcom/android/ex/photo/PhotoViewActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    sget v10, Lcom/android/ex/photo/R$string;->photo_view_count:I

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v11, v8

    iget v8, p0, Lcom/android/ex/photo/PhotoViewActivity;->mAlbumCount:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v11, v7

    invoke-virtual {v9, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .restart local v5    # "subtitle":Ljava/lang/String;
    goto :goto_2
.end method

.method protected updateActionItems()V
    .locals 0

    .prologue
    .line 330
    return-void
.end method
