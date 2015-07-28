package com.android.mail.compose;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public class EmptyService
  extends Service
{
  private static final String TAG = ;
  
  public IBinder onBind(Intent paramIntent)
  {
    LogUtils.i(TAG, "onBind()", new Object[0]);
    return null;
  }
  
  public void onCreate()
  {
    LogUtils.v(TAG, "onCreate()", new Object[0]);
  }
}

/* Location:
 * Qualified Name:     com.android.mail.compose.EmptyService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */