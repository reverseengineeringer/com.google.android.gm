.class Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->performAction()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/mail/ui/AbstractActivityController$ConversationAction;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)V
    .locals 0

    .prologue
    .line 2101
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;->this$1:Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 2104
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;->this$1:Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    iget-object v0, v0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    new-instance v1, Lcom/android/mail/ui/ToastBarOperation;

    iget-object v2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;->this$1:Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    # getter for: Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;
    invoke-static {v2}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->access$100(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->size()I

    move-result v2

    iget-object v3, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;->this$1:Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    # getter for: Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mAction:I
    invoke-static {v3}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->access$200(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)I

    move-result v3

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;->this$1:Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    # getter for: Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mIsSelectedSet:Z
    invoke-static {v5}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->access$300(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)Z

    move-result v5

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/android/mail/ui/ToastBarOperation;-><init>(IIIZ)V

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AbstractActivityController;->onUndoAvailable(Lcom/android/mail/ui/ToastBarOperation;)V

    .line 2106
    return-void
.end method
