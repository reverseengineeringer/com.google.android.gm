import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AccountsException;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.http.client.CookieStore;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

public final class ddy
{
  static final String a = cvl.a;
  public static final String[] b = { ghy.a("mail") };
  private final Context c;
  
  public ddy(Context paramContext)
  {
    c = paramContext;
  }
  
  public static String a(String paramString)
  {
    Cookie localCookie = b(paramString);
    String str1 = localCookie.getPath();
    String str2 = localCookie.getName();
    String str3 = localCookie.getValue();
    paramString = str1;
    if (str1 == null) {
      paramString = "/";
    }
    return String.format("%s=%s; path=%s; domain=%s", new Object[] { str2, str3, paramString, localCookie.getDomain() });
  }
  
  public static String a(CookieStore paramCookieStore)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramCookieStore = paramCookieStore.getCookies().iterator();
    while (paramCookieStore.hasNext())
    {
      Cookie localCookie = (Cookie)paramCookieStore.next();
      localStringBuilder.append(localCookie.getName());
      localStringBuilder.append('=');
      localStringBuilder.append(localCookie.getValue());
      localStringBuilder.append("; ");
    }
    return localStringBuilder.toString();
  }
  
  public static HttpContext a(String paramString, CookieStore paramCookieStore)
  {
    BasicHttpContext localBasicHttpContext = new BasicHttpContext();
    localBasicHttpContext.setAttribute("http.cookie-store", paramCookieStore);
    if (paramString != null) {
      paramCookieStore.addCookie(b(paramString));
    }
    return localBasicHttpContext;
  }
  
  public static void a(Activity paramActivity, dee paramdee)
  {
    PendingIntent localPendingIntent = PendingIntent.getActivity(paramActivity, -1, new Intent("android.intent.action.VIEW"), 0);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("allowSkip", false);
    localBundle.putString("introMessage", paramActivity.getResources().getString(dge.fm));
    localBundle.putParcelable("pendingIntent", localPendingIntent);
    AccountManager.get(paramActivity).addAccount("com.google", dms.a(paramActivity.getApplicationContext()), null, localBundle, paramActivity, new deb(paramdee, localPendingIntent, paramActivity), null);
  }
  
  public static void a(Activity paramActivity, String paramString)
  {
    a(paramActivity, paramString, null);
  }
  
  public static void a(Activity paramActivity, String paramString, Bundle paramBundle)
  {
    Object localObject = paramActivity.getResources().getString(dge.dv);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      a(paramActivity, null);
      return;
    }
    localObject = new Intent((String)localObject);
    ((Intent)localObject).putExtra("SKIP_LANDING", false);
    ((Intent)localObject).putExtra("SOURCE_LABEL", paramString);
    if (paramBundle != null) {
      ((Intent)localObject).putExtras(paramBundle);
    }
    ((Intent)localObject).setPackage(paramActivity.getPackageName());
    paramActivity.startActivity((Intent)localObject);
  }
  
  public static void a(Activity paramActivity, String paramString, def paramdef)
  {
    paramString = new Account(paramString, "com.google");
    Bundle localBundle = new Bundle();
    AccountManager.get(paramActivity).getAuthToken(paramString, dms.a(paramActivity.getApplicationContext()), localBundle, paramActivity, new dec(paramdef), null);
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 401;
  }
  
  private static Cookie b(String paramString)
  {
    paramString = new BasicClientCookie("GX", paramString);
    paramString.setDomain("google.com");
    return paramString;
  }
  
  public final String a(Account paramAccount, String paramString1, String paramString2)
  {
    localbut = buo.a();
    String str = String.valueOf("token_get");
    paramString2 = String.valueOf(paramString2).length() + 1 + String.valueOf(str).length() + paramString2 + "_" + str;
    try
    {
      paramAccount = AccountManager.get(c).blockingGetAuthToken(paramAccount, paramString1, true);
      if (paramAccount != null) {
        break label205;
      }
      dri.d(a, "Null auth token @getAuthToken for type=%s", new Object[] { paramString1 });
      localbut.a("gmail_auth", paramString2, dms.a("null", paramString1), 0L);
      paramAccount = String.valueOf(paramString1);
      if (paramAccount.length() == 0) {
        break label191;
      }
      paramAccount = "Unable to get auth token: ".concat(paramAccount);
    }
    catch (AuthenticatorException paramAccount)
    {
      for (;;)
      {
        dri.c(a, "Authenticator exception while getting auth token type=%s", new Object[] { paramString1 });
        localbut.a("gmail_auth", paramString2, dms.a("exception", paramString1), 0L);
        throw new dsj(paramAccount.getMessage());
        paramAccount = new String("Unable to get auth token: ");
      }
      localbut.a("gmail_auth", paramString2, dms.a("success", paramString1), 0L);
      return paramAccount;
    }
    catch (OperationCanceledException paramAccount)
    {
      for (;;) {}
    }
    throw new dsj(paramAccount);
  }
  
  public final void a(ded paramded)
  {
    AccountManager.get(c).getAccountsByTypeAndFeatures("com.google", b, new ddz(this, paramded), null);
  }
  
  public final Account[] a(String... paramVarArgs)
  {
    String[] arrayOfString = new String[paramVarArgs.length];
    int i = 0;
    while (i < paramVarArgs.length)
    {
      arrayOfString[i] = ghy.a(paramVarArgs[i]);
      i += 1;
    }
    try
    {
      paramVarArgs = (Account[])AccountManager.get(c).getAccountsByTypeAndFeatures("com.google", arrayOfString, null, null).getResult();
      return paramVarArgs;
    }
    catch (AuthenticatorException paramVarArgs)
    {
      dri.d(a, paramVarArgs, "Failed to get accounts", new Object[0]);
      return new Account[0];
    }
    catch (OperationCanceledException paramVarArgs)
    {
      for (;;) {}
    }
    catch (IOException paramVarArgs)
    {
      for (;;) {}
    }
  }
  
  public final List<String> b(String... paramVarArgs)
  {
    paramVarArgs = a(paramVarArgs);
    dea localdea = new dea(this);
    if (paramVarArgs == null) {
      return hii.a;
    }
    return hgd.a(Arrays.asList(paramVarArgs), localdea);
  }
  
  public final void b(Account paramAccount, String paramString1, String paramString2)
  {
    Object localObject2 = AccountManager.get(c);
    Object localObject1 = "null";
    try
    {
      String str = ((AccountManager)localObject2).blockingGetAuthToken(paramAccount, paramString1, false);
      if (str != null)
      {
        ((AccountManager)localObject2).invalidateAuthToken(type, str);
        localObject1 = "success";
      }
      paramAccount = (Account)localObject1;
    }
    catch (AuthenticatorException paramAccount)
    {
      for (;;)
      {
        dri.d(a, "Unable to get auth token for invalidation:%s", new Object[] { paramString1 });
        paramAccount = "exception";
      }
    }
    catch (OperationCanceledException paramAccount)
    {
      for (;;) {}
    }
    catch (IOException paramAccount)
    {
      for (;;) {}
    }
    localObject1 = buo.a();
    localObject2 = String.valueOf("token_invalidate");
    ((but)localObject1).a("gmail_auth", String.valueOf(paramString2).length() + 1 + String.valueOf(localObject2).length() + paramString2 + "_" + (String)localObject2, dms.a(paramAccount, paramString1), 0L);
  }
}

/* Location:
 * Qualified Name:     ddy
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */