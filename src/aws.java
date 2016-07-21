import android.content.Context;
import android.text.TextUtils;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.Credential;
import com.android.emailcommon.provider.HostAuth;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class aws
{
  private static aws a;
  private final Map<Long, awt> b = new HashMap();
  
  public static aws a()
  {
    try
    {
      if (a == null) {
        a = new aws();
      }
      aws localaws = a;
      return localaws;
    }
    finally {}
  }
  
  private static void a(Context paramContext, awt paramawt)
  {
    cvm.b(bbw.a, "saveEntry", new Object[0]);
    Object localObject = Account.a(paramContext, a);
    if (localObject != null)
    {
      localObject = ((Account)localObject).d(paramContext).b(paramContext);
      c = b;
      d = c;
      e = d;
      f = e;
      ((Credential)localObject).a(paramContext, ((Credential)localObject).e());
    }
  }
  
  private final void a(Context paramContext, awt paramawt, Account paramAccount, boolean paramBoolean)
  {
    cvm.b(bbw.a, "AuthenticationCache refreshEntry %d", new Object[] { Long.valueOf(a) });
    but localbut = buo.a();
    localbut.b(d);
    String str1;
    String str2;
    bcb localbcb;
    try
    {
      paramAccount = awu.a(b);
      str1 = b;
      str2 = d;
      localbcb = awj.a(paramContext).c(str1);
      if (localbcb != null) {
        break label257;
      }
      cvm.e(awu.a, "invalid provider %s", new Object[] { str1 });
      paramAccount = String.valueOf(str1);
      if (paramAccount.length() == 0) {
        break label212;
      }
      paramAccount = "Invalid provider ".concat(paramAccount);
    }
    catch (bcs paramAccount)
    {
      for (;;)
      {
        cvm.b(bbw.a, "authentication failed, clearing", new Object[0]);
        if (paramBoolean)
        {
          cvm.b(bbw.a, "clearEntry", new Object[0]);
          c = "";
          d = "";
          e = 0L;
          a(paramContext, paramawt);
          b.remove(Long.valueOf(a));
        }
        localbut.a("oauth", "refresh_token_auth_failed", b, 0L);
        throw paramAccount;
        paramAccount = new String("Invalid provider ");
      }
    }
    catch (bdi paramContext)
    {
      cvm.b(bbw.a, "messaging exception", new Object[0]);
      localbut.a("oauth", "refresh_token_exception", b, 0L);
      throw paramContext;
      if (!TextUtils.isEmpty(str2)) {
        break label320;
      }
      cvm.d(awu.a, "OAuth tokens have been cleared. Re-authentication required", new Object[0]);
      throw new bcs("OAuth tokens have been cleared. Re-authentication required");
    }
    catch (IOException paramContext)
    {
      label212:
      label257:
      cvm.b(bbw.a, "IO exception", new Object[0]);
      localbut.a("oauth", "refresh_token_io_exception", b, 0L);
      throw paramContext;
    }
    throw new bcs(paramAccount);
    label320:
    paramAccount = paramAccount.a(paramAccount.b(paramContext, localbcb, str2), str1, "refresh");
    c = a;
    e = (c * 1000L + System.currentTimeMillis());
    a(paramContext, paramawt);
    localbut.a("oauth", "refresh_token_succeed", b, 0L);
  }
  
  private final awt c(Context paramContext, Account paramAccount)
  {
    if ((paramAccount.h()) && (!x))
    {
      awt localawt2 = (awt)b.get(Long.valueOf(D));
      awt localawt1 = localawt2;
      if (localawt2 == null)
      {
        cvm.b(bbw.a, "initializing entry from database", new Object[0]);
        paramContext = paramAccount.d(paramContext).b(paramContext);
        localawt1 = new awt(this, D, c, d, e, f);
        b.put(Long.valueOf(D), localawt1);
      }
      return localawt1;
    }
    paramContext = paramAccount.d(paramContext).a(paramContext);
    return new awt(this, D, c, d, e, f);
  }
  
  public final String a(Context paramContext, Account paramAccount)
  {
    long l;
    synchronized (b)
    {
      localawt = c(paramContext, paramAccount);
    }
  }
  
  public final String b(Context paramContext, Account paramAccount)
  {
    awt localawt = c(paramContext, paramAccount);
    String str = cui.b(d);
    cvm.c(cvl.a, "refreshAccessToken for %s", new Object[] { str });
    buo.a().a("oauth", "refresh_access_token", str, 0L);
    try
    {
      a(paramContext, localawt, paramAccount, true);
      paramContext = c;
      return paramContext;
    }
    finally {}
  }
}

/* Location:
 * Qualified Name:     aws
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */