import android.accounts.Account;
import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Groups;
import android.provider.ContactsContract.RawContacts;
import com.android.exchange.service.ContactsSyncAdapterService;

public final class brs
  extends brq
{
  public brs(ContactsSyncAdapterService paramContactsSyncAdapterService, Context paramContext)
  {
    super(paramContactsSyncAdapterService, paramContext);
  }
  
  protected final String a()
  {
    return "contacts";
  }
  
  protected final boolean a(Account paramAccount)
  {
    String str = bnq.c;
    Uri localUri = ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("account_name", name).appendQueryParameter("account_type", str).build();
    boolean bool2 = ContactsSyncAdapterService.a(b.getContentResolver(), localUri, "dirty");
    boolean bool1 = bool2;
    if (!bool2)
    {
      paramAccount = ContactsContract.Groups.CONTENT_URI.buildUpon().appendQueryParameter("account_name", name).appendQueryParameter("account_type", str).build();
      bool1 = ContactsSyncAdapterService.a(b.getContentResolver(), paramAccount, "dirty");
    }
    return bool1;
  }
}

/* Location:
 * Qualified Name:     brs
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */