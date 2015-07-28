package com.google.android.gm.provider;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import com.android.mail.utils.DelayedTaskHandler;

class UiProvider$AccountChangedNotifier
  extends DelayedTaskHandler
{
  private final Uri mNotificationUri;
  private final ContentResolver mResolver;
  
  UiProvider$AccountChangedNotifier(Context paramContext, Looper paramLooper, String paramString)
  {
    super(paramLooper, UiProvider.access$600());
    mResolver = paramContext.getContentResolver();
    mNotificationUri = UiProvider.access$700(paramString);
  }
  
  protected void performTask()
  {
    mResolver.notifyChange(mNotificationUri, null, false);
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.provider.UiProvider.AccountChangedNotifier
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */