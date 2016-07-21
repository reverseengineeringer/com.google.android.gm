import android.app.Activity;
import android.os.AsyncTask;

public final class dyq
  extends AsyncTask<Void, Void, Void>
{
  private static final String a = cvl.a;
  private eij b;
  private eii c;
  private final Activity d;
  
  public dyq(Activity paramActivity)
  {
    d = paramActivity;
  }
  
  private final Void a()
  {
    try
    {
      gcc.a(d);
      return null;
    }
    catch (eij localeij)
    {
      for (;;)
      {
        dri.e(a, localeij, "Repairable error in ConscryptMailActivityTask", new Object[0]);
        b = localeij;
        buo.a().a("gms_core", "conscrypt_repairable", Integer.toString(a), 0L);
      }
    }
    catch (eii localeii)
    {
      for (;;)
      {
        dri.e(a, localeii, "Unrecoverable error in ConscryptMailActivityTask", new Object[0]);
        c = localeii;
        buo.a().a("gms_core", "conscrypt_gms_core_not_available", Integer.toString(a), 0L);
      }
    }
  }
}

/* Location:
 * Qualified Name:     dyq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */