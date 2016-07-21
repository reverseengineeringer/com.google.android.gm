import android.app.DialogFragment;
import com.google.android.gm.gmailify.GmailifyUnlinkActivity;

public final class dmb
  implements Runnable
{
  public dmb(GmailifyUnlinkActivity paramGmailifyUnlinkActivity, DialogFragment paramDialogFragment) {}
  
  public final void run()
  {
    try
    {
      a.show(b.getFragmentManager(), "error-dialog-tag");
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      cvm.d(GmailifyUnlinkActivity.a, localIllegalStateException, "GmailifyUnlink: Could not display DialogFragment", new Object[0]);
    }
  }
}

/* Location:
 * Qualified Name:     dmb
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */