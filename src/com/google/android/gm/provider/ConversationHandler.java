package com.google.android.gm.provider;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.TimingLogger;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class ConversationHandler
{
  protected final SQLiteDatabase mDb;
  protected final Gmail.LabelMap mLabelMap;
  protected final MailCore mMailCore;
  
  static
  {
    if (!ConversationHandler.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  protected ConversationHandler(SQLiteDatabase paramSQLiteDatabase, MailCore paramMailCore)
  {
    mDb = paramSQLiteDatabase;
    mMailCore = paramMailCore;
    mLabelMap = mMailCore.getLabelMap();
  }
  
  private static void calculateSetIntersectionAndDifferences(Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3, Set<Long> paramSet4, Set<Long> paramSet5)
  {
    if (paramSet3 != null)
    {
      assert (paramSet3.size() == 0);
      paramSet3.addAll(paramSet1);
      paramSet3.removeAll(paramSet2);
    }
    if (paramSet4 != null)
    {
      assert (paramSet4.size() == 0);
      paramSet4.addAll(paramSet2);
      paramSet4.removeAll(paramSet1);
    }
    if (paramSet5 != null)
    {
      assert (paramSet5.size() == 0);
      paramSet5.addAll(paramSet1);
      paramSet5.retainAll(paramSet2);
    }
  }
  
  private void updateLabelCounts(MailSync.SyncRationale paramSyncRationale, Map<Long, LabelRecord> paramMap1, Map<Long, LabelRecord> paramMap2, Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3)
  {
    long l1 = mLabelMap.getLabelIdUnread();
    Object localObject;
    if (paramMap1.containsKey(Long.valueOf(l1)) != paramMap2.containsKey(Long.valueOf(l1)))
    {
      localObject = paramMap1.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramSet1.add((Long)((Iterator)localObject).next());
      }
      localObject = paramMap2.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        paramSet2.add((Long)((Iterator)localObject).next());
      }
    }
    paramSet3 = paramSet3.iterator();
    while (paramSet3.hasNext())
    {
      long l2 = ((Long)paramSet3.next()).longValue();
      bool1 = getvalueOfisZombie;
      boolean bool2 = getvalueOfisZombie;
      if ((!bool1) && (bool2)) {
        paramSet1.add(Long.valueOf(l2));
      }
      if ((bool1) && (!bool2)) {
        paramSet2.add(Long.valueOf(l2));
      }
    }
    paramSet3 = Sets.newHashSet();
    boolean bool1 = paramMap1.containsKey(Long.valueOf(l1));
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext())
    {
      localObject = (Long)paramSet1.next();
      if ((l1 != ((Long)localObject).longValue()) && ((paramSyncRationale == MailSync.SyncRationale.LOCAL_CHANGE) || (MailCore.isLabelIdLocal(((Long)localObject).longValue()))) && ((!paramMap1.containsKey(localObject)) || (!getisZombie)))
      {
        if (bool1)
        {
          mDb.execSQL("UPDATE labels SET\n  numConversations = max(numConversations - 1, 0),\n  numUnreadConversations =     max(numUnreadConversations - 1, 0)\nWHERE _id = ?", new String[] { Long.toString(((Long)localObject).longValue()) });
          LogUtils.v("Gmail", "onConversationChanged decreased total and unread, label %d", new Object[] { localObject });
        }
        for (;;)
        {
          paramSet3.add(localObject);
          break;
          mDb.execSQL("UPDATE labels SET\n  numConversations = max(numConversations - 1, 0)\nWHERE _id = ?", new String[] { Long.toString(((Long)localObject).longValue()) });
          LogUtils.v("Gmail", "onConversationChanged decreased total, label %d", new Object[] { localObject });
        }
      }
    }
    bool1 = paramMap2.containsKey(Long.valueOf(l1));
    paramMap1 = paramSet2.iterator();
    while (paramMap1.hasNext())
    {
      paramSet1 = (Long)paramMap1.next();
      if ((l1 != paramSet1.longValue()) && ((paramSyncRationale == MailSync.SyncRationale.LOCAL_CHANGE) || (MailCore.isLabelIdLocal(paramSet1.longValue()))) && ((!paramMap2.containsKey(paramSet1)) || (!getisZombie)))
      {
        if (bool1)
        {
          mDb.execSQL("UPDATE labels SET\n  numConversations = numConversations + 1,\n  numUnreadConversations = numUnreadConversations + 1\nWHERE _id = ?", new String[] { Long.toString(paramSet1.longValue()) });
          LogUtils.v("Gmail", "onConversationChanged increased total and unread, label %d", new Object[] { paramSet1 });
        }
        for (;;)
        {
          paramSet3.add(paramSet1);
          break;
          mDb.execSQL("UPDATE labels SET\n  numConversations = numConversations + 1\nWHERE _id = ?", new String[] { Long.toString(paramSet1.longValue()) });
          LogUtils.v("Gmail", "onConversationChanged increased total, label %d", new Object[] { paramSet1 });
        }
      }
    }
    if (paramSet3.size() > 0)
    {
      mLabelMap.requery();
      mMailCore.mListener.onLabelsUpdated(paramSet3);
    }
  }
  
  private void updateLabels(long paramLong1, long paramLong2, Set<Long> paramSet1, Map<Long, LabelRecord> paramMap, Set<Long> paramSet2, Set<Long> paramSet3, Set<Long> paramSet4, Set<Long> paramSet5, MailSync.SyncRationale paramSyncRationale)
  {
    Iterator localIterator = mMailCore.mNotificationRequests.iterator();
    while (localIterator.hasNext())
    {
      MailCore.NotificationRequest localNotificationRequest = (MailCore.NotificationRequest)localIterator.next();
      long l = localNotificationRequest.getTagLabelId();
      boolean bool1 = localNotificationRequest.conversationMatches(paramMap.keySet());
      if (bool1 != paramMap.containsKey(Long.valueOf(l)))
      {
        boolean bool2;
        if ((bool1) && (paramSyncRationale != MailSync.SyncRationale.LOCAL_CHANGE))
        {
          bool2 = localNotificationRequest.conversationMatches(paramSet1);
          if ((paramSet2 == null) || (!localNotificationRequest.conversationMatches(paramSet2))) {
            break label286;
          }
        }
        label286:
        for (int i = 1;; i = 0)
        {
          if ((!bool2) && (i != 0))
          {
            LabelRecord localLabelRecord = (LabelRecord)paramMap.get(Long.valueOf(localNotificationRequest.getLabelId()));
            if (localLabelRecord != null) {
              updateLabelsAddLabel(l, paramLong2, paramMap, paramSet3, paramSet4, paramSet5, localLabelRecord, Operations.RecordHistory.FALSE);
            }
            mMailCore.mListener.onConversationNewlyMatchesNotificationRequest(localNotificationRequest);
            LogUtils.v("Gmail", "onConversationChanged %d added tag label %d for label %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l), Long.valueOf(localNotificationRequest.getLabelId()) });
          }
          if (bool1) {
            break;
          }
          updateLabelsRemoveLabel(l, paramLong1, paramLong2, paramMap, paramSet3, paramSet4, paramSet5, Operations.RecordHistory.FALSE);
          LogUtils.v("Gmail", "onConversationChanged %d removed tag label %d for label %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l), Long.valueOf(localNotificationRequest.getLabelId()) });
          break;
        }
      }
    }
  }
  
  private void updateLabelsAddLabel(long paramLong1, long paramLong2, Map<Long, LabelRecord> paramMap, Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3, LabelRecord paramLabelRecord, Operations.RecordHistory paramRecordHistory)
  {
    mMailCore.setLabelOnMessage(paramLong2, mMailCore.getLabelOrThrow(paramLong1), true, paramRecordHistory);
    paramMap.put(Long.valueOf(paramLong1), paramLabelRecord);
    paramSet1.remove(Long.valueOf(paramLong1));
    paramSet2.add(Long.valueOf(paramLong1));
    paramSet3.remove(Long.valueOf(paramLong1));
  }
  
  private void updateLabelsRemoveLabel(long paramLong1, long paramLong2, long paramLong3, Map<Long, LabelRecord> paramMap, Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3, Operations.RecordHistory paramRecordHistory)
  {
    mMailCore.setLabelOnConversation(paramLong2, paramLong3, mMailCore.getLabelOrThrow(paramLong1), false, paramRecordHistory);
    paramMap.remove(Long.valueOf(paramLong1));
    paramSet1.add(Long.valueOf(paramLong1));
    paramSet2.remove(Long.valueOf(paramLong1));
    paramSet3.remove(Long.valueOf(paramLong1));
  }
  
  public void insertConversationLabels(long paramLong1, long paramLong2, Map<Long, LabelRecord> paramMap)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("queryId", Long.valueOf(paramLong2));
    localContentValues.put("conversation_id", Long.valueOf(paramLong1));
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      paramLong1 = ((Long)((Map.Entry)localObject).getKey()).longValue();
      localObject = (LabelRecord)((Map.Entry)localObject).getValue();
      localContentValues.put("labels_id", Long.valueOf(paramLong1));
      localContentValues.put("isZombie", Boolean.valueOf(isZombie));
      localContentValues.put("sortMessageId", Long.valueOf(sortMessageId));
      localContentValues.put("date", Long.valueOf(dateReceived));
      mDb.replace("conversation_labels", null, localContentValues);
    }
  }
  
  final void onConversationChanged(long paramLong1, MailSync.SyncRationale paramSyncRationale, long paramLong2, Map<Long, LabelRecord> paramMap1, long paramLong3, Map<Long, LabelRecord> paramMap2, boolean paramBoolean, TimingLogger paramTimingLogger)
  {
    paramBoolean = onConversationChangedImpl(paramLong1, paramSyncRationale, Long.toString(paramLong2), paramMap1, paramLong3, paramMap2, paramBoolean, paramTimingLogger);
    paramTimingLogger.addSplit("process messages");
    if (!paramBoolean)
    {
      insertConversationLabels(paramLong1, paramLong2, paramMap2);
      paramTimingLogger.addSplit("write labels");
    }
  }
  
  protected abstract boolean onConversationChangedImpl(long paramLong1, MailSync.SyncRationale paramSyncRationale, String paramString, Map<Long, LabelRecord> paramMap1, long paramLong2, Map<Long, LabelRecord> paramMap2, boolean paramBoolean, TimingLogger paramTimingLogger);
  
  public void updateLabelInfo(long paramLong1, MailSync.SyncRationale paramSyncRationale, Map<Long, LabelRecord> paramMap1, Map<Long, LabelRecord> paramMap2, long paramLong2, Set<Long> paramSet)
  {
    HashSet localHashSet1 = Sets.newHashSet();
    HashSet localHashSet2 = Sets.newHashSet();
    HashSet localHashSet3 = Sets.newHashSet();
    calculateSetIntersectionAndDifferences(paramMap1.keySet(), paramMap2.keySet(), localHashSet1, localHashSet2, localHashSet3);
    LogUtils.v("Gmail", "onConversationChanged %d removedLabels (%s), addedLabels (%s), keptLabels (%s)", new Object[] { Long.valueOf(paramLong1), localHashSet1, localHashSet2, localHashSet3 });
    updateLabels(paramLong1, paramLong2, paramMap1.keySet(), paramMap2, paramSet, localHashSet1, localHashSet2, localHashSet3, paramSyncRationale);
    LogUtils.v("Gmail", "onConversationChanged after updateLabels %d removedLabels (%s), addedLabels (%s), keptLabels (%s)", new Object[] { Long.valueOf(paramLong1), localHashSet1, localHashSet2, localHashSet3 });
    updateLabelCounts(paramSyncRationale, paramMap1, paramMap2, localHashSet1, localHashSet2, localHashSet3);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.ConversationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */