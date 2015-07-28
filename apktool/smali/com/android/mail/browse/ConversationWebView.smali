.class public Lcom/android/mail/browse/ConversationWebView;
.super Landroid/webkit/WebView;
.source "ConversationWebView.java"

# interfaces
.implements Lcom/android/mail/browse/ScrollNotifier;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field private mCachedContentHeight:I

.field private mCanvas:Landroid/graphics/Canvas;

.field private final mDensity:F

.field private mHandlingTouch:Z

.field private final mNotifyPageRenderedInHardwareLayer:Ljava/lang/Runnable;

.field private final mScrollListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/android/mail/browse/ScrollNotifier$ScrollListener;",
            ">;"
        }
    .end annotation
.end field

.field private mSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

.field private mUseSoftwareLayer:Z

.field private final mViewportWidth:I

.field private mVisible:Z

.field private final mWebviewInitialDelay:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 163
    invoke-static {}, Lcom/android/mail/utils/LogTag;->getLogTag()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/android/mail/browse/ConversationWebView;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 166
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/android/mail/browse/ConversationWebView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 167
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "c"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 170
    invoke-direct {p0, p1, p2}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 50
    new-instance v1, Lcom/android/mail/browse/ConversationWebView$1;

    invoke-direct {v1, p0}, Lcom/android/mail/browse/ConversationWebView$1;-><init>(Lcom/android/mail/browse/ConversationWebView;)V

    iput-object v1, p0, Lcom/android/mail/browse/ConversationWebView;->mNotifyPageRenderedInHardwareLayer:Ljava/lang/Runnable;

    .line 154
    new-instance v1, Ljava/util/concurrent/CopyOnWriteArraySet;

    invoke-direct {v1}, Ljava/util/concurrent/CopyOnWriteArraySet;-><init>()V

    iput-object v1, p0, Lcom/android/mail/browse/ConversationWebView;->mScrollListeners:Ljava/util/Set;

    .line 172
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 173
    .local v0, "r":Landroid/content/res/Resources;
    const v1, 0x7f0a0025

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    iput v1, p0, Lcom/android/mail/browse/ConversationWebView;->mViewportWidth:I

    .line 174
    const v1, 0x7f0a002c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v1

    iput v1, p0, Lcom/android/mail/browse/ConversationWebView;->mWebviewInitialDelay:I

    .line 175
    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    iget v1, v1, Landroid/util/DisplayMetrics;->density:F

    iput v1, p0, Lcom/android/mail/browse/ConversationWebView;->mDensity:F

    .line 176
    return-void
.end method

.method static synthetic access$002(Lcom/android/mail/browse/ConversationWebView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationWebView;
    .param p1, "x1"    # Z

    .prologue
    .line 35
    iput-boolean p1, p0, Lcom/android/mail/browse/ConversationWebView;->mUseSoftwareLayer:Z

    return p1
.end method

.method static synthetic access$100(Lcom/android/mail/browse/ConversationWebView;)V
    .locals 0
    .param p0, "x0"    # Lcom/android/mail/browse/ConversationWebView;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationWebView;->destroyBitmap()V

    return-void
.end method

.method private destroyBitmap()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 107
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 108
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 109
    iput-object v1, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    .line 110
    iput-object v1, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;

    .line 112
    :cond_0
    return-void
.end method


# virtual methods
.method public addScrollListener(Lcom/android/mail/browse/ScrollNotifier$ScrollListener;)V
    .locals 1
    .param p1, "l"    # Lcom/android/mail/browse/ScrollNotifier$ScrollListener;

    .prologue
    .line 180
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView;->mScrollListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 181
    return-void
.end method

.method public computeHorizontalScrollExtent()I
    .locals 1

    .prologue
    .line 220
    invoke-super {p0}, Landroid/webkit/WebView;->computeHorizontalScrollExtent()I

    move-result v0

    return v0
.end method

.method public computeHorizontalScrollOffset()I
    .locals 1

    .prologue
    .line 215
    invoke-super {p0}, Landroid/webkit/WebView;->computeHorizontalScrollOffset()I

    move-result v0

    return v0
.end method

.method public computeHorizontalScrollRange()I
    .locals 1

    .prologue
    .line 210
    invoke-super {p0}, Landroid/webkit/WebView;->computeHorizontalScrollRange()I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollExtent()I
    .locals 1

    .prologue
    .line 205
    invoke-super {p0}, Landroid/webkit/WebView;->computeVerticalScrollExtent()I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollOffset()I
    .locals 1

    .prologue
    .line 200
    invoke-super {p0}, Landroid/webkit/WebView;->computeVerticalScrollOffset()I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollRange()I
    .locals 1

    .prologue
    .line 195
    invoke-super {p0}, Landroid/webkit/WebView;->computeVerticalScrollRange()I

    move-result v0

    return v0
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/android/mail/browse/ConversationWebView;->destroyBitmap()V

    .line 98
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView;->mNotifyPageRenderedInHardwareLayer:Ljava/lang/Runnable;

    invoke-virtual {p0, v0}, Lcom/android/mail/browse/ConversationWebView;->removeCallbacks(Ljava/lang/Runnable;)Z

    .line 100
    invoke-super {p0}, Landroid/webkit/WebView;->destroy()V

    .line 101
    return-void
.end method

.method public getInitialScale()F
    .locals 1

    .prologue
    .line 283
    iget v0, p0, Lcom/android/mail/browse/ConversationWebView;->mDensity:F

    return v0
.end method

.method public getViewportWidth()I
    .locals 1

    .prologue
    .line 271
    iget v0, p0, Lcom/android/mail/browse/ConversationWebView;->mViewportWidth:I

    return v0
.end method

.method public invalidate()V
    .locals 2

    .prologue
    .line 234
    invoke-super {p0}, Landroid/webkit/WebView;->invalidate()V

    .line 236
    iget-object v1, p0, Lcom/android/mail/browse/ConversationWebView;->mSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    if-eqz v1, :cond_0

    .line 237
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getContentHeight()I

    move-result v0

    .line 238
    .local v0, "contentHeight":I
    iget v1, p0, Lcom/android/mail/browse/ConversationWebView;->mCachedContentHeight:I

    if-eq v0, v1, :cond_0

    .line 239
    iput v0, p0, Lcom/android/mail/browse/ConversationWebView;->mCachedContentHeight:I

    .line 240
    iget-object v1, p0, Lcom/android/mail/browse/ConversationWebView;->mSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    invoke-interface {v1, v0}, Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;->onHeightChange(I)V

    .line 243
    .end local v0    # "contentHeight":I
    :cond_0
    return-void
.end method

.method public isHandlingTouch()Z
    .locals 1

    .prologue
    .line 267
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationWebView;->mHandlingTouch:Z

    return v0
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 7
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    const/4 v6, 0x0

    .line 63
    invoke-super {p0, p1}, Landroid/webkit/WebView;->onDraw(Landroid/graphics/Canvas;)V

    .line 67
    iget-boolean v3, p0, Lcom/android/mail/browse/ConversationWebView;->mUseSoftwareLayer:Z

    if-eqz v3, :cond_1

    iget-boolean v3, p0, Lcom/android/mail/browse/ConversationWebView;->mVisible:Z

    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getWidth()I

    move-result v3

    if-lez v3, :cond_1

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getHeight()I

    move-result v3

    if-lez v3, :cond_1

    .line 68
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    if-nez v3, :cond_0

    .line 71
    :try_start_0
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getWidth()I

    move-result v3

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getHeight()I

    move-result v4

    sget-object v5, Landroid/graphics/Bitmap$Config;->RGB_565:Landroid/graphics/Bitmap$Config;

    invoke-static {v3, v4, v5}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v3

    iput-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    .line 72
    new-instance v3, Landroid/graphics/Canvas;

    iget-object v4, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    invoke-direct {v3, v4}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    iput-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 81
    :cond_0
    :goto_0
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v3, :cond_1

    .line 82
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getScrollX()I

    move-result v1

    .line 83
    .local v1, "x":I
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getScrollY()I

    move-result v2

    .line 85
    .local v2, "y":I
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;

    invoke-virtual {v3}, Landroid/graphics/Canvas;->save()I

    .line 86
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;

    neg-int v4, v1

    int-to-float v4, v4

    neg-int v5, v2

    int-to-float v5, v5

    invoke-virtual {v3, v4, v5}, Landroid/graphics/Canvas;->translate(FF)V

    .line 87
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;

    invoke-super {p0, v3}, Landroid/webkit/WebView;->onDraw(Landroid/graphics/Canvas;)V

    .line 88
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;

    invoke-virtual {v3}, Landroid/graphics/Canvas;->restore()V

    .line 90
    iget-object v3, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    int-to-float v4, v1

    int-to-float v5, v2

    invoke-virtual {p1, v3, v4, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 93
    .end local v1    # "x":I
    .end local v2    # "y":I
    :cond_1
    return-void

    .line 73
    :catch_0
    move-exception v0

    .line 75
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    iput-object v6, p0, Lcom/android/mail/browse/ConversationWebView;->mBitmap:Landroid/graphics/Bitmap;

    .line 76
    iput-object v6, p0, Lcom/android/mail/browse/ConversationWebView;->mCanvas:Landroid/graphics/Canvas;

    .line 77
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationWebView;->mUseSoftwareLayer:Z

    goto :goto_0
.end method

.method public onRenderComplete()V
    .locals 3

    .prologue
    .line 132
    iget-boolean v0, p0, Lcom/android/mail/browse/ConversationWebView;->mUseSoftwareLayer:Z

    if-eqz v0, :cond_0

    .line 134
    iget-object v0, p0, Lcom/android/mail/browse/ConversationWebView;->mNotifyPageRenderedInHardwareLayer:Ljava/lang/Runnable;

    iget v1, p0, Lcom/android/mail/browse/ConversationWebView;->mWebviewInitialDelay:I

    int-to-long v1, v1

    invoke-virtual {p0, v0, v1, v2}, Lcom/android/mail/browse/ConversationWebView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 136
    :cond_0
    return-void
.end method

.method protected onScrollChanged(IIII)V
    .locals 3
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 225
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebView;->onScrollChanged(IIII)V

    .line 227
    iget-object v2, p0, Lcom/android/mail/browse/ConversationWebView;->mScrollListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/browse/ScrollNotifier$ScrollListener;

    .line 228
    .local v1, "listener":Lcom/android/mail/browse/ScrollNotifier$ScrollListener;
    invoke-interface {v1, p1, p2}, Lcom/android/mail/browse/ScrollNotifier$ScrollListener;->onNotifierScroll(II)V

    goto :goto_0

    .line 230
    .end local v1    # "listener":Lcom/android/mail/browse/ScrollNotifier$ScrollListener;
    :cond_0
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 247
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getActionMasked()I

    move-result v0

    .line 249
    .local v0, "action":I
    packed-switch v0, :pswitch_data_0

    .line 263
    :goto_0
    :pswitch_0
    invoke-super {p0, p1}, Landroid/webkit/WebView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v1

    return v1

    .line 251
    :pswitch_1
    iput-boolean v4, p0, Lcom/android/mail/browse/ConversationWebView;->mHandlingTouch:Z

    goto :goto_0

    .line 254
    :pswitch_2
    sget-object v1, Lcom/android/mail/browse/ConversationWebView;->LOG_TAG:Ljava/lang/String;

    const-string v2, "WebView disabling intercepts: POINTER_DOWN"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {v1, v2, v3}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 255
    invoke-virtual {p0, v4}, Lcom/android/mail/browse/ConversationWebView;->requestDisallowInterceptTouchEvent(Z)V

    goto :goto_0

    .line 259
    :pswitch_3
    iput-boolean v3, p0, Lcom/android/mail/browse/ConversationWebView;->mHandlingTouch:Z

    goto :goto_0

    .line 249
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onUserVisibilityChanged(Z)V
    .locals 0
    .param p1, "visible"    # Z

    .prologue
    .line 139
    iput-boolean p1, p0, Lcom/android/mail/browse/ConversationWebView;->mVisible:Z

    .line 140
    return-void
.end method

.method public screenPxToWebPx(I)I
    .locals 2
    .param p1, "screenPx"    # I

    .prologue
    .line 287
    int-to-float v0, p1

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getInitialScale()F

    move-result v1

    div-float/2addr v0, v1

    float-to-int v0, v0

    return v0
.end method

.method public screenPxToWebPxError(I)F
    .locals 2
    .param p1, "screenPx"    # I

    .prologue
    .line 295
    int-to-float v0, p1

    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationWebView;->getInitialScale()F

    move-result v1

    div-float/2addr v0, v1

    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationWebView;->screenPxToWebPx(I)I

    move-result v1

    int-to-float v1, v1

    sub-float/2addr v0, v1

    return v0
.end method

.method public setContentSizeChangeListener(Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;)V
    .locals 0
    .param p1, "l"    # Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/android/mail/browse/ConversationWebView;->mSizeChangeListener:Lcom/android/mail/browse/ConversationWebView$ContentSizeChangeListener;

    .line 190
    return-void
.end method

.method public setUseSoftwareLayer(Z)V
    .locals 0
    .param p1, "useSoftware"    # Z

    .prologue
    .line 124
    iput-boolean p1, p0, Lcom/android/mail/browse/ConversationWebView;->mUseSoftwareLayer:Z

    .line 125
    return-void
.end method
