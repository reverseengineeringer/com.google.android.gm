.class Lcom/android/mail/ui/ConversationListFragment$2;
.super Ljava/lang/Object;
.source "ConversationListFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/android/mail/ui/ConversationListFragment;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/android/mail/ui/ConversationListFragment;


# direct methods
.method constructor <init>(Lcom/android/mail/ui/ConversationListFragment;)V
    .locals 0

    .prologue
    .line 327
    iput-object p1, p0, Lcom/android/mail/ui/ConversationListFragment$2;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 330
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment$2;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    # getter for: Lcom/android/mail/ui/ConversationListFragment;->mListView:Lcom/android/mail/ui/SwipeableListView;
    invoke-static {v0}, Lcom/android/mail/ui/ConversationListFragment;->access$500(Lcom/android/mail/ui/ConversationListFragment;)Lcom/android/mail/ui/SwipeableListView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/android/mail/ui/SwipeableListView;->invalidateViews()V

    .line 331
    iget-object v0, p0, Lcom/android/mail/ui/ConversationListFragment$2;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    # getter for: Lcom/android/mail/ui/ConversationListFragment;->mHandler:Landroid/os/Handler;
    invoke-static {v0}, Lcom/android/mail/ui/ConversationListFragment;->access$800(Lcom/android/mail/ui/ConversationListFragment;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lcom/android/mail/ui/ConversationListFragment$2;->this$0:Lcom/android/mail/ui/ConversationListFragment;

    # getter for: Lcom/android/mail/ui/ConversationListFragment;->mUpdateTimestampsRunnable:Ljava/lang/Runnable;
    invoke-static {v1}, Lcom/android/mail/ui/ConversationListFragment;->access$600(Lcom/android/mail/ui/ConversationListFragment;)Ljava/lang/Runnable;

    move-result-object v1

    # getter for: Lcom/android/mail/ui/ConversationListFragment;->TIMESTAMP_UPDATE_INTERVAL:I
    invoke-static {}, Lcom/android/mail/ui/ConversationListFragment;->access$700()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 332
    return-void
.end method
