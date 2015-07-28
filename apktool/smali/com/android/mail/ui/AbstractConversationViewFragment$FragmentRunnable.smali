.class public abstract Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;
.super Ljava/lang/Object;
.source "AbstractConversationViewFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x404
    name = "FragmentRunnable"
.end annotation


# instance fields
.field private final mOpName:Ljava/lang/String;

.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Ljava/lang/String;)V
    .locals 0
    .param p2, "opName"    # Ljava/lang/String;

    .prologue
    .line 782
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 783
    iput-object p2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;->mOpName:Ljava/lang/String;

    .line 784
    return-void
.end method


# virtual methods
.method public abstract go()V
.end method

.method public run()V
    .locals 5

    .prologue
    .line 790
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-virtual {v0}, Lcom/android/mail/ui/AbstractConversationViewFragment;->isAdded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 791
    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$600()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Unable to run op=\'%s\' b/c fragment is not attached: %s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;->mOpName:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 796
    :goto_0
    return-void

    .line 795
    :cond_0
    invoke-virtual {p0}, Lcom/android/mail/ui/AbstractConversationViewFragment$FragmentRunnable;->go()V

    goto :goto_0
.end method
