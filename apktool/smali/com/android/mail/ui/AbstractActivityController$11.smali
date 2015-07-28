.class Lcom/android/mail/ui/AbstractActivityController$11;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController;->getStorageErrorClickedListener()Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;)V
    .locals 0

    .prologue
    .line 2800
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$11;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionClicked()V
    .locals 1

    .prologue
    .line 2803
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$11;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # invokes: Lcom/android/mail/ui/AbstractActivityController;->showStorageErrorDialog()V
    invoke-static {v0}, Lcom/android/mail/ui/AbstractActivityController;->access$1100(Lcom/android/mail/ui/AbstractActivityController;)V

    .line 2804
    return-void
.end method
