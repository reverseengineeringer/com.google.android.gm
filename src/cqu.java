import android.accounts.Account;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;

final class cqu
  implements DialogInterface.OnClickListener
{
  cqu(cqs paramcqs, String paramString, Account paramAccount) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ContentResolver.setMasterSyncAutomatically(true);
    if (TextUtils.isEmpty(a)) {}
    for (paramDialogInterface = cqs.a;; paramDialogInterface = a)
    {
      if (!TextUtils.isEmpty(paramDialogInterface))
      {
        ContentResolver.setSyncAutomatically(b, paramDialogInterface, true);
        if (c.b != null) {
          c.b.d();
        }
      }
      return;
    }
  }
}

/* Location:
 * Qualified Name:     cqu
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */