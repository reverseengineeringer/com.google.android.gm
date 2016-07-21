import android.text.TextUtils;
import com.android.mail.providers.Conversation;
import com.google.android.gm.provider.Advertisement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public final class duh
{
  static final String a = cvl.a;
  final long b;
  final long c;
  final int d;
  final List<dui> e;
  final Long f;
  final Integer g;
  final Boolean h;
  final int i;
  final Integer j;
  final Integer k;
  final String l;
  
  public duh(int paramInt1, long paramLong1, long paramLong2, int paramInt2, List<dui> paramList, Long paramLong, Integer paramInteger1, Boolean paramBoolean, Integer paramInteger2, Integer paramInteger3, String paramString)
  {
    i = paramInt1;
    b = paramLong1;
    c = paramLong2;
    d = paramInt2;
    e = paramList;
    f = paramLong;
    g = paramInteger1;
    h = paramBoolean;
    j = paramInteger2;
    k = paramInteger3;
    l = paramString;
  }
  
  public static duh a(long paramLong1, long paramLong2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
  {
    for (;;)
    {
      try
      {
        bool = TextUtils.isEmpty(paramString1);
        if (!bool) {
          continue;
        }
        m = -1;
        n = m;
      }
      catch (NumberFormatException paramString1)
      {
        boolean bool;
        List localList;
        label124:
        label135:
        int n = -1;
        continue;
        l1 = Long.parseLong(paramString3, 10);
        paramString1 = Long.valueOf(l1);
        continue;
      }
      localList = a(paramString2);
      for (;;)
      {
        try
        {
          bool = TextUtils.isEmpty(paramString3);
          if (bool)
          {
            paramString1 = null;
            paramString2 = paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          long l1;
          paramString2 = null;
          continue;
          m = Integer.parseInt(paramString4, 10);
          paramString1 = Integer.valueOf(m);
          continue;
        }
        try
        {
          bool = TextUtils.isEmpty(paramString4);
          if (!bool) {
            continue;
          }
          paramString1 = null;
          paramString3 = paramString1;
        }
        catch (NumberFormatException paramString1)
        {
          paramString3 = null;
          continue;
          paramString4 = Boolean.valueOf(Boolean.parseBoolean(paramString5));
          continue;
          m = Advertisement.a(Integer.parseInt(paramString6, 10));
        }
      }
      if (!TextUtils.isEmpty(paramString5)) {
        break label240;
      }
      paramString4 = null;
      try
      {
        bool = TextUtils.isEmpty(paramString6);
        if (bool) {
          m = -1;
        }
      }
      catch (NumberFormatException paramString1)
      {
        dri.e(a, "operation has invalid tab %s", new Object[] { paramString6 });
        m = -1;
        continue;
        i1 = Integer.parseInt(paramString7, 10);
        paramString1 = Integer.valueOf(i1);
        continue;
      }
      for (;;)
      {
        try
        {
          bool = TextUtils.isEmpty(paramString7);
          if (bool)
          {
            paramString1 = null;
            paramString5 = paramString1;
          }
        }
        catch (NumberFormatException paramString1)
        {
          paramString5 = null;
          break;
          i1 = Integer.parseInt(paramString8, 10);
          paramString1 = Integer.valueOf(i1);
          break label124;
        }
        try
        {
          bool = TextUtils.isEmpty(paramString8);
          if (!bool) {
            continue;
          }
          paramString1 = null;
        }
        catch (NumberFormatException paramString1)
        {
          paramString1 = null;
          break label124;
          paramString6 = paramString9;
          break label135;
        }
      }
      if (!TextUtils.isEmpty(paramString9)) {
        break label348;
      }
      paramString6 = null;
      return new duh(Advertisement.a(m), paramLong1, paramLong2, n, localList, paramString2, paramString3, paramString4, paramString5, paramString1, paramString6);
      m = Integer.parseInt(paramString1, 10);
    }
  }
  
  public static List<dui> a(int paramInt, bwg parambwg)
  {
    ArrayList localArrayList = new ArrayList();
    if (parambwg == null) {
      return localArrayList;
    }
    int m = 0;
    parambwg.moveToPosition(-1);
    while ((m < paramInt) && (parambwg.moveToNext()))
    {
      Conversation localConversation = parambwg.m();
      if (localConversation != null)
      {
        localArrayList.add(new dui(localConversation, m));
        m += 1;
      }
    }
    return localArrayList;
  }
  
  private static List<dui> a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    try
    {
      paramString = new JSONArray(paramString);
      ArrayList localArrayList = new ArrayList(paramString.length());
      int m = 0;
      for (;;)
      {
        int n = paramString.length();
        if (m < n) {
          try
          {
            localArrayList.add(new dui(paramString.getJSONObject(m)));
            m += 1;
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              dri.e(a, localJSONException, "Invalid ThreadInfos JSON array.", new Object[0]);
              localArrayList.add(new dui());
            }
          }
        }
      }
      return localArrayList;
    }
    catch (JSONException paramString)
    {
      dri.e(a, paramString, "Invalid ThreadInfos JSON array.", new Object[0]);
      return null;
    }
  }
  
  final String a()
  {
    if (e == null) {
      return "";
    }
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = e.iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put(((dui)localIterator.next()).a());
    }
    return localJSONArray.toString();
  }
  
  final gxv b()
  {
    gxv localgxv = new gxv();
    d = new gxw[e.size()];
    int m = 0;
    while (m < e.size())
    {
      gxw[] arrayOfgxw = d;
      dui localdui = (dui)e.get(m);
      gxw localgxw = new gxw();
      b = a;
      a |= 0x1;
      d = c;
      a |= 0x4;
      c = b;
      a |= 0x2;
      e = d.intValue();
      a |= 0x8;
      arrayOfgxw[m] = localgxw;
      m += 1;
    }
    b = c;
    a |= 0x1;
    e = j.intValue();
    a |= 0x4;
    f = k.intValue();
    a |= 0x8;
    c = d;
    a |= 0x2;
    return localgxv;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof duh)) {
      return false;
    }
    duh localduh = (duh)paramObject;
    if ((paramObject instanceof duh))
    {
      paramObject = (duh)paramObject;
      if ((b != b) || (d != d) || (!hbc.a(e, e)) || (!hbc.a(f, f)) || (!hbc.a(g, g)) || (!hbc.a(h, h)) || (!hbc.a(j, j)) || (!hbc.a(k, k)) || (!hbc.a(l, l)) || (i != i)) {}
    }
    for (int m = 1; (m != 0) && (c == c); m = 0) {
      return true;
    }
    return false;
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{OrganicEventOperation type: ").append(b);
    localStringBuilder.append(", timestampMs: ").append(c);
    localStringBuilder.append(", numAdsShown: ").append(d);
    if (e != null)
    {
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext())
      {
        dui localdui = (dui)localIterator.next();
        localStringBuilder.append(", threadInfo: ").append(localdui.toString());
      }
    }
    if (f != null) {
      localStringBuilder.append(", threadId: ").append(f);
    }
    if (g != null) {
      localStringBuilder.append(", displayPosition: ").append(g);
    }
    if (h != null) {
      localStringBuilder.append(", isRead: ").append(h);
    }
    localStringBuilder.append(", tab: ").append(i);
    if (j != null) {
      localStringBuilder.append(", operationAction: ").append(j);
    }
    if (k != null) {
      localStringBuilder.append(", operationType: ").append(k);
    }
    if (l != null) {
      localStringBuilder.append(", clickedUrl: ").append(l);
    }
    return "}";
  }
}

/* Location:
 * Qualified Name:     duh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */