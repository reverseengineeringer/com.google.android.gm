.class public Lcom/android/mail/utils/InputSmoother;
.super Ljava/lang/Object;
.source "InputSmoother.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/android/mail/utils/InputSmoother$1;,
        Lcom/android/mail/utils/InputSmoother$Sample;
    }
.end annotation


# instance fields
.field private final mDensity:F

.field private final mRecentSamples:Ljava/util/Deque;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Deque",
            "<",
            "Lcom/android/mail/utils/InputSmoother$Sample;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 45
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    invoke-static {}, Lcom/google/common/collect/Lists;->newLinkedList()Ljava/util/LinkedList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    .line 46
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    iput v0, p0, Lcom/android/mail/utils/InputSmoother;->mDensity:F

    .line 47
    return-void
.end method


# virtual methods
.method public getSmoothedVelocity()Ljava/lang/Float;
    .locals 13

    .prologue
    const/4 v8, 0x0

    .line 76
    iget-object v7, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v7}, Ljava/util/Deque;->size()I

    move-result v7

    const/4 v9, 0x2

    if-ge v7, v9, :cond_0

    move-object v7, v8

    .line 97
    :goto_0
    return-object v7

    .line 82
    :cond_0
    const/4 v4, 0x0

    .line 83
    .local v4, "totalDistancePx":I
    iget-object v7, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v7}, Ljava/util/Deque;->getFirst()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/mail/utils/InputSmoother$Sample;

    iget v2, v7, Lcom/android/mail/utils/InputSmoother$Sample;->pos:I

    .line 84
    .local v2, "prevPos":I
    iget-object v7, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v7}, Ljava/util/Deque;->getLast()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/mail/utils/InputSmoother$Sample;

    iget-wide v9, v7, Lcom/android/mail/utils/InputSmoother$Sample;->millis:J

    iget-object v7, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v7}, Ljava/util/Deque;->getFirst()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/android/mail/utils/InputSmoother$Sample;

    iget-wide v11, v7, Lcom/android/mail/utils/InputSmoother$Sample;->millis:J

    sub-long v5, v9, v11

    .line 86
    .local v5, "totalTimeMs":J
    const-wide/16 v9, 0x0

    cmp-long v7, v5, v9

    if-gtz v7, :cond_1

    move-object v7, v8

    .line 88
    goto :goto_0

    .line 91
    :cond_1
    iget-object v7, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v7}, Ljava/util/Deque;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/mail/utils/InputSmoother$Sample;

    .line 92
    .local v3, "s":Lcom/android/mail/utils/InputSmoother$Sample;
    iget v7, v3, Lcom/android/mail/utils/InputSmoother$Sample;->pos:I

    sub-int/2addr v7, v2

    invoke-static {v7}, Ljava/lang/Math;->abs(I)I

    move-result v7

    add-int/2addr v4, v7

    .line 93
    iget v2, v3, Lcom/android/mail/utils/InputSmoother$Sample;->pos:I

    goto :goto_1

    .line 95
    .end local v3    # "s":Lcom/android/mail/utils/InputSmoother$Sample;
    :cond_2
    int-to-float v7, v4

    iget v8, p0, Lcom/android/mail/utils/InputSmoother;->mDensity:F

    div-float v0, v7, v8

    .line 97
    .local v0, "distanceDp":F
    const/high16 v7, 0x447a0000    # 1000.0f

    mul-float/2addr v7, v0

    long-to-float v8, v5

    div-float/2addr v7, v8

    invoke-static {v7}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v7

    goto :goto_0
.end method

.method public onInput(I)V
    .locals 8
    .param p1, "pos"    # I

    .prologue
    .line 51
    invoke-static {}, Landroid/os/SystemClock;->uptimeMillis()J

    move-result-wide v1

    .line 53
    .local v1, "nowMs":J
    iget-object v4, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->peekLast()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/utils/InputSmoother$Sample;

    .line 54
    .local v0, "last":Lcom/android/mail/utils/InputSmoother$Sample;
    if-eqz v0, :cond_0

    iget-wide v4, v0, Lcom/android/mail/utils/InputSmoother$Sample;->millis:J

    sub-long v4, v1, v4

    const-wide/16 v6, 0xc8

    cmp-long v4, v4, v6

    if-lez v4, :cond_0

    .line 55
    iget-object v4, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->clear()V

    .line 58
    :cond_0
    iget-object v4, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->size()I

    move-result v4

    const/4 v5, 0x5

    if-ne v4, v5, :cond_1

    .line 59
    iget-object v4, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v4}, Ljava/util/Deque;->removeFirst()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/android/mail/utils/InputSmoother$Sample;

    .line 63
    .local v3, "sample":Lcom/android/mail/utils/InputSmoother$Sample;
    :goto_0
    iput p1, v3, Lcom/android/mail/utils/InputSmoother$Sample;->pos:I

    .line 64
    iput-wide v1, v3, Lcom/android/mail/utils/InputSmoother$Sample;->millis:J

    .line 66
    iget-object v4, p0, Lcom/android/mail/utils/InputSmoother;->mRecentSamples:Ljava/util/Deque;

    invoke-interface {v4, v3}, Ljava/util/Deque;->add(Ljava/lang/Object;)Z

    .line 67
    return-void

    .line 61
    .end local v3    # "sample":Lcom/android/mail/utils/InputSmoother$Sample;
    :cond_1
    new-instance v3, Lcom/android/mail/utils/InputSmoother$Sample;

    const/4 v4, 0x0

    invoke-direct {v3, v4}, Lcom/android/mail/utils/InputSmoother$Sample;-><init>(Lcom/android/mail/utils/InputSmoother$1;)V

    .restart local v3    # "sample":Lcom/android/mail/utils/InputSmoother$Sample;
    goto :goto_0
.end method
