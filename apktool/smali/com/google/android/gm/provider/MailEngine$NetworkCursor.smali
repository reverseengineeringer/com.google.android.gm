.class Lcom/google/android/gm/provider/MailEngine$NetworkCursor;
.super Landroid/database/sqlite/SQLiteCursor;
.source "MailEngine.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "NetworkCursor"
.end annotation


# instance fields
.field mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

.field protected final mLogicLock:Ljava/lang/Object;

.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method public constructor <init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;)V
    .locals 1
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p3, "driver"    # Landroid/database/sqlite/SQLiteCursorDriver;
    .param p4, "editTable"    # Ljava/lang/String;
    .param p5, "query"    # Landroid/database/sqlite/SQLiteQuery;
    .param p6, "logic"    # Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    .prologue
    .line 5495
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->this$0:Lcom/google/android/gm/provider/MailEngine;

    .line 5496
    invoke-direct {p0, p2, p3, p4, p5}, Landroid/database/sqlite/SQLiteCursor;-><init>(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteCursorDriver;Ljava/lang/String;Landroid/database/sqlite/SQLiteQuery;)V

    .line 5492
    new-instance v0, Ljava/lang/Object;

    invoke-direct/range {v0 .. v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    .line 5497
    iput-object p6, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    .line 5498
    return-void
.end method


# virtual methods
.method public final getExtras()Landroid/os/Bundle;
    .locals 2

    .prologue
    .line 5502
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v1

    .line 5503
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    monitor-exit v1

    return-object v0

    .line 5504
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getWantsAllOnMoveCalls()Z
    .locals 2

    .prologue
    .line 5516
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v1

    .line 5517
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->getWantsAllOnMoveCalls()Z

    move-result v0

    monitor-exit v1

    return v0

    .line 5518
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public declared-synchronized respond(Landroid/os/Bundle;)Landroid/os/Bundle;
    .locals 2
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 5509
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogicLock:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 5510
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$NetworkCursor;->mLogic:Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailEngine$NetworkCursorLogic;->respond(Landroid/os/Bundle;)Landroid/os/Bundle;

    move-result-object v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit p0

    return-object v0

    .line 5511
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 5509
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method
