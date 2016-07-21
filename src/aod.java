import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.SystemClock;
import android.os.Vibrator;
import android.provider.Settings.System;

public final class aod
{
  final Context a;
  boolean b;
  private final ContentObserver c;
  private Vibrator d;
  private long e;
  
  public aod(Context paramContext)
  {
    a = paramContext;
    c = new aoe(this);
  }
  
  static boolean a(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "haptic_feedback_enabled", 0) == 1;
  }
  
  public final void a()
  {
    d = ((Vibrator)a.getSystemService("vibrator"));
    b = a(a);
    Uri localUri = Settings.System.getUriFor("haptic_feedback_enabled");
    a.getContentResolver().registerContentObserver(localUri, false, c);
  }
  
  public final void b()
  {
    d = null;
    a.getContentResolver().unregisterContentObserver(c);
  }
  
  public final void c()
  {
    if ((d != null) && (b))
    {
      long l = SystemClock.uptimeMillis();
      if (l - e >= 125L)
      {
        d.vibrate(5L);
        e = l;
      }
    }
  }
}

/* Location:
 * Qualified Name:     aod
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */