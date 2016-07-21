import android.content.Context;
import com.google.android.gm.MailMigrationApplication;

public final class dfp
  extends bhf
{
  public dfp(MailMigrationApplication paramMailMigrationApplication) {}
  
  public final void a(Context paramContext)
  {
    try
    {
      if (ghz.a(paramContext.getContentResolver(), "gmail_enable_conscrypt_provider", true)) {
        gcc.a(paramContext);
      }
      return;
    }
    catch (eij localeij)
    {
      cvm.e(cvm.a, localeij, "Repairable error from installIfNeeded, in runHttpRequest", new Object[0]);
      eik.a(a, paramContext);
      return;
    }
    catch (eii paramContext)
    {
      cvm.e(cvm.a, paramContext, "Unrecoverable error from installIfNeeded, in runHttpRequest", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     dfp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */