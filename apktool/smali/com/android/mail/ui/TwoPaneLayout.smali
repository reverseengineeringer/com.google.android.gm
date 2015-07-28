.class final Lcom/android/mail/ui/TwoPaneLayout;
.super Landroid/widget/FrameLayout;
.source "TwoPaneLayout.java"

# interfaces
.implements Lcom/android/mail/ui/ViewMode$ModeChangeListener;


# instance fields
.field private mController:Lcom/android/mail/ui/AbstractActivityController;

.field private final mConversationListWeight:D

.field private mConversationView:Landroid/view/View;

.field private mCurrentMode:I

.field private final mFolderListWeight:D

.field private mFoldersView:Landroid/view/View;

.field private mIsSearchResult:Z

.field private final mListCollapsible:Z

.field private mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

.field private mListCopyWidthOnComplete:Ljava/lang/Integer;

.field private mListView:Landroid/view/View;

.field private mListener:Lcom/android/mail/ui/LayoutListener;

.field private mPositionedMode:I

.field private final mSlideInterpolator:Landroid/animation/TimeInterpolator;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 110
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/ui/TwoPaneLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 111
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v4, 0x0

    .line 114
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 78
    iput v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    .line 83
    iput v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    .line 116
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 121
    .local v3, "res":Landroid/content/res/Resources;
    const/high16 v4, 0x7f0f0000

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v4

    iput-boolean v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCollapsible:Z

    .line 123
    const v4, 0x10c0003

    invoke-static {p1, v4}, Landroid/view/animation/AnimationUtils;->loadInterpolator(Landroid/content/Context;I)Landroid/view/animation/Interpolator;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mSlideInterpolator:Landroid/animation/TimeInterpolator;

    .line 126
    const v4, 0x7f0a0019

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    .line 127
    .local v2, "folderListWeight":I
    const v4, 0x7f0a001a

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v0

    .line 128
    .local v0, "convListWeight":I
    const v4, 0x7f0a001b

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    .line 129
    .local v1, "convViewWeight":I
    int-to-double v4, v2

    add-int v6, v2, v0

    int-to-double v6, v6

    div-double/2addr v4, v6

    iput-wide v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFolderListWeight:D

    .line 131
    int-to-double v4, v0

    add-int v6, v0, v1

    int-to-double v6, v6

    div-double/2addr v4, v6

    iput-wide v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationListWeight:D

    .line 133
    return-void
.end method

.method static synthetic access$000(Lcom/android/mail/ui/TwoPaneLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/TwoPaneLayout;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneLayout;->onTransitionComplete()V

    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/ui/TwoPaneLayout;)Lcom/android/mail/ui/ConversationListCopy;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/TwoPaneLayout;

    .prologue
    .line 59
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/ui/TwoPaneLayout;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/TwoPaneLayout;
    .param p1, "x1"    # Z

    .prologue
    .line 59
    invoke-direct {p0, p1}, Lcom/android/mail/ui/TwoPaneLayout;->useHardwareLayer(Z)V

    return-void
.end method

