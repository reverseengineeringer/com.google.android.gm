import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import java.lang.ref.WeakReference;

final class cne
  implements DialogInterface.OnClickListener
{
  cne(cnd paramcnd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (a.a != null)
    {
      paramDialogInterface = (cnf)a.a.get();
      if (paramDialogInterface != null) {
        paramDialogInterface.u();
      }
    }
  }
}

/* Location:
 * Qualified Name:     cne
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */