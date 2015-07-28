package com.google.android.gms.common;

import android.app.PendingIntent;

public final class ConnectionResult
{
  public static final ConnectionResult RESULT_SUCCESS = new ConnectionResult(0, null);
  private final PendingIntent mPendingIntent;
  private final int mStatusCode;
  
  public ConnectionResult(int paramInt, PendingIntent paramPendingIntent)
  {
    mStatusCode = paramInt;
    mPendingIntent = paramPendingIntent;
  }
  
  public int getErrorCode()
  {
    return mStatusCode;
  }
}

/* Location:
 * Qualified Name:     com.google.android.gms.common.ConnectionResult
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */