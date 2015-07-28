package com.google.android.gm.provider;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.TimingLogger;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ConversationUtil
{
  private final SQLiteDatabase mDb;
  private final MailCore mMailCore;
  
  protected ConversationUtil(SQLiteDatabase paramSQLiteDatabase, MailCore paramMailCore)
  {
    mDb = paramSQLiteDatabase;
    mMailCore = paramMailCore;
  }
  
  private void onConversationChanged(long paramLong1, long paramLong2, MailSync.SyncRationale paramSyncRationale, boolean paramBoolean)
  {
    TimingLogger localTimingLogger = new TimingLogger("Gmail", "onConversationChanged");
    for (;;)
    {
      try
      {
        Object localObject2 = Long.toString(paramLong1);
        String str = Long.toString(paramLong2);
        Map localMap = fetchOldConversationLabels(paramLong1, paramLong2);
        localTimingLogger.addSplit("fetch old labels");
        long l = 0L;
        Object localObject1 = mDb.rawQuery("SELECT maxMessageId FROM conversations WHERE _id = ? AND queryId = ?", new String[] { localObject2, str });
        try
        {
          if (((Cursor)localObject1).moveToNext()) {
            l = ((Cursor)localObject1).getLong(0);
          }
          ((Cursor)localObject1).close();
          localTimingLogger.addSplit("read old conversation");
          mDb.delete("conversation_labels", "queryId = ? AND conversation_id = ?", new String[] { str, localObject2 });
          localTimingLogger.addSplit("delete old labels");
          localObject2 = Maps.newHashMap();
          if (paramLong2 == 0L)
          {
            localObject1 = new SyncedConversationHandler(mDb, mMailCore);
            ((ConversationHandler)localObject1).onConversationChanged(paramLong1, paramSyncRationale, paramLong2, localMap, l, (Map)localObject2, paramBoolean, localTimingLogger);
            LogUtils.v("Gmail", "updated tables for conversation %d", new Object[] { Long.valueOf(paramLong1) });
            localTimingLogger.addSplit("finish");
            localTimingLogger.dumpToLog();
            return;
          }
        }
        finally
        {
          ((Cursor)localObject1).close();
        }
        localObject1 = new LiveConversationHandler(mDb, mMailCore);
      }
      finally
      {
        LogUtils.v("Gmail", "updated tables for conversation %d", new Object[] { Long.valueOf(paramLong1) });
        localTimingLogger.addSplit("finish");
        localTimingLogger.dumpToLog();
      }
    }
  }
  
  public Map<Long, LabelRecord> fetchOldConversationLabels(long paramLong1, long paramLong2)
  {
    HashMap localHashMap = Maps.newHashMap();
    Object localObject = mDb;
    String str1 = Long.toString(paramLong2);
    String str2 = Long.toString(paramLong1);
    localObject = ((SQLiteDatabase)localObject).query("conversation_labels AS cl JOIN labels AS l ON cl.labels_id = l._id", new String[] { "labels_id", "isZombie", "sortMessageId", "date" }, "queryId = ? AND conversation_id = ? AND canonicalName NOT LIKE '^^unseen-%'", new String[] { str1, str2 }, null, null, null);
    for (;;)
    {
      try
      {
        if (!((Cursor)localObject).moveToNext()) {
          break;
        }
        paramLong1 = ((Cursor)localObject).getLong(0);
        boolean bool;
        if (((Cursor)localObject).getInt(1) != 0)
        {
          bool = true;
          localHashMap.put(Long.valueOf(paramLong1), new LabelRecord(((Cursor)localObject).getLong(2), ((Cursor)localObject).getLong(3), bool));
        }
        else
        {
          bool = false;
        }
      }
      finally
      {
        ((Cursor)localObject).close();
      }
    }
    ((Cursor)localObject).close();
    return localMap;
  }
  
  void onConversationChanged(long paramLong, MailSync.SyncRationale paramSyncRationale)
  {
    onConversationChanged(paramLong, paramSyncRationale, false, false);
  }
  
  void onConversationChanged(long paramLong, MailSync.SyncRationale paramSyncRationale, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!mDb.inTransaction()) {
      throw new IllegalStateException("Must be in transaction");
    }
    LogUtils.v("Gmail", "updateConversationTables: conversationId %d", new Object[] { Long.valueOf(paramLong) });
    Object localObject = mDb.query("conversation_labels", new String[] { "queryId" }, "conversation_id = ?", new String[] { String.valueOf(paramLong) }, "queryId", null, null);
    HashSet localHashSet = Sets.newHashSet();
    try
    {
      while (((Cursor)localObject).moveToNext()) {
        localHashSet.add(Long.valueOf(((Cursor)localObject).getLong(0)));
      }
      if (!paramBoolean1) {
        break label147;
      }
    }
    finally
    {
      ((Cursor)localObject).close();
    }
    localHashSet.add(Long.valueOf(0L));
    label147:
    localObject = localHashSet.iterator();
    while (((Iterator)localObject).hasNext()) {
      onConversationChanged(paramLong, ((Long)((Iterator)localObject).next()).longValue(), paramSyncRationale, paramBoolean2);
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ConversationUtil
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */