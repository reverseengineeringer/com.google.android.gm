import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class byt
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private String a;
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    buo.a().a("attachment_no_viewer", "cancel", a, 0L);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == -1)
    {
      Intent localIntent = new Intent("android.intent.action.VIEW");
      paramDialogInterface = String.valueOf(a);
      if (paramDialogInterface.length() != 0) {
        paramDialogInterface = "market://search?q=".concat(paramDialogInterface);
      }
      for (;;)
      {
        localIntent.setData(Uri.parse(paramDialogInterface));
        localIntent.setFlags(524288);
        try
        {
          startActivity(localIntent);
          buo.a().a("attachment_no_viewer", "search", a, 0L);
          return;
          paramDialogInterface = new String("market://search?q=");
        }
        catch (ActivityNotFoundException paramDialogInterface)
        {
          for (;;)
          {
            cvm.c("no-app-dialog", "Failed to find activity for searching for an attachment in Play Store", new Object[0]);
          }
        }
      }
    }
    buo.a().a("attachment_no_viewer", "cancel", a, 0L);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments();
    a = paramBundle.getString("extensionType");
    Object localObject;
    if (a == null)
    {
      localObject = getString(buj.dm);
      paramBundle = paramBundle.getString("mimeType");
    }
    for (;;)
    {
      a = paramBundle;
      return new AlertDialog.Builder(getActivity()).setMessage((CharSequence)localObject).setNegativeButton(buj.R, this).setPositiveButton(buj.er, this).create();
      paramBundle = getString(buj.dl, new Object[] { a });
      localObject = String.valueOf(a);
      String str;
      if (((String)localObject).length() != 0)
      {
        str = ".".concat((String)localObject);
        localObject = paramBundle;
        paramBundle = str;
      }
      else
      {
        str = new String(".");
        localObject = paramBundle;
        paramBundle = str;
      }
    }
  }
}

/* Location:
 * Qualified Name:     byt
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */