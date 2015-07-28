.class public Lcom/android/mail/browse/ConversationContainer;
.super Landroid/view/ViewGroup;
.source "ConversationContainer.java"

# interfaces
.implements Lcom/android/mail/browse/ScrollNotifier$ScrollListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationContainer$AdapterObserver;,
        Lcom/android/mail/browse/ConversationContainer$OverlayView;,
        Lcom/android/mail/browse/ConversationContainer$OverlayPosition;,
        Lcom/android/mail/browse/ConversationContainer$DetachListener;
    }
.end annotation


# static fields
.field private static final BOTTOM_LAYER_VIEW_IDS:[I

.field private static final TOP_LAYER_VIEW_IDS:[I


# instance fields
.field private mActivePointerId:I

.field private final mAdapterObserver:Landroid/database/DataSetObserver;

.field private mAttachedOverlaySinceLastDraw:Z

.field private mDisableLayoutTracing:Z

.field private mLastMotionY:F

.field private mMissedPointerDown:Z

.field private final mNonScrollingChildren:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mOffsetY:I

.field private mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

.field private mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

.field private final mOverlayViews:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Lcom/android/mail/browse/ConversationContainer$OverlayView;",
            ">;"
        }
    .end annotation
.end field

.field private mScale:F

.field private final mScrapViews:Lcom/android/mail/utils/DequeMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/android/mail/utils/DequeMap",
            "<",
            "Ljava/lang/Integer;",
            "Landroid/view/View;",
            ">;"
        }
    .end annotation
.end field

.field private mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

.field private mSnapIndex:I

.field private mTopMostOverlay:Landroid/view/View;

.field private mTouchInitialized:Z

.field private mTouchIsDown:Z

.field private final mTouchSlop:I

.field private final mVelocityTracker:Lcom/android/mail/utils/InputSmoother;

.field private mWebView:Lcom/android/mail/browse/ConversationWebView;

