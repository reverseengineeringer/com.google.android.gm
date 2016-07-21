import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.emailcommon.provider.Account;
import com.android.emailcommon.provider.ExchangeOofSettings;
import com.android.emailcommon.provider.RecipientAvailability;
import com.android.emailcommon.service.HostAuthCompat;
import com.android.emailcommon.service.SearchParams;
import java.util.List;

public final class bal
  extends bez
  implements bey
{
  private static final String b = cvl.a;
  public Context a;
  
  public final int a()
  {
    return 7;
  }
  
  public final int a(long paramLong, Bundle paramBundle)
  {
    return 0;
  }
  
  public final Bundle a(long paramLong1, SearchParams paramSearchParams, long paramLong2)
  {
    cvm.f(b, "No more EmailServiceStub.searchMessages", new Object[0]);
    throw new RemoteException();
  }
  
  public final Bundle a(HostAuthCompat paramHostAuthCompat)
  {
    return null;
  }
  
  public final Bundle a(String paramString1, String paramString2)
  {
    return null;
  }
  
  public final Bundle a(String paramString1, String paramString2, Bundle paramBundle)
  {
    return null;
  }
  
  public final List<RecipientAvailability> a(String paramString, List<String> paramList, long paramLong1, long paramLong2)
  {
    return null;
  }
  
  public final void a(int paramInt) {}
  
  public final void a(long paramLong)
  {
    cvm.f(b, "updateFolderList is no longer supported from EmailServiceStub", new Object[0]);
    throw new RemoteException();
  }
  
  public final void a(long paramLong1, int paramInt, long paramLong2, long paramLong3, String paramString) {}
  
  public final void a(long paramLong1, long paramLong2)
  {
    cvm.e(b, "pushModifyWithBackoff invalid for account type %d backoff %d", new Object[] { Long.valueOf(paramLong1), Long.valueOf(paramLong2) });
  }
  
  public final void a(long paramLong, ExchangeOofSettings paramExchangeOofSettings) {}
  
  public final void a(long paramLong1, String paramString, long paramLong2)
  {
    Account localAccount = Account.a(a, paramLong1);
    try
    {
      awr.a(localAccount, a).a(paramLong1, paramString, paramLong2);
      return;
    }
    catch (bdi paramString)
    {
      cvm.e(b, paramString, "MessagingException in createFolder", new Object[0]);
    }
  }
  
  public final void a(bfb parambfb, long paramLong1, long paramLong2, boolean paramBoolean)
  {
    cvm.f(b, "loadAttachment is no longer supported from EmailServiceStub", new Object[0]);
    throw new RemoteException();
  }
  
  public final void a(String paramString) {}
  
  public final String b(String paramString)
  {
    paramString = Account.a(a, paramString);
    if (paramString != null) {
      return l;
    }
    return null;
  }
  
  public final void b(long paramLong)
  {
    cvm.e(b, "pushModify invalid for account for %d", new Object[] { Long.valueOf(paramLong) });
  }
  
  public final void b(long paramLong1, long paramLong2)
  {
    Account localAccount = Account.a(a, paramLong1);
    try
    {
      awr.a(localAccount, a).a(paramLong1, paramLong2);
      return;
    }
    catch (bdi localbdi)
    {
      cvm.e(b, localbdi, "MessagingException in markFolderForDeletion", new Object[0]);
    }
  }
  
  public final void c(long paramLong)
  {
    cvm.f(b, "No more EmailServiceStub.sendMail", new Object[0]);
    throw new RemoteException();
  }
  
  public final void c(long paramLong1, long paramLong2) {}
}

/* Location:
 * Qualified Name:     bal
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */