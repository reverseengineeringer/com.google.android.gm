import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.os.Bundle;
import com.android.email.SecurityPolicy;
import com.android.email.activity.setup.AccountSecurity;

public final class aso
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    dismiss();
    paramDialogInterface = (AccountSecurity)getActivity();
    if (a == null)
    {
      paramDialogInterface.finish();
      return;
    }
    switch (paramInt)
    {
    default: 
      return;
    case -2: 
      AccountSecurity.a(a, SecurityPolicy.a(paramDialogInterface));
      paramDialogInterface.finish();
      return;
    }
    paramDialogInterface.a(a);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    paramBundle = getArguments().getString("account_name");
    Object localObject = getActivity();
    Resources localResources = ((Context)localObject).getResources();
    localObject = new AlertDialog.Builder((Context)localObject);
    ((AlertDialog.Builder)localObject).setTitle(arh.m);
    ((AlertDialog.Builder)localObject).setIconAttribute(16843605);
    ((AlertDialog.Builder)localObject).setMessage(localResources.getString(arh.l, new Object[] { paramBundle }));
    ((AlertDialog.Builder)localObject).setPositiveButton(17039370, this);
    ((AlertDialog.Builder)localObject).setNegativeButton(17039360, this);
    return ((AlertDialog.Builder)localObject).create();
  }
}

/* Location:
 * Qualified Name:     aso
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */