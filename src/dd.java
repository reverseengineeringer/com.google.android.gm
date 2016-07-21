import android.os.Build.VERSION;

public final class dd
{
  static final cp a = new de();
  private static final df b = new dg();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      b = new dh();
      return;
    }
  }
  
  public static cm a()
  {
    return a.a();
  }
}

/* Location:
 * Qualified Name:     dd
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */