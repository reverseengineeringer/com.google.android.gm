.class Lcom/android/mail/ui/AbstractConversationViewFragment$3;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;->dismissLoadingStatus(Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

.field final synthetic val$doAfter:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;Ljava/lang/Runnable;)V
    .locals 0
    .param p2, "x0"    # Ljava/lang/String;

    .prologue
    .line 256
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$3;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iput-object p3, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$3;->val$doAfter:Ljava/lang/Runnable;

    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 2

    .prologue
    .line 259
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$3;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$3;->val$doAfter:Ljava/lang/Runnable;

    # invokes: Lcom/android/mail/ui/AbstractConversationViewFragment;->dismiss(Ljava/lang/Runnable;)V
    invoke-static {v0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$300(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/Runnable;)V

    .line 260
    return-void
.end method
