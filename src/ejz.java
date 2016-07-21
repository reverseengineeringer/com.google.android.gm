import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;

final class ejz
  extends ekp
{
  ejz(ejy paramejy, ekt paramekt, eju parameju, ResolveAccountResponse paramResolveAccountResponse)
  {
    super(paramekt);
  }
  
  public final void a()
  {
    eju localeju = a;
    ResolveAccountResponse localResolveAccountResponse = b;
    ConnectionResult localConnectionResult;
    if (localeju.b(0))
    {
      localConnectionResult = c;
      if (localConnectionResult.b())
      {
        g = emf.a(b);
        f = true;
        h = d;
        i = e;
        localeju.f();
      }
    }
    else
    {
      return;
    }
    if (localeju.a(localConnectionResult))
    {
      localeju.i();
      localeju.f();
      return;
    }
    localeju.b(localConnectionResult);
  }
}

/* Location:
 * Qualified Name:     ejz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */