.class Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;
.super Lcom/google/android/gm/provider/MailSync$AbstractOperationSink;
.source "MailSync.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailSync;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ProtoOperationSink"
.end annotation


# instance fields
.field private final mParams:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;"
        }
    .end annotation
.end field

.field private mParts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/common/http/Part;",
            ">;"
        }
    .end annotation
.end field

.field mUphillSyncProto:Lcom/google/common/io/protocol/ProtoBuf;

.field final synthetic this$0:Lcom/google/android/gm/provider/MailSync;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailSync;Lcom/google/common/io/protocol/ProtoBuf;)V
    .locals 2
    .param p2, "uphillSyncProto"    # Lcom/google/common/io/protocol/ProtoBuf;

    .prologue
    const/4 v1, 0x0

    .line 3264
    iput-object p1, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    invoke-direct {p0, p1, v1}, Lcom/google/android/gm/provider/MailSync$AbstractOperationSink;-><init>(Lcom/google/android/gm/provider/MailSync;Lcom/google/android/gm/provider/MailSync$1;)V

    .line 3265
    iput-object p2, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mUphillSyncProto:Lcom/google/common/io/protocol/ProtoBuf;

    .line 3266
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParams:Ljava/util/ArrayList;

    .line 3267
    iput-object v1, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    .line 3268
    return-void
.end method

.method private newOperationProto(J)Lcom/google/common/io/protocol/ProtoBuf;
    .locals 3
    .param p1, "clientOperationId"    # J

    .prologue
    const/4 v2, 0x1

    .line 3544
    iget-object v1, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mUphillSyncProto:Lcom/google/common/io/protocol/ProtoBuf;

    invoke-virtual {v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->addNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v0

    .line 3545
    .local v0, "operation":Lcom/google/common/io/protocol/ProtoBuf;
    invoke-virtual {v0, v2, p1, p2}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3546
    return-object v0
.end method

.method private notifyAttachmentFailed(Lcom/google/android/gm/provider/MailSync$Message;Lcom/google/android/gm/provider/Gmail$Attachment;)V
    .locals 4
    .param p1, "message"    # Lcom/google/android/gm/provider/MailSync$Message;
    .param p2, "attachment"    # Lcom/google/android/gm/provider/Gmail$Attachment;

    .prologue
    .line 3523
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.google.android.gm.intent.ACTION_POST_SEND_ERROR"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 3524
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "account"

    iget-object v2, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    # getter for: Lcom/google/android/gm/provider/MailSync;->mStore:Lcom/google/android/gm/provider/MailStore;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailSync;->access$300(Lcom/google/android/gm/provider/MailSync;)Lcom/google/android/gm/provider/MailStore;

    move-result-object v2

    invoke-interface {v2}, Lcom/google/android/gm/provider/MailStore;->getAccount()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3525
    const-string v1, "extraMessageSubject"

    iget-object v2, p1, Lcom/google/android/gm/provider/MailSync$Message;->subject:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 3526
    const-string v1, "extraConversationId"

    iget-wide v2, p1, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 3527
    iget-object v1, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    # getter for: Lcom/google/android/gm/provider/MailSync;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailSync;->access$000(Lcom/google/android/gm/provider/MailSync;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 3528
    return-void
.end method

.method private shouldIgnoreLabelOperation(J)Z
    .locals 2
    .param p1, "labelId"    # J

    .prologue
    .line 3540
    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public conversationLabelAddedOrRemoved(JJJZ)V
    .locals 5
    .param p1, "clientOperationId"    # J
    .param p3, "maxMessageId"    # J
    .param p5, "labelId"    # J
    .param p7, "added"    # Z

    .prologue
    const/4 v3, 0x3

    .line 3324
    invoke-direct {p0, p5, p6}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->shouldIgnoreLabelOperation(J)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3344
    :goto_0
    return-void

    .line 3326
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->newOperationProto(J)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v1

    .line 3327
    .local v1, "operation":Lcom/google/common/io/protocol/ProtoBuf;
    invoke-virtual {v1, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v0

    .line 3329
    .local v0, "labelAdded":Lcom/google/common/io/protocol/ProtoBuf;
    invoke-virtual {v0, v3, p7}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3331
    const/4 v2, 0x1

    invoke-virtual {v0, v2, p3, p4}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3334
    invoke-static {p5, p6}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v2

    if-nez v2, :cond_1

    .line 3335
    const/4 v2, 0x2

    invoke-virtual {v0, v2, p5, p6}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    goto :goto_0

    .line 3339
    :cond_1
    const/4 v3, 0x4

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->LOCAL_PRIORITY_LABELS:Lcom/google/common/collect/BiMap;

    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v2, v4}, Lcom/google/common/collect/BiMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v0, v3, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    goto :goto_0
.end method

.method public getNumOperations()I
    .locals 2

    .prologue
    .line 3272
    iget-object v0, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mUphillSyncProto:Lcom/google/common/io/protocol/ProtoBuf;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->getCount(I)I

    move-result v0

    return v0
.end method

.method public getParts()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/common/http/Part;",
            ">;"
        }
    .end annotation

    .prologue
    .line 3280
    iget-object v0, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    return-object v0
.end method

.method public hasAttachments()Z
    .locals 1

    .prologue
    .line 3276
    iget-object v0, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public messageExpunged(JJ)V
    .locals 2
    .param p1, "clientOperationId"    # J
    .param p3, "messageId"    # J

    .prologue
    .line 3531
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->newOperationProto(J)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v0

    .line 3532
    .local v0, "operation":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v1, 0x5

    invoke-virtual {v0, v1, p3, p4}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3533
    return-void
.end method

.method public messageLabelAdded(JJJ)V
    .locals 5
    .param p1, "clientOperationId"    # J
    .param p3, "messageId"    # J
    .param p5, "labelId"    # J

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 3284
    invoke-direct {p0, p5, p6}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->shouldIgnoreLabelOperation(J)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3304
    :goto_0
    return-void

    .line 3286
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->newOperationProto(J)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v1

    .line 3287
    .local v1, "operation":Lcom/google/common/io/protocol/ProtoBuf;
    invoke-virtual {v1, v4}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v0

    .line 3289
    .local v0, "labelAdded":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v2, 0x3

    invoke-virtual {v0, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3291
    invoke-virtual {v0, v3, p3, p4}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3295
    invoke-static {p5, p6}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v2

    if-nez v2, :cond_1

    .line 3296
    invoke-virtual {v0, v4, p5, p6}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    goto :goto_0

    .line 3300
    :cond_1
    const/4 v3, 0x4

    sget-object v2, Lcom/google/android/gm/provider/Gmail;->LOCAL_PRIORITY_LABELS:Lcom/google/common/collect/BiMap;

    invoke-static {p5, p6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-interface {v2, v4}, Lcom/google/common/collect/BiMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-virtual {v0, v3, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    goto :goto_0
.end method

.method public messageLabelRemoved(JJJ)V
    .locals 5
    .param p1, "clientOperationId"    # J
    .param p3, "messageId"    # J
    .param p5, "labelId"    # J

    .prologue
    const/4 v4, 0x2

    .line 3307
    invoke-direct {p0, p5, p6}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->shouldIgnoreLabelOperation(J)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 3320
    :goto_0
    return-void

    .line 3309
    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->newOperationProto(J)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v1

    .line 3310
    .local v1, "operation":Lcom/google/common/io/protocol/ProtoBuf;
    invoke-virtual {v1, v4}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v0

    .line 3312
    .local v0, "labelAdded":Lcom/google/common/io/protocol/ProtoBuf;
    const/4 v2, 0x3

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3314
    const/4 v2, 0x1

    invoke-virtual {v0, v2, p3, p4}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3317
    invoke-virtual {v0, v4, p5, p6}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    goto :goto_0
.end method

.method public messageSavedOrSent(JLcom/google/android/gm/provider/MailSync$Message;JJZ)V
    .locals 28
    .param p1, "clientOperationId"    # J
    .param p3, "message"    # Lcom/google/android/gm/provider/MailSync$Message;
    .param p4, "prevMessageId"    # J
    .param p6, "refMessageId"    # J
    .param p8, "save"    # Z

    .prologue
    .line 3350
    const-string v23, "Gmail"

    const-string v24, "MailSync posting operation %d (messageSavedOrSent)"

    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v27

    aput-object v27, v25, v26

    invoke-static/range {v23 .. v25}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3352
    invoke-direct/range {p0 .. p2}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->newOperationProto(J)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v16

    .line 3353
    .local v16, "operation":Lcom/google/common/io/protocol/ProtoBuf;
    const/16 v23, 0x4

    move-object/from16 v0, v16

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->setNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v19

    .line 3355
    .local v19, "savedOrSentProto":Lcom/google/common/io/protocol/ProtoBuf;
    const/16 v23, 0xa

    move-object/from16 v0, v19

    move/from16 v1, v23

    move/from16 v2, p8

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3357
    const/16 v23, 0x1

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-wide/from16 v2, p4

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3360
    const/16 v23, 0x2

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-wide/from16 v2, p6

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3363
    const/16 v23, 0x3

    const-string v24, ", "

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->toAddresses:Ljava/util/List;

    move-object/from16 v25, v0

    invoke-static/range {v24 .. v25}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3366
    const/16 v23, 0x4

    const-string v24, ", "

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->ccAddresses:Ljava/util/List;

    move-object/from16 v25, v0

    invoke-static/range {v24 .. v25}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3369
    const/16 v23, 0x5

    const-string v24, ", "

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->bccAddresses:Ljava/util/List;

    move-object/from16 v25, v0

    invoke-static/range {v24 .. v25}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v24

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3372
    const/16 v24, 0x6

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->subject:Ljava/lang/String;

    move-object/from16 v23, v0

    if-eqz v23, :cond_3

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->subject:Ljava/lang/String;

    move-object/from16 v23, v0

    :goto_0
    move-object/from16 v0, v19

    move/from16 v1, v24

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3375
    const/16 v24, 0x7

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    move-object/from16 v23, v0

    if-eqz v23, :cond_4

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    move-object/from16 v23, v0

    :goto_1
    move-object/from16 v0, v19

    move/from16 v1, v24

    move-object/from16 v2, v23

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3380
    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->clientCreated:Z

    move/from16 v23, v0

    if-eqz v23, :cond_5

    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->includeQuotedText:Z

    move/from16 v23, v0

    if-eqz v23, :cond_5

    .line 3381
    const/16 v23, 0xb

    const/16 v24, 0x1

    move-object/from16 v0, v19

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3384
    const/16 v23, 0xd

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->quoteStartPos:J

    move-wide/from16 v24, v0

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-wide/from16 v2, v24

    invoke-virtual {v0, v1, v2, v3}, Lcom/google/common/io/protocol/ProtoBuf;->setLong(IJ)V

    .line 3387
    move-object/from16 v0, p3

    iget-boolean v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->forward:Z

    move/from16 v23, v0

    if-eqz v23, :cond_0

    .line 3388
    const/16 v23, 0xc

    const/16 v24, 0x1

    move-object/from16 v0, v19

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3398
    :cond_0
    :goto_2
    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->customFromAddress:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v23

    if-nez v23, :cond_1

    .line 3399
    const/16 v23, 0xe

    const/16 v24, 0x1

    move-object/from16 v0, v19

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    .line 3402
    const/16 v23, 0xf

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->customFromAddress:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3406
    const-string v23, "Gmail"

    const-string v24, "Uphill Sync operation with custom from address: %s"

    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->customFromAddress:Ljava/lang/String;

    move-object/from16 v27, v0

    aput-object v27, v25, v26

    invoke-static/range {v23 .. v25}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3410
    :cond_1
    const/16 v20, 0x1

    .line 3411
    .local v20, "tempIndex":I
    move-object/from16 v0, p3

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    move-object/from16 v23, v0

    invoke-interface/range {v23 .. v23}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_c

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 3412
    .local v4, "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    sget-object v23, Lcom/google/android/gm/provider/MailSync$2;->$SwitchMap$com$google$android$gm$provider$Gmail$AttachmentOrigin:[I

    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;->ordinal()I

    move-result v24

    aget v23, v23, v24

    packed-switch v23, :pswitch_data_0

    .line 3516
    new-instance v23, Ljava/lang/IllegalArgumentException;

    new-instance v24, Ljava/lang/StringBuilder;

    invoke-direct/range {v24 .. v24}, Ljava/lang/StringBuilder;-><init>()V

    const-string v25, "Unknown origin: "

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v24

    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->origin:Lcom/google/android/gm/provider/Gmail$AttachmentOrigin;

    move-object/from16 v25, v0

    invoke-virtual/range {v24 .. v25}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v24

    invoke-virtual/range {v24 .. v24}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v24

    invoke-direct/range {v23 .. v24}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v23

    .line 3372
    .end local v4    # "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v20    # "tempIndex":I
    :cond_3
    const-string v23, ""

    goto/16 :goto_0

    .line 3375
    :cond_4
    const-string v23, ""

    goto/16 :goto_1

    .line 3392
    :cond_5
    const/16 v23, 0xb

    const/16 v24, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setBool(IZ)V

    goto/16 :goto_2

    .line 3414
    .restart local v4    # "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .restart local v12    # "i$":Ljava/util/Iterator;
    .restart local v20    # "tempIndex":I
    :pswitch_0
    const/16 v23, 0x8

    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v19

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->addString(ILjava/lang/String;)V

    goto :goto_3

    .line 3419
    :pswitch_1
    iget-object v6, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    .line 3421
    .local v6, "attachmentUri":Ljava/lang/String;
    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-object/from16 v23, v0

    invoke-static/range {v23 .. v23}, Lcom/google/android/common/base/Strings;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v23

    if-eqz v23, :cond_7

    .line 3426
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v24, v0

    invoke-virtual/range {v23 .. v25}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, "-"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .line 3427
    .local v5, "attachmentId":Ljava/lang/String;
    add-int/lit8 v20, v20, 0x1

    .line 3431
    :goto_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    move-object/from16 v23, v0

    # getter for: Lcom/google/android/gm/provider/MailSync;->mResolver:Landroid/content/ContentResolver;
    invoke-static/range {v23 .. v23}, Lcom/google/android/gm/provider/MailSync;->access$200(Lcom/google/android/gm/provider/MailSync;)Landroid/content/ContentResolver;

    move-result-object v23

    const-string v24, "gmail_use_multipart_protobuf"

    const/16 v25, 0x1

    invoke-static/range {v23 .. v25}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v23

    if-eqz v23, :cond_8

    const/16 v22, 0x1

    .line 3433
    .local v22, "useMultiPartProtoBuf":Z
    :goto_5
    const/4 v11, 0x0

    .line 3434
    .local v11, "fileContents":[B
    if-eqz v22, :cond_9

    .line 3435
    const/16 v17, 0x0

    .line 3437
    .local v17, "part":Lcom/google/android/common/http/FilePart;
    :try_start_0
    new-instance v18, Lcom/google/android/gm/provider/MailSync$AttachmentPartSource;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    move-object/from16 v23, v0

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v24, v0

    move-object/from16 v0, v18

    move-object/from16 v1, v23

    move-wide/from16 v2, v24

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/android/gm/provider/MailSync$AttachmentPartSource;-><init>(Lcom/google/android/gm/provider/MailSync;JLcom/google/android/gm/provider/Gmail$Attachment;)V

    .line 3439
    .local v18, "partSource":Lcom/google/android/common/http/PartSource;
    new-instance v17, Lcom/google/android/common/http/FilePart;

    .end local v17    # "part":Lcom/google/android/common/http/FilePart;
    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    move-object/from16 v23, v0

    const/16 v24, 0x0

    move-object/from16 v0, v17

    move-object/from16 v1, v18

    move-object/from16 v2, v23

    move-object/from16 v3, v24

    invoke-direct {v0, v5, v1, v2, v3}, Lcom/google/android/common/http/FilePart;-><init>(Ljava/lang/String;Lcom/google/android/common/http/PartSource;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    .line 3461
    .restart local v17    # "part":Lcom/google/android/common/http/FilePart;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    move-object/from16 v23, v0

    if-nez v23, :cond_6

    .line 3462
    new-instance v23, Ljava/util/ArrayList;

    invoke-direct/range {v23 .. v23}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    .line 3464
    :cond_6
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->mParts:Ljava/util/ArrayList;

    move-object/from16 v23, v0

    move-object/from16 v0, v23

    move-object/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 3497
    .end local v17    # "part":Lcom/google/android/common/http/FilePart;
    .end local v18    # "partSource":Lcom/google/android/common/http/PartSource;
    :goto_6
    const/16 v23, 0x9

    move-object/from16 v0, v19

    move/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/google/common/io/protocol/ProtoBuf;->addNewProtoBuf(I)Lcom/google/common/io/protocol/ProtoBuf;

    move-result-object v21

    .line 3499
    .local v21, "uploadedAttachment":Lcom/google/common/io/protocol/ProtoBuf;
    const/16 v23, 0x1

    move-object/from16 v0, v21

    move/from16 v1, v23

    invoke-virtual {v0, v1, v5}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3502
    const/16 v23, 0x2

    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->name:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v21

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3505
    const/16 v23, 0x3

    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    move-object/from16 v24, v0

    move-object/from16 v0, v21

    move/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v1, v2}, Lcom/google/common/io/protocol/ProtoBuf;->setString(ILjava/lang/String;)V

    .line 3508
    if-nez v22, :cond_2

    .line 3509
    const/16 v23, 0x4

    move-object/from16 v0, v21

    move/from16 v1, v23

    invoke-virtual {v0, v1, v11}, Lcom/google/common/io/protocol/ProtoBuf;->setBytes(I[B)V

    goto/16 :goto_3

    .line 3429
    .end local v5    # "attachmentId":Ljava/lang/String;
    .end local v11    # "fileContents":[B
    .end local v21    # "uploadedAttachment":Lcom/google/common/io/protocol/ProtoBuf;
    .end local v22    # "useMultiPartProtoBuf":Z
    :cond_7
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v24, v0

    invoke-virtual/range {v23 .. v25}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, "-"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    iget-object v0, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->partId:Ljava/lang/String;

    move-object/from16 v24, v0

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    .restart local v5    # "attachmentId":Ljava/lang/String;
    goto/16 :goto_4

    .line 3431
    :cond_8
    const/16 v22, 0x0

    goto/16 :goto_5

    .line 3441
    .restart local v11    # "fileContents":[B
    .restart local v22    # "useMultiPartProtoBuf":Z
    :catch_0
    move-exception v10

    .line 3446
    .local v10, "e":Ljava/io/IOException;
    const-string v23, "Gmail"

    const-string v24, "IO error while reading attachment: %s"

    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object v5, v25, v26

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v10, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3448
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1, v4}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->notifyAttachmentFailed(Lcom/google/android/gm/provider/MailSync$Message;Lcom/google/android/gm/provider/Gmail$Attachment;)V

    goto/16 :goto_3

    .line 3450
    .end local v10    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v10

    .line 3455
    .local v10, "e":Ljava/lang/SecurityException;
    const-string v23, "Gmail"

    const-string v24, "SecurityException while reading attachment: %S"

    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object v5, v25, v26

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v10, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3457
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1, v4}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->notifyAttachmentFailed(Lcom/google/android/gm/provider/MailSync$Message;Lcom/google/android/gm/provider/Gmail$Attachment;)V

    goto/16 :goto_3

    .line 3467
    .end local v10    # "e":Ljava/lang/SecurityException;
    :cond_9
    :try_start_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->this$0:Lcom/google/android/gm/provider/MailSync;

    move-object/from16 v23, v0

    # getter for: Lcom/google/android/gm/provider/MailSync;->mStore:Lcom/google/android/gm/provider/MailStore;
    invoke-static/range {v23 .. v23}, Lcom/google/android/gm/provider/MailSync;->access$300(Lcom/google/android/gm/provider/MailSync;)Lcom/google/android/gm/provider/MailStore;

    move-result-object v23

    move-object/from16 v0, p3

    iget-wide v0, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v24, v0

    move-object/from16 v0, v23

    move-wide/from16 v1, v24

    invoke-interface {v0, v1, v2, v4}, Lcom/google/android/gm/provider/MailStore;->getInputStreamForUploadedAttachment(JLcom/google/android/gm/provider/Gmail$Attachment;)Ljava/io/InputStream;

    move-result-object v13

    .line 3469
    .local v13, "is":Ljava/io/InputStream;
    new-instance v7, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v7}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 3470
    .local v7, "byteStream":Ljava/io/ByteArrayOutputStream;
    const/16 v23, 0x400

    move/from16 v0, v23

    new-array v9, v0, [B

    .line 3471
    .local v9, "data":[B
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v14

    .line 3473
    .local v14, "now":J
    :cond_a
    invoke-virtual {v13, v9}, Ljava/io/InputStream;->read([B)I

    move-result v8

    .line 3474
    .local v8, "bytesRead":I
    if-gez v8, :cond_b

    .line 3481
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v11

    goto/16 :goto_6

    .line 3476
    :cond_b
    const/16 v23, 0x0

    move/from16 v0, v23

    invoke-virtual {v7, v9, v0, v8}, Ljava/io/ByteArrayOutputStream;->write([BII)V

    .line 3477
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v23

    sub-long v23, v23, v14

    const-wide/32 v25, 0x36ee80

    cmp-long v23, v23, v25

    if-lez v23, :cond_a

    .line 3478
    new-instance v23, Ljava/io/IOException;

    const-string v24, "Timed out reading attachment"

    invoke-direct/range {v23 .. v24}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v23
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_2

    .line 3482
    .end local v7    # "byteStream":Ljava/io/ByteArrayOutputStream;
    .end local v8    # "bytesRead":I
    .end local v9    # "data":[B
    .end local v13    # "is":Ljava/io/InputStream;
    .end local v14    # "now":J
    :catch_2
    move-exception v10

    .line 3487
    .local v10, "e":Ljava/io/IOException;
    const-string v23, "Gmail"

    const-string v24, "IO error while reading attachment: %s"

    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object v5, v25, v26

    move-object/from16 v0, v23

    move-object/from16 v1, v24

    move-object/from16 v2, v25

    invoke-static {v0, v10, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3490
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    invoke-direct {v0, v1, v4}, Lcom/google/android/gm/provider/MailSync$ProtoOperationSink;->notifyAttachmentFailed(Lcom/google/android/gm/provider/MailSync$Message;Lcom/google/android/gm/provider/Gmail$Attachment;)V

    goto/16 :goto_3

    .line 3519
    .end local v4    # "attachment":Lcom/google/android/gm/provider/Gmail$Attachment;
    .end local v5    # "attachmentId":Ljava/lang/String;
    .end local v6    # "attachmentUri":Ljava/lang/String;
    .end local v10    # "e":Ljava/io/IOException;
    .end local v11    # "fileContents":[B
    .end local v22    # "useMultiPartProtoBuf":Z
    :cond_c
    const-string v23, "Gmail"

    const-string v24, "messageSavedOrSent: message = %s"

    const/16 v25, 0x1

    move/from16 v0, v25

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v25, v0

    const/16 v26, 0x0

    aput-object v19, v25, v26

    invoke-static/range {v23 .. v25}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 3520
    return-void

    .line 3412
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
