.class Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;
.super Ljava/lang/Object;
.source "AttachmentStatusLoader.java"

# interfaces
.implements Landroid/content/Loader$OnLoadCompleteListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/AttachmentStatusLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "AttachmentListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/content/Loader$OnLoadCompleteListener",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;


# direct methods
.method private constructor <init>(Lcom/google/android/gm/provider/AttachmentStatusLoader;)V
    .locals 0

    .prologue
    .line 391
    iput-object p1, p0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/android/gm/provider/AttachmentStatusLoader;Lcom/google/android/gm/provider/AttachmentStatusLoader$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/google/android/gm/provider/AttachmentStatusLoader;
    .param p2, "x1"    # Lcom/google/android/gm/provider/AttachmentStatusLoader$1;

    .prologue
    .line 391
    invoke-direct {p0, p1}, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;-><init>(Lcom/google/android/gm/provider/AttachmentStatusLoader;)V

    return-void
.end method


# virtual methods
.method public onLoadComplete(Landroid/content/Loader;Landroid/database/Cursor;)V
    .locals 16
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 394
    .local p1, "loader":Landroid/content/Loader;, "Landroid/content/Loader<Landroid/database/Cursor;>;"
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    # setter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v2, v3}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$202(Lcom/google/android/gm/provider/AttachmentStatusLoader;Ljava/util/List;)Ljava/util/List;

    .line 395
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadMap:Ljava/util/Map;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$300(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->clear()V

    .line 397
    const/4 v15, -0x1

    .line 398
    .local v15, "pos":I
    :cond_0
    :goto_0
    add-int/lit8 v15, v15, 0x1

    move-object/from16 v0, p2

    invoke-interface {v0, v15}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 399
    const/4 v2, 0x0

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 400
    .local v4, "messageId":J
    const/4 v2, 0x1

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 401
    .local v6, "partId":Ljava/lang/String;
    const/4 v2, 0x2

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v12

    .line 402
    .local v12, "downloadId":J
    const/4 v2, 0x3

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 403
    .local v9, "mimeType":Ljava/lang/String;
    const/4 v2, 0x4

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    if-eqz v2, :cond_3

    const/4 v7, 0x1

    .line 404
    .local v7, "saveToSd":Z
    :goto_1
    const/4 v2, 0x5

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 405
    .local v8, "fileName":Ljava/lang/String;
    const/4 v2, 0x6

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    .line 406
    .local v10, "status":I
    const/4 v2, 0x7

    move-object/from16 v0, p2

    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 411
    .local v11, "rendition":Ljava/lang/String;
    new-instance v1, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mConversationId:J
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$400(Lcom/google/android/gm/provider/AttachmentStatusLoader;)J

    move-result-wide v2

    invoke-direct/range {v1 .. v11}, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;-><init>(JJLjava/lang/String;ZLjava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 413
    .local v1, "result":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$200(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v1}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v14

    .line 414
    .local v14, "index":I
    if-ltz v14, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$200(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v14}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;

    iget-boolean v2, v2, Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;->saveToSd:Z

    if-nez v2, :cond_1

    .line 415
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$200(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v14}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 417
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$200(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 418
    const-wide/16 v2, 0x0

    cmp-long v2, v12, v2

    if-ltz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadMap:Ljava/util/Map;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$300(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/Map;

    move-result-object v2

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    if-eqz v7, :cond_0

    .line 419
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadMap:Ljava/util/Map;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$300(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/Map;

    move-result-object v2

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 403
    .end local v1    # "result":Lcom/google/android/gm/provider/AttachmentStatusLoader$Result;
    .end local v7    # "saveToSd":Z
    .end local v8    # "fileName":Ljava/lang/String;
    .end local v10    # "status":I
    .end local v11    # "rendition":Ljava/lang/String;
    .end local v14    # "index":I
    :cond_3
    const/4 v7, 0x0

    goto/16 :goto_1

    .line 425
    .end local v4    # "messageId":J
    .end local v6    # "partId":Ljava/lang/String;
    .end local v9    # "mimeType":Ljava/lang/String;
    .end local v12    # "downloadId":J
    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadMap:Ljava/util/Map;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$300(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/Map;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Map;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 426
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$200(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    .line 427
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mAttachments:Ljava/util/List;
    invoke-static {v3}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$200(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->deliverResult(Ljava/lang/Object;)V

    .line 435
    :cond_5
    :goto_2
    return-void

    .line 431
    :cond_6
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$500(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;->reset()V

    .line 432
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$500(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadMap:Ljava/util/Map;
    invoke-static {v3}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$300(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;->setIds(Ljava/util/Collection;)V

    .line 433
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->this$0:Lcom/google/android/gm/provider/AttachmentStatusLoader;

    # getter for: Lcom/google/android/gm/provider/AttachmentStatusLoader;->mDownloadLoader:Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;
    invoke-static {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader;->access$500(Lcom/google/android/gm/provider/AttachmentStatusLoader;)Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/android/gm/provider/AttachmentStatusLoader$DownloadStatusLoader;->startLoading()V

    goto :goto_2
.end method

.method public bridge synthetic onLoadComplete(Landroid/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 391
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/google/android/gm/provider/AttachmentStatusLoader$AttachmentListener;->onLoadComplete(Landroid/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method
