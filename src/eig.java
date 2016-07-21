import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;

public final class eig
  extends DialogFragment
{
  Dialog a = null;
  DialogInterface.OnCancelListener b = null;
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (b != null) {
      b.onCancel(paramDialogInterface);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    if (a == null) {
      setShowsDialog(false);
    }
    return a;
  }
  
  public final void show(FragmentManager paramFragmentManager, String paramString)
  {
    super.show(paramFragmentManager, paramString);
  }
}

/* Location:
 * Qualified Name:     eig
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */