package com.google.android.common;

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
import android.util.EventLog;

public abstract class LoggingThreadedSyncAdapter
  extends AbstractThreadedSyncAdapter
{
  public LoggingThreadedSyncAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
  }
  
  public LoggingThreadedSyncAdapter(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramContext, paramBoolean1, paramBoolean2);
  }
  
  protected void onLogSyncDetails(long paramLong1, long paramLong2, SyncResult paramSyncResult)
  {
    EventLog.writeEvent(203001, new Object[] { "Sync", Long.valueOf(paramLong1), Long.valueOf(paramLong2), "" });
  }
  
  public abstract void onPerformLoggedSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult);
  
  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    i = Process.myUid();
    l1 = TrafficStats.getUidTxBytes(i);
    l3 = TrafficStats.getUidRxBytes(i);
    try
    {
      onPerformLoggedSync(paramAccount, paramBundle, paramString, paramContentProviderClient, paramSyncResult);
      l1 = TrafficStats.getUidTxBytes(i) - l1;
      l2 = TrafficStats.getUidRxBytes(i);
    }
    catch (SQLException paramAccount)
    {
      for (;;)
      {
        paramAccount = stats;
        numParseExceptions += 1L;
        l1 = TrafficStats.getUidTxBytes(i) - l1;
        long l2 = TrafficStats.getUidRxBytes(i);
      }
    }
    finally
    {
      onLogSyncDetails(TrafficStats.getUidTxBytes(i) - l1, TrafficStats.getUidRxBytes(i) - l3, paramSyncResult);
    }
    onLogSyncDetails(l1, l2 - l3, paramSyncResult);
  }
}

/* Location:
 * Qualified Name:     com.google.android.common.LoggingThreadedSyncAdapter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */