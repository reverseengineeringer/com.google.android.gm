import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Account;

final class cit
  implements LoaderManager.LoaderCallbacks<ccy<Account>>
{
  final String[] a = chh.c;
  final ccx<Account> b = Account.S;
  
  cit(cht paramcht) {}
  
  public final Loader<ccy<Account>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      cvm.f(cht.I, "Got an id  (%d) that I cannot create!", new Object[] { Integer.valueOf(paramInt) });
      return null;
    case 0: 
      cvm.b(cht.I, "LOADER_ACCOUNT_CURSOR created", new Object[0]);
      return new ccz(c.h, cgr.b(), a, b);
    }
    cvm.b(cht.I, "LOADER_ACCOUNT_UPDATE_CURSOR created", new Object[0]);
    return new ccz(c.h, c.c.g, a, b);
  }
  
  public final void onLoaderReset(Loader<ccy<Account>> paramLoader) {}
}

/* Location:
 * Qualified Name:     cit
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */