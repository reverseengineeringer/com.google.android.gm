import android.os.Build.VERSION;

public final class sz
{
  public static final tb a = new te();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 21)
    {
      a = new td();
      return;
    }
    if (i >= 19)
    {
      a = new tc();
      return;
    }
    if (i >= 14)
    {
      a = new ta();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     sz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */