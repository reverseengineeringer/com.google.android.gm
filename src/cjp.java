import android.app.LoaderManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.mail.providers.Account;

public class cjp
  extends zh
  implements bvz, cjr
{
  private MenuItem l;
  public Uri m;
  public Account n;
  
  public final Account a()
  {
    return n;
  }
  
  public final void a(ccy<Account> paramccy)
  {
    if ((paramccy != null) && (paramccy.moveToFirst())) {
      n = ((Account)paramccy.f());
    }
  }
  
  public void a(String paramString)
  {
    cxa.a(this, n, paramString);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(bue.a);
    f().a().b(true);
    m = ((Uri)getIntent().getParcelableExtra("extra-account-uri"));
    if (m != null) {
      getLoaderManager().initLoader(0, Bundle.EMPTY, new cjq(this, m, this));
    }
  }
  
  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    if (m == null) {
      return false;
    }
    getMenuInflater().inflate(buf.a, paramMenu);
    l = paramMenu.findItem(buc.bO);
    return true;
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == 16908332) {
      finish();
    }
    for (;;)
    {
      return true;
      if (i == buc.eG)
      {
        cxa.a(this, n);
      }
      else
      {
        if (i != buc.bO) {
          break;
        }
        a(getString(buj.cV));
      }
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    MenuItem localMenuItem;
    if (l != null)
    {
      localMenuItem = l;
      if ((n == null) || (!n.a(32768L))) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      localMenuItem.setVisible(bool);
      return super.onPrepareOptionsMenu(paramMenu);
    }
  }
}

/* Location:
 * Qualified Name:     cjp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */