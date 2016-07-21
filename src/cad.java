import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class cad
  implements DialogInterface.OnClickListener
{
  cad(cac paramcac) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    Intent localIntent = new Intent("android.settings.INTERNAL_STORAGE_SETTINGS");
    localIntent.addFlags(524288);
    a.startActivity(localIntent);
    paramDialogInterface.dismiss();
  }
}

/* Location:
 * Qualified Name:     cad
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */