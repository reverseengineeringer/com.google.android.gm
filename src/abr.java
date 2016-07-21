import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

final class abr
{
  static final abs a = new abs();
  final Context b;
  private final LocationManager c;
  
  abr(Context paramContext)
  {
    b = paramContext;
    c = ((LocationManager)paramContext.getSystemService("location"));
  }
  
  static boolean a(abs paramabs)
  {
    return (paramabs != null) && (f > System.currentTimeMillis());
  }
  
  final Location a(String paramString)
  {
    if (c != null) {
      try
      {
        if (c.isProviderEnabled(paramString))
        {
          paramString = c.getLastKnownLocation(paramString);
          return paramString;
        }
      }
      catch (Exception paramString) {}
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     abr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */