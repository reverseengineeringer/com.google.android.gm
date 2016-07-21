import android.os.Bundle;
import android.support.v4.os.ResultReceiver;

public final class mm
  implements Runnable
{
  final int a;
  final Bundle b;
  
  mm(ResultReceiver paramResultReceiver, int paramInt, Bundle paramBundle)
  {
    a = paramInt;
    b = paramBundle;
  }
  
  public final void run()
  {
    c.a(a, b);
  }
}

/* Location:
 * Qualified Name:     mm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */