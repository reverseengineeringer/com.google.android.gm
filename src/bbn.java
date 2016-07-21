import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.android.email.activity.setup.SetupDataFragment;
import com.android.emailcommon.mail.Address;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.HostAuth;
import java.io.IOException;

public final class bbn
{
  public static final String a = cvl.a;
  public static final String[] b = { "email_address", "exchange_host", "exchange_username" };
  
  public static Bundle a(SetupDataFragment paramSetupDataFragment)
  {
    boolean bool2 = true;
    if (paramSetupDataFragment == null) {}
    do
    {
      return null;
      localObject = b;
    } while (localObject == null);
    paramSetupDataFragment = new Bundle();
    paramSetupDataFragment.putString("email_address", d);
    Object localObject = t;
    if (localObject != null)
    {
      paramSetupDataFragment.putString("exchange_password", g);
      paramSetupDataFragment.putString("exchange_username", f);
      String str1 = String.valueOf(c);
      String str2 = String.valueOf(String.valueOf(d));
      paramSetupDataFragment.putString("exchange_host", String.valueOf(str1).length() + 1 + String.valueOf(str2).length() + str1 + ":" + str2);
      paramSetupDataFragment.putString("exchange_login_certificate_alias", i);
      int i = e;
      if ((i & 0x1) == 0) {
        break label195;
      }
      bool1 = true;
      paramSetupDataFragment.putBoolean("exchange_ssl_required", bool1);
      if ((i & 0x8) == 0) {
        break label200;
      }
    }
    label195:
    label200:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramSetupDataFragment.putBoolean("exchange_trust_all_certificates", bool1);
      return paramSetupDataFragment;
      bool1 = false;
      break;
    }
  }
  
  public static String a(Context paramContext, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      cvm.d(a, "getPolicyUnsupportErrorMessage, No data for unsupported policies", new Object[0]);
      return null;
    }
    return paramContext.getString(arh.ae, new Object[] { TextUtils.join(", ", paramArrayOfString) });
  }
  
  public static void a(Context paramContext, SetupDataFragment paramSetupDataFragment)
  {
    String str1 = c;
    String str2 = str1.split("@")[1];
    Object localObject = b;
    ban localban = paramSetupDataFragment.a(paramContext);
    HostAuth localHostAuth = ((Account)localObject).d(paramContext);
    localHostAuth.a(str1);
    String str3 = h;
    if (j) {}
    for (int i = 2;; i = 1)
    {
      localHostAuth.a(str3, str2, -1, i);
      a(paramContext, localHostAuth, d);
      e = true;
      if (m)
      {
        localObject = ((Account)localObject).c(paramContext);
        ((HostAuth)localObject).a(str1);
        ((HostAuth)localObject).a("smtp", str2, -1, 2);
        a(paramContext, (HostAuth)localObject, d);
        f = true;
      }
      return;
    }
  }
  
  public static void a(Context paramContext, Account paramAccount, SetupDataFragment paramSetupDataFragment)
  {
    if ((paramSetupDataFragment != null) && (paramAccount != null))
    {
      paramContext = paramSetupDataFragment.a(paramContext);
      if (paramContext != null) {
        break label19;
      }
    }
    label19:
    do
    {
      return;
      g = z;
      f = s;
    } while (!n);
    paramAccount.a(o);
  }
  
  public static void a(Context paramContext, HostAuth paramHostAuth, Bundle paramBundle)
  {
    if (paramBundle == null) {
      return;
    }
    String str = paramBundle.getString("password");
    if (!TextUtils.isEmpty(str))
    {
      g = str;
      paramHostAuth.d();
      i = paramBundle.getString("certificate");
      return;
    }
    awj.a(paramContext).a(paramHostAuth, paramBundle);
  }
  
  public static boolean a(Context paramContext, Account paramAccount, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    j |= 0x10;
    atg.a(paramContext, paramAccount);
    AccountManagerFuture localAccountManagerFuture = bam.a(paramContext, paramAccount, paramBoolean1, paramBoolean2, paramBoolean3);
    try
    {
      localAccountManagerFuture.getResult();
      i = 1;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      for (;;)
      {
        cvm.b(a, localOperationCanceledException, "Account not created", new Object[0]);
        int i = 0;
      }
      bd).e.putBoolean("inbox-notifications-enabled", paramBoolean4).apply();
      j &= 0xFFFFFFEF;
      atg.a(paramContext, paramAccount);
      return true;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    catch (AuthenticatorException localAuthenticatorException)
    {
      for (;;) {}
    }
    if (i == 0) {
      return false;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return false;
      paramString = Address.d(paramString);
    } while ((paramString.length != 1) || (TextUtils.isEmpty(0a)));
    return true;
  }
}

/* Location:
 * Qualified Name:     bbn
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */