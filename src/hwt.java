import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class hwt
  implements hwr
{
  private static final Pattern a = Pattern.compile("(?<=/)[^/]*/[^/]*$");
  private static final Map b = new hpl((byte)0);
  private static final Properties c = new Properties();
  private Map d;
  private String e;
  
  static
  {
    Object localObject2;
    try
    {
      localObject2 = icn.b("net/fortuna/ical4j/model/tz.alias");
      Object localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = icn.b("java/net/fortuna/ical4j/model/tz.alias");
      }
      c.load((InputStream)localObject1);
      String str1;
      str2 = "Error loading custom timezone aliases: ".concat(str2);
    }
    catch (IOException localIOException)
    {
      try
      {
        c.load(icn.b("tz.alias"));
        return;
      }
      catch (Exception localException)
      {
        localObject2 = LogFactory.getLog(hwt.class);
        str2 = String.valueOf(localException.getMessage());
        if (str2.length() == 0) {
          break label155;
        }
      }
      localIOException = localIOException;
      localObject2 = LogFactory.getLog(hwt.class);
      str1 = String.valueOf(localIOException.getMessage());
      if (str1.length() != 0) {}
      for (str1 = "Error loading timezone aliases: ".concat(str1);; str1 = new String("Error loading timezone aliases: "))
      {
        ((Log)localObject2).warn(str1);
        break;
      }
    }
    for (;;)
    {
      ((Log)localObject2).debug(str2);
      return;
      label155:
      String str2 = new String("Error loading custom timezone aliases: ");
    }
  }
  
  public hwt()
  {
    this("zoneinfo/");
  }
  
  private hwt(String paramString)
  {
    e = paramString;
    d = new hpl((byte)0);
  }
  
  private static hyc a(hyc paramhyc)
  {
    Object localObject = (iby)paramhyc.b("TZURL");
    Log localLog;
    if (localObject != null) {
      try
      {
        localObject = (hyc)new hrl().a(c.toURL().openStream()).a("VTIMEZONE");
        if (localObject != null) {
          return (hyc)localObject;
        }
      }
      catch (Exception localException)
      {
        localLog = LogFactory.getLog(hwt.class);
        localObject = String.valueOf(((ibu)paramhyc.b("TZID")).a());
        if (((String)localObject).length() == 0) {}
      }
    }
    for (localObject = "Unable to retrieve updates for timezone: ".concat((String)localObject);; localObject = new String("Unable to retrieve updates for timezone: "))
    {
      localLog.warn(localObject, localException);
      return paramhyc;
    }
  }
  
  public final hwq a(String paramString)
  {
    hwq localhwq;
    for (Object localObject = paramString;; localObject = paramString)
    {
      localhwq = (hwq)d.get(localObject);
      paramString = localhwq;
      if (localhwq != null) {
        break label209;
      }
      localhwq = (hwq)b.get(localObject);
      paramString = localhwq;
      if (localhwq != null) {
        break label209;
      }
      paramString = c.getProperty((String)localObject);
      if (paramString == null) {
        break;
      }
    }
    synchronized (b)
    {
      localhwq = (hwq)b.get(localObject);
      paramString = localhwq;
      if (localhwq != null) {}
    }
    for (;;)
    {
      try
      {
        paramString = e;
        paramString = icn.a(String.valueOf(paramString).length() + 4 + String.valueOf(localObject).length() + paramString + (String)localObject + ".ics");
        if (paramString != null)
        {
          paramString = (hyc)new hrl().a(paramString.openStream()).a("VTIMEZONE");
          if (!"false".equals(icg.a("net.fortuna.ical4j.timezone.update.enabled")))
          {
            paramString = a(paramString);
            if (paramString == null) {
              continue;
            }
            paramString = new hwq(paramString);
          }
        }
      }
      catch (Exception localException1)
      {
        label209:
        paramString = localhwq;
      }
      try
      {
        b.put(paramString.getID(), paramString);
        return paramString;
      }
      catch (Exception localException2)
      {
        for (;;) {}
      }
      continue;
      paramString = null;
      continue;
      paramString = localhwq;
      if (icf.a("ical4j.parsing.relaxed"))
      {
        localObject = a.matcher((CharSequence)localObject);
        paramString = localhwq;
        if (((Matcher)localObject).find())
        {
          paramString = a(((Matcher)localObject).group());
          return paramString;
          paramString = finally;
          throw paramString;
          LogFactory.getLog(hwt.class).warn("Error occurred loading VTimeZone", localException1);
        }
      }
    }
  }
  
  public final void a(hwq paramhwq)
  {
    d.put(paramhwq.getID(), paramhwq);
  }
}

/* Location:
 * Qualified Name:     hwt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */