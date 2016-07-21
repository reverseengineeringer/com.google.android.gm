import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public final class aux
  extends DialogFragment
{
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    getActivity();
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    Object localObject = getArguments();
    String str = ((Bundle)localObject).getString("CheckSettingsErrorDialog.Message");
    int i = ((Bundle)localObject).getInt("CheckSettingsErrorDialog.ExceptionId");
    setCancelable(true);
    localObject = new AlertDialog.Builder(paramBundle).setMessage(str);
    if (i == 1)
    {
      ((AlertDialog.Builder)localObject).setTitle(arh.v);
      if (i != 2) {
        break label125;
      }
      ((AlertDialog.Builder)localObject).setPositiveButton(paramBundle.getString(17039370), new auy(this));
      ((AlertDialog.Builder)localObject).setNegativeButton(paramBundle.getString(17039360), new auz(this));
    }
    for (;;)
    {
      return ((AlertDialog.Builder)localObject).create();
      ((AlertDialog.Builder)localObject).setIconAttribute(16843605).setTitle(paramBundle.getString(arh.aa));
      break;
      label125:
      ((AlertDialog.Builder)localObject).setPositiveButton(paramBundle.getString(arh.X), new ava(this));
    }
  }
}

/* Location:
 * Qualified Name:     aux
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */