import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public final class dys
  extends DialogFragment
{
  private int a;
  
  public static dys a(int paramInt1, int paramInt2)
  {
    dys localdys = new dys();
    Bundle localBundle = new Bundle(2);
    localBundle.putInt("error-code", paramInt1);
    localBundle.putInt("request-code", paramInt2);
    localdys.setArguments(localBundle);
    return localdys;
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    int i = getArguments().getInt("error-code");
    a = getArguments().getInt("request-code");
    return eik.a(i, getActivity(), a);
  }
  
  public final void onDismiss(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = getActivity();
    if ((paramDialogInterface instanceof dyt)) {
      ((dyt)paramDialogInterface).h(a);
    }
  }
}

/* Location:
 * Qualified Name:     dys
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */