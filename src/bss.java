import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.emailcommon.provider.Mailbox;
import com.android.exchange.service.EmailSyncAdapterService;

public final class bss
  extends bgp
{
  public bss(EmailSyncAdapterService paramEmailSyncAdapterService, Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a(long paramLong1, long paramLong2, SyncResult paramSyncResult) {}
  
  public final void a(android.accounts.Account paramAccount, Bundle paramBundle, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    if (cuh.a())
    {
      paramContentProviderClient = "onPerformBundledSync";
      if (!cvm.a("Exchange", 3)) {
        break label72;
      }
      cvm.b("Exchange", "%s email: %s, %s", new Object[] { paramContentProviderClient, paramAccount.toString(), paramBundle.toString() });
    }
    for (;;)
    {
      bgq.a(getContext());
      if (a.b()) {
        break label98;
      }
      return;
      paramContentProviderClient = "onPerformSync";
      break;
      label72:
      cvm.c("Exchange", "%s email: %s", new Object[] { paramContentProviderClient, paramBundle.toString() });
    }
    label98:
    paramAccount = com.android.emailcommon.provider.Account.a(a, name);
    if (paramAccount == null)
    {
      cvm.d("Exchange", "onPerformSync() - Could not find an Account, skipping email sync.", new Object[0]);
      return;
    }
    if (Mailbox.c(paramBundle))
    {
      cvm.b("Exchange", "onPerformSync email: push only", new Object[0]);
      try
      {
        long l = paramBundle.getLong("PING_DELAY", 0L);
        a.a.a(D, l);
        return;
      }
      catch (RemoteException paramAccount)
      {
        cvm.e("Exchange", paramAccount, "While trying to pushModify within onPerformSync", new Object[0]);
        return;
      }
    }
    try
    {
      int i = a.a.a(D, paramBundle);
      a.a(i, D);
      bro.a(i, paramSyncResult);
      cvm.b("Exchange", "onPerformSync email: finished", new Object[0]);
      return;
    }
    catch (RemoteException paramAccount)
    {
      for (;;)
      {
        cvm.e("Exchange", paramAccount, "While trying to pushModify within onPerformSync", new Object[0]);
      }
    }
  }
}

/* Location:
 * Qualified Name:     bss
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */