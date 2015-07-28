.class Lcom/android/mail/ui/ConversationViewFragment$1$1;
.super Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/ConversationViewFragment$1;->onChanged()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/android/mail/ui/ConversationViewFragment$1;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationViewFragment$1;Ljava/lang/String;)V
    .locals 1
    .param p2, "x0"    # Ljava/lang/String;

    .prologue
    .line 174
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$1$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$1;

    iget-object v0, p1, Lcom/android/mail/ui/ConversationViewFragment$1;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0, v0, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public go()V
    .locals 5

    .prologue
    .line 177
    # getter for: Lcom/android/mail/ui/ConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/ConversationViewFragment;->access$200()Ljava/lang/String;

    move-result-object v0

    const-string v1, "CVF load observer fired, this=%s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/ConversationViewFragment$1$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$1;

    iget-object v4, v4, Lcom/android/mail/ui/ConversationViewFragment$1;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 179
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$1$1;->this$1:Lcom/android/mail/ui/ConversationViewFragment$1;

    iget-object v0, v0, Lcom/android/mail/ui/ConversationViewFragment$1;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    # invokes: Lcom/android/mail/ui/ConversationViewFragment;->handleDelayedConversationLoad()V
    invoke-static {v0}, Lcom/android/mail/ui/ConversationViewFragment;->access$300(Lcom/android/mail/ui/ConversationViewFragment;)V

    .line 180
    return-void
.end method
