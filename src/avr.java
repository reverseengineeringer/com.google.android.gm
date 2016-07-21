import android.app.Activity;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.net.Uri;

final class avr
  implements DialogInterface.OnClickListener
{
  avr(avo paramavo, Uri paramUri) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.getActivity().getContentResolver().delete(a, null, null);
  }
}

/* Location:
 * Qualified Name:     avr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */