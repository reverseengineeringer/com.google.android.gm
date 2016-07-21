import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.email.activity.setup.SetupDataFragment;

public class ath
  extends Activity
  implements awp
{
  public SetupDataFragment a;
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    buo.a().a(10, a.i);
    buo.a().a(11, a.h);
    String str = a.c;
    if (!TextUtils.isEmpty(str)) {
      buo.a().b(str);
    }
    buo.a().a(paramString1, paramString2, paramString3, 0L);
  }
  
  public SetupDataFragment l()
  {
    return a;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle == null)
    {
      paramBundle = getIntent().getExtras();
      if (paramBundle != null)
      {
        a = ((SetupDataFragment)paramBundle.getParcelable("com.android.email.setupdata"));
        if (a != null)
        {
          paramBundle = getFragmentManager().beginTransaction();
          paramBundle.add(a, "setupData");
          paramBundle.commit();
        }
      }
    }
    for (;;)
    {
      if (a == null)
      {
        a = new SetupDataFragment();
        paramBundle = getFragmentManager().beginTransaction();
        paramBundle.add(a, "setupData");
        paramBundle.commit();
      }
      return;
      a = ((SetupDataFragment)getFragmentManager().findFragmentByTag("setupData"));
    }
  }
}

/* Location:
 * Qualified Name:     ath
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */