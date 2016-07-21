import android.accounts.Account;
import android.content.ContentResolver;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class dnl
  implements DialogInterface.OnClickListener
{
  dnl(dnk paramdnk, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    ContentResolver.setSyncAutomatically(new Account(a, "com.google"), "gmail-ls", true);
  }
}

/* Location:
 * Qualified Name:     dnl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */