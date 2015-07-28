.class Lcom/google/android/gm/provider/GmailTransactionListener;
.super Ljava/lang/Object;
.source "GmailTransactionListener.java"

# interfaces
.implements Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;
    }
.end annotation


# instance fields
.field private final DEBUG:Z

.field private final mAccount:Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field private final mDb:Landroid/database/sqlite/SQLiteDatabase;

.field private final mEngine:Lcom/google/android/gm/provider/MailEngine;

.field private final mState:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;",
            ">;"
        }
    .end annotation
.end field

.field private mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "engine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p3, "account"    # Ljava/lang/String;

    .prologue
    .line 99
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 37
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->DEBUG:Z

    .line 100
    iput-object p1, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mContext:Landroid/content/Context;

    .line 101
    iput-object p3, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mAccount:Ljava/lang/String;

    .line 102
    iput-object p2, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    .line 103
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 105
    new-instance v0, Lcom/google/android/gm/provider/GmailTransactionListener$1;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/GmailTransactionListener$1;-><init>(Lcom/google/android/gm/provider/GmailTransactionListener;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mState:Ljava/lang/ThreadLocal;

    .line 111
    return-void
.end method

.method private getConversationIdsSet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 256
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mState:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;

    iget-object v0, v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mConversationIds:Ljava/util/Set;

    return-object v0
.end method

.method private getLabelIdsSet()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 260
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mState:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;

    iget-object v0, v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mLabelIds:Ljava/util/Set;

    return-object v0
.end method


# virtual methods
.method public addConversationToNotify(J)V
    .locals 6
    .param p1, "conversationId"    # J

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 118
    iget-object v1, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_1

    .line 119
    const-string v1, "Gmail"

    const-string v2, "Must already be in a transaction with listener to add conversation to notify. (id=%d)"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 127
    :cond_0
    :goto_0
    return-void

    .line 123
    :cond_1
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailTransactionListener;->getConversationIdsSet()Ljava/util/Set;

    move-result-object v1

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-interface {v1, v2}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    move-result v0

    .line 124
    .local v0, "added":Z
    if-eqz v0, :cond_0

    .line 125
    const-string v1, "Gmail"

    const-string v2, "adding convId (%d) to notify"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public addLabelToNotify(Ljava/util/Set;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 130
    iget-object v1, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_1

    .line 131
    const-string v1, "Gmail"

    const-string v2, "Must already be in a transaction with listener to add label to notify. (ids=%s)"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 139
    :cond_0
    :goto_0
    return-void

    .line 135
    :cond_1
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailTransactionListener;->getLabelIdsSet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1, p1}, Ljava/util/Set;->addAll(Ljava/util/Collection;)Z

    move-result v0

    .line 136
    .local v0, "added":Z
    if-eqz v0, :cond_0

    .line 137
    const-string v1, "Gmail"

    const-string v2, "adding labelIds (%s) to notify"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public enableGmailAccountNotifications(Z)V
    .locals 6
    .param p1, "scheduleSync"    # Z

    .prologue
    const/4 v3, 0x1

    .line 142
    iget-object v1, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v1}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v1

    if-nez v1, :cond_1

    .line 143
    const-string v1, "Gmail"

    const-string v2, "Must already be in a transaction with listener to enable notifications for account %s."

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mAccount:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v1, v2, v3}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 154
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    iget-object v1, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mState:Ljava/lang/ThreadLocal;

    invoke-virtual {v1}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;

    .line 148
    .local v0, "state":Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;
    iput-boolean v3, v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mSendGmailAccountNotifications:Z

    .line 151
    if-eqz p1, :cond_0

    iget-boolean v1, v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mScheduleSyncOnAccountNotification:Z

    if-nez v1, :cond_0

    .line 152
    iput-boolean v3, v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mScheduleSyncOnAccountNotification:Z

    goto :goto_0
.end method

.method public onBegin()V
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mAccount:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/MailIndexerService;->onContentProviderAccess(Ljava/lang/String;)V

    .line 165
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    invoke-interface {v0}, Landroid/database/sqlite/SQLiteTransactionListener;->onBegin()V

    .line 168
    :cond_0
    return-void
.end method

.method public onCommit()V
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    if-eqz v0, :cond_0

    .line 185
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    invoke-interface {v0}, Landroid/database/sqlite/SQLiteTransactionListener;->onCommit()V

    .line 187
    :cond_0
    return-void
.end method

.method public onCommitCompleted(Z)V
    .locals 10
    .param p1, "suppressUiNotifications"    # Z

    .prologue
    const/4 v9, 0x0

    .line 208
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v5}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v5

    if-nez v5, :cond_3

    .line 209
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailTransactionListener;->getConversationIdsSet()Ljava/util/Set;

    move-result-object v1

    .line 210
    .local v1, "conversationIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    if-nez p1, :cond_1

    .line 211
    invoke-interface {v1}, Ljava/util/Set;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_0

    .line 212
    const-string v5, "Gmail"

    const-string v6, "Outermost commit complete, notifying on conversations: %s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    aput-object v1, v7, v9

    invoke-static {v5, v6, v7}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 214
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    .line 215
    .local v0, "conversationId":Ljava/lang/Long;
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mAccount:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    invoke-static {v5, v6, v7, v8}, Lcom/google/android/gm/provider/UiProvider;->onConversationChanged(Landroid/content/Context;Ljava/lang/String;J)V

    goto :goto_0

    .line 218
    .end local v0    # "conversationId":Ljava/lang/Long;
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_0
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mContext:Landroid/content/Context;

    iget-object v6, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mAccount:Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/google/android/gm/provider/UiProvider;->broadcastAccountChangeNotification(Landroid/content/Context;Ljava/lang/String;)V

    .line 220
    :cond_1
    invoke-interface {v1}, Ljava/util/Set;->clear()V

    .line 223
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailTransactionListener;->getLabelIdsSet()Ljava/util/Set;

    move-result-object v3

    .line 224
    .local v3, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v5, v3}, Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotificationsImpl(Ljava/util/Set;)V

    .line 225
    invoke-interface {v3}, Ljava/util/Set;->clear()V

    .line 227
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mState:Ljava/lang/ThreadLocal;

    invoke-virtual {v5}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;

    .line 228
    .local v4, "state":Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;
    iget-boolean v5, v4, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mSendGmailAccountNotifications:Z

    if-eqz v5, :cond_2

    .line 229
    iget-object v5, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    iget-boolean v6, v4, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mScheduleSyncOnAccountNotification:Z

    invoke-virtual {v5, v6}, Lcom/google/android/gm/provider/MailEngine;->sendAccountNotifications(Z)V

    .line 231
    :cond_2
    iput-boolean v9, v4, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mSendGmailAccountNotifications:Z

    .line 232
    iput-boolean v9, v4, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;->mScheduleSyncOnAccountNotification:Z

    .line 234
    .end local v1    # "conversationIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v3    # "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v4    # "state":Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;
    :cond_3
    return-void
.end method

.method public onRollback()V
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    if-eqz v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    invoke-interface {v0}, Landroid/database/sqlite/SQLiteTransactionListener;->onRollback()V

    .line 201
    :cond_0
    return-void
.end method

.method public onRollbackCompleted()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 238
    iget-object v2, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteDatabase;->inTransaction()Z

    move-result v2

    if-nez v2, :cond_2

    .line 239
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailTransactionListener;->getConversationIdsSet()Ljava/util/Set;

    move-result-object v0

    .line 240
    .local v0, "conversationIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 241
    const-string v2, "Gmail"

    const-string v3, "Rolled back outermost conversation commit, NOT notifying on: %s"

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 244
    :cond_0
    invoke-interface {v0}, Ljava/util/Set;->clear()V

    .line 246
    invoke-direct {p0}, Lcom/google/android/gm/provider/GmailTransactionListener;->getLabelIdsSet()Ljava/util/Set;

    move-result-object v1

    .line 247
    .local v1, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-interface {v1}, Ljava/util/Set;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 248
    const-string v2, "Gmail"

    const-string v3, "Rolled back outermost label commit, NOT notifying on: %s"

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 251
    :cond_1
    invoke-interface {v1}, Ljava/util/Set;->clear()V

    .line 253
    .end local v0    # "conversationIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v1    # "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    :cond_2
    return-void
.end method

.method public setTestTransactionListener(Landroid/database/sqlite/SQLiteTransactionListener;)V
    .locals 0
    .param p1, "testListener"    # Landroid/database/sqlite/SQLiteTransactionListener;

    .prologue
    .line 114
    iput-object p1, p0, Lcom/google/android/gm/provider/GmailTransactionListener;->mTestTransactionListener:Landroid/database/sqlite/SQLiteTransactionListener;

    .line 115
    return-void
.end method
