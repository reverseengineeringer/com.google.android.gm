import android.content.Context;
import android.content.Intent;

public final class flz
{
  public final fma a;
  
  public flz(fma paramfma)
  {
    enz.a(paramfma, "Callbacks must not be null.");
    a = paramfma;
  }
  
  public static boolean a(Context paramContext, Intent paramIntent)
  {
    enz.a(paramContext, "Context must not be null.");
    enz.a(paramIntent, "Intent must not be null.");
    return paramIntent.hasExtra("com.google.android.gms.accounts.ACCOUNT_DATA");
  }
}

/* Location:
 * Qualified Name:     flz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */