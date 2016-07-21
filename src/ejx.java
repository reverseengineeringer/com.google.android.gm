import com.google.android.gms.common.ConnectionResult;

final class ejx
  extends ekp
{
  ejx(ejw paramejw, ekt paramekt, eju parameju, ConnectionResult paramConnectionResult)
  {
    super(paramekt);
  }
  
  public final void a()
  {
    eju localeju = a;
    ConnectionResult localConnectionResult = b;
    if (localeju.b(2))
    {
      if (localConnectionResult.b()) {
        localeju.h();
      }
    }
    else {
      return;
    }
    if (localeju.a(localConnectionResult))
    {
      localeju.i();
      localeju.h();
      return;
    }
    localeju.b(localConnectionResult);
  }
}

/* Location:
 * Qualified Name:     ejx
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */