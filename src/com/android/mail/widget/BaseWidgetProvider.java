package com.android.mail.widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.android.mail.persistence.Persistence;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.android.mail.providers.UIProvider;
import com.android.mail.ui.MailboxSelectionActivity;
import com.android.mail.utils.AccountUtils;
import com.android.mail.utils.LogTag;
import com.android.mail.utils.LogUtils;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.Set;

public abstract class BaseWidgetProvider
  extends AppWidgetProvider
{
  private static final String LOG_TAG = ;
  
  private boolean isWidgetConfigured(Context paramContext, int paramInt)
  {
    return Persistence.getPreferences(paramContext).getString("widget-account-" + paramInt, null) != null;
  }
  
  private final void migrateAllLegacyWidgetInformation(Context paramContext)
  {
    migrateLegacyWidgets(paramContext, getCurrentWidgetIds(paramContext));
  }
  
  private final void migrateLegacyWidgets(Context paramContext, int[] paramArrayOfInt)
  {
    int j = paramArrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = paramArrayOfInt[i];
      if (!isWidgetConfigured(paramContext, k)) {
        migrateLegacyWidgetInformation(paramContext, k);
      }
      i += 1;
    }
  }
  
  public static void updateWidget(Context paramContext, int paramInt, Account paramAccount, Folder paramFolder)
  {
    if ((paramAccount == null) || (paramFolder == null))
    {
      LogUtils.e(LOG_TAG, "Missing account or folder.  account: %s folder %s", new Object[] { paramAccount, paramFolder });
      return;
    }
    Intent localIntent = new Intent("com.android.mail.ACTION_UPDATE_WIDGET");
    localIntent.setType(mimeType);
    localIntent.putExtra("widgetId", paramInt);
    localIntent.putExtra("account", paramAccount.serialize());
    localIntent.putExtra("folder", Folder.toString(paramFolder));
    paramContext.sendBroadcast(localIntent);
  }
  
  protected void configureValidAccountWidget(Context paramContext, RemoteViews paramRemoteViews, int paramInt, Account paramAccount, Folder paramFolder, String paramString)
  {
    WidgetService.configureValidAccountWidget(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, paramString, WidgetService.class);
  }
  
  protected Account getAccountObject(Context paramContext, String paramString)
  {
    Object localObject2 = paramContext.getContentResolver();
    Object localObject1 = null;
    paramContext = null;
    try
    {
      localObject2 = ((ContentResolver)localObject2).query(Uri.parse(paramString), UIProvider.ACCOUNTS_PROJECTION, null, null, null);
      paramString = (String)localObject1;
      if (localObject2 != null)
      {
        paramString = (String)localObject1;
        paramContext = (Context)localObject2;
        if (((Cursor)localObject2).moveToFirst())
        {
          paramContext = (Context)localObject2;
          paramString = new Account((Cursor)localObject2);
        }
      }
      if (localObject2 != null) {
        ((Cursor)localObject2).close();
      }
      return paramString;
    }
    finally
    {
      if (paramContext != null) {
        paramContext.close();
      }
    }
  }
  
  protected int[] getCurrentWidgetIds(Context paramContext)
  {
    return AppWidgetManager.getInstance(paramContext).getAppWidgetIds(new ComponentName(paramContext, "com.android.mail.widget.WidgetProvider"));
  }
  
  protected boolean isAccountValid(Context paramContext, Account paramAccount)
  {
    if (paramAccount != null)
    {
      paramContext = AccountUtils.getSyncingAccounts(paramContext);
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramContext[i];
        if ((paramAccount != null) && (localObject != null) && (uri.equals(uri))) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  protected abstract void migrateLegacyWidgetInformation(Context paramContext, int paramInt);
  
  public void onDeleted(Context paramContext, int[] paramArrayOfInt)
  {
    super.onDeleted(paramContext, paramArrayOfInt);
    paramContext = Persistence.getPreferences(paramContext).edit();
    int i = 0;
    while (i < paramArrayOfInt.length)
    {
      paramContext.remove("widget-account-" + paramArrayOfInt[i]);
      i += 1;
    }
    paramContext.apply();
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    migrateAllLegacyWidgetInformation(paramContext);
    super.onReceive(paramContext, paramIntent);
    LogUtils.d(LOG_TAG, "BaseWidgetProvider.onReceive: %s", new Object[] { paramIntent });
    Object localObject1 = paramIntent.getAction();
    int i;
    if ("com.android.mail.ACTION_UPDATE_WIDGET".equals(localObject1))
    {
      i = paramIntent.getIntExtra("widgetId", -1);
      localObject1 = Account.newinstance(paramIntent.getStringExtra("account"));
      paramIntent = Folder.fromString(paramIntent.getStringExtra("folder"));
      if ((i != -1) && (localObject1 != null) && (paramIntent != null)) {
        updateWidgetInternal(paramContext, i, (Account)localObject1, paramIntent);
      }
    }
    Object localObject2;
    label300:
    do
    {
      boolean bool3;
      do
      {
        do
        {
          return;
        } while (!"com.android.mail.ACTION_NOTIFY_DATASET_CHANGED".equals(localObject1));
        localObject2 = paramIntent.getExtras();
        paramIntent = (Uri)((Bundle)localObject2).getParcelable("accountUri");
        localObject1 = (Uri)((Bundle)localObject2).getParcelable("folderUri");
        bool3 = ((Bundle)localObject2).getBoolean("update-all-widgets", false);
      } while ((paramIntent == null) && (localObject1 == null) && (!bool3));
      localObject2 = Sets.newHashSet();
      int[] arrayOfInt = getCurrentWidgetIds(paramContext);
      int j = arrayOfInt.length;
      i = 0;
      if (i < j)
      {
        int k = arrayOfInt[i];
        Object localObject3 = Persistence.getPreferences(paramContext).getString("widget-account-" + k, null);
        boolean bool2;
        boolean bool1;
        if (localObject3 != null)
        {
          localObject3 = TextUtils.split((String)localObject3, " ");
          bool2 = bool3;
          bool1 = bool2;
          if (!bool2)
          {
            if ((paramIntent == null) || (!TextUtils.equals(paramIntent.toString(), localObject3[0]))) {
              break label300;
            }
            bool1 = true;
          }
        }
        for (;;)
        {
          if (bool1) {
            ((Set)localObject2).add(Integer.valueOf(k));
          }
          i += 1;
          break;
          bool1 = bool2;
          if (localObject1 != null)
          {
            bool1 = bool2;
            if (TextUtils.equals(((Uri)localObject1).toString(), localObject3[1])) {
              bool1 = true;
            }
          }
        }
      }
    } while (((Set)localObject2).size() <= 0);
    paramIntent = Ints.toArray((Collection)localObject2);
    AppWidgetManager.getInstance(paramContext).notifyAppWidgetViewDataChanged(paramIntent, 2131755275);
  }
  
  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    migrateLegacyWidgets(paramContext, paramArrayOfInt);
    super.onUpdate(paramContext, paramAppWidgetManager, paramArrayOfInt);
    ContentResolver localContentResolver = paramContext.getContentResolver();
    int i = 0;
    Object localObject1;
    if (i < paramArrayOfInt.length)
    {
      Object localObject2 = Persistence.getPreferences(paramContext).getString("widget-account-" + paramArrayOfInt[i], null);
      localObject1 = null;
      paramAppWidgetManager = null;
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        paramAppWidgetManager = TextUtils.split((String)localObject2, " ");
        if (paramAppWidgetManager.length != 2) {
          break label232;
        }
        localObject1 = paramAppWidgetManager[0];
      }
      for (paramAppWidgetManager = paramAppWidgetManager[1];; paramAppWidgetManager = null)
      {
        localObject2 = null;
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = getAccountObject(paramContext, (String)localObject1);
        }
        localObject1 = null;
        Object localObject3 = null;
        if (!TextUtils.isEmpty(paramAppWidgetManager)) {
          localObject1 = null;
        }
        try
        {
          Cursor localCursor = localContentResolver.query(Uri.parse(paramAppWidgetManager), UIProvider.FOLDERS_PROJECTION, null, null, null);
          paramAppWidgetManager = (AppWidgetManager)localObject3;
          if (localCursor != null)
          {
            paramAppWidgetManager = (AppWidgetManager)localObject3;
            localObject1 = localCursor;
            if (localCursor.moveToFirst())
            {
              localObject1 = localCursor;
              paramAppWidgetManager = new Folder(localCursor);
            }
          }
          localObject1 = paramAppWidgetManager;
          if (localCursor != null)
          {
            localCursor.close();
            localObject1 = paramAppWidgetManager;
          }
          updateWidgetInternal(paramContext, paramArrayOfInt[i], (Account)localObject2, (Folder)localObject1);
          i += 1;
          break;
        }
        finally
        {
          label232:
          if (localObject1 == null) {
            break label254;
          }
          ((Cursor)localObject1).close();
        }
        localObject1 = localObject2;
      }
    }
    label254:
  }
  
  protected void updateWidgetInternal(Context paramContext, int paramInt, Account paramAccount, Folder paramFolder)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968698);
    if (!isAccountValid(paramContext, paramAccount))
    {
      localRemoteViews.setViewVisibility(2131755271, 8);
      localRemoteViews.setViewVisibility(2131755272, 8);
      localRemoteViews.setViewVisibility(2131755273, 8);
      localRemoteViews.setViewVisibility(2131755274, 8);
      localRemoteViews.setViewVisibility(2131755275, 8);
      localRemoteViews.setViewVisibility(2131755277, 8);
      localRemoteViews.setViewVisibility(2131755276, 0);
      paramAccount = new Intent(paramContext, MailboxSelectionActivity.class);
      paramAccount.putExtra("appWidgetId", paramInt);
      paramAccount.setData(Uri.parse(paramAccount.toUri(1)));
      paramAccount.setFlags(1073741824);
      localRemoteViews.setOnClickPendingIntent(2131755276, PendingIntent.getActivity(paramContext, 0, paramAccount, 134217728));
    }
    for (;;)
    {
      AppWidgetManager.getInstance(paramContext).updateAppWidget(paramInt, localRemoteViews);
      return;
      configureValidAccountWidget(paramContext, localRemoteViews, paramInt, paramAccount, paramFolder, " ");
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.BaseWidgetProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */