package com.google.android.gm.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

class MailStoreInitializer
  extends DatabaseInitializer
{
  MailStoreInitializer(MailEngine paramMailEngine, SQLiteDatabase paramSQLiteDatabase)
  {
    super(paramMailEngine, paramSQLiteDatabase);
  }
  
  public static void moveSyncSettingsToInternalDb(SQLiteDatabase paramSQLiteDatabase1, SQLiteDatabase paramSQLiteDatabase2)
  {
    Object localObject1 = new ContentValues[Gmail.SETTINGS_PROJECTION.length];
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("select ");
    int i = 0;
    while (i < Gmail.SETTINGS_PROJECTION.length)
    {
      String str = Gmail.SETTINGS_PROJECTION[i];
      if (i != 0) {
        ((StringBuilder)localObject2).append(", ");
      }
      ((StringBuilder)localObject2).append("(select value from sync_settings where name ='");
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("') as ");
      ((StringBuilder)localObject2).append(str);
      localObject1[i] = new ContentValues();
      localObject1[i].put("name", str);
      i += 1;
    }
    localObject2 = paramSQLiteDatabase1.rawQuery(((StringBuilder)localObject2).toString(), null);
    ((Cursor)localObject2).moveToNext();
    i = 0;
    while (i < Gmail.SETTINGS_PROJECTION.length)
    {
      localObject1[i].put("value", ((Cursor)localObject2).getString(i));
      i += 1;
    }
    ((Cursor)localObject2).close();
    paramSQLiteDatabase2.beginTransactionNonExclusive();
    try
    {
      paramSQLiteDatabase2.delete("internal_sync_settings", null, null);
      int j = localObject1.length;
      i = 0;
      while (i < j)
      {
        paramSQLiteDatabase2.insert("internal_sync_settings", null, localObject1[i]);
        i += 1;
      }
      paramSQLiteDatabase2.setTransactionSuccessful();
      paramSQLiteDatabase2.endTransaction();
      paramSQLiteDatabase2 = new StringBuilder();
      paramSQLiteDatabase2.append("delete from sync_settings where ");
      i = 0;
      while (i < Gmail.SETTINGS_PROJECTION.length)
      {
        localObject1 = Gmail.SETTINGS_PROJECTION[i];
        paramSQLiteDatabase2.append(" name ='");
        paramSQLiteDatabase2.append((String)localObject1);
        paramSQLiteDatabase2.append("'");
        if (i != 3) {
          paramSQLiteDatabase2.append(" OR ");
        }
        i += 1;
      }
      paramSQLiteDatabase1.execSQL(paramSQLiteDatabase2.toString());
    }
    finally
    {
      paramSQLiteDatabase2.endTransaction();
    }
  }
  
  public void bootstrapDatabase()
  {
    LogUtils.i("Gmail", "Bootstrapping db: %s Current version is %d", new Object[] { mDb.getPath(), Integer.valueOf(mDb.getVersion()) });
    mDb.execSQL("DROP TABLE IF EXISTS sync_settings");
    mDb.execSQL("CREATE TABLE sync_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))");
    mDb.execSQL("DROP TABLE IF EXISTS engine_settings");
    mDb.execSQL("CREATE TABLE engine_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))");
    mDb.execSQL("DROP TABLE IF EXISTS messages");
    mDb.execSQL("CREATE TABLE messages (_id INTEGER PRIMARY KEY,messageId INTEGER,conversation INTEGER,fromAddress TEXT,toAddresses TEXT,ccAddresses TEXT,bccAddresses TEXT,replyToAddresses TEXT,dateSentMs INTEGER,dateReceivedMs INTEGER,subject TEXT,snippet TEXT,listInfo TEXT,personalLevel INTEGER,body TEXT,bodyEmbedsExternalResources INTEGER,joinedAttachmentInfos STRING,synced INTEGER,error TEXT, clientCreated INTEGER, refMessageId INTEGER DEFAULT 0, forward INTEGER DEFAULT 0, includeQuotedText INTEGER DEFAULT 0, quoteStartPos INTEGER DEFAULT 0, bodyCompressed BLOB DEFAULT NULL, customFromAddress TEXT DEFAULT NULL, queryId INTEGER DEFAULT 1, UNIQUE(messageId))");
    mDb.execSQL("DROP TABLE IF EXISTS attachments");
    mDb.execSQL("CREATE TABLE attachments (\n  _id INTEGER PRIMARY KEY,\n  messages_conversation INTEGER,\n  messages_messageId INTEGER,\n  messages_partId TEXT,\n  originExtras TEXT,\n  desiredRendition TEXT,  automatic INTEGER,\n  downloadedRendition TEXT,  downloadId INTEGER,\n  status TEXT,\n  saveToSd INTEGER,\n  filename TEXT, priority INTEGER DEFAULT 0, mimeType TEXT DEFAULT NULL, UNIQUE(\n    messages_conversation, messages_messageId,\n    messages_partId, desiredRendition, saveToSd),\n  UNIQUE(messages_messageId, messages_partId, desiredRendition, saveToSd))");
    mDb.execSQL("CREATE INDEX attachment_downloadid ON attachments (downloadId)");
    mDb.execSQL("DROP TABLE IF EXISTS labels");
    mDb.execSQL("CREATE TABLE labels ( _id INTEGER PRIMARY KEY, canonicalName TEXT, name TEXT, numConversations TEXT, numUnreadConversations TEXT, color INTEGER DEFAULT 2147483647, systemLabel INTEGER DEFAULT 0, systemLabelOrder INTEGER DEFAULT 0, hidden INTEGER DEFAULT 0, labelCountDisplayBehavior INTEGER DEFAULT 0, labelSyncPolicy INTEGER DEFAULT 0, visibility TEXT, lastTouched INTEGER DEFAULT 0)");
    mDb.execSQL("CREATE INDEX labels_index ON labels (_id, canonicalName, numConversations, numUnreadConversations)");
    mDb.execSQL("DROP TABLE IF EXISTS message_labels");
    mDb.execSQL("CREATE TABLE message_labels (_id INTEGER PRIMARY KEY,labels_id INTEGER not null,message_messageId INTEGER not null,message_conversation INTEGER,UNIQUE (labels_id, message_messageId))");
    mDb.execSQL("CREATE INDEX message_labels_index ON message_labels (labels_id, message_messageId, message_conversation)");
    mDb.execSQL("CREATE INDEX message_labels_conversation ON message_labels (message_conversation, labels_id)");
    mDb.execSQL("DROP TABLE IF EXISTS operations");
    mDb.execSQL("CREATE TABLE operations (_id INTEGER PRIMARY KEY AUTOINCREMENT,action TEXT,message_messageId INTEGER,value1 INTEGER,value2 INTEGER, numAttempts INTEGER DEFAULT 0, nextTimeToAttempt INTEGER DEFAULT 0, delay INTEGER DEFAULT 0)");
    mDb.execSQL("CREATE INDEX operations_messageid_action_index ON operations (message_messageId, action)");
    mDb.execSQL("DROP TABLE IF EXISTS conversations_to_fetch");
    mDb.execSQL("CREATE TABLE conversations_to_fetch (_id INTEGER PRIMARY KEY, nextAttemptDateMs INTEGER DEFAULT 0, numAttempts INTEGER DEFAULT 0)");
    mDb.execSQL("DROP TABLE IF EXISTS send_without_sync_conversations_to_fetch");
    mDb.execSQL("CREATE TABLE send_without_sync_conversations_to_fetch (_id INTEGER PRIMARY KEY)");
    mDb.execSQL("DROP TABLE IF EXISTS messages_to_fetch");
    mDb.execSQL("CREATE TABLE messages_to_fetch (_id INTEGER PRIMARY KEY)");
    mDb.execSQL("DROP TABLE IF EXISTS conversation_labels;");
    mDb.execSQL("CREATE TABLE conversation_labels (  labels_id TEXT,   queryId INTEGER,   isZombie INTEGER,   sortMessageId INTEGER,   date INTEGER,   conversation_id INTEGER,   UNIQUE(labels_id, queryId, conversation_id));");
    mDb.execSQL("CREATE INDEX conversation_labels_index ON conversation_labels (labels_id, sortMessageId, queryId, isZombie, date, conversation_id);");
    mDb.execSQL("CREATE INDEX conversationLabels_conversationIndex ON conversation_labels (conversation_id, labels_id)");
    mDb.execSQL("CREATE INDEX conversationLabels_queryId ON conversation_labels (queryId)");
    mDb.execSQL("DROP TABLE IF EXISTS conversations");
    mDb.execSQL("CREATE TABLE conversations (_id INTEGER, queryId INTEGER, subject TEXT, snippet TEXT, fromAddress TEXT, personalLevel INTEGER, labelIds TEXT, numMessages INTEGER, maxMessageId INTEGER, hasAttachments INTEGER, hasMessagesWithErrors INTEGER, syncRationale STRING, syncRationaleMessageId INTEGER, forceAllUnread INTEGER, dirty INTEGER DEFAULT 0, UNIQUE(_id, queryId));");
    mDb.execSQL("CREATE INDEX conversations_syncRationale on conversations (syncRationale, syncRationaleMessageId);");
    mDb.execSQL("CREATE INDEX conversations_queryId on conversations (queryId);");
    mDb.execSQL("CREATE INDEX labels_name on labels (canonicalName);");
    mDb.execSQL("CREATE INDEX labels_id on labels (_id);");
    mDb.execSQL("CREATE INDEX message_labels_message_messageId_labels_id on message_labels (message_messageId, labels_id);");
    mDb.execSQL("CREATE INDEX messages_messageId on messages (messageId);");
    mDb.execSQL("CREATE INDEX messages_queryId on messages (queryId);");
    mDb.execSQL("CREATE INDEX messages_conversation on messages (conversation, messageId);");
    mDb.execSQL("CREATE INDEX messages_messageId_queryId on messages (messageId, queryId);");
    mDb.execSQL("CREATE INDEX messages_joinedAttachmentInfos ON messages (joinedAttachmentInfos);");
    mDb.execSQL("CREATE INDEX messages_conversation_queryId on messages (conversation, queryId)");
    mDb.execSQL("DROP TABLE IF EXISTS custom_label_color_prefs");
    mDb.execSQL("CREATE TABLE custom_label_color_prefs (\n  _id INTEGER PRIMARY KEY,\n  color_index TEXT,\n  text_color TEXT,\n  background_color TEXT);");
    mDb.execSQL("DROP TABLE IF EXISTS custom_from_prefs");
    mDb.execSQL("CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  address TEXT,\n  is_default TEXT,\n  reply_to TEXT);");
    mDb.execSQL("DROP TABLE IF EXISTS server_preferences");
    mDb.execSQL("CREATE TABLE server_preferences (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  value TEXT);");
    mDb.execSQL("DROP TABLE IF EXISTS info_overload");
    mDb.execSQL("CREATE TABLE info_overload (enabled_pref TEXT);");
    MailIndexerService.createSearchIndexTables(mDb);
    mDb.setVersion(127);
  }
  
  int getTargetDbVersion(int paramInt)
  {
    if ((paramInt >= 52) && (paramInt < 100)) {
      return 100;
    }
    return paramInt + 1;
  }
  
  public void upgradeDbTo100()
  {
    mDb.execSQL("ALTER TABLE labels ADD COLUMN systemLabel INTEGER DEFAULT 0");
    mDb.execSQL("UPDATE labels SET systemLabel = 1 WHERE substr(canonicalName, 1, 1) = '^'");
    mDb.execSQL("ALTER TABLE labels ADD COLUMN systemLabelOrder INTEGER DEFAULT 0");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 1 WHERE canonicalName = '^i'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 2 WHERE canonicalName = '^t'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = '^b'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = '^f'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = '^^out'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = '^r'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = '^all'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = '^s'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = '^k'");
    mDb.execSQL("ALTER TABLE labels ADD COLUMN hidden INTEGER DEFAULT 0");
    mDb.execSQL("UPDATE labels SET hidden = 1 WHERE substr(canonicalName, 1, 1) = '^' AND canonicalName NOT IN ('^i', '^t', '^b', '^f', '^^out', '^r', '^all', '^s', '^k')");
  }
  
  public void upgradeDbTo101()
  {
    mDb.execSQL("ALTER TABLE labels ADD COLUMN labelCountDisplayBehavior INTEGER DEFAULT 0");
    mDb.execSQL("UPDATE labels SET labelCountDisplayBehavior = 1 WHERE canonicalName IN ('^^out', '^r', '^s')");
    mDb.execSQL("UPDATE labels SET labelCountDisplayBehavior = 2 WHERE canonicalName IN ('^f', '^t', '^b', '^all', '^k')");
  }
  
  public void upgradeDbTo102()
  {
    mDb.execSQL("ALTER TABLE labels ADD COLUMN labelSyncPolicy INTEGER DEFAULT 0");
    mDb.execSQL("UPDATE labels SET labelSyncPolicy = 1 WHERE canonicalName IN ('^^out', '^r')");
    mDb.execSQL("UPDATE labels SET labelSyncPolicy = 2 WHERE canonicalName IN ('^s', '^b', '^all', '^k')");
    mDb.execSQL("UPDATE labels SET labelSyncPolicy = 3 WHERE canonicalName IN ('^i', '^f')");
  }
  
  public void upgradeDbTo103()
  {
    moveSyncSettingsToInternalDb(mDb, mEngine.mInternalDb);
    mEngine.sendUpgradeSyncWindowIntent();
  }
  
  public void upgradeDbTo104()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("DROP TABLE IF EXISTS custom_label_color_prefs");
    mDb.execSQL("CREATE TABLE custom_label_color_prefs (\n  _id INTEGER PRIMARY KEY,\n  color_index TEXT,\n  text_color TEXT,\n  background_color TEXT);");
  }
  
  public void upgradeDbTo105()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("DROP TABLE IF EXISTS custom_from_prefs");
    mDb.execSQL("CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  is_default TEXT,\n  reply_to TEXT);");
  }
  
  public void upgradeDbTo106()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("DROP TABLE IF EXISTS server_preferences");
    mDb.execSQL("CREATE TABLE server_preferences (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  value TEXT);");
  }
  
  public void upgradeDbTo107()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("ALTER TABLE labels ADD COLUMN visibility TEXT");
  }
  
  public void upgradeDbTo108()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = '^io_im'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = '^b'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = '^f'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = '^^out'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = '^r'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = '^all'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = '^s'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 10 WHERE canonicalName = '^k'");
    mDb.execSQL("DROP TABLE IF EXISTS info_overload");
    mDb.execSQL("CREATE TABLE info_overload (enabled_pref TEXT);");
  }
  
  public void upgradeDbTo109()
  {
    mDb.execSQL("ALTER TABLE attachments ADD COLUMN priority INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo110()
  {
    if ((mInitialDbVersion < 100) && (mInitialDbVersion >= 53))
    {
      LogUtils.w("Gmail", "skipping v110 mailstore upgrade due to initial version %d", new Object[] { Integer.valueOf(mInitialDbVersion) });
      return;
    }
    mDb.execSQL("ALTER TABLE conversations_to_fetch ADD COLUMN nextAttemptDateMs INTEGER DEFAULT 0");
    mDb.execSQL("ALTER TABLE conversations_to_fetch ADD COLUMN numAttempts INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo111()
  {
    if ((mInitialDbVersion < 100) && (mInitialDbVersion >= 54))
    {
      LogUtils.w("Gmail", "skipping v111 mailstore upgrade due to initial version %d", new Object[] { Integer.valueOf(mInitialDbVersion) });
      return;
    }
    mDb.execSQL("ALTER TABLE messages ADD COLUMN customFromAddress TEXT DEFAULT NULL");
  }
  
  public void upgradeDbTo112()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 2 WHERE canonicalName = '^iim'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = '^t'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = '^io_im'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = '^b'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = '^f'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = '^^out'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = '^r'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = '^all'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 10 WHERE canonicalName = '^s'");
    mDb.execSQL("UPDATE labels SET systemLabelOrder = 11 WHERE canonicalName = '^k'");
  }
  
  public void upgradeDbTo113()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
  }
  
  public void upgradeDbTo114()
  {
    mEngine.setValidateSyncSets(true);
    mEngine.requestSync();
  }
  
  public void upgradeDbTo115()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
  }
  
  public void upgradeDbTo116()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mDb.execSQL("UPDATE labels SET labelCountDisplayBehavior = 2 WHERE canonicalName = '^io_im'");
  }
  
  public void upgradeDbTo117()
  {
    mDb.execSQL("ALTER TABLE attachments ADD COLUMN mimeType TEXT DEFAULT NULL");
  }
  
  public void upgradeDbTo118()
  {
    mDb.execSQL("UPDATE labels SET labelSyncPolicy = 0 WHERE canonicalName = '^i'");
  }
  
  public void upgradeDbTo119()
  {
    mDb.execSQL("ALTER TABLE messages ADD COLUMN queryId INTEGER DEFAULT 1");
    mDb.execSQL("UPDATE messages SET queryId = 0 WHERE synced = 1");
    mDb.execSQL("DELETE FROM messages where synced = 0");
    mDb.execSQL("CREATE INDEX IF NOT EXISTS messages_queryId on messages (queryId);");
    mDb.execSQL("DROP INDEX IF EXISTS messages_synced;");
  }
  
  public void upgradeDbTo120()
  {
    MailIndexerService.createSearchIndexTables(mDb);
  }
  
  public void upgradeDbTo121()
  {
    mDb.execSQL("ALTER TABLE labels ADD COLUMN lastTouched INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo122()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
  }
  
  public void upgradeDbTo123()
  {
    mDb.execSQL("CREATE INDEX IF NOT EXISTS messages_messageId_queryId on messages (messageId, queryId);");
  }
  
  public void upgradeDbTo124()
  {
    if ((mInitialDbVersion < 100) && (mInitialDbVersion >= 60))
    {
      LogUtils.w("Gmail", "skipping v124 mailstore upgrade due to initial version %d", new Object[] { Integer.valueOf(mInitialDbVersion) });
      return;
    }
    mDb.execSQL("ALTER TABLE operations ADD COLUMN delay INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo125()
  {
    mDb.execSQL("DROP TABLE IF EXISTS message_fts_table_index");
    mDb.execSQL("CREATE TABLE message_fts_table_index(docid INTEGER PRIMARY KEY)");
    mDb.execSQL("DROP TABLE IF EXISTS conversation_fts_table_index");
    mDb.execSQL("CREATE TABLE conversation_fts_table_index(docid INTEGER PRIMARY KEY)");
  }
  
  public void upgradeDbTo126()
  {
    mDb.execSQL("CREATE INDEX IF NOT EXISTS messages_conversation_queryId on messages (conversation, queryId)");
  }
  
  public void upgradeDbTo127()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("DROP TABLE IF EXISTS custom_from_prefs");
    mDb.execSQL("CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  address TEXT,\n  is_default TEXT,\n  reply_to TEXT);");
  }
  
  public void upgradeDbTo37()
  {
    mDb.execSQL("UPDATE conversations SET labelIds = ',' || labelIds");
  }
  
  public void upgradeDbTo38()
  {
    mDb.execSQL("ALTER TABLE messages ADD COLUMN clientCreated INTEGER");
    mDb.execSQL("ALTER TABLE messages ADD COLUMN refMessageId INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo39()
  {
    MailCore.correctLocalLabelIds(mDb);
  }
  
  public void upgradeDbTo40() {}
  
  public void upgradeDbTo41()
  {
    mDb.execSQL("ALTER TABLE operations ADD COLUMN numAttempts INTEGER DEFAULT 0");
    mDb.execSQL("ALTER TABLE operations ADD COLUMN nextTimeToAttempt INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo42()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("ALTER TABLE labels ADD COLUMN color INTEGER DEFAULT 2147483647");
  }
  
  public void upgradeDbTo43()
  {
    mDb.execSQL("DROP TABLE IF EXISTS send_without_sync_conversations_to_fetch");
    mDb.execSQL("CREATE TABLE send_without_sync_conversations_to_fetch (_id INTEGER PRIMARY KEY)");
  }
  
  public void upgradeDbTo44()
  {
    mDb.execSQL("ALTER TABLE messages ADD COLUMN forward INTEGER DEFAULT 0");
    mDb.execSQL("ALTER TABLE messages ADD COLUMN includeQuotedText INTEGER DEFAULT 0");
    mDb.execSQL("ALTER TABLE messages ADD COLUMN quoteStartPos INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo45()
  {
    mDb.execSQL("DROP TABLE IF EXISTS attachments");
    mDb.execSQL("CREATE TABLE attachments (\n  _id INTEGER PRIMARY KEY,\n  messages_conversation INTEGER,\n  messages_messageId INTEGER,\n  messages_partId TEXT,\n  originExtras TEXT,\n  desiredRendition TEXT,  automatic INTEGER,\n  downloadedRendition TEXT,  downloadId INTEGER,\n  status TEXT,\n  saveToSd INTEGER,\n  filename TEXT, UNIQUE(\n    messages_conversation, messages_messageId,\n    messages_partId, desiredRendition, saveToSd),\n  UNIQUE(messages_messageId, messages_partId, desiredRendition, saveToSd))");
  }
  
  public void upgradeDbTo46()
  {
    mDb.execSQL("CREATE INDEX IF NOT EXISTS attachment_downloadid ON attachments (downloadId)");
  }
  
  public void upgradeDbTo47()
  {
    mDb.execSQL("CREATE INDEX IF NOT EXISTS messages_joinedAttachmentInfos ON messages (joinedAttachmentInfos)");
  }
  
  public void upgradeDbTo48()
  {
    mDb.execSQL("ALTER TABLE conversations ADD COLUMN dirty INTEGER DEFAULT 0");
  }
  
  public void upgradeDbTo49()
  {
    mDb.execSQL("ALTER TABLE messages ADD COLUMN bodyCompressed BLOB DEFAULT NULL");
  }
  
  public void upgradeDbTo50()
  {
    mDb.execSQL("CREATE INDEX IF NOT EXISTS conversations_queryId on conversations (queryId);");
    mDb.execSQL("CREATE INDEX IF NOT EXISTS messages_synced on messages (synced);");
  }
  
  public void upgradeDbTo51()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
    mDb.execSQL("DROP TABLE IF EXISTS info_overload");
    mDb.execSQL("CREATE TABLE info_overload (enabled_pref TEXT);");
  }
  
  public void upgradeDbTo52()
  {
    MailEngine.setSyncSetting(mDb, "startSyncNeeded", "1");
    mEngine.requestSync();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailStoreInitializer
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */