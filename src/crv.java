import android.app.Fragment;
import android.app.LoaderManager;
import android.content.Intent;
import android.os.Bundle;
import com.android.mail.providers.Account;
import com.android.mail.ui.settings.GeneralPrefsFragment;
import java.lang.ref.WeakReference;

public class crv
  extends crx
{
  public WeakReference<GeneralPrefsFragment> a;
  public Account[] b;
  
  public final Account a()
  {
    Intent localIntent = getIntent();
    Account localAccount2 = (Account)localIntent.getParcelableExtra("current-account");
    Account localAccount1 = localAccount2;
    if (localAccount2 == null) {
      localAccount1 = (Account)localIntent.getParcelableExtra("mail_account");
    }
    return localAccount1;
  }
  
  public boolean isValidFragment(String paramString)
  {
    return true;
  }
  
  public void onAttachFragment(Fragment paramFragment)
  {
    super.onAttachFragment(paramFragment);
    if ((paramFragment instanceof GeneralPrefsFragment)) {
      a = new WeakReference((GeneralPrefsFragment)paramFragment);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = super.b().a();
    if (paramBundle != null)
    {
      paramBundle.a();
      paramBundle.c();
    }
    getLoaderManager().initLoader(0, null, new crw(this));
  }
}

/* Location:
 * Qualified Name:     crv
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */