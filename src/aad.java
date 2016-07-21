import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

final class aad
  extends Handler
{
  private WeakReference<DialogInterface> a;
  
  public aad(DialogInterface paramDialogInterface)
  {
    a = new WeakReference(paramDialogInterface);
  }
  
  public final void handleMessage(Message paramMessage)
  {
    switch (what)
    {
    case 0: 
    default: 
      return;
    case -3: 
    case -2: 
    case -1: 
      ((DialogInterface.OnClickListener)obj).onClick((DialogInterface)a.get(), what);
      return;
    }
    ((DialogInterface)obj).dismiss();
  }
}

/* Location:
 * Qualified Name:     aad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */