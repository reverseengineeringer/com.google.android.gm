import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.res.Resources;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class dei
  implements Runnable
{
  dei(deh paramdeh) {}
  
  public final void run()
  {
    deh localdeh = a;
    Context localContext = a.b;
    ArrayList localArrayList = new ArrayList();
    String[] arrayOfString = localContext.getResources().getStringArray(btw.a);
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      String str = arrayOfString[i];
      Collections.addAll(localArrayList, AccountManager.get(localContext).getAccountsByType(str));
      i += 1;
    }
    localdeh.onAccountsUpdated((Account[])localArrayList.toArray(new Account[localArrayList.size()]));
  }
}

/* Location:
 * Qualified Name:     dei
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */