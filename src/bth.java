import android.content.ContentValues;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public final class bth
{
  public static final String a = cvl.a;
  private final String b = "UTC";
  private final String c = "yyyyMMdd'T'HHmmss";
  private final String d = "yyyyMMdd'T'HHmmss'Z'";
  private final String e = "yyyyMMdd";
  
  private static long a(String paramString, TimeZone paramTimeZone)
  {
    long l = 0L;
    SimpleDateFormat localSimpleDateFormat;
    if (paramString.length() == 8)
    {
      localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd");
      localSimpleDateFormat.setTimeZone(paramTimeZone);
      paramTimeZone = localSimpleDateFormat;
    }
    for (;;)
    {
      try
      {
        l = paramTimeZone.parse(paramString).getTime();
        return l;
      }
      catch (ParseException paramTimeZone)
      {
        cvm.e(a, paramTimeZone, "Illegal dtstart / dtend format: %s", new Object[] { paramString });
      }
      if (paramString.length() == 15)
      {
        localSimpleDateFormat = new SimpleDateFormat("yyyyMMdd'T'HHmmss");
        localSimpleDateFormat.setTimeZone(paramTimeZone);
        paramTimeZone = localSimpleDateFormat;
      }
      else if (paramString.length() == 16)
      {
        paramTimeZone = new SimpleDateFormat("yyyyMMdd'T'HHmmss'Z'");
        paramTimeZone.setTimeZone(TimeZone.getTimeZone("UTC"));
      }
    }
    return 0L;
  }
  
  public final void a(BufferedInputStream paramBufferedInputStream, ContentValues paramContentValues)
  {
    if (Thread.currentThread().getContextClassLoader() == null) {
      Thread.currentThread().setContextClassLoader(getClass().getClassLoader());
    }
    icf.a("ical4j.unfolding.relaxed", true);
    icf.a("ical4j.parsing.relaxed", true);
    icf.a("ical4j.compatibility.outlook", true);
    icf.a("ical4j.compatibility.notes", true);
    localObject1 = new dbz(dca.a.a());
    try
    {
      localObject5 = ((dbz)localObject1).a(paramBufferedInputStream);
      paramBufferedInputStream = TimeZone.getTimeZone("UTC");
      localObject1 = null;
      str = null;
      localObject2 = null;
      localObject3 = null;
      localObject4 = null;
      l2 = 0L;
      l3 = 0L;
      l4 = 0L;
      l1 = 0L;
      localObject6 = (iau)a.a("METHOD");
      if (localObject6 != null) {
        str = ((iau)localObject6).a();
      }
      if (!"COUNTER".equals(str)) {
        break label734;
      }
      localIterator = b.iterator();
    }
    catch (ParseException paramBufferedInputStream)
    {
      String str;
      for (;;)
      {
        Iterator localIterator;
        hxl localhxl;
        iai localiai;
        cvm.d(a, paramBufferedInputStream, "Error parsing ICS file.", new Object[0]);
        return;
        localObject4 = new iak(new hst(1));
        continue;
        l2 = a(((hue)localObject4).a(), paramBufferedInputStream);
        continue;
        l1 = a(((hue)localObject4).a(), paramBufferedInputStream);
      }
      localObject4 = ((hue)localObject4).a();
      break label808;
      if (localObject1 == null) {
        break label645;
      }
      paramContentValues.put("uid", (String)localObject1);
      if (localObject2 == null) {
        break label659;
      }
      paramContentValues.put("title", (String)localObject2);
      if (localObject3 == null) {
        break label673;
      }
      paramContentValues.put("comment", (String)localObject3);
      if (localObject4 == null) {
        break label687;
      }
      paramContentValues.put("recurrenceRule", (String)localObject4);
      paramContentValues.put("originalStart", Long.valueOf(l4));
      paramContentValues.put("originalEnd", Long.valueOf(l1));
      paramContentValues.put("dtstart", Long.valueOf(l2));
      paramContentValues.put("dtend", Long.valueOf(l3));
      paramContentValues.put("method", str);
      return;
    }
    catch (hry paramBufferedInputStream)
    {
      for (;;) {}
    }
    catch (NullPointerException paramBufferedInputStream)
    {
      for (;;) {}
    }
    catch (NumberFormatException paramBufferedInputStream)
    {
      for (;;)
      {
        continue;
        long l5 = l3;
        long l6 = l2;
        Object localObject5 = localObject2;
        Object localObject6 = localObject1;
        long l2 = l1;
        long l3 = l4;
        long l4 = l5;
        long l1 = l6;
        localObject1 = localObject4;
        Object localObject2 = localObject3;
        Object localObject3 = localObject5;
        Object localObject4 = localObject6;
        break label846;
        continue;
        localObject5 = localObject4;
        localObject6 = localObject3;
        l5 = l1;
        localObject4 = localObject1;
        localObject3 = localObject2;
        localObject2 = localObject6;
        localObject1 = localObject5;
        l1 = l3;
        l3 = l2;
        l2 = l5;
        localObject5 = localObject4;
        localObject6 = localObject3;
        l5 = l4;
        l4 = l2;
        l2 = l1;
        localObject4 = localObject1;
        l1 = l4;
        l4 = l3;
        l3 = l5;
        localObject3 = localObject2;
        localObject2 = localObject6;
        localObject1 = localObject5;
      }
    }
    catch (IOException paramBufferedInputStream)
    {
      label278:
      label295:
      label506:
      label516:
      label526:
      for (;;) {}
    }
    if (localIterator.hasNext())
    {
      localObject6 = (hsj)localIterator.next();
      if ("VTIMEZONE".equals(a))
      {
        localObject5 = ((hsj)localObject6).b("TZID").a();
        if ((localObject5 == null) || (!btk.a.containsKey(localObject5))) {
          break label805;
        }
        paramBufferedInputStream = TimeZone.getTimeZone((String)btk.a.get(localObject5));
        break label805;
      }
      if (!"VEVENT".equals(a)) {
        break label756;
      }
      localObject1 = ((hsj)localObject6).b("UID");
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = ((hsj)localObject6).b("SUMMARY");
        if (localObject2 != null) {
          break label506;
        }
        localObject2 = null;
        localObject3 = ((hsj)localObject6).b("COMMENT");
        if (localObject3 != null) {
          break label516;
        }
        localObject3 = null;
        l3 = ac.getTime();
        localhxl = (hxl)localObject6;
        localObject5 = (iag)localhxl.b("DTEND");
        localObject4 = localObject5;
        if (localObject5 == null)
        {
          localObject4 = localObject5;
          if (localhxl.a() != null)
          {
            localiai = localhxl.a();
            if (localhxl.b() == null) {
              break label526;
            }
          }
        }
      }
      for (localObject4 = localhxl.b();; localObject4 = new iak(new hst(0)))
      {
        localObject5 = new iag(ich.a(c.a(c), (hzm)localiai.a("VALUE")));
        localObject4 = localObject5;
        if (localiai.b())
        {
          ((iag)localObject5).a(true);
          localObject4 = localObject5;
        }
        l4 = c.getTime();
        localObject4 = ((hsj)localObject6).b("X-MS-OLK-ORIGINALSTART");
        if (localObject4 != null) {
          break label594;
        }
        l2 = 0L;
        localObject4 = ((hsj)localObject6).b("X-MS-OLK-ORIGINALEND");
        if (localObject4 != null) {
          break label608;
        }
        l1 = 0L;
        localObject4 = ((hsj)localObject6).b("RRULE");
        if (localObject4 != null) {
          break label621;
        }
        localObject4 = null;
        break label808;
        localObject1 = ((hue)localObject1).a();
        break;
        localObject2 = ((hue)localObject2).a();
        break label278;
        localObject3 = ((hue)localObject3).a();
        break label295;
        if (!(c instanceof hsq)) {
          break label574;
        }
      }
    }
  }
}

/* Location:
 * Qualified Name:     bth
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */