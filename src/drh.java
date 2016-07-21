import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.TimingLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class drh
  extends dps
{
  protected drh(SQLiteDatabase paramSQLiteDatabase, drj paramdrj)
  {
    super(paramSQLiteDatabase, paramdrj);
  }
  
  private final List<due> a(String paramString)
  {
    paramString = a.rawQuery("SELECT \n  messageId,\n  group_concat(labels_id, ','),\n  dateReceivedMs \nFROM\n  messages LEFT OUTER JOIN   message_labels ON messageId = message_messageId\nWHERE\n  synced = 0 AND conversation = ?\nGROUP BY messageId\nORDER BY messageId", new String[] { paramString });
    try
    {
      int i = paramString.getCount();
      if (i == 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      while (paramString.moveToNext())
      {
        long l = paramString.getLong(0);
        localArrayList.add(new due(paramString.getString(1), l, paramString.getLong(2)));
      }
    }
    finally
    {
      paramString.close();
    }
    return localList;
  }
  
  private final List<due> a(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    paramString1 = a.rawQuery("SELECT   labelIds, \n  maxMessageId FROM   conversations WHERE   _id = ? AND queryId = ?", new String[] { paramString2, paramString1 });
    try
    {
      if (paramString1.moveToNext()) {
        localArrayList.add(new due(paramString1.getString(0), Long.valueOf(paramString1.getLong(1))));
      }
      return localArrayList;
    }
    finally
    {
      paramString1.close();
    }
  }
  
  protected final boolean a(long paramLong1, int paramInt, String paramString, Map<Long, drg> paramMap1, long paramLong2, Map<Long, drg> paramMap2, boolean paramBoolean, dpt paramdpt, TimingLogger paramTimingLogger)
  {
    Object localObject3 = Long.toString(paramLong1);
    Object localObject1 = paramMap1.values().iterator();
    for (paramLong2 = Long.MIN_VALUE; ((Iterator)localObject1).hasNext(); paramLong2 = Math.max(paramLong2, nextb)) {}
    localObject1 = null;
    if (paramBoolean) {
      localObject1 = a((String)localObject3);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = a(paramString, (String)localObject3);
    }
    long l3 = c.i();
    long l4 = c.h();
    long l1 = Long.MIN_VALUE;
    localObject1 = ((List)localObject2).iterator();
    long l2;
    label175:
    int i;
    int j;
    int k;
    label198:
    Object localObject4;
    int m;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (due)((Iterator)localObject1).next();
      l2 = b;
      if (a != null)
      {
        paramString = TextUtils.split(a, dpy.e);
        localObject3 = new ArrayList();
        i = 0;
        j = 0;
        int n = paramString.length;
        k = 0;
        if (k >= n) {
          break label318;
        }
        localObject4 = paramString[k];
        if (TextUtils.isEmpty((CharSequence)localObject4)) {
          break label558;
        }
        l1 = Long.valueOf((String)localObject4).longValue();
        ((List)localObject3).add(Long.valueOf(l1));
        if (l3 != l1) {
          break label296;
        }
        m = 1;
        j = i;
        i = m;
      }
    }
    for (;;)
    {
      m = k + 1;
      k = j;
      j = i;
      i = k;
      k = m;
      break label198;
      paramString = new String[0];
      break label175;
      label296:
      if (l4 == l1)
      {
        m = 1;
        i = j;
        j = m;
        continue;
        label318:
        localObject3 = ((List)localObject3).iterator();
        l1 = l2;
        if (!((Iterator)localObject3).hasNext()) {
          break;
        }
        localObject4 = (Long)((Iterator)localObject3).next();
        label386:
        Object localObject5;
        if (!paramMap2.containsKey(localObject4))
        {
          paramString = new drg();
          paramMap2.put(localObject4, paramString);
          a = Math.max(a, l2);
          localObject5 = (drg)paramMap1.get(localObject4);
          if (localObject5 != null) {
            a = Math.max(a, a);
          }
          localObject5 = c;
          if (localObject5 == null) {
            break label527;
          }
        }
        label527:
        for (l1 = ((Long)localObject5).longValue();; l1 = paramLong2)
        {
          b = l1;
          if (((j != 0) || (i != 0)) && ((((Long)localObject4).longValue() != l3) || (i != 0)) && (((Long)localObject4).longValue() != l4)) {
            break;
          }
          c = false;
          break;
          paramString = (drg)paramMap2.get(localObject4);
          break label386;
        }
        a(paramLong1, paramInt, paramMap1, paramMap2, l1, null, paramdpt);
        paramTimingLogger.addSplit("process labels");
        return false;
      }
      label558:
      m = i;
      i = j;
      j = m;
    }
  }
}

/* Location:
 * Qualified Name:     drh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */