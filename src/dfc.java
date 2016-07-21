import android.app.Application;

final class dfc
  extends gni
{
  private final ehi a;
  
  dfc(Application paramApplication)
  {
    a = new ehi(paramApplication, "GMAIL_ANDROID_PRIMES");
  }
  
  protected final void a_(hri paramhri)
  {
    if (cvm.a("Gmail", 3)) {
      cvm.b("Gmail", "Memory metrics - %s", new Object[] { paramhri.toString() });
    }
    new ehk(a, hlt.a(paramhri)).a();
  }
}

/* Location:
 * Qualified Name:     dfc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */