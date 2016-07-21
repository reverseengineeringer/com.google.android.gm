import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;

final class ejw
  extends gcg
{
  private final WeakReference<eju> a;
  
  ejw(eju parameju)
  {
    a = new WeakReference(parameju);
  }
  
  public final void a(ConnectionResult paramConnectionResult, AuthAccountResult paramAuthAccountResult)
  {
    paramAuthAccountResult = (eju)a.get();
    if (paramAuthAccountResult == null) {
      return;
    }
    a.a(new ejx(this, paramAuthAccountResult, paramAuthAccountResult, paramConnectionResult));
  }
}

/* Location:
 * Qualified Name:     ejw
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */