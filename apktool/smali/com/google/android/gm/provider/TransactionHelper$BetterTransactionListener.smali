.class public interface abstract Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;
.super Ljava/lang/Object;
.source "TransactionHelper.java"

# interfaces
.implements Landroid/database/sqlite/SQLiteTransactionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/TransactionHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x609
    name = "BetterTransactionListener"
.end annotation


# virtual methods
.method public abstract onCommitCompleted(Z)V
.end method

.method public abstract onRollbackCompleted()V
.end method
