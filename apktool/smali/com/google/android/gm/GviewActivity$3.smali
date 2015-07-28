.class Lcom/google/android/gm/GviewActivity$3;
.super Ljava/lang/Object;
.source "GviewActivity.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


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
    .line 156
    iput-object p1, p0, Lcom/google/android/gm/GviewActivity$3;->this$0:Lcom/google/android/gm/GviewActivity;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 158
    iget-object v0, p0, Lcom/google/android/gm/GviewActivity$3;->this$0:Lcom/google/android/gm/GviewActivity;

    # getter for: Lcom/google/android/gm/GviewActivity;->mProgressDialogCreated:Z
    invoke-static {v0}, Lcom/google/android/gm/GviewActivity;->access$100(Lcom/google/android/gm/GviewActivity;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/google/android/gm/GviewActivity$3;->this$0:Lcom/google/android/gm/GviewActivity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/GviewActivity;->dismissDialog(I)V

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/GviewActivity$3;->this$0:Lcom/google/android/gm/GviewActivity;

    invoke-virtual {v0}, Lcom/google/android/gm/GviewActivity;->finish()V

    .line 162
    return-void
.end method
