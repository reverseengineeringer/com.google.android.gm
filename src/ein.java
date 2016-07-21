import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;

public final class ein
  extends ff
{
  Dialog ai = null;
  DialogInterface.OnCancelListener aj = null;
  
  public final void a(fq paramfq, String paramString)
  {
    super.a(paramfq, paramString);
  }
  
  public final Dialog b()
  {
    if (ai == null) {
      d = false;
    }
    return ai;
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    if (aj != null) {
      aj.onCancel(paramDialogInterface);
    }
  }
}

/* Location:
 * Qualified Name:     ein
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */