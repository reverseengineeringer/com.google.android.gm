.class Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;
.super Landroid/database/DataSetObserver;
.source "AbstractConversationViewFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractConversationViewFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MarkReadObserver"
.end annotation


# instance fields
.field private final mListController:Lcom/android/mail/ui/ConversationUpdater;

.field final synthetic this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;


# direct methods
.method private constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/ConversationUpdater;)V
    .locals 0
    .param p2, "listController"    # Lcom/android/mail/ui/ConversationUpdater;

    .prologue
    .line 754
    iput-object p1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    .line 755
    iput-object p2, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->mListController:Lcom/android/mail/ui/ConversationUpdater;

    .line 756
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/ConversationUpdater;Lcom/android/mail/ui/AbstractConversationViewFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/ui/AbstractConversationViewFragment;
    .param p2, "x1"    # Lcom/android/mail/ui/ConversationUpdater;
    .param p3, "x2"    # Lcom/android/mail/ui/AbstractConversationViewFragment$1;

    .prologue
    .line 751
    invoke-direct {p0, p1, p2}, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;-><init>(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/ConversationUpdater;)V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 6

    .prologue
    .line 760
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->mListController:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0}, Lcom/android/mail/ui/ConversationUpdater;->getConversationListCursor()Lcom/android/mail/browse/ConversationCursor;

    move-result-object v0

    if-nez v0, :cond_0

    .line 769
    :goto_0
    return-void

    .line 765
    :cond_0
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->mListController:Lcom/android/mail/ui/ConversationUpdater;

    invoke-interface {v0, p0}, Lcom/android/mail/ui/ConversationUpdater;->unregisterConversationListObserver(Landroid/database/DataSetObserver;)V

    .line 766
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    const/4 v1, 0x0

    # setter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->mMarkReadObserver:Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;
    invoke-static {v0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$1002(Lcom/android/mail/ui/AbstractConversationViewFragment;Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;)Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;

    .line 767
    # getter for: Lcom/android/mail/ui/AbstractConversationViewFragment;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/android/mail/ui/AbstractConversationViewFragment;->access$600()Ljava/lang/String;

    move-result-object v0

    const-string v1, "running deferred conv mark read on open, id=%d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractConversationViewFragment;->mConversation:Lcom/android/mail/providers/Conversation;

    iget-wide v4, v4, Lcom/android/mail/providers/Conversation;->id:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 768
    iget-object v0, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->this$0:Lcom/android/mail/ui/AbstractConversationViewFragment;

    iget-object v1, p0, Lcom/android/mail/ui/AbstractConversationViewFragment$MarkReadObserver;->mListController:Lcom/android/mail/ui/ConversationUpdater;

    invoke-virtual {v0, v1}, Lcom/android/mail/ui/AbstractConversationViewFragment;->markReadOnSeen(Lcom/android/mail/ui/ConversationUpdater;)V

    goto :goto_0
.end method
