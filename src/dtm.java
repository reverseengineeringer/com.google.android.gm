import android.accounts.Account;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gm.provider.MailIndexerService;
import java.util.Random;

final class dtm
  extends dpv
{
  static final String d = cvl.a;
  
  dtm(drp paramdrp, SQLiteDatabase paramSQLiteDatabase)
  {
    super(paramdrp, paramSQLiteDatabase);
  }
  
  private final void e()
  {
    cty.a(b, "search_status");
    b.execSQL("CREATE TABLE search_status (_id INTEGER PRIMARY KEY, app_data_search_enabled INTEGER, incarnation TEXT, seqnos_trimmed INTEGER)");
    a(false);
  }
  
  private final void f()
  {
    b.execSQL("DROP TRIGGER IF EXISTS insert_messages");
    b.execSQL("DROP TRIGGER IF EXISTS update_messages");
    b.execSQL("DROP TRIGGER IF EXISTS update_messages_keychange");
    b.execSQL("DROP TRIGGER IF EXISTS delete_messages");
    b.execSQL("DROP TRIGGER IF EXISTS insert_message_labels");
    b.execSQL("DROP TRIGGER IF EXISTS update_message_labels");
    b.execSQL("DROP TRIGGER IF EXISTS delete_message_labels");
    b.execSQL(String.valueOf("  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,0,  new.messageId, new.conversation);\n").length() + 66 + "CREATE TRIGGER insert_messages AFTER INSERT ON messages\nBEGIN\n" + "  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,0,  new.messageId, new.conversation);\n" + "END;");
    b.execSQL(String.valueOf("  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,0,  new.messageId, new.conversation);\n").length() + 141 + "CREATE TRIGGER update_messages AFTER UPDATE ON messages\nWHEN new.messageId = old.messageId AND new.conversation = old.conversation\nBEGIN\n" + "  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,0,  new.messageId, new.conversation);\n" + "END;");
    b.execSQL(String.valueOf("  DELETE FROM search_sequence WHERE messageId = old.messageId\n  AND type IN (0,1);\n  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,1,  old.messageId, old.conversation);\n").length() + 152 + String.valueOf("  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,0,  new.messageId, new.conversation);\n").length() + "CREATE TRIGGER update_messages_keychange AFTER UPDATE ON messages\nWHEN new.messageId != old.messageId OR new.conversation != old.conversation\nBEGIN\n" + "  DELETE FROM search_sequence WHERE messageId = old.messageId\n  AND type IN (0,1);\n  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,1,  old.messageId, old.conversation);\n" + "  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,0,  new.messageId, new.conversation);\n" + "END;");
    b.execSQL(String.valueOf("  DELETE FROM search_sequence WHERE messageId = old.messageId\n  AND type IN (0,1);\n  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,1,  old.messageId, old.conversation);\n").length() + 66 + "CREATE TRIGGER delete_messages AFTER DELETE ON messages\nBEGIN\n" + "  DELETE FROM search_sequence WHERE messageId = old.messageId\n  AND type IN (0,1);\n  INSERT INTO search_sequence (type,action,messageId,conversationId)  VALUES(0,1,  old.messageId, old.conversation);\n" + "END;");
    b.execSQL("CREATE TRIGGER insert_message_labels AFTER INSERT ON message_labels\nBEGIN\n  INSERT INTO search_sequence (type,action,messageId,conversationId,labelId)  VALUES(1,0,  new.message_messageId, new.message_conversation, new.labels_id);\nEND;");
    b.execSQL("CREATE TRIGGER update_message_labels AFTER UPDATE ON message_labels\nBEGIN\n  DELETE FROM search_sequence WHERE messageId = old.message_messageId\n  AND type = 1 AND labelId = old.labels_id;\n  INSERT INTO search_sequence (type,action,messageId,conversationId,labelId)  VALUES(1,1,  old.message_messageId, old.message_conversation, old.labels_id);\n  INSERT INTO search_sequence (type,action,messageId,conversationId,labelId)  VALUES(1,0,  new.message_messageId, old.message_conversation, new.labels_id);\nEND;");
    b.execSQL("CREATE TRIGGER delete_message_labels AFTER DELETE ON message_labels\nBEGIN\n  DELETE FROM search_sequence WHERE messageId = old.message_messageId\n  AND type = 1 AND labelId = old.labels_id;\n  INSERT INTO search_sequence (type,action,messageId,conversationId,labelId)  VALUES(1,1,  old.message_messageId, old.message_conversation, old.labels_id);\nEND;");
  }
  
  private final void g()
  {
    cty.a(b, "dasher_info");
    b.execSQL("CREATE TABLE dasher_info (\n  _id INTEGER PRIMARY KEY,\n  domainTitle TEXT);");
  }
  
  private final void h()
  {
    cty.a(b, "blocked_senders");
    SQLiteDatabase localSQLiteDatabase = b;
    String str = String.valueOf("(creationTimeMs INTEGER NOT NULL DEFAULT 0, senderIdentifier TEXT, displayName TEXT, UNIQUE(senderIdentifier))");
    if (str.length() != 0) {}
    for (str = "CREATE TABLE blocked_senders".concat(str);; str = new String("CREATE TABLE blocked_senders"))
    {
      localSQLiteDatabase.execSQL(str);
      return;
    }
  }
  
  private final void i()
  {
    cty.a(b, "unsubscribed_senders");
    SQLiteDatabase localSQLiteDatabase = b;
    String str = String.valueOf("(creationTimeMs INTEGER NOT NULL DEFAULT 0, senderIdentifier TEXT, UNIQUE(senderIdentifier))");
    if (str.length() != 0) {}
    for (str = "CREATE TABLE unsubscribed_senders ".concat(str);; str = new String("CREATE TABLE unsubscribed_senders "))
    {
      localSQLiteDatabase.execSQL(str);
      return;
    }
  }
  
  private final void j()
  {
    drp.a(b, "startSyncNeeded", "1");
    a.k();
  }
  
  public final void a()
  {
    dri.c(drp.b, "Bootstrapping db: %s Current version is %d", new Object[] { b.getPath(), Integer.valueOf(b.getVersion()) });
    cty.a(b, "sync_settings");
    b.execSQL("CREATE TABLE sync_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))");
    cty.a(b, "engine_settings");
    b.execSQL("CREATE TABLE engine_settings (_id INTEGER PRIMARY KEY,name TEXT,value TEXT,UNIQUE (name))");
    cty.a(b, "messages");
    b.execSQL("CREATE TABLE messages (_id INTEGER PRIMARY KEY,messageId INTEGER,conversation INTEGER,fromAddress TEXT,toAddresses TEXT,ccAddresses TEXT,bccAddresses TEXT,replyToAddresses TEXT,dateSentMs INTEGER,dateReceivedMs INTEGER,subject TEXT,snippet TEXT,listInfo TEXT,personalLevel INTEGER,body TEXT,bodyEmbedsExternalResources INTEGER,joinedAttachmentInfos TEXT,synced INTEGER,error TEXT, clientCreated INTEGER, refMessageId INTEGER DEFAULT 0, forward INTEGER DEFAULT 0, includeQuotedText INTEGER DEFAULT 0, quoteStartPos INTEGER DEFAULT 0, bodyCompressed BLOB DEFAULT NULL, customFromAddress TEXT DEFAULT NULL, queryId INTEGER DEFAULT 1, spamDisplayedReasonType INTEGER DEFAULT -1,deliveryChannel INTEGER,referencesRfc822MessageIds TEXT,showSendersFullEmailAddress INTEGER,viaDomain TEXT,showForgedFromMeWarning INTEGER,refAdEventId TEXT,permalink TEXT,clipped INTEGER DEFAULT 0,encrypted INTEGER NOT NULL DEFAULT 0,signed INTEGER NOT NULL DEFAULT 0,receivedWithTls INTEGER NOT NULL DEFAULT 0,clientDomain TEXT DEFAULT NULL,unsubscribeSenderName TEXT DEFAULT NULL,unsubscribeSenderIdentifier TEXT DEFAULT NULL,syncBlocked INTEGER NOT NULL DEFAULT 0,hasEvent INTEGER DEFAULT 0,stylesheet TEXT,stylesheetRestrictor TEXT,eventTitle TEXT DEFAULT NULL,startTime INTEGER,endTime INTEGER,allDay INTEGER DEFAULT 0,location TEXT DEFAULT NULL,organizer TEXT DEFAULT NULL,attendees TEXT DEFAULT NULL,icalMethod INTEGER DEFAULT 8,eventId TEXT DEFAULT NULL,calendarId TEXT DEFAULT NULL,responder TEXT DEFAULT NULL,responseStatus INTEGER DEFAULT 0,spf TEXT DEFAULT NULL,dkim TEXT DEFAULT NULL,UNIQUE(messageId))");
    cty.a(b, "attachments");
    b.execSQL("CREATE TABLE attachments (\n  _id INTEGER PRIMARY KEY,\n  messages_conversation INTEGER,\n  messages_messageId INTEGER,\n  messages_partId TEXT,\n  originExtras TEXT,\n  desiredRendition TEXT,  automatic INTEGER,\n  downloadedRendition TEXT,  downloadId INTEGER,\n  status TEXT,\n  saveToSd INTEGER,\n  filename TEXT, priority INTEGER DEFAULT 0, mimeType TEXT DEFAULT NULL, size INTEGER DEFAULT 0, UNIQUE(\n    messages_conversation, messages_messageId,\n    messages_partId, desiredRendition, saveToSd),\n  UNIQUE(messages_messageId, messages_partId, desiredRendition, saveToSd))");
    b.execSQL("CREATE INDEX attachment_downloadid ON attachments (downloadId)");
    cty.a(b, "labels");
    b.execSQL("CREATE TABLE labels ( _id INTEGER PRIMARY KEY, canonicalName TEXT, name TEXT, numConversations TEXT, numUnreadConversations TEXT, color INTEGER DEFAULT 2147483647, systemLabel INTEGER DEFAULT 0, systemLabelOrder INTEGER DEFAULT 0, hidden INTEGER DEFAULT 0, labelCountDisplayBehavior INTEGER DEFAULT 0, labelSyncPolicy INTEGER DEFAULT 0, visibility TEXT, lastTouched INTEGER DEFAULT 0, numUnseenConversations INTEGER DEFAULT 0, lastMessageTimestamp INTEGER NOT NULL DEFAULT 0)");
    b.execSQL("CREATE INDEX labels_index ON labels (_id, canonicalName, numConversations, numUnreadConversations)");
    cty.a(b, "message_labels");
    b.execSQL("CREATE TABLE message_labels (_id INTEGER PRIMARY KEY,labels_id INTEGER not null,message_messageId INTEGER not null,message_conversation INTEGER,UNIQUE (labels_id, message_messageId))");
    b.execSQL("CREATE INDEX message_labels_index ON message_labels (labels_id, message_messageId, message_conversation)");
    b.execSQL("CREATE INDEX message_labels_conversation ON message_labels (message_conversation, labels_id)");
    cty.a(b, "operations");
    b.execSQL("CREATE TABLE operations (_id INTEGER PRIMARY KEY AUTOINCREMENT,action TEXT,message_messageId INTEGER,value1 INTEGER,value2 INTEGER, numAttempts INTEGER DEFAULT 0, nextTimeToAttempt INTEGER DEFAULT 0, delay INTEGER DEFAULT 0, value3 TEXT, value4 TEXT, value5 TEXT, value6 TEXT, value7 TEXT, value8 TEXT, value9 TEXT, value10 TEXT, value11 TEXT, value12 TEXT )");
    b.execSQL("CREATE INDEX operations_messageid_action_index ON operations (message_messageId, action)");
    cty.a(b, "conversations_to_fetch");
    b.execSQL("CREATE TABLE conversations_to_fetch (_id INTEGER PRIMARY KEY, nextAttemptDateMs INTEGER DEFAULT 0, numAttempts INTEGER DEFAULT 0)");
    cty.a(b, "send_without_sync_conversations_to_fetch");
    b.execSQL("CREATE TABLE send_without_sync_conversations_to_fetch (_id INTEGER PRIMARY KEY)");
    cty.a(b, "messages_to_fetch");
    b.execSQL("CREATE TABLE messages_to_fetch (_id INTEGER PRIMARY KEY)");
    cty.a(b, "conversation_labels;");
    b.execSQL("CREATE TABLE conversation_labels (  labels_id TEXT,   queryId INTEGER,   isZombie INTEGER,   sortMessageId INTEGER,   date INTEGER,   conversation_id INTEGER,   UNIQUE(labels_id, queryId, conversation_id));");
    b.execSQL("CREATE INDEX conversation_labels_index ON conversation_labels (labels_id, sortMessageId, queryId, isZombie, date, conversation_id);");
    b.execSQL("CREATE INDEX conversationLabels_conversationIndex ON conversation_labels (conversation_id, labels_id)");
    b.execSQL("CREATE INDEX conversationLabels_queryId ON conversation_labels (queryId)");
    cty.a(b, "conversations");
    b.execSQL("CREATE TABLE conversations (_id INTEGER, queryId INTEGER, subject TEXT, snippet TEXT, fromAddress TEXT, fromProtoBuf BLOB,fromCompact BLOB,personalLevel INTEGER, labelIds TEXT, numMessages INTEGER, maxMessageId INTEGER, hasAttachments INTEGER, hasMessagesWithErrors INTEGER, syncRationale TEXT, syncRationaleMessageId INTEGER, forceAllUnread INTEGER, dirty INTEGER DEFAULT 0, unreadMessageId INTEGER DEFAULT 0, unreadMessageLocalId INTEGER DEFAULT 0, attachmentPreviews TEXT DEFAULT NULL, attachmentPreviewStates INTEGER DEFAULT 0, attachmentPreviewsCount INTEGER DEFAULT 0, permalink TEXT DEFAULT NULL, unsubscribeSenderName TEXT DEFAULT NULL, promoteCalendar INTEGER DEFAULT 0, unsubscribeSenderIdentifier TEXT DEFAULT NULL, fromCompactV2 BLOB, hasCalendarInvite INTEGER DEFAULT 0, UNIQUE(_id, queryId));");
    b.execSQL("CREATE INDEX conversations_syncRationale on conversations (syncRationale, syncRationaleMessageId);");
    b.execSQL("CREATE INDEX conversations_queryId on conversations (queryId);");
    b.execSQL("CREATE INDEX labels_name on labels (canonicalName);");
    b.execSQL("CREATE INDEX labels_id on labels (_id);");
    b.execSQL("CREATE INDEX message_labels_message_messageId_labels_id on message_labels (message_messageId, labels_id);");
    b.execSQL("CREATE INDEX messages_messageId on messages (messageId);");
    b.execSQL("CREATE INDEX messages_queryId on messages (queryId);");
    b.execSQL("CREATE INDEX messages_conversation on messages (conversation, messageId);");
    b.execSQL("CREATE INDEX messages_messageId_queryId on messages (messageId, queryId);");
    b.execSQL("CREATE INDEX messages_joinedAttachmentInfos ON messages (joinedAttachmentInfos);");
    b.execSQL("CREATE INDEX messages_conversation_queryId on messages (conversation, queryId)");
    cty.a(b, "custom_label_color_prefs");
    b.execSQL("CREATE TABLE custom_label_color_prefs (\n  _id INTEGER PRIMARY KEY,\n  color_index TEXT,\n  text_color TEXT,\n  background_color TEXT);");
    cty.a(b, "custom_from_prefs");
    b.execSQL("CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  address TEXT,\n  is_default TEXT,\n  reply_to TEXT);");
    cty.a(b, "server_preferences");
    b.execSQL("CREATE TABLE server_preferences (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  value TEXT,\n  blobValue BLOB DEFAULT NULL);");
    cty.a(b, "info_overload");
    e();
    cty.a(b, "ads");
    b.execSQL("CREATE TABLE ads (_id INTEGER PRIMARY KEY, event_id TEXT, advertiser_name TEXT, title TEXT, line1 TEXT, visible_url TEXT, advertiser_image_data BLOB, body TEXT, expiration INTEGER, reason INTEGER, apm_extra_targeting_data TEXT, starred INTEGER, view_status INTEGER, view TEXT, slot TEXT, apm_xsrf_token TEXT, delete_status INTEGER DEFAULT 0, redirect_url TEXT, wta_data TEXT, view_url TEXT, click_url TEXT, interaction_url TEXT, body_view_urls TEXT, obfuscated_data TEXT, report_ad_server INTEGER, report_bow INTEGER, send_body INTEGER, show_body_feedback_survey INTEGER, report_duration_since_last_action INTEGER DEFAULT 0, click_id TEXT, aia_star_rating TEXT, aia_ratings_count INTEGER, aia_package_name TEXT, aia_inline_install_enabled INTEGER, aia_teaser_experiment INTEGER, aia_body_experiment INTEGER, dismiss_survey_data TEXT, aia_referrer TEXT, aia_install_url TEXT, aia_install_button_url TEXT, last_shown_timestamp INTEGER DEFAULT 0, last_clicked_timestamp INTEGER DEFAULT 0, last_starred_timestamp INTEGER DEFAULT 0, wta_get_url TEXT, wta_tooltip_type INTEGER DEFAULT 0, tab INTEGER DEFAULT 0, ad_client_dedup_id_data TEXT, report_duration_since_last_action_to_bow INTEGER DEFAULT 0, report_click_id_for_click_event INTEGER DEFAULT 0, UNIQUE(event_id))");
    b.execSQL("DROP TABLE IF EXISTS promotions");
    b.execSQL("CREATE TABLE promotions (_id INTEGER PRIMARY KEY, priority INTEGER, startTime INTEGER, expirationTime INTEGER, titleText TEXT, bodyText TEXT, bodyHtml TEXT, positiveButtonText TEXT, negativeButtonText TEXT, buttonUrl TEXT, rawImageData BLOB, minBuildSdk INTEGER)");
    g();
    h();
    i();
    chb.b(b);
    chb.a(b);
    cgd.b(b);
    cgd.a(b);
    b.setVersion(202);
  }
  
  final void a(boolean paramBoolean)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("_id", Integer.valueOf(0));
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localContentValues.put("app_data_search_enabled", Integer.valueOf(i));
      localContentValues.put("incarnation", Long.toHexString(new Random().nextLong()));
      localContentValues.put("seqnos_trimmed", Integer.valueOf(0));
      b.replace("search_status", null, localContentValues);
      return;
    }
  }
  
  final int b(int paramInt)
  {
    if ((paramInt >= 52) && (paramInt < 100)) {
      return 100;
    }
    return paramInt + 1;
  }
  
  public final boolean b()
  {
    boolean bool = true;
    Cursor localCursor = b.rawQuery("SELECT app_data_search_enabled FROM search_status WHERE _id = 0", null);
    try
    {
      if (localCursor.moveToNext())
      {
        int i = localCursor.getInt(0);
        if (i == 1) {}
        for (;;)
        {
          return bool;
          bool = false;
        }
      }
      return false;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  final void c()
  {
    b.execSQL("DROP INDEX IF EXISTS search_sequence_messageId_type_labelId");
    b.execSQL("DROP TRIGGER IF EXISTS insert_messages");
    b.execSQL("DROP TRIGGER IF EXISTS update_messages");
    b.execSQL("DROP TRIGGER IF EXISTS update_messages_keychange");
    b.execSQL("DROP TRIGGER IF EXISTS delete_messages");
    b.execSQL("DROP TRIGGER IF EXISTS insert_message_labels");
    b.execSQL("DROP TRIGGER IF EXISTS update_message_labels");
    b.execSQL("DROP TRIGGER IF EXISTS delete_message_labels");
    cty.a(b, "search_sequence");
  }
  
  final void d()
  {
    c();
    b.execSQL("CREATE TABLE search_sequence (\n_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL DEFAULT 0, action INTEGER NOT NULL DEFAULT 0, messageId INTEGER NOT NULL DEFAULT 0, conversationId INTEGER NOT NULL DEFAULT 0, labelId INTEGER NOT NULL DEFAULT 0);");
    f();
    b.execSQL("CREATE INDEX search_sequence_messageId_type_labelId ON search_sequence (messageId,type,labelId)");
    b.execSQL("INSERT INTO search_sequence (type,action,messageId,conversationId)  SELECT 0,0,  messageId,conversation FROM messages;");
    b.execSQL("INSERT INTO search_sequence (type,action,messageId,conversationId,labelId) SELECT 1,0, message_messageId,message_conversation,labels_id FROM message_labels;");
  }
  
  public final void upgradeDbTo100()
  {
    b.execSQL("ALTER TABLE labels ADD COLUMN systemLabel INTEGER DEFAULT 0");
    b.execSQL("UPDATE labels SET systemLabel = 1 WHERE substr(canonicalName, 1, 1) = '^'");
    b.execSQL("ALTER TABLE labels ADD COLUMN systemLabelOrder INTEGER DEFAULT 0");
    b.execSQL("UPDATE labels SET systemLabelOrder = 1 WHERE canonicalName = '^i'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 2 WHERE canonicalName = '^t'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = '^b'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = '^f'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = '^^out'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = '^r'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = '^all'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = '^s'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = '^k'");
    b.execSQL("ALTER TABLE labels ADD COLUMN hidden INTEGER DEFAULT 0");
    b.execSQL("UPDATE labels SET hidden = 1 WHERE substr(canonicalName, 1, 1) = '^' AND canonicalName NOT IN ('^i', '^t', '^b', '^f', '^^out', '^r', '^all', '^s', '^k')");
  }
  
  public final void upgradeDbTo101()
  {
    b.execSQL("ALTER TABLE labels ADD COLUMN labelCountDisplayBehavior INTEGER DEFAULT 0");
    b.execSQL("UPDATE labels SET labelCountDisplayBehavior = 1 WHERE canonicalName IN ('^^out', '^r', '^s')");
    b.execSQL("UPDATE labels SET labelCountDisplayBehavior = 2 WHERE canonicalName IN ('^f', '^t', '^b', '^all', '^k')");
  }
  
  public final void upgradeDbTo102()
  {
    b.execSQL("ALTER TABLE labels ADD COLUMN labelSyncPolicy INTEGER DEFAULT 0");
    b.execSQL("UPDATE labels SET labelSyncPolicy = 1 WHERE canonicalName IN ('^^out', '^r')");
    b.execSQL("UPDATE labels SET labelSyncPolicy = 2 WHERE canonicalName IN ('^s', '^b', '^all', '^k')");
    b.execSQL("UPDATE labels SET labelSyncPolicy = 3 WHERE canonicalName IN ('^i', '^f')");
  }
  
  public final void upgradeDbTo103()
  {
    int j = 0;
    SQLiteDatabase localSQLiteDatabase = b;
    Object localObject2 = a.q;
    Object localObject3 = new ContentValues[dpy.u.length];
    Object localObject4 = new StringBuilder();
    ((StringBuilder)localObject4).append("select ");
    int i = 0;
    while (i < dpy.u.length)
    {
      String str = dpy.u[i];
      if (i != 0) {
        ((StringBuilder)localObject4).append(", ");
      }
      ((StringBuilder)localObject4).append("(select value from sync_settings where name ='");
      ((StringBuilder)localObject4).append(str);
      ((StringBuilder)localObject4).append("') as ");
      ((StringBuilder)localObject4).append(str);
      localObject3[i] = new ContentValues();
      localObject3[i].put("name", str);
      i += 1;
    }
    localObject4 = localSQLiteDatabase.rawQuery(((StringBuilder)localObject4).toString(), null);
    ((Cursor)localObject4).moveToNext();
    i = 0;
    while (i < dpy.u.length)
    {
      localObject3[i].put("value", ((Cursor)localObject4).getString(i));
      i += 1;
    }
    ((Cursor)localObject4).close();
    ((SQLiteDatabase)localObject2).beginTransactionNonExclusive();
    try
    {
      ((SQLiteDatabase)localObject2).delete("internal_sync_settings", null, null);
      int k = localObject3.length;
      i = 0;
      while (i < k)
      {
        ((SQLiteDatabase)localObject2).insert("internal_sync_settings", null, localObject3[i]);
        i += 1;
      }
      ((SQLiteDatabase)localObject2).setTransactionSuccessful();
      ((SQLiteDatabase)localObject2).endTransaction();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("delete from sync_settings where ");
      i = j;
      while (i < dpy.u.length)
      {
        localObject3 = dpy.u[i];
        ((StringBuilder)localObject2).append(" name ='");
        ((StringBuilder)localObject2).append((String)localObject3);
        ((StringBuilder)localObject2).append("'");
        if (i != 3) {
          ((StringBuilder)localObject2).append(" OR ");
        }
        i += 1;
      }
      ((SQLiteDatabase)localObject1).execSQL(((StringBuilder)localObject2).toString());
    }
    finally
    {
      ((SQLiteDatabase)localObject2).endTransaction();
    }
    drp localdrp = a;
    localObject2 = new Intent("com.google.android.gm.intent.ACTION_UPGRADE_SYNC_WINDOW");
    ((Intent)localObject2).putExtra("account", l.name);
    localdrp.getContext().sendBroadcast((Intent)localObject2, "com.google.android.gm.permission.BROADCAST_INTERNAL");
  }
  
  public final void upgradeDbTo104()
  {
    j();
    cty.a(b, "custom_label_color_prefs");
    b.execSQL("CREATE TABLE custom_label_color_prefs (\n  _id INTEGER PRIMARY KEY,\n  color_index TEXT,\n  text_color TEXT,\n  background_color TEXT);");
  }
  
  public final void upgradeDbTo105()
  {
    j();
    cty.a(b, "custom_from_prefs");
    b.execSQL("CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  is_default TEXT,\n  reply_to TEXT);");
  }
  
  public final void upgradeDbTo106()
  {
    j();
    cty.a(b, "server_preferences");
    b.execSQL("CREATE TABLE server_preferences (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  value TEXT);");
  }
  
  public final void upgradeDbTo107()
  {
    j();
    b.execSQL("ALTER TABLE labels ADD COLUMN visibility TEXT");
  }
  
  public final void upgradeDbTo108()
  {
    j();
    b.execSQL("UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = '^io_im'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = '^b'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = '^f'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = '^^out'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = '^r'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = '^all'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = '^s'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 10 WHERE canonicalName = '^k'");
    cty.a(b, "info_overload");
  }
  
  public final void upgradeDbTo109()
  {
    b.execSQL("ALTER TABLE attachments ADD COLUMN priority INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo110()
  {
    if ((c < 100) && (c >= 53))
    {
      dri.d(drp.b, "skipping v110 mailstore upgrade due to initial version %d", new Object[] { Integer.valueOf(c) });
      return;
    }
    b.execSQL("ALTER TABLE conversations_to_fetch ADD COLUMN nextAttemptDateMs INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE conversations_to_fetch ADD COLUMN numAttempts INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo111()
  {
    if ((c < 100) && (c >= 54))
    {
      dri.d(drp.b, "skipping v111 mailstore upgrade due to initial version %d", new Object[] { Integer.valueOf(c) });
      return;
    }
    b.execSQL("ALTER TABLE messages ADD COLUMN customFromAddress TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo112()
  {
    j();
    b.execSQL("UPDATE labels SET systemLabelOrder = 2 WHERE canonicalName = '^iim'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 3 WHERE canonicalName = '^t'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 4 WHERE canonicalName = '^io_im'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 5 WHERE canonicalName = '^b'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 6 WHERE canonicalName = '^f'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 7 WHERE canonicalName = '^^out'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 8 WHERE canonicalName = '^r'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 9 WHERE canonicalName = '^all'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 10 WHERE canonicalName = '^s'");
    b.execSQL("UPDATE labels SET systemLabelOrder = 11 WHERE canonicalName = '^k'");
  }
  
  public final void upgradeDbTo113()
  {
    j();
  }
  
  public final void upgradeDbTo114()
  {
    a.j = true;
    a.k();
  }
  
  public final void upgradeDbTo115()
  {
    j();
  }
  
  public final void upgradeDbTo116()
  {
    j();
    b.execSQL("UPDATE labels SET labelCountDisplayBehavior = 2 WHERE canonicalName = '^io_im'");
  }
  
  public final void upgradeDbTo117()
  {
    b.execSQL("ALTER TABLE attachments ADD COLUMN mimeType TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo118()
  {
    b.execSQL("UPDATE labels SET labelSyncPolicy = 0 WHERE canonicalName = '^i'");
  }
  
  public final void upgradeDbTo119()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN queryId INTEGER DEFAULT 1");
    b.execSQL("UPDATE messages SET queryId = 0 WHERE synced = 1");
    b.execSQL("DELETE FROM messages where synced = 0");
    b.execSQL("CREATE INDEX IF NOT EXISTS messages_queryId on messages (queryId);");
    b.execSQL("DROP INDEX IF EXISTS messages_synced;");
  }
  
  public final void upgradeDbTo120()
  {
    MailIndexerService.b(b);
  }
  
  public final void upgradeDbTo121()
  {
    b.execSQL("ALTER TABLE labels ADD COLUMN lastTouched INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo122()
  {
    j();
  }
  
  public final void upgradeDbTo123()
  {
    b.execSQL("CREATE INDEX IF NOT EXISTS messages_messageId_queryId on messages (messageId, queryId);");
  }
  
  public final void upgradeDbTo124()
  {
    if ((c < 100) && (c >= 60))
    {
      dri.d(drp.b, "skipping v124 mailstore upgrade due to initial version %d", new Object[] { Integer.valueOf(c) });
      return;
    }
    b.execSQL("ALTER TABLE operations ADD COLUMN delay INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo125()
  {
    cty.a(b, "message_fts_table_index");
    b.execSQL("CREATE TABLE message_fts_table_index(docid INTEGER PRIMARY KEY)");
    cty.a(b, "conversation_fts_table_index");
    b.execSQL("CREATE TABLE conversation_fts_table_index(docid INTEGER PRIMARY KEY)");
  }
  
  public final void upgradeDbTo126()
  {
    b.execSQL("CREATE INDEX IF NOT EXISTS messages_conversation_queryId on messages (conversation, queryId)");
  }
  
  public final void upgradeDbTo127()
  {
    j();
    cty.a(b, "custom_from_prefs");
    b.execSQL("CREATE TABLE custom_from_prefs (\n  _id TEXT PRIMARY KEY,\n  name TEXT,\n  address TEXT,\n  is_default TEXT,\n  reply_to TEXT);");
  }
  
  public final void upgradeDbTo128()
  {
    e();
  }
  
  public final void upgradeDbTo129()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN spamDisplayedReasonType INTEGER");
    b.execSQL("ALTER TABLE messages ADD COLUMN deliveryChannel INTEGER");
    b.execSQL("ALTER TABLE messages ADD COLUMN referencesRfc822MessageIds TEXT");
  }
  
  public final void upgradeDbTo130()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN fromProtoBuf BLOB");
  }
  
  public final void upgradeDbTo131()
  {
    b.execSQL("DELETE FROM labels WHERE canonicalName='' AND name='';");
  }
  
  public final void upgradeDbTo132()
  {
    cty.a(b, "info_overload");
    j();
    b.execSQL("ALTER TABLE server_preferences ADD COLUMN blobValue BLOB DEFAULT NULL;");
  }
  
  public final void upgradeDbTo133()
  {
    b.execSQL("ALTER TABLE labels ADD COLUMN numUnseenConversations INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo134()
  {
    b.execSQL("ALTER TABLE labels ADD COLUMN lastMessageTimestamp INTEGER NOT NULL DEFAULT 0");
  }
  
  public final void upgradeDbTo135()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value3 TEXT");
  }
  
  public final void upgradeDbTo136()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN showSendersFullEmailAddress INTEGER");
    b.execSQL("ALTER TABLE messages ADD COLUMN viaDomain TEXT");
    b.execSQL("ALTER TABLE messages ADD COLUMN showForgedFromMeWarning INTEGER");
  }
  
  public final void upgradeDbTo137()
  {
    j();
  }
  
  public final void upgradeDbTo138()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN fromCompact BLOB");
  }
  
  public final void upgradeDbTo139()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN unreadMessageId INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE conversations ADD COLUMN unreadMessageLocalId INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE conversations ADD COLUMN attachmentPreviews TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE conversations ADD COLUMN attachmentPreviewStates INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE conversations ADD COLUMN attachmentPreviewsCount INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo140()
  {
    b.execSQL("ALTER TABLE attachments ADD COLUMN size INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo141() {}
  
  public final void upgradeDbTo142()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value4 TEXT");
    b.execSQL("ALTER TABLE operations ADD COLUMN value5 TEXT");
    b.execSQL("ALTER TABLE operations ADD COLUMN value6 TEXT");
  }
  
  public final void upgradeDbTo143() {}
  
  public final void upgradeDbTo144() {}
  
  public final void upgradeDbTo145()
  {
    cty.a(b, "ads");
    b.execSQL("CREATE TABLE ads (_id INTEGER PRIMARY KEY, event_id TEXT, advertiser_name TEXT, title TEXT, line1 TEXT, visible_url TEXT, advertiser_image_data BLOB, body TEXT, expiration INTEGER, reason INTEGER, apm_extra_targeting_data TEXT, starred INTEGER, view_status INTEGER, view TEXT, slot TEXT, apm_xsrf_token TEXT, delete_status INTEGER DEFAULT 0, UNIQUE(event_id))");
  }
  
  public final void upgradeDbTo146()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN refAdEventId TEXT");
  }
  
  public final void upgradeDbTo147()
  {
    if (b()) {
      f();
    }
  }
  
  public final void upgradeDbTo148()
  {
    b.execSQL("UPDATE conversations SET unreadMessageId = 0");
    b.execSQL("UPDATE conversations SET unreadMessageLocalId = 0");
    b.execSQL("UPDATE conversations SET attachmentPreviews = NULL");
    b.execSQL("UPDATE conversations SET attachmentPreviewStates = 0");
    b.execSQL("UPDATE conversations SET attachmentPreviewsCount = 0");
  }
  
  public final void upgradeDbTo149() {}
  
  public final void upgradeDbTo150()
  {
    g();
    j();
  }
  
  public final void upgradeDbTo151()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN permalink TEXT");
    b.execSQL("ALTER TABLE messages ADD COLUMN clipped INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE conversations ADD COLUMN permalink TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo152()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN redirect_url TEXT");
  }
  
  public final void upgradeDbTo153()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN wta_data TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN view_url TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN click_url TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN interaction_url TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN obfuscated_data TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN report_ad_server INTEGER");
    b.execSQL("ALTER TABLE ads ADD COLUMN report_bow INTEGER");
    b.execSQL("ALTER TABLE ads ADD COLUMN send_body INTEGER");
    b.execSQL("ALTER TABLE ads ADD COLUMN click_id TEXT");
  }
  
  public final void upgradeDbTo154()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value7 TEXT");
    b.execSQL("ALTER TABLE operations ADD COLUMN value8 TEXT");
  }
  
  public final void upgradeDbTo155()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_star_rating TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_ratings_count INTEGER");
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_package_name TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_inline_install_enabled INTEGER");
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_teaser_experiment INTEGER");
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_body_experiment INTEGER");
  }
  
  public final void upgradeDbTo156()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN show_body_feedback_survey INTEGER");
  }
  
  public final void upgradeDbTo157()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value9 TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN dismiss_survey_data TEXT");
  }
  
  public final void upgradeDbTo158()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_referrer TEXT");
  }
  
  public final void upgradeDbTo159()
  {
    b.execSQL("DROP TABLE IF EXISTS promotions");
    b.execSQL("CREATE TABLE promotions (_id INTEGER PRIMARY KEY, priority INTEGER, startTime INTEGER, expirationTime INTEGER, titleText TEXT, bodyText TEXT, bodyHtml TEXT, positiveButtonText TEXT, negativeButtonText TEXT, buttonUrl TEXT, rawImageData BLOB, minBuildSdk INTEGER)");
  }
  
  public final void upgradeDbTo160()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value10 TEXT");
  }
  
  public final void upgradeDbTo161()
  {
    e();
    if (bgr.b(a.k))
    {
      a(true);
      b.execSQL("UPDATE search_status SET seqnos_trimmed = 1");
      b.execSQL("UPDATE search_status SET incarnation = ''");
    }
  }
  
  public final void upgradeDbTo162()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_install_url TEXT");
  }
  
  public final void upgradeDbTo163()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN unsubscribeSenderName TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE conversations ADD COLUMN unsubscribeSenderName TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo164()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN aia_install_button_url TEXT");
  }
  
  /* Error */
  public final void upgradeDbTo165()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 690	dtm:b	()Z
    //   4: ifne +4 -> 8
    //   7: return
    //   8: aload_0
    //   9: getfield 25	dtm:b	Landroid/database/sqlite/SQLiteDatabase;
    //   12: ldc_w 792
    //   15: iconst_1
    //   16: anewarray 64	java/lang/String
    //   19: dup
    //   20: iconst_0
    //   21: ldc_w 432
    //   24: aastore
    //   25: ldc_w 794
    //   28: aconst_null
    //   29: aconst_null
    //   30: aconst_null
    //   31: aconst_null
    //   32: invokevirtual 798	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   35: astore_2
    //   36: aload_2
    //   37: ifnull +50 -> 87
    //   40: aload_2
    //   41: invokeinterface 801 1 0
    //   46: istore_1
    //   47: iload_1
    //   48: ifle +39 -> 87
    //   51: iconst_1
    //   52: istore_1
    //   53: aload_2
    //   54: ifnull +9 -> 63
    //   57: aload_2
    //   58: invokeinterface 350 1 0
    //   63: iload_1
    //   64: ifne -57 -> 7
    //   67: getstatic 144	drp:b	Ljava/lang/String;
    //   70: ldc_w 803
    //   73: iconst_0
    //   74: anewarray 148	java/lang/Object
    //   77: invokestatic 805	dri:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   80: pop
    //   81: aload_0
    //   82: iconst_0
    //   83: invokevirtual 43	dtm:a	(Z)V
    //   86: return
    //   87: iconst_0
    //   88: istore_1
    //   89: goto -36 -> 53
    //   92: astore_3
    //   93: aload_2
    //   94: ifnull +9 -> 103
    //   97: aload_2
    //   98: invokeinterface 350 1 0
    //   103: aload_3
    //   104: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	105	0	this	dtm
    //   46	43	1	i	int
    //   35	63	2	localCursor	Cursor
    //   92	12	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   40	47	92	finally
  }
  
  public final void upgradeDbTo166()
  {
    h();
  }
  
  public final void upgradeDbTo167()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN encrypted INTEGER NOT NULL DEFAULT 0");
    b.execSQL("ALTER TABLE messages ADD COLUMN signed INTEGER NOT NULL DEFAULT 0");
  }
  
  public final void upgradeDbTo168()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN unsubscribeSenderIdentifier TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo169()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN receivedWithTls INTEGER NOT NULL DEFAULT 0");
  }
  
  public final void upgradeDbTo170()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN promoteCalendar INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo171() {}
  
  public final void upgradeDbTo172()
  {
    Cursor localCursor = b.rawQuery("SELECT * FROM sqlite_master WHERE type LIKE 'table' AND name LIKE 'messages' AND sql LIKE '%smartReply%'", null);
    if (localCursor != null) {}
    try
    {
      if (localCursor.getCount() > 0) {
        b.execSQL("UPDATE messages SET smartReply=null");
      }
      return;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public final void upgradeDbTo173()
  {
    i();
    b.execSQL("ALTER TABLE conversations ADD COLUMN unsubscribeSenderIdentifier TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo174()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value11 TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN report_duration_since_last_action INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE ads ADD COLUMN last_shown_timestamp INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE ads ADD COLUMN last_clicked_timestamp INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE ads ADD COLUMN last_starred_timestamp INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo175() {}
  
  public final void upgradeDbTo176()
  {
    b.execSQL("DROP TRIGGER IF EXISTS delete_smart_replies");
    cty.a(b, "smart_replies");
  }
  
  public final void upgradeDbTo177()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN wta_get_url TEXT");
    b.execSQL("ALTER TABLE ads ADD COLUMN wta_tooltip_type INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo178() {}
  
  public final void upgradeDbTo179()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN syncBlocked INTEGER NOT NULL DEFAULT 0");
  }
  
  public final void upgradeDbTo180()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN body_view_urls TEXT");
  }
  
  public final void upgradeDbTo181() {}
  
  public final void upgradeDbTo182() {}
  
  public final void upgradeDbTo183()
  {
    b.execSQL("UPDATE messages SET spamDisplayedReasonType=-1 WHERE spamDisplayedReasonType IS NULL");
  }
  
  public final void upgradeDbTo184()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN hasEvent INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE messages ADD COLUMN eventTitle TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE messages ADD COLUMN startTime INTEGER");
    b.execSQL("ALTER TABLE messages ADD COLUMN endTime INTEGER");
    b.execSQL("ALTER TABLE messages ADD COLUMN allDay INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE messages ADD COLUMN location TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE messages ADD COLUMN organizer TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE messages ADD COLUMN attendees TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo185()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN icalMethod INTEGER DEFAULT 8");
    b.execSQL("ALTER TABLE messages ADD COLUMN eventId TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE messages ADD COLUMN calendarId TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo186() {}
  
  public final void upgradeDbTo187()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN fromCompactV2 BLOB");
  }
  
  public final void upgradeDbTo188()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN hasCalendarInvite INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo189()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN responder TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE messages ADD COLUMN responseStatus INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo190() {}
  
  public final void upgradeDbTo191()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN tab INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE ads ADD COLUMN ad_client_dedup_id_data TEXT");
  }
  
  public final void upgradeDbTo192() {}
  
  public final void upgradeDbTo193()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN value12 TEXT");
  }
  
  public final void upgradeDbTo194()
  {
    cgd.b(b);
    cgd.a(b);
  }
  
  public final void upgradeDbTo195()
  {
    b.execSQL("UPDATE operations SET value8 = '0' WHERE   IFNULL(value8, '') = '' and   action = 'organicEvent'");
  }
  
  public final void upgradeDbTo196() {}
  
  public final void upgradeDbTo197()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN clientDomain TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo198()
  {
    chb.b(b);
    chb.a(b);
  }
  
  public final void upgradeDbTo199()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN spf TEXT DEFAULT NULL");
    b.execSQL("ALTER TABLE messages ADD COLUMN dkim TEXT DEFAULT NULL");
  }
  
  public final void upgradeDbTo200()
  {
    b.execSQL("UPDATE conversations SET syncRationale = '0' WHERE syncRationale = 'LABEL'");
    b.execSQL("UPDATE conversations SET syncRationale = '1' WHERE syncRationale = 'DURATION'");
    b.execSQL("UPDATE conversations SET syncRationale = '2' WHERE syncRationale = 'NONE'");
    b.execSQL("UPDATE conversations SET syncRationale = '3' WHERE syncRationale = 'UNKNOWN'");
    b.execSQL("UPDATE conversations SET syncRationale = '4' WHERE syncRationale = 'LOCAL_CHANGE'");
  }
  
  public final void upgradeDbTo201()
  {
    b.execSQL("ALTER TABLE ads ADD COLUMN report_duration_since_last_action_to_bow INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE ads ADD COLUMN report_click_id_for_click_event INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo202()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN stylesheet TEXT");
    b.execSQL("ALTER TABLE messages ADD COLUMN stylesheetRestrictor TEXT");
  }
  
  public final void upgradeDbTo37()
  {
    b.execSQL("UPDATE conversations SET labelIds = ',' || labelIds");
  }
  
  public final void upgradeDbTo38()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN clientCreated INTEGER");
    b.execSQL("ALTER TABLE messages ADD COLUMN refMessageId INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo39()
  {
    drj.a(b);
  }
  
  public final void upgradeDbTo40() {}
  
  public final void upgradeDbTo41()
  {
    b.execSQL("ALTER TABLE operations ADD COLUMN numAttempts INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE operations ADD COLUMN nextTimeToAttempt INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo42()
  {
    j();
    b.execSQL("ALTER TABLE labels ADD COLUMN color INTEGER DEFAULT 2147483647");
  }
  
  public final void upgradeDbTo43()
  {
    cty.a(b, "send_without_sync_conversations_to_fetch");
    b.execSQL("CREATE TABLE send_without_sync_conversations_to_fetch (_id INTEGER PRIMARY KEY)");
  }
  
  public final void upgradeDbTo44()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN forward INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE messages ADD COLUMN includeQuotedText INTEGER DEFAULT 0");
    b.execSQL("ALTER TABLE messages ADD COLUMN quoteStartPos INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo45()
  {
    cty.a(b, "attachments");
    b.execSQL("CREATE TABLE attachments (\n  _id INTEGER PRIMARY KEY,\n  messages_conversation INTEGER,\n  messages_messageId INTEGER,\n  messages_partId TEXT,\n  originExtras TEXT,\n  desiredRendition TEXT,  automatic INTEGER,\n  downloadedRendition TEXT,  downloadId INTEGER,\n  status TEXT,\n  saveToSd INTEGER,\n  filename TEXT, UNIQUE(\n    messages_conversation, messages_messageId,\n    messages_partId, desiredRendition, saveToSd),\n  UNIQUE(messages_messageId, messages_partId, desiredRendition, saveToSd))");
  }
  
  public final void upgradeDbTo46()
  {
    b.execSQL("CREATE INDEX IF NOT EXISTS attachment_downloadid ON attachments (downloadId)");
  }
  
  public final void upgradeDbTo47()
  {
    b.execSQL("CREATE INDEX IF NOT EXISTS messages_joinedAttachmentInfos ON messages (joinedAttachmentInfos)");
  }
  
  public final void upgradeDbTo48()
  {
    b.execSQL("ALTER TABLE conversations ADD COLUMN dirty INTEGER DEFAULT 0");
  }
  
  public final void upgradeDbTo49()
  {
    b.execSQL("ALTER TABLE messages ADD COLUMN bodyCompressed BLOB DEFAULT NULL");
  }
  
  public final void upgradeDbTo50()
  {
    b.execSQL("CREATE INDEX IF NOT EXISTS conversations_queryId on conversations (queryId);");
    b.execSQL("CREATE INDEX IF NOT EXISTS messages_synced on messages (synced);");
  }
  
  public final void upgradeDbTo51()
  {
    j();
    cty.a(b, "info_overload");
  }
  
  public final void upgradeDbTo52()
  {
    j();
  }
}

/* Location:
 * Qualified Name:     dtm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */