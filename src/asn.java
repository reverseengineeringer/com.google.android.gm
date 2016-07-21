import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import com.android.email.activity.setup.AccountSecurity;

public final class asn
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    dismiss();
    paramDialogInterface = (AccountSecurity)getActivity();
    if (paramInt == -1) {
      paramDialogInterface.startActivity(new Intent("android.app.action.SET_NEW_PASSWORD"));
    }
    paramDialogInterface.finish();
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments().getString("account_name");
    boolean bool = getArguments().getBoolean("expired");
    int i;
    if (bool)
    {
      i = arh.ca;
      if (!bool) {
        break label110;
      }
    }
    label110:
    for (int j = arh.bZ;; j = arh.bV)
    {
      Activity localActivity = getActivity();
      Resources localResources = localActivity.getResources();
      return new AlertDialog.Builder(localActivity).setTitle(i).setIconAttribute(16843605).setMessage(localResources.getString(j, new Object[] { paramBundle })).setPositiveButton(17039370, this).setNegativeButton(17039360, this).create();
      i = arh.bW;
      break;
    }
  }
}

/* Location:
 * Qualified Name:     asn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */