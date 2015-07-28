.class Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask$1;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;)V
    .locals 0

    .prologue
    .line 2269
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask$1;->this$0:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 2272
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Delay done... calling onRefreshRequired"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2273
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask$1;->this$0:Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController$RefreshTimerTask;->mController:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v0}, Lcom/android/mail/ui/AbstractActivityController;->onRefreshRequired()V

    .line 2274
    return-void
.end method