.field private mWidthMeasureSpec:I


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 71
    new-array v0, v3, [I

    const v1, 0x7f1000ad

    aput v1, v0, v2

    sput-object v0, Lcom/android/mail/browse/ConversationContainer;->BOTTOM_LAYER_VIEW_IDS:[I

    .line 75
    new-array v0, v3, [I

    const v1, 0x7f1000ae

    aput v1, v0, v2

    sput-object v0, Lcom/android/mail/browse/ConversationContainer;->TOP_LAYER_VIEW_IDS:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 217
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/ConversationContainer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 218
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v2, 0x0

    .line 221
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 104
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mNonScrollingChildren:Ljava/util/List;

    .line 138
    iput-boolean v2, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchIsDown:Z

    .line 149
    new-instance v0, Lcom/android/mail/utils/DequeMap;

    invoke-direct {v0}, Lcom/android/mail/utils/DequeMap;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mScrapViews:Lcom/android/mail/utils/DequeMap;

    .line 173
    new-instance v0, Lcom/android/mail/browse/ConversationContainer$AdapterObserver;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/android/mail/browse/ConversationContainer$AdapterObserver;-><init>(Lcom/android/mail/browse/ConversationContainer;Lcom/android/mail/browse/ConversationContainer$1;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mAdapterObserver:Landroid/database/DataSetObserver;

    .line 223
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    .line 225
    new-instance v0, Lcom/android/mail/utils/InputSmoother;

    invoke-direct {v0, p1}, Lcom/android/mail/utils/InputSmoother;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mVelocityTracker:Lcom/android/mail/utils/InputSmoother;

    .line 227
    invoke-static {p1}, Landroid/view/ViewConfiguration;->get(Landroid/content/Context;)Landroid/view/ViewConfiguration;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewConfiguration;->getScaledTouchSlop()I

    move-result v0

    iput v0, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchSlop:I

    .line 233
    invoke-virtual {p0, v2}, Lcom/android/mail/browse/ConversationContainer;->setMotionEventSplittingEnabled(Z)V

    .line 234
    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/browse/ConversationContainer;Lcom/android/mail/browse/ConversationContainer$OverlayView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationContainer;
    .param p1, "x1"    # Lcom/android/mail/browse/ConversationContainer$OverlayView;

    .prologue
    .line 68
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationContainer;->detachOverlay(Lcom/android/mail/browse/ConversationContainer$OverlayView;)V

    return-void
.end method

.method static synthetic access$200(Lcom/android/mail/browse/ConversationContainer;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationContainer;

    .prologue
    .line 68
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationContainer;->onDataSetChanged()V

    return-void
.end method

.method private addOverlayView(I)Landroid/view/View;
    .locals 10
    .param p1, "adapterIndex"    # I

    .prologue
    const/4 v6, 0x2

    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 755
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v4, p1}, Lcom/android/mail/browse/ConversationViewAdapter;->getItemViewType(I)I

    move-result v2

    .line 756
    .local v2, "itemType":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mScrapViews:Lcom/android/mail/utils/DequeMap;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/android/mail/utils/DequeMap;->poll(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    .line 758
    .local v0, "convertView":Landroid/view/View;
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v4, p1, v0, p0}, Lcom/android/mail/browse/ConversationViewAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 759
    .local v3, "view":Landroid/view/View;
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    new-instance v5, Lcom/android/mail/browse/ConversationContainer$OverlayView;

    invoke-direct {v5, v3, v2}, Lcom/android/mail/browse/ConversationContainer$OverlayView;-><init>(Landroid/view/View;I)V

    invoke-virtual {v4, p1, v5}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 761
    sget-object v4, Lcom/android/mail/browse/ConversationContainer;->BOTTOM_LAYER_VIEW_IDS:[I

    array-length v1, v4

    .line 763
    .local v1, "index":I
    if-ne v0, v3, :cond_0

    .line 764
    const-string v4, "ConvLayout"

    const-string v5, "want to REUSE scrolled-in view: index=%d obj=%s"

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    aput-object v3, v6, v8

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 768
    :goto_0
    invoke-virtual {v3}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v4

    invoke-virtual {p0, v3, v1, v4, v8}, Lcom/android/mail/browse/ConversationContainer;->addViewInLayout(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;Z)Z

    .line 770
    iput-boolean v8, p0, Lcom/android/mail/browse/ConversationContainer;->mAttachedOverlaySinceLastDraw:Z

    .line 772
    return-object v3

    .line 766
    :cond_0
    const-string v4, "ConvLayout"

    const-string v5, "want to CREATE scrolled-in view: index=%d obj=%s"

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v6, v9

    aput-object v3, v6, v8

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method private calculatePosition(Lcom/android/mail/browse/ConversationOverlayItem;III)Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    .locals 5
    .param p1, "adapterItem"    # Lcom/android/mail/browse/ConversationOverlayItem;
    .param p2, "withinTop"    # I
    .param p3, "withinBottom"    # I
    .param p4, "forceGravity"    # I

    .prologue
    .line 497
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationOverlayItem;->getHeight()I

    move-result v2

    if-nez v2, :cond_1

    .line 500
    const/16 v2, 0x30

    if-ne p4, v2, :cond_0

    move v1, p2

    .line 501
    .local v1, "y":I
    :goto_0
    new-instance v2, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    invoke-direct {v2, v1, v1}, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;-><init>(II)V

    .line 510
    .end local v1    # "y":I
    .end local p4    # "forceGravity":I
    :goto_1
    return-object v2

    .restart local p4    # "forceGravity":I
    :cond_0
    move v1, p3

    .line 500
    goto :goto_0

    .line 504
    :cond_1
    if-eqz p4, :cond_2

    .end local p4    # "forceGravity":I
    :goto_2
    and-int/lit8 v0, p4, 0x70

    .line 506
    .local v0, "v":I
    sparse-switch v0, :sswitch_data_0

    .line 512
    new-instance v2, Ljava/lang/UnsupportedOperationException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "unsupported gravity: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 504
    .end local v0    # "v":I
    .restart local p4    # "forceGravity":I
    :cond_2
    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationOverlayItem;->getGravity()I

    move-result p4

    goto :goto_2

    .line 508
    .end local p4    # "forceGravity":I
    .restart local v0    # "v":I
    :sswitch_0
    new-instance v2, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationOverlayItem;->getHeight()I

    move-result v3

    sub-int v3, p3, v3

    invoke-direct {v2, v3, p3}, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;-><init>(II)V

    goto :goto_1

    .line 510
    :sswitch_1
    new-instance v2, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    invoke-virtual {p1}, Lcom/android/mail/browse/ConversationOverlayItem;->getHeight()I

    move-result v3

    add-int/2addr v3, p2

    invoke-direct {v2, p2, v3}, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;-><init>(II)V

    goto :goto_1

    .line 506
    nop

    :sswitch_data_0
    .sparse-switch
        0x30 -> :sswitch_1
        0x50 -> :sswitch_0
    .end sparse-switch
.end method

.method private clearOverlays()V
    .locals 3

    .prologue
    .line 293
    const/4 v0, 0x0

    .local v0, "i":I
    iget-object v2, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->size()I

    move-result v1

    .local v1, "len":I
    :goto_0
    if-ge v0, v1, :cond_0

    .line 294
    iget-object v2, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    invoke-virtual {v2, v0}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/android/mail/browse/ConversationContainer$OverlayView;

    invoke-direct {p0, v2}, Lcom/android/mail/browse/ConversationContainer;->detachOverlay(Lcom/android/mail/browse/ConversationContainer$OverlayView;)V

    .line 293
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 296
    :cond_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    invoke-virtual {v2}, Landroid/util/SparseArray;->clear()V

    .line 297
    return-void
.end method

.method private detachOverlay(Lcom/android/mail/browse/ConversationContainer$OverlayView;)V
    .locals 3
    .param p1, "overlay"    # Lcom/android/mail/browse/ConversationContainer$OverlayView;

    .prologue
    .line 586
    iget-object v0, p1, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationContainer;->removeViewInLayout(Landroid/view/View;)V

    .line 587
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mScrapViews:Lcom/android/mail/utils/DequeMap;

    iget v1, p1, Lcom/android/mail/browse/ConversationContainer$OverlayView;->itemType:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    iget-object v2, p1, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/utils/DequeMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 588
    iget-object v0, p1, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    instance-of v0, v0, Lcom/android/mail/browse/ConversationContainer$DetachListener;

    if-eqz v0, :cond_0

    .line 589
    iget-object v0, p1, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    check-cast v0, Lcom/android/mail/browse/ConversationContainer$DetachListener;

    invoke-interface {v0}, Lcom/android/mail/browse/ConversationContainer$DetachListener;->onDetachedFromParent()V

    .line 591
    :cond_0
    return-void
.end method

.method private findNextPushingOverlay(I)Lcom/android/mail/browse/ConversationOverlayItem;
    .locals 5
    .param p1, "start"    # I

    .prologue
    .line 814
    const/4 v3, -0x1

    .line 815
    .local v3, "value":I
    move v0, p1

    .local v0, "i":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v4}, Lcom/android/mail/browse/ConversationViewAdapter;->getCount()I

    move-result v1

    .local v1, "len":I
    :goto_0
    if-ge v0, v1, :cond_1

    .line 816
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v4, v0}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v2

    .line 817
    .local v2, "next":Lcom/android/mail/browse/ConversationOverlayItem;
    invoke-virtual {v2}, Lcom/android/mail/browse/ConversationOverlayItem;->canPushSnapHeader()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 821
    .end local v2    # "next":Lcom/android/mail/browse/ConversationOverlayItem;
    :goto_1
    return-object v2

    .line 815
    .restart local v2    # "next":Lcom/android/mail/browse/ConversationOverlayItem;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 821
    .end local v2    # "next":Lcom/android/mail/browse/ConversationOverlayItem;
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method private forwardFakeMotionEvent(Landroid/view/MotionEvent;I)V
    .locals 6
    .param p1, "original"    # Landroid/view/MotionEvent;
    .param p2, "newAction"    # I

    .prologue
    .line 313
    invoke-static {p1}, Landroid/view/MotionEvent;->obtain(Landroid/view/MotionEvent;)Landroid/view/MotionEvent;

    move-result-object v0

    .line 314
    .local v0, "newEvent":Landroid/view/MotionEvent;
    invoke-virtual {v0, p2}, Landroid/view/MotionEvent;->setAction(I)V

    .line 315
    iget-object v1, p0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/ConversationWebView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 316
    const-string v1, "ConvLayout"

    const-string v2, "in Container.OnTouch. fake: action=%d x/y=%f/%f pointers=%d"

    const/4 v3, 0x4

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getX()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x3

    invoke-virtual {v0}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 319
    return-void
.end method

.method private getOverlayBottom(I)I
    .locals 1
    .param p1, "spacerIndex"    # I

    .prologue
    .line 684
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    aget-object v0, v0, p1

    iget v0, v0, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationContainer;->webPxToScreenPx(I)I

    move-result v0

    return v0
.end method

.method private getOverlayTop(I)I
    .locals 1
    .param p1, "spacerIndex"    # I

    .prologue
    .line 680
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    aget-object v0, v0, p1

    iget v0, v0, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    invoke-direct {p0, v0}, Lcom/android/mail/browse/ConversationContainer;->webPxToScreenPx(I)I

    move-result v0

    return v0
.end method

.method private layoutOverlay(Landroid/view/View;II)V
    .locals 6
    .param p1, "child"    # Landroid/view/View;
    .param p2, "childTop"    # I
    .param p3, "childBottom"    # I

    .prologue
    .line 745
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    sub-int v3, p2, v4

    .line 746
    .local v3, "top":I
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    sub-int v0, p3, v4

    .line 748
    .local v0, "bottom":I
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 749
    .local v2, "lp":Landroid/view/ViewGroup$MarginLayoutParams;
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->getPaddingLeft()I

    move-result v4

    iget v5, v2, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int v1, v4, v5

    .line 751
    .local v1, "childLeft":I
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredWidth()I

    move-result v4

    add-int/2addr v4, v1

    invoke-virtual {p1, v1, v3, v4, v0}, Landroid/view/View;->layout(IIII)V

    .line 752
    return-void
.end method

.method private measureOverlayView(Landroid/view/View;)V
    .locals 8
    .param p1, "child"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x0

    .line 533
    invoke-virtual {p1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 534
    .local v3, "p":Landroid/view/ViewGroup$MarginLayoutParams;
    if-nez v3, :cond_0

    .line 535
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    .end local v3    # "p":Landroid/view/ViewGroup$MarginLayoutParams;
    check-cast v3, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 538
    .restart local v3    # "p":Landroid/view/ViewGroup$MarginLayoutParams;
    :cond_0
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mWidthMeasureSpec:I

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->getPaddingLeft()I

    move-result v5

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->getPaddingRight()I

    move-result v6

    add-int/2addr v5, v6

    iget v6, v3, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    add-int/2addr v5, v6

    iget v6, v3, Landroid/view/ViewGroup$MarginLayoutParams;->rightMargin:I

    add-int/2addr v5, v6

    iget v6, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    invoke-static {v4, v5, v6}, Landroid/view/ViewGroup;->getChildMeasureSpec(III)I

    move-result v1

    .line 540
    .local v1, "childWidthSpec":I
    iget v2, v3, Landroid/view/ViewGroup$MarginLayoutParams;->height:I

    .line 542
    .local v2, "lpHeight":I
    if-lez v2, :cond_1

    .line 543
    const/high16 v4, 0x40000000    # 2.0f

    invoke-static {v2, v4}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .line 547
    .local v0, "childHeightSpec":I
    :goto_0
    invoke-virtual {p1, v1, v0}, Landroid/view/View;->measure(II)V

    .line 548
    return-void

    .line 545
    .end local v0    # "childHeightSpec":I
    :cond_1
    invoke-static {v7, v7}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    .restart local v0    # "childHeightSpec":I
    goto :goto_0
.end method

.method private onDataSetChanged()V
    .locals 2

    .prologue
    .line 305
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationContainer;->clearOverlays()V

    .line 308
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v0}, Lcom/android/mail/browse/MessageHeaderView;->unbind()V

    .line 309
    const/4 v0, 0x0

    iget v1, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    invoke-direct {p0, v0, v1}, Lcom/android/mail/browse/ConversationContainer;->positionOverlays(II)V

    .line 310
    return-void
.end method

.method private onOverlayScrolledOff(ILcom/android/mail/browse/ConversationContainer$OverlayView;II)V
    .locals 1
    .param p1, "adapterIndex"    # I
    .param p2, "overlay"    # Lcom/android/mail/browse/ConversationContainer$OverlayView;
    .param p3, "overlayTop"    # I
    .param p4, "overlayBottom"    # I

    .prologue
    .line 556
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseArray;->remove(I)V

    .line 558
    new-instance v0, Lcom/android/mail/browse/ConversationContainer$1;

    invoke-direct {v0, p0, p2}, Lcom/android/mail/browse/ConversationContainer$1;-><init>(Lcom/android/mail/browse/ConversationContainer;Lcom/android/mail/browse/ConversationContainer$OverlayView;)V

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationContainer;->post(Ljava/lang/Runnable;)Z

    .line 567
    iget-object v0, p2, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    invoke-direct {p0, v0, p3, p4}, Lcom/android/mail/browse/ConversationContainer;->layoutOverlay(Landroid/view/View;II)V

    .line 568
    return-void
.end method

.method private positionOverlay(III)V
    .locals 9
    .param p1, "adapterIndex"    # I
    .param p2, "overlayTopY"    # I
    .param p3, "overlayBottomY"    # I

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 694
    iget-object v3, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    invoke-virtual {v3, p1}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ConversationContainer$OverlayView;

    .line 695
    .local v1, "overlay":Lcom/android/mail/browse/ConversationContainer$OverlayView;
    iget-object v3, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v3, p1}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v0

    .line 698
    .local v0, "item":Lcom/android/mail/browse/ConversationOverlayItem;
    invoke-virtual {v0, p2}, Lcom/android/mail/browse/ConversationOverlayItem;->setTop(I)V

    .line 701
    if-eq p2, p3, :cond_4

    iget v3, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    if-le p3, v3, :cond_4

    iget v3, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->getHeight()I

    move-result v4

    add-int/2addr v3, v4

    if-ge p2, v3, :cond_4

    .line 703
    if-eqz v1, :cond_2

    iget-object v2, v1, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    .line 705
    .local v2, "overlayView":Landroid/view/View;
    :goto_0
    if-nez v2, :cond_3

    .line 706
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationContainer;->addOverlayView(I)Landroid/view/View;

    move-result-object v2

    .line 707
    invoke-direct {p0, v2}, Lcom/android/mail/browse/ConversationContainer;->measureOverlayView(Landroid/view/View;)V

    .line 708
    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationOverlayItem;->markMeasurementValid()V

    .line 709
    const-string v3, "show/measure overlay %d"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 719
    :cond_0
    :goto_1
    const-string v3, "laying out overlay %d with h=%d"

    new-array v4, v8, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 721
    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v3

    add-int/2addr v3, p2

    invoke-direct {p0, v2, p2, v3}, Lcom/android/mail/browse/ConversationContainer;->layoutOverlay(Landroid/view/View;II)V

    .line 732
    .end local v2    # "overlayView":Landroid/view/View;
    :goto_2
    iget v3, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    if-gt p2, v3, :cond_1

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationOverlayItem;->canPushSnapHeader()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 733
    iget v3, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    const/4 v4, -0x1

    if-ne v3, v4, :cond_6

    .line 734
    iput p1, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    .line 740
    :cond_1
    :goto_3
    return-void

    .line 703
    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    .line 711
    .restart local v2    # "overlayView":Landroid/view/View;
    :cond_3
    const-string v3, "move overlay %d"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 712
    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationOverlayItem;->isMeasurementValid()Z

    move-result v3

    if-nez v3, :cond_0

    .line 713
    invoke-direct {p0, v2}, Lcom/android/mail/browse/ConversationContainer;->measureOverlayView(Landroid/view/View;)V

    .line 714
    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationOverlayItem;->markMeasurementValid()V

    .line 715
    const-string v3, "and (re)measure overlay %d, old/new heights=%d/%d"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {v2}, Landroid/view/View;->getHeight()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {v2}, Landroid/view/View;->getMeasuredHeight()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_1

    .line 724
    .end local v2    # "overlayView":Landroid/view/View;
    :cond_4
    if-eqz v1, :cond_5

    .line 725
    const-string v3, "hide overlay %d"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 726
    invoke-direct {p0, p1, v1, p2, p3}, Lcom/android/mail/browse/ConversationContainer;->onOverlayScrolledOff(ILcom/android/mail/browse/ConversationContainer$OverlayView;II)V

    goto :goto_2

    .line 728
    :cond_5
    const-string v3, "ignore non-visible overlay %d"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-direct {p0, v3, v4}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 735
    :cond_6
    iget v3, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    if-le p1, v3, :cond_1

    .line 736
    iput p1, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    goto :goto_3
.end method

.method private positionOverlays(II)V
    .locals 18
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 400
    move/from16 v0, p2

    move-object/from16 v1, p0

    iput v0, v1, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    .line 409
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/android/mail/browse/ConversationContainer;->mTouchInitialized:Z

    if-eqz v14, :cond_2

    .line 410
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v14}, Lcom/android/mail/browse/ConversationWebView;->getScale()F

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Lcom/android/mail/browse/ConversationContainer;->mScale:F

    .line 414
    :cond_0
    :goto_0
    const-string v14, "in positionOverlays, raw scale=%f, effective scale=%f"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/android/mail/browse/ConversationWebView;->getScale()F

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    move-object/from16 v0, p0

    iget v0, v0, Lcom/android/mail/browse/ConversationContainer;->mScale:F

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v17

    aput-object v17, v15, v16

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v15}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 417
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    if-eqz v14, :cond_1

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    if-nez v14, :cond_3

    .line 493
    :cond_1
    :goto_1
    return-void

    .line 411
    :cond_2
    move-object/from16 v0, p0

    iget v14, v0, Lcom/android/mail/browse/ConversationContainer;->mScale:F

    const/4 v15, 0x0

    cmpl-float v14, v14, v15

    if-nez v14, :cond_0

    .line 412
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v14}, Lcom/android/mail/browse/ConversationWebView;->getInitialScale()F

    move-result v14

    move-object/from16 v0, p0

    iput v14, v0, Lcom/android/mail/browse/ConversationContainer;->mScale:F

    goto :goto_0

    .line 429
    :cond_3
    const-string v14, "IN positionOverlays, spacerCount=%d overlayCount=%d"

    const/4 v15, 0x2

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    array-length v0, v0

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/android/mail/browse/ConversationViewAdapter;->getCount()I

    move-result v17

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v15}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 432
    const/4 v14, -0x1

    move-object/from16 v0, p0

    iput v14, v0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    .line 434
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v14}, Lcom/android/mail/browse/ConversationViewAdapter;->getCount()I

    move-result v14

    add-int/lit8 v4, v14, -0x1

    .line 435
    .local v4, "adapterLoopIndex":I
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    array-length v14, v14

    add-int/lit8 v12, v14, -0x1

    .line 436
    .local v12, "spacerIndex":I
    :goto_2
    if-ltz v12, :cond_b

    if-ltz v4, :cond_b

    .line 438
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/android/mail/browse/ConversationContainer;->getOverlayTop(I)I

    move-result v13

    .line 439
    .local v13, "spacerTop":I
    move-object/from16 v0, p0

    invoke-direct {v0, v12}, Lcom/android/mail/browse/ConversationContainer;->getOverlayBottom(I)I

    move-result v11

    .line 446
    .local v11, "spacerBottom":I
    if-nez v12, :cond_5

    .line 447
    const/4 v5, 0x1

    .line 448
    .local v5, "flip":Z
    move v6, v4

    .line 449
    .local v6, "flipOffset":I
    const/16 v7, 0x30

    .line 456
    .local v7, "forceGravity":I
    :goto_3
    if-eqz v5, :cond_6

    sub-int v2, v6, v4

    .line 459
    .local v2, "adapterIndex":I
    :goto_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v14, v2}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v3

    .line 461
    .local v3, "adapterItem":Lcom/android/mail/browse/ConversationOverlayItem;
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v13, v11, v7}, Lcom/android/mail/browse/ConversationContainer;->calculatePosition(Lcom/android/mail/browse/ConversationOverlayItem;III)Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    move-result-object v8

    .line 464
    .local v8, "itemPos":Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    const-string v14, "in loop, spacer=%d overlay=%d t/b=%d/%d (%s)"

    const/4 v15, 0x5

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x2

    iget v0, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x3

    iget v0, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x4

    aput-object v3, v15, v16

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v15}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 466
    iget v14, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    iget v15, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v14, v15}, Lcom/android/mail/browse/ConversationContainer;->positionOverlay(III)V

    .line 470
    :goto_5
    add-int/lit8 v4, v4, -0x1

    if-ltz v4, :cond_4

    .line 471
    if-eqz v5, :cond_7

    sub-int v2, v6, v4

    .line 472
    :goto_6
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v14, v2}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v3

    .line 473
    if-lez v12, :cond_8

    invoke-virtual {v3}, Lcom/android/mail/browse/ConversationOverlayItem;->isContiguous()Z

    move-result v14

    if-nez v14, :cond_8

    .line 489
    :cond_4
    add-int/lit8 v12, v12, -0x1

    .line 490
    goto/16 :goto_2

    .line 451
    .end local v2    # "adapterIndex":I
    .end local v3    # "adapterItem":Lcom/android/mail/browse/ConversationOverlayItem;
    .end local v5    # "flip":Z
    .end local v6    # "flipOffset":I
    .end local v7    # "forceGravity":I
    .end local v8    # "itemPos":Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    :cond_5
    const/4 v5, 0x0

    .line 452
    .restart local v5    # "flip":Z
    const/4 v6, 0x0

    .line 453
    .restart local v6    # "flipOffset":I
    const/4 v7, 0x0

    .restart local v7    # "forceGravity":I
    goto :goto_3

    :cond_6
    move v2, v4

    .line 456
    goto :goto_4

    .restart local v2    # "adapterIndex":I
    .restart local v3    # "adapterItem":Lcom/android/mail/browse/ConversationOverlayItem;
    .restart local v8    # "itemPos":Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    :cond_7
    move v2, v4

    .line 471
    goto :goto_6

    .line 480
    :cond_8
    if-eqz v5, :cond_9

    iget v10, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    .line 481
    .local v10, "regionTop":I
    :goto_7
    if-eqz v5, :cond_a

    move v9, v11

    .line 482
    .local v9, "regionBottom":I
    :goto_8
    move-object/from16 v0, p0

    invoke-direct {v0, v3, v10, v9, v7}, Lcom/android/mail/browse/ConversationContainer;->calculatePosition(Lcom/android/mail/browse/ConversationOverlayItem;III)Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    move-result-object v8

    .line 484
    const-string v14, "in contig loop, spacer=%d overlay=%d t/b=%d/%d (%s)"

    const/4 v15, 0x5

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v12}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x1

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x2

    iget v0, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x3

    iget v0, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    move/from16 v17, v0

    invoke-static/range {v17 .. v17}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    const/16 v16, 0x4

    aput-object v3, v15, v16

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v15}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 486
    iget v14, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    iget v15, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    move-object/from16 v0, p0

    invoke-direct {v0, v2, v14, v15}, Lcom/android/mail/browse/ConversationContainer;->positionOverlay(III)V

    goto :goto_5

    .end local v9    # "regionBottom":I
    .end local v10    # "regionTop":I
    :cond_9
    move v10, v13

    .line 480
    goto :goto_7

    .line 481
    .restart local v10    # "regionTop":I
    :cond_a
    iget v9, v8, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    goto :goto_8

    .line 492
    .end local v2    # "adapterIndex":I
    .end local v3    # "adapterItem":Lcom/android/mail/browse/ConversationOverlayItem;
    .end local v5    # "flip":Z
    .end local v6    # "flipOffset":I
    .end local v7    # "forceGravity":I
    .end local v8    # "itemPos":Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    .end local v10    # "regionTop":I
    .end local v11    # "spacerBottom":I
    .end local v13    # "spacerTop":I
    :cond_b
    move-object/from16 v0, p0

    iget v14, v0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/android/mail/browse/ConversationContainer;->positionSnapHeader(I)V

    goto/16 :goto_1
.end method

.method private positionSnapHeader(I)V
    .locals 8
    .param p1, "snapIndex"    # I

    .prologue
    const/4 v7, 0x0

    .line 777
    const/4 v3, 0x0

    .line 778
    .local v3, "snapItem":Lcom/android/mail/browse/ConversationOverlayItem;
    const/4 v5, -0x1

    if-eq p1, v5, :cond_0

    .line 779
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v5, p1}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v0

    .line 780
    .local v0, "item":Lcom/android/mail/browse/ConversationOverlayItem;
    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationOverlayItem;->canBecomeSnapHeader()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 781
    move-object v3, v0

    .line 784
    .end local v0    # "item":Lcom/android/mail/browse/ConversationOverlayItem;
    :cond_0
    if-nez v3, :cond_1

    .line 785
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    const/16 v6, 0x8

    invoke-virtual {v5, v6}, Lcom/android/mail/browse/MessageHeaderView;->setVisibility(I)V

    .line 786
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v5}, Lcom/android/mail/browse/MessageHeaderView;->unbind()V

    .line 810
    :goto_0
    return-void

    .line 790
    :cond_1
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v3, v5, v7}, Lcom/android/mail/browse/ConversationOverlayItem;->bindView(Landroid/view/View;Z)V

    .line 791
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v5, v7}, Lcom/android/mail/browse/MessageHeaderView;->setVisibility(I)V

    .line 794
    const/4 v2, 0x0

    .line 796
    .local v2, "overlap":I
    add-int/lit8 v5, p1, 0x1

    invoke-direct {p0, v5}, Lcom/android/mail/browse/ConversationContainer;->findNextPushingOverlay(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v1

    .line 797
    .local v1, "next":Lcom/android/mail/browse/ConversationOverlayItem;
    if-eqz v1, :cond_2

    .line 798
    invoke-virtual {v1}, Lcom/android/mail/browse/ConversationOverlayItem;->getTop()I

    move-result v5

    iget-object v6, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v6}, Lcom/android/mail/browse/MessageHeaderView;->getHeight()I

    move-result v6

    sub-int/2addr v5, v6

    iget v6, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    sub-int/2addr v5, v6

    invoke-static {v7, v5}, Ljava/lang/Math;->min(II)I

    move-result v2

    .line 801
    if-gez v2, :cond_2

    .line 802
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mVelocityTracker:Lcom/android/mail/utils/InputSmoother;

    invoke-virtual {v5}, Lcom/android/mail/utils/InputSmoother;->getSmoothedVelocity()Ljava/lang/Float;

    move-result-object v4

    .line 803
    .local v4, "v":Ljava/lang/Float;
    if-eqz v4, :cond_2

    invoke-virtual {v4}, Ljava/lang/Float;->floatValue()F

    move-result v5

    const/high16 v6, 0x44160000    # 600.0f

    cmpl-float v5, v5, v6

    if-lez v5, :cond_2

    .line 804
    const/4 v2, 0x0

    .line 809
    .end local v4    # "v":Ljava/lang/Float;
    :cond_2
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    int-to-float v6, v2

    invoke-virtual {v5, v6}, Lcom/android/mail/browse/MessageHeaderView;->setTranslationY(F)V

    goto :goto_0
.end method

.method private varargs traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V
    .locals 1
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "params"    # [Ljava/lang/Object;

    .prologue
    .line 849
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationContainer;->mDisableLayoutTracing:Z

    if-eqz v0, :cond_0

    .line 853
    :goto_0
    return-void

    .line 852
    :cond_0
    const-string v0, "ConvLayout"

    invoke-static {v0, p1, p2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method private webPxToScreenPx(I)I
    .locals 2
    .param p1, "webPx"    # I

    .prologue
    .line 690
    int-to-float v0, p1

    iget v1, p0, Lcom/android/mail/browse/ConversationContainer;->mScale:F

    mul-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method


# virtual methods
.method public addScrapView(ILandroid/view/View;)V
    .locals 2
    .param p1, "type"    # I
    .param p2, "v"    # Landroid/view/View;

    .prologue
    .line 580
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mScrapViews:Lcom/android/mail/utils/DequeMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1, p2}, Lcom/android/mail/utils/DequeMap;->add(Ljava/lang/Object;Ljava/lang/Object;)V

    .line 581
    return-void
.end method

.method protected checkLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Z
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 676
    instance-of v0, p1, Landroid/view/ViewGroup$MarginLayoutParams;

    return v0
.end method

.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 651
    invoke-super {p0, p1}, Landroid/view/ViewGroup;->dispatchDraw(Landroid/graphics/Canvas;)V

    .line 653
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationContainer;->mAttachedOverlaySinceLastDraw:Z

    if-eqz v0, :cond_0

    .line 654
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mTopMostOverlay:Landroid/view/View;

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->getDrawingTime()J

    move-result-wide v1

    invoke-virtual {p0, p1, v0, v1, v2}, Lcom/android/mail/browse/ConversationContainer;->drawChild(Landroid/graphics/Canvas;Landroid/view/View;J)Z

    .line 655
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationContainer;->mAttachedOverlaySinceLastDraw:Z

    .line 657
    :cond_0
    return-void
