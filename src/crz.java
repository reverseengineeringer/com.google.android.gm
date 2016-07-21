import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceActivity.Header;
import android.text.TextUtils;
import android.view.MenuItem;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class crz
  extends crx
{
  Uri b;
  public Account c;
  public int d;
  final List<cuq> e = new ArrayList();
  
  public static Intent a(Context paramContext, Class paramClass, Account paramAccount, Uri paramUri, int paramInt)
  {
    paramContext = new Intent(paramContext, paramClass);
    paramContext.putExtra("ACCOUNT", paramAccount);
    paramContext.putExtra("FOLDERS_URI", paramUri);
    paramContext.putExtra("INBOX_ID", paramInt);
    return paramContext;
  }
  
  public abstract PreferenceActivity.Header a();
  
  public abstract void a(PreferenceActivity.Header paramHeader, Folder paramFolder);
  
  public void onBuildHeaders(List<PreferenceActivity.Header> paramList)
  {
    if (e.isEmpty()) {
      paramList.add(a());
    }
    for (;;)
    {
      return;
      Iterator localIterator = e.iterator();
      while (localIterator.hasNext())
      {
        cuq localcuq = (cuq)localIterator.next();
        Folder localFolder = a;
        PreferenceActivity.Header localHeader = new PreferenceActivity.Header();
        if (TextUtils.isEmpty(c)) {}
        for (title = d;; title = cup.a(c, this))
        {
          a(localHeader, localFolder);
          if (a != d) {
            break label136;
          }
          paramList.add(0, localHeader);
          break;
        }
        label136:
        paramList.add(localHeader);
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    d = getIntent().getIntExtra("INBOX_ID", -1);
    c = ((Account)getIntent().getParcelableExtra("ACCOUNT"));
    b = ((Uri)getIntent().getParcelableExtra("FOLDERS_URI"));
    if (b != null) {
      getLoaderManager().initLoader(0, null, new csa(this));
    }
    super.onCreate(paramBundle);
    paramBundle = super.b().a();
    if (paramBundle != null)
    {
      paramBundle.a(4, 4);
      paramBundle.a();
      paramBundle.c();
    }
  }
  
  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    if (paramMenuItem.getItemId() == 16908332)
    {
      onBackPressed();
      return true;
    }
    return super.onOptionsItemSelected(paramMenuItem);
  }
}

/* Location:
 * Qualified Name:     crz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */