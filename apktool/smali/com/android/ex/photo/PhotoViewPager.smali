.class public Lcom/android/ex/photo/PhotoViewPager;
.super Landroid/support/v4/view/ViewPager;
.source "PhotoViewPager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;,
        Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    }
.end annotation


# instance fields
.field private mActivatedX:F

.field private mActivatedY:F

.field private mActivePointerId:I

.field private mLastMotionX:F

.field private mListener:Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 66
    invoke-direct {p0, p1}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;)V

    .line 67
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewPager;->initialize()V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 71
    invoke-direct {p0, p1, p2}, Landroid/support/v4/view/ViewPager;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 72
    invoke-direct {p0}, Lcom/android/ex/photo/PhotoViewPager;->initialize()V

    .line 73
    return-void
.end method

.method private initialize()V
    .locals 2

    .prologue
    .line 78
    const/4 v0, 0x1

    new-instance v1, Lcom/android/ex/photo/PhotoViewPager$1;

    invoke-direct {v1, p0}, Lcom/android/ex/photo/PhotoViewPager$1;-><init>(Lcom/android/ex/photo/PhotoViewPager;)V

    invoke-virtual {p0, v0, v1}, Lcom/android/ex/photo/PhotoViewPager;->setPageTransformer(ZLandroid/support/v4/view/ViewPager$PageTransformer;)V

    .line 104
    return-void
.end method


# virtual methods
.method public onInterceptTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 12
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    .line 114
    iget-object v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mListener:Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;

    if-eqz v9, :cond_5

    iget-object v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mListener:Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;

    iget v10, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivatedX:F

    iget v11, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivatedY:F

    invoke-interface {v9, v10, v11}, Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;->onTouchIntercept(FF)Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    move-result-object v4

    .line 117
    .local v4, "intercept":Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    :goto_0
    sget-object v9, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->BOTH:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    if-eq v4, v9, :cond_0

    sget-object v9, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->LEFT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    if-ne v4, v9, :cond_6

    :cond_0
    const/4 v2, 0x1

    .line 119
    .local v2, "ignoreScrollLeft":Z
    :goto_1
    sget-object v9, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->BOTH:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    if-eq v4, v9, :cond_1

    sget-object v9, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->RIGHT:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    if-ne v4, v9, :cond_7

    :cond_1
    const/4 v3, 0x1

    .line 123
    .local v3, "ignoreScrollRight":Z
    :goto_2
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v9

    and-int/lit16 v0, v9, 0xff

    .line 125
    .local v0, "action":I
    const/4 v9, 0x3

    if-eq v0, v9, :cond_2

    const/4 v9, 0x1

    if-ne v0, v9, :cond_3

    .line 126
    :cond_2
    const/4 v9, -0x1

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivePointerId:I

    .line 129
    :cond_3
    sparse-switch v0, :sswitch_data_0

    .line 179
    :cond_4
    :goto_3
    invoke-super {p0, p1}, Landroid/support/v4/view/ViewPager;->onInterceptTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v9

    :goto_4
    return v9

    .line 114
    .end local v0    # "action":I
    .end local v2    # "ignoreScrollLeft":Z
    .end local v3    # "ignoreScrollRight":Z
    .end local v4    # "intercept":Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    :cond_5
    sget-object v4, Lcom/android/ex/photo/PhotoViewPager$InterceptType;->NONE:Lcom/android/ex/photo/PhotoViewPager$InterceptType;

    goto :goto_0

    .line 117
    .restart local v4    # "intercept":Lcom/android/ex/photo/PhotoViewPager$InterceptType;
    :cond_6
    const/4 v2, 0x0

    goto :goto_1

    .line 119
    .restart local v2    # "ignoreScrollLeft":Z
    :cond_7
    const/4 v3, 0x0

    goto :goto_2

    .line 131
    .restart local v0    # "action":I
    .restart local v3    # "ignoreScrollRight":Z
    :sswitch_0
    if-nez v2, :cond_8

    if-eqz v3, :cond_4

    .line 132
    :cond_8
    iget v1, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivePointerId:I

    .line 133
    .local v1, "activePointerId":I
    const/4 v9, -0x1

    if-eq v1, v9, :cond_4

    .line 138
    invoke-static {p1, v1}, Landroid/support/v4/view/MotionEventCompat;->findPointerIndex(Landroid/view/MotionEvent;I)I

    move-result v7

    .line 140
    .local v7, "pointerIndex":I
    invoke-static {p1, v7}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v8

    .line 142
    .local v8, "x":F
    if-eqz v2, :cond_9

    if-eqz v3, :cond_9

    .line 143
    iput v8, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    .line 144
    const/4 v9, 0x0

    goto :goto_4

    .line 145
    :cond_9
    if-eqz v2, :cond_a

    iget v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    cmpl-float v9, v8, v9

    if-lez v9, :cond_a

    .line 146
    iput v8, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    .line 147
    const/4 v9, 0x0

    goto :goto_4

    .line 148
    :cond_a
    if-eqz v3, :cond_4

    iget v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    cmpg-float v9, v8, v9

    if-gez v9, :cond_4

    .line 149
    iput v8, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    .line 150
    const/4 v9, 0x0

    goto :goto_4

    .line 157
    .end local v1    # "activePointerId":I
    .end local v7    # "pointerIndex":I
    .end local v8    # "x":F
    :sswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v9

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    .line 160
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v9

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivatedX:F

    .line 161
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v9

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivatedY:F

    .line 162
    const/4 v9, 0x0

    invoke-static {p1, v9}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v9

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivePointerId:I

    goto :goto_3

    .line 167
    :sswitch_2
    invoke-static {p1}, Landroid/support/v4/view/MotionEventCompat;->getActionIndex(Landroid/view/MotionEvent;)I

    move-result v7

    .line 168
    .restart local v7    # "pointerIndex":I
    invoke-static {p1, v7}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v6

    .line 169
    .local v6, "pointerId":I
    iget v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivePointerId:I

    if-ne v6, v9, :cond_4

    .line 171
    if-nez v7, :cond_b

    const/4 v5, 0x1

    .line 172
    .local v5, "newPointerIndex":I
    :goto_5
    invoke-static {p1, v5}, Landroid/support/v4/view/MotionEventCompat;->getX(Landroid/view/MotionEvent;I)F

    move-result v9

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mLastMotionX:F

    .line 173
    invoke-static {p1, v5}, Landroid/support/v4/view/MotionEventCompat;->getPointerId(Landroid/view/MotionEvent;I)I

    move-result v9

    iput v9, p0, Lcom/android/ex/photo/PhotoViewPager;->mActivePointerId:I

    goto :goto_3

    .line 171
    .end local v5    # "newPointerIndex":I
    :cond_b
    const/4 v5, 0x0

    goto :goto_5

    .line 129
    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_1
        0x2 -> :sswitch_0
        0x6 -> :sswitch_2
    .end sparse-switch
.end method

.method public setOnInterceptTouchListener(Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;)V
    .locals 0
    .param p1, "l"    # Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;

    .prologue
    .line 186
    iput-object p1, p0, Lcom/android/ex/photo/PhotoViewPager;->mListener:Lcom/android/ex/photo/PhotoViewPager$OnInterceptTouchListener;

    .line 187
    return-void
.end method
