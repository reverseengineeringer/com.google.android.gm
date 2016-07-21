import android.os.Build.VERSION;

public final class eb
{
  public static final ed a = new ec();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new eg();
      return;
    }
    if (Build.VERSION.SDK_INT >= 15)
    {
      a = new ef();
      return;
    }
    if (Build.VERSION.SDK_INT >= 14)
    {
      a = new ee();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     eb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */