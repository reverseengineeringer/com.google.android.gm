import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;

public final class eml<T extends IInterface>
  extends emr<T>
{
  private final eiv<T> f;
  
  public eml(Context paramContext, Looper paramLooper, int paramInt, ejc paramejc, eje parameje, emc paramemc, eiv parameiv)
  {
    super(paramContext, paramLooper, paramInt, paramemc, paramejc, parameje);
    f = parameiv;
  }
  
  protected final T a(IBinder paramIBinder)
  {
    return f.c();
  }
  
  protected final String a()
  {
    return f.a();
  }
  
  protected final String b()
  {
    return f.b();
  }
}

/* Location:
 * Qualified Name:     eml
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */