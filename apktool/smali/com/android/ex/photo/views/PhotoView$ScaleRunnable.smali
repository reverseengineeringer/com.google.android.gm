.class Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;
.super Ljava/lang/Object;
.source "PhotoView.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/ex/photo/views/PhotoView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "ScaleRunnable"
.end annotation


# instance fields
.field private mCenterX:F

.field private mCenterY:F

.field private final mHeader:Lcom/android/ex/photo/views/PhotoView;

.field private mRunning:Z

.field private mStartScale:F

.field private mStartTime:J

.field private mStop:Z

.field private mTargetScale:F

.field private mVelocity:F

.field private mZoomingIn:Z


# direct methods
.method public constructor <init>(Lcom/android/ex/photo/views/PhotoView;)V
    .locals 0
    .param p1, "header"    # Lcom/android/ex/photo/views/PhotoView;

    .prologue
    .line 964
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 965
    iput-object p1, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    .line 966
    return-void
.end method


# virtual methods
.method public run()V
    .locals 9

    .prologue
    .line 1001
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStop:Z

    if-eqz v5, :cond_1

    .line 1020
    :cond_0
    :goto_0
    return-void

    .line 1006
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    .line 1007
    .local v3, "now":J
    iget-wide v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStartTime:J

    sub-long v0, v3, v5

    .line 1008
    .local v0, "ellapsed":J
    iget v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStartScale:F

    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mVelocity:F

    long-to-float v7, v0

    mul-float/2addr v6, v7

    add-float v2, v5, v6

    .line 1009
    .local v2, "newScale":F
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mCenterX:F

    iget v7, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mCenterY:F

    # invokes: Lcom/android/ex/photo/views/PhotoView;->scale(FFF)V
    invoke-static {v5, v2, v6, v7}, Lcom/android/ex/photo/views/PhotoView;->access$100(Lcom/android/ex/photo/views/PhotoView;FFF)V

    .line 1012
    iget v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mTargetScale:F

    cmpl-float v5, v2, v5

    if-eqz v5, :cond_2

    iget-boolean v6, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mZoomingIn:Z

    iget v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mTargetScale:F

    cmpl-float v5, v2, v5

    if-lez v5, :cond_4

    const/4 v5, 0x1

    :goto_1
    if-ne v6, v5, :cond_3

    .line 1013
    :cond_2
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mTargetScale:F

    iget v7, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mCenterX:F

    iget v8, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mCenterY:F

    # invokes: Lcom/android/ex/photo/views/PhotoView;->scale(FFF)V
    invoke-static {v5, v6, v7, v8}, Lcom/android/ex/photo/views/PhotoView;->access$100(Lcom/android/ex/photo/views/PhotoView;FFF)V

    .line 1014
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->stop()V

    .line 1017
    :cond_3
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStop:Z

    if-nez v5, :cond_0

    .line 1018
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v5, p0}, Lcom/android/ex/photo/views/PhotoView;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .line 1012
    :cond_4
    const/4 v5, 0x0

    goto :goto_1
.end method

.method public start(FFFF)Z
    .locals 5
    .param p1, "startScale"    # F
    .param p2, "targetScale"    # F
    .param p3, "centerX"    # F
    .param p4, "centerY"    # F

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 972
    iget-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mRunning:Z

    if-eqz v0, :cond_0

    .line 988
    :goto_0
    return v2

    .line 976
    :cond_0
    iput p3, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mCenterX:F

    .line 977
    iput p4, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mCenterY:F

    .line 980
    iput p2, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mTargetScale:F

    .line 981
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    iput-wide v3, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStartTime:J

    .line 982
    iput p1, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStartScale:F

    .line 983
    iget v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mTargetScale:F

    iget v3, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStartScale:F

    cmpl-float v0, v0, v3

    if-lez v0, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mZoomingIn:Z

    .line 984
    iget v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mTargetScale:F

    iget v3, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStartScale:F

    sub-float/2addr v0, v3

    const/high16 v3, 0x43960000    # 300.0f

    div-float/2addr v0, v3

    iput v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mVelocity:F

    .line 985
    iput-boolean v1, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mRunning:Z

    .line 986
    iput-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStop:Z

    .line 987
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v0, p0}, Lcom/android/ex/photo/views/PhotoView;->post(Ljava/lang/Runnable;)Z

    move v2, v1

    .line 988
    goto :goto_0

    :cond_1
    move v0, v2

    .line 983
    goto :goto_1
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 995
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mRunning:Z

    .line 996
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$ScaleRunnable;->mStop:Z

    .line 997
    return-void
.end method
