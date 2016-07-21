import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class hwn
  implements Serializable
{
  public static int a = 1000;
  private static final long serialVersionUID = -7333226591784095142L;
  public transient Log b = LogFactory.getLog(hwn.class);
  public hsn c;
  public int d = -1;
  private String e;
  private int f = -1;
  private hsx g;
  private hsx h;
  private hsx i;
  private hwx j;
  private hsx k;
  private hsx l;
  private hsx m;
  private hsx n;
  private hsx o;
  private String p;
  private int q = 2;
  private Map r = new HashMap();
  private int s;
  
  static
  {
    String str = icg.a("net.fortuna.ical4j.recur.maxincrementcount");
    if ((str != null) && (str.length() > 0))
    {
      a = Integer.parseInt(str);
      return;
    }
  }
  
  public hwn() {}
  
  public hwn(String paramString)
  {
    paramString = new StringTokenizer(paramString, ";=");
    while (paramString.hasMoreTokens())
    {
      String str = paramString.nextToken();
      if ("FREQ".equals(str))
      {
        e = a(paramString, str);
      }
      else if ("UNTIL".equals(str))
      {
        str = a(paramString, str);
        if ((str != null) && (str.indexOf("T") >= 0))
        {
          c = new hsq(str);
          ((hsq)c).a(true);
        }
        else
        {
          c = new hsn(str);
        }
      }
      else if ("COUNT".equals(str))
      {
        d = Integer.parseInt(a(paramString, str));
      }
      else if ("INTERVAL".equals(str))
      {
        f = Integer.parseInt(a(paramString, str));
      }
      else if ("BYSECOND".equals(str))
      {
        g = new hsx(a(paramString, str), 0, 59, false);
      }
      else if ("BYMINUTE".equals(str))
      {
        h = new hsx(a(paramString, str), 0, 59, false);
      }
      else if ("BYHOUR".equals(str))
      {
        i = new hsx(a(paramString, str), 0, 23, false);
      }
      else if ("BYDAY".equals(str))
      {
        j = new hwx(a(paramString, str));
      }
      else if ("BYMONTHDAY".equals(str))
      {
        k = new hsx(a(paramString, str), 1, 31, true);
      }
      else if ("BYYEARDAY".equals(str))
      {
        l = new hsx(a(paramString, str), 1, 366, true);
      }
      else if ("BYWEEKNO".equals(str))
      {
        m = new hsx(a(paramString, str), 1, 53, true);
      }
      else if ("BYMONTH".equals(str))
      {
        n = new hsx(a(paramString, str), 1, 12, false);
      }
      else if ("BYSETPOS".equals(str))
      {
        o = new hsx(a(paramString, str), 1, 366, true);
      }
      else if ("WKST".equals(str))
      {
        p = a(paramString, str);
        q = hww.a(new hww(p));
      }
      else if (icf.a("ical4j.parsing.relaxed"))
      {
        r.put(str, a(paramString, str));
      }
      else
      {
        paramString = String.valueOf(a(paramString, str));
        throw new IllegalArgumentException(String.valueOf(str).length() + 31 + String.valueOf(paramString).length() + "Invalid recurrence rule part: " + str + "=" + paramString);
      }
    }
    j();
  }
  
  public hwn(String paramString, byte paramByte)
  {
    e = paramString;
    d = 1;
    j();
  }
  
  private static String a(StringTokenizer paramStringTokenizer, String paramString)
  {
    try
    {
      paramStringTokenizer = paramStringTokenizer.nextToken();
      return paramStringTokenizer;
    }
    catch (NoSuchElementException paramStringTokenizer)
    {
      paramStringTokenizer = String.valueOf(paramString);
      if (paramStringTokenizer.length() == 0) {}
    }
    for (paramStringTokenizer = "Missing expected token, last token: ".concat(paramStringTokenizer);; paramStringTokenizer = new String("Missing expected token, last token: ")) {
      throw new IllegalArgumentException(paramStringTokenizer);
    }
  }
  
  private final hwx b()
  {
    if (j == null) {
      j = new hwx();
    }
    return j;
  }
  
  private final hsx c()
  {
    if (i == null) {
      i = new hsx(0, 23, false);
    }
    return i;
  }
  
  private final hsx d()
  {
    if (h == null) {
      h = new hsx(0, 59, false);
    }
    return h;
  }
  
  private final hsx e()
  {
    if (k == null) {
      k = new hsx(1, 31, true);
    }
    return k;
  }
  
  private final hsx f()
  {
    if (g == null) {
      g = new hsx(0, 59, false);
    }
    return g;
  }
  
  private final hsx g()
  {
    if (o == null) {
      o = new hsx(1, 366, true);
    }
    return o;
  }
  
  private final hsx h()
  {
    if (m == null) {
      m = new hsx(1, 53, true);
    }
    return m;
  }
  
  public static hso i(hso paramhso)
  {
    hso localhso = new hso(a);
    if (c)
    {
      localhso.a(true);
      return localhso;
    }
    localhso.a(b);
    return localhso;
  }
  
  private final hsx i()
  {
    if (l == null) {
      l = new hsx(1, 366, true);
    }
    return l;
  }
  
  private final void j()
  {
    if (e == null) {
      throw new IllegalArgumentException("A recurrence rule MUST contain a FREQ rule part.");
    }
    if ("SECONDLY".equals(e))
    {
      s = 13;
      return;
    }
    if ("MINUTELY".equals(e))
    {
      s = 12;
      return;
    }
    if ("HOURLY".equals(e))
    {
      s = 11;
      return;
    }
    if ("DAILY".equals(e))
    {
      s = 6;
      return;
    }
    if ("WEEKLY".equals(e))
    {
      s = 3;
      return;
    }
    if ("MONTHLY".equals(e))
    {
      s = 2;
      return;
    }
    if ("YEARLY".equals(e))
    {
      s = 1;
      return;
    }
    String str = e;
    throw new IllegalArgumentException(String.valueOf(str).length() + 44 + "Invalid FREQ rule part '" + str + "' in recurrence rule");
  }
  
  private void readObject(ObjectInputStream paramObjectInputStream)
  {
    paramObjectInputStream.defaultReadObject();
    b = LogFactory.getLog(hwn.class);
  }
  
  public final hso a(hso paramhso)
  {
    if (g().isEmpty()) {
      return paramhso;
    }
    Collections.sort(paramhso);
    hso localhso = i(paramhso);
    int i1 = paramhso.size();
    Iterator localIterator = g().iterator();
    while (localIterator.hasNext())
    {
      int i2 = ((Integer)localIterator.next()).intValue();
      if ((i2 > 0) && (i2 <= i1)) {
        localhso.add(paramhso.get(i2 - 1));
      } else if ((i2 < 0) && (i2 >= -i1)) {
        localhso.add(paramhso.get(i2 + i1));
      }
    }
    return localhso;
  }
  
  public final hsx a()
  {
    if (n == null) {
      n = new hsx(1, 12, false);
    }
    return n;
  }
  
  public final Calendar a(hsn paramhsn, boolean paramBoolean)
  {
    Calendar localCalendar = ich.a(paramhsn);
    localCalendar.setMinimalDaysInFirstWeek(4);
    localCalendar.setFirstDayOfWeek(q);
    localCalendar.setLenient(paramBoolean);
    localCalendar.setTime(paramhsn);
    return localCalendar;
  }
  
  public final void a(Calendar paramCalendar)
  {
    if (f > 0) {}
    for (int i1 = f;; i1 = 1)
    {
      paramCalendar.add(s, i1);
      return;
    }
  }
  
  public final hso b(hso paramhso)
  {
    if (h().isEmpty()) {
      return paramhso;
    }
    hso localhso = i(paramhso);
    paramhso = paramhso.iterator();
    if (paramhso.hasNext())
    {
      Calendar localCalendar = a((hsn)paramhso.next(), true);
      Iterator localIterator = h().iterator();
      label57:
      Object localObject2;
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject2 = (Integer)localIterator.next();
        localObject1 = localCalendar.getTime();
        i1 = ((Integer)localObject2).intValue();
        if ((i1 == 0) || (i1 < -53) || (i1 > 53)) {
          throw new IllegalArgumentException(MessageFormat.format("Invalid week number [{0}]", new Object[] { new Integer(i1) }));
        }
        if (i1 <= 0) {
          break label170;
        }
      }
      for (;;)
      {
        localCalendar.set(3, i1);
        localhso.a(ich.a(localCalendar.getTime(), a));
        break label57;
        break;
        label170:
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime((Date)localObject1);
        int i2 = ((Calendar)localObject2).get(1);
        localObject1 = new ArrayList();
        ((Calendar)localObject2).set(3, 1);
        while (((Calendar)localObject2).get(1) == i2)
        {
          ((List)localObject1).add(new Integer(((Calendar)localObject2).get(3)));
          ((Calendar)localObject2).add(3, 1);
        }
        i1 = ((Integer)((List)localObject1).get(i1 + ((List)localObject1).size())).intValue();
      }
    }
    return localhso;
  }
  
  public final hso c(hso paramhso)
  {
    if (i().isEmpty()) {
      return paramhso;
    }
    hso localhso = i(paramhso);
    paramhso = paramhso.iterator();
    if (paramhso.hasNext())
    {
      Calendar localCalendar = a((hsn)paramhso.next(), true);
      Iterator localIterator = i().iterator();
      label57:
      Object localObject2;
      Object localObject1;
      int i1;
      if (localIterator.hasNext())
      {
        localObject2 = (Integer)localIterator.next();
        localObject1 = localCalendar.getTime();
        i1 = ((Integer)localObject2).intValue();
        if ((i1 == 0) || (i1 < 65170) || (i1 > 366)) {
          throw new IllegalArgumentException(MessageFormat.format("Invalid year day [{0}]", new Object[] { new Integer(i1) }));
        }
        if (i1 <= 0) {
          break label173;
        }
      }
      for (;;)
      {
        localCalendar.set(6, i1);
        localhso.a(ich.a(localCalendar.getTime(), a));
        break label57;
        break;
        label173:
        localObject2 = Calendar.getInstance();
        ((Calendar)localObject2).setTime((Date)localObject1);
        int i2 = ((Calendar)localObject2).get(1);
        localObject1 = new ArrayList();
        ((Calendar)localObject2).set(6, 1);
        while (((Calendar)localObject2).get(1) == i2)
        {
          ((List)localObject1).add(new Integer(((Calendar)localObject2).get(6)));
          ((Calendar)localObject2).add(6, 1);
        }
        i1 = ((Integer)((List)localObject1).get(i1 + ((List)localObject1).size())).intValue();
      }
    }
    return localhso;
  }
  
  public final hso d(hso paramhso)
  {
    if (e().isEmpty()) {
      return paramhso;
    }
    hso localhso = i(paramhso);
    paramhso = paramhso.iterator();
    while (paramhso.hasNext())
    {
      Calendar localCalendar = a((hsn)paramhso.next(), false);
      Iterator localIterator = e().iterator();
      while (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        try
        {
          localCalendar.set(5, ich.a(localCalendar.getTime(), localInteger.intValue()));
          localhso.a(ich.a(localCalendar.getTime(), a));
        }
        catch (IllegalArgumentException localIllegalArgumentException) {}
        if (b.isTraceEnabled())
        {
          Log localLog = b;
          int i1 = ich.a(localCalendar.getTime(), localInteger.intValue());
          localLog.trace(33 + "Invalid day of month: " + i1);
        }
      }
    }
    return localhso;
  }
  
  public final hso e(hso paramhso)
  {
    if (b().isEmpty()) {
      return paramhso;
    }
    hso localhso2 = i(paramhso);
    Iterator localIterator1 = paramhso.iterator();
    if (localIterator1.hasNext())
    {
      hsn localhsn = (hsn)localIterator1.next();
      Iterator localIterator2 = b().iterator();
      label55:
      Object localObject1;
      Object localObject2;
      Calendar localCalendar;
      hso localhso1;
      label192:
      int i1;
      while (localIterator2.hasNext())
      {
        localObject1 = (hww)localIterator2.next();
        if ((!i().isEmpty()) || (!e().isEmpty()))
        {
          if (((hww)localObject1).equals(new hww(hww.a(a(localhsn, true).get(7))))) {
            localhso2.a(localhsn);
          }
        }
        else
        {
          localObject2 = a;
          localCalendar = a(localhsn, true);
          localhso1 = new hso((hzm)localObject2);
          if ((localhsn instanceof hsq))
          {
            if (!a.a) {
              break label218;
            }
            localhso1.a(true);
          }
          i1 = hww.a((hww)localObject1);
          if (i1 != -1) {
            break label234;
          }
          localObject1 = localhso1;
        }
      }
      for (;;)
      {
        localhso2.addAll((Collection)localObject1);
        break label55;
        break;
        label218:
        localhso1.a(b);
        break label192;
        label234:
        if ("DAILY".equals(e)) {
          if (localCalendar.get(7) == i1) {
            localhso1.a(ich.a(localCalendar.getTime(), (hzm)localObject2));
          }
        }
        for (;;)
        {
          i1 = h;
          if (i1 != 0) {
            break label567;
          }
          localObject1 = localhso1;
          break;
          if (("WEEKLY".equals(e)) || (!h().isEmpty()))
          {
            i2 = localCalendar.get(3);
            localCalendar.set(7, localCalendar.getFirstDayOfWeek());
            while (localCalendar.get(7) != i1) {
              localCalendar.add(7, 1);
            }
            if (localCalendar.get(3) == i2) {
              localhso1.a(ich.a(localCalendar.getTime(), (hzm)localObject2));
            }
          }
          else if (("MONTHLY".equals(e)) || (!a().isEmpty()))
          {
            i2 = localCalendar.get(2);
            localCalendar.set(5, 1);
            while (localCalendar.get(7) != i1) {
              localCalendar.add(5, 1);
            }
            while (localCalendar.get(2) == i2)
            {
              localhso1.a(ich.a(localCalendar.getTime(), (hzm)localObject2));
              localCalendar.add(5, 7);
            }
          }
          else if ("YEARLY".equals(e))
          {
            i2 = localCalendar.get(1);
            localCalendar.set(6, 1);
            while (localCalendar.get(7) != i1) {
              localCalendar.add(6, 1);
            }
            while (localCalendar.get(1) == i2)
            {
              localhso1.a(ich.a(localCalendar.getTime(), (hzm)localObject2));
              localCalendar.add(6, 7);
            }
          }
        }
        label567:
        localObject2 = i(localhso1);
        int i2 = localhso1.size();
        if ((i1 < 0) && (i1 >= -i2))
        {
          ((List)localObject2).add(localhso1.get(i1 + i2));
          localObject1 = localObject2;
        }
        else
        {
          localObject1 = localObject2;
          if (i1 > 0)
          {
            localObject1 = localObject2;
            if (i1 <= i2)
            {
              ((List)localObject2).add(localhso1.get(i1 - 1));
              localObject1 = localObject2;
            }
          }
        }
      }
    }
    return localhso2;
  }
  
  public final hso f(hso paramhso)
  {
    if (c().isEmpty()) {
      return paramhso;
    }
    hso localhso = i(paramhso);
    paramhso = paramhso.iterator();
    while (paramhso.hasNext())
    {
      Calendar localCalendar = a((hsn)paramhso.next(), true);
      Iterator localIterator = c().iterator();
      while (localIterator.hasNext())
      {
        localCalendar.set(11, ((Integer)localIterator.next()).intValue());
        localhso.a(ich.a(localCalendar.getTime(), a));
      }
    }
    return localhso;
  }
  
  public final hso g(hso paramhso)
  {
    if (d().isEmpty()) {
      return paramhso;
    }
    hso localhso = i(paramhso);
    paramhso = paramhso.iterator();
    while (paramhso.hasNext())
    {
      Calendar localCalendar = a((hsn)paramhso.next(), true);
      Iterator localIterator = d().iterator();
      while (localIterator.hasNext())
      {
        localCalendar.set(12, ((Integer)localIterator.next()).intValue());
        localhso.a(ich.a(localCalendar.getTime(), a));
      }
    }
    return localhso;
  }
  
  public final hso h(hso paramhso)
  {
    if (f().isEmpty()) {
      return paramhso;
    }
    hso localhso = i(paramhso);
    paramhso = paramhso.iterator();
    while (paramhso.hasNext())
    {
      Calendar localCalendar = a((hsn)paramhso.next(), true);
      Iterator localIterator = f().iterator();
      while (localIterator.hasNext())
      {
        localCalendar.set(13, ((Integer)localIterator.next()).intValue());
        localhso.a(ich.a(localCalendar.getTime(), a));
      }
    }
    return localhso;
  }
  
  public final String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("FREQ");
    localStringBuffer.append('=');
    localStringBuffer.append(e);
    if (p != null)
    {
      localStringBuffer.append(';');
      localStringBuffer.append("WKST");
      localStringBuffer.append('=');
      localStringBuffer.append(p);
    }
    if (f > 0)
    {
      localStringBuffer.append(';');
      localStringBuffer.append("INTERVAL");
      localStringBuffer.append('=');
      localStringBuffer.append(f);
    }
    if (c != null)
    {
      localStringBuffer.append(';');
      localStringBuffer.append("UNTIL");
      localStringBuffer.append('=');
      localStringBuffer.append(c);
    }
    if (d > 0)
    {
      localStringBuffer.append(';');
      localStringBuffer.append("COUNT");
      localStringBuffer.append('=');
      localStringBuffer.append(d);
    }
    if (!a().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYMONTH");
      localStringBuffer.append('=');
      localStringBuffer.append(n);
    }
    if (!h().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYWEEKNO");
      localStringBuffer.append('=');
      localStringBuffer.append(m);
    }
    if (!i().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYYEARDAY");
      localStringBuffer.append('=');
      localStringBuffer.append(l);
    }
    if (!e().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYMONTHDAY");
      localStringBuffer.append('=');
      localStringBuffer.append(k);
    }
    if (!b().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYDAY");
      localStringBuffer.append('=');
      localStringBuffer.append(j);
    }
    if (!c().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYHOUR");
      localStringBuffer.append('=');
      localStringBuffer.append(i);
    }
    if (!d().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYMINUTE");
      localStringBuffer.append('=');
      localStringBuffer.append(h);
    }
    if (!f().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYSECOND");
      localStringBuffer.append('=');
      localStringBuffer.append(g);
    }
    if (!g().isEmpty())
    {
      localStringBuffer.append(';');
      localStringBuffer.append("BYSETPOS");
      localStringBuffer.append('=');
      localStringBuffer.append(o);
    }
    return localStringBuffer.toString();
  }
}

/* Location:
 * Qualified Name:     hwn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */