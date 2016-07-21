import android.os.Build.VERSION;

public final class na
{
  static final nb a = new nc();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new ne();
      return;
    }
    if (i >= 14)
    {
      a = new nd();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     na
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */