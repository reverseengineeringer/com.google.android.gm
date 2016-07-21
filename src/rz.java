import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class rz
{
  public static final se a = new sa();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new sd();
      return;
    }
    if (Build.VERSION.SDK_INT >= 11)
    {
      a = new sc();
      return;
    }
    if (Build.VERSION.SDK_INT >= 8)
    {
      a = new sb();
      return;
    }
  }
  
  public static boolean a(ViewConfiguration paramViewConfiguration)
  {
    return a.b(paramViewConfiguration);
  }
}

/* Location:
 * Qualified Name:     rz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */