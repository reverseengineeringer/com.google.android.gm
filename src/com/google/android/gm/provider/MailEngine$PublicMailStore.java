package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteStatement;
import android.net.Uri;
import android.text.TextUtils;
import android.util.TimingLogger;
import com.google.android.common.base.Strings;
import com.google.android.gsf.Gservices;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MailEngine$PublicMailStore
  implements MailStore
{
  MailEngine$PublicMailStore(MailEngine paramMailEngine) {}
  
  private long getMaxMessageIdForConversation(long paramLong)
  {
    SQLiteStatement localSQLiteStatement = this$0.mDb.compileStatement("SELECT MAX(messageId) FROM messages WHERE conversation = ? and queryId = 0 and clientCreated = 0");
    try
    {
      localSQLiteStatement.bindLong(1, paramLong);
      paramLong = localSQLiteStatement.simpleQueryForLong();
      localSQLiteStatement.close();
      return paramLong;
    }
    catch (SQLiteDoneException localSQLiteDoneException)
    {
      localSQLiteDoneException = localSQLiteDoneException;
      localSQLiteStatement.close();
      return 0L;
    }
    finally
    {
      localObject = finally;
      localSQLiteStatement.close();
      throw ((Throwable)localObject);
    }
  }
  
  /* Error */
  public void addOrUpdateMessage(MailSync.Message paramMessage, long paramLong)
  {
    // Byte code:
    //   0: ldc 52
    //   2: ldc 54
    //   4: iconst_1
    //   5: anewarray 4	java/lang/Object
    //   8: dup
    //   9: iconst_0
    //   10: aload_1
    //   11: aastore
    //   12: invokestatic 60	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   15: pop
    //   16: aload_0
    //   17: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   20: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   23: aload_0
    //   24: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   27: invokestatic 68	com/google/android/gm/provider/MailEngine:access$500	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    //   30: invokevirtual 74	com/google/android/gm/provider/TransactionHelper:beginTransactionWithListenerNonExclusive	(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    //   33: aload_0
    //   34: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   37: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   40: ldc 76
    //   42: iconst_4
    //   43: anewarray 78	java/lang/String
    //   46: dup
    //   47: iconst_0
    //   48: aload_1
    //   49: getfield 84	com/google/android/gm/provider/MailSync$Message:messageId	J
    //   52: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   55: aastore
    //   56: dup
    //   57: iconst_1
    //   58: ldc 92
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: ldc 94
    //   65: aastore
    //   66: dup
    //   67: iconst_3
    //   68: aload_1
    //   69: getfield 97	com/google/android/gm/provider/MailSync$Message:conversationId	J
    //   72: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   75: aastore
    //   76: invokestatic 103	android/database/DatabaseUtils:longForQuery	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   79: lconst_0
    //   80: lcmp
    //   81: ifne +65 -> 146
    //   84: aload_0
    //   85: aload_1
    //   86: lconst_0
    //   87: lload_2
    //   88: getstatic 109	com/google/android/gm/provider/MailEngine$ClientCreated:SERVER_CREATED	Lcom/google/android/gm/provider/MailEngine$ClientCreated;
    //   91: invokevirtual 113	com/google/android/gm/provider/MailEngine$PublicMailStore:addOrUpdateMessageNoNotifyWithoutWritingOperations	(Lcom/google/android/gm/provider/MailSync$Message;JJLcom/google/android/gm/provider/MailEngine$ClientCreated;)V
    //   94: aload_1
    //   95: getfield 84	com/google/android/gm/provider/MailSync$Message:messageId	J
    //   98: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   101: astore_1
    //   102: aload_0
    //   103: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   106: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   109: ldc 115
    //   111: ldc 117
    //   113: iconst_1
    //   114: anewarray 78	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: aload_1
    //   120: aastore
    //   121: invokevirtual 121	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   124: pop
    //   125: aload_0
    //   126: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   129: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   132: invokevirtual 124	com/google/android/gm/provider/TransactionHelper:setTransactionSuccessful	()V
    //   135: aload_0
    //   136: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   139: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   142: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   145: return
    //   146: ldc 52
    //   148: ldc -127
    //   150: iconst_1
    //   151: anewarray 4	java/lang/Object
    //   154: dup
    //   155: iconst_0
    //   156: aload_1
    //   157: getfield 84	com/google/android/gm/provider/MailSync$Message:messageId	J
    //   160: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   163: aastore
    //   164: invokestatic 136	com/google/android/gm/provider/LogUtils:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   167: pop
    //   168: goto -74 -> 94
    //   171: astore_1
    //   172: aload_0
    //   173: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   176: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   179: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   182: aload_1
    //   183: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	184	0	this	PublicMailStore
    //   0	184	1	paramMessage	MailSync.Message
    //   0	184	2	paramLong	long
    // Exception table:
    //   from	to	target	type
    //   33	94	171	finally
    //   94	135	171	finally
    //   146	168	171	finally
  }
  
  void addOrUpdateMessageNoNotifyWithoutWritingOperations(MailSync.Message paramMessage, long paramLong1, long paramLong2, MailEngine.ClientCreated paramClientCreated)
  {
    TimingLogger localTimingLogger = new TimingLogger("Gmail", "addOrUpdateMessageNoNotifyWithoutWritingOperations");
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    ContentValues localContentValues;
    int i;
    try
    {
      localContentValues = new ContentValues();
      localContentValues.put("messageId", Long.valueOf(messageId));
      localContentValues.put("conversation", Long.valueOf(conversationId));
      localContentValues.put("fromAddress", fromAddress);
      localContentValues.put("toAddresses", TextUtils.join("\n", toAddresses));
      localContentValues.put("ccAddresses", TextUtils.join("\n", ccAddresses));
      localContentValues.put("bccAddresses", TextUtils.join("\n", bccAddresses));
      localContentValues.put("replyToAddresses", TextUtils.join("\n", replyToAddresses));
      localContentValues.put("dateSentMs", Long.valueOf(dateSentMs));
      localContentValues.put("dateReceivedMs", Long.valueOf(dateReceivedMs));
      localContentValues.put("subject", subject);
      localContentValues.put("listInfo", listInfo);
      localContentValues.put("personalLevel", Integer.valueOf(personalLevel.toInt()));
      localContentValues.put("clientCreated", Integer.valueOf(paramClientCreated.toInt()));
      localContentValues.put("snippet", snippet);
      if (paramLong1 == 0L) {
        break label1360;
      }
      localContentValues.put("_id", Long.valueOf(paramLong1));
    }
    finally
    {
      this$0.mTransaction.endTransaction();
      localTimingLogger.addSplit("post body");
      localTimingLogger.dumpToLog();
    }
    localContentValues.put("synced", Integer.valueOf(i));
    localContentValues.put("queryId", Long.valueOf(paramLong2));
    localTimingLogger.addSplit("pre body");
    if (body != null)
    {
      if (Gservices.getInt(MailEngine.access$2300(this$0).getContentResolver(), "gmail_db_compression_type", 1) != 0) {
        break label716;
      }
      localContentValues.put("body", body);
      localContentValues.putNull("bodyCompressed");
    }
    label332:
    label350:
    long l;
    for (;;)
    {
      localTimingLogger.addSplit("body");
      if (!bodyEmbedsExternalResources) {
        break label1373;
      }
      i = 1;
      localContentValues.put("bodyEmbedsExternalResources", Integer.valueOf(i));
      if (!TextUtils.isEmpty(customFromAddress)) {
        localContentValues.put("customFromAddress", customFromAddress);
      }
      if (refMsgId != 0L) {
        localContentValues.put("refMessageId", Long.valueOf(refMsgId));
      }
      l = MailEngine.access$000(this$0).getLabelIdDraft();
      if (attachments.size() == 0) {
        break label1385;
      }
      if ((paramLong1 == 0L) && (paramLong2 == 0L))
      {
        if ((MailEngine.access$2400(this$0) == null) || (!MailEngine.access$2400(this$0).getPrefetchAttachments(this$0.getAccountName()))) {
          break label1379;
        }
        i = 1;
        label481:
        localObject = attachments.iterator();
        for (;;)
        {
          if (((Iterator)localObject).hasNext())
          {
            Gmail.Attachment localAttachment = (Gmail.Attachment)((Iterator)localObject).next();
            Uri localUri = Gmail.getAttachmentUri(this$0.getAccountName(), messageId, localAttachment, Gmail.AttachmentRendition.BEST, false);
            boolean bool = MimeType.isViewable(MailEngine.access$2300(this$0), localUri, contentType);
            if ((contentType.startsWith("image/")) && (paramClientCreated == MailEngine.ClientCreated.SERVER_CREATED) && (!labelIds.contains(Long.valueOf(l)))) {
              MailEngine.access$1200(this$0).enqueueAttachment(conversationId, messageId, localAttachment, Gmail.AttachmentRendition.SIMPLE, false, true, 1);
            }
            if ((paramClientCreated == MailEngine.ClientCreated.SERVER_CREATED) && (!labelIds.contains(Long.valueOf(l))) && (i != 0) && (bool))
            {
              MailEngine.access$1200(this$0).enqueueAttachment(conversationId, messageId, localAttachment, Gmail.AttachmentRendition.BEST, false, true, 0);
              continue;
              label710:
              i = 0;
              break;
              label716:
              i = Gservices.getInt(MailEngine.access$2300(this$0).getContentResolver(), "gmail_db_compression_threshold", 100);
              if (body.length() < i)
              {
                localContentValues.put("body", body);
                localContentValues.putNull("bodyCompressed");
                break label332;
              }
              try
              {
                localContentValues.put("bodyCompressed", ZipUtils.deflate(body.getBytes("UTF-8")));
                localContentValues.putNull("body");
              }
              catch (UnsupportedEncodingException paramMessage)
              {
                throw new IllegalStateException("UTF-8 not supported");
              }
            }
          }
        }
      }
    }
    paramClientCreated = MailEngine.access$2500(paramMessage);
    label821:
    localContentValues.put("joinedAttachmentInfos", paramClientCreated);
    int j = 0;
    paramClientCreated = this$0;
    paramLong1 = messageId;
    Object localObject = paramClientCreated.getMessageCursorForMessageId(new String[] { "conversation", "queryId", "joinedAttachmentInfos", "clientCreated" }, paramLong1);
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject).moveToNext()) {
          break label1349;
        }
        paramLong1 = ((Cursor)localObject).getLong(0);
        if (((Cursor)localObject).getInt(1) != 0) {
          break label1393;
        }
        i = 1;
        paramClientCreated = ((Cursor)localObject).getString(2);
        j = ((Cursor)localObject).getInt(3);
        int k = MailEngine.ClientCreated.access$2600(MailEngine.ClientCreated.CLIENT_CREATED);
        if (j != k) {
          break label1399;
        }
        j = 1;
        ((Cursor)localObject).close();
        if (paramLong1 == 0L) {
          break label1179;
        }
        if ((j != 0) && (paramClientCreated != null))
        {
          if (!labelIds.contains(Long.valueOf(l))) {
            MailEngine.access$2700(this$0, paramClientCreated);
          }
        }
        else
        {
          if ((paramLong2 != 0L) && (i != 0))
          {
            LogUtils.d("Gmail", "Message %d already synced. Keep it that way", new Object[] { Long.valueOf(messageId) });
            localContentValues.put("queryId", Integer.valueOf(0));
            localContentValues.put("synced", Boolean.valueOf(true));
          }
          LogUtils.d("Gmail", "Updating message %d. queryId=%d", new Object[] { Long.valueOf(messageId), Long.valueOf(paramLong2) });
          i = this$0.mDb.update("messages", localContentValues, "messageId = ?", new String[] { Long.toString(messageId) });
          if (i == 1) {
            break label1244;
          }
          throw new SQLException("surprising number of rows updated: " + i);
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
      MailEngine.access$2800(this$0, localContentValues, paramClientCreated);
      continue;
      label1179:
      LogUtils.d("Gmail", "Inserting message %d. queryId=%d", new Object[] { Long.valueOf(messageId), Long.valueOf(paramLong2) });
      if (this$0.mDb.insert("messages", null, localContentValues) == -1L) {
        throw new SQLException("error inserting message");
      }
      label1244:
      if ((body != null) && (paramLong2 == 0L)) {
        MailEngine.access$2900(this$0);
      }
      this$0.mMailCore.setLabelsOnMessageWithoutWritingOperations(messageId, labelIds);
      paramClientCreated = MailSync.SyncRationale.UNKNOWN;
      if ((paramLong1 != 0L) && (paramLong1 != conversationId)) {
        MailEngine.access$2000(this$0, paramLong1, paramClientCreated, true, false);
      }
      this$0.mTransaction.setTransactionSuccessful();
      this$0.mTransaction.endTransaction();
      localTimingLogger.addSplit("post body");
      localTimingLogger.dumpToLog();
      return;
      label1349:
      paramLong1 = 0L;
      paramClientCreated = null;
      i = 0;
      continue;
      label1360:
      if (paramLong2 != 0L) {
        break label710;
      }
      i = 1;
      break;
      label1373:
      i = 0;
      break label350;
      label1379:
      i = 0;
      break label481;
      label1385:
      paramClientCreated = "";
      break label821;
      label1393:
      i = 0;
      continue;
      label1399:
      j = 0;
    }
  }
  
  public void addSendWithoutSyncConversationInfoToCheck(long paramLong1, long paramLong2)
  {
    if (getMaxMessageIdForConversation(paramLong1) < paramLong2)
    {
      LogUtils.v("Gmail", "  device is lower than server. Will check conversation", new Object[0]);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("_id", Long.valueOf(paramLong1));
      this$0.mDb.replace("send_without_sync_conversations_to_fetch", null, localContentValues);
    }
  }
  
  /* Error */
  public void addSyncedConversationInfoToCheck(long paramLong1, long paramLong2)
  {
    // Byte code:
    //   0: ldc_w 526
    //   3: astore 6
    //   5: aload_0
    //   6: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   9: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   12: ldc_w 543
    //   15: invokevirtual 35	android/database/sqlite/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Landroid/database/sqlite/SQLiteStatement;
    //   18: astore 8
    //   20: aload 8
    //   22: iconst_1
    //   23: lload_1
    //   24: invokevirtual 41	android/database/sqlite/SQLiteStatement:bindLong	(IJ)V
    //   27: aload 8
    //   29: invokevirtual 546	android/database/sqlite/SQLiteStatement:simpleQueryForString	()Ljava/lang/String;
    //   32: astore 7
    //   34: aload 7
    //   36: astore 6
    //   38: aload 8
    //   40: invokevirtual 48	android/database/sqlite/SQLiteStatement:close	()V
    //   43: getstatic 549	com/google/android/gm/provider/MailSync$SyncRationale:NONE	Lcom/google/android/gm/provider/MailSync$SyncRationale;
    //   46: invokevirtual 550	com/google/android/gm/provider/MailSync$SyncRationale:toString	()Ljava/lang/String;
    //   49: aload 6
    //   51: invokevirtual 553	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   54: ifeq +126 -> 180
    //   57: aload_0
    //   58: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   61: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   64: aload_0
    //   65: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   68: invokestatic 68	com/google/android/gm/provider/MailEngine:access$500	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    //   71: invokevirtual 74	com/google/android/gm/provider/TransactionHelper:beginTransactionWithListenerNonExclusive	(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    //   74: aload_0
    //   75: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   78: lload_1
    //   79: getstatic 520	com/google/android/gm/provider/MailSync$SyncRationale:UNKNOWN	Lcom/google/android/gm/provider/MailSync$SyncRationale;
    //   82: iconst_1
    //   83: iconst_0
    //   84: invokestatic 524	com/google/android/gm/provider/MailEngine:access$2000	(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    //   87: aload_0
    //   88: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   91: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   94: invokevirtual 124	com/google/android/gm/provider/TransactionHelper:setTransactionSuccessful	()V
    //   97: aload_0
    //   98: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   101: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   104: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   107: new 146	android/content/ContentValues
    //   110: dup
    //   111: invokespecial 147	android/content/ContentValues:<init>	()V
    //   114: astore 6
    //   116: aload 6
    //   118: ldc -26
    //   120: lload_1
    //   121: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   124: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   127: aload_0
    //   128: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   131: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   134: ldc_w 555
    //   137: aconst_null
    //   138: aload 6
    //   140: invokevirtual 540	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   143: pop2
    //   144: return
    //   145: astore 7
    //   147: aload 8
    //   149: invokevirtual 48	android/database/sqlite/SQLiteStatement:close	()V
    //   152: goto -109 -> 43
    //   155: astore 6
    //   157: aload 8
    //   159: invokevirtual 48	android/database/sqlite/SQLiteStatement:close	()V
    //   162: aload 6
    //   164: athrow
    //   165: astore 6
    //   167: aload_0
    //   168: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   171: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   174: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   177: aload 6
    //   179: athrow
    //   180: aload_0
    //   181: lload_1
    //   182: invokespecial 530	com/google/android/gm/provider/MailEngine$PublicMailStore:getMaxMessageIdForConversation	(J)J
    //   185: lload_3
    //   186: lcmp
    //   187: ifge +54 -> 241
    //   190: ldc 52
    //   192: ldc_w 532
    //   195: iconst_0
    //   196: anewarray 4	java/lang/Object
    //   199: invokestatic 535	com/google/android/gm/provider/LogUtils:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   202: pop
    //   203: new 146	android/content/ContentValues
    //   206: dup
    //   207: invokespecial 147	android/content/ContentValues:<init>	()V
    //   210: astore 6
    //   212: aload 6
    //   214: ldc -26
    //   216: lload_1
    //   217: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   220: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   223: aload_0
    //   224: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   227: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   230: ldc_w 555
    //   233: aconst_null
    //   234: aload 6
    //   236: invokevirtual 540	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   239: pop2
    //   240: return
    //   241: lconst_0
    //   242: aload_0
    //   243: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   246: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   249: ldc_w 557
    //   252: iconst_1
    //   253: anewarray 78	java/lang/String
    //   256: dup
    //   257: iconst_0
    //   258: lload_3
    //   259: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   262: aastore
    //   263: invokestatic 103	android/database/DatabaseUtils:longForQuery	(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;)J
    //   266: lcmp
    //   267: ifeq +61 -> 328
    //   270: iconst_1
    //   271: istore 5
    //   273: iload 5
    //   275: ifne +59 -> 334
    //   278: ldc 52
    //   280: ldc_w 559
    //   283: iconst_0
    //   284: anewarray 4	java/lang/Object
    //   287: invokestatic 60	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   290: pop
    //   291: new 146	android/content/ContentValues
    //   294: dup
    //   295: invokespecial 147	android/content/ContentValues:<init>	()V
    //   298: astore 6
    //   300: aload 6
    //   302: ldc -26
    //   304: lload_3
    //   305: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   308: invokevirtual 152	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   311: aload_0
    //   312: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   315: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   318: ldc 115
    //   320: aconst_null
    //   321: aload 6
    //   323: invokevirtual 497	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   326: pop2
    //   327: return
    //   328: iconst_0
    //   329: istore 5
    //   331: goto -58 -> 273
    //   334: ldc 52
    //   336: iconst_2
    //   337: invokestatic 563	com/google/android/gm/provider/LogUtils:isLoggable	(Ljava/lang/String;I)Z
    //   340: ifeq -196 -> 144
    //   343: ldc 52
    //   345: ldc_w 565
    //   348: iconst_0
    //   349: anewarray 4	java/lang/Object
    //   352: invokestatic 60	com/google/android/gm/provider/LogUtils:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)I
    //   355: pop
    //   356: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	357	0	this	PublicMailStore
    //   0	357	1	paramLong1	long
    //   0	357	3	paramLong2	long
    //   271	59	5	i	int
    //   3	136	6	localObject1	Object
    //   155	8	6	localObject2	Object
    //   165	13	6	localObject3	Object
    //   210	112	6	localContentValues	ContentValues
    //   32	3	7	str	String
    //   145	1	7	localSQLiteDoneException	SQLiteDoneException
    //   18	140	8	localSQLiteStatement	SQLiteStatement
    // Exception table:
    //   from	to	target	type
    //   20	34	145	android/database/sqlite/SQLiteDoneException
    //   20	34	155	finally
    //   74	97	165	finally
  }
  
  public void commit()
  {
    this$0.mTransaction.setTransactionSuccessful();
    this$0.mTransaction.endTransaction();
  }
  
  public void delayConversationSync(long paramLong)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    long l3 = DatabaseUtils.longForQuery(this$0.mDb, "SELECT numAttempts FROM conversations_to_fetch WHERE _id = ?", arrayOfString);
    long l2 = this$0.mMailSync.getConversationAgeDays();
    long l1;
    if (l2 > 0L)
    {
      l1 = l2;
      if (l2 <= 7L) {}
    }
    else
    {
      l1 = 7L;
    }
    if (l3 > l1 + 4L)
    {
      LogUtils.i("Gmail", "Giving up on conversation %d after %d attempts", new Object[] { Long.valueOf(paramLong), Long.valueOf(l3) });
      this$0.mDb.delete("conversations_to_fetch", "_id = ?", arrayOfString);
    }
    int i;
    do
    {
      return;
      i = Math.min(1 << (int)l3, 24);
      l1 = new Date().getTime() + i * 60 * 60 * 1000;
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("nextAttemptDateMs", Long.valueOf(l1));
      localContentValues.put("numAttempts", Long.valueOf(l3 + 1L));
      this$0.mDb.update("conversations_to_fetch", localContentValues, "_id = ?", arrayOfString);
    } while (!LogUtils.isLoggable("Gmail", 4));
    LogUtils.i("Gmail", "Delayed sync of conversation %d by %d hours till after %s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(i), new Date(l1) });
  }
  
  public void deleteCorruptedMessage(long paramLong1, long paramLong2)
  {
    this$0.mDb.execSQL("DELETE FROM messages WHERE conversation = ? AND messageId >= ?", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  public void deleteLabel(MailCore.Label paramLabel)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    try
    {
      this$0.mMailCore.deleteLabel(paramLabel);
      this$0.mMailCore.onLabelsChanged();
      this$0.mTransaction.setTransactionSuccessful();
      return;
    }
    finally
    {
      this$0.mTransaction.endTransaction();
    }
  }
  
  public void expungeMessages(long paramLong, List<Long> paramList, MailSync.SyncRationale paramSyncRationale)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    try
    {
      this$0.mMailCore.expungeMessagesWithoutWritingOperations(paramList);
      MailEngine.access$2000(this$0, paramLong, paramSyncRationale, true, false);
      this$0.mTransaction.setTransactionSuccessful();
      return;
    }
    finally
    {
      this$0.mTransaction.endTransaction();
    }
  }
  
  public String getAccount()
  {
    return access$800this$0).name;
  }
  
  public ArrayList<MailSync.ConversationInfo> getConversationInfosToFetch(MailEngine.SyncInfo paramSyncInfo)
  {
    Object localObject1;
    if ((paramSyncInfo == null) || (normalSync))
    {
      long l = new Date().getTime();
      localObject1 = "select conversations_to_fetch._id as _id,   max(\n    case when not clientCreated then messages.messageId else 0 end)\n    as highestMessageId,   max(messages.clientCreated) as hasClientCreatedMessages from   conversations_to_fetch left outer join messages on   messages.conversation = conversations_to_fetch._id   and messages.queryId = 0 where nextAttemptDateMs < ?group by conversations_to_fetch._id order by conversations_to_fetch._id desc limit 50";
      paramSyncInfo = new String[1];
      paramSyncInfo[0] = String.valueOf(l);
    }
    String str;
    for (;;)
    {
      paramSyncInfo = this$0.mDb.rawQuery((String)localObject1, paramSyncInfo);
      int i = paramSyncInfo.getColumnIndexOrThrow("_id");
      int j = paramSyncInfo.getColumnIndexOrThrow("highestMessageId");
      try
      {
        localObject1 = new ArrayList();
        while (paramSyncInfo.moveToNext()) {
          ((ArrayList)localObject1).add(new MailSync.ConversationInfo(paramSyncInfo.getLong(i), paramSyncInfo.getLong(j)));
        }
        str = "select send_without_sync_conversations_to_fetch._id as _id,   max(\n    case when not clientCreated then messages.messageId else 0 end)\n    as highestMessageId,   max(messages.clientCreated) as hasClientCreatedMessages from   send_without_sync_conversations_to_fetch left outer join messages on   messages.conversation = send_without_sync_conversations_to_fetch._id   and messages.queryId = 0 group by send_without_sync_conversations_to_fetch._id order by send_without_sync_conversations_to_fetch._id desc limit 50";
      }
      finally
      {
        paramSyncInfo.close();
      }
      paramSyncInfo = null;
    }
    paramSyncInfo.close();
    return str;
  }
  
  public ArrayList<Long> getDirtyConversations()
  {
    ArrayList localArrayList = Lists.newArrayList();
    Cursor localCursor = this$0.mDb.rawQuery("SELECT DISTINCT _id FROM conversations WHERE dirty = 1", null);
    try
    {
      if (localCursor.moveToNext()) {
        localArrayList.add(Long.valueOf(localCursor.getLong(0)));
      }
      return localArrayList1;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public InputStream getInputStreamForUploadedAttachment(long paramLong, Gmail.Attachment paramAttachment)
    throws FileNotFoundException, SecurityException
  {
    if (!Strings.isNullOrEmpty(cachedContent))
    {
      LogUtils.d("Gmail", "Loading cached attachment: %s", new Object[] { cachedContent });
      try
      {
        FileInputStream localFileInputStream = new FileInputStream(cachedContent);
        return localFileInputStream;
      }
      catch (IOException localIOException)
      {
        LogUtils.w("Gmail", localIOException, "Failed to load cached attachment %s. Will attempt original URI %s", new Object[] { cachedContent, originExtras });
      }
    }
    try
    {
      Object localObject = Uri.parse(originExtras);
      LogUtils.d("Gmail", "Loading attachment URI: %s", new Object[] { originExtras });
      localObject = MailEngine.access$2300(this$0).getContentResolver().openInputStream((Uri)localObject);
      return (InputStream)localObject;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      LogUtils.w("Gmail", localFileNotFoundException, "Failed to attach %s due to a FileNotFoundException. Since the cached file has already been tried, this file cannotbe attached. Notify the user.", new Object[] { originExtras });
      throw localFileNotFoundException;
    }
    catch (SecurityException localSecurityException)
    {
      LogUtils.w("Gmail", localSecurityException, "Failed to attach %s due to a SecurityException. Since the cached file has already been tried, this file cannot be attached. Notify the user.", new Object[] { originExtras });
      throw localSecurityException;
    }
  }
  
  public String getLabelCanonicalNameOrNull(MailCore.Label paramLabel)
  {
    return this$0.mMailCore.getLabelCanonicalNameOrNull(paramLabel);
  }
  
  public MailCore.Label getLabelOrNull(long paramLong)
  {
    return this$0.mMailCore.getLabelOrNull(paramLong);
  }
  
  public Cursor getMessageCursorForConversationId(String[] paramArrayOfString, long paramLong)
  {
    return this$0.getMessageCursorForConversationId(paramArrayOfString, paramLong);
  }
  
  public ArrayList<Long> getMessageIdsToFetch()
  {
    ArrayList localArrayList = Lists.newArrayList();
    Cursor localCursor = this$0.mDb.rawQuery("select _id from messages_to_fetch", null);
    try
    {
      if (localCursor.moveToNext()) {
        localArrayList.add(Long.valueOf(localCursor.getLong(0)));
      }
      return localArrayList1;
    }
    finally
    {
      localCursor.close();
    }
  }
  
  public MailCore.Label getOrAddLabel(long paramLong)
  {
    return this$0.mMailCore.getOrAddLabel(paramLong);
  }
  
  public MailCore.Label getOrAddLabel(String paramString)
  {
    return this$0.mMailCore.getOrAddLabel(paramString);
  }
  
  public void handleConversation(MailSync.Conversation paramConversation)
  {
    LogUtils.v("Gmail", "Got conversation header with MainSync: %s", new Object[] { paramConversation });
    this$0.handleConversation(paramConversation, 0L, null);
  }
  
  public boolean isSyncConfigKey(String paramString)
  {
    return ("labelsIncluded".equals(paramString)) || ("labelsPartial".equals(paramString)) || ("conversationAgeDays".equals(paramString)) || ("maxAttachmentSize".equals(paramString));
  }
  
  public void markConversationDirty(long paramLong)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("dirty", Integer.valueOf(1));
    if (this$0.mDb.update("conversations", localContentValues, "_id = ?", new String[] { Long.toString(paramLong) }) == 0) {
      LogUtils.e("Gmail", "Failed to mark conversation as dirty", new Object[0]);
    }
  }
  
  public void notifyConversationChanged(long paramLong, MailSync.SyncRationale paramSyncRationale)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    try
    {
      MailEngine.access$2000(this$0, paramLong, paramSyncRationale, true, false);
      this$0.mTransaction.setTransactionSuccessful();
      return;
    }
    finally
    {
      this$0.mTransaction.endTransaction();
    }
  }
  
  /* Error */
  public void notifyConversationLoaded(long paramLong, MailSync.SyncRationale paramSyncRationale, MailEngine.SyncInfo paramSyncInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   4: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   7: aload_0
    //   8: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   11: invokestatic 68	com/google/android/gm/provider/MailEngine:access$500	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    //   14: invokevirtual 74	com/google/android/gm/provider/TransactionHelper:beginTransactionWithListenerNonExclusive	(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    //   17: aload 4
    //   19: getfield 644	com/google/android/gm/provider/MailEngine$SyncInfo:normalSync	Z
    //   22: ifeq +79 -> 101
    //   25: aload_0
    //   26: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   29: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   32: ldc_w 555
    //   35: ldc 117
    //   37: iconst_1
    //   38: anewarray 78	java/lang/String
    //   41: dup
    //   42: iconst_0
    //   43: lload_1
    //   44: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   47: aastore
    //   48: invokevirtual 121	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   51: pop
    //   52: aload_0
    //   53: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   56: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   59: ldc_w 555
    //   62: ldc_w 782
    //   65: iconst_1
    //   66: anewarray 78	java/lang/String
    //   69: dup
    //   70: iconst_0
    //   71: lload_1
    //   72: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   75: aastore
    //   76: invokevirtual 121	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   79: pop
    //   80: aload_0
    //   81: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   84: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   87: invokevirtual 124	com/google/android/gm/provider/TransactionHelper:setTransactionSuccessful	()V
    //   90: aload_0
    //   91: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   94: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   97: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   100: return
    //   101: aload_0
    //   102: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   105: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   108: ldc_w 537
    //   111: ldc 117
    //   113: iconst_1
    //   114: anewarray 78	java/lang/String
    //   117: dup
    //   118: iconst_0
    //   119: lload_1
    //   120: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   123: aastore
    //   124: invokevirtual 121	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   127: pop
    //   128: aload_0
    //   129: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   132: getfield 27	com/google/android/gm/provider/MailEngine:mDb	Landroid/database/sqlite/SQLiteDatabase;
    //   135: ldc_w 537
    //   138: ldc_w 782
    //   141: iconst_1
    //   142: anewarray 78	java/lang/String
    //   145: dup
    //   146: iconst_0
    //   147: lload_1
    //   148: invokestatic 90	java/lang/Long:toString	(J)Ljava/lang/String;
    //   151: aastore
    //   152: invokevirtual 121	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   155: pop
    //   156: goto -76 -> 80
    //   159: astore_3
    //   160: aload_0
    //   161: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   164: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   167: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   170: aload_3
    //   171: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	172	0	this	PublicMailStore
    //   0	172	1	paramLong	long
    //   0	172	3	paramSyncRationale	MailSync.SyncRationale
    //   0	172	4	paramSyncInfo	MailEngine.SyncInfo
    // Exception table:
    //   from	to	target	type
    //   17	80	159	finally
    //   80	90	159	finally
    //   101	156	159	finally
  }
  
  public void notifyLabelChanges(Set<Long> paramSet)
  {
    MailEngine.access$1400(this$0, paramSet);
  }
  
  public void notifyMessageDoesNotExist(long paramLong)
  {
    this$0.mDb.delete("messages_to_fetch", "_id = ?", new String[] { Long.toString(paramLong) });
  }
  
  public void notifyMessageNotUpdated(long paramLong, String paramString)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("error", paramString);
    String[] arrayOfString = new String[1];
    arrayOfString[0] = Long.toString(paramLong);
    if ("dup".equals(paramString))
    {
      LogUtils.w("Gmail", "Deleting message %d", new Object[] { Long.valueOf(paramLong) });
      expungeMessages(DatabaseUtils.longForQuery(this$0.mDb, "SELECT conversation FROM messages WHERE messageId=?", arrayOfString), Lists.newArrayList(new Long[] { Long.valueOf(paramLong) }), MailSync.SyncRationale.LOCAL_CHANGE);
      return;
    }
    this$0.mDb.update("messages", localContentValues, "messageId = ?", arrayOfString);
  }
  
  public void prepare()
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
  }
  
  public void provideOperations(MailStore.OperationSink paramOperationSink, MailEngine.SyncInfo paramSyncInfo, long paramLong)
  {
    if (normalSync)
    {
      this$0.mOperations.provideNormalOperations(paramOperationSink, this$0, paramSyncInfo, paramLong);
      return;
    }
    this$0.mOperations.provideOperations(paramOperationSink, this$0, paramSyncInfo, paramLong);
  }
  
  public void removeCustomFromPreference(String paramString)
  {
    this$0.mMailCore.removeCustomFromPreference(access$800this$0).name, paramString);
  }
  
  public void removeOperationByMessageId(long paramLong)
  {
    this$0.mOperations.deleteOperationsForMessageId(paramLong);
  }
  
  public void removeOperations(long paramLong)
  {
    this$0.mDb.delete("operations", "_id <= ?", new String[] { Long.toString(paramLong) });
  }
  
  public void renameLabel(MailCore.Label paramLabel, String paramString1, String paramString2, int paramInt, String paramString3)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    try
    {
      this$0.mMailCore.renameLabel(paramLabel, paramString1, paramString2, paramInt, paramString3);
      this$0.mMailCore.onLabelsChanged();
      this$0.mTransaction.setTransactionSuccessful();
      return;
    }
    finally
    {
      this$0.mTransaction.endTransaction();
    }
  }
  
  public void setCustomFromPreference(Map<String, MailStore.CustomFromPreference> paramMap, boolean paramBoolean)
  {
    this$0.mMailCore.setCustomFromPreference(access$800this$0).name, paramMap, paramBoolean);
  }
  
  public void setCustomLabelColorPreference(Map<String, MailStore.CustomLabelColorPreference> paramMap)
  {
    this$0.mMailCore.setCustomLabelColorPreference(access$800this$0).name, paramMap);
  }
  
  public void setInfoOverloadArrowsOffPreference(String paramString)
  {
    this$0.mMailCore.setInfoOverloadArrowsOffPreference(paramString);
  }
  
  public void setInfoOverloadEnabledPreference(String paramString)
  {
    this$0.mMailCore.setInfoOverloadEnabledPreference(paramString);
  }
  
  public void setLabelCounts(MailCore.Label paramLabel, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    this$0.mMailCore.setLabelCounts(paramLabel, paramInt1, paramInt2, paramInt3, paramString);
  }
  
  public void setLabelOnMessages(long paramLong, List<Long> paramList, MailCore.Label paramLabel, boolean paramBoolean, MailSync.SyncRationale paramSyncRationale)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    int i = 0;
    for (;;)
    {
      try
      {
        paramList = paramList.iterator();
        if (paramList.hasNext())
        {
          long l = ((Long)paramList.next()).longValue();
          if (DatabaseUtils.longForQuery(this$0.mDb, "SELECT COUNT(*) FROM messages WHERE messageId = ?", new String[] { String.valueOf(l) }) > 0L)
          {
            j = 1;
            if (j == 0) {
              continue;
            }
            this$0.mMailCore.setLabelOnMessage(l, paramLabel, paramBoolean, Operations.RecordHistory.FALSE);
            i = 1;
          }
        }
        else
        {
          if ((i != 0) || (paramSyncRationale.equals(MailSync.SyncRationale.NONE))) {
            MailEngine.access$2000(this$0, paramLong, paramSyncRationale, true, false);
          }
          this$0.mTransaction.setTransactionSuccessful();
          return;
        }
      }
      finally
      {
        this$0.mTransaction.endTransaction();
      }
      int j = 0;
    }
  }
  
  public void setLabels(Map<Long, MailStore.LabelInfo> paramMap)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    Object localObject1;
    Object localObject2;
    Object localObject3;
    try
    {
      localObject1 = new HashMap(paramMap);
      paramMap = ((Map)localObject1).keySet();
      localObject2 = this$0.mMailCore.getAllLabels().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (MailCore.Label)((Iterator)localObject2).next();
        if ((!((Map)localObject1).containsKey(Long.valueOf(id))) && (!MailCore.isLabelIdLocal(id))) {
          this$0.mMailCore.deleteLabel((MailCore.Label)localObject3);
        }
      }
      localObject1 = ((Map)localObject1).entrySet().iterator();
    }
    finally
    {
      this$0.mTransaction.endTransaction();
    }
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject2 = this$0.mMailCore.getLabelOrThrow(((Long)((Map.Entry)localObject3).getKey()).longValue());
      localObject3 = (MailStore.LabelInfo)((Map.Entry)localObject3).getValue();
      if ((MailCore.isCanonicalLabelNameLocal(canonicalName)) || (MailCore.isLabelIdLocal(id))) {
        throw new IllegalArgumentException("Server label appears to be local: " + id + "/" + canonicalName);
      }
      this$0.mMailCore.renameLabel((MailCore.Label)localObject2, canonicalName, name, color, visibility);
      setLabelCounts((MailCore.Label)localObject2, numConversations, numUnreadConversations, color, visibility);
    }
    this$0.mMailCore.onLabelsChanged();
    MailEngine.access$600(this$0);
    this$0.mTransaction.setTransactionSuccessful();
    this$0.mTransaction.endTransaction();
    MailEngine.access$1400(this$0, paramMap);
  }
  
  public void setServerPreferences(Map<String, String> paramMap)
  {
    this$0.mMailCore.setServerPreferences(access$800this$0).name, paramMap);
  }
  
  public void setSettings(Map<String, String> paramMap, boolean paramBoolean)
  {
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    Object localObject;
    for (;;)
    {
      try
      {
        this$0.mInternalDb.beginTransactionNonExclusive();
        Map.Entry localEntry;
        try
        {
          localObject = paramMap.entrySet().iterator();
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localEntry = (Map.Entry)((Iterator)localObject).next();
          if (isSyncConfigKey((String)localEntry.getKey()))
          {
            this$0.setInternalSetting((String)localEntry.getKey(), (String)localEntry.getValue());
            continue;
            paramMap = finally;
          }
        }
        finally
        {
          this$0.mInternalDb.endTransaction();
        }
        MailEngine.access$1800(this$0, (String)localEntry.getKey(), (String)localEntry.getValue());
      }
      finally
      {
        this$0.mTransaction.endTransaction();
      }
    }
    this$0.mInternalDb.setTransactionSuccessful();
    this$0.mTransaction.setTransactionSuccessful();
    this$0.mInternalDb.endTransaction();
    this$0.mTransaction.endTransaction();
    if (this$0.mMailSync != null)
    {
      this$0.mMailCore.setServerVersion(this$0.mMailSync.getServerVersion());
      if (paramBoolean) {
        MailEngine.access$1900(this$0);
      }
    }
    if (paramBoolean)
    {
      localObject = new ContentValues();
      ((ContentValues)localObject).put("syncRationale", MailSync.SyncRationale.UNKNOWN.toString());
      this$0.mDb.update("conversations", (ContentValues)localObject, "queryId = 0", null);
      MailEngine.access$700(this$0);
    }
    if (paramMap.containsKey("lowestMessageIdInDuration")) {
      this$0.purgeStaleMessagesOutsideTransaction();
    }
  }
  
  public void updateNotificationLabels()
  {
    if (this$0.mMailSync == null) {
      return;
    }
    this$0.mTransaction.beginTransactionWithListenerNonExclusive(MailEngine.access$500(this$0));
    Object localObject1;
    boolean bool;
    try
    {
      LogUtils.v("Gmail", "updateNotificationLabels: Updating notification labels", new Object[0]);
      ArrayList localArrayList1 = Lists.newArrayList();
      Object localObject2 = Lists.newArrayList(this$0.mMailSync.getLabelsIncludedArray());
      ((List)localObject2).addAll(Arrays.asList(this$0.mMailSync.getLabelsPartialArray()));
      long l1 = MailEngine.access$000(this$0).getLabelIdUnread();
      localObject1 = ImmutableSet.of(Long.valueOf(MailEngine.access$000(this$0).getLabelIdIgnored()));
      ArrayList localArrayList2 = Lists.newArrayList();
      MailEngine.access$1300(this$0).clear();
      bool = false;
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (String)((Iterator)localObject2).next();
        if (!LabelManager.getForcedSyncedNoNotifyLabels().contains(localObject3))
        {
          LogUtils.v("Gmail", "updateNotificationLabels:   Adding: %s", new Object[] { localObject3 });
          localObject3 = this$0.mMailCore.getOrAddLabel((String)localObject3);
          long l2 = id;
          bool |= MailEngine.access$2200(this$0, (MailCore.Label)localObject3);
          localObject3 = ImmutableSet.of(Long.valueOf(l2), Long.valueOf(l1));
          long l3 = this$0.getNotificationTagLabel(l2).id;
          localArrayList2.add(Long.valueOf(l3));
          localArrayList1.add(new MailCore.NotificationRequest(l2, l3, (Set)localObject3, (Set)localObject1));
        }
      }
      localObject1 = TextUtils.join(",", localArrayList2);
    }
    finally
    {
      this$0.mTransaction.endTransaction();
    }
    this$0.mDb.delete("conversation_labels", "labels_id IN (SELECT _id FROM labels WHERE canonicalName LIKE '^^unseen-%' AND _id NOT IN (" + (String)localObject1 + "))", null);
    int i;
    if (this$0.mDb.delete("labels", "canonicalName LIKE '^^unseen-%' AND _id NOT IN (" + (String)localObject1 + ")", null) > 0) {
      i = 1;
    }
    for (;;)
    {
      this$0.mMailCore.onLabelsChanged();
      do
      {
        this$0.mMailCore.setNotificationRequests(localCollection);
        this$0.mTransaction.setTransactionSuccessful();
        this$0.mTransaction.endTransaction();
        return;
        i = 0;
        if (bool) {
          break;
        }
      } while (i == 0);
    }
  }
  
  /* Error */
  public void updateSentOrSavedMessage(long paramLong1, long paramLong2, long paramLong3)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   4: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   7: aload_0
    //   8: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   11: invokestatic 68	com/google/android/gm/provider/MailEngine:access$500	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/GmailTransactionListener;
    //   14: invokevirtual 74	com/google/android/gm/provider/TransactionHelper:beginTransactionWithListenerNonExclusive	(Lcom/google/android/gm/provider/TransactionHelper$BetterTransactionListener;)V
    //   17: aload_0
    //   18: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   21: aconst_null
    //   22: lload_1
    //   23: invokevirtual 422	com/google/android/gm/provider/MailEngine:getMessageCursorForMessageId	([Ljava/lang/String;J)Landroid/database/Cursor;
    //   26: astore 12
    //   28: aload 12
    //   30: invokeinterface 427 1 0
    //   35: istore 11
    //   37: iload 11
    //   39: ifne +21 -> 60
    //   42: aload 12
    //   44: invokeinterface 446 1 0
    //   49: aload_0
    //   50: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   53: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   56: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   59: return
    //   60: aload 12
    //   62: aload 12
    //   64: ldc -26
    //   66: invokeinterface 656 2 0
    //   71: invokeinterface 431 2 0
    //   76: lstore 7
    //   78: aload 12
    //   80: aload 12
    //   82: ldc -102
    //   84: invokeinterface 656 2 0
    //   89: invokeinterface 431 2 0
    //   94: lstore 9
    //   96: aload_0
    //   97: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   100: aload 12
    //   102: iconst_1
    //   103: invokestatic 1094	com/google/android/gm/provider/MailEngine:access$2100	(Lcom/google/android/gm/provider/MailEngine;Landroid/database/Cursor;Z)Lcom/google/android/gm/provider/MailSync$Message;
    //   106: astore 13
    //   108: aload 13
    //   110: lload_3
    //   111: putfield 84	com/google/android/gm/provider/MailSync$Message:messageId	J
    //   114: aload 13
    //   116: lload 5
    //   118: putfield 97	com/google/android/gm/provider/MailSync$Message:conversationId	J
    //   121: aload 12
    //   123: invokeinterface 446 1 0
    //   128: aload_0
    //   129: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   132: invokestatic 372	com/google/android/gm/provider/MailEngine:access$1200	(Lcom/google/android/gm/provider/MailEngine;)Lcom/google/android/gm/provider/AttachmentManager;
    //   135: lload_1
    //   136: aload 13
    //   138: getfield 84	com/google/android/gm/provider/MailSync$Message:messageId	J
    //   141: invokevirtual 1097	com/google/android/gm/provider/AttachmentManager:updateMessageId	(JJ)V
    //   144: aload_0
    //   145: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   148: getfield 817	com/google/android/gm/provider/MailEngine:mOperations	Lcom/google/android/gm/provider/Operations;
    //   151: lload_1
    //   152: aload 13
    //   154: getfield 84	com/google/android/gm/provider/MailSync$Message:messageId	J
    //   157: invokevirtual 1098	com/google/android/gm/provider/Operations:updateMessageId	(JJ)V
    //   160: lload 9
    //   162: lconst_0
    //   163: lcmp
    //   164: ifeq +41 -> 205
    //   167: aload_0
    //   168: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   171: getfield 508	com/google/android/gm/provider/MailEngine:mMailCore	Lcom/google/android/gm/provider/MailCore;
    //   174: iconst_1
    //   175: anewarray 86	java/lang/Long
    //   178: dup
    //   179: iconst_0
    //   180: lload_1
    //   181: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   184: aastore
    //   185: invokestatic 805	com/google/common/collect/Lists:newArrayList	([Ljava/lang/Object;)Ljava/util/ArrayList;
    //   188: invokevirtual 625	com/google/android/gm/provider/MailCore:expungeMessagesWithoutWritingOperations	(Ljava/util/List;)V
    //   191: aload_0
    //   192: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   195: lload 9
    //   197: getstatic 520	com/google/android/gm/provider/MailSync$SyncRationale:UNKNOWN	Lcom/google/android/gm/provider/MailSync$SyncRationale;
    //   200: iconst_1
    //   201: iconst_0
    //   202: invokestatic 524	com/google/android/gm/provider/MailEngine:access$2000	(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    //   205: aload_0
    //   206: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   209: getfield 508	com/google/android/gm/provider/MailEngine:mMailCore	Lcom/google/android/gm/provider/MailCore;
    //   212: ldc_w 1100
    //   215: invokevirtual 1102	com/google/android/gm/provider/MailCore:getLabelOrThrow	(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    //   218: astore 12
    //   220: aload 13
    //   222: getfield 362	com/google/android/gm/provider/MailSync$Message:labelIds	Ljava/util/Set;
    //   225: aload 12
    //   227: getfield 905	com/google/android/gm/provider/MailCore$Label:id	J
    //   230: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   233: invokeinterface 368 2 0
    //   238: ifeq +52 -> 290
    //   241: aload 13
    //   243: getfield 362	com/google/android/gm/provider/MailSync$Message:labelIds	Ljava/util/Set;
    //   246: aload 12
    //   248: getfield 905	com/google/android/gm/provider/MailCore$Label:id	J
    //   251: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   254: invokeinterface 1105 2 0
    //   259: pop
    //   260: aload 13
    //   262: getfield 362	com/google/android/gm/provider/MailSync$Message:labelIds	Ljava/util/Set;
    //   265: aload_0
    //   266: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   269: getfield 508	com/google/android/gm/provider/MailEngine:mMailCore	Lcom/google/android/gm/provider/MailCore;
    //   272: ldc_w 1107
    //   275: invokevirtual 1102	com/google/android/gm/provider/MailCore:getLabelOrThrow	(Ljava/lang/String;)Lcom/google/android/gm/provider/MailCore$Label;
    //   278: getfield 905	com/google/android/gm/provider/MailCore$Label:id	J
    //   281: invokestatic 133	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   284: invokeinterface 1108 2 0
    //   289: pop
    //   290: aload_0
    //   291: aload 13
    //   293: lload 7
    //   295: lconst_0
    //   296: getstatic 441	com/google/android/gm/provider/MailEngine$ClientCreated:CLIENT_CREATED	Lcom/google/android/gm/provider/MailEngine$ClientCreated;
    //   299: invokevirtual 113	com/google/android/gm/provider/MailEngine$PublicMailStore:addOrUpdateMessageNoNotifyWithoutWritingOperations	(Lcom/google/android/gm/provider/MailSync$Message;JJLcom/google/android/gm/provider/MailEngine$ClientCreated;)V
    //   302: aload_0
    //   303: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   306: aload 13
    //   308: getfield 97	com/google/android/gm/provider/MailSync$Message:conversationId	J
    //   311: getstatic 520	com/google/android/gm/provider/MailSync$SyncRationale:UNKNOWN	Lcom/google/android/gm/provider/MailSync$SyncRationale;
    //   314: iconst_1
    //   315: iconst_0
    //   316: invokestatic 524	com/google/android/gm/provider/MailEngine:access$2000	(Lcom/google/android/gm/provider/MailEngine;JLcom/google/android/gm/provider/MailSync$SyncRationale;ZZ)V
    //   319: aload_0
    //   320: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   323: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   326: invokevirtual 124	com/google/android/gm/provider/TransactionHelper:setTransactionSuccessful	()V
    //   329: aload_0
    //   330: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   333: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   336: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   339: return
    //   340: astore 13
    //   342: aload 12
    //   344: invokeinterface 446 1 0
    //   349: aload 13
    //   351: athrow
    //   352: astore 12
    //   354: aload_0
    //   355: getfield 15	com/google/android/gm/provider/MailEngine$PublicMailStore:this$0	Lcom/google/android/gm/provider/MailEngine;
    //   358: getfield 64	com/google/android/gm/provider/MailEngine:mTransaction	Lcom/google/android/gm/provider/TransactionHelper;
    //   361: invokevirtual 127	com/google/android/gm/provider/TransactionHelper:endTransaction	()V
    //   364: aload 12
    //   366: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	PublicMailStore
    //   0	367	1	paramLong1	long
    //   0	367	3	paramLong2	long
    //   0	367	5	paramLong3	long
    //   76	218	7	l1	long
    //   94	102	9	l2	long
    //   35	3	11	bool	boolean
    //   26	317	12	localObject1	Object
    //   352	13	12	localObject2	Object
    //   106	201	13	localMessage	MailSync.Message
    //   340	10	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   28	37	340	finally
    //   60	121	340	finally
    //   17	28	352	finally
    //   42	49	352	finally
    //   121	160	352	finally
    //   167	205	352	finally
    //   205	290	352	finally
    //   290	329	352	finally
    //   342	352	352	finally
  }
  
  public void wipeAndResync(String paramString)
  {
    MailEngine.access$1700(this$0, paramString);
  }
  
  public boolean yieldForContention()
  {
    return this$0.mDb.yieldIfContendedSafely();
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailEngine.PublicMailStore
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */