import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public final class avm
  extends DialogFragment
{
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    String str = getArguments().getString("NoteDialogFragment.AccountName");
    setCancelable(true);
    return new AlertDialog.Builder(paramBundle).setIconAttribute(16843605).setTitle(arh.h).setMessage(paramBundle.getString(arh.g, new Object[] { str })).setPositiveButton(17039370, null).create();
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    paramDialogInterface = (avn)getActivity();
    if (paramDialogInterface != null)
    {
      paramDialogInterface.q();
      return;
    }
    cvm.b(cvm.a, "Null callback in DuplicateAccount dialog onDismiss", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     avm
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */