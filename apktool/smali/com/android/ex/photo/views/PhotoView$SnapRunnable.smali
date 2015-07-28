.class Lcom/android/ex/photo/views/PhotoView$SnapRunnable;
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
    name = "SnapRunnable"
.end annotation


# instance fields
.field private final mHeader:Lcom/android/ex/photo/views/PhotoView;

.field private mRunning:Z

.field private mStartRunTime:J

.field private mStop:Z

.field private mTranslateX:F

.field private mTranslateY:F


# direct methods
.method public constructor <init>(Lcom/android/ex/photo/views/PhotoView;)V
    .locals 2
    .param p1, "header"    # Lcom/android/ex/photo/views/PhotoView;

    .prologue
    .line 1136
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 1137
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStartRunTime:J

    .line 1138
    iput-object p1, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    .line 1139
    return-void
.end method


# virtual methods
.method public run()V
    .locals 13

    .prologue
    const-wide/16 v11, -0x1

    const/high16 v10, 0x7fc00000    # NaNf

    const/high16 v9, 0x41200000    # 10.0f

    const/high16 v8, 0x42c80000    # 100.0f

    const/4 v5, 0x0

    .line 1168
    iget-boolean v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStop:Z

    if-eqz v6, :cond_1

    .line 1209
    :cond_0
    :goto_0
    return-void

    .line 1173
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 1174
    .local v1, "now":J
    iget-wide v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStartRunTime:J

    cmp-long v6, v6, v11

    if-eqz v6, :cond_5

    iget-wide v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStartRunTime:J

    sub-long v6, v1, v6

    long-to-float v0, v6

    .line 1176
    .local v0, "delta":F
    :goto_1
    iget-wide v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStartRunTime:J

    cmp-long v6, v6, v11

    if-nez v6, :cond_2

    .line 1177
    iput-wide v1, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStartRunTime:J

    .line 1182
    :cond_2
    cmpl-float v6, v0, v8

    if-ltz v6, :cond_6

    .line 1183
    iget v3, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    .line 1184
    .local v3, "transX":F
    iget v4, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    .line 1196
    .local v4, "transY":F
    :cond_3
    :goto_2
    iget-object v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    # invokes: Lcom/android/ex/photo/views/PhotoView;->translate(FF)Z
    invoke-static {v6, v3, v4}, Lcom/android/ex/photo/views/PhotoView;->access$200(Lcom/android/ex/photo/views/PhotoView;FF)Z

    .line 1197
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    sub-float/2addr v6, v3

    iput v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    .line 1198
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    sub-float/2addr v6, v4

    iput v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    .line 1200
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    cmpl-float v6, v6, v5

    if-nez v6, :cond_4

    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    cmpl-float v5, v6, v5

    if-nez v5, :cond_4

    .line 1201
    invoke-virtual {p0}, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->stop()V

    .line 1205
    :cond_4
    iget-boolean v5, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStop:Z

    if-nez v5, :cond_0

    .line 1208
    iget-object v5, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    invoke-virtual {v5, p0}, Lcom/android/ex/photo/views/PhotoView;->post(Ljava/lang/Runnable;)Z

    goto :goto_0

    .end local v0    # "delta":F
    .end local v3    # "transX":F
    .end local v4    # "transY":F
    :cond_5
    move v0, v5

    .line 1174
    goto :goto_1

    .line 1186
    .restart local v0    # "delta":F
    :cond_6
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    sub-float v7, v8, v0

    div-float/2addr v6, v7

    mul-float v3, v6, v9

    .line 1187
    .restart local v3    # "transX":F
    iget v6, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    sub-float v7, v8, v0

    div-float/2addr v6, v7

    mul-float v4, v6, v9

    .line 1188
    .restart local v4    # "transY":F
    invoke-static {v3}, Ljava/lang/Math;->abs(F)F

    move-result v6

    iget v7, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    cmpl-float v6, v6, v7

    if-gtz v6, :cond_7

    cmpl-float v6, v3, v10

    if-nez v6, :cond_8

    .line 1189
    :cond_7
    iget v3, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    .line 1191
    :cond_8
    invoke-static {v4}, Ljava/lang/Math;->abs(F)F

    move-result v6

    iget v7, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    invoke-static {v7}, Ljava/lang/Math;->abs(F)F

    move-result v7

    cmpl-float v6, v6, v7

    if-gtz v6, :cond_9

    cmpl-float v6, v4, v10

    if-nez v6, :cond_3

    .line 1192
    :cond_9
    iget v4, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    goto :goto_2
.end method

.method public start(FF)Z
    .locals 4
    .param p1, "translateX"    # F
    .param p2, "translateY"    # F

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 1145
    iget-boolean v2, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mRunning:Z

    if-eqz v2, :cond_0

    .line 1154
    :goto_0
    return v0

    .line 1148
    :cond_0
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStartRunTime:J

    .line 1149
    iput p1, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateX:F

    .line 1150
    iput p2, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mTranslateY:F

    .line 1151
    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStop:Z

    .line 1152
    iput-boolean v1, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mRunning:Z

    .line 1153
    iget-object v0, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mHeader:Lcom/android/ex/photo/views/PhotoView;

    const-wide/16 v2, 0xfa

    invoke-virtual {v0, p0, v2, v3}, Lcom/android/ex/photo/views/PhotoView;->postDelayed(Ljava/lang/Runnable;J)Z

    move v0, v1

    .line 1154
    goto :goto_0
.end method

.method public stop()V
    .locals 1

    .prologue
    .line 1161
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mRunning:Z

    .line 1162
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/android/ex/photo/views/PhotoView$SnapRunnable;->mStop:Z

    .line 1163
    return-void
.end method
