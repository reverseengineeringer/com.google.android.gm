package com.google.android.gm;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gm.provider.LogUtils;

final class Utils$2
  implements ServiceConnection
{
  public void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      paramIBinder.transact(1, Parcel.obtain(), null, 0);
      return;
    }
    catch (RemoteException paramComponentName)
    {
      LogUtils.e("Gmail", paramComponentName, "Error connecting to bug report service", new Object[0]);
    }
  }
  
  public void onServiceDisconnected(ComponentName paramComponentName) {}
}

/* Location:
 * Qualified Name:     com.google.android.gm.Utils.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */