import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public final class awk
  extends DialogFragment
{
  public static awk a(String paramString)
  {
    awk localawk = new awk();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("SecurityRequiredDialog.HostName", paramString);
    localawk.setArguments(localBundle);
    return localawk;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    paramDialogInterface = (awn)getActivity();
    if (paramDialogInterface != null) {
      paramDialogInterface.a(false);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    String str = getArguments().getString("SecurityRequiredDialog.HostName");
    setCancelable(true);
    return new AlertDialog.Builder(paramBundle).setIconAttribute(16843605).setTitle(paramBundle.getString(arh.aJ)).setMessage(paramBundle.getString(arh.aI, new Object[] { str })).setPositiveButton(paramBundle.getString(17039370), new awm(this)).setNegativeButton(paramBundle.getString(17039360), new awl(this)).create();
  }
}

/* Location:
 * Qualified Name:     awk
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */