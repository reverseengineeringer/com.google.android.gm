.class Lcom/android/mail/browse/SyncErrorDialogFragment$1;
.super Ljava/lang/Object;
.source "SyncErrorDialogFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/browse/SyncErrorDialogFragment;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/SyncErrorDialogFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/SyncErrorDialogFragment;)V
    .locals 0

    .prologue
    .line 53
    iput-object p1, p0, Lcom/android/mail/browse/SyncErrorDialogFragment$1;->this$0:Lcom/android/mail/browse/SyncErrorDialogFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 2
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "whichButton"    # I

    .prologue
    .line 55
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.settings.INTERNAL_STORAGE_SETTINGS"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 57
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 58
    iget-object v1, p0, Lcom/android/mail/browse/SyncErrorDialogFragment$1;->this$0:Lcom/android/mail/browse/SyncErrorDialogFragment;

    invoke-virtual {v1, v0}, Lcom/android/mail/browse/SyncErrorDialogFragment;->startActivity(Landroid/content/Intent;)V

    .line 59
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 60
    return-void
.end method
