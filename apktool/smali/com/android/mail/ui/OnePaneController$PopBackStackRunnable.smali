.class final Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;
.super Ljava/lang/Object;
.source "OnePaneController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/OnePaneController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x12
    name = "PopBackStackRunnable"
.end annotation


# instance fields
.field private final mTransactionId:I

.field final synthetic this$0:Lcom/android/mail/ui/OnePaneController;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/OnePaneController;I)V
    .locals 0
    .param p2, "transactionId"    # I

    .prologue
    .line 572
    iput-object p1, p0, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->this$0:Lcom/android/mail/ui/OnePaneController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 573
    iput p2, p0, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->mTransactionId:I

    .line 574
    return-void
.end method


# virtual methods
.method public popBackStack()V
    .locals 3

    .prologue
    .line 577
    iget-object v0, p0, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->this$0:Lcom/android/mail/ui/OnePaneController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v0}, Lcom/android/mail/ui/ControllableActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    iget v1, p0, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->mTransactionId:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentManager;->popBackStack(II)V

    .line 578
    return-void
.end method

.method public run()V
    .locals 3

    .prologue
    .line 582
    iget-object v0, p0, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->this$0:Lcom/android/mail/ui/OnePaneController;

    invoke-virtual {v0}, Lcom/android/mail/ui/OnePaneController;->safeToModifyFragments()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 583
    invoke-virtual {p0}, Lcom/android/mail/ui/OnePaneController$PopBackStackRunnable;->popBackStack()V

    .line 588
    :goto_0
    return-void

    .line 585
    :cond_0
    sget-object v0, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Activity has been saved; ignoring unsafe deferred request to pop back stack"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method
