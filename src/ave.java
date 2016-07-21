import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public final class ave
  extends DialogFragment
  implements awi
{
  private String a;
  
  public final void a(String paramString)
  {
    a = paramString;
    paramString = (AlertDialog)getDialog();
    if ((paramString != null) && (a != null)) {
      paramString.setMessage(a);
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    paramDialogInterface = (avg)getActivity();
    if (paramDialogInterface != null)
    {
      paramDialogInterface.d();
      return;
    }
    cvm.b(cvm.a, "Null callback in CheckSettings dialog onCancel", new Object[0]);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    Activity localActivity = getActivity();
    if (paramBundle != null) {
      a = paramBundle.getString("CheckProgressDialog.Progress");
    }
    if (a == null)
    {
      int i = aro.a(getArguments().getInt("CheckProgressDialog.Mode"));
      a = aro.a(getActivity(), i);
    }
    setCancelable(false);
    paramBundle = new ProgressDialog(localActivity);
    paramBundle.setIndeterminate(true);
    paramBundle.setMessage(a);
    paramBundle.setButton(-2, localActivity.getString(17039360), new avf(this));
    return paramBundle;
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putString("CheckProgressDialog.Progress", a);
  }
}

/* Location:
 * Qualified Name:     ave
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */