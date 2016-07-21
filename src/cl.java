import android.content.Context;
import android.content.res.TypedArray;

public final class cl
{
  private static final int[] a = { c.b };
  
  public static void a(Context paramContext)
  {
    int i = 0;
    paramContext = paramContext.obtainStyledAttributes(a);
    if (!paramContext.hasValue(0)) {
      i = 1;
    }
    if (paramContext != null) {
      paramContext.recycle();
    }
    if (i != 0) {
      throw new IllegalArgumentException("You need to use a Theme.AppCompat theme (or descendant) with the design library.");
    }
  }
}

/* Location:
 * Qualified Name:     cl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */