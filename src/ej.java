import android.os.Build.VERSION;

public final class ej
{
  public static final ek a = new el();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 12)
    {
      a = new em();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     ej
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */