import android.os.Build.VERSION;

public final class es
{
  public static final eu a = new eu();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      a = new et();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     es
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */