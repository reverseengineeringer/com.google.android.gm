import android.app.ActionBar;
import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;

public class coj
  extends Activity
{
  private static final String a = cvl.a;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(bue.N);
    paramBundle = getActionBar();
    Object localObject;
    if (paramBundle != null)
    {
      paramBundle.setDisplayHomeAsUpEnabled(true);
      paramBundle.setTitle(buj.cf);
      localObject = getPackageManager();
      if (localObject == null) {}
    }
    try
    {
      String str = getString(buj.p);
      localObject = ((PackageManager)localObject).getPackageInfo(getPackageName(), 0);
      paramBundle.setSubtitle(getString(buj.fB, new Object[] { str, versionName }));
      return;
    }
    catch (PackageManager.NameNotFoundException paramBundle)
    {
      cvm.f(a, paramBundle, "Unable to locate application version.", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     coj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */