import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.content.SyncStats;
import android.database.SQLException;
import android.net.TrafficStats;
import android.os.Bundle;
import android.os.Process;

public abstract class bgp
  extends AbstractThreadedSyncAdapter
{
  public bgp(Context paramContext)
  {
    super(paramContext, true);
  }
  
  public bgp(Context paramContext, byte paramByte)
  {
    super(paramContext, false, true);
  }
  
  public abstract void a(long paramLong1, long paramLong2, SyncResult paramSyncResult);
  
  public abstract void a(Account paramAccount, Bundle paramBundle, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult);
  
  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    int i = Process.myUid();
    long l1 = TrafficStats.getUidTxBytes(i);
    long l2 = TrafficStats.getUidRxBytes(i);
    try
    {
      a(paramAccount, paramBundle, paramContentProviderClient, paramSyncResult);
      return;
    }
    catch (SQLException paramAccount)
    {
      paramAccount = stats;
      numParseExceptions += 1L;
      return;
    }
    finally
    {
      a(TrafficStats.getUidTxBytes(i) - l1, TrafficStats.getUidRxBytes(i) - l2, paramSyncResult);
    }
  }
}

/* Location:
 * Qualified Name:     bgp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */