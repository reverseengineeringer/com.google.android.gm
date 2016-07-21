import android.os.Build.VERSION;
import android.os.CancellationSignal;

public final class mb
{
  public boolean a;
  public Object b;
  public boolean c;
  
  public final boolean a()
  {
    try
    {
      boolean bool = a;
      return bool;
    }
    finally {}
  }
  
  public final Object b()
  {
    if (Build.VERSION.SDK_INT < 16) {
      return null;
    }
    try
    {
      if (b == null)
      {
        b = new CancellationSignal();
        if (a) {
          ((CancellationSignal)b).cancel();
        }
      }
      Object localObject1 = b;
      return localObject1;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     mb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */