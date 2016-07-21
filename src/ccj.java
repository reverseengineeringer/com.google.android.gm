import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.android.mail.providers.Account;

public final class ccj
  extends DialogFragment
  implements DialogInterface.OnClickListener
{
  private cck a = null;
  
  public final void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if ((paramActivity instanceof cck))
    {
      a = ((cck)paramActivity);
      return;
    }
    throw new ClassCastException(String.valueOf(paramActivity.toString()).concat(" must implement OnConfirmedListener"));
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    super.onCancel(paramDialogInterface);
    onClick(paramDialogInterface, -2);
  }
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = getArguments();
    cck localcck = a;
    if (paramInt == -1) {}
    for (boolean bool = true;; bool = false)
    {
      localcck.a(bool, cha.a((Account)paramDialogInterface.getParcelable("account"), paramDialogInterface.getString("replyFromAccount")));
      return;
    }
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    return new aag(getActivity()).b(buj.em).a(buj.dx, this).b(buj.R, this).a();
  }
}

/* Location:
 * Qualified Name:     ccj
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */