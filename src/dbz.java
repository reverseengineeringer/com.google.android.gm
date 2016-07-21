import java.text.ParseException;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class dbz
  extends hrl
{
  public dbz(hwr paramhwr)
  {
    super(paramhwr);
  }
  
  private final void a(hwm paramhwm)
  {
    paramhwm = paramhwm.iterator();
    while (paramhwm.hasNext())
    {
      Object localObject1 = paramhwm.next();
      if ((localObject1 instanceof iae))
      {
        localObject1 = (iae)localObject1;
        Object localObject2 = c;
        if ((localObject2 instanceof hsq))
        {
          localObject2 = (hsq)localObject2;
          Object localObject3 = ((iae)localObject1).a("TZID");
          if (localObject3 != null)
          {
            localObject3 = a.a(((hsy)localObject3).a());
            if (localObject3 != null)
            {
              Object localObject4 = ((hsq)localObject2).toString();
              Matcher localMatcher = dcb.a.matcher((CharSequence)localObject4);
              if (!localMatcher.matches()) {
                throw new NumberFormatException(String.valueOf(localObject4).length() + 12 + "Bad date: \"" + (String)localObject4 + "\"");
              }
              localObject4 = new GregorianCalendar(Integer.parseInt(localMatcher.group(1)), Integer.parseInt(localMatcher.group(2)) - 1, Integer.parseInt(localMatcher.group(3)), Integer.parseInt(localMatcher.group(4)), Integer.parseInt(localMatcher.group(5)), Integer.parseInt(localMatcher.group(6)));
              ((GregorianCalendar)localObject4).setTimeZone((TimeZone)localObject3);
              ((hsq)localObject2).setTime(((GregorianCalendar)localObject4).getTimeInMillis());
              ((iae)localObject1).a((hwq)localObject3);
            }
          }
        }
      }
    }
  }
  
  public final hsc a(hrz paramhrz)
  {
    paramhrz = super.a(paramhrz);
    try
    {
      a(a);
      Iterator localIterator = b.iterator();
      while (localIterator.hasNext()) {
        a(nextb);
      }
      return paramhrz;
    }
    catch (ParseException paramhrz)
    {
      throw new hry("Builder can't fix time property", 0, paramhrz);
    }
  }
}

/* Location:
 * Qualified Name:     dbz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */