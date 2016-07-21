import android.app.Activity;
import android.app.FragmentManager;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import com.android.mail.ui.MailActivity;
import com.google.android.gms.common.ConnectionResult;

public abstract class dyz
  extends dyo
{
  private final Activity a;
  
  public dyz(Activity paramActivity, Bundle paramBundle, int paramInt, String paramString1, String paramString2)
  {
    super(paramBundle, paramInt, paramString1, paramString2);
    a = paramActivity;
  }
  
  static void a(Activity paramActivity, int paramInt1, int paramInt2)
  {
    if (((paramActivity instanceof MailActivity)) && (!u)) {
      return;
    }
    paramActivity = paramActivity.getFragmentManager();
    dys localdys = (dys)paramActivity.findFragmentByTag("error-dialog-tag");
    if (localdys != null) {
      localdys.dismiss();
    }
    localdys = dys.a(paramInt1, paramInt2);
    try
    {
      localdys.show(paramActivity, "error-dialog-tag");
      return;
    }
    catch (IllegalStateException paramActivity) {}
  }
  
  protected final void b(int paramInt)
  {
    a(a, paramInt, d);
  }
  
  protected final void b(ConnectionResult paramConnectionResult)
  {
    try
    {
      paramConnectionResult.a(a, d);
      return;
    }
    catch (IntentSender.SendIntentException paramConnectionResult)
    {
      while (f == null) {}
      f.b();
      b();
    }
  }
}

/* Location:
 * Qualified Name:     dyz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */