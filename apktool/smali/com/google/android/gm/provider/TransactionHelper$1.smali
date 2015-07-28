.class Lcom/google/android/gm/provider/TransactionHelper$1;
.super Ljava/lang/ThreadLocal;
.source "TransactionHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/TransactionHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ThreadLocal",
        "<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/TransactionHelper;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/TransactionHelper;)V
    .locals 0

    .prologue
    .line 21
    iput-object p1, p0, Lcom/google/android/gm/provider/TransactionHelper$1;->this$0:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method


# virtual methods
.method protected initialValue()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 23
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    return-object v0
.end method

.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 21
    invoke-virtual {p0}, Lcom/google/android/gm/provider/TransactionHelper$1;->initialValue()Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method
