.class Lcom/google/android/gm/provider/MailEngine$PublicMailStore;
.super Ljava/lang/Object;
.source "MailEngine.java"

# interfaces
.implements Lcom/google/android/gm/provider/MailStore;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/google/android/gm/provider/MailEngine;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PublicMailStore"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/google/android/gm/provider/MailEngine;


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailEngine;)V
    .locals 0

    .prologue
    .line 4146
    iput-object p1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-direct/range {p0 .. p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private getMaxMessageIdForConversation(J)J
    .locals 5
    .param p1, "conversationId"    # J

    .prologue
    .line 4671
    const-wide/16 v0, 0x0

    .line 4672
    .local v0, "maxMessageId":J
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT MAX(messageId) FROM messages WHERE conversation = ? and queryId = 0 and clientCreated = 0"

    invoke-virtual {v3, v4}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v2

    .line 4677
    .local v2, "statement":Landroid/database/sqlite/SQLiteStatement;
    const/4 v3, 0x1

    :try_start_0
    invoke-virtual {v2, v3, p1, p2}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 4679
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteStatement;->simpleQueryForLong()J
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteDoneException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v0

    .line 4683
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteStatement;->close()V

    .line 4686
    :goto_0
    return-wide v0

    .line 4680
    :catch_0
    move-exception v3

    .line 4683
    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteStatement;->close()V

    goto :goto_0

    :catchall_0
    move-exception v3

    invoke-virtual {v2}, Landroid/database/sqlite/SQLiteStatement;->close()V

    throw v3
.end method


# virtual methods
.method public addOrUpdateMessage(Lcom/google/android/gm/provider/MailSync$Message;J)V
    .locals 12
    .param p1, "message"    # Lcom/google/android/gm/provider/MailSync$Message;
    .param p2, "queryId"    # J

    .prologue
    const-wide/16 v10, 0x0

    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 4204
    const-string v0, "Gmail"

    const-string v1, "addOrUpdateMessage: %s"

    new-array v2, v2, [Ljava/lang/Object;

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4206
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4212
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "SELECT COUNT(*) FROM operations WHERE message_messageId = ? AND action IN (?, ?) AND value2 = ?"

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-wide v4, p1, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    const-string v4, "messageSaved"

    aput-object v4, v2, v3

    const/4 v3, 0x2

    const-string v4, "messageSent"

    aput-object v4, v2, v3

    const/4 v3, 0x3

    iget-wide v4, p1, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v8

    .line 4220
    .local v8, "numSendOrSaveOperations":J
    cmp-long v0, v8, v10

    if-nez v0, :cond_0

    .line 4221
    const-wide/16 v2, 0x0

    sget-object v6, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->SERVER_CREATED:Lcom/google/android/gm/provider/MailEngine$ClientCreated;

    move-object v0, p0

    move-object v1, p1

    move-wide v4, p2

    invoke-virtual/range {v0 .. v6}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->addOrUpdateMessageNoNotifyWithoutWritingOperations(Lcom/google/android/gm/provider/MailSync$Message;JJLcom/google/android/gm/provider/MailEngine$ClientCreated;)V

    .line 4236
    :goto_0
    iget-wide v0, p1, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v0, v1}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v7

    .line 4237
    .local v7, "messageIdString":Ljava/lang/String;
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages_to_fetch"

    const-string v2, "_id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object v7, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4238
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4240
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4242
    return-void

    .line 4224
    .end local v7    # "messageIdString":Ljava/lang/String;
    :cond_0
    :try_start_1
    const-string v0, "Gmail"

    const-string v1, "addOrUpdateMessage ignoring message %d because of a pending save/send operation"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-wide v4, p1, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 4240
    .end local v8    # "numSendOrSaveOperations":J
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
.end method

.method addOrUpdateMessageNoNotifyWithoutWritingOperations(Lcom/google/android/gm/provider/MailSync$Message;JJLcom/google/android/gm/provider/MailEngine$ClientCreated;)V
    .locals 25

    .prologue
    .line 5044
    new-instance v18, Landroid/util/TimingLogger;

    const-string v1, "Gmail"

    const-string v2, "addOrUpdateMessageNoNotifyWithoutWritingOperations"

    move-object/from16 v0, v18

    invoke-direct {v0, v1, v2}, Landroid/util/TimingLogger;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 5047
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 5049
    :try_start_0
    new-instance v19, Landroid/content/ContentValues;

    invoke-direct/range {v19 .. v19}, Landroid/content/ContentValues;-><init>()V

    .line 5050
    const-string v1, "messageId"

    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5051
    const-string v1, "conversation"

    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5052
    const-string v1, "fromAddress"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->fromAddress:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5053
    const-string v1, "toAddresses"

    const-string v2, "\n"

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->toAddresses:Ljava/util/List;

    invoke-static {v2, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5056
    const-string v1, "ccAddresses"

    const-string v2, "\n"

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->ccAddresses:Ljava/util/List;

    invoke-static {v2, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5059
    const-string v1, "bccAddresses"

    const-string v2, "\n"

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->bccAddresses:Ljava/util/List;

    invoke-static {v2, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5062
    const-string v1, "replyToAddresses"

    const-string v2, "\n"

    move-object/from16 v0, p1

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->replyToAddresses:Ljava/util/List;

    invoke-static {v2, v3}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5065
    const-string v1, "dateSentMs"

    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->dateSentMs:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5066
    const-string v1, "dateReceivedMs"

    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->dateReceivedMs:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5067
    const-string v1, "subject"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->subject:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5068
    const-string v1, "listInfo"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->listInfo:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5069
    const-string v1, "personalLevel"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->personalLevel:Lcom/google/android/gm/provider/Gmail$PersonalLevel;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/Gmail$PersonalLevel;->toInt()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 5070
    const-string v1, "clientCreated"

    invoke-virtual/range {p6 .. p6}, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->toInt()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 5071
    const-string v1, "snippet"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->snippet:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5072
    const-wide/16 v1, 0x0

    cmp-long v1, p2, v1

    if-eqz v1, :cond_0

    .line 5074
    const-string v1, "_id"

    invoke-static/range {p2 .. p3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5077
    :cond_0
    const-string v2, "synced"

    const-wide/16 v3, 0x0

    cmp-long v1, p4, v3

    if-nez v1, :cond_6

    const/4 v1, 0x1

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 5078
    const-string v1, "queryId"

    invoke-static/range {p4 .. p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5079
    const-string v1, "pre body"

    move-object/from16 v0, v18

    invoke-virtual {v0, v1}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 5080
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    if-eqz v1, :cond_1

    .line 5081
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "gmail_db_compression_type"

    const/4 v3, 0x1

    invoke-static {v1, v2, v3}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    .line 5084
    if-nez v1, :cond_7

    .line 5085
    const-string v1, "body"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5086
    const-string v1, "bodyCompressed"

    move-object/from16 v0, v19

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V

    .line 5106
    :cond_1
    :goto_1
    const-string v1, "body"

    move-object/from16 v0, v18

    invoke-virtual {v0, v1}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 5108
    const-string v2, "bodyEmbedsExternalResources"

    move-object/from16 v0, p1

    iget-boolean v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->bodyEmbedsExternalResources:Z

    if-eqz v1, :cond_9

    const/4 v1, 0x1

    :goto_2
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 5112
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->customFromAddress:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 5113
    const-string v1, "customFromAddress"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->customFromAddress:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5118
    :cond_2
    move-object/from16 v0, p1

    iget-wide v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->refMsgId:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-eqz v1, :cond_3

    .line 5119
    const-string v1, "refMessageId"

    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->refMsgId:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5124
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v1

    invoke-virtual {v1}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdDraft()J

    move-result-wide v20

    .line 5125
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-eqz v1, :cond_e

    .line 5129
    const-wide/16 v1, 0x0

    cmp-long v1, p2, v1

    if-nez v1, :cond_b

    const-wide/16 v1, 0x0

    cmp-long v1, p4, v1

    if-nez v1, :cond_b

    .line 5130
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$2400(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/MailEngine$Preferences;

    move-result-object v1

    if-eqz v1, :cond_a

    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mPreferences:Lcom/google/android/gm/provider/MailEngine$Preferences;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$2400(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/MailEngine$Preferences;

    move-result-object v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/google/android/gm/provider/MailEngine$Preferences;->getPrefetchAttachments(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_a

    const/4 v1, 0x1

    move/from16 v17, v1

    .line 5139
    :goto_3
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->attachments:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :cond_4
    :goto_4
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_b

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/google/android/gm/provider/Gmail$Attachment;

    .line 5140
    const/4 v6, 0x0

    .line 5141
    const/4 v15, 0x1

    .line 5142
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/MailEngine;->getAccountName()Ljava/lang/String;

    move-result-object v1

    move-object/from16 v0, p1

    iget-wide v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    sget-object v5, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    invoke-static/range {v1 .. v6}, Lcom/google/android/gm/provider/Gmail;->getAttachmentUri(Ljava/lang/String;JLcom/google/android/gm/provider/uiprovider/UIAttachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;Z)Landroid/net/Uri;

    move-result-object v1

    .line 5144
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v2

    iget-object v3, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    invoke-static {v2, v1, v3}, Lcom/google/android/gm/provider/MimeType;->isViewable(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;)Z

    move-result v1

    .line 5148
    iget-object v2, v4, Lcom/google/android/gm/provider/Gmail$Attachment;->contentType:Ljava/lang/String;

    const-string v3, "image/"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 5149
    sget-object v2, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->SERVER_CREATED:Lcom/google/android/gm/provider/MailEngine$ClientCreated;

    move-object/from16 v0, p6

    if-ne v0, v2, :cond_5

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    invoke-static/range {v20 .. v21}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 5151
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$1200(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v7

    move-object/from16 v0, p1

    iget-wide v8, v0, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    move-object/from16 v0, p1

    iget-wide v10, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    sget-object v13, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->SIMPLE:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    const/16 v16, 0x1

    move-object v12, v4

    move v14, v6

    invoke-virtual/range {v7 .. v16}, Lcom/google/android/gm/provider/AttachmentManager;->enqueueAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZZI)V

    .line 5160
    :cond_5
    sget-object v2, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->SERVER_CREATED:Lcom/google/android/gm/provider/MailEngine$ClientCreated;

    move-object/from16 v0, p6

    if-ne v0, v2, :cond_4

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    invoke-static/range {v20 .. v21}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    if-eqz v17, :cond_4

    if-eqz v1, :cond_4

    .line 5163
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$1200(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v7

    move-object/from16 v0, p1

    iget-wide v8, v0, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    move-object/from16 v0, p1

    iget-wide v10, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    sget-object v13, Lcom/google/android/gm/provider/Gmail$AttachmentRendition;->BEST:Lcom/google/android/gm/provider/Gmail$AttachmentRendition;

    const/16 v16, 0x0

    move-object v12, v4

    move v14, v6

    invoke-virtual/range {v7 .. v16}, Lcom/google/android/gm/provider/AttachmentManager;->enqueueAttachment(JJLcom/google/android/gm/provider/Gmail$Attachment;Lcom/google/android/gm/provider/Gmail$AttachmentRendition;ZZI)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_4

    .line 5258
    :catchall_0
    move-exception v1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 5259
    const-string v2, "post body"

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 5260
    invoke-virtual/range {v18 .. v18}, Landroid/util/TimingLogger;->dumpToLog()V

    throw v1

    .line 5077
    :cond_6
    const/4 v1, 0x0

    goto/16 :goto_0

    .line 5088
    :cond_7
    :try_start_1
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    const-string v2, "gmail_db_compression_threshold"

    const/16 v3, 0x64

    invoke-static {v1, v2, v3}, Lcom/google/android/gsf/Gservices;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v1

    .line 5091
    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    if-ge v2, v1, :cond_8

    .line 5092
    const-string v1, "body"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5093
    const-string v1, "bodyCompressed"

    move-object/from16 v0, v19

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_1

    .line 5096
    :cond_8
    :try_start_2
    const-string v1, "bodyCompressed"

    move-object/from16 v0, p1

    iget-object v2, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    const-string v3, "UTF-8"

    invoke-virtual {v2, v3}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gm/provider/ZipUtils;->deflate([B)[B

    move-result-object v2

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 5098
    const-string v1, "body"

    move-object/from16 v0, v19

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->putNull(Ljava/lang/String;)V
    :try_end_2
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_1

    .line 5099
    :catch_0
    move-exception v1

    .line 5101
    :try_start_3
    new-instance v1, Ljava/lang/IllegalStateException;

    const-string v2, "UTF-8 not supported"

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 5108
    :cond_9
    const/4 v1, 0x0

    goto/16 :goto_2

    .line 5130
    :cond_a
    const/4 v1, 0x0

    move/from16 v17, v1

    goto/16 :goto_3

    .line 5170
    :cond_b
    # invokes: Lcom/google/android/gm/provider/MailEngine;->joinedAttachmentsString(Lcom/google/android/gm/provider/MailSync$Message;)Ljava/lang/String;
    invoke-static/range {p1 .. p1}, Lcom/google/android/gm/provider/MailEngine;->access$2500(Lcom/google/android/gm/provider/MailSync$Message;)Ljava/lang/String;

    move-result-object v1

    .line 5174
    :goto_5
    const-string v2, "joinedAttachmentInfos"

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 5177
    const-wide/16 v4, 0x0

    .line 5178
    const/4 v3, 0x0

    .line 5179
    const/4 v2, 0x0

    .line 5180
    const/4 v1, 0x0

    .line 5181
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v7, 0x4

    new-array v7, v7, [Ljava/lang/String;

    const/4 v8, 0x0

    const-string v9, "conversation"

    aput-object v9, v7, v8

    const/4 v8, 0x1

    const-string v9, "queryId"

    aput-object v9, v7, v8

    const/4 v8, 0x2

    const-string v9, "joinedAttachmentInfos"

    aput-object v9, v7, v8

    const/4 v8, 0x3

    const-string v9, "clientCreated"

    aput-object v9, v7, v8

    move-object/from16 v0, p1

    iget-wide v8, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-virtual {v6, v7, v8, v9}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForMessageId([Ljava/lang/String;J)Landroid/database/Cursor;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v6

    .line 5190
    :try_start_4
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v7

    if-eqz v7, :cond_16

    .line 5191
    const/4 v1, 0x0

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 5192
    const/4 v1, 0x1

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-nez v1, :cond_f

    const/4 v3, 0x1

    .line 5193
    :goto_6
    const/4 v1, 0x2

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 5194
    const/4 v1, 0x3

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    sget-object v7, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->CLIENT_CREATED:Lcom/google/android/gm/provider/MailEngine$ClientCreated;

    # getter for: Lcom/google/android/gm/provider/MailEngine$ClientCreated;->mValue:I
    invoke-static {v7}, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->access$2600(Lcom/google/android/gm/provider/MailEngine$ClientCreated;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    move-result v7

    if-ne v1, v7, :cond_10

    const/4 v1, 0x1

    :goto_7
    move-object/from16 v23, v2

    move/from16 v24, v3

    move-wide v2, v4

    move-object/from16 v4, v23

    move/from16 v5, v24

    .line 5198
    :goto_8
    :try_start_5
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 5201
    const-wide/16 v6, 0x0

    cmp-long v6, v2, v6

    if-eqz v6, :cond_12

    .line 5202
    if-eqz v1, :cond_c

    if-eqz v4, :cond_c

    .line 5209
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    invoke-static/range {v20 .. v21}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v1, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_11

    .line 5210
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->cleanupAttachments(Ljava/lang/String;)V
    invoke-static {v1, v4}, Lcom/google/android/gm/provider/MailEngine;->access$2700(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V

    .line 5220
    :cond_c
    :goto_9
    const-wide/16 v6, 0x0

    cmp-long v1, p4, v6

    if-eqz v1, :cond_d

    if-eqz v5, :cond_d

    .line 5221
    const-string v1, "Gmail"

    const-string v4, "Message %d already synced. Keep it that way"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    move-object/from16 v0, p1

    iget-wide v7, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 5223
    const-string v1, "queryId"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 5224
    const-string v1, "synced"

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    move-object/from16 v0, v19

    invoke-virtual {v0, v1, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 5226
    :cond_d
    const-string v1, "Gmail"

    const-string v4, "Updating message %d. queryId=%d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    move-object/from16 v0, p1

    iget-wide v7, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {p4 .. p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 5227
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "messages"

    const-string v5, "messageId = ?"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    move-object/from16 v0, p1

    iget-wide v8, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v8, v9}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    move-object/from16 v0, v19

    invoke-virtual {v1, v4, v0, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v1

    .line 5230
    const/4 v4, 0x1

    if-eq v1, v4, :cond_13

    .line 5231
    new-instance v2, Landroid/database/SQLException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "surprising number of rows updated: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v2, v1}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 5172
    :cond_e
    const-string v1, ""

    goto/16 :goto_5

    .line 5192
    :cond_f
    const/4 v3, 0x0

    goto/16 :goto_6

    .line 5194
    :cond_10
    const/4 v1, 0x0

    goto/16 :goto_7

    .line 5198
    :catchall_1
    move-exception v1

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    throw v1

    .line 5217
    :cond_11
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    move-object/from16 v0, v19

    # invokes: Lcom/google/android/gm/provider/MailEngine;->updateCachedAttachmentReferences(Landroid/content/ContentValues;Ljava/lang/String;)V
    invoke-static {v1, v0, v4}, Lcom/google/android/gm/provider/MailEngine;->access$2800(Lcom/google/android/gm/provider/MailEngine;Landroid/content/ContentValues;Ljava/lang/String;)V

    goto/16 :goto_9

    .line 5235
    :cond_12
    const-string v1, "Gmail"

    const-string v4, "Inserting message %d. queryId=%d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    move-object/from16 v0, p1

    iget-wide v7, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-static/range {p4 .. p5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v1, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 5236
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "messages"

    const/4 v5, 0x0

    move-object/from16 v0, v19

    invoke-virtual {v1, v4, v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    move-result-wide v4

    .line 5237
    const-wide/16 v6, -0x1

    cmp-long v1, v4, v6

    if-nez v1, :cond_13

    .line 5238
    new-instance v1, Landroid/database/SQLException;

    const-string v2, "error inserting message"

    invoke-direct {v1, v2}, Landroid/database/SQLException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 5241
    :cond_13
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/google/android/gm/provider/MailSync$Message;->body:Ljava/lang/String;

    if-eqz v1, :cond_14

    const-wide/16 v4, 0x0

    cmp-long v1, p4, v4

    if-nez v1, :cond_14

    .line 5243
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->requestIndex()V
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$2900(Lcom/google/android/gm/provider/MailEngine;)V

    .line 5246
    :cond_14
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, p1

    iget-wide v4, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    invoke-virtual {v1, v4, v5, v6}, Lcom/google/android/gm/provider/MailCore;->setLabelsOnMessageWithoutWritingOperations(JLjava/util/Set;)V

    .line 5249
    sget-object v4, Lcom/google/android/gm/provider/MailSync$SyncRationale;->UNKNOWN:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    .line 5251
    const-wide/16 v5, 0x0

    cmp-long v1, v2, v5

    if-eqz v1, :cond_15

    move-object/from16 v0, p1

    iget-wide v5, v0, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    cmp-long v1, v2, v5

    if-eqz v1, :cond_15

    .line 5253
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v5, 0x1

    const/4 v6, 0x0

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v1 .. v6}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 5256
    :cond_15
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 5258
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 5259
    const-string v1, "post body"

    move-object/from16 v0, v18

    invoke-virtual {v0, v1}, Landroid/util/TimingLogger;->addSplit(Ljava/lang/String;)V

    .line 5260
    invoke-virtual/range {v18 .. v18}, Landroid/util/TimingLogger;->dumpToLog()V

    .line 5262
    return-void

    :cond_16
    move-object/from16 v23, v2

    move/from16 v24, v3

    move-wide v2, v4

    move-object/from16 v4, v23

    move/from16 v5, v24

    goto/16 :goto_8
.end method

.method public addSendWithoutSyncConversationInfoToCheck(JJ)V
    .locals 6
    .param p1, "conversationId"    # J
    .param p3, "highestMessageIdOnServer"    # J

    .prologue
    .line 4650
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->getMaxMessageIdForConversation(J)J

    move-result-wide v1

    .line 4652
    .local v1, "highestMessageIdOnDevice":J
    cmp-long v3, v1, p3

    if-gez v3, :cond_0

    .line 4653
    const-string v3, "Gmail"

    const-string v4, "  device is lower than server. Will check conversation"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4658
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 4659
    .local v0, "conversationsValues":Landroid/content/ContentValues;
    const-string v3, "_id"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v0, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4660
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "send_without_sync_conversations_to_fetch"

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 4668
    .end local v0    # "conversationsValues":Landroid/content/ContentValues;
    :cond_0
    return-void
.end method

.method public addSyncedConversationInfoToCheck(JJ)V
    .locals 16
    .param p1, "conversationId"    # J
    .param p3, "highestMessageIdOnServer"    # J

    .prologue
    .line 4696
    const-string v9, ""

    .line 4698
    .local v9, "existingSyncRationale":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "SELECT syncRationale FROM conversations WHERE _id = ?"

    invoke-virtual {v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->compileStatement(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;

    move-result-object v13

    .line 4701
    .local v13, "statement":Landroid/database/sqlite/SQLiteStatement;
    const/4 v2, 0x1

    :try_start_0
    move-wide/from16 v0, p1

    invoke-virtual {v13, v2, v0, v1}, Landroid/database/sqlite/SQLiteStatement;->bindLong(IJ)V

    .line 4702
    invoke-virtual {v13}, Landroid/database/sqlite/SQLiteStatement;->simpleQueryForString()Ljava/lang/String;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteDoneException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v9

    .line 4706
    invoke-virtual {v13}, Landroid/database/sqlite/SQLiteStatement;->close()V

    .line 4709
    :goto_0
    sget-object v2, Lcom/google/android/gm/provider/MailSync$SyncRationale;->NONE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/MailSync$SyncRationale;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 4710
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4712
    :try_start_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    sget-object v5, Lcom/google/android/gm/provider/MailSync$SyncRationale;->UNKNOWN:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v6, 0x1

    const/4 v7, 0x0

    move-wide/from16 v3, p1

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v2 .. v7}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4714
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 4716
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4725
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 4726
    .local v8, "conversationsValues":Landroid/content/ContentValues;
    const-string v2, "_id"

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4727
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "conversations_to_fetch"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v8}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 4765
    .end local v8    # "conversationsValues":Landroid/content/ContentValues;
    :cond_0
    :goto_1
    return-void

    .line 4703
    :catch_0
    move-exception v2

    .line 4706
    invoke-virtual {v13}, Landroid/database/sqlite/SQLiteStatement;->close()V

    goto :goto_0

    :catchall_0
    move-exception v2

    invoke-virtual {v13}, Landroid/database/sqlite/SQLiteStatement;->close()V

    throw v2

    .line 4716
    :catchall_1
    move-exception v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v2

    .line 4731
    :cond_1
    invoke-direct/range {p0 .. p2}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->getMaxMessageIdForConversation(J)J

    move-result-wide v11

    .line 4733
    .local v11, "highestMessageIdOnDevice":J
    cmp-long v2, v11, p3

    if-gez v2, :cond_2

    .line 4734
    const-string v2, "Gmail"

    const-string v3, "  device is lower than server. Will check conversation"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4739
    new-instance v8, Landroid/content/ContentValues;

    invoke-direct {v8}, Landroid/content/ContentValues;-><init>()V

    .line 4740
    .restart local v8    # "conversationsValues":Landroid/content/ContentValues;
    const-string v2, "_id"

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v8, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4741
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "conversations_to_fetch"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v8}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto :goto_1

    .line 4750
    .end local v8    # "conversationsValues":Landroid/content/ContentValues;
    :cond_2
    const-wide/16 v2, 0x0

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "select count(*) from messages where messageId = ? and queryId = 0"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v15

    aput-object v15, v6, v7

    invoke-static {v4, v5, v6}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-eqz v2, :cond_3

    const/4 v10, 0x1

    .line 4754
    .local v10, "haveMessage":Z
    :goto_2
    if-nez v10, :cond_4

    .line 4755
    const-string v2, "Gmail"

    const-string v3, "  we do not have the server\'s message. Will check message"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4757
    new-instance v14, Landroid/content/ContentValues;

    invoke-direct {v14}, Landroid/content/ContentValues;-><init>()V

    .line 4758
    .local v14, "values":Landroid/content/ContentValues;
    const-string v2, "_id"

    invoke-static/range {p3 .. p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v14, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 4759
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "messages_to_fetch"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v14}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    goto/16 :goto_1

    .line 4750
    .end local v10    # "haveMessage":Z
    .end local v14    # "values":Landroid/content/ContentValues;
    :cond_3
    const/4 v10, 0x0

    goto :goto_2

    .line 4762
    .restart local v10    # "haveMessage":Z
    :cond_4
    const-string v2, "Gmail"

    const/4 v3, 0x2

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 4763
    const-string v2, "Gmail"

    const-string v3, "  nothing to check"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto/16 :goto_1
.end method

.method public commit()V
    .locals 1

    .prologue
    .line 4335
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V

    .line 4336
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4337
    return-void
.end method

.method public delayConversationSync(J)V
    .locals 13

    .prologue
    const-wide/16 v2, 0x7

    const/4 v12, 0x2

    const/4 v11, 0x0

    const/4 v10, 0x1

    .line 5001
    new-array v4, v10, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v11

    .line 5002
    const-string v0, "_id = ?"

    .line 5004
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "SELECT numAttempts FROM conversations_to_fetch WHERE _id = ?"

    invoke-static {v0, v1, v4}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v5

    .line 5006
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailSync;->getConversationAgeDays()J

    move-result-wide v0

    .line 5007
    const-wide/16 v7, 0x0

    cmp-long v7, v0, v7

    if-lez v7, :cond_0

    cmp-long v7, v0, v2

    if-lez v7, :cond_1

    :cond_0
    move-wide v0, v2

    .line 5010
    :cond_1
    const-wide/16 v2, 0x4

    add-long/2addr v0, v2

    cmp-long v0, v5, v0

    if-lez v0, :cond_3

    .line 5012
    const-string v0, "Gmail"

    const-string v1, "Giving up on conversation %d after %d attempts"

    new-array v2, v12, [Ljava/lang/Object;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v11

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    aput-object v3, v2, v10

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 5013
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "conversations_to_fetch"

    const-string v2, "_id = ?"

    invoke-virtual {v0, v1, v2, v4}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 5030
    :cond_2
    :goto_0
    return-void

    .line 5015
    :cond_3
    long-to-int v0, v5

    shl-int v0, v10, v0

    const/16 v1, 0x18

    invoke-static {v0, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 5016
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v1

    mul-int/lit8 v3, v0, 0x3c

    mul-int/lit8 v3, v3, 0x3c

    mul-int/lit16 v3, v3, 0x3e8

    int-to-long v7, v3

    add-long/2addr v1, v7

    .line 5017
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 5018
    const-string v7, "nextAttemptDateMs"

    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    invoke-virtual {v3, v7, v8}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5019
    const-string v7, "numAttempts"

    const-wide/16 v8, 0x1

    add-long/2addr v5, v8

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v3, v7, v5}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 5020
    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v5, v5, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v6, "conversations_to_fetch"

    const-string v7, "_id = ?"

    invoke-virtual {v5, v6, v3, v7, v4}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 5025
    const-string v3, "Gmail"

    const/4 v4, 0x4

    invoke-static {v3, v4}, Lcom/google/android/gm/provider/LogUtils;->isLoggable(Ljava/lang/String;I)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 5026
    const-string v3, "Gmail"

    const-string v4, "Delayed sync of conversation %d by %d hours till after %s"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v11

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v5, v10

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    aput-object v0, v5, v12

    invoke-static {v3, v4, v5}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    goto :goto_0
.end method

.method public deleteCorruptedMessage(JJ)V
    .locals 5

    .prologue
    .line 5033
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DELETE FROM messages WHERE conversation = ? AND messageId >= ?"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-static {p3, p4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-virtual {v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 5035
    return-void
.end method

.method public deleteLabel(Lcom/google/android/gm/provider/MailCore$Label;)V
    .locals 2
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 4544
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4546
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->deleteLabel(Lcom/google/android/gm/provider/MailCore$Label;)V

    .line 4547
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V

    .line 4548
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4550
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4552
    return-void

    .line 4550
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
.end method

.method public expungeMessages(JLjava/util/List;Lcom/google/android/gm/provider/MailSync$SyncRationale;)V
    .locals 6
    .param p1, "conversationId"    # J
    .param p4, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/google/android/gm/provider/MailSync$SyncRationale;",
            ")V"
        }
    .end annotation

    .prologue
    .line 4247
    .local p3, "messageIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4249
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p3}, Lcom/google/android/gm/provider/MailCore;->expungeMessagesWithoutWritingOperations(Ljava/util/List;)V

    .line 4250
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v4, 0x1

    const/4 v5, 0x0

    move-wide v1, p1

    move-object v3, p4

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4252
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4254
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4256
    return-void

    .line 4254
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
.end method

.method public getAccount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 5266
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v0

    iget-object v0, v0, Landroid/accounts/Account;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getConversationInfosToFetch(Lcom/google/android/gm/provider/MailEngine$SyncInfo;)Ljava/util/ArrayList;
    .locals 16
    .param p1, "syncInfo"    # Lcom/google/android/gm/provider/MailEngine$SyncInfo;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gm/provider/MailEngine$SyncInfo;",
            ")",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/google/android/gm/provider/MailSync$ConversationInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 4837
    if-eqz p1, :cond_0

    move-object/from16 v0, p1

    iget-boolean v14, v0, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    if-eqz v14, :cond_1

    .line 4838
    :cond_0
    new-instance v14, Ljava/util/Date;

    invoke-direct {v14}, Ljava/util/Date;-><init>()V

    invoke-virtual {v14}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    .line 4839
    .local v5, "cutoff":J
    const-string v13, "select conversations_to_fetch._id as _id,   max(\n    case when not clientCreated then messages.messageId else 0 end)\n    as highestMessageId,   max(messages.clientCreated) as hasClientCreatedMessages from   conversations_to_fetch left outer join messages on   messages.conversation = conversations_to_fetch._id   and messages.queryId = 0 where nextAttemptDateMs < ?group by conversations_to_fetch._id order by conversations_to_fetch._id desc limit 50"

    .line 4853
    .local v13, "query":Ljava/lang/String;
    const/4 v14, 0x1

    new-array v1, v14, [Ljava/lang/String;

    const/4 v14, 0x0

    invoke-static {v5, v6}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v15

    aput-object v15, v1, v14

    .line 4871
    .end local v5    # "cutoff":J
    .local v1, "args":[Ljava/lang/String;
    :goto_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v14, v14, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v14, v13, v1}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v4

    .line 4872
    .local v4, "cursor":Landroid/database/Cursor;
    const-string v14, "_id"

    invoke-interface {v4, v14}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v10

    .line 4873
    .local v10, "idIndex":I
    const-string v14, "highestMessageId"

    invoke-interface {v4, v14}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v9

    .line 4876
    .local v9, "highestMessageIdIndex":I
    :try_start_0
    new-instance v12, Ljava/util/ArrayList;

    invoke-direct {v12}, Ljava/util/ArrayList;-><init>()V

    .line 4878
    .local v12, "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gm/provider/MailSync$ConversationInfo;>;"
    :goto_1
    invoke-interface {v4}, Landroid/database/Cursor;->moveToNext()Z

    move-result v14

    if-eqz v14, :cond_2

    .line 4879
    invoke-interface {v4, v10}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    .line 4880
    .local v2, "conversationId":J
    invoke-interface {v4, v9}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v7

    .line 4881
    .local v7, "highestFetchedMessageId":J
    new-instance v11, Lcom/google/android/gm/provider/MailSync$ConversationInfo;

    invoke-direct {v11, v2, v3, v7, v8}, Lcom/google/android/gm/provider/MailSync$ConversationInfo;-><init>(JJ)V

    .line 4883
    .local v11, "info":Lcom/google/android/gm/provider/MailSync$ConversationInfo;
    invoke-virtual {v12, v11}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 4887
    .end local v2    # "conversationId":J
    .end local v7    # "highestFetchedMessageId":J
    .end local v11    # "info":Lcom/google/android/gm/provider/MailSync$ConversationInfo;
    .end local v12    # "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gm/provider/MailSync$ConversationInfo;>;"
    :catchall_0
    move-exception v14

    invoke-interface {v4}, Landroid/database/Cursor;->close()V

    throw v14

    .line 4855
    .end local v1    # "args":[Ljava/lang/String;
    .end local v4    # "cursor":Landroid/database/Cursor;
    .end local v9    # "highestMessageIdIndex":I
    .end local v10    # "idIndex":I
    .end local v13    # "query":Ljava/lang/String;
    :cond_1
    const-string v13, "select send_without_sync_conversations_to_fetch._id as _id,   max(\n    case when not clientCreated then messages.messageId else 0 end)\n    as highestMessageId,   max(messages.clientCreated) as hasClientCreatedMessages from   send_without_sync_conversations_to_fetch left outer join messages on   messages.conversation = send_without_sync_conversations_to_fetch._id   and messages.queryId = 0 group by send_without_sync_conversations_to_fetch._id order by send_without_sync_conversations_to_fetch._id desc limit 50"

    .line 4868
    .restart local v13    # "query":Ljava/lang/String;
    const/4 v1, 0x0

    .restart local v1    # "args":[Ljava/lang/String;
    goto :goto_0

    .line 4887
    .restart local v4    # "cursor":Landroid/database/Cursor;
    .restart local v9    # "highestMessageIdIndex":I
    .restart local v10    # "idIndex":I
    .restart local v12    # "infos":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/google/android/gm/provider/MailSync$ConversationInfo;>;"
    :cond_2
    invoke-interface {v4}, Landroid/database/Cursor;->close()V

    return-object v12
.end method

.method public getDirtyConversations()Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 4984
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    .line 4986
    .local v3, "ids":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "SELECT DISTINCT _id FROM conversations WHERE dirty = 1"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 4989
    .local v0, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 4990
    const/4 v4, 0x0

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 4991
    .local v1, "id":J
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 4994
    .end local v1    # "id":J
    :catchall_0
    move-exception v4

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v4

    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 4996
    return-object v3
.end method

.method public getInputStreamForUploadedAttachment(JLcom/google/android/gm/provider/Gmail$Attachment;)Ljava/io/InputStream;
    .locals 11
    .param p1, "messageId"    # J
    .param p3, "attachment"    # Lcom/google/android/gm/provider/Gmail$Attachment;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/FileNotFoundException;,
            Ljava/lang/SecurityException;
        }
    .end annotation

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 4926
    iget-object v4, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-static {v4}, Lcom/google/android/common/base/Strings;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 4927
    const-string v4, "Gmail"

    const-string v5, "Loading cached attachment: %s"

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    aput-object v7, v6, v9

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4929
    :try_start_0
    new-instance v0, Ljava/io/FileInputStream;

    iget-object v4, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    invoke-direct {v0, v4}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 4957
    :goto_0
    return-object v0

    .line 4930
    :catch_0
    move-exception v1

    .line 4931
    .local v1, "e":Ljava/io/IOException;
    const-string v4, "Gmail"

    const-string v5, "Failed to load cached attachment %s. Will attempt original URI %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    iget-object v7, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->cachedContent:Ljava/lang/String;

    aput-object v7, v6, v9

    iget-object v7, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v7, v6, v10

    invoke-static {v4, v1, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4937
    .end local v1    # "e":Ljava/io/IOException;
    :cond_0
    const/4 v0, 0x0

    .line 4942
    .local v0, "attachmentStream":Ljava/io/InputStream;
    :try_start_1
    iget-object v4, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 4943
    .local v3, "uri":Landroid/net/Uri;
    const-string v4, "Gmail"

    const-string v5, "Loading attachment URI: %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    iget-object v8, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4944
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mContext:Landroid/content/Context;
    invoke-static {v4}, Lcom/google/android/gm/provider/MailEngine;->access$2300(Lcom/google/android/gm/provider/MailEngine;)Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/content/ContentResolver;->openInputStream(Landroid/net/Uri;)Ljava/io/InputStream;
    :try_end_1
    .catch Ljava/io/FileNotFoundException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v0

    goto :goto_0

    .line 4945
    .end local v3    # "uri":Landroid/net/Uri;
    :catch_1
    move-exception v2

    .line 4946
    .local v2, "exception":Ljava/io/FileNotFoundException;
    const-string v4, "Gmail"

    const-string v5, "Failed to attach %s due to a FileNotFoundException. Since the cached file has already been tried, this file cannotbe attached. Notify the user."

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v7, v6, v9

    invoke-static {v4, v2, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4949
    throw v2

    .line 4950
    .end local v2    # "exception":Ljava/io/FileNotFoundException;
    :catch_2
    move-exception v2

    .line 4951
    .local v2, "exception":Ljava/lang/SecurityException;
    const-string v4, "Gmail"

    const-string v5, "Failed to attach %s due to a SecurityException. Since the cached file has already been tried, this file cannot be attached. Notify the user."

    new-array v6, v10, [Ljava/lang/Object;

    iget-object v7, p3, Lcom/google/android/gm/provider/Gmail$Attachment;->originExtras:Ljava/lang/String;

    aput-object v7, v6, v9

    invoke-static {v4, v2, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4955
    throw v2
.end method

.method public getLabelCanonicalNameOrNull(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;
    .locals 1
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;

    .prologue
    .line 4594
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->getLabelCanonicalNameOrNull(Lcom/google/android/gm/provider/MailCore$Label;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getLabelOrNull(J)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 1
    .param p1, "labelId"    # J

    .prologue
    .line 4584
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/MailCore;->getLabelOrNull(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    return-object v0
.end method

.method public getMessageCursorForConversationId([Ljava/lang/String;J)Landroid/database/Cursor;
    .locals 1
    .param p1, "projection"    # [Ljava/lang/String;
    .param p2, "conversationId"    # J

    .prologue
    .line 4404
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0, p1, p2, p3}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForConversationId([Ljava/lang/String;J)Landroid/database/Cursor;

    move-result-object v0

    return-object v0
.end method

.method public getMessageIdsToFetch()Ljava/util/ArrayList;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation

    .prologue
    .line 4893
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v3

    .line 4895
    .local v3, "messageIds":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Long;>;"
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "select _id from messages_to_fetch"

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    .line 4898
    .local v0, "cursor":Landroid/database/Cursor;
    :goto_0
    :try_start_0
    invoke-interface {v0}, Landroid/database/Cursor;->moveToNext()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 4899
    const/4 v4, 0x0

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    .line 4900
    .local v1, "messageId":J
    invoke-static {v1, v2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 4903
    .end local v1    # "messageId":J
    :catchall_0
    move-exception v4

    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    throw v4

    :cond_0
    invoke-interface {v0}, Landroid/database/Cursor;->close()V

    .line 4906
    return-object v3
.end method

.method public getOrAddLabel(J)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 1
    .param p1, "labelId"    # J

    .prologue
    .line 4574
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/MailCore;->getOrAddLabel(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    return-object v0
.end method

.method public getOrAddLabel(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    .locals 1
    .param p1, "canonicalName"    # Ljava/lang/String;

    .prologue
    .line 4569
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->getOrAddLabel(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v0

    return-object v0
.end method

.method public handleConversation(Lcom/google/android/gm/provider/MailSync$Conversation;)V
    .locals 4
    .param p1, "conversation"    # Lcom/google/android/gm/provider/MailSync$Conversation;

    .prologue
    .line 4409
    const-string v0, "Gmail"

    const-string v1, "Got conversation header with MainSync: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p1, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4410
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const-wide/16 v1, 0x0

    const/4 v3, 0x0

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/google/android/gm/provider/MailEngine;->handleConversation(Lcom/google/android/gm/provider/MailSync$Conversation;JLcom/google/android/gm/provider/MailCore$Label;)J

    .line 4414
    return-void
.end method

.method public isSyncConfigKey(Ljava/lang/String;)Z
    .locals 1
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 4962
    const-string v0, "labelsIncluded"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "labelsPartial"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "conversationAgeDays"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "maxAttachmentSize"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 4966
    :cond_0
    const/4 v0, 0x1

    .line 4968
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public markConversationDirty(J)V
    .locals 8
    .param p1, "conversationId"    # J

    .prologue
    const/4 v5, 0x1

    const/4 v7, 0x0

    .line 4973
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 4974
    .local v1, "values":Landroid/content/ContentValues;
    const-string v2, "dirty"

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 4975
    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v3, "conversations"

    const-string v4, "_id = ?"

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v2, v3, v1, v4, v5}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 4977
    .local v0, "updated":I
    if-nez v0, :cond_0

    .line 4978
    const-string v2, "Gmail"

    const-string v3, "Failed to mark conversation as dirty"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v2, v3, v4}, Lcom/google/android/gm/provider/LogUtils;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4980
    :cond_0
    return-void
.end method

.method public notifyConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;)V
    .locals 6
    .param p1, "conversationId"    # J
    .param p3, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;

    .prologue
    .line 4817
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4819
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v4, 0x1

    const/4 v5, 0x0

    move-wide v1, p1

    move-object v3, p3

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4821
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4823
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4825
    return-void

    .line 4823
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
.end method

.method public notifyConversationLoaded(JLcom/google/android/gm/provider/MailSync$SyncRationale;Lcom/google/android/gm/provider/MailEngine$SyncInfo;)V
    .locals 6
    .param p1, "conversationId"    # J
    .param p3, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;
    .param p4, "syncInfo"    # Lcom/google/android/gm/provider/MailEngine$SyncInfo;

    .prologue
    .line 4771
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4773
    :try_start_0
    iget-boolean v0, p4, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    if-eqz v0, :cond_0

    .line 4774
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "conversations_to_fetch"

    const-string v2, "_id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4794
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "conversations_to_fetch"

    const-string v2, "_id in (SELECT messageId FROM messages WHERE conversation = ?)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4808
    :goto_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4810
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4812
    return-void

    .line 4799
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "send_without_sync_conversations_to_fetch"

    const-string v2, "_id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4801
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "send_without_sync_conversations_to_fetch"

    const-string v2, "_id in (SELECT messageId FROM messages WHERE conversation = ?)"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 4810
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
.end method

.method public notifyLabelChanges(Ljava/util/Set;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/Long;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 4492
    .local p1, "labelIds":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V
    invoke-static {v0, p1}, Lcom/google/android/gm/provider/MailEngine;->access$1400(Lcom/google/android/gm/provider/MailEngine;Ljava/util/Set;)V

    .line 4493
    return-void
.end method

.method public notifyMessageDoesNotExist(J)V
    .locals 6
    .param p1, "messageId"    # J

    .prologue
    .line 4829
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "messages_to_fetch"

    const-string v2, "_id = ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4830
    return-void
.end method

.method public notifyMessageNotUpdated(JLjava/lang/String;)V
    .locals 10
    .param p1, "messageId"    # J
    .param p3, "error"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 4346
    new-instance v3, Landroid/content/ContentValues;

    invoke-direct {v3}, Landroid/content/ContentValues;-><init>()V

    .line 4347
    .local v3, "values":Landroid/content/ContentValues;
    const-string v4, "error"

    invoke-virtual {v3, v4, p3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 4348
    new-array v0, v9, [Ljava/lang/String;

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v0, v8

    .line 4349
    .local v0, "args":[Ljava/lang/String;
    const-string v4, "dup"

    invoke-virtual {v4, p3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 4350
    const-string v4, "Gmail"

    const-string v5, "Deleting message %d"

    new-array v6, v9, [Ljava/lang/Object;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-static {v4, v5, v6}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4351
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "SELECT conversation FROM messages WHERE messageId=?"

    invoke-static {v4, v5, v0}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v1

    .line 4355
    .local v1, "conversationId":J
    new-array v4, v9, [Ljava/lang/Long;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v4, v8

    invoke-static {v4}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v4

    sget-object v5, Lcom/google/android/gm/provider/MailSync$SyncRationale;->LOCAL_CHANGE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-virtual {p0, v1, v2, v4, v5}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->expungeMessages(JLjava/util/List;Lcom/google/android/gm/provider/MailSync$SyncRationale;)V

    .line 4362
    .end local v1    # "conversationId":J
    :goto_0
    return-void

    .line 4360
    :cond_0
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v5, "messages"

    const-string v6, "messageId = ?"

    invoke-virtual {v4, v5, v3, v6, v0}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0
.end method

.method public prepare()V
    .locals 2

    .prologue
    .line 4330
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4331
    return-void
.end method

.method public provideOperations(Lcom/google/android/gm/provider/MailStore$OperationSink;Lcom/google/android/gm/provider/MailEngine$SyncInfo;J)V
    .locals 6
    .param p1, "sink"    # Lcom/google/android/gm/provider/MailStore$OperationSink;
    .param p2, "syncInfo"    # Lcom/google/android/gm/provider/MailEngine$SyncInfo;
    .param p3, "currentTime"    # J

    .prologue
    .line 4640
    iget-boolean v0, p2, Lcom/google/android/gm/provider/MailEngine$SyncInfo;->normalSync:Z

    if-eqz v0, :cond_0

    .line 4641
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    move-object v1, p1

    move-object v3, p2

    move-wide v4, p3

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/Operations;->provideNormalOperations(Lcom/google/android/gm/provider/MailStore$OperationSink;Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$SyncInfo;J)V

    .line 4645
    :goto_0
    return-void

    .line 4643
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    move-object v1, p1

    move-object v3, p2

    move-wide v4, p3

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/Operations;->provideOperations(Lcom/google/android/gm/provider/MailStore$OperationSink;Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailEngine$SyncInfo;J)V

    goto :goto_0
.end method

.method public removeCustomFromPreference(Ljava/lang/String;)V
    .locals 2
    .param p1, "preferenceName"    # Ljava/lang/String;

    .prologue
    .line 4624
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v1

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, p1}, Lcom/google/android/gm/provider/MailCore;->removeCustomFromPreference(Ljava/lang/String;Ljava/lang/String;)V

    .line 4625
    return-void
.end method

.method public removeOperationByMessageId(J)V
    .locals 1
    .param p1, "messageId"    # J

    .prologue
    .line 4916
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    invoke-virtual {v0, p1, p2}, Lcom/google/android/gm/provider/Operations;->deleteOperationsForMessageId(J)V

    .line 4917
    return-void
.end method

.method public removeOperations(J)V
    .locals 6
    .param p1, "maxOperationId"    # J

    .prologue
    .line 4911
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "operations"

    const-string v2, "_id <= ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {p1, p2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {v0, v1, v2, v3}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4912
    return-void
.end method

.method public renameLabel(Lcom/google/android/gm/provider/MailCore$Label;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 6
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p2, "canonicalName"    # Ljava/lang/String;
    .param p3, "name"    # Ljava/lang/String;
    .param p4, "color"    # I
    .param p5, "visibility"    # Ljava/lang/String;

    .prologue
    .line 4557
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4559
    :try_start_0
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailCore;->renameLabel(Lcom/google/android/gm/provider/MailCore$Label;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 4560
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V

    .line 4561
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4563
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4565
    return-void

    .line 4563
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0
.end method

.method public setCustomFromPreference(Ljava/util/Map;Z)V
    .locals 2
    .param p2, "isStartSync"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/MailStore$CustomFromPreference;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 4613
    .local p1, "fromPreferences":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomFromPreference;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v1

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, p1, p2}, Lcom/google/android/gm/provider/MailCore;->setCustomFromPreference(Ljava/lang/String;Ljava/util/Map;Z)V

    .line 4614
    return-void
.end method

.method public setCustomLabelColorPreference(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 4607
    .local p1, "colorPreferences":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Lcom/google/android/gm/provider/MailStore$CustomLabelColorPreference;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v1

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, p1}, Lcom/google/android/gm/provider/MailCore;->setCustomLabelColorPreference(Ljava/lang/String;Ljava/util/Map;)V

    .line 4608
    return-void
.end method

.method public setInfoOverloadArrowsOffPreference(Ljava/lang/String;)V
    .locals 1
    .param p1, "infoOverloadArrowsOffPref"    # Ljava/lang/String;

    .prologue
    .line 4634
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->setInfoOverloadArrowsOffPreference(Ljava/lang/String;)V

    .line 4635
    return-void
.end method

.method public setInfoOverloadEnabledPreference(Ljava/lang/String;)V
    .locals 1
    .param p1, "infoOverloadEnabledPref"    # Ljava/lang/String;

    .prologue
    .line 4629
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, p1}, Lcom/google/android/gm/provider/MailCore;->setInfoOverloadEnabledPreference(Ljava/lang/String;)V

    .line 4630
    return-void
.end method

.method public setLabelCounts(Lcom/google/android/gm/provider/MailCore$Label;IIILjava/lang/String;)V
    .locals 6
    .param p1, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p2, "conversations"    # I
    .param p3, "unreadConversations"    # I
    .param p4, "color"    # I
    .param p5, "visibility"    # Ljava/lang/String;

    .prologue
    .line 4600
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object v1, p1

    move v2, p2

    move v3, p3

    move v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailCore;->setLabelCounts(Lcom/google/android/gm/provider/MailCore$Label;IIILjava/lang/String;)V

    .line 4602
    return-void
.end method

.method public setLabelOnMessages(JLjava/util/List;Lcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/MailSync$SyncRationale;)V
    .locals 13
    .param p1, "conversationId"    # J
    .param p4, "label"    # Lcom/google/android/gm/provider/MailCore$Label;
    .param p5, "on"    # Z
    .param p6, "rationale"    # Lcom/google/android/gm/provider/MailSync$SyncRationale;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Long;",
            ">;",
            "Lcom/google/android/gm/provider/MailCore$Label;",
            "Z",
            "Lcom/google/android/gm/provider/MailSync$SyncRationale;",
            ")V"
        }
    .end annotation

    .prologue
    .line 4367
    .local p3, "messageIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v4}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4369
    const/4 v10, 0x0

    .line 4370
    .local v10, "changed":Z
    :try_start_0
    invoke-interface/range {p3 .. p3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    .local v11, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Long;

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 4371
    .local v2, "messageId":J
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "SELECT COUNT(*) FROM messages WHERE messageId = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v1, v4, v5}, Landroid/database/DatabaseUtils;->longForQuery(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v1, v4, v6

    if-lez v1, :cond_1

    const/4 v12, 0x1

    .line 4375
    .local v12, "messageExists":Z
    :goto_1
    if-eqz v12, :cond_0

    .line 4376
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    sget-object v6, Lcom/google/android/gm/provider/Operations$RecordHistory;->FALSE:Lcom/google/android/gm/provider/Operations$RecordHistory;

    move-object/from16 v4, p4

    move/from16 v5, p5

    invoke-virtual/range {v1 .. v6}, Lcom/google/android/gm/provider/MailCore;->setLabelOnMessage(JLcom/google/android/gm/provider/MailCore$Label;ZLcom/google/android/gm/provider/Operations$RecordHistory;)V

    .line 4378
    const/4 v10, 0x1

    goto :goto_0

    .line 4371
    .end local v12    # "messageExists":Z
    :cond_1
    const/4 v12, 0x0

    goto :goto_1

    .line 4389
    .end local v2    # "messageId":J
    :cond_2
    if-nez v10, :cond_3

    sget-object v1, Lcom/google/android/gm/provider/MailSync$SyncRationale;->NONE:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    move-object/from16 v0, p6

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailSync$SyncRationale;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 4390
    :cond_3
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v8, 0x1

    const/4 v9, 0x0

    move-wide v5, p1

    move-object/from16 v7, p6

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v4 .. v9}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4396
    :cond_4
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 4398
    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v1}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4400
    return-void

    .line 4398
    .end local v11    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v1

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v1
.end method

.method public setLabels(Ljava/util/Map;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/google/android/gm/provider/MailStore$LabelInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 4498
    .local p1, "labelInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/google/android/gm/provider/MailStore$LabelInfo;>;"
    const/4 v9, 0x0

    .line 4499
    .local v9, "labelIdsToNotify":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v2}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4501
    :try_start_0
    new-instance v10, Ljava/util/HashMap;

    invoke-direct {v10, p1}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    .line 4502
    .local v10, "mutableLabelInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/google/android/gm/provider/MailStore$LabelInfo;>;"
    invoke-interface {v10}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v9

    .line 4508
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailCore;->getAllLabels()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .local v7, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/google/android/gm/provider/MailCore$Label;

    .line 4509
    .local v1, "label":Lcom/google/android/gm/provider/MailCore$Label;
    iget-wide v2, v1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-interface {v10, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-wide v2, v1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v0

    if-nez v0, :cond_0

    .line 4511
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailCore;->deleteLabel(Lcom/google/android/gm/provider/MailCore$Label;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 4536
    .end local v1    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    .end local v7    # "i$":Ljava/util/Iterator;
    .end local v10    # "mutableLabelInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/google/android/gm/provider/MailStore$LabelInfo;>;"
    :catchall_0
    move-exception v0

    iget-object v2, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v2, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v2}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v0

    .line 4515
    .restart local v7    # "i$":Ljava/util/Iterator;
    .restart local v10    # "mutableLabelInfos":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Long;Lcom/google/android/gm/provider/MailStore$LabelInfo;>;"
    :cond_1
    :try_start_1
    invoke-interface {v10}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/Map$Entry;

    .line 4518
    .local v6, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Long;Lcom/google/android/gm/provider/MailStore$LabelInfo;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v2, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-interface {v6}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v1

    .line 4519
    .restart local v1    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    invoke-interface {v6}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;

    .line 4520
    .local v8, "info":Lcom/google/android/gm/provider/MailStore$LabelInfo;
    iget-object v0, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->canonicalName:Ljava/lang/String;

    invoke-static {v0}, Lcom/google/android/gm/provider/MailCore;->isCanonicalLabelNameLocal(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-wide v2, v1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v2, v3}, Lcom/google/android/gm/provider/MailCore;->isLabelIdLocal(J)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 4522
    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Server label appears to be local: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-wide v3, v1, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->canonicalName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 4526
    :cond_3
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v2, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->canonicalName:Ljava/lang/String;

    iget-object v3, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->name:Ljava/lang/String;

    iget v4, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->color:I

    iget-object v5, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->visibility:Ljava/lang/String;

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailCore;->renameLabel(Lcom/google/android/gm/provider/MailCore$Label;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    .line 4528
    iget v2, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->numConversations:I

    iget v3, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->numUnreadConversations:I

    iget v4, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->color:I

    iget-object v5, v8, Lcom/google/android/gm/provider/MailStore$LabelInfo;->visibility:Ljava/lang/String;

    move-object v0, p0

    invoke-virtual/range {v0 .. v5}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->setLabelCounts(Lcom/google/android/gm/provider/MailCore$Label;IIILjava/lang/String;)V

    goto :goto_1

    .line 4532
    .end local v1    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    .end local v6    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/Long;Lcom/google/android/gm/provider/MailStore$LabelInfo;>;"
    .end local v8    # "info":Lcom/google/android/gm/provider/MailStore$LabelInfo;
    :cond_4
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V

    .line 4533
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onLabelsPossiblyLoaded()V
    invoke-static {v0}, Lcom/google/android/gm/provider/MailEngine;->access$600(Lcom/google/android/gm/provider/MailEngine;)V

    .line 4534
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 4536
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4539
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->broadcastLabelNotifications(Ljava/util/Set;)V
    invoke-static {v0, v9}, Lcom/google/android/gm/provider/MailEngine;->access$1400(Lcom/google/android/gm/provider/MailEngine;Ljava/util/Set;)V

    .line 4540
    return-void
.end method

.method public setServerPreferences(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 4619
    .local p1, "serverPreferences":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v1, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAccount:Landroid/accounts/Account;
    invoke-static {v1}, Lcom/google/android/gm/provider/MailEngine;->access$800(Lcom/google/android/gm/provider/MailEngine;)Landroid/accounts/Account;

    move-result-object v1

    iget-object v1, v1, Landroid/accounts/Account;->name:Ljava/lang/String;

    invoke-virtual {v0, v1, p1}, Lcom/google/android/gm/provider/MailCore;->setServerPreferences(Ljava/lang/String;Ljava/util/Map;)V

    .line 4620
    return-void
.end method

.method public setSettings(Ljava/util/Map;Z)V
    .locals 7
    .param p2, "configChanged"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 4155
    .local p1, "settings":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v4}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4157
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 4159
    :try_start_1
    invoke-interface {p1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 4160
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-virtual {p0, v3}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->isSyncConfigKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 4161
    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v5, v3, v4}, Lcom/google/android/gm/provider/MailEngine;->setInternalSetting(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 4169
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v3

    :try_start_2
    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 4172
    :catchall_1
    move-exception v3

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v3

    .line 4163
    .restart local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_3
    iget-object v5, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v5, v3, v4}, Lcom/google/android/gm/provider/MailEngine;->access$1800(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 4166
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    :cond_1
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V

    .line 4167
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 4169
    :try_start_4
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v3}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 4172
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4177
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    if-eqz v3, :cond_2

    .line 4178
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    iget-object v4, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v4, v4, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/MailSync;->getServerVersion()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gm/provider/MailCore;->setServerVersion(J)V

    .line 4179
    if-eqz p2, :cond_2

    .line 4180
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->updateMailCoreConfig()V
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$1900(Lcom/google/android/gm/provider/MailEngine;)V

    .line 4184
    :cond_2
    if-eqz p2, :cond_3

    .line 4185
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 4186
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "syncRationale"

    sget-object v4, Lcom/google/android/gm/provider/MailSync$SyncRationale;->UNKNOWN:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    invoke-virtual {v4}, Lcom/google/android/gm/provider/MailSync$SyncRationale;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 4188
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v4, "conversations"

    const-string v5, "queryId = 0"

    const/4 v6, 0x0

    invoke-virtual {v3, v4, v2, v5, v6}, Landroid/database/sqlite/SQLiteDatabase;->update(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4189
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->calculateUnknownSyncRationalesAndPurgeInBackground()V
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$700(Lcom/google/android/gm/provider/MailEngine;)V

    .line 4192
    .end local v2    # "values":Landroid/content/ContentValues;
    :cond_3
    const-string v3, "lowestMessageIdInDuration"

    invoke-interface {p1, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 4198
    iget-object v3, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailEngine;->purgeStaleMessagesOutsideTransaction()Z

    .line 4200
    :cond_4
    return-void
.end method

.method public updateNotificationLabels()V
    .locals 24

    .prologue
    .line 4418
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    if-nez v3, :cond_0

    .line 4488
    :goto_0
    return-void

    .line 4422
    :cond_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    move-object/from16 v21, v0

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static/range {v21 .. v21}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4424
    :try_start_0
    const-string v3, "Gmail"

    const-string v21, "updateNotificationLabels: Updating notification labels"

    const/16 v22, 0x0

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v22, v0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-static {v3, v0, v1}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4425
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v17

    .line 4427
    .local v17, "notificationRequests":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/MailCore$NotificationRequest;>;"
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailSync;->getLabelsIncludedArray()[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v18

    .line 4429
    .local v18, "syncedLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailSync:Lcom/google/android/gm/provider/MailSync;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailSync;->getLabelsPartialArray()[Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v3

    move-object/from16 v0, v18

    invoke-interface {v0, v3}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 4431
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdUnread()J

    move-result-wide v14

    .line 4434
    .local v14, "labelIdUnread":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mLabelMap:Lcom/google/android/gm/provider/Gmail$LabelMap;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$000(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/Gmail$LabelMap;

    move-result-object v3

    invoke-virtual {v3}, Lcom/google/android/gm/provider/Gmail$LabelMap;->getLabelIdIgnored()J

    move-result-wide v21

    invoke-static/range {v21 .. v22}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v3}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v9

    .line 4437
    .local v9, "requiredAbsentLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v19

    .line 4440
    .local v19, "tagLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mNotificationLabels:Ljava/util/Map;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$1300(Lcom/google/android/gm/provider/MailEngine;)Ljava/util/Map;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Map;->clear()V

    .line 4442
    const/4 v10, 0x0

    .line 4445
    .local v10, "added":Z
    invoke-interface/range {v18 .. v18}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .local v12, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_2

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    .line 4446
    .local v16, "name":Ljava/lang/String;
    invoke-static {}, Lcom/google/android/gm/provider/LabelManager;->getForcedSyncedNoNotifyLabels()Ljava/util/Set;

    move-result-object v3

    move-object/from16 v0, v16

    invoke-interface {v3, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 4450
    const-string v3, "Gmail"

    const-string v21, "updateNotificationLabels:   Adding: %s"

    const/16 v22, 0x1

    move/from16 v0, v22

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    aput-object v16, v22, v23

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    invoke-static {v3, v0, v1}, Lcom/google/android/gm/provider/LogUtils;->v(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 4451
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, v16

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailCore;->getOrAddLabel(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v13

    .line 4452
    .local v13, "label":Lcom/google/android/gm/provider/MailCore$Label;
    iget-wide v4, v13, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    .line 4453
    .local v4, "labelId":J
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->addNotificationLabel(Lcom/google/android/gm/provider/MailCore$Label;)Z
    invoke-static {v3, v13}, Lcom/google/android/gm/provider/MailEngine;->access$2200(Lcom/google/android/gm/provider/MailEngine;Lcom/google/android/gm/provider/MailCore$Label;)Z

    move-result v3

    or-int/2addr v10, v3

    .line 4454
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v14, v15}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v21

    move-object/from16 v0, v21

    invoke-static {v3, v0}, Lcom/google/common/collect/ImmutableSet;->of(Ljava/lang/Object;Ljava/lang/Object;)Lcom/google/common/collect/ImmutableSet;

    move-result-object v8

    .line 4457
    .local v8, "required":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v3, v4, v5}, Lcom/google/android/gm/provider/MailEngine;->getNotificationTagLabel(J)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v3

    iget-wide v6, v3, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    .line 4458
    .local v6, "tagLabelId":J
    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    move-object/from16 v0, v19

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 4459
    new-instance v3, Lcom/google/android/gm/provider/MailCore$NotificationRequest;

    invoke-direct/range {v3 .. v9}, Lcom/google/android/gm/provider/MailCore$NotificationRequest;-><init>(JJLjava/util/Set;Ljava/util/Set;)V

    move-object/from16 v0, v17

    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 4486
    .end local v4    # "labelId":J
    .end local v6    # "tagLabelId":J
    .end local v8    # "required":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v9    # "requiredAbsentLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .end local v10    # "added":Z
    .end local v12    # "i$":Ljava/util/Iterator;
    .end local v13    # "label":Lcom/google/android/gm/provider/MailCore$Label;
    .end local v14    # "labelIdUnread":J
    .end local v16    # "name":Ljava/lang/String;
    .end local v17    # "notificationRequests":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/MailCore$NotificationRequest;>;"
    .end local v18    # "syncedLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v19    # "tagLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    :catchall_0
    move-exception v3

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    move-object/from16 v21, v0

    move-object/from16 v0, v21

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v21, v0

    invoke-virtual/range {v21 .. v21}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v3

    .line 4467
    .restart local v9    # "requiredAbsentLabels":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/Long;>;"
    .restart local v10    # "added":Z
    .restart local v12    # "i$":Ljava/util/Iterator;
    .restart local v14    # "labelIdUnread":J
    .restart local v17    # "notificationRequests":Ljava/util/List;, "Ljava/util/List<Lcom/google/android/gm/provider/MailCore$NotificationRequest;>;"
    .restart local v18    # "syncedLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v19    # "tagLabels":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Long;>;"
    :cond_2
    :try_start_1
    const-string v3, ","

    move-object/from16 v0, v19

    invoke-static {v3, v0}, Landroid/text/TextUtils;->join(Ljava/lang/CharSequence;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v20

    .line 4468
    .local v20, "tagLabelsString":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v21, "conversation_labels"

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "labels_id IN (SELECT _id FROM labels WHERE canonicalName LIKE \'^^unseen-%\' AND _id NOT IN ("

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "))"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    const/16 v23, 0x0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v3, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 4475
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v21, "labels"

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    const-string v23, "canonicalName LIKE \'^^unseen-%\' AND _id NOT IN ("

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, v20

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, ")"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    const/16 v23, 0x0

    move-object/from16 v0, v21

    move-object/from16 v1, v22

    move-object/from16 v2, v23

    invoke-virtual {v3, v0, v1, v2}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v3

    if-lez v3, :cond_5

    const/4 v11, 0x1

    .line 4480
    .local v11, "deleted":Z
    :goto_2
    if-nez v10, :cond_3

    if-eqz v11, :cond_4

    .line 4481
    :cond_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/MailCore;->onLabelsChanged()V

    .line 4483
    :cond_4
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    move-object/from16 v0, v17

    invoke-virtual {v3, v0}, Lcom/google/android/gm/provider/MailCore;->setNotificationRequests(Ljava/util/Collection;)V

    .line 4484
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 4486
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    goto/16 :goto_0

    .line 4475
    .end local v11    # "deleted":Z
    :cond_5
    const/4 v11, 0x0

    goto :goto_2
.end method

.method public updateSentOrSavedMessage(JJJ)V
    .locals 18
    .param p1, "prevMessageId"    # J
    .param p3, "messageId"    # J
    .param p5, "conversationId"    # J

    .prologue
    .line 4261
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mTransactionListener:Lcom/google/android/gm/provider/GmailTransactionListener;
    invoke-static {v6}, Lcom/google/android/gm/provider/MailEngine;->access$500(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/google/android/gm/provider/TransactionHelper;->beginTransactionWithListenerNonExclusive(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V

    .line 4263
    const-wide/16 v14, 0x0

    .line 4264
    .local v14, "localMessageId":J
    const-wide/16 v4, 0x0

    .line 4267
    .local v4, "oldConversationId":J
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v6, 0x0

    move-wide/from16 v0, p1

    invoke-virtual {v3, v6, v0, v1}, Lcom/google/android/gm/provider/MailEngine;->getMessageCursorForMessageId([Ljava/lang/String;J)Landroid/database/Cursor;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result-object v13

    .line 4269
    .local v13, "cursor":Landroid/database/Cursor;
    :try_start_1
    invoke-interface {v13}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    if-nez v3, :cond_0

    .line 4285
    :try_start_2
    invoke-interface {v13}, Landroid/database/Cursor;->close()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 4324
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    .line 4326
    :goto_0
    return-void

    .line 4278
    :cond_0
    :try_start_3
    const-string v3, "_id"

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v14

    .line 4279
    const-string v3, "conversation"

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getColumnIndexOrThrow(Ljava/lang/String;)I

    move-result v3

    invoke-interface {v13, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    .line 4281
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    const/4 v6, 0x1

    # invokes: Lcom/google/android/gm/provider/MailEngine;->getMessageFromCursor(Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;
    invoke-static {v3, v13, v6}, Lcom/google/android/gm/provider/MailEngine;->access$2100(Lcom/google/android/gm/provider/MailEngine;Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;

    move-result-object v17

    .line 4282
    .local v17, "prevMessage":Lcom/google/android/gm/provider/MailSync$Message;
    move-wide/from16 v0, p3

    move-object/from16 v2, v17

    iput-wide v0, v2, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    .line 4283
    move-wide/from16 v0, p5

    move-object/from16 v2, v17

    iput-wide v0, v2, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 4285
    :try_start_4
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    .line 4290
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # getter for: Lcom/google/android/gm/provider/MailEngine;->mAttachmentManager:Lcom/google/android/gm/provider/AttachmentManager;
    invoke-static {v3}, Lcom/google/android/gm/provider/MailEngine;->access$1200(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/AttachmentManager;

    move-result-object v3

    move-object/from16 v0, v17

    iget-wide v6, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v0, p1

    invoke-virtual {v3, v0, v1, v6, v7}, Lcom/google/android/gm/provider/AttachmentManager;->updateMessageId(JJ)V

    .line 4291
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mOperations:Lcom/google/android/gm/provider/Operations;

    move-object/from16 v0, v17

    iget-wide v6, v0, Lcom/google/android/gm/provider/MailSync$Message;->messageId:J

    move-wide/from16 v0, p1

    invoke-virtual {v3, v0, v1, v6, v7}, Lcom/google/android/gm/provider/Operations;->updateMessageId(JJ)V

    .line 4299
    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-eqz v3, :cond_1

    .line 4300
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Long;

    const/4 v7, 0x0

    invoke-static/range {p1 .. p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v6}, Lcom/google/common/collect/Lists;->newArrayList([Ljava/lang/Object;)Ljava/util/ArrayList;

    move-result-object v6

    invoke-virtual {v3, v6}, Lcom/google/android/gm/provider/MailCore;->expungeMessagesWithoutWritingOperations(Ljava/util/List;)V

    .line 4302
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    sget-object v6, Lcom/google/android/gm/provider/MailSync$SyncRationale;->UNKNOWN:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v7, 0x1

    const/4 v8, 0x0

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v3 .. v8}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4308
    :cond_1
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const-string v6, "^^out"

    invoke-virtual {v3, v6}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v16

    .line 4309
    .local v16, "outboxLabel":Lcom/google/android/gm/provider/MailCore$Label;
    move-object/from16 v0, v17

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    move-object/from16 v0, v16

    iget-wide v6, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 4310
    move-object/from16 v0, v17

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    move-object/from16 v0, v16

    iget-wide v6, v0, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 4311
    move-object/from16 v0, v17

    iget-object v3, v0, Lcom/google/android/gm/provider/MailSync$Message;->labelIds:Ljava/util/Set;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v6, v6, Lcom/google/android/gm/provider/MailEngine;->mMailCore:Lcom/google/android/gm/provider/MailCore;

    const-string v7, "^f"

    invoke-virtual {v6, v7}, Lcom/google/android/gm/provider/MailCore;->getLabelOrThrow(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;

    move-result-object v6

    iget-wide v6, v6, Lcom/google/android/gm/provider/MailCore$Label;->id:J

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    invoke-interface {v3, v6}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 4316
    :cond_2
    const-wide/16 v10, 0x0

    sget-object v12, Lcom/google/android/gm/provider/MailEngine$ClientCreated;->CLIENT_CREATED:Lcom/google/android/gm/provider/MailEngine$ClientCreated;

    move-object/from16 v6, p0

    move-object/from16 v7, v17

    move-wide v8, v14

    invoke-virtual/range {v6 .. v12}, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->addOrUpdateMessageNoNotifyWithoutWritingOperations(Lcom/google/android/gm/provider/MailSync$Message;JJLcom/google/android/gm/provider/MailEngine$ClientCreated;)V

    .line 4319
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    move-object/from16 v0, v17

    iget-wide v7, v0, Lcom/google/android/gm/provider/MailSync$Message;->conversationId:J

    sget-object v9, Lcom/google/android/gm/provider/MailSync$SyncRationale;->UNKNOWN:Lcom/google/android/gm/provider/MailSync$SyncRationale;

    const/4 v10, 0x1

    const/4 v11, 0x0

    # invokes: Lcom/google/android/gm/provider/MailEngine;->onConversationChanged(JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    invoke-static/range {v6 .. v11}, Lcom/google/android/gm/provider/MailEngine;->access$2000(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V

    .line 4322
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->setTransactionSuccessful()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 4324
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v3, v3, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v3}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    goto/16 :goto_0

    .line 4285
    .end local v16    # "outboxLabel":Lcom/google/android/gm/provider/MailCore$Label;
    .end local v17    # "prevMessage":Lcom/google/android/gm/provider/MailSync$Message;
    :catchall_0
    move-exception v3

    :try_start_5
    invoke-interface {v13}, Landroid/database/Cursor;->close()V

    throw v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 4324
    .end local v13    # "cursor":Landroid/database/Cursor;
    :catchall_1
    move-exception v3

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v6, v6, Lcom/google/android/gm/provider/MailEngine;->mTransaction:Lcom/google/android/gm/provider/TransactionHelper;

    invoke-virtual {v6}, Lcom/google/android/gm/provider/TransactionHelper;->endTransaction()V

    throw v3
.end method

.method public wipeAndResync(Ljava/lang/String;)V
    .locals 1
    .param p1, "reason"    # Ljava/lang/String;

    .prologue
    .line 4150
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    # invokes: Lcom/google/android/gm/provider/MailEngine;->wipeAndResync(Ljava/lang/String;)V
    invoke-static {v0, p1}, Lcom/google/android/gm/provider/MailEngine;->access$1700(Lcom/google/android/gm/provider/MailEngine;Ljava/lang/String;)V

    .line 4151
    return-void
.end method

.method public yieldForContention()Z
    .locals 1

    .prologue
    .line 4341
    iget-object v0, p0, Lcom/google/android/gm/provider/MailEngine$PublicMailStore;->this$0:Lcom/google/android/gm/provider/MailEngine;

    iget-object v0, v0, Lcom/google/android/gm/provider/MailEngine;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->yieldIfContendedSafely()Z

    move-result v0

    return v0
.end method