.method static synthetic access$300(Lcom/android/mail/ui/TwoPaneLayout;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/ui/TwoPaneLayout;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/android/mail/ui/TwoPaneLayout;->fixupListCopyWidth()V

    return-void
.end method

.method private animatePanes(III)V
    .locals 5
    .param p1, "foldersX"    # I
    .param p2, "listX"    # I
    .param p3, "convX"    # I

    .prologue
    const/4 v4, 0x1

    const/high16 v3, 0x3f800000    # 1.0f

    const/4 v2, 0x0

    .line 285
    iget v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    if-nez v0, :cond_0

    .line 286
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    int-to-float v1, p3

    invoke-virtual {v0, v1}, Landroid/view/View;->setX(F)V

    .line 287
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    int-to-float v1, p1

    invoke-virtual {v0, v1}, Landroid/view/View;->setX(F)V

    .line 288
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    int-to-float v1, p2

    invoke-virtual {v0, v1}, Landroid/view/View;->setX(F)V

    .line 292
    new-instance v0, Lcom/android/mail/ui/TwoPaneLayout$1;

    invoke-direct {v0, p0}, Lcom/android/mail/ui/TwoPaneLayout$1;-><init>(Lcom/android/mail/ui/TwoPaneLayout;)V

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->post(Ljava/lang/Runnable;)Z

    .line 331
    :goto_0
    return-void

    .line 302
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ConversationListCopy;->bind(Landroid/view/View;)V

    .line 303
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getX()F

    move-result v1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ConversationListCopy;->setX(F)V

    .line 305
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-virtual {v0, v3}, Lcom/android/mail/ui/ConversationListCopy;->setAlpha(F)V

    .line 306
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setAlpha(F)V

    .line 308
    invoke-direct {p0, v4}, Lcom/android/mail/ui/TwoPaneLayout;->useHardwareLayer(Z)V

    .line 310
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    int-to-float v1, p3

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->x(F)Landroid/view/ViewPropertyAnimator;

    .line 311
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    int-to-float v1, p1

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->x(F)Landroid/view/ViewPropertyAnimator;

    .line 312
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationListCopy;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    int-to-float v1, p2

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->x(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    .line 313
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    int-to-float v1, p2

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->x(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/TwoPaneLayout$2;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/TwoPaneLayout$2;-><init>(Lcom/android/mail/ui/TwoPaneLayout;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->setListener(Landroid/animation/Animator$AnimatorListener;)Landroid/view/ViewPropertyAnimator;

    .line 330
    const/4 v0, 0x4

    new-array v0, v0, [Landroid/view/View;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    aput-object v2, v0, v1

    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    aput-object v1, v0, v4

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    aput-object v2, v0, v1

    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->configureAnimations([Landroid/view/View;)V

    goto :goto_0
.end method

.method private computeConversationListWidth(I)I
    .locals 4
    .param p1, "totalWidth"    # I

    .prologue
    .line 405
    iget v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    packed-switch v0, :pswitch_data_0

    .line 413
    :pswitch_0
    const/4 v0, 0x0

    :goto_0
    return v0

    .line 408
    :pswitch_1
    invoke-direct {p0, p1}, Lcom/android/mail/ui/TwoPaneLayout;->computeFolderListWidth(I)I

    move-result v0

    sub-int v0, p1, v0

    goto :goto_0

    .line 411
    :pswitch_2
    int-to-double v0, p1

    iget-wide v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationListWeight:D

    mul-double/2addr v0, v2

    double-to-int v0, v0

    goto :goto_0

    .line 405
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_2
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private computeConversationWidth(I)I
    .locals 4
    .param p1, "totalWidth"    # I

    .prologue
    .line 421
    iget-boolean v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCollapsible:Z

    if-eqz v0, :cond_0

    .line 424
    .end local p1    # "totalWidth":I
    :goto_0
    return p1

    .restart local p1    # "totalWidth":I
    :cond_0
    int-to-double v0, p1

    iget-wide v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationListWeight:D

    mul-double/2addr v0, v2

    double-to-int v0, v0

    sub-int/2addr p1, v0

    goto :goto_0
.end method

.method private computeFolderListWidth(I)I
    .locals 4
    .param p1, "parentWidth"    # I

    .prologue
    .line 432
    iget-boolean v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mIsSearchResult:Z

    if-eqz v0, :cond_0

    .line 433
    const/4 v0, 0x0

    .line 435
    :goto_0
    return v0

    :cond_0
    int-to-double v0, p1

    iget-wide v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFolderListWeight:D

    mul-double/2addr v0, v2

    double-to-int v0, v0

    goto :goto_0
.end method

.method private varargs configureAnimations([Landroid/view/View;)V
    .locals 7
    .param p1, "views"    # [Landroid/view/View;

    .prologue
    .line 334
    move-object v0, p1

    .local v0, "arr$":[Landroid/view/View;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 335
    .local v3, "v":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v4

    iget-object v5, p0, Lcom/android/mail/ui/TwoPaneLayout;->mSlideInterpolator:Landroid/animation/TimeInterpolator;

    invoke-virtual {v4, v5}, Landroid/view/ViewPropertyAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)Landroid/view/ViewPropertyAnimator;

    move-result-object v4

    const-wide/16 v5, 0x12c

    invoke-virtual {v4, v5, v6}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    .line 334
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 339
    .end local v3    # "v":Landroid/view/View;
    :cond_0
    return-void
.end method

.method private dispatchConversationListVisibilityChange(Z)V
    .locals 1
    .param p1, "visible"    # Z

    .prologue
    .line 439
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListener:Lcom/android/mail/ui/LayoutListener;

    if-eqz v0, :cond_0

    .line 440
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListener:Lcom/android/mail/ui/LayoutListener;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/LayoutListener;->onConversationListVisibilityChanged(Z)V

    .line 442
    :cond_0
    return-void
.end method

.method private dispatchConversationVisibilityChanged(Z)V
    .locals 1
    .param p1, "visible"    # Z

    .prologue
    .line 445
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListener:Lcom/android/mail/ui/LayoutListener;

    if-eqz v0, :cond_0

    .line 446
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListener:Lcom/android/mail/ui/LayoutListener;

    invoke-interface {v0, p1}, Lcom/android/mail/ui/LayoutListener;->onConversationVisibilityChanged(Z)V

    .line 448
    :cond_0
    return-void
.end method

.method private fixupListCopyWidth()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 358
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->getPaneWidth(Landroid/view/View;)I

    move-result v0

    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 360
    :cond_0
    iput-object v5, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    .line 367
    :goto_0
    return-void

    .line 363
    :cond_1
    const-string v0, "TwoPaneLayout"

    const-string v1, "onAnimationEnd of list view, setting copy width to %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 365
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    invoke-direct {p0, v0, v1}, Lcom/android/mail/ui/TwoPaneLayout;->setPaneWidth(Landroid/view/View;I)V

    .line 366
    iput-object v5, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    goto :goto_0
.end method

.method private getPaneWidth(Landroid/view/View;)I
    .locals 1
    .param p1, "pane"    # Landroid/view/View;

    .prologue
    .line 451
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    iget v0, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    return v0
.end method

.method private onTransitionComplete()V
    .locals 3

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 370
    iget-object v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mController:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v2}, Lcom/android/mail/ui/AbstractActivityController;->isDestroyed()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 372
    const-string v0, "TwoPaneLayout"

    const-string v2, "IN TPL.onTransitionComplete, activity destroyed->quitting early"

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v2, v1}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 392
    :goto_0
    return-void

    .line 376
    :cond_0
    iget v2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    packed-switch v2, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 379
    :pswitch_1
    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->dispatchConversationVisibilityChanged(Z)V

    .line 380
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneLayout;->isConversationListCollapsed()Z

    move-result v2

    if-nez v2, :cond_1

    :goto_1
    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->dispatchConversationListVisibilityChange(Z)V

    goto :goto_0

    :cond_1
    move v0, v1

    goto :goto_1

    .line 385
    :pswitch_2
    invoke-direct {p0, v1}, Lcom/android/mail/ui/TwoPaneLayout;->dispatchConversationVisibilityChanged(Z)V

    .line 386
    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->dispatchConversationListVisibilityChange(Z)V

    goto :goto_0

    .line 376
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private positionPanes(I)V
    .locals 13
    .param p1, "width"    # I

    .prologue
    const/4 v8, 0x3

    const/4 v12, 0x2

    const/4 v11, 0x1

    const/4 v10, 0x0

    .line 228
    iget v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    iget v7, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    if-ne v6, v7, :cond_0

    .line 274
    :goto_0
    return-void

    .line 232
    :cond_0
    const/4 v3, 0x0

    .line 233
    .local v3, "hasPositions":Z
    const/4 v0, 0x0

    .local v0, "convX":I
    const/4 v5, 0x0

    .local v5, "listX":I
    const/4 v2, 0x0

    .line 235
    .local v2, "foldersX":I
    iget v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    packed-switch v6, :pswitch_data_0

    .line 269
    :goto_1
    :pswitch_0
    if-eqz v3, :cond_1

    .line 270
    invoke-direct {p0, v2, v5, v0}, Lcom/android/mail/ui/TwoPaneLayout;->animatePanes(III)V

    .line 273
    :cond_1
    iget v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    iput v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    goto :goto_0

    .line 238
    :pswitch_1
    iget-object v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-direct {p0, v6}, Lcom/android/mail/ui/TwoPaneLayout;->getPaneWidth(Landroid/view/View;)I

    move-result v1

    .line 240
    .local v1, "foldersW":I
    iget-object v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-direct {p0, v6}, Lcom/android/mail/ui/TwoPaneLayout;->getPaneWidth(Landroid/view/View;)I

    move-result v4

    .line 242
    .local v4, "listW":I
    iget-boolean v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCollapsible:Z

    if-eqz v6, :cond_2

    .line 243
    const/4 v0, 0x0

    .line 244
    neg-int v5, v4

    .line 245
    sub-int v2, v5, v1

    .line 251
    :goto_2
    const/4 v3, 0x1

    .line 252
    const-string v6, "TwoPaneLayout"

    const-string v7, "conversation mode layout, x=%d/%d/%d"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v12

    invoke-static {v6, v7, v8}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 247
    :cond_2
    move v0, v4

    .line 248
    const/4 v5, 0x0

    .line 249
    neg-int v2, v1

    goto :goto_2

    .line 257
    .end local v1    # "foldersW":I
    .end local v4    # "listW":I
    :pswitch_2
    move v0, p1

    .line 258
    iget-object v6, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-direct {p0, v6}, Lcom/android/mail/ui/TwoPaneLayout;->getPaneWidth(Landroid/view/View;)I

    move-result v5

    .line 259
    const/4 v2, 0x0

    .line 261
    const/4 v3, 0x1

    .line 262
    const-string v6, "TwoPaneLayout"

    const-string v7, "conv-list mode layout, x=%d/%d/%d"

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v12

    invoke-static {v6, v7, v8}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_1

    .line 235
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private setPaneWidth(Landroid/view/View;I)V
    .locals 2
    .param p1, "pane"    # Landroid/view/View;
    .param p2, "w"    # I

    .prologue
    .line 489
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    .line 490
    .local v0, "lp":Landroid/view/ViewGroup$LayoutParams;
    iget v1, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    if-ne v1, p2, :cond_0

    .line 495
    :goto_0
    return-void

    .line 493
    :cond_0
    iput p2, v0, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 494
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_0
.end method

.method private setupPaneWidths(I)V
    .locals 11
    .param p1, "parentWidth"    # I

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 182
    invoke-direct {p0, p1}, Lcom/android/mail/ui/TwoPaneLayout;->computeFolderListWidth(I)I

    move-result v2

    .line 183
    .local v2, "foldersWidth":I
    invoke-direct {p0, p1}, Lcom/android/mail/ui/TwoPaneLayout;->computeConversationWidth(I)I

    move-result v0

    .line 186
    .local v0, "convWidth":I
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneLayout;->getMeasuredWidth()I

    move-result v4

    if-eq p1, v4, :cond_0

    .line 187
    const-string v4, "TwoPaneLayout"

    const-string v5, "setting up new TPL, w=%d fw=%d cv=%d"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v10

    const/4 v7, 0x2

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 190
    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-direct {p0, v4, v2}, Lcom/android/mail/ui/TwoPaneLayout;->setPaneWidth(Landroid/view/View;I)V

    .line 191
    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    invoke-direct {p0, v4, v0}, Lcom/android/mail/ui/TwoPaneLayout;->setPaneWidth(Landroid/view/View;I)V

    .line 194
    :cond_0
    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-direct {p0, v4}, Lcom/android/mail/ui/TwoPaneLayout;->getPaneWidth(Landroid/view/View;)I

    move-result v1

    .line 195
    .local v1, "currListWidth":I
    move v3, v1

    .line 196
    .local v3, "listWidth":I
    iget v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    packed-switch v4, :pswitch_data_0

    .line 210
    :cond_1
    :goto_0
    :pswitch_0
    const-string v4, "TwoPaneLayout"

    const-string v5, "conversation list width change, w=%d"

    new-array v6, v10, [Ljava/lang/Object;

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 211
    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-direct {p0, v4, v3}, Lcom/android/mail/ui/TwoPaneLayout;->setPaneWidth(Landroid/view/View;I)V

    .line 213
    iget v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    iget v5, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    if-eq v4, v5, :cond_2

    iget v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    if-nez v4, :cond_3

    :cond_2
    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    if-eqz v4, :cond_4

    .line 215
    :cond_3
    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyWidthOnComplete:Ljava/lang/Integer;

    .line 219
    :goto_1
    return-void

    .line 199
    :pswitch_1
    iget-boolean v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCollapsible:Z

    if-nez v4, :cond_1

    .line 200
    sub-int v3, p1, v0

    goto :goto_0

    .line 205
    :pswitch_2
    sub-int v3, p1, v2

    .line 206
    goto :goto_0

    .line 217
    :cond_4
    iget-object v4, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-direct {p0, v4, v3}, Lcom/android/mail/ui/TwoPaneLayout;->setPaneWidth(Landroid/view/View;I)V

    goto :goto_1

    .line 196
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_2
        :pswitch_1
    .end packed-switch
.end method

.method private useHardwareLayer(Z)V
    .locals 3
    .param p1, "useHardware"    # Z

    .prologue
    const/4 v2, 0x0

    .line 342
    if-eqz p1, :cond_1

    const/4 v0, 0x2

    .line 343
    .local v0, "layerType":I
    :goto_0
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-virtual {v1, v0, v2}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 344
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v1, v0, v2}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 345
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-virtual {v1, v0, v2}, Lcom/android/mail/ui/ConversationListCopy;->setLayerType(ILandroid/graphics/Paint;)V

    .line 346
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    invoke-virtual {v1, v0, v2}, Landroid/view/View;->setLayerType(ILandroid/graphics/Paint;)V

    .line 347
    if-eqz p1, :cond_0

    .line 350
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->buildLayer()V

    .line 351
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->buildLayer()V

    .line 352
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-virtual {v1}, Lcom/android/mail/ui/ConversationListCopy;->buildLayer()V

    .line 353
    iget-object v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->buildLayer()V

    .line 355
    :cond_0
    return-void

    .line 342
    .end local v0    # "layerType":I
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected computeConversationListWidth()I
    .locals 1

    .prologue
    .line 398
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneLayout;->getMeasuredWidth()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->computeConversationListWidth(I)I

    move-result v0

    return v0
.end method

.method public isConversationListCollapsed()Z
    .locals 1

    .prologue
    .line 462
    iget v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    invoke-static {v0}, Lcom/android/mail/ui/ViewMode;->isListMode(I)Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCollapsible:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 137
    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    .line 139
    const v0, 0x7f1000be

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    .line 140
    const v0, 0x7f1000fc

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    .line 141
    const v0, 0x7f1000fd

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/android/mail/ui/ConversationListCopy;

    iput-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    .line 142
    const v0, 0x7f1000ab

    invoke-virtual {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    .line 145
    const/4 v0, 0x0

    iput v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    .line 146
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 147
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 148
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/ConversationListCopy;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 150
    return-void
.end method

.method protected onLayout(ZIIII)V
    .locals 4
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 168
    const-string v0, "MailBlankFragment"

    const-string v1, "TPL(%s).onLayout()"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 169
    if-nez p1, :cond_0

    iget v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    iget v1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mPositionedMode:I

    if-eq v0, v1, :cond_1

    .line 170
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneLayout;->getMeasuredWidth()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->positionPanes(I)V

    .line 172
    :cond_1
    invoke-super/range {p0 .. p5}, Landroid/widget/FrameLayout;->onLayout(ZIIII)V

    .line 173
    return-void
.end method

.method protected onMeasure(II)V
    .locals 4
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 161
    const-string v0, "MailBlankFragment"

    const-string v1, "TPL(%s).onMeasure()"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p0, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 162
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    invoke-direct {p0, v0}, Lcom/android/mail/ui/TwoPaneLayout;->setupPaneWidths(I)V

    .line 163
    invoke-super {p0, p1, p2}, Landroid/widget/FrameLayout;->onMeasure(II)V

    .line 164
    return-void
.end method

.method public onViewModeChanged(I)V
    .locals 5
    .param p1, "newMode"    # I

    .prologue
    const/4 v4, 0x0

    .line 468
    iget v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    if-nez v0, :cond_0

    .line 469
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mFoldersView:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 470
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListView:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 471
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListCopyView:Lcom/android/mail/ui/ConversationListCopy;

    invoke-virtual {v0, v4}, Lcom/android/mail/ui/ConversationListCopy;->setVisibility(I)V

    .line 472
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mConversationView:Landroid/view/View;

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 476
    :cond_0
    iget v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    invoke-static {v0}, Lcom/android/mail/ui/ViewMode;->isConversationMode(I)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 477
    iget-object v0, p0, Lcom/android/mail/ui/TwoPaneLayout;->mController:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v0}, Lcom/android/mail/ui/AbstractActivityController;->disablePagerUpdates()V

    .line 480
    :cond_1
    iput p1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mCurrentMode:I

    .line 481
    const-string v0, "TwoPaneLayout"

    const-string v1, "onViewModeChanged(%d)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 485
    invoke-virtual {p0}, Lcom/android/mail/ui/TwoPaneLayout;->requestLayout()V

    .line 486
    return-void
.end method

.method public requestLayout()V
    .locals 0

    .prologue
    .line 499
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->checkRequestLayout(Landroid/view/View;)V

    .line 500
    invoke-super {p0}, Landroid/widget/FrameLayout;->requestLayout()V

    .line 501
    return-void
.end method

.method public setController(Lcom/android/mail/ui/AbstractActivityController;Z)V
    .locals 0
    .param p1, "controller"    # Lcom/android/mail/ui/AbstractActivityController;
    .param p2, "isSearchResult"    # Z

    .prologue
    .line 154
    iput-object p1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mController:Lcom/android/mail/ui/AbstractActivityController;

    .line 155
    iput-object p1, p0, Lcom/android/mail/ui/TwoPaneLayout;->mListener:Lcom/android/mail/ui/LayoutListener;

    .line 156
    iput-boolean p2, p0, Lcom/android/mail/ui/TwoPaneLayout;->mIsSearchResult:Z

    .line 157
    return-void
.end method
