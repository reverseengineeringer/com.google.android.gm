import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.TimingLogger;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dux
  extends dps
{
  private static final String d = cvl.a;
  
  protected dux(SQLiteDatabase paramSQLiteDatabase, drj paramdrj)
  {
    super(paramSQLiteDatabase, paramdrj);
  }
  
  protected final boolean a(long paramLong1, int paramInt, String paramString, Map<Long, drg> paramMap1, long paramLong2, Map<Long, drg> paramMap2, boolean paramBoolean, dpt paramdpt, TimingLogger paramTimingLogger)
  {
    String str3 = Long.toString(paramLong1);
    Object localObject6 = null;
    Object localObject4 = null;
    Object localObject2 = null;
    paramString = null;
    String str1 = null;
    int k = 2;
    long l1 = 0L;
    Cursor localCursor = a.rawQuery("SELECT \n  messageId,\n  fromAddress,\n  group_concat(labels_id, ' ') AS labelIds,\n  subject,\n  snippet,\n  personalLevel,\n  joinedAttachmentInfos,\n  dateReceivedMs,\n  error,\n  permalink,\n  unsubscribeSenderName,\n  unsubscribeSenderIdentifier,\n  hasEvent\nFROM\n  messages\nLEFT OUTER JOIN message_labels   ON messageId = message_messageId\nWHERE\n  synced = 1 AND conversation = ?\nGROUP BY messageId\nORDER BY messageId", new String[] { str3 });
    paramTimingLogger.addSplit("fetch messages");
    dpo localdpo = new dpo();
    long l4;
    long l5;
    long l6;
    long l9;
    int n;
    Object localObject1;
    int i1;
    int i2;
    Object localObject3;
    int i3;
    long l2;
    Object localObject7;
    int m;
    int i4;
    int j;
    long l12;
    boolean bool1;
    int i;
    int i5;
    label333:
    label368:
    Object localObject5;
    try
    {
      long l3 = c.f();
      l4 = c.g();
      l5 = c.d();
      l6 = c.m();
      long l7 = c.i();
      long l8 = c.h();
      l9 = c.q();
      n = 0;
      localObject1 = null;
      i1 = 0;
      i2 = 0;
      localObject3 = null;
      i3 = Integer.MIN_VALUE;
      l2 = Long.MIN_VALUE;
      if (!localCursor.moveToNext()) {
        break label1752;
      }
      long l10 = localCursor.getLong(localCursor.getColumnIndexOrThrow("messageId"));
      localObject7 = localCursor.getString(localCursor.getColumnIndexOrThrow("fromAddress"));
      long l11 = localCursor.getLong(localCursor.getColumnIndexOrThrow("dateReceivedMs"));
      paramString = localCursor.getString(localCursor.getColumnIndexOrThrow("labelIds"));
      if (paramString != null) {}
      for (localObject3 = TextUtils.split(paramString, dpy.d);; localObject3 = new String[0])
      {
        m = 0;
        i4 = localObject3.length;
        j = 0;
        if (j >= i4) {
          break;
        }
        l12 = Long.valueOf(localObject3[j]).longValue();
        if (l7 == l12) {
          break label1514;
        }
        if (l8 != l12) {
          break label1500;
        }
        break label1514;
      }
      paramBoolean = false;
      bool1 = false;
      j = 0;
      i = 0;
      i4 = 0;
      i6 = localObject3.length;
      i5 = 0;
      paramString = (String)localObject6;
      if (i5 < i6)
      {
        l12 = Long.valueOf(localObject3[i5]).longValue();
        if (l3 != l12) {
          break label1551;
        }
        paramBoolean = bool1;
        bool1 = true;
        if (!paramMap2.containsKey(Long.valueOf(l12)))
        {
          localObject5 = new drg();
          paramMap2.put(Long.valueOf(l12), localObject5);
          a = Math.max(a, l10);
          b = Math.max(b, l11);
          if (m == 0) {
            c = false;
          }
          localObject5 = (Boolean)b.f.get(Long.valueOf(l12));
          if ((m != 0) || (localObject5 == null) || (paramInt == 2)) {
            break label1482;
          }
          if (!((Boolean)localObject5).booleanValue()) {
            break label554;
          }
        }
        for (k = 0;; k = 1)
        {
          label496:
          if (l10 <= paramLong2) {
            break label1479;
          }
          if (paramString != null) {
            break label1476;
          }
          paramString = new HashSet();
          label518:
          paramString.add(Long.valueOf(l12));
          break label1530;
          localObject5 = (drg)paramMap2.get(Long.valueOf(l12));
          break;
          label554:
          if (k == 0) {
            break label1482;
          }
          l1 = Math.max(l1, l10);
        }
      }
      localObject3 = localObject4;
      if (localObject4 == null) {
        localObject3 = localCursor.getString(localCursor.getColumnIndexOrThrow("subject"));
      }
      localObject4 = localCursor.getString(localCursor.getColumnIndexOrThrow("snippet"));
      localObject5 = localObject2;
      if (localObject2 == null)
      {
        if (bool1) {
          break label1651;
        }
        localObject5 = localObject2;
        if (localCursor.isLast()) {
          break label1651;
        }
      }
      label650:
      i5 = Math.max(i3, localCursor.getInt(localCursor.getColumnIndexOrThrow("personalLevel")));
      l2 = Math.max(l2, l10);
      if (TextUtils.isEmpty(localCursor.getString(localCursor.getColumnIndexOrThrow("joinedAttachmentInfos")))) {
        break label1716;
      }
      m = 1;
      i6 = i2 | m;
      if (localCursor.getInt(localCursor.getColumnIndexOrThrow("error")) == 0) {
        break label1722;
      }
      m = 1;
      label736:
      str2 = localCursor.getString(localCursor.getColumnIndexOrThrow("permalink"));
      if (str1 != null) {
        break label1473;
      }
      str1 = localCursor.getString(localCursor.getColumnIndexOrThrow("unsubscribeSenderName"));
      label777:
      if (localObject1 != null) {
        break label1466;
      }
      localObject2 = localCursor.getString(localCursor.getColumnIndexOrThrow("unsubscribeSenderIdentifier"));
      label800:
      if (localCursor.getInt(localCursor.getColumnIndexOrThrow("hasEvent")) == 0) {
        break label1728;
      }
      i2 = 1;
    }
    finally
    {
      int i6;
      String str2;
      label825:
      localCursor.close();
    }
    if (i3 != 0) {
      d = true;
    }
    label854:
    boolean bool2;
    for (;;)
    {
      duq localduq = c;
      if (localObject7 != null) {
        break label951;
      }
      localObject1 = null;
      break label1687;
      localduq.a((String)localObject1, (String)localObject6, paramBoolean, bool1, bool2, -1, i4);
      n |= i2;
      localObject1 = localObject2;
      localObject7 = str2;
      i1 |= m;
      localObject6 = paramString;
      localObject2 = localObject5;
      paramString = (String)localObject4;
      localObject4 = localObject3;
      localObject3 = localObject7;
      i2 = i6;
      i3 = i5;
      break;
      if (i != 0) {
        e = true;
      }
    }
    label951:
    Matcher localMatcher = dpy.f.matcher((CharSequence)localObject7);
    if (localMatcher.find())
    {
      localObject6 = localMatcher.group(1);
      localObject1 = localObject6;
      if (((String)localObject6).length() > 0) {
        break label1687;
      }
      localObject1 = ((String)localObject7).substring(localMatcher.end(), ((String)localObject7).length());
      label1006:
      localObject6 = dpy.g.matcher((CharSequence)localObject1);
      if (!((Matcher)localObject6).find()) {
        break label1687;
      }
      localObject1 = ((Matcher)localObject6).group(1);
      break label1687;
      label1035:
      localObject6 = dpy.h((String)localObject7);
      break label1695;
    }
    for (;;)
    {
      label1045:
      if (paramInt != k) {
        dri.d(d, "Server sent rational %s but we calculated %s with messageId %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(k), Long.valueOf(l1) });
      }
      label1294:
      label1313:
      label1451:
      label1456:
      label1461:
      label1466:
      label1473:
      label1476:
      label1479:
      label1482:
      label1500:
      label1514:
      label1517:
      label1530:
      label1551:
      label1651:
      label1658:
      label1687:
      label1695:
      label1716:
      label1722:
      label1728:
      label1740:
      label1746:
      label1752:
      do
      {
        do
        {
          i = localCursor.getCount();
          c.d = i;
          localCursor.close();
          paramTimingLogger.addSplit("process messages");
          a(paramLong1, paramInt, paramMap1, paramMap2, l2, (Set)localObject6, paramdpt);
          paramTimingLogger.addSplit("process labels");
          if (i == 0)
          {
            a.delete("conversations", "_id = ? AND queryId = 0", new String[] { str3 });
            return true;
          }
          paramMap1 = new ContentValues();
          paramMap1.put("_id", Long.valueOf(paramLong1));
          paramMap1.put("queryId", Integer.valueOf(0));
          paramMap1.put("subject", (String)localObject4);
          if (localObject2 != null)
          {
            paramMap1.put("snippet", (String)localObject2);
            paramMap1.put("personalLevel", Integer.valueOf(i3));
            paramMap1.put("numMessages", Integer.valueOf(i));
            paramMap1.put("maxMessageId", Long.valueOf(l2));
            paramMap1.put("labelIds", dpy.a(paramMap2.keySet()));
            if (i2 == 0) {
              break label1451;
            }
            paramInt = 1;
            paramMap1.put("hasAttachments", Integer.valueOf(paramInt));
            if (i1 == 0) {
              break label1456;
            }
            paramInt = 1;
            paramMap1.put("hasMessagesWithErrors", Integer.valueOf(paramInt));
            paramMap1.put("syncRationale", String.valueOf(k));
            paramMap1.put("syncRationaleMessageId", Long.valueOf(l1));
            paramMap1.put("fromCompactV2", dpo.a(c));
            paramMap1.put("permalink", (String)localObject3);
            paramMap1.put("unsubscribeSenderName", str1);
            paramMap1.put("unsubscribeSenderIdentifier", (String)localObject1);
            paramMap1.put("promoteCalendar", Integer.valueOf(dyb.a(paramLong1)));
            if (n == 0) {
              break label1461;
            }
          }
          for (paramInt = 1;; paramInt = 0)
          {
            paramMap1.put("hasCalendarInvite", Integer.valueOf(paramInt));
            a.replace("conversations", null, paramMap1);
            return false;
            localObject2 = paramString;
            break;
            paramInt = 0;
            break label1294;
            paramInt = 0;
            break label1313;
          }
          localObject2 = localObject1;
          break label800;
          break label777;
          break label518;
          break label1530;
          break label496;
          do
          {
            bool2 = paramBoolean;
            paramBoolean = bool1;
            bool1 = bool2;
            break label368;
            i = m;
            break label1517;
            localObject1 = localObject7;
            break label1006;
            i = 1;
            j += 1;
            m = i;
            break;
            i5 += 1;
            bool2 = paramBoolean;
            paramBoolean = bool1;
            bool1 = bool2;
            break label333;
            if (l4 == l12)
            {
              bool2 = true;
              bool1 = paramBoolean;
              paramBoolean = bool2;
              break label368;
            }
            if (l5 == l12)
            {
              j = 1;
              bool2 = paramBoolean;
              paramBoolean = bool1;
              bool1 = bool2;
              break label368;
            }
            if (l6 == l12)
            {
              bool2 = paramBoolean;
              i = 1;
              paramBoolean = bool1;
              bool1 = bool2;
              break label368;
            }
          } while (l9 != l12);
          i4 = 2;
          bool2 = paramBoolean;
          paramBoolean = bool1;
          bool1 = bool2;
          break label368;
          localObject5 = localObject4;
          break label650;
          if ((i != 0) && (m == 0)) {}
          for (i3 = 1;; i3 = 0)
          {
            if ((i == 0) || (m == 0)) {
              break label1740;
            }
            i = 1;
            break label825;
            if (localObject7 != null) {
              break label1035;
            }
            localObject6 = null;
            if ((j == 0) && (i3 == 0) && (i == 0)) {
              break label1746;
            }
            bool2 = true;
            break label854;
            m = 0;
            break;
            m = 0;
            break label736;
            i2 = 0;
            break label1658;
          }
          i = 0;
          break label825;
          bool2 = false;
          break label854;
        } while (l1 == 0L);
        if (paramInt == 1) {
          break label1045;
        }
      } while (paramInt != 0);
    }
  }
}

/* Location:
 * Qualified Name:     dux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */