.class public Lcom/google/android/gm/provider/TransactionHelper;
.super Ljava/lang/Object;
.source "TransactionHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;,
        Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;
    }
.end annotation


# instance fields
.field private final mDb:Landroid/database/sqlite/SQLiteDatabase;

.field private final mStates:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/util/Stack",
            "<",
            "Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;",
            ">;>;"
        }
    .end annotation
.end field

.field private final mSuppressUiNotifications:Ljava/lang/ThreadLocal;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ThreadLocal",
            "<",
            "Ljava/lang/Boolean;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 1
    .param p1, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 44
    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Lcom/google/android/gm/provider/TransactionHelper$1;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/TransactionHelper$1;-><init>(Lcom/google/android/gm/provider/TransactionHelper;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mSuppressUiNotifications:Ljava/lang/ThreadLocal;

    .line 45
    iput-object p1, p0, Lcom/google/android/gm/provider/TransactionHelper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    .line 46
    new-instance v0, Lcom/google/android/gm/provider/TransactionHelper$2;

    invoke-direct {v0, p0}, Lcom/google/android/gm/provider/TransactionHelper$2;-><init>(Lcom/google/android/gm/provider/TransactionHelper;)V

    iput-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mStates:Ljava/lang/ThreadLocal;

    .line 52
    return-void
.end method

.method private getStates()Ljava/util/Stack;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Stack",
            "<",
            "Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;",
            ">;"
        }
    .end annotation

    .prologue
    .line 119
    iget-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mStates:Ljava/lang/ThreadLocal;

    invoke-virtual {v0}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Stack;

    return-object v0
.end method


# virtual methods
.method public beginTransactionNonExclusive()V
    .locals 3

    .prologue
    .line 64
    invoke-direct {p0}, Lcom/google/android/gm/provider/TransactionHelper;->getStates()Ljava/util/Stack;

    move-result-object v0

    new-instance v1, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;-><init>(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    invoke-virtual {v0, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 65
    iget-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 66
    return-void
.end method

.method public beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;

    .prologue
    .line 74
    invoke-direct {p0}, Lcom/google/android/gm/provider/TransactionHelper;->getStates()Ljava/util/Stack;

    move-result-object v0

    new-instance v1, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;

    invoke-direct {v1, p1}, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;-><init>(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    invoke-virtual {v0, v1}, Ljava/util/Stack;->push(Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    iget-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0, p1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionWithListenerNonExclusive(Landroid/database/sqlite/SQLiteTransactionListener;)V

    .line 76
    return-void
.end method

.method public endTransaction()V
    .locals 6

    .prologue
    const/4 v4, 0x1

    .line 91
    iget-object v3, p0, Lcom/google/android/gm/provider/TransactionHelper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 93
    invoke-direct {p0}, Lcom/google/android/gm/provider/TransactionHelper;->getStates()Ljava/util/Stack;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Stack;->pop()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;

    .line 94
    .local v0, "state":Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;
    iget-boolean v3, v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mSuccess:Z

    if-eqz v3, :cond_2

    iget-boolean v3, v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mChildFailed:Z

    if-nez v3, :cond_2

    move v2, v4

    .line 95
    .local v2, "successful":Z
    :goto_0
    iget-object v3, v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mListener:Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;

    if-eqz v3, :cond_0

    .line 96
    if-eqz v2, :cond_3

    .line 100
    iget-object v5, v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mListener:Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;

    iget-object v3, p0, Lcom/google/android/gm/provider/TransactionHelper;->mSuppressUiNotifications:Ljava/lang/ThreadLocal;

    invoke-virtual {v3}, Ljava/lang/ThreadLocal;->get()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-interface {v5, v3}, Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;->onCommitCompleted(Z)V

    .line 105
    :cond_0
    :goto_1
    if-nez v2, :cond_1

    .line 106
    invoke-direct {p0}, Lcom/google/android/gm/provider/TransactionHelper;->getStates()Ljava/util/Stack;

    move-result-object v1

    .line 108
    .local v1, "states":Ljava/util/Stack;, "Ljava/util/Stack<Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;>;"
    invoke-virtual {v1}, Ljava/util/Stack;->empty()Z

    move-result v3

    if-nez v3, :cond_1

    .line 109
    invoke-virtual {v1}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;

    iput-boolean v4, v3, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mChildFailed:Z

    .line 112
    .end local v1    # "states":Ljava/util/Stack;, "Ljava/util/Stack<Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;>;"
    :cond_1
    return-void

    .line 94
    .end local v2    # "successful":Z
    :cond_2
    const/4 v2, 0x0

    goto :goto_0

    .line 102
    .restart local v2    # "successful":Z
    :cond_3
    iget-object v3, v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mListener:Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;

    invoke-interface {v3}, Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;->onRollbackCompleted()V

    goto :goto_1
.end method

.method public setTransactionSuccessful()V
    .locals 2

    .prologue
    .line 86
    iget-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 87
    invoke-direct {p0}, Lcom/google/android/gm/provider/TransactionHelper;->getStates()Ljava/util/Stack;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Stack;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/google/android/gm/provider/TransactionHelper$ThreadTransactionState;->mSuccess:Z

    .line 88
    return-void
.end method

.method suppressUiNotifications()V
    .locals 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/google/android/gm/provider/TransactionHelper;->mSuppressUiNotifications:Ljava/lang/ThreadLocal;

    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Ljava/lang/ThreadLocal;->set(Ljava/lang/Object;)V

    .line 83
    return-void
.end method
