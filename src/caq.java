import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public final class caq
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private static final String a = cvl.a;
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    buo.a().a("calendar_not_installed", "cancel", null, 0L);
    super.onCancel(paramDialogInterface);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    buo.a().a("calendar_not_installed", "download", null, 0L);
    paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.google.android.calendar")).addFlags(524288);
    try
    {
      startActivity(paramDialogInterface);
      return;
    }
    catch (ActivityNotFoundException paramDialogInterface)
    {
      cvm.e(a, "No activity to open the Play Store link to Google Calendar", new Object[0]);
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new aag(getActivity()).b(buj.ba).a(buj.aZ, this).a();
  }
}

/* Location:
 * Qualified Name:     caq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */