import android.os.Build.VERSION;

public final class yq
{
  public static final yw a = new ys();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 23)
    {
      a = new yr();
      return;
    }
    if (i >= 18)
    {
      a = new yu();
      return;
    }
    if (i >= 17)
    {
      a = new yt();
      return;
    }
    if (i >= 16)
    {
      a = new yv();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     yq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */