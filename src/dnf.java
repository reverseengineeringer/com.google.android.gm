import android.app.Activity;
import android.os.AsyncTask;
import android.view.MenuItem;
import com.android.mail.providers.Account;

public final class dnf
{
  public static boolean a(MenuItem paramMenuItem, Activity paramActivity, Account paramAccount, Account[] paramArrayOfAccount, dng paramdng)
  {
    int i = paramMenuItem.getItemId();
    buo.a().a("menu_item", i, paramdng.getClass().getName());
    if (i == dfy.bN)
    {
      paramMenuItem = dmv.a().b(paramActivity);
      if (dfh.a != null) {
        dfh.a.cancel(false);
      }
      dfh.a = new dfi(paramMenuItem);
      dfh.a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
      return true;
    }
    if (i == dfy.bg)
    {
      dev.a(paramActivity);
      new dyv().a(paramActivity, paramAccount, paramdng.F_(), paramArrayOfAccount);
      return true;
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     dnf
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */