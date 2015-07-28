package com.google.android.gm.provider;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.TimingLogger;
import com.google.common.collect.Sets;
import java.util.Map;
import java.util.Set;

public class SyncedConversationHandler
  extends ConversationHandler
{
  protected SyncedConversationHandler(SQLiteDatabase paramSQLiteDatabase, MailCore paramMailCore)
  {
    super(paramSQLiteDatabase, paramMailCore);
  }
  
  protected boolean onConversationChangedImpl(long paramLong1, MailSync.SyncRationale paramSyncRationale, String paramString, Map<Long, LabelRecord> paramMap1, long paramLong2, Map<Long, LabelRecord> paramMap2, boolean paramBoolean, TimingLogger paramTimingLogger)
  {
    String str1 = Long.toString(paramLong1);
    long l1 = Long.MIN_VALUE;
    int k = Integer.MIN_VALUE;
    Object localObject6 = null;
    Object localObject4 = null;
    paramString = null;
    Object localObject1 = null;
    int j = 0;
    int i = 0;
    Object localObject2 = MailSync.SyncRationale.NONE;
    long l2 = 0L;
    Cursor localCursor = mDb.rawQuery("SELECT \n  messageId,\n  fromAddress,\n  group_concat(labels_id, ' '),\n  subject,\n  snippet,\n  personalLevel,\n  length(joinedAttachmentInfos) > 0 as hasAttachments,\n  dateReceivedMs,\n  error\nFROM\n  messages LEFT OUTER JOIN   message_labels ON messageId = message_messageId\nWHERE\n  synced = 1 AND conversation = ?\nGROUP BY messageId\nORDER BY messageId", new String[] { str1 });
    paramTimingLogger.addSplit("fetch messages");
    for (;;)
    {
      CompactSenderInstructions localCompactSenderInstructions;
      long l5;
      long l6;
      long l7;
      int n;
      int i1;
      int m;
      long l3;
      boolean bool2;
      boolean bool1;
      Object localObject3;
      label284:
      long l12;
      boolean bool5;
      try
      {
        localCompactSenderInstructions = new CompactSenderInstructions();
        long l4 = mLabelMap.getLabelIdDraft();
        l5 = mLabelMap.getLabelIdUnread();
        l6 = mLabelMap.getLabelIdSent();
        l7 = mLabelMap.getLabelIdOutbox();
        long l8 = mLabelMap.getLabelIdSpam();
        long l9 = mLabelMap.getLabelIdTrash();
        if (!localCursor.moveToNext()) {
          break label775;
        }
        long l10 = localCursor.getLong(0);
        str2 = localCursor.getString(1);
        long l11 = localCursor.getLong(7);
        localObject1 = localCursor.getString(2);
        if (localObject1 != null)
        {
          localObject5 = TextUtils.split((String)localObject1, Gmail.SPACE_SEPARATOR_PATTERN);
          n = 0;
          i1 = localObject5.length;
          m = 0;
          if (m < i1)
          {
            l3 = Long.valueOf(localObject5[m]).longValue();
            if (l8 == l3) {
              break label1119;
            }
            if (l9 != l3) {
              break label1122;
            }
            break label1119;
          }
        }
        else
        {
          localObject5 = new String[0];
          continue;
        }
        bool2 = false;
        bool1 = false;
        paramBoolean = false;
        m = 0;
        int i2 = localObject5.length;
        i1 = 0;
        localObject3 = localObject2;
        localObject1 = localObject6;
        if (i1 < i2)
        {
          l12 = Long.valueOf(localObject5[i1]).longValue();
          if (l4 != l12) {
            break label1164;
          }
          bool3 = true;
          bool5 = paramBoolean;
          bool4 = bool1;
          label323:
          if (!paramMap2.containsKey(Long.valueOf(l12)))
          {
            localObject2 = new LabelRecord();
            paramMap2.put(Long.valueOf(l12), localObject2);
            sortMessageId = Math.max(sortMessageId, l10);
            dateReceived = Math.max(dateReceived, l11);
            if (n == 0) {
              isZombie = false;
            }
            localObject6 = (Boolean)mMailCore.mLabelIdsIncludedOrPartial.get(Long.valueOf(l12));
            localObject2 = localObject3;
            l3 = l2;
            if (n == 0)
            {
              localObject2 = localObject3;
              l3 = l2;
              if (localObject6 != null)
              {
                localObject2 = localObject3;
                l3 = l2;
                if (paramSyncRationale != MailSync.SyncRationale.NONE)
                {
                  if (!((Boolean)localObject6).booleanValue()) {
                    continue;
                  }
                  localObject2 = MailSync.SyncRationale.LABEL;
                  l3 = l2;
                }
              }
            }
            localObject3 = localObject1;
            if (l10 <= paramLong2) {
              break label1131;
            }
            localObject3 = localObject1;
            if (localObject1 == null) {
              localObject3 = Sets.newHashSet();
            }
            ((Set)localObject3).add(Long.valueOf(l12));
            break label1131;
          }
          else
          {
            localObject2 = (LabelRecord)paramMap2.get(Long.valueOf(l12));
            continue;
          }
          localObject2 = localObject3;
          l3 = l2;
          if (localObject3 == MailSync.SyncRationale.LABEL) {
            continue;
          }
          localObject2 = MailSync.SyncRationale.DURATION;
          l3 = Math.max(l2, l10);
          continue;
        }
        localObject5 = localObject4;
        if (localObject4 == null) {
          localObject5 = localCursor.getString(3);
        }
        localObject4 = localCursor.getString(4);
        localObject7 = paramString;
        if (paramString == null)
        {
          localObject7 = paramString;
          if (bool1) {
            localObject7 = localObject4;
          }
        }
        n = Math.max(k, localCursor.getInt(5));
        l1 = Math.max(l1, l10);
        if (localCursor.getInt(6) == 0) {
          break label751;
        }
        k = 1;
        k = j | k;
        if (localCursor.getInt(8) == 0) {
          break label757;
        }
        j = 1;
      }
      finally
      {
        String str2;
        Object localObject5;
        Object localObject7;
        label693:
        localCursor.close();
      }
      localCompactSenderInstructions.addMessage(str2, bool2, bool1, paramBoolean, bool3, bool4);
      localObject6 = localObject1;
      localObject2 = localObject3;
      j = k;
      localObject1 = localObject4;
      k = n;
      localObject4 = localObject5;
      paramString = (String)localObject7;
      continue;
      label751:
      k = 0;
      continue;
      label757:
      j = 0;
      label763:
      for (boolean bool3 = false; (m == 0) || (j == 0); bool3 = true)
      {
        bool4 = false;
        break label693;
        label775:
        if ((l2 != 0L) && ((paramSyncRationale == MailSync.SyncRationale.DURATION) || (paramSyncRationale == MailSync.SyncRationale.LABEL)) && (paramSyncRationale != localObject2)) {
          LogUtils.w("Gmail", "Server sent rational %s but we calculated %s with messageId %d", new Object[] { paramSyncRationale, localObject2, Long.valueOf(l2) });
        }
        localObject3 = localCompactSenderInstructions.toInstructionString(5);
        m = localCursor.getCount();
        localCursor.close();
        paramTimingLogger.addSplit("process messages");
        updateLabelInfo(paramLong1, paramSyncRationale, paramMap1, paramMap2, l1, (Set)localObject6);
        paramTimingLogger.addSplit("process labels");
        if (m == 0)
        {
          mDb.delete("conversations", "_id = ? AND queryId = 0", new String[] { str1 });
          return true;
        }
        paramSyncRationale = new ContentValues();
        paramSyncRationale.put("_id", Long.valueOf(paramLong1));
        paramSyncRationale.put("queryId", Integer.valueOf(0));
        paramSyncRationale.put("fromAddress", (String)localObject3);
        paramSyncRationale.put("subject", (String)localObject4);
        if (paramString != null)
        {
          paramSyncRationale.put("snippet", paramString);
          paramSyncRationale.put("personalLevel", Integer.valueOf(k));
          paramSyncRationale.put("numMessages", Integer.valueOf(m));
          paramSyncRationale.put("maxMessageId", Long.valueOf(l1));
          paramSyncRationale.put("labelIds", Gmail.getLabelIdsStringFromLabelIds(paramMap2.keySet()));
          if (j == 0) {
            break label1107;
          }
          j = 1;
          label1030:
          paramSyncRationale.put("hasAttachments", Integer.valueOf(j));
          if (i == 0) {
            break label1113;
          }
        }
        label1107:
        label1113:
        for (i = 1;; i = 0)
        {
          paramSyncRationale.put("hasMessagesWithErrors", Integer.valueOf(i));
          paramSyncRationale.put("syncRationale", ((MailSync.SyncRationale)localObject2).toString());
          paramSyncRationale.put("syncRationaleMessageId", Long.valueOf(l2));
          mDb.replace("conversations", null, paramSyncRationale);
          return false;
          paramString = (String)localObject1;
          break;
          j = 0;
          break label1030;
        }
        label1119:
        n = 1;
        label1122:
        m += 1;
        break;
        label1131:
        i1 += 1;
        bool2 = bool3;
        bool1 = bool4;
        paramBoolean = bool5;
        localObject1 = localObject3;
        localObject3 = localObject2;
        l2 = l3;
        break label284;
        label1164:
        if (l5 == l12)
        {
          bool4 = true;
          bool3 = bool2;
          bool5 = paramBoolean;
          break label323;
        }
        if (l6 == l12)
        {
          bool5 = true;
          bool3 = bool2;
          bool4 = bool1;
          break label323;
        }
        bool3 = bool2;
        bool4 = bool1;
        bool5 = paramBoolean;
        if (l7 != l12) {
          break label323;
        }
        m = 1;
        bool3 = bool2;
        bool4 = bool1;
        bool5 = paramBoolean;
        break label323;
        i |= j;
        if ((m == 0) || (j != 0)) {
          break label763;
        }
      }
      boolean bool4 = true;
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.SyncedConversationHandler
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */