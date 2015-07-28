package com.google.android.gm.provider;

import android.accounts.Account;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.database.SQLException;
import android.os.Bundle;
import android.util.EventLog;
import com.google.android.common.LoggingThreadedSyncAdapter;

class MailSyncAdapterService$SyncAdapterImpl
  extends LoggingThreadedSyncAdapter
{
  private volatile MailEngine mMailEngine;
  
  public MailSyncAdapterService$SyncAdapterImpl(Context paramContext)
  {
    super(paramContext, false, true);
  }
  
  protected void onLogSyncDetails(long paramLong1, long paramLong2, SyncResult paramSyncResult)
  {
    if (mMailEngine != null) {
      EventLog.writeEvent(203001, new Object[] { "Gmail", Long.valueOf(paramLong1), Long.valueOf(paramLong2), mMailEngine.getMailSync().getStats(paramSyncResult) });
    }
  }
  
  public void onPerformLoggedSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    mMailEngine = MailEngine.getOrMakeMailEngineSync(MailProvider.getMailProvider().getContext(), name);
    try
    {
      mMailEngine.performBackgroundSync(paramSyncResult, paramBundle);
      return;
    }
    catch (SQLException paramAccount)
    {
      LogUtils.e("Gmail", paramAccount, "Mail sync failed", new Object[0]);
      databaseError = true;
    }
  }
  
  public void onSyncCanceled(Thread paramThread)
  {
    if (mMailEngine != null) {
      mMailEngine.onSyncCanceled();
    }
    super.onSyncCanceled(paramThread);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.MailSyncAdapterService.SyncAdapterImpl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */