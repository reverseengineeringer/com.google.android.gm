import android.content.UriMatcher;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;

public final class btp
{
  private static final UriMatcher d;
  public final Account a;
  public final Folder b;
  public final String c;
  
  static
  {
    UriMatcher localUriMatcher = new UriMatcher(-1);
    d = localUriMatcher;
    localUriMatcher.addURI("com.android.mail.providers", "account/*/folder/*", 0);
  }
  
  public btp(Account paramAccount, String paramString, Folder paramFolder)
  {
    if (paramAccount == null) {
      cvm.d(cvl.a, new NullPointerException(), "Account is null", new Object[0]);
    }
    a = paramAccount;
    c = paramString;
    if (paramFolder == null) {
      cvm.d(cvl.a, new NullPointerException(), "Folder is null", new Object[0]);
    }
    b = paramFolder;
  }
  
  public static btp a(Bundle paramBundle)
  {
    Account localAccount = (Account)paramBundle.getParcelable("mail_account");
    Folder localFolder = (Folder)paramBundle.getParcelable("folder");
    return new btp(localAccount, paramBundle.getString("query"), localFolder);
  }
  
  public static btp a(Account paramAccount, Folder paramFolder, String paramString)
  {
    return new btp(paramAccount, (String)hbe.a(paramString), paramFolder);
  }
  
  public static boolean a(btp parambtp)
  {
    return (parambtp != null) && (!TextUtils.isEmpty(c));
  }
}

/* Location:
 * Qualified Name:     btp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */