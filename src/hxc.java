import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class hxc
  extends hsj
{
  private static final DateFormat g;
  private static final long serialVersionUID = 2523330383042085994L;
  private long[] c;
  private hsq[] d;
  private Map e = new TreeMap();
  private hsn f = null;
  private hsn h;
  
  static
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
    g = localSimpleDateFormat;
    localSimpleDateFormat.setTimeZone(icp.a);
    g.setLenient(false);
  }
  
  protected hxc(String paramString)
  {
    super(paramString);
  }
  
  protected hxc(String paramString, hwm paramhwm)
  {
    super(paramString, paramhwm);
  }
  
  private final hsq a(hsq paramhsq)
  {
    hsq localhsq = new hsq((byte)0);
    localhsq.setTime(paramhsq.getTime() - b"TZOFFSETFROM"c.a);
    return localhsq;
  }
  
  private static hsq c(String paramString)
  {
    synchronized (g)
    {
      long l = g.parse(paramString).getTime();
      paramString = new hsq((byte)0);
      paramString.setTime(l);
      return paramString;
    }
  }
  
  public final hsn a(hsn paramhsn)
  {
    if (f == null) {}
    try
    {
      f = a(c(b"DTSTART"c.toString()));
      if (paramhsn.before(f))
      {
        paramhsn = null;
        return paramhsn;
      }
    }
    catch (ParseException paramhsn)
    {
      LogFactory.getLog(hxc.class).error("Unexpected error calculating initial onset", paramhsn);
      return null;
    }
    if ((c != null) && ((h == null) || (paramhsn.before(h))))
    {
      i = Arrays.binarySearch(c, paramhsn.getTime());
      if (i >= 0) {
        return d[i];
      }
      i = -i;
      return d[(i - 1 - 1)];
    }
    Object localObject2 = f;
    for (;;)
    {
      try
      {
        localhsq = c(b"DTSTART"c.toString());
        localhso1 = new hso();
        localhso1.a(true);
        localhso1.a(f);
        localObject4 = a("RDATE").iterator();
        if (!((Iterator)localObject4).hasNext()) {
          break;
        }
        localObject5 = nextc.iterator();
        localObject1 = localObject2;
      }
      catch (ParseException paramhsn)
      {
        try
        {
          localObject2 = a(c(((hsn)((Iterator)localObject5).next()).toString()));
          if (((hsq)localObject2).after(paramhsn)) {
            break label1893;
          }
          boolean bool = ((hsq)localObject2).after((Date)localObject1);
          if (!bool) {
            break label1893;
          }
          localObject1 = localObject2;
        }
        catch (ParseException localParseException2)
        {
          for (;;)
          {
            hsq localhsq;
            hso localhso1;
            Object localObject4;
            Object localObject5;
            Object localObject1;
            Iterator localIterator1;
          }
          continue;
        }
        try
        {
          localhso1.a((hsn)localObject2);
        }
        catch (ParseException localParseException1) {}
        paramhsn = paramhsn;
        LogFactory.getLog(hxc.class).error("Unexpected error calculating initial onset", paramhsn);
        return null;
      }
      localObject2 = localObject1;
      if (((Iterator)localObject5).hasNext()) {
        LogFactory.getLog(hxc.class).error("Unexpected error calculating onset", localParseException1);
      }
    }
    localIterator1 = a("RRULE").iterator();
    localObject1 = localParseException1;
    while (localIterator1.hasNext())
    {
      Object localObject3 = (ibe)localIterator1.next();
      localObject4 = ich.a(paramhsn);
      ((Calendar)localObject4).setTime(paramhsn);
      ((Calendar)localObject4).add(1, 10);
      h = ich.a(((Calendar)localObject4).getTime(), hzm.f);
      hwn localhwn = c;
      hsn localhsn = h;
      hzm localhzm = hzm.f;
      hso localhso2 = new hso(localhzm);
      if (a.a) {
        localhso2.a(true);
      }
      Calendar localCalendar;
      for (;;)
      {
        localCalendar = localhwn.a(localhsq, true);
        if (d > 0) {
          break;
        }
        localObject3 = (Calendar)localCalendar.clone();
        while (((Calendar)localObject3).getTime().before(localhsq))
        {
          localCalendar.setTime(((Calendar)localObject3).getTime());
          localhwn.a((Calendar)localObject3);
        }
        localhso2.a(b);
      }
      i = 0;
      localObject3 = null;
      int j = 0;
      localObject4 = ich.a(localCalendar.getTime(), localhzm);
      if (((c == null) || (localObject3 == null) || (!((hsn)localObject3).after(c))) && ((localhsn == null) || (localObject3 == null) || (!((hsn)localObject3).after(localhsn))) && ((d <= 0) || (localhso2.size() + i < d)))
      {
        label679:
        label702:
        Object localObject6;
        if ((localObject4 instanceof hsq))
        {
          if (c) {
            ((hsq)localObject4).a(true);
          }
        }
        else
        {
          localObject5 = new hso(localhzm);
          if ((localObject4 instanceof hsq))
          {
            if (!a.a) {
              break label1471;
            }
            ((hso)localObject5).a(true);
          }
          ((hso)localObject5).a((hsn)localObject4);
          if (!localhwn.a().isEmpty()) {
            break label1487;
          }
          localObject4 = localObject5;
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 32 + "Dates after BYMONTH processing: " + (String)localObject6);
          }
          localObject4 = localhwn.b((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 33 + "Dates after BYWEEKNO processing: " + (String)localObject6);
          }
          localObject4 = localhwn.c((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 34 + "Dates after BYYEARDAY processing: " + (String)localObject6);
          }
          localObject4 = localhwn.d((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 35 + "Dates after BYMONTHDAY processing: " + (String)localObject6);
          }
          localObject4 = localhwn.e((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 30 + "Dates after BYDAY processing: " + (String)localObject6);
          }
          localObject4 = localhwn.f((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 31 + "Dates after BYHOUR processing: " + (String)localObject6);
          }
          localObject4 = localhwn.g((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 33 + "Dates after BYMINUTE processing: " + (String)localObject6);
          }
          localObject4 = localhwn.h((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 33 + "Dates after BYSECOND processing: " + (String)localObject6);
          }
          localObject4 = localhwn.a((hso)localObject4);
          if (b.isDebugEnabled())
          {
            localObject5 = b;
            localObject6 = String.valueOf(localObject4);
            ((Log)localObject5).debug(String.valueOf(localObject6).length() + 31 + "Dates after SETPOS processing: " + (String)localObject6);
          }
          if (((hso)localObject4).isEmpty()) {
            break label1695;
          }
          Collections.sort((List)localObject4);
          localObject5 = ((hso)localObject4).iterator();
        }
        for (;;)
        {
          if (!((Iterator)localObject5).hasNext()) {
            break label1669;
          }
          localObject4 = (hsn)((Iterator)localObject5).next();
          localObject3 = localObject4;
          if (!((hsn)localObject4).before(localhsq))
          {
            if ((((hsn)localObject4).before(localhsq)) || (!((hsn)localObject4).before(localhsn)))
            {
              i += 1;
              localObject3 = localObject4;
              continue;
              ((hsq)localObject4).a(b);
              break;
              label1471:
              ((hso)localObject5).a(b);
              break label679;
              label1487:
              localObject4 = hwn.i((hso)localObject5);
              localObject5 = ((hso)localObject5).iterator();
              while (((Iterator)localObject5).hasNext())
              {
                localObject6 = localhwn.a((hsn)((Iterator)localObject5).next(), true);
                Iterator localIterator2 = localhwn.a().iterator();
                while (localIterator2.hasNext())
                {
                  ((Calendar)localObject6).roll(2, ((Integer)localIterator2.next()).intValue() - 1 - ((Calendar)localObject6).get(2));
                  ((hso)localObject4).a(ich.a(((Calendar)localObject6).getTime(), a));
                }
              }
              break label702;
            }
            if (d > 0)
            {
              localObject3 = localObject4;
              if (localhso2.size() + i >= d) {
                break label1669;
              }
            }
            if (c != null)
            {
              localObject3 = localObject4;
              if (((hsn)localObject4).after(c)) {}
            }
            else
            {
              localhso2.a((hsn)localObject4);
              localObject3 = localObject4;
            }
          }
        }
        label1669:
        j = 0;
        int k = i;
        localObject4 = localObject3;
        label1695:
        int m;
        do
        {
          do
          {
            localhwn.a(localCalendar);
            localObject3 = localObject4;
            i = k;
            break;
            m = j + 1;
            j = m;
            localObject4 = localObject3;
            k = i;
          } while (hwn.a <= 0);
          j = m;
          localObject4 = localObject3;
          k = i;
        } while (m <= hwn.a);
      }
      Collections.sort(localhso2);
      localObject4 = localhso2.iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject3 = a((hsq)((Iterator)localObject4).next());
        if ((((hsq)localObject3).after(paramhsn)) || (!((hsq)localObject3).after((Date)localObject1))) {
          break label1890;
        }
        localObject1 = localObject3;
        localhso1.a((hsn)localObject3);
      }
    }
    Collections.sort(localhso1);
    c = new long[localhso1.size()];
    d = new hsq[c.length];
    int i = 0;
    for (;;)
    {
      paramhsn = (hsn)localObject1;
      if (i >= c.length) {
        break;
      }
      paramhsn = (hsq)localhso1.get(i);
      c[i] = paramhsn.getTime();
      d[i] = paramhsn;
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     hxc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */