import android.os.SystemClock;
import java.util.Map;

public final class buq
{
  public static final buq b = new buq();
  public final Map<String, Long> a = hhk.e();
  
  public final long a(String paramString1, boolean paramBoolean, String paramString2, String paramString3, String paramString4)
  {
    if (paramBoolean)
    {
      paramString4 = (Long)a.remove(paramString1);
      if (paramString4 != null) {
        break label83;
      }
      paramString1 = String.valueOf(paramString1);
      if (paramString1.length() == 0) {
        break label70;
      }
    }
    label70:
    for (paramString1 = "Trying to log id that doesn't exist: ".concat(paramString1);; paramString1 = new String("Trying to log id that doesn't exist: "))
    {
      throw new IllegalStateException(paramString1);
      paramString4 = (Long)a.get(paramString1);
      break;
    }
    label83:
    long l = SystemClock.uptimeMillis() - paramString4.longValue();
    buo.a().a(paramString2, l, paramString3, null);
    return l;
  }
  
  public final void a(String paramString)
  {
    a.put(paramString, Long.valueOf(SystemClock.uptimeMillis()));
  }
  
  public final void a(String paramString1, boolean paramBoolean, String paramString2, String paramString3)
  {
    try
    {
      a(paramString1, paramBoolean, paramString2, paramString3, null);
      return;
    }
    catch (IllegalStateException paramString1) {}
  }
  
  public final void b(String paramString)
  {
    a.remove(paramString);
  }
}

/* Location:
 * Qualified Name:     buq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */