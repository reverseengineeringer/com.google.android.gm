package com.google.android.gm;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.app.DownloadManager;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.SQLException;
import android.os.Bundle;
import com.google.android.gm.perf.Timer;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.AttachmentManager;
import com.google.android.gm.provider.Gmail;
import com.google.android.gm.provider.LogUtils;
import com.google.android.gm.provider.MailEngine;
import com.google.android.gm.provider.MailSync;
import com.google.android.gsf.GoogleLoginServiceConstants;
import java.io.IOException;
import java.util.ArrayList;

public class MailIntentService
  extends IntentService
{
  public MailIntentService()
  {
    super("MailIntentService");
  }
  
  private void handleAccountList(Account[] paramArrayOfAccount, boolean paramBoolean)
  {
    Utils.cacheGoogleAccountList(this, false, paramArrayOfAccount);
    if (!paramBoolean) {}
    for (;;)
    {
      return;
      int j = paramArrayOfAccount.length;
      int i = 0;
      while (i < j)
      {
        MailEngine.getOrMakeMailEngineSync(this, name).sendNotificationIntents(true);
        i += 1;
      }
    }
  }
  
  private void handleLocaleChanged(Intent paramIntent)
  {
    Utils.cancelAndResendNotifications(this);
  }
  
  private void handleProviderChangedIntent(Intent paramIntent)
  {
    Persistence localPersistence = Persistence.getInstance();
    String str = paramIntent.getExtras().getString("account");
    if (!localPersistence.getEnableNotifications(this, str)) {}
    while (!localPersistence.shouldNotifyForLabel(this, str, paramIntent.getExtras().getString("notificationLabel"))) {
      return;
    }
    Utils.setNewEmailIndicator(this, paramIntent);
  }
  
  private void postSendErrorNotification(Intent paramIntent)
  {
    String str1 = paramIntent.getStringExtra("account");
    String str2 = paramIntent.getStringExtra("extraMessageSubject");
    long l = paramIntent.getLongExtra("extraConversationId", -1L);
    Utils.createErrorNotification(getBaseContext(), str1, str2, l, 2131820578, 2131493335);
  }
  
  private void sendAccountsChangedNotification(boolean paramBoolean)
  {
    if (paramBoolean) {
      Timer.startTiming("MIS.sendInitialNotifications");
    }
    AccountManagerFuture localAccountManagerFuture = AccountManager.get(this).getAccountsByTypeAndFeatures("com.google", new String[] { GoogleLoginServiceConstants.featureForService("mail") }, null, null);
    try
    {
      handleAccountList((Account[])localAccountManagerFuture.getResult(), paramBoolean);
      return;
    }
    catch (OperationCanceledException localOperationCanceledException)
    {
      LogUtils.w("Gmail", localOperationCanceledException, "Unexpected exception trying to get accounts.", new Object[0]);
      return;
    }
    catch (IOException localIOException)
    {
      LogUtils.w("Gmail", localIOException, "Unexpected exception trying to get accounts.", new Object[0]);
      return;
    }
    catch (AuthenticatorException localAuthenticatorException)
    {
      LogUtils.w("Gmail", localAuthenticatorException, "Unexpected exception trying to get accounts.", new Object[0]);
      return;
    }
    finally
    {
      if (paramBoolean) {
        Timer.stopTiming("MIS.sendInitialNotifications");
      }
      stopSelf();
    }
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    try
    {
      LogUtils.v("Gmail", "Handling intent %s", new Object[] { paramIntent });
      Utils.haveGoogleMailActivitiesBeenEnabled(this);
      Object localObject1 = paramIntent.getAction();
      if (("android.intent.action.BOOT_COMPLETED".equals(localObject1)) || ("android.intent.action.DEVICE_STORAGE_OK".equals(localObject1)) || ("android.intent.action.MY_PACKAGE_REPLACED".equals(localObject1)))
      {
        sendAccountsChangedNotification(true);
        return;
      }
      if (!"android.intent.action.DOWNLOAD_COMPLETE".equals(localObject1)) {
        break label220;
      }
      localObject1 = Long.valueOf(paramIntent.getLongExtra("extra_download_id", -1L));
      localObject3 = AttachmentManager.getAccountFromDownloadId(((Long)localObject1).longValue());
      if (localObject3 == null)
      {
        ((DownloadManager)getSystemService("download")).remove(new long[] { ((Long)localObject1).longValue() });
        return;
      }
    }
    catch (SQLException localSQLException)
    {
      LogUtils.e("Gmail", localSQLException, "Error handling intent %s", new Object[] { paramIntent });
      return;
    }
    Object localObject2 = MailEngine.getOrMakeMailEngineSync(this, (String)localObject3);
    Object localObject3 = getBaseContext().getResources();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(((Resources)localObject3).getString(2131493303));
    localArrayList.add(((Resources)localObject3).getString(2131493304));
    paramIntent.putStringArrayListExtra(AttachmentManager.ATTACHMENT_FROM, localArrayList);
    ((MailEngine)localObject2).getAttachmentManager().handleDownloadManagerIntent(paramIntent);
    return;
    label220:
    if ("com.google.android.gm.intent.CLEAR_ALL_NEW_MAIL_NOTIFICATIONS".equals(localObject2))
    {
      Utils.clearAllNotfications(this);
      return;
    }
    if ("com.google.android.gm.intent.CLEAR_NEW_MAIL_NOTIFICATIONS".equals(localObject2))
    {
      Utils.clearLabelNotification(this, paramIntent.getStringExtra("account"), paramIntent.getStringExtra("label"));
      return;
    }
    if ("com.android.mail.action.update_notification".equals(localObject2))
    {
      handleProviderChangedIntent(paramIntent);
      return;
    }
    if ("android.accounts.LOGIN_ACCOUNTS_CHANGED".equals(localObject2))
    {
      Utils.enableShortcutIntentFilter(this);
      sendAccountsChangedNotification(false);
      return;
    }
    if ("android.intent.action.LOCALE_CHANGED".equals(localObject2))
    {
      handleLocaleChanged(paramIntent);
      return;
    }
    if ("com.google.android.gm.intent.VALIDATE_ACCOUNT_NOTIFICATIONS".equals(localObject2))
    {
      Utils.validateAccountNotifications(this, paramIntent.getStringExtra("account"));
      return;
    }
    if ("com.google.android.gm.intent.ACTION_POST_SEND_ERROR".equals(localObject2))
    {
      postSendErrorNotification(paramIntent);
      return;
    }
    if ("com.google.android.gm.intent.ACTION_PROVIDER_CREATED".equals(localObject2))
    {
      localObject2 = new Intent("com.android.mail.ACTION_NOTIFY_DATASET_CHANGED");
      ((Intent)localObject2).putExtra("update-all-widgets", true);
      ((Intent)localObject2).setType("application/gmail-ls");
      sendBroadcast((Intent)localObject2);
      return;
    }
    if ("com.google.android.gm.intent.ACTION_UPGRADE_SYNC_WINDOW".equals(localObject2))
    {
      localObject2 = MailEngine.getOrMakeMailEngineSync(this, paramIntent.getStringExtra("account")).getMailSync();
      long l = Gmail.getDefaultConversationAgeDays(this);
      if (((MailSync)localObject2).getConversationAgeDays() < l)
      {
        Persistence.getInstance().setUpgradeSyncWindow(this, true);
        sendBroadcast(new Intent("com.google.android.gm.intent.ACTION_DISPLAY_SYNC_WINDOW_UPGRADE"));
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.google.android.gm.MailIntentService
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */