.class public Lcom/android/mail/browse/SyncErrorDialogFragment;
.super Landroid/app/DialogFragment;
.source "SyncErrorDialogFragment.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Landroid/app/DialogFragment;-><init>()V

    return-void
.end method

.method public static newInstance()Lcom/android/mail/browse/SyncErrorDialogFragment;
    .locals 1

    .prologue
    .line 36
    new-instance v0, Lcom/android/mail/browse/SyncErrorDialogFragment;

    invoke-direct {v0}, Lcom/android/mail/browse/SyncErrorDialogFragment;-><init>()V

    .line 37
    .local v0, "frag":Lcom/android/mail/browse/SyncErrorDialogFragment;
    return-object v0
.end method


# virtual methods
.method public onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 42
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-virtual {p0}, Lcom/android/mail/browse/SyncErrorDialogFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    const v1, 0x7f0c00f8

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00f9

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00d2

    new-instance v2, Lcom/android/mail/browse/SyncErrorDialogFragment$2;

    invoke-direct {v2, p0}, Lcom/android/mail/browse/SyncErrorDialogFragment$2;-><init>(Lcom/android/mail/browse/SyncErrorDialogFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    const v1, 0x7f0c00fa

    new-instance v2, Lcom/android/mail/browse/SyncErrorDialogFragment$1;

    invoke-direct {v2, p0}, Lcom/android/mail/browse/SyncErrorDialogFragment$1;-><init>(Lcom/android/mail/browse/SyncErrorDialogFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    return-object v0
.end method
