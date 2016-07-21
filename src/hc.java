import android.app.PendingIntent;
import android.os.Bundle;
import java.util.ArrayList;

public final class hc
{
  public ArrayList<is> a;
  private final int b;
  private final CharSequence c;
  private final PendingIntent d;
  private final Bundle e;
  
  public hc(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent)
  {
    this(paramInt, paramCharSequence, paramPendingIntent, new Bundle());
  }
  
  private hc(int paramInt, CharSequence paramCharSequence, PendingIntent paramPendingIntent, Bundle paramBundle)
  {
    b = paramInt;
    c = hf.e(paramCharSequence);
    d = paramPendingIntent;
    e = paramBundle;
  }
  
  public final ha a()
  {
    if (a != null) {}
    for (is[] arrayOfis = (is[])a.toArray(new is[a.size()]);; arrayOfis = null) {
      return new ha(b, c, d, e, arrayOfis);
    }
  }
}

/* Location:
 * Qualified Name:     hc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */