.class Lcom/android/mail/ui/AbstractActivityController$9;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController;->getRetryClickedListener(Lcom/android/mail/providers/Folder;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;

.field final synthetic val$folder:Lcom/android/mail/providers/Folder;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/providers/Folder;)V
    .locals 0

    .prologue
    .line 2778
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$9;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iput-object p2, p0, Lcom/android/mail/ui/AbstractActivityController$9;->val$folder:Lcom/android/mail/providers/Folder;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionClicked()V
    .locals 2

    .prologue
    .line 2781
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$9;->val$folder:Lcom/android/mail/providers/Folder;

    iget-object v0, v1, Lcom/android/mail/providers/Folder;->refreshUri:Landroid/net/Uri;

    .line 2783
    .local v0, "uri":Landroid/net/Uri;
    if-eqz v0, :cond_0

    .line 2784
    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$9;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # invokes: Lcom/android/mail/ui/AbstractActivityController;->startAsyncRefreshTask(Landroid/net/Uri;)V
    invoke-static {v1, v0}, Lcom/android/mail/ui/AbstractActivityController;->access$900(Lcom/android/mail/ui/AbstractActivityController;Landroid/net/Uri;)V

    .line 2786
    :cond_0
    return-void
.end method
