import android.accounts.Account;
import android.content.Context;
import com.google.android.gm.welcome.WelcomeTourActivity;

public final class eap
  implements Runnable
{
  private final Context a;
  
  public eap(Context paramContext)
  {
    a = paramContext;
  }
  
  public final void run()
  {
    Account[] arrayOfAccount = new ddy(a).a(new String[] { "mail" });
    int j = arrayOfAccount.length;
    int i = 0;
    while (i < j)
    {
      Account localAccount = arrayOfAccount[i];
      drj localdrj = ba, name).o;
      if (1 > localdrj.d("ix_awtsv")) {
        localdrj.a(hdu.a("ix_awtsv", "1"), true);
      }
      cvm.b(WelcomeTourActivity.a, "Updating server version of welcome tour for %s", new Object[] { name });
      i += 1;
    }
  }
}

/* Location:
 * Qualified Name:     eap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */