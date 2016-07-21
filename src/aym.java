import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Policy;
import java.util.Locale;

public final class aym
{
  private static final String[] a = { "hostAuthKeyRecv", "emailAddress" };
  private static final String[] b = { "protocol", "password" };
  private static final String[] c = { "_id", "flags", "hostAuthKeyRecv" };
  private static final String[] d = { "protocol" };
  private static final int[] e = { 17, 16, 14, 18, 15 };
  private static final String[] f = { "bccList", "ccList", "fromList", "replyToList", "toList" };
  
  static void A(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE Mailbox SET serverId=displayName WHERE Mailbox._id IN ( SELECT Mailbox._id FROM Mailbox,Account,HostAuth WHERE (Mailbox.parentKey isnull OR Mailbox.parentKey=0 ) AND Mailbox.accountKey=Account._id AND Account.hostAuthKeyRecv=HostAuth._id AND ( HostAuth.protocol='imap' OR HostAuth.protocol='pop3' ) )");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(17), Integer.valueOf(18) });
      a("to_v18");
    }
  }
  
  static void B(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("alter table Mailbox add column lastTouchedTime integer default 0;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(22), Integer.valueOf(23) });
      a("to_v23");
    }
  }
  
  static void C(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("alter table HostAuth add column certAlias text;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(23), Integer.valueOf(24) });
      a("to_v24");
    }
  }
  
  static void D(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      t(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(24), Integer.valueOf(25) });
      a("to_v25");
    }
  }
  
  static void E(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      Cursor localCursor1 = paramSQLiteDatabase.query("Account", c, null, null, null, null, null);
      ContentValues localContentValues = new ContentValues();
      try
      {
        String[] arrayOfString = new String[1];
        if (localCursor1.moveToNext())
        {
          arrayOfString[0] = localCursor1.getString(2);
          localCursor2 = paramSQLiteDatabase.query("HostAuth", d, "_id=?", arrayOfString, null, null, null);
        }
      }
      finally
      {
        try
        {
          for (;;)
          {
            if ((localCursor2.moveToFirst()) && ("imap".equals(localCursor2.getString(0))))
            {
              String str = localCursor1.getString(0);
              localContentValues.put("flags", Integer.valueOf(localCursor1.getInt(1) | 0x800));
              paramSQLiteDatabase.update("Account", localContentValues, "_id=?", new String[] { str });
            }
            localCursor2.close();
          }
        }
        finally
        {
          Cursor localCursor2;
          localCursor2.close();
        }
        paramSQLiteDatabase = finally;
        localCursor1.close();
      }
      localCursor1.close();
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(25), Integer.valueOf(26) });
      a("to_v26");
      return;
    }
  }
  
  static void F(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      av(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(29), Integer.valueOf(30) });
      a("to_v30");
    }
  }
  
  static void G(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      av(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(125), Integer.valueOf(126) });
      a("to_v126");
    }
  }
  
  static void H(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD serverThreadId text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Updates ADD serverThreadId text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD serverThreadId text;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(127), Integer.valueOf(128) });
      a("to_v128");
    }
  }
  
  static void I(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.delete("Attachment", "(flags&1024)!=0", null);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(128), Integer.valueOf(129) });
      a("to_v129");
    }
  }
  
  static void J(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD retryCount integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD nextRetryTime integer;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(129), Integer.valueOf(130) });
      a("to_v130");
    }
  }
  
  static void K(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Updates ADD retryCount integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Updates ADD nextRetryTime integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD retryCount integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD nextRetryTime integer;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(130), Integer.valueOf(131) });
      a("to_v131");
    }
  }
  
  static void L(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD inReplyTo text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD mailReferences text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD threadId integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Updates ADD inReplyTo text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Updates ADD mailReferences text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Updates ADD threadId integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD inReplyTo text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD mailReferences text;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD threadId integer;");
      cty.a(paramSQLiteDatabase, "Message", "messageId");
      cty.a(paramSQLiteDatabase, "Message", "inReplyTo");
      cty.a(paramSQLiteDatabase, "Message", "threadId");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(131), Integer.valueOf(133) });
      a("to_v133");
    }
  }
  
  static void M(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE MessageStateChange ADD oldFlagAnswered integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE MessageStateChange ADD newFlagAnswered integer;");
      paramSQLiteDatabase.execSQL("DROP TABLE Message_Updates;");
      paramSQLiteDatabase.execSQL("DROP TRIGGER mailbox_delete;");
      paramSQLiteDatabase.execSQL("create trigger mailbox_delete before delete on Mailbox begin delete from Message  where mailboxKey=old._id; delete from Message_Deletes  where mailboxKey=old._id; end");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(133), Integer.valueOf(134) });
      a("to_v134");
    }
  }
  
  static void N(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE MessageStateChange ADD oldFlagForwarded integer;");
      paramSQLiteDatabase.execSQL("ALTER TABLE MessageStateChange ADD newFlagForwarded integer;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(134), Integer.valueOf(135) });
      a("to_v135");
    }
  }
  
  static void O(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE Thread (threadKey INTEGER PRIMARY KEY NOT NULL, threadTopic TEXT, numMessage INTEGER DEFAULT 0, numDraft INTEGER DEFAULT 0)");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_insert BEFORE INSERT ON Message WHEN NEW._id = NEW.threadId BEGIN INSERT INTO thread (threadKey,threadTopic) VALUES (NEW.threadId, NEW.subject); END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_numMessage_increment AFTER INSERT on Message BEGIN UPDATE Thread set numMessage = numMessage + 1 WHERE threadKey = NEW.threadId; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_numMessage_decrement BEFORE DELETE ON Message BEGIN UPDATE Thread SET numMessage = numMessage - 1 WHERE threadKey = OLD.threadId; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_remove AFTER UPDATE on Thread WHEN NEW.numMessage = 0 BEGIN DELETE FROM Thread WHERE threadKey = OLD.threadKey; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thead_key_change AFTER UPDATE OF threadId ON Message WHEN OLD.threadId != NEW.threadId BEGIN INSERT OR REPLACE INTO Thread (threadKey,numMessage) VALUES (NEW.threadId, (SELECT COUNT(*) FROM Message WHERE threadId = NEW.threadId)); UPDATE Thread SET numMessage = numMessage - 1 WHERE threadKey = OLD.threadId; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_numDraft_insert BEFORE INSERT ON Message WHEN (NEW.flags & 32505859) != 0 BEGIN UPDATE Thread SET numDraft = numDraft + 1 WHERE threadKey = NEW.threadId; END;");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_numDraft_deleted BEFORE DELETE ON Message WHEN (OLD.flags & 32505859) != 0 BEGIN UPDATE Thread SET numDraft = numDraft - 1 WHERE threadKey = OLD.threadId; END;");
      String str1 = String.valueOf("CREATE TRIGGER thread_numDraft_update AFTER UPDATE OF flags,threadId ON Message BEGIN ");
      String str2 = String.valueOf(String.format(Locale.US, "UPDATE Thread SET numDraft = (SELECT COUNT(*) FROM Message WHERE threadId = %s.threadId AND (flags & 32505859) != 0) WHERE threadKey = %s.threadId;", new Object[] { "OLD", "OLD" }));
      String str3 = String.valueOf(String.format(Locale.US, "UPDATE Thread SET numDraft = (SELECT COUNT(*) FROM Message WHERE threadId = %s.threadId AND (flags & 32505859) != 0) WHERE threadKey = %s.threadId;", new Object[] { "NEW", "NEW" }));
      paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 5 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + str2 + str3 + " END;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(135), Integer.valueOf(136) });
      a("to_v136");
    }
  }
  
  static void P(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TRIGGER thead_key_change");
      paramSQLiteDatabase.execSQL("UPDATE Message SET threadId = NULL");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER thread_key_change AFTER UPDATE OF threadId ON Message WHEN OLD.threadId != NEW.threadId BEGIN INSERT OR IGNORE INTO Thread (threadKey) VALUES (NEW.threadId); UPDATE Thread SET numMessage = (SELECT COUNT(*) FROM Message WHERE threadId = NEW.threadId),threadTopic = (SELECT subject FROM Message WHERE threadId = NEW.threadId ORDER BY timeStamp DESC LIMIT 1) WHERE threadKey = NEW.threadId;  UPDATE Thread SET numMessage = numMessage - 1 WHERE threadKey = OLD.threadId; END;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(136), Integer.valueOf(137) });
      a("to_v137");
    }
  }
  
  static void Q(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE Message SET flagLoaded = 6 WHERE flagLoaded = 1 AND threadId IS NULL AND inReplyTo IS NULL");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(137), Integer.valueOf(138) });
      a("to_v138");
    }
  }
  
  static void R(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_insert");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_numMessage_increment");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_numMessage_decrement");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_remove");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_numDraft_insert");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_numDraft_deleted");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_numDraft_update");
      paramSQLiteDatabase.execSQL("DROP TRIGGER thread_key_change");
      cty.a(paramSQLiteDatabase, "Thread");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(138), Integer.valueOf(139) });
      a("to_v139");
    }
  }
  
  static void S(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN androidMessageId TEXT;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(139), Integer.valueOf(140) });
      a("to_v140");
    }
  }
  
  static void T(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN androidMessageId TEXT;");
      cty.a(paramSQLiteDatabase, "Message", "androidMessageId");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(140), Integer.valueOf(141) });
      a("to_v141");
    }
  }
  
  static void U(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      c(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(141), Integer.valueOf(142) });
      a("to_v142");
    }
  }
  
  static void V(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE Account SET maxAttachmentSize=1024*maxAttachmentSize");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(142), Integer.valueOf(143) });
      a("to_v143");
    }
  }
  
  static void W(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("UPDATE Account SET syncInterval='15' WHERE syncInterval='10' OR syncInterval='5'");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(143), Integer.valueOf(144) });
      a("to_v144");
    }
  }
  
  static void X(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Account ADD COLUMN sendingCapabilities integer");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(145), Integer.valueOf(146) });
      a("to_v146");
    }
  }
  
  static void Y(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Mailbox ADD COLUMN localOnly INTEGER DEFAULT 0");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(146), Integer.valueOf(147) });
      a("to_v147");
    }
  }
  
  static void Z(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Mailbox ADD COLUMN previousName TEXT DEFAULT NULL");
      paramSQLiteDatabase.execSQL("ALTER TABLE Mailbox ADD COLUMN isDeleted INTEGER DEFAULT 0");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(147), Integer.valueOf(148) });
      a("to_v148");
    }
  }
  
  static void a(Context paramContext)
  {
    aa.edit().putBoolean("need_eas16_resync_calendar", true).putBoolean("need_eas16_resync_contacts", true).apply();
  }
  
  static void a(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create trigger message_delete_duplicates_on_insert before insert on Message for each row when new.syncServerId is not null and (select type from Mailbox where _id=new.mailboxKey)!=8 and (select HostAuth.protocol from HostAuth,Account where new.accountKey=Account._id and Account.hostAuthKeyRecv=HostAuth._id)='");
    paramContext = String.valueOf(paramContext.getString(arh.ck));
    String str2 = String.valueOf("Message");
    String str3 = String.valueOf("syncServerId");
    String str4 = String.valueOf("syncServerId");
    String str5 = String.valueOf("accountKey");
    String str6 = String.valueOf("accountKey");
    String str7 = String.valueOf("Mailbox");
    String str8 = String.valueOf("type");
    String str9 = String.valueOf("Mailbox");
    String str10 = String.valueOf("_id");
    String str11 = String.valueOf("mailboxKey");
    paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 89 + String.valueOf(paramContext).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(str9).length() + String.valueOf(str10).length() + String.valueOf(str11).length() + str1 + paramContext + "' begin delete from " + str2 + " where new." + str3 + "=" + str4 + " and new." + str5 + "=" + str6 + " and (select " + str7 + "." + str8 + " from " + str9 + " where " + str10 + "=" + str11 + ")!=8; end");
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create trigger message_count_message_insert after insert on Message begin update Mailbox set messageCount=messageCount+1  where _id=NEW.mailboxKey; end");
    paramSQLiteDatabase.execSQL("create trigger message_count_message_delete after delete on Message begin update Mailbox set messageCount=messageCount-1  where _id=OLD.mailboxKey; end");
    paramSQLiteDatabase.execSQL("create trigger message_count_message_move after update of mailboxKey on Message begin update Mailbox set messageCount=messageCount-1  where _id=OLD.mailboxKey; update Mailbox set messageCount=messageCount+1 where _id=NEW.mailboxKey; end");
  }
  
  private static void a(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str1 = String.valueOf("UPDATE Message SET flagsEas=flagsEas|");
    String str2 = String.valueOf(Integer.toString(paramInt2));
    String str3 = String.valueOf("flags");
    paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + str2 + " WHERE (" + str3 + "&" + paramInt1 + ")!=0");
    str1 = String.valueOf("UPDATE Message SET flags=flags&~");
    str2 = String.valueOf(Integer.toString(paramInt1));
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      return;
    }
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase, Context paramContext)
  {
    b(paramSQLiteDatabase, paramContext);
  }
  
  static void a(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    cty.a(paramSQLiteDatabase, paramString, "messageKey");
    cty.a(paramSQLiteDatabase, paramString, "accountKey");
  }
  
  static void a(String paramString)
  {
    buo.a().a("DBHelper", paramString, "SQLException", 0L);
  }
  
  /* Error */
  private static boolean a(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_0
    //   4: aload_1
    //   5: iconst_1
    //   6: anewarray 16	java/lang/String
    //   9: dup
    //   10: iconst_0
    //   11: aload_2
    //   12: aastore
    //   13: aconst_null
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: ldc_w 511
    //   21: invokevirtual 514	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   24: astore_0
    //   25: aload_0
    //   26: ifnonnull +15 -> 41
    //   29: aload_0
    //   30: ifnull +9 -> 39
    //   33: aload_0
    //   34: invokeinterface 148 1 0
    //   39: iconst_0
    //   40: ireturn
    //   41: aload_0
    //   42: aload_2
    //   43: invokeinterface 518 2 0
    //   48: istore_3
    //   49: iload_3
    //   50: iconst_m1
    //   51: if_icmpeq +19 -> 70
    //   54: iconst_1
    //   55: istore 4
    //   57: aload_0
    //   58: ifnull +9 -> 67
    //   61: aload_0
    //   62: invokeinterface 148 1 0
    //   67: iload 4
    //   69: ireturn
    //   70: iconst_0
    //   71: istore 4
    //   73: goto -16 -> 57
    //   76: astore_0
    //   77: aconst_null
    //   78: astore_0
    //   79: aload_0
    //   80: ifnull -41 -> 39
    //   83: aload_0
    //   84: invokeinterface 148 1 0
    //   89: iconst_0
    //   90: ireturn
    //   91: astore_0
    //   92: aload 5
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +9 -> 105
    //   99: aload_1
    //   100: invokeinterface 148 1 0
    //   105: aload_0
    //   106: athrow
    //   107: astore_2
    //   108: aload_0
    //   109: astore_1
    //   110: aload_2
    //   111: astore_0
    //   112: goto -17 -> 95
    //   115: astore_1
    //   116: goto -37 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	119	1	paramString1	String
    //   0	119	2	paramString2	String
    //   48	4	3	i	int
    //   55	17	4	bool	boolean
    //   1	92	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	25	76	android/database/sqlite/SQLiteException
    //   3	25	91	finally
    //   41	49	107	finally
    //   41	49	115	android/database/sqlite/SQLiteException
  }
  
  static void aa(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN priority INTEGER DEFAULT 1;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN priority INTEGER DEFAULT 1;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(148), Integer.valueOf(149) });
      a("to_v149");
    }
  }
  
  static void ab(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN eventUid TEXT DEFAULT NULL");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN eventUid TEXT DEFAULT NULL");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(149), Integer.valueOf(150) });
      a("to_v150");
    }
  }
  
  static void ac(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN draftUpsyncTimestamp INTEGER DEFAULT 0");
      cty.a(paramSQLiteDatabase, "Message", "draftUpsyncTimestamp");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN draftUpsyncTimestamp INTEGER DEFAULT 0");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(150), Integer.valueOf(151) });
      a("to_v151");
    }
  }
  
  static void ad(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN eventSubject TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN meetingResponseComment TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN eventStartTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN eventEndTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN proposedStartTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN proposedEndTime LONG;");
      cty.a(paramSQLiteDatabase, "Message", "proposedStartTime");
      cty.a(paramSQLiteDatabase, "Message", "proposedEndTime");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN eventSubject TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN meetingResponseComment TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN eventStartTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN eventEndTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN proposedStartTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN proposedEndTime LONG;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(151), Integer.valueOf(152) });
      a("to_v152");
    }
  }
  
  static void ae(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Attachment ADD COLUMN fileReference TEXT");
      r(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(152), Integer.valueOf(153) });
      a("to_v153");
    }
  }
  
  static void af(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN eventRecurrenceRule TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN eventRecurrenceRule TEXT;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(153), Integer.valueOf(154) });
      a("to_v154");
    }
  }
  
  static void ag(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Account ADD COLUMN accountCreationHistory TEXT DEFAULT NULL");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(154), Integer.valueOf(155) });
      a("to_v155");
    }
  }
  
  static void ah(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("create table AccountDirtyFlags (_id integer primary key, signatureDirty integer not null default 0, syncLookbackDirty integer not null default 0);");
      paramSQLiteDatabase.execSQL("INSERT INTO AccountDirtyFlags(_id, signatureDirty, syncLookbackDirty) SELECT _id, 1 AS signatureDirty, 1 AS syncLookbackDirty FROM Account;");
      paramSQLiteDatabase.execSQL("DROP TRIGGER account_delete;");
      paramSQLiteDatabase.execSQL("create trigger account_delete before delete on Account begin delete from Mailbox where accountKey=old._id; delete from HostAuth where _id=old.hostAuthKeyRecv; delete from HostAuth where _id=old.hostAuthKeySend; delete from Policy where _id=old.policyKey; delete from AccountDirtyFlags where _id=old._id; end;");
      paramSQLiteDatabase.execSQL("create trigger account_insert after insert on Account begin insert or ignore into AccountDirtyFlags(_id) values (new._id); end;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(155), Integer.valueOf(156) });
      a("to_v156");
    }
  }
  
  static void ai(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE AccountDirtyFlags ADD COLUMN passwordDirty INTEGER DEFAULT 0;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(156), Integer.valueOf(157) });
      a("to_157");
    }
  }
  
  static void aj(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE app_indexing (_id INTEGER PRIMARY KEY NOT NULL, messageKey INTEGER DEFAULT 0, action INTEGER, type INTEGER)");
      cty.a(paramSQLiteDatabase, "app_indexing", "messageKey");
      paramSQLiteDatabase.execSQL("INSERT INTO app_indexing SELECT NULL, _id, 0, 0 FROM Message");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER message_app_indexing_insert AFTER INSERT ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, NEW._id, 0, 0); END");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER message_app_indexing_delete AFTER DELETE ON Message BEGIN UPDATE app_indexing SET action = 1 WHERE messageKey =  OLD._id; END");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(157), Integer.valueOf(158) });
      a("to_v158");
    }
  }
  
  static void ak(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      e(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(158), Integer.valueOf(159) });
      a("to_v159");
    }
  }
  
  static void al(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN proposeTimeFromMailRefMessageUri TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN proposeTimeFromMailRsvp INTEGER;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN proposeTimeFromMailProposedStartTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN proposeTimeFromMailProposedEndTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN proposeTimeFromMailRefMessageUri TEXT;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN proposeTimeFromMailRsvp INTEGER;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN proposeTimeFromMailProposedStartTime LONG;");
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN proposeTimeFromMailProposedEndTime LONG;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(159), Integer.valueOf(160) });
      a("to_160");
    }
  }
  
  static void am(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      chb.b(paramSQLiteDatabase);
      chb.a(paramSQLiteDatabase);
      cgd.a(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(162), Integer.valueOf(163) });
      a("to_163");
    }
  }
  
  static void an(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "app_indexing");
      paramSQLiteDatabase.execSQL("DROP TRIGGER message_app_indexing_insert");
      paramSQLiteDatabase.execSQL("DROP TRIGGER message_app_indexing_delete");
      String str = String.valueOf("app_indexing".toLowerCase(Locale.ENGLISH));
      paramSQLiteDatabase.execSQL(String.valueOf(str).length() + 22 + String.valueOf("messageKey").length() + "DROP INDEX IF EXISTS " + str + "_" + "messageKey");
      d(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(163), Integer.valueOf(164) });
      a("to_164");
    }
  }
  
  static void ao(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      if (!a(paramSQLiteDatabase, "Message", "syncBlocked")) {
        paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN syncBlocked INTEGER;");
      }
      if (!a(paramSQLiteDatabase, "Message_Deletes", "syncBlocked")) {
        paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN syncBlocked INTEGER;");
      }
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(164), Integer.valueOf(165) });
      a("to_165");
    }
  }
  
  static void ap(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      azz.a(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(165), Integer.valueOf(166) });
      a("to_166");
    }
  }
  
  static void aq(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("DROP TABLE Search");
      paramSQLiteDatabase.execSQL("CREATE TABLE Search (searchId TEXT, messageKey INTEGER NOT NULL UNIQUE)");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(166), Integer.valueOf(167) });
      a("to_167");
    }
  }
  
  static void ar(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Search ADD COLUMN mailboxKey INTEGER NOT NULL DEFAULT -1;");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(167), Integer.valueOf(168) });
      a("to_168");
    }
  }
  
  static void as(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message ADD COLUMN flagsEas INTEGER DEFAULT 0;");
      a(paramSQLiteDatabase, 8388608, 1);
      a(paramSQLiteDatabase, 16777216, 2);
      a(paramSQLiteDatabase, 33554432, 4);
      a(paramSQLiteDatabase, 67108864, 8);
      a(paramSQLiteDatabase, 134217728, 16);
      a(paramSQLiteDatabase, 268435456, 32);
      a(paramSQLiteDatabase, 536870912, 64);
      String str1 = String.valueOf("UPDATE Message SET flags=flags|");
      String str2 = String.valueOf(Integer.toString(8388608));
      String str3 = String.valueOf("flags");
      paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + str2 + " WHERE (" + str3 + "&1073741824" + ")!=0");
      str1 = String.valueOf("UPDATE Message SET flags=flags&~");
      str2 = String.valueOf(Integer.toString(1073741824));
      if (str2.length() != 0) {}
      for (str1 = str1.concat(str2);; str1 = new String(str1))
      {
        paramSQLiteDatabase.execSQL(str1);
        return;
      }
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(168), Integer.valueOf(169) });
      a("to_169");
    }
  }
  
  static void at(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("ALTER TABLE Message_Deletes ADD COLUMN flagsEas INTEGER DEFAULT 0;");
      b(paramSQLiteDatabase, 8388608, 1);
      b(paramSQLiteDatabase, 16777216, 2);
      b(paramSQLiteDatabase, 33554432, 4);
      b(paramSQLiteDatabase, 67108864, 8);
      b(paramSQLiteDatabase, 134217728, 16);
      b(paramSQLiteDatabase, 268435456, 32);
      b(paramSQLiteDatabase, 536870912, 64);
      String str1 = String.valueOf("UPDATE Message_Deletes SET flags=flags|");
      String str2 = String.valueOf(Integer.toString(8388608));
      String str3 = String.valueOf("flags");
      paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + str2 + " WHERE (" + str3 + "&1073741824" + ")!=0");
      str1 = String.valueOf("UPDATE Message_Deletes SET flags=flags&~");
      str2 = String.valueOf(Integer.toString(1073741824));
      if (str2.length() != 0) {}
      for (str1 = str1.concat(str2);; str1 = new String(str1))
      {
        paramSQLiteDatabase.execSQL(str1);
        return;
      }
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(170), Integer.valueOf(171) });
      a("to_171");
    }
  }
  
  static void au(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("update Mailbox set lastNotifiedMessageKey=0 where lastNotifiedMessageKey IS NULL");
      paramSQLiteDatabase.execSQL("update Mailbox set lastNotifiedMessageCount=0 where lastNotifiedMessageCount IS NULL");
    }
    catch (SQLException localSQLException2)
    {
      try
      {
        paramSQLiteDatabase.execSQL("update Attachment set uiState=3 where contentUri is not null;");
      }
      catch (SQLException localSQLException2)
      {
        try
        {
          for (;;)
          {
            paramSQLiteDatabase.execSQL("update Mailbox set lastTouchedTime = 2 WHERE type = 3");
            paramSQLiteDatabase.execSQL("update Mailbox set lastTouchedTime = 1 WHERE type = 5");
            try
            {
              paramSQLiteDatabase.execSQL("update Mailbox set flags=flags|64 where (flags&8)!=0 and accountKey IN (SELECT Account._id from Account,HostAuth where Account.hostAuthKeyRecv=HostAuth._id and protocol='eas')");
              return;
            }
            catch (SQLException paramSQLiteDatabase)
            {
              cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProvider.db from 35/36 to 37/100", new Object[0]);
              a("upgradeToEmail2_to_v37");
            }
            localSQLException1 = localSQLException1;
            cvm.d("EmailProvider", localSQLException1, "Exception upgrading EmailProvider.db from 31 to 32/100", new Object[0]);
            a("upgradeToEmail2_to_v32");
            continue;
            localSQLException2 = localSQLException2;
            cvm.d("EmailProvider", localSQLException2, "Exception upgrading EmailProvider.db from 32 to 33/100", new Object[0]);
            a("upgradeToEmail2_to_v33");
          }
        }
        catch (SQLException localSQLException3)
        {
          for (;;)
          {
            cvm.d("EmailProvider", localSQLException3, "Exception upgrading EmailProvider.db from 34 to 35/100", new Object[0]);
            a("upgradeToEmail2_to_v35");
          }
        }
      }
    }
  }
  
  private static void av(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("Message", beb.g, null, null, null, null, null);
    ContentValues localContentValues = new ContentValues(e.length);
    String[] arrayOfString = new String[1];
    try
    {
      while (localCursor.moveToNext())
      {
        int i = 0;
        while (i < e.length)
        {
          Address[] arrayOfAddress = Address.h(localCursor.getString(e[i]));
          localContentValues.put(f[i], Address.b(arrayOfAddress));
          i += 1;
        }
        arrayOfString[0] = localCursor.getString(0);
        paramSQLiteDatabase.update("Message", localContentValues, "_id=?", arrayOfString);
      }
    }
    finally
    {
      localCursor.close();
    }
  }
  
  static void b(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf(" (_id integer primary key autoincrement, syncServerId text, syncServerTimeStamp integer, ");
    String str2 = String.valueOf("displayName text, timeStamp integer, subject text, flagRead integer, flagLoaded integer, flagFavorite integer, flagAttachment integer, flags integer, clientId integer, messageId text, mailboxKey integer, accountKey integer, fromList text, toList text, ccList text, bccList text, replyToList text, meetingInfo text, eventUid text, snippet text, protocolSearchInfo text, threadTopic text, syncData text, flagSeen integer, mainMailboxKey integer, retryCount integer, nextRetryTime integer, inReplyTo text, mailReferences text, threadId integer, serverThreadId text, androidMessageId text, priority integer default 1, draftUpsyncTimestamp integer default 0, eventSubject text, meetingResponseComment text, eventStartTime long, eventEndTime long, proposedStartTime long, proposedEndTime long,eventRecurrenceRule text, proposeTimeFromMailRefMessageUri text, proposeTimeFromMailRsvp integer, proposeTimeFromMailProposedStartTime long, proposeTimeFromMailProposedEndTime long, syncBlocked integer, flagsEas integer default 0);");
    String str3;
    if (str2.length() != 0)
    {
      str2 = str1.concat(str2);
      str1 = String.valueOf(" (_id integer unique, syncServerId text, syncServerTimeStamp integer, ");
      str3 = String.valueOf("displayName text, timeStamp integer, subject text, flagRead integer, flagLoaded integer, flagFavorite integer, flagAttachment integer, flags integer, clientId integer, messageId text, mailboxKey integer, accountKey integer, fromList text, toList text, ccList text, bccList text, replyToList text, meetingInfo text, eventUid text, snippet text, protocolSearchInfo text, threadTopic text, syncData text, flagSeen integer, mainMailboxKey integer, retryCount integer, nextRetryTime integer, inReplyTo text, mailReferences text, threadId integer, serverThreadId text, androidMessageId text, priority integer default 1, draftUpsyncTimestamp integer default 0, eventSubject text, meetingResponseComment text, eventStartTime long, eventEndTime long, proposedStartTime long, proposedEndTime long,eventRecurrenceRule text, proposeTimeFromMailRefMessageUri text, proposeTimeFromMailRsvp integer, proposeTimeFromMailProposedStartTime long, proposeTimeFromMailProposedEndTime long, syncBlocked integer, flagsEas integer default 0);");
      if (str3.length() == 0) {
        break label233;
      }
      str1 = str1.concat(str3);
      label61:
      str3 = String.valueOf("create table Message");
      str2 = String.valueOf(str2);
      if (str2.length() == 0) {
        break label245;
      }
      str2 = str3.concat(str2);
      label93:
      paramSQLiteDatabase.execSQL(str2);
      str2 = String.valueOf("create table Message_Deletes");
      str1 = String.valueOf(str1);
      if (str1.length() == 0) {
        break label259;
      }
    }
    label233:
    label245:
    label259:
    for (str1 = str2.concat(str1);; str1 = new String(str2))
    {
      paramSQLiteDatabase.execSQL(str1);
      int i = 0;
      while (i < 10)
      {
        cty.a(paramSQLiteDatabase, "Message", new String[] { "timeStamp", "flagRead", "flagLoaded", "mailboxKey", "threadId", "messageId", "inReplyTo", "androidMessageId", "syncServerId", "draftUpsyncTimestamp" }[i]);
        i += 1;
      }
      str2 = new String(str1);
      break;
      str1 = new String(str1);
      break label61;
      str2 = new String(str3);
      break label93;
    }
    paramSQLiteDatabase.execSQL("create trigger message_delete before delete on Message begin delete from Attachment  where messageKey=old._id; end");
    paramSQLiteDatabase.execSQL("create trigger unread_message_insert before insert on Message when NEW.flagRead=0 begin update Mailbox set unreadCount=unreadCount+1  where _id=NEW.mailboxKey; end");
    paramSQLiteDatabase.execSQL("create trigger unread_message_delete before delete on Message when OLD.flagRead=0 begin update Mailbox set unreadCount=unreadCount-1  where _id=OLD.mailboxKey; end");
    paramSQLiteDatabase.execSQL("create trigger unread_message_move before update of mailboxKey on Message when OLD.flagRead=0 begin update Mailbox set unreadCount=unreadCount-1  where _id=OLD.mailboxKey; update Mailbox set unreadCount=unreadCount+1 where _id=NEW.mailboxKey; end");
    paramSQLiteDatabase.execSQL("create trigger unread_message_read before update of flagRead on Message when OLD.flagRead!=NEW.flagRead begin update Mailbox set unreadCount=unreadCount+ case OLD.flagRead when 0 then -1 else 1 end  where _id=OLD.mailboxKey; end");
    a(paramSQLiteDatabase);
    a(paramContext, paramSQLiteDatabase);
  }
  
  static void b(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table Credential");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, provider text,accessToken text,refreshToken text,expiration integer);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      paramSQLiteDatabase.execSQL("create trigger host_auth_delete after delete on HostAuth begin delete from Credential where _id=old.credentialKey and (select count(*) from HostAuth where credentialKey=old.credentialKey)=0; end");
      return;
    }
  }
  
  private static void b(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    String str1 = String.valueOf("UPDATE Message_Deletes SET flagsEas=flagsEas|");
    String str2 = String.valueOf(Integer.toString(paramInt2));
    String str3 = String.valueOf("flags");
    paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 24 + String.valueOf(str2).length() + String.valueOf(str3).length() + str1 + str2 + " WHERE (" + str3 + "&" + paramInt1 + ")!=0");
    str1 = String.valueOf("UPDATE Message_Deletes SET flags=flags&~");
    str2 = String.valueOf(Integer.toString(paramInt1));
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      return;
    }
  }
  
  /* Error */
  static void b(SQLiteDatabase paramSQLiteDatabase, Context paramContext)
  {
    // Byte code:
    //   0: new 826	hen
    //   3: dup
    //   4: invokespecial 827	hen:<init>	()V
    //   7: ldc_w 829
    //   10: aload_1
    //   11: getstatic 832	arh:k	I
    //   14: invokevirtual 431	android/content/Context:getString	(I)Ljava/lang/String;
    //   17: invokevirtual 835	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   20: ldc -127
    //   22: aload_1
    //   23: getstatic 838	arh:j	I
    //   26: invokevirtual 431	android/content/Context:getString	(I)Ljava/lang/String;
    //   29: invokevirtual 835	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   32: ldc_w 840
    //   35: aload_1
    //   36: getstatic 843	arh:i	I
    //   39: invokevirtual 431	android/content/Context:getString	(I)Ljava/lang/String;
    //   42: invokevirtual 835	hen:b	(Ljava/lang/Object;Ljava/lang/Object;)Lhen;
    //   45: invokevirtual 846	hen:b	()Lhel;
    //   48: astore 6
    //   50: aload_0
    //   51: ldc 101
    //   53: getstatic 22	aym:a	[Ljava/lang/String;
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: aconst_null
    //   61: invokevirtual 105	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   64: astore 4
    //   66: iconst_1
    //   67: anewarray 16	java/lang/String
    //   70: astore 7
    //   72: aload 4
    //   74: invokeinterface 116 1 0
    //   79: ifeq +415 -> 494
    //   82: aload 7
    //   84: iconst_0
    //   85: aload 4
    //   87: iconst_0
    //   88: invokeinterface 120 2 0
    //   93: aastore
    //   94: aload_0
    //   95: ldc 122
    //   97: getstatic 28	aym:b	[Ljava/lang/String;
    //   100: ldc 124
    //   102: aload 7
    //   104: aconst_null
    //   105: aconst_null
    //   106: aconst_null
    //   107: invokevirtual 105	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   110: astore 5
    //   112: aload 5
    //   114: invokeinterface 127 1 0
    //   119: ifeq +250 -> 369
    //   122: aload 5
    //   124: iconst_0
    //   125: invokeinterface 120 2 0
    //   130: astore 9
    //   132: ldc -127
    //   134: aload 9
    //   136: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   139: ifne +14 -> 153
    //   142: ldc_w 829
    //   145: aload 9
    //   147: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   150: ifeq +273 -> 423
    //   153: ldc 65
    //   155: ldc_w 848
    //   158: iconst_2
    //   159: anewarray 4	java/lang/Object
    //   162: dup
    //   163: iconst_0
    //   164: aload 9
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: aload 4
    //   171: iconst_1
    //   172: invokeinterface 120 2 0
    //   177: aastore
    //   178: invokestatic 851	cvm:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   181: pop
    //   182: aload 4
    //   184: iconst_1
    //   185: invokeinterface 120 2 0
    //   190: astore 8
    //   192: aload 6
    //   194: aload 9
    //   196: invokeinterface 857 2 0
    //   201: checkcast 16	java/lang/String
    //   204: astore 11
    //   206: aload 5
    //   208: iconst_1
    //   209: invokeinterface 120 2 0
    //   214: astore 9
    //   216: aload_1
    //   217: invokestatic 862	android/accounts/AccountManager:get	(Landroid/content/Context;)Landroid/accounts/AccountManager;
    //   220: astore 10
    //   222: aload 10
    //   224: aload 11
    //   226: invokevirtual 866	android/accounts/AccountManager:getAccountsByType	(Ljava/lang/String;)[Landroid/accounts/Account;
    //   229: astore 12
    //   231: aload 12
    //   233: ifnull +185 -> 418
    //   236: aload 12
    //   238: arraylength
    //   239: istore_3
    //   240: iconst_0
    //   241: istore_2
    //   242: iload_2
    //   243: iload_3
    //   244: if_icmpge +174 -> 418
    //   247: aload 12
    //   249: iload_2
    //   250: aaload
    //   251: astore 13
    //   253: aload 13
    //   255: getfield 872	android/accounts/Account:name	Ljava/lang/String;
    //   258: aload 8
    //   260: invokestatic 877	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   263: ifeq +148 -> 411
    //   266: aload 13
    //   268: getfield 879	android/accounts/Account:type	Ljava/lang/String;
    //   271: aload 11
    //   273: invokestatic 877	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   276: ifeq +135 -> 411
    //   279: iconst_1
    //   280: istore_2
    //   281: iload_2
    //   282: ifne +87 -> 369
    //   285: ldc_w 881
    //   288: ldc_w 883
    //   291: iconst_2
    //   292: anewarray 4	java/lang/Object
    //   295: dup
    //   296: iconst_0
    //   297: aload 8
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: aload 11
    //   304: aastore
    //   305: invokestatic 885	cvm:a	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   308: pop
    //   309: new 868	android/accounts/Account
    //   312: dup
    //   313: aload 8
    //   315: aload 11
    //   317: invokespecial 887	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   320: astore 8
    //   322: aload 10
    //   324: aload 8
    //   326: aload 9
    //   328: aconst_null
    //   329: invokevirtual 891	android/accounts/AccountManager:addAccountExplicitly	(Landroid/accounts/Account;Ljava/lang/String;Landroid/os/Bundle;)Z
    //   332: pop
    //   333: aload 8
    //   335: getstatic 895	bdv:F	Ljava/lang/String;
    //   338: iconst_1
    //   339: invokestatic 901	android/content/ContentResolver:setIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;I)V
    //   342: aload 8
    //   344: getstatic 895	bdv:F	Ljava/lang/String;
    //   347: iconst_1
    //   348: invokestatic 905	android/content/ContentResolver:setSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;Z)V
    //   351: aload 8
    //   353: ldc_w 907
    //   356: iconst_0
    //   357: invokestatic 901	android/content/ContentResolver:setIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;I)V
    //   360: aload 8
    //   362: ldc_w 909
    //   365: iconst_0
    //   366: invokestatic 901	android/content/ContentResolver:setIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;I)V
    //   369: aload 5
    //   371: invokeinterface 148 1 0
    //   376: goto -304 -> 72
    //   379: astore_0
    //   380: aload 4
    //   382: invokeinterface 148 1 0
    //   387: aload_0
    //   388: athrow
    //   389: astore_0
    //   390: ldc 65
    //   392: aload_0
    //   393: ldc_w 911
    //   396: iconst_0
    //   397: anewarray 4	java/lang/Object
    //   400: invokestatic 78	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   403: pop
    //   404: ldc_w 913
    //   407: invokestatic 82	aym:a	(Ljava/lang/String;)V
    //   410: return
    //   411: iload_2
    //   412: iconst_1
    //   413: iadd
    //   414: istore_2
    //   415: goto -173 -> 242
    //   418: iconst_0
    //   419: istore_2
    //   420: goto -139 -> 281
    //   423: ldc_w 840
    //   426: aload 9
    //   428: invokevirtual 133	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   431: ifeq -62 -> 369
    //   434: new 868	android/accounts/Account
    //   437: dup
    //   438: aload 4
    //   440: iconst_1
    //   441: invokeinterface 120 2 0
    //   446: aload 6
    //   448: aload 9
    //   450: invokeinterface 857 2 0
    //   455: checkcast 16	java/lang/String
    //   458: invokespecial 887	android/accounts/Account:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: astore 8
    //   463: aload 8
    //   465: getstatic 895	bdv:F	Ljava/lang/String;
    //   468: iconst_1
    //   469: invokestatic 901	android/content/ContentResolver:setIsSyncable	(Landroid/accounts/Account;Ljava/lang/String;I)V
    //   472: aload 8
    //   474: getstatic 895	bdv:F	Ljava/lang/String;
    //   477: iconst_1
    //   478: invokestatic 905	android/content/ContentResolver:setSyncAutomatically	(Landroid/accounts/Account;Ljava/lang/String;Z)V
    //   481: goto -112 -> 369
    //   484: astore_0
    //   485: aload 5
    //   487: invokeinterface 148 1 0
    //   492: aload_0
    //   493: athrow
    //   494: aload 4
    //   496: invokeinterface 148 1 0
    //   501: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	502	0	paramSQLiteDatabase	SQLiteDatabase
    //   0	502	1	paramContext	Context
    //   241	179	2	i	int
    //   239	6	3	j	int
    //   64	431	4	localCursor1	Cursor
    //   110	376	5	localCursor2	Cursor
    //   48	399	6	localhel	hel
    //   70	33	7	arrayOfString	String[]
    //   190	283	8	localObject	Object
    //   130	319	9	str1	String
    //   220	103	10	localAccountManager	android.accounts.AccountManager
    //   204	112	11	str2	String
    //   229	19	12	arrayOfAccount	android.accounts.Account[]
    //   251	16	13	localAccount	android.accounts.Account
    // Exception table:
    //   from	to	target	type
    //   66	72	379	finally
    //   72	112	379	finally
    //   369	376	379	finally
    //   485	494	379	finally
    //   50	66	389	android/database/SQLException
    //   380	389	389	android/database/SQLException
    //   494	501	389	android/database/SQLException
    //   112	153	484	finally
    //   153	231	484	finally
    //   236	240	484	finally
    //   253	279	484	finally
    //   285	369	484	finally
    //   423	481	484	finally
  }
  
  static void b(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    String str1 = String.valueOf("Message");
    String str2 = String.valueOf("messageKey");
    String str3 = String.valueOf("_id");
    paramSQLiteDatabase.execSQL(String.valueOf(paramString).length() + 97 + String.valueOf(str1).length() + String.valueOf(paramString).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "create trigger " + paramString + "_delete_message before delete on " + str1 + " for each row begin delete from " + paramString + " where " + str2 + "=old." + str3 + "; end");
    str1 = String.valueOf("Account");
    str2 = String.valueOf("accountKey");
    str3 = String.valueOf("_id");
    paramSQLiteDatabase.execSQL(String.valueOf(paramString).length() + 97 + String.valueOf(str1).length() + String.valueOf(paramString).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "create trigger " + paramString + "_delete_account before delete on " + str1 + " for each row begin delete from " + paramString + " where " + str2 + "=old." + str3 + "; end");
  }
  
  static void c(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "Message");
      cty.a(paramSQLiteDatabase, "Message_Updates");
      cty.a(paramSQLiteDatabase, "Message_Deletes");
      b(paramContext, paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        a("reset_message");
      }
    }
  }
  
  static void c(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS ExchangeOofSettings");
    paramSQLiteDatabase.execSQL("CREATE TABLE ExchangeOofSettings (email TEXT PRIMARY KEY, num_attempts_to_upload INTEGER, eas_oof_state INTEGER, eas_oof_start INTEGER, eas_oof_end INTEGER, is_dirty INTEGER, eas_oof_internal_enabled INTEGER, eas_oof_internal_message TEXT, eas_oof_internal_message_type INTEGER, eas_oof_external_known_enabled INTEGER, eas_oof_external_known_message TEXT, eas_oof_external_known_message_type INTEGER, eas_oof_external_unknown_enabled INTEGER, eas_oof_external_unknown_message TEXT, eas_oof_external_unknown_message_type INTEGER)");
  }
  
  /* Error */
  static void d(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc_w 941
    //   4: iconst_1
    //   5: anewarray 16	java/lang/String
    //   8: dup
    //   9: iconst_0
    //   10: ldc_w 492
    //   13: aastore
    //   14: aconst_null
    //   15: aconst_null
    //   16: aconst_null
    //   17: aconst_null
    //   18: aconst_null
    //   19: invokevirtual 105	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   22: astore 4
    //   24: aload 4
    //   26: ifnonnull +36 -> 62
    //   29: new 943	java/lang/IllegalStateException
    //   32: dup
    //   33: ldc_w 945
    //   36: invokespecial 946	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
    //   39: athrow
    //   40: astore_0
    //   41: ldc 65
    //   43: aload_0
    //   44: ldc_w 948
    //   47: iconst_0
    //   48: anewarray 4	java/lang/Object
    //   51: invokestatic 78	cvm:d	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   54: pop
    //   55: ldc_w 950
    //   58: invokestatic 82	aym:a	(Ljava/lang/String;)V
    //   61: return
    //   62: aload_1
    //   63: ldc_w 952
    //   66: invokevirtual 956	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   69: astore 5
    //   71: aload_1
    //   72: ldc_w 958
    //   75: invokevirtual 956	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   78: astore 6
    //   80: aload 4
    //   82: invokeinterface 116 1 0
    //   87: ifeq +201 -> 288
    //   90: aload 4
    //   92: iconst_0
    //   93: invokeinterface 962 2 0
    //   98: lstore_2
    //   99: aload 5
    //   101: iconst_1
    //   102: lload_2
    //   103: invokevirtual 968	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   106: aload 5
    //   108: invokevirtual 971	android/database/sqlite/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   111: astore 8
    //   113: aload 8
    //   115: invokestatic 975	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   118: ifne +32 -> 150
    //   121: new 977	java/io/FileWriter
    //   124: dup
    //   125: aload_0
    //   126: lload_2
    //   127: ldc_w 979
    //   130: invokestatic 984	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;JLjava/lang/String;)Ljava/io/File;
    //   133: invokespecial 987	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   136: astore 7
    //   138: aload 7
    //   140: aload 8
    //   142: invokevirtual 990	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   145: aload 7
    //   147: invokevirtual 991	java/io/FileWriter:close	()V
    //   150: aload 6
    //   152: iconst_1
    //   153: lload_2
    //   154: invokevirtual 968	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   157: aload 6
    //   159: invokevirtual 971	android/database/sqlite/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   162: astore 8
    //   164: aload 8
    //   166: invokestatic 975	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   169: ifne -89 -> 80
    //   172: new 977	java/io/FileWriter
    //   175: dup
    //   176: aload_0
    //   177: lload_2
    //   178: ldc_w 993
    //   181: invokestatic 984	com/android/email/provider/EmailProvider:a	(Landroid/content/Context;JLjava/lang/String;)Ljava/io/File;
    //   184: invokespecial 987	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   187: astore 7
    //   189: aload 7
    //   191: aload 8
    //   193: invokevirtual 990	java/io/FileWriter:write	(Ljava/lang/String;)V
    //   196: aload 7
    //   198: invokevirtual 991	java/io/FileWriter:close	()V
    //   201: goto -121 -> 80
    //   204: astore 7
    //   206: getstatic 995	cvm:a	Ljava/lang/String;
    //   209: aload 7
    //   211: ldc_w 997
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 999	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   221: pop
    //   222: ldc_w 950
    //   225: invokestatic 82	aym:a	(Ljava/lang/String;)V
    //   228: goto -148 -> 80
    //   231: astore_0
    //   232: new 1001	java/lang/RuntimeException
    //   235: dup
    //   236: aload_0
    //   237: invokespecial 1004	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   240: athrow
    //   241: astore 8
    //   243: aload 7
    //   245: invokevirtual 991	java/io/FileWriter:close	()V
    //   248: aload 8
    //   250: athrow
    //   251: astore 7
    //   253: getstatic 995	cvm:a	Ljava/lang/String;
    //   256: aload 7
    //   258: ldc_w 1006
    //   261: iconst_0
    //   262: anewarray 4	java/lang/Object
    //   265: invokestatic 999	cvm:a	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)I
    //   268: pop
    //   269: ldc_w 950
    //   272: invokestatic 82	aym:a	(Ljava/lang/String;)V
    //   275: goto -125 -> 150
    //   278: astore 8
    //   280: aload 7
    //   282: invokevirtual 991	java/io/FileWriter:close	()V
    //   285: aload 8
    //   287: athrow
    //   288: aload_1
    //   289: ldc_w 1008
    //   292: invokevirtual 63	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   295: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	296	0	paramContext	Context
    //   0	296	1	paramSQLiteDatabase	SQLiteDatabase
    //   98	80	2	l	long
    //   22	69	4	localCursor	Cursor
    //   69	38	5	localSQLiteStatement1	android.database.sqlite.SQLiteStatement
    //   78	80	6	localSQLiteStatement2	android.database.sqlite.SQLiteStatement
    //   136	61	7	localFileWriter	java.io.FileWriter
    //   204	40	7	localSQLiteDoneException1	android.database.sqlite.SQLiteDoneException
    //   251	30	7	localSQLiteDoneException2	android.database.sqlite.SQLiteDoneException
    //   111	81	8	str	String
    //   241	8	8	localObject1	Object
    //   278	8	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   0	24	40	android/database/SQLException
    //   29	40	40	android/database/SQLException
    //   62	80	40	android/database/SQLException
    //   80	106	40	android/database/SQLException
    //   106	138	40	android/database/SQLException
    //   145	150	40	android/database/SQLException
    //   150	157	40	android/database/SQLException
    //   157	189	40	android/database/SQLException
    //   196	201	40	android/database/SQLException
    //   206	228	40	android/database/SQLException
    //   243	251	40	android/database/SQLException
    //   253	275	40	android/database/SQLException
    //   280	288	40	android/database/SQLException
    //   288	295	40	android/database/SQLException
    //   157	189	204	android/database/sqlite/SQLiteDoneException
    //   196	201	204	android/database/sqlite/SQLiteDoneException
    //   280	288	204	android/database/sqlite/SQLiteDoneException
    //   0	24	231	java/io/IOException
    //   29	40	231	java/io/IOException
    //   62	80	231	java/io/IOException
    //   80	106	231	java/io/IOException
    //   106	138	231	java/io/IOException
    //   145	150	231	java/io/IOException
    //   150	157	231	java/io/IOException
    //   157	189	231	java/io/IOException
    //   196	201	231	java/io/IOException
    //   206	228	231	java/io/IOException
    //   243	251	231	java/io/IOException
    //   253	275	231	java/io/IOException
    //   280	288	231	java/io/IOException
    //   288	295	231	java/io/IOException
    //   138	145	241	finally
    //   106	138	251	android/database/sqlite/SQLiteDoneException
    //   145	150	251	android/database/sqlite/SQLiteDoneException
    //   243	251	251	android/database/sqlite/SQLiteDoneException
    //   189	196	278	finally
  }
  
  static void d(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE app_indexing (_id INTEGER PRIMARY KEY NOT NULL, messageKey INTEGER DEFAULT 0, action INTEGER, type INTEGER, accountKey INTEGER, mailboxKey INTEGER)");
    cty.a(paramSQLiteDatabase, "app_indexing", "messageKey");
    cty.a(paramSQLiteDatabase, "app_indexing", "accountKey");
    paramSQLiteDatabase.execSQL("INSERT INTO app_indexing SELECT NULL, _id, 0, 0, accountKey, mailboxKey FROM Message");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_app_indexing_insert_document AFTER INSERT ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, NEW._id, 0, 0, NEW.accountKey, NEW.mailboxKey); END");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_app_indexing_insert_tag AFTER INSERT ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, NEW._id, 0, 1, NEW.accountKey, NEW.mailboxKey); END");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_app_indexing_delete_document AFTER DELETE ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, OLD._id, 1, 0, OLD.accountKey, OLD.mailboxKey); END");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_app_indexing_delete_tag AFTER DELETE ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, OLD._id, 1, 1, OLD.accountKey, OLD.mailboxKey); END");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_moved_app_indexing_insert_tag AFTER UPDATE OF mailboxKey ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, NEW._id, 0, 1, NEW.accountKey, NEW.mailboxKey); END");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_moved_app_indexing_delete_tag AFTER UPDATE OF mailboxKey ON Message BEGIN INSERT INTO app_indexing VALUES (NULL, OLD._id, 1, 1, OLD.accountKey, OLD.mailboxKey); END");
  }
  
  static void e(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      String str1 = String.valueOf("UPDATE Account SET flags=flags|");
      String str2 = String.valueOf(Long.toString(6272L));
      String str3 = String.valueOf("_id");
      String str4 = String.valueOf("_id");
      String str5 = String.valueOf("Account");
      String str6 = String.valueOf("HostAuth");
      String str7 = String.valueOf("hostAuthKeyRecv");
      String str8 = String.valueOf("protocol");
      paramContext = String.valueOf(paramContext.getString(arh.ck));
      String str9 = String.valueOf("protocolVersion");
      paramSQLiteDatabase.execSQL(String.valueOf(str1).length() + 102 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length() + String.valueOf(str5).length() + String.valueOf(str6).length() + String.valueOf(str7).length() + String.valueOf(str8).length() + String.valueOf(paramContext).length() + String.valueOf(str9).length() + str1 + str2 + " WHERE " + str3 + " IN (SELECT t1." + str4 + " FROM " + str5 + " t1 INNER JOIN " + str6 + " t2 ON t1." + str7 + "=t2._id WHERE t2." + str8 + "='" + paramContext + "' AND CAST(t1." + str9 + " AS REAL)>=12.0)");
      return;
    }
    catch (SQLException paramContext)
    {
      cvm.d("EmailProvider", paramContext, "Exception upgrading EmailProvider.db from %d to %d", new Object[] { Integer.valueOf(126), Integer.valueOf(127) });
      a("to_v127");
    }
  }
  
  static void e(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("CREATE TABLE Search (searchId TEXT, messageKey INTEGER NOT NULL UNIQUE, mailboxKey INTEGER NOT NULL DEFAULT -1)");
    paramSQLiteDatabase.execSQL("CREATE TRIGGER message_search_delete AFTER DELETE ON Message BEGIN DELETE FROM Search WHERE messageKey= OLD._id; END");
  }
  
  static void f(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("drop trigger message_delete_duplicates_on_insert");
  }
  
  static void g(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table MessageMove (_id integer primary key autoincrement, messageKey integer, messageServerId text, accountKey integer, status integer, srcFolderKey integer, dstFolderKey integer, srcFolderServerId text, dstFolderServerId text);");
    a(paramSQLiteDatabase, "MessageMove");
    b(paramSQLiteDatabase, "MessageMove");
  }
  
  static void h(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table MessageStateChange (_id integer primary key autoincrement, messageKey integer, messageServerId text, accountKey integer, status integer, oldFlagRead integer, newFlagRead integer, oldFlagFavorite integer, newFlagFavorite integer,oldFlagAnswered integer, newFlagAnswered integer, oldFlagForwarded integer, newFlagForwarded integer);");
    a(paramSQLiteDatabase, "MessageStateChange");
    b(paramSQLiteDatabase, "MessageStateChange");
  }
  
  static void i(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table Account");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, displayName text, emailAddress text, syncKey text, syncLookback integer, syncInterval text, hostAuthKeyRecv integer, hostAuthKeySend integer, flags integer, isDefault integer, compatibilityUuid text, senderName text, ringtoneUri text, protocolVersion text, newMessageCount integer, securityFlags integer, securitySyncKey text, signature text, policyKey integer, maxAttachmentSize integer, pingDuration integer, sendingCapabilities integer, accountCreationHistory text default null);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      paramSQLiteDatabase.execSQL("create trigger account_delete before delete on Account begin delete from Mailbox where accountKey=old._id; delete from HostAuth where _id=old.hostAuthKeyRecv; delete from HostAuth where _id=old.hostAuthKeySend; delete from Policy where _id=old.policyKey; delete from AccountDirtyFlags where _id=old._id; end;");
      paramSQLiteDatabase.execSQL("create trigger account_insert after insert on Account begin insert or ignore into AccountDirtyFlags(_id) values (new._id); end;");
      return;
    }
  }
  
  static void j(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "Account");
      i(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        a("reset_account");
      }
    }
  }
  
  static void k(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("create table AccountDirtyFlags (_id integer primary key, signatureDirty integer not null default 0, syncLookbackDirty integer not null default 0, passwordDirty integer not null default 0);");
  }
  
  static void l(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table Policy");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, passwordMode integer, passwordMinLength integer, passwordExpirationDays integer, passwordHistory integer, passwordComplexChars integer, passwordMaxFails integer, maxScreenLockTime integer, requireRemoteWipe integer, requireEncryption integer, requireEncryptionExternal integer, requireManualSyncRoaming integer, dontAllowCamera integer, dontAllowAttachments integer, dontAllowHtml integer, maxAttachmentSize integer, maxTextTruncationSize integer, maxHTMLTruncationSize integer, maxEmailLookback integer, maxCalendarLookback integer, passwordRecoveryEnabled integer, protocolPoliciesEnforced text, protocolPoliciesUnsupported text);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      return;
    }
  }
  
  static void m(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table HostAuth");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, protocol text, address text, port integer, flags integer, login text, password text, domain text, accountKey integer,certAlias text,serverCert blob,credentialKey integer);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      return;
    }
  }
  
  static void n(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "HostAuth");
      m(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        a("reset_host");
      }
    }
  }
  
  static void o(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table Mailbox");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, displayName text, serverId text, parentServerId text, parentKey integer, accountKey integer, type integer, delimiter integer, syncKey text, syncLookback integer, syncInterval integer, syncTime integer, unreadCount integer, flagVisible integer, flags integer, visibleLimit integer, syncStatus text, messageCount integer not null default 0, lastTouchedTime integer default 0, uiSyncStatus integer default 0, uiLastSyncResult integer default 0, lastNotifiedMessageKey integer not null default 0, lastNotifiedMessageCount integer not null default 0, totalCount integer, hierarchicalName text, lastFullSyncTime integer, localOnly integer default 0, previousName text default null, isDeleted integer default 0);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      paramSQLiteDatabase.execSQL("create index mailbox_serverId on Mailbox (serverId)");
      paramSQLiteDatabase.execSQL("create index mailbox_accountKey on Mailbox (accountKey)");
      paramSQLiteDatabase.execSQL("create trigger mailbox_delete before delete on Mailbox begin delete from Message  where mailboxKey=old._id; delete from Message_Deletes  where mailboxKey=old._id; end");
      return;
    }
  }
  
  static void p(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "Mailbox");
      o(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        a("reset_mailbox");
      }
    }
  }
  
  static void q(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table Attachment");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, fileName text, mimeType text, size integer, contentId text, contentUri text, messageKey integer, location text, encoding text, content text, flags integer, content_bytes blob, accountKey integer, uiState integer, uiDestination integer, uiDownloadedSize integer, cachedFile text, fileReference text);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      cty.a(paramSQLiteDatabase, "Attachment", "messageKey");
      return;
    }
  }
  
  static void r(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("CREATE TABLE AttachmentDelete");
    String str2 = String.valueOf(" (_id INTEGER PRIMARY KEY AUTOINCREMENT, messageKey INTEGER, fileReference TEXT);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      cty.a(paramSQLiteDatabase, "AttachmentDelete", "messageKey");
      cty.a(paramSQLiteDatabase, "AttachmentDelete", "fileReference");
      paramSQLiteDatabase.execSQL("CREATE TRIGGER mark_attachment_pending_delete AFTER DELETE ON Attachment WHEN OLD.fileReference NOTNULL BEGIN INSERT INTO AttachmentDelete (messageKey, fileReference) VALUES (OLD.messageKey, OLD.fileReference); END;");
      return;
    }
  }
  
  static void s(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "Attachment");
      q(paramSQLiteDatabase);
      return;
    }
    catch (SQLException localSQLException)
    {
      for (;;)
      {
        a("reset_attachment");
      }
    }
  }
  
  static void t(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table QuickResponse");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, quickResponse text, accountKey integer);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      return;
    }
  }
  
  static void u(SQLiteDatabase paramSQLiteDatabase)
  {
    String str1 = String.valueOf("create table Body");
    String str2 = String.valueOf(" (_id integer primary key autoincrement, messageKey integer, htmlContent text, textContent text, htmlReply text, textReply text, sourceMessageKey text, introText text, quotedTextStartPos integer);");
    if (str2.length() != 0) {}
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramSQLiteDatabase.execSQL(str1);
      cty.a(paramSQLiteDatabase, "Body", "messageKey");
      return;
    }
  }
  
  static void v(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      cty.a(paramSQLiteDatabase, "Body");
      u(paramSQLiteDatabase);
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProviderBody.db from <v5", new Object[0]);
      a("to_v5");
    }
  }
  
  static void w(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("alter table Body add introText text");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProviderBody.db from v5 to v6", new Object[0]);
      a("to_v6");
    }
  }
  
  static void x(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("alter table Body add quotedTextStartPos integer");
      return;
    }
    catch (SQLException paramSQLiteDatabase)
    {
      cvm.d("EmailProvider", paramSQLiteDatabase, "Exception upgrading EmailProviderBody.db from v6 to v8", new Object[0]);
      a("to_v8");
    }
  }
  
  static void y(SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL("update Mailbox set messageCount= (select count(*) from Message where mailboxKey = Mailbox._id)");
  }
  
  static void z(SQLiteDatabase paramSQLiteDatabase)
  {
    Cursor localCursor = paramSQLiteDatabase.query("Account", new String[] { "_id", "securityFlags" }, "securityFlags>0", null, null, null, null);
    for (;;)
    {
      try
      {
        ContentValues localContentValues = new ContentValues();
        String[] arrayOfString = new String[1];
        if (!localCursor.moveToNext()) {
          break;
        }
        long l = localCursor.getLong(1);
        Policy localPolicy = new Policy();
        b = ((int)(0x1E0 & l) >> 5);
        c = ((int)((0x1F & l) >> 0));
        d = ((int)((0x3E00 & l) >> 9));
        g = ((int)((0x1F00000000000 & l) >> 44));
        f = ((int)((0xFF000000000 & l) >> 36));
        e = ((int)((0xFFC000000 & l) >> 26));
        h = ((int)((0x1FFC000 & l) >> 14));
        if (0L != (0x2000000 & l))
        {
          bool = true;
          i = bool;
          if (0L == (0x2000000000000 & l)) {
            break label301;
          }
          bool = true;
          j = bool;
          if (0L == (l & 0x4000000000000)) {
            break label306;
          }
          bool = true;
          k = bool;
          localContentValues.put("policyKey", Long.valueOf(paramSQLiteDatabase.insert("Policy", null, localPolicy.e())));
          localContentValues.putNull("securityFlags");
          arrayOfString[0] = Long.toString(localCursor.getLong(0));
          paramSQLiteDatabase.update("Account", localContentValues, "_id=?", arrayOfString);
          continue;
        }
        bool = false;
      }
      finally
      {
        localCursor.close();
      }
      continue;
      label301:
      boolean bool = false;
      continue;
      label306:
      bool = false;
    }
    localCursor.close();
  }
}

/* Location:
 * Qualified Name:     aym
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */