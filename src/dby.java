import android.content.Context;
import android.os.Bundle;

public final class dby<T>
  implements Runnable
{
  private final Context a;
  private final Bundle b;
  private final dbx<T> c;
  
  public dby(Context paramContext, Bundle paramBundle, dbx<T> paramdbx)
  {
    a = paramContext;
    b = paramBundle;
    c = paramdbx;
  }
  
  public final void run()
  {
    c.a(a, b);
  }
}

/* Location:
 * Qualified Name:     dby
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */