import android.app.LoaderManager.LoaderCallbacks;
import android.content.Context;
import android.content.Loader;
import android.net.Uri;
import android.os.Bundle;
import com.android.mail.providers.Account;

public final class cjq
  implements LoaderManager.LoaderCallbacks<ccy<Account>>
{
  private final Context a;
  private final Uri b;
  private final cjr c;
  
  public cjq(Context paramContext, Uri paramUri, cjr paramcjr)
  {
    a = paramContext;
    b = paramUri;
    c = paramcjr;
  }
  
  public final Loader<ccy<Account>> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    paramBundle = chh.c;
    ccx localccx = Account.S;
    return new ccz(a, b, paramBundle, localccx);
  }
  
  public final void onLoaderReset(Loader<ccy<Account>> paramLoader) {}
}

/* Location:
 * Qualified Name:     cjq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */