import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.google.android.gm.ComposeActivityGmail;

public final class dis
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private boolean a;
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      ((ComposeActivityGmail)getActivity()).g(a);
      buo.a().a("acl_fixer", "none_fixable_dialog", "confirm", 0L);
    }
    while (paramInt != -2) {
      return;
    }
    buo.a().a("acl_fixer", "none_fixable_dialog", "cancel", 0L);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    int i = paramBundle.getInt("numFiles");
    a = paramBundle.getBoolean("showToast");
    paramBundle = getActivity();
    String str = paramBundle.getResources().getQuantityString(dgd.a, i);
    return new AlertDialog.Builder(paramBundle).setMessage(str).setPositiveButton(dge.fs, this).setNegativeButton(dge.bG, this).create();
  }
}

/* Location:
 * Qualified Name:     dis
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */