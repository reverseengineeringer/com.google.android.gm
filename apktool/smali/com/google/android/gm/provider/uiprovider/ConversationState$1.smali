.class Lcom/google/android/gm/provider/uiprovider/ConversationState$1;
.super Ljava/lang/Object;
.source "ConversationState.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/google/android/gm/provider/uiprovider/ConversationState;->ensureAttachmentStatusLoaderStarted()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/uiprovider/ConversationState;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    .line 150
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mLoaderLock:Ljava/lang/Object;
    invoke-static {v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$000(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Ljava/lang/Object;

    move-result-object v6

    monitor-enter v6

    .line 151
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;
    invoke-static {v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$100(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Lcom/google/android/gm/provider/AttachmentStatusLoader;

    move-result-object v0

    if-nez v0, :cond_0

    .line 152
    iget-object v7, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    new-instance v0, Lcom/google/android/gm/provider/AttachmentStatusLoader;

    iget-object v1, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$200(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAccount:Ljava/lang/String;
    invoke-static {v2}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$300(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mConversationId:J
    invoke-static {v3}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$400(Lcom/google/android/gm/provider/uiprovider/ConversationState;)J

    move-result-wide v3

    iget-object v5, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mDownloadManager:Landroid/app/DownloadManager;
    invoke-static {v5}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$500(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Landroid/app/DownloadManager;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gm/provider/AttachmentStatusLoader;-><init>(Landroid/content/Context;Ljava/lang/String;JLandroid/app/DownloadManager;)V

    # setter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;
    invoke-static {v7, v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$102(Lcom/google/android/gm/provider/uiprovider/ConversationState;Lcom/google/android/gm/provider/AttachmentStatusLoader;)Lcom/google/android/gm/provider/AttachmentStatusLoader;

    .line 155
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;
    invoke-static {v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$100(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Lcom/google/android/gm/provider/AttachmentStatusLoader;

    move-result-object v0

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    invoke-virtual {v0, v1, v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->registerListener(ILandroid/content/Loader$OnLoadCompleteListener;)V

    .line 158
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;
    invoke-static {v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$100(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Lcom/google/android/gm/provider/AttachmentStatusLoader;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->isStarted()Z

    move-result v0

    if-nez v0, :cond_1

    .line 159
    const-string v0, "Gmail"

    const-string v1, "starting attachment loader for conversation %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mConversationId:J
    invoke-static {v4}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$400(Lcom/google/android/gm/provider/uiprovider/ConversationState;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 161
    iget-object v0, p0, Lcom/google/android/gm/provider/uiprovider/ConversationState$1;->this$0:Lcom/google/android/gm/provider/uiprovider/ConversationState;

    # getter for: Lcom/google/android/gm/provider/uiprovider/ConversationState;->mAttachmentStatusLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader;
    invoke-static {v0}, Lcom/google/android/gm/provider/uiprovider/ConversationState;->access$100(Lcom/google/android/gm/provider/uiprovider/ConversationState;)Lcom/google/android/gm/provider/AttachmentStatusLoader;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->startLoading()V

    .line 163
    :cond_1
    monitor-exit v6

    .line 164
    return-void

    .line 163
    :catchall_0
    move-exception v0

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
