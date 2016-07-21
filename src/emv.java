import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;

public final class emv
  extends eno
{
  private emr a;
  private final int b;
  
  public emv(emr paramemr, int paramInt)
  {
    a = paramemr;
    b = paramInt;
  }
  
  public final void a(int paramInt, Bundle paramBundle)
  {
    enz.a(a, "onAccountValidationComplete can be called only once per call to validateAccount");
    emr localemr = a;
    int i = b;
    c.sendMessage(c.obtainMessage(5, i, -1, new ena(localemr, paramInt, paramBundle)));
    a = null;
  }
  
  public final void a(int paramInt, IBinder paramIBinder, Bundle paramBundle)
  {
    enz.a(a, "onPostInitComplete can be called only once per call to getRemoteService");
    a.a(paramInt, paramIBinder, paramBundle, b);
    a = null;
  }
}

/* Location:
 * Qualified Name:     emv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */