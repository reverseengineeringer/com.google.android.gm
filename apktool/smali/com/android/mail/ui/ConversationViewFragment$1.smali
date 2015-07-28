.class Lcom/android/mail/ui/ConversationViewFragment$1;
.super Landroid/database/DataSetObserver;
.source "ConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/ConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationViewFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationViewFragment;)V
    .locals 0

    .prologue
    .line 171
    iput-object p1, p0, Lcom/android/mail/ui/ConversationViewFragment$1;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 3

    .prologue
    .line 174
    iget-object v0, p0, Lcom/android/mail/ui/ConversationViewFragment$1;->this$0:Lcom/android/mail/ui/ConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/ConversationViewFragment;->getHandler()Landroid/os/Handler;

    move-result-object v0

    new-instance v1, Lcom/android/mail/ui/ConversationViewFragment$1$1;

    const-string v2, "delayedConversationLoad"

    invoke-direct {v1, p0, v2}, Lcom/android/mail/ui/ConversationViewFragment$1$1;-><init>(Lcom/android/mail/ui/ConversationViewFragment$1;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 182
    return-void
.end method
