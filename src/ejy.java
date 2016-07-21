import com.google.android.gms.common.internal.ResolveAccountResponse;
import java.lang.ref.WeakReference;

final class ejy
  extends enu
{
  private final WeakReference<eju> a;
  
  ejy(eju parameju)
  {
    a = new WeakReference(parameju);
  }
  
  public final void a(ResolveAccountResponse paramResolveAccountResponse)
  {
    eju localeju = (eju)a.get();
    if (localeju == null) {
      return;
    }
    a.a(new ejz(this, localeju, localeju, paramResolveAccountResponse));
  }
}

/* Location:
 * Qualified Name:     ejy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */