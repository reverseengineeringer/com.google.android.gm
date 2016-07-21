import android.os.Build.VERSION;
import android.view.ViewGroup;

public final class sf
{
  public static final si a = new sl();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new sk();
      return;
    }
    if (i >= 18)
    {
      a = new sj();
      return;
    }
    if (i >= 14)
    {
      a = new sh();
      return;
    }
    if (i >= 11)
    {
      a = new sg();
      return;
    }
  }
  
  public static int a(ViewGroup paramViewGroup)
  {
    return a.a(paramViewGroup);
  }
}

/* Location:
 * Qualified Name:     sf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */