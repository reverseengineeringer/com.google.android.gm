import android.os.Build.VERSION;
import android.os.Bundle;

public final class is
  extends jb
{
  public static final iv a;
  public static final jc b;
  private final String c;
  private final CharSequence d;
  private final CharSequence[] e;
  private final boolean f;
  private final Bundle g;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 20) {
      a = new iw();
    }
    for (;;)
    {
      b = new it();
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        a = new iy();
      } else {
        a = new ix();
      }
    }
  }
  
  public is(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    c = paramString;
    d = paramCharSequence;
    e = paramArrayOfCharSequence;
    f = paramBoolean;
    g = paramBundle;
  }
  
  public final String a()
  {
    return c;
  }
  
  public final CharSequence b()
  {
    return d;
  }
  
  public final CharSequence[] c()
  {
    return e;
  }
  
  public final boolean d()
  {
    return f;
  }
  
  public final Bundle e()
  {
    return g;
  }
}

/* Location:
 * Qualified Name:     is
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */