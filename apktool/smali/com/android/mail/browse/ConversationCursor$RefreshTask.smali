.class Lcom/android/mail/browse/ConversationCursor$RefreshTask;
.super Landroid/os/AsyncTask;
.source "ConversationCursor.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/android/mail/browse/ConversationCursor;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RefreshTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private mCursor:Landroid/database/Cursor;

.field final synthetic this$0:Lcom/android/mail/browse/ConversationCursor;


# direct methods
.method private constructor <init>(Lcom/android/mail/browse/ConversationCursor;)V
    .locals 1

    .prologue
    .line 223
    iput-object p1, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 221
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->mCursor:Landroid/database/Cursor;

    .line 224
    return-void
.end method

.method synthetic constructor <init>(Lcom/android/mail/browse/ConversationCursor;Lcom/android/mail/browse/ConversationCursor$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/android/mail/browse/ConversationCursor;
    .param p2, "x1"    # Lcom/android/mail/browse/ConversationCursor$1;

    .prologue
    .line 220
    invoke-direct {p0, p1}, Lcom/android/mail/browse/ConversationCursor$RefreshTask;-><init>(Lcom/android/mail/browse/ConversationCursor;)V

    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 220
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 6
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v5, 0x0

    .line 229
    const-string v0, "ConversationCursor"

    const-string v1, "[Start refresh of %s: %d]"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # getter for: Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;
    invoke-static {v3}, Lcom/android/mail/browse/ConversationCursor;->access$000(Lcom/android/mail/browse/ConversationCursor;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    const/4 v3, 0x1

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 232
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # invokes: Lcom/android/mail/browse/ConversationCursor;->doQuery(Z)Landroid/database/Cursor;
    invoke-static {v0, v5}, Lcom/android/mail/browse/ConversationCursor;->access$100(Lcom/android/mail/browse/ConversationCursor;Z)Landroid/database/Cursor;

    move-result-object v0

    iput-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->mCursor:Landroid/database/Cursor;

    .line 234
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->getCount()I

    .line 235
    const/4 v0, 0x0

    return-object v0
.end method

.method protected onCancelled()V
    .locals 5

    .prologue
    .line 260
    const-string v0, "ConversationCursor"

    const-string v1, "[Ignoring refresh result: %d]"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 262
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->mCursor:Landroid/database/Cursor;

    if-eqz v0, :cond_0

    .line 263
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->mCursor:Landroid/database/Cursor;

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 265
    :cond_0
    return-void
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 220
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 6
    .param p1, "param"    # Ljava/lang/Void;

    .prologue
    .line 240
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # getter for: Lcom/android/mail/browse/ConversationCursor;->mCacheMapLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->access$200(Lcom/android/mail/browse/ConversationCursor;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    .line 242
    :try_start_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    invoke-virtual {v0}, Lcom/android/mail/browse/ConversationCursor;->isClosed()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 243
    invoke-virtual {p0}, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->onCancelled()V

    .line 244
    monitor-exit v1

    .line 255
    :goto_0
    return-void

    .line 246
    :cond_0
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    iget-object v2, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->mCursor:Landroid/database/Cursor;

    # setter for: Lcom/android/mail/browse/ConversationCursor;->mRequeryCursor:Landroid/database/Cursor;
    invoke-static {v0, v2}, Lcom/android/mail/browse/ConversationCursor;->access$302(Lcom/android/mail/browse/ConversationCursor;Landroid/database/Cursor;)Landroid/database/Cursor;

    .line 247
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    const/4 v2, 0x1

    # setter for: Lcom/android/mail/browse/ConversationCursor;->mRefreshReady:Z
    invoke-static {v0, v2}, Lcom/android/mail/browse/ConversationCursor;->access$402(Lcom/android/mail/browse/ConversationCursor;Z)Z

    .line 249
    const-string v0, "ConversationCursor"

    const-string v2, "[Query done %s: %d]"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # getter for: Lcom/android/mail/browse/ConversationCursor;->mName:Ljava/lang/String;
    invoke-static {v5}, Lcom/android/mail/browse/ConversationCursor;->access$000(Lcom/android/mail/browse/ConversationCursor;)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    invoke-virtual {p0}, Ljava/lang/Object;->hashCode()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v0, v2, v3}, Lcom/android/mail/utils/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 251
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # getter for: Lcom/android/mail/browse/ConversationCursor;->mDeferSync:Z
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->access$500(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # getter for: Lcom/android/mail/browse/ConversationCursor;->mPaused:Z
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->access$600(Lcom/android/mail/browse/ConversationCursor;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 252
    iget-object v0, p0, Lcom/android/mail/browse/ConversationCursor$RefreshTask;->this$0:Lcom/android/mail/browse/ConversationCursor;

    # invokes: Lcom/android/mail/browse/ConversationCursor;->notifyRefreshReady()V
    invoke-static {v0}, Lcom/android/mail/browse/ConversationCursor;->access$700(Lcom/android/mail/browse/ConversationCursor;)V

    .line 254
    :cond_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
