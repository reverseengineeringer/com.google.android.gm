.class public Lcom/android/mail/ui/AbstractActivityController$ConversationAction;
.super Ljava/lang/Object;
.source "AbstractActivityController.java"

# interfaces
.implements Lcom/android/mail/ui/DestructiveAction;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/ui/AbstractActivityController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ConversationAction"
.end annotation


# instance fields
.field private final mAction:I

.field private mCompleted:Z

.field private final mIsSelectedSet:Z

.field private final mTarget:Ljava/util/Collection;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/android/mail/ui/AbstractActivityController;


# direct methods
.method public constructor <init>(Lcom/android/mail/ui/AbstractActivityController;ILjava/util/Collection;Z)V
    .locals 1
    .param p2, "action"    # I
    .param p4, "isBatch"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/Collection",
            "<",
            "Lcom/android/mail/providers/Conversation;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 2005
    .local p3, "target":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/android/mail/providers/Conversation;>;"
    iput-object p1, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 2006
    iput p2, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mAction:I

    .line 2007
    invoke-static {p3}, Lcom/google/common/collect/ImmutableList;->copyOf(Ljava/util/Collection;)Lcom/google/common/collect/ImmutableList;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    .line 2008
    iput-boolean p4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mIsSelectedSet:Z

    .line 2009
    return-void
.end method

.method static synthetic access$100(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)Ljava/util/Collection;
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    .prologue
    .line 1985
    iget-object v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    return-object v0
.end method

.method static synthetic access$200(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)I
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    .prologue
    .line 1985
    iget v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mAction:I

    return v0
.end method

.method static synthetic access$300(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)Z
    .locals 1
    .param p0, "x0"    # Lcom/android/mail/ui/AbstractActivityController$ConversationAction;

    .prologue
    .line 1985
    iget-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mIsSelectedSet:Z

    return v0
.end method

.method private declared-synchronized isPerformed()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 2120
    monitor-enter p0

    :try_start_0
    iget-boolean v1, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mCompleted:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v1, :cond_0

    .line 2124
    :goto_0
    monitor-exit p0

    return v0

    .line 2123
    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mCompleted:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 2124
    const/4 v0, 0x0

    goto :goto_0

    .line 2120
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method public performAction()V
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 2017
    invoke-direct {p0}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->isPerformed()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 2113
    :cond_0
    :goto_0
    return-void

    .line 2020
    :cond_1
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mAccount:Lcom/android/mail/providers/Account;

    const/16 v5, 0x4000

    invoke-virtual {v4, v5}, Lcom/android/mail/providers/Account;->supportsCapability(I)Z

    move-result v3

    .line 2023
    .local v3, "undoEnabled":Z
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const/4 v5, 0x3

    invoke-static {v4, v5}, Lcom/android/mail/utils/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 2024
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "ConversationAction.performAction():\nmTarget=%s\nCurrent=%s"

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-static {v7}, Lcom/android/mail/providers/Conversation;->toString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v7, v7, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2029
    :cond_2
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    if-nez v4, :cond_3

    .line 2030
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "null ConversationCursor in ConversationAction.performAction():\nmTarget=%s\nCurrent=%s"

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-static {v7}, Lcom/android/mail/providers/Conversation;->toString(Ljava/util/Collection;)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    iget-object v7, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v7, v7, Lcom/android/mail/ui/AbstractActivityController;->mCurrentConversation:Lcom/android/mail/providers/Conversation;

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0

    .line 2036
    :cond_3
    iget v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mAction:I

    packed-switch v4, :pswitch_data_0

    .line 2100
    :cond_4
    :goto_1
    :pswitch_0
    if-eqz v3, :cond_5

    .line 2101
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mHandler:Landroid/os/Handler;

    new-instance v5, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;

    invoke-direct {v5, p0}, Lcom/android/mail/ui/AbstractActivityController$ConversationAction$1;-><init>(Lcom/android/mail/ui/AbstractActivityController$ConversationAction;)V

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # getter for: Lcom/android/mail/ui/AbstractActivityController;->mShowUndoBarDelay:I
    invoke-static {v6}, Lcom/android/mail/ui/AbstractActivityController;->access$400(Lcom/android/mail/ui/AbstractActivityController;)I

    move-result v6

    int-to-long v6, v6

    invoke-virtual {v4, v5, v6, v7}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 2109
    :cond_5
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    invoke-virtual {v4}, Lcom/android/mail/ui/AbstractActivityController;->refreshConversationList()V

    .line 2110
    iget-boolean v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mIsSelectedSet:Z

    if-eqz v4, :cond_0

    .line 2111
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    # getter for: Lcom/android/mail/ui/AbstractActivityController;->mSelectedSet:Lcom/android/mail/ui/ConversationSelectionSet;
    invoke-static {v4}, Lcom/android/mail/ui/AbstractActivityController;->access$500(Lcom/android/mail/ui/AbstractActivityController;)Lcom/android/mail/ui/ConversationSelectionSet;

    move-result-object v4

    invoke-virtual {v4}, Lcom/android/mail/ui/ConversationSelectionSet;->clear()V

    goto :goto_0

    .line 2038
    :pswitch_1
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Archiving"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2039
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->archive(Landroid/content/Context;Ljava/util/Collection;)I

    goto :goto_1

    .line 2042
    :pswitch_2
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Deleting"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2043
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->delete(Landroid/content/Context;Ljava/util/Collection;)I

    .line 2044
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v5, 0x800

    invoke-virtual {v4, v5}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 2045
    const/4 v3, 0x0

    goto :goto_1

    .line 2049
    :pswitch_3
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Muting"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2050
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    const/16 v5, 0x100

    invoke-virtual {v4, v5}, Lcom/android/mail/providers/Folder;->supportsCapability(I)Z

    move-result v4

    if-eqz v4, :cond_6

    .line 2051
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_6

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/android/mail/providers/Conversation;

    .line 2052
    .local v0, "c":Lcom/android/mail/providers/Conversation;
    iput-boolean v9, v0, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    goto :goto_2

    .line 2055
    .end local v0    # "c":Lcom/android/mail/providers/Conversation;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_6
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->mute(Landroid/content/Context;Ljava/util/Collection;)I

    goto/16 :goto_1

    .line 2058
    :pswitch_4
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Reporting spam"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2059
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->reportSpam(Landroid/content/Context;Ljava/util/Collection;)I

    goto/16 :goto_1

    .line 2062
    :pswitch_5
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Marking not spam"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2063
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->reportNotSpam(Landroid/content/Context;Ljava/util/Collection;)I

    goto/16 :goto_1

    .line 2066
    :pswitch_6
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Reporting phishing"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2067
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->reportPhishing(Landroid/content/Context;Ljava/util/Collection;)I

    goto/16 :goto_1

    .line 2070
    :pswitch_7
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Removing star"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2072
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    sget-object v7, Lcom/android/mail/providers/UIProvider$ConversationColumns;->STARRED:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/android/mail/browse/ConversationCursor;->updateBoolean(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;Z)I

    goto/16 :goto_1

    .line 2076
    :pswitch_8
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Marking not-important"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2079
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v4, :cond_7

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v4}, Lcom/android/mail/providers/Folder;->isImportantOnly()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 2080
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_7

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Conversation;

    .line 2081
    .local v1, "conv":Lcom/android/mail/providers/Conversation;
    iput-boolean v9, v1, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    goto :goto_3

    .line 2084
    .end local v1    # "conv":Lcom/android/mail/providers/Conversation;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_7
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    sget-object v7, Lcom/android/mail/providers/UIProvider$ConversationColumns;->PRIORITY:Ljava/lang/String;

    invoke-virtual {v4, v5, v6, v7, v8}, Lcom/android/mail/browse/ConversationCursor;->updateInt(Landroid/content/Context;Ljava/util/Collection;Ljava/lang/String;I)I

    goto/16 :goto_1

    .line 2088
    :pswitch_9
    sget-object v4, Lcom/android/mail/ui/AbstractActivityController;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Discarding draft messages"

    new-array v6, v8, [Ljava/lang/Object;

    invoke-static {v4, v5, v6}, Lcom/android/mail/utils/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 2090
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    if-eqz v4, :cond_8

    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mFolder:Lcom/android/mail/providers/Folder;

    invoke-virtual {v4}, Lcom/android/mail/providers/Folder;->isDraft()Z

    move-result v4

    if-eqz v4, :cond_8

    .line 2091
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_8

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/android/mail/providers/Conversation;

    .line 2092
    .restart local v1    # "conv":Lcom/android/mail/providers/Conversation;
    iput-boolean v9, v1, Lcom/android/mail/providers/Conversation;->localDeleteOnUpdate:Z

    goto :goto_4

    .line 2095
    .end local v1    # "conv":Lcom/android/mail/providers/Conversation;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_8
    iget-object v4, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v4, v4, Lcom/android/mail/ui/AbstractActivityController;->mConversationListCursor:Lcom/android/mail/browse/ConversationCursor;

    iget-object v5, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->this$0:Lcom/android/mail/ui/AbstractActivityController;

    iget-object v5, v5, Lcom/android/mail/ui/AbstractActivityController;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/android/mail/ui/AbstractActivityController$ConversationAction;->mTarget:Ljava/util/Collection;

    invoke-virtual {v4, v5, v6}, Lcom/android/mail/browse/ConversationCursor;->discardDrafts(Landroid/content/Context;Ljava/util/Collection;)I

    .line 2097
    const/4 v3, 0x0

    goto/16 :goto_1

    .line 2036
    :pswitch_data_0
    .packed-switch 0x7f100123
        :pswitch_1
        :pswitch_0
        :pswitch_2
        :pswitch_9
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_8
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
    .end packed-switch
.end method
