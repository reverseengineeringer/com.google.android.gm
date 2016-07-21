import android.os.Handler;
import com.google.android.gms.common.ConnectionResult;

final class elb
  implements eje
{
  public final int a;
  public final eiz b;
  public final eje c;
  
  public elb(ela paramela, int paramInt, eiz parameiz, eje parameje)
  {
    a = paramInt;
    b = parameiz;
    c = parameje;
    parameiz.a(this);
  }
  
  public final void a(ConnectionResult paramConnectionResult)
  {
    ela.e(d).post(new elc(d, a, paramConnectionResult));
  }
}

/* Location:
 * Qualified Name:     elb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */