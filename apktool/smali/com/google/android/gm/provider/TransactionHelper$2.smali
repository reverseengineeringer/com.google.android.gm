.class Lcom/google/android/gm/provider/TransactionHelper$2;
.super Ljava/lang/ThreadLocal;
.source "TransactionHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/TransactionHelper;-><init>(Landroid/database/sqlite/SQLiteDatabase;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

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


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/TransactionHelper;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/TransactionHelper;)V
    .locals 0

    .prologue
    .line 46
    iput-object p1, p0, Lcom/google/android/gm/provider/TransactionHelper$2;->this$0:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method


# virtual methods
.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 46
    invoke-virtual {p0}, Lcom/google/android/gm/provider/TransactionHelper$2;->initialValue()Ljava/util/Stack;

    move-result-object v0

    return-object v0
.end method

.method protected initialValue()Ljava/util/Stack;
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
    .line 49
    new-instance v0, Ljava/util/Stack;

    invoke-direct {v0}, Ljava/util/Stack;-><init>()V

    return-object v0
.end method
