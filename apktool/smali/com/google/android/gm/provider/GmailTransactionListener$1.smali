.class Lcom/google/android/gm/provider/GmailTransactionListener$1;
.super Ljava/lang/ThreadLocal;
.source "GmailTransactionListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/GmailTransactionListener;-><init>(Landroid/content/Context;Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/ThreadLocal",
        "<",
        "Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/GmailTransactionListener;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/GmailTransactionListener;)V
    .locals 0

    .prologue
    .line 105
    iput-object p1, p0, Lcom/google/android/gm/provider/GmailTransactionListener$1;->this$0:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-direct {p0}, Ljava/lang/ThreadLocal;-><init>()V

    return-void
.end method


# virtual methods
.method protected initialValue()Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;
    .locals 2

    .prologue
    .line 108
    new-instance v0, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;

    iget-object v1, p0, Lcom/google/android/gm/provider/GmailTransactionListener$1;->this$0:Lcom/google/android/gm/provider/GmailTransactionListener;

    invoke-direct {v0, v1}, Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;-><init>(Lcom/google/android/gm/provider/GmailTransactionListener;)V

    return-object v0
.end method

.method protected bridge synthetic initialValue()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 105
    invoke-virtual {p0}, Lcom/google/android/gm/provider/GmailTransactionListener$1;->initialValue()Lcom/google/android/gm/provider/GmailTransactionListener$GmailTransactionState;

    move-result-object v0

    return-object v0
.end method
