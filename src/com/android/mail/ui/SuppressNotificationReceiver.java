package com.android.mail.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentFilter.MalformedMimeTypeException;
import android.net.Uri;
import android.text.TextUtils;
import com.android.mail.ConversationListContext;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;

public class SuppressNotificationReceiver
  extends BroadcastReceiver
{
  private static final String LOG_TAG = ;
  private Context mContext;
  private AbstractActivityController mController;
  private String mMimeType;
  
  public boolean activate(Context paramContext, AbstractActivityController paramAbstractActivityController)
  {
    Account localAccount = paramAbstractActivityController.getCurrentAccount();
    mContext = paramContext;
    mController = paramAbstractActivityController;
    paramAbstractActivityController = new IntentFilter("com.android.mail.action.update_notification");
    paramAbstractActivityController.setPriority(0);
    if (localAccount != null) {
      mMimeType = mimeType;
    }
    for (;;)
    {
      try
      {
        paramAbstractActivityController.addDataType(mMimeType);
        paramContext.registerReceiver(this, paramAbstractActivityController);
        return true;
      }
      catch (IntentFilter.MalformedMimeTypeException localMalformedMimeTypeException)
      {
        LogUtils.wtf(LOG_TAG, "Malformed mimetype: %s", new Object[] { mMimeType });
        continue;
      }
      LogUtils.d(LOG_TAG, "Registering receiver with no mime type", new Object[0]);
    }
  }
  
  public boolean activated()
  {
    return mContext != null;
  }
  
  public void deactivate()
  {
    try
    {
      if (mContext != null)
      {
        mContext.unregisterReceiver(this);
        mContext = null;
        mMimeType = null;
      }
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException) {}
  }
  
  public boolean notificationsDisabledForAccount(Account paramAccount)
  {
    return (mContext != null) && (TextUtils.equals(mimeType, mMimeType));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!"com.android.mail.action.update_notification".equals(paramIntent.getAction())) {}
    label12:
    Object localObject;
    do
    {
      Uri localUri;
      do
      {
        do
        {
          break label12;
          do
          {
            return;
          } while (!mController.isConversationListVisible());
          localObject = mController.getCurrentListContext();
          if (localObject == null)
          {
            LogUtils.e(LOG_TAG, "unexpected null context", new Object[0]);
            return;
          }
        } while (ConversationListContext.isSearchResult((ConversationListContext)localObject));
        paramContext = account;
        localObject = folder;
        if ((paramContext == null) || (localObject == null))
        {
          LogUtils.e(LOG_TAG, "SuppressNotificationReceiver.onReceive: account=%s, folder=%s", new Object[] { paramContext, localObject });
          return;
        }
        localUri = (Uri)paramIntent.getParcelableExtra("notification_extra_account");
      } while (!uri.equals(localUri));
      paramContext = (Uri)paramIntent.getParcelableExtra("notification_extra_folder");
    } while ((!uri.equals(paramContext)) || (paramIntent.getIntExtra("notification_updated_unread_count", 0) == 0));
    LogUtils.i(LOG_TAG, "Aborting broadcast of intent %s, folder uri is %s", new Object[] { paramIntent, paramContext });
    abortBroadcast();
  }
}

/* Location:
 * Qualified Name:     com.android.mail.ui.SuppressNotificationReceiver
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */