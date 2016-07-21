import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.util.Log;

public final class emp
  implements DialogInterface.OnClickListener
{
  private final Activity a;
  private final Fragment b;
  private final Intent c;
  private final int d;
  
  public emp(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    a = paramActivity;
    b = null;
    c = paramIntent;
    d = paramInt;
  }
  
  public emp(Fragment paramFragment, Intent paramIntent, int paramInt)
  {
    a = null;
    b = paramFragment;
    c = paramIntent;
    d = paramInt;
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Fragment localFragment;
    Intent localIntent;
    try
    {
      if ((c == null) || (b == null)) {
        break label95;
      }
      localFragment = b;
      localIntent = c;
      paramInt = d;
      if (C == null) {
        throw new IllegalStateException("Fragment " + localFragment + " not attached to Activity");
      }
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      Log.e("SettingsRedirect", "Can't redirect to app settings for Google Play services");
      return;
    }
    C.a(localFragment, localIntent, paramInt, null);
    for (;;)
    {
      paramDialogInterface.dismiss();
      return;
      label95:
      if (c != null) {
        a.startActivityForResult(c, d);
      }
    }
  }
}

/* Location:
 * Qualified Name:     emp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */