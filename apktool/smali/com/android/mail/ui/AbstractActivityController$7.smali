.class Lcom/android/mail/ui/AbstractActivityController$7;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController;->confirmAndDelete(Ljava/util/Collection;ZILcom/android/mail/ui/DestructiveAction;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;

.field final synthetic val$action:Lcom/android/mail/ui/DestructiveAction;

.field final synthetic val$target:Ljava/util/Collection;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 0

    .prologue
    .line 1131
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$7;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iput-object p2, p0, Lcom/android/mail/ui/AbstractActivityController$7;->val$target:Ljava/util/Collection;

    iput-object p3, p0, Lcom/android/mail/ui/AbstractActivityController$7;->val$action:Lcom/android/mail/ui/DestructiveAction;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 1134
    const/4 v0, -0x1

    if-ne p2, v0, :cond_0

    .line 1135
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$7;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$7;->val$target:Ljava/util/Collection;

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController$7;->val$action:Lcom/android/mail/ui/DestructiveAction;

    invoke-virtual {v0, v1, v2, v3}, Lcom/android/mail/ui/AbstractActivityController;->delete(ILjava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 1137
    :cond_0
    return-void
.end method
