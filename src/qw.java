import android.os.Build.VERSION;

public final class qw
{
  public static final qz a = new qx();
  
  static
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      a = new qy();
      return;
    }
  }
}

/* Location:
 * Qualified Name:     qw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */