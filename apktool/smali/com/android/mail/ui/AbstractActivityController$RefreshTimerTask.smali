.class Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;
.super Ljava/util/TimerTask;
.source "AbstractActivityController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractActivityController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "RefreshTimerTask"
.end annotation


# instance fields
.field final mController:Lcom/android/mail/ui/AbstractActivityController;

.field final mHandler:Landroid/os/Handler;


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2269
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;->mHandler:Landroid/os/Handler;

    new-instance v1, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask$1;

    invoke-direct {v1, p0}, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask$1;-><init>(Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 2275
    return-void
.end method
