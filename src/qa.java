import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class qa
{
  public static final qb a = new qc();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      a = new qd();
      return;
    }
  }
  
  public static void a(ViewGroup.MarginLayoutParams paramMarginLayoutParams, int paramInt)
  {
    a.a(paramMarginLayoutParams, paramInt);
  }
}

/* Location:
 * Qualified Name:     qa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */