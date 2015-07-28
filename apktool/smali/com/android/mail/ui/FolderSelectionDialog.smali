.class public abstract Lcom/android/mail/ui/FolderSelectionDialog;
.super Ljava/lang/Object;
.source "FolderSelectionDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnDismissListener;


# static fields
.field private static sDialogShown:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static isShown()Z
    .locals 1

    .prologue
    .line 29
    sget-boolean v0, Lcom/android/mail/ui/FolderSelectionDialog;->sDialogShown:Z

    return v0
.end method

.method public static setDialogDismissed()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 33
    const-string v0, "Gmail"

    const-string v1, "Folder Selection dialog dismissed"

    new-array v2, v3, [Ljava/lang/Object;

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 34
    sput-boolean v3, Lcom/android/mail/ui/FolderSelectionDialog;->sDialogShown:Z

    .line 35
    return-void
.end method


# virtual methods
.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 43
    invoke-static {}, Lcom/android/mail/ui/FolderSelectionDialog;->setDialogDismissed()V

    .line 44
    return-void
.end method

.method public show()V
    .locals 1

    .prologue
    .line 38
    const/4 v0, 0x1

    sput-boolean v0, Lcom/android/mail/ui/FolderSelectionDialog;->sDialogShown:Z

    .line 39
    return-void
.end method
