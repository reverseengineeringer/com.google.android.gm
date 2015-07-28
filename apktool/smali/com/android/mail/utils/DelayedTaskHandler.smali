.class public abstract Lcom/android/mail/utils/DelayedTaskHandler;
.super Landroid/os/Handler;
.source "DelayedTaskHandler.java"


# instance fields
.field private final mDelayMs:I

.field private mLastTaskExecuteTime:J


# direct methods
.method public constructor <init>(Landroid/os/Looper;I)V
    .locals 2
    .param p1, "looper"    # Landroid/os/Looper;
    .param p2, "defaultDelayMs"    # I

    .prologue
    .line 39
    invoke-direct {p0, p1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 36
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mLastTaskExecuteTime:J

    .line 40
    iput p2, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mDelayMs:I

    .line 41
    return-void
.end method


# virtual methods
.method public dispatchMessage(Landroid/os/Message;)V
    .locals 0
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 62
    invoke-virtual {p0}, Lcom/android/mail/utils/DelayedTaskHandler;->onTaskExecution()V

    .line 63
    invoke-virtual {p0}, Lcom/android/mail/utils/DelayedTaskHandler;->performTask()V

    .line 64
    return-void
.end method

.method public onTaskExecution()V
    .locals 2

    .prologue
    .line 73
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mLastTaskExecuteTime:J

    .line 74
    return-void
.end method

.method protected abstract performTask()V
.end method

.method public scheduleTask()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 47
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 48
    .local v0, "currentTime":J
    invoke-virtual {p0, v6}, Lcom/android/mail/utils/DelayedTaskHandler;->removeMessages(I)V

    .line 49
    iget-wide v2, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mLastTaskExecuteTime:J

    const-wide/16 v4, -0x1

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    iget-wide v2, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mLastTaskExecuteTime:J

    iget v4, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mDelayMs:I

    int-to-long v4, v4

    add-long/2addr v2, v4

    cmp-long v2, v2, v0

    if-gez v2, :cond_1

    .line 53
    :cond_0
    invoke-virtual {p0, v6}, Lcom/android/mail/utils/DelayedTaskHandler;->sendEmptyMessage(I)Z

    .line 58
    :goto_0
    return-void

    .line 56
    :cond_1
    iget v2, p0, Lcom/android/mail/utils/DelayedTaskHandler;->mDelayMs:I

    int-to-long v2, v2

    invoke-virtual {p0, v6, v2, v3}, Lcom/android/mail/utils/DelayedTaskHandler;->sendEmptyMessageDelayed(IJ)Z

    goto :goto_0
.end method
