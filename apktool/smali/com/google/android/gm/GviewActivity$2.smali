.class Lcom/google/android/gm/GviewActivity$2;
.super Ljava/lang/Object;
.source "GviewActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/GviewActivity;->onCreateDialog(ILandroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/GviewActivity;


# direct methods
.method constructor <init>(Lcom/google/android/gm/GviewActivity;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/google/android/gm/GviewActivity$2;->this$0:Lcom/google/android/gm/GviewActivity;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 145
    iget-object v0, p0, Lcom/google/android/gm/GviewActivity$2;->this$0:Lcom/google/android/gm/GviewActivity;

    # getter for: Lcom/google/android/gm/GviewActivity;->mGviewAsyncTask:Lcom/google/android/gm/GviewActivity$GviewAsyncTask;
    invoke-static {v0}, Lcom/google/android/gm/GviewActivity;->access$000(Lcom/google/android/gm/GviewActivity;)Lcom/google/android/gm/GviewActivity$GviewAsyncTask;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/GviewActivity$GviewAsyncTask;->isLoading()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/google/android/gm/GviewActivity$2;->this$0:Lcom/google/android/gm/GviewActivity;

    # getter for: Lcom/google/android/gm/GviewActivity;->mGviewAsyncTask:Lcom/google/android/gm/GviewActivity$GviewAsyncTask;
    invoke-static {v0}, Lcom/google/android/gm/GviewActivity;->access$000(Lcom/google/android/gm/GviewActivity;)Lcom/google/android/gm/GviewActivity$GviewAsyncTask;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/GviewActivity$GviewAsyncTask;->cancel(Z)Z

    .line 147
    iget-object v0, p0, Lcom/google/android/gm/GviewActivity$2;->this$0:Lcom/google/android/gm/GviewActivity;

    invoke-virtual {v0}, Lcom/google/android/gm/GviewActivity;->finish()V

    .line 149
    :cond_0
    return-void
.end method
