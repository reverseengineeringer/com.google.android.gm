import android.accounts.Account;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.appdatasearch.SearchResults;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dqs
  extends dqr
{
  private boolean A;
  private double B;
  private final StringBuilder C = new StringBuilder();
  final HashMap<Long, String> s = new HashMap();
  private final bgr t;
  private String u;
  private final Set<Long> v = new HashSet();
  private final Set<Long> w = new HashSet();
  private int x = 0;
  private boolean y = false;
  private int z = 0;
  
  public dqs(dro paramdro, String paramString1, String paramString2, bgr parambgr)
  {
    super(paramdro, paramString1, paramString2, false);
    t = parambgr;
    paramdro = i.a("^f");
    boolean bool;
    if ((paramdro != null) && (n.contains(Long.valueOf(a))))
    {
      bool = true;
      A = bool;
      if (!A) {
        break label158;
      }
    }
    label158:
    for (B = 2.0D;; B = 3.0D)
    {
      C.delete(0, C.length());
      c();
      return;
      bool = false;
      break;
    }
  }
  
  private static void a(String paramString, Collection<String> paramCollection1, Collection<String> paramCollection2)
  {
    paramCollection1 = paramCollection1.iterator();
    while (paramCollection1.hasNext()) {
      paramCollection2.add(String.format("%s:%s", new Object[] { paramString, (String)paramCollection1.next() }));
    }
  }
  
  private final void c()
  {
    if (f.matcher(r).find())
    {
      u = null;
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (!r.isEmpty()) {
      localArrayList.add(r);
    }
    a("from_address", m, localArrayList);
    a("to_addresses", l, localArrayList);
    a("subject", o, localArrayList);
    Iterator localIterator = n.iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      localArrayList.add(String.format("tag:%s", new Object[] { i.c(localLong.longValue()).b }));
    }
    if (q) {
      localArrayList.add(String.format("-tag:%s", new Object[] { "^u" }));
    }
    if (p) {
      localArrayList.add("tag:has_attachments");
    }
    u = TextUtils.join(" ", localArrayList);
  }
  
  final Cursor a(Cursor paramCursor)
  {
    return new dqt(this, paramCursor);
  }
  
  final CharSequence a(int paramInt)
  {
    int j = paramInt;
    if (x == 0) {
      j = 20;
    }
    Object localObject1;
    int i;
    label208:
    Object localObject2;
    Long localLong;
    if ((u != null) && (!y) && (j > z)) {
      if ((!y) && (v.size() < j))
      {
        paramInt = Math.max(10, Math.min(500, (int)(B * (j - v.size()))));
        dri.b("Gmail", "Search request for [%s] num results %d", new Object[] { u, Integer.valueOf(paramInt) });
        localObject1 = new Account(this.j, "com.google");
        localObject1 = t.a(u, (Account)localObject1, x, paramInt);
        if (localObject1 != null)
        {
          dri.b("Gmail", "Search request done with %d results", new Object[] { Integer.valueOf(h) });
          if (h < paramInt) {
            y = true;
          }
          if (h > 0)
          {
            localObject1 = ((SearchResults)localObject1).b();
            paramInt = 0;
            i = 0;
            if (!((Iterator)localObject1).hasNext()) {
              break label728;
            }
            localObject2 = (eci)((Iterator)localObject1).next();
            localLong = Long.valueOf(((eci)localObject2).a("conversation"));
            if (A)
            {
              v.add(localLong);
              label262:
              if (!s.containsKey(localLong))
              {
                localObject2 = ((eci)localObject2).a("body");
                s.put(localLong, localObject2);
              }
              i += 1;
              if (v.size() < j) {
                break label725;
              }
            }
          }
        }
      }
    }
    label571:
    label725:
    label728:
    for (;;)
    {
      x += i;
      if (v.size() != 0) {
        B = (x / v.size());
      }
      dri.b("Gmail", "Cids found now %d (added %d sent %d)", new Object[] { Integer.valueOf(v.size()), Integer.valueOf(i), Integer.valueOf(paramInt) });
      break;
      if (b.e == null) {}
      boolean[] arrayOfBoolean;
      for (int m = 0;; m = arrayOfBoolean[a])
      {
        if (m == 0) {
          break label571;
        }
        int k = paramInt + 1;
        paramInt = k;
        if (v.contains(localLong)) {
          break;
        }
        w.add(localLong);
        paramInt = k;
        break;
        arrayOfBoolean = b.e[b.i[a]].getBooleanArray("^f");
        if (arrayOfBoolean == null) {
          throw new IllegalArgumentException("Tag " + "^f" + " with corpus " + b.j[b.i[a]] + " doesn't exist");
        }
      }
      v.add(localLong);
      w.remove(localLong);
      break label262;
      z = j;
      if (y) {
        v.addAll(w);
      }
      C.delete(0, C.length());
      localObject1 = v.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localLong = (Long)((Iterator)localObject1).next();
        C.append(localLong);
        C.append(',');
      }
      paramInt = C.length();
      if (paramInt > 0) {
        C.delete(paramInt - 1, paramInt);
      }
      return C;
      break label208;
    }
  }
  
  final String a()
  {
    return "conversation_labels.conversation_id IN (%s)";
  }
  
  final List<String> b()
  {
    return new ArrayList();
  }
}

/* Location:
 * Qualified Name:     dqs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */