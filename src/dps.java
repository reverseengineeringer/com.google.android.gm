import android.content.ContentQueryMap;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.util.TimingLogger;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class dps
{
  public final SQLiteDatabase a;
  public final drj b;
  public final dqc c;
  
  protected dps(SQLiteDatabase paramSQLiteDatabase, drj paramdrj)
  {
    a = paramSQLiteDatabase;
    b = paramdrj;
    c = b.i;
  }
  
  private final void a(int paramInt, Map<Long, drg> paramMap1, Map<Long, drg> paramMap2, Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3, dpt paramdpt)
  {
    long l1 = c.g();
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
      bool1 = getvalueOfc;
      boolean bool2 = getvalueOfc;
      if ((!bool1) && (bool2)) {
        paramSet1.add(Long.valueOf(l2));
      }
      if ((bool1) && (!bool2)) {
        paramSet2.add(Long.valueOf(l2));
      }
    }
    paramSet3 = new HashSet();
    boolean bool1 = paramMap1.containsKey(Long.valueOf(l1));
    paramSet1 = paramSet1.iterator();
    while (paramSet1.hasNext())
    {
      localObject = (Long)paramSet1.next();
      if ((l1 != ((Long)localObject).longValue()) && ((paramInt == 4) || (drj.d(((Long)localObject).longValue()))) && ((!paramMap1.containsKey(localObject)) || (!getc)) && ((paramdpt == null) || (paramdpt.a(true, (Long)localObject))))
      {
        if (bool1)
        {
          a.execSQL("UPDATE labels SET\n  numConversations = max(numConversations - 1, 0),\n  numUnreadConversations =     max(numUnreadConversations - 1, 0)\nWHERE _id = ?", new String[] { Long.toString(((Long)localObject).longValue()) });
          dri.a("Gmail", "onConversationChanged decreased total and unread, label %d", new Object[] { localObject });
        }
        for (;;)
        {
          paramSet3.add(localObject);
          break;
          a.execSQL("UPDATE labels SET\n  numConversations = max(numConversations - 1, 0)\nWHERE _id = ?", new String[] { Long.toString(((Long)localObject).longValue()) });
          dri.a("Gmail", "onConversationChanged decreased total, label %d", new Object[] { localObject });
        }
      }
    }
    bool1 = paramMap2.containsKey(Long.valueOf(l1));
    paramMap1 = paramSet2.iterator();
    while (paramMap1.hasNext())
    {
      paramSet1 = (Long)paramMap1.next();
      if ((l1 != paramSet1.longValue()) && ((paramInt == 4) || (drj.d(paramSet1.longValue()))) && ((!paramMap2.containsKey(paramSet1)) || (!getc)) && ((paramdpt == null) || (paramdpt.a(false, paramSet1))))
      {
        if (bool1)
        {
          a.execSQL("UPDATE labels SET\n  numConversations = numConversations + 1,\n  numUnreadConversations = numUnreadConversations + 1\nWHERE _id = ?", new String[] { Long.toString(paramSet1.longValue()) });
          dri.a("Gmail", "onConversationChanged increased total and unread, label %d", new Object[] { paramSet1 });
        }
        for (;;)
        {
          paramSet3.add(paramSet1);
          break;
          a.execSQL("UPDATE labels SET\n  numConversations = numConversations + 1\nWHERE _id = ?", new String[] { Long.toString(paramSet1.longValue()) });
          dri.a("Gmail", "onConversationChanged increased total, label %d", new Object[] { paramSet1 });
        }
      }
    }
    if (paramSet3.size() > 0)
    {
      c.a.requery();
      b.h.a(paramSet3);
    }
  }
  
  private final void a(long paramLong1, long paramLong2, Map<Long, drg> paramMap, Set<Long> paramSet1, Set<Long> paramSet2, Set<Long> paramSet3, Set<Long> paramSet4, int paramInt)
  {
    if (b.e == null) {
      return;
    }
    Iterator localIterator = b.e.iterator();
    label25:
    drm localdrm;
    long l;
    boolean bool;
    label85:
    int i;
    if (localIterator.hasNext())
    {
      localdrm = (drm)localIterator.next();
      l = b;
      bool = localdrm.a(paramMap.keySet());
      if ((paramInt == 4) && (!c)) {
        break label416;
      }
      j = 1;
      if (bool == paramMap.containsKey(Long.valueOf(l))) {
        break label422;
      }
      i = 1;
      label105:
      if ((bool) && (j != 0)) {
        if ((paramSet1 == null) || (!localdrm.a(paramSet1))) {
          break label428;
        }
      }
    }
    label416:
    label422:
    label428:
    for (int j = 1;; j = 0)
    {
      if (j != 0)
      {
        drg localdrg = (drg)paramMap.get(Long.valueOf(a));
        if (localdrg != null)
        {
          b.a(paramLong2, b.c(l), true, 0);
          paramMap.put(Long.valueOf(l), localdrg);
          if (i != 0)
          {
            paramSet2.remove(Long.valueOf(l));
            paramSet3.add(Long.valueOf(l));
            paramSet4.remove(Long.valueOf(l));
          }
        }
        b.h.a(localdrm);
        dri.a("Gmail", "onConversationChanged %d added tag label %d for label %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l), Long.valueOf(a) });
      }
      if (bool) {
        break label25;
      }
      b.a(paramLong1, paramLong2, b.c(l), false, 0);
      paramMap.remove(Long.valueOf(l));
      if (i != 0)
      {
        paramSet2.add(Long.valueOf(l));
        paramSet3.remove(Long.valueOf(l));
        paramSet4.remove(Long.valueOf(l));
      }
      dri.a("Gmail", "onConversationChanged %d removed tag label %d for label %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(l), Long.valueOf(a) });
      break label25;
      break;
      j = 0;
      break label85;
      i = 0;
      break label105;
    }
  }
  
  final void a(long paramLong1, int paramInt, long paramLong2, Map<Long, drg> paramMap1, long paramLong3, Map<Long, drg> paramMap2, boolean paramBoolean, dpt paramdpt, TimingLogger paramTimingLogger)
  {
    paramBoolean = a(paramLong1, paramInt, Long.toString(paramLong2), paramMap1, paramLong3, paramMap2, paramBoolean, paramdpt, paramTimingLogger);
    paramTimingLogger.addSplit("process messages");
    if (!paramBoolean)
    {
      a(paramLong1, paramLong2, paramMap2);
      paramTimingLogger.addSplit("write labels");
    }
  }
  
  public final void a(long paramLong1, int paramInt, Map<Long, drg> paramMap1, Map<Long, drg> paramMap2, long paramLong2, Set<Long> paramSet, dpt paramdpt)
  {
    HashSet localHashSet1 = new HashSet();
    HashSet localHashSet2 = new HashSet();
    HashSet localHashSet3 = new HashSet();
    Set localSet1 = paramMap1.keySet();
    Set localSet2 = paramMap2.keySet();
    localHashSet1.addAll(localSet1);
    localHashSet1.removeAll(localSet2);
    localHashSet2.addAll(localSet2);
    localHashSet2.removeAll(localSet1);
    localHashSet3.addAll(localSet1);
    localHashSet3.retainAll(localSet2);
    dri.a("Gmail", "onConversationChanged %d removedLabels (%s), addedLabels (%s), keptLabels (%s)", new Object[] { Long.valueOf(paramLong1), localHashSet1, localHashSet2, localHashSet3 });
    a(paramLong1, paramLong2, paramMap2, paramSet, localHashSet1, localHashSet2, localHashSet3, paramInt);
    dri.a("Gmail", "onConversationChanged after updateLabels %d removedLabels (%s), addedLabels (%s), keptLabels (%s)", new Object[] { Long.valueOf(paramLong1), localHashSet1, localHashSet2, localHashSet3 });
    a(paramInt, paramMap1, paramMap2, localHashSet1, localHashSet2, localHashSet3, paramdpt);
  }
  
  public final void a(long paramLong1, long paramLong2, Map<Long, drg> paramMap)
  {
    ContentValues localContentValues = new ContentValues(6);
    localContentValues.put("queryId", Long.valueOf(paramLong2));
    localContentValues.put("conversation_id", Long.valueOf(paramLong1));
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      paramLong1 = ((Long)((Map.Entry)localObject).getKey()).longValue();
      localObject = (drg)((Map.Entry)localObject).getValue();
      localContentValues.put("labels_id", Long.valueOf(paramLong1));
      localContentValues.put("isZombie", Boolean.valueOf(c));
      localContentValues.put("sortMessageId", Long.valueOf(a));
      localContentValues.put("date", Long.valueOf(b));
      a.replace("conversation_labels", null, localContentValues);
    }
  }
  
  protected abstract boolean a(long paramLong1, int paramInt, String paramString, Map<Long, drg> paramMap1, long paramLong2, Map<Long, drg> paramMap2, boolean paramBoolean, dpt paramdpt, TimingLogger paramTimingLogger);
}

/* Location:
 * Qualified Name:     dps
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */