.class public Lcom/android/ex/photo/views/PhotoView;
.super Landroid/view/View;
.source "PhotoView.java"

# interfaces
.implements Landroid/view/GestureDetector$OnDoubleTapListener;
.implements Landroid/view/GestureDetector$OnGestureListener;
.implements Landroid/view/ScaleGestureDetector$OnScaleGestureListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/ex/photo/views/PhotoView$RotateRunnable;,
        Lcom/android/ex/photo/views/PhotoView$SnapRunnable;,
        Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;,
        Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;
    }
.end annotation


# static fields
.field private static sCropDimPaint:Landroid/graphics/Paint;

.field private static sCropPaint:Landroid/graphics/Paint;

.field private static sCropSize:I

.field private static sInitialized:Z

.field private static sVideoImage:Landroid/graphics/Bitmap;

.field private static sVideoNotReadyImage:Landroid/graphics/Bitmap;


# instance fields
.field private mAllowCrop:Z

.field private mCropRect:Landroid/graphics/Rect;

.field private mCropSize:I

.field private mDoubleTapDebounce:Z

.field private mDoubleTapToZoomEnabled:Z

.field private mDrawMatrix:Landroid/graphics/Matrix;

.field private mDrawable:Landroid/graphics/drawable/BitmapDrawable;

.field private mExternalClickListener:Landroid/view/View$OnClickListener;

.field private mFixedHeight:I

.field private mFullScreen:Z

.field private mGestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

.field private mHaveLayout:Z

.field private mIsDoubleTouch:Z

.field private mMatrix:Landroid/graphics/Matrix;

.field private mMaxScale:F

.field private mMinScale:F

.field private mOriginalMatrix:Landroid/graphics/Matrix;

.field private mRotateRunnable:Lcom/android/ex/photo/views/PhotoView$RotateRunnable;

.field private mRotation:F

.field private mScaleGetureDetector:Landroid/view/ScaleGestureDetector;

.field private mScaleRunnable:Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

.field private mSnapRunnable:Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

.field private mTempDst:Landroid/graphics/RectF;

.field private mTempSrc:Landroid/graphics/RectF;

.field private mTransformsEnabled:Z

.field private mTranslateRect:Landroid/graphics/RectF;

.field private mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

.field private mValues:[F

.field private mVideoBlob:[B

.field private mVideoReady:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 160
    invoke-direct {p0, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 90
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    .line 92
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mOriginalMatrix:Landroid/graphics/Matrix;

    .line 95
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/ex/photo/views/PhotoView;->mFixedHeight:I

    .line 108
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    .line 123
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapToZoomEnabled:Z

    .line 151
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    .line 153
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTempDst:Landroid/graphics/RectF;

    .line 155
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    .line 157
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    .line 161
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->initialize()V

    .line 162
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 165
    invoke-direct {p0, p1, p2}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 90
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    .line 92
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mOriginalMatrix:Landroid/graphics/Matrix;

    .line 95
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/ex/photo/views/PhotoView;->mFixedHeight:I

    .line 108
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    .line 123
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapToZoomEnabled:Z

    .line 151
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    .line 153
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTempDst:Landroid/graphics/RectF;

    .line 155
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    .line 157
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    .line 166
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->initialize()V

    .line 167
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 170
    invoke-direct {p0, p1, p2, p3}, Landroid/view/View;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 90
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    .line 92
    new-instance v0, Landroid/graphics/Matrix;

    invoke-direct {v0}, Landroid/graphics/Matrix;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mOriginalMatrix:Landroid/graphics/Matrix;

    .line 95
    const/4 v0, -0x1

    iput v0, p0, Lcom/android/ex/photo/views/PhotoView;->mFixedHeight:I

    .line 108
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    .line 123
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapToZoomEnabled:Z

    .line 151
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    .line 153
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTempDst:Landroid/graphics/RectF;

    .line 155
    new-instance v0, Landroid/graphics/RectF;

    invoke-direct {v0}, Landroid/graphics/RectF;-><init>()V

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    .line 157
    const/16 v0, 0x9

    new-array v0, v0, [F

    iput-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    .line 171
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->initialize()V

    .line 172
    return-void
.end method

.method static synthetic access$100(Lcom/android/ex/photo/views/PhotoView;FFF)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/photo/views/PhotoView;
    .param p1, "x1"    # F
    .param p2, "x2"    # F
    .param p3, "x3"    # F

    .prologue
    .line 45
    invoke-direct {p0, p1, p2, p3}, Lcom/android/ex/photo/views/PhotoView;->scale(FFF)V

    return-void
.end method

.method static synthetic access$200(Lcom/android/ex/photo/views/PhotoView;FF)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/ex/photo/views/PhotoView;
    .param p1, "x1"    # F
    .param p2, "x2"    # F

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/android/ex/photo/views/PhotoView;->translate(FF)Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/android/ex/photo/views/PhotoView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/photo/views/PhotoView;

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->snap()V

    return-void
.end method

.method static synthetic access$400(Lcom/android/ex/photo/views/PhotoView;FZ)V
    .locals 0
    .param p0, "x0"    # Lcom/android/ex/photo/views/PhotoView;
    .param p1, "x1"    # F
    .param p2, "x2"    # Z

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/android/ex/photo/views/PhotoView;->rotate(FZ)V

    return-void
.end method

.method private configureBounds(Z)V
    .locals 7
    .param p1, "changed"    # Z

    .prologue
    const/4 v5, 0x0

    .line 649
    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v6, :cond_0

    iget-boolean v6, p0, Lcom/android/ex/photo/views/PhotoView;->mHaveLayout:Z

    if-nez v6, :cond_1

    .line 676
    :cond_0
    :goto_0
    return-void

    .line 652
    :cond_1
    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v6}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v1

    .line 653
    .local v1, "dwidth":I
    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v6}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v0

    .line 655
    .local v0, "dheight":I
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v4

    .line 656
    .local v4, "vwidth":I
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v3

    .line 658
    .local v3, "vheight":I
    if-ltz v1, :cond_2

    if-ne v4, v1, :cond_7

    :cond_2
    if-ltz v0, :cond_3

    if-ne v3, v0, :cond_7

    :cond_3
    const/4 v2, 0x1

    .line 662
    .local v2, "fits":Z
    :goto_1
    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v6, v5, v5, v1, v0}, Landroid/graphics/drawable/BitmapDrawable;->setBounds(IIII)V

    .line 665
    if-nez p1, :cond_4

    iget v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    const/4 v6, 0x0

    cmpl-float v5, v5, v6

    if-nez v5, :cond_5

    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v5, :cond_5

    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mHaveLayout:Z

    if-eqz v5, :cond_5

    .line 666
    :cond_4
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->generateMatrix()V

    .line 667
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->generateScale()V

    .line 670
    :cond_5
    if-nez v2, :cond_6

    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v5}, Landroid/graphics/Matrix;->isIdentity()Z

    move-result v5

    if-eqz v5, :cond_8

    .line 672
    :cond_6
    const/4 v5, 0x0

    iput-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    goto :goto_0

    .end local v2    # "fits":Z
    :cond_7
    move v2, v5

    .line 658
    goto :goto_1

    .line 674
    .restart local v2    # "fits":Z
    :cond_8
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iput-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    goto :goto_0
.end method

.method private generateMatrix()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 683
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v5}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v1

    .line 684
    .local v1, "dwidth":I
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v5}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v0

    .line 686
    .local v0, "dheight":I
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v5, :cond_2

    sget v4, Lcom/android/ex/photo/views/PhotoView;->sCropSize:I

    .line 687
    .local v4, "vwidth":I
    :goto_0
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v5, :cond_3

    sget v3, Lcom/android/ex/photo/views/PhotoView;->sCropSize:I

    .line 689
    .local v3, "vheight":I
    :goto_1
    if-ltz v1, :cond_0

    if-ne v4, v1, :cond_4

    :cond_0
    if-ltz v0, :cond_1

    if-ne v3, v0, :cond_4

    :cond_1
    const/4 v2, 0x1

    .line 692
    .local v2, "fits":Z
    :goto_2
    if-eqz v2, :cond_5

    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-nez v5, :cond_5

    .line 693
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v5}, Landroid/graphics/Matrix;->reset()V

    .line 709
    :goto_3
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mOriginalMatrix:Landroid/graphics/Matrix;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v5, v6}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 710
    return-void

    .line 686
    .end local v2    # "fits":Z
    .end local v3    # "vheight":I
    .end local v4    # "vwidth":I
    :cond_2
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v4

    goto :goto_0

    .line 687
    .restart local v4    # "vwidth":I
    :cond_3
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v3

    goto :goto_1

    .line 689
    .restart local v3    # "vheight":I
    :cond_4
    const/4 v2, 0x0

    goto :goto_2

    .line 696
    .restart local v2    # "fits":Z
    :cond_5
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    int-to-float v6, v1

    int-to-float v7, v0

    invoke-virtual {v5, v8, v8, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    .line 697
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v5, :cond_6

    .line 698
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTempDst:Landroid/graphics/RectF;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    invoke-virtual {v5, v6}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 703
    :goto_4
    if-ge v1, v4, :cond_7

    if-ge v0, v3, :cond_7

    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-nez v5, :cond_7

    .line 704
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    div-int/lit8 v6, v4, 0x2

    div-int/lit8 v7, v1, 0x2

    sub-int/2addr v6, v7

    int-to-float v6, v6

    div-int/lit8 v7, v3, 0x2

    div-int/lit8 v8, v0, 0x2

    sub-int/2addr v7, v8

    int-to-float v7, v7

    invoke-virtual {v5, v6, v7}, Landroid/graphics/Matrix;->setTranslate(FF)V

    goto :goto_3

    .line 700
    :cond_6
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTempDst:Landroid/graphics/RectF;

    int-to-float v6, v4

    int-to-float v7, v3

    invoke-virtual {v5, v8, v8, v6, v7}, Landroid/graphics/RectF;->set(FFFF)V

    goto :goto_4

    .line 706
    :cond_7
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    iget-object v7, p0, Lcom/android/ex/photo/views/PhotoView;->mTempDst:Landroid/graphics/RectF;

    sget-object v8, Landroid/graphics/Matrix$ScaleToFit;->CENTER:Landroid/graphics/Matrix$ScaleToFit;

    invoke-virtual {v5, v6, v7, v8}, Landroid/graphics/Matrix;->setRectToRect(Landroid/graphics/RectF;Landroid/graphics/RectF;Landroid/graphics/Matrix$ScaleToFit;)Z

    goto :goto_3
.end method

.method private generateScale()V
    .locals 6

    .prologue
    const/high16 v5, 0x41000000    # 8.0f

    .line 713
    iget-object v4, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v4}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v1

    .line 714
    .local v1, "dwidth":I
    iget-object v4, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v4}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v0

    .line 716
    .local v0, "dheight":I
    iget-boolean v4, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v4, :cond_0

    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->getCropSize()I

    move-result v3

    .line 717
    .local v3, "vwidth":I
    :goto_0
    iget-boolean v4, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v4, :cond_1

    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->getCropSize()I

    move-result v2

    .line 719
    .local v2, "vheight":I
    :goto_1
    if-ge v1, v3, :cond_2

    if-ge v0, v2, :cond_2

    iget-boolean v4, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-nez v4, :cond_2

    .line 720
    const/high16 v4, 0x3f800000    # 1.0f

    iput v4, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    .line 724
    :goto_2
    iget v4, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    mul-float/2addr v4, v5

    invoke-static {v4, v5}, Ljava/lang/Math;->max(FF)F

    move-result v4

    iput v4, p0, Lcom/android/ex/photo/views/PhotoView;->mMaxScale:F

    .line 725
    return-void

    .line 716
    .end local v2    # "vheight":I
    .end local v3    # "vwidth":I
    :cond_0
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v3

    goto :goto_0

    .line 717
    .restart local v3    # "vwidth":I
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v2

    goto :goto_1

    .line 722
    .restart local v2    # "vheight":I
    :cond_2
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->getScale()F

    move-result v4

    iput v4, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    goto :goto_2
.end method

.method private getCropSize()I
    .locals 1

    .prologue
    .line 731
    iget v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    if-lez v0, :cond_0

    iget v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/android/ex/photo/views/PhotoView;->sCropSize:I

    goto :goto_0
.end method

.method private getScale()F
    .locals 2

    .prologue
    .line 740
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->getValues([F)V

    .line 741
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    const/4 v1, 0x0

    aget v0, v0, v1

    return v0
.end method

.method private initialize()V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 915
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 917
    .local v0, "context":Landroid/content/Context;
    sget-boolean v2, Lcom/android/ex/photo/views/PhotoView;->sInitialized:Z

    if-nez v2, :cond_0

    .line 918
    sput-boolean v4, Lcom/android/ex/photo/views/PhotoView;->sInitialized:Z

    .line 920
    invoke-virtual {v0}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 922
    .local v1, "resources":Landroid/content/res/Resources;
    sget v2, Lcom/android/ex/photo/R$dimen;->photo_crop_width:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    sput v2, Lcom/android/ex/photo/views/PhotoView;->sCropSize:I

    .line 924
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    sput-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropDimPaint:Landroid/graphics/Paint;

    .line 925
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropDimPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 926
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropDimPaint:Landroid/graphics/Paint;

    sget v3, Lcom/android/ex/photo/R$color;->photo_crop_dim_color:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 927
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropDimPaint:Landroid/graphics/Paint;

    sget-object v3, Landroid/graphics/Paint$Style;->FILL:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 929
    new-instance v2, Landroid/graphics/Paint;

    invoke-direct {v2}, Landroid/graphics/Paint;-><init>()V

    sput-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropPaint:Landroid/graphics/Paint;

    .line 930
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropPaint:Landroid/graphics/Paint;

    invoke-virtual {v2, v4}, Landroid/graphics/Paint;->setAntiAlias(Z)V

    .line 931
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropPaint:Landroid/graphics/Paint;

    sget v3, Lcom/android/ex/photo/R$color;->photo_crop_highlight_color:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setColor(I)V

    .line 932
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropPaint:Landroid/graphics/Paint;

    sget-object v3, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 933
    sget-object v2, Lcom/android/ex/photo/views/PhotoView;->sCropPaint:Landroid/graphics/Paint;

    sget v3, Lcom/android/ex/photo/R$dimen;->photo_crop_stroke_width:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    invoke-virtual {v2, v3}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 936
    .end local v1    # "resources":Landroid/content/res/Resources;
    :cond_0
    new-instance v2, Landroid/support/v4/view/GestureDetectorCompat;

    const/4 v3, 0x0

    invoke-direct {v2, v0, p0, v3}, Landroid/support/v4/view/GestureDetectorCompat;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;Landroid/os/Handler;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mGestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

    .line 937
    new-instance v2, Landroid/view/ScaleGestureDetector;

    invoke-direct {v2, v0, p0}, Landroid/view/ScaleGestureDetector;-><init>(Landroid/content/Context;Landroid/view/ScaleGestureDetector$OnScaleGestureListener;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleGetureDetector:Landroid/view/ScaleGestureDetector;

    .line 938
    new-instance v2, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

    invoke-direct {v2, p0}, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;-><init>(Lcom/android/ex/photo/views/PhotoView;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleRunnable:Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

    .line 939
    new-instance v2, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    invoke-direct {v2, p0}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;-><init>(Lcom/android/ex/photo/views/PhotoView;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    .line 940
    new-instance v2, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

    invoke-direct {v2, p0}, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;-><init>(Lcom/android/ex/photo/views/PhotoView;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mSnapRunnable:Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

    .line 941
    new-instance v2, Lcom/android/ex/photo/views/PhotoView$RotateRunnable;

    invoke-direct {v2, p0}, Lcom/android/ex/photo/views/PhotoView$RotateRunnable;-><init>(Lcom/android/ex/photo/views/PhotoView;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mRotateRunnable:Lcom/android/ex/photo/views/PhotoView$RotateRunnable;

    .line 942
    return-void
.end method

.method private rotate(FZ)V
    .locals 3
    .param p1, "degrees"    # F
    .param p2, "animate"    # Z

    .prologue
    .line 902
    if-eqz p2, :cond_0

    .line 903
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mRotateRunnable:Lcom/android/ex/photo/views/PhotoView$RotateRunnable;

    invoke-virtual {v0, p1}, Lcom/android/ex/photo/views/PhotoView$RotateRunnable;->start(F)V

    .line 909
    :goto_0
    return-void

    .line 905
    :cond_0
    iget v0, p0, Lcom/android/ex/photo/views/PhotoView;->mRotation:F

    add-float/2addr v0, p1

    iput v0, p0, Lcom/android/ex/photo/views/PhotoView;->mRotation:F

    .line 906
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v2

    div-int/lit8 v2, v2, 0x2

    int-to-float v2, v2

    invoke-virtual {v0, p1, v1, v2}, Landroid/graphics/Matrix;->postRotate(FFF)Z

    .line 907
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    goto :goto_0
.end method

.method private scale(FFF)V
    .locals 6
    .param p1, "newScale"    # F
    .param p2, "centerX"    # F
    .param p3, "centerY"    # F

    .prologue
    .line 759
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget v3, p0, Lcom/android/ex/photo/views/PhotoView;->mRotation:F

    neg-float v3, v3

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/graphics/Matrix;->postRotate(FFF)Z

    .line 762
    iget v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    invoke-static {p1, v2}, Ljava/lang/Math;->max(FF)F

    move-result p1

    .line 763
    iget v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMaxScale:F

    invoke-static {p1, v2}, Ljava/lang/Math;->min(FF)F

    move-result p1

    .line 765
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->getScale()F

    move-result v0

    .line 766
    .local v0, "currentScale":F
    div-float v1, p1, v0

    .line 769
    .local v1, "factor":F
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v2, v1, v1, p2, p3}, Landroid/graphics/Matrix;->postScale(FFFF)Z

    .line 772
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->snap()V

    .line 775
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget v3, p0, Lcom/android/ex/photo/views/PhotoView;->mRotation:F

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v4

    div-int/lit8 v4, v4, 0x2

    int-to-float v4, v4

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v5

    div-int/lit8 v5, v5, 0x2

    int-to-float v5, v5

    invoke-virtual {v2, v3, v4, v5}, Landroid/graphics/Matrix;->postRotate(FFF)Z

    .line 777
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    .line 778
    return-void
.end method

.method private snap()V
    .locals 15

    .prologue
    const/high16 v14, 0x41a00000    # 20.0f

    const/high16 v13, 0x40000000    # 2.0f

    const/4 v10, 0x0

    .line 844
    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget-object v12, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    invoke-virtual {v11, v12}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 845
    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v12, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    invoke-virtual {v11, v12}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 848
    iget-boolean v11, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v11, :cond_1

    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->left:I

    int-to-float v3, v11

    .line 849
    .local v3, "maxLeft":F
    :goto_0
    iget-boolean v11, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v11, :cond_2

    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v11, v11, Landroid/graphics/Rect;->right:I

    int-to-float v4, v11

    .line 850
    .local v4, "maxRight":F
    :goto_1
    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v1, v11, Landroid/graphics/RectF;->left:F

    .line 851
    .local v1, "l":F
    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v6, v11, Landroid/graphics/RectF;->right:F

    .line 854
    .local v6, "r":F
    sub-float v11, v6, v1

    sub-float v12, v4, v3

    cmpg-float v11, v11, v12

    if-gez v11, :cond_3

    .line 856
    sub-float v11, v4, v3

    add-float v12, v6, v1

    sub-float/2addr v11, v12

    div-float/2addr v11, v13

    add-float v8, v3, v11

    .line 868
    .local v8, "translateX":F
    :goto_2
    iget-boolean v11, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v11, :cond_6

    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->top:I

    int-to-float v5, v10

    .line 869
    .local v5, "maxTop":F
    :goto_3
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_7

    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->bottom:I

    int-to-float v2, v10

    .line 870
    .local v2, "maxBottom":F
    :goto_4
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v7, v10, Landroid/graphics/RectF;->top:F

    .line 871
    .local v7, "t":F
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v0, v10, Landroid/graphics/RectF;->bottom:F

    .line 874
    .local v0, "b":F
    sub-float v10, v0, v7

    sub-float v11, v2, v5

    cmpg-float v10, v10, v11

    if-gez v10, :cond_8

    .line 876
    sub-float v10, v2, v5

    add-float v11, v0, v7

    sub-float/2addr v10, v11

    div-float/2addr v10, v13

    add-float v9, v5, v10

    .line 887
    .local v9, "translateY":F
    :goto_5
    invoke-static {v8}, Ljava/lang/Math;->abs(F)F

    move-result v10

    cmpl-float v10, v10, v14

    if-gtz v10, :cond_0

    invoke-static {v9}, Ljava/lang/Math;->abs(F)F

    move-result v10

    cmpl-float v10, v10, v14

    if-lez v10, :cond_b

    .line 888
    :cond_0
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mSnapRunnable:Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

    invoke-virtual {v10, v8, v9}, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->start(FF)Z

    .line 893
    :goto_6
    return-void

    .end local v0    # "b":F
    .end local v1    # "l":F
    .end local v2    # "maxBottom":F
    .end local v3    # "maxLeft":F
    .end local v4    # "maxRight":F
    .end local v5    # "maxTop":F
    .end local v6    # "r":F
    .end local v7    # "t":F
    .end local v8    # "translateX":F
    .end local v9    # "translateY":F
    :cond_1
    move v3, v10

    .line 848
    goto :goto_0

    .line 849
    .restart local v3    # "maxLeft":F
    :cond_2
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v11

    int-to-float v4, v11

    goto :goto_1

    .line 857
    .restart local v1    # "l":F
    .restart local v4    # "maxRight":F
    .restart local v6    # "r":F
    :cond_3
    cmpl-float v11, v1, v3

    if-lez v11, :cond_4

    .line 859
    sub-float v8, v3, v1

    .restart local v8    # "translateX":F
    goto :goto_2

    .line 860
    .end local v8    # "translateX":F
    :cond_4
    cmpg-float v11, v6, v4

    if-gez v11, :cond_5

    .line 862
    sub-float v8, v4, v6

    .restart local v8    # "translateX":F
    goto :goto_2

    .line 864
    .end local v8    # "translateX":F
    :cond_5
    const/4 v8, 0x0

    .restart local v8    # "translateX":F
    goto :goto_2

    :cond_6
    move v5, v10

    .line 868
    goto :goto_3

    .line 869
    .restart local v5    # "maxTop":F
    :cond_7
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v10

    int-to-float v2, v10

    goto :goto_4

    .line 877
    .restart local v0    # "b":F
    .restart local v2    # "maxBottom":F
    .restart local v7    # "t":F
    :cond_8
    cmpl-float v10, v7, v5

    if-lez v10, :cond_9

    .line 879
    sub-float v9, v5, v7

    .restart local v9    # "translateY":F
    goto :goto_5

    .line 880
    .end local v9    # "translateY":F
    :cond_9
    cmpg-float v10, v0, v2

    if-gez v10, :cond_a

    .line 882
    sub-float v9, v2, v0

    .restart local v9    # "translateY":F
    goto :goto_5

    .line 884
    .end local v9    # "translateY":F
    :cond_a
    const/4 v9, 0x0

    .restart local v9    # "translateY":F
    goto :goto_5

    .line 890
    :cond_b
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v10, v8, v9}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 891
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    goto :goto_6
.end method

.method private translate(FF)Z
    .locals 12
    .param p1, "tx"    # F
    .param p2, "ty"    # F

    .prologue
    .line 791
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    invoke-virtual {v10, v11}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 792
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    invoke-virtual {v10, v11}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 794
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_0

    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->left:I

    int-to-float v3, v10

    .line 795
    .local v3, "maxLeft":F
    :goto_0
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_1

    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->right:I

    int-to-float v4, v10

    .line 796
    .local v4, "maxRight":F
    :goto_1
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v1, v10, Landroid/graphics/RectF;->left:F

    .line 797
    .local v1, "l":F
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v6, v10, Landroid/graphics/RectF;->right:F

    .line 800
    .local v6, "r":F
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_2

    .line 802
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v10, v10, Landroid/graphics/RectF;->right:F

    sub-float v10, v3, v10

    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v11, v11, Landroid/graphics/RectF;->left:F

    sub-float v11, v4, v11

    invoke-static {v11, p1}, Ljava/lang/Math;->min(FF)F

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(FF)F

    move-result v8

    .line 813
    .local v8, "translateX":F
    :goto_2
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_4

    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->top:I

    int-to-float v5, v10

    .line 814
    .local v5, "maxTop":F
    :goto_3
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_5

    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    iget v10, v10, Landroid/graphics/Rect;->bottom:I

    int-to-float v2, v10

    .line 815
    .local v2, "maxBottom":F
    :goto_4
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v7, v10, Landroid/graphics/RectF;->top:F

    .line 816
    .local v7, "t":F
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v0, v10, Landroid/graphics/RectF;->bottom:F

    .line 820
    .local v0, "b":F
    iget-boolean v10, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v10, :cond_6

    .line 822
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v10, v10, Landroid/graphics/RectF;->bottom:F

    sub-float v10, v5, v10

    iget-object v11, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v11, v11, Landroid/graphics/RectF;->top:F

    sub-float v11, v2, v11

    invoke-static {v11, p2}, Ljava/lang/Math;->min(FF)F

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(FF)F

    move-result v9

    .line 834
    .local v9, "translateY":F
    :goto_5
    iget-object v10, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v10, v8, v9}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 835
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    .line 837
    cmpl-float v10, v8, p1

    if-nez v10, :cond_8

    cmpl-float v10, v9, p2

    if-nez v10, :cond_8

    const/4 v10, 0x1

    :goto_6
    return v10

    .line 794
    .end local v0    # "b":F
    .end local v1    # "l":F
    .end local v2    # "maxBottom":F
    .end local v3    # "maxLeft":F
    .end local v4    # "maxRight":F
    .end local v5    # "maxTop":F
    .end local v6    # "r":F
    .end local v7    # "t":F
    .end local v8    # "translateX":F
    .end local v9    # "translateY":F
    :cond_0
    const/4 v3, 0x0

    goto :goto_0

    .line 795
    .restart local v3    # "maxLeft":F
    :cond_1
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v10

    int-to-float v4, v10

    goto :goto_1

    .line 806
    .restart local v1    # "l":F
    .restart local v4    # "maxRight":F
    .restart local v6    # "r":F
    :cond_2
    sub-float v10, v6, v1

    sub-float v11, v4, v3

    cmpg-float v10, v10, v11

    if-gez v10, :cond_3

    .line 807
    sub-float v10, v4, v3

    add-float v11, v6, v1

    sub-float/2addr v10, v11

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    add-float v8, v3, v10

    .restart local v8    # "translateX":F
    goto :goto_2

    .line 809
    .end local v8    # "translateX":F
    :cond_3
    sub-float v10, v4, v6

    sub-float v11, v3, v1

    invoke-static {v11, p1}, Ljava/lang/Math;->min(FF)F

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(FF)F

    move-result v8

    .restart local v8    # "translateX":F
    goto :goto_2

    .line 813
    :cond_4
    const/4 v5, 0x0

    goto :goto_3

    .line 814
    .restart local v5    # "maxTop":F
    :cond_5
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v10

    int-to-float v2, v10

    goto :goto_4

    .line 826
    .restart local v0    # "b":F
    .restart local v2    # "maxBottom":F
    .restart local v7    # "t":F
    :cond_6
    sub-float v10, v0, v7

    sub-float v11, v2, v5

    cmpg-float v10, v10, v11

    if-gez v10, :cond_7

    .line 827
    sub-float v10, v2, v5

    add-float v11, v0, v7

    sub-float/2addr v10, v11

    const/high16 v11, 0x40000000    # 2.0f

    div-float/2addr v10, v11

    add-float v9, v5, v10

    .restart local v9    # "translateY":F
    goto :goto_5

    .line 829
    .end local v9    # "translateY":F
    :cond_7
    sub-float v10, v2, v0

    sub-float v11, v5, v7

    invoke-static {v11, p2}, Ljava/lang/Math;->min(FF)F

    move-result v11

    invoke-static {v10, v11}, Ljava/lang/Math;->max(FF)F

    move-result v9

    .restart local v9    # "translateY":F
    goto :goto_5

    .line 837
    :cond_8
    const/4 v10, 0x0

    goto :goto_6
.end method


# virtual methods
.method public bindPhoto(Landroid/graphics/Bitmap;)V
    .locals 4
    .param p1, "photoBitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 392
    const/4 v0, 0x0

    .line 393
    .local v0, "changed":Z
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v2, :cond_2

    .line 394
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v1

    .line 395
    .local v1, "drawableBitmap":Landroid/graphics/Bitmap;
    if-ne p1, v1, :cond_0

    .line 415
    .end local v1    # "drawableBitmap":Landroid/graphics/Bitmap;
    :goto_0
    return-void

    .line 400
    .restart local v1    # "drawableBitmap":Landroid/graphics/Bitmap;
    :cond_0
    if-eqz p1, :cond_4

    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicWidth()I

    move-result v2

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    if-ne v2, v3, :cond_1

    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getIntrinsicHeight()I

    move-result v2

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v3

    if-eq v2, v3, :cond_4

    :cond_1
    const/4 v0, 0x1

    .line 405
    :goto_1
    const/4 v2, 0x0

    iput v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    .line 406
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    .line 409
    .end local v1    # "drawableBitmap":Landroid/graphics/Bitmap;
    :cond_2
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    if-nez v2, :cond_3

    if-eqz p1, :cond_3

    .line 410
    new-instance v2, Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-direct {v2, v3, p1}, Landroid/graphics/drawable/BitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    iput-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    .line 413
    :cond_3
    invoke-direct {p0, v0}, Lcom/android/ex/photo/views/PhotoView;->configureBounds(Z)V

    .line 414
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    goto :goto_0

    .line 400
    .restart local v1    # "drawableBitmap":Landroid/graphics/Bitmap;
    :cond_4
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public clear()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 371
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mGestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

    .line 372
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleGetureDetector:Landroid/view/ScaleGestureDetector;

    .line 373
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    .line 374
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleRunnable:Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->stop()V

    .line 375
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleRunnable:Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

    .line 376
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->stop()V

    .line 377
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    .line 378
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mSnapRunnable:Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->stop()V

    .line 379
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mSnapRunnable:Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

    .line 380
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mRotateRunnable:Lcom/android/ex/photo/views/PhotoView$RotateRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$RotateRunnable;->stop()V

    .line 381
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mRotateRunnable:Lcom/android/ex/photo/views/PhotoView$RotateRunnable;

    .line 382
    invoke-virtual {p0, v1}, Lcom/android/ex/photo/views/PhotoView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 383
    iput-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mExternalClickListener:Landroid/view/View$OnClickListener;

    .line 384
    return-void
.end method

.method public enableImageTransforms(Z)V
    .locals 1
    .param p1, "enable"    # Z

    .prologue
    .line 639
    iput-boolean p1, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    .line 640
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-nez v0, :cond_0

    .line 641
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->resetTransformations()V

    .line 643
    :cond_0
    return-void
.end method

.method public interceptMoveLeft(FF)Z
    .locals 7
    .param p1, "origX"    # F
    .param p2, "origY"    # F

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 302
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-nez v5, :cond_1

    .line 328
    :cond_0
    :goto_0
    return v3

    .line 305
    :cond_1
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    # getter for: Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->mRunning:Z
    invoke-static {v5}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->access$000(Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;)Z

    move-result v5

    if-eqz v5, :cond_2

    move v3, v4

    .line 307
    goto :goto_0

    .line 309
    :cond_2
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    invoke-virtual {v5, v6}, Landroid/graphics/Matrix;->getValues([F)V

    .line 310
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    invoke-virtual {v5, v6}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 311
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    invoke-virtual {v5, v6}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 313
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v5

    int-to-float v2, v5

    .line 314
    .local v2, "viewWidth":F
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    const/4 v6, 0x2

    aget v1, v5, v6

    .line 315
    .local v1, "transX":F
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->right:F

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v6, v6, Landroid/graphics/RectF;->left:F

    sub-float v0, v5, v6

    .line 317
    .local v0, "drawWidth":F
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v5, :cond_0

    cmpg-float v5, v0, v2

    if-lez v5, :cond_0

    .line 320
    const/4 v5, 0x0

    cmpl-float v5, v1, v5

    if-eqz v5, :cond_0

    .line 323
    add-float v3, v0, v1

    cmpl-float v3, v2, v3

    if-ltz v3, :cond_3

    move v3, v4

    .line 325
    goto :goto_0

    :cond_3
    move v3, v4

    .line 328
    goto :goto_0
.end method

.method public interceptMoveRight(FF)Z
    .locals 7
    .param p1, "origX"    # F
    .param p2, "origY"    # F

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 335
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-nez v5, :cond_1

    .line 361
    :cond_0
    :goto_0
    return v3

    .line 338
    :cond_1
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    # getter for: Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->mRunning:Z
    invoke-static {v5}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->access$000(Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;)Z

    move-result v5

    if-eqz v5, :cond_2

    move v3, v4

    .line 340
    goto :goto_0

    .line 342
    :cond_2
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    invoke-virtual {v5, v6}, Landroid/graphics/Matrix;->getValues([F)V

    .line 343
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTempSrc:Landroid/graphics/RectF;

    invoke-virtual {v5, v6}, Landroid/graphics/RectF;->set(Landroid/graphics/RectF;)V

    .line 344
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    invoke-virtual {v5, v6}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 346
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v5

    int-to-float v2, v5

    .line 347
    .local v2, "viewWidth":F
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mValues:[F

    const/4 v6, 0x2

    aget v1, v5, v6

    .line 348
    .local v1, "transX":F
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v5, v5, Landroid/graphics/RectF;->right:F

    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget v6, v6, Landroid/graphics/RectF;->left:F

    sub-float v0, v5, v6

    .line 350
    .local v0, "drawWidth":F
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v5, :cond_0

    cmpg-float v5, v0, v2

    if-lez v5, :cond_0

    .line 353
    const/4 v5, 0x0

    cmpl-float v5, v1, v5

    if-nez v5, :cond_3

    move v3, v4

    .line 355
    goto :goto_0

    .line 356
    :cond_3
    add-float v5, v0, v1

    cmpl-float v5, v2, v5

    if-gez v5, :cond_0

    move v3, v4

    .line 361
    goto :goto_0
.end method

.method public isPhotoBound()Z
    .locals 1

    .prologue
    .line 452
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onDoubleTap(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 199
    iget-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapToZoomEnabled:Z

    if-eqz v2, :cond_1

    iget-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v2, :cond_1

    .line 200
    iget-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapDebounce:Z

    if-nez v2, :cond_0

    .line 201
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->getScale()F

    move-result v0

    .line 202
    .local v0, "currentScale":F
    const/high16 v2, 0x3fc00000    # 1.5f

    mul-float v1, v0, v2

    .line 205
    .local v1, "targetScale":F
    iget v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMinScale:F

    invoke-static {v2, v1}, Ljava/lang/Math;->max(FF)F

    move-result v1

    .line 206
    iget v2, p0, Lcom/android/ex/photo/views/PhotoView;->mMaxScale:F

    invoke-static {v2, v1}, Ljava/lang/Math;->min(FF)F

    move-result v1

    .line 208
    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleRunnable:Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    invoke-virtual {v2, v0, v1, v3, v4}, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->start(FFFF)Z

    .line 210
    .end local v0    # "currentScale":F
    .end local v1    # "targetScale":F
    :cond_0
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapDebounce:Z

    .line 212
    :cond_1
    const/4 v2, 0x1

    return v2
.end method

.method public onDoubleTapEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 217
    const/4 v0, 0x1

    return v0
.end method

.method public onDown(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 252
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v0, :cond_0

    .line 253
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->stop()V

    .line 254
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mSnapRunnable:Lcom/android/ex/photo/views/PhotoView$SnapRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->stop()V

    .line 256
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 11
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v1, 0x0

    .line 543
    invoke-super {p0, p1}, Landroid/view/View;->onDraw(Landroid/graphics/Canvas;)V

    .line 546
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v0, :cond_4

    .line 547
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getSaveCount()I

    move-result v9

    .line 548
    .local v9, "saveCount":I
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 550
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    if-eqz v0, :cond_0

    .line 551
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->concat(Landroid/graphics/Matrix;)V

    .line 553
    :cond_0
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 555
    invoke-virtual {p1, v9}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 557
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mVideoBlob:[B

    if-eqz v0, :cond_1

    .line 558
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mVideoReady:Z

    if-eqz v0, :cond_5

    sget-object v10, Lcom/android/ex/photo/views/PhotoView;->sVideoImage:Landroid/graphics/Bitmap;

    .line 559
    .local v10, "videoImage":Landroid/graphics/Bitmap;
    :goto_0
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v0

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    sub-int/2addr v0, v2

    div-int/lit8 v6, v0, 0x2

    .line 560
    .local v6, "drawLeft":I
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v0

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    sub-int/2addr v0, v2

    div-int/lit8 v7, v0, 0x2

    .line 561
    .local v7, "drawTop":I
    int-to-float v0, v6

    int-to-float v2, v7

    const/4 v3, 0x0

    invoke-virtual {p1, v10, v0, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 565
    .end local v6    # "drawLeft":I
    .end local v7    # "drawTop":I
    .end local v10    # "videoImage":Landroid/graphics/Bitmap;
    :cond_1
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v2}, Landroid/graphics/drawable/BitmapDrawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/graphics/RectF;->set(Landroid/graphics/Rect;)V

    .line 566
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    if-eqz v0, :cond_2

    .line 567
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRect:Landroid/graphics/RectF;

    invoke-virtual {v0, v2}, Landroid/graphics/Matrix;->mapRect(Landroid/graphics/RectF;)Z

    .line 570
    :cond_2
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v0, :cond_4

    .line 571
    invoke-virtual {p1}, Landroid/graphics/Canvas;->getSaveCount()I

    move-result v8

    .line 572
    .local v8, "previousSaveCount":I
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v0

    int-to-float v3, v0

    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v0

    int-to-float v4, v0

    sget-object v5, Lcom/android/ex/photo/views/PhotoView;->sCropDimPaint:Landroid/graphics/Paint;

    move-object v0, p1

    move v2, v1

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawRect(FFFFLandroid/graphics/Paint;)V

    .line 573
    invoke-virtual {p1}, Landroid/graphics/Canvas;->save()I

    .line 574
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->clipRect(Landroid/graphics/Rect;)Z

    .line 576
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    if-eqz v0, :cond_3

    .line 577
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawMatrix:Landroid/graphics/Matrix;

    invoke-virtual {p1, v0}, Landroid/graphics/Canvas;->concat(Landroid/graphics/Matrix;)V

    .line 580
    :cond_3
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDrawable:Landroid/graphics/drawable/BitmapDrawable;

    invoke-virtual {v0, p1}, Landroid/graphics/drawable/BitmapDrawable;->draw(Landroid/graphics/Canvas;)V

    .line 581
    invoke-virtual {p1, v8}, Landroid/graphics/Canvas;->restoreToCount(I)V

    .line 582
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    sget-object v1, Lcom/android/ex/photo/views/PhotoView;->sCropPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 585
    .end local v8    # "previousSaveCount":I
    .end local v9    # "saveCount":I
    :cond_4
    return-void

    .line 558
    .restart local v9    # "saveCount":I
    :cond_5
    sget-object v10, Lcom/android/ex/photo/views/PhotoView;->sVideoNotReadyImage:Landroid/graphics/Bitmap;

    goto :goto_0
.end method

.method public onFling(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 1
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "velocityX"    # F
    .param p4, "velocityY"    # F

    .prologue
    .line 261
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v0, :cond_0

    .line 262
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    invoke-virtual {v0, p3, p4}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->start(FF)Z

    .line 264
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method protected onLayout(ZIIII)V
    .locals 8
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    .line 589
    invoke-super/range {p0 .. p5}, Landroid/view/View;->onLayout(ZIIII)V

    .line 590
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/android/ex/photo/views/PhotoView;->mHaveLayout:Z

    .line 591
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getWidth()I

    move-result v5

    .line 592
    .local v5, "layoutWidth":I
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getHeight()I

    move-result v4

    .line 594
    .local v4, "layoutHeight":I
    iget-boolean v6, p0, Lcom/android/ex/photo/views/PhotoView;->mAllowCrop:Z

    if-eqz v6, :cond_0

    .line 595
    sget v6, Lcom/android/ex/photo/views/PhotoView;->sCropSize:I

    invoke-static {v5, v4}, Ljava/lang/Math;->min(II)I

    move-result v7

    invoke-static {v6, v7}, Ljava/lang/Math;->min(II)I

    move-result v6

    iput v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    .line 596
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    sub-int v6, v5, v6

    div-int/lit8 v1, v6, 0x2

    .line 597
    .local v1, "cropLeft":I
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    sub-int v6, v4, v6

    div-int/lit8 v3, v6, 0x2

    .line 598
    .local v3, "cropTop":I
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    add-int v2, v1, v6

    .line 599
    .local v2, "cropRight":I
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropSize:I

    add-int v0, v3, v6

    .line 603
    .local v0, "cropBottom":I
    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView;->mCropRect:Landroid/graphics/Rect;

    invoke-virtual {v6, v1, v3, v2, v0}, Landroid/graphics/Rect;->set(IIII)V

    .line 605
    .end local v0    # "cropBottom":I
    .end local v1    # "cropLeft":I
    .end local v2    # "cropRight":I
    .end local v3    # "cropTop":I
    :cond_0
    invoke-direct {p0, p1}, Lcom/android/ex/photo/views/PhotoView;->configureBounds(Z)V

    .line 606
    return-void
.end method

.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 0
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 236
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 610
    iget v0, p0, Lcom/android/ex/photo/views/PhotoView;->mFixedHeight:I

    const/4 v1, -0x1

    if-eq v0, v1, :cond_0

    .line 611
    iget v0, p0, Lcom/android/ex/photo/views/PhotoView;->mFixedHeight:I

    const/high16 v1, -0x80000000

    invoke-static {v0, v1}, Landroid/view/View$MeasureSpec;->makeMeasureSpec(II)I

    move-result v0

    invoke-super {p0, p1, v0}, Landroid/view/View;->onMeasure(II)V

    .line 613
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->getMeasuredWidth()I

    move-result v0

    iget v1, p0, Lcom/android/ex/photo/views/PhotoView;->mFixedHeight:I

    invoke-virtual {p0, v0, v1}, Lcom/android/ex/photo/views/PhotoView;->setMeasuredDimension(II)V

    .line 617
    :goto_0
    return-void

    .line 615
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/view/View;->onMeasure(II)V

    goto :goto_0
.end method

.method public onScale(Landroid/view/ScaleGestureDetector;)Z
    .locals 4
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 269
    iget-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v2, :cond_0

    .line 270
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView;->mIsDoubleTouch:Z

    .line 271
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->getScale()F

    move-result v0

    .line 272
    .local v0, "currentScale":F
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getScaleFactor()F

    move-result v2

    mul-float v1, v0, v2

    .line 273
    .local v1, "newScale":F
    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusX()F

    move-result v2

    invoke-virtual {p1}, Landroid/view/ScaleGestureDetector;->getFocusY()F

    move-result v3

    invoke-direct {p0, v1, v2, v3}, Lcom/android/ex/photo/views/PhotoView;->scale(FFF)V

    .line 275
    .end local v0    # "currentScale":F
    .end local v1    # "newScale":F
    :cond_0
    const/4 v2, 0x1

    return v2
.end method

.method public onScaleBegin(Landroid/view/ScaleGestureDetector;)Z
    .locals 2
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    const/4 v1, 0x1

    .line 280
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v0, :cond_0

    .line 281
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleRunnable:Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;

    invoke-virtual {v0}, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->stop()V

    .line 282
    iput-boolean v1, p0, Lcom/android/ex/photo/views/PhotoView;->mIsDoubleTouch:Z

    .line 284
    :cond_0
    return v1
.end method

.method public onScaleEnd(Landroid/view/ScaleGestureDetector;)V
    .locals 1
    .param p1, "detector"    # Landroid/view/ScaleGestureDetector;

    .prologue
    .line 289
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mIsDoubleTouch:Z

    if-eqz v0, :cond_0

    .line 290
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mDoubleTapDebounce:Z

    .line 291
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->resetTransformations()V

    .line 293
    :cond_0
    return-void
.end method

.method public onScroll(Landroid/view/MotionEvent;Landroid/view/MotionEvent;FF)Z
    .locals 2
    .param p1, "e1"    # Landroid/view/MotionEvent;
    .param p2, "e2"    # Landroid/view/MotionEvent;
    .param p3, "distanceX"    # F
    .param p4, "distanceY"    # F

    .prologue
    .line 244
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mTransformsEnabled:Z

    if-eqz v0, :cond_0

    .line 245
    neg-float v0, p3

    neg-float v1, p4

    invoke-direct {p0, v0, v1}, Lcom/android/ex/photo/views/PhotoView;->translate(FF)Z

    .line 247
    :cond_0
    const/4 v0, 0x1

    return v0
.end method

.method public onShowPress(Landroid/view/MotionEvent;)V
    .locals 0
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 240
    return-void
.end method

.method public onSingleTapConfirmed(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 222
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mExternalClickListener:Landroid/view/View$OnClickListener;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mIsDoubleTouch:Z

    if-nez v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mExternalClickListener:Landroid/view/View$OnClickListener;

    invoke-interface {v0, p0}, Landroid/view/View$OnClickListener;->onClick(Landroid/view/View;)V

    .line 225
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mIsDoubleTouch:Z

    .line 226
    const/4 v0, 0x1

    return v0
.end method

.method public onSingleTapUp(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "e"    # Landroid/view/MotionEvent;

    .prologue
    .line 231
    const/4 v0, 0x0

    return v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 176
    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleGetureDetector:Landroid/view/ScaleGestureDetector;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mGestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

    if-nez v1, :cond_1

    .line 194
    :cond_0
    :goto_0
    return v2

    .line 181
    :cond_1
    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mScaleGetureDetector:Landroid/view/ScaleGestureDetector;

    invoke-virtual {v1, p1}, Landroid/view/ScaleGestureDetector;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 182
    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mGestureDetector:Landroid/support/v4/view/GestureDetectorCompat;

    invoke-virtual {v1, p1}, Landroid/support/v4/view/GestureDetectorCompat;->onTouchEvent(Landroid/view/MotionEvent;)Z

    .line 183
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 185
    .local v0, "action":I
    packed-switch v0, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 188
    :pswitch_1
    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mTranslateRunnable:Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;

    # getter for: Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->mRunning:Z
    invoke-static {v1}, Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;->access$000(Lcom/android/ex/photo/views/PhotoView$TranslateRunnable;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 189
    invoke-direct {p0}, Lcom/android/ex/photo/views/PhotoView;->snap()V

    goto :goto_0

    .line 185
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public resetTransformations()V
    .locals 2

    .prologue
    .line 518
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView;->mMatrix:Landroid/graphics/Matrix;

    iget-object v1, p0, Lcom/android/ex/photo/views/PhotoView;->mOriginalMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v0, v1}, Landroid/graphics/Matrix;->set(Landroid/graphics/Matrix;)V

    .line 524
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    .line 525
    return-void
.end method

.method public setFullScreen(ZZ)V
    .locals 1
    .param p1, "fullScreen"    # Z
    .param p2, "animate"    # Z

    .prologue
    .line 461
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView;->mFullScreen:Z

    if-eq p1, v0, :cond_0

    .line 462
    iput-boolean p1, p0, Lcom/android/ex/photo/views/PhotoView;->mFullScreen:Z

    .line 463
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->requestLayout()V

    .line 464
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView;->invalidate()V

    .line 466
    :cond_0
    return-void
.end method

.method public setOnClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 297
    iput-object p1, p0, Lcom/android/ex/photo/views/PhotoView;->mExternalClickListener:Landroid/view/View$OnClickListener;

    .line 298
    return-void
.end method
