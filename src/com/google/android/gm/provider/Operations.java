package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDoneException;
import android.database.sqlite.SQLiteQueryBuilder;
import android.text.TextUtils;
import com.google.android.gsf.Gservices;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Operations
{
  private static final Integer NUM_RETRY_UPHILL_OPS = Integer.valueOf(20);
  private final String[] PROJECTION_PROVIDE_OPERATIONS = { "_id", "action", "message_messageId", "value1", "value2", "numAttempts", "nextTimeToAttempt", "delay" };
  private Context mContext;
  private final SQLiteDatabase mDb;
  
  public Operations(Context paramContext, SQLiteDatabase paramSQLiteDatabase)
  {
    mDb = paramSQLiteDatabase;
    mContext = paramContext;
  }
  
  private boolean calculateAndUpdateOpDelay(long paramLong1, long paramLong2, int paramInt1, int paramInt2, long paramLong3, OperationInfo paramOperationInfo, MailEngine.SyncInfo paramSyncInfo, MailEngine paramMailEngine)
  {
    if (Gservices.getInt(mContext.getContentResolver(), "gmail_delay_bad_op", 1) != 0) {}
    for (int i = 1; i == 0; i = 0) {
      return true;
    }
    String str = mAction;
    LogUtils.d("Gmail", "calculateAndUpdateOpDelay: currentTime = %d, nextTimeToAttempt = %d, numAttempts = %d delay=%d %s", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong3), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramSyncInfo });
    if (paramLong3 > paramLong1)
    {
      moveOperationToEnd(paramLong2, paramOperationInfo, paramSyncInfo, paramInt1, paramLong3, paramInt2);
      return false;
    }
    if ((!receivedHandledClientOp) && (paramInt1 > 0))
    {
      LogUtils.i("Gmail", "Not retrying this operation id %d as we have not received what client operations the server has handled.", new Object[] { Long.valueOf(paramLong2) });
      mMailSync.setBooleanSetting("unackedSentOperations", true);
      mMailSync.saveDirtySettings();
      moveOperationToEnd(paramLong2, paramOperationInfo, paramSyncInfo, paramInt1, paramLong3, paramInt2);
      return false;
    }
    if (paramInt1 >= 3)
    {
      if (paramInt2 == 0) {}
      for (paramInt1 = 30;; paramInt1 = Math.min(86400, paramInt2 * 2))
      {
        paramLong1 += paramInt1;
        LogUtils.i("Gmail", "Backing off operation %d with newAttempts %d, delay %d, newBackOffTime %d, newOpId %d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(2), Integer.valueOf(paramInt1), Long.valueOf(paramLong1), Long.valueOf(moveOperationToEnd(paramLong2, paramOperationInfo, paramSyncInfo, 2, paramLong1, paramInt1)) });
        return false;
      }
    }
    paramOperationInfo = Integer.toString(paramInt1 + 1);
    paramSyncInfo = Long.toString(paramLong2);
    mDb.execSQL("UPDATE operations SET numAttempts = ? WHERE _id = ?", new String[] { paramOperationInfo, paramSyncInfo });
    return true;
  }
  
  private void checkForMessageToDiscard(MailEngine paramMailEngine)
  {
    ContentResolver localContentResolver = mContext.getContentResolver();
    int i = Gservices.getInt(localContentResolver, "gmail_num_retry_uphill_op", NUM_RETRY_UPHILL_OPS.intValue());
    int j = nextOperationId();
    int k = mMailSync.getIntegerSetting("nextUnackedSentOp");
    int m = mMailSync.getIntegerSetting("errorCountNextUnackedSentOp");
    long l1 = mMailSync.getLongSetting("nextUnackedOpWriteTime");
    long l2 = System.currentTimeMillis() / 1000L;
    long l3 = Gservices.getLong(localContentResolver, "gmail_wait_time_retry_uphill_op", 36400L);
    if ((j == k) && (m >= Integer.valueOf(i).intValue()) && (l2 - l1 > l3)) {
      mDb.delete("operations", "_id == " + j, null);
    }
  }
  
  private boolean doesLabelMatter(String paramString)
  {
    return (!"messageSaved".equals(paramString)) && (!"messageSent".equals(paramString)) && (!"messageExpunged".equals(paramString));
  }
  
  private long moveOperationToEnd(long paramLong1, OperationInfo paramOperationInfo, MailEngine.SyncInfo paramSyncInfo, int paramInt1, long paramLong2, int paramInt2)
  {
    String str = mAction;
    long l;
    if (normalSync)
    {
      mDb.execSQL("DELETE FROM operations where _id = ?", new String[] { Long.toString(paramLong1) });
      if (doesLabelMatter(str)) {
        l = recordOperationWithLabelId(mConversationId, mMessageId, mAction, mLabelId, paramInt1, paramInt2, paramLong2);
      }
    }
    for (;;)
    {
      LogUtils.i("Gmail", "Moving delayed operation %d to end of list with newAttempts %d, delay %d, newBackOffTime %d, newOpId %d", new Object[] { Long.valueOf(paramLong1), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong2), Long.valueOf(l) });
      return l;
      l = recordOperation(mConversationId, mMessageId, mAction, paramInt1, paramInt2, paramLong2);
      continue;
      mDb.execSQL("DELETE FROM operations where _id = ?", new String[] { Long.toString(paramLong1) });
      l = incrementAndAddOperations(new OperationInfo(conversationId, messageId, mAction, 0L, paramInt1, paramInt2, paramLong2));
    }
  }
  
  public static void updateLabelId(SQLiteDatabase paramSQLiteDatabase, long paramLong1, long paramLong2)
  {
    paramSQLiteDatabase.execSQL("UPDATE operations SET value1 = ? WHERE action IN ('messageLabelAdded', 'messageLabelRemoved', 'conversationLabelAdded', 'conversationLabelRemoved') AND value1 = ?", new String[] { Long.toString(paramLong2), Long.toString(paramLong1) });
  }
  
  public void deleteOperationsForLabelId(long paramLong)
  {
    String str = Long.toString(paramLong);
    mDb.delete("operations", "action IN ('messageLabelAdded', 'messageLabelRemoved', 'conversationLabelAdded', 'conversationLabelRemoved') AND value1 = ?", new String[] { str });
  }
  
  public void deleteOperationsForMessageId(long paramLong)
  {
    mDb.delete("operations", "message_messageId = ?", new String[] { Long.toString(paramLong) });
  }
  
  public void deleteOperationsForMessageIds(List<Long> paramList)
  {
    paramList = TextUtils.join(", ", paramList);
    mDb.delete("operations", "message_messageId IN (" + paramList + ")", null);
  }
  
  public boolean hasUnackedSendOrSaveOperationsForConversation(long paramLong)
  {
    return 0L != DatabaseUtils.longForQuery(mDb, "SELECT COUNT(*) FROM operations WHERE ACTION IN ('messageSaved', 'messageSent') AND value2 = ?", new String[] { Long.toString(paramLong) });
  }
  
  public long incrementAndAddOperations(OperationInfo paramOperationInfo)
  {
    mDb.beginTransactionNonExclusive();
    ArrayList localArrayList;
    try
    {
      localArrayList = new ArrayList();
      Object localObject = new SQLiteQueryBuilder();
      ((SQLiteQueryBuilder)localObject).setTables("operations");
      localObject = ((SQLiteQueryBuilder)localObject).query(mDb, PROJECTION_PROVIDE_OPERATIONS, null, null, null, null, "_id");
      int i = ((Cursor)localObject).getColumnIndexOrThrow("_id");
      int j = ((Cursor)localObject).getColumnIndexOrThrow("action");
      int k = ((Cursor)localObject).getColumnIndexOrThrow("message_messageId");
      int m = ((Cursor)localObject).getColumnIndexOrThrow("value1");
      int n = ((Cursor)localObject).getColumnIndexOrThrow("value2");
      int i1 = ((Cursor)localObject).getColumnIndexOrThrow("numAttempts");
      int i2 = ((Cursor)localObject).getColumnIndexOrThrow("nextTimeToAttempt");
      int i3 = ((Cursor)localObject).getColumnIndexOrThrow("delay");
      while (((Cursor)localObject).moveToNext())
      {
        ((Cursor)localObject).getInt(i);
        String str = ((Cursor)localObject).getString(j);
        l1 = ((Cursor)localObject).getLong(k);
        int i4 = ((Cursor)localObject).getInt(i1);
        long l2 = ((Cursor)localObject).getLong(i2);
        int i5 = ((Cursor)localObject).getInt(i3);
        localArrayList.add(new OperationInfo(((Cursor)localObject).getLong(n), l1, str, ((Cursor)localObject).getLong(m), i4, i5, l2));
      }
      ((Cursor)localObject).close();
    }
    finally
    {
      mDb.endTransaction();
    }
    mDb.execSQL("DELETE FROM operations");
    long l1 = recordOperation(paramOperationInfo);
    paramOperationInfo = localArrayList.iterator();
    while (paramOperationInfo.hasNext()) {
      recordOperation((OperationInfo)paramOperationInfo.next());
    }
    mDb.setTransactionSuccessful();
    mDb.endTransaction();
    return l1;
  }
  
  public int nextOperationId()
  {
    try
    {
      long l = DatabaseUtils.longForQuery(mDb, "SELECT _id FROM operations LIMIT 1", null);
      return (int)l;
    }
    catch (SQLiteDoneException localSQLiteDoneException) {}
    return 0;
  }
  
  public void provideNormalOperations(MailStore.OperationSink paramOperationSink, MailEngine paramMailEngine, MailEngine.SyncInfo paramSyncInfo, long paramLong)
  {
    int i;
    Object localObject;
    int j;
    int k;
    int m;
    int n;
    int i1;
    int i2;
    int i3;
    if (Gservices.getInt(mContext.getContentResolver(), "gmail_discard_error_uphill_op_old_froyo", 0) != 0)
    {
      i = 1;
      if (i != 0) {
        checkForMessageToDiscard(paramMailEngine);
      }
      localObject = new SQLiteQueryBuilder();
      ((SQLiteQueryBuilder)localObject).setTables("operations");
      localObject = ((SQLiteQueryBuilder)localObject).query(mDb, PROJECTION_PROVIDE_OPERATIONS, null, null, null, null, "_id", "50");
      i = ((Cursor)localObject).getColumnIndexOrThrow("_id");
      j = ((Cursor)localObject).getColumnIndexOrThrow("action");
      k = ((Cursor)localObject).getColumnIndexOrThrow("message_messageId");
      m = ((Cursor)localObject).getColumnIndexOrThrow("value1");
      n = ((Cursor)localObject).getColumnIndexOrThrow("value2");
      i1 = ((Cursor)localObject).getColumnIndexOrThrow("numAttempts");
      i2 = ((Cursor)localObject).getColumnIndexOrThrow("nextTimeToAttempt");
      i3 = ((Cursor)localObject).getColumnIndexOrThrow("delay");
    }
    for (;;)
    {
      if (((Cursor)localObject).moveToNext())
      {
        long l1 = ((Cursor)localObject).getLong(i);
        String str = ((Cursor)localObject).getString(j);
        long l2 = ((Cursor)localObject).getLong(k);
        int i4 = ((Cursor)localObject).getInt(i1);
        long l3 = ((Cursor)localObject).getLong(i2);
        int i5 = ((Cursor)localObject).getInt(i3);
        long l4 = ((Cursor)localObject).getLong(n);
        long l5 = ((Cursor)localObject).getLong(m);
        if (calculateAndUpdateOpDelay(paramLong, l1, i4, i5, l3, new OperationInfo(l4, l2, str, l5), paramSyncInfo, paramMailEngine))
        {
          if ("messageLabelAdded".equals(str))
          {
            paramOperationSink.messageLabelAdded(l1, l2, l5);
            continue;
            i = 0;
            break;
          }
          if ("messageLabelRemoved".equals(str))
          {
            paramOperationSink.messageLabelRemoved(l1, l2, l5);
          }
          else if ("conversationLabelAdded".equals(str))
          {
            paramOperationSink.conversationLabelAddedOrRemoved(l1, l2, l5, true);
          }
          else if ("conversationLabelRemoved".equals(str))
          {
            paramOperationSink.conversationLabelAddedOrRemoved(l1, l2, l5, false);
          }
          else if (("messageSaved".equals(str)) || ("messageSent".equals(str)))
          {
            MailSync.Message localMessage = paramMailEngine.getMessage(l2, true);
            if (localMessage == null)
            {
              LogUtils.e("Gmail", "Cannot find message with id = %d for operations!", new Object[] { Long.valueOf(l2) });
              mDb.delete("operations", "_id == " + l1, null);
            }
            else
            {
              paramOperationSink.messageSavedOrSent(l1, localMessage, l2, refMessageId, "messageSaved".equals(str));
            }
          }
          else if ("messageExpunged".equals(str))
          {
            paramOperationSink.messageExpunged(l1, l2);
          }
          else
          {
            throw new RuntimeException("Unknown action: " + str);
          }
        }
      }
    }
    ((Cursor)localObject).close();
  }
  
  public void provideOperations(MailStore.OperationSink paramOperationSink, MailEngine paramMailEngine, MailEngine.SyncInfo paramSyncInfo, long paramLong)
  {
    Cursor localCursor = mDb.rawQuery("SELECT \n  _id,\n  action,\n  numAttempts,\n  nextTimeToAttempt,\n  delay\nFROM\n operations\nWHERE\n  message_messageId = ? AND value2 = ?\n", new String[] { Long.toString(messageId), Long.toString(conversationId) });
    int i = localCursor.getColumnIndexOrThrow("_id");
    int j = localCursor.getColumnIndexOrThrow("action");
    int k = localCursor.getColumnIndexOrThrow("numAttempts");
    int m = localCursor.getColumnIndexOrThrow("nextTimeToAttempt");
    int n = localCursor.getColumnIndexOrThrow("delay");
    while (localCursor.moveToNext())
    {
      long l1 = localCursor.getLong(i);
      Object localObject = localCursor.getString(j);
      int i1 = localCursor.getInt(k);
      long l2 = localCursor.getLong(m);
      int i2 = localCursor.getInt(n);
      OperationInfo localOperationInfo = new OperationInfo(conversationId, messageId, (String)localObject, 0L);
      if (!"messageSent".equals(localObject)) {}
      while (!calculateAndUpdateOpDelay(paramLong, l1, i1, i2, l2, localOperationInfo, paramSyncInfo, paramMailEngine)) {
        return;
      }
      localObject = paramMailEngine.getMessage(messageId, true);
      if (localObject == null)
      {
        LogUtils.e("Gmail", "Cannot find message with id = %d for operations!", new Object[] { Long.valueOf(messageId) });
        mDb.delete("operations", "_id == " + l1, null);
      }
      else
      {
        paramOperationSink.messageSavedOrSent(l1, (MailSync.Message)localObject, messageId, refMessageId, false);
      }
    }
    localCursor.close();
  }
  
  public long recordOperation(long paramLong1, long paramLong2, String paramString)
  {
    return recordOperation(paramLong1, paramLong2, paramString, 0L, 0, 0L);
  }
  
  public long recordOperation(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt, long paramLong4)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("action", paramString);
    localContentValues.put("message_messageId", Long.valueOf(paramLong2));
    localContentValues.put("value2", Long.valueOf(paramLong1));
    if ((paramLong3 > 0L) && (paramLong4 > 0L))
    {
      localContentValues.put("numAttempts", Long.valueOf(paramLong3));
      localContentValues.put("nextTimeToAttempt", Long.valueOf(paramLong4));
      localContentValues.put("delay", Integer.valueOf(paramInt));
    }
    return mDb.insert("operations", null, localContentValues);
  }
  
  public long recordOperation(OperationInfo paramOperationInfo)
  {
    if (doesLabelMatter(mAction)) {
      return recordOperationWithLabelId(mConversationId, mMessageId, mAction, mLabelId, mNumAttempts, mDelay, mNextTimeToAttempt);
    }
    return recordOperation(mConversationId, mMessageId, mAction, mNumAttempts, mDelay, mNextTimeToAttempt);
  }
  
  public long recordOperationWithLabelId(long paramLong1, long paramLong2, String paramString, long paramLong3)
  {
    return recordOperationWithLabelId(paramLong1, paramLong2, paramString, paramLong3, 0L, 0, 0L);
  }
  
  public long recordOperationWithLabelId(long paramLong1, long paramLong2, String paramString, long paramLong3, long paramLong4, int paramInt, long paramLong5)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("action", paramString);
    localContentValues.put("message_messageId", Long.valueOf(paramLong2));
    localContentValues.put("value1", Long.valueOf(paramLong3));
    localContentValues.put("value2", Long.valueOf(paramLong1));
    if ((paramLong4 > 0L) && (paramLong5 > 0L))
    {
      localContentValues.put("numAttempts", Long.valueOf(paramLong4));
      localContentValues.put("nextTimeToAttempt", Long.valueOf(paramLong5));
      localContentValues.put("delay", Integer.valueOf(paramInt));
    }
    return mDb.insert("operations", null, localContentValues);
  }
  
  public void updateMessageId(long paramLong1, long paramLong2)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("message_messageId", Long.valueOf(paramLong2));
    mDb.update("operations", localContentValues, "message_messageId = " + paramLong1, null);
  }
  
  public static class OperationInfo
  {
    public String mAction;
    public long mConversationId;
    public int mDelay;
    public long mLabelId;
    public long mMessageId;
    public long mNextTimeToAttempt;
    public int mNumAttempts;
    
    public OperationInfo(long paramLong1, long paramLong2, String paramString, long paramLong3)
    {
      this(paramLong1, paramLong2, paramString, paramLong3, 0, 0, 0L);
    }
    
    public OperationInfo(long paramLong1, long paramLong2, String paramString, long paramLong3, int paramInt1, int paramInt2, long paramLong4)
    {
      mConversationId = paramLong1;
      mMessageId = paramLong2;
      mAction = paramString;
      mLabelId = paramLong3;
      mNumAttempts = paramInt1;
      mDelay = paramInt2;
      mNextTimeToAttempt = paramLong4;
    }
  }
  
  public static enum RecordHistory
  {
    FALSE,  TRUE;
    
    private RecordHistory() {}
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.Operations
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */