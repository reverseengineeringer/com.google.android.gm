import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import java.lang.ref.WeakReference;

public final class dnh
  extends DialogFragment
{
  String a;
  private WeakReference<dnj> b = null;
  
  public final void a(dnj paramdnj)
  {
    b = new WeakReference(paramdnj);
  }
  
  final void a(String paramString, boolean paramBoolean)
  {
    Activity localActivity = getActivity();
    dnm.a(localActivity, paramString).a(true);
    dol.a(localActivity, paramString);
    if (b != null)
    {
      paramString = (dnj)b.get();
      if (paramString != null) {
        paramString.f();
      }
    }
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a(a, true);
  }
  
  public final Dialog onCreateDialog(Bundle paramBundle)
  {
    a = getArguments().getString("accountName");
    paramBundle = new dni(this);
    return new AlertDialog.Builder(getActivity()).setTitle(dge.fb).setMessage(dge.fa).setPositiveButton(dge.eZ, null).setNegativeButton(17039360, paramBundle).create();
  }
}

/* Location:
 * Qualified Name:     dnh
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */