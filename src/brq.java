import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.RemoteException;
import com.android.emailcommon.provider.Mailbox;

public abstract class brq
  extends AbstractThreadedSyncAdapter
{
  public brq(bro parambro, Context paramContext)
  {
    super(paramContext, true);
  }
  
  protected abstract String a();
  
  protected abstract boolean a(android.accounts.Account paramAccount);
  
  public void onPerformSync(android.accounts.Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    if (cuh.a())
    {
      paramString = "onPerformBundledSync";
      if (!cvm.a("Exchange", 3)) {
        break label79;
      }
      cvm.b("Exchange", "%s %s: %s, %s", new Object[] { paramString, a(), paramAccount.toString(), paramBundle.toString() });
      label55:
      bgq.a(getContext());
      if (a.b()) {
        break label112;
      }
    }
    label79:
    label112:
    do
    {
      return;
      paramString = "onPerformSync";
      break;
      cvm.c("Exchange", "%s %s: %s", new Object[] { paramString, a(), paramBundle.toString() });
      break label55;
      paramString = com.android.emailcommon.provider.Account.a(getContext(), name);
      if (paramString == null)
      {
        cvm.d("Exchange", "onPerformSync() - Could not find an Account, skipping %s sync", new Object[] { a() });
        return;
      }
      if ((!paramBundle.getBoolean("upload")) || (a(paramAccount))) {
        break label198;
      }
    } while (!bnq.b);
    cvm.b("Exchange", "No %s changes to upsync for account %s", new Object[] { a(), name });
    return;
    label198:
    if (Mailbox.c(paramBundle))
    {
      cvm.b("Exchange", "onPerformSync %s: push only", new Object[] { a() });
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
      cvm.b("Exchange", "onPerformSync %s: finished", new Object[] { a() });
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
 * Qualified Name:     brq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */