import android.content.Context;
import android.os.Build.VERSION;

public final class mo
{
  public mr a;
  
  public mo(Context paramContext)
  {
    if (a())
    {
      a = new mp(paramContext);
      return;
    }
    a = new mq();
  }
  
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 19;
  }
}

/* Location:
 * Qualified Name:     mo
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */