package com.google.android.gm.provider;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.TimingLogger;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class LiveConversationHandler
  extends ConversationHandler
{
  protected LiveConversationHandler(SQLiteDatabase paramSQLiteDatabase, MailCore paramMailCore)
  {
    super(paramSQLiteDatabase, paramMailCore);
  }
  
  private List<MessageLabelRecord> getMessageLabelRecordsFromConversationTable(String paramString1, String paramString2)
  {
    ArrayList localArrayList = Lists.newArrayList();
    paramString1 = mDb.rawQuery("SELECT   labelIds, \n  maxMessageId FROM   conversations WHERE   _id = ? AND queryId = ?", new String[] { paramString2, paramString1 });
    try
    {
      if (paramString1.moveToNext()) {
        localArrayList.add(new MessageLabelRecord(paramString1.getString(0), Long.valueOf(paramString1.getLong(1))));
      }
      return localArrayList;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  private List<MessageLabelRecord> getMessageLabelRecordsFromLiveMessageTable(String paramString)
  {
    paramString = mDb.rawQuery("SELECT \n  messageId,\n  group_concat(labels_id, ','),\n  dateReceivedMs \nFROM\n  messages LEFT OUTER JOIN   message_labels ON messageId = message_messageId\nWHERE\n  synced = 0 AND conversation = ?\nGROUP BY messageId\nORDER BY messageId", new String[] { paramString });
    try
    {
      int i = paramString.getCount();
      if (i == 0) {
        return null;
      }
      ArrayList localArrayList = Lists.newArrayList();
      while (paramString.moveToNext())
      {
        long l = paramString.getLong(0);
        localArrayList.add(new MessageLabelRecord(paramString.getString(1), l, paramString.getLong(2)));
      }
    }
    finally
    {
      paramString.close();
    }
    return localList;
  }
  
  protected boolean onConversationChangedImpl(long paramLong1, MailSync.SyncRationale paramSyncRationale, String paramString, Map<Long, LabelRecord> paramMap1, long paramLong2, Map<Long, LabelRecord> paramMap2, boolean paramBoolean, TimingLogger paramTimingLogger)
  {
    Object localObject3 = Long.toString(paramLong1);
    paramLong2 = Long.MIN_VALUE;
    Object localObject1 = paramMap1.values().iterator();
    while (((Iterator)localObject1).hasNext()) {
      paramLong2 = Math.max(paramLong2, nextdateReceived);
    }
    localObject1 = null;
    if (paramBoolean) {
      localObject1 = getMessageLabelRecordsFromLiveMessageTable((String)localObject3);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = getMessageLabelRecordsFromConversationTable(paramString, (String)localObject3);
    }
    long l3 = mLabelMap.getLabelIdSpam();
    long l4 = mLabelMap.getLabelIdTrash();
    long l1 = Long.MIN_VALUE;
    localObject1 = ((List)localObject2).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (MessageLabelRecord)((Iterator)localObject1).next();
      long l2 = ((MessageLabelRecord)localObject2).getMessageId();
      paramString = ((MessageLabelRecord)localObject2).getLabelIds();
      localObject3 = Lists.newArrayList();
      int k = 0;
      int j = 0;
      int i1 = paramString.length;
      int i = 0;
      Object localObject4;
      if (i < i1)
      {
        localObject4 = paramString[i];
        int m = k;
        int n = j;
        if (!TextUtils.isEmpty((CharSequence)localObject4))
        {
          l1 = Long.valueOf((String)localObject4).longValue();
          ((List)localObject3).add(Long.valueOf(l1));
          if (l3 != l1) {
            break label265;
          }
          n = 1;
          m = k;
        }
        for (;;)
        {
          i += 1;
          k = m;
          j = n;
          break;
          label265:
          m = k;
          n = j;
          if (l4 == l1)
          {
            m = 1;
            n = j;
          }
        }
      }
      localObject3 = ((List)localObject3).iterator();
      l1 = l2;
      if (((Iterator)localObject3).hasNext())
      {
        localObject4 = (Long)((Iterator)localObject3).next();
        label359:
        Object localObject5;
        if (!paramMap2.containsKey(localObject4))
        {
          paramString = new LabelRecord();
          paramMap2.put(localObject4, paramString);
          sortMessageId = Math.max(sortMessageId, l2);
          localObject5 = (LabelRecord)paramMap1.get(localObject4);
          if (localObject5 != null) {
            sortMessageId = Math.max(sortMessageId, sortMessageId);
          }
          localObject5 = ((MessageLabelRecord)localObject2).getDateReceived();
          if (localObject5 == null) {
            break label500;
          }
        }
        label500:
        for (l1 = ((Long)localObject5).longValue();; l1 = paramLong2)
        {
          dateReceived = l1;
          if (((j != 0) || (k != 0)) && ((((Long)localObject4).longValue() != l3) || (k != 0)) && (((Long)localObject4).longValue() != l4)) {
            break;
          }
          isZombie = false;
          break;
          paramString = (LabelRecord)paramMap2.get(localObject4);
          break label359;
        }
      }
    }
    updateLabelInfo(paramLong1, paramSyncRationale, paramMap1, paramMap2, l1, null);
    paramTimingLogger.addSplit("process labels");
    return false;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.LiveConversationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */