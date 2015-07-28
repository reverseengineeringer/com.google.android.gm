.class Lcom/google/android/gm/provider/MailEngine$1;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Ljava/util/Observer;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private mLabelMapInitialized:Z

.field private mPreviousLabelSynced:Z

.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 463
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$1;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 464
    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$1;->mLabelMapInitialized:Z

    .line 465
    iput-boolean v0, p0, Lcom/google/android/gm/provider/MailEngine$1;->mPreviousLabelSynced:Z

    return-void
.end method


# virtual methods
.method public update(Ljava/util/Observable;Ljava/lang/Object;)V
    .locals 3
    .param p1, "observable"    # Ljava/util/Observable;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 468
    iget-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->mLabelMapInitialized:Z

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$1;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynchronizationStateInitialized()Z

    move-result v2

    if-ne v1, v2, :cond_0

    iget-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->mPreviousLabelSynced:Z

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$1;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v2

    if-eq v1, v2, :cond_2

    :cond_0
    const/4 v0, 0x1

    .line 471
    .local v0, "sendNotifications":Z
    :goto_0
    if-eqz v0, :cond_1

    .line 472
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynced()Z

    move-result v1

    iput-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->mPreviousLabelSynced:Z

    .line 473
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$LabelMap;->labelsSynchronizationStateInitialized()Z

    move-result v1

    iput-boolean v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->mLabelMapInitialized:Z

    .line 475
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$1;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->notifyStatusChange()V
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$100(Lcom/google/android/gm/provider/MailEngine;)V

    .line 477
    :cond_1
    return-void

    .line 468
    .end local v0    # "sendNotifications":Z
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method
