import android.app.PendingIntent;
import android.os.Bundle;

public final class ha
  extends hz
{
  public static final ia d = new hb();
  public int a;
  public CharSequence b;
  public PendingIntent c;
  private final Bundle e;
  private final is[] f;
  
  ha(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle, is[] paramArrayOfis)
  {
    a = paramInt;
    b = hf.e(paramCharSequence);
    c = paramPendingIntent;
    if (paramBundle != null) {}
    for (;;)
    {
      e = paramBundle;
      f = paramArrayOfis;
      return;
      paramBundle = new Bundle();
    }
  }
  
  public final int a()
  {
    return a;
  }
  
  public final CharSequence b()
  {
    return b;
  }
  
  public final PendingIntent c()
  {
    return c;
  }
  
  public final Bundle d()
  {
    return e;
  }
}

/* Location:
 * Qualified Name:     ha
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */