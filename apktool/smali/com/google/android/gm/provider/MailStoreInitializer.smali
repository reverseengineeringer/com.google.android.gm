.class Lcom/google/android/gm/provider/MailStoreInitializer;
.super Lcom/google/android/gm/provider/DatabaseInitializer;
.source "MailStoreInitializer.java"


# direct methods
.method constructor <init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 0
    .param p1, "engine"    # Lcom/google/android/gm/provider/MailEngine;
    .param p2, "db"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lcom/google/android/gm/provider/DatabaseInitializer;-><init>(Lcom/google/android/gm/provider/MailEngine;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 22
    return-void
.end method

.method public static moveSyncSettingsToInternalDb(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteDatabase;)V
    .locals 13
    .param p0, "db"    # Landroid/database/sqlite/SQLiteDatabase;
    .param p1, "internalDb"    # Landroid/database/sqlite/SQLiteDatabase;

    .prologue
    const/4 v12, 0x0

    .line 527
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    array-length v10, v10

    new-array v9, v10, [Landroid/content/ContentValues;

    .line 529
    .local v9, "values":[Landroid/content/ContentValues;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 530
    .local v7, "sb":Ljava/lang/StringBuilder;
    const-string v10, "select "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 531
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    array-length v10, v10

    if-ge v4, v10, :cond_1

    .line 532
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    aget-object v1, v10, v4

    .line 533
    .local v1, "column":Ljava/lang/String;
    if-eqz v4, :cond_0

    const-string v10, ", "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 534
    :cond_0
    const-string v10, "(select value from sync_settings where name =\'"

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 535
    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 536
    const-string v10, "\') as "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 537
    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 539
    new-instance v10, Landroid/content/ContentValues;

    invoke-direct {v10}, Landroid/content/ContentValues;-><init>()V

    aput-object v10, v9, v4

    .line 540
    aget-object v10, v9, v4

    const-string v11, "name"

    invoke-virtual {v10, v11, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 531
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 543
    .end local v1    # "column":Ljava/lang/String;
    :cond_1
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p0, v10, v12}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v2

    .line 544
    .local v2, "cursor":Landroid/database/Cursor;
    invoke-interface {v2}, Landroid/database/Cursor;->moveToNext()Z

    .line 545
    const/4 v4, 0x0

    :goto_1
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    array-length v10, v10

    if-ge v4, v10, :cond_2

    .line 546
    aget-object v10, v9, v4

    const-string v11, "value"

    invoke-interface {v2, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v10, v11, v12}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 545
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 548
    :cond_2
    invoke-interface {v2}, Landroid/database/Cursor;->close()V

    .line 550
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->beginTransactionNonExclusive()V

    .line 553
    :try_start_0
    const-string v10, "internal_sync_settings"

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-virtual {p1, v10, v11, v12}, Landroid/database/sqlite/SQLiteDatabase;->delete(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 556
    move-object v0, v9

    .local v0, "arr$":[Landroid/content/ContentValues;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_2
    if-ge v5, v6, :cond_3

    aget-object v8, v0, v5

    .line 557
    .local v8, "v":Landroid/content/ContentValues;
    const-string v10, "internal_sync_settings"

    const/4 v11, 0x0

    invoke-virtual {p1, v10, v11, v8}, Landroid/database/sqlite/SQLiteDatabase;->insert(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 556
    add-int/lit8 v5, v5, 0x1

    goto :goto_2

    .line 559
    .end local v8    # "v":Landroid/content/ContentValues;
    :cond_3
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->setTransactionSuccessful()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 561
    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    .line 564
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 565
    .local v3, "deleteSb":Ljava/lang/StringBuilder;
    const-string v10, "delete from sync_settings where "

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 566
    const/4 v4, 0x0

    :goto_3
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    array-length v10, v10

    if-ge v4, v10, :cond_5

    .line 567
    sget-object v10, Lcom/google/android/gm/provider/Gmail;->SETTINGS_PROJECTION:[Ljava/lang/String;

    aget-object v1, v10, v4

    .line 568
    .restart local v1    # "column":Ljava/lang/String;
    const-string v10, " name =\'"

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 569
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 570
    const-string v10, "\'"

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 571
    const/4 v10, 0x3

    if-eq v4, v10, :cond_4

    const-string v10, " OR "

    invoke-virtual {v3, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 566
    :cond_4
    add-int/lit8 v4, v4, 0x1

    goto :goto_3

    .line 561
    .end local v0    # "arr$":[Landroid/content/ContentValues;
    .end local v1    # "column":Ljava/lang/String;
    .end local v3    # "deleteSb":Ljava/lang/StringBuilder;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :catchall_0
    move-exception v10

    invoke-virtual {p1}, Landroid/database/sqlite/SQLiteDatabase;->endTransaction()V

    throw v10

    .line 574
    .restart local v0    # "arr$":[Landroid/content/ContentValues;
    .restart local v3    # "deleteSb":Ljava/lang/StringBuilder;
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_5
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p0, v10}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 575
    return-void
.end method


# virtual methods
.method public bootstrapDatabase()V
    .locals 5

    .prologue
    .line 45
    const-string v0, "Gmail"

    const-string v1, "Bootstrapping db: %s Current version is %d"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->getPath()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-virtual {v4}, Landroid/database/sqlite/SQLiteDatabase;->getVersion()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->i(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 54
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS sync_settings"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 55
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE sync_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 61
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS engine_settings"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 62
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE engine_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 68
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS messages"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 69
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE messages (_id INTEGER PRIMARY KEY,messageId INTEGER,conversation INTEGER,fromAddress TEXT,toAddresses TEXT,ccAddresses TEXT,bccAddresses TEXT,replyToAddresses TEXT,dateSentMs INTEGER,dateReceivedMs INTEGER,subject TEXT,snippet TEXT,listInfo TEXT,personalLevel INTEGER,body TEXT,bodyEmbedsExternalResources INTEGER,joinedAttachmentInfos STRING,synced INTEGER,error TEXT, clientCreated INTEGER, refMessageId INTEGER DEFAULT 0, forward INTEGER DEFAULT 0, includeQuotedText INTEGER DEFAULT 0, quoteStartPos INTEGER DEFAULT 0, bodyCompressed BLOB DEFAULT NULL, customFromAddress TEXT DEFAULT NULL, queryId INTEGER DEFAULT 1, UNIQUE(messageId))"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 102
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS attachments"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 103
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE attachments (\n  _id INTEGER PRIMARY KEY,\n  messages_conversation INTEGER,\n  messages_messageId INTEGER,\n  messages_partId TEXT,\n  originExtras TEXT,\n  desiredRendition TEXT,  automatic INTEGER,\n  downloadedRendition TEXT,  downloadId INTEGER,\n  status TEXT,\n  saveToSd INTEGER,\n  filename TEXT, priority INTEGER DEFAULT 0, mimeType TEXT DEFAULT NULL, UNIQUE(\n    messages_conversation, messages_messageId,\n    messages_partId, desiredRendition, saveToSd),\n  UNIQUE(messages_messageId, messages_partId, desiredRendition, saveToSd))"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 126
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX attachment_downloadid ON attachments (downloadId)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 129
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS labels"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 130
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE labels ( _id INTEGER PRIMARY KEY, canonicalName TEXT, name TEXT, numConversations TEXT, numUnreadConversations TEXT, color INTEGER DEFAULT 2147483647, systemLabel INTEGER DEFAULT 0, systemLabelOrder INTEGER DEFAULT 0, hidden INTEGER DEFAULT 0, labelCountDisplayBehavior INTEGER DEFAULT 0, labelSyncPolicy INTEGER DEFAULT 0, visibility TEXT, lastTouched INTEGER DEFAULT 0)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 146
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX labels_index ON labels (_id, canonicalName, numConversations, numUnreadConversations)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 149
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS message_labels"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 150
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE message_labels (_id INTEGER PRIMARY KEY,labels_id INTEGER not null,message_messageId INTEGER not null,message_conversation INTEGER,UNIQUE (labels_id, message_messageId))"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 157
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX message_labels_index ON message_labels (labels_id, message_messageId, message_conversation)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 160
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX message_labels_conversation ON message_labels (message_conversation, labels_id)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 163
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS operations"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE operations (_id INTEGER PRIMARY KEY AUTOINCREMENT,action TEXT,message_messageId INTEGER,value1 INTEGER,value2 INTEGER, numAttempts INTEGER DEFAULT 0, nextTimeToAttempt INTEGER DEFAULT 0, delay INTEGER DEFAULT 0)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 176
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX operations_messageid_action_index ON operations (message_messageId, action)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 179
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS conversations_to_fetch"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 180
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE conversations_to_fetch (_id INTEGER PRIMARY KEY, nextAttemptDateMs INTEGER DEFAULT 0, numAttempts INTEGER DEFAULT 0)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 185
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS send_without_sync_conversations_to_fetch"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 186
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE send_without_sync_conversations_to_fetch (_id INTEGER PRIMARY KEY)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 189
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS messages_to_fetch"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 190
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE messages_to_fetch (_id INTEGER PRIMARY KEY)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 193
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS conversation_labels;"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 194
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE conversation_labels (  labels_id TEXT,   queryId INTEGER,   isZombie INTEGER,   sortMessageId INTEGER,   date INTEGER,   conversation_id INTEGER,   UNIQUE(labels_id, queryId, conversation_id));"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 203
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX conversation_labels_index ON conversation_labels (labels_id, sortMessageId, queryId, isZombie, date, conversation_id);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 207
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX conversationLabels_conversationIndex ON conversation_labels (conversation_id, labels_id)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 209
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX conversationLabels_queryId ON conversation_labels (queryId)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 212
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS conversations"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE conversations (_id INTEGER, queryId INTEGER, subject TEXT, snippet TEXT, fromAddress TEXT, personalLevel INTEGER, labelIds TEXT, numMessages INTEGER, maxMessageId INTEGER, hasAttachments INTEGER, hasMessagesWithErrors INTEGER, syncRationale STRING, syncRationaleMessageId INTEGER, forceAllUnread INTEGER, dirty INTEGER DEFAULT 0, UNIQUE(_id, queryId));"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 245
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX conversations_syncRationale on conversations (syncRationale, syncRationaleMessageId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 247
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX conversations_queryId on conversations (queryId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 249
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX labels_name on labels (canonicalName);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 250
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX labels_id on labels (_id);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 251
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX message_labels_message_messageId_labels_id on message_labels (message_messageId, labels_id);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 254
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX messages_messageId on messages (messageId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX messages_queryId on messages (queryId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 257
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX messages_conversation on messages (conversation, messageId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 259
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX messages_messageId_queryId on messages (messageId, queryId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX messages_joinedAttachmentInfos ON messages (joinedAttachmentInfos);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 263
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX messages_conversation_queryId on messages (conversation, queryId)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 265
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS custom_label_color_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 266
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE custom_label_color_prefs (\n  _id INTEGER PRIMARY KEY,\n  color_index TEXT,\n  text_color TEXT,\n  background_color TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 271
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS custom_from_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 272
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  address TEXT,\n  is_default TEXT,\n  reply_to TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 281
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS server_preferences"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 282
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE server_preferences (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  value TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 288
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS info_overload"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 289
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE info_overload (enabled_pref TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 293
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0}, Lcom/google/android/gm/provider/MailIndexerService;->createSearchIndexTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 295
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const/16 v1, 0x7f

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->setVersion(I)V

    .line 296
    return-void
.end method

.method getTargetDbVersion(I)I
    .locals 2
    .param p1, "currentDbVersion"    # I

    .prologue
    const/16 v0, 0x64

    .line 32
    const/16 v1, 0x34

    if-lt p1, v1, :cond_0

    if-ge p1, v0, :cond_0

    .line 37
    :goto_0
    return v0

    :cond_0
    add-int/lit8 v0, p1, 0x1

    goto :goto_0
.end method

.method public upgradeDbTo100()V
    .locals 2

    .prologue
    .line 416
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN systemLabel INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 418
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabel = 1 WHERE substr(canonicalName, 1, 1) = \'^\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 422
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN systemLabelOrder INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 424
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 1 WHERE canonicalName = \'^i\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 426
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 2 WHERE canonicalName = \'^t\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 428
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = \'^b\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 430
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = \'^f\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 432
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = \'^^out\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 434
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = \'^r\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 436
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = \'^all\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 438
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = \'^s\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 440
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = \'^k\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 444
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN hidden INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 446
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET hidden = 1 WHERE substr(canonicalName, 1, 1) = \'^\' AND canonicalName NOT IN (\'^i\', \'^t\', \'^b\', \'^f\', \'^^out\', \'^r\', \'^all\', \'^s\', \'^k\')"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 457
    return-void
.end method

.method public upgradeDbTo101()V
    .locals 2

    .prologue
    .line 461
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN labelCountDisplayBehavior INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 466
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelCountDisplayBehavior = 1 WHERE canonicalName IN (\'^^out\', \'^r\', \'^s\')"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 475
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelCountDisplayBehavior = 2 WHERE canonicalName IN (\'^f\', \'^t\', \'^b\', \'^all\', \'^k\')"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 483
    return-void
.end method

.method public upgradeDbTo102()V
    .locals 2

    .prologue
    .line 487
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN labelSyncPolicy INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 491
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelSyncPolicy = 1 WHERE canonicalName IN (\'^^out\', \'^r\')"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 498
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelSyncPolicy = 2 WHERE canonicalName IN (\'^s\', \'^b\', \'^all\', \'^k\')"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 507
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelSyncPolicy = 3 WHERE canonicalName IN (\'^i\', \'^f\')"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 512
    return-void
.end method

.method public upgradeDbTo103()V
    .locals 2

    .prologue
    .line 515
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    iget-object v1, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    iget-object v1, v1, Lcom/google/android/gm/provider/MailEngine;->mInternalDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0, v1}, Lcom/google/android/gm/provider/MailStoreInitializer;->moveSyncSettingsToInternalDb(Landroid/database/sqlite/SQLiteDatabase;Landroid/database/sqlite/SQLiteDatabase;)V

    .line 521
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->sendUpgradeSyncWindowIntent()V

    .line 522
    return-void
.end method

.method public upgradeDbTo104()V
    .locals 3

    .prologue
    .line 581
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 582
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 583
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS custom_label_color_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 584
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE custom_label_color_prefs (\n  _id INTEGER PRIMARY KEY,\n  color_index TEXT,\n  text_color TEXT,\n  background_color TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 589
    return-void
.end method

.method public upgradeDbTo105()V
    .locals 3

    .prologue
    .line 596
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 597
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 598
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS custom_from_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 599
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  is_default TEXT,\n  reply_to TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 604
    return-void
.end method

.method public upgradeDbTo106()V
    .locals 3

    .prologue
    .line 610
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 611
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 612
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS server_preferences"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 613
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE server_preferences (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  value TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 618
    return-void
.end method

.method public upgradeDbTo107()V
    .locals 3

    .prologue
    .line 622
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 623
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 624
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN visibility TEXT"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 625
    return-void
.end method

.method public upgradeDbTo108()V
    .locals 3

    .prologue
    .line 629
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 630
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 632
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = \'^io_im\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 634
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = \'^b\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 636
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = \'^f\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 638
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = \'^^out\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 640
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = \'^r\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 642
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = \'^all\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 644
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = \'^s\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 646
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 10 WHERE canonicalName = \'^k\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 650
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS info_overload"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 651
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE info_overload (enabled_pref TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 653
    return-void
.end method

.method public upgradeDbTo109()V
    .locals 2

    .prologue
    .line 657
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE attachments ADD COLUMN priority INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 658
    return-void
.end method

.method public upgradeDbTo110()V
    .locals 5

    .prologue
    .line 662
    iget v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    const/16 v1, 0x64

    if-ge v0, v1, :cond_0

    iget v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    const/16 v1, 0x35

    if-lt v0, v1, :cond_0

    .line 664
    const-string v0, "Gmail"

    const-string v1, "skipping v110 mailstore upgrade due to initial version %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 673
    :goto_0
    return-void

    .line 669
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE conversations_to_fetch ADD COLUMN nextAttemptDateMs INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 671
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE conversations_to_fetch ADD COLUMN numAttempts INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public upgradeDbTo111()V
    .locals 5

    .prologue
    .line 678
    iget v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    const/16 v1, 0x64

    if-ge v0, v1, :cond_0

    iget v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    const/16 v1, 0x36

    if-lt v0, v1, :cond_0

    .line 680
    const-string v0, "Gmail"

    const-string v1, "skipping v111 mailstore upgrade due to initial version %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 686
    :goto_0
    return-void

    .line 685
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN customFromAddress TEXT DEFAULT NULL"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public upgradeDbTo112()V
    .locals 3

    .prologue
    .line 691
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 692
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 694
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 2 WHERE canonicalName = \'^iim\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 696
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = \'^t\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 698
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = \'^io_im\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 700
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = \'^b\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 702
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = \'^f\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 704
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = \'^^out\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 706
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = \'^r\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 708
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = \'^all\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 710
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 10 WHERE canonicalName = \'^s\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 712
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET systemLabelOrder = 11 WHERE canonicalName = \'^k\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 714
    return-void
.end method

.method public upgradeDbTo113()V
    .locals 3

    .prologue
    .line 718
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 719
    return-void
.end method

.method public upgradeDbTo114()V
    .locals 2

    .prologue
    .line 723
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/google/android/gm/provider/MailEngine;->setValidateSyncSets(Z)V

    .line 724
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 725
    return-void
.end method

.method public upgradeDbTo115()V
    .locals 3

    .prologue
    .line 729
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 730
    return-void
.end method

.method public upgradeDbTo116()V
    .locals 3

    .prologue
    .line 734
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 736
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelCountDisplayBehavior = 2 WHERE canonicalName = \'^io_im\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 738
    return-void
.end method

.method public upgradeDbTo117()V
    .locals 2

    .prologue
    .line 742
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE attachments ADD COLUMN mimeType TEXT DEFAULT NULL"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 743
    return-void
.end method

.method public upgradeDbTo118()V
    .locals 2

    .prologue
    .line 748
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE labels SET labelSyncPolicy = 0 WHERE canonicalName = \'^i\'"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 751
    return-void
.end method

.method public upgradeDbTo119()V
    .locals 2

    .prologue
    .line 758
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN queryId INTEGER DEFAULT 1"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 761
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE messages SET queryId = 0 WHERE synced = 1"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 764
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DELETE FROM messages where synced = 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 767
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS messages_queryId on messages (queryId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 770
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP INDEX IF EXISTS messages_synced;"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 771
    return-void
.end method

.method public upgradeDbTo120()V
    .locals 1

    .prologue
    .line 775
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0}, Lcom/google/android/gm/provider/MailIndexerService;->createSearchIndexTables(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 776
    return-void
.end method

.method public upgradeDbTo121()V
    .locals 2

    .prologue
    .line 780
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN lastTouched INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 781
    return-void
.end method

.method public upgradeDbTo122()V
    .locals 3

    .prologue
    .line 786
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 787
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 788
    return-void
.end method

.method public upgradeDbTo123()V
    .locals 2

    .prologue
    .line 792
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS messages_messageId_queryId on messages (messageId, queryId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 794
    return-void
.end method

.method public upgradeDbTo124()V
    .locals 5

    .prologue
    .line 798
    iget v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    const/16 v1, 0x64

    if-ge v0, v1, :cond_0

    iget v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    const/16 v1, 0x3c

    if-lt v0, v1, :cond_0

    .line 800
    const-string v0, "Gmail"

    const-string v1, "skipping v124 mailstore upgrade due to initial version %d"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget v4, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mInitialDbVersion:I

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/LogUtils;->w(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I

    .line 806
    :goto_0
    return-void

    .line 805
    :cond_0
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE operations ADD COLUMN delay INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public upgradeDbTo125()V
    .locals 2

    .prologue
    .line 809
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS message_fts_table_index"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 810
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE message_fts_table_index(docid INTEGER PRIMARY KEY)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 813
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS conversation_fts_table_index"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 814
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE conversation_fts_table_index(docid INTEGER PRIMARY KEY)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 816
    return-void
.end method

.method public upgradeDbTo126()V
    .locals 2

    .prologue
    .line 819
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS messages_conversation_queryId on messages (conversation, queryId)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 821
    return-void
.end method

.method public upgradeDbTo127()V
    .locals 3

    .prologue
    .line 828
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 829
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 830
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS custom_from_prefs"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 831
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  address TEXT,\n  is_default TEXT,\n  reply_to TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 837
    return-void
.end method

.method public upgradeDbTo37()V
    .locals 2

    .prologue
    .line 304
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "UPDATE conversations SET labelIds = \',\' || labelIds"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 305
    return-void
.end method

.method public upgradeDbTo38()V
    .locals 2

    .prologue
    .line 308
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN clientCreated INTEGER"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 309
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN refMessageId INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 310
    return-void
.end method

.method public upgradeDbTo39()V
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    invoke-static {v0}, Lcom/google/android/gm/provider/MailCore;->correctLocalLabelIds(Landroid/database/sqlite/SQLiteDatabase;)V

    .line 314
    return-void
.end method

.method public upgradeDbTo40()V
    .locals 0

    .prologue
    .line 317
    return-void
.end method

.method public upgradeDbTo41()V
    .locals 2

    .prologue
    .line 320
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE operations ADD COLUMN numAttempts INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 321
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE operations ADD COLUMN nextTimeToAttempt INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 322
    return-void
.end method

.method public upgradeDbTo42()V
    .locals 3

    .prologue
    .line 325
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 326
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 327
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE labels ADD COLUMN color INTEGER DEFAULT 2147483647"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 329
    return-void
.end method

.method public upgradeDbTo43()V
    .locals 2

    .prologue
    .line 332
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS send_without_sync_conversations_to_fetch"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 333
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE send_without_sync_conversations_to_fetch (_id INTEGER PRIMARY KEY)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 335
    return-void
.end method

.method public upgradeDbTo44()V
    .locals 2

    .prologue
    .line 338
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN forward INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 339
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN includeQuotedText INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 340
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN quoteStartPos INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 341
    return-void
.end method

.method public upgradeDbTo45()V
    .locals 2

    .prologue
    .line 349
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS attachments"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 350
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE attachments (\n  _id INTEGER PRIMARY KEY,\n  messages_conversation INTEGER,\n  messages_messageId INTEGER,\n  messages_partId TEXT,\n  originExtras TEXT,\n  desiredRendition TEXT,  automatic INTEGER,\n  downloadedRendition TEXT,  downloadId INTEGER,\n  status TEXT,\n  saveToSd INTEGER,\n  filename TEXT, UNIQUE(\n    messages_conversation, messages_messageId,\n    messages_partId, desiredRendition, saveToSd),\n  UNIQUE(messages_messageId, messages_partId, desiredRendition, saveToSd))"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 369
    return-void
.end method

.method public upgradeDbTo46()V
    .locals 2

    .prologue
    .line 374
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS attachment_downloadid ON attachments (downloadId)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 376
    return-void
.end method

.method public upgradeDbTo47()V
    .locals 2

    .prologue
    .line 381
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS messages_joinedAttachmentInfos ON messages (joinedAttachmentInfos)"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 383
    return-void
.end method

.method public upgradeDbTo48()V
    .locals 2

    .prologue
    .line 386
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE conversations ADD COLUMN dirty INTEGER DEFAULT 0"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 387
    return-void
.end method

.method public upgradeDbTo49()V
    .locals 2

    .prologue
    .line 390
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "ALTER TABLE messages ADD COLUMN bodyCompressed BLOB DEFAULT NULL"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 391
    return-void
.end method

.method public upgradeDbTo50()V
    .locals 2

    .prologue
    .line 394
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS conversations_queryId on conversations (queryId);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 396
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE INDEX IF NOT EXISTS messages_synced on messages (synced);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 397
    return-void
.end method

.method public upgradeDbTo51()V
    .locals 3

    .prologue
    .line 400
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 401
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 402
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "DROP TABLE IF EXISTS info_overload"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 403
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "CREATE TABLE info_overload (enabled_pref TEXT);"

    invoke-virtual {v0, v1}, Landroid/database/sqlite/SQLiteDatabase;->execSQL(Ljava/lang/String;)V

    .line 405
    return-void
.end method

.method public upgradeDbTo52()V
    .locals 3

    .prologue
    .line 408
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mDb:Landroid/database/sqlite/SQLiteDatabase;

    const-string v1, "startSyncNeeded"

    const-string v2, "1"

    invoke-static {v0, v1, v2}, Lcom/google/android/gm/provider/MailEngine;->setSyncSetting(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;Ljava/lang/String;)V

    .line 409
    iget-object v0, p0, Lcom/google/android/gm/provider/DatabaseInitializer;->mEngine:Lcom/google/android/gm/provider/MailEngine;

    invoke-virtual {v0}, Lcom/google/android/gm/provider/MailEngine;->requestSync()V

    .line 410
    return-void
.end method
