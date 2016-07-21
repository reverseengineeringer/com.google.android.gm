import java.text.DateFormat;
import java.util.Map;
import java.util.WeakHashMap;

final class hsr
{
  private final Map a = new WeakHashMap();
  private final DateFormat b;
  
  hsr(DateFormat paramDateFormat)
  {
    b = paramDateFormat;
  }
  
  public final DateFormat a()
  {
    DateFormat localDateFormat2 = (DateFormat)a.get(Thread.currentThread());
    DateFormat localDateFormat1 = localDateFormat2;
    if (localDateFormat2 == null)
    {
      localDateFormat1 = (DateFormat)b.clone();
      a.put(Thread.currentThread(), localDateFormat1);
    }
    return localDateFormat1;
  }
}

/* Location:
 * Qualified Name:     hsr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */