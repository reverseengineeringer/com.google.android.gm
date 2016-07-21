import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.google.android.gm.welcome.WelcomeTourState;

public final class eau
  implements LoaderManager.LoaderCallbacks<WelcomeTourState>
{
  static final String a = cvl.a;
  private final Activity b;
  private final eaw c;
  private final ccy<Account> d;
  
  public eau(Activity paramActivity, eaw parameaw, ccy<Account> paramccy)
  {
    b = paramActivity;
    c = parameaw;
    d = paramccy;
  }
  
  public static cjq a(Activity paramActivity, LoaderManager paramLoaderManager, eaw parameaw)
  {
    paramLoaderManager = new eav(paramActivity, parameaw, paramLoaderManager);
    return new cjq(paramActivity, cgr.b(), paramLoaderManager);
  }
  
  public final Loader<WelcomeTourState> onCreateLoader(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      cvm.f(a, "Got an id  (%d) that I cannot create", new Object[] { Integer.valueOf(paramInt) });
      return null;
    }
    return new eat(b, d);
  }
  
  public final void onLoaderReset(Loader<WelcomeTourState> paramLoader) {}
}

/* Location:
 * Qualified Name:     eau
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */