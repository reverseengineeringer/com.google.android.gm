.class Lcom/android/mail/browse/SyncErrorDialogFragment$2;
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
    .line 46
    iput-object p1, p0, Lcom/android/mail/browse/SyncErrorDialogFragment$2;->this$0:Lcom/android/mail/browse/SyncErrorDialogFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "whichButton"    # I

    .prologue
    .line 48
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    .line 49
    return-void
.end method
