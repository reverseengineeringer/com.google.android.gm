.class Lcom/android/mail/ui/AbstractActivityController$8;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController;->getUndoClickedListener(Lcom/android/mail/ui/AnimatedAdapter;)Lcom/android/mail/ui/ActionableToastBar$ActionClickedListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;

.field final synthetic val$listAdapter:Lcom/android/mail/ui/AnimatedAdapter;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController;Lcom/android/mail/ui/AnimatedAdapter;)V
    .locals 0

    .prologue
    .line 2701
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$8;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iput-object p2, p0, Lcom/android/mail/ui/AbstractActivityController$8;->val$listAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionClicked()V
    .locals 3

    .prologue
    .line 2704
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$8;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v0, v0, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    if-eqz v0, :cond_1

    .line 2709
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$8;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-eqz v0, :cond_0

    .line 2710
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$8;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractActivityController$8;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v1, v1, Lcom/android/mail/ui/AbstractActivityController;->mActivity:Lcom/android/mail/ui/ControllableActivity;

    invoke-interface {v1}, Lcom/android/mail/ui/ControllableActivity;->getActivityContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$8;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v2, v2, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    iget-object v2, v2, Lcom/android/mail/providers/Account;->undoUri:Landroid/net/Uri;

    invoke-virtual {v0, v1, v2}, Lcom/android/mail/browse/ConversationCursor;->undo(Landroid/content/Context;Landroid/net/Uri;)V

    .line 2713
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$8;->val$listAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    if-eqz v0, :cond_1

    .line 2714
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$8;->val$listAdapter:Lcom/android/mail/ui/AnimatedAdapter;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AnimatedAdapter;->setUndo(Z)V

    .line 2717
    :cond_1
    return-void
.end method