.end method

.method protected generateDefaultLayoutParams()Landroid/view/ViewGroup$LayoutParams;
    .locals 3

    .prologue
    .line 661
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;

    const/4 v1, -0x1

    const/4 v2, -0x2

    invoke-direct {v0, v1, v2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    return-object v0
.end method

.method public generateLayoutParams(Landroid/util/AttributeSet;)Landroid/view/ViewGroup$LayoutParams;
    .locals 2
    .param p1, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 666
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationContainer;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    return-object v0
.end method

.method protected generateLayoutParams(Landroid/view/ViewGroup$LayoutParams;)Landroid/view/ViewGroup$LayoutParams;
    .locals 1
    .param p1, "p"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 671
    new-instance v0, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    return-object v0
.end method

.method public getScrapView(I)Landroid/view/View;
    .locals 2
    .param p1, "type"    # I

    .prologue
    .line 576
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mScrapViews:Lcom/android/mail/utils/DequeMap;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/android/mail/utils/DequeMap;->peek(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/View;

    return-object v0
.end method

.method public getSnapHeader()Lcom/android/mail/browse/MessageHeaderView;
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    return-object v0
.end method

.method public invalidateSpacerGeometry()V
    .locals 1

    .prologue
    .line 835
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    .line 836
    return-void
.end method

.method public measureOverlay(Landroid/view/View;)I
    .locals 1
    .param p1, "overlayView"    # Landroid/view/View;

    .prologue
    .line 525
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationContainer;->measureOverlayView(Landroid/view/View;)V

    .line 526
    invoke-virtual {p1}, Landroid/view/View;->getMeasuredHeight()I

    move-result v0

    return v0
.end method

.method protected onFinishInflate()V
    .locals 6

    .prologue
    .line 238
    invoke-super {p0}, Landroid/view/ViewGroup;->onFinishInflate()V

    .line 240
    const v4, 0x7f1000ad

    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/android/mail/browse/ConversationWebView;

    iput-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    .line 241
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v4, p0}, Lcom/android/mail/browse/ConversationWebView;->addScrollListener(Lcom/android/mail/browse/ScrollNotifier$ScrollListener;)V

    .line 243
    const v4, 0x7f1000ae

    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v4

    iput-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mTopMostOverlay:Landroid/view/View;

    .line 245
    const v4, 0x7f1000af

    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/android/mail/browse/MessageHeaderView;

    iput-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    .line 246
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    const/4 v5, 0x1

    invoke-virtual {v4, v5}, Lcom/android/mail/browse/MessageHeaderView;->setSnappy(Z)V

    .line 248
    sget-object v0, Lcom/android/mail/browse/ConversationContainer;->BOTTOM_LAYER_VIEW_IDS:[I

    .local v0, "arr$":[I
    array-length v3, v0

    .local v3, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v3, :cond_0

    aget v2, v0, v1

    .line 249
    .local v2, "id":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mNonScrollingChildren:Ljava/util/List;

    invoke-virtual {p0, v2}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 248
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 251
    .end local v2    # "id":I
    :cond_0
    sget-object v0, Lcom/android/mail/browse/ConversationContainer;->TOP_LAYER_VIEW_IDS:[I

    array-length v3, v0

    const/4 v1, 0x0

    :goto_1
    if-ge v1, v3, :cond_1

    aget v2, v0, v1

    .line 252
    .restart local v2    # "id":I
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mNonScrollingChildren:Ljava/util/List;

    invoke-virtual {p0, v2}, Lcom/android/mail/browse/ConversationContainer;->findViewById(I)Landroid/view/View;

    move-result-object v5

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 251
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 254
    .end local v2    # "id":I
    :cond_1
    return-void
.end method

.method public onGeometryChange([Lcom/android/mail/browse/ConversationContainer$OverlayPosition;)V
    .locals 9
    .param p1, "overlayPositions"    # [Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    .prologue
    const/4 v8, 0x0

    .line 839
    const-string v4, "*** got overlay spacer positions:"

    new-array v5, v8, [Ljava/lang/Object;

    invoke-direct {p0, v4, v5}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 840
    move-object v0, p1

    .local v0, "arr$":[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 841
    .local v3, "pos":Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    const-string v4, "top=%d bottom=%d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    iget v6, v3, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->top:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v8

    const/4 v6, 0x1

    iget v7, v3, Lcom/android/mail/browse/ConversationContainer$OverlayPosition;->bottom:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-direct {p0, v4, v5}, Lcom/android/mail/browse/ConversationContainer;->traceLayout(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 840
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 844
    .end local v3    # "pos":Lcom/android/mail/browse/ConversationContainer$OverlayPosition;
    :cond_0
    iput-object p1, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayPositions:[Lcom/android/mail/browse/ConversationContainer$OverlayPosition;

    .line 845
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    invoke-direct {p0, v8, v4}, Lcom/android/mail/browse/ConversationContainer;->positionOverlays(II)V

    .line 846
    return-void
.end method

.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 8
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v7, 0x1

    const/4 v4, 0x0

    .line 327
    iget-boolean v5, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchInitialized:Z

    if-nez v5, :cond_0

    .line 328
    iput-boolean v7, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchInitialized:Z

    .line 332
    :cond_0
    iget-object v5, p0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v5}, Lcom/android/mail/browse/ConversationWebView;->isHandlingTouch()Z

    move-result v5

    if-eqz v5, :cond_2

    move v0, v4

    .line 363
    :cond_1
    :goto_0
    return v0

    .line 336
    :cond_2
    const/4 v0, 0x0

    .line 337
    .local v0, "intercept":Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v5

    packed-switch v5, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 346
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v5

    iput v5, p0, Lcom/android/mail/browse/ConversationContainer;->mLastMotionY:F

    .line 347
    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->getPointerId(I)I

    move-result v4

    iput v4, p0, Lcom/android/mail/browse/ConversationContainer;->mActivePointerId:I

    goto :goto_0

    .line 339
    :pswitch_2
    const-string v5, "ConvLayout"

    const-string v6, "Container is intercepting non-primary touch!"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v5, v6, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 340
    const/4 v0, 0x1

    .line 341
    iput-boolean v7, p0, Lcom/android/mail/browse/ConversationContainer;->mMissedPointerDown:Z

    .line 342
    invoke-virtual {p0, v7}, Lcom/android/mail/browse/ConversationContainer;->requestDisallowInterceptTouchEvent(Z)V

    goto :goto_0

    .line 351
    :pswitch_3
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mActivePointerId:I

    invoke-virtual {p1, v4}, Landroid/view/MotionEvent;->findPointerIndex(I)I

    move-result v1

    .line 352
    .local v1, "pointerIndex":I
    invoke-virtual {p1, v1}, Landroid/view/MotionEvent;->getY(I)F

    move-result v2

    .line 353
    .local v2, "y":F
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mLastMotionY:F

    sub-float v4, v2, v4

    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v4

    float-to-int v3, v4

    .line 354
    .local v3, "yDiff":I
    iget v4, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchSlop:I

    if-le v3, v4, :cond_1

    .line 355
    iput v2, p0, Lcom/android/mail/browse/ConversationContainer;->mLastMotionY:F

    .line 356
    const/4 v0, 0x1

    goto :goto_0

    .line 337
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method protected onLayout(ZIIII)V
    .locals 12
    .param p1, "changed"    # Z
    .param p2, "l"    # I
    .param p3, "t"    # I
    .param p4, "r"    # I
    .param p5, "b"    # I

    .prologue
    .line 616
    const-string v9, "ConvLayout"

    const-string v10, "*** IN header container onLayout"

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-static {v9, v10, v11}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 618
    iget-object v9, p0, Lcom/android/mail/browse/ConversationContainer;->mNonScrollingChildren:Ljava/util/List;

    invoke-interface {v9}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/View;

    .line 619
    .local v7, "nonScrollingChild":Landroid/view/View;
    invoke-virtual {v7}, Landroid/view/View;->getVisibility()I

    move-result v9

    const/16 v10, 0x8

    if-eq v9, v10, :cond_0

    .line 620
    invoke-virtual {v7}, Landroid/view/View;->getMeasuredWidth()I

    move-result v8

    .line 621
    .local v8, "w":I
    invoke-virtual {v7}, Landroid/view/View;->getMeasuredHeight()I

    move-result v2

    .line 623
    .local v2, "h":I
    invoke-virtual {v7}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    check-cast v6, Landroid/view/ViewGroup$MarginLayoutParams;

    .line 626
    .local v6, "lp":Landroid/view/ViewGroup$MarginLayoutParams;
    iget v0, v6, Landroid/view/ViewGroup$MarginLayoutParams;->leftMargin:I

    .line 627
    .local v0, "childLeft":I
    iget v1, v6, Landroid/view/ViewGroup$MarginLayoutParams;->topMargin:I

    .line 628
    .local v1, "childTop":I
    add-int v9, v0, v8

    add-int v10, v1, v2

    invoke-virtual {v7, v0, v1, v9, v10}, Landroid/view/View;->layout(IIII)V

    goto :goto_0

    .line 632
    .end local v0    # "childLeft":I
    .end local v1    # "childTop":I
    .end local v2    # "h":I
    .end local v6    # "lp":Landroid/view/ViewGroup$MarginLayoutParams;
    .end local v7    # "nonScrollingChild":Landroid/view/View;
    .end local v8    # "w":I
    :cond_1
    iget-object v9, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    if-eqz v9, :cond_2

    .line 635
    const/4 v3, 0x0

    .local v3, "i":I
    iget-object v9, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v9}, Lcom/android/mail/browse/ConversationViewAdapter;->getCount()I

    move-result v5

    .local v5, "len":I
    :goto_1
    if-ge v3, v5, :cond_2

    .line 636
    iget-object v9, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v9, v3}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v9

    invoke-virtual {v9}, Lcom/android/mail/browse/ConversationOverlayItem;->invalidateMeasurement()V

    .line 635
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 640
    .end local v3    # "i":I
    .end local v5    # "len":I
    :cond_2
    const/4 v9, 0x0

    iget v10, p0, Lcom/android/mail/browse/ConversationContainer;->mOffsetY:I

    invoke-direct {p0, v9, v10}, Lcom/android/mail/browse/ConversationContainer;->positionOverlays(II)V

    .line 641
    return-void
.end method

.method protected onMeasure(II)V
    .locals 8
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    const/4 v3, 0x0

    .line 595
    invoke-super {p0, p1, p2}, Landroid/view/ViewGroup;->onMeasure(II)V

    .line 596
    const-string v0, "ConvLayout"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 597
    const-string v0, "ConvLayout"

    const-string v2, "*** IN header container onMeasure spec for w/h=%s/%s"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {p1}, Landroid/view/View$MeasureSpec;->toString(I)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v3

    const/4 v5, 0x1

    invoke-static {p2}, Landroid/view/View$MeasureSpec;->toString(I)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v4, v5

    invoke-static {v0, v2, v4}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 602
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mNonScrollingChildren:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/View;

    .line 603
    .local v1, "nonScrollingChild":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v0

    const/16 v2, 0x8

    if-eq v0, v2, :cond_1

    move-object v0, p0

    move v2, p1

    move v4, p2

    move v5, v3

    .line 604
    invoke-virtual/range {v0 .. v5}, Lcom/android/mail/browse/ConversationContainer;->measureChildWithMargins(Landroid/view/View;IIII)V

    goto :goto_0

    .line 608
    .end local v1    # "nonScrollingChild":Landroid/view/View;
    :cond_2
    iput p1, p0, Lcom/android/mail/browse/ConversationContainer;->mWidthMeasureSpec:I

    .line 612
    return-void
.end method

.method public onNotifierScroll(II)V
    .locals 1
    .param p1, "x"    # I
    .param p2, "y"    # I

    .prologue
    .line 393
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mVelocityTracker:Lcom/android/mail/utils/InputSmoother;

    invoke-virtual {v0, p2}, Lcom/android/mail/utils/InputSmoother;->onInput(I)V

    .line 394
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationContainer;->mDisableLayoutTracing:Z

    .line 395
    invoke-direct {p0, p1, p2}, Lcom/android/mail/browse/ConversationContainer;->positionOverlays(II)V

    .line 396
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/mail/browse/ConversationContainer;->mDisableLayoutTracing:Z

    .line 397
    return-void
.end method

.method public onOverlayModelUpdate(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 280
    .local p1, "affectedAdapterPositions":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 281
    .local v0, "i":Ljava/lang/Integer;
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Lcom/android/mail/browse/ConversationViewAdapter;->getItem(I)Lcom/android/mail/browse/ConversationOverlayItem;

    move-result-object v2

    .line 282
    .local v2, "item":Lcom/android/mail/browse/ConversationOverlayItem;
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayViews:Landroid/util/SparseArray;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/util/SparseArray;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/mail/browse/ConversationContainer$OverlayView;

    .line 283
    .local v3, "overlay":Lcom/android/mail/browse/ConversationContainer$OverlayView;
    if-eqz v3, :cond_1

    iget-object v4, v3, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    if-eqz v4, :cond_1

    if-eqz v2, :cond_1

    .line 284
    iget-object v4, v3, Lcom/android/mail/browse/ConversationContainer$OverlayView;->view:Landroid/view/View;

    invoke-virtual {v2, v4}, Lcom/android/mail/browse/ConversationOverlayItem;->onModelUpdated(Landroid/view/View;)V

    .line 286
    :cond_1
    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v4

    iget v5, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapIndex:I

    if-ne v4, v5, :cond_0

    .line 287
    iget-object v4, p0, Lcom/android/mail/browse/ConversationContainer;->mSnapHeader:Lcom/android/mail/browse/MessageHeaderView;

    invoke-virtual {v4}, Lcom/android/mail/browse/MessageHeaderView;->refresh()V

    goto :goto_0

    .line 290
    .end local v0    # "i":Ljava/lang/Integer;
    .end local v2    # "item":Lcom/android/mail/browse/ConversationOverlayItem;
    .end local v3    # "overlay":Lcom/android/mail/browse/ConversationContainer$OverlayView;
    :cond_2
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v5, 0x5

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 368
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 370
    .local v0, "action":I
    if-eq v0, v4, :cond_0

    const/4 v2, 0x3

    if-ne v0, v2, :cond_2

    .line 371
    :cond_0
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchIsDown:Z

    .line 384
    :cond_1
    :goto_0
    iget-object v2, p0, Lcom/android/mail/browse/ConversationContainer;->mWebView:Lcom/android/mail/browse/ConversationWebView;

    invoke-virtual {v2, p1}, Lcom/android/mail/browse/ConversationWebView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    .line 388
    .local v1, "webViewResult":Z
    return v1

    .line 372
    .end local v1    # "webViewResult":Z
    :cond_2
    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchIsDown:Z

    if-nez v2, :cond_1

    const/4 v2, 0x2

    if-eq v0, v2, :cond_3

    if-ne v0, v5, :cond_1

    .line 375
    :cond_3
    invoke-direct {p0, p1, v3}, Lcom/android/mail/browse/ConversationContainer;->forwardFakeMotionEvent(Landroid/view/MotionEvent;I)V

    .line 376
    iget-boolean v2, p0, Lcom/android/mail/browse/ConversationContainer;->mMissedPointerDown:Z

    if-eqz v2, :cond_4

    .line 377
    invoke-direct {p0, p1, v5}, Lcom/android/mail/browse/ConversationContainer;->forwardFakeMotionEvent(Landroid/view/MotionEvent;I)V

    .line 378
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationContainer;->mMissedPointerDown:Z

    .line 381
    :cond_4
    iput-boolean v4, p0, Lcom/android/mail/browse/ConversationContainer;->mTouchIsDown:Z

    goto :goto_0
.end method

.method public requestLayout()V
    .locals 0

    .prologue
    .line 645
    invoke-static {p0}, Lcom/android/mail/utils/Utils;->checkRequestLayout(Landroid/view/View;)V

    .line 646
    invoke-super {p0}, Landroid/view/ViewGroup;->requestLayout()V

    .line 647
    return-void
.end method

.method public setOverlayAdapter(Lcom/android/mail/browse/ConversationViewAdapter;)V
    .locals 2
    .param p1, "a"    # Lcom/android/mail/browse/ConversationViewAdapter;

    .prologue
    .line 261
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationContainer;->mAdapterObserver:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationViewAdapter;->unregisterDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 263
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationContainer;->clearOverlays()V

    .line 265
    :cond_0
    iput-object p1, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    .line 266
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    if-eqz v0, :cond_1

    .line 267
    iget-object v0, p0, Lcom/android/mail/browse/ConversationContainer;->mOverlayAdapter:Lcom/android/mail/browse/ConversationViewAdapter;

    iget-object v1, p0, Lcom/android/mail/browse/ConversationContainer;->mAdapterObserver:Landroid/database/DataSetObserver;

    invoke-virtual {v0, v1}, Lcom/android/mail/browse/ConversationViewAdapter;->registerDataSetObserver(Landroid/database/DataSetObserver;)V

    .line 269
    :cond_1
    return-void
.end method
