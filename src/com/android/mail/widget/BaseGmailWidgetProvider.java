package com.android.mail.widget;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.android.mail.providers.Account;
import com.android.mail.providers.Folder;
import com.google.android.gm.Utils;
import com.google.android.gm.persistence.Persistence;
import com.google.android.gm.provider.UiProvider;
import com.google.common.primitives.Ints;

public class BaseGmailWidgetProvider
  extends BaseWidgetProvider
{
  protected void configureValidAccountWidget(Context paramContext, RemoteViews paramRemoteViews, int paramInt, Account paramAccount, Folder paramFolder, String paramString)
  {
    GmailWidgetService.configureValidAccountWidget(paramContext, paramRemoteViews, paramInt, paramAccount, paramFolder, name, GmailWidgetService.class);
  }
  
  protected int[] getCurrentWidgetIds(Context paramContext)
  {
    AppWidgetManager localAppWidgetManager = AppWidgetManager.getInstance(paramContext);
    ComponentName localComponentName = new ComponentName(paramContext, "com.google.android.gm.widget.GmailWidgetProvider");
    paramContext = new ComponentName(paramContext, "com.google.android.gm.widget.GoogleMailWidgetProvider");
    return Ints.concat(new int[][] { localAppWidgetManager.getAppWidgetIds(localComponentName), localAppWidgetManager.getAppWidgetIds(paramContext) });
  }
  
  protected boolean isAccountValid(Context paramContext, Account paramAccount)
  {
    return Utils.isAccountValid(paramContext, paramAccount);
  }
  
  protected void migrateLegacyWidgetInformation(Context paramContext, int paramInt)
  {
    Object localObject1 = Persistence.getPreferences(paramContext);
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    String str = "widget-account-" + paramInt;
    localObject1 = ((SharedPreferences)localObject1).getString(str, null);
    if (localObject1 != null)
    {
      localObject2 = TextUtils.split((String)localObject1, " ");
      if (localObject2.length != 2) {
        break label134;
      }
      localObject1 = localObject2[0];
    }
    label134:
    for (Object localObject2 = localObject2[1];; localObject2 = Persistence.getAccountInbox(paramContext, (String)localObject1))
    {
      Account localAccount = UiProvider.getAccountObject(paramContext, (String)localObject1);
      localObject1 = UiProvider.getSparseFolderObject(paramContext, null, (String)localObject1, (String)localObject2);
      if ((localAccount != null) && (localObject1 != null))
      {
        WidgetService.saveWidgetInformation(paramContext, paramInt, localAccount, (Folder)localObject1);
        updateWidgetInternal(paramContext, paramInt, localAccount, (Folder)localObject1);
        localEditor.remove(str);
      }
      localEditor.apply();
      return;
    }
  }
  
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
  
  protected void updateWidgetInternal(Context paramContext, int paramInt, Account paramAccount, Folder paramFolder)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), 2130968698);
    if (!isAccountValid(paramContext, paramAccount)) {
      super.updateWidgetInternal(paramContext, paramInt, paramAccount, paramFolder);
    }
    for (;;)
    {
      AppWidgetManager.getInstance(paramContext).updateAppWidget(paramInt, localRemoteViews);
      return;
      configureValidAccountWidget(paramContext, localRemoteViews, paramInt, paramAccount, paramFolder, name);
    }
  }
}

/* Location:
 * Qualified Name:     com.android.mail.widget.BaseGmailWidgetProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */