import android.content.ComponentName;
import android.content.Intent;
import android.os.Build.VERSION;

public final class jt
{
  private static final ju a = new jv();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (i >= 15)
    {
      a = new jx();
      return;
    }
    if (i >= 11)
    {
      a = new jw();
      return;
    }
  }
  
  public static Intent a(ComponentName paramComponentName)
  {
    return a.a(paramComponentName);
  }
}

/* Location:
 * Qualified Name:     jt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */