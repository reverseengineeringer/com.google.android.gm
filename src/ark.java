import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;

public final class ark
{
  private static ark b;
  public final int[] a;
  private final Paint[] c;
  
  private ark(Context paramContext)
  {
    a = paramContext.getResources().getIntArray(aqz.e);
    c = new Paint[a.length];
    int i = 0;
    while (i < a.length)
    {
      paramContext = new Paint();
      paramContext.setColor(a[i]);
      c[i] = paramContext;
      i += 1;
    }
  }
  
  public static ark a(Context paramContext)
  {
    try
    {
      if (b == null) {
        b = new ark(paramContext);
      }
      paramContext = b;
      return paramContext;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     ark
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */