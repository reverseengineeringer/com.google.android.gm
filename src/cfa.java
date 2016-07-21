import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

public final class cfa
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String a = cvl.a;
  
  private final Intent a()
  {
    Intent localIntent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
    String str = String.valueOf(getActivity().getPackageName());
    if (str.length() != 0) {}
    for (str = "package:".concat(str);; str = new String("package:"))
    {
      localIntent.setData(Uri.parse(str));
      localIntent.setFlags(524288);
      return localIntent;
    }
  }
  
  public static cfa a(String paramString)
  {
    cfa localcfa = new cfa();
    Bundle localBundle = new Bundle(1);
    localBundle.putString("message", paramString);
    localcfa.setArguments(localBundle);
    return localcfa;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    bus.a("calendar_show_agenda", "cancel_dialog");
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = a();
    try
    {
      startActivity(paramDialogInterface);
      bus.a("calendar_show_agenda", "settings");
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      for (;;)
      {
        cvm.e(a, paramDialogInterface, "No activity to handle permission settings", new Object[0]);
      }
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getActivity();
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramBundle).setMessage(getArguments().getString("message"));
    if (paramBundle.getPackageManager().resolveActivity(a(), 65536) != null) {
      localBuilder.setPositiveButton(buj.eM, this);
    }
    return localBuilder.create();
  }
}

/* Location:
 * Qualified Name:     cfa
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */