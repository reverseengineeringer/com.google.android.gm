import android.content.Context;
import android.content.UriMatcher;
import android.net.Uri;
import com.android.mail.providers.Account;

public final class cgy
{
  public static Uri a(Context paramContext, String paramString, long paramLong)
  {
    paramContext = ctl.a(paramContext, paramString);
    if (paramContext != null) {
      return a(paramContext, "/operation", paramLong);
    }
    return null;
  }
  
  public static Uri a(Account paramAccount, String paramString)
  {
    return Uri.parse(b(paramAccount, paramString));
  }
  
  public static Uri a(Account paramAccount, String paramString, long paramLong)
  {
    paramAccount = String.valueOf(b(paramAccount, paramString));
    return Uri.parse(String.valueOf(paramAccount).length() + 21 + paramAccount + "/" + paramLong);
  }
  
  public static void a(UriMatcher paramUriMatcher, String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    String str1 = String.valueOf(paramString2);
    String str2 = String.valueOf("/saveTo");
    if (str2.length() != 0)
    {
      str1 = str1.concat(str2);
      paramUriMatcher.addURI(paramString1, str1, paramInt1);
      str1 = String.valueOf("/saveTo/save");
      paramUriMatcher.addURI(paramString1, String.valueOf(paramString2).length() + 2 + String.valueOf(str1).length() + paramString2 + str1 + "/#", paramInt2);
      str1 = String.valueOf("/saveTo/message");
      paramUriMatcher.addURI(paramString1, String.valueOf(paramString2).length() + 2 + String.valueOf(str1).length() + paramString2 + str1 + "/*", paramInt3);
      str1 = String.valueOf(paramString2);
      str2 = String.valueOf("/operation");
      if (str2.length() == 0) {
        break label260;
      }
    }
    label260:
    for (str1 = str1.concat(str2);; str1 = new String(str1))
    {
      paramUriMatcher.addURI(paramString1, str1, paramInt4);
      str1 = String.valueOf("/operation");
      paramUriMatcher.addURI(paramString1, String.valueOf(paramString2).length() + 2 + String.valueOf(str1).length() + paramString2 + str1 + "/#", paramInt5);
      return;
      str1 = new String(str1);
      break;
    }
  }
  
  private static String b(Account paramAccount, String paramString)
  {
    paramAccount = String.valueOf(N.toString());
    paramString = String.valueOf(paramString);
    if (paramString.length() != 0) {
      return paramAccount.concat(paramString);
    }
    return new String(paramAccount);
  }
}

/* Location:
 * Qualified Name:     cgy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */