.class Lcom/android/mail/browse/SelectedConversationsActionMenu$2;
.super Ljava/lang/Object;
.source "SelectedConversationsActionMenu.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/browse/SelectedConversationsActionMenu;->performDestructiveAction(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/browse/SelectedConversationsActionMenu;

.field final synthetic val$action:I

.field final synthetic val$conversations:Ljava/util/Collection;

.field final synthetic val$destructiveAction:Lcom/android/mail/ui/DestructiveAction;

.field final synthetic val$views:Ljava/util/Collection;


# direct methods
.method constructor <init>(Lcom/android/mail/browse/SelectedConversationsActionMenu;ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    .locals 0

    .prologue
    .line 271
    iput-object p1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->this$0:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    iput p2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$action:I

    iput-object p3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$conversations:Ljava/util/Collection;

    iput-object p4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$views:Ljava/util/Collection;

    iput-object p5, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$destructiveAction:Lcom/android/mail/ui/DestructiveAction;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 274
    iget-object v0, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->this$0:Lcom/android/mail/browse/SelectedConversationsActionMenu;

    iget v1, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$action:I

    iget-object v2, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$conversations:Ljava/util/Collection;

    iget-object v3, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$views:Ljava/util/Collection;

    iget-object v4, p0, Lcom/android/mail/browse/SelectedConversationsActionMenu$2;->val$destructiveAction:Lcom/android/mail/ui/DestructiveAction;

    # invokes: Lcom/android/mail/browse/SelectedConversationsActionMenu;->destroy(ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V
    invoke-static {v0, v1, v2, v3, v4}, Lcom/android/mail/browse/SelectedConversationsActionMenu;->access$100(Lcom/android/mail/browse/SelectedConversationsActionMenu;ILjava/util/Collection;Ljava/util/Collection;Lcom/android/mail/ui/DestructiveAction;)V

    .line 275
    return-void
.end method
